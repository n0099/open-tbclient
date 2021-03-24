package com.baidu.searchbox.logsystem.util;

import android.os.Build;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class Common {
    public static AppExtraCall sAppExtraCall;
    public static volatile Device sCommonDevice;
    public static volatile Version sCommonVersion;

    /* loaded from: classes3.dex */
    public interface AppExtraCall {
        JSONObject getAppExtraInfo();
    }

    /* loaded from: classes3.dex */
    public static class Device {
        @NonNull
        public String mCPU = "";
        @NonNull
        public String mModel = "";
        @NonNull
        public String mOSVersion = "";
        @NonNull
        public String mMemory = "";
    }

    /* loaded from: classes3.dex */
    public static class Version {
        public static final String SDK_VERSION = "sdkversion";
        @NonNull
        public String mSDKVersion = "";
        @NonNull
        public String mAppVersion = "";
    }

    public static String getAppExtra() {
        JSONObject appExtraInfo;
        AppExtraCall appExtraCall = sAppExtraCall;
        if (appExtraCall == null || (appExtraInfo = appExtraCall.getAppExtraInfo()) == null) {
            return null;
        }
        return appExtraInfo.toString();
    }

    public static Device getDeviceInfo() {
        if (sCommonDevice == null) {
            Device device = new Device();
            String str = Build.HARDWARE;
            String num = Integer.toString(CpuInfoUtils.getNumCores());
            String f2 = Float.toString(Math.round(CpuInfoUtils.getAveCpuFrequency() * 10.0f) / 10.0f);
            String arrays = Arrays.toString(Build.VERSION.SDK_INT >= 21 ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI});
            if (!TextUtils.isEmpty(arrays)) {
                arrays = arrays.replace("[", "").replace("]", "");
            }
            device.mCPU = str + ";" + num + ";" + f2 + ";" + arrays;
            String prop = RomUtils.getProp("dalvik.vm.heapstartsize");
            String prop2 = RomUtils.getProp("dalvik.vm.heapgrowthlimit");
            String prop3 = RomUtils.getProp("dalvik.vm.heapsize");
            device.mMemory = (prop + ";" + prop2 + ";" + prop3).replace("m", "");
            device.mModel = DeviceUtil.BrandInfo.getDeviceModel();
            device.mOSVersion = DeviceUtil.OSInfo.getOsVersion();
            if (sCommonDevice == null) {
                sCommonDevice = device;
            }
            if (LLog.sDebug) {
                Log.e("prop", "cpu:" + sCommonDevice.mCPU + ", Model:" + sCommonDevice.mModel + ", OSVersion:" + sCommonDevice.mOSVersion + ", memory:" + sCommonDevice.mMemory);
            }
        }
        return sCommonDevice;
    }

    public static Version getVersionInfo() {
        JsonReader jsonReader;
        IOException e2;
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

    public static void setAppExtraCall(AppExtraCall appExtraCall) {
        sAppExtraCall = appExtraCall;
    }
}
