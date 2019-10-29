package com.baidu.swan.games.e;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.ValueCallback;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.InspectorNativeChannel;
import com.baidu.searchbox.v8engine.InspectorNativeClient;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.searchbox.v8engine.V8NativeInit;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.searchbox.v8engine.filesystem.V8FileSystemDelegatePolicy;
import com.baidu.searchbox.v8engine.thread.V8ExecuteCallback;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class a implements b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private EventTarget bzA;
    private EventTarget bzB;
    private com.baidu.swan.games.e.b.a bzC;
    private com.baidu.swan.games.e.b.b bzD;
    private com.baidu.swan.games.e.a.a bzE;
    private List<JSEvent> bzF;
    private boolean bzG;
    protected com.baidu.swan.games.e.d.b bzy;
    public final String bzz;
    private Context mContext;
    private V8Engine mV8Engine;
    private int mCurState = 0;
    private boolean bzH = false;

    @NonNull
    public abstract EventTarget Wv();

    static {
        V8NativeInit.initEnv();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull String str, @NonNull com.baidu.swan.games.e.d.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        this.bzz = str;
        this.bzy = bVar;
        String WH = WH();
        if (!TextUtils.isEmpty(WH)) {
            this.bzA = Wv();
            this.bzB = Ww();
            this.mV8Engine = new V8Engine(AppRuntime.getAppContext(), WH, this.bzy.Gc(), v8ThreadDelegatePolicy, this.bzA, this.bzB);
            this.mV8Engine.setFileSystemDelegatePolicy(new com.baidu.swan.games.e.c.d());
            if (bVar.Ga() != null) {
                this.mV8Engine.setCodeCacheSetting(bVar.Ga());
            }
            this.bzC = new com.baidu.swan.games.e.b.a(this.mV8Engine);
            this.bzE = new com.baidu.swan.games.e.a.a(this.mV8Engine);
            this.bzF = new ArrayList();
            onCreate();
        }
    }

    @NonNull
    public EventTarget Ww() {
        return new EventTargetImpl(this);
    }

    public void Wx() {
        if (this.mV8Engine != null) {
            this.mV8Engine.setBdFileRealPath(com.baidu.swan.games.f.g.getBasePath());
        }
    }

    public void Wy() {
        if (this.mV8Engine != null) {
            this.mV8Engine.setMainPackageBasePath(com.baidu.swan.apps.w.e.LD().Lm());
        }
    }

    public void setFileSystemDelegatePolicy(V8FileSystemDelegatePolicy v8FileSystemDelegatePolicy) {
        this.mV8Engine.setFileSystemDelegatePolicy(v8FileSystemDelegatePolicy);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Wz() {
        if (DEBUG) {
            Log.d("SwanAppV8Engine", "initEngine start.");
        }
        this.bzy.a(this);
        this.mV8Engine.startEngine();
        this.mV8Engine.addStatusHandler(new V8Engine.V8StatusListener() { // from class: com.baidu.swan.games.e.a.1
            @Override // com.baidu.searchbox.v8engine.V8Engine.V8StatusListener
            public void onReady() {
                a.this.onReady();
            }

            @Override // com.baidu.searchbox.v8engine.V8Engine.V8StatusListener
            public void onPause() {
            }

            @Override // com.baidu.searchbox.v8engine.V8Engine.V8StatusListener
            public void onResume() {
            }
        });
        if (DEBUG) {
            Log.d("SwanAppV8Engine", "initEngine end.");
        }
    }

    public void setCodeCacheSetting(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        this.mV8Engine.setCodeCacheSetting(codeCacheSetting);
    }

    public void a(V8EngineConfiguration.JSCacheCallback jSCacheCallback) {
        this.mV8Engine.setJSCacheCallback(jSCacheCallback);
    }

    public void finish() {
        if (!this.bzG) {
            if (DEBUG) {
                Log.d("SwanAppV8Engine", "finish called.");
            }
            this.bzG = true;
            onFinish();
            this.mV8Engine.destroyEngine(new V8ExecuteCallback() { // from class: com.baidu.swan.games.e.a.2
                @Override // com.baidu.searchbox.v8engine.thread.V8ExecuteCallback
                public void onExecuted() {
                    if (a.DEBUG) {
                        Log.d("SwanAppV8Engine", "finish onExecuted.");
                    }
                    a.this.onDestroy();
                }
            });
        }
    }

    public boolean isFinishing() {
        return this.bzG;
    }

    @Override // com.baidu.swan.games.e.b
    public com.baidu.swan.games.e.b.b WA() {
        if (this.bzD == null) {
            this.bzD = new com.baidu.swan.games.e.b.b(this.mV8Engine);
        }
        return this.bzD;
    }

    @Override // com.baidu.swan.games.e.b
    public EventTarget WB() {
        return this.bzA;
    }

    @Override // com.baidu.swan.games.e.b
    public EventTarget WC() {
        return this.bzB;
    }

    @Override // com.baidu.swan.games.e.b
    public com.baidu.swan.games.e.a.a WD() {
        return this.bzE;
    }

    public boolean dispatchEvent(final JSEvent jSEvent) {
        if (DEBUG) {
            Log.d("SwanAppV8Engine", "dispatchEvent event: " + (jSEvent != null ? jSEvent.type : ""));
        }
        if (this.bzA == null || !JSEvent.isValid(jSEvent)) {
            if (DEBUG) {
                Log.e("SwanAppV8Engine", "dispatchEvent globalObject or event is invalid.");
            }
            return false;
        }
        runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.e.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.isLoaded()) {
                    if (a.DEBUG) {
                        Log.d("SwanAppV8Engine", "dispatchEvent add to pending list.");
                    }
                    a.this.bzF.add(jSEvent);
                    return;
                }
                a.this.bzA.dispatchEvent(jSEvent);
            }
        });
        return true;
    }

    private void WE() {
        if (DEBUG) {
            Log.d("SwanAppV8Engine", "doPendingDispatch start.");
        }
        runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.e.a.4
            @Override // java.lang.Runnable
            public void run() {
                for (JSEvent jSEvent : a.this.bzF) {
                    if (a.DEBUG) {
                        Log.d("SwanAppV8Engine", "doPendingDispatch event type: " + jSEvent.type);
                    }
                    a.this.dispatchEvent(jSEvent);
                }
                a.this.bzF.clear();
            }
        });
    }

    @Override // com.baidu.swan.games.e.b
    public void bc(String str, String str2) {
        this.bzC.bc(str, str2);
    }

    @Override // com.baidu.swan.apps.core.container.a
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        this.bzC.evaluateJavascript(str, valueCallback);
    }

    @Override // com.baidu.swan.apps.core.container.a
    public boolean isDestroyed() {
        return this.bzG;
    }

    public void addJavascriptInterface(@NonNull Object obj, @NonNull String str) {
        if (DEBUG) {
            Log.d("SwanAppV8Engine", "addJavascriptInterface object: " + obj + " ,name: " + str);
        }
        this.bzC.addJavascriptInterface(obj, str);
    }

    @Override // com.baidu.swan.games.e.b
    public void throwJSException(JSExceptionType jSExceptionType, String str) {
        this.bzC.throwJSException(jSExceptionType, str);
    }

    @Override // com.baidu.swan.games.e.b, com.baidu.searchbox.v8engine.JSRuntime
    public void runOnJSThread(Runnable runnable) {
        if (runnable != null) {
            this.mV8Engine.runOnJSThread(runnable);
        }
    }

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    public void postOnJSThread(Runnable runnable) {
        if (runnable != null) {
            this.mV8Engine.postOnJSThread(runnable);
        }
    }

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    public void postOnJSThread(Runnable runnable, long j) {
        if (runnable != null) {
            this.mV8Engine.postOnJSThread(runnable, j);
        }
    }

    public void setUserAgent(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.d("SwanAppV8Engine", "setUserAgent: " + str);
            }
            this.mV8Engine.setUserAgent(str);
        }
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public String getUrl() {
        if (this.bzy != null) {
            return this.bzy.Gb();
        }
        return null;
    }

    @Override // com.baidu.swan.games.e.b
    public boolean j(Runnable runnable) {
        runOnJSThread(runnable);
        return true;
    }

    public void a(@NonNull V8Engine.V8EngineConsole v8EngineConsole) {
        this.mV8Engine.addV8EngineConsole(v8EngineConsole);
    }

    public void a(@NonNull V8Engine.JavaScriptExceptionDelegate javaScriptExceptionDelegate) {
        this.mV8Engine.setJavaScriptExceptionDelegate(javaScriptExceptionDelegate);
    }

    public String MD() {
        return "[" + this.bzz + "] : ";
    }

    private d WF() {
        return d.WI();
    }

    private void onCreate() {
        WF().h(this);
        this.mCurState = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onReady() {
        WF().i(this);
        this.mCurState = 2;
        this.bzy.b(this);
    }

    public void onPause() {
        if (this.mV8Engine != null) {
            this.mV8Engine.onPause();
        }
        WF().k(this);
        this.mCurState = 4;
    }

    public void onResume() {
        if (this.mV8Engine != null) {
            this.mV8Engine.onResume();
        }
        WF().l(this);
        this.mCurState = 5;
    }

    public void onLoad() {
        WF().j(this);
        this.mCurState = 3;
        this.bzH = true;
        WE();
    }

    private void onFinish() {
        WF().m(this);
        this.mCurState = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        WF().n(this);
        this.mCurState = 7;
    }

    public boolean isLoaded() {
        return this.bzH;
    }

    @Override // com.baidu.swan.apps.core.container.a
    public boolean Ep() {
        return false;
    }

    public boolean WG() {
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

    protected String WH() {
        return this.bzy.Gb();
    }

    public InspectorNativeClient initInspector(InspectorNativeChannel inspectorNativeChannel) {
        return this.mV8Engine.initInspector(inspectorNativeChannel);
    }

    @Override // com.baidu.swan.games.e.b
    public byte[] a(JsSerializeValue jsSerializeValue, boolean z) {
        return this.mV8Engine.serialize(jsSerializeValue, z);
    }

    @Override // com.baidu.swan.games.e.b
    public JsSerializeValue d(byte[] bArr, boolean z) {
        return this.mV8Engine.deserialize(bArr, z);
    }

    @Override // com.baidu.swan.games.e.b
    public void setPreferredFramesPerSecond(short s) {
        this.mV8Engine.setPreferredFramesPerSecond(s);
    }
}
