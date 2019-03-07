package com.baidu.swan.games.e;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.ValueCallback;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.searchbox.v8engine.filesystem.V8FileSystemDelegatePolicy;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class a implements b {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    protected com.baidu.swan.games.e.d.b bbo;
    public final String bbp;
    private EventTarget bbq;
    private EventTarget bbr;
    private com.baidu.swan.games.e.b.a bbs;
    private com.baidu.swan.games.e.b.b bbt;
    private com.baidu.swan.games.e.a.a bbu;
    private List<JSEvent> bbv;
    private boolean bbw;
    private Context mContext;
    private int mCurState = 0;
    private boolean bbx = false;

    @NonNull
    public abstract EventTarget NQ();

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull String str, @NonNull com.baidu.swan.games.e.d.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        this.bbp = str;
        this.bbo = bVar;
        if (!TextUtils.isEmpty(Oa())) {
            this.bbq = NQ();
            this.bbr = NR();
            this.bbv = new ArrayList();
            onCreate();
        }
    }

    @NonNull
    public EventTarget NR() {
        return new EventTargetImpl(this);
    }

    public void NS() {
    }

    public void setFileSystemDelegatePolicy(V8FileSystemDelegatePolicy v8FileSystemDelegatePolicy) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void NT() {
        if (DEBUG) {
            Log.d("SwanAppV8Engine", "initEngine start.");
        }
        this.bbo.a(this);
        if (DEBUG) {
            Log.d("SwanAppV8Engine", "initEngine end.");
        }
    }

    public void finish() {
        if (!this.bbw) {
            if (DEBUG) {
                Log.d("SwanAppV8Engine", "finish called.");
            }
            this.bbw = true;
            onFinish();
        }
    }

    public boolean isFinishing() {
        return this.bbw;
    }

    @Override // com.baidu.swan.games.e.b
    public com.baidu.swan.games.e.b.b NU() {
        return this.bbt;
    }

    @Override // com.baidu.swan.games.e.b
    public EventTarget NV() {
        return this.bbq;
    }

    @Override // com.baidu.swan.games.e.b
    public EventTarget NW() {
        return this.bbr;
    }

    @Override // com.baidu.swan.games.e.b
    public com.baidu.swan.games.e.a.a NX() {
        return this.bbu;
    }

    public boolean dispatchEvent(final JSEvent jSEvent) {
        if (DEBUG) {
            Log.d("SwanAppV8Engine", "dispatchEvent event: " + (jSEvent != null ? jSEvent.type : ""));
        }
        if (this.bbq == null || !JSEvent.isValid(jSEvent)) {
            if (DEBUG) {
                Log.e("SwanAppV8Engine", "dispatchEvent globalObject or event is invalid.");
            }
            return false;
        }
        runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.e.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.isLoaded()) {
                    if (a.DEBUG) {
                        Log.d("SwanAppV8Engine", "dispatchEvent add to pending list.");
                    }
                    a.this.bbv.add(jSEvent);
                    return;
                }
                a.this.bbq.dispatchEvent(jSEvent);
            }
        });
        return true;
    }

    @Override // com.baidu.swan.games.e.b
    public void aS(String str, String str2) {
        this.bbs.aS(str, str2);
    }

    @Override // com.baidu.swan.apps.core.container.a
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        this.bbs.evaluateJavascript(str, valueCallback);
    }

    @Override // com.baidu.swan.apps.core.container.a
    public boolean isDestroyed() {
        return this.bbw;
    }

    public void addJavascriptInterface(@NonNull Object obj, @NonNull String str) {
        if (DEBUG) {
            Log.d("SwanAppV8Engine", "addJavascriptInterface object: " + obj + " ,name: " + str);
        }
        this.bbs.addJavascriptInterface(obj, str);
    }

    @Override // com.baidu.swan.games.e.b
    public void throwJSException(JSExceptionType jSExceptionType, String str) {
        this.bbs.throwJSException(jSExceptionType, str);
    }

    @Override // com.baidu.swan.games.e.b, com.baidu.searchbox.v8engine.JSRuntime
    public void runOnJSThread(Runnable runnable) {
        if (runnable == null) {
        }
    }

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    public void postOnJSThread(Runnable runnable) {
        if (runnable == null) {
        }
    }

    public void setUserAgent(String str) {
        if (!TextUtils.isEmpty(str) && DEBUG) {
            Log.d("SwanAppV8Engine", "setUserAgent: " + str);
        }
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public String getUrl() {
        if (this.bbo != null) {
            return this.bbo.zu();
        }
        return null;
    }

    @Override // com.baidu.swan.games.e.b
    public boolean post(Runnable runnable) {
        runOnJSThread(runnable);
        return true;
    }

    public void a(@NonNull V8Engine.V8EngineConsole v8EngineConsole) {
    }

    public void a(@NonNull V8Engine.JavaScriptExceptionDelegate javaScriptExceptionDelegate) {
    }

    public String EV() {
        return "[" + this.bbp + "] : ";
    }

    private d NY() {
        return d.Ob();
    }

    private void onCreate() {
        NY().d(this);
        this.mCurState = 1;
    }

    public void onPause() {
        NY().e(this);
        this.mCurState = 4;
    }

    public void onResume() {
        NY().f(this);
        this.mCurState = 5;
    }

    private void onFinish() {
        NY().g(this);
        this.mCurState = 6;
    }

    public boolean isLoaded() {
        return this.bbx;
    }

    @Override // com.baidu.swan.apps.core.container.a
    public boolean xS() {
        return false;
    }

    public boolean NZ() {
        return this.mCurState == 7;
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public void handleSchemeDispatchCallback(String str, String str2) {
        String quote;
        if (isFinishing()) {
            if (DEBUG) {
                Log.e("SwanAppV8Engine", Log.getStackTraceString(new Exception("engine isFinishing.")));
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            quote = "";
        } else {
            quote = JSONObject.quote(str2);
        }
        evaluateJavascript(str + "(" + quote + ");", null);
        if (DEBUG) {
            Log.d("SwanAppV8Engine", "handleSchemeDispatchCallback callback " + str + " ,params: " + str2);
        }
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public String getCurrentPageUrl() {
        return null;
    }

    protected String Oa() {
        return this.bbo.zu();
    }

    @Override // com.baidu.swan.games.e.b
    public byte[] a(JsSerializeValue jsSerializeValue, boolean z) {
        return null;
    }

    @Override // com.baidu.swan.games.e.b
    public JsSerializeValue c(byte[] bArr, boolean z) {
        return null;
    }

    @Override // com.baidu.swan.games.e.b
    public void setPreferredFramesPerSecond(short s) {
    }
}
