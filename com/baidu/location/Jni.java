package com.baidu.location;

import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes2.dex */
public class Jni {

    /* renamed from: a  reason: collision with root package name */
    public static int f6428a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f6429b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static int f6430c = 2;

    /* renamed from: d  reason: collision with root package name */
    public static int f6431d = 11;

    /* renamed from: e  reason: collision with root package name */
    public static int f6432e = 12;

    /* renamed from: f  reason: collision with root package name */
    public static int f6433f = 13;

    /* renamed from: g  reason: collision with root package name */
    public static int f6434g = 14;

    /* renamed from: h  reason: collision with root package name */
    public static int f6435h = 15;
    public static int i = 1024;
    public static boolean j = false;

    static {
        try {
            System.loadLibrary("locSDK7b");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            j = true;
        }
    }

    public static native String a(byte[] bArr, int i2);

    public static native String b(double d2, double d3, int i2, int i3);

    public static native String c(byte[] bArr, int i2);

    public static double[] coorEncrypt(double d2, double d3, String str) {
        double[] dArr = {0.0d, 0.0d};
        if (j) {
            return dArr;
        }
        int i2 = -1;
        if (str.equals(BDLocation.BDLOCATION_GCJ02_TO_BD09)) {
            i2 = f6428a;
        } else if (str.equals("bd09ll")) {
            i2 = f6429b;
        } else if (str.equals("gcj02")) {
            i2 = f6430c;
        } else if (str.equals(BDLocation.BDLOCATION_WGS84_TO_GCJ02)) {
            i2 = f6431d;
        } else if (str.equals(BDLocation.BDLOCATION_BD09_TO_GCJ02)) {
            i2 = f6432e;
        } else if (str.equals(BDLocation.BDLOCATION_BD09LL_TO_GCJ02)) {
            i2 = f6433f;
        } else if (str.equals("wgs842mc")) {
            i2 = f6435h;
        }
        try {
            String[] split = b(d2, d3, str.equals("gcj2wgs") ? 16 : i2, 132456).split(":");
            dArr[0] = Double.parseDouble(split[0]);
            dArr[1] = Double.parseDouble(split[1]);
        } catch (UnsatisfiedLinkError unused) {
        }
        return dArr;
    }

    public static native String ee(String str, int i2);

    public static String en1(String str) {
        if (j) {
            return "err!";
        }
        if (str == null) {
            return StringUtil.NULL_STRING;
        }
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[i];
        int length = bytes.length;
        if (length > 740) {
            length = 740;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (bytes[i3] != 0) {
                bArr[i2] = bytes[i3];
                i2++;
            }
        }
        try {
            return a(bArr, 132456);
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return "err!";
        }
    }

    public static String encode(String str) {
        if (j) {
            return "err!";
        }
        return en1(str) + "|tp=3";
    }

    public static String encode2(String str) {
        if (j) {
            return "err!";
        }
        if (str == null) {
            return StringUtil.NULL_STRING;
        }
        try {
            return c(str.getBytes(), 132456);
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return "err!";
        }
    }

    public static Long encode3(String str) {
        String str2;
        if (j) {
            return null;
        }
        try {
            str2 = new String(str.getBytes(), "UTF-8");
        } catch (Exception unused) {
            str2 = "";
        }
        try {
            return Long.valueOf(murmur(str2));
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static native String encodeNotLimit(String str, int i2);

    public static String encodeOfflineLocationUpdateRequest(String str) {
        String str2;
        String str3 = "err!";
        if (j) {
            return "err!";
        }
        try {
            str2 = new String(str.getBytes(), "UTF-8");
        } catch (Exception unused) {
            str2 = "";
        }
        try {
            str3 = encodeNotLimit(str2, 132456);
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
        return str3 + "|tp=3";
    }

    public static String encodeTp4(String str) {
        String str2;
        String str3 = "err!";
        if (j) {
            return "err!";
        }
        try {
            str2 = new String(str.getBytes(), "UTF-8");
        } catch (Exception unused) {
            str2 = "";
        }
        try {
            str3 = ee(str2, 132456);
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
        return str3 + "|tp=4";
    }

    public static double getGpsSwiftRadius(float f2, double d2, double d3) {
        if (j) {
            return 0.0d;
        }
        try {
            return gsr(f2, d2, d3);
        } catch (UnsatisfiedLinkError unused) {
            return 0.0d;
        }
    }

    public static native double gsr(float f2, double d2, double d3);

    public static native long murmur(String str);
}
