package com.baidu.adp.lib.g;
/* loaded from: classes.dex */
public abstract class b {
    public static int g(String str, int i) {
        if (str != null) {
            try {
                return Integer.parseInt(str);
            } catch (Exception e) {
                return i;
            }
        }
        return i;
    }

    public static int h(String str, int i, int i2) {
        if (str != null) {
            try {
                return Integer.parseInt(str, i2);
            } catch (Exception e) {
                return i;
            }
        }
        return i;
    }

    public static long c(String str, long j) {
        if (str != null) {
            try {
                return Long.parseLong(str);
            } catch (Exception e) {
                return j;
            }
        }
        return j;
    }

    public static float c(String str, float f) {
        if (str != null) {
            try {
                return Float.parseFloat(str);
            } catch (Exception e) {
                return f;
            }
        }
        return f;
    }

    public static double a(String str, double d) {
        if (str != null) {
            try {
                return Double.parseDouble(str);
            } catch (Exception e) {
                return d;
            }
        }
        return d;
    }

    public static boolean c(String str, boolean z) {
        if (str != null) {
            try {
                return Boolean.parseBoolean(str);
            } catch (Exception e) {
                return z;
            }
        }
        return z;
    }
}
