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
import com.baidu.swan.apps.setting.oauth.a.f;
import com.baidu.swan.apps.setting.oauth.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends d {
    public b(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b aiT() {
        if (DEBUG) {
            Log.d("Api-Login", "start is login action");
        }
        e aGN = e.aGN();
        if (aGN == null) {
            c.e("Api-Login", "swan app is null");
            return new com.baidu.swan.apps.api.c.b(202, "swan app is null");
        }
        boolean isLogin = aGN.aGZ().isLogin(getContext());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isLogin", isLogin);
            return new com.baidu.swan.apps.api.c.b(0, jSONObject);
        } catch (JSONException e) {
            c.e("Api-Login", "json parse fail");
            return new com.baidu.swan.apps.api.c.b(1001);
        }
    }

    public com.baidu.swan.apps.api.c.b kz(String str) {
        if (DEBUG) {
            Log.d("Api-Login", "start login");
        }
        e aGN = e.aGN();
        CallbackHandler aiO = aiQ().aiO();
        if (aGN == null) {
            com.baidu.swan.games.v.c.e(aiO, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
            return new com.baidu.swan.apps.api.c.b(1001, "empty swanApp");
        }
        JSONObject kx = kx(str);
        if (kx == null) {
            com.baidu.swan.games.v.c.e(aiO, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
            a(aGN, 1, 201, "empty joParams");
            return new com.baidu.swan.apps.api.c.b(201, "empty joParams");
        }
        String optString = kx.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.games.v.c.e(aiO, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
            a(aGN, 1, 201, "empty cb");
            return new com.baidu.swan.apps.api.c.b(201, "empty cb");
        } else if (!kx.optBoolean("force", true) && !aGN.aGZ().isLogin(getContext())) {
            aiO.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
            com.baidu.swan.games.v.c.e(aiO, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
            a(aGN, 43, 10004, "user not logged in");
            return new com.baidu.swan.apps.api.c.b(0);
        } else {
            Context context = getContext();
            if (!(context instanceof Activity) && (context = aGN.aGG()) == null) {
                return new com.baidu.swan.apps.api.c.b(1001, "the context is not an activity");
            }
            a(aGN, (Activity) context, kx, aiO, optString);
            return new com.baidu.swan.apps.api.c.b(0);
        }
    }

    public static void a(final e eVar, Activity activity, final JSONObject jSONObject, final CallbackHandler callbackHandler, final String str) {
        final a aVar = new a(jSONObject);
        eVar.aGY().a(activity, aVar, (Bundle) null, new com.baidu.swan.apps.ap.e.b<h<f.c>>() { // from class: com.baidu.swan.apps.api.module.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void M(h<f.c> hVar) {
                if (!hVar.isOk()) {
                    int errorCode = hVar.getErrorCode();
                    c.w("Api-Login", errorCode + " " + a.this.toString());
                    String hz = com.baidu.swan.apps.setting.oauth.c.hz(errorCode);
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(errorCode, hz).toString());
                    com.baidu.swan.games.v.c.e(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(errorCode, hz).toString());
                    b.a(eVar, 43, errorCode, hz);
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
    public static void a(String str, final e eVar, final CallbackHandler callbackHandler, final String str2, final h<f.c> hVar) {
        SwanAppActivity aGG = eVar.aGG();
        if (aGG == null) {
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "the activity is null").toString());
        } else {
            com.baidu.swan.apps.setting.b.a.a(aGG, "snsapi_userinfo", com.baidu.swan.apps.ac.g.b.ri(str), false, new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.b.a>() { // from class: com.baidu.swan.apps.api.module.a.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: a */
                public void M(com.baidu.swan.apps.setting.b.a aVar) {
                    if (aVar != null && aVar.aJf()) {
                        b.a(eVar, CallbackHandler.this, str2, hVar);
                    } else {
                        CallbackHandler.this.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(403, "permission denied").toString());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(e eVar, CallbackHandler callbackHandler, String str, h<f.c> hVar) {
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
        public final boolean cwj;
        public final long cwk;

        public a(@NonNull JSONObject jSONObject) {
            this.cwj = jSONObject.has("timeout");
            this.cwk = jSONObject.optLong("timeout", 0L);
            if (this.cwk < 0) {
                c.w("Api-Login", "timeout is a minus：" + toString());
            }
        }

        public String toString() {
            return "LoginTimeoutConfig{enableTimeout=" + this.cwj + ", timeoutMills=" + this.cwk + '}';
        }
    }

    public static void a(e eVar, int i, int i2, String str) {
        int aeW;
        if (eVar != null && (aeW = eVar.aeW()) == 0) {
            com.baidu.swan.apps.statistic.a.d te = new com.baidu.swan.apps.statistic.a.d().i(new com.baidu.swan.apps.am.a().cv(5L).cw(i)).a(eVar.afg()).td(com.baidu.swan.apps.statistic.h.ku(aeW)).te(e.aGO());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(TiebaInitialize.LogFields.ERROR_CODE, i2);
                jSONObject.put("errorMessage", str);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            te.ca(jSONObject);
            com.baidu.swan.apps.statistic.h.b(te);
        }
    }
}
