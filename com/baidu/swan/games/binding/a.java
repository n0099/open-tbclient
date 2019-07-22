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
    private SwanAppGlobalJsBridge bfn;
    private SwanAppJsBridge bfo;
    private SwanAppUtilsJavaScriptInterface bfp;
    private UnitedSchemeMainDispatcher mMainDispatcher;

    public void a(com.baidu.swan.games.e.a aVar, Context context) {
        this.mMainDispatcher = new UnitedSchemeMainDispatcher();
        this.bfn = new SwanAppGlobalJsBridge(context, this.mMainDispatcher, aVar);
        aVar.addJavascriptInterface(this.bfn, SwanAppGlobalJsBridge.JAVASCRIPT_INTERFACE_NAME);
        this.bfo = new SwanAppJsBridge(context, this.mMainDispatcher, aVar);
        aVar.addJavascriptInterface(this.bfo, SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
        e.a(this.mMainDispatcher);
        this.bfp = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.bfp.setSource("swan_");
        aVar.addJavascriptInterface(this.bfp, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
    }

    public void U(Activity activity) {
        if (this.bfn != null) {
            this.bfn.setActivityRef(activity);
        }
        if (this.bfo != null) {
            this.bfo.setActivityRef(activity);
        }
        if (this.bfp != null) {
            this.bfp.setActivity(activity);
        }
    }
}
