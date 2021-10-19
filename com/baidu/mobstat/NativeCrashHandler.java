package com.baidu.mobstat;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes5.dex */
public final class NativeCrashHandler {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f43100a;

    /* renamed from: b  reason: collision with root package name */
    public static Context f43101b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1966252792, "Lcom/baidu/mobstat/NativeCrashHandler;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1966252792, "Lcom/baidu/mobstat/NativeCrashHandler;");
                return;
            }
        }
        try {
            System.loadLibrary("crash_analysis");
            f43100a = true;
        } catch (Throwable unused) {
        }
    }

    public NativeCrashHandler() {
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

    public static void doNativeCrash() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && f43100a) {
            try {
                nativeException();
            } catch (Throwable unused) {
            }
        }
    }

    public static void init(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, context) == null) || context == null) {
            return;
        }
        f43101b = context;
        if (f43100a) {
            File cacheDir = context.getCacheDir();
            if (cacheDir.exists() && cacheDir.isDirectory()) {
                try {
                    nativeInit(cacheDir.getAbsolutePath());
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static native void nativeException();

    public static native void nativeInit(String str);

    public static native void nativeProcess(String str);

    public static native void nativeUnint();

    public static void onCrashCallbackFromNative(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            ExceptionAnalysis.getInstance().saveCrashInfo(f43101b, System.currentTimeMillis(), str, "NativeException", 1, 0);
        }
    }

    public static void process(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, str) == null) || str == null || str.length() == 0 || !f43100a) {
            return;
        }
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            try {
                nativeProcess(str);
            } catch (Throwable unused) {
            }
        }
    }

    public static void uninit() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, null) == null) && f43100a) {
            try {
                nativeUnint();
            } catch (Throwable unused) {
            }
        }
    }
}
