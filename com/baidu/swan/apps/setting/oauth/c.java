package com.baidu.swan.apps.setting.oauth;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.sapi2.utils.SapiGIDEvent;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.cookie.CookieJarImpl;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.widget.dialog.e;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c {
    public static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private static final Map<String, a> aRe = new HashMap();
    private static OkHttpClient aRf;

    public static Context getAppContext() {
        return AppRuntime.getAppContext();
    }

    public static RequestBody n(Map<String, String> map) {
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
            if (DEBUG) {
                a("query :: " + key + " = " + value, (Boolean) false);
            }
            builder.add(key, value);
        }
        return builder.build();
    }

    public static void a(String str, Boolean bool) {
        if (DEBUG) {
            a("aiapps-oauth", str, bool);
        }
    }

    public static void a(final String str, final String str2, Boolean bool) {
        if (DEBUG) {
            com.baidu.swan.apps.console.c.i(str, str2);
            if (bool.booleanValue()) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(c.getAppContext(), str + " :: " + str2, 0).show();
                    }
                });
            }
        }
    }

    public static OkHttpClient EZ() {
        if (aRf != null) {
            return aRf;
        }
        OkHttpClient build = com.baidu.swan.apps.ae.e.Jo().aNY.get().uP().uV().newBuilder().cookieJar(new CookieJarImpl(com.baidu.swan.apps.u.a.CV().Dt())).addNetworkInterceptor(new com.baidu.swan.apps.network.a.c()).build();
        aRf = build;
        return build;
    }

    public static String getKeyHash() {
        try {
            PackageInfo packageInfo = getAppContext().getPackageManager().getPackageInfo(getAppContext().getPackageName(), 64);
            if (packageInfo != null && packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                return com.baidu.swan.c.c.toMd5(packageInfo.signatures[0].toByteArray(), false);
            }
            return "";
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void a(final Context context, com.baidu.swan.apps.ae.b bVar, final e eVar, com.baidu.swan.apps.setting.oauth.a aVar) {
        if (eVar == null || TextUtils.isEmpty(eVar.id)) {
            aVar.bt(false);
            return;
        }
        synchronized (aRe) {
            a aVar2 = aRe.get(eVar.id);
            if (aVar2 != null) {
                aVar2.aRj.add(aVar);
            } else {
                a aVar3 = new a(eVar.id);
                aVar3.aRj.add(aVar);
                aRe.put(eVar.id, aVar3);
                DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.setting.oauth.c.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i) {
                            case -2:
                                c.a("onNegBtn", (Boolean) false);
                                com.baidu.swan.apps.statistic.c.i("click", e.this.id, false);
                                c.u(e.this.id, false);
                                return;
                            case -1:
                                c.a("onPosBtn", (Boolean) false);
                                com.baidu.swan.apps.statistic.c.i("click", e.this.id, true);
                                c.u(e.this.id, true);
                                return;
                            default:
                                return;
                        }
                    }
                };
                View.OnClickListener onClickListener2 = TextUtils.isEmpty(eVar.description) ? null : new View.OnClickListener() { // from class: com.baidu.swan.apps.setting.oauth.c.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.a(context, eVar);
                    }
                };
                com.baidu.swan.apps.statistic.c.i(SmsLoginView.StatEvent.LOGIN_SHOW, eVar.id, false);
                if ("mobile".equals(eVar.id)) {
                    b(context, bVar, eVar, onClickListener, onClickListener2);
                } else {
                    a(context, bVar, eVar, onClickListener, onClickListener2);
                }
            }
        }
    }

    @Nullable
    public static String getErrMessage(int i) {
        switch (i) {
            case 10001:
                return "internal_error";
            case 10002:
                return "network_error";
            case 10003:
                return "user deny";
            case SapiGIDEvent.BUSINESS_GET_GID /* 10004 */:
                return "user not login";
            case SapiGIDEvent.BUSINESS_LOGOUT /* 10005 */:
                return "system deny";
            case SapiGIDEvent.SYSTEM_SCREEN_ON /* 10006 */:
                return "not found";
            case 10007:
                return "request_timeout";
            case 10008:
                return "app not installed";
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void u(String str, boolean z) {
        a remove;
        synchronized (aRe) {
            remove = aRe.remove(str);
        }
        if (remove != null && !remove.aRj.isEmpty()) {
            for (com.baidu.swan.apps.setting.oauth.a aVar : remove.aRj) {
                if (aVar != null) {
                    aVar.bt(z);
                }
            }
        }
    }

    private static void a(Context context, com.baidu.swan.apps.ae.b bVar, e eVar, DialogInterface.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        Resources resources = context.getResources();
        View inflate = View.inflate(context, b.g.aiapps_auth_dialog_content_common, null);
        TextView textView = (TextView) inflate.findViewById(b.f.label);
        textView.setText(context.getString(b.h.aiapps_auth_dialog_label_common, bVar.getName()));
        textView.setTextColor(resources.getColor(b.c.aiapps_auth_dialog_label));
        if (onClickListener2 != null) {
            View findViewById = inflate.findViewById(b.f.desc);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(onClickListener2);
        }
        inflate.findViewById(b.f.auth_divider).setBackgroundColor(resources.getColor(b.c.aiapps_auth_dialog_divider));
        ((SwanAppRoundedImageView) inflate.findViewById(b.f.icon)).setImageDrawable(new BitmapDrawable(resources, aa.a(bVar.uB(), "OAuthUtils", false)));
        TextView textView2 = (TextView) inflate.findViewById(b.f.scopes);
        textView2.setTextColor(resources.getColor(b.c.aiapps_auth_dialog_scopes));
        textView2.setText(context.getString(b.h.aiapps_auth_dialog_scope_entity, eVar.name));
        new e.a(context).d(context.getString(b.h.aiapps_auth_dialog_title, getAppName(context))).ad(inflate).c(context.getText(b.h.aiapps_auth_dialog_btn_pos), onClickListener).d(context.getText(b.h.aiapps_auth_dialog_btn_neg), onClickListener).dm(b.c.aiapps_auth_dialog_btn_pos).bR(false).a(new com.baidu.swan.apps.view.b.a()).Iu();
    }

    private static void b(Context context, com.baidu.swan.apps.ae.b bVar, e eVar, DialogInterface.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        Resources resources = context.getResources();
        View inflate = View.inflate(context, b.g.aiapps_auth_dialog_content_mobile, null);
        TextView textView = (TextView) inflate.findViewById(b.f.label);
        textView.setText(context.getString(b.h.aiapps_auth_dialog_label_mobile, bVar.getName(), getAppName(context)));
        textView.setTextColor(resources.getColor(b.c.aiapps_auth_dialog_label));
        TextView textView2 = (TextView) inflate.findViewById(b.f.name);
        textView2.setText(eVar.name);
        textView2.setTextColor(resources.getColor(b.c.aiapps_auth_dialog_label));
        if (onClickListener2 != null) {
            View findViewById = inflate.findViewById(b.f.desc);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(onClickListener2);
        }
        inflate.findViewById(b.f.auth_divider).setBackgroundColor(resources.getColor(b.c.aiapps_auth_dialog_divider));
        ((SwanAppRoundedImageView) inflate.findViewById(b.f.icon)).setImageDrawable(new BitmapDrawable(resources, aa.a(bVar.uB(), "OAuthUtils", false)));
        TextView textView3 = (TextView) inflate.findViewById(b.f.ext);
        textView3.setTextColor(resources.getColor(b.c.aiapps_auth_dialog_label));
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = eVar.aRn.iterator();
        while (it.hasNext()) {
            sb.append(context.getString(b.h.aiapps_auth_dialog_scope_entity, it.next()));
            sb.append("\n");
        }
        textView3.setText(sb.toString());
        new e.a(context).d(context.getString(b.h.aiapps_auth_dialog_title, getAppName(context))).ad(inflate).c(context.getText(b.h.aiapps_auth_dialog_btn_pos), onClickListener).d(context.getText(b.h.aiapps_auth_dialog_btn_neg), onClickListener).dm(b.c.aiapps_auth_dialog_btn_pos).bR(false).a(new com.baidu.swan.apps.view.b.a()).Iu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Context context, e eVar) {
        new e.a(context).d(context.getString(b.h.aiapps_auth_dialog_title, getAppName(context))).gd(eVar.description).b(b.h.aiapps_auth_scope_desc_dialog_btn_pos, null).a(new com.baidu.swan.apps.view.b.a()).Iu();
    }

    @Deprecated
    public static void g(Runnable runnable) {
        aa.j(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        final Set<com.baidu.swan.apps.setting.oauth.a> aRj = new HashSet();
        final String scope;

        a(String str) {
            this.scope = str;
        }
    }

    public static JSONObject ae(JSONObject jSONObject) {
        String vE = com.baidu.swan.apps.u.a.CK().vE();
        return (jSONObject == null || TextUtils.isEmpty(vE)) ? jSONObject : jSONObject.optJSONObject(vE);
    }

    public static String getAppName(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo;
            int i = applicationInfo.labelRes;
            return i == 0 ? applicationInfo.nonLocalizedLabel.toString() : context.getString(i);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
