package com.baidu.ar.arplay.c;
/* loaded from: classes6.dex */
public class c {
    public static float a(Object obj, float f) {
        if (obj != null) {
            if ((obj instanceof Float) || (obj instanceof Integer)) {
                return ((Float) obj).floatValue();
            }
            if (obj instanceof String) {
                try {
                    return Float.parseFloat((String) obj);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return f;
                }
            }
            return f;
        }
        return f;
    }

    public static int a(Object obj, int i) {
        if (obj != null) {
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            if (obj instanceof Float) {
                return ((Float) obj).intValue();
            }
            if (obj instanceof String) {
                try {
                    return Integer.parseInt((String) obj);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return i;
                }
            }
            return i;
        }
        return i;
    }

    public static long a(Object obj, long j) {
        if (obj != null) {
            if ((obj instanceof Long) || (obj instanceof Float)) {
                return ((Long) obj).longValue();
            }
            if (obj instanceof String) {
                try {
                    return Long.parseLong((String) obj);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return j;
                }
            }
            return j;
        }
        return j;
    }

    public static String a(Object obj, String str) {
        return obj != null ? String.valueOf(obj) : str;
    }
}
