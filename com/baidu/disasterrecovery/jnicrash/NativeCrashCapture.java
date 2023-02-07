package com.baidu.disasterrecovery.jnicrash;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.soloader.SoLoader;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.logsystem.util.LLog;
import com.baidu.tieba.n20;
import com.baidu.tieba.o20;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes2.dex */
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
    public static o20 sNativeCrashHandler;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            }
        }
    }

    public static native int nativeCrash();

    public static native int nativeInit(int i);

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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void beginNativeCrash() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            if (Build.VERSION.SDK_INT > 19) {
                o20 o20Var = sNativeCrashHandler;
                if (o20Var != null) {
                    o20Var.onCrashStart();
                    return;
                }
                return;
            }
            if (DEBUG) {
                Log.d(TAG, "beginNativeCrash");
            }
            o20 o20Var2 = sNativeCrashHandler;
            if (o20Var2 != null) {
                o20Var2.onCrashStart();
            }
        }
    }

    public static void makeCrash() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            if (sInit) {
                nativeCrash();
            } else {
                Log.e(TAG, "so hasn't been loaded.");
            }
        }
    }

    public static void preloadKIKKAT() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, null) == null) && Build.VERSION.SDK_INT <= 19) {
            a.a();
            b.a();
        }
    }

    public static void init(@NonNull Context context, @NonNull o20 o20Var, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, context, o20Var, z) == null) && !sInit && o20Var != null && context != null) {
            sContext = context;
            sNativeCrashHandler = o20Var;
            loadNativeCrashLib();
            if (sInit) {
                File file = new File(sContext.getFilesDir() + "/" + SO_INIT_FLAG_FILE);
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                try {
                    nativeInit(Build.VERSION.SDK_INT);
                    if (z) {
                        n20.a();
                    }
                    file.delete();
                    if (DEBUG) {
                        Log.d(TAG, "nativeInit success");
                    }
                } catch (Throwable th) {
                    if (DEBUG) {
                        th.printStackTrace();
                        Log.d(TAG, "nativeInit failed");
                    }
                }
            }
        }
    }

    public static void loadNativeCrashLib() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            File file = new File(sContext.getFilesDir() + "/" + SO_LOAD_FLAG_FILE);
            File file2 = new File(sContext.getFilesDir() + "/" + SO_INIT_FLAG_FILE);
            if (file.exists()) {
                sNativeCrashHandler.onEvent(STATISTIC_UBC_LOAD_CRASH_TAG, "Native load crash");
            }
            if (file2.exists()) {
                sNativeCrashHandler.onEvent(STATISTIC_UBC_INIT_FAILED_TAG, "Native init failed");
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
                sNativeCrashHandler.onEvent(STATISTIC_UBC_LOAD_EXP_TAG, Log.getStackTraceString(th));
            }
        }
    }

    public static void uncaughtNativeCrash(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65546, null, str, i, i2) == null) {
            if (Build.VERSION.SDK_INT > 19) {
                o20 o20Var = sNativeCrashHandler;
                if (o20Var != null) {
                    o20Var.uncaughtNativeCrash(str, i, i2);
                    return;
                }
                return;
            }
            if (DEBUG) {
                Log.d(TAG, "uncaughtNativeCrash");
            }
            o20 o20Var2 = sNativeCrashHandler;
            if (o20Var2 != null) {
                o20Var2.uncaughtNativeCrash(str, i, i2);
            }
        }
    }
}
