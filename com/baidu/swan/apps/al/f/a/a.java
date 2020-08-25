package com.baidu.swan.apps.al.f.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.al.f.b;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends aa {
    public a(j jVar) {
        super(jVar, "/swanAPI/memoryWarning");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (context == null || callbackHandler == null || eVar == null) {
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
        b Yb;
        if ((context instanceof com.baidu.swan.apps.al.f.c) && (Yb = ((com.baidu.swan.apps.al.f.c) context).Yb()) != null) {
            Yb.a(new com.baidu.swan.apps.al.f.a() { // from class: com.baidu.swan.apps.al.f.a.a.1
                @Override // com.baidu.swan.apps.al.f.a
                public void ka(int i) {
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
