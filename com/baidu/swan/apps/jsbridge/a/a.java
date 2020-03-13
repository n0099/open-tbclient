package com.baidu.swan.apps.jsbridge.a;

import android.app.Activity;
import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.swan.apps.jsbridge.SwanAppGlobalJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppNativeSwanJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppPreloadJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppUtilsJavaScriptInterface;
/* loaded from: classes11.dex */
public class a {
    private com.baidu.swan.apps.jsbridge.a byc;
    private com.baidu.swan.apps.jsbridge.a byd;
    private SwanAppUtilsJavaScriptInterface bye;
    private com.baidu.swan.apps.api.a byf;

    public void a(com.baidu.swan.apps.core.container.a aVar, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher) {
        if (aVar != null && context != null && callbackHandler != null && unitedSchemeMainDispatcher != null) {
            b(aVar, context, callbackHandler, unitedSchemeMainDispatcher);
            if (aVar instanceof com.baidu.swan.games.e.b) {
                a(aVar, context);
            } else {
                c(aVar);
            }
        }
    }

    public void a(Context context, com.baidu.swan.apps.core.container.a aVar) {
        this.bye = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.bye.setSource("swan_");
        aVar.addJavascriptInterface(this.bye, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
        this.bye.setForceShareLight(true);
    }

    private void b(com.baidu.swan.apps.core.container.a aVar, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher) {
        this.byc = new SwanAppGlobalJsBridge(context, unitedSchemeMainDispatcher, callbackHandler);
        aVar.addJavascriptInterface(this.byc, "Bdbox_android_jsbridge");
        this.byd = new SwanAppJsBridge(context, unitedSchemeMainDispatcher, callbackHandler);
        aVar.addJavascriptInterface(this.byd, SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
        aVar.addJavascriptInterface(new SwanAppPreloadJsBridge(aVar), SwanAppPreloadJsBridge.JAVASCRIPT_INTERFACE_NAME);
        this.byf = new com.baidu.swan.apps.api.a(context, callbackHandler, aVar);
        this.byf.a(aVar);
    }

    private void c(com.baidu.swan.apps.core.container.a aVar) {
        aVar.addJavascriptInterface(new SwanAppNativeSwanJsBridge(), SwanAppNativeSwanJsBridge.JAVASCRIPT_INTERFACE_NAME);
    }

    private void a(com.baidu.swan.apps.core.container.a aVar, Context context) {
        this.bye = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.bye.setSource("swan_");
        aVar.addJavascriptInterface(this.bye, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
    }

    public void H(Activity activity) {
        if (this.byc != null) {
            this.byc.setActivityRef(activity);
        }
        if (this.byd != null) {
            this.byd.setActivityRef(activity);
        }
        if (this.bye != null) {
            this.bye.setActivity(activity);
        }
        if (this.byf != null) {
            this.byf.setActivityRef(activity);
        }
    }
}
