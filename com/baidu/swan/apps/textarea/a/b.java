package com.baidu.swan.apps.textarea.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.textarea.c.b;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends z {
    private HashMap<String, String> mCallbackMap;

    public b(j jVar) {
        super(jVar, "/swan/openTextarea");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            Log.d("OpenTextAreaAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.apps.console.c.d("OpenTextAreaAction", "OpenTextAreaAction paramsJson: " + optParamsAsJo);
        String optString = optParamsAsJo.optString("inputId");
        String optString2 = optParamsAsJo.optString("slaveId");
        String optString3 = optParamsAsJo.optString("cb");
        if (this.mCallbackMap == null) {
            this.mCallbackMap = new HashMap<>();
        }
        this.mCallbackMap.put(optString, optString3);
        if (!com.baidu.swan.apps.textarea.c.a.OS().ib(optString2).a(new b.a() { // from class: com.baidu.swan.apps.textarea.a.b.1
            @Override // com.baidu.swan.apps.textarea.c.b.a
            public void d(String str, JSONObject jSONObject) {
                b.this.a(str, callbackHandler, 0, jSONObject);
            }
        }, context, optParamsAsJo)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, CallbackHandler callbackHandler, int i, JSONObject jSONObject) {
        if (DEBUG) {
            Log.d("OpenTextAreaAction", "sendAsyncCallback, arg0: " + i + ", arg1: " + jSONObject);
        }
        com.baidu.swan.apps.console.c.d("OpenTextAreaAction", "sendAsyncCallback, arg0: " + i + ", arg1: " + jSONObject);
        String str2 = this.mCallbackMap.get(str);
        if (!TextUtils.isEmpty(str2)) {
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
        }
    }
}
