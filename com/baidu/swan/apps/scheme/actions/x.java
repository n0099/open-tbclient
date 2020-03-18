package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class x extends ab {
    public x(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/preventPullDownRefresh");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (DEBUG) {
            Log.d("PreventPullDownRefresh", "handle entity: " + unitedSchemeEntity.toString());
        }
        JSONObject b = b(unitedSchemeEntity, "params");
        if (b == null) {
            com.baidu.swan.apps.console.c.e("preventPullDownRefresh", "none params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none params");
            return false;
        }
        String optString = b.optString("slaveId");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("preventPullDownRefresh", "slaveId null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "slaveId null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e hu = com.baidu.swan.apps.y.f.WV().hu(optString);
        if (!(hu instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("preventPullDownRefresh", "webViewManager not a SwanAppSlaveManager");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "webViewManager not a SwanAppSlaveManager");
            return false;
        }
        boolean optBoolean = b.optBoolean("prevent", false);
        PullToRefreshBaseWebView IL = ((com.baidu.swan.apps.adaptation.b.c) hu).IL();
        if (IL != null) {
            IL.setIsPreventPullToRefresh(optBoolean);
        }
        return true;
    }
}
