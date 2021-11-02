package com.baidu.searchbox.logsystem.util;

import android.os.Build;
import android.text.TextUtils;
import android.util.JsonReader;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.android.util.io.Closeables;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class Common {
    public static /* synthetic */ Interceptable $ic;
    public static AppExtraCall sAppExtraCall;
    public static volatile Device sCommonDevice;
    public static volatile Version sCommonVersion;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface AppExtraCall {
        JSONObject getAppExtraInfo();
    }

    /* loaded from: classes7.dex */
    public static class Device {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public String mCPU;
        @NonNull
        public String mMemory;
        @NonNull
        public String mModel;
        @NonNull
        public String mOSVersion;

        public Device() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mCPU = "";
            this.mModel = "";
            this.mOSVersion = "";
            this.mMemory = "";
        }
    }

    /* loaded from: classes7.dex */
    public static class Version {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String SDK_VERSION = "sdkversion";
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public String mAppVersion;
        @NonNull
        public String mSDKVersion;

        public Version() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mSDKVersion = "";
            this.mAppVersion = "";
        }
    }

    public Common() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String getAppExtra() {
        InterceptResult invokeV;
        JSONObject appExtraInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            AppExtraCall appExtraCall = sAppExtraCall;
            if (appExtraCall == null || (appExtraInfo = appExtraCall.getAppExtraInfo()) == null) {
                return null;
            }
            return appExtraInfo.toString();
        }
        return (String) invokeV.objValue;
    }

    public static Device getDeviceInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (sCommonDevice == null) {
                Device device = new Device();
                String str = Build.HARDWARE;
                String num = Integer.toString(CpuInfoUtils.getNumCores());
                String f2 = Float.toString(Math.round(CpuInfoUtils.getAveCpuFrequency() * 10.0f) / 10.0f);
                String arrays = Arrays.toString(Build.VERSION.SDK_INT >= 21 ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI});
                if (!TextUtils.isEmpty(arrays)) {
                    arrays = arrays.replace(PreferencesUtil.LEFT_MOUNT, "").replace(PreferencesUtil.RIGHT_MOUNT, "");
                }
                device.mCPU = str + ";" + num + ";" + f2 + ";" + arrays;
                device.mMemory = (RomUtils.getProp("dalvik.vm.heapstartsize") + ";" + RomUtils.getProp("dalvik.vm.heapgrowthlimit") + ";" + RomUtils.getProp("dalvik.vm.heapsize")).replace("m", "");
                device.mModel = DeviceUtil.BrandInfo.getDeviceModel();
                device.mOSVersion = DeviceUtil.OSInfo.getOsVersion();
                if (sCommonDevice == null) {
                    sCommonDevice = device;
                }
                if (LLog.sDebug) {
                    String str2 = "cpu:" + sCommonDevice.mCPU + ", Model:" + sCommonDevice.mModel + ", OSVersion:" + sCommonDevice.mOSVersion + ", memory:" + sCommonDevice.mMemory;
                }
            }
            return sCommonDevice;
        }
        return (Device) invokeV.objValue;
    }

    public static Version getVersionInfo() {
        InterceptResult invokeV;
        JsonReader jsonReader;
        IOException e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (sCommonVersion == null) {
                Version version = new Version();
                try {
                    jsonReader = new JsonReader(new InputStreamReader(AppRuntime.getAppContext().getAssets().open("loki_config", 3), "UTF-8"));
                } catch (IOException e3) {
                    jsonReader = null;
                    e2 = e3;
                }
                try {
                    jsonReader.beginObject();
                    while (true) {
                        if (!jsonReader.hasNext()) {
                            break;
                        } else if ("sdkversion".equals(jsonReader.nextName())) {
                            version.mSDKVersion = jsonReader.nextString();
                            break;
                        }
                    }
                    jsonReader.endObject();
                } catch (IOException e4) {
                    e2 = e4;
                    e2.printStackTrace();
                    Closeables.closeSafely(jsonReader);
                    version.mAppVersion = Utility.getAppVersion(AppRuntime.getAppContext());
                    sCommonVersion = version;
                    return sCommonVersion;
                }
                version.mAppVersion = Utility.getAppVersion(AppRuntime.getAppContext());
                sCommonVersion = version;
            }
            return sCommonVersion;
        }
        return (Version) invokeV.objValue;
    }

    public static void setAppExtraCall(AppExtraCall appExtraCall) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, appExtraCall) == null) {
            sAppExtraCall = appExtraCall;
        }
    }
}
