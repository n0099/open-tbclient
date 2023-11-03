package com.baidu.adp.lib.util;

import android.annotation.SuppressLint;
import android.app.Application;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.TbadkCore;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.behavior.record.api.IBehaviorApi;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.common.security.CacheDeviceInfo;
import com.baidu.searchbox.common.security.DeviceIdBag;
import com.baidu.searchbox.common.security.DeviceInfoManager;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.tieba.ud;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class DeviceInfoHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT = "";
    public static final String DEFAULT_ANDROID_ID = "000000000000000";
    public static final String DEFAULT_IMEI = "000000000000000";
    public static final String PURPOSE = "定位问题，安全保障，个性化展示";
    public static final String SCENE = "初始化";
    public static ud permissionUtil;
    @NonNull
    public static final Map<String, String> sCache;
    public static final Application sContext;
    public static final DeviceInfoManager sDIM;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1291145066, "Lcom/baidu/adp/lib/util/DeviceInfoHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1291145066, "Lcom/baidu/adp/lib/util/DeviceInfoHelper;");
                return;
            }
        }
        sContext = BdBaseApplication.getInst();
        sDIM = DeviceInfoManager.INSTANCE;
        sCache = new HashMap();
    }

    public DeviceInfoHelper() {
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

    @NonNull
    public static String getAndroidId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return getIdByInfoName(CacheDeviceInfo.JSON_KEY_ANDROID_ID);
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static String getIMEI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return getIdByInfoName("ie");
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static String getIMSI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return getIdByInfoName("isi");
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static String getMacAddress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return getIdByInfoName("ma");
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static String getManufacturer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return getIdByInfoName(CacheDeviceInfo.JSON_KEY_MANUFACTURER);
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static String getModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return getIdByInfoName("md");
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static String getOAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return getIdByInfoName("oi");
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static String getOperator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return getIdByInfoName("ci");
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static String getOsVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return getIdByInfoName("ov");
        }
        return (String) invokeV.objValue;
    }

    @SuppressLint({"HardwareIds"})
    public static String getIdByInfoName(@NonNull String str) {
        InterceptResult invokeL;
        DeviceIdBag androidId;
        TelephonyManager telephonyManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            ud udVar = permissionUtil;
            String str2 = "";
            if (udVar != null && udVar.isBrowseMode()) {
                return "";
            }
            String str3 = sCache.get(str);
            if (str3 != null) {
                return str3;
            }
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 3112) {
                if (hashCode != 3174) {
                    if (hashCode != 3333) {
                        if (hashCode != 3356) {
                            if (hashCode != 3476) {
                                if (hashCode != 3479) {
                                    if (hashCode != 3489) {
                                        if (hashCode != 3546) {
                                            if (hashCode != 3559) {
                                                if (hashCode == 104575 && str.equals("isi")) {
                                                    c = '\t';
                                                }
                                            } else if (str.equals("ov")) {
                                                c = '\b';
                                            }
                                        } else if (str.equals("oi")) {
                                            c = 7;
                                        }
                                    } else if (str.equals(CacheDeviceInfo.JSON_KEY_MANUFACTURER)) {
                                        c = 5;
                                    }
                                } else if (str.equals("md")) {
                                    c = 6;
                                }
                            } else if (str.equals("ma")) {
                                c = 2;
                            }
                        } else if (str.equals("ie")) {
                            c = 1;
                        }
                    } else if (str.equals("hm")) {
                        c = 4;
                    }
                } else if (str.equals("ci")) {
                    c = 3;
                }
            } else if (str.equals(CacheDeviceInfo.JSON_KEY_ANDROID_ID)) {
                c = 0;
            }
            switch (c) {
                case 0:
                    androidId = sDIM.getAndroidId(sContext, SCENE, PURPOSE);
                    str2 = "000000000000000";
                    break;
                case 1:
                    androidId = sDIM.getIMEI(sContext, SCENE, PURPOSE);
                    str2 = "000000000000000";
                    break;
                case 2:
                    androidId = sDIM.getMacAddress(sContext, SCENE, PURPOSE);
                    break;
                case 3:
                    androidId = sDIM.getOperator(sContext, SCENE, PURPOSE);
                    break;
                case 4:
                    androidId = sDIM.getHarmonyVersion(sContext, SCENE, PURPOSE);
                    break;
                case 5:
                    androidId = sDIM.getManufacturer(SCENE, PURPOSE);
                    break;
                case 6:
                    androidId = sDIM.getModel(SCENE, PURPOSE);
                    break;
                case 7:
                    androidId = sDIM.getOAID(SCENE, PURPOSE);
                    break;
                case '\b':
                    androidId = sDIM.getOsVersion(SCENE, PURPOSE);
                    break;
                case '\t':
                    androidId = new DeviceIdBag();
                    try {
                        TbadkCore tbadkCore = (TbadkCore) ServiceManager.getService(TbadkCore.SERVICE_REFERENCE);
                        if (tbadkCore.permissionUtilIsAgreePrivacyPolicy() && tbadkCore.permissionUtilCheckReadPhoneState(sContext) && (telephonyManager = (TelephonyManager) sContext.getSystemService("phone")) != null) {
                            androidId.deviceId = ApiReplaceUtil.getSubscriberId(telephonyManager);
                            ((IBehaviorApi) ServiceManager.getService(IBehaviorApi.SERVICE_REFERENCE)).addBehavior(1, "isi", "tieba", "tieba");
                            break;
                        }
                    } catch (Exception e) {
                        BdLog.e(e);
                        break;
                    }
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + str);
            }
            String nonNullId = getNonNullId(androidId, str2);
            sCache.put(str, nonNullId);
            return nonNullId;
        }
        return (String) invokeL.objValue;
    }

    public static String getNonNullId(@NonNull DeviceIdBag deviceIdBag, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, deviceIdBag, str)) == null) {
            if (!TextUtils.isEmpty(deviceIdBag.deviceId)) {
                return deviceIdBag.deviceId;
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public static String getUA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            DisplayMetrics displayMetrics = BdBaseApplication.getInst().getResources().getDisplayMetrics();
            int i = 0;
            String[] strArr = {String.valueOf(displayMetrics.widthPixels), String.valueOf(displayMetrics.heightPixels), "android", ((TbadkCore) ServiceManager.getService(TbadkCore.SERVICE_REFERENCE)).tbConfigGetVersion(), String.valueOf(displayMetrics.densityDpi)};
            StringBuilder sb = new StringBuilder();
            String str = "";
            while (i < 5) {
                String str2 = strArr[i];
                sb.append(str);
                sb.append(str2);
                i++;
                str = "_";
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static void setPermissionUtil(ud udVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, udVar) == null) {
            permissionUtil = udVar;
        }
    }
}
