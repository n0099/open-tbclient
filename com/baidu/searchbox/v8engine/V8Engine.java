package com.baidu.searchbox.v8engine;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.searchbox.v8engine.bean.PerformanceJsonBean;
import com.baidu.searchbox.v8engine.filesystem.V8FileSystemDelegatePolicy;
import com.baidu.searchbox.v8engine.net.NetRequest;
import com.baidu.searchbox.v8engine.thread.V8DefaultThreadPolicy;
import com.baidu.searchbox.v8engine.thread.V8ExecuteCallback;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.smallgame.sdk.Log;
import com.baidu.tieba.so1;
import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
@NotProguard
/* loaded from: classes4.dex */
public class V8Engine implements JSRuntime {
    public static final String ACTION_CONSTRUCTOR_DONE = "v8_constructor_done";
    public static final String ACTION_NATIVE_INIT = "v8_native_init";
    public static final String ACTION_READY = "v8_ready";
    public static final String ACTION_START_ENGINE_BEGIN = "v8_start_engine_begin";
    public static final String ACTION_START_ENGINE_END = "v8_start_engine_end";
    public static final String ACTION_V8_CREATE_MAIN_CONTEXT_START = "v8_create_main_context";
    public static final String ACTION_V8_REQUIRE_BASE_JS_START = "v8_require_base_js";
    public static final String ACTION_WORKER_INIT = "v8_worker_init";
    public static final String ALTERNATIVE_ADD_ASSET_PATH_METHOD = "addAssetPath";
    public static final String ALTERNATIVE_CACHE_PATH = "webview_baidu";
    public static final String ALTERNATIVE_SO = "libcom.baidu.zeus.so";
    public static boolean APP_DEBUG = false;
    public static final long CLOCKS_PER_SEC = 1000;
    public static final float DEFAULT_FRAMES = 16.666666f;
    public static final int INVOKE_NATIVE_METHOD_ERROR_ENGINE_IS_NULL = 1;
    public static final int INVOKE_NATIVE_METHOD_ERROR_HAS_NULL_PARAM = 4;
    public static final int INVOKE_NATIVE_METHOD_ERROR_MUST_CALL_ON_V8_THREAD = 2;
    public static final int INVOKE_NATIVE_METHOD_ERROR_PARAM_IS_NULL = 3;
    public static final int INVOKE_NATIVE_METHOD_ERROR_USE_DESTROYED_ENGINE = 5;
    public static final int INVOKE_NATIVE_METHOD_NO_ERROR = 0;
    public static final int SET_NET_REQUEST_ERROR_ENGINE_PTR_IS_NULLPTR = 1;
    public static final int SET_NET_REQUEST_ERROR_JAVA_NET_REQUEST_HAS_BEEN_SET_BEFORE = 196608;
    public static final int SET_NET_REQUEST_ERROR_MUST_CALL_ON_V8_THREAD = 256;
    public static final int SET_NET_REQUEST_ERROR_NET_REQUEST_OBJECT_IS_NULL = 2;
    public static final int SET_NET_REQUEST_ERROR_NOT_SUPPORT_DIFFERENT_JAVA_NET_REQUEST_OBJ = 65536;
    public static final int SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_CAN_NOT_FIND_SWAN_NATIVE = 262145;
    public static final int SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_HAS_KEY_BUT_NOT_ALLOWED_OVERWRITING = 262144;
    public static final int SET_NET_REQUEST_ERROR_UNKNOWN = 3;
    public static final int SET_NET_REQUEST_ERROR_USE_DESTROYED_ENGINE = 512;
    public static final int SET_NET_REQUEST_ERROR_V8NET_FUNCTION_TABLE_DELEGATE_NOT_READY = 131072;
    public static final int SET_NET_REQUEST_NO_ERROR = 0;
    public static final String TAG = "V8Engine";
    public static final String TYPE_V8 = "v8";
    public static int mSurfaceViewHeight;
    public static int mSurfaceViewWidth;
    public static Context sAppContext;
    public static final long sEngineDestroyed = 0;
    public static int sWorkerID;
    public AssetManager mAssetManager;
    public V8EngineConfiguration.CodeCacheSetting mCodeCacheSetting;
    public ComponentCallbacks2 mComponentCallbacks2;
    public CustomJsCodeCacheHandler mCustomJsCodeCacheHandler;
    public File mDiskCodeCachePathFile;
    public JavaScriptExceptionDelegate mExceptionDelegate;
    public V8FileSystemDelegatePolicy mFileSystemDelegatePolicy;
    public String mInitBasePath;
    public String mInitJsPath;
    public InspectorNativeChannel mInspectorChannel;
    public InspectorNativeClient mInspectorNativeClient;
    @Deprecated
    public V8EngineConfiguration.JSCacheCallback mJSCacheCallback;
    public JavaBoundObjectManager mJavaBoundObjectManager;
    public JsCodeCacheCallback mJsCodeCacheCallback;
    public Object mMainGlobalObject;
    public long mNativeV8Engine;
    public NetRequest mNetRequest;
    public Object mOpenGlobalObject;
    public PerformanceJsonBean mPerformanceJsonBean;
    public volatile boolean mReady;
    public V8ThreadDelegatePolicy mThreadDelegatePolicy;
    public V8Timer mTimer;
    public String mUserAgent;
    public AssetManager mV8BinAssetManager;
    public V8ExceptionInfo mV8ExceptionInfo;
    public static HashMap<Long, V8Engine> sEngines = new HashMap<>();
    public static Method sSetCrashKeyValueMethod = null;
    public static Method sClearCrashKeyMethod = null;
    public String mExternalV8BinPath = null;
    public String mBuildInV8BinPath = null;
    public AtomicBoolean mIsDestroyed = new AtomicBoolean(true);
    public ArrayList<V8StatusListener> mHandlers = null;
    public ArrayList<V8EngineConsole> mConsoles = null;
    public String mDecodeBdfile = "";
    public String mMainPackageBasePath = "";
    public volatile boolean mPaused = false;
    public Vector<Runnable> mSuspendableTasks = null;
    public long mV8ThreadId = 0;
    public float mFramesInterval = 16.666666f;
    public String mThreadName = "V8JavaScriptContext";
    public WorkerFactory mWorkerFactoryDelegate = null;
    public boolean mIsWorker = false;
    public volatile boolean mSetMemSetMemMemoryEnable = false;

    /* loaded from: classes4.dex */
    public interface JavaScriptExceptionDelegate {
        void onV8ExceptionCallBack(V8ExceptionInfo v8ExceptionInfo);
    }

    @NotProguard
    /* loaded from: classes4.dex */
    public static class MemoryInfo {
        @V8JavascriptField
        public int dalvikPrivateDirty;
        @V8JavascriptField
        public int dalvikPss;
        @V8JavascriptField
        public int nativePrivateDirty;
        @V8JavascriptField
        public int nativePss;
        @V8JavascriptField
        public int otherPrivateDirty;
        @V8JavascriptField
        public int otherPss;
        @V8JavascriptField
        public int summaryGraphics;
        @V8JavascriptField
        public int summaryJavaHeap;
        @V8JavascriptField
        public int summaryNativeHeap;
        @V8JavascriptField
        public int summaryPrivateOther;
        @V8JavascriptField
        public int summaryStack;
        @V8JavascriptField
        public int summaryTotalPss;
        @V8JavascriptField
        public int summaryTotalSwap;
        @V8JavascriptField
        public int totalPrivateDirty;
        @V8JavascriptField
        public int totalPss;
    }

    /* loaded from: classes4.dex */
    public interface V8EngineConsole {
        void onDebugConsole(String str);

        void onErrorConsole(String str);

        void onInfoConsole(String str);

        void onLogConsole(String str);

        void onTraceConsole(String str);

        void onWarnConsole(String str);
    }

    /* loaded from: classes4.dex */
    public interface V8StatusListener {
        void onPause();

        void onReady();

        void onResume();
    }

    /* loaded from: classes4.dex */
    public interface WorkerFactory {
        V8Engine onCreateWorker();
    }

    private native void addJavascriptInterfaceImpl(long j, Object obj, String str, Class cls, boolean z);

    public static native void nativeDeleteJsReleaser(long j, long j2, boolean z);

    private native JsSerializeValue nativeDeserialize(long j, byte[] bArr, int i, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeDestroyOpenDataContext(long j);

    public static native long nativeGetChannelFunctionTable();

    public static native int nativeGetVersionCode();

    public static native String nativeGetVersionName();

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeInitGlobalV8NetFunctionTable(long j, long j2);

    private native void nativeOnReady(long j);

    private native byte[] nativeSerialize(long j, JsSerializeValue jsSerializeValue, boolean z);

    private native void nativeSetBdFileRealPath(long j, String str);

    private native boolean nativeSetCodeCacheSetting(long j, String str, String str2, int i, String[] strArr, int i2, long j2);

    private native int nativeSetCustomJsCodeCacheHandler(long j, Object obj);

    private native int nativeSetJavaNetRequest(long j, Object obj);

    private native void nativeSetMainPackageBasePath(long j, String str);

    private native void nativeSetMemSetMemoryEnable(long j, boolean z);

    private native void nativeSetUserAgent(long j, String str);

    public static native void nativeSetV8GCPressureLevel(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeThrowJSException(long j, int i, String str, boolean z);

    public static native String nativeToColorRGBA(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void pumpNativeMessageLoop(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void removeJavascriptInterfaceImpl(long j, String str, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native void require(long j, String str, String str2, boolean z, boolean z2);

    private native String runScript(long j, String str, String str2, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native void v8EngineDestroy(long j);

    private native long v8EngineInit();

    static {
        regiestMessageChannelForT7();
        V8NetFunctionTable.addOnCronetThreadInitializedListenerForT7();
        sWorkerID = 0;
        APP_DEBUG = false;
        mSurfaceViewWidth = 0;
        mSurfaceViewHeight = 0;
    }

    private boolean checkVersion() {
        Log.w(TAG, "[mario] version: 1.3.6.1 nativeVersion: " + nativeGetVersionName());
        if ("1.3.6.1".equals(nativeGetVersionName()) && 1 == nativeGetVersionCode()) {
            return true;
        }
        return false;
    }

    public static Context getAppContext() {
        return sAppContext;
    }

    private String getBuildInV8BinPath() {
        if (this.mBuildInV8BinPath == null) {
            this.mBuildInV8BinPath = getAppContext().getApplicationInfo().nativeLibraryDir + File.separator + "libcom.baidu.zeus.so";
        }
        return this.mBuildInV8BinPath;
    }

    public static boolean isDebug() {
        return APP_DEBUG;
    }

    private void onReady() {
        this.mReady = true;
        if (this.mHandlers != null) {
            for (V8StatusListener v8StatusListener : new ArrayList(this.mHandlers)) {
                v8StatusListener.onReady();
            }
        }
    }

    public static void regiestMessageChannelForT7() {
        try {
            Class.forName("com.baidu.webkit.internal.ApisInteractWithMario").getDeclaredMethod("setMessageChannalFunctoinTable", Long.TYPE).invoke(null, Long.valueOf(nativeGetChannelFunctionTable()));
        } catch (Throwable th) {
            Log.e(TAG, th.getMessage());
        }
    }

    public void destroyOpenDataContext() {
        runOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.V8Engine.12
            @Override // java.lang.Runnable
            public void run() {
                if (!V8Engine.this.mIsDestroyed.get()) {
                    V8Engine v8Engine = V8Engine.this;
                    v8Engine.nativeDestroyOpenDataContext(v8Engine.mNativeV8Engine);
                    return;
                }
                Log.w(V8Engine.TAG, "destroyOpenDataContext fail. please start engine before execute js task");
            }
        });
    }

    public void destroyWorkerV8Engine() {
        destroyEngine(null);
    }

    public AssetManager getAssetManager() {
        return this.mAssetManager;
    }

    public String getBdFileRealPath() {
        return this.mDecodeBdfile;
    }

    public V8FileSystemDelegatePolicy getFileSystemDelegatePolicy() {
        return this.mFileSystemDelegatePolicy;
    }

    public String getInitBasePath() {
        return this.mInitBasePath;
    }

    public InspectorNativeClient getInspectorNativeClient() {
        return this.mInspectorNativeClient;
    }

    public String getMainPackageBasePath() {
        return this.mMainPackageBasePath;
    }

    public NetRequest getNetRequest() {
        return this.mNetRequest;
    }

    public Object getOpenGlobalObject() {
        return this.mOpenGlobalObject;
    }

    public JSONArray getPerformanceJson() {
        PerformanceJsonBean performanceJsonBean = this.mPerformanceJsonBean;
        if (performanceJsonBean == null) {
            return new JSONArray();
        }
        return performanceJsonBean.toJSONArray();
    }

    public PerformanceJsonBean getPerformanceJsonBean() {
        return this.mPerformanceJsonBean;
    }

    public void initializeV8() {
        Log.i(TAG, "[V8Dispose] Initializing V8Engine");
        this.mV8ThreadId = Thread.currentThread().getId();
        V8NativeInit.initialize(this.mNativeV8Engine, this.mAssetManager, getV8BinAssetManager(), this.mTimer, this.mMainGlobalObject, this.mV8ThreadId);
    }

    public boolean isDestroyed() {
        return this.mIsDestroyed.get();
    }

    public synchronized boolean isPaused() {
        return this.mPaused;
    }

    public boolean isReady() {
        return this.mReady;
    }

    public boolean isWorker() {
        return this.mIsWorker;
    }

    public float minFramesInterval() {
        return this.mFramesInterval;
    }

    public long nativePtr() {
        return this.mNativeV8Engine;
    }

    public void onPause() {
        this.mPaused = true;
        if (this.mHandlers != null) {
            for (V8StatusListener v8StatusListener : new ArrayList(this.mHandlers)) {
                v8StatusListener.onPause();
            }
        }
    }

    public void onResume() {
        this.mPaused = false;
        if (this.mHandlers != null) {
            for (V8StatusListener v8StatusListener : new ArrayList(this.mHandlers)) {
                v8StatusListener.onResume();
            }
        }
        postSuspendableTasks();
    }

    @NotProguard
    public void pumpMessageLoop() {
        try {
            postOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.V8Engine.4
                @Override // java.lang.Runnable
                public void run() {
                    if (!V8Engine.this.mIsDestroyed.get()) {
                        V8Engine.checkValid(V8Engine.this.mNativeV8Engine, V8Engine.this.mV8ThreadId);
                        V8Engine v8Engine = V8Engine.this;
                        v8Engine.pumpNativeMessageLoop(v8Engine.mNativeV8Engine, 0L);
                    }
                }
            });
        } catch (Throwable th) {
            android.util.Log.e(TAG, "", th);
        }
    }

    public synchronized void startEngine() {
        if (this.mThreadDelegatePolicy != null) {
            this.mThreadDelegatePolicy.startV8Engine(this);
        } else {
            Log.w(TAG, "startV8Engine failed. please init thread delegate policy before");
        }
    }

    public String threadName() {
        return this.mThreadName;
    }

    public String userAgent() {
        return this.mUserAgent;
    }

    public V8Engine(Context context, String str, String str2, V8ThreadDelegatePolicy v8ThreadDelegatePolicy, Object obj, Object obj2) {
        initialize(context, str, str2, v8ThreadDelegatePolicy, obj, obj2);
    }

    public static void clearCrashKey(String str) {
        try {
            if (sClearCrashKeyMethod == null) {
                sClearCrashKeyMethod = Class.forName("com.baidu.webkit.internal.ApisInteractWithMario").getDeclaredMethod("clearCrashKey", String.class);
            }
            sClearCrashKeyMethod.invoke(null, str);
        } catch (Throwable th) {
            Log.e(TAG, th.getMessage());
        }
    }

    private void delegateRunnableAsync(Runnable runnable) {
        V8ThreadDelegatePolicy v8ThreadDelegatePolicy = this.mThreadDelegatePolicy;
        if (v8ThreadDelegatePolicy != null) {
            v8ThreadDelegatePolicy.doDelegateRunnable(runnable);
        } else {
            Log.w(TAG, "Execute delegateRunnableAsync failed. mThreadDelegatePolicy is null");
        }
    }

    public static void dumpJavaStackTraceToLogcat(String str) {
        StackTraceElement[] stackTraceElementArr = Thread.getAllStackTraces().get(Thread.currentThread());
        Log.w(str, "================Java StackTrace================");
        if (stackTraceElementArr != null) {
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                Log.w(str, stackTraceElement.toString());
            }
        }
        Log.w(str, "================Java StackTrace================");
    }

    public static V8Engine getInstance(long j) {
        synchronized (sEngines) {
            V8Engine v8Engine = sEngines.get(Long.valueOf(j));
            if (v8Engine != null && !v8Engine.mIsDestroyed.get()) {
                return v8Engine;
            }
            return null;
        }
    }

    private String getTrimPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 0) {
            return null;
        }
        return trim;
    }

    private void onDebugConsole(String str) {
        if (this.mConsoles != null) {
            for (V8EngineConsole v8EngineConsole : new ArrayList(this.mConsoles)) {
                v8EngineConsole.onDebugConsole(str);
            }
        }
    }

    private void onErrorConsole(String str) {
        if (this.mConsoles != null) {
            for (V8EngineConsole v8EngineConsole : new ArrayList(this.mConsoles)) {
                v8EngineConsole.onErrorConsole(str);
            }
        }
    }

    private void onInfoConsole(String str) {
        if (this.mConsoles != null) {
            for (V8EngineConsole v8EngineConsole : new ArrayList(this.mConsoles)) {
                v8EngineConsole.onInfoConsole(str);
            }
        }
    }

    private void onLogConsole(String str) {
        if (this.mConsoles != null) {
            for (V8EngineConsole v8EngineConsole : new ArrayList(this.mConsoles)) {
                v8EngineConsole.onLogConsole(str);
            }
        }
    }

    private void onTraceConsole(String str) {
        if (this.mConsoles != null) {
            for (V8EngineConsole v8EngineConsole : new ArrayList(this.mConsoles)) {
                v8EngineConsole.onTraceConsole(str);
            }
        }
    }

    private void onWarnConsole(String str) {
        if (this.mConsoles != null) {
            for (V8EngineConsole v8EngineConsole : new ArrayList(this.mConsoles)) {
                v8EngineConsole.onWarnConsole(str);
            }
        }
    }

    public static String toColorRGBA(String str) {
        return nativeToColorRGBA(str);
    }

    public synchronized void addStatusHandler(V8StatusListener v8StatusListener) {
        if (this.mReady) {
            v8StatusListener.onReady();
            return;
        }
        if (this.mHandlers == null) {
            this.mHandlers = new ArrayList<>(1);
        }
        this.mHandlers.add(v8StatusListener);
    }

    public synchronized void addV8EngineConsole(V8EngineConsole v8EngineConsole) {
        if (this.mConsoles == null) {
            this.mConsoles = new ArrayList<>(1);
        }
        this.mConsoles.add(v8EngineConsole);
    }

    public boolean clearDiskCodeCache(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = this.mDiskCodeCachePathFile;
        if (file != null && file.exists()) {
            return DiskCodeCacheManager.clearDiskCodeCache(this.mDiskCodeCachePathFile.getAbsolutePath(), str);
        }
        return true;
    }

    public void destroyEngine(final V8ExecuteCallback v8ExecuteCallback) {
        Log.e("V8", "v8engine.java::destroyEngine");
        runOnJSThreadDirectly(new Runnable() { // from class: com.baidu.searchbox.v8engine.V8Engine.3
            @Override // java.lang.Runnable
            public void run() {
                Log.e(V8Engine.TAG, "v8engine.java::destroyEngine run");
                if (V8Engine.this.mIsDestroyed.getAndSet(true)) {
                    Log.w(V8Engine.TAG, "v8engine.java:destroyEngine has been called before");
                    return;
                }
                V8Engine.this.removeJavascriptInterface("jBenchmark");
                if (V8Engine.this.mTimer != null) {
                    V8Engine.this.mTimer.destroy();
                }
                if (V8Engine.this.mJavaBoundObjectManager != null) {
                    V8Engine.this.mJavaBoundObjectManager.clear();
                }
                synchronized (V8Engine.sEngines) {
                    V8Engine.sEngines.remove(Long.valueOf(V8Engine.this.mNativeV8Engine));
                }
                if (V8Engine.this.mInspectorNativeClient != null) {
                    V8Engine.this.mInspectorNativeClient.destroy();
                }
                V8Engine v8Engine = V8Engine.this;
                v8Engine.v8EngineDestroy(v8Engine.mNativeV8Engine);
                if (V8Engine.sAppContext != null) {
                    V8Engine.sAppContext.unregisterComponentCallbacks(V8Engine.this.mComponentCallbacks2);
                }
                V8Engine.this.mNativeV8Engine = 0L;
                if (V8Engine.this.mThreadDelegatePolicy != null) {
                    V8Engine.this.mThreadDelegatePolicy.shutdown();
                }
                if (V8Engine.this.mFileSystemDelegatePolicy != null) {
                    V8Engine.this.mFileSystemDelegatePolicy.destroy();
                }
                int unused = V8Engine.mSurfaceViewWidth = 0;
                int unused2 = V8Engine.mSurfaceViewHeight = 0;
                V8ExecuteCallback v8ExecuteCallback2 = v8ExecuteCallback;
                if (v8ExecuteCallback2 != null) {
                    v8ExecuteCallback2.onExecuted();
                }
            }
        });
    }

    public InspectorNativeClient initInspector(InspectorNativeChannel inspectorNativeChannel) {
        InspectorNativeClient inspectorNativeClient = new InspectorNativeClient(this.mNativeV8Engine, inspectorNativeChannel);
        this.mInspectorNativeClient = inspectorNativeClient;
        return inspectorNativeClient;
    }

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    public void postOnJSThread(Runnable runnable) {
        if (!this.mIsDestroyed.get()) {
            delegateRunnableAsync(runnable);
        } else {
            Log.w(TAG, "postOnJsThread fail. please start engine before execute js task");
        }
    }

    public void postSuspendableTaskOnJSThread(Runnable runnable) {
        if (this.mIsDestroyed.get()) {
            Log.w(TAG, "postOnJsThread fail. please start engine before execute js task");
            return;
        }
        synchronized (this) {
            if (this.mPaused) {
                if (this.mSuspendableTasks == null) {
                    this.mSuspendableTasks = new Vector<>(1);
                }
                this.mSuspendableTasks.add(runnable);
                return;
            }
            delegateRunnableAsync(runnable);
        }
    }

    public void removeJavascriptInterface(final String str) {
        runOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.V8Engine.8
            @Override // java.lang.Runnable
            public void run() {
                if (!V8Engine.this.mIsDestroyed.get()) {
                    V8Engine v8Engine = V8Engine.this;
                    v8Engine.removeJavascriptInterfaceImpl(v8Engine.mNativeV8Engine, str, true);
                    return;
                }
                Log.w(V8Engine.TAG, "removeJavascriptInterface fail. please start engine before execute js task");
            }
        });
    }

    public void removeJavascriptInterfaceForOpenData(final String str) {
        runOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.V8Engine.9
            @Override // java.lang.Runnable
            public void run() {
                if (!V8Engine.this.mIsDestroyed.get()) {
                    V8Engine v8Engine = V8Engine.this;
                    v8Engine.removeJavascriptInterfaceImpl(v8Engine.mNativeV8Engine, str, false);
                    return;
                }
                Log.w(V8Engine.TAG, "removeJavascriptInterfaceForOpenData fail. please start engine before execute js task");
            }
        });
    }

    public synchronized void removeStatusHandler(V8StatusListener v8StatusListener) {
        if (this.mHandlers == null) {
            return;
        }
        this.mHandlers.remove(v8StatusListener);
    }

    public synchronized void removeV8EngineConsole(V8EngineConsole v8EngineConsole) {
        if (this.mConsoles == null) {
            return;
        }
        this.mConsoles.remove(v8EngineConsole);
    }

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    public void runOnJSThread(Runnable runnable) {
        if (!this.mIsDestroyed.get()) {
            delegateRunnable(runnable, false);
        } else {
            Log.w(TAG, "runOnJSThread fail. please start engine before execute js task");
        }
    }

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    public void runOnJSThreadDirectly(Runnable runnable) {
        if (!this.mIsDestroyed.get()) {
            delegateRunnable(runnable, true);
        } else {
            Log.w(TAG, "runOnJSThreadDirectly fail. please start engine before execute js task");
        }
    }

    public void setBdFileRealPath(String str) {
        String trimPath = getTrimPath(str);
        if (trimPath == null) {
            Log.e(TAG, "bdfile path is empy");
        } else if (!this.mDecodeBdfile.equals(trimPath)) {
            this.mDecodeBdfile = trimPath;
            nativeSetBdFileRealPath(this.mNativeV8Engine, trimPath);
        }
    }

    @Deprecated
    public void setCodeCacheSetting(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        useCodeCacheSetting(codeCacheSetting);
    }

    public int setCustomJsCodeCacheHandler(CustomJsCodeCacheHandler customJsCodeCacheHandler) {
        int checkBeforeInvokeNativeMethod = checkBeforeInvokeNativeMethod(true, false, customJsCodeCacheHandler);
        if (checkBeforeInvokeNativeMethod == 0 && (checkBeforeInvokeNativeMethod = nativeSetCustomJsCodeCacheHandler(this.mNativeV8Engine, customJsCodeCacheHandler)) == 0) {
            this.mCustomJsCodeCacheHandler = customJsCodeCacheHandler;
        }
        if (checkBeforeInvokeNativeMethod != 0) {
            Log.w(TAG, "setCustomJsCodeCacheHandler调用失败, 错误码: " + checkBeforeInvokeNativeMethod);
        }
        return checkBeforeInvokeNativeMethod;
    }

    public void setExternalV8BinFilesPath(String str) {
        String str2 = null;
        if (str == null) {
            this.mExternalV8BinPath = null;
            return;
        }
        String trim = str.trim();
        if (!TextUtils.isEmpty(trim)) {
            str2 = trim;
        }
        this.mExternalV8BinPath = str2;
    }

    public void setFileSystemDelegatePolicy(V8FileSystemDelegatePolicy v8FileSystemDelegatePolicy) {
        this.mFileSystemDelegatePolicy = v8FileSystemDelegatePolicy;
    }

    public void setInspectorChannel(InspectorNativeChannel inspectorNativeChannel) {
        this.mInspectorChannel = inspectorNativeChannel;
    }

    public void setIsWorker(boolean z) {
        this.mIsWorker = z;
    }

    @Deprecated
    public void setJSCacheCallback(V8EngineConfiguration.JSCacheCallback jSCacheCallback) {
        this.mJSCacheCallback = jSCacheCallback;
    }

    public void setJavaScriptExceptionDelegate(JavaScriptExceptionDelegate javaScriptExceptionDelegate) {
        this.mExceptionDelegate = javaScriptExceptionDelegate;
    }

    public void setJsCodeCacheCallback(JsCodeCacheCallback jsCodeCacheCallback) {
        this.mJsCodeCacheCallback = jsCodeCacheCallback;
    }

    public void setMainPackageBasePath(String str) {
        String trimPath = getTrimPath(str);
        if (trimPath == null) {
            Log.e(TAG, "mainPacakge path is empty");
        } else if (!this.mMainPackageBasePath.equals(trimPath)) {
            this.mMainPackageBasePath = trimPath;
            nativeSetMainPackageBasePath(this.mNativeV8Engine, trimPath);
        }
    }

    public boolean setNetRequest(NetRequest netRequest) {
        if (setJavaNetRequest(netRequest) == 0) {
            return true;
        }
        return false;
    }

    public void setPreferredFramesPerSecond(short s) {
        if (s > 0 && s <= 60) {
            this.mFramesInterval = (float) (1000 / s);
        }
    }

    public void setThreadName(String str) {
        this.mThreadName = str;
    }

    public void setUserAgent(String str) {
        if (!TextUtils.equals(str, this.mUserAgent)) {
            this.mUserAgent = str;
            nativeSetUserAgent(this.mNativeV8Engine, str);
        }
    }

    public void setWorkerFactoryDelegate(WorkerFactory workerFactory) {
        this.mWorkerFactoryDelegate = workerFactory;
    }

    private void delegateRunnableAsync(Runnable runnable, long j) {
        V8ThreadDelegatePolicy v8ThreadDelegatePolicy = this.mThreadDelegatePolicy;
        if (v8ThreadDelegatePolicy != null) {
            v8ThreadDelegatePolicy.doDelegateRunnable(runnable, j);
        } else {
            Log.w(TAG, "Execute delegateRunnableAsync failed. mThreadDelegatePolicy is null");
        }
    }

    public static void runOnJSThread(long j, Runnable runnable) {
        V8Engine v8Engine = getInstance(j);
        if (v8Engine != null) {
            v8Engine.runOnJSThread(runnable);
        }
    }

    public void addJavascriptInterface(Object obj, String str) {
        addPossiblyUnsafeJavascriptInterface(obj, str, JavascriptInterface.class, true);
    }

    public void addJavascriptInterfaceForOpenData(Object obj, String str) {
        addPossiblyUnsafeJavascriptInterface(obj, str, JavascriptInterface.class, false);
    }

    public JsSerializeValue deserialize(byte[] bArr, boolean z) {
        if (bArr != null && bArr.length != 0 && !this.mIsDestroyed.get()) {
            checkValid(this.mNativeV8Engine, this.mV8ThreadId);
            return nativeDeserialize(this.mNativeV8Engine, bArr, bArr.length, z);
        }
        Log.w(TAG, "deserialize fail. please start engine before execute js task");
        return null;
    }

    @NotProguard
    public synchronized void onConsoleCallBack(int i, String str) {
        switch (i) {
            case 1:
                onLogConsole(str);
                break;
            case 2:
                onDebugConsole(str);
                break;
            case 3:
                onInfoConsole(str);
                break;
            case 4:
                onErrorConsole(str);
                break;
            case 5:
                onWarnConsole(str);
                break;
            case 6:
                onTraceConsole(str);
                break;
        }
    }

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    public void postOnJSThread(Runnable runnable, long j) {
        if (!this.mIsDestroyed.get()) {
            delegateRunnableAsync(runnable, j);
        } else {
            Log.w(TAG, "postOnJsThread fail. please start engine before execute js task");
        }
    }

    @NotProguard
    public void pumpMessageLoop(final long j, long j2) {
        if (j <= 0) {
            return;
        }
        try {
            postOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.V8Engine.5
                @Override // java.lang.Runnable
                public void run() {
                    if (!V8Engine.this.mIsDestroyed.get()) {
                        V8Engine.checkValid(V8Engine.this.mNativeV8Engine, V8Engine.this.mV8ThreadId);
                        V8Engine v8Engine = V8Engine.this;
                        v8Engine.pumpNativeMessageLoop(v8Engine.mNativeV8Engine, j);
                    }
                }
            }, j2);
        } catch (Throwable th) {
            android.util.Log.e(TAG, "", th);
        }
    }

    public void requireJSFile(final String str, final String str2) {
        runOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.V8Engine.10
            @Override // java.lang.Runnable
            public void run() {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !V8Engine.this.mIsDestroyed.get()) {
                    V8Engine v8Engine = V8Engine.this;
                    v8Engine.require(v8Engine.mNativeV8Engine, str, str2, true, false);
                    return;
                }
                Log.w(V8Engine.TAG, "basePath is null ? " + TextUtils.isEmpty(str) + ", filePath is null ?  " + TextUtils.isEmpty(str2) + ", mIsDestroyed = " + V8Engine.this.mIsDestroyed.get());
            }
        });
    }

    public void requireJSFileForOpenData(final String str, final String str2) {
        runOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.V8Engine.11
            @Override // java.lang.Runnable
            public void run() {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !V8Engine.this.mIsDestroyed.get()) {
                    V8Engine v8Engine = V8Engine.this;
                    v8Engine.require(v8Engine.mNativeV8Engine, str, str2, false, false);
                    return;
                }
                Log.w(V8Engine.TAG, "basePath = " + str + ", filePath = " + str2 + ", mIsDestroyed = " + V8Engine.this.mIsDestroyed.get());
            }
        });
    }

    public byte[] serialize(JsSerializeValue jsSerializeValue, boolean z) {
        if (this.mIsDestroyed.get()) {
            Log.w(TAG, "serialize fail. please start engine before execute js task");
            return null;
        }
        checkValid(this.mNativeV8Engine, this.mV8ThreadId);
        return nativeSerialize(this.mNativeV8Engine, jsSerializeValue, z);
    }

    public void throwJSException(final JSExceptionType jSExceptionType, final String str) {
        runOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.V8Engine.6
            @Override // java.lang.Runnable
            public void run() {
                V8Engine.checkValid(V8Engine.this.mNativeV8Engine, V8Engine.this.mV8ThreadId);
                V8Engine v8Engine = V8Engine.this;
                v8Engine.nativeThrowJSException(v8Engine.mNativeV8Engine, jSExceptionType.ordinal(), str, true);
            }
        });
    }

    public void throwJSExceptionForOpenData(final JSExceptionType jSExceptionType, final String str) {
        runOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.V8Engine.7
            @Override // java.lang.Runnable
            public void run() {
                V8Engine.checkValid(V8Engine.this.mNativeV8Engine, V8Engine.this.mV8ThreadId);
                V8Engine v8Engine = V8Engine.this;
                v8Engine.nativeThrowJSException(v8Engine.mNativeV8Engine, jSExceptionType.ordinal(), str, false);
            }
        });
    }

    private void onJsCodeCacheFinished(String str, String str2, boolean z) {
        try {
            if (this.mJsCodeCacheCallback != null) {
                this.mJsCodeCacheCallback.onJsCodeCacheFinished(new JsCodeCacheResult(str, str2, z));
            } else if (this.mJSCacheCallback != null) {
                this.mJSCacheCallback.onCacheResult(new V8EngineConfiguration.CacheInfo(str2, z));
            }
        } catch (Throwable th) {
            Log.w(TAG, "onJsCodeCacheFinished invoke failed. please check the exception message.", th);
        }
    }

    public void evaluateJavascript(final String str, final ValueCallback<String> valueCallback, final String str2) {
        runOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.V8Engine.13
            @Override // java.lang.Runnable
            public void run() {
                V8Engine.this.evaluateJavascriptImpl(str, valueCallback, str2, true);
            }

            @NotProguard
            public String toString() {
                return "evaluateJavascript-" + str2;
            }
        });
    }

    public void evaluateJavascriptForOpenData(final String str, final ValueCallback<String> valueCallback, final String str2) {
        runOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.V8Engine.14
            @Override // java.lang.Runnable
            public void run() {
                V8Engine.this.evaluateJavascriptImpl(str, valueCallback, str2, false);
            }

            @NotProguard
            public String toString() {
                return "evaluateJavascriptForOpenData-" + str2;
            }
        });
    }

    private void addPossiblyUnsafeJavascriptInterface(Object obj, String str, Class<? extends Annotation> cls, boolean z) {
        if (obj != null && this.mNativeV8Engine != 0) {
            if (!this.mIsDestroyed.get()) {
                addJavascriptInterfaceImpl(this.mNativeV8Engine, obj, str, null, z);
                return;
            } else {
                Log.w(TAG, "addPossiblyUnsafeJavascriptInterface fail. please start engine before execute js task");
                return;
            }
        }
        Log.i(TAG, "addPossiblyUnsafeJavascriptInterface object is null or mNativeV8Engine is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void evaluateJavascriptImpl(String str, ValueCallback<String> valueCallback, String str2, boolean z) {
        if (this.mIsDestroyed.get()) {
            Log.w(TAG, "v8engine has been destroyed or not init. please init firstly.");
            return;
        }
        checkValid(this.mNativeV8Engine, this.mV8ThreadId);
        String runScript = runScript(this.mNativeV8Engine, str, str2, z);
        if (valueCallback != null) {
            valueCallback.onReceiveValue(runScript);
        }
    }

    @NotProguard
    public void onV8ExceptionCallBack(String str, String str2, String str3, String str4) {
        if (this.mExceptionDelegate != null) {
            this.mV8ExceptionInfo.reset(System.currentTimeMillis(), str, str2, str3, str4);
            this.mExceptionDelegate.onV8ExceptionCallBack(this.mV8ExceptionInfo);
        }
    }

    private int checkBeforeInvokeNativeMethod(boolean z, boolean z2, Object... objArr) {
        if (z) {
            if (objArr == null) {
                return 3;
            }
            for (Object obj : objArr) {
                if (obj == null) {
                    return 4;
                }
            }
        }
        if (this.mNativeV8Engine != 0 && !this.mIsDestroyed.get()) {
            if (z2) {
                if (this.mThreadDelegatePolicy.getThread() != null) {
                    if (this.mThreadDelegatePolicy.getThread() != null && this.mThreadDelegatePolicy.getThread() != Thread.currentThread()) {
                        return 2;
                    }
                } else {
                    return 2;
                }
            }
            return 0;
        }
        return 5;
    }

    public static void checkValid(long j, long j2) {
        long id = Thread.currentThread().getId();
        if (j2 != 0 && j2 != id) {
            throw new IllegalStateException("javascript or v8 methods must run on v8 thread, current thread id = " + id + ", expect thread id = " + j2);
        } else if (j != 0) {
        } else {
            throw new IllegalStateException("v8 engine has been destroyed!");
        }
    }

    private void delegateRunnable(Runnable runnable, boolean z) {
        V8ThreadDelegatePolicy v8ThreadDelegatePolicy = this.mThreadDelegatePolicy;
        if (v8ThreadDelegatePolicy == null) {
            Log.e(TAG, "delegate runnable failed. please init thread delegate policy");
        } else if (v8ThreadDelegatePolicy.getThread() == Thread.currentThread()) {
            checkValid(this.mNativeV8Engine, this.mV8ThreadId);
            try {
                runnable.run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (z) {
            this.mThreadDelegatePolicy.doDelegateRunnableDirectly(runnable);
        } else {
            this.mThreadDelegatePolicy.doDelegateRunnable(runnable);
        }
    }

    public static void setCrashKeyValue(String str, String str2) {
        try {
            if (sSetCrashKeyValueMethod == null) {
                sSetCrashKeyValueMethod = Class.forName("com.baidu.webkit.internal.ApisInteractWithMario").getDeclaredMethod("setCrashKeyValue", String.class, String.class);
            }
            sSetCrashKeyValueMethod.invoke(null, str, str2);
        } catch (Throwable th) {
            Log.e(TAG, th.getMessage());
        }
    }

    public static V8Engine getInstance() {
        V8Engine v8Engine;
        long id = Thread.currentThread().getId();
        synchronized (sEngines) {
            Iterator<V8Engine> it = sEngines.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                v8Engine = it.next();
                if (v8Engine != null && v8Engine.mV8ThreadId == id) {
                    if (!v8Engine.mIsDestroyed.get()) {
                    }
                }
            }
            v8Engine = null;
        }
        return v8Engine;
    }

    private final MemoryInfo getMemoryInfo() {
        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        MemoryInfo memoryInfo2 = new MemoryInfo();
        memoryInfo2.nativePss = memoryInfo.nativePss;
        memoryInfo2.nativePrivateDirty = memoryInfo.nativePrivateDirty;
        memoryInfo2.dalvikPss = memoryInfo.dalvikPss;
        memoryInfo2.dalvikPrivateDirty = memoryInfo.dalvikPrivateDirty;
        memoryInfo2.totalPss = memoryInfo.getTotalPss();
        memoryInfo2.totalPrivateDirty = memoryInfo.getTotalPrivateDirty();
        memoryInfo2.otherPss = memoryInfo.otherPss;
        memoryInfo2.otherPrivateDirty = memoryInfo.otherPrivateDirty;
        if (Build.VERSION.SDK_INT > 23) {
            try {
                memoryInfo2.summaryJavaHeap = Integer.parseInt(memoryInfo.getMemoryStat("summary.java-heap"));
                memoryInfo2.summaryNativeHeap = Integer.parseInt(memoryInfo.getMemoryStat("summary.native-heap"));
                memoryInfo2.summaryStack = Integer.parseInt(memoryInfo.getMemoryStat("summary.stack"));
                memoryInfo2.summaryGraphics = Integer.parseInt(memoryInfo.getMemoryStat("summary.graphics"));
                memoryInfo2.summaryPrivateOther = Integer.parseInt(memoryInfo.getMemoryStat("summary.private-other"));
                memoryInfo2.summaryTotalPss = Integer.parseInt(memoryInfo.getMemoryStat("summary.total-pss"));
                memoryInfo2.summaryTotalSwap = Integer.parseInt(memoryInfo.getMemoryStat("summary.total-swap"));
            } catch (Throwable unused) {
            }
        }
        return memoryInfo2;
    }

    public void startEngineInternal() {
        Log.i(TAG, "[V8Dispose][mario] java version = 1.3.6.1, nativeVersion = " + nativeGetVersionName());
        try {
        } catch (Exception e) {
            Log.e(TAG, Log.getStackTraceString(e));
        }
        if (!checkVersion()) {
            throw new Exception("[mario] java version and native version dismatch  version: 1.3.6.1 nativeVersion: " + nativeGetVersionName());
        }
        this.mTimer.initialize(this, new Handler(Looper.getMainLooper()));
        nativeSetMemSetMemoryEnable(this.mNativeV8Engine, this.mSetMemSetMemMemoryEnable);
        initializeV8();
        InspectorNativeChannel inspectorNativeChannel = this.mInspectorChannel;
        if (inspectorNativeChannel != null) {
            initInspector(inspectorNativeChannel);
        }
        require(this.mNativeV8Engine, this.mInitBasePath, this.mInitJsPath, true, true);
        nativeOnReady(this.mNativeV8Engine);
        onReady();
    }

    private AssetManager getV8BinAssetManager() {
        if (this.mV8BinAssetManager == null) {
            try {
                String str = this.mExternalV8BinPath;
                if (str == null) {
                    str = getBuildInV8BinPath();
                }
                if (str != null && so1.b(str)) {
                    this.mV8BinAssetManager = (AssetManager) AssetManager.class.newInstance();
                    AssetManager.class.getDeclaredMethod(ALTERNATIVE_ADD_ASSET_PATH_METHOD, String.class).invoke(this.mV8BinAssetManager, str);
                }
                Log.i(TAG, "can't find v8bin'AssetManager, path = " + str);
                return null;
            } catch (Throwable unused) {
                Log.w(TAG, "can not find T7 assetManager, use appContext assetManager to find bin file");
            }
        }
        return this.mV8BinAssetManager;
    }

    private synchronized void postSuspendableTasks() {
        if (this.mSuspendableTasks != null && !this.mSuspendableTasks.isEmpty() && !this.mIsDestroyed.get()) {
            Iterator<Runnable> it = this.mSuspendableTasks.iterator();
            while (it.hasNext()) {
                delegateRunnableAsync(it.next());
            }
            this.mSuspendableTasks.clear();
            return;
        }
        Log.w(TAG, "postSuspendableTasks failed. mSuspendableTasks = " + this.mSuspendableTasks + ", mIsDestroyed = " + this.mIsDestroyed.get());
    }

    private void initialize(Context context, String str, String str2, V8ThreadDelegatePolicy v8ThreadDelegatePolicy, Object obj, Object obj2) {
        boolean z;
        Context applicationContext = context.getApplicationContext();
        sAppContext = applicationContext;
        if (applicationContext != null) {
            ApplicationInfo applicationInfo = applicationContext.getApplicationInfo();
            if (applicationInfo != null) {
                if ((applicationInfo.flags & 2) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                APP_DEBUG = z;
            }
            DiskCodeCacheManager.clearAllOldDiskCodeCacheResources(context, "app_mario");
            DiskCodeCacheManager.clearAllOldDiskCodeCacheResources(context, DiskCodeCacheManager.OLD_DISK_CODE_CACHE_PACKAGE_WEBVIEW_NAME);
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.mInitBasePath = str;
            this.mInitJsPath = str2;
            this.mV8ExceptionInfo = new V8ExceptionInfo();
            this.mJavaBoundObjectManager = new JavaBoundObjectManager();
            this.mTimer = new V8Timer();
            this.mAssetManager = context.getAssets();
            this.mPerformanceJsonBean = new PerformanceJsonBean();
            this.mNativeV8Engine = v8EngineInit();
            this.mIsDestroyed.set(false);
            addJavascriptInterface(new BindingBenchmark(this), "jBenchmark");
            ComponentCallbacks2 componentCallbacks2 = new ComponentCallbacks2() { // from class: com.baidu.searchbox.v8engine.V8Engine.1
                @Override // android.content.ComponentCallbacks
                public void onConfigurationChanged(Configuration configuration) {
                }

                @Override // android.content.ComponentCallbacks
                public void onLowMemory() {
                }

                @Override // android.content.ComponentCallbacks2
                public void onTrimMemory(final int i) {
                    if (!V8Engine.this.isReady()) {
                        Log.w(V8Engine.TAG, "onTrimMemory failed. V8Engine is not ready.");
                    } else {
                        V8Engine.this.postOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.V8Engine.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                int i2;
                                long j = V8Engine.this.mNativeV8Engine;
                                if (i < 15) {
                                    i2 = 1;
                                } else {
                                    i2 = 2;
                                }
                                V8Engine.nativeSetV8GCPressureLevel(j, i2);
                            }
                        });
                    }
                }
            };
            this.mComponentCallbacks2 = componentCallbacks2;
            Context context2 = sAppContext;
            if (context2 != null) {
                context2.registerComponentCallbacks(componentCallbacks2);
            }
            synchronized (sEngines) {
                sEngines.put(Long.valueOf(this.mNativeV8Engine), this);
            }
            if (v8ThreadDelegatePolicy == null) {
                v8ThreadDelegatePolicy = new V8DefaultThreadPolicy(this);
            }
            this.mThreadDelegatePolicy = v8ThreadDelegatePolicy;
            this.mMainGlobalObject = obj;
            this.mOpenGlobalObject = obj2;
            V8NetFunctionTable.addOnCronetThreadInitializedListener(new ValueCallback<Long>() { // from class: com.baidu.searchbox.v8engine.V8Engine.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(Long l) {
                    Log.i(V8Engine.TAG, "[mario-request] nativeInitGlobalV8NetFunctionTable: value = " + l);
                    V8Engine v8Engine = V8Engine.this;
                    v8Engine.nativeInitGlobalV8NetFunctionTable(v8Engine.mNativeV8Engine, l.longValue());
                }
            });
            return;
        }
        throw new RuntimeException("basePath and path must not be null.");
    }

    public long createWorkerV8Engine(long j) {
        Log.e("V8", "!!!!!createWorkerV8Engine, mWorkerFactoryDelegate =  " + this.mWorkerFactoryDelegate);
        WorkerFactory workerFactory = this.mWorkerFactoryDelegate;
        if (workerFactory != null) {
            V8Engine onCreateWorker = workerFactory.onCreateWorker();
            onCreateWorker.setIsWorker(true);
            StringBuilder sb = new StringBuilder();
            sb.append("MarioWT");
            int i = sWorkerID;
            sWorkerID = i + 1;
            sb.append(i);
            onCreateWorker.setThreadName(sb.toString());
            onCreateWorker.startEngine();
            return onCreateWorker.nativePtr();
        }
        Log.e("V8", "ERROR!!!!! no mWorkerFactoryDelegate");
        return 0L;
    }

    public int setJavaNetRequest(NetRequest netRequest) {
        int i;
        if (netRequest == null) {
            i = 2;
        } else if (this.mNativeV8Engine != 0 && !this.mIsDestroyed.get()) {
            if (this.mThreadDelegatePolicy.getThread() != null && (this.mThreadDelegatePolicy.getThread() == null || this.mThreadDelegatePolicy.getThread() == Thread.currentThread())) {
                int nativeSetJavaNetRequest = nativeSetJavaNetRequest(this.mNativeV8Engine, netRequest);
                if (nativeSetJavaNetRequest == 0) {
                    this.mNetRequest = netRequest;
                    netRequest.bindV8Engine(this);
                }
                i = nativeSetJavaNetRequest;
            } else {
                i = 256;
            }
        } else {
            i = 512;
        }
        if (i != 0) {
            Log.w(TAG, "[mario-request] setJavaNetRequest调用失败, 错误码: " + i);
        }
        return i;
    }

    public void setMemSetMemoryEnable(boolean z) {
        Log.i(TAG, "[V8Dispose] Set MemSetMemory enable = " + z);
        boolean z2 = false;
        if (z) {
            String[] strArr = {"MI 6X", "MI 6X MIKU", "REDMI NOTE 5", "REDMI NOTE 7", "V1814A", "V1814T", "V1816A", "V1816T", "VIVO X21", "VIVO X21A", "VIVO X21UD", "VIVO X21UD A", "VIVO Z3X"};
            int i = 0;
            while (true) {
                if (i >= 13) {
                    break;
                } else if (strArr[i].equals(Build.MODEL.toUpperCase())) {
                    z2 = true;
                    break;
                } else {
                    i++;
                }
            }
            this.mSetMemSetMemMemoryEnable = z2;
            return;
        }
        this.mSetMemSetMemMemoryEnable = false;
    }

    public boolean useCodeCacheSetting(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        Context appContext = getAppContext();
        if (appContext == null) {
            Log.w(TAG, "[CodeCache] SetCodeCacheSetting failed. Context is null");
            return false;
        } else if (!DiskCodeCacheManager.isCodeCacheSettingValid(appContext, codeCacheSetting)) {
            Log.w(TAG, "[CodeCache] CodeCacheSetting is invalid.");
            return false;
        } else {
            File createDiskCodeCacheDirectory = DiskCodeCacheManager.createDiskCodeCacheDirectory(appContext, null);
            this.mDiskCodeCachePathFile = createDiskCodeCacheDirectory;
            if (createDiskCodeCacheDirectory == null) {
                Log.w(TAG, "[CodeCache] Create disk code cache directory failed.");
                return false;
            }
            String[] strArr = new String[codeCacheSetting.pathList.size()];
            codeCacheSetting.pathList.toArray(strArr);
            boolean nativeSetCodeCacheSetting = nativeSetCodeCacheSetting(this.mNativeV8Engine, codeCacheSetting.id, this.mDiskCodeCachePathFile.getAbsolutePath(), codeCacheSetting.maxCount, strArr, codeCacheSetting.sizeLimit, codeCacheSetting.diskCodeCacheSizeThreshold);
            if (!nativeSetCodeCacheSetting) {
                Log.w(TAG, "[CodeCache] NativeSetCodeCacheSetting failed.");
            }
            return nativeSetCodeCacheSetting;
        }
    }
}
