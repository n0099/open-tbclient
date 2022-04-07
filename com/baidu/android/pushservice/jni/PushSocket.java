package com.baidu.android.pushservice.jni;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.pushservice.message.h;
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

    public static int a(int i, byte[] bArr, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), bArr, Integer.valueOf(i2)})) == null) {
            if (i >= 0) {
                return sendMsg(i, bArr, i2);
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public static short a(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, bArr, i)) == null) ? (short) ((bArr[i + 0] & 255) | (bArr[i + 1] << 8)) : invokeLI.shortValue;
    }

    public static void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, null, i) == null) {
            b = null;
            c = 0;
            if (i >= 0) {
                closeSocket(i);
            }
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
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

    /* JADX WARN: Code restructure failed: missing block: B:31:0x006d, code lost:
        r7 = new byte[2];
        java.lang.System.arraycopy(com.baidu.android.pushservice.jni.PushSocket.b, com.baidu.android.pushservice.jni.PushSocket.c, r7, 0, 2);
        com.baidu.android.pushservice.message.h.g.b();
        com.baidu.android.pushservice.jni.PushSocket.c += 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0081, code lost:
        return r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLI = interceptable.invokeLI(65541, null, context, i)) != null) {
            return (byte[]) invokeLI.objValue;
        }
        if (i < 0) {
            return null;
        }
        while (true) {
            byte[] bArr = b;
            if (bArr != null) {
                int length = bArr.length;
                int i2 = c;
                if (length == i2) {
                    b = null;
                    c = 0;
                } else if (length - i2 > 1) {
                    short a2 = a(bArr, i2);
                    if (a2 == h.f.b() || a2 == h.g.b()) {
                        break;
                    } else if (length - c < e && !b(i)) {
                        return null;
                    } else {
                        int b2 = b(b, c + f);
                        int i3 = c;
                        int i4 = e;
                        if (i3 + b2 + i4 <= length - i3) {
                            int i5 = i4 + b2;
                            byte[] bArr2 = new byte[i5];
                            System.arraycopy(b, i3, bArr2, 0, i5);
                            c += b2 + e;
                            return bArr2;
                        } else if (!b(i)) {
                            return null;
                        }
                    }
                } else if (!b(i)) {
                    return null;
                }
            } else if (!b(i)) {
                return null;
            }
        }
    }

    public static int b(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, bArr, i)) == null) ? ((bArr[i + 0] & 255) << 0) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 1] & 255) << 8) : invokeLI.intValue;
    }

    public static boolean b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) {
            byte[] rcvMsg = rcvMsg(i);
            if (rcvMsg == null || rcvMsg.length == 0) {
                return false;
            }
            byte[] bArr = b;
            if (bArr == null) {
                b = rcvMsg;
                return true;
            }
            byte[] bArr2 = new byte[bArr.length + rcvMsg.length];
            int i2 = c;
            System.arraycopy(bArr, i2, bArr2, 0, bArr.length - i2);
            System.arraycopy(rcvMsg, 0, bArr2, b.length, rcvMsg.length);
            b = bArr2;
            return true;
        }
        return invokeI.booleanValue;
    }

    public static native int closeSocket(int i);

    public static native int createSocket(String str, int i, OnCreateSocketListener onCreateSocketListener);

    public static native int getLastSocketError();

    public static native String getLastSocketIP();

    public static native boolean isIPv4Reachable();

    public static native byte[] rcvMsg(int i);

    public static native int sendMsg(int i, byte[] bArr, int i2);
}
