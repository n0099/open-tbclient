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
/* loaded from: classes10.dex */
public class b extends c {
    public b(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.b.b Hp() {
        if (DEBUG) {
            Log.d("Api-Login", "start is login action");
        }
        e aaq = e.aaq();
        if (aaq == null) {
            com.baidu.swan.apps.console.c.e("Api-Login", "swan app is null");
            return new com.baidu.swan.apps.api.b.b(202, "swan app is null");
        }
        boolean isLogin = aaq.aaA().isLogin(getContext());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isLogin", isLogin);
            return new com.baidu.swan.apps.api.b.b(0, jSONObject);
        } catch (JSONException e) {
            com.baidu.swan.apps.console.c.e("Api-Login", "json parse fail");
            return new com.baidu.swan.apps.api.b.b(1001);
        }
    }

    public com.baidu.swan.apps.api.b.b eQ(String str) {
        if (DEBUG) {
            Log.d("Api-Login", "start login");
        }
        final e aaq = e.aaq();
        final CallbackHandler Hl = Hn().Hl();
        if (aaq == null) {
            com.baidu.swan.games.u.c.f(Hl, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
            return new com.baidu.swan.apps.api.b.b(1001, "empty swanApp");
        }
        final JSONObject eO = eO(str);
        if (eO == null) {
            com.baidu.swan.games.u.c.f(Hl, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
            a(aaq, 1, 201, "empty joParams");
            return new com.baidu.swan.apps.api.b.b(201, "empty joParams");
        }
        final String optString = eO.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.games.u.c.f(Hl, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
            a(aaq, 1, 201, "empty cb");
            return new com.baidu.swan.apps.api.b.b(201, "empty cb");
        } else if (!eO.optBoolean("force", true) && !aaq.aaA().isLogin(getContext())) {
            Hl.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
            com.baidu.swan.games.u.c.f(Hl, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
            a(aaq, 43, 10004, "user not logged in");
            return new com.baidu.swan.apps.api.b.b(0);
        } else {
            Context context = getContext();
            if (!(context instanceof Activity)) {
                return new com.baidu.swan.apps.api.b.b(1001, "the context is not an activity");
            }
            final Activity activity = (Activity) context;
            String optString2 = eO.optString("__plugin__", null);
            if (!TextUtils.isEmpty(optString2)) {
                com.baidu.swan.apps.setting.b.a.a(activity, "snsapi_userinfo", com.baidu.swan.apps.ag.g.b.jW(optString2), false, new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.setting.b.a>() { // from class: com.baidu.swan.apps.api.module.a.b.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.as.d.b
                    /* renamed from: a */
                    public void B(com.baidu.swan.apps.setting.b.a aVar) {
                        if (aVar == null) {
                            b.this.a(optString, new com.baidu.swan.apps.api.b.b(403, "permission denied"));
                        } else if (aVar.aco()) {
                            b.a(aaq, activity, eO, Hl, optString);
                        } else {
                            b.this.a(optString, new com.baidu.swan.apps.api.b.b(403, "permission denied"));
                        }
                    }
                });
            } else {
                a(aaq, activity, eO, Hl, optString);
            }
            return new com.baidu.swan.apps.api.b.b(0);
        }
    }

    public static void a(final e eVar, Activity activity, JSONObject jSONObject, final CallbackHandler callbackHandler, final String str) {
        final a aVar = new a(jSONObject);
        eVar.aaz().a(activity, aVar, (Bundle) null, new com.baidu.swan.apps.as.d.b<h<e.c>>() { // from class: com.baidu.swan.apps.api.module.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void B(h<e.c> hVar) {
                if (!hVar.isOk()) {
                    int errorCode = hVar.getErrorCode();
                    com.baidu.swan.apps.console.c.w("Api-Login", errorCode + HanziToPinyin.Token.SEPARATOR + a.this.toString());
                    String fX = com.baidu.swan.apps.setting.oauth.c.fX(errorCode);
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(errorCode, fX).toString());
                    com.baidu.swan.games.u.c.f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(errorCode, fX).toString());
                    b.a(eVar, 43, errorCode, fX);
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

    /* loaded from: classes10.dex */
    public static class a {
        public final boolean aYM;
        public final long aYN;

        public a(@NonNull JSONObject jSONObject) {
            this.aYM = jSONObject.has("timeout");
            this.aYN = jSONObject.optLong("timeout", 0L);
            if (this.aYN < 0) {
                com.baidu.swan.apps.console.c.w("Api-Login", "timeout is a minus：" + toString());
            }
        }

        public String toString() {
            return "LoginTimeoutConfig{enableTimeout=" + this.aYM + ", timeoutMills=" + this.aYN + '}';
        }
    }

    public static void a(com.baidu.swan.apps.runtime.e eVar, int i, int i2, String str) {
        int Ed;
        if (eVar != null && (Ed = eVar.Ed()) == 0) {
            d lz = new d().e(new com.baidu.swan.apps.ap.a().aE(5L).aF(i)).a(eVar.En()).ly(f.gb(Ed)).lz(com.baidu.swan.apps.runtime.e.aar());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(TiebaInitialize.LogFields.ERROR_CODE, i2);
                jSONObject.put("errorMessage", str);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            lz.aZ(jSONObject);
            f.b(lz);
        }
    }
}
