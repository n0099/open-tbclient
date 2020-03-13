package com.baidu.swan.apps.setting.oauth;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.cookie.CookieJarImpl;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.setting.oauth.a.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class c {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Map<String, a> bTg = new HashMap();
    private static OkHttpClient bTh;

    public static boolean aO(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return TextUtils.equals(jSONObject.optString("invokeFrom"), "component");
    }

    public static Context getAppContext() {
        return AppRuntime.getAppContext();
    }

    public static RequestBody p(Map<String, String> map) {
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
                c("query :: " + key + " = " + value, false);
            }
            builder.add(key, value);
        }
        return builder.build();
    }

    public static void c(String str, Boolean bool) {
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

    public static OkHttpClient YW() {
        if (bTh != null) {
            return bTh;
        }
        OkHttpClient build = com.baidu.swan.apps.runtime.d.acC().acE().GV().HU().newBuilder().cookieJar(new CookieJarImpl(com.baidu.swan.apps.w.a.Uu().Iu())).addNetworkInterceptor(new com.baidu.swan.apps.network.a.c()).build();
        bTh = build;
        return build;
    }

    public static String getKeyHash() {
        try {
            PackageInfo packageInfo = getAppContext().getPackageManager().getPackageInfo(getAppContext().getPackageName(), 64);
            if (packageInfo != null && packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                return com.baidu.swan.d.d.toMd5(packageInfo.signatures[0].toByteArray(), false);
            }
            return "";
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void a(Context context, com.baidu.swan.apps.runtime.e eVar, final e eVar2, JSONObject jSONObject, com.baidu.swan.apps.setting.oauth.a aVar) {
        if (eVar2 == null || TextUtils.isEmpty(eVar2.id)) {
            aVar.onResult(false);
            return;
        }
        synchronized (bTg) {
            a aVar2 = bTg.get(eVar2.id);
            if (aVar2 != null) {
                aVar2.kf.add(aVar);
            } else {
                a aVar3 = new a(eVar2.id);
                aVar3.kf.add(aVar);
                bTg.put(eVar2.id, aVar3);
                DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.setting.oauth.c.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i) {
                            case -2:
                                c.c("onNegBtn", false);
                                com.baidu.swan.apps.statistic.f.m("click", e.this.id, false);
                                c.A(e.this.id, false);
                                break;
                            case -1:
                                c.c("onPosBtn", false);
                                com.baidu.swan.apps.statistic.f.m("click", e.this.id, true);
                                c.A(e.this.id, true);
                                break;
                        }
                        com.baidu.swan.games.u.d.pD("na_authorize_end");
                    }
                };
                DialogInterface.OnCancelListener onCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.setting.oauth.c.3
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        c.c("onCancel", false);
                        com.baidu.swan.apps.statistic.f.m("click", e.this.id, false);
                        c.A(e.this.id, false);
                    }
                };
                com.baidu.swan.apps.statistic.f.m("show", eVar2.id, false);
                com.baidu.swan.games.u.d.pD("na_authorize_start");
                a(context, eVar, eVar2, jSONObject, onClickListener, onCancelListener);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void A(String str, boolean z) {
        a remove;
        synchronized (bTg) {
            remove = bTg.remove(str);
        }
        if (remove != null && !remove.kf.isEmpty()) {
            for (com.baidu.swan.apps.setting.oauth.a aVar : remove.kf) {
                if (aVar != null) {
                    aVar.onResult(z);
                }
            }
        }
    }

    private static void a(Context context, com.baidu.swan.apps.runtime.e eVar, e eVar2, JSONObject jSONObject, DialogInterface.OnClickListener onClickListener, DialogInterface.OnCancelListener onCancelListener) {
        g.a a2 = com.baidu.swan.apps.w.a.UL().a(context, eVar, eVar2, jSONObject, onClickListener);
        if (a2 == null) {
            if (DEBUG) {
                throw new RuntimeException("auth dialog builder is null");
            }
            return;
        }
        com.baidu.swan.apps.res.widget.dialog.g Pc = a2.Pc();
        Pc.setEnableImmersion(false);
        Pc.setOnCancelListener(onCancelListener);
        Window window = Pc.getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setLayout(af.cK(context), -2);
            window.setWindowAnimations(a.i.action_sheet_animation);
        }
        SwanAppActivity acB = eVar == null ? null : eVar.acB();
        if (acB != null && !acB.isFinishing()) {
            Pc.show();
        }
    }

    @Deprecated
    public static void g(Runnable runnable) {
        ai.l(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        final Set<com.baidu.swan.apps.setting.oauth.a> kf = new HashSet();
        final String scope;

        a(String str) {
            this.scope = str;
        }
    }

    public static JSONObject aP(JSONObject jSONObject) {
        String Id = com.baidu.swan.apps.w.a.Ui().Id();
        return (jSONObject == null || TextUtils.isEmpty(Id)) ? jSONObject : jSONObject.optJSONObject(Id);
    }

    public static boolean b(h<b.d> hVar) {
        return hVar != null && hVar.isOk() && hVar.mData.bTn;
    }

    public static void a(int i, CallbackHandler callbackHandler, String str) {
        if (!TextUtils.isEmpty(str)) {
            String gn = gn(i);
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(i, gn).toString());
            com.baidu.swan.apps.console.c.w("OAuthUtils", "authorize failed : " + gn);
        }
    }

    public static void a(h<b.d> hVar, CallbackHandler callbackHandler, String str) {
        if (hVar == null || hVar.aex() == null) {
            com.baidu.swan.apps.console.c.e("OAuthUtils", "authorize failed : result is invalid");
        } else {
            a(hVar.getErrorCode(), callbackHandler, str);
        }
    }

    public static void a(h<b.d> hVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
        if (hVar == null || hVar.aex() == null) {
            com.baidu.swan.apps.console.c.e("OAuthUtils", "authorize failed : result is invalid");
            return;
        }
        int errorCode = hVar.getErrorCode();
        String gn = gn(errorCode);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(errorCode, gn));
        com.baidu.swan.apps.console.c.w("OAuthUtils", "authorize failed : " + gn);
    }

    public static void a(com.baidu.swan.apps.setting.b.a aVar, CallbackHandler callbackHandler, String str) {
        int i;
        if (aVar != null && aVar.bUt != null) {
            try {
                i = (int) aVar.bUt.agk();
            } catch (ClassCastException e) {
                if (DEBUG) {
                    Log.e("OAuthUtils", e.toString());
                }
                i = -1;
            }
            if (i >= 0) {
                a(i, callbackHandler, str);
            }
        }
    }

    public static String gn(int i) {
        String str;
        switch (i) {
            case 10001:
                str = "internal error";
                break;
            case 10002:
                str = SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR;
                break;
            case 10003:
                str = "user deny";
                break;
            case 10004:
                str = "user not logged in";
                break;
            case 10005:
                str = "system deny";
                break;
            case 10006:
                str = "no data";
                break;
            default:
                str = "Permission denied";
                break;
        }
        if (DEBUG) {
            Log.w("OAuthUtils", i + HanziToPinyin.Token.SEPARATOR + str);
        }
        return str;
    }

    public static void release() {
        bTg.clear();
    }
}
