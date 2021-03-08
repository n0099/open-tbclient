package com.baidu.swan.apps.jsbridge.a;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.swan.apps.jsbridge.SwanAppGlobalJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppNativeSwanJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppPreloadJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppUtilsJavaScriptInterface;
/* loaded from: classes8.dex */
public class a {
    private com.baidu.swan.apps.jsbridge.a dhd;
    private com.baidu.swan.apps.jsbridge.a dhe;
    private SwanAppUtilsJavaScriptInterface dhf;
    private com.baidu.swan.apps.api.a dhg;

    public void a(com.baidu.swan.apps.core.container.a aVar, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher) {
        if (aVar != null && context != null && callbackHandler != null && unitedSchemeMainDispatcher != null) {
            this.dhg = new com.baidu.swan.apps.api.a(context, callbackHandler, aVar);
            a(aVar, context, callbackHandler, unitedSchemeMainDispatcher, this.dhg);
            if (aVar instanceof com.baidu.swan.games.f.b) {
                a(aVar, context, this.dhg);
            } else {
                e(aVar);
            }
        }
    }

    public void a(Context context, com.baidu.swan.apps.core.container.a aVar) {
        this.dhf = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.dhf.setSource("swan_");
        aVar.addJavascriptInterface(this.dhf, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
        this.dhf.setForceShareLight(true);
    }

    private void a(com.baidu.swan.apps.core.container.a aVar, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, @NonNull com.baidu.swan.apps.api.a aVar2) {
        this.dhd = new SwanAppGlobalJsBridge(context, unitedSchemeMainDispatcher, callbackHandler);
        aVar.addJavascriptInterface(this.dhd, SwanAppGlobalJsBridge.JAVASCRIPT_INTERFACE_NAME);
        this.dhe = new SwanAppJsBridge(context, unitedSchemeMainDispatcher, callbackHandler);
        aVar.addJavascriptInterface(this.dhe, SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
        aVar.addJavascriptInterface(new SwanAppPreloadJsBridge(aVar), SwanAppPreloadJsBridge.JAVASCRIPT_INTERFACE_NAME);
        aVar2.a(aVar);
    }

    private void e(com.baidu.swan.apps.core.container.a aVar) {
        aVar.addJavascriptInterface(new SwanAppNativeSwanJsBridge(aVar), SwanAppNativeSwanJsBridge.JAVASCRIPT_INTERFACE_NAME);
    }

    private void a(@NonNull com.baidu.swan.apps.core.container.a aVar, Context context, @NonNull com.baidu.swan.apps.api.a aVar2) {
        this.dhf = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.dhf.setSource("swan_");
        aVar.addJavascriptInterface(this.dhf, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
        aVar2.c(aVar);
    }

    public void y(Activity activity) {
        if (this.dhd != null) {
            this.dhd.setActivityRef(activity);
        }
        if (this.dhe != null) {
            this.dhe.setActivityRef(activity);
        }
        if (this.dhf != null) {
            this.dhf.setActivity(activity);
        }
        if (this.dhg != null) {
            this.dhg.setActivityRef(activity);
        }
    }
}
