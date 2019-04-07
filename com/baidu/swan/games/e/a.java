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
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean bbA;
    protected com.baidu.swan.games.e.d.b bbs;
    public final String bbt;
    private EventTarget bbu;
    private EventTarget bbv;
    private com.baidu.swan.games.e.b.a bbw;
    private com.baidu.swan.games.e.b.b bbx;
    private com.baidu.swan.games.e.a.a bby;
    private List<JSEvent> bbz;
    private Context mContext;
    private int mCurState = 0;
    private boolean bbB = false;

    @NonNull
    public abstract EventTarget NO();

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull String str, @NonNull com.baidu.swan.games.e.d.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        this.bbt = str;
        this.bbs = bVar;
        if (!TextUtils.isEmpty(NY())) {
            this.bbu = NO();
            this.bbv = NP();
            this.bbz = new ArrayList();
            onCreate();
        }
    }

    @NonNull
    public EventTarget NP() {
        return new EventTargetImpl(this);
    }

    public void NQ() {
    }

    public void setFileSystemDelegatePolicy(V8FileSystemDelegatePolicy v8FileSystemDelegatePolicy) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void NR() {
        if (DEBUG) {
            Log.d("SwanAppV8Engine", "initEngine start.");
        }
        this.bbs.a(this);
        if (DEBUG) {
            Log.d("SwanAppV8Engine", "initEngine end.");
        }
    }

    public void finish() {
        if (!this.bbA) {
            if (DEBUG) {
                Log.d("SwanAppV8Engine", "finish called.");
            }
            this.bbA = true;
            onFinish();
        }
    }

    public boolean isFinishing() {
        return this.bbA;
    }

    @Override // com.baidu.swan.games.e.b
    public com.baidu.swan.games.e.b.b NS() {
        return this.bbx;
    }

    @Override // com.baidu.swan.games.e.b
    public EventTarget NT() {
        return this.bbu;
    }

    @Override // com.baidu.swan.games.e.b
    public EventTarget NU() {
        return this.bbv;
    }

    @Override // com.baidu.swan.games.e.b
    public com.baidu.swan.games.e.a.a NV() {
        return this.bby;
    }

    public boolean dispatchEvent(final JSEvent jSEvent) {
        if (DEBUG) {
            Log.d("SwanAppV8Engine", "dispatchEvent event: " + (jSEvent != null ? jSEvent.type : ""));
        }
        if (this.bbu == null || !JSEvent.isValid(jSEvent)) {
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
                    a.this.bbz.add(jSEvent);
                    return;
                }
                a.this.bbu.dispatchEvent(jSEvent);
            }
        });
        return true;
    }

    @Override // com.baidu.swan.games.e.b
    public void aS(String str, String str2) {
        this.bbw.aS(str, str2);
    }

    @Override // com.baidu.swan.apps.core.container.a
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        this.bbw.evaluateJavascript(str, valueCallback);
    }

    @Override // com.baidu.swan.apps.core.container.a
    public boolean isDestroyed() {
        return this.bbA;
    }

    public void addJavascriptInterface(@NonNull Object obj, @NonNull String str) {
        if (DEBUG) {
            Log.d("SwanAppV8Engine", "addJavascriptInterface object: " + obj + " ,name: " + str);
        }
        this.bbw.addJavascriptInterface(obj, str);
    }

    @Override // com.baidu.swan.games.e.b
    public void throwJSException(JSExceptionType jSExceptionType, String str) {
        this.bbw.throwJSException(jSExceptionType, str);
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
        if (this.bbs != null) {
            return this.bbs.zt();
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

    public String ET() {
        return "[" + this.bbt + "] : ";
    }

    private d NW() {
        return d.NZ();
    }

    private void onCreate() {
        NW().d(this);
        this.mCurState = 1;
    }

    public void onPause() {
        NW().e(this);
        this.mCurState = 4;
    }

    public void onResume() {
        NW().f(this);
        this.mCurState = 5;
    }

    private void onFinish() {
        NW().g(this);
        this.mCurState = 6;
    }

    public boolean isLoaded() {
        return this.bbB;
    }

    @Override // com.baidu.swan.apps.core.container.a
    public boolean xR() {
        return false;
    }

    public boolean NX() {
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

    protected String NY() {
        return this.bbs.zt();
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
