package com.baidu.searchbox.aperf.param;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import android.util.JsonReader;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.android.util.devices.StorageUtils;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.aperf.param.util.CpuInfoUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.iw;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class CommonUtils {
    public static final String FALSE = "0";
    public static final String INVALID = "-1";
    public static final int MAGIC_INTEGER_1024 = 1024;
    public static final int MAGIC_INTEGER_2 = 2;
    public static final String SDK_VERSION = "sdkversion";
    public static final String TRUE = "1";
    public static final String UNKNOWN = "-1";
    public static final ConcurrentHashMap<String, String> sSDKVersionMap = new ConcurrentHashMap<>();
    public static final HashSet<String> mVSSKey = new HashSet<String>() { // from class: com.baidu.searchbox.aperf.param.CommonUtils.1
        {
            add("VmPeak");
            add("VmSize");
            add(VSSConstants.VMHWM);
            add(VSSConstants.VMRSS);
        }
    };
    public static String sOSVersion = null;
    public static String sMemory = null;
    public static String sCPU = null;
    public static String sModel = null;
    public static String sAppVersion = null;
    public static String sRooted = null;
    public static String sProcessBit = null;
    public static String sEmulator = null;
    public static String sROM = null;
    public static String sPackageName = null;

    /* loaded from: classes3.dex */
    public static final class VSSConstants {
        public static final String VMHWM = "VmHWM";
        public static final String VMPEAK = "VmPeak";
        public static final String VMRSS = "VmRSS";
        public static final String VMSIZE = "VmSize";
    }

    public static String getEmulator() {
        if (sEmulator == null) {
            if (mayEmulatorFromBuild()) {
                sEmulator = "1";
            } else {
                sEmulator = "-1";
            }
        }
        return sEmulator;
    }

    public static String getLogId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String getModel() {
        if (sModel == null) {
            String deviceModel = DeviceUtil.BrandInfo.getDeviceModel();
            sModel = deviceModel;
            if (deviceModel == null) {
                sModel = "";
            }
        }
        return sModel;
    }

    public static String getNetwork() {
        return new iw().a();
    }

    public static String getOSVersion() {
        if (sOSVersion == null) {
            sOSVersion = DeviceUtil.OSInfo.getOsVersion();
        }
        return sOSVersion;
    }

    public static String getPSS() {
        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        long j = memoryInfo.dalvikPss;
        StringBuilder sb = new StringBuilder();
        sb.append(memoryInfo.nativePss);
        sb.append(ParamableElem.DIVIDE_PARAM);
        sb.append(j);
        return sb.toString();
    }

    public static String getPackageName() {
        if (sPackageName == null) {
            String packageName = AppRuntime.getAppContext().getPackageName();
            sPackageName = packageName;
            if (packageName == null) {
                sPackageName = "";
            }
        }
        return sPackageName;
    }

    public static String getProcessBit() {
        String str;
        if (sProcessBit == null) {
            if (is64Bit()) {
                str = "1";
            } else {
                str = "0";
            }
            sProcessBit = str;
        }
        return sProcessBit;
    }

    public static String getROM() {
        if (sROM == null) {
            sROM = RomUtils.getName() + ParamableElem.DIVIDE_PARAM + RomUtils.getVersion();
        }
        return sROM;
    }

    public static String getRootedInfo() {
        if (sRooted == null) {
            String prop = RomUtils.getProp("ro.secure");
            boolean z = true;
            if (prop != null && "0".equals(prop)) {
                z = false;
            }
            String str = "1";
            if (!z) {
                sRooted = "1";
            } else {
                if (!isSUExist()) {
                    str = "-1";
                }
                sRooted = str;
            }
        }
        return sRooted;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0018: ARITH  (r0v4 long A[REMOVE]) = (wrap: long : 0x0014: IGET  (r0v3 long A[REMOVE]) = (r1v1 android.app.ActivityManager$MemoryInfo) android.app.ActivityManager.MemoryInfo.availMem long) / (1024 long))] */
    public static String getSysMem() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) AppRuntime.getAppContext().getSystemService("activity")).getMemoryInfo(memoryInfo);
        StringBuilder sb = new StringBuilder();
        sb.append(memoryInfo.availMem / 1024);
        return sb.toString();
    }

    public static boolean is64Bit() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            return Process.is64Bit();
        }
        if (i < 21) {
            return false;
        }
        String[] strArr = Build.SUPPORTED_64_BIT_ABIS;
        if (strArr.length <= 0) {
            return false;
        }
        return Build.CPU_ABI.equals(strArr[0]);
    }

    public static boolean isLowMemory() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) AppRuntime.getAppContext().getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.lowMemory;
    }

    public static boolean isSUExist() {
        String[] strArr = {"/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su"};
        for (int i = 0; i < 8; i++) {
            if (new File(strArr[i]).exists()) {
                return true;
            }
        }
        return false;
    }

    public static String getAppVersion() {
        if (sAppVersion == null) {
            String appVersion = AperfOverlayRuntime.getAperfOverlayContext().getAppVersion();
            if (!TextUtils.isEmpty(appVersion)) {
                sAppVersion = appVersion;
                return appVersion;
            }
            try {
                Context appContext = AppRuntime.getAppContext();
                sAppVersion = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            if (sAppVersion == null) {
                sAppVersion = "";
            }
        }
        return sAppVersion;
    }

    public static String getCPUInfo() {
        if (sCPU == null) {
            String str = Build.HARDWARE;
            String num = Integer.toString(CpuInfoUtils.getNumCores());
            String f = Float.toString(Math.round(CpuInfoUtils.getMaxCpuFrequency() * 10.0f) / 10.0f);
            String arrays = Arrays.toString(DeviceUtils.CPUInfo.getSupportedABIs());
            if (!TextUtils.isEmpty(arrays)) {
                arrays = arrays.replace(PreferencesUtil.LEFT_MOUNT, "").replace(PreferencesUtil.RIGHT_MOUNT, "");
            }
            sCPU = str + ParamableElem.DIVIDE_PARAM + num + ParamableElem.DIVIDE_PARAM + f + ParamableElem.DIVIDE_PARAM + arrays;
        }
        return sCPU;
    }

    public static String getExStorage() {
        Long l;
        long availableExternalMemorySize = StorageUtils.getAvailableExternalMemorySize();
        long totalExternalMemorySize = StorageUtils.getTotalExternalMemorySize();
        if (availableExternalMemorySize > 0) {
            availableExternalMemorySize = Math.round(((float) availableExternalMemorySize) / 1024.0f);
        }
        if (totalExternalMemorySize > 0) {
            totalExternalMemorySize = Math.round(((float) totalExternalMemorySize) / 1024.0f);
        }
        StringBuilder sb = new StringBuilder();
        Object obj = "-1";
        if (availableExternalMemorySize < 0) {
            l = "-1";
        } else {
            l = Long.valueOf(availableExternalMemorySize);
        }
        sb.append(l);
        sb.append(ParamableElem.DIVIDE_PARAM);
        if (totalExternalMemorySize >= 0) {
            obj = Long.valueOf(totalExternalMemorySize);
        }
        sb.append(obj);
        return sb.toString();
    }

    public static String getHeapInfo() {
        long j = Runtime.getRuntime().totalMemory() / 1024;
        long freeMemory = j - (Runtime.getRuntime().freeMemory() / 1024);
        return (Debug.getNativeHeapAllocatedSize() / 1024) + ParamableElem.DIVIDE_PARAM + freeMemory + ParamableElem.DIVIDE_PARAM + (Debug.getNativeHeapSize() / 1024) + ParamableElem.DIVIDE_PARAM + j + ParamableElem.DIVIDE_PARAM + (Runtime.getRuntime().maxMemory() / 1024);
    }

    public static String getInStorage() {
        Long l;
        long availableInternalMemorySize = StorageUtils.getAvailableInternalMemorySize();
        long totalInternalMemorySize = StorageUtils.getTotalInternalMemorySize();
        if (availableInternalMemorySize > 0) {
            availableInternalMemorySize = Math.round(((float) availableInternalMemorySize) / 1024.0f);
        }
        if (totalInternalMemorySize > 0) {
            totalInternalMemorySize = Math.round(((float) totalInternalMemorySize) / 1024.0f);
        }
        StringBuilder sb = new StringBuilder();
        Object obj = "-1";
        if (availableInternalMemorySize < 0) {
            l = "-1";
        } else {
            l = Long.valueOf(availableInternalMemorySize);
        }
        sb.append(l);
        sb.append(ParamableElem.DIVIDE_PARAM);
        if (totalInternalMemorySize >= 0) {
            obj = Long.valueOf(totalInternalMemorySize);
        }
        sb.append(obj);
        return sb.toString();
    }

    public static String getMemoryInfo() {
        Object obj;
        if (sMemory == null) {
            String prop = RomUtils.getProp("dalvik.vm.heapstartsize");
            String prop2 = RomUtils.getProp("dalvik.vm.heapgrowthlimit");
            String prop3 = RomUtils.getProp("dalvik.vm.heapsize");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) AppRuntime.getAppContext().getSystemService("activity")).getMemoryInfo(memoryInfo);
            long j = memoryInfo.totalMem;
            if (j > 0) {
                j = (j / 1024) / 1024;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(prop);
            sb.append(ParamableElem.DIVIDE_PARAM);
            sb.append(prop2);
            sb.append(ParamableElem.DIVIDE_PARAM);
            sb.append(prop3);
            sb.append(ParamableElem.DIVIDE_PARAM);
            if (j >= 0) {
                obj = Long.valueOf(j);
            } else {
                obj = "-1";
            }
            sb.append(obj);
            sMemory = sb.toString().replace("m", "");
        }
        return sMemory;
    }

    public static boolean mayEmulatorFromBuild() {
        String prop = RomUtils.getProp("ro.product.model");
        if (!TextUtils.isEmpty(prop) && !prop.toLowerCase().contains("sdk") && !prop.toLowerCase().contains("google_sdk") && !prop.contains("Emulator")) {
            String prop2 = RomUtils.getProp("ro.product.manufacturer");
            if (!TextUtils.isEmpty(prop2) && !prop2.toLowerCase().contains("unknown") && !prop2.contains("Genymotion")) {
                String prop3 = RomUtils.getProp("ro.product.device");
                if (!TextUtils.isEmpty(prop3) && !prop3.toLowerCase().contains("generic")) {
                    return "1".equals(RomUtils.getProp("ro.kernel.qemu"));
                }
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getSDKVersion(String str) {
        JsonReader jsonReader;
        Exception e;
        if (sSDKVersionMap.get(str) == null) {
            JsonReader jsonReader2 = null;
            try {
                try {
                    jsonReader = new JsonReader(new InputStreamReader(AppRuntime.getAppContext().getAssets().open(str, 3), "UTF-8"));
                    try {
                        try {
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
                            jsonReader.close();
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            if (jsonReader != null) {
                                jsonReader.close();
                            }
                            return sSDKVersionMap.get(str);
                        }
                    } catch (Throwable th) {
                        th = th;
                        jsonReader2 = jsonReader;
                        if (jsonReader2 != null) {
                            try {
                                jsonReader2.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            } catch (Exception e5) {
                jsonReader = null;
                e = e5;
            } catch (Throwable th2) {
                th = th2;
                if (jsonReader2 != null) {
                }
                throw th;
            }
        }
        return sSDKVersionMap.get(str);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:63:0x00d9 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.StringBuilder] */
    public static String getVSSRSS() {
        BufferedReader bufferedReader;
        String str;
        String str2;
        String str3;
        ?? r0;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                File file = new File("/proc/self/status");
                if (file.exists()) {
                    BufferedReader bufferedReader3 = new BufferedReader(new FileReader(file));
                    try {
                        try {
                            int size = mVSSKey.size();
                            str = null;
                            str2 = null;
                            str3 = null;
                            int i = 0;
                            while (i < size) {
                                try {
                                    String readLine = bufferedReader3.readLine();
                                    if (readLine != null) {
                                        String[] split = readLine.split(":");
                                        if (split.length == 2) {
                                            String str4 = split[0];
                                            String str5 = split[1];
                                            if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
                                                String trim = str4.trim();
                                                String upperCase = str5.trim().toUpperCase();
                                                if (mVSSKey.contains(trim)) {
                                                    i++;
                                                    if (upperCase.endsWith(" KB")) {
                                                        upperCase = upperCase.substring(0, upperCase.lastIndexOf(" KB"));
                                                    }
                                                    if (!TextUtils.isEmpty(upperCase)) {
                                                        char c = 65535;
                                                        switch (trim.hashCode()) {
                                                            case -1729713066:
                                                                if (trim.equals("VmPeak")) {
                                                                    c = 1;
                                                                    break;
                                                                }
                                                                break;
                                                            case -1729619080:
                                                                if (trim.equals("VmSize")) {
                                                                    c = 3;
                                                                    break;
                                                                }
                                                                break;
                                                            case 82741991:
                                                                if (trim.equals(VSSConstants.VMHWM)) {
                                                                    c = 0;
                                                                    break;
                                                                }
                                                                break;
                                                            case 82751483:
                                                                if (trim.equals(VSSConstants.VMRSS)) {
                                                                    c = 2;
                                                                    break;
                                                                }
                                                                break;
                                                        }
                                                        if (c != 0) {
                                                            if (c != 1) {
                                                                if (c != 2) {
                                                                    if (c == 3) {
                                                                        bufferedReader2 = upperCase;
                                                                    }
                                                                } else {
                                                                    str3 = upperCase;
                                                                }
                                                            } else {
                                                                str = upperCase;
                                                            }
                                                        } else {
                                                            str2 = upperCase;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        r0 = bufferedReader2;
                                        bufferedReader2 = bufferedReader3;
                                    }
                                } catch (FileNotFoundException e) {
                                    e = e;
                                    bufferedReader = bufferedReader2;
                                    bufferedReader2 = bufferedReader3;
                                    e.printStackTrace();
                                    if (bufferedReader2 != null) {
                                        try {
                                            bufferedReader2.close();
                                        } catch (IOException e2) {
                                            e = e2;
                                            e.printStackTrace();
                                            r0 = bufferedReader;
                                            return r0 + ParamableElem.DIVIDE_PARAM + str + ParamableElem.DIVIDE_PARAM + str3 + ParamableElem.DIVIDE_PARAM + str2;
                                        }
                                    }
                                    r0 = bufferedReader;
                                    return r0 + ParamableElem.DIVIDE_PARAM + str + ParamableElem.DIVIDE_PARAM + str3 + ParamableElem.DIVIDE_PARAM + str2;
                                } catch (IOException e3) {
                                    e = e3;
                                    bufferedReader = bufferedReader2;
                                    bufferedReader2 = bufferedReader3;
                                    e.printStackTrace();
                                    if (bufferedReader2 != null) {
                                        try {
                                            bufferedReader2.close();
                                        } catch (IOException e4) {
                                            e = e4;
                                            e.printStackTrace();
                                            r0 = bufferedReader;
                                            return r0 + ParamableElem.DIVIDE_PARAM + str + ParamableElem.DIVIDE_PARAM + str3 + ParamableElem.DIVIDE_PARAM + str2;
                                        }
                                    }
                                    r0 = bufferedReader;
                                    return r0 + ParamableElem.DIVIDE_PARAM + str + ParamableElem.DIVIDE_PARAM + str3 + ParamableElem.DIVIDE_PARAM + str2;
                                }
                            }
                            r0 = bufferedReader2;
                            bufferedReader2 = bufferedReader3;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader2 = bufferedReader3;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException e6) {
                        e = e6;
                        bufferedReader = null;
                        str = null;
                        str2 = null;
                        str3 = null;
                    } catch (IOException e7) {
                        e = e7;
                        bufferedReader = null;
                        str = null;
                        str2 = null;
                        str3 = null;
                    }
                } else {
                    r0 = 0;
                    str = null;
                    str2 = null;
                    str3 = null;
                }
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException e9) {
            e = e9;
            bufferedReader = null;
            str = null;
            str2 = null;
            str3 = null;
        } catch (IOException e10) {
            e = e10;
            bufferedReader = null;
            str = null;
            str2 = null;
            str3 = null;
        }
        return r0 + ParamableElem.DIVIDE_PARAM + str + ParamableElem.DIVIDE_PARAM + str3 + ParamableElem.DIVIDE_PARAM + str2;
    }
}
