package com.baidu.searchbox.v8engine;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.searchbox.v8engine.filesystem.V8FileSystemDelegatePolicy;
import com.baidu.searchbox.v8engine.thread.V8DefaultThreadPolicy;
import com.baidu.searchbox.v8engine.thread.V8ExecuteCallback;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.smallgame.sdk.Log;
import com.baidu.smallgame.sdk.b.a;
import java.io.File;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
@NotProguard
/* loaded from: classes2.dex */
public class V8Engine implements JSRuntime {
    private static final String ALTERNATIVE_ADD_ASSET_PATH_METHOD = "addAssetPath";
    private static final String ALTERNATIVE_CACHE_PATH = "webview_baidu";
    private static final String ALTERNATIVE_SO = "libcom.baidu.zeus.so";
    private static final long CLOCKS_PER_SEC = 1000;
    private static final String MARIO_CACHE_PATH = "mario";
    private static final String TAG = "V8Engine";
    private static AssetManager mAltAssetManager = null;
    private static int mSurfaceViewHeight = 0;
    private static int mSurfaceViewWidth = 0;
    private static Context sAppContext = null;
    private static final long sEngineDestroyed = -1;
    private static HashMap<Long, V8Engine> sEngines = new HashMap<>();
    private AssetManager mAssetManager;
    private V8EngineConfiguration.CodeCacheSetting mCodeCacheSetting;
    private final ComponentCallbacks2 mComponentCallbacks2;
    private JavaScriptExceptionDelegate mExceptionDelegate;
    private V8FileSystemDelegatePolicy mFileSystemDelegatePolicy;
    private V8EngineConfiguration.CacheInfo mInfo;
    private String mInitBasePath;
    private String mInitJsPath;
    private InspectorNativeClient mInspectorNativeClient;
    private V8EngineConfiguration.JSCacheCallback mJSCacheCallback;
    private Object mMainGlobalObject;
    private long mNativeV8Engine;
    private Object mOpenGlobalObject;
    private boolean mReady;
    private V8ThreadDelegatePolicy mThreadDelegatePolicy;
    private V8Timer mTimer;
    private String mUserAgent;
    private ArrayList<V8StatusListener> mHandlers = null;
    private ArrayList<V8EngineConsole> mConsoles = null;
    private final Map<String, Pair<Object, Class>> mJavaScriptInterfaces = new HashMap();
    private String mDecodeBdfile = "";
    private String mMainPackageBasePath = "";
    private volatile boolean mPaused = false;
    private Vector<Runnable> mSuspendableTasks = null;
    private long mV8ThreadId = 0;
    private float mFramesInterval = 0.0f;

    /* loaded from: classes2.dex */
    public interface JavaScriptExceptionDelegate {
        void onV8ExceptionCallBack(String str, String str2);
    }

    /* loaded from: classes2.dex */
    public interface V8EngineConsole {
        void onDebugConsole(String str);

        void onErrorConsole(String str);

        void onInfoConsole(String str);

        void onLogConsole(String str);

        void onTraceConsole(String str);

        void onWarnConsole(String str);
    }

    /* loaded from: classes2.dex */
    public interface V8StatusListener {
        void onPause();

        void onReady();

        void onResume();
    }

    private native void addJavascriptInterfaceImpl(long j, Object obj, String str, Class cls, boolean z);

    private native JsSerializeValue nativeDeserialize(long j, byte[] bArr, int i, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeDestroyOpenDataContext(long j);

    private static native long nativeGetChannelFunctionTable();

    private static native int nativeGetPreferredFramesPerSecond();

    private static native int nativeGetVersionCode();

    private static native String nativeGetVersionName();

    public static native void nativeInitFonts(Map<String, String> map, Object[] objArr);

    public static native void nativeNotifyGCMemoryAllocate(int i);

    public static native void nativeNotifyGCMemoryFree(int i);

    private native byte[] nativeSerialize(long j, JsSerializeValue jsSerializeValue, boolean z);

    private native void nativeSetBdFileRealPath(long j, String str);

    private native void nativeSetCodeCacheSetting(long j, String str, String str2, int i, String[] strArr, int i2);

    public static native void nativeSetDisplayMetrics(float f, float f2, float f3, float f4, float f5);

    private native void nativeSetMainPackageBasePath(long j, String str);

    public static native void nativeSetSize(float f, float f2);

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
    public native void require(long j, String str, String str2, boolean z);

    private native String runScript(long j, String str, String str2, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native void v8EngineDestroy(long j);

    private native long v8EngineInit();

    public native int nativeInitPreferredFramesPerSecond(short s);

    static {
        V8SoLoader.load();
        regiestMessageChannelForT7();
        mSurfaceViewWidth = 0;
        mSurfaceViewHeight = 0;
    }

    public V8FileSystemDelegatePolicy getFileSystemDelegatePolicy() {
        return this.mFileSystemDelegatePolicy;
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

    public void setCodeCacheSetting(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        this.mCodeCacheSetting = codeCacheSetting;
        if (this.mCodeCacheSetting.id != null && this.mCodeCacheSetting.pathList != null) {
            File dir = getAppContext().getDir(ALTERNATIVE_CACHE_PATH, 0);
            if (!a.existsFile(getAlternativeFilePath())) {
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

    public void setJSCacheCallback(V8EngineConfiguration.JSCacheCallback jSCacheCallback) {
        this.mJSCacheCallback = jSCacheCallback;
    }

    private void onJsCacheCallback(String str, boolean z) {
        if (this.mJSCacheCallback != null) {
            this.mInfo.jsPath = str;
            this.mInfo.cached = z;
            this.mJSCacheCallback.onCacheResult(this.mInfo);
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
        sAppContext = context.getApplicationContext();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.mInitBasePath = str;
            this.mInitJsPath = str2;
            this.mTimer = new V8Timer();
            this.mAssetManager = context.getAssets();
            this.mNativeV8Engine = v8EngineInit();
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
            this.mThreadDelegatePolicy = v8ThreadDelegatePolicy == null ? new V8DefaultThreadPolicy(this) : v8ThreadDelegatePolicy;
            this.mMainGlobalObject = obj;
            this.mOpenGlobalObject = obj2;
            this.mInfo = new V8EngineConfiguration.CacheInfo(null, false);
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
        if (j == -1) {
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
            if (v8Engine == null || v8Engine.isDestroyed()) {
                return null;
            }
            return v8Engine;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002e, code lost:
        if (r0.isDestroyed() == false) goto L15;
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

    public static int getPreferredFramesPerSecond() {
        return nativeGetPreferredFramesPerSecond();
    }

    public AssetManager getAssetManager() {
        return this.mAssetManager;
    }

    public static Context getAppContext() {
        return sAppContext;
    }

    public synchronized void startEngine() {
        this.mThreadDelegatePolicy.startV8Engine(this);
    }

    public void startEngineInternal() {
        try {
            if (!checkVersion()) {
                throw new Exception("[mario] java version and native version dismatch  version: 1.1.1.92 nativeVersion: " + nativeGetVersionName());
            }
        } catch (Exception e) {
            Log.e(TAG, Log.getStackTraceString(e));
        }
        this.mTimer.initialize(this, new Handler(Looper.getMainLooper()));
        initializeV8();
        require(this.mNativeV8Engine, this.mInitBasePath, this.mInitJsPath, true);
        onReady();
    }

    public void initializeV8() {
        Log.i(TAG, "[V8Dispose] Initializing V8Engine");
        this.mV8ThreadId = Thread.currentThread().getId();
        V8NativeInit.initialize(this.mNativeV8Engine, this.mAssetManager, getAlternativeAssetManager(), this.mTimer, this.mMainGlobalObject, this.mV8ThreadId);
        initDisplayMetrics();
    }

    private static String getAlternativeFilePath() {
        if (getAppContext() != null) {
            return getAppContext().getApplicationInfo().nativeLibraryDir + File.separator + ALTERNATIVE_SO;
        }
        return null;
    }

    private static AssetManager getAlternativeAssetManager() {
        if (mAltAssetManager == null) {
            try {
                String alternativeFilePath = getAlternativeFilePath();
                if (a.existsFile(alternativeFilePath)) {
                    mAltAssetManager = (AssetManager) AssetManager.class.newInstance();
                    AssetManager.class.getDeclaredMethod(ALTERNATIVE_ADD_ASSET_PATH_METHOD, String.class).invoke(mAltAssetManager, alternativeFilePath);
                }
            } catch (Throwable th) {
                Log.w(TAG, "can not find T7 assetManager, use appContext assetManager to find bin file");
            }
        }
        return mAltAssetManager;
    }

    public static void updateSurfaceViewSize(int i, int i2) {
        Log.w(TAG, "[V8Dispose] updateSurfaceViewSize, width=" + i + ", height=" + i2);
        mSurfaceViewWidth = i;
        mSurfaceViewHeight = i2;
        nativeSetSize(i, i2);
    }

    private boolean checkVersion() {
        Log.w(TAG, "[mario] version: 1.1.1.92 nativeVersion: " + nativeGetVersionName());
        return "1.1.1.92".equals(nativeGetVersionName()) && 92 == nativeGetVersionCode();
    }

    private void initDisplayMetrics() {
        Context context = sAppContext;
        Context context2 = sAppContext;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        float f = displayMetrics.widthPixels;
        float f2 = displayMetrics.heightPixels;
        if (mSurfaceViewWidth != 0) {
            f = mSurfaceViewWidth;
        }
        if (mSurfaceViewHeight != 0) {
            f2 = mSurfaceViewHeight;
        }
        nativeSetDisplayMetrics(f, f2, displayMetrics.xdpi, displayMetrics.ydpi, displayMetrics.density);
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

    public void destroyEngine(final V8ExecuteCallback v8ExecuteCallback) {
        runOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.V8Engine.2
            @Override // java.lang.Runnable
            public void run() {
                V8Engine.this.mTimer.destroy();
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
                V8Engine.this.mThreadDelegatePolicy.shutdown();
                V8Engine.this.mNativeV8Engine = -1L;
                V8Engine.this.mFileSystemDelegatePolicy.destroy();
                int unused = V8Engine.mSurfaceViewWidth = 0;
                int unused2 = V8Engine.mSurfaceViewHeight = 0;
                if (v8ExecuteCallback != null) {
                    v8ExecuteCallback.onExecuted();
                }
            }
        });
    }

    private void delegateRunnable(Runnable runnable) {
        if (this.mThreadDelegatePolicy.getThread() == Thread.currentThread()) {
            checkValid(this.mNativeV8Engine, this.mV8ThreadId);
            runnable.run();
            return;
        }
        this.mThreadDelegatePolicy.doDelegateRunnable(runnable);
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
                    V8Engine.this.pumpNativeMessageLoop(V8Engine.this.mNativeV8Engine, 0L);
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
                        V8Engine.this.pumpNativeMessageLoop(V8Engine.this.mNativeV8Engine, j);
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
        if (!isDestroyed()) {
            delegateRunnable(runnable);
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
        if (!isDestroyed()) {
            delegateRunnableAsync(runnable);
        }
    }

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    public void postOnJSThread(Runnable runnable, long j) {
        if (!isDestroyed()) {
            delegateRunnableAsync(runnable, j);
        }
    }

    public boolean isDestroyed() {
        return this.mNativeV8Engine == 0 || this.mNativeV8Engine == -1;
    }

    public void postSuspendableTaskOnJSThread(Runnable runnable) {
        if (!isDestroyed()) {
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
    }

    private synchronized void postSuspendableTasks() {
        if (this.mSuspendableTasks != null && !this.mSuspendableTasks.isEmpty()) {
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

    public void setJavaScriptExceptionDelegate(JavaScriptExceptionDelegate javaScriptExceptionDelegate) {
        this.mExceptionDelegate = javaScriptExceptionDelegate;
    }

    @NotProguard
    public void onV8ExceptionCallBack(String str, String str2) {
        if (this.mExceptionDelegate != null) {
            this.mExceptionDelegate.onV8ExceptionCallBack(str, str2);
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
            this.mJavaScriptInterfaces.put(str, new Pair<>(obj, cls));
            if (!isDestroyed()) {
                addJavascriptInterfaceImpl(this.mNativeV8Engine, obj, str, cls, z);
                return;
            }
            return;
        }
        Log.i(TAG, "addPossiblyUnsafeJavascriptInterface object is null or mNativeV8Engine is null");
    }

    public void removeJavascriptInterface(final String str) {
        runOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.V8Engine.7
            @Override // java.lang.Runnable
            public void run() {
                V8Engine.this.mJavaScriptInterfaces.remove(str);
                if (!V8Engine.this.isDestroyed()) {
                    V8Engine.this.removeJavascriptInterfaceImpl(V8Engine.this.mNativeV8Engine, str, true);
                }
            }
        });
    }

    public void removeJavascriptInterfaceForOpenData(final String str) {
        runOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.V8Engine.8
            @Override // java.lang.Runnable
            public void run() {
                V8Engine.this.mJavaScriptInterfaces.remove(str);
                if (!V8Engine.this.isDestroyed()) {
                    V8Engine.this.removeJavascriptInterfaceImpl(V8Engine.this.mNativeV8Engine, str, false);
                }
            }
        });
    }

    public void requireJSFile(final String str, final String str2) {
        runOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.V8Engine.9
            @Override // java.lang.Runnable
            public void run() {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !V8Engine.this.isDestroyed()) {
                    V8Engine.this.require(V8Engine.this.mNativeV8Engine, str, str2, true);
                }
            }
        });
    }

    public void requireJSFileForOpenData(final String str, final String str2) {
        runOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.V8Engine.10
            @Override // java.lang.Runnable
            public void run() {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !V8Engine.this.isDestroyed()) {
                    V8Engine.this.require(V8Engine.this.mNativeV8Engine, str, str2, false);
                }
            }
        });
    }

    public void destroyOpenDataContext() {
        runOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.V8Engine.11
            @Override // java.lang.Runnable
            public void run() {
                if (!V8Engine.this.isDestroyed()) {
                    V8Engine.this.nativeDestroyOpenDataContext(V8Engine.this.mNativeV8Engine);
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
        if (!isDestroyed()) {
            checkValid(this.mNativeV8Engine, this.mV8ThreadId);
            String runScript = runScript(this.mNativeV8Engine, str, str2, z);
            if (valueCallback != null) {
                valueCallback.onReceiveValue(runScript);
            }
        }
    }

    public static String toColorRGBA(String str) {
        return nativeToColorRGBA(str);
    }

    public InspectorNativeClient initInspector(InspectorNativeChannel inspectorNativeChannel) {
        this.mInspectorNativeClient = new InspectorNativeClient(this.mNativeV8Engine, inspectorNativeChannel);
        return this.mInspectorNativeClient;
    }

    public static void notifyGCAllocate(long j, final int i) {
        if (i != 0) {
            runOnJSThread(j, new Runnable() { // from class: com.baidu.searchbox.v8engine.V8Engine.14
                @Override // java.lang.Runnable
                public void run() {
                    V8Engine.nativeNotifyGCMemoryAllocate(i);
                }
            });
        }
    }

    public static void notifyGCFree(long j, final int i) {
        if (i != 0) {
            runOnJSThread(j, new Runnable() { // from class: com.baidu.searchbox.v8engine.V8Engine.15
                @Override // java.lang.Runnable
                public void run() {
                    V8Engine.nativeNotifyGCMemoryFree(i);
                }
            });
        }
    }

    public byte[] serialize(JsSerializeValue jsSerializeValue, boolean z) {
        if (isDestroyed()) {
            return null;
        }
        checkValid(this.mNativeV8Engine, this.mV8ThreadId);
        return nativeSerialize(this.mNativeV8Engine, jsSerializeValue, z);
    }

    public JsSerializeValue deserialize(byte[] bArr, boolean z) {
        if (bArr == null || bArr.length == 0 || isDestroyed()) {
            return null;
        }
        checkValid(this.mNativeV8Engine, this.mV8ThreadId);
        return nativeDeserialize(this.mNativeV8Engine, bArr, bArr.length, z);
    }

    private static void regiestMessageChannelForT7() {
        try {
            Class.forName("com.baidu.webkit.internal.ApisInteractWithMario").getDeclaredMethod("setMessageChannalFunctoinTable", Long.TYPE).invoke(null, Long.valueOf(nativeGetChannelFunctionTable()));
        } catch (Throwable th) {
            Log.e(TAG, th.getMessage());
        }
    }
}
