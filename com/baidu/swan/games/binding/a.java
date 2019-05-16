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
    private SwanAppGlobalJsBridge beA;
    private SwanAppJsBridge beB;
    private SwanAppUtilsJavaScriptInterface beC;
    private UnitedSchemeMainDispatcher mMainDispatcher;

    public void a(com.baidu.swan.games.e.a aVar, Context context) {
        this.mMainDispatcher = new UnitedSchemeMainDispatcher();
        this.beA = new SwanAppGlobalJsBridge(context, this.mMainDispatcher, aVar);
        aVar.addJavascriptInterface(this.beA, SwanAppGlobalJsBridge.JAVASCRIPT_INTERFACE_NAME);
        this.beB = new SwanAppJsBridge(context, this.mMainDispatcher, aVar);
        aVar.addJavascriptInterface(this.beB, SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
        e.a(this.mMainDispatcher);
        this.beC = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.beC.setSource("swan_");
        aVar.addJavascriptInterface(this.beC, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
    }

    public void R(Activity activity) {
        if (this.beA != null) {
            this.beA.setActivityRef(activity);
        }
        if (this.beB != null) {
            this.beB.setActivityRef(activity);
        }
        if (this.beC != null) {
            this.beC.setActivity(activity);
        }
    }
}
