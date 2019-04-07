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
    private SwanAppGlobalJsBridge baE;
    private SwanAppJsBridge baF;
    private SwanAppUtilsJavaScriptInterface baG;
    private UnitedSchemeMainDispatcher mMainDispatcher;

    public void a(com.baidu.swan.games.e.a aVar, Context context) {
        this.mMainDispatcher = new UnitedSchemeMainDispatcher();
        this.baE = new SwanAppGlobalJsBridge(context, this.mMainDispatcher, aVar);
        aVar.addJavascriptInterface(this.baE, SwanAppGlobalJsBridge.JAVASCRIPT_INTERFACE_NAME);
        this.baF = new SwanAppJsBridge(context, this.mMainDispatcher, aVar);
        aVar.addJavascriptInterface(this.baF, SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
        e.a(this.mMainDispatcher);
        this.baG = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.baG.setSource("swan_");
        aVar.addJavascriptInterface(this.baG, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
    }

    public void P(Activity activity) {
        if (this.baE != null) {
            this.baE.setActivityRef(activity);
        }
        if (this.baF != null) {
            this.baF.setActivityRef(activity);
        }
        if (this.baG != null) {
            this.baG.setActivity(activity);
        }
    }
}
