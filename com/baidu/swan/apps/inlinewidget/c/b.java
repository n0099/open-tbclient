package com.baidu.swan.apps.inlinewidget.c;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.v.f;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class b extends aa {
    protected abstract boolean a(@NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull com.baidu.swan.apps.inlinewidget.e.b bVar, @NonNull List<String> list);

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(j jVar, String str) {
        super(jVar, str);
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            com.baidu.swan.apps.console.c.e("componentFullScreen", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (DEBUG) {
                Log.e("SwanAppAction", "getAutoRotationSync --- illegal swanApp");
                return false;
            }
            return false;
        } else if (context == null) {
            com.baidu.swan.apps.console.c.e("componentFullScreen", "none context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
            if (DEBUG) {
                Log.e("SwanAppAction", "getAutoRotationSync --- illegal context");
                return false;
            }
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                com.baidu.swan.apps.console.c.e("componentFullScreen", "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            String optString = optParamsAsJo.optString("slaveId");
            JSONArray optJSONArray = optParamsAsJo.optJSONArray("componentId");
            if (TextUtils.isEmpty(optString) || optJSONArray == null || optJSONArray.length() == 0) {
                com.baidu.swan.apps.console.c.e("componentFullScreen", "param error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                String optString2 = optJSONArray.optString(i);
                if (!TextUtils.isEmpty(optString2)) {
                    arrayList.add(optString2);
                }
            }
            if (arrayList.size() == 0) {
                com.baidu.swan.apps.console.c.e("componentFullScreen", "empty component id list");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            com.baidu.swan.apps.adaptation.b.e mn = f.asJ().mn(optString);
            if (!(mn instanceof SwanAppWebViewManager)) {
                com.baidu.swan.apps.console.c.e("componentFullScreen", "cant get WebView");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            com.baidu.swan.apps.inlinewidget.e.b agf = ((SwanAppWebViewManager) mn).agf();
            if (agf == null) {
                com.baidu.swan.apps.console.c.e("componentFullScreen", "cant get CustomViewHelper");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (!a(unitedSchemeEntity, agf, arrayList)) {
                com.baidu.swan.apps.console.c.e("componentFullScreen", "custom view handle fail");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
                return true;
            }
        }
    }
}
