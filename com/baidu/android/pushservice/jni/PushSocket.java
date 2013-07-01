package com.baidu.android.pushservice.jni;

import com.baidu.android.common.logging.Log;
import com.baidu.android.pushservice.b;
import com.baidu.android.pushservice.message.a;
import com.baidu.android.pushservice.util.n;
/* loaded from: classes.dex */
public class PushSocket {

    /* renamed from: a  reason: collision with root package name */
    private static byte[] f316a = null;
    private static int b = 0;
    private static String c = "socket";
    private static int d = 36;
    private static int e = 32;

    static {
        System.loadLibrary("push-socket");
    }

    public static short a(byte[] bArr, int i) {
        return (short) ((bArr[i + 1] << 8) | (bArr[i + 0] & 255));
    }

    private static boolean a(int i) {
        byte[] rcvMsg = rcvMsg(i);
        if (rcvMsg == null || rcvMsg.length == 0) {
            return false;
        }
        if (f316a == null) {
            f316a = rcvMsg;
        } else {
            byte[] bArr = new byte[f316a.length + rcvMsg.length];
            System.arraycopy(f316a, b, bArr, 0, f316a.length - b);
            System.arraycopy(rcvMsg, 0, bArr, f316a.length, rcvMsg.length);
            f316a = bArr;
        }
        return true;
    }

    public static byte[] a(int i, a aVar) {
        short a2;
        while (true) {
            if (f316a != null) {
                int length = f316a.length;
                if (length == b) {
                    f316a = null;
                    b = 0;
                } else if (length - b > 1) {
                    a2 = a(f316a, b);
                    Log.i(c, "msgid:" + ((int) a2));
                    if (a2 == 5 || a2 == 6) {
                        break;
                    } else if (length - b < d && !a(i)) {
                        return null;
                    } else {
                        int b2 = b(f316a, b + e);
                        if (b + b2 + d <= length - b) {
                            byte[] bArr = new byte[d + b2];
                            System.arraycopy(f316a, b, bArr, 0, bArr.length);
                            b += b2 + d;
                            return bArr;
                        } else if (!a(i)) {
                            return null;
                        }
                    }
                } else if (!a(i)) {
                    return null;
                }
            } else if (!a(i)) {
                return null;
            }
        }
        byte[] bArr2 = new byte[2];
        System.arraycopy(f316a, b, bArr2, 0, bArr2.length);
        if (b.a() && a2 == 6) {
            Log.i(c, "MSG_ID_TINY_HEARTBEAT_SERVER");
            n.a("MSG_ID_TINY_HEARTBEAT_SERVER");
        }
        b += 2;
        return bArr2;
    }

    public static int b(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 0] & 255) << 0);
    }

    public static native int closeSocket(int i);

    public static native int createSocket(int i, int i2, int i3, String str, int i4);

    public static native int getLastSocketError();

    private static native byte[] rcvMsg(int i);

    public static native int sendMsg(int i, byte[] bArr, int i2);
}
