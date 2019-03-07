package com.baidu.swan.apps.setting.a;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.y;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g extends y {
    public g(j jVar) {
        super(jVar, "/swan/login");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (bVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        final String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            return false;
        }
        final a aVar = new a(optParamsAsJo);
        bVar.Jb().a((Activity) context, aVar, null, new com.baidu.swan.apps.an.c.a<com.baidu.swan.apps.setting.oauth.g<e.c>>() { // from class: com.baidu.swan.apps.setting.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.c.a
            /* renamed from: a */
            public void D(com.baidu.swan.apps.setting.oauth.g<e.c> gVar) {
                if (!gVar.isOk()) {
                    com.baidu.swan.apps.console.c.w("LoginAction", gVar.getErrorCode() + " " + aVar.toString());
                    String errMessage = com.baidu.swan.apps.setting.oauth.c.getErrMessage(gVar.getErrorCode());
                    if (!TextUtils.isEmpty(errMessage)) {
                        callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(gVar.getErrorCode(), errMessage).toString());
                    } else {
                        callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(gVar.getErrorCode()).toString());
                    }
                } else if (TextUtils.isEmpty(gVar.mData.code)) {
                    callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
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
                    }
                }
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public final boolean aQV;
        public final long aQW;

        public a(@NonNull JSONObject jSONObject) {
            this.aQV = jSONObject.has("timeout");
            this.aQW = jSONObject.optLong("timeout", 0L);
            if (this.aQW < 0) {
                com.baidu.swan.apps.console.c.w("LoginAction", "timeout is a minus：" + toString());
            }
        }

        public String toString() {
            return "LoginTimeoutConfig{enableTimeout=" + this.aQV + ", timeoutMills=" + this.aQW + '}';
        }
    }
}
