package com.baidu.android.pushservice.jni;

import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.message.h;
/* loaded from: classes.dex */
public class PushSocket {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f3402a = false;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f3403b = null;

    /* renamed from: c  reason: collision with root package name */
    public static int f3404c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static String f3405d = "PushSocket";

    /* renamed from: e  reason: collision with root package name */
    public static int f3406e = 36;

    /* renamed from: f  reason: collision with root package name */
    public static int f3407f = 32;

    /* loaded from: classes.dex */
    public interface OnCreateSocketListener {
        void onConnect(int i);
    }

    static {
        try {
            System.loadLibrary("bdpush_V3_4");
            f3402a = true;
        } catch (Throwable unused) {
        }
    }

    public static int a(int i, byte[] bArr, int i2) {
        if (i >= 0) {
            return sendMsg(i, bArr, i2);
        }
        return -1;
    }

    public static short a(byte[] bArr, int i) {
        return (short) ((bArr[i + 0] & 255) | (bArr[i + 1] << 8));
    }

    public static void a(int i) {
        f3403b = null;
        f3404c = 0;
        if (i >= 0) {
            closeSocket(i);
        }
    }

    public static boolean a() {
        if (!f3402a) {
            try {
                System.loadLibrary("bdpush_V3_4");
                f3402a = true;
            } catch (Throwable unused) {
                Log.e("BDPushSDK-" + f3405d, "Native library not found! Please copy libbdpush_V3_4.so into your project!");
            }
        }
        return f3402a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0069, code lost:
        r0 = new byte[2];
        java.lang.System.arraycopy(com.baidu.android.pushservice.jni.PushSocket.f3403b, com.baidu.android.pushservice.jni.PushSocket.f3404c, r0, 0, 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0079, code lost:
        if (r1 != com.baidu.android.pushservice.message.h.MSG_ID_TINY_HEARTBEAT_SERVER.b()) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007b, code lost:
        com.baidu.android.pushservice.j.m.a("MSG_ID_TINY_HEARTBEAT_SERVER", r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0080, code lost:
        com.baidu.android.pushservice.jni.PushSocket.f3404c += 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0085, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(Context context, int i) {
        if (i < 0) {
            return null;
        }
        while (true) {
            byte[] bArr = f3403b;
            if (bArr != null) {
                int length = bArr.length;
                int i2 = f3404c;
                if (length == i2) {
                    f3403b = null;
                    f3404c = 0;
                } else if (length - i2 > 1) {
                    short a2 = a(bArr, i2);
                    if (a2 == h.MSG_ID_TINY_HEARTBEAT_CLIENT.b() || a2 == h.MSG_ID_TINY_HEARTBEAT_SERVER.b()) {
                        break;
                    } else if (length - f3404c < f3406e && !b(i)) {
                        return null;
                    } else {
                        int b2 = b(f3403b, f3404c + f3407f);
                        int i3 = f3404c;
                        int i4 = f3406e;
                        if (i3 + b2 + i4 <= length - i3) {
                            int i5 = i4 + b2;
                            byte[] bArr2 = new byte[i5];
                            System.arraycopy(f3403b, i3, bArr2, 0, i5);
                            f3404c += b2 + f3406e;
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
        return ((bArr[i + 0] & 255) << 0) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 1] & 255) << 8);
    }

    public static boolean b(int i) {
        byte[] rcvMsg = rcvMsg(i);
        if (rcvMsg == null || rcvMsg.length == 0) {
            return false;
        }
        byte[] bArr = f3403b;
        if (bArr == null) {
            f3403b = rcvMsg;
            return true;
        }
        byte[] bArr2 = new byte[bArr.length + rcvMsg.length];
        int i2 = f3404c;
        System.arraycopy(bArr, i2, bArr2, 0, bArr.length - i2);
        System.arraycopy(rcvMsg, 0, bArr2, f3403b.length, rcvMsg.length);
        f3403b = bArr2;
        return true;
    }

    public static native int closeSocket(int i);

    public static native int createSocket(String str, int i, OnCreateSocketListener onCreateSocketListener);

    public static native int getLastSocketError();

    public static native String getLastSocketIP();

    public static native boolean isIPv4Reachable();

    public static native byte[] rcvMsg(int i);

    public static native int sendMsg(int i, byte[] bArr, int i2);
}
