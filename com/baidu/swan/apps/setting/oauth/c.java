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
import com.baidu.mapapi.SDKInitializer;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.cookie.CookieJarImpl;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.aq.aj;
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
    private static final Map<String, a> cIS = new HashMap();
    private static OkHttpClient cIT;

    public static boolean bp(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return TextUtils.equals(jSONObject.optString("invokeFrom"), "component");
    }

    public static Context getAppContext() {
        return AppRuntime.getAppContext();
    }

    public static RequestBody q(Map<String, String> map) {
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

    public static OkHttpClient alD() {
        if (cIT != null) {
            return cIT;
        }
        OkHttpClient build = com.baidu.swan.apps.runtime.d.apI().apK().Se().TH().newBuilder().cookieJar(new CookieJarImpl(com.baidu.swan.apps.u.a.agu().TS())).addNetworkInterceptor(new com.baidu.swan.apps.network.a.d()).build();
        cIT = build;
        return build;
    }

    public static String getKeyHash() {
        try {
            PackageInfo packageInfo = getAppContext().getPackageManager().getPackageInfo(getAppContext().getPackageName(), 64);
            if (packageInfo != null && packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                return com.baidu.swan.e.e.toMd5(packageInfo.signatures[0].toByteArray(), false);
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
        synchronized (cIS) {
            a aVar2 = cIS.get(eVar2.id);
            if (aVar2 != null) {
                aVar2.Ge.add(aVar);
            } else {
                a aVar3 = new a(eVar2.id);
                aVar3.Ge.add(aVar);
                cIS.put(eVar2.id, aVar3);
                DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.setting.oauth.c.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i) {
                            case -2:
                                c.c("onNegBtn", false);
                                com.baidu.swan.apps.statistic.h.n("click", e.this.id, false);
                                c.T(e.this.id, false);
                                break;
                            case -1:
                                c.c("onPosBtn", false);
                                com.baidu.swan.apps.statistic.h.n("click", e.this.id, true);
                                c.T(e.this.id, true);
                                break;
                        }
                        com.baidu.swan.games.v.d.sB("na_authorize_end");
                    }
                };
                DialogInterface.OnCancelListener onCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.setting.oauth.c.3
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        c.c("onCancel", false);
                        com.baidu.swan.apps.statistic.h.n("click", e.this.id, false);
                        c.T(e.this.id, false);
                    }
                };
                com.baidu.swan.apps.statistic.h.n("show", eVar2.id, false);
                com.baidu.swan.games.v.d.sB("na_authorize_start");
                a(context, eVar, eVar2, jSONObject, onClickListener, onCancelListener);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void T(String str, boolean z) {
        a remove;
        synchronized (cIS) {
            remove = cIS.remove(str);
        }
        if (remove != null && !remove.Ge.isEmpty()) {
            for (com.baidu.swan.apps.setting.oauth.a aVar : remove.Ge) {
                if (aVar != null) {
                    aVar.onResult(z);
                }
            }
        }
    }

    private static void a(Context context, com.baidu.swan.apps.runtime.e eVar, e eVar2, JSONObject jSONObject, DialogInterface.OnClickListener onClickListener, DialogInterface.OnCancelListener onCancelListener) {
        g.a a2 = com.baidu.swan.apps.u.a.agL().a(context, eVar, eVar2, jSONObject, onClickListener);
        if (a2 == null) {
            if (DEBUG) {
                throw new RuntimeException("auth dialog builder is null");
            }
            return;
        }
        com.baidu.swan.apps.res.widget.dialog.g aaL = a2.aaL();
        aaL.setEnableImmersion(false);
        aaL.setOnCancelListener(onCancelListener);
        Window window = aaL.getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setLayout(ag.cy(context), -2);
            window.setWindowAnimations(a.i.action_sheet_animation);
        }
        SwanAppActivity apG = eVar == null ? null : eVar.apG();
        if (apG != null && !apG.isFinishing()) {
            aaL.show();
        }
    }

    @Deprecated
    public static void k(Runnable runnable) {
        aj.p(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        final Set<com.baidu.swan.apps.setting.oauth.a> Ge = new HashSet();
        final String scope;

        a(String str) {
            this.scope = str;
        }
    }

    public static JSONObject bq(JSONObject jSONObject) {
        String SW = com.baidu.swan.apps.u.a.agj().SW();
        return (jSONObject == null || TextUtils.isEmpty(SW)) ? jSONObject : jSONObject.optJSONObject(SW);
    }

    public static boolean b(h<b.d> hVar) {
        return hVar != null && hVar.isOk() && hVar.mData.cJa;
    }

    public static void a(int i, CallbackHandler callbackHandler, String str) {
        if (!TextUtils.isEmpty(str)) {
            String gZ = gZ(i);
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(i, gZ).toString());
            com.baidu.swan.apps.console.c.w("OAuthUtils", "authorize failed : " + gZ);
        }
    }

    public static void a(h<b.d> hVar, CallbackHandler callbackHandler, String str) {
        if (hVar == null || hVar.arN() == null) {
            com.baidu.swan.apps.console.c.e("OAuthUtils", "authorize failed : result is invalid");
        } else {
            a(hVar.getErrorCode(), callbackHandler, str);
        }
    }

    public static void a(h<b.d> hVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
        if (hVar == null || hVar.arN() == null) {
            com.baidu.swan.apps.console.c.e("OAuthUtils", "authorize failed : result is invalid");
            return;
        }
        int errorCode = hVar.getErrorCode();
        String gZ = gZ(errorCode);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(errorCode, gZ));
        com.baidu.swan.apps.console.c.w("OAuthUtils", "authorize failed : " + gZ);
    }

    public static void a(com.baidu.swan.apps.setting.b.a aVar, CallbackHandler callbackHandler, String str) {
        int i;
        if (aVar != null && aVar.cKe != null) {
            try {
                i = (int) aVar.cKe.atS();
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

    public static String gZ(int i) {
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
            Log.w("OAuthUtils", i + " " + str);
        }
        return str;
    }

    public static void release() {
        cIS.clear();
    }
}
