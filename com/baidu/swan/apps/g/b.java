package com.baidu.swan.apps.g;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.an.o;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends z {
    private String mCallback;

    public b(j jVar) {
        super(jVar, "/swan/scanCode");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (bVar == null) {
            c.i("scanCode", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        this.mCallback = o.dP(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(this.mCallback)) {
            c.i("scanCode", "cb is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        com.baidu.swan.apps.u.a.Jr().a(bVar.getActivity(), new a() { // from class: com.baidu.swan.apps.g.b.1
            @Override // com.baidu.swan.apps.g.a
            public void onSuccess(String str, String str2, String str3) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("scanType", str2);
                    jSONObject.put("charSet", str3);
                    jSONObject.put("result", str);
                    c.i("scanCode", jSONObject.toString());
                    callbackHandler.handleSchemeDispatchCallback(b.this.mCallback, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                } catch (JSONException e) {
                    if (b.DEBUG) {
                        e.printStackTrace();
                    }
                    c.i("scanCode", "scanCode exec fail");
                    callbackHandler.handleSchemeDispatchCallback(b.this.mCallback, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                }
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }
}
