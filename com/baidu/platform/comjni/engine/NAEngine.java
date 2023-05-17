package com.baidu.platform.comjni.engine;

import android.content.Context;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.exception.ComInitException;
import com.baidu.platform.comapi.longlink.LongLinkClient;
import com.baidu.platform.comjni.NativeComponent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class NAEngine extends NativeComponent {
    public static /* synthetic */ Interceptable $ic;
    public static LongLinkClient a;
    public static boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-370543850, "Lcom/baidu/platform/comjni/engine/NAEngine;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-370543850, "Lcom/baidu/platform/comjni/engine/NAEngine;");
        }
    }

    private native long nativeCreate();

    public static native void nativeEnableMonitor(boolean z);

    public static native boolean nativeGetFlaxLength(Bundle bundle);

    public static native String nativeGetIP(String str);

    public static native void nativeInitCVLogFilePath(String str);

    public static native int nativeInitClass(Object obj, int i);

    public static native boolean nativeInitEngine(Object obj, String str);

    public static native void nativeInitMonitor(String str);

    public static native void nativeMonitorAddLog(int i, String str, String str2);

    public static native void nativeMonitorSetLogPriority(int i);

    public static native void nativeMonitorSetOutPutType(int i);

    private native int nativeRelease(long j);

    public static native void nativeSetHttpsEnable(boolean z);

    public static native void nativeSetMonitorLogFilter(String[] strArr);

    public static native void nativeSetNewDomainEnable(boolean z);

    public static native void nativeSetProxyInfo(String str, int i);

    public static native void nativeStartRunningRequest();

    public static native boolean nativeStartSocketProc();

    public static native boolean nativeStartSocketProcByCache(String str);

    public static native void nativeSyncAppRuntime(String str);

    public static native void nativeUninitCVLogFilePath();

    public static native boolean nativeUninitEngine();

    public NAEngine() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        create();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            nativeInitClass(new Bundle(), 0);
            b = true;
        }
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            try {
                if (a != null) {
                    a.unRegister(null);
                    a.release();
                    a = null;
                }
                return nativeUninitEngine();
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return nativeStartSocketProc();
        }
        return invokeV.booleanValue;
    }

    public static boolean initLongLinkClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (a == null) {
                try {
                    a = LongLinkClient.create();
                } catch (ComInitException unused) {
                }
            }
            if (a != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void restartLongLink() {
        LongLinkClient longLinkClient;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65572, null) == null) && (longLinkClient = a) != null) {
            try {
                longLinkClient.start();
            } catch (Exception unused) {
            }
        }
    }

    public static void startRunningRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, null) == null) {
            nativeStartRunningRequest();
        }
    }

    public static void stopLongLink() {
        LongLinkClient longLinkClient;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65574, null) == null) && (longLinkClient = a) != null) {
            try {
                longLinkClient.stop();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.baidu.platform.comjni.NativeComponent
    public long create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.mNativePointer = nativeCreate();
            return this.mNativePointer;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.platform.comjni.NativeComponent
    public int dispose() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return nativeRelease(this.mNativePointer);
        }
        return invokeV.intValue;
    }

    public static void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, null, i) == null) {
            nativeMonitorSetOutPutType(i);
        }
    }

    public static void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65545, null, i) == null) {
            nativeMonitorSetLogPriority(i);
        }
    }

    public static String getIP(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            return nativeGetIP(str);
        }
        return (String) invokeL.objValue;
    }

    public static void a(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, str, str2) == null) {
            nativeMonitorAddLog(i, str, str2);
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            nativeInitMonitor(str);
        }
    }

    public static void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65542, null, z) == null) {
            nativeEnableMonitor(z);
        }
    }

    public static void a(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, strArr) == null) {
            nativeSetMonitorLogFilter(strArr);
        }
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) {
            if (!b) {
                a();
            }
            try {
                return nativeInitEngine(context, str);
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
