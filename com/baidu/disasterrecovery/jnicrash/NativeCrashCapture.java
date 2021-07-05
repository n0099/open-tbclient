package com.baidu.disasterrecovery.jnicrash;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.util.soloader.SoLoader;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.logsystem.util.LLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes3.dex */
public class NativeCrashCapture implements NoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String SO_INIT_FLAG_FILE = "jnicrash_so_init_fail_flag";
    public static final String SO_LOAD_FLAG_FILE = "jnicrash_so_load_fail_flag";
    public static final String STATISTIC_UBC_INIT_FAILED_TAG = "SO_INIT_FAILED";
    public static final String STATISTIC_UBC_LOAD_CRASH_TAG = "SO_LOAD_CRASH";
    public static final String STATISTIC_UBC_LOAD_EXP_TAG = "SO_LOAD_EXCEPTION";
    public static final String TAG = "NativeCrashCapture";
    public static Context sContext;
    public static boolean sInit;
    public static d.a.o.a.b sNativeCrashHandler;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1523712317, "Lcom/baidu/disasterrecovery/jnicrash/NativeCrashCapture;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1523712317, "Lcom/baidu/disasterrecovery/jnicrash/NativeCrashCapture;");
                return;
            }
        }
        DEBUG = LLog.sDebug;
        sInit = false;
        sContext = null;
        sNativeCrashHandler = null;
    }

    public NativeCrashCapture() {
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

    public static void beginNativeCrash() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            if (Build.VERSION.SDK_INT > 19) {
                d.a.o.a.b bVar = sNativeCrashHandler;
                if (bVar != null) {
                    bVar.d();
                    return;
                }
                return;
            }
            if (DEBUG) {
                Log.d(TAG, "beginNativeCrash");
            }
            d.a.o.a.b bVar2 = sNativeCrashHandler;
            if (bVar2 != null) {
                bVar2.d();
            }
        }
    }

    public static void init(@NonNull Context context, @NonNull d.a.o.a.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65540, null, context, bVar, z) == null) || sInit || bVar == null || context == null) {
            return;
        }
        sContext = context;
        sNativeCrashHandler = bVar;
        loadNativeCrashLib();
        if (sInit) {
            File file = new File(sContext.getFilesDir() + "/" + SO_INIT_FLAG_FILE);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            nativeInit(Build.VERSION.SDK_INT);
            if (z) {
                d.a.o.a.a.a();
            }
            file.delete();
            if (DEBUG) {
                Log.d(TAG, "nativeInit success");
            }
        }
    }

    public static void loadNativeCrashLib() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            File file = new File(sContext.getFilesDir() + "/" + SO_LOAD_FLAG_FILE);
            File file2 = new File(sContext.getFilesDir() + "/" + SO_INIT_FLAG_FILE);
            if (file.exists()) {
                sNativeCrashHandler.f(STATISTIC_UBC_LOAD_CRASH_TAG, "Native load crash");
            }
            if (file2.exists()) {
                sNativeCrashHandler.f(STATISTIC_UBC_INIT_FAILED_TAG, "Native init failed");
            }
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                SoLoader.load(sContext, "native-crash");
                if (SoLoader.isSoLoadedSucc("native-crash")) {
                    sInit = true;
                    file.delete();
                    if (DEBUG) {
                        String lowerCase = System.getProperty("os.arch").toLowerCase();
                        Log.d(TAG, "load native-crash.so success, arch is: " + lowerCase);
                    }
                }
            } catch (Throwable th) {
                sInit = false;
                th.printStackTrace();
                sNativeCrashHandler.f(STATISTIC_UBC_LOAD_EXP_TAG, Log.getStackTraceString(th));
            }
        }
    }

    public static void makeCrash() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            if (sInit) {
                nativeCrash();
            } else {
                Log.e(TAG, "so hasn't been loaded.");
            }
        }
    }

    public static native int nativeCrash();

    public static native int nativeInit(int i2);

    public static void preloadKIKKAT() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, null) == null) || Build.VERSION.SDK_INT > 19) {
            return;
        }
        a.a();
        b.a();
    }

    public static void uncaughtNativeCrash(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65546, null, str, i2, i3) == null) {
            if (Build.VERSION.SDK_INT > 19) {
                d.a.o.a.b bVar = sNativeCrashHandler;
                if (bVar != null) {
                    bVar.i(str, i2, i3);
                    return;
                }
                return;
            }
            if (DEBUG) {
                Log.d(TAG, "uncaughtNativeCrash");
            }
            d.a.o.a.b bVar2 = sNativeCrashHandler;
            if (bVar2 != null) {
                bVar2.i(str, i2, i3);
            }
        }
    }
}
