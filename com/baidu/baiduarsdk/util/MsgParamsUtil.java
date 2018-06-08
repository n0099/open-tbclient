package com.baidu.baiduarsdk.util;

import java.util.HashMap;
/* loaded from: classes3.dex */
public class MsgParamsUtil {
    public static float obj2Float(Object obj, float f) {
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

    public static HashMap<String, Object> obj2HashMap(Object obj, HashMap<String, Object> hashMap) {
        return (obj == null || !(obj instanceof HashMap)) ? hashMap : (HashMap) obj;
    }

    public static int obj2Int(Object obj, int i) {
        if (obj != null) {
            if ((obj instanceof Integer) || (obj instanceof Float)) {
                return ((Integer) obj).intValue();
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

    public static long obj2Long(Object obj, long j) {
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

    public static String obj2String(Object obj, String str) {
        return obj != null ? String.valueOf(obj) : str;
    }

    public static float[] str2FloatArray(String str) {
        String[] split = str.split(",");
        float[] fArr = new float[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                fArr[i] = Float.parseFloat(split[i]);
            } catch (NumberFormatException e) {
                throw e;
            }
        }
        return fArr;
    }

    public static String[] str2StringArray(String str) {
        return str.split(",");
    }
}
