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
    protected com.baidu.swan.games.e.d.b bgh;
    public final String bgi;
    private EventTarget bgj;
    private EventTarget bgk;
    private com.baidu.swan.games.e.b.a bgl;
    private com.baidu.swan.games.e.b.b bgm;
    private com.baidu.swan.games.e.a.a bgn;
    private List<JSEvent> bgo;
    private boolean bgp;
    private Context mContext;
    private V8Engine mV8Engine;
    private int mCurState = 0;
    private boolean bgq = false;

    @NonNull
    public abstract EventTarget RA();

    static {
        V8NativeInit.initEnv();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull String str, @NonNull com.baidu.swan.games.e.d.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        this.bgi = str;
        this.bgh = bVar;
        String RM = RM();
        if (!TextUtils.isEmpty(RM)) {
            this.bgj = RA();
            this.bgk = RB();
            this.mV8Engine = new V8Engine(AppRuntime.getAppContext(), RM, this.bgh.Bd(), v8ThreadDelegatePolicy, this.bgj, this.bgk);
            this.mV8Engine.setFileSystemDelegatePolicy(new com.baidu.swan.games.e.c.d());
            if (bVar.Bb() != null) {
                this.mV8Engine.setCodeCacheSetting(bVar.Bb());
            }
            this.bgl = new com.baidu.swan.games.e.b.a(this.mV8Engine);
            this.bgn = new com.baidu.swan.games.e.a.a(this.mV8Engine);
            this.bgo = new ArrayList();
            onCreate();
        }
    }

    @NonNull
    public EventTarget RB() {
        return new EventTargetImpl(this);
    }

    public void RC() {
        if (this.mV8Engine != null) {
            this.mV8Engine.setBdFileRealPath(com.baidu.swan.games.f.g.getBasePath());
        }
    }

    public void RD() {
        if (this.mV8Engine != null) {
            this.mV8Engine.setMainPackageBasePath(com.baidu.swan.apps.w.e.GF().Go());
        }
    }

    public void setFileSystemDelegatePolicy(V8FileSystemDelegatePolicy v8FileSystemDelegatePolicy) {
        this.mV8Engine.setFileSystemDelegatePolicy(v8FileSystemDelegatePolicy);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void RE() {
        if (DEBUG) {
            Log.d("SwanAppV8Engine", "initEngine start.");
        }
        this.bgh.a(this);
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
        if (!this.bgp) {
            if (DEBUG) {
                Log.d("SwanAppV8Engine", "finish called.");
            }
            this.bgp = true;
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
        return this.bgp;
    }

    @Override // com.baidu.swan.games.e.b
    public com.baidu.swan.games.e.b.b RF() {
        if (this.bgm == null) {
            this.bgm = new com.baidu.swan.games.e.b.b(this.mV8Engine);
        }
        return this.bgm;
    }

    @Override // com.baidu.swan.games.e.b
    public EventTarget RG() {
        return this.bgj;
    }

    @Override // com.baidu.swan.games.e.b
    public EventTarget RH() {
        return this.bgk;
    }

    @Override // com.baidu.swan.games.e.b
    public com.baidu.swan.games.e.a.a RI() {
        return this.bgn;
    }

    public boolean dispatchEvent(final JSEvent jSEvent) {
        if (DEBUG) {
            Log.d("SwanAppV8Engine", "dispatchEvent event: " + (jSEvent != null ? jSEvent.type : ""));
        }
        if (this.bgj == null || !JSEvent.isValid(jSEvent)) {
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
                    a.this.bgo.add(jSEvent);
                    return;
                }
                a.this.bgj.dispatchEvent(jSEvent);
            }
        });
        return true;
    }

    private void RJ() {
        if (DEBUG) {
            Log.d("SwanAppV8Engine", "doPendingDispatch start.");
        }
        runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.e.a.4
            @Override // java.lang.Runnable
            public void run() {
                for (JSEvent jSEvent : a.this.bgo) {
                    if (a.DEBUG) {
                        Log.d("SwanAppV8Engine", "doPendingDispatch event type: " + jSEvent.type);
                    }
                    a.this.dispatchEvent(jSEvent);
                }
                a.this.bgo.clear();
            }
        });
    }

    @Override // com.baidu.swan.games.e.b
    public void aV(String str, String str2) {
        this.bgl.aV(str, str2);
    }

    @Override // com.baidu.swan.apps.core.container.a
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        this.bgl.evaluateJavascript(str, valueCallback);
    }

    @Override // com.baidu.swan.apps.core.container.a
    public boolean isDestroyed() {
        return this.bgp;
    }

    public void addJavascriptInterface(@NonNull Object obj, @NonNull String str) {
        if (DEBUG) {
            Log.d("SwanAppV8Engine", "addJavascriptInterface object: " + obj + " ,name: " + str);
        }
        this.bgl.addJavascriptInterface(obj, str);
    }

    @Override // com.baidu.swan.games.e.b
    public void throwJSException(JSExceptionType jSExceptionType, String str) {
        this.bgl.throwJSException(jSExceptionType, str);
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
        if (this.bgh != null) {
            return this.bgh.Bc();
        }
        return null;
    }

    @Override // com.baidu.swan.games.e.b
    public boolean l(Runnable runnable) {
        runOnJSThread(runnable);
        return true;
    }

    public void a(@NonNull V8Engine.V8EngineConsole v8EngineConsole) {
        this.mV8Engine.addV8EngineConsole(v8EngineConsole);
    }

    public void a(@NonNull V8Engine.JavaScriptExceptionDelegate javaScriptExceptionDelegate) {
        this.mV8Engine.setJavaScriptExceptionDelegate(javaScriptExceptionDelegate);
    }

    public String HF() {
        return "[" + this.bgi + "] : ";
    }

    private d RK() {
        return d.RN();
    }

    private void onCreate() {
        RK().h(this);
        this.mCurState = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onReady() {
        RK().i(this);
        this.mCurState = 2;
        this.bgh.b(this);
    }

    public void onPause() {
        if (this.mV8Engine != null) {
            this.mV8Engine.onPause();
        }
        RK().k(this);
        this.mCurState = 4;
    }

    public void onResume() {
        if (this.mV8Engine != null) {
            this.mV8Engine.onResume();
        }
        RK().l(this);
        this.mCurState = 5;
    }

    public void onLoad() {
        RK().j(this);
        this.mCurState = 3;
        this.bgq = true;
        RJ();
    }

    private void onFinish() {
        RK().m(this);
        this.mCurState = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        RK().n(this);
        this.mCurState = 7;
    }

    public boolean isLoaded() {
        return this.bgq;
    }

    @Override // com.baidu.swan.apps.core.container.a
    public boolean zq() {
        return false;
    }

    public boolean RL() {
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

    protected String RM() {
        return this.bgh.Bc();
    }

    public InspectorNativeClient initInspector(InspectorNativeChannel inspectorNativeChannel) {
        return this.mV8Engine.initInspector(inspectorNativeChannel);
    }

    @Override // com.baidu.swan.games.e.b
    public byte[] a(JsSerializeValue jsSerializeValue, boolean z) {
        return this.mV8Engine.serialize(jsSerializeValue, z);
    }

    @Override // com.baidu.swan.games.e.b
    public JsSerializeValue c(byte[] bArr, boolean z) {
        return this.mV8Engine.deserialize(bArr, z);
    }

    @Override // com.baidu.swan.games.e.b
    public void setPreferredFramesPerSecond(short s) {
        this.mV8Engine.setPreferredFramesPerSecond(s);
    }
}
