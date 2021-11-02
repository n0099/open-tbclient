package com.baidu.android.pushservice.jni;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.pushservice.message.h;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class PushSocket {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f35725a = false;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f35726b = null;

    /* renamed from: c  reason: collision with root package name */
    public static int f35727c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static String f35728d = "PushSocket";

    /* renamed from: e  reason: collision with root package name */
    public static int f35729e = 36;

    /* renamed from: f  reason: collision with root package name */
    public static int f35730f = 32;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface OnCreateSocketListener {
        void onConnect(int i2);
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
            System.loadLibrary("bdpush_V3_4");
            f35725a = true;
        } catch (Throwable unused) {
        }
    }

    public static int a(int i2, byte[] bArr, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), bArr, Integer.valueOf(i3)})) == null) {
            if (i2 >= 0) {
                return sendMsg(i2, bArr, i3);
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public static short a(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, bArr, i2)) == null) ? (short) ((bArr[i2 + 0] & 255) | (bArr[i2 + 1] << 8)) : invokeLI.shortValue;
    }

    public static void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, null, i2) == null) {
            f35726b = null;
            f35727c = 0;
            if (i2 >= 0) {
                closeSocket(i2);
            }
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (!f35725a) {
                try {
                    System.loadLibrary("bdpush_V3_4");
                    f35725a = true;
                } catch (Throwable unused) {
                    String str = "BDPushSDK-" + f35728d;
                }
            }
            return f35725a;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x006d, code lost:
        r0 = new byte[2];
        java.lang.System.arraycopy(com.baidu.android.pushservice.jni.PushSocket.f35726b, com.baidu.android.pushservice.jni.PushSocket.f35727c, r0, 0, 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007d, code lost:
        if (r1 != com.baidu.android.pushservice.message.h.f35794g.b()) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007f, code lost:
        com.baidu.android.pushservice.j.m.a("MSG_ID_TINY_HEARTBEAT_SERVER", r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0084, code lost:
        com.baidu.android.pushservice.jni.PushSocket.f35727c += 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0089, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, context, i2)) != null) {
            return (byte[]) invokeLI.objValue;
        }
        if (i2 < 0) {
            return null;
        }
        while (true) {
            byte[] bArr = f35726b;
            if (bArr != null) {
                int length = bArr.length;
                int i3 = f35727c;
                if (length == i3) {
                    f35726b = null;
                    f35727c = 0;
                } else if (length - i3 > 1) {
                    short a2 = a(bArr, i3);
                    if (a2 == h.f35793f.b() || a2 == h.f35794g.b()) {
                        break;
                    } else if (length - f35727c < f35729e && !b(i2)) {
                        return null;
                    } else {
                        int b2 = b(f35726b, f35727c + f35730f);
                        int i4 = f35727c;
                        int i5 = f35729e;
                        if (i4 + b2 + i5 <= length - i4) {
                            int i6 = i5 + b2;
                            byte[] bArr2 = new byte[i6];
                            System.arraycopy(f35726b, i4, bArr2, 0, i6);
                            f35727c += b2 + f35729e;
                            return bArr2;
                        } else if (!b(i2)) {
                            return null;
                        }
                    }
                } else if (!b(i2)) {
                    return null;
                }
            } else if (!b(i2)) {
                return null;
            }
        }
    }

    public static int b(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, null, bArr, i2)) == null) ? ((bArr[i2 + 0] & 255) << 0) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 1] & 255) << 8) : invokeLI.intValue;
    }

    public static boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i2)) == null) {
            byte[] rcvMsg = rcvMsg(i2);
            if (rcvMsg == null || rcvMsg.length == 0) {
                return false;
            }
            byte[] bArr = f35726b;
            if (bArr == null) {
                f35726b = rcvMsg;
                return true;
            }
            byte[] bArr2 = new byte[bArr.length + rcvMsg.length];
            int i3 = f35727c;
            System.arraycopy(bArr, i3, bArr2, 0, bArr.length - i3);
            System.arraycopy(rcvMsg, 0, bArr2, f35726b.length, rcvMsg.length);
            f35726b = bArr2;
            return true;
        }
        return invokeI.booleanValue;
    }

    public static native int closeSocket(int i2);

    public static native int createSocket(String str, int i2, OnCreateSocketListener onCreateSocketListener);

    public static native int getLastSocketError();

    public static native String getLastSocketIP();

    public static native boolean isIPv4Reachable();

    public static native byte[] rcvMsg(int i2);

    public static native int sendMsg(int i2, byte[] bArr, int i3);
}
