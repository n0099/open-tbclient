package com.baidu.android.util.devices;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.android.util.devices.IDevices;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
@Deprecated
/* loaded from: classes4.dex */
public class DeviceUtil implements IDevices {

    /* loaded from: classes4.dex */
    public static class OSInfo {
        public static final int KITKAT = 19;
        public static final int LOLLIPOP = 21;
        public static final int LOLLIPOP_MR1 = 22;
        public static final int MARSHMALLOW = 23;
        public static final int Nougat = 24;
        public static final int NougatPlus = 25;

        public static String getOS() {
            return "Android";
        }

        public static boolean hasFroyo() {
            return DeviceUtils.OSInfo.hasFroyo();
        }

        public static boolean hasGingerbread() {
            return DeviceUtils.OSInfo.hasGingerbread();
        }

        public static boolean isGingerbreadmr1() {
            return DeviceUtils.OSInfo.isGingerbreadmr1();
        }

        public static boolean isGingerbread() {
            return DeviceUtils.OSInfo.isGingerbread();
        }

        public static boolean hasHoneycomb() {
            return DeviceUtils.OSInfo.hasHoneycomb();
        }

        public static boolean hasHoneycombMR1() {
            return DeviceUtils.OSInfo.hasHoneycombMR1();
        }

        public static boolean hasICS() {
            return DeviceUtils.OSInfo.hasICS();
        }

        public static boolean hasICSMR1() {
            return DeviceUtils.OSInfo.hasICSMR1();
        }

        public static boolean hasJellyBean() {
            return DeviceUtils.OSInfo.hasJellyBean();
        }

        public static boolean hasJellyBeanMR1() {
            return DeviceUtils.OSInfo.hasJellyBeanMR1();
        }

        public static boolean hasJellyBeanMR2() {
            return DeviceUtils.OSInfo.hasJellyBeanMR2();
        }

        public static boolean hasKitKat() {
            return DeviceUtils.OSInfo.hasKitKat();
        }

        public static boolean isKitKat() {
            return DeviceUtils.OSInfo.isKitKat();
        }

        public static boolean hasLollipop() {
            return DeviceUtils.OSInfo.hasLollipop();
        }

        public static boolean hasLollipopMR1() {
            return DeviceUtils.OSInfo.hasLollipopMR1();
        }

        public static final boolean isLollipop() {
            return DeviceUtils.OSInfo.isLollipop();
        }

        public static boolean hasMarshMallow() {
            return DeviceUtils.OSInfo.hasMarshMallow();
        }

        public static boolean hasNougat() {
            return DeviceUtils.OSInfo.hasNougat();
        }

        public static boolean hasNougatMR1() {
            return DeviceUtils.OSInfo.hasNougatMR1();
        }

        public static boolean hasOreo() {
            return DeviceUtils.OSInfo.hasOreo();
        }

        public static String getOsVersion() {
            return DeviceUtils.OSInfo.getOsVersion();
        }

        public static int getSDKLevel() {
            return DeviceUtils.OSInfo.getSDKLevel();
        }
    }

    /* loaded from: classes4.dex */
    public static class ScreenInfo {
        private static final int STANDARD_STATUSBAR_HEIGHT = 50;
        private static int originDensityDip = 0;
        private static DisplayMetrics sDisplayMetrics;

        public static int dp2px(@Nullable Context context, float f) {
            return (int) ((AppRuntime.getAppContext().getResources().getDisplayMetrics().density * f) + 0.5f);
        }

        public static float dp2pxf(@Nullable Context context, float f) {
            return getDensity(AppRuntime.getAppContext()) * f;
        }

        public static int px2dp(@Nullable Context context, float f) {
            return (int) ((f / AppRuntime.getAppContext().getResources().getDisplayMetrics().density) + 0.5f);
        }

        @Deprecated
        public static float px2dpFloat(float f) {
            return f / getDensity(AppRuntime.getAppContext());
        }

        public static int getDisplayWidth(@Nullable Context context) {
            DisplayMetrics displayMetrics = getDisplayMetrics(AppRuntime.getAppContext());
            if (displayMetrics != null) {
                return displayMetrics.widthPixels;
            }
            return 0;
        }

        public static int getDisplayHeight(@Nullable Context context) {
            DisplayMetrics displayMetrics = getDisplayMetrics(AppRuntime.getAppContext());
            if (displayMetrics != null) {
                return displayMetrics.heightPixels;
            }
            return 0;
        }

        public static int getRealScreenHeight(@Nullable Context context) {
            WindowManager windowManager = (WindowManager) AppRuntime.getAppContext().getSystemService("window");
            if (windowManager == null) {
                return -1;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (OSInfo.hasJellyBeanMR1()) {
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
                return displayMetrics.heightPixels;
            }
            return getDisplayHeight(context);
        }

        public static int getScreenOriginDensityDip() {
            return DeviceUtils.ScreenInfo.getScreenOriginDensityDip();
        }

        public static float getDensity(@Nullable Context context) {
            initDisplayMetrics(AppRuntime.getAppContext());
            if (sDisplayMetrics != null) {
                return sDisplayMetrics.density;
            }
            return 0.0f;
        }

        public static int getDensityDpi(@Nullable Context context) {
            initDisplayMetrics(AppRuntime.getAppContext());
            if (sDisplayMetrics != null) {
                return sDisplayMetrics.densityDpi;
            }
            return 0;
        }

        private static void initDisplayMetrics(Context context) {
            Context appContext = AppRuntime.getAppContext();
            if (sDisplayMetrics == null) {
                if (appContext != null) {
                    context = appContext;
                }
                if (context != null) {
                    sDisplayMetrics = context.getResources().getDisplayMetrics();
                }
            }
        }

        private static DisplayMetrics getDisplayMetrics(Context context) {
            Context appContext = AppRuntime.getAppContext();
            if (appContext == null) {
                return null;
            }
            return appContext.getResources().getDisplayMetrics();
        }

        public static int getStatusBarHeight() {
            return DeviceUtils.ScreenInfo.getStatusBarHeight();
        }

        public static int getNavigationBarHeight() {
            return DeviceUtils.ScreenInfo.getNavigationBarHeight();
        }

        public static boolean isScreenPortrait() {
            return DeviceUtils.ScreenInfo.isScreenPortrait();
        }

        public static boolean isScreenLand() {
            return DeviceUtils.ScreenInfo.isScreenLand();
        }

        public static boolean isDensityTooLarge(Activity activity) {
            return DeviceUtils.ScreenInfo.isDensityTooLarge(activity);
        }

        @Deprecated
        public static String getRealScreenSize(@Nullable Context context) {
            int displayWidth = getDisplayWidth(context);
            int realScreenHeight = getRealScreenHeight(context);
            if (displayWidth <= 0 || realScreenHeight <= 0) {
                return "";
            }
            return displayWidth + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + realScreenHeight;
        }
    }

    /* loaded from: classes4.dex */
    public static class BrandInfo {
        public static String getDeviceBrand() {
            return RomUtils.getDeviceBrand();
        }

        public static String getManufacturer() {
            return RomUtils.getManufacturer();
        }

        public static String getDeviceModel() {
            return RomUtils.getDeviceModel();
        }

        public static String getDeviceName() {
            return RomUtils.getDeviceName();
        }

        public static boolean isMiBox2Device() {
            return RomUtils.isMiBox2Device();
        }

        public static boolean isMagicBoxDevice() {
            return RomUtils.isMagicBoxDevice();
        }

        @Deprecated
        public static boolean isProblemBoxDevice() {
            return isMiBox2Device() || isMagicBoxDevice();
        }
    }

    public static boolean isSupportFoldable() {
        if (isMateX() || isHwFoldableDevice()) {
            return true;
        }
        return Build.MODEL.equals("SM-F9000");
    }

    public static boolean isMateX() {
        String[] strArr = {"RLI-AN00", "RLI-N29", "TAH-AN00", "TAH-N29", "TAH-AN00m", "RHA-AN00m", "TET-AN00"};
        if ("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) {
            for (String str : strArr) {
                if (str.equalsIgnoreCase(Build.MODEL)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isHwFoldableDevice() {
        return "HUAWEI".equalsIgnoreCase(Build.MANUFACTURER) && AppRuntime.getAppContext().getPackageManager().hasSystemFeature("com.huawei.hardware.sensor.posture");
    }

    /* loaded from: classes4.dex */
    public static final class CPUInfo {
        public static final String FEATURE_COMMON = "common";
        public static final String FEATURE_NEON = "neon";
        public static final String FEATURE_VFP = "vfp";
        private static final String PREFIX_FEATURES = "features";
        private static final String PREFIX_PROCESSOR = "processor";
        public static final String PROCESSOR_ARMV5 = "armv5";
        public static final String PROCESSOR_ARMV6 = "armv6";
        public static final String PROCESSOR_ARMV7 = "armv7";
        public static final String PROCESSOR_X86 = "x86";
        private static CPUInfo systemCPUInfo = null;
        private static IDevices.ARCH sArch = IDevices.ARCH.Unknown;
        public String processor = "";
        public String features = "";

        public static CPUInfo getSystemCPUInfo() {
            if (systemCPUInfo != null) {
                return systemCPUInfo;
            }
            CPUInfo cPUInfo = new CPUInfo();
            try {
                FileReader fileReader = new FileReader("/proc/cpuinfo");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                    String lowerCase = readLine.trim().toLowerCase();
                    if (lowerCase.startsWith(PREFIX_PROCESSOR) && lowerCase.indexOf(":", PREFIX_PROCESSOR.length()) != -1) {
                        if (cPUInfo.processor.length() > 0) {
                            cPUInfo.processor += "__";
                        }
                        cPUInfo.processor += lowerCase.split(":")[1].trim();
                    } else if (lowerCase.startsWith(PREFIX_FEATURES) && lowerCase.indexOf(":", PREFIX_FEATURES.length()) != -1) {
                        if (cPUInfo.features.length() > 0) {
                            cPUInfo.features += "__";
                        }
                        cPUInfo.features += lowerCase.split(":")[1].trim();
                    }
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            if (Build.CPU_ABI.equalsIgnoreCase("x86")) {
                cPUInfo.processor = "x86";
            }
            systemCPUInfo = cPUInfo;
            return cPUInfo;
        }

        public static String getCpuArchInfo() {
            return DeviceUtils.CPUInfo.getCpuArchInfo();
        }

        public static synchronized IDevices.ARCH getMyCpuArch() {
            IDevices.ARCH cpuArch;
            synchronized (CPUInfo.class) {
                cpuArch = DeviceUtils.CPUInfo.getCpuArch();
            }
            return cpuArch;
        }

        @Deprecated
        public static String get_CPU_ABI() {
            return Build.CPU_ABI;
        }

        @Deprecated
        public static String get_CPU_ABI2() {
            try {
                Field declaredField = Build.class.getDeclaredField("CPU_ABI2");
                if (declaredField == null) {
                    return null;
                }
                Object obj = declaredField.get(null);
                if (obj instanceof String) {
                    return (String) obj;
                }
                return null;
            } catch (Exception e) {
                return null;
            }
        }

        public static boolean supportABI(String str) {
            String _cpu_abi = get_CPU_ABI();
            if (TextUtils.isEmpty(_cpu_abi) || !_cpu_abi.equalsIgnoreCase(str)) {
                return !TextUtils.isEmpty(get_CPU_ABI2()) && _cpu_abi.equalsIgnoreCase(str);
            }
            return true;
        }

        public static boolean supportX86() {
            return supportABI("x86");
        }

        public static boolean supportMips() {
            return supportABI(IDevices.ABI_MIPS);
        }

        public static boolean isARMSimulatedByX86() {
            return !supportX86() && IDevices.ARCH.X86.equals(getMyCpuArch());
        }

        public static boolean isRealARMArch() {
            return (supportABI("armeabi-v7a") || supportABI("armeabi")) && IDevices.ARCH.ARM.equals(getMyCpuArch());
        }

        public static boolean isRealX86Arch() {
            return supportABI("x86") || IDevices.ARCH.X86.equals(getMyCpuArch());
        }

        public static String getPreferredABI() {
            return DeviceUtils.CPUInfo.getPreferredABI();
        }
    }
}
