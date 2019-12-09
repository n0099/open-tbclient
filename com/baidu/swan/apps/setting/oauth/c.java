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
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.cookie.CookieJarImpl;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.statistic.a;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Map<String, a> bnR = new HashMap();
    private static OkHttpClient bnS;

    public static Context getAppContext() {
        return AppRuntime.getAppContext();
    }

    public static RequestBody o(Map<String, String> map) {
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
            b("aiapps-oauth", str, bool);
        }
    }

    public static void b(final String str, final String str2, Boolean bool) {
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

    public static OkHttpClient MM() {
        if (bnS != null) {
            return bnS;
        }
        OkHttpClient build = com.baidu.swan.apps.ae.e.Rt().bka.get().AY().BB().newBuilder().cookieJar(new CookieJarImpl(com.baidu.swan.apps.u.a.JG().Ke())).addNetworkInterceptor(new com.baidu.swan.apps.network.a.c()).build();
        bnS = build;
        return build;
    }

    public static String getKeyHash() {
        try {
            PackageInfo packageInfo = getAppContext().getPackageManager().getPackageInfo(getAppContext().getPackageName(), 64);
            if (packageInfo != null && packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                return com.baidu.swan.c.b.toMd5(packageInfo.signatures[0].toByteArray(), false);
            }
            return "";
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void a(final Context context, com.baidu.swan.apps.ae.b bVar, final e eVar, com.baidu.swan.apps.setting.oauth.a aVar) {
        if (eVar == null || TextUtils.isEmpty(eVar.id)) {
            aVar.onResult(false);
            return;
        }
        synchronized (bnR) {
            a aVar2 = bnR.get(eVar.id);
            if (aVar2 != null) {
                aVar2.bnW.add(aVar);
            } else {
                a aVar3 = new a(eVar.id);
                aVar3.bnW.add(aVar);
                bnR.put(eVar.id, aVar3);
                DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.setting.oauth.c.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i) {
                            case -2:
                                c.a("onNegBtn", (Boolean) false);
                                com.baidu.swan.apps.statistic.e.m("click", e.this.id, false);
                                c.y(e.this.id, false);
                                return;
                            case -1:
                                c.a("onPosBtn", (Boolean) false);
                                com.baidu.swan.apps.statistic.e.m("click", e.this.id, true);
                                c.y(e.this.id, true);
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
                com.baidu.swan.apps.statistic.e.m("show", eVar.id, false);
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
            case 10004:
                return "user not login";
            case 10005:
                return "system deny";
            case 10006:
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
    public static void y(String str, boolean z) {
        a remove;
        synchronized (bnR) {
            remove = bnR.remove(str);
        }
        if (remove != null && !remove.bnW.isEmpty()) {
            for (com.baidu.swan.apps.setting.oauth.a aVar : remove.bnW) {
                if (aVar != null) {
                    aVar.onResult(z);
                }
            }
        }
    }

    private static void a(Context context, com.baidu.swan.apps.ae.b bVar, e eVar, DialogInterface.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        Resources resources = context.getResources();
        View inflate = View.inflate(context, a.g.aiapps_auth_dialog_content_common, null);
        TextView textView = (TextView) inflate.findViewById(a.f.label);
        textView.setText(context.getString(a.h.aiapps_auth_dialog_label_common, bVar.getName()));
        textView.setTextColor(resources.getColor(a.c.aiapps_auth_dialog_label));
        if (onClickListener2 != null) {
            View findViewById = inflate.findViewById(a.f.desc);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(onClickListener2);
        }
        inflate.findViewById(a.f.auth_divider).setBackgroundColor(resources.getColor(a.c.aiapps_auth_dialog_divider));
        ((SwanAppRoundedImageView) inflate.findViewById(a.f.icon)).setImageDrawable(new BitmapDrawable(resources, ac.a(bVar.AK(), "OAuthUtils", false)));
        TextView textView2 = (TextView) inflate.findViewById(a.f.scopes);
        textView2.setTextColor(resources.getColor(a.c.aiapps_auth_dialog_scopes));
        textView2.setText(context.getString(a.h.aiapps_auth_dialog_scope_entity, eVar.name));
        new g.a(context).d(context.getString(a.h.aiapps_auth_dialog_title, getAppName(context))).al(inflate).c(context.getText(a.h.aiapps_auth_dialog_btn_pos), onClickListener).d(context.getText(a.h.aiapps_auth_dialog_btn_neg), onClickListener).er(a.c.aiapps_auth_dialog_btn_pos).cv(false).a(new com.baidu.swan.apps.view.b.a()).Qv();
    }

    private static void b(Context context, com.baidu.swan.apps.ae.b bVar, e eVar, DialogInterface.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        Resources resources = context.getResources();
        View inflate = View.inflate(context, a.g.aiapps_auth_dialog_content_mobile, null);
        TextView textView = (TextView) inflate.findViewById(a.f.label);
        textView.setText(context.getString(a.h.aiapps_auth_dialog_label_mobile, bVar.getName(), getAppName(context)));
        textView.setTextColor(resources.getColor(a.c.aiapps_auth_dialog_label));
        TextView textView2 = (TextView) inflate.findViewById(a.f.name);
        textView2.setText(eVar.name);
        textView2.setTextColor(resources.getColor(a.c.aiapps_auth_dialog_label));
        if (onClickListener2 != null) {
            View findViewById = inflate.findViewById(a.f.desc);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(onClickListener2);
        }
        inflate.findViewById(a.f.auth_divider).setBackgroundColor(resources.getColor(a.c.aiapps_auth_dialog_divider));
        ((SwanAppRoundedImageView) inflate.findViewById(a.f.icon)).setImageDrawable(new BitmapDrawable(resources, ac.a(bVar.AK(), "OAuthUtils", false)));
        TextView textView3 = (TextView) inflate.findViewById(a.f.ext);
        textView3.setTextColor(resources.getColor(a.c.aiapps_auth_dialog_label));
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = eVar.bob.iterator();
        while (it.hasNext()) {
            sb.append(context.getString(a.h.aiapps_auth_dialog_scope_entity, it.next()));
            sb.append("\n");
        }
        textView3.setText(sb.toString());
        new g.a(context).d(context.getString(a.h.aiapps_auth_dialog_title, getAppName(context))).al(inflate).c(context.getText(a.h.aiapps_auth_dialog_btn_pos), onClickListener).d(context.getText(a.h.aiapps_auth_dialog_btn_neg), onClickListener).er(a.c.aiapps_auth_dialog_btn_pos).cv(false).a(new com.baidu.swan.apps.view.b.a()).Qv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Context context, e eVar) {
        new g.a(context).d(context.getString(a.h.aiapps_auth_dialog_title, getAppName(context))).hi(eVar.description).b(a.h.aiapps_auth_scope_desc_dialog_btn_pos, null).a(new com.baidu.swan.apps.view.b.a()).Qv();
    }

    @Deprecated
    public static void e(Runnable runnable) {
        ac.i(runnable);
    }

    public static synchronized void aH(@NonNull String str, @NonNull String str2) {
        synchronized (c.class) {
            int i = com.baidu.swan.apps.storage.b.f.ST().getInt("login_error_report_count", 0);
            if (i < 20) {
                e(10004, str, str2);
                com.baidu.swan.apps.storage.b.f.ST().putInt("login_error_report_count", i + 1);
            }
        }
    }

    public static synchronized void aD(@NonNull JSONObject jSONObject) throws JSONException {
        synchronized (c.class) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && optJSONObject.has("code")) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", 1);
                jSONObject.put("data", jSONObject2);
            }
        }
    }

    private static void e(int i, @NonNull String str, @NonNull String str2) {
        String str3;
        try {
            String Rm = com.baidu.swan.apps.ae.b.Rm();
            String str4 = TextUtils.isEmpty(Rm) ? "NotSwanAppProcess" : Rm;
            String str5 = str + "===";
            if (str2.length() > 1024) {
                str3 = (str5 + str2.substring(0, 1024)) + StringHelper.STRING_MORE;
            } else {
                str3 = str5 + str2;
            }
            new a.C0219a(i).hU(str4).hV(str3).La();
            if (DEBUG) {
                Log.d("OAuthUtils", "error reported: " + i + " ,content: " + str3);
            }
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("OAuthUtils", "error report error: " + i);
                e.printStackTrace();
            }
            new a.C0219a(i).hV("ReportError" + e.getMessage()).La();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        final Set<com.baidu.swan.apps.setting.oauth.a> bnW = new HashSet();
        final String scope;

        a(String str) {
            this.scope = str;
        }
    }

    public static JSONObject aE(JSONObject jSONObject) {
        String BS = com.baidu.swan.apps.u.a.Jv().BS();
        return (jSONObject == null || TextUtils.isEmpty(BS)) ? jSONObject : jSONObject.optJSONObject(BS);
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
