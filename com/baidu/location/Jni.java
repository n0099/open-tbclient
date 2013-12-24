package com.baidu.location;

import com.baidu.zeus.NotificationProxy;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class Jni {

    /* renamed from: new  reason: not valid java name */
    private static boolean f26new;

    /* renamed from: case  reason: not valid java name */
    private static int f21case = 0;

    /* renamed from: try  reason: not valid java name */
    private static int f27try = 1;

    /* renamed from: byte  reason: not valid java name */
    private static int f20byte = 2;

    /* renamed from: for  reason: not valid java name */
    private static int f23for = 11;

    /* renamed from: int  reason: not valid java name */
    private static int f25int = 12;

    /* renamed from: if  reason: not valid java name */
    private static int f24if = 13;
    private static int a = 14;

    /* renamed from: do  reason: not valid java name */
    private static int f22do = NotificationProxy.MAX_URL_LENGTH;

    static {
        f26new = false;
        try {
            System.loadLibrary("locSDK3");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            f26new = true;
        }
    }

    Jni() {
    }

    private static native String a(byte[] bArr, int i);

    private static native String b(double d, double d2, int i, int i2);

    /* renamed from: if  reason: not valid java name */
    public static String m2if(String str) {
        if (f26new) {
            return "err!";
        }
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[f22do];
        int length = bytes.length;
        int i = length <= 740 ? length : 740;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (bytes[i3] != 0) {
                bArr[i2] = bytes[i3];
                i2++;
            } else {
                j.a(f.v, "\\0 found in string");
            }
        }
        j.a(f.v, "number:" + bytes.length);
        return a(bArr, 132456) + "|tp=3";
    }

    /* renamed from: if  reason: not valid java name */
    public static double[] m3if(double d, double d2, String str) {
        double[] dArr = {0.0d, 0.0d};
        if (f26new) {
            return dArr;
        }
        int i = -1;
        if (str.equals("bd09")) {
            i = f21case;
        } else if (str.equals("bd09ll")) {
            i = f27try;
        } else if (str.equals("gcj02")) {
            i = f20byte;
        } else if (str.equals("gps2gcj")) {
            i = f23for;
        } else if (str.equals("bd092gcj")) {
            i = f25int;
        } else if (str.equals("bd09ll2gcj")) {
            i = f24if;
        }
        j.a(f.v, "type:" + i);
        try {
            String[] split = b(d, d2, i, 132456).split(":");
            dArr[0] = Double.parseDouble(split[0]);
            dArr[1] = Double.parseDouble(split[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dArr;
    }
}
