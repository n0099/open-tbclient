package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class w extends y {
    public w(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/preventPullDownRefresh");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            Log.d("PreventPullDownRefresh", "handle entity: " + unitedSchemeEntity.toString());
        }
        JSONObject c = c(unitedSchemeEntity, LegoListActivityConfig.PARAMS);
        if (c == null) {
            com.baidu.swan.apps.console.c.e("preventPullDownRefresh", "none params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none params");
            return false;
        }
        String optString = c.optString("slaveId");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("preventPullDownRefresh", "slaveId null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "slaveId null");
            return false;
        }
        com.baidu.swan.apps.b.c.e ee = com.baidu.swan.apps.w.e.Ec().ee(optString);
        if (!(ee instanceof com.baidu.swan.apps.b.c.c)) {
            com.baidu.swan.apps.console.c.e("preventPullDownRefresh", "webViewManager not a SwanAppSlaveManager");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "webViewManager not a SwanAppSlaveManager");
            return false;
        }
        boolean optBoolean = c.optBoolean("prevent", false);
        PullToRefreshBaseWebView vW = ((com.baidu.swan.apps.b.c.c) ee).vW();
        if (vW != null) {
            vW.setIsPreventPullToRefresh(optBoolean);
        }
        return true;
    }
}
