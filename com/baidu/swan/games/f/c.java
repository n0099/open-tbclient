package com.baidu.swan.games.f;

import android.support.annotation.NonNull;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
/* loaded from: classes11.dex */
public class c extends com.baidu.swan.games.f.a {

    /* loaded from: classes11.dex */
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
    public EventTarget azu() {
        b bVar = new b(this, this.cWu.getInitBasePath());
        bVar.env.config = com.baidu.swan.apps.swancore.a.a.arV();
        return bVar;
    }

    @Override // com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    public int getInvokeSourceType() {
        return 0;
    }

    /* loaded from: classes11.dex */
    public static class b extends EventTargetImpl {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private com.baidu.swan.games.f.b cTU;
        private com.baidu.swan.games.i.e cVB;
        @V8JavascriptField
        public a env;

        public b(com.baidu.swan.games.f.b bVar, String str) {
            super(bVar);
            this.cTU = bVar;
            this.env = new a();
            this.env.basePath = str;
        }

        @JavascriptInterface
        public com.baidu.swan.games.i.e getFileSystemManager() {
            if (this.cVB == null) {
                this.cVB = new com.baidu.swan.games.i.e((com.baidu.swan.games.f.a) this.cTU);
            }
            return this.cVB;
        }

        @JavascriptInterface
        public String getEnvVariables() {
            return com.baidu.swan.apps.jsbridge.a.b.getEnvVariables();
        }

        @JavascriptInterface
        public String getAPIs(int i) {
            return DEBUG ? com.baidu.swan.apps.af.a.a.amt() ? com.baidu.swan.apps.aq.h.z(i, true) : "" : (com.baidu.swan.apps.aq.h.ati() && com.baidu.swan.apps.u.a.aeU().Rh()) ? com.baidu.swan.apps.aq.h.z(i, true) : "";
        }
    }
}
