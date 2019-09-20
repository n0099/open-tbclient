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
    private SwanAppGlobalJsBridge bfL;
    private SwanAppJsBridge bfM;
    private SwanAppUtilsJavaScriptInterface bfN;
    private UnitedSchemeMainDispatcher mMainDispatcher;

    public void a(com.baidu.swan.games.e.a aVar, Context context) {
        this.mMainDispatcher = new UnitedSchemeMainDispatcher();
        this.bfL = new SwanAppGlobalJsBridge(context, this.mMainDispatcher, aVar);
        aVar.addJavascriptInterface(this.bfL, SwanAppGlobalJsBridge.JAVASCRIPT_INTERFACE_NAME);
        this.bfM = new SwanAppJsBridge(context, this.mMainDispatcher, aVar);
        aVar.addJavascriptInterface(this.bfM, SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
        e.a(this.mMainDispatcher);
        this.bfN = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.bfN.setSource("swan_");
        aVar.addJavascriptInterface(this.bfN, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
    }

    public void U(Activity activity) {
        if (this.bfL != null) {
            this.bfL.setActivityRef(activity);
        }
        if (this.bfM != null) {
            this.bfM.setActivityRef(activity);
        }
        if (this.bfN != null) {
            this.bfN.setActivity(activity);
        }
    }
}
