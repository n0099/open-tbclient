package com.baidu.swan.games.binding;

import android.app.Activity;
import android.content.Context;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.swan.apps.jsbridge.SwanAppGlobalJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppUtilsJavaScriptInterface;
import com.baidu.swan.apps.scheme.e;
/* loaded from: classes2.dex */
public final class a {
    private SwanAppGlobalJsBridge bxN;
    private SwanAppJsBridge bxO;
    private SwanAppUtilsJavaScriptInterface bxP;
    private UnitedSchemeMainDispatcher mMainDispatcher;

    public void a(com.baidu.swan.games.e.a aVar, Context context) {
        this.mMainDispatcher = new UnitedSchemeMainDispatcher();
        this.bxN = new SwanAppGlobalJsBridge(context, this.mMainDispatcher, aVar);
        aVar.addJavascriptInterface(this.bxN, SwanAppGlobalJsBridge.JAVASCRIPT_INTERFACE_NAME);
        this.bxO = new SwanAppJsBridge(context, this.mMainDispatcher, aVar);
        aVar.addJavascriptInterface(this.bxO, SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
        e.a(this.mMainDispatcher);
        this.bxP = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.bxP.setSource("swan_");
        aVar.addJavascriptInterface(this.bxP, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
    }

    public void T(Activity activity) {
        if (this.bxN != null) {
            this.bxN.setActivityRef(activity);
        }
        if (this.bxO != null) {
            this.bxO.setActivityRef(activity);
        }
        if (this.bxP != null) {
            this.bxP.setActivity(activity);
        }
    }
}
