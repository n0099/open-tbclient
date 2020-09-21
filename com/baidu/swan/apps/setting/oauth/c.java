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
/* loaded from: classes3.dex */
public final class c {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Map<String, a> cXf = new HashMap();

    public static boolean bF(JSONObject jSONObject) {
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

    public static void c(final String str, Boolean bool) {
        com.baidu.swan.apps.console.c.bb("aiapps-oauth", str);
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
        synchronized (cXf) {
            a aVar2 = cXf.get(eVar2.id);
            if (aVar2 != null) {
                aVar2.GK.add(aVar);
            } else {
                a aVar3 = new a(eVar2.id);
                aVar3.GK.add(aVar);
                cXf.put(eVar2.id, aVar3);
                DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.setting.oauth.c.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i) {
                            case -2:
                                c.c("onNegBtn", false);
                                com.baidu.swan.apps.statistic.h.n("click", e.this.id, false);
                                c.X(e.this.id, false);
                                break;
                            case -1:
                                c.c("onPosBtn", false);
                                com.baidu.swan.apps.statistic.h.n("click", e.this.id, true);
                                c.X(e.this.id, true);
                                break;
                        }
                        com.baidu.swan.games.v.d.wj("na_authorize_end");
                    }
                };
                DialogInterface.OnCancelListener onCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.setting.oauth.c.3
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        c.c("onCancel", false);
                        com.baidu.swan.apps.statistic.h.n("click", e.this.id, false);
                        c.X(e.this.id, false);
                    }
                };
                com.baidu.swan.apps.statistic.h.n("show", eVar2.id, false);
                com.baidu.swan.games.v.d.wj("na_authorize_start");
                a(context, eVar, eVar2, jSONObject, onClickListener, onCancelListener);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void X(String str, boolean z) {
        a remove;
        synchronized (cXf) {
            remove = cXf.remove(str);
        }
        if (remove != null && !remove.GK.isEmpty()) {
            for (com.baidu.swan.apps.setting.oauth.a aVar : remove.GK) {
                if (aVar != null) {
                    aVar.onResult(z);
                }
            }
        }
    }

    private static void a(Context context, com.baidu.swan.apps.runtime.e eVar, e eVar2, JSONObject jSONObject, DialogInterface.OnClickListener onClickListener, DialogInterface.OnCancelListener onCancelListener) {
        g.a a2 = com.baidu.swan.apps.t.a.aqk().a(context, eVar, eVar2, jSONObject, onClickListener);
        if (a2 == null) {
            if (DEBUG) {
                throw new RuntimeException("auth dialog builder is null");
            }
            return;
        }
        com.baidu.swan.apps.res.widget.dialog.g aiJ = a2.aiJ();
        aiJ.setEnableImmersion(false);
        aiJ.setOnCancelListener(onCancelListener);
        Window window = aiJ.getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setLayout(ah.cI(context), -2);
            window.setWindowAnimations(a.i.action_sheet_animation);
        }
        SwanAppActivity aAl = eVar == null ? null : eVar.aAl();
        if (aAl != null && !aAl.isFinishing()) {
            aiJ.show();
        }
    }

    @Deprecated
    public static void h(Runnable runnable) {
        ak.m(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        final Set<com.baidu.swan.apps.setting.oauth.a> GK = new HashSet();
        final String scope;

        a(String str) {
            this.scope = str;
        }
    }

    public static JSONObject bG(JSONObject jSONObject) {
        String aaa = com.baidu.swan.apps.t.a.apG().aaa();
        return (jSONObject == null || TextUtils.isEmpty(aaa)) ? jSONObject : jSONObject.optJSONObject(aaa);
    }

    public static boolean b(h<b.d> hVar) {
        return hVar != null && hVar.isOk() && hVar.mData.cXk;
    }

    public static void a(int i, CallbackHandler callbackHandler, String str) {
        if (!TextUtils.isEmpty(str)) {
            String gL = gL(i);
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(i, gL).toString());
            com.baidu.swan.apps.console.c.w("OAuthUtils", "authorize failed : " + gL);
        }
    }

    public static void a(h<b.d> hVar, CallbackHandler callbackHandler, String str) {
        if (hVar == null || hVar.aCA() == null) {
            com.baidu.swan.apps.console.c.e("OAuthUtils", "authorize failed : result is invalid");
        } else {
            a(hVar.getErrorCode(), callbackHandler, str);
        }
    }

    public static void a(h<b.d> hVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
        if (hVar == null || hVar.aCA() == null) {
            com.baidu.swan.apps.console.c.e("OAuthUtils", "authorize failed : result is invalid");
            return;
        }
        int errorCode = hVar.getErrorCode();
        String gL = gL(errorCode);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(errorCode, gL));
        com.baidu.swan.apps.console.c.w("OAuthUtils", "authorize failed : " + gL);
    }

    public static void a(com.baidu.swan.apps.setting.b.a aVar, CallbackHandler callbackHandler, String str) {
        int i;
        if (aVar != null && aVar.cYv != null) {
            try {
                i = (int) aVar.cYv.aEM();
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

    public static String gL(int i) {
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
        cXf.clear();
    }
}
