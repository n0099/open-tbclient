package com.baidu.android.pushservice.jni;

import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.g.a;
import com.baidu.android.pushservice.j.q;
import com.baidu.android.pushservice.message.h;
/* loaded from: classes2.dex */
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
            System.loadLibrary("bdpush_V2_7");
            a = true;
        } catch (UnsatisfiedLinkError e2) {
            a.e(d, "Native library not found! Please copy libbdpush_V2_7.so into your project!");
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
                System.loadLibrary("bdpush_V2_7");
                a = true;
            } catch (UnsatisfiedLinkError e2) {
                Log.e("BDPushSDK-" + d, "Native library not found! Please copy libbdpush_V2_7.so into your project!");
            }
        }
        return a;
    }

    public static byte[] a(Context context, int i) {
        short a2;
        while (true) {
            if (b != null) {
                int length = b.length;
                if (length == c) {
                    b = null;
                    c = 0;
                } else if (length - c > 1) {
                    a2 = a(b, c);
                    a.b(d, "msgid:" + ((int) a2));
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
        byte[] bArr2 = new byte[2];
        System.arraycopy(b, c, bArr2, 0, bArr2.length);
        if (a2 == h.MSG_ID_TINY_HEARTBEAT_SERVER.a()) {
            a.b(d, "MSG_ID_TINY_HEARTBEAT_SERVER");
            q.b("MSG_ID_TINY_HEARTBEAT_SERVER", context);
        }
        c += 2;
        return bArr2;
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
