package com.baidu.swan.apps.setting.a;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g extends z {
    public g(j jVar) {
        super(jVar, "/swan/login");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (bVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            com.baidu.swan.games.r.c.e(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            com.baidu.swan.games.r.c.e(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
            return false;
        }
        final String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            com.baidu.swan.games.r.c.e(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
            return false;
        }
        final a aVar = new a(optParamsAsJo);
        bVar.Rd().a((Activity) context, aVar, null, new com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.setting.oauth.g<e.c>>() { // from class: com.baidu.swan.apps.setting.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: a */
            public void B(com.baidu.swan.apps.setting.oauth.g<e.c> gVar) {
                if (!gVar.isOk()) {
                    com.baidu.swan.apps.console.c.w("LoginAction", gVar.getErrorCode() + HanziToPinyin.Token.SEPARATOR + aVar.toString());
                    String errMessage = com.baidu.swan.apps.setting.oauth.c.getErrMessage(gVar.getErrorCode());
                    if (!TextUtils.isEmpty(errMessage)) {
                        callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(gVar.getErrorCode(), errMessage).toString());
                        com.baidu.swan.games.r.c.e(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(gVar.getErrorCode(), errMessage).toString());
                        return;
                    }
                    callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(gVar.getErrorCode()).toString());
                    com.baidu.swan.games.r.c.e(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(gVar.getErrorCode()).toString());
                } else if (TextUtils.isEmpty(gVar.mData.code)) {
                    callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    com.baidu.swan.games.r.c.e(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                } else {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("code", gVar.mData.code);
                        callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(jSONObject, gVar.getErrorCode()).toString());
                    } catch (JSONException e) {
                        if (g.DEBUG) {
                            e.printStackTrace();
                        }
                        callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                        com.baidu.swan.games.r.c.e(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                    }
                }
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public final boolean boa;
        public final long bob;

        public a(@NonNull JSONObject jSONObject) {
            this.boa = jSONObject.has("timeout");
            this.bob = jSONObject.optLong("timeout", 0L);
            if (this.bob < 0) {
                com.baidu.swan.apps.console.c.w("LoginAction", "timeout is a minus：" + toString());
            }
        }

        public String toString() {
            return "LoginTimeoutConfig{enableTimeout=" + this.boa + ", timeoutMills=" + this.bob + '}';
        }
    }
}
