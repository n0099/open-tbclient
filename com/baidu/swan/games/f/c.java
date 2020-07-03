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
    public EventTarget aAA() {
        b bVar = new b(this, this.dbg.getInitBasePath());
        bVar.env.config = com.baidu.swan.apps.swancore.a.a.atc();
        return bVar;
    }

    @Override // com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    public int getInvokeSourceType() {
        return 0;
    }

    /* loaded from: classes11.dex */
    public static class b extends EventTargetImpl {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private com.baidu.swan.games.f.b cYE;
        private com.baidu.swan.games.i.e dal;
        @V8JavascriptField
        public a env;

        public b(com.baidu.swan.games.f.b bVar, String str) {
            super(bVar);
            this.cYE = bVar;
            this.env = new a();
            this.env.basePath = str;
        }

        @JavascriptInterface
        public com.baidu.swan.games.i.e getFileSystemManager() {
            if (this.dal == null) {
                this.dal = new com.baidu.swan.games.i.e((com.baidu.swan.games.f.a) this.cYE);
            }
            return this.dal;
        }

        @JavascriptInterface
        public String getEnvVariables() {
            return com.baidu.swan.apps.jsbridge.a.b.getEnvVariables();
        }

        @JavascriptInterface
        public String getAPIs(int i) {
            return DEBUG ? com.baidu.swan.apps.af.a.a.anz() ? com.baidu.swan.apps.aq.h.A(i, true) : "" : (com.baidu.swan.apps.aq.h.auo() && com.baidu.swan.apps.u.a.aga().Sn()) ? com.baidu.swan.apps.aq.h.A(i, true) : "";
        }
    }
}
