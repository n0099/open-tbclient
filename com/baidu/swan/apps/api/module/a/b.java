package com.baidu.swan.apps.api.module.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.api.a.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.setting.oauth.a.e;
import com.baidu.swan.apps.setting.oauth.h;
import com.baidu.swan.apps.statistic.a.d;
import com.baidu.swan.apps.statistic.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b extends c {
    public b(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.b.b GT() {
        if (DEBUG) {
            Log.d("Api-Login", "start is login action");
        }
        e ZT = e.ZT();
        if (ZT == null) {
            com.baidu.swan.apps.console.c.e("Api-Login", "swan app is null");
            return new com.baidu.swan.apps.api.b.b(202, "swan app is null");
        }
        boolean isLogin = ZT.aad().isLogin(getContext());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isLogin", isLogin);
            return new com.baidu.swan.apps.api.b.b(0, jSONObject);
        } catch (JSONException e) {
            com.baidu.swan.apps.console.c.e("Api-Login", "json parse fail");
            return new com.baidu.swan.apps.api.b.b(1001);
        }
    }

    public com.baidu.swan.apps.api.b.b eN(String str) {
        if (DEBUG) {
            Log.d("Api-Login", "start login");
        }
        final e ZT = e.ZT();
        final CallbackHandler GP = GR().GP();
        if (ZT == null) {
            com.baidu.swan.games.u.c.f(GP, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
            return new com.baidu.swan.apps.api.b.b(1001, "empty swanApp");
        }
        final JSONObject eL = eL(str);
        if (eL == null) {
            com.baidu.swan.games.u.c.f(GP, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
            a(ZT, 1, 201, "empty joParams");
            return new com.baidu.swan.apps.api.b.b(201, "empty joParams");
        }
        final String optString = eL.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.games.u.c.f(GP, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
            a(ZT, 1, 201, "empty cb");
            return new com.baidu.swan.apps.api.b.b(201, "empty cb");
        } else if (!eL.optBoolean("force", true) && !ZT.aad().isLogin(getContext())) {
            GP.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
            com.baidu.swan.games.u.c.f(GP, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
            a(ZT, 43, 10004, "user not logged in");
            return new com.baidu.swan.apps.api.b.b(0);
        } else {
            Context context = getContext();
            if (!(context instanceof Activity)) {
                return new com.baidu.swan.apps.api.b.b(1001, "the context is not an activity");
            }
            final Activity activity = (Activity) context;
            String optString2 = eL.optString("__plugin__", null);
            if (!TextUtils.isEmpty(optString2)) {
                com.baidu.swan.apps.setting.b.a.a(activity, "snsapi_userinfo", com.baidu.swan.apps.ag.g.b.jT(optString2), false, new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.setting.b.a>() { // from class: com.baidu.swan.apps.api.module.a.b.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.as.d.b
                    /* renamed from: a */
                    public void B(com.baidu.swan.apps.setting.b.a aVar) {
                        if (aVar == null) {
                            b.this.a(optString, new com.baidu.swan.apps.api.b.b(403, "permission denied"));
                        } else if (aVar.abR()) {
                            b.a(ZT, activity, eL, GP, optString);
                        } else {
                            b.this.a(optString, new com.baidu.swan.apps.api.b.b(403, "permission denied"));
                        }
                    }
                });
            } else {
                a(ZT, activity, eL, GP, optString);
            }
            return new com.baidu.swan.apps.api.b.b(0);
        }
    }

    public static void a(final e eVar, Activity activity, JSONObject jSONObject, final CallbackHandler callbackHandler, final String str) {
        final a aVar = new a(jSONObject);
        eVar.aac().a(activity, aVar, (Bundle) null, new com.baidu.swan.apps.as.d.b<h<e.c>>() { // from class: com.baidu.swan.apps.api.module.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void B(h<e.c> hVar) {
                if (!hVar.isOk()) {
                    int errorCode = hVar.getErrorCode();
                    com.baidu.swan.apps.console.c.w("Api-Login", errorCode + HanziToPinyin.Token.SEPARATOR + a.this.toString());
                    String fW = com.baidu.swan.apps.setting.oauth.c.fW(errorCode);
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(errorCode, fW).toString());
                    com.baidu.swan.games.u.c.f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(errorCode, fW).toString());
                    b.a(eVar, 43, errorCode, fW);
                } else if (TextUtils.isEmpty(hVar.mData.code)) {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    com.baidu.swan.games.u.c.f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    b.a(eVar, 43, 1001, "empty code");
                } else {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("code", hVar.mData.code);
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, hVar.getErrorCode()).toString());
                    } catch (JSONException e) {
                        if (c.DEBUG) {
                            e.printStackTrace();
                        }
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                        com.baidu.swan.games.u.c.f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                        b.a(eVar, 43, 1001, e.getMessage());
                    }
                }
            }
        });
    }

    /* loaded from: classes9.dex */
    public static class a {
        public final boolean aXU;
        public final long aXV;

        public a(@NonNull JSONObject jSONObject) {
            this.aXU = jSONObject.has("timeout");
            this.aXV = jSONObject.optLong("timeout", 0L);
            if (this.aXV < 0) {
                com.baidu.swan.apps.console.c.w("Api-Login", "timeout is a minus：" + toString());
            }
        }

        public String toString() {
            return "LoginTimeoutConfig{enableTimeout=" + this.aXU + ", timeoutMills=" + this.aXV + '}';
        }
    }

    public static void a(com.baidu.swan.apps.runtime.e eVar, int i, int i2, String str) {
        int DH;
        if (eVar != null && (DH = eVar.DH()) == 0) {
            d lw = new d().e(new com.baidu.swan.apps.ap.a().aB(5L).aC(i)).a(eVar.DR()).lv(f.ga(DH)).lw(com.baidu.swan.apps.runtime.e.ZU());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(TiebaInitialize.LogFields.ERROR_CODE, i2);
                jSONObject.put("errorMessage", str);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            lw.aZ(jSONObject);
            f.b(lw);
        }
    }
}
