package com.baidu.sofire.ac;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.sofire.a.b;
import com.baidu.sofire.b.c;
import com.baidu.sofire.b.i;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.j.a;
import com.baidu.sofire.k.k;
import com.baidu.sofire.k.q;
import com.baidu.sofire.k.r;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class FH {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INVOKE_METHOD_ERROR_DEFULT = -1;
    public static final int INVOKE_METHOD_ERROR_ILLGEAL_METHOD_NAME = -3;
    public static final int INVOKE_METHOD_ERROR_JSON = -2;
    public static final int INVOKE_METHOD_ERROR_METHOD_NOT_FOUND = -4;
    public static final int INVOKE_METHOD_ERROR_MUTI_METHOD = -5;
    public static final int INVOKE_METHOD_ERROR_PARAM_MISMATCH = -6;
    public static final int INVOKE_METHOD_SUCCESS = 0;
    public static final int TYPE_VERSION = 1;
    public transient /* synthetic */ FieldHolder $fh;

    public static String gd(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) ? "" : (String) invokeL.objValue;
    }

    public static String getVersion(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) ? "3.6.0.4" : (String) invokeL.objValue;
    }

    public FH() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void bc(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65537, null, context, z) == null) {
            String str = c.a;
            if (context != null && r.a(context)) {
                a.a(context).a(z);
            }
        }
    }

    public static boolean call(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i, str)) == null) {
            return call(i, str, null);
        }
        return invokeIL.booleanValue;
    }

    public static Pair<Integer, Object> callSync(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65542, null, i, str)) == null) {
            return callSync(i, str, null, new Object[0]);
        }
        return (Pair) invokeIL.objValue;
    }

    public static void setAgreePolicy(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65568, null, context, z) == null) {
            c.a(context, z);
        }
    }

    public static boolean call(int i, String str, Callback callback) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65539, null, i, str, callback)) == null) {
            return call(i, str, callback, null, new Object[0]);
        }
        return invokeILL.booleanValue;
    }

    public static String gzfi(Context context, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65550, null, context, str, i)) == null) {
            k.a();
            return c.a(context, str, i, (String) null);
        }
        return (String) invokeLLI.objValue;
    }

    public static void tryLoadModule(Context context, BDModuleLoadCallback bDModuleLoadCallback, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65571, null, context, bDModuleLoadCallback, i) == null) {
            c.a(context, i, bDModuleLoadCallback, true);
        }
    }

    public static boolean call(int i, String str, Callback callback, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i), str, callback, clsArr, objArr})) == null) {
            return c.a(i, str, callback, clsArr, objArr);
        }
        return invokeCommon.booleanValue;
    }

    public static void initDelay(Context context, int i, String str, String str2, int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65555, null, new Object[]{context, Integer.valueOf(i), str, str2, iArr}) == null) {
            c.a(context, i, str, str2, iArr);
        }
    }

    public static boolean call(int i, String str, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Integer.valueOf(i), str, clsArr, objArr})) == null) {
            return call(i, str, null, clsArr, objArr);
        }
        return invokeCommon.booleanValue;
    }

    public static Pair<Integer, Object> callSync(int i, String str, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Integer.valueOf(i), str, clsArr, objArr})) == null) {
            return c.a(i, str, clsArr, objArr);
        }
        return (Pair) invokeCommon.objValue;
    }

    public static String gzfi(Context context, String str, int i, String str2) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65551, null, context, str, i, str2)) == null) {
            k.a();
            return c.a(context, str, i, str2);
        }
        return (String) invokeLLIL.objValue;
    }

    public static void init(Context context, String str, String str2, int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65553, null, context, str, str2, iArr) == null) {
            c.a(context, 0, str, str2, iArr);
        }
    }

    public static Pair<Integer, String> gel() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            String str2 = c.a;
            try {
                if (TextUtils.isEmpty(com.baidu.sofire.b.a.a)) {
                    str = "";
                } else {
                    str = Base64.encodeToString(com.baidu.sofire.b.a.a.getBytes(), 0);
                }
                return new Pair<>(Integer.valueOf(com.baidu.sofire.b.a.b), str);
            } catch (Throwable unused) {
                int i = b.a;
                return new Pair<>(Integer.valueOf(com.baidu.sofire.b.a.b), "");
            }
        }
        return (Pair) invokeV.objValue;
    }

    public static Object getPInfo(int i, int i2) {
        InterceptResult invokeII;
        i iVar;
        List<ApkInfo> b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65546, null, i, i2)) == null) {
            try {
                Context context = com.baidu.sofire.b.b.e;
                if (context != null && r.a(context) && i2 == 1 && i > 0 && (iVar = i.g) != null && (b = iVar.b()) != null && b.size() > 0) {
                    for (ApkInfo apkInfo : b) {
                        if (apkInfo.key == i) {
                            String str = apkInfo.versionName;
                            if (str == null) {
                                return "";
                            }
                            return str;
                        }
                    }
                }
                return "";
            } catch (Throwable unused) {
                int i3 = b.a;
                return "";
            }
        }
        return invokeII.objValue;
    }

    public static String gt(Context context, String str, String str2, int i, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{context, str, str2, Integer.valueOf(i), str3})) == null) {
            String str4 = c.a;
            if (context != null) {
                try {
                } catch (Throwable unused) {
                    int i2 = b.a;
                }
                if (r.a(context)) {
                    if (TextUtils.isEmpty(str)) {
                        return com.baidu.sofire.k.b.a(context, 8);
                    }
                    int i3 = 2;
                    Pair<Integer, Object> a = c.a(100067, "retrieveToken", new Class[]{String.class, String.class, Integer.TYPE, String.class}, str, str2, Integer.valueOf(i), str3);
                    if (((Integer) a.first).intValue() == 0) {
                        String str5 = (String) a.second;
                        if (!TextUtils.isEmpty(str5)) {
                            return str5;
                        }
                        return com.baidu.sofire.k.b.a(context, 9);
                    }
                    if (((Integer) a.first).intValue() != 4 && ((Integer) a.first).intValue() != 3) {
                        if (((Integer) a.first).intValue() == 5 || ((Integer) a.first).intValue() == 11) {
                            return com.baidu.sofire.k.b.a(context, 7);
                        }
                        return com.baidu.sofire.k.b.a(context, 8);
                    }
                    String[] o = com.baidu.sofire.k.b.o(context);
                    c.a(context, 0, o[0], o[1], 100067);
                    if (((Integer) a.first).intValue() == 3) {
                        i3 = 5;
                    }
                    return com.baidu.sofire.k.b.a(context, i3);
                }
            }
            return "";
        }
        return (String) invokeCommon.objValue;
    }

    public static String gz(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            return c.b(context);
        }
        return (String) invokeL.objValue;
    }

    public static boolean isInitSuc(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65557, null, i)) == null) {
            Context context = com.baidu.sofire.b.b.e;
            if (context != null && r.a(context)) {
                return com.baidu.sofire.k.b.b(i);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public static void setDeviceInfoCallback(DeviceInfoCallback deviceInfoCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65569, null, deviceInfoCallback) == null) {
            q.a = deviceInfoCallback;
        }
    }

    public static void init(Context context, String str, String str2, BDModuleLoadCallback bDModuleLoadCallback, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{context, str, str2, bDModuleLoadCallback, Integer.valueOf(i)}) == null) {
            c.a(context, 0, str, str2, bDModuleLoadCallback, i);
        }
    }

    public static void initDelay(Context context, int i, String str, String str2, BDModuleLoadCallback bDModuleLoadCallback, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, null, new Object[]{context, Integer.valueOf(i), str, str2, bDModuleLoadCallback, Integer.valueOf(i2)}) == null) {
            c.a(context, i, str, str2, bDModuleLoadCallback, i2);
        }
    }

    public static Pair<Integer, String> invokeMethod(Context context, String str) {
        InterceptResult invokeLL;
        Method[] methods;
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, context, str)) == null) {
            try {
                if (context == null) {
                    return new Pair<>(-1, "");
                }
                if (!r.a(context)) {
                    return new Pair<>(12, "");
                }
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("f");
                if (!TextUtils.isEmpty(optString) && !"init".equals(optString) && !"initDelay".equals(optString) && !NotificationCompat.CATEGORY_CALL.equals(optString)) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("p");
                    if (optString.equals("callSync")) {
                        if (com.baidu.sofire.b.b.e == null) {
                            com.baidu.sofire.b.b.e = context.getApplicationContext();
                        }
                        if (optJSONArray != null && optJSONArray.length() == 2) {
                            method = FH.class.getMethod("callSync", Integer.TYPE, String.class);
                        } else if (optJSONArray != null && optJSONArray.length() < 2) {
                            return new Pair<>(-6, "");
                        } else {
                            method = FH.class.getMethod("callSync", Integer.TYPE, String.class, Class[].class, Object[].class);
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
            } catch (IllegalArgumentException unused) {
                int i2 = b.a;
                return new Pair<>(-6, "");
            } catch (Throwable unused2) {
                int i3 = b.a;
                return new Pair<>(-1, "");
            }
        }
        return (Pair) invokeLL.objValue;
    }

    public static boolean parseBoolean(String str) throws IllegalArgumentException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, str)) == null) {
            if (ExifInterface.GPS_DIRECTION_TRUE.equals(str)) {
                return true;
            }
            if ("F".equals(str)) {
                return false;
            }
            throw new IllegalArgumentException("parse boolean fail:" + str);
        }
        return invokeL.booleanValue;
    }

    public static char parseChar(String str) throws IllegalArgumentException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, str)) == null) {
            if (str.length() == 1) {
                return str.charAt(0);
            }
            throw new IllegalArgumentException("parse char fail");
        }
        return invokeL.charValue;
    }

    public static double parseDouble(String str) throws IllegalArgumentException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, str)) == null) {
            return Double.valueOf(str).doubleValue();
        }
        return invokeL.doubleValue;
    }

    public static float parseFloat(String str) throws IllegalArgumentException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, str)) == null) {
            return Float.valueOf(str).floatValue();
        }
        return invokeL.floatValue;
    }

    public static int parseInt(String str) throws IllegalArgumentException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, str)) == null) {
            return Integer.valueOf(str).intValue();
        }
        return invokeL.intValue;
    }

    public static long parseLong(String str) throws IllegalArgumentException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, str)) == null) {
            return Long.valueOf(str).longValue();
        }
        return invokeL.longValue;
    }

    public static short parseShort(String str) throws IllegalArgumentException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, str)) == null) {
            return Short.valueOf(str).shortValue();
        }
        return invokeL.shortValue;
    }

    public static byte parseByte(String str) throws IllegalArgumentException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, str)) == null) {
            int intValue = Integer.valueOf(str).intValue();
            if (intValue <= 127 && intValue >= -128) {
                return (byte) intValue;
            }
            throw new IllegalArgumentException("parse byte fail");
        }
        return invokeL.byteValue;
    }

    public static Class[] parseClassArray(String str) throws IllegalArgumentException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, str)) == null) {
            int length = str.length();
            Class[] clsArr = new Class[length];
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt != 'F') {
                    if (charAt != 'Z') {
                        if (charAt != 'I') {
                            if (charAt != 'J') {
                                if (charAt != 'S') {
                                    if (charAt != 'T') {
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
                                } else {
                                    clsArr[i] = Short.TYPE;
                                }
                            } else {
                                clsArr[i] = Long.TYPE;
                            }
                        } else {
                            clsArr[i] = Integer.TYPE;
                        }
                    } else {
                        clsArr[i] = Boolean.TYPE;
                    }
                } else {
                    clsArr[i] = Float.TYPE;
                }
            }
            return clsArr;
        }
        return (Class[]) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object[] parseParams(String str, Context context, JSONArray jSONArray, int i, Class[] clsArr) throws IllegalArgumentException {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65566, null, new Object[]{str, context, jSONArray, Integer.valueOf(i), clsArr})) == null) {
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
                                } else {
                                    Context context2 = com.baidu.sofire.b.b.e;
                                    if (context2 != null) {
                                        objArr[i3] = context2;
                                    } else {
                                        throw new IllegalArgumentException("method request context");
                                    }
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
                                                                } else if (equals) {
                                                                    if (clsArr2 == null) {
                                                                        objArr[i3] = null;
                                                                    } else {
                                                                        objArr[i3] = parseParams("", context, jSONArray, i, clsArr2);
                                                                    }
                                                                } else {
                                                                    throw new IllegalArgumentException("only callSync support Object[]");
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
                int i4 = b.a;
                throw new IllegalArgumentException("" + th.getMessage());
            }
        }
        return (Object[]) invokeCommon.objValue;
    }

    public static void setDid(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65570, null, context, str) == null) {
            String str2 = c.a;
            if (context != null) {
                try {
                    if (r.a(context)) {
                        a a = a.a(context);
                        a.d.putString("s_h_d_id", str);
                        if (Build.VERSION.SDK_INT >= 9) {
                            a.d.apply();
                        } else {
                            a.d.commit();
                        }
                    }
                } catch (Throwable unused) {
                    int i = b.a;
                }
            }
        }
    }

    public static String xgz(Context context, String str) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65572, null, context, str)) == null) {
            String str2 = c.a;
            if (context == null) {
                return "";
            }
            try {
            } catch (Throwable unused) {
                int i2 = b.a;
                i = 501;
            }
            if (!r.a(context)) {
                return "";
            }
            Pair<Integer, Object> b = c.b(1, "xgz", new Class[]{String.class}, str);
            if (((Integer) b.first).intValue() == 0 && !TextUtils.isEmpty((String) b.second)) {
                return (String) b.second;
            }
            if (((Integer) b.first).intValue() == 0) {
                i = 502;
            } else {
                i = ((Integer) b.first).intValue();
            }
            try {
                return new JSONObject().put("rc", i).put("z", c.b(context)).toString();
            } catch (Throwable unused2) {
                int i3 = b.a;
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }
}
