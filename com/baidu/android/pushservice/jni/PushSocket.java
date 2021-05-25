package com.baidu.android.pushservice.jni;

import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.message.h;
/* loaded from: classes.dex */
public class PushSocket {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f3476a = false;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f3477b = null;

    /* renamed from: c  reason: collision with root package name */
    public static int f3478c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static String f3479d = "PushSocket";

    /* renamed from: e  reason: collision with root package name */
    public static int f3480e = 36;

    /* renamed from: f  reason: collision with root package name */
    public static int f3481f = 32;

    /* loaded from: classes.dex */
    public interface OnCreateSocketListener {
        void onConnect(int i2);
    }

    static {
        try {
            System.loadLibrary("bdpush_V3_4");
            f3476a = true;
        } catch (Throwable unused) {
        }
    }

    public static int a(int i2, byte[] bArr, int i3) {
        if (i2 >= 0) {
            return sendMsg(i2, bArr, i3);
        }
        return -1;
    }

    public static short a(byte[] bArr, int i2) {
        return (short) ((bArr[i2 + 0] & 255) | (bArr[i2 + 1] << 8));
    }

    public static void a(int i2) {
        f3477b = null;
        f3478c = 0;
        if (i2 >= 0) {
            closeSocket(i2);
        }
    }

    public static boolean a() {
        if (!f3476a) {
            try {
                System.loadLibrary("bdpush_V3_4");
                f3476a = true;
            } catch (Throwable unused) {
                Log.e("BDPushSDK-" + f3479d, "Native library not found! Please copy libbdpush_V3_4.so into your project!");
            }
        }
        return f3476a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0069, code lost:
        r0 = new byte[2];
        java.lang.System.arraycopy(com.baidu.android.pushservice.jni.PushSocket.f3477b, com.baidu.android.pushservice.jni.PushSocket.f3478c, r0, 0, 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0079, code lost:
        if (r1 != com.baidu.android.pushservice.message.h.MSG_ID_TINY_HEARTBEAT_SERVER.b()) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007b, code lost:
        com.baidu.android.pushservice.j.m.a("MSG_ID_TINY_HEARTBEAT_SERVER", r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0080, code lost:
        com.baidu.android.pushservice.jni.PushSocket.f3478c += 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0085, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(Context context, int i2) {
        if (i2 < 0) {
            return null;
        }
        while (true) {
            byte[] bArr = f3477b;
            if (bArr != null) {
                int length = bArr.length;
                int i3 = f3478c;
                if (length == i3) {
                    f3477b = null;
                    f3478c = 0;
                } else if (length - i3 > 1) {
                    short a2 = a(bArr, i3);
                    if (a2 == h.MSG_ID_TINY_HEARTBEAT_CLIENT.b() || a2 == h.MSG_ID_TINY_HEARTBEAT_SERVER.b()) {
                        break;
                    } else if (length - f3478c < f3480e && !b(i2)) {
                        return null;
                    } else {
                        int b2 = b(f3477b, f3478c + f3481f);
                        int i4 = f3478c;
                        int i5 = f3480e;
                        if (i4 + b2 + i5 <= length - i4) {
                            int i6 = i5 + b2;
                            byte[] bArr2 = new byte[i6];
                            System.arraycopy(f3477b, i4, bArr2, 0, i6);
                            f3478c += b2 + f3480e;
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
        return ((bArr[i2 + 0] & 255) << 0) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 1] & 255) << 8);
    }

    public static boolean b(int i2) {
        byte[] rcvMsg = rcvMsg(i2);
        if (rcvMsg == null || rcvMsg.length == 0) {
            return false;
        }
        byte[] bArr = f3477b;
        if (bArr == null) {
            f3477b = rcvMsg;
            return true;
        }
        byte[] bArr2 = new byte[bArr.length + rcvMsg.length];
        int i3 = f3478c;
        System.arraycopy(bArr, i3, bArr2, 0, bArr.length - i3);
        System.arraycopy(rcvMsg, 0, bArr2, f3477b.length, rcvMsg.length);
        f3477b = bArr2;
        return true;
    }

    public static native int closeSocket(int i2);

    public static native int createSocket(String str, int i2, OnCreateSocketListener onCreateSocketListener);

    public static native int getLastSocketError();

    public static native String getLastSocketIP();

    public static native boolean isIPv4Reachable();

    public static native byte[] rcvMsg(int i2);

    public static native int sendMsg(int i2, byte[] bArr, int i3);
}
