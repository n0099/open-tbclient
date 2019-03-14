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
    private SwanAppGlobalJsBridge baB;
    private SwanAppJsBridge baC;
    private SwanAppUtilsJavaScriptInterface baD;
    private UnitedSchemeMainDispatcher mMainDispatcher;

    public void a(com.baidu.swan.games.e.a aVar, Context context) {
        this.mMainDispatcher = new UnitedSchemeMainDispatcher();
        this.baB = new SwanAppGlobalJsBridge(context, this.mMainDispatcher, aVar);
        aVar.addJavascriptInterface(this.baB, SwanAppGlobalJsBridge.JAVASCRIPT_INTERFACE_NAME);
        this.baC = new SwanAppJsBridge(context, this.mMainDispatcher, aVar);
        aVar.addJavascriptInterface(this.baC, SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
        e.a(this.mMainDispatcher);
        this.baD = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.baD.setSource("swan_");
        aVar.addJavascriptInterface(this.baD, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
    }

    public void P(Activity activity) {
        if (this.baB != null) {
            this.baB.setActivityRef(activity);
        }
        if (this.baC != null) {
            this.baC.setActivityRef(activity);
        }
        if (this.baD != null) {
            this.baD.setActivity(activity);
        }
    }
}
