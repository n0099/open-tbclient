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
import com.baidu.searchbox.v8engine.thread.V8DefaultThreadPolicy;
import com.baidu.searchbox.v8engine.thread.V8ExecuteCallback;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.smallgame.sdk.Log;
import com.baidu.smallgame.sdk.c.a;
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
/* loaded from: classes20.dex */
public class V8Engine implements JSRuntime {
    public static final String ACTION_CONSTRUCTOR_DONE = "v8_constructor_done";
    public static final String ACTION_NATIVE_INIT = "v8_native_init";
    public static final String ACTION_READY = "v8_ready";
    public static final String ACTION_START_ENGINE_BEGIN = "v8_start_engine_begin";
    public static final String ACTION_START_ENGINE_END = "v8_start_engine_end";
    public static final String ACTION_V8_CREATE_MAIN_CONTEXT_START = "v8_create_main_context";
    public static final String ACTION_V8_REQUIRE_BASE_JS_START = "v8_require_base_js";
    public static final String ACTION_WORKER_INIT = "v8_worker_init";
    private static final String ALTERNATIVE_ADD_ASSET_PATH_METHOD = "addAssetPath";
    private static final String ALTERNATIVE_CACHE_PATH = "webview_baidu";
    private static final String ALTERNATIVE_SO = "libcom.baidu.zeus.so";
    private static boolean APP_DEBUG = false;
    private static final long CLOCKS_PER_SEC = 1000;
    public static final float DEFAULT_FRAMES = 16.666666f;
    private static final String MARIO_CACHE_PATH = "mario";
    private static final String TAG = "V8Engine";
    public static final String TYPE_V8 = "v8";
    private static int mSurfaceViewHeight;
    private static int mSurfaceViewWidth;
    private static Context sAppContext;
    private static final long sEngineDestroyed = 0;
    private static int sWorkerID;
    private AssetManager mAssetManager;
    private V8EngineConfiguration.CacheInfo mCacheInfo;
    private V8EngineConfiguration.CodeCacheSetting mCodeCacheSetting;
    private ComponentCallbacks2 mComponentCallbacks2;
    private JavaScriptExceptionDelegate mExceptionDelegate;
    private V8FileSystemDelegatePolicy mFileSystemDelegatePolicy;
    private String mInitBasePath;
    private String mInitJsPath;
    private InspectorNativeChannel mInspectorChannel;
    private InspectorNativeClient mInspectorNativeClient;
    private V8EngineConfiguration.JSCacheCallback mJSCacheCallback;
    private JavaBoundObjectManager mJavaBoundObjectManager;
    private Object mMainGlobalObject;
    private long mNativeV8Engine;
    private Object mOpenGlobalObject;
    private PerformanceJsonBean mPerformanceJsonBean;
    private volatile boolean mReady;
    private V8ThreadDelegatePolicy mThreadDelegatePolicy;
    private V8Timer mTimer;
    private String mUserAgent;
    private AssetManager mV8BinAssetManager;
    private V8ExceptionInfo mV8ExceptionInfo;
    private static HashMap<Long, V8Engine> sEngines = new HashMap<>();
    private static Method sSetCrashKeyValueMethod = null;
    private static Method sClearCrashKeyMethod = null;
    private String mExternalV8BinPath = null;
    private String mBuildInV8BinPath = null;
    private AtomicBoolean mIsDestroyed = new AtomicBoolean(true);
    private ArrayList<V8StatusListener> mHandlers = null;
    private ArrayList<V8EngineConsole> mConsoles = null;
    private String mDecodeBdfile = "";
    private String mMainPackageBasePath = "";
    private volatile boolean mPaused = false;
    private Vector<Runnable> mSuspendableTasks = null;
    private long mV8ThreadId = 0;
    private float mFramesInterval = 16.666666f;
    private String mThreadName = "V8JavaScriptContext";
    private WorkerFactory mWorkerFactoryDelegate = null;
    private boolean mIsWorker = false;

    /* loaded from: classes20.dex */
    public interface JavaScriptExceptionDelegate {
        void onV8ExceptionCallBack(V8ExceptionInfo v8ExceptionInfo);
    }

    /* loaded from: classes20.dex */
    public interface V8EngineConsole {
        void onDebugConsole(String str);

        void onErrorConsole(String str);

        void onInfoConsole(String str);

        void onLogConsole(String str);

        void onTraceConsole(String str);

        void onWarnConsole(String str);
    }

    /* loaded from: classes20.dex */
    public interface V8StatusListener {
        void onPause();

        void onReady();

        void onResume();
    }

    /* loaded from: classes20.dex */
    public interface WorkerFactory {
        V8Engine onCreateWorker();
    }

    private native void addJavascriptInterfaceImpl(long j, Object obj, String str, Class cls, boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void nativeDeleteJsReleaser(long j, long j2, boolean z);

    private native JsSerializeValue nativeDeserialize(long j, byte[] bArr, int i, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeDestroyOpenDataContext(long j);

    private static native long nativeGetChannelFunctionTable();

    private static native int nativeGetVersionCode();

    private static native String nativeGetVersionName();

    private native void nativeOnReady(long j);

    private native byte[] nativeSerialize(long j, JsSerializeValue jsSerializeValue, boolean z);

    private native void nativeSetBdFileRealPath(long j, String str);

    private native void nativeSetCodeCacheSetting(long j, String str, String str2, int i, String[] strArr, int i2);

    private native void nativeSetMainPackageBasePath(long j, String str);

    private native void nativeSetUserAgent(long j, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetV8GCPressureLevel(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeThrowJSException(long j, int i, String str, boolean z);

    private static native String nativeToColorRGBA(String str);

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
        sWorkerID = 0;
        APP_DEBUG = false;
        mSurfaceViewWidth = 0;
        mSurfaceViewHeight = 0;
    }

    public boolean isWorker() {
        return this.mIsWorker;
    }

    public void setIsWorker(boolean z) {
        this.mIsWorker = z;
    }

    public long nativePtr() {
        return this.mNativeV8Engine;
    }

    public V8FileSystemDelegatePolicy getFileSystemDelegatePolicy() {
        return this.mFileSystemDelegatePolicy;
    }

    public String threadName() {
        return this.mThreadName;
    }

    public void setThreadName(String str) {
        this.mThreadName = str;
    }

    private String getTrimPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() != 0) {
            return trim;
        }
        return null;
    }

    public void setBdFileRealPath(String str) {
        String trimPath = getTrimPath(str);
        if (trimPath == null) {
            Log.e(TAG, "bdfile path is empy");
        } else if (!this.mDecodeBdfile.equals(trimPath)) {
            this.mDecodeBdfile = trimPath;
            nativeSetBdFileRealPath(this.mNativeV8Engine, this.mDecodeBdfile);
        }
    }

    public InspectorNativeClient getInspectorNativeClient() {
        return this.mInspectorNativeClient;
    }

    public void setInspectorChannel(InspectorNativeChannel inspectorNativeChannel) {
        this.mInspectorChannel = inspectorNativeChannel;
    }

    public void setCodeCacheSetting(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        this.mCodeCacheSetting = codeCacheSetting;
        if (this.mCodeCacheSetting.id != null && this.mCodeCacheSetting.pathList != null) {
            File dir = getAppContext().getDir(ALTERNATIVE_CACHE_PATH, 0);
            if (!a.it(getBuildInV8BinPath())) {
                dir = getAppContext().getDir(MARIO_CACHE_PATH, 0);
                dir.mkdirs();
            }
            if (dir.exists()) {
                String[] strArr = new String[codeCacheSetting.pathList.size()];
                codeCacheSetting.pathList.toArray(strArr);
                nativeSetCodeCacheSetting(this.mNativeV8Engine, codeCacheSetting.id, dir.getAbsolutePath(), codeCacheSetting.maxCount, strArr, codeCacheSetting.sizeLimit);
            }
        }
    }

    public JSONArray getPerformanceJson() {
        return this.mPerformanceJsonBean == null ? new JSONArray() : this.mPerformanceJsonBean.toJSONArray();
    }

    public PerformanceJsonBean getPerformanceJsonBean() {
        return this.mPerformanceJsonBean;
    }

    public void setJSCacheCallback(V8EngineConfiguration.JSCacheCallback jSCacheCallback) {
        this.mJSCacheCallback = jSCacheCallback;
    }

    private void onJsCacheCallback(String str, boolean z) {
        if (this.mJSCacheCallback != null) {
            this.mCacheInfo.jsPath = str;
            this.mCacheInfo.cached = z;
            this.mJSCacheCallback.onCacheResult(this.mCacheInfo);
        }
    }

    public void setMainPackageBasePath(String str) {
        String trimPath = getTrimPath(str);
        if (trimPath == null) {
            Log.e(TAG, "mainPacakge path is empty");
        } else if (!this.mMainPackageBasePath.equals(trimPath)) {
            this.mMainPackageBasePath = trimPath;
            nativeSetMainPackageBasePath(this.mNativeV8Engine, this.mMainPackageBasePath);
        }
    }

    public String getBdFileRealPath() {
        return this.mDecodeBdfile;
    }

    public String getMainPackageBasePath() {
        return this.mMainPackageBasePath;
    }

    public void setFileSystemDelegatePolicy(V8FileSystemDelegatePolicy v8FileSystemDelegatePolicy) {
        this.mFileSystemDelegatePolicy = v8FileSystemDelegatePolicy;
    }

    public V8Engine(Context context, String str, String str2, V8ThreadDelegatePolicy v8ThreadDelegatePolicy, Object obj, Object obj2) {
        initialize(context, str, str2, v8ThreadDelegatePolicy, obj, obj2);
    }

    private void initialize(Context context, String str, String str2, V8ThreadDelegatePolicy v8ThreadDelegatePolicy, Object obj, Object obj2) {
        ApplicationInfo applicationInfo;
        sAppContext = context.getApplicationContext();
        if (sAppContext != null && (applicationInfo = sAppContext.getApplicationInfo()) != null) {
            APP_DEBUG = (applicationInfo.flags & 2) != 0;
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
            this.mComponentCallbacks2 = new ComponentCallbacks2() { // from class: com.baidu.searchbox.v8engine.V8Engine.1
                @Override // android.content.ComponentCallbacks2
                public void onTrimMemory(final int i) {
                    V8Engine.this.postOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.V8Engine.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            V8Engine.nativeSetV8GCPressureLevel(V8Engine.this.mNativeV8Engine, i < 15 ? 1 : 2);
                        }
                    });
                }

                @Override // android.content.ComponentCallbacks
                public void onConfigurationChanged(Configuration configuration) {
                }

                @Override // android.content.ComponentCallbacks
                public void onLowMemory() {
                }
            };
            sAppContext.registerComponentCallbacks(this.mComponentCallbacks2);
            synchronized (sEngines) {
                sEngines.put(Long.valueOf(this.mNativeV8Engine), this);
            }
            if (v8ThreadDelegatePolicy == null) {
                v8ThreadDelegatePolicy = new V8DefaultThreadPolicy(this);
            }
            this.mThreadDelegatePolicy = v8ThreadDelegatePolicy;
            this.mMainGlobalObject = obj;
            this.mOpenGlobalObject = obj2;
            this.mCacheInfo = new V8EngineConfiguration.CacheInfo(null, false);
            return;
        }
        throw new RuntimeException("basePath and path must not be null.");
    }

    public Object getOpenGlobalObject() {
        return this.mOpenGlobalObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkValid(long j, long j2) {
        long id = Thread.currentThread().getId();
        if (j2 != 0 && j2 != id) {
            throw new IllegalStateException("javascript or v8 methods must run on v8 thread, current thread id = " + id + ", expect thread id = " + j2);
        }
        if (j == 0) {
            throw new IllegalStateException("v8 engine has been destroyed!");
        }
    }

    public void setPreferredFramesPerSecond(short s) {
        if (s > 0 && s <= 60) {
            this.mFramesInterval = (float) (1000 / s);
        }
    }

    public float minFramesInterval() {
        return this.mFramesInterval;
    }

    public static V8Engine getInstance(long j) {
        synchronized (sEngines) {
            V8Engine v8Engine = sEngines.get(Long.valueOf(j));
            if (v8Engine == null || v8Engine.mIsDestroyed.get()) {
                return null;
            }
            return v8Engine;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0030, code lost:
        if (r0.mIsDestroyed.get() == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
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
                if (v8Engine == null || v8Engine.mV8ThreadId != id) {
                }
            }
            v8Engine = null;
        }
        return v8Engine;
    }

    public AssetManager getAssetManager() {
        return this.mAssetManager;
    }

    public static Context getAppContext() {
        return sAppContext;
    }

    public static boolean isDebug() {
        return APP_DEBUG;
    }

    public synchronized void startEngine() {
        if (this.mThreadDelegatePolicy != null) {
            this.mThreadDelegatePolicy.startV8Engine(this);
        } else {
            Log.w(TAG, "startV8Engine failed. please init thread delegate policy before");
        }
    }

    public void startEngineInternal() {
        Log.i(TAG, "[V8Dispose][mario] java version = 1.3.1.15, nativeVersion = " + nativeGetVersionName());
        try {
            if (!checkVersion()) {
                throw new Exception("[mario] java version and native version dismatch  version: 1.3.1.15 nativeVersion: " + nativeGetVersionName());
            }
        } catch (Exception e) {
            Log.e(TAG, Log.getStackTraceString(e));
        }
        this.mTimer.initialize(this, new Handler(Looper.getMainLooper()));
        initializeV8();
        if (this.mInspectorChannel != null) {
            initInspector(this.mInspectorChannel);
        }
        require(this.mNativeV8Engine, this.mInitBasePath, this.mInitJsPath, true, true);
        nativeOnReady(this.mNativeV8Engine);
        onReady();
    }

    public void initializeV8() {
        Log.i(TAG, "[V8Dispose] Initializing V8Engine");
        this.mV8ThreadId = Thread.currentThread().getId();
        V8NativeInit.initialize(this.mNativeV8Engine, this.mAssetManager, getV8BinAssetManager(), this.mTimer, this.mMainGlobalObject, this.mV8ThreadId);
    }

    public void setExternalV8BinFilesPath(String str) {
        if (str == null) {
            this.mExternalV8BinPath = null;
            return;
        }
        String trim = str.trim();
        this.mExternalV8BinPath = TextUtils.isEmpty(trim) ? null : trim;
    }

    private String getBuildInV8BinPath() {
        if (this.mBuildInV8BinPath == null) {
            this.mBuildInV8BinPath = getAppContext().getApplicationInfo().nativeLibraryDir + File.separator + "libcom.baidu.zeus.so";
        }
        return this.mBuildInV8BinPath;
    }

    private AssetManager getV8BinAssetManager() {
        if (this.mV8BinAssetManager == null) {
            try {
                String str = this.mExternalV8BinPath;
                String buildInV8BinPath = str == null ? getBuildInV8BinPath() : str;
                if (buildInV8BinPath == null || !a.it(buildInV8BinPath)) {
                    Log.i(TAG, "can't find v8bin'AssetManager, path = " + buildInV8BinPath);
                    return null;
                }
                this.mV8BinAssetManager = (AssetManager) AssetManager.class.newInstance();
                AssetManager.class.getDeclaredMethod(ALTERNATIVE_ADD_ASSET_PATH_METHOD, String.class).invoke(this.mV8BinAssetManager, buildInV8BinPath);
            } catch (Throwable th) {
                Log.w(TAG, "can not find T7 assetManager, use appContext assetManager to find bin file");
            }
        }
        return this.mV8BinAssetManager;
    }

    private boolean checkVersion() {
        Log.w(TAG, "[mario] version: 1.3.1.15 nativeVersion: " + nativeGetVersionName());
        return "1.3.1.15".equals(nativeGetVersionName()) && 15 == nativeGetVersionCode();
    }

    public synchronized boolean isPaused() {
        return this.mPaused;
    }

    private void onReady() {
        this.mReady = true;
        if (this.mHandlers != null) {
            for (V8StatusListener v8StatusListener : new ArrayList(this.mHandlers)) {
                v8StatusListener.onReady();
            }
        }
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

    public void setUserAgent(String str) {
        if (!TextUtils.equals(str, this.mUserAgent)) {
            this.mUserAgent = str;
            nativeSetUserAgent(this.mNativeV8Engine, this.mUserAgent);
        }
    }

    public String userAgent() {
        return this.mUserAgent;
    }

    public boolean isReady() {
        return this.mReady;
    }

    public boolean isDestroyed() {
        return this.mIsDestroyed.get();
    }

    public void destroyEngine(final V8ExecuteCallback v8ExecuteCallback) {
        Log.e("V8", "v8engine.java::destroyEngine");
        runOnJSThreadDirectly(new Runnable() { // from class: com.baidu.searchbox.v8engine.V8Engine.2
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
                V8Engine.this.v8EngineDestroy(V8Engine.this.mNativeV8Engine);
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
                if (v8ExecuteCallback != null) {
                    v8ExecuteCallback.onExecuted();
                }
            }
        });
    }

    private void delegateRunnable(Runnable runnable, boolean z) {
        if (this.mThreadDelegatePolicy == null) {
            Log.e(TAG, "delegate runnable failed. please init thread delegate policy");
        } else if (this.mThreadDelegatePolicy.getThread() == Thread.currentThread()) {
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

    private void delegateRunnableAsync(Runnable runnable) {
        this.mThreadDelegatePolicy.doDelegateRunnable(runnable);
    }

    private void delegateRunnableAsync(Runnable runnable, long j) {
        this.mThreadDelegatePolicy.doDelegateRunnable(runnable, j);
    }

    @NotProguard
    public void pumpMessageLoop() {
        try {
            postOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.V8Engine.3
                @Override // java.lang.Runnable
                public void run() {
                    if (!V8Engine.this.mIsDestroyed.get()) {
                        V8Engine.checkValid(V8Engine.this.mNativeV8Engine, V8Engine.this.mV8ThreadId);
                        V8Engine.this.pumpNativeMessageLoop(V8Engine.this.mNativeV8Engine, 0L);
                    }
                }
            });
        } catch (Throwable th) {
            android.util.Log.e(TAG, "", th);
        }
    }

    @NotProguard
    public void pumpMessageLoop(final long j, long j2) {
        if (j > 0) {
            try {
                postOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.V8Engine.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!V8Engine.this.mIsDestroyed.get()) {
                            V8Engine.checkValid(V8Engine.this.mNativeV8Engine, V8Engine.this.mV8ThreadId);
                            V8Engine.this.pumpNativeMessageLoop(V8Engine.this.mNativeV8Engine, j);
                        }
                    }
                }, j2);
            } catch (Throwable th) {
                android.util.Log.e(TAG, "", th);
            }
        }
    }

    public synchronized void addStatusHandler(V8StatusListener v8StatusListener) {
        if (this.mReady) {
            v8StatusListener.onReady();
        } else {
            if (this.mHandlers == null) {
                this.mHandlers = new ArrayList<>(1);
            }
            this.mHandlers.add(v8StatusListener);
        }
    }

    public synchronized void removeStatusHandler(V8StatusListener v8StatusListener) {
        if (this.mHandlers != null) {
            this.mHandlers.remove(v8StatusListener);
        }
    }

    public void throwJSException(final JSExceptionType jSExceptionType, final String str) {
        runOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.V8Engine.5
            @Override // java.lang.Runnable
            public void run() {
                V8Engine.checkValid(V8Engine.this.mNativeV8Engine, V8Engine.this.mV8ThreadId);
                V8Engine.this.nativeThrowJSException(V8Engine.this.mNativeV8Engine, jSExceptionType.ordinal(), str, true);
            }
        });
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

    public static void runOnJSThread(long j, Runnable runnable) {
        V8Engine v8Engine = getInstance(j);
        if (v8Engine != null) {
            v8Engine.runOnJSThread(runnable);
        }
    }

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    public void postOnJSThread(Runnable runnable) {
        if (!this.mIsDestroyed.get()) {
            delegateRunnableAsync(runnable);
        } else {
            Log.w(TAG, "postOnJsThread fail. please start engine before execute js task");
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

    private synchronized void postSuspendableTasks() {
        if (this.mSuspendableTasks == null || this.mSuspendableTasks.isEmpty() || this.mIsDestroyed.get()) {
            Log.w(TAG, "postSuspendableTasks failed. mSuspendableTasks = " + this.mSuspendableTasks + ", mIsDestroyed = " + this.mIsDestroyed.get());
        } else {
            Iterator<Runnable> it = this.mSuspendableTasks.iterator();
            while (it.hasNext()) {
                delegateRunnableAsync(it.next());
            }
            this.mSuspendableTasks.clear();
        }
    }

    public void throwJSExceptionForOpenData(final JSExceptionType jSExceptionType, final String str) {
        runOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.V8Engine.6
            @Override // java.lang.Runnable
            public void run() {
                V8Engine.checkValid(V8Engine.this.mNativeV8Engine, V8Engine.this.mV8ThreadId);
                V8Engine.this.nativeThrowJSException(V8Engine.this.mNativeV8Engine, jSExceptionType.ordinal(), str, false);
            }
        });
    }

    public String getInitBasePath() {
        return this.mInitBasePath;
    }

    public synchronized void addV8EngineConsole(V8EngineConsole v8EngineConsole) {
        if (this.mConsoles == null) {
            this.mConsoles = new ArrayList<>(1);
        }
        this.mConsoles.add(v8EngineConsole);
    }

    public synchronized void removeV8EngineConsole(V8EngineConsole v8EngineConsole) {
        if (this.mConsoles != null) {
            this.mConsoles.remove(v8EngineConsole);
        }
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

    private void onLogConsole(String str) {
        if (this.mConsoles != null) {
            for (V8EngineConsole v8EngineConsole : new ArrayList(this.mConsoles)) {
                v8EngineConsole.onLogConsole(str);
            }
        }
    }

    private void onDebugConsole(String str) {
        if (this.mConsoles != null) {
            for (V8EngineConsole v8EngineConsole : new ArrayList(this.mConsoles)) {
                v8EngineConsole.onDebugConsole(str);
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

    private void onErrorConsole(String str) {
        if (this.mConsoles != null) {
            for (V8EngineConsole v8EngineConsole : new ArrayList(this.mConsoles)) {
                v8EngineConsole.onErrorConsole(str);
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

    private void onTraceConsole(String str) {
        if (this.mConsoles != null) {
            for (V8EngineConsole v8EngineConsole : new ArrayList(this.mConsoles)) {
                v8EngineConsole.onTraceConsole(str);
            }
        }
    }

    public void setWorkerFactoryDelegate(WorkerFactory workerFactory) {
        this.mWorkerFactoryDelegate = workerFactory;
    }

    public long createWorkerV8Engine(long j) {
        Log.e("V8", "!!!!!createWorkerV8Engine, mWorkerFactoryDelegate =  " + this.mWorkerFactoryDelegate);
        if (this.mWorkerFactoryDelegate != null) {
            V8Engine onCreateWorker = this.mWorkerFactoryDelegate.onCreateWorker();
            onCreateWorker.setIsWorker(true);
            StringBuilder append = new StringBuilder().append("MarioWT");
            int i = sWorkerID;
            sWorkerID = i + 1;
            onCreateWorker.setThreadName(append.append(i).toString());
            onCreateWorker.startEngine();
            return onCreateWorker.nativePtr();
        }
        Log.e("V8", "ERROR!!!!! no mWorkerFactoryDelegate");
        return 0L;
    }

    public void destroyWorkerV8Engine() {
        destroyEngine(null);
    }

    public void setJavaScriptExceptionDelegate(JavaScriptExceptionDelegate javaScriptExceptionDelegate) {
        this.mExceptionDelegate = javaScriptExceptionDelegate;
    }

    @NotProguard
    public void onV8ExceptionCallBack(String str, String str2, String str3, String str4) {
        if (this.mExceptionDelegate != null) {
            this.mV8ExceptionInfo.reset(System.currentTimeMillis(), str, str2, str3, str4);
            this.mExceptionDelegate.onV8ExceptionCallBack(this.mV8ExceptionInfo);
        }
    }

    public void addJavascriptInterface(Object obj, String str) {
        addPossiblyUnsafeJavascriptInterface(obj, str, JavascriptInterface.class, true);
    }

    public void addJavascriptInterfaceForOpenData(Object obj, String str) {
        addPossiblyUnsafeJavascriptInterface(obj, str, JavascriptInterface.class, false);
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

    public void removeJavascriptInterface(final String str) {
        runOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.V8Engine.7
            @Override // java.lang.Runnable
            public void run() {
                if (!V8Engine.this.mIsDestroyed.get()) {
                    V8Engine.this.removeJavascriptInterfaceImpl(V8Engine.this.mNativeV8Engine, str, true);
                } else {
                    Log.w(V8Engine.TAG, "removeJavascriptInterface fail. please start engine before execute js task");
                }
            }
        });
    }

    public void removeJavascriptInterfaceForOpenData(final String str) {
        runOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.V8Engine.8
            @Override // java.lang.Runnable
            public void run() {
                if (!V8Engine.this.mIsDestroyed.get()) {
                    V8Engine.this.removeJavascriptInterfaceImpl(V8Engine.this.mNativeV8Engine, str, false);
                } else {
                    Log.w(V8Engine.TAG, "removeJavascriptInterfaceForOpenData fail. please start engine before execute js task");
                }
            }
        });
    }

    public void requireJSFile(final String str, final String str2) {
        runOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.V8Engine.9
            @Override // java.lang.Runnable
            public void run() {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !V8Engine.this.mIsDestroyed.get()) {
                    V8Engine.this.require(V8Engine.this.mNativeV8Engine, str, str2, true, false);
                } else {
                    Log.w(V8Engine.TAG, "basePath is null ? " + TextUtils.isEmpty(str) + ", filePath is null ?  " + TextUtils.isEmpty(str2) + ", mIsDestroyed = " + V8Engine.this.mIsDestroyed.get());
                }
            }
        });
    }

    public void requireJSFileForOpenData(final String str, final String str2) {
        runOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.V8Engine.10
            @Override // java.lang.Runnable
            public void run() {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !V8Engine.this.mIsDestroyed.get()) {
                    V8Engine.this.require(V8Engine.this.mNativeV8Engine, str, str2, false, false);
                } else {
                    Log.w(V8Engine.TAG, "basePath = " + str + ", filePath = " + str2 + ", mIsDestroyed = " + V8Engine.this.mIsDestroyed.get());
                }
            }
        });
    }

    public void destroyOpenDataContext() {
        runOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.V8Engine.11
            @Override // java.lang.Runnable
            public void run() {
                if (!V8Engine.this.mIsDestroyed.get()) {
                    V8Engine.this.nativeDestroyOpenDataContext(V8Engine.this.mNativeV8Engine);
                } else {
                    Log.w(V8Engine.TAG, "destroyOpenDataContext fail. please start engine before execute js task");
                }
            }
        });
    }

    public void evaluateJavascript(final String str, final ValueCallback<String> valueCallback, final String str2) {
        runOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.V8Engine.12
            @NotProguard
            public String toString() {
                return "evaluateJavascript-" + str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                V8Engine.this.evaluateJavascriptImpl(str, valueCallback, str2, true);
            }
        });
    }

    public void evaluateJavascriptForOpenData(final String str, final ValueCallback<String> valueCallback, final String str2) {
        runOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.V8Engine.13
            @NotProguard
            public String toString() {
                return "evaluateJavascriptForOpenData-" + str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                V8Engine.this.evaluateJavascriptImpl(str, valueCallback, str2, false);
            }
        });
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

    public static String toColorRGBA(String str) {
        return nativeToColorRGBA(str);
    }

    public InspectorNativeClient initInspector(InspectorNativeChannel inspectorNativeChannel) {
        this.mInspectorNativeClient = new InspectorNativeClient(this.mNativeV8Engine, inspectorNativeChannel);
        return this.mInspectorNativeClient;
    }

    public byte[] serialize(JsSerializeValue jsSerializeValue, boolean z) {
        if (this.mIsDestroyed.get()) {
            Log.w(TAG, "serialize fail. please start engine before execute js task");
            return null;
        }
        checkValid(this.mNativeV8Engine, this.mV8ThreadId);
        return nativeSerialize(this.mNativeV8Engine, jsSerializeValue, z);
    }

    public JsSerializeValue deserialize(byte[] bArr, boolean z) {
        if (bArr == null || bArr.length == 0 || this.mIsDestroyed.get()) {
            Log.w(TAG, "deserialize fail. please start engine before execute js task");
            return null;
        }
        checkValid(this.mNativeV8Engine, this.mV8ThreadId);
        return nativeDeserialize(this.mNativeV8Engine, bArr, bArr.length, z);
    }

    @NotProguard
    /* loaded from: classes20.dex */
    static class MemoryInfo {
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

        MemoryInfo() {
        }
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
            } catch (Throwable th) {
            }
        }
        return memoryInfo2;
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

    private static void regiestMessageChannelForT7() {
        try {
            Class.forName("com.baidu.webkit.internal.ApisInteractWithMario").getDeclaredMethod("setMessageChannalFunctoinTable", Long.TYPE).invoke(null, Long.valueOf(nativeGetChannelFunctionTable()));
        } catch (Throwable th) {
            Log.e(TAG, th.getMessage());
        }
    }
}
