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
import androidx.core.view.InputDeviceCompat;
import c.a.j0.a.e.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.searchbox.v8engine.bean.PerformanceJsonBean;
import com.baidu.searchbox.v8engine.filesystem.V8FileSystemDelegatePolicy;
import com.baidu.searchbox.v8engine.net.NetRequest;
import com.baidu.searchbox.v8engine.thread.V8DefaultThreadPolicy;
import com.baidu.searchbox.v8engine.thread.V8ExecuteCallback;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.smallgame.sdk.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes5.dex */
public class V8Engine implements JSRuntime {
    public static /* synthetic */ Interceptable $ic = null;
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
    public static final String TAG = "V8Engine";
    public static final String TYPE_V8 = "v8";
    public static int mSurfaceViewHeight;
    public static int mSurfaceViewWidth;
    public static Context sAppContext;
    public static Method sClearCrashKeyMethod;
    public static final long sEngineDestroyed = 0;
    public static HashMap<Long, V8Engine> sEngines;
    public static Method sSetCrashKeyValueMethod;
    public static int sWorkerID;
    public transient /* synthetic */ FieldHolder $fh;
    public AssetManager mAssetManager;
    public String mBuildInV8BinPath;
    public V8EngineConfiguration.CacheInfo mCacheInfo;
    public V8EngineConfiguration.CodeCacheSetting mCodeCacheSetting;
    public ComponentCallbacks2 mComponentCallbacks2;
    public ArrayList<V8EngineConsole> mConsoles;
    public String mDecodeBdfile;
    public File mDiskCodeCachePathFile;
    public JavaScriptExceptionDelegate mExceptionDelegate;
    public String mExternalV8BinPath;
    public V8FileSystemDelegatePolicy mFileSystemDelegatePolicy;
    public float mFramesInterval;
    public ArrayList<V8StatusListener> mHandlers;
    public String mInitBasePath;
    public String mInitJsPath;
    public InspectorNativeChannel mInspectorChannel;
    public InspectorNativeClient mInspectorNativeClient;
    public AtomicBoolean mIsDestroyed;
    public boolean mIsWorker;
    public V8EngineConfiguration.JSCacheCallback mJSCacheCallback;
    public JavaBoundObjectManager mJavaBoundObjectManager;
    public Object mMainGlobalObject;
    public String mMainPackageBasePath;
    public long mNativeV8Engine;
    public NetRequest mNetRequest;
    public Object mOpenGlobalObject;
    public volatile boolean mPaused;
    public PerformanceJsonBean mPerformanceJsonBean;
    public volatile boolean mReady;
    public Vector<Runnable> mSuspendableTasks;
    public V8ThreadDelegatePolicy mThreadDelegatePolicy;
    public String mThreadName;
    public V8Timer mTimer;
    public String mUserAgent;
    public AssetManager mV8BinAssetManager;
    public V8ExceptionInfo mV8ExceptionInfo;
    public long mV8ThreadId;
    public WorkerFactory mWorkerFactoryDelegate;

    /* loaded from: classes5.dex */
    public interface JavaScriptExceptionDelegate {
        void onV8ExceptionCallBack(V8ExceptionInfo v8ExceptionInfo);
    }

    @NotProguard
    /* loaded from: classes5.dex */
    public static class MemoryInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
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

        public MemoryInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface V8EngineConsole {
        void onDebugConsole(String str);

        void onErrorConsole(String str);

        void onInfoConsole(String str);

        void onLogConsole(String str);

        void onTraceConsole(String str);

        void onWarnConsole(String str);
    }

    /* loaded from: classes5.dex */
    public interface V8StatusListener {
        void onPause();

        void onReady();

        void onResume();
    }

    /* loaded from: classes5.dex */
    public interface WorkerFactory {
        V8Engine onCreateWorker();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1999678630, "Lcom/baidu/searchbox/v8engine/V8Engine;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1999678630, "Lcom/baidu/searchbox/v8engine/V8Engine;");
                return;
            }
        }
        sEngines = new HashMap<>();
        sSetCrashKeyValueMethod = null;
        sClearCrashKeyMethod = null;
        regiestMessageChannelForT7();
        V8NetFunctionTable.addOnCronetThreadInitializedListenerForT7();
        sWorkerID = 0;
        APP_DEBUG = false;
        mSurfaceViewWidth = 0;
        mSurfaceViewHeight = 0;
    }

    public V8Engine(Context context, String str, String str2, V8ThreadDelegatePolicy v8ThreadDelegatePolicy, Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, v8ThreadDelegatePolicy, obj, obj2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mExternalV8BinPath = null;
        this.mBuildInV8BinPath = null;
        this.mIsDestroyed = new AtomicBoolean(true);
        this.mHandlers = null;
        this.mConsoles = null;
        this.mDecodeBdfile = "";
        this.mMainPackageBasePath = "";
        this.mPaused = false;
        this.mSuspendableTasks = null;
        this.mV8ThreadId = 0L;
        this.mFramesInterval = 16.666666f;
        this.mThreadName = "V8JavaScriptContext";
        this.mWorkerFactoryDelegate = null;
        this.mIsWorker = false;
        initialize(context, str, str2, v8ThreadDelegatePolicy, obj, obj2);
    }

    private native void addJavascriptInterfaceImpl(long j2, Object obj, String str, Class cls, boolean z);

    private void addPossiblyUnsafeJavascriptInterface(Object obj, String str, Class<? extends Annotation> cls, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65562, this, new Object[]{obj, str, cls, Boolean.valueOf(z)}) == null) {
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
    }

    public static void checkValid(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65563, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            long id = Thread.currentThread().getId();
            if (j3 == 0 || j3 == id) {
                if (j2 == 0) {
                    throw new IllegalStateException("v8 engine has been destroyed!");
                }
                return;
            }
            throw new IllegalStateException("javascript or v8 methods must run on v8 thread, current thread id = " + id + ", expect thread id = " + j3);
        }
    }

    private boolean checkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, this)) == null) {
            Log.w(TAG, "[mario] version: 1.3.2.3 nativeVersion: " + nativeGetVersionName());
            return "1.3.2.3".equals(nativeGetVersionName()) && 3 == nativeGetVersionCode();
        }
        return invokeV.booleanValue;
    }

    public static void clearCrashKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65565, null, str) == null) {
            try {
                if (sClearCrashKeyMethod == null) {
                    sClearCrashKeyMethod = Class.forName("com.baidu.webkit.internal.ApisInteractWithMario").getDeclaredMethod("clearCrashKey", String.class);
                }
                sClearCrashKeyMethod.invoke(null, str);
            } catch (Throwable th) {
                Log.e(TAG, th.getMessage());
            }
        }
    }

    private void delegateRunnable(Runnable runnable, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65566, this, runnable, z) == null) {
            V8ThreadDelegatePolicy v8ThreadDelegatePolicy = this.mThreadDelegatePolicy;
            if (v8ThreadDelegatePolicy == null) {
                Log.e(TAG, "delegate runnable failed. please init thread delegate policy");
            } else if (v8ThreadDelegatePolicy.getThread() != Thread.currentThread()) {
                if (z) {
                    this.mThreadDelegatePolicy.doDelegateRunnableDirectly(runnable);
                } else {
                    this.mThreadDelegatePolicy.doDelegateRunnable(runnable);
                }
            } else {
                checkValid(this.mNativeV8Engine, this.mV8ThreadId);
                try {
                    runnable.run();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private void delegateRunnableAsync(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65567, this, runnable) == null) {
            V8ThreadDelegatePolicy v8ThreadDelegatePolicy = this.mThreadDelegatePolicy;
            if (v8ThreadDelegatePolicy != null) {
                v8ThreadDelegatePolicy.doDelegateRunnable(runnable);
            } else {
                Log.w(TAG, "Execute delegateRunnableAsync failed. mThreadDelegatePolicy is null");
            }
        }
    }

    public static void dumpJavaStackTraceToLogcat(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65569, null, str) == null) {
            StackTraceElement[] stackTraceElementArr = Thread.getAllStackTraces().get(Thread.currentThread());
            Log.w(str, "================Java StackTrace================");
            if (stackTraceElementArr != null) {
                for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                    Log.w(str, stackTraceElement.toString());
                }
            }
            Log.w(str, "================Java StackTrace================");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void evaluateJavascriptImpl(String str, ValueCallback<String> valueCallback, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65570, this, new Object[]{str, valueCallback, str2, Boolean.valueOf(z)}) == null) {
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
    }

    public static Context getAppContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) ? sAppContext : (Context) invokeV.objValue;
    }

    private String getBuildInV8BinPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, this)) == null) {
            if (this.mBuildInV8BinPath == null) {
                this.mBuildInV8BinPath = getAppContext().getApplicationInfo().nativeLibraryDir + File.separator + "libcom.baidu.zeus.so";
            }
            return this.mBuildInV8BinPath;
        }
        return (String) invokeV.objValue;
    }

    public static V8Engine getInstance(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65574, null, j2)) == null) {
            synchronized (sEngines) {
                V8Engine v8Engine = sEngines.get(Long.valueOf(j2));
                if (v8Engine == null || v8Engine.mIsDestroyed.get()) {
                    return null;
                }
                return v8Engine;
            }
        }
        return (V8Engine) invokeJ.objValue;
    }

    private final MemoryInfo getMemoryInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, this)) == null) {
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
        return (MemoryInfo) invokeV.objValue;
    }

    private String getTrimPath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String trim = str.trim();
            if (trim.length() == 0) {
                return null;
            }
            return trim;
        }
        return (String) invokeL.objValue;
    }

    private AssetManager getV8BinAssetManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65577, this)) == null) {
            if (this.mV8BinAssetManager == null) {
                try {
                    String str = this.mExternalV8BinPath;
                    if (str == null) {
                        str = getBuildInV8BinPath();
                    }
                    if (str != null && a.b(str)) {
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
        return (AssetManager) invokeV.objValue;
    }

    private void initialize(Context context, String str, String str2, V8ThreadDelegatePolicy v8ThreadDelegatePolicy, Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65578, this, new Object[]{context, str, str2, v8ThreadDelegatePolicy, obj, obj2}) == null) {
            Context applicationContext = context.getApplicationContext();
            sAppContext = applicationContext;
            if (applicationContext != null) {
                ApplicationInfo applicationInfo = applicationContext.getApplicationInfo();
                if (applicationInfo != null) {
                    APP_DEBUG = (applicationInfo.flags & 2) != 0;
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
                ComponentCallbacks2 componentCallbacks2 = new ComponentCallbacks2(this) { // from class: com.baidu.searchbox.v8engine.V8Engine.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ V8Engine this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // android.content.ComponentCallbacks
                    public void onConfigurationChanged(Configuration configuration) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, configuration) == null) {
                        }
                    }

                    @Override // android.content.ComponentCallbacks
                    public void onLowMemory() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        }
                    }

                    @Override // android.content.ComponentCallbacks2
                    public void onTrimMemory(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                            if (!this.this$0.isReady()) {
                                Log.w(V8Engine.TAG, "onTrimMemory failed. V8Engine is not ready.");
                            } else {
                                this.this$0.postOnJSThread(new Runnable(this, i2) { // from class: com.baidu.searchbox.v8engine.V8Engine.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass1 this$1;
                                    public final /* synthetic */ int val$level;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, Integer.valueOf(i2)};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i3 = newInitContext.flag;
                                            if ((i3 & 1) != 0) {
                                                int i4 = i3 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$1 = this;
                                        this.val$level = i2;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            V8Engine.nativeSetV8GCPressureLevel(this.this$1.this$0.mNativeV8Engine, this.val$level < 15 ? 1 : 2);
                                        }
                                    }
                                });
                            }
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
                this.mCacheInfo = new V8EngineConfiguration.CacheInfo(null, false);
                V8NetFunctionTable.addOnCronetThreadInitializedListener(new ValueCallback<Long>(this) { // from class: com.baidu.searchbox.v8engine.V8Engine.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ V8Engine this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // android.webkit.ValueCallback
                    public void onReceiveValue(Long l) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, l) == null) {
                            Log.i(V8Engine.TAG, "[mario-request] nativeInitGlobalV8NetFunctionTable: value = " + l);
                            V8Engine v8Engine = this.this$0;
                            v8Engine.nativeInitGlobalV8NetFunctionTable(v8Engine.mNativeV8Engine, l.longValue());
                        }
                    }
                });
                return;
            }
            throw new RuntimeException("basePath and path must not be null.");
        }
    }

    public static boolean isDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65579, null)) == null) ? APP_DEBUG : invokeV.booleanValue;
    }

    public static native void nativeDeleteJsReleaser(long j2, long j3, boolean z);

    private native JsSerializeValue nativeDeserialize(long j2, byte[] bArr, int i2, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeDestroyOpenDataContext(long j2);

    public static native long nativeGetChannelFunctionTable();

    public static native int nativeGetVersionCode();

    public static native String nativeGetVersionName();

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeInitGlobalV8NetFunctionTable(long j2, long j3);

    private native void nativeOnReady(long j2);

    private native byte[] nativeSerialize(long j2, JsSerializeValue jsSerializeValue, boolean z);

    private native void nativeSetBdFileRealPath(long j2, String str);

    private native boolean nativeSetCodeCacheSetting(long j2, String str, String str2, int i2, String[] strArr, int i3, long j3);

    private native void nativeSetMainPackageBasePath(long j2, String str);

    private native boolean nativeSetNetRequest(long j2, Object obj);

    private native void nativeSetUserAgent(long j2, String str);

    public static native void nativeSetV8GCPressureLevel(long j2, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeThrowJSException(long j2, int i2, String str, boolean z);

    public static native String nativeToColorRGBA(String str);

    private void onDebugConsole(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65597, this, str) == null) || this.mConsoles == null) {
            return;
        }
        for (V8EngineConsole v8EngineConsole : new ArrayList(this.mConsoles)) {
            v8EngineConsole.onDebugConsole(str);
        }
    }

    private void onErrorConsole(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65598, this, str) == null) || this.mConsoles == null) {
            return;
        }
        for (V8EngineConsole v8EngineConsole : new ArrayList(this.mConsoles)) {
            v8EngineConsole.onErrorConsole(str);
        }
    }

    private void onInfoConsole(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65599, this, str) == null) || this.mConsoles == null) {
            return;
        }
        for (V8EngineConsole v8EngineConsole : new ArrayList(this.mConsoles)) {
            v8EngineConsole.onInfoConsole(str);
        }
    }

    private void onJsCacheCallback(String str, boolean z) {
        V8EngineConfiguration.JSCacheCallback jSCacheCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65600, this, str, z) == null) || (jSCacheCallback = this.mJSCacheCallback) == null) {
            return;
        }
        V8EngineConfiguration.CacheInfo cacheInfo = this.mCacheInfo;
        cacheInfo.jsPath = str;
        cacheInfo.cached = z;
        jSCacheCallback.onCacheResult(cacheInfo);
    }

    private void onLogConsole(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65601, this, str) == null) || this.mConsoles == null) {
            return;
        }
        for (V8EngineConsole v8EngineConsole : new ArrayList(this.mConsoles)) {
            v8EngineConsole.onLogConsole(str);
        }
    }

    private void onReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65602, this) == null) {
            this.mReady = true;
            if (this.mHandlers != null) {
                for (V8StatusListener v8StatusListener : new ArrayList(this.mHandlers)) {
                    v8StatusListener.onReady();
                }
            }
        }
    }

    private void onTraceConsole(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65603, this, str) == null) || this.mConsoles == null) {
            return;
        }
        for (V8EngineConsole v8EngineConsole : new ArrayList(this.mConsoles)) {
            v8EngineConsole.onTraceConsole(str);
        }
    }

    private void onWarnConsole(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65604, this, str) == null) || this.mConsoles == null) {
            return;
        }
        for (V8EngineConsole v8EngineConsole : new ArrayList(this.mConsoles)) {
            v8EngineConsole.onWarnConsole(str);
        }
    }

    private synchronized void postSuspendableTasks() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65605, this) == null) {
            synchronized (this) {
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
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void pumpNativeMessageLoop(long j2, long j3);

    public static void regiestMessageChannelForT7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65607, null) == null) {
            try {
                Class.forName("com.baidu.webkit.internal.ApisInteractWithMario").getDeclaredMethod("setMessageChannalFunctoinTable", Long.TYPE).invoke(null, Long.valueOf(nativeGetChannelFunctionTable()));
            } catch (Throwable th) {
                Log.e(TAG, th.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void removeJavascriptInterfaceImpl(long j2, String str, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native void require(long j2, String str, String str2, boolean z, boolean z2);

    private native String runScript(long j2, String str, String str2, boolean z);

    public static void setCrashKeyValue(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65612, null, str, str2) == null) {
            try {
                if (sSetCrashKeyValueMethod == null) {
                    sSetCrashKeyValueMethod = Class.forName("com.baidu.webkit.internal.ApisInteractWithMario").getDeclaredMethod("setCrashKeyValue", String.class, String.class);
                }
                sSetCrashKeyValueMethod.invoke(null, str, str2);
            } catch (Throwable th) {
                Log.e(TAG, th.getMessage());
            }
        }
    }

    public static String toColorRGBA(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65613, null, str)) == null) ? nativeToColorRGBA(str) : (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void v8EngineDestroy(long j2);

    private native long v8EngineInit();

    public void addJavascriptInterface(Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, obj, str) == null) {
            addPossiblyUnsafeJavascriptInterface(obj, str, JavascriptInterface.class, true);
        }
    }

    public void addJavascriptInterfaceForOpenData(Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, str) == null) {
            addPossiblyUnsafeJavascriptInterface(obj, str, JavascriptInterface.class, false);
        }
    }

    public synchronized void addStatusHandler(V8StatusListener v8StatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, v8StatusListener) == null) {
            synchronized (this) {
                if (this.mReady) {
                    v8StatusListener.onReady();
                    return;
                }
                if (this.mHandlers == null) {
                    this.mHandlers = new ArrayList<>(1);
                }
                this.mHandlers.add(v8StatusListener);
            }
        }
    }

    public synchronized void addV8EngineConsole(V8EngineConsole v8EngineConsole) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, v8EngineConsole) == null) {
            synchronized (this) {
                if (this.mConsoles == null) {
                    this.mConsoles = new ArrayList<>(1);
                }
                this.mConsoles.add(v8EngineConsole);
            }
        }
    }

    public boolean clearDiskCodeCache(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            File file = this.mDiskCodeCachePathFile;
            if (file == null || !file.exists()) {
                return true;
            }
            return DiskCodeCacheManager.clearDiskCodeCache(this.mDiskCodeCachePathFile.getAbsolutePath(), str);
        }
        return invokeL.booleanValue;
    }

    public long createWorkerV8Engine(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
            Log.e("V8", "!!!!!createWorkerV8Engine, mWorkerFactoryDelegate =  " + this.mWorkerFactoryDelegate);
            WorkerFactory workerFactory = this.mWorkerFactoryDelegate;
            if (workerFactory != null) {
                V8Engine onCreateWorker = workerFactory.onCreateWorker();
                onCreateWorker.setIsWorker(true);
                StringBuilder sb = new StringBuilder();
                sb.append("MarioWT");
                int i2 = sWorkerID;
                sWorkerID = i2 + 1;
                sb.append(i2);
                onCreateWorker.setThreadName(sb.toString());
                onCreateWorker.startEngine();
                return onCreateWorker.nativePtr();
            }
            Log.e("V8", "ERROR!!!!! no mWorkerFactoryDelegate");
            return 0L;
        }
        return invokeJ.longValue;
    }

    public JsSerializeValue deserialize(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, bArr, z)) == null) {
            if (bArr != null && bArr.length != 0 && !this.mIsDestroyed.get()) {
                checkValid(this.mNativeV8Engine, this.mV8ThreadId);
                return nativeDeserialize(this.mNativeV8Engine, bArr, bArr.length, z);
            }
            Log.w(TAG, "deserialize fail. please start engine before execute js task");
            return null;
        }
        return (JsSerializeValue) invokeLZ.objValue;
    }

    public void destroyEngine(V8ExecuteCallback v8ExecuteCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, v8ExecuteCallback) == null) {
            Log.e("V8", "v8engine.java::destroyEngine");
            runOnJSThreadDirectly(new Runnable(this, v8ExecuteCallback) { // from class: com.baidu.searchbox.v8engine.V8Engine.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ V8Engine this$0;
                public final /* synthetic */ V8ExecuteCallback val$callback;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, v8ExecuteCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$callback = v8ExecuteCallback;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Log.e(V8Engine.TAG, "v8engine.java::destroyEngine run");
                        if (this.this$0.mIsDestroyed.getAndSet(true)) {
                            Log.w(V8Engine.TAG, "v8engine.java:destroyEngine has been called before");
                            return;
                        }
                        this.this$0.removeJavascriptInterface("jBenchmark");
                        if (this.this$0.mTimer != null) {
                            this.this$0.mTimer.destroy();
                        }
                        if (this.this$0.mJavaBoundObjectManager != null) {
                            this.this$0.mJavaBoundObjectManager.clear();
                        }
                        synchronized (V8Engine.sEngines) {
                            V8Engine.sEngines.remove(Long.valueOf(this.this$0.mNativeV8Engine));
                        }
                        if (this.this$0.mInspectorNativeClient != null) {
                            this.this$0.mInspectorNativeClient.destroy();
                        }
                        V8Engine v8Engine = this.this$0;
                        v8Engine.v8EngineDestroy(v8Engine.mNativeV8Engine);
                        if (V8Engine.sAppContext != null) {
                            V8Engine.sAppContext.unregisterComponentCallbacks(this.this$0.mComponentCallbacks2);
                        }
                        this.this$0.mNativeV8Engine = 0L;
                        if (this.this$0.mThreadDelegatePolicy != null) {
                            this.this$0.mThreadDelegatePolicy.shutdown();
                        }
                        if (this.this$0.mFileSystemDelegatePolicy != null) {
                            this.this$0.mFileSystemDelegatePolicy.destroy();
                        }
                        int unused = V8Engine.mSurfaceViewWidth = 0;
                        int unused2 = V8Engine.mSurfaceViewHeight = 0;
                        V8ExecuteCallback v8ExecuteCallback2 = this.val$callback;
                        if (v8ExecuteCallback2 != null) {
                            v8ExecuteCallback2.onExecuted();
                        }
                    }
                }
            });
        }
    }

    public void destroyOpenDataContext() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            runOnJSThread(new Runnable(this) { // from class: com.baidu.searchbox.v8engine.V8Engine.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ V8Engine this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (!this.this$0.mIsDestroyed.get()) {
                            V8Engine v8Engine = this.this$0;
                            v8Engine.nativeDestroyOpenDataContext(v8Engine.mNativeV8Engine);
                            return;
                        }
                        Log.w(V8Engine.TAG, "destroyOpenDataContext fail. please start engine before execute js task");
                    }
                }
            });
        }
    }

    public void destroyWorkerV8Engine() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            destroyEngine(null);
        }
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, str, valueCallback, str2) == null) {
            runOnJSThread(new Runnable(this, str2, str, valueCallback) { // from class: com.baidu.searchbox.v8engine.V8Engine.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ V8Engine this$0;
                public final /* synthetic */ String val$js;
                public final /* synthetic */ ValueCallback val$resultCallback;
                public final /* synthetic */ String val$tagName;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str2, str, valueCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$tagName = str2;
                    this.val$js = str;
                    this.val$resultCallback = valueCallback;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.evaluateJavascriptImpl(this.val$js, this.val$resultCallback, this.val$tagName, true);
                    }
                }

                @NotProguard
                public String toString() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return "evaluateJavascript-" + this.val$tagName;
                    }
                    return (String) invokeV.objValue;
                }
            });
        }
    }

    public void evaluateJavascriptForOpenData(String str, ValueCallback<String> valueCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, str, valueCallback, str2) == null) {
            runOnJSThread(new Runnable(this, str2, str, valueCallback) { // from class: com.baidu.searchbox.v8engine.V8Engine.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ V8Engine this$0;
                public final /* synthetic */ String val$js;
                public final /* synthetic */ ValueCallback val$resultCallback;
                public final /* synthetic */ String val$tagName;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str2, str, valueCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$tagName = str2;
                    this.val$js = str;
                    this.val$resultCallback = valueCallback;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.evaluateJavascriptImpl(this.val$js, this.val$resultCallback, this.val$tagName, false);
                    }
                }

                @NotProguard
                public String toString() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return "evaluateJavascriptForOpenData-" + this.val$tagName;
                    }
                    return (String) invokeV.objValue;
                }
            });
        }
    }

    public AssetManager getAssetManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mAssetManager : (AssetManager) invokeV.objValue;
    }

    public String getBdFileRealPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mDecodeBdfile : (String) invokeV.objValue;
    }

    public V8FileSystemDelegatePolicy getFileSystemDelegatePolicy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mFileSystemDelegatePolicy : (V8FileSystemDelegatePolicy) invokeV.objValue;
    }

    public String getInitBasePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mInitBasePath : (String) invokeV.objValue;
    }

    public InspectorNativeClient getInspectorNativeClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mInspectorNativeClient : (InspectorNativeClient) invokeV.objValue;
    }

    public String getMainPackageBasePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mMainPackageBasePath : (String) invokeV.objValue;
    }

    public NetRequest getNetRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mNetRequest : (NetRequest) invokeV.objValue;
    }

    public Object getOpenGlobalObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mOpenGlobalObject : invokeV.objValue;
    }

    public JSONArray getPerformanceJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            PerformanceJsonBean performanceJsonBean = this.mPerformanceJsonBean;
            return performanceJsonBean == null ? new JSONArray() : performanceJsonBean.toJSONArray();
        }
        return (JSONArray) invokeV.objValue;
    }

    public PerformanceJsonBean getPerformanceJsonBean() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mPerformanceJsonBean : (PerformanceJsonBean) invokeV.objValue;
    }

    public InspectorNativeClient initInspector(InspectorNativeChannel inspectorNativeChannel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, inspectorNativeChannel)) == null) {
            InspectorNativeClient inspectorNativeClient = new InspectorNativeClient(this.mNativeV8Engine, inspectorNativeChannel);
            this.mInspectorNativeClient = inspectorNativeClient;
            return inspectorNativeClient;
        }
        return (InspectorNativeClient) invokeL.objValue;
    }

    public void initializeV8() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            Log.i(TAG, "[V8Dispose] Initializing V8Engine");
            this.mV8ThreadId = Thread.currentThread().getId();
            V8NativeInit.initialize(this.mNativeV8Engine, this.mAssetManager, getV8BinAssetManager(), this.mTimer, this.mMainGlobalObject, this.mV8ThreadId);
        }
    }

    public boolean isDestroyed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mIsDestroyed.get() : invokeV.booleanValue;
    }

    public synchronized boolean isPaused() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            synchronized (this) {
                z = this.mPaused;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mReady : invokeV.booleanValue;
    }

    public boolean isWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mIsWorker : invokeV.booleanValue;
    }

    public float minFramesInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.mFramesInterval : invokeV.floatValue;
    }

    public long nativePtr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.mNativeV8Engine : invokeV.longValue;
    }

    @NotProguard
    public synchronized void onConsoleCallBack(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048606, this, i2, str) == null) {
            synchronized (this) {
                switch (i2) {
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
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.mPaused = true;
            if (this.mHandlers != null) {
                for (V8StatusListener v8StatusListener : new ArrayList(this.mHandlers)) {
                    v8StatusListener.onPause();
                }
            }
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.mPaused = false;
            if (this.mHandlers != null) {
                for (V8StatusListener v8StatusListener : new ArrayList(this.mHandlers)) {
                    v8StatusListener.onResume();
                }
            }
            postSuspendableTasks();
        }
    }

    @NotProguard
    public void onV8ExceptionCallBack(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048609, this, str, str2, str3, str4) == null) || this.mExceptionDelegate == null) {
            return;
        }
        this.mV8ExceptionInfo.reset(System.currentTimeMillis(), str, str2, str3, str4);
        this.mExceptionDelegate.onV8ExceptionCallBack(this.mV8ExceptionInfo);
    }

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    public void postOnJSThread(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, runnable) == null) {
            if (!this.mIsDestroyed.get()) {
                delegateRunnableAsync(runnable);
            } else {
                Log.w(TAG, "postOnJsThread fail. please start engine before execute js task");
            }
        }
    }

    public void postSuspendableTaskOnJSThread(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, runnable) == null) {
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
    }

    @NotProguard
    public void pumpMessageLoop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            try {
                postOnJSThread(new Runnable(this) { // from class: com.baidu.searchbox.v8engine.V8Engine.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ V8Engine this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.mIsDestroyed.get()) {
                            return;
                        }
                        V8Engine.checkValid(this.this$0.mNativeV8Engine, this.this$0.mV8ThreadId);
                        V8Engine v8Engine = this.this$0;
                        v8Engine.pumpNativeMessageLoop(v8Engine.mNativeV8Engine, 0L);
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    public void removeJavascriptInterface(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            runOnJSThread(new Runnable(this, str) { // from class: com.baidu.searchbox.v8engine.V8Engine.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ V8Engine this$0;
                public final /* synthetic */ String val$name;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$name = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (!this.this$0.mIsDestroyed.get()) {
                            V8Engine v8Engine = this.this$0;
                            v8Engine.removeJavascriptInterfaceImpl(v8Engine.mNativeV8Engine, this.val$name, true);
                            return;
                        }
                        Log.w(V8Engine.TAG, "removeJavascriptInterface fail. please start engine before execute js task");
                    }
                }
            });
        }
    }

    public void removeJavascriptInterfaceForOpenData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            runOnJSThread(new Runnable(this, str) { // from class: com.baidu.searchbox.v8engine.V8Engine.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ V8Engine this$0;
                public final /* synthetic */ String val$name;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$name = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (!this.this$0.mIsDestroyed.get()) {
                            V8Engine v8Engine = this.this$0;
                            v8Engine.removeJavascriptInterfaceImpl(v8Engine.mNativeV8Engine, this.val$name, false);
                            return;
                        }
                        Log.w(V8Engine.TAG, "removeJavascriptInterfaceForOpenData fail. please start engine before execute js task");
                    }
                }
            });
        }
    }

    public synchronized void removeStatusHandler(V8StatusListener v8StatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, v8StatusListener) == null) {
            synchronized (this) {
                if (this.mHandlers == null) {
                    return;
                }
                this.mHandlers.remove(v8StatusListener);
            }
        }
    }

    public synchronized void removeV8EngineConsole(V8EngineConsole v8EngineConsole) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, v8EngineConsole) == null) {
            synchronized (this) {
                if (this.mConsoles == null) {
                    return;
                }
                this.mConsoles.remove(v8EngineConsole);
            }
        }
    }

    public void requireJSFile(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048619, this, str, str2) == null) {
            runOnJSThread(new Runnable(this, str, str2) { // from class: com.baidu.searchbox.v8engine.V8Engine.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ V8Engine this$0;
                public final /* synthetic */ String val$basePath;
                public final /* synthetic */ String val$filePath;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$basePath = str;
                    this.val$filePath = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (!TextUtils.isEmpty(this.val$basePath) && !TextUtils.isEmpty(this.val$filePath) && !this.this$0.mIsDestroyed.get()) {
                            V8Engine v8Engine = this.this$0;
                            v8Engine.require(v8Engine.mNativeV8Engine, this.val$basePath, this.val$filePath, true, false);
                            return;
                        }
                        Log.w(V8Engine.TAG, "basePath is null ? " + TextUtils.isEmpty(this.val$basePath) + ", filePath is null ?  " + TextUtils.isEmpty(this.val$filePath) + ", mIsDestroyed = " + this.this$0.mIsDestroyed.get());
                    }
                }
            });
        }
    }

    public void requireJSFileForOpenData(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048620, this, str, str2) == null) {
            runOnJSThread(new Runnable(this, str, str2) { // from class: com.baidu.searchbox.v8engine.V8Engine.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ V8Engine this$0;
                public final /* synthetic */ String val$basePath;
                public final /* synthetic */ String val$filePath;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$basePath = str;
                    this.val$filePath = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (!TextUtils.isEmpty(this.val$basePath) && !TextUtils.isEmpty(this.val$filePath) && !this.this$0.mIsDestroyed.get()) {
                            V8Engine v8Engine = this.this$0;
                            v8Engine.require(v8Engine.mNativeV8Engine, this.val$basePath, this.val$filePath, false, false);
                            return;
                        }
                        Log.w(V8Engine.TAG, "basePath = " + this.val$basePath + ", filePath = " + this.val$filePath + ", mIsDestroyed = " + this.this$0.mIsDestroyed.get());
                    }
                }
            });
        }
    }

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    public void runOnJSThread(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, runnable) == null) {
            if (!this.mIsDestroyed.get()) {
                delegateRunnable(runnable, false);
            } else {
                Log.w(TAG, "runOnJSThread fail. please start engine before execute js task");
            }
        }
    }

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    public void runOnJSThreadDirectly(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, runnable) == null) {
            if (!this.mIsDestroyed.get()) {
                delegateRunnable(runnable, true);
            } else {
                Log.w(TAG, "runOnJSThreadDirectly fail. please start engine before execute js task");
            }
        }
    }

    public byte[] serialize(JsSerializeValue jsSerializeValue, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048623, this, jsSerializeValue, z)) == null) {
            if (this.mIsDestroyed.get()) {
                Log.w(TAG, "serialize fail. please start engine before execute js task");
                return null;
            }
            checkValid(this.mNativeV8Engine, this.mV8ThreadId);
            return nativeSerialize(this.mNativeV8Engine, jsSerializeValue, z);
        }
        return (byte[]) invokeLZ.objValue;
    }

    public void setBdFileRealPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            String trimPath = getTrimPath(str);
            if (trimPath == null) {
                Log.e(TAG, "bdfile path is empy");
            } else if (this.mDecodeBdfile.equals(trimPath)) {
            } else {
                this.mDecodeBdfile = trimPath;
                nativeSetBdFileRealPath(this.mNativeV8Engine, trimPath);
            }
        }
    }

    @Deprecated
    public void setCodeCacheSetting(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, codeCacheSetting) == null) {
            useCodeCacheSetting(codeCacheSetting);
        }
    }

    public void setExternalV8BinFilesPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, str) == null) {
            if (str == null) {
                this.mExternalV8BinPath = null;
                return;
            }
            String trim = str.trim();
            this.mExternalV8BinPath = TextUtils.isEmpty(trim) ? null : trim;
        }
    }

    public void setFileSystemDelegatePolicy(V8FileSystemDelegatePolicy v8FileSystemDelegatePolicy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, v8FileSystemDelegatePolicy) == null) {
            this.mFileSystemDelegatePolicy = v8FileSystemDelegatePolicy;
        }
    }

    public void setInspectorChannel(InspectorNativeChannel inspectorNativeChannel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, inspectorNativeChannel) == null) {
            this.mInspectorChannel = inspectorNativeChannel;
        }
    }

    public void setIsWorker(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            this.mIsWorker = z;
        }
    }

    public void setJSCacheCallback(V8EngineConfiguration.JSCacheCallback jSCacheCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, jSCacheCallback) == null) {
            this.mJSCacheCallback = jSCacheCallback;
        }
    }

    public void setJavaScriptExceptionDelegate(JavaScriptExceptionDelegate javaScriptExceptionDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, javaScriptExceptionDelegate) == null) {
            this.mExceptionDelegate = javaScriptExceptionDelegate;
        }
    }

    public void setMainPackageBasePath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, str) == null) {
            String trimPath = getTrimPath(str);
            if (trimPath == null) {
                Log.e(TAG, "mainPacakge path is empty");
            } else if (this.mMainPackageBasePath.equals(trimPath)) {
            } else {
                this.mMainPackageBasePath = trimPath;
                nativeSetMainPackageBasePath(this.mNativeV8Engine, trimPath);
            }
        }
    }

    public boolean setNetRequest(NetRequest netRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, netRequest)) == null) {
            this.mNetRequest = netRequest;
            if (netRequest != null) {
                boolean nativeSetNetRequest = nativeSetNetRequest(this.mNativeV8Engine, netRequest);
                if (nativeSetNetRequest) {
                    this.mNetRequest.bindV8Engine(this);
                    return nativeSetNetRequest;
                }
                Log.w(TAG, "[mario-request] NA-NetRequest对象初始化失败.");
                return nativeSetNetRequest;
            }
            Log.w(TAG, "[mario-request] Java-NetRequest对象为空, naRequest初始化失败");
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setPreferredFramesPerSecond(short s) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{Short.valueOf(s)}) == null) || s <= 0 || s > 60) {
            return;
        }
        this.mFramesInterval = (float) (1000 / s);
    }

    public void setThreadName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, str) == null) {
            this.mThreadName = str;
        }
    }

    public void setUserAgent(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048636, this, str) == null) || TextUtils.equals(str, this.mUserAgent)) {
            return;
        }
        this.mUserAgent = str;
        nativeSetUserAgent(this.mNativeV8Engine, str);
    }

    public void setWorkerFactoryDelegate(WorkerFactory workerFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, workerFactory) == null) {
            this.mWorkerFactoryDelegate = workerFactory;
        }
    }

    public synchronized void startEngine() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            synchronized (this) {
                if (this.mThreadDelegatePolicy != null) {
                    this.mThreadDelegatePolicy.startV8Engine(this);
                } else {
                    Log.w(TAG, "startV8Engine failed. please init thread delegate policy before");
                }
            }
        }
    }

    public void startEngineInternal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            Log.i(TAG, "[V8Dispose][mario] java version = 1.3.2.3, nativeVersion = " + nativeGetVersionName());
            try {
            } catch (Exception e2) {
                Log.e(TAG, Log.getStackTraceString(e2));
            }
            if (!checkVersion()) {
                throw new Exception("[mario] java version and native version dismatch  version: 1.3.2.3 nativeVersion: " + nativeGetVersionName());
            }
            this.mTimer.initialize(this, new Handler(Looper.getMainLooper()));
            initializeV8();
            InspectorNativeChannel inspectorNativeChannel = this.mInspectorChannel;
            if (inspectorNativeChannel != null) {
                initInspector(inspectorNativeChannel);
            }
            require(this.mNativeV8Engine, this.mInitBasePath, this.mInitJsPath, true, true);
            nativeOnReady(this.mNativeV8Engine);
            onReady();
        }
    }

    public String threadName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.mThreadName : (String) invokeV.objValue;
    }

    public void throwJSException(JSExceptionType jSExceptionType, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048641, this, jSExceptionType, str) == null) {
            runOnJSThread(new Runnable(this, jSExceptionType, str) { // from class: com.baidu.searchbox.v8engine.V8Engine.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ V8Engine this$0;
                public final /* synthetic */ String val$msg;
                public final /* synthetic */ JSExceptionType val$type;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, jSExceptionType, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$type = jSExceptionType;
                    this.val$msg = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        V8Engine.checkValid(this.this$0.mNativeV8Engine, this.this$0.mV8ThreadId);
                        V8Engine v8Engine = this.this$0;
                        v8Engine.nativeThrowJSException(v8Engine.mNativeV8Engine, this.val$type.ordinal(), this.val$msg, true);
                    }
                }
            });
        }
    }

    public void throwJSExceptionForOpenData(JSExceptionType jSExceptionType, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048642, this, jSExceptionType, str) == null) {
            runOnJSThread(new Runnable(this, jSExceptionType, str) { // from class: com.baidu.searchbox.v8engine.V8Engine.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ V8Engine this$0;
                public final /* synthetic */ String val$msg;
                public final /* synthetic */ JSExceptionType val$type;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, jSExceptionType, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$type = jSExceptionType;
                    this.val$msg = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        V8Engine.checkValid(this.this$0.mNativeV8Engine, this.this$0.mV8ThreadId);
                        V8Engine v8Engine = this.this$0;
                        v8Engine.nativeThrowJSException(v8Engine.mNativeV8Engine, this.val$type.ordinal(), this.val$msg, false);
                    }
                }
            });
        }
    }

    public boolean useCodeCacheSetting(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048643, this, codeCacheSetting)) == null) {
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
        return invokeL.booleanValue;
    }

    public String userAgent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.mUserAgent : (String) invokeV.objValue;
    }

    @NotProguard
    public void pumpMessageLoop(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) || j2 <= 0) {
            return;
        }
        try {
            postOnJSThread(new Runnable(this, j2) { // from class: com.baidu.searchbox.v8engine.V8Engine.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ V8Engine this$0;
                public final /* synthetic */ long val$id;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$id = j2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.mIsDestroyed.get()) {
                        return;
                    }
                    V8Engine.checkValid(this.this$0.mNativeV8Engine, this.this$0.mV8ThreadId);
                    V8Engine v8Engine = this.this$0;
                    v8Engine.pumpNativeMessageLoop(v8Engine.mNativeV8Engine, this.val$id);
                }
            }, j3);
        } catch (Throwable unused) {
        }
    }

    private void delegateRunnableAsync(Runnable runnable, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65568, this, runnable, j2) == null) {
            V8ThreadDelegatePolicy v8ThreadDelegatePolicy = this.mThreadDelegatePolicy;
            if (v8ThreadDelegatePolicy != null) {
                v8ThreadDelegatePolicy.doDelegateRunnable(runnable, j2);
            } else {
                Log.w(TAG, "Execute delegateRunnableAsync failed. mThreadDelegatePolicy is null");
            }
        }
    }

    public static void runOnJSThread(long j2, Runnable runnable) {
        V8Engine v8Engine;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(65610, null, j2, runnable) == null) || (v8Engine = getInstance(j2)) == null) {
            return;
        }
        v8Engine.runOnJSThread(runnable);
    }

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    public void postOnJSThread(Runnable runnable, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048611, this, runnable, j2) == null) {
            if (!this.mIsDestroyed.get()) {
                delegateRunnableAsync(runnable, j2);
            } else {
                Log.w(TAG, "postOnJsThread fail. please start engine before execute js task");
            }
        }
    }

    public static V8Engine getInstance() {
        InterceptResult invokeV;
        V8Engine v8Engine;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) {
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
        return (V8Engine) invokeV.objValue;
    }
}
