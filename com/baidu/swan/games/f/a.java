package com.baidu.swan.games.f;

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
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.searchbox.v8engine.filesystem.V8FileSystemDelegatePolicy;
import com.baidu.searchbox.v8engine.thread.V8ExecuteCallback;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.swan.games.i.n;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class a implements b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected com.baidu.swan.games.f.d.b dgP;
    public final String dgQ;
    private EventTarget dgR;
    private EventTarget dgS;
    private com.baidu.swan.games.f.b.a dgT;
    private com.baidu.swan.games.f.b.b dgU;
    private com.baidu.swan.games.f.a.a dgV;
    private List<JSEvent> dgW;
    private boolean dgX;
    private Context mContext;
    protected V8Engine mV8Engine;
    private int mCurState = 0;
    private boolean dgY = false;

    @NonNull
    public abstract EventTarget aEf();

    static {
        com.baidu.swan.games.utils.so.d.aHi();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull String str, @NonNull com.baidu.swan.games.f.d.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        this.dgQ = str;
        this.dgP = bVar;
        String initBasePath = getInitBasePath();
        if (!TextUtils.isEmpty(initBasePath)) {
            this.dgR = aEf();
            this.dgS = aEg();
            this.mV8Engine = new V8Engine(AppRuntime.getAppContext(), initBasePath, this.dgP.abQ(), v8ThreadDelegatePolicy, this.dgR, this.dgS);
            this.mV8Engine.setExternalV8BinFilesPath(com.baidu.swan.games.utils.so.d.aHn());
            this.mV8Engine.setFileSystemDelegatePolicy(new com.baidu.swan.games.f.c.d());
            if (bVar.abP() != null) {
                this.mV8Engine.setCodeCacheSetting(bVar.abP());
            }
            this.dgT = new com.baidu.swan.games.f.b.a(this.mV8Engine);
            this.dgV = new com.baidu.swan.games.f.a.a(this.mV8Engine);
            this.dgW = new ArrayList();
            onCreate();
        }
    }

    @NonNull
    public EventTarget aEg() {
        return new EventTargetImpl(this);
    }

    public void aEh() {
        if (this.mV8Engine != null) {
            this.mV8Engine.setBdFileRealPath(n.getBasePath());
        }
    }

    public void aEi() {
        if (this.mV8Engine != null) {
            this.mV8Engine.setMainPackageBasePath(com.baidu.swan.apps.v.f.akr().ajY());
        }
    }

    public void setFileSystemDelegatePolicy(V8FileSystemDelegatePolicy v8FileSystemDelegatePolicy) {
        this.mV8Engine.setFileSystemDelegatePolicy(v8FileSystemDelegatePolicy);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aEj() {
        if (DEBUG) {
            Log.d("SwanAppV8Engine", "initEngine start.");
        }
        this.dgP.a(this);
        this.mV8Engine.startEngine();
        this.mV8Engine.addStatusHandler(new V8Engine.V8StatusListener() { // from class: com.baidu.swan.games.f.a.1
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
        if (!this.dgX) {
            if (DEBUG) {
                Log.d("SwanAppV8Engine", "finish called.");
            }
            this.dgX = true;
            onFinish();
            this.mV8Engine.destroyEngine(new V8ExecuteCallback() { // from class: com.baidu.swan.games.f.a.2
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
        return this.dgX;
    }

    @Override // com.baidu.swan.games.f.b
    public com.baidu.swan.games.f.b.b aEk() {
        if (this.dgU == null) {
            this.dgU = new com.baidu.swan.games.f.b.b(this.mV8Engine);
        }
        return this.dgU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public V8Engine aEl() {
        return this.mV8Engine;
    }

    @Override // com.baidu.swan.games.f.b
    public EventTarget aEm() {
        return this.dgR;
    }

    @Override // com.baidu.swan.games.f.b
    public EventTarget aEn() {
        return this.dgS;
    }

    @Override // com.baidu.swan.games.f.b
    public com.baidu.swan.games.f.a.a aEo() {
        return this.dgV;
    }

    public boolean dispatchEvent(final JSEvent jSEvent) {
        if (DEBUG) {
            Log.d("SwanAppV8Engine", "dispatchEvent event: " + (jSEvent != null ? jSEvent.type : ""));
        }
        if (this.dgR == null || !JSEvent.isValid(jSEvent)) {
            if (DEBUG) {
                Log.e("SwanAppV8Engine", "dispatchEvent globalObject or event is invalid.");
            }
            return false;
        }
        runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.isLoaded()) {
                    if (a.DEBUG) {
                        Log.d("SwanAppV8Engine", "dispatchEvent add to pending list.");
                    }
                    a.this.dgW.add(jSEvent);
                    return;
                }
                a.this.dgR.dispatchEvent(jSEvent);
            }
        });
        return true;
    }

    private void aEp() {
        if (DEBUG) {
            Log.d("SwanAppV8Engine", "doPendingDispatch start.");
        }
        runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.a.4
            @Override // java.lang.Runnable
            public void run() {
                for (JSEvent jSEvent : a.this.dgW) {
                    if (a.DEBUG) {
                        Log.d("SwanAppV8Engine", "doPendingDispatch event type: " + jSEvent.type);
                    }
                    a.this.dispatchEvent(jSEvent);
                }
                a.this.dgW.clear();
            }
        });
    }

    @Override // com.baidu.swan.games.f.b
    public void cp(String str, String str2) {
        this.dgT.cp(str, str2);
    }

    @Override // com.baidu.swan.apps.core.container.a
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        this.dgT.evaluateJavascript(str, valueCallback);
    }

    @Override // com.baidu.swan.apps.core.container.a
    public boolean isDestroyed() {
        return this.dgX;
    }

    @Override // com.baidu.swan.apps.core.container.a
    public void addJavascriptInterface(@NonNull Object obj, @NonNull String str) {
        if (DEBUG) {
            Log.d("SwanAppV8Engine", "addJavascriptInterface object: " + obj + " ,name: " + str);
        }
        this.dgT.addJavascriptInterface(obj, str);
    }

    @Override // com.baidu.swan.games.f.b
    public void throwJSException(JSExceptionType jSExceptionType, String str) {
        this.dgT.throwJSException(jSExceptionType, str);
    }

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    public void runOnJSThreadDirectly(Runnable runnable) {
        if (runnable != null) {
            this.mV8Engine.runOnJSThreadDirectly(runnable);
        }
    }

    @Override // com.baidu.swan.games.f.b, com.baidu.searchbox.v8engine.JSRuntime
    public void runOnJSThread(Runnable runnable) {
        if (runnable != null) {
            this.mV8Engine.runOnJSThread(runnable);
        }
    }

    @Override // com.baidu.swan.games.f.b, com.baidu.searchbox.v8engine.JSRuntime
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

    @Override // com.baidu.swan.games.f.b
    public boolean r(Runnable runnable) {
        runOnJSThread(runnable);
        return true;
    }

    public void a(@NonNull V8Engine.V8EngineConsole v8EngineConsole) {
        this.mV8Engine.addV8EngineConsole(v8EngineConsole);
    }

    public void a(@NonNull V8Engine.JavaScriptExceptionDelegate javaScriptExceptionDelegate) {
        this.mV8Engine.setJavaScriptExceptionDelegate(javaScriptExceptionDelegate);
    }

    public String getLogTag() {
        return "[" + this.dgQ + "] : ";
    }

    private d aEq() {
        return d.aEs();
    }

    private void onCreate() {
        aEq().h(this);
        this.mCurState = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onReady() {
        aEq().i(this);
        this.mCurState = 2;
        this.dgP.b(this);
    }

    public void onPause() {
        if (this.mV8Engine != null) {
            this.mV8Engine.onPause();
        }
        aEq().k(this);
        this.mCurState = 4;
    }

    public void onResume() {
        if (this.mV8Engine != null) {
            this.mV8Engine.onResume();
        }
        aEq().l(this);
        this.mCurState = 5;
    }

    public void onLoad() {
        aEq().j(this);
        this.mCurState = 3;
        this.dgY = true;
        aEp();
    }

    private void onFinish() {
        aEq().m(this);
        this.mCurState = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        aEq().n(this);
        this.mCurState = 7;
    }

    public boolean isLoaded() {
        return this.dgY;
    }

    @Override // com.baidu.swan.apps.core.container.a
    public boolean isWebView() {
        return false;
    }

    public boolean aEr() {
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

    @Override // com.baidu.swan.games.f.b
    public String getInitBasePath() {
        return this.dgP.getInitBasePath();
    }

    public InspectorNativeClient initInspector(InspectorNativeChannel inspectorNativeChannel) {
        return this.mV8Engine.initInspector(inspectorNativeChannel);
    }

    @Override // com.baidu.swan.games.f.b
    public byte[] a(JsSerializeValue jsSerializeValue, boolean z) {
        return this.mV8Engine.serialize(jsSerializeValue, z);
    }

    @Override // com.baidu.swan.games.f.b
    public JsSerializeValue d(byte[] bArr, boolean z) {
        return this.mV8Engine.deserialize(bArr, z);
    }

    @Override // com.baidu.swan.games.f.b
    public void setPreferredFramesPerSecond(short s) {
        this.mV8Engine.setPreferredFramesPerSecond(s);
    }

    @Override // com.baidu.swan.apps.core.container.a
    public void onJSLoaded() {
        com.baidu.swan.apps.core.turbo.d.adw().dX(true);
    }

    public JSONArray getPerformanceJson() {
        if (this.mV8Engine == null) {
            return null;
        }
        return this.mV8Engine.getPerformanceJson();
    }

    @Override // com.baidu.swan.apps.core.container.a
    public String getContainerId() {
        return this.dgQ;
    }
}
