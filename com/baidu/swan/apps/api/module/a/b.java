package com.baidu.swan.apps.api.module.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
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
/* loaded from: classes9.dex */
public class b extends d {
    public b(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b ajQ() {
        if (DEBUG) {
            Log.d("Api-Login", "start is login action");
        }
        e aIL = e.aIL();
        if (aIL == null) {
            c.e("Api-Login", "swan app is null");
            return new com.baidu.swan.apps.api.c.b(202, "swan app is null");
        }
        boolean isLogin = aIL.aIX().isLogin(getContext());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isLogin", isLogin);
            return new com.baidu.swan.apps.api.c.b(0, jSONObject);
        } catch (JSONException e) {
            c.e("Api-Login", "json parse fail");
            return new com.baidu.swan.apps.api.c.b(1001);
        }
    }

    public com.baidu.swan.apps.api.c.b kg(String str) {
        if (DEBUG) {
            Log.d("Api-Login", "start login");
        }
        e aIL = e.aIL();
        CallbackHandler ajL = ajN().ajL();
        if (aIL == null) {
            com.baidu.swan.games.v.c.e(ajL, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
            return new com.baidu.swan.apps.api.c.b(1001, "empty swanApp");
        }
        JSONObject ke = ke(str);
        if (ke == null) {
            com.baidu.swan.games.v.c.e(ajL, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
            a(aIL, 1, 201, "empty joParams");
            return new com.baidu.swan.apps.api.c.b(201, "empty joParams");
        }
        String optString = ke.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.games.v.c.e(ajL, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
            a(aIL, 1, 201, "empty cb");
            return new com.baidu.swan.apps.api.c.b(201, "empty cb");
        } else if (!ke.optBoolean("force", true) && !aIL.aIX().isLogin(getContext())) {
            ajL.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
            com.baidu.swan.games.v.c.e(ajL, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
            a(aIL, 43, 10004, "user not logged in");
            return new com.baidu.swan.apps.api.c.b(0);
        } else {
            Context context = getContext();
            if (!(context instanceof Activity) && (context = aIL.aIE()) == null) {
                return new com.baidu.swan.apps.api.c.b(1001, "the context is not an activity");
            }
            a(aIL, (Activity) context, ke, ajL, optString);
            return new com.baidu.swan.apps.api.c.b(0);
        }
    }

    public static void a(final e eVar, Activity activity, final JSONObject jSONObject, final CallbackHandler callbackHandler, final String str) {
        final a aVar = new a(jSONObject);
        eVar.aIW().a(activity, aVar, (Bundle) null, new com.baidu.swan.apps.ao.e.b<h<f.c>>() { // from class: com.baidu.swan.apps.api.module.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: a */
            public void L(h<f.c> hVar) {
                if (!hVar.isOk()) {
                    int errorCode = hVar.getErrorCode();
                    c.w("Api-Login", errorCode + " " + a.this.toString());
                    String gn = com.baidu.swan.apps.setting.oauth.c.gn(errorCode);
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(errorCode, gn).toString());
                    com.baidu.swan.games.v.c.e(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(errorCode, gn).toString());
                    b.a(eVar, 43, errorCode, gn);
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
        SwanAppActivity aIE = eVar.aIE();
        if (aIE == null) {
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "the activity is null").toString());
        } else {
            com.baidu.swan.apps.setting.b.a.a(aIE, "snsapi_userinfo", com.baidu.swan.apps.ac.g.b.qP(str), false, new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.setting.b.a>() { // from class: com.baidu.swan.apps.api.module.a.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: a */
                public void L(com.baidu.swan.apps.setting.b.a aVar) {
                    if (aVar != null && aVar.aLd()) {
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

    /* loaded from: classes9.dex */
    public static class a {
        public final boolean cFB;
        public final long cFC;

        public a(@NonNull JSONObject jSONObject) {
            this.cFB = jSONObject.has("timeout");
            this.cFC = jSONObject.optLong("timeout", 0L);
            if (this.cFC < 0) {
                c.w("Api-Login", "timeout is a minus：" + toString());
            }
        }

        public String toString() {
            return "LoginTimeoutConfig{enableTimeout=" + this.cFB + ", timeoutMills=" + this.cFC + '}';
        }
    }

    public static void a(e eVar, int i, int i2, String str) {
        int frameType;
        if (eVar != null && (frameType = eVar.getFrameType()) == 0) {
            com.baidu.swan.apps.statistic.a.d sQ = new com.baidu.swan.apps.statistic.a.d().i(new com.baidu.swan.apps.al.a().db(5L).dc(i)).a(eVar.afZ()).sP(com.baidu.swan.apps.statistic.h.ju(frameType)).sQ(e.aIM());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(TiebaInitialize.LogFields.ERROR_CODE, i2);
                jSONObject.put("errorMessage", str);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            sQ.ch(jSONObject);
            com.baidu.swan.apps.statistic.h.b(sQ);
        }
    }
}
