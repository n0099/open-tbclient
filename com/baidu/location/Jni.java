package com.baidu.location;

import com.baidu.zeus.NotificationProxy;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class Jni {

    /* renamed from: a  reason: collision with root package name */
    private static int f452a = 0;
    private static int b = 1;
    private static int c = 2;
    private static int d = 11;
    private static int e = 12;
    private static int f = 13;
    private static int g = 14;
    private static int h = NotificationProxy.MAX_URL_LENGTH;
    private static boolean i;

    static {
        i = false;
        try {
            System.loadLibrary("locSDK3");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            i = true;
        }
    }

    public static String a(String str) {
        if (i) {
            return "err!";
        }
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[h];
        int length = bytes.length;
        int i2 = length <= 740 ? length : 740;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (bytes[i4] != 0) {
                bArr[i3] = bytes[i4];
                i3++;
            } else {
                ap.a("baidu_location_service", "\\0 found in string");
            }
        }
        ap.a("baidu_location_service", "number:" + bytes.length);
        return a(bArr, 132456) + "|tp=3";
    }

    private static native String a(byte[] bArr, int i2);

    public static double[] a(double d2, double d3, String str) {
        double[] dArr = {0.0d, 0.0d};
        if (i) {
            return dArr;
        }
        int i2 = -1;
        if (str.equals("bd09")) {
            i2 = f452a;
        } else if (str.equals("bd09ll")) {
            i2 = b;
        } else if (str.equals("gcj02")) {
            i2 = c;
        } else if (str.equals("gps2gcj")) {
            i2 = d;
        } else if (str.equals("bd092gcj")) {
            i2 = e;
        } else if (str.equals("bd09ll2gcj")) {
            i2 = f;
        }
        ap.a("baidu_location_service", "type:" + i2);
        try {
            String[] split = b(d2, d3, i2, 132456).split(":");
            dArr[0] = Double.parseDouble(split[0]);
            dArr[1] = Double.parseDouble(split[1]);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return dArr;
    }

    private static native String b(double d2, double d3, int i2, int i3);
}
