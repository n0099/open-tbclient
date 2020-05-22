package com.baidu.swan.apps.c.a.b.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends aa {
    public a(j jVar) {
        super(jVar, "/swanAPI/setSelectedAddressSync");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            com.baidu.swan.apps.console.c.i("SetSelectedAddressSync", "framework error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null || optParamsAsJo.length() <= 0) {
            com.baidu.swan.apps.console.c.i("SetSelectedAddressSync", "empty params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        String optString = optParamsAsJo.optString(BaseJsonData.TAG_ERRNO);
        if (!TextUtils.equals(optString, "0")) {
            com.baidu.swan.apps.console.c.i("SetSelectedAddressSync", "error no" + optString);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "error no" + optString);
            return false;
        }
        JSONObject optJSONObject = optParamsAsJo.optJSONObject("data");
        if (optJSONObject == null || optJSONObject.length() <= 0) {
            com.baidu.swan.apps.console.c.i("SetSelectedAddressSync", "address data is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "data is empty");
            return false;
        }
        ad(optJSONObject);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    private void ad(JSONObject jSONObject) {
        d.TN().ab(jSONObject);
        aj.p(new Runnable() { // from class: com.baidu.swan.apps.c.a.b.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                c.Zg();
            }
        });
    }
}
