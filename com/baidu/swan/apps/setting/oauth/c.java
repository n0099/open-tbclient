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
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.setting.oauth.a.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public final class c {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Map<String, a> dDb = new HashMap();

    public static boolean bR(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return TextUtils.equals(jSONObject.optString("invokeFrom"), "component");
    }

    public static Context getAppContext() {
        return AppRuntime.getAppContext();
    }

    public static RequestBody A(Map<String, String> map) {
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

    public static void c(final String str, Boolean bool) {
        com.baidu.swan.apps.console.c.bt("aiapps-oauth", str);
        if (DEBUG && bool.booleanValue()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.c.1
                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(c.getAppContext(), "aiapps-oauth :: " + str, 0).show();
                }
            });
        }
    }

    public static String getKeyHash() {
        try {
            PackageInfo packageInfo = getAppContext().getPackageManager().getPackageInfo(getAppContext().getPackageName(), 64);
            if (packageInfo != null && packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                return com.baidu.swan.c.e.toMd5(packageInfo.signatures[0].toByteArray(), false);
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
        synchronized (dDb) {
            a aVar2 = dDb.get(eVar2.id);
            if (aVar2 != null) {
                aVar2.HV.add(aVar);
            } else {
                a aVar3 = new a(eVar2.id);
                aVar3.HV.add(aVar);
                dDb.put(eVar2.id, aVar3);
                DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.setting.oauth.c.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i) {
                            case -2:
                                c.c("onNegBtn", false);
                                com.baidu.swan.apps.statistic.h.p("click", e.this.id, false);
                                c.ae(e.this.id, false);
                                break;
                            case -1:
                                c.c("onPosBtn", false);
                                com.baidu.swan.apps.statistic.h.p("click", e.this.id, true);
                                c.ae(e.this.id, true);
                                break;
                        }
                        com.baidu.swan.games.v.d.ye("na_authorize_end");
                    }
                };
                DialogInterface.OnCancelListener onCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.setting.oauth.c.3
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        c.c("onCancel", false);
                        com.baidu.swan.apps.statistic.h.p("click", e.this.id, false);
                        c.ae(e.this.id, false);
                    }
                };
                com.baidu.swan.apps.statistic.h.p("show", eVar2.id, false);
                com.baidu.swan.games.v.d.ye("na_authorize_start");
                a(context, eVar, eVar2, jSONObject, onClickListener, onCancelListener);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ae(String str, boolean z) {
        a remove;
        synchronized (dDb) {
            remove = dDb.remove(str);
        }
        if (remove != null && !remove.HV.isEmpty()) {
            for (com.baidu.swan.apps.setting.oauth.a aVar : remove.HV) {
                if (aVar != null) {
                    aVar.onResult(z);
                }
            }
        }
    }

    private static void a(Context context, com.baidu.swan.apps.runtime.e eVar, e eVar2, JSONObject jSONObject, DialogInterface.OnClickListener onClickListener, DialogInterface.OnCancelListener onCancelListener) {
        g.a a2 = com.baidu.swan.apps.t.a.azQ().a(context, eVar, eVar2, jSONObject, onClickListener);
        if (a2 == null) {
            if (DEBUG) {
                throw new RuntimeException("auth dialog builder is null");
            }
            return;
        }
        com.baidu.swan.apps.res.widget.dialog.g asp = a2.asp();
        asp.setEnableImmersion(false);
        asp.setOnCancelListener(onCancelListener);
        Window window = asp.getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setLayout(ah.du(context), -2);
            window.setWindowAnimations(a.i.action_sheet_animation);
        }
        SwanAppActivity aJO = eVar == null ? null : eVar.aJO();
        if (aJO != null && !aJO.isFinishing()) {
            asp.show();
        }
    }

    @Deprecated
    public static void h(Runnable runnable) {
        ak.m(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public static class a {
        final Set<com.baidu.swan.apps.setting.oauth.a> HV = new HashSet();
        final String scope;

        a(String str) {
            this.scope = str;
        }
    }

    public static JSONObject bS(JSONObject jSONObject) {
        String ajG = com.baidu.swan.apps.t.a.azm().ajG();
        return (jSONObject == null || TextUtils.isEmpty(ajG)) ? jSONObject : jSONObject.optJSONObject(ajG);
    }

    public static boolean b(h<b.d> hVar) {
        return hVar != null && hVar.isOk() && hVar.mData.dDg;
    }

    public static void a(int i, CallbackHandler callbackHandler, String str) {
        if (!TextUtils.isEmpty(str)) {
            String hX = hX(i);
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(i, hX).toString());
            com.baidu.swan.apps.console.c.w("OAuthUtils", "authorize failed : " + hX);
        }
    }

    public static void a(h<b.d> hVar, CallbackHandler callbackHandler, String str) {
        if (hVar == null || hVar.aMd() == null) {
            com.baidu.swan.apps.console.c.e("OAuthUtils", "authorize failed : result is invalid");
        } else {
            a(hVar.getErrorCode(), callbackHandler, str);
        }
    }

    public static void a(h<b.d> hVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
        if (hVar == null || hVar.aMd() == null) {
            com.baidu.swan.apps.console.c.e("OAuthUtils", "authorize failed : result is invalid");
            return;
        }
        int errorCode = hVar.getErrorCode();
        String hX = hX(errorCode);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(errorCode, hX));
        com.baidu.swan.apps.console.c.w("OAuthUtils", "authorize failed : " + hX);
    }

    public static void a(com.baidu.swan.apps.setting.b.a aVar, CallbackHandler callbackHandler, String str) {
        int i;
        if (aVar != null && aVar.dEr != null) {
            try {
                i = (int) aVar.dEr.aOo();
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

    public static String hX(int i) {
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
        dDb.clear();
    }
}
