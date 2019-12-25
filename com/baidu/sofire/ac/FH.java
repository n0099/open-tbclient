package com.baidu.sofire.ac;

import android.content.Context;
import android.support.media.ExifInterface;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.e;
import com.baidu.sofire.core.g;
import com.baidu.sofire.i.d;
import java.lang.reflect.Method;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class FH {
    public static final int INVOKE_METHOD_ERROR_DEFULT = -1;
    public static final int INVOKE_METHOD_ERROR_ILLGEAL_METHOD_NAME = -3;
    public static final int INVOKE_METHOD_ERROR_JSON = -2;
    public static final int INVOKE_METHOD_ERROR_METHOD_NOT_FOUND = -4;
    public static final int INVOKE_METHOD_ERROR_MUTI_METHOD = -5;
    public static final int INVOKE_METHOD_ERROR_PARAM_MISMATCH = -6;
    public static final int INVOKE_METHOD_SUCCESS = 0;
    public static final int TYPE_VERSION = 1;

    private FH() {
    }

    public static void init(Context context, String str, String str2, int... iArr) {
        e.a(context, 0, str, str2, iArr);
    }

    public static void initDelay(Context context, int i, String str, String str2, int... iArr) {
        e.a(context, i, str, str2, iArr);
    }

    public static boolean call(int i, String str) {
        return call(i, str, null);
    }

    public static Pair<Integer, Object> callSync(int i, String str) {
        return callSync(i, str, null, new Object[0]);
    }

    public static Pair<Integer, Object> callSync(int i, String str, Class<?>[] clsArr, Object... objArr) {
        return e.a(i, str, clsArr, objArr);
    }

    public static boolean call(int i, String str, Callback callback) {
        return call(i, str, callback, null, new Object[0]);
    }

    public static boolean call(int i, String str, Class<?>[] clsArr, Object... objArr) {
        return call(i, str, null, clsArr, objArr);
    }

    public static boolean call(int i, String str, Callback callback, Class<?>[] clsArr, Object... objArr) {
        return e.a(i, str, callback, clsArr, objArr);
    }

    public static boolean isInitSuc(int i) {
        return d.a(i);
    }

    public static Object getPInfo(int i, int i2) {
        switch (i2) {
            case 1:
                if (i <= 0) {
                    return "";
                }
                try {
                    g a = g.a();
                    if (a == null) {
                        return "";
                    }
                    List<ApkInfo> b = a.b();
                    if (b == null || b.size() <= 0) {
                        return "";
                    }
                    for (ApkInfo apkInfo : b) {
                        if (apkInfo.key == i) {
                            if (apkInfo.versionName == null) {
                                return "";
                            }
                            return apkInfo.versionName;
                        }
                    }
                    return "";
                } catch (Throwable th) {
                    d.a();
                    return "";
                }
            default:
                return "";
        }
    }

    public static String getVersion(Context context) {
        return "3.3.9.8.2";
    }

    public static String gzfi(Context context, String str, int i, String str2) {
        return e.a(context, str, i, str2);
    }

    public static String gzfi(Context context, String str, int i) {
        return e.a(context, str, i, (String) null);
    }

    public static String gz(Context context) {
        return e.b(context);
    }

    public static String gd(Context context) {
        return e.a(context);
    }

    public static String gt(Context context, String str, String str2, int i, String str3) {
        return e.a(context, str, str2, i, str3);
    }

    public static String xgz(Context context, String str) {
        return e.a(context, str);
    }

    public static void bc(Context context, boolean z) {
        e.a(context, z);
    }

    public static void setAgreePolicy(Context context, boolean z) {
        e.b(context, z);
    }

    public static Pair<Integer, String> invokeMethod(Context context, String str) {
        int i;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("f");
            if (TextUtils.isEmpty(optString) || "init".equals(optString) || "initDelay".equals(optString) || NotificationCompat.CATEGORY_CALL.equals(optString)) {
                return new Pair<>(-3, "");
            }
            Method method = null;
            JSONArray optJSONArray = jSONObject.optJSONArray("p");
            if (optString.equals("callSync")) {
                if (com.baidu.sofire.core.d.b == null && context != null) {
                    com.baidu.sofire.core.d.b = context.getApplicationContext();
                }
                if (optJSONArray != null && optJSONArray.length() == 2) {
                    method = FH.class.getMethod("callSync", Integer.TYPE, String.class);
                } else if (optJSONArray == null || optJSONArray.length() >= 2) {
                    method = FH.class.getMethod("callSync", Integer.TYPE, String.class, Class[].class, Object[].class);
                } else {
                    return new Pair<>(-6, "");
                }
            } else if (optString.equals("gzfi")) {
                if (optJSONArray != null && optJSONArray.length() == 2) {
                    method = FH.class.getMethod("gzfi", Context.class, String.class, Integer.TYPE);
                } else if (optJSONArray != null && optJSONArray.length() == 3) {
                    method = FH.class.getMethod("gzfi", Context.class, String.class, Integer.TYPE, String.class);
                } else {
                    return new Pair<>(-6, "");
                }
            } else {
                Method[] methods = FH.class.getMethods();
                int length = methods.length;
                int i2 = 0;
                int i3 = 0;
                while (i2 < length) {
                    Method method2 = methods[i2];
                    if (optString.equals(method2.getName())) {
                        if (method != null) {
                            method2 = method;
                        }
                        method = method2;
                        i = i3 + 1;
                    } else {
                        i = i3;
                    }
                    i2++;
                    i3 = i;
                }
                if (i3 <= 0 || method == null) {
                    return new Pair<>(-4, "");
                }
                if (i3 >= 2) {
                    return new Pair<>(-5, "");
                }
            }
            Object[] parseParams = parseParams(optString, context, optJSONArray, 0, method.getParameterTypes());
            if ("callSync".equals(optString)) {
                Pair pair = (Pair) method.invoke(null, parseParams);
                if (((Integer) pair.first).intValue() == 0) {
                    Object obj = pair.second;
                    if (obj == null) {
                        return new Pair<>(0, "");
                    }
                    return new Pair<>(0, obj.toString());
                }
                return new Pair<>(pair.first, "");
            }
            Object invoke = method.invoke(null, parseParams);
            if (invoke == null) {
                return new Pair<>(0, "");
            }
            return new Pair<>(0, invoke.toString());
        } catch (IllegalArgumentException e) {
            d.a();
            return new Pair<>(-6, "");
        } catch (Throwable th) {
            d.a();
            return new Pair<>(-1, "");
        }
    }

    private static Object[] parseParams(String str, Context context, JSONArray jSONArray, int i, Class[] clsArr) throws IllegalArgumentException {
        try {
            boolean equals = "callSync".equals(str);
            int length = (clsArr == null || clsArr.length == 0) ? 0 : clsArr.length;
            Object[] objArr = new Object[length];
            int i2 = i;
            Class[] clsArr2 = null;
            for (int i3 = 0; i3 < length; i3++) {
                if (clsArr == null) {
                    throw new IllegalArgumentException("parameterTypes null");
                }
                Class cls = clsArr[i3];
                if (cls.equals(Context.class)) {
                    if (context != null) {
                        objArr[i3] = context;
                    } else if (com.baidu.sofire.core.d.b != null) {
                        objArr[i3] = com.baidu.sofire.core.d.b;
                    } else {
                        throw new IllegalArgumentException("method request context");
                    }
                } else if (jSONArray == null) {
                    throw new IllegalArgumentException("request params but get null");
                } else {
                    String optString = jSONArray.optString(i2);
                    if (cls.equals(Boolean.TYPE) || cls.equals(Boolean.class)) {
                        if (TextUtils.isEmpty(optString)) {
                            throw new IllegalArgumentException("boolean not support null String");
                        }
                        objArr[i3] = Boolean.valueOf(parseBoolean(optString));
                        i2++;
                    } else if (cls.equals(Byte.TYPE) || cls.equals(Byte.class)) {
                        if (TextUtils.isEmpty(optString)) {
                            throw new IllegalArgumentException("byte not support null String");
                        }
                        objArr[i3] = Byte.valueOf(parseByte(optString));
                        i2++;
                    } else if (cls.equals(Character.TYPE)) {
                        if (TextUtils.isEmpty(optString)) {
                            throw new IllegalArgumentException("char not support null String");
                        }
                        objArr[i3] = Character.valueOf(parseChar(optString));
                        i2++;
                    } else if (cls.equals(Short.TYPE) || cls.equals(Short.class)) {
                        if (TextUtils.isEmpty(optString)) {
                            throw new IllegalArgumentException("short not support null String");
                        }
                        objArr[i3] = Short.valueOf(parseShort(optString));
                        i2++;
                    } else if (cls.equals(Integer.TYPE) || cls.equals(Integer.class)) {
                        if (TextUtils.isEmpty(optString)) {
                            throw new IllegalArgumentException("int not support null String");
                        }
                        objArr[i3] = Integer.valueOf(parseInt(optString));
                        i2++;
                    } else if (cls.equals(Long.TYPE) || cls.equals(Long.class)) {
                        if (TextUtils.isEmpty(optString)) {
                            throw new IllegalArgumentException("long not support null String");
                        }
                        objArr[i3] = Long.valueOf(parseLong(optString));
                        i2++;
                    } else if (cls.equals(Float.TYPE) || cls.equals(Float.class)) {
                        if (TextUtils.isEmpty(optString)) {
                            throw new IllegalArgumentException("float not support null String");
                        }
                        objArr[i3] = Float.valueOf(parseFloat(optString));
                        i2++;
                    } else if (cls.equals(Double.TYPE) || cls.equals(Double.class)) {
                        if (TextUtils.isEmpty(optString)) {
                            throw new IllegalArgumentException("double not support null String");
                        }
                        objArr[i3] = Double.valueOf(parseDouble(optString));
                        i2++;
                    } else if (cls.equals(String.class)) {
                        objArr[i3] = optString;
                        i2++;
                    } else if (cls.equals(Class[].class)) {
                        if (!equals) {
                            throw new IllegalArgumentException("only callSync support Class[]");
                        }
                        if (TextUtils.isEmpty(optString)) {
                            objArr[i3] = null;
                            clsArr2 = null;
                        } else {
                            clsArr2 = parseClassArray(optString);
                            objArr[i3] = clsArr2;
                        }
                        i2++;
                    } else if (!cls.equals(Object[].class)) {
                        continue;
                    } else if (!equals) {
                        throw new IllegalArgumentException("only callSync support Object[]");
                    } else {
                        if (clsArr2 == null) {
                            objArr[i3] = null;
                        } else {
                            objArr[i3] = parseParams("", context, jSONArray, i2, clsArr2);
                        }
                    }
                }
            }
            return objArr;
        } catch (Throwable th) {
            d.a();
            throw new IllegalArgumentException(th.getMessage());
        }
    }

    private static boolean parseBoolean(String str) throws IllegalArgumentException {
        if (ExifInterface.GPS_DIRECTION_TRUE.equals(str)) {
            return true;
        }
        if ("F".equals(str)) {
            return false;
        }
        throw new IllegalArgumentException("parse boolean fail:" + str);
    }

    private static byte parseByte(String str) throws IllegalArgumentException {
        try {
            int intValue = Integer.valueOf(str).intValue();
            if (intValue > 127 || intValue < -128) {
                throw new IllegalArgumentException("parse byte fail");
            }
            return (byte) intValue;
        } catch (Throwable th) {
            d.a();
            throw new IllegalArgumentException("parse byte fail:" + str);
        }
    }

    private static char parseChar(String str) throws IllegalArgumentException {
        try {
            if (str.length() != 1) {
                throw new IllegalArgumentException("parse char fail");
            }
            return str.charAt(0);
        } catch (Throwable th) {
            d.a();
            throw new IllegalArgumentException("parse char fail:" + str);
        }
    }

    private static short parseShort(String str) throws IllegalArgumentException {
        try {
            return Short.valueOf(str).shortValue();
        } catch (Throwable th) {
            d.a();
            throw new IllegalArgumentException("parse short fail:" + str);
        }
    }

    private static int parseInt(String str) throws IllegalArgumentException {
        try {
            return Integer.valueOf(str).intValue();
        } catch (Throwable th) {
            d.a();
            throw new IllegalArgumentException("parse int fail:" + str);
        }
    }

    private static long parseLong(String str) throws IllegalArgumentException {
        try {
            return Long.valueOf(str).longValue();
        } catch (Throwable th) {
            d.a();
            throw new IllegalArgumentException("parse long fail:" + str);
        }
    }

    private static float parseFloat(String str) throws IllegalArgumentException {
        try {
            return Float.valueOf(str).floatValue();
        } catch (Throwable th) {
            d.a();
            throw new IllegalArgumentException("parse float fail:" + str);
        }
    }

    private static double parseDouble(String str) throws IllegalArgumentException {
        try {
            return Double.valueOf(str).doubleValue();
        } catch (Throwable th) {
            d.a();
            throw new IllegalArgumentException("parse double fail:" + str);
        }
    }

    private static Class[] parseClassArray(String str) throws IllegalArgumentException {
        try {
            int length = str.length();
            Class[] clsArr = new Class[length];
            for (int i = 0; i < length; i++) {
                switch (str.charAt(i)) {
                    case 'B':
                        clsArr[i] = Byte.TYPE;
                        break;
                    case 'C':
                        clsArr[i] = Character.TYPE;
                        break;
                    case 'D':
                        clsArr[i] = Double.TYPE;
                        break;
                    case 'F':
                        clsArr[i] = Float.TYPE;
                        break;
                    case 'I':
                        clsArr[i] = Integer.TYPE;
                        break;
                    case 'J':
                        clsArr[i] = Long.TYPE;
                        break;
                    case 'S':
                        clsArr[i] = Short.TYPE;
                        break;
                    case 'T':
                        clsArr[i] = String.class;
                        break;
                    case 'Z':
                        clsArr[i] = Boolean.TYPE;
                        break;
                    default:
                        throw new IllegalArgumentException("parse classArray fail");
                }
            }
            return clsArr;
        } catch (Throwable th) {
            d.a();
            throw new IllegalArgumentException("parse classArray fail:" + str);
        }
    }
}
