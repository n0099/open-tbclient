package com.baidu.swan.games.f;

import android.support.annotation.NonNull;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
/* loaded from: classes7.dex */
public class c extends com.baidu.swan.games.f.a {

    /* loaded from: classes7.dex */
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
    public EventTarget aEf() {
        b bVar = new b(this, this.dgP.getInitBasePath());
        bVar.env.config = com.baidu.swan.apps.swancore.a.a.avd();
        return bVar;
    }

    @Override // com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    public int getInvokeSourceType() {
        return 0;
    }

    /* loaded from: classes7.dex */
    public static class b extends EventTargetImpl {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private com.baidu.swan.games.f.b deo;
        private com.baidu.swan.games.i.e dfW;
        @V8JavascriptField
        public a env;

        public b(com.baidu.swan.games.f.b bVar, String str) {
            super(bVar);
            this.deo = bVar;
            this.env = new a();
            this.env.basePath = str;
        }

        @JavascriptInterface
        public com.baidu.swan.games.i.e getFileSystemManager() {
            if (this.dfW == null) {
                this.dfW = new com.baidu.swan.games.i.e((com.baidu.swan.games.f.a) this.deo);
            }
            return this.dfW;
        }

        @JavascriptInterface
        public String getEnvVariables() {
            return com.baidu.swan.apps.jsbridge.a.b.getEnvVariables();
        }

        @JavascriptInterface
        public String getAPIs(int i) {
            return DEBUG ? com.baidu.swan.apps.ae.a.a.apj() ? com.baidu.swan.apps.aq.i.z(i, true) : "" : (com.baidu.swan.apps.aq.i.awq() && com.baidu.swan.apps.t.a.ahm().SE()) ? com.baidu.swan.apps.aq.i.z(i, true) : "";
        }
    }
}
