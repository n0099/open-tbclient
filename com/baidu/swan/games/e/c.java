package com.baidu.swan.games.e;

import android.support.annotation.NonNull;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
/* loaded from: classes2.dex */
public class c extends com.baidu.swan.games.e.a {

    /* loaded from: classes2.dex */
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
    public EventTarget RA() {
        b bVar = new b(this, this.bgh.Bc());
        bVar.env.config = com.baidu.swan.apps.swancore.b.a.Od();
        return bVar;
    }

    @Override // com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    public int getInvokeSourceType() {
        return 0;
    }

    /* loaded from: classes2.dex */
    public static class b extends EventTargetImpl {
        @V8JavascriptField
        public a env;

        public b(JSRuntime jSRuntime, String str) {
            super(jSRuntime);
            this.env = new a();
            this.env.basePath = str;
        }

        @JavascriptInterface
        public String getEnvVariables() {
            return com.baidu.swan.apps.jsbridge.a.a.getEnvVariables();
        }
    }
}
