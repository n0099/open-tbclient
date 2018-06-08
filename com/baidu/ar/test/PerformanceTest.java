package com.baidu.ar.test;
/* loaded from: classes3.dex */
public class PerformanceTest {
    private static boolean a = false;
    private static boolean b = true;
    private static boolean c = true;
    private static boolean d = true;
    private static boolean e = true;
    private static int f = 25;

    public static int getMaxFrameRate() {
        return f;
    }

    public static boolean isDrawCamera() {
        return b || !a;
    }

    public static boolean isOpen3DEngine() {
        return c || !a;
    }

    public static boolean isOpenIMU() {
        return d || !a;
    }

    public static boolean isOpenSlam() {
        return e || !a;
    }

    public static boolean isTestOpen() {
        return a;
    }

    public static void setDrawCamera(boolean z) {
        b = z;
    }

    public static void setMaxFrameRate(int i) {
        f = i;
    }

    public static void setOpen3DEngine(boolean z) {
        c = z;
    }

    public static void setOpenIMU(boolean z) {
        d = z;
    }

    public static void setOpenSlam(boolean z) {
        e = z;
    }

    public static void setTestOpen(boolean z) {
        a = z;
    }
}
