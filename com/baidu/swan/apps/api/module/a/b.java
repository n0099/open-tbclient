package com.baidu.swan.apps.api.module.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.api.a.d;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.setting.oauth.a.e;
import com.baidu.swan.apps.setting.oauth.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends d {
    public b(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b VG() {
        if (DEBUG) {
            Log.d("Api-Login", "start is login action");
        }
        e arw = e.arw();
        if (arw == null) {
            c.e("Api-Login", "swan app is null");
            return new com.baidu.swan.apps.api.c.b(202, "swan app is null");
        }
        boolean isLogin = arw.arI().isLogin(getContext());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isLogin", isLogin);
            return new com.baidu.swan.apps.api.c.b(0, jSONObject);
        } catch (JSONException e) {
            c.e("Api-Login", "json parse fail");
            return new com.baidu.swan.apps.api.c.b(1001);
        }
    }

    public com.baidu.swan.apps.api.c.b hu(String str) {
        if (DEBUG) {
            Log.d("Api-Login", "start login");
        }
        e arw = e.arw();
        CallbackHandler VB = VD().VB();
        if (arw == null) {
            com.baidu.swan.games.v.c.e(VB, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
            return new com.baidu.swan.apps.api.c.b(1001, "empty swanApp");
        }
        JSONObject hs = hs(str);
        if (hs == null) {
            com.baidu.swan.games.v.c.e(VB, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
            a(arw, 1, 201, "empty joParams");
            return new com.baidu.swan.apps.api.c.b(201, "empty joParams");
        }
        String optString = hs.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.games.v.c.e(VB, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
            a(arw, 1, 201, "empty cb");
            return new com.baidu.swan.apps.api.c.b(201, "empty cb");
        } else if (!hs.optBoolean("force", true) && !arw.arI().isLogin(getContext())) {
            VB.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
            com.baidu.swan.games.v.c.e(VB, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
            a(arw, 43, 10004, "user not logged in");
            return new com.baidu.swan.apps.api.c.b(0);
        } else {
            Context context = getContext();
            if (!(context instanceof Activity)) {
                return new com.baidu.swan.apps.api.c.b(1001, "the context is not an activity");
            }
            a(arw, (Activity) context, hs, VB, optString);
            return new com.baidu.swan.apps.api.c.b(0);
        }
    }

    public static void a(final e eVar, Activity activity, final JSONObject jSONObject, final CallbackHandler callbackHandler, final String str) {
        final a aVar = new a(jSONObject);
        eVar.arH().a(activity, aVar, (Bundle) null, new com.baidu.swan.apps.aq.e.b<h<e.c>>() { // from class: com.baidu.swan.apps.api.module.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: a */
            public void H(h<e.c> hVar) {
                if (!hVar.isOk()) {
                    int errorCode = hVar.getErrorCode();
                    c.w("Api-Login", errorCode + " " + a.this.toString());
                    String eE = com.baidu.swan.apps.setting.oauth.c.eE(errorCode);
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(errorCode, eE).toString());
                    com.baidu.swan.games.v.c.e(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(errorCode, eE).toString());
                    b.a(eVar, 43, errorCode, eE);
                } else if (TextUtils.isEmpty(hVar.mData.code)) {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    com.baidu.swan.games.v.c.e(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    b.a(eVar, 43, 1001, "empty code");
                } else {
                    String optString = jSONObject.optString("__plugin__");
                    if (!TextUtils.isEmpty(optString)) {
                        b.a(optString, eVar, callbackHandler, str, hVar);
                    } else {
                        b.a(eVar, callbackHandler, str, hVar);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str, final com.baidu.swan.apps.runtime.e eVar, final CallbackHandler callbackHandler, final String str2, final h<e.c> hVar) {
        SwanAppActivity arp = eVar.arp();
        if (arp == null) {
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "the activity is null").toString());
        } else {
            com.baidu.swan.apps.setting.b.a.a(arp, "snsapi_userinfo", com.baidu.swan.apps.ad.g.b.nD(str), false, new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.setting.b.a>() { // from class: com.baidu.swan.apps.api.module.a.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: a */
                public void H(com.baidu.swan.apps.setting.b.a aVar) {
                    if (aVar != null && aVar.atR()) {
                        b.a(eVar, CallbackHandler.this, str2, hVar);
                    } else {
                        CallbackHandler.this.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(403, "permission denied").toString());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.baidu.swan.apps.runtime.e eVar, CallbackHandler callbackHandler, String str, h<e.c> hVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", hVar.mData.code);
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, hVar.getErrorCode()).toString());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
            com.baidu.swan.games.v.c.e(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
            a(eVar, 43, 1001, e.getMessage());
        }
    }

    /* loaded from: classes7.dex */
    public static class a {
        public final boolean bPB;
        public final long bPC;

        public a(@NonNull JSONObject jSONObject) {
            this.bPB = jSONObject.has("timeout");
            this.bPC = jSONObject.optLong("timeout", 0L);
            if (this.bPC < 0) {
                c.w("Api-Login", "timeout is a minus：" + toString());
            }
        }

        public String toString() {
            return "LoginTimeoutConfig{enableTimeout=" + this.bPB + ", timeoutMills=" + this.bPC + '}';
        }
    }

    public static void a(com.baidu.swan.apps.runtime.e eVar, int i, int i2, String str) {
        int RU;
        if (eVar != null && (RU = eVar.RU()) == 0) {
            com.baidu.swan.apps.statistic.a.d pv = new com.baidu.swan.apps.statistic.a.d().f(new com.baidu.swan.apps.an.a().bJ(5L).bK(i)).a(eVar.Se()).pu(com.baidu.swan.apps.statistic.h.ho(RU)).pv(com.baidu.swan.apps.runtime.e.arx());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(TiebaInitialize.LogFields.ERROR_CODE, i2);
                jSONObject.put("errorMessage", str);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            pv.bF(jSONObject);
            com.baidu.swan.apps.statistic.h.b(pv);
        }
    }
}
