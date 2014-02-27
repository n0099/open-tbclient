package com.baidu.adp.lib.f;
/* loaded from: classes.dex */
public abstract class b {
    public static int a(String str, int i) {
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
        if (str == null) {
            return 0L;
        }
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            return 0L;
        }
    }

    public static float a(String str, float f) {
        if (str == null) {
            return 0.0f;
        }
        try {
            return Float.parseFloat(str);
        } catch (Exception e) {
            return 0.0f;
        }
    }

    public static double a(String str, double d) {
        if (str == null) {
            return 0.0d;
        }
        try {
            return Double.parseDouble(str);
        } catch (Exception e) {
            return 0.0d;
        }
    }
}
