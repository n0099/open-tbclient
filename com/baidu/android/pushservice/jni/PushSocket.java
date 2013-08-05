package com.baidu.android.pushservice.jni;

import com.baidu.android.common.logging.Log;
import com.baidu.android.pushservice.b;
import com.baidu.android.pushservice.message.a;
import com.baidu.android.pushservice.util.n;
/* loaded from: classes.dex */
public class PushSocket {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f586a;
    private static byte[] b = null;
    private static int c = 0;
    private static String d = "socket";
    private static int e = 36;
    private static int f = 32;

    static {
        f586a = false;
        try {
            System.loadLibrary("push-socket");
            f586a = true;
        } catch (UnsatisfiedLinkError e2) {
            Log.d(d, "native library not found!");
        }
    }

    public static short a(byte[] bArr, int i) {
        return (short) ((bArr[i + 1] << 8) | (bArr[i + 0] & 255));
    }

    private static boolean a(int i) {
        byte[] rcvMsg = rcvMsg(i);
        if (rcvMsg == null || rcvMsg.length == 0) {
            return false;
        }
        if (b == null) {
            b = rcvMsg;
        } else {
            byte[] bArr = new byte[b.length + rcvMsg.length];
            System.arraycopy(b, c, bArr, 0, b.length - c);
            System.arraycopy(rcvMsg, 0, bArr, b.length, rcvMsg.length);
            b = bArr;
        }
        return true;
    }

    public static byte[] a(int i, a aVar) {
        short a2;
        while (true) {
            if (b != null) {
                int length = b.length;
                if (length == c) {
                    b = null;
                    c = 0;
                } else if (length - c > 1) {
                    a2 = a(b, c);
                    Log.i(d, "msgid:" + ((int) a2));
                    if (a2 == 5 || a2 == 6) {
                        break;
                    } else if (length - c < e && !a(i)) {
                        return null;
                    } else {
                        int b2 = b(b, c + f);
                        if (c + b2 + e <= length - c) {
                            byte[] bArr = new byte[e + b2];
                            System.arraycopy(b, c, bArr, 0, bArr.length);
                            c += b2 + e;
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
        System.arraycopy(b, c, bArr2, 0, bArr2.length);
        if (b.a() && a2 == 6) {
            Log.i(d, "MSG_ID_TINY_HEARTBEAT_SERVER");
            n.a("MSG_ID_TINY_HEARTBEAT_SERVER");
        }
        c += 2;
        return bArr2;
    }

    public static int b(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 0] & 255) << 0);
    }

    public static native int closeSocket(int i);

    public static native int createSocket(String str, int i);

    public static native int getLastSocketError();

    private static native byte[] rcvMsg(int i);

    public static native int sendMsg(int i, byte[] bArr, int i2);
}
