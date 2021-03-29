package com.baidu.sofire.ac;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.c;
import com.baidu.sofire.core.d;
import com.baidu.sofire.core.f;
import com.baidu.sofire.g.s;
import java.lang.reflect.Method;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class FH {
    public static final int INVOKE_METHOD_ERROR_DEFULT = -1;
    public static final int INVOKE_METHOD_ERROR_ILLGEAL_METHOD_NAME = -3;
    public static final int INVOKE_METHOD_ERROR_JSON = -2;
    public static final int INVOKE_METHOD_ERROR_METHOD_NOT_FOUND = -4;
    public static final int INVOKE_METHOD_ERROR_MUTI_METHOD = -5;
    public static final int INVOKE_METHOD_ERROR_PARAM_MISMATCH = -6;
    public static final int INVOKE_METHOD_SUCCESS = 0;
    public static final int TYPE_VERSION = 1;

    public static void bc(Context context, boolean z) {
        d.a(context, z);
    }

    public static boolean call(int i, String str) {
        return call(i, str, null);
    }

    public static Pair<Integer, Object> callSync(int i, String str) {
        return callSync(i, str, null, new Object[0]);
    }

    public static String gd(Context context) {
        return "";
    }

    public static Object getPInfo(int i, int i2) {
        f a2;
        List<ApkInfo> b2;
        try {
            if (c.f11659b != null && s.a(c.f11659b) && i2 == 1 && i > 0 && (a2 = f.a()) != null && (b2 = a2.b()) != null && b2.size() > 0) {
                for (ApkInfo apkInfo : b2) {
                    if (apkInfo.key == i) {
                        return apkInfo.versionName == null ? "" : apkInfo.versionName;
                    }
                }
            }
            return "";
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
            return "";
        }
    }

    public static String getVersion(Context context) {
        return "3.5.7.3";
    }

    public static String gt(Context context, String str, String str2, int i, String str3) {
        return d.a(context, str, str2, i, str3);
    }

    public static String gz(Context context) {
        return d.a(context);
    }

    public static String gzfi(Context context, String str, int i, String str2) {
        return d.a(context, str, i, str2);
    }

    public static void init(Context context, String str, String str2, int... iArr) {
        d.a(context, 0, str, str2, iArr);
    }

    public static void initDelay(Context context, int i, String str, String str2, int... iArr) {
        d.a(context, i, str, str2, iArr);
    }

    public static Pair<Integer, String> invokeMethod(Context context, String str) {
        Method[] methods;
        Method method;
        try {
            if (!s.a(context)) {
                return new Pair<>(12, "");
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("f");
                if (!TextUtils.isEmpty(optString) && !"init".equals(optString) && !"initDelay".equals(optString) && !NotificationCompat.CATEGORY_CALL.equals(optString)) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("p");
                    if (optString.equals("callSync")) {
                        if (c.f11659b == null && context != null) {
                            c.f11659b = context.getApplicationContext();
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
                        Method method2 = null;
                        int i = 0;
                        for (Method method3 : FH.class.getMethods()) {
                            if (optString.equals(method3.getName())) {
                                if (method2 == null) {
                                    method2 = method3;
                                }
                                i++;
                            }
                        }
                        if (i > 0 && method2 != null) {
                            if (i >= 2) {
                                return new Pair<>(-5, "");
                            }
                            method = method2;
                        }
                        return new Pair<>(-4, "");
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
                }
                return new Pair<>(-3, "");
            } catch (Throwable unused) {
                com.baidu.sofire.g.d.a();
                return new Pair<>(-2, "");
            }
        } catch (IllegalArgumentException unused2) {
            com.baidu.sofire.g.d.a();
            return new Pair<>(-6, "");
        } catch (Throwable unused3) {
            com.baidu.sofire.g.d.a();
            return new Pair<>(-1, "");
        }
    }

    public static boolean isInitSuc(int i) {
        Context context = c.f11659b;
        if (context != null && s.a(context)) {
            return com.baidu.sofire.g.d.a(i);
        }
        return false;
    }

    public static boolean parseBoolean(String str) throws IllegalArgumentException {
        if (ExifInterface.GPS_DIRECTION_TRUE.equals(str)) {
            return true;
        }
        if ("F".equals(str)) {
            return false;
        }
        throw new IllegalArgumentException("parse boolean fail:" + str);
    }

    public static byte parseByte(String str) throws IllegalArgumentException {
        int intValue = Integer.valueOf(str).intValue();
        if (intValue > 127 || intValue < -128) {
            throw new IllegalArgumentException("parse byte fail");
        }
        return (byte) intValue;
    }

    public static char parseChar(String str) throws IllegalArgumentException {
        if (str.length() == 1) {
            return str.charAt(0);
        }
        throw new IllegalArgumentException("parse char fail");
    }

    public static Class[] parseClassArray(String str) throws IllegalArgumentException {
        int length = str.length();
        Class[] clsArr = new Class[length];
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == 'F') {
                clsArr[i] = Float.TYPE;
            } else if (charAt == 'Z') {
                clsArr[i] = Boolean.TYPE;
            } else if (charAt == 'I') {
                clsArr[i] = Integer.TYPE;
            } else if (charAt == 'J') {
                clsArr[i] = Long.TYPE;
            } else if (charAt == 'S') {
                clsArr[i] = Short.TYPE;
            } else if (charAt != 'T') {
                switch (charAt) {
                    case 'B':
                        clsArr[i] = Byte.TYPE;
                        continue;
                    case 'C':
                        clsArr[i] = Character.TYPE;
                        continue;
                    case 'D':
                        clsArr[i] = Double.TYPE;
                        continue;
                    default:
                        throw new IllegalArgumentException("parse classArray fail");
                }
            } else {
                clsArr[i] = String.class;
            }
        }
        return clsArr;
    }

    public static double parseDouble(String str) throws IllegalArgumentException {
        return Double.valueOf(str).doubleValue();
    }

    public static float parseFloat(String str) throws IllegalArgumentException {
        return Float.valueOf(str).floatValue();
    }

    public static int parseInt(String str) throws IllegalArgumentException {
        return Integer.valueOf(str).intValue();
    }

    public static long parseLong(String str) throws IllegalArgumentException {
        return Long.valueOf(str).longValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object[] parseParams(String str, Context context, JSONArray jSONArray, int i, Class[] clsArr) throws IllegalArgumentException {
        int i2;
        try {
            boolean equals = "callSync".equals(str);
            if (clsArr != null && clsArr.length != 0) {
                i2 = clsArr.length;
                Object[] objArr = new Object[i2];
                Class[] clsArr2 = null;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (clsArr != null) {
                        Class cls = clsArr[i3];
                        if (cls.equals(Context.class)) {
                            if (context != null) {
                                objArr[i3] = context;
                            } else if (c.f11659b != null) {
                                objArr[i3] = c.f11659b;
                            } else {
                                throw new IllegalArgumentException("method request context");
                            }
                        } else if (jSONArray != null) {
                            String optString = jSONArray.optString(i);
                            if (!cls.equals(Boolean.TYPE) && !cls.equals(Boolean.class)) {
                                if (!cls.equals(Byte.TYPE) && !cls.equals(Byte.class)) {
                                    if (cls.equals(Character.TYPE)) {
                                        if (!TextUtils.isEmpty(optString)) {
                                            objArr[i3] = Character.valueOf(parseChar(optString));
                                        } else {
                                            throw new IllegalArgumentException("char not support null String");
                                        }
                                    } else {
                                        if (!cls.equals(Short.TYPE) && !cls.equals(Short.class)) {
                                            if (!cls.equals(Integer.TYPE) && !cls.equals(Integer.class)) {
                                                if (!cls.equals(Long.TYPE) && !cls.equals(Long.class)) {
                                                    if (!cls.equals(Float.TYPE) && !cls.equals(Float.class)) {
                                                        if (!cls.equals(Double.TYPE) && !cls.equals(Double.class)) {
                                                            if (cls.equals(String.class)) {
                                                                objArr[i3] = optString;
                                                            } else if (cls.equals(Class[].class)) {
                                                                if (equals) {
                                                                    if (TextUtils.isEmpty(optString)) {
                                                                        objArr[i3] = null;
                                                                        clsArr2 = null;
                                                                    } else {
                                                                        clsArr2 = parseClassArray(optString);
                                                                        objArr[i3] = clsArr2;
                                                                    }
                                                                } else {
                                                                    throw new IllegalArgumentException("only callSync support Class[]");
                                                                }
                                                            } else if (!cls.equals(Object[].class)) {
                                                                continue;
                                                            } else if (!equals) {
                                                                throw new IllegalArgumentException("only callSync support Object[]");
                                                            } else {
                                                                if (clsArr2 == null) {
                                                                    objArr[i3] = null;
                                                                } else {
                                                                    objArr[i3] = parseParams("", context, jSONArray, i, clsArr2);
                                                                }
                                                            }
                                                        }
                                                        if (!TextUtils.isEmpty(optString)) {
                                                            objArr[i3] = Double.valueOf(parseDouble(optString));
                                                        } else {
                                                            throw new IllegalArgumentException("double not support null String");
                                                        }
                                                    }
                                                    if (!TextUtils.isEmpty(optString)) {
                                                        objArr[i3] = Float.valueOf(parseFloat(optString));
                                                    } else {
                                                        throw new IllegalArgumentException("float not support null String");
                                                    }
                                                }
                                                if (!TextUtils.isEmpty(optString)) {
                                                    objArr[i3] = Long.valueOf(parseLong(optString));
                                                } else {
                                                    throw new IllegalArgumentException("long not support null String");
                                                }
                                            }
                                            if (!TextUtils.isEmpty(optString)) {
                                                objArr[i3] = Integer.valueOf(parseInt(optString));
                                            } else {
                                                throw new IllegalArgumentException("int not support null String");
                                            }
                                        }
                                        if (!TextUtils.isEmpty(optString)) {
                                            objArr[i3] = Short.valueOf(parseShort(optString));
                                        } else {
                                            throw new IllegalArgumentException("short not support null String");
                                        }
                                    }
                                    i++;
                                }
                                if (!TextUtils.isEmpty(optString)) {
                                    objArr[i3] = Byte.valueOf(parseByte(optString));
                                    i++;
                                } else {
                                    throw new IllegalArgumentException("byte not support null String");
                                }
                            }
                            if (!TextUtils.isEmpty(optString)) {
                                objArr[i3] = Boolean.valueOf(parseBoolean(optString));
                                i++;
                            } else {
                                throw new IllegalArgumentException("boolean not support null String");
                            }
                        } else {
                            throw new IllegalArgumentException("request params but get null");
                        }
                    } else {
                        throw new IllegalArgumentException("parameterTypes null");
                    }
                }
                return objArr;
            }
            i2 = 0;
            Object[] objArr2 = new Object[i2];
            Class[] clsArr22 = null;
            while (i3 < i2) {
            }
            return objArr2;
        } catch (Throwable th) {
            com.baidu.sofire.g.d.a();
            throw new IllegalArgumentException(th.getMessage());
        }
    }

    public static short parseShort(String str) throws IllegalArgumentException {
        return Short.valueOf(str).shortValue();
    }

    public static void setAgreePolicy(Context context, boolean z) {
        d.b(context, z);
    }

    public static void setDid(Context context, String str) {
        d.b(context, str);
    }

    public static String xgz(Context context, String str) {
        return d.a(context, str);
    }

    public static boolean call(int i, String str, Callback callback) {
        return call(i, str, callback, null, new Object[0]);
    }

    public static Pair<Integer, Object> callSync(int i, String str, Class<?>[] clsArr, Object... objArr) {
        return d.a(i, str, clsArr, objArr);
    }

    public static String gzfi(Context context, String str, int i) {
        return d.a(context, str, i, (String) null);
    }

    public static boolean call(int i, String str, Class<?>[] clsArr, Object... objArr) {
        return call(i, str, null, clsArr, objArr);
    }

    public static boolean call(int i, String str, Callback callback, Class<?>[] clsArr, Object... objArr) {
        return d.a(i, str, callback, clsArr, objArr);
    }
}
