package com.baidu.swan.games.f;

import android.support.annotation.NonNull;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
/* loaded from: classes25.dex */
public class c extends com.baidu.swan.games.f.a {

    /* loaded from: classes25.dex */
    public static class a {
        @V8JavascriptField
        public String basePath;
        @V8JavascriptField
        public Object config;
    }

    public c(@NonNull String str, @NonNull com.baidu.swan.games.f.d.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        super(str, bVar, v8ThreadDelegatePolicy);
    }

    @Override // com.baidu.swan.games.f.a
    @NonNull
    public EventTarget aXf() {
        b bVar = new b(this, this.dYM.getInitBasePath());
        bVar.env.config = com.baidu.swan.apps.swancore.a.a.aNy();
        return bVar;
    }

    @Override // com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    public int getInvokeSourceType() {
        return 0;
    }

    /* loaded from: classes25.dex */
    public static class b extends EventTargetImpl {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private com.baidu.swan.games.f.b dWl;
        private com.baidu.swan.games.i.e dXT;
        @V8JavascriptField
        public a env;

        public b(com.baidu.swan.games.f.b bVar, String str) {
            super(bVar);
            this.dWl = bVar;
            this.env = new a();
            this.env.basePath = str;
        }

        @JavascriptInterface
        public com.baidu.swan.games.i.e getFileSystemManager() {
            if (this.dXT == null) {
                this.dXT = new com.baidu.swan.games.i.e((com.baidu.swan.games.f.a) this.dWl);
            }
            return this.dXT;
        }

        @JavascriptInterface
        public String getEnvVariables() {
            return com.baidu.swan.apps.jsbridge.a.b.f(this.dWl);
        }

        @JavascriptInterface
        public String getAPIs(int i) {
            if (DEBUG) {
                return com.baidu.swan.apps.ad.a.a.aHt() ? com.baidu.swan.apps.ap.i.C(i, true) : "";
            } else if (!com.baidu.swan.apps.ap.i.aOM()) {
                return "";
            } else {
                return com.baidu.swan.apps.ap.i.C(i, true);
            }
        }
    }
}
