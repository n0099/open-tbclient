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
    private SwanAppGlobalJsBridge baF;
    private SwanAppJsBridge baG;
    private SwanAppUtilsJavaScriptInterface baH;
    private UnitedSchemeMainDispatcher mMainDispatcher;

    public void a(com.baidu.swan.games.e.a aVar, Context context) {
        this.mMainDispatcher = new UnitedSchemeMainDispatcher();
        this.baF = new SwanAppGlobalJsBridge(context, this.mMainDispatcher, aVar);
        aVar.addJavascriptInterface(this.baF, SwanAppGlobalJsBridge.JAVASCRIPT_INTERFACE_NAME);
        this.baG = new SwanAppJsBridge(context, this.mMainDispatcher, aVar);
        aVar.addJavascriptInterface(this.baG, SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
        e.a(this.mMainDispatcher);
        this.baH = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.baH.setSource("swan_");
        aVar.addJavascriptInterface(this.baH, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
    }

    public void P(Activity activity) {
        if (this.baF != null) {
            this.baF.setActivityRef(activity);
        }
        if (this.baG != null) {
            this.baG.setActivityRef(activity);
        }
        if (this.baH != null) {
            this.baH.setActivity(activity);
        }
    }
}
