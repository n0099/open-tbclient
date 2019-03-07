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
    private SwanAppGlobalJsBridge baA;
    private SwanAppJsBridge baB;
    private SwanAppUtilsJavaScriptInterface baC;
    private UnitedSchemeMainDispatcher mMainDispatcher;

    public void a(com.baidu.swan.games.e.a aVar, Context context) {
        this.mMainDispatcher = new UnitedSchemeMainDispatcher();
        this.baA = new SwanAppGlobalJsBridge(context, this.mMainDispatcher, aVar);
        aVar.addJavascriptInterface(this.baA, SwanAppGlobalJsBridge.JAVASCRIPT_INTERFACE_NAME);
        this.baB = new SwanAppJsBridge(context, this.mMainDispatcher, aVar);
        aVar.addJavascriptInterface(this.baB, SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
        e.a(this.mMainDispatcher);
        this.baC = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.baC.setSource("swan_");
        aVar.addJavascriptInterface(this.baC, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
    }

    public void P(Activity activity) {
        if (this.baA != null) {
            this.baA.setActivityRef(activity);
        }
        if (this.baB != null) {
            this.baB.setActivityRef(activity);
        }
        if (this.baC != null) {
            this.baC.setActivity(activity);
        }
    }
}
