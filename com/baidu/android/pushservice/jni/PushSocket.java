package com.baidu.android.pushservice.jni;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class PushSocket {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = false;
    public static byte[] b = null;
    public static int c = 0;
    public static String d = "PushSocket";
    public static int e = 36;
    public static int f = 32;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public interface OnCreateSocketListener {
        void onConnect(int i);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(713882114, "Lcom/baidu/android/pushservice/jni/PushSocket;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(713882114, "Lcom/baidu/android/pushservice/jni/PushSocket;");
                return;
            }
        }
        try {
            System.loadLibrary("bdpush_V3_5");
            a = true;
        } catch (Throwable unused) {
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (!a) {
                try {
                    System.loadLibrary("bdpush_V3_5");
                    a = true;
                } catch (Throwable unused) {
                    Log.e("BDPushSDK-" + d, "Native library not found! Please copy libbdpush_V3_5.so into your project!");
                }
            }
            return a;
        }
        return invokeV.booleanValue;
    }

    public static native boolean isIPv4Reachable();
}
