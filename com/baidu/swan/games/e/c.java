package com.baidu.swan.games.e;

import android.support.annotation.NonNull;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
/* loaded from: classes9.dex */
public class c extends com.baidu.swan.games.e.a {

    /* loaded from: classes9.dex */
    public static class a {
        @V8JavascriptField
        public String basePath;
        @V8JavascriptField
        public Object config;
    }

    public c(@NonNull String str, @NonNull com.baidu.swan.games.e.d.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        super(str, bVar, v8ThreadDelegatePolicy);
    }

    @Override // com.baidu.swan.games.e.a
    @NonNull
    public EventTarget akG() {
        b bVar = new b(this, this.cia.getInitBasePath());
        bVar.env.config = com.baidu.swan.apps.swancore.b.a.acL();
        return bVar;
    }

    @Override // com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    public int getInvokeSourceType() {
        return 0;
    }

    /* loaded from: classes9.dex */
    public static class b extends EventTargetImpl {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        @V8JavascriptField
        public a env;

        public b(JSRuntime jSRuntime, String str) {
            super(jSRuntime);
            this.env = new a();
            this.env.basePath = str;
        }

        @JavascriptInterface
        public String getEnvVariables() {
            return com.baidu.swan.apps.jsbridge.a.b.getEnvVariables();
        }

        @JavascriptInterface
        public String getAPIs(int i) {
            return DEBUG ? com.baidu.swan.apps.ah.a.a.XS() ? com.baidu.swan.apps.as.g.t(i, true) : "" : (com.baidu.swan.apps.as.g.adS() && com.baidu.swan.apps.w.a.Rn().Es()) ? com.baidu.swan.apps.as.g.t(i, true) : "";
        }
    }
}
