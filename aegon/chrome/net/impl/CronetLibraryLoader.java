package aegon.chrome.net.impl;

import aegon.chrome.base.ContextUtils;
import aegon.chrome.base.Log;
import aegon.chrome.base.annotations.CalledByNative;
import aegon.chrome.net.NetworkChangeNotifier;
import aegon.chrome.net.RegistrationPolicyAlwaysRegister;
import android.content.Context;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class CronetLibraryLoader {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic;
    public static final String LIBRARY_NAME;
    public static final String TAG;
    public static final HandlerThread sInitThread;
    public static volatile boolean sInitThreadInitDone;
    public static volatile boolean sLibraryLoaded;
    public static final Object sLoadLock;
    public static final ConditionVariable sWaitForLibLoad;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(268619179, "Laegon/chrome/net/impl/CronetLibraryLoader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(268619179, "Laegon/chrome/net/impl/CronetLibraryLoader;");
                return;
            }
        }
        sLoadLock = new Object();
        LIBRARY_NAME = "cronet.77.0.3865.0";
        TAG = CronetLibraryLoader.class.getSimpleName();
        sInitThread = new HandlerThread("CronetInit");
        sLibraryLoaded = false;
        sWaitForLibLoad = new ConditionVariable();
    }

    public CronetLibraryLoader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void ensureInitialized(Context context, CronetEngineBuilderImpl cronetEngineBuilderImpl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, cronetEngineBuilderImpl) == null) {
            synchronized (sLoadLock) {
                if (!sInitThreadInitDone) {
                    ContextUtils.initApplicationContext(context);
                    if (!sInitThread.isAlive()) {
                        sInitThread.start();
                    }
                    postToInitThread(new Runnable() { // from class: aegon.chrome.net.impl.CronetLibraryLoader.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                }
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                CronetLibraryLoader.ensureInitializedOnInitThread();
                            }
                        }
                    });
                }
                if (!sLibraryLoaded) {
                    if (((NativeCronetEngineBuilderWithLibraryLoaderImpl) cronetEngineBuilderImpl).mLibraryLoader != null) {
                        ((NativeCronetEngineBuilderWithLibraryLoaderImpl) cronetEngineBuilderImpl).mLibraryLoader.mWrappedLoader.loadLibrary(LIBRARY_NAME);
                    } else {
                        System.loadLibrary(LIBRARY_NAME);
                    }
                    if (!"77.0.3865.0".equals(nativeGetCronetVersion())) {
                        throw new RuntimeException(String.format("Expected Cronet version number %s, actual version number %s.", "77.0.3865.0", nativeGetCronetVersion()));
                    }
                    String str = TAG;
                    Object[] objArr = new Object[2];
                    objArr[0] = "77.0.3865.0";
                    objArr[1] = System.getProperty("os.arch");
                    Log.i(str, "Cronet version: %s, arch: %s", objArr);
                    sLibraryLoaded = true;
                    sWaitForLibLoad.open();
                }
            }
        }
    }

    @CalledByNative
    public static void ensureInitializedFromNative() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            synchronized (sLoadLock) {
                sLibraryLoaded = true;
                sWaitForLibLoad.open();
            }
            ensureInitialized(ContextUtils.sApplicationContext, null);
        }
    }

    public static void ensureInitializedOnInitThread() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65540, null) == null) || sInitThreadInitDone) {
            return;
        }
        NetworkChangeNotifier.init();
        NetworkChangeNotifier.getInstance().setAutoDetectConnectivityStateInternal(true, new RegistrationPolicyAlwaysRegister());
        sWaitForLibLoad.block();
        Runnable runnable = CronetLibraryLoader$$Lambda$1.$ic;
        try {
            try {
                runnable.run();
            } catch (UnsatisfiedLinkError unused) {
                runnable.run();
            }
        } catch (UnsatisfiedLinkError unused2) {
            runnable.run();
        }
        sInitThreadInitDone = true;
    }

    @CalledByNative
    public static String getDefaultUserAgent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? UserAgent.from(ContextUtils.sApplicationContext) : (String) invokeV.objValue;
    }

    public static native void nativeCronetInitOnInitThread();

    public static native String nativeGetCronetVersion();

    public static void postToInitThread(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, runnable) == null) {
            if (sInitThread.getLooper() == Looper.myLooper()) {
                runnable.run();
            } else {
                new Handler(sInitThread.getLooper()).post(runnable);
            }
        }
    }

    @CalledByNative
    public static void setNetworkThreadPriorityOnNetworkThread(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65546, null, i2) == null) {
            Process.setThreadPriority(i2);
        }
    }
}
