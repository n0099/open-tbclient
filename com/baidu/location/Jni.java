package com.baidu.location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class Jni {

    /* renamed from: new  reason: not valid java name */
    private static boolean f62new;

    /* renamed from: case  reason: not valid java name */
    private static int f57case = 0;

    /* renamed from: try  reason: not valid java name */
    private static int f63try = 1;

    /* renamed from: byte  reason: not valid java name */
    private static int f56byte = 2;

    /* renamed from: for  reason: not valid java name */
    private static int f59for = 11;

    /* renamed from: int  reason: not valid java name */
    private static int f61int = 12;

    /* renamed from: if  reason: not valid java name */
    private static int f60if = 13;

    /* renamed from: a  reason: collision with root package name */
    private static int f900a = 14;

    /* renamed from: do  reason: not valid java name */
    private static int f58do = 1024;

    static {
        f62new = false;
        try {
            System.loadLibrary("locSDK3");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            f62new = true;
        }
    }

    Jni() {
    }

    private static native String a(byte[] bArr, int i);

    private static native String b(double d, double d2, int i, int i2);

    /* renamed from: if  reason: not valid java name */
    public static String m17if(String str) {
        if (f62new) {
            return "err!";
        }
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[f58do];
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
    public static double[] m18if(double d, double d2, String str) {
        double[] dArr = {0.0d, 0.0d};
        if (f62new) {
            return dArr;
        }
        int i = -1;
        if (str.equals("bd09")) {
            i = f57case;
        } else if (str.equals("bd09ll")) {
            i = f63try;
        } else if (str.equals("gcj02")) {
            i = f56byte;
        } else if (str.equals("gps2gcj")) {
            i = f59for;
        } else if (str.equals("bd092gcj")) {
            i = f61int;
        } else if (str.equals("bd09ll2gcj")) {
            i = f60if;
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
