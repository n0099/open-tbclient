package com.baidu.searchbox.aperf.param;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.JsonReader;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.e.c.f;
import com.baidu.searchbox.aperf.param.util.CpuInfoUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes19.dex */
public class CommonUtils {
    private static final String SDK_VERSION = "sdkversion";
    public static String sAppVersion;
    public static String sCPU;
    public static String sMemory;
    public static String sModel;
    public static String sOSVersion;
    private static String sPackageName;
    private static ConcurrentHashMap<String, String> sSDKVersionMap = new ConcurrentHashMap<>();

    public static String getOSVersion() {
        if (sOSVersion == null) {
            sOSVersion = DeviceUtil.OSInfo.getOsVersion();
        }
        return sOSVersion;
    }

    public static String getCPUInfo() {
        if (sCPU == null) {
            String str = Build.HARDWARE;
            String num = Integer.toString(CpuInfoUtils.getNumCores());
            String f = Float.toString(Math.round(CpuInfoUtils.getAveCpuFrequency() * 10.0f) / 10.0f);
            String arrays = Arrays.toString(Build.VERSION.SDK_INT >= 21 ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI});
            if (!TextUtils.isEmpty(arrays)) {
                arrays = arrays.replace("[", "").replace("]", "");
            }
            sCPU = str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + num + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + f + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + arrays;
        }
        return sCPU;
    }

    public static String getMemoryInfo() {
        if (sMemory == null) {
            String prop = RomUtils.getProp("dalvik.vm.heapstartsize");
            String prop2 = RomUtils.getProp("dalvik.vm.heapgrowthlimit");
            String prop3 = RomUtils.getProp("dalvik.vm.heapsize");
            ActivityManager activityManager = (ActivityManager) AppRuntime.getAppContext().getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
            String valueOf = String.valueOf((new ActivityManager.MemoryInfo().totalMem / 1024) / 1024);
            StringBuilder sb = new StringBuilder();
            sb.append(prop).append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR).append(prop2).append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR).append(prop3).append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR).append(valueOf);
            sMemory = sb.toString().replace("m", "");
        }
        return sMemory;
    }

    public static String getAppVersion() {
        if (sAppVersion == null) {
            String appVersion = AperfOverlayRuntime.getAperfOverlayContext().getAppVersion();
            if (!TextUtils.isEmpty(appVersion)) {
                sAppVersion = appVersion;
                return sAppVersion;
            }
            try {
                Context appContext = AppRuntime.getAppContext();
                sAppVersion = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0).versionName;
                return sAppVersion;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        return sAppVersion;
    }

    public static String getSDKVersion(String str) {
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sSDKVersionMap.get(str);
    }

    public static String getModel() {
        if (sModel == null) {
            sModel = DeviceUtil.BrandInfo.getDeviceModel();
        }
        return sModel;
    }

    public static String getNetwork() {
        return new f().getCurrentNetTypeId();
    }

    public static String getPackageName() {
        if (sPackageName == null) {
            sPackageName = AppRuntime.getAppContext().getPackageName();
        }
        return sPackageName;
    }

    public static String getLogId() {
        return UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
    }
}
