package com.baidu.ar.bean;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.ar.ARType;
import com.baidu.ar.constants.ARConfigKey;
import com.baidu.ar.h.l;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ARConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AR_SDK_SALT_FIGURE = "777078ec21930de508131ba36035de6b";
    public static final int LAUNCH_AR_TAB = 2;
    public static final int LAUNCH_AR_TAB_CASE = 3;
    public static final int LAUNCH_MODE_H5 = 1;
    public static final int LAUNCH_MODE_TAKE_PICTURE = 0;
    public static int TYPE_VPS = 11;
    public static String mARExtraInfo = "";
    public static String mARId = null;
    public static int mARInitialType = -1;
    public static String mARKey = null;
    public static int mARLaunchMode = 0;
    public static String mARPath = null;
    public static int mARType = -1;
    public static String mArFrom = null;
    public static String mArValue = null;
    public static boolean mIsNeedLastPreview = false;
    public static String sCUID = "";
    public static String sFeaPointsDir;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1986932857, "Lcom/baidu/ar/bean/ARConfig;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1986932857, "Lcom/baidu/ar/bean/ARConfig;");
        }
    }

    public ARConfig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String getARExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? mARExtraInfo : (String) invokeV.objValue;
    }

    public static String getARId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? mARId : (String) invokeV.objValue;
    }

    public static int getARInitialType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? mARInitialType : invokeV.intValue;
    }

    public static String getARKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? mARKey : (String) invokeV.objValue;
    }

    public static int getARLaunchMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? mARLaunchMode : invokeV.intValue;
    }

    public static String getARPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? mARPath : (String) invokeV.objValue;
    }

    public static int getARType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? mARType : invokeV.intValue;
    }

    public static String getArFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? mArFrom : (String) invokeV.objValue;
    }

    public static String getArValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? mArValue : (String) invokeV.objValue;
    }

    public static String getCUID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? sCUID : (String) invokeV.objValue;
    }

    public static Object[] getSignatureAndTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? getSignatureAndTime(DuMixARConfig.getAipAppId(), DuMixARConfig.getAPIKey()) : (Object[]) invokeV.objValue;
    }

    public static Object[] getSignatureAndTime(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, str, str2)) == null) {
            Object[] objArr = new Object[2];
            long currentTimeMillis = System.currentTimeMillis();
            if (isOpen(str)) {
                objArr[0] = l.aU(str + AR_SDK_SALT_FIGURE + currentTimeMillis);
            } else {
                objArr[0] = l.aU(str + str2 + AR_SDK_SALT_FIGURE + currentTimeMillis);
            }
            objArr[1] = Long.valueOf(currentTimeMillis);
            return objArr;
        }
        return (Object[]) invokeLL.objValue;
    }

    public static void initARConfig(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                mArValue = str;
                setARKey(jSONObject.has("ar_key") ? jSONObject.getString("ar_key") : jSONObject.has(ARConfigKey.OLD_AR_KEY) ? jSONObject.getString(ARConfigKey.OLD_AR_KEY) : null);
                setARPath(jSONObject.has(ARConfigKey.AR_PATH) ? jSONObject.getString(ARConfigKey.AR_PATH) : null);
                String string = jSONObject.has("ar_type") ? jSONObject.getString("ar_type") : jSONObject.has(ARConfigKey.OLD_AR_TYPE) ? jSONObject.getString(ARConfigKey.OLD_AR_TYPE) : null;
                if (TextUtils.isEmpty(string)) {
                    setARType(ARType.TRACK_2D.getTypeValue());
                } else {
                    setARType(Integer.parseInt(string));
                    setARInitialType(Integer.parseInt(string));
                }
                String string2 = jSONObject.has(ARConfigKey.AR_LAUNCH_MODE) ? jSONObject.getString(ARConfigKey.AR_LAUNCH_MODE) : null;
                if (TextUtils.isEmpty(string2)) {
                    setARLaunchMode(0);
                } else {
                    setARLaunchMode(Integer.parseInt(string2));
                }
                String string3 = jSONObject.has(ARConfigKey.AR_ID) ? jSONObject.getString(ARConfigKey.AR_ID) : null;
                setARId(string3);
                if (TextUtils.isEmpty(getARKey()) && string3 != null) {
                    try {
                        setARKey(new JSONObject(string3).optString("content_id"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (jSONObject.has(ARConfigKey.AR_FROM)) {
                    setArFrom(jSONObject.getString(ARConfigKey.AR_FROM));
                }
                if (jSONObject.has(ARConfigKey.AR_NEED_LAST_PREVIEW)) {
                    setIsNeedLastPreview(jSONObject.getBoolean(ARConfigKey.AR_NEED_LAST_PREVIEW));
                }
                if (jSONObject.has(ARConfigKey.EXTRA_INFO)) {
                    setARExtraInfo(jSONObject.getString(ARConfigKey.EXTRA_INFO));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean isBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? "2".equals(DuMixARConfig.getAipAppId()) && !"com.baidu.ar.boxdemo".equals(DuMixARConfig.getPackageName()) : invokeV.booleanValue;
    }

    public static boolean isNeedLastPreview() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? mIsNeedLastPreview : invokeV.booleanValue;
    }

    public static boolean isOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? isOpen(DuMixARConfig.getAipAppId()) : invokeV.booleanValue;
    }

    public static boolean isOpen(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                return Long.parseLong(str) > 10000;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static void setARExtraInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, str) == null) {
            mARExtraInfo = str;
        }
    }

    public static void setARId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, str) == null) {
            mARId = str;
        }
    }

    public static void setARInitialType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65557, null, i) == null) {
            mARInitialType = i;
        }
    }

    public static void setARKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, str) == null) {
            mARKey = str;
        }
    }

    public static void setARLaunchMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65559, null, i) == null) {
            mARLaunchMode = i;
        }
    }

    public static void setARPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, str) == null) {
            mARPath = str;
        }
    }

    public static void setARType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65561, null, i) == null) {
            mARType = i;
        }
    }

    public static void setArFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, null, str) == null) {
            mArFrom = str;
        }
    }

    public static void setCUID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, null, str) == null) {
            sCUID = str;
        }
    }

    public static void setIsNeedLastPreview(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65564, null, z) == null) {
            mIsNeedLastPreview = z;
        }
    }
}
