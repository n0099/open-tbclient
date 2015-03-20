package com.baidu.location;
/* loaded from: classes.dex */
class Jni implements a0, n {
    private static boolean ft;
    private static int fw = 0;
    private static int fu = 1;
    private static int fv = 2;
    private static int fr = 11;
    private static int fs = 12;
    private static int fp = 13;
    private static int fo = 14;
    private static int fq = 1024;

    static {
        ft = false;
        try {
            System.loadLibrary("locSDK5");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            ft = true;
            throw new IllegalStateException("no found the liblocSDK4d.so file, please correct settings");
        }
    }

    Jni() {
    }

    private static native String a(byte[] bArr, int i);

    public static String aW() {
        return sky();
    }

    private static native String b(double d, double d2, int i, int i2);

    private static native String c(byte[] bArr, int i);

    private static native void f(byte[] bArr, byte[] bArr2);

    private static native String g(byte[] bArr);

    /* renamed from: if  reason: not valid java name */
    public static double[] m20if(double d, double d2, String str) {
        double[] dArr = {0.0d, 0.0d};
        if (ft) {
            return dArr;
        }
        int i = -1;
        if (str.equals(BDGeofence.COORD_TYPE_BD09)) {
            i = fw;
        } else if (str.equals(BDGeofence.COORD_TYPE_BD09LL)) {
            i = fu;
        } else if (str.equals(BDGeofence.COORD_TYPE_GCJ)) {
            i = fv;
        } else if (str.equals("gps2gcj")) {
            i = fr;
        } else if (str.equals("bd092gcj")) {
            i = fs;
        } else if (str.equals("bd09ll2gcj")) {
            i = fp;
        }
        try {
            String[] split = b(d, d2, i, 132456).split(":");
            dArr[0] = Double.parseDouble(split[0]);
            dArr[1] = Double.parseDouble(split[1]);
        } catch (Exception e) {
        }
        return dArr;
    }

    /* renamed from: int  reason: not valid java name */
    public static void m21int(String str, String str2) {
        try {
            f(str.getBytes(), str2.getBytes());
        } catch (Exception e) {
        }
    }

    public static String j(String str) {
        return ft ? "err!" : m(str) + "|tp=3";
    }

    public static String k(String str) {
        return ft ? "err!" : c(str.getBytes(), 132456);
    }

    public static String l(String str) {
        try {
            String g = g(str.getBytes());
            if (g == null || g.length() < 2 || "no".equals(g)) {
                return null;
            }
            return g;
        } catch (Exception e) {
            return null;
        }
    }

    public static String m(String str) {
        if (ft) {
            return "err!";
        }
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[fq];
        int length = bytes.length;
        int i = length <= 740 ? length : 740;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (bytes[i3] != 0) {
                bArr[i2] = bytes[i3];
                i2++;
            }
        }
        return a(bArr, 132456);
    }

    private static native String sky();
}
