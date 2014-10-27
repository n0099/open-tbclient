package com.baidu.adp.lib.g;
/* loaded from: classes.dex */
public abstract class c {
    public static int f(String str, int i) {
        if (str != null) {
            try {
                return Integer.parseInt(str);
            } catch (Exception e) {
                return i;
            }
        }
        return i;
    }

    public static long a(String str, long j) {
        if (str != null) {
            try {
                return Long.parseLong(str);
            } catch (Exception e) {
                return j;
            }
        }
        return j;
    }

    public static float a(String str, float f) {
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
}
