package com.baidu.android.pushservice.jni;

import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.message.h;
/* loaded from: classes3.dex */
public class PushSocket {
    public static boolean a;
    private static byte[] b = null;
    private static int c = 0;
    private static String d = "PushSocket";
    private static int e = 36;
    private static int f = 32;

    static {
        a = false;
        try {
            System.loadLibrary("bdpush_V2_9");
            a = true;
        } catch (UnsatisfiedLinkError e2) {
        }
    }

    public static short a(byte[] bArr, int i) {
        return (short) ((bArr[i + 1] << 8) | (bArr[i + 0] & 255));
    }

    public static void a(int i) {
        b = null;
        c = 0;
        closeSocket(i);
    }

    public static boolean a(Context context) {
        if (!a) {
            try {
                System.loadLibrary("bdpush_V2_9");
                a = true;
            } catch (UnsatisfiedLinkError e2) {
                Log.e("BDPushSDK-" + d, "Native library not found! Please copy libbdpush_V2_9.so into your project!");
            }
        }
        return a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0031, code lost:
        r0 = new byte[2];
        java.lang.System.arraycopy(com.baidu.android.pushservice.jni.PushSocket.b, com.baidu.android.pushservice.jni.PushSocket.c, r0, 0, r0.length);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0042, code lost:
        if (r2 != com.baidu.android.pushservice.message.h.MSG_ID_TINY_HEARTBEAT_SERVER.a()) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0044, code lost:
        com.baidu.android.pushservice.i.l.b("MSG_ID_TINY_HEARTBEAT_SERVER", r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004a, code lost:
        com.baidu.android.pushservice.jni.PushSocket.c += 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0050, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(Context context, int i) {
        while (true) {
            if (b != null) {
                int length = b.length;
                if (length == c) {
                    b = null;
                    c = 0;
                } else if (length - c > 1) {
                    short a2 = a(b, c);
                    if (a2 == h.MSG_ID_TINY_HEARTBEAT_CLIENT.a() || a2 == h.MSG_ID_TINY_HEARTBEAT_SERVER.a()) {
                        break;
                    } else if (length - c < e && !b(i)) {
                        return null;
                    } else {
                        int b2 = b(b, c + f);
                        if (c + b2 + e <= length - c) {
                            byte[] bArr = new byte[e + b2];
                            System.arraycopy(b, c, bArr, 0, bArr.length);
                            c += b2 + e;
                            return bArr;
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
        return ((bArr[i + 3] & 255) << 24) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 0] & 255) << 0);
    }

    private static boolean b(int i) {
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

    public static native int closeSocket(int i);

    public static native int createSocket(String str, int i);

    public static native int getLastSocketError();

    private static native byte[] rcvMsg(int i);

    public static native int sendMsg(int i, byte[] bArr, int i2);
}
