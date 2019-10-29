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
    private SwanAppGlobalJsBridge byE;
    private SwanAppJsBridge byF;
    private SwanAppUtilsJavaScriptInterface byG;
    private UnitedSchemeMainDispatcher mMainDispatcher;

    public void a(com.baidu.swan.games.e.a aVar, Context context) {
        this.mMainDispatcher = new UnitedSchemeMainDispatcher();
        this.byE = new SwanAppGlobalJsBridge(context, this.mMainDispatcher, aVar);
        aVar.addJavascriptInterface(this.byE, SwanAppGlobalJsBridge.JAVASCRIPT_INTERFACE_NAME);
        this.byF = new SwanAppJsBridge(context, this.mMainDispatcher, aVar);
        aVar.addJavascriptInterface(this.byF, SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
        e.a(this.mMainDispatcher);
        this.byG = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.byG.setSource("swan_");
        aVar.addJavascriptInterface(this.byG, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
    }

    public void T(Activity activity) {
        if (this.byE != null) {
            this.byE.setActivityRef(activity);
        }
        if (this.byF != null) {
            this.byF.setActivityRef(activity);
        }
        if (this.byG != null) {
            this.byG.setActivity(activity);
        }
    }
}
