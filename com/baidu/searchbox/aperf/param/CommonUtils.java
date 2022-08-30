package com.baidu.searchbox.aperf.param;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import android.util.JsonReader;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.android.util.devices.StorageUtils;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.aperf.param.util.CpuInfoUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.j10;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes2.dex */
public class CommonUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FALSE = "0";
    public static final String INVALID = "-1";
    public static final int MAGIC_INTEGER_1024 = 1024;
    public static final int MAGIC_INTEGER_2 = 2;
    public static final String SDK_VERSION = "sdkversion";
    public static final String TRUE = "1";
    public static final String UNKNOWN = "-1";
    public static final HashSet<String> mVSSKey;
    public static String sAppVersion;
    public static String sCPU;
    public static String sEmulator;
    public static String sMemory;
    public static String sModel;
    public static String sOSVersion;
    public static String sPackageName;
    public static String sProcessBit;
    public static String sROM;
    public static String sRooted;
    public static final ConcurrentHashMap<String, String> sSDKVersionMap;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static final class VSSConstants {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String VMHWM = "VmHWM";
        public static final String VMPEAK = "VmPeak";
        public static final String VMRSS = "VmRSS";
        public static final String VMSIZE = "VmSize";
        public transient /* synthetic */ FieldHolder $fh;

        public VSSConstants() {
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
    }

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
        mVSSKey = new HashSet<String>() { // from class: com.baidu.searchbox.aperf.param.CommonUtils.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                add("VmPeak");
                add("VmSize");
                add(VSSConstants.VMHWM);
                add(VSSConstants.VMRSS);
            }
        };
        sOSVersion = null;
        sMemory = null;
        sCPU = null;
        sModel = null;
        sAppVersion = null;
        sRooted = null;
        sProcessBit = null;
        sEmulator = null;
        sROM = null;
        sPackageName = null;
    }

    public CommonUtils() {
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
        return (String) invokeV.objValue;
    }

    public static String getCPUInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
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
        return (String) invokeV.objValue;
    }

    public static String getEmulator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (sEmulator == null) {
                if (mayEmulatorFromBuild()) {
                    sEmulator = "1";
                } else {
                    sEmulator = "-1";
                }
            }
            return sEmulator;
        }
        return (String) invokeV.objValue;
    }

    public static String getExStorage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            long availableExternalMemorySize = StorageUtils.getAvailableExternalMemorySize();
            long totalExternalMemorySize = StorageUtils.getTotalExternalMemorySize();
            if (availableExternalMemorySize > 0) {
                availableExternalMemorySize = Math.round(((float) availableExternalMemorySize) / 1024.0f);
            }
            if (totalExternalMemorySize > 0) {
                totalExternalMemorySize = Math.round(((float) totalExternalMemorySize) / 1024.0f);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(availableExternalMemorySize >= 0 ? Long.valueOf(availableExternalMemorySize) : "-1");
            sb.append(ParamableElem.DIVIDE_PARAM);
            sb.append(totalExternalMemorySize >= 0 ? Long.valueOf(totalExternalMemorySize) : "-1");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static String getHeapInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            long j = Runtime.getRuntime().totalMemory() / 1024;
            long freeMemory = j - (Runtime.getRuntime().freeMemory() / 1024);
            return (Debug.getNativeHeapAllocatedSize() / 1024) + ParamableElem.DIVIDE_PARAM + freeMemory + ParamableElem.DIVIDE_PARAM + (Debug.getNativeHeapSize() / 1024) + ParamableElem.DIVIDE_PARAM + j + ParamableElem.DIVIDE_PARAM + (Runtime.getRuntime().maxMemory() / 1024);
        }
        return (String) invokeV.objValue;
    }

    public static String getInStorage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            long availableInternalMemorySize = StorageUtils.getAvailableInternalMemorySize();
            long totalInternalMemorySize = StorageUtils.getTotalInternalMemorySize();
            if (availableInternalMemorySize > 0) {
                availableInternalMemorySize = Math.round(((float) availableInternalMemorySize) / 1024.0f);
            }
            if (totalInternalMemorySize > 0) {
                totalInternalMemorySize = Math.round(((float) totalInternalMemorySize) / 1024.0f);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(availableInternalMemorySize >= 0 ? Long.valueOf(availableInternalMemorySize) : "-1");
            sb.append(ParamableElem.DIVIDE_PARAM);
            sb.append(totalInternalMemorySize >= 0 ? Long.valueOf(totalInternalMemorySize) : "-1");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static String getLogId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? UUID.randomUUID().toString().replace("-", "") : (String) invokeV.objValue;
    }

    public static String getMemoryInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
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
                sb.append(j >= 0 ? Long.valueOf(j) : "-1");
                sMemory = sb.toString().replace("m", "");
            }
            return sMemory;
        }
        return (String) invokeV.objValue;
    }

    public static String getModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (sModel == null) {
                String deviceModel = DeviceUtil.BrandInfo.getDeviceModel();
                sModel = deviceModel;
                if (deviceModel == null) {
                    sModel = "";
                }
            }
            return sModel;
        }
        return (String) invokeV.objValue;
    }

    public static String getNetwork() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? new j10().a() : (String) invokeV.objValue;
    }

    public static String getOSVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (sOSVersion == null) {
                sOSVersion = DeviceUtil.OSInfo.getOsVersion();
            }
            return sOSVersion;
        }
        return (String) invokeV.objValue;
    }

    public static String getPSS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            long j = memoryInfo.dalvikPss;
            StringBuilder sb = new StringBuilder();
            sb.append(memoryInfo.nativePss);
            sb.append(ParamableElem.DIVIDE_PARAM);
            sb.append(j);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (sPackageName == null) {
                String packageName = AppRuntime.getAppContext().getPackageName();
                sPackageName = packageName;
                if (packageName == null) {
                    sPackageName = "";
                }
            }
            return sPackageName;
        }
        return (String) invokeV.objValue;
    }

    public static String getProcessBit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            if (sProcessBit == null) {
                sProcessBit = is64Bit() ? "1" : "0";
            }
            return sProcessBit;
        }
        return (String) invokeV.objValue;
    }

    public static String getROM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            if (sROM == null) {
                sROM = RomUtils.getName() + ParamableElem.DIVIDE_PARAM + RomUtils.getVersion();
            }
            return sROM;
        }
        return (String) invokeV.objValue;
    }

    public static String getRootedInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            if (sRooted == null) {
                String prop = RomUtils.getProp("ro.secure");
                boolean z = true;
                if (prop != null && "0".equals(prop)) {
                    z = false;
                }
                if (!z) {
                    sRooted = "1";
                } else {
                    sRooted = isSUExist() ? "1" : "-1";
                }
            }
            return sRooted;
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x004d */
    /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: android.util.JsonReader */
    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: android.util.JsonReader */
    /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: android.util.JsonReader */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getSDKVersion(String str) {
        InterceptResult invokeL;
        JsonReader jsonReader;
        Exception e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
            if (sSDKVersionMap.get(str) == null) {
                JsonReader jsonReader2 = 0;
                try {
                    try {
                        try {
                            jsonReader = new JsonReader(new InputStreamReader(AppRuntime.getAppContext().getAssets().open(str, 3), "UTF-8"));
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
                            jsonReader2 = interceptable;
                            if (jsonReader2 != 0) {
                                try {
                                    jsonReader2.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e4) {
                        jsonReader = null;
                        e = e4;
                    } catch (Throwable th2) {
                        th = th2;
                        if (jsonReader2 != 0) {
                        }
                        throw th;
                    }
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            return sSDKVersionMap.get(str);
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x001c: ARITH  (r0v6 long A[REMOVE]) = (wrap: long : 0x0018: IGET  (r0v5 long A[REMOVE]) = (r1v4 android.app.ActivityManager$MemoryInfo) android.app.ActivityManager.MemoryInfo.availMem long) / (1024 long))] */
    public static String getSysMem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) AppRuntime.getAppContext().getSystemService("activity")).getMemoryInfo(memoryInfo);
            StringBuilder sb = new StringBuilder();
            sb.append(memoryInfo.availMem / 1024);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:65:0x00dd */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.StringBuilder] */
    public static String getVSSRSS() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        String str;
        String str2;
        String str3;
        ?? r0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
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
                                                            if (c == 0) {
                                                                str2 = upperCase;
                                                            } else if (c == 1) {
                                                                str = upperCase;
                                                            } else if (c == 2) {
                                                                str3 = upperCase;
                                                            } else if (c == 3) {
                                                                bufferedReader2 = upperCase;
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
        return (String) invokeV.objValue;
    }

    public static boolean is64Bit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 23) {
                return Process.is64Bit();
            }
            if (i >= 21) {
                String[] strArr = Build.SUPPORTED_64_BIT_ABIS;
                if (strArr.length > 0) {
                    return Build.CPU_ABI.equals(strArr[0]);
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isLowMemory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) AppRuntime.getAppContext().getSystemService("activity")).getMemoryInfo(memoryInfo);
            return memoryInfo.lowMemory;
        }
        return invokeV.booleanValue;
    }

    public static boolean isSUExist() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            String[] strArr = {"/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su"};
            for (int i = 0; i < 8; i++) {
                if (new File(strArr[i]).exists()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean mayEmulatorFromBuild() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
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
        return invokeV.booleanValue;
    }
}
