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
/* loaded from: classes3.dex */
public class b extends d {
    public b(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b acv() {
        if (DEBUG) {
            Log.d("Api-Login", "start is login action");
        }
        e aAs = e.aAs();
        if (aAs == null) {
            c.e("Api-Login", "swan app is null");
            return new com.baidu.swan.apps.api.c.b(202, "swan app is null");
        }
        boolean isLogin = aAs.aAE().isLogin(getContext());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isLogin", isLogin);
            return new com.baidu.swan.apps.api.c.b(0, jSONObject);
        } catch (JSONException e) {
            c.e("Api-Login", "json parse fail");
            return new com.baidu.swan.apps.api.c.b(1001);
        }
    }

    public com.baidu.swan.apps.api.c.b jl(String str) {
        if (DEBUG) {
            Log.d("Api-Login", "start login");
        }
        e aAs = e.aAs();
        CallbackHandler acq = acs().acq();
        if (aAs == null) {
            com.baidu.swan.games.v.c.e(acq, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
            return new com.baidu.swan.apps.api.c.b(1001, "empty swanApp");
        }
        JSONObject jj = jj(str);
        if (jj == null) {
            com.baidu.swan.games.v.c.e(acq, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
            a(aAs, 1, 201, "empty joParams");
            return new com.baidu.swan.apps.api.c.b(201, "empty joParams");
        }
        String optString = jj.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.games.v.c.e(acq, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
            a(aAs, 1, 201, "empty cb");
            return new com.baidu.swan.apps.api.c.b(201, "empty cb");
        } else if (!jj.optBoolean("force", true) && !aAs.aAE().isLogin(getContext())) {
            acq.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
            com.baidu.swan.games.v.c.e(acq, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
            a(aAs, 43, 10004, "user not logged in");
            return new com.baidu.swan.apps.api.c.b(0);
        } else {
            Context context = getContext();
            if (!(context instanceof Activity) && (context = aAs.aAl()) == null) {
                return new com.baidu.swan.apps.api.c.b(1001, "the context is not an activity");
            }
            a(aAs, (Activity) context, jj, acq, optString);
            return new com.baidu.swan.apps.api.c.b(0);
        }
    }

    public static void a(final e eVar, Activity activity, final JSONObject jSONObject, final CallbackHandler callbackHandler, final String str) {
        final a aVar = new a(jSONObject);
        eVar.aAD().a(activity, aVar, (Bundle) null, new com.baidu.swan.apps.ap.e.b<h<f.c>>() { // from class: com.baidu.swan.apps.api.module.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void J(h<f.c> hVar) {
                if (!hVar.isOk()) {
                    int errorCode = hVar.getErrorCode();
                    c.w("Api-Login", errorCode + " " + a.this.toString());
                    String gL = com.baidu.swan.apps.setting.oauth.c.gL(errorCode);
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(errorCode, gL).toString());
                    com.baidu.swan.games.v.c.e(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(errorCode, gL).toString());
                    b.a(eVar, 43, errorCode, gL);
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
        SwanAppActivity aAl = eVar.aAl();
        if (aAl == null) {
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "the activity is null").toString());
        } else {
            com.baidu.swan.apps.setting.b.a.a(aAl, "snsapi_userinfo", com.baidu.swan.apps.ac.g.b.pV(str), false, new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.b.a>() { // from class: com.baidu.swan.apps.api.module.a.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: a */
                public void J(com.baidu.swan.apps.setting.b.a aVar) {
                    if (aVar != null && aVar.aCK()) {
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

    /* loaded from: classes3.dex */
    public static class a {
        public final boolean bXg;
        public final long bXh;

        public a(@NonNull JSONObject jSONObject) {
            this.bXg = jSONObject.has("timeout");
            this.bXh = jSONObject.optLong("timeout", 0L);
            if (this.bXh < 0) {
                c.w("Api-Login", "timeout is a minus：" + toString());
            }
        }

        public String toString() {
            return "LoginTimeoutConfig{enableTimeout=" + this.bXg + ", timeoutMills=" + this.bXh + '}';
        }
    }

    public static void a(e eVar, int i, int i2, String str) {
        int Yy;
        if (eVar != null && (Yy = eVar.Yy()) == 0) {
            com.baidu.swan.apps.statistic.a.d rP = new com.baidu.swan.apps.statistic.a.d().i(new com.baidu.swan.apps.am.a().bP(5L).bQ(i)).a(eVar.YI()).rO(com.baidu.swan.apps.statistic.h.jG(Yy)).rP(e.aAt());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(TiebaInitialize.LogFields.ERROR_CODE, i2);
                jSONObject.put("errorMessage", str);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            rP.bQ(jSONObject);
            com.baidu.swan.apps.statistic.h.b(rP);
        }
    }
}
