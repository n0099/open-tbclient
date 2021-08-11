package com.baidu.searchbox.aperf.param;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.JsonReader;
import androidx.core.view.InputDeviceCompat;
import c.a.n.c.f;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.aperf.param.util.CpuInfoUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class CommonUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SDK_VERSION = "sdkversion";
    public static String sAppVersion;
    public static String sCPU;
    public static String sMemory;
    public static String sModel;
    public static String sOSVersion;
    public static String sPackageName;
    public static ConcurrentHashMap<String, String> sSDKVersionMap;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-899448266, "Lcom/baidu/searchbox/aperf/param/CommonUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-899448266, "Lcom/baidu/searchbox/aperf/param/CommonUtils;");
                return;
            }
        }
        sSDKVersionMap = new ConcurrentHashMap<>();
    }

    public CommonUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String getAppVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (sAppVersion == null) {
                String appVersion = AperfOverlayRuntime.getAperfOverlayContext().getAppVersion();
                if (!TextUtils.isEmpty(appVersion)) {
                    sAppVersion = appVersion;
                    return appVersion;
                }
                try {
                    Context appContext = AppRuntime.getAppContext();
                    String str = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0).versionName;
                    sAppVersion = str;
                    return str;
                } catch (PackageManager.NameNotFoundException e2) {
                    e2.printStackTrace();
                }
            }
            return sAppVersion;
        }
        return (String) invokeV.objValue;
    }

    public static String getCPUInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (sCPU == null) {
                String str = Build.HARDWARE;
                String num = Integer.toString(CpuInfoUtils.getNumCores());
                String f2 = Float.toString(Math.round(CpuInfoUtils.getAveCpuFrequency() * 10.0f) / 10.0f);
                String arrays = Arrays.toString(Build.VERSION.SDK_INT >= 21 ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI});
                if (!TextUtils.isEmpty(arrays)) {
                    arrays = arrays.replace(PreferencesUtil.LEFT_MOUNT, "").replace(PreferencesUtil.RIGHT_MOUNT, "");
                }
                sCPU = str + ";" + num + ";" + f2 + ";" + arrays;
            }
            return sCPU;
        }
        return (String) invokeV.objValue;
    }

    public static String getLogId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? UUID.randomUUID().toString().replace("-", "") : (String) invokeV.objValue;
    }

    public static String getMemoryInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (sMemory == null) {
                String prop = RomUtils.getProp("dalvik.vm.heapstartsize");
                String prop2 = RomUtils.getProp("dalvik.vm.heapgrowthlimit");
                String prop3 = RomUtils.getProp("dalvik.vm.heapsize");
                ActivityManager activityManager = (ActivityManager) AppRuntime.getAppContext().getSystemService("activity");
                String valueOf = String.valueOf((new ActivityManager.MemoryInfo().totalMem / 1024) / 1024);
                sMemory = (prop + ";" + prop2 + ";" + prop3 + ";" + valueOf).replace("m", "");
            }
            return sMemory;
        }
        return (String) invokeV.objValue;
    }

    public static String getModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            if (sModel == null) {
                sModel = DeviceUtil.BrandInfo.getDeviceModel();
            }
            return sModel;
        }
        return (String) invokeV.objValue;
    }

    public static String getNetwork() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? new f().b() : (String) invokeV.objValue;
    }

    public static String getOSVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (sOSVersion == null) {
                sOSVersion = DeviceUtil.OSInfo.getOsVersion();
            }
            return sOSVersion;
        }
        return (String) invokeV.objValue;
    }

    public static String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (sPackageName == null) {
                sPackageName = AppRuntime.getAppContext().getPackageName();
            }
            return sPackageName;
        }
        return (String) invokeV.objValue;
    }

    public static String getSDKVersion(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (sSDKVersionMap.get(str) == null) {
                try {
                    JsonReader jsonReader = new JsonReader(new InputStreamReader(AppRuntime.getAppContext().getAssets().open(str, 3), "UTF-8"));
                    jsonReader.beginObject();
                    while (true) {
                        if (!jsonReader.hasNext()) {
                            break;
                        } else if ("sdkversion".equals(jsonReader.nextName())) {
                            sSDKVersionMap.put(str, jsonReader.nextString());
                            break;
                        }
                    }
                    jsonReader.endObject();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return sSDKVersionMap.get(str);
        }
        return (String) invokeL.objValue;
    }
}
