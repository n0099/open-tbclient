package com.baidu.swan.apps.aj.f.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ae.b;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends z {
    public a(j jVar) {
        super(jVar, "/swan/memoryWarning");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b bVar) {
        if (context == null || callbackHandler == null || bVar == null) {
            c.e("MemoryWarningAction", "execute fail");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            c.e("MemoryWarningAction", "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            c.e("MemoryWarningAction", "callback is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        b(context, callbackHandler, optString);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    public void b(Context context, final CallbackHandler callbackHandler, final String str) {
        com.baidu.swan.apps.aj.f.b vR;
        if ((context instanceof com.baidu.swan.apps.aj.f.c) && (vR = ((com.baidu.swan.apps.aj.f.c) context).vR()) != null) {
            vR.a(new com.baidu.swan.apps.aj.f.a() { // from class: com.baidu.swan.apps.aj.f.a.a.1
                @Override // com.baidu.swan.apps.aj.f.a
                public void es(int i) {
                    c.i("MemoryWarningAction", "trimMemory consume level:" + i);
                    if (i == 10 || i == 15) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("level", i);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                    }
                }
            });
        }
    }
}
