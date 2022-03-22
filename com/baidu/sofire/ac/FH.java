package com.baidu.sofire.ac;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.SurfaceHolder;
import android.view.TextureView;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.ForHostApp;
import com.baidu.sofire.core.MethodImpl;
import com.baidu.sofire.core.PluginloaderHub;
import com.baidu.sofire.facesrc.FaceLivenessProcessManager;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.sofire.utility.LocalConstant;
import com.baidu.sofire.utility.PrivacyPolicyUtil;
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
            MethodImpl.bc(context, z);
        }
    }

    public static boolean call(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i, str)) == null) ? call(i, str, null) : invokeIL.booleanValue;
    }

    public static Pair<Integer, Object> callSync(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65542, null, i, str)) == null) ? callSync(i, str, null, new Object[0]) : (Pair) invokeIL.objValue;
    }

    public static void cancelFaceProcess() {
        FaceLivenessProcessManager peekInstance;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, null) == null) || (peekInstance = FaceLivenessProcessManager.peekInstance()) == null) {
            return;
        }
        peekInstance.cancelCurrentFaceLivenessProcess();
    }

    public static String gd(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) ? "" : (String) invokeL.objValue;
    }

    public static Pair<Integer, String> gel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? MethodImpl.gel() : (Pair) invokeV.objValue;
    }

    public static Object getPInfo(int i, int i2) {
        InterceptResult invokeII;
        PluginloaderHub peekInstance;
        List<ApkInfo> allLoadedPlugins;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65547, null, i, i2)) == null) {
            try {
                if (ForHostApp.hostContext != null && PrivacyPolicyUtil.check(ForHostApp.hostContext) && i2 == 1 && i > 0 && (peekInstance = PluginloaderHub.peekInstance()) != null && (allLoadedPlugins = peekInstance.getAllLoadedPlugins()) != null && allLoadedPlugins.size() > 0) {
                    for (ApkInfo apkInfo : allLoadedPlugins) {
                        if (apkInfo.key == i) {
                            return apkInfo.versionName == null ? "" : apkInfo.versionName;
                        }
                    }
                }
                return "";
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return "";
            }
        }
        return invokeII.objValue;
    }

    public static String getVersion(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) ? LocalConstant.V : (String) invokeL.objValue;
    }

    public static IVideoRecordProcess getVideoRecordProcess(Activity activity, SurfaceHolder surfaceHolder, RecordCallback recordCallback, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65549, null, activity, surfaceHolder, recordCallback, i)) == null) {
            FaceLivenessProcessManager faceLivenessProcessManager = FaceLivenessProcessManager.getInstance(activity.getApplicationContext());
            if (faceLivenessProcessManager != null) {
                return faceLivenessProcessManager.getVideoRecordProcess(activity, surfaceHolder, recordCallback, i);
            }
            return null;
        }
        return (IVideoRecordProcess) invokeLLLI.objValue;
    }

    public static IVideoRecordProcess getVideoRecordTextureProcess(Activity activity, TextureView textureView, RecordCallback recordCallback, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65550, null, activity, textureView, recordCallback, i)) == null) {
            FaceLivenessProcessManager faceLivenessProcessManager = FaceLivenessProcessManager.getInstance(activity.getApplicationContext());
            if (faceLivenessProcessManager != null) {
                return faceLivenessProcessManager.getVideoRecordTextureProcess(activity, textureView, recordCallback, i);
            }
            return null;
        }
        return (IVideoRecordProcess) invokeLLLI.objValue;
    }

    public static String gt(Context context, String str, String str2, int i, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{context, str, str2, Integer.valueOf(i), str3})) == null) ? MethodImpl.gt(context, str, str2, i, str3) : (String) invokeCommon.objValue;
    }

    public static String gz(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) ? MethodImpl.gz(context) : (String) invokeL.objValue;
    }

    public static String gzfi(Context context, String str, int i, String str2) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65554, null, context, str, i, str2)) == null) ? MethodImpl.gzfi(context, str, i, str2) : (String) invokeLLIL.objValue;
    }

    public static void init(Context context, String str, String str2, int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65556, null, context, str, str2, iArr) == null) {
            MethodImpl.initDelay(context, 0, str, str2, iArr);
        }
    }

    public static void initDelay(Context context, int i, String str, String str2, int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{context, Integer.valueOf(i), str, str2, iArr}) == null) {
            MethodImpl.initDelay(context, i, str, str2, iArr);
        }
    }

    public static Pair<Integer, String> invokeMethod(Context context, String str) {
        InterceptResult invokeLL;
        Method[] methods;
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, context, str)) == null) {
            try {
                if (context == null) {
                    return new Pair<>(-1, "");
                }
                if (!PrivacyPolicyUtil.check(context)) {
                    return new Pair<>(12, "");
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString("f");
                    if (!TextUtils.isEmpty(optString) && !"init".equals(optString) && !"initDelay".equals(optString) && !NotificationCompat.CATEGORY_CALL.equals(optString)) {
                        JSONArray optJSONArray = jSONObject.optJSONArray("p");
                        if ("callSync".equals(optString)) {
                            if (ForHostApp.hostContext == null && context != null) {
                                ForHostApp.hostContext = context.getApplicationContext();
                            }
                            if (optJSONArray != null && optJSONArray.length() == 2) {
                                method = FH.class.getMethod("callSync", Integer.TYPE, String.class);
                            } else if (optJSONArray == null || optJSONArray.length() >= 2) {
                                method = FH.class.getMethod("callSync", Integer.TYPE, String.class, Class[].class, Object[].class);
                            } else {
                                return new Pair<>(-6, "");
                            }
                        } else if ("gzfi".equals(optString)) {
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
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                    return new Pair<>(-2, "");
                }
            } catch (IllegalArgumentException e2) {
                CommonMethods.handleNuLException(e2);
                return new Pair<>(-6, "");
            } catch (Throwable th2) {
                CommonMethods.handleNuLException(th2);
                return new Pair<>(-1, "");
            }
        }
        return (Pair) invokeLL.objValue;
    }

    public static boolean isInitSuc(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65560, null, i)) == null) {
            Context context = ForHostApp.hostContext;
            if (context == null || !PrivacyPolicyUtil.check(context)) {
                return false;
            }
            return CommonMethods.isInitSuc(i);
        }
        return invokeI.booleanValue;
    }

    public static boolean parseBoolean(String str) throws IllegalArgumentException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, str)) == null) {
            if ("T".equals(str)) {
                return true;
            }
            if ("F".equals(str)) {
                return false;
            }
            throw new IllegalArgumentException("parse boolean fail:" + str);
        }
        return invokeL.booleanValue;
    }

    public static byte parseByte(String str) throws IllegalArgumentException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, str)) == null) {
            try {
                int intValue = Integer.valueOf(str).intValue();
                if (intValue > 127 || intValue < -128) {
                    throw new IllegalArgumentException("parse byte fail");
                }
                return (byte) intValue;
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                throw new IllegalArgumentException("parse byte fail:" + str);
            }
        }
        return invokeL.byteValue;
    }

    public static char parseChar(String str) throws IllegalArgumentException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, str)) == null) {
            try {
                if (str.length() == 1) {
                    return str.charAt(0);
                }
                throw new IllegalArgumentException("parse char fail");
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                throw new IllegalArgumentException("parse char fail:" + str);
            }
        }
        return invokeL.charValue;
    }

    public static Class[] parseClassArray(String str) throws IllegalArgumentException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, str)) == null) {
            try {
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
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                throw new IllegalArgumentException("parse classArray fail:" + str);
            }
        }
        return (Class[]) invokeL.objValue;
    }

    public static double parseDouble(String str) throws IllegalArgumentException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, str)) == null) {
            try {
                return Double.valueOf(str).doubleValue();
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                throw new IllegalArgumentException("parse double fail:" + str);
            }
        }
        return invokeL.doubleValue;
    }

    public static float parseFloat(String str) throws IllegalArgumentException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, str)) == null) {
            try {
                return Float.valueOf(str).floatValue();
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                throw new IllegalArgumentException("parse float fail:" + str);
            }
        }
        return invokeL.floatValue;
    }

    public static int parseInt(String str) throws IllegalArgumentException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, str)) == null) {
            try {
                return Integer.valueOf(str).intValue();
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                throw new IllegalArgumentException("parse int fail:" + str);
            }
        }
        return invokeL.intValue;
    }

    public static long parseLong(String str) throws IllegalArgumentException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, str)) == null) {
            try {
                return Long.valueOf(str).longValue();
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                throw new IllegalArgumentException("parse long fail:" + str);
            }
        }
        return invokeL.longValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object[] parseParams(String str, Context context, JSONArray jSONArray, int i, Class[] clsArr) throws IllegalArgumentException {
        int i2;
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65569, null, new Object[]{str, context, jSONArray, Integer.valueOf(i), clsArr})) == null) {
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
                                } else if (ForHostApp.hostContext != null) {
                                    objArr[i3] = ForHostApp.hostContext;
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
                CommonMethods.handleNuLException(th);
                throw new IllegalArgumentException(th.getMessage());
            }
        }
        return (Object[]) invokeCommon.objValue;
    }

    public static short parseShort(String str) throws IllegalArgumentException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, str)) == null) {
            try {
                return Short.valueOf(str).shortValue();
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                throw new IllegalArgumentException("parse short fail:" + str);
            }
        }
        return invokeL.shortValue;
    }

    public static void setAgreePolicy(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65571, null, context, z) == null) {
            MethodImpl.setAgreePolicy(context, z);
        }
    }

    public static void setDid(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65572, null, context, str) == null) {
            MethodImpl.setDid(context, str);
        }
    }

    public static void setFaceLicenseId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65573, null, str) == null) {
            FaceLivenessProcessManager.setLicenseId(str);
        }
    }

    public static void setSoundEnable(boolean z) {
        FaceLivenessProcessManager peekInstance;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65574, null, z) == null) || (peekInstance = FaceLivenessProcessManager.peekInstance()) == null) {
            return;
        }
        peekInstance.setSoundEnable(z);
    }

    public static boolean startFaceSurfaceLiveness(Activity activity, SurfaceHolder surfaceHolder, FaceProcessCallback faceProcessCallback, int i, IFaceProcessInfo iFaceProcessInfo, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65575, null, new Object[]{activity, surfaceHolder, faceProcessCallback, Integer.valueOf(i), iFaceProcessInfo, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) ? FaceLivenessProcessManager.getInstance(activity.getApplicationContext()).startFaceSurfaceLiveness(activity, surfaceHolder, faceProcessCallback, i, iFaceProcessInfo, z, i2) : invokeCommon.booleanValue;
    }

    public static boolean startFaceTextureLiveness(Activity activity, TextureView textureView, FaceProcessCallback faceProcessCallback, int i, IFaceProcessInfo iFaceProcessInfo, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65576, null, new Object[]{activity, textureView, faceProcessCallback, Integer.valueOf(i), iFaceProcessInfo, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) ? FaceLivenessProcessManager.getInstance(activity.getApplicationContext()).startFaceTextureLiveness(activity, textureView, faceProcessCallback, i, iFaceProcessInfo, true, z, i2) : invokeCommon.booleanValue;
    }

    public static void tryLoadModule(Context context, BDModuleLoadCallback bDModuleLoadCallback, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65577, null, context, bDModuleLoadCallback, i) == null) {
            MethodImpl.addModuleCallback(context, i, bDModuleLoadCallback, true);
        }
    }

    public static String xgz(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65578, null, context, str)) == null) ? MethodImpl.xgz(context, str) : (String) invokeLL.objValue;
    }

    public static boolean call(int i, String str, Callback callback) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(65539, null, i, str, callback)) == null) ? call(i, str, callback, null, new Object[0]) : invokeILL.booleanValue;
    }

    public static Pair<Integer, Object> callSync(int i, String str, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Integer.valueOf(i), str, clsArr, objArr})) == null) ? MethodImpl.callSync(i, str, clsArr, objArr) : (Pair) invokeCommon.objValue;
    }

    public static String gzfi(Context context, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65553, null, context, str, i)) == null) ? MethodImpl.gzfi(context, str, i, null) : (String) invokeLLI.objValue;
    }

    public static void init(Context context, String str, String str2, BDModuleLoadCallback bDModuleLoadCallback, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65555, null, new Object[]{context, str, str2, bDModuleLoadCallback, Integer.valueOf(i)}) == null) {
            MethodImpl.initDelay(context, 0, str, str2, bDModuleLoadCallback, i);
        }
    }

    public static void initDelay(Context context, int i, String str, String str2, BDModuleLoadCallback bDModuleLoadCallback, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65557, null, new Object[]{context, Integer.valueOf(i), str, str2, bDModuleLoadCallback, Integer.valueOf(i2)}) == null) {
            MethodImpl.initDelay(context, i, str, str2, bDModuleLoadCallback, i2);
        }
    }

    public static boolean call(int i, String str, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Integer.valueOf(i), str, clsArr, objArr})) == null) ? call(i, str, null, clsArr, objArr) : invokeCommon.booleanValue;
    }

    public static boolean call(int i, String str, Callback callback, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i), str, callback, clsArr, objArr})) == null) ? MethodImpl.call(i, str, callback, clsArr, objArr) : invokeCommon.booleanValue;
    }
}
