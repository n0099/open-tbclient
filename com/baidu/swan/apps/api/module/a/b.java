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
import com.baidu.swan.apps.api.a.d;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.setting.oauth.a.e;
import com.baidu.swan.apps.setting.oauth.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends d {
    public b(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b TV() {
        if (DEBUG) {
            Log.d("Api-Login", "start is login action");
        }
        e aoG = e.aoG();
        if (aoG == null) {
            c.e("Api-Login", "swan app is null");
            return new com.baidu.swan.apps.api.c.b(202, "swan app is null");
        }
        boolean isLogin = aoG.aoS().isLogin(getContext());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isLogin", isLogin);
            return new com.baidu.swan.apps.api.c.b(0, jSONObject);
        } catch (JSONException e) {
            c.e("Api-Login", "json parse fail");
            return new com.baidu.swan.apps.api.c.b(1001);
        }
    }

    public com.baidu.swan.apps.api.c.b he(String str) {
        if (DEBUG) {
            Log.d("Api-Login", "start login");
        }
        final e aoG = e.aoG();
        final CallbackHandler TQ = TS().TQ();
        if (aoG == null) {
            com.baidu.swan.games.v.c.e(TQ, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
            return new com.baidu.swan.apps.api.c.b(1001, "empty swanApp");
        }
        final JSONObject hc = hc(str);
        if (hc == null) {
            com.baidu.swan.games.v.c.e(TQ, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
            a(aoG, 1, 201, "empty joParams");
            return new com.baidu.swan.apps.api.c.b(201, "empty joParams");
        }
        final String optString = hc.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.games.v.c.e(TQ, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
            a(aoG, 1, 201, "empty cb");
            return new com.baidu.swan.apps.api.c.b(201, "empty cb");
        } else if (!hc.optBoolean("force", true) && !aoG.aoS().isLogin(getContext())) {
            TQ.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
            com.baidu.swan.games.v.c.e(TQ, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
            a(aoG, 43, 10004, "user not logged in");
            return new com.baidu.swan.apps.api.c.b(0);
        } else {
            Context context = getContext();
            if (!(context instanceof Activity)) {
                return new com.baidu.swan.apps.api.c.b(1001, "the context is not an activity");
            }
            final Activity activity = (Activity) context;
            String optString2 = hc.optString("__plugin__", null);
            if (!TextUtils.isEmpty(optString2)) {
                com.baidu.swan.apps.setting.b.a.a(activity, "snsapi_userinfo", com.baidu.swan.apps.ae.g.b.mO(optString2), false, new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.setting.b.a>() { // from class: com.baidu.swan.apps.api.module.a.b.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.aq.e.b
                    /* renamed from: a */
                    public void H(com.baidu.swan.apps.setting.b.a aVar) {
                        if (aVar == null) {
                            b.this.a(optString, new com.baidu.swan.apps.api.c.b(403, "permission denied"));
                        } else if (aVar.aqP()) {
                            b.a(aoG, activity, hc, TQ, optString);
                        } else {
                            b.this.a(optString, new com.baidu.swan.apps.api.c.b(403, "permission denied"));
                        }
                    }
                });
            } else {
                a(aoG, activity, hc, TQ, optString);
            }
            return new com.baidu.swan.apps.api.c.b(0);
        }
    }

    public static void a(final e eVar, Activity activity, JSONObject jSONObject, final CallbackHandler callbackHandler, final String str) {
        final a aVar = new a(jSONObject);
        eVar.aoR().a(activity, aVar, (Bundle) null, new com.baidu.swan.apps.aq.e.b<h<e.c>>() { // from class: com.baidu.swan.apps.api.module.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: a */
            public void H(h<e.c> hVar) {
                if (!hVar.isOk()) {
                    int errorCode = hVar.getErrorCode();
                    c.w("Api-Login", errorCode + " " + a.this.toString());
                    String gO = com.baidu.swan.apps.setting.oauth.c.gO(errorCode);
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(errorCode, gO).toString());
                    com.baidu.swan.games.v.c.e(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(errorCode, gO).toString());
                    b.a(eVar, 43, errorCode, gO);
                } else if (TextUtils.isEmpty(hVar.mData.code)) {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    com.baidu.swan.games.v.c.e(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    b.a(eVar, 43, 1001, "empty code");
                } else {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("code", hVar.mData.code);
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, hVar.getErrorCode()).toString());
                    } catch (JSONException e) {
                        if (d.DEBUG) {
                            e.printStackTrace();
                        }
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                        com.baidu.swan.games.v.c.e(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                        b.a(eVar, 43, 1001, e.getMessage());
                    }
                }
            }
        });
    }

    /* loaded from: classes11.dex */
    public static class a {
        public final boolean bJV;
        public final long bJW;

        public a(@NonNull JSONObject jSONObject) {
            this.bJV = jSONObject.has("timeout");
            this.bJW = jSONObject.optLong("timeout", 0L);
            if (this.bJW < 0) {
                c.w("Api-Login", "timeout is a minus：" + toString());
            }
        }

        public String toString() {
            return "LoginTimeoutConfig{enableTimeout=" + this.bJV + ", timeoutMills=" + this.bJW + '}';
        }
    }

    public static void a(com.baidu.swan.apps.runtime.e eVar, int i, int i2, String str) {
        int Qz;
        if (eVar != null && (Qz = eVar.Qz()) == 0) {
            com.baidu.swan.apps.statistic.a.d oD = new com.baidu.swan.apps.statistic.a.d().f(new com.baidu.swan.apps.an.a().bw(5L).bx(i)).a(eVar.QJ()).oC(com.baidu.swan.apps.statistic.h.gU(Qz)).oD(com.baidu.swan.apps.runtime.e.aoH());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(TiebaInitialize.LogFields.ERROR_CODE, i2);
                jSONObject.put("errorMessage", str);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            oD.bt(jSONObject);
            com.baidu.swan.apps.statistic.h.b(oD);
        }
    }
}
