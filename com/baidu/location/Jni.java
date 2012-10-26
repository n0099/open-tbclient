package com.baidu.location;

import android.support.v4.view.accessibility.AccessibilityEventCompat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class Jni {

    /* renamed from: new  reason: not valid java name */
    private static int f25new = 0;

    /* renamed from: for  reason: not valid java name */
    private static int f22for = 1;

    /* renamed from: byte  reason: not valid java name */
    private static int f20byte = 2;
    private static int a = 11;

    /* renamed from: do  reason: not valid java name */
    private static int f21do = 12;

    /* renamed from: try  reason: not valid java name */
    private static int f26try = 13;

    /* renamed from: int  reason: not valid java name */
    private static int f24int = 14;

    /* renamed from: if  reason: not valid java name */
    private static int f23if = AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END;

    static {
        System.loadLibrary("locSDK_2.4");
    }

    Jni() {
    }

    private static native String a(byte[] bArr, int i);

    private static native String b(double d, double d2, int i, int i2);

    /* renamed from: if  reason: not valid java name */
    public static String m0if(String str) {
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[f23if];
        int length = bytes.length;
        int i = length <= 740 ? length : 740;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (bytes[i3] != 0) {
                bArr[i2] = bytes[i3];
                i2++;
            } else {
                j.a(f.g, "\\0 found in string");
            }
        }
        j.a(f.g, "number:" + bytes.length);
        return a(bArr, 132456) + "|tp=3";
    }

    /* renamed from: if  reason: not valid java name */
    public static double[] m1if(double d, double d2, String str) {
        double[] dArr = {0.0d, 0.0d};
        int i = -1;
        if (str.equals("bd09")) {
            i = f25new;
        } else if (str.equals("bd09ll")) {
            i = f22for;
        } else if (str.equals("gcj02")) {
            i = f20byte;
        } else if (str.equals("gps2gcj")) {
            i = a;
        } else if (str.equals("bd092gcj")) {
            i = f21do;
        } else if (str.equals("bd09ll2gcj")) {
            i = f26try;
        }
        j.a(f.g, "type:" + i);
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
