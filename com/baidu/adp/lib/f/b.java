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
        if (str != null) {
            try {
                return Long.parseLong(str);
            } catch (Exception e) {
                return j;
            }
        }
        return j;
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
