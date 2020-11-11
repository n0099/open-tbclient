package com.baidu.swan.apps.jsbridge.a;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.swan.apps.jsbridge.SwanAppGlobalJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppNativeSwanJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppPreloadJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppUtilsJavaScriptInterface;
/* loaded from: classes10.dex */
public class a {
    private com.baidu.swan.apps.jsbridge.a cXX;
    private com.baidu.swan.apps.jsbridge.a cXY;
    private SwanAppUtilsJavaScriptInterface cXZ;
    private com.baidu.swan.apps.api.a cYa;

    public void a(com.baidu.swan.apps.core.container.a aVar, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher) {
        if (aVar != null && context != null && callbackHandler != null && unitedSchemeMainDispatcher != null) {
            this.cYa = new com.baidu.swan.apps.api.a(context, callbackHandler, aVar);
            a(aVar, context, callbackHandler, unitedSchemeMainDispatcher, this.cYa);
            if (aVar instanceof com.baidu.swan.games.f.b) {
                a(aVar, context, this.cYa);
            } else {
                e(aVar);
            }
        }
    }

    public void a(Context context, com.baidu.swan.apps.core.container.a aVar) {
        this.cXZ = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.cXZ.setSource("swan_");
        aVar.addJavascriptInterface(this.cXZ, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
        this.cXZ.setForceShareLight(true);
    }

    private void a(com.baidu.swan.apps.core.container.a aVar, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, @NonNull com.baidu.swan.apps.api.a aVar2) {
        this.cXX = new SwanAppGlobalJsBridge(context, unitedSchemeMainDispatcher, callbackHandler);
        aVar.addJavascriptInterface(this.cXX, SwanAppGlobalJsBridge.JAVASCRIPT_INTERFACE_NAME);
        this.cXY = new SwanAppJsBridge(context, unitedSchemeMainDispatcher, callbackHandler);
        aVar.addJavascriptInterface(this.cXY, SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
        aVar.addJavascriptInterface(new SwanAppPreloadJsBridge(aVar), SwanAppPreloadJsBridge.JAVASCRIPT_INTERFACE_NAME);
        aVar2.a(aVar);
    }

    private void e(com.baidu.swan.apps.core.container.a aVar) {
        aVar.addJavascriptInterface(new SwanAppNativeSwanJsBridge(aVar), SwanAppNativeSwanJsBridge.JAVASCRIPT_INTERFACE_NAME);
    }

    private void a(@NonNull com.baidu.swan.apps.core.container.a aVar, Context context, @NonNull com.baidu.swan.apps.api.a aVar2) {
        this.cXZ = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.cXZ.setSource("swan_");
        aVar.addJavascriptInterface(this.cXZ, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
        aVar2.c(aVar);
    }

    public void G(Activity activity) {
        if (this.cXX != null) {
            this.cXX.setActivityRef(activity);
        }
        if (this.cXY != null) {
            this.cXY.setActivityRef(activity);
        }
        if (this.cXZ != null) {
            this.cXZ.setActivity(activity);
        }
        if (this.cYa != null) {
            this.cYa.setActivityRef(activity);
        }
    }
}
