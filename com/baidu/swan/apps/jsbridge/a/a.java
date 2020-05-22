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
/* loaded from: classes11.dex */
public class a {
    private com.baidu.swan.apps.jsbridge.a cgZ;
    private com.baidu.swan.apps.jsbridge.a cha;
    private SwanAppUtilsJavaScriptInterface chb;
    private com.baidu.swan.apps.api.a chc;

    public void a(com.baidu.swan.apps.core.container.a aVar, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher) {
        if (aVar != null && context != null && callbackHandler != null && unitedSchemeMainDispatcher != null) {
            this.chc = new com.baidu.swan.apps.api.a(context, callbackHandler, aVar);
            a(aVar, context, callbackHandler, unitedSchemeMainDispatcher, this.chc);
            if (aVar instanceof com.baidu.swan.games.f.b) {
                a(aVar, context, this.chc);
            } else {
                e(aVar);
            }
        }
    }

    public void a(Context context, com.baidu.swan.apps.core.container.a aVar) {
        this.chb = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.chb.setSource("swan_");
        aVar.addJavascriptInterface(this.chb, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
        this.chb.setForceShareLight(true);
    }

    private void a(com.baidu.swan.apps.core.container.a aVar, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, @NonNull com.baidu.swan.apps.api.a aVar2) {
        this.cgZ = new SwanAppGlobalJsBridge(context, unitedSchemeMainDispatcher, callbackHandler);
        aVar.addJavascriptInterface(this.cgZ, SwanAppGlobalJsBridge.JAVASCRIPT_INTERFACE_NAME);
        this.cha = new SwanAppJsBridge(context, unitedSchemeMainDispatcher, callbackHandler);
        aVar.addJavascriptInterface(this.cha, SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
        aVar.addJavascriptInterface(new SwanAppPreloadJsBridge(aVar), SwanAppPreloadJsBridge.JAVASCRIPT_INTERFACE_NAME);
        aVar2.a(aVar);
    }

    private void e(com.baidu.swan.apps.core.container.a aVar) {
        aVar.addJavascriptInterface(new SwanAppNativeSwanJsBridge(), SwanAppNativeSwanJsBridge.JAVASCRIPT_INTERFACE_NAME);
    }

    private void a(@NonNull com.baidu.swan.apps.core.container.a aVar, Context context, @NonNull com.baidu.swan.apps.api.a aVar2) {
        this.chb = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.chb.setSource("swan_");
        aVar.addJavascriptInterface(this.chb, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
        aVar2.c(aVar);
    }

    public void E(Activity activity) {
        if (this.cgZ != null) {
            this.cgZ.setActivityRef(activity);
        }
        if (this.cha != null) {
            this.cha.setActivityRef(activity);
        }
        if (this.chb != null) {
            this.chb.setActivity(activity);
        }
        if (this.chc != null) {
            this.chc.setActivityRef(activity);
        }
    }
}
