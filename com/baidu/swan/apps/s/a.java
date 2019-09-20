package com.baidu.swan.apps.s;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends z {
    public a(j jVar) {
        super(jVar, "/swan/chooseInvoiceTitle");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.ae.b bVar) {
        c.i("chooseInvoiceTitle", "发票调起");
        if (bVar == null) {
            c.e("chooseInvoiceTitle", "empty swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        } else if (TextUtils.isEmpty(bVar.getAppKey())) {
            c.e("chooseInvoiceTitle", "empty clientId");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty clientId");
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                c.e("chooseInvoiceTitle", "empty joParams");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
                return false;
            }
            final String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.e("chooseInvoiceTitle", "empty cb");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                return false;
            } else if (!(context instanceof Activity)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
                return false;
            } else {
                bVar.Ml().a((Activity) context, "mapp_choose_invoice", new com.baidu.swan.apps.an.d.a<Boolean>() { // from class: com.baidu.swan.apps.s.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.an.d.a
                    /* renamed from: b */
                    public void D(Boolean bool) {
                        if (bool.booleanValue()) {
                            c.i("chooseInvoiceTitle", OAuthResult.RESULT_MSG_SUCCESS);
                            a.this.a(context, callbackHandler, unitedSchemeEntity, bVar, optString);
                            return;
                        }
                        c.i("chooseInvoiceTitle", OAuthResult.ERROR_MSG_UNKNOWN);
                        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "Permission denied").toString(), optString);
                    }
                });
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, final CallbackHandler callbackHandler, final UnitedSchemeEntity unitedSchemeEntity, com.baidu.swan.apps.ae.b bVar, final String str) {
        com.baidu.swan.apps.u.a.Ev().a(context, bVar.id, bVar.getAppKey(), new b() { // from class: com.baidu.swan.apps.s.a.2
            @Override // com.baidu.swan.apps.s.b
            public void r(JSONObject jSONObject) {
                c.i("chooseInvoiceTitle", "选择成功");
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString(), str);
            }

            @Override // com.baidu.swan.apps.s.b
            public void bP(int i) {
                String jSONObject;
                if (i == 1) {
                    c.i("chooseInvoiceTitle", "取消选择");
                    jSONObject = UnitedSchemeUtility.wrapCallbackParams(1002, "choose canceled").toString();
                } else {
                    c.i("chooseInvoiceTitle", "选择失败");
                    jSONObject = UnitedSchemeUtility.wrapCallbackParams(1003, "choose failed").toString();
                }
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, jSONObject, str);
            }
        });
    }
}
