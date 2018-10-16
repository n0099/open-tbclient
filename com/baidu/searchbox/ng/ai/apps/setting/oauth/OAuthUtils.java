package com.baidu.searchbox.ng.ai.apps.setting.oauth;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.TextView;
import com.baidu.ar.util.IoUtils;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AiAppAlertDialog;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.util.AiAppMD5Utils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
import com.baidu.searchbox.ng.ai.apps.view.AiAppsRoundedImageView;
import com.baidu.searchbox.ng.ai.apps.view.decorate.AiAppsDialogDecorate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
/* loaded from: classes2.dex */
public final class OAuthUtils implements OAuthDef {
    public static final boolean DEBUG = false;
    private static final Map<String, DialogSession> sDialogSessions = new HashMap();
    private static OkHttpClient sHttpClient;

    private OAuthUtils() {
    }

    public static Context getAppContext() {
        return AppRuntime.getAppContext();
    }

    public static RequestBody buildBody(Map<String, String> map) {
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (TextUtils.isEmpty(key)) {
                key = "";
            }
            if (TextUtils.isEmpty(value)) {
                value = "";
            }
            builder.add(key, value);
        }
        return builder.build();
    }

    public static void log(String str, Boolean bool) {
    }

    public static void log(String str, String str2, Boolean bool) {
    }

    public static String encrypt(String str, String str2, String str3) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(1, new SecretKeySpec(str2.getBytes(IoUtils.UTF_8), SapiEnv.SHARE_ALGORITHM), new IvParameterSpec(str3.getBytes(IoUtils.UTF_8)));
            return Base64.encodeToString(cipher.doFinal(padBytes(str.getBytes(IoUtils.UTF_8))), 2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static byte[] padBytes(byte[] bArr) {
        return Arrays.copyOf(bArr, (16 - (bArr.length % 16)) + bArr.length);
    }

    public static OkHttpClient getHttpClient() {
        if (sHttpClient != null) {
            return sHttpClient;
        }
        OkHttpClient build = new OkHttpClient.Builder().cookieJar(new CookieJar() { // from class: com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthUtils.2
            @Override // okhttp3.CookieJar
            public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
            }

            @Override // okhttp3.CookieJar
            public List<Cookie> loadForRequest(HttpUrl httpUrl) {
                ArrayList arrayList = new ArrayList();
                String bduss = AiAppsRuntime.getAiAppAccountRuntime().getBduss(OAuthUtils.getAppContext());
                if (!TextUtils.isEmpty(bduss)) {
                    arrayList.add(new Cookie.Builder().name("BDUSS").domain(httpUrl.host()).value(bduss).build());
                }
                return arrayList;
            }
        }).build();
        sHttpClient = build;
        return build;
    }

    public static String getKeyHash() {
        try {
            Signature[] signatureArr = getAppContext().getPackageManager().getPackageInfo(getAppContext().getPackageName(), 64).signatures;
            if (0 < signatureArr.length) {
                return AiAppMD5Utils.toMd5(signatureArr[0].toByteArray(), false);
            }
            return "";
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void showAuthDialog(final Context context, AiApp aiApp, final ScopeInfo scopeInfo, AuthorizeListener authorizeListener) {
        if (scopeInfo == null || TextUtils.isEmpty(scopeInfo.id)) {
            authorizeListener.onResult(false);
            return;
        }
        synchronized (sDialogSessions) {
            DialogSession dialogSession = sDialogSessions.get(scopeInfo.id);
            if (dialogSession != null) {
                dialogSession.listeners.add(authorizeListener);
            } else {
                DialogSession dialogSession2 = new DialogSession(scopeInfo.id);
                dialogSession2.listeners.add(authorizeListener);
                sDialogSessions.put(scopeInfo.id, dialogSession2);
                DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthUtils.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i) {
                            case -2:
                                OAuthUtils.log("onNegBtn", false);
                                OAuthUtils.finishDialogSession(ScopeInfo.this.id, false);
                                return;
                            case -1:
                                OAuthUtils.log("onPosBtn", false);
                                OAuthUtils.finishDialogSession(ScopeInfo.this.id, true);
                                return;
                            default:
                                return;
                        }
                    }
                };
                View.OnClickListener onClickListener2 = TextUtils.isEmpty(scopeInfo.description) ? null : new View.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthUtils.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        OAuthUtils.showScopeDescDialog(context, scopeInfo);
                    }
                };
                if (ScopeInfo.SCOPE_ID_MOBILE.equals(scopeInfo.id)) {
                    showMobileAuthDialog(context, aiApp, scopeInfo, onClickListener, onClickListener2);
                } else {
                    showCommonAuthDialog(context, aiApp, scopeInfo, onClickListener, onClickListener2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void finishDialogSession(String str, boolean z) {
        DialogSession remove;
        synchronized (sDialogSessions) {
            remove = sDialogSessions.remove(str);
        }
        if (remove != null && !remove.listeners.isEmpty()) {
            for (AuthorizeListener authorizeListener : remove.listeners) {
                if (authorizeListener != null) {
                    authorizeListener.onResult(z);
                }
            }
        }
    }

    private static void showCommonAuthDialog(Context context, AiApp aiApp, ScopeInfo scopeInfo, DialogInterface.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        Resources resources = context.getResources();
        View inflate = View.inflate(context, R.layout.aiapps_auth_dialog_content_common, null);
        TextView textView = (TextView) inflate.findViewById(R.id.label);
        textView.setText(context.getString(R.string.aiapps_auth_dialog_label_common, aiApp.getName()));
        textView.setTextColor(resources.getColor(R.color.aiapps_auth_dialog_label));
        if (onClickListener2 != null) {
            View findViewById = inflate.findViewById(R.id.desc);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(onClickListener2);
        }
        inflate.findViewById(R.id.auth_divider).setBackgroundColor(resources.getColor(R.color.aiapps_auth_dialog_divider));
        ((AiAppsRoundedImageView) inflate.findViewById(R.id.icon)).setImageDrawable(aiApp.getIcon());
        TextView textView2 = (TextView) inflate.findViewById(R.id.scopes);
        textView2.setTextColor(resources.getColor(R.color.aiapps_auth_dialog_scopes));
        textView2.setText(context.getString(R.string.aiapps_auth_dialog_scope_entity, scopeInfo.name));
        new AiAppAlertDialog.Builder(context).setTitle(context.getText(R.string.aiapps_auth_dialog_title)).setView(inflate).setPositiveButton(context.getText(R.string.aiapps_auth_dialog_btn_pos), onClickListener).setNegativeButton(context.getText(R.string.aiapps_auth_dialog_btn_neg), onClickListener).setPositiveTextColor(R.color.aiapps_auth_dialog_btn_pos).setCancelable(false).setDecorate(new AiAppsDialogDecorate()).show();
    }

    private static void showMobileAuthDialog(Context context, AiApp aiApp, ScopeInfo scopeInfo, DialogInterface.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        Resources resources = context.getResources();
        View inflate = View.inflate(context, R.layout.aiapps_auth_dialog_content_mobile, null);
        TextView textView = (TextView) inflate.findViewById(R.id.label);
        textView.setText(context.getString(R.string.aiapps_auth_dialog_label_mobile, aiApp.getName()));
        textView.setTextColor(resources.getColor(R.color.aiapps_auth_dialog_label));
        TextView textView2 = (TextView) inflate.findViewById(R.id.name);
        textView2.setText(scopeInfo.name);
        textView2.setTextColor(resources.getColor(R.color.aiapps_auth_dialog_label));
        if (onClickListener2 != null) {
            View findViewById = inflate.findViewById(R.id.desc);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(onClickListener2);
        }
        inflate.findViewById(R.id.auth_divider).setBackgroundColor(resources.getColor(R.color.aiapps_auth_dialog_divider));
        ((AiAppsRoundedImageView) inflate.findViewById(R.id.icon)).setImageDrawable(aiApp.getIcon());
        TextView textView3 = (TextView) inflate.findViewById(R.id.ext);
        textView3.setTextColor(resources.getColor(R.color.aiapps_auth_dialog_label));
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = scopeInfo.ext.iterator();
        while (it.hasNext()) {
            sb.append(context.getString(R.string.aiapps_auth_dialog_scope_entity, it.next()));
            sb.append("\n");
        }
        textView3.setText(sb.toString());
        new AiAppAlertDialog.Builder(context).setTitle(context.getText(R.string.aiapps_auth_dialog_title)).setView(inflate).setPositiveButton(context.getText(R.string.aiapps_auth_dialog_btn_pos), onClickListener).setNegativeButton(context.getText(R.string.aiapps_auth_dialog_btn_neg), onClickListener).setPositiveTextColor(R.color.aiapps_auth_dialog_btn_pos).setCancelable(false).setDecorate(new AiAppsDialogDecorate()).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showScopeDescDialog(Context context, ScopeInfo scopeInfo) {
        new AiAppAlertDialog.Builder(context).setTitle(context.getText(R.string.aiapps_auth_dialog_title)).setMessage(scopeInfo.description).setPositiveButton(R.string.aiapps_auth_scope_desc_dialog_btn_pos, (DialogInterface.OnClickListener) null).setDecorate(new AiAppsDialogDecorate()).show();
    }

    @Deprecated
    public static void postToMain(Runnable runnable) {
        AiAppsUtils.postOnUi(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class DialogSession {
        final Set<AuthorizeListener> listeners = new HashSet();
        final String scope;

        DialogSession(String str) {
            this.scope = str;
        }
    }
}
