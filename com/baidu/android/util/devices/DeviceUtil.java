package com.baidu.android.util.devices;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyCharacterMap;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.baidu.android.util.devices.IDevices;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ui.animview.praise.PraiseDataPassUtil;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
/* loaded from: classes12.dex */
public class DeviceUtil implements IDevices {

    /* loaded from: classes12.dex */
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
            return Build.VERSION.SDK_INT >= 8;
        }

        public static boolean hasGingerbread() {
            return Build.VERSION.SDK_INT >= 9;
        }

        public static boolean isGingerbreadmr1() {
            return Build.VERSION.SDK_INT == 10;
        }

        public static boolean isGingerbread() {
            return Build.VERSION.SDK_INT == 9;
        }

        public static boolean hasHoneycomb() {
            return Build.VERSION.SDK_INT >= 11;
        }

        public static boolean hasHoneycombMR1() {
            return Build.VERSION.SDK_INT >= 12;
        }

        public static boolean hasICS() {
            return Build.VERSION.SDK_INT >= 14;
        }

        public static boolean hasICSMR1() {
            return Build.VERSION.SDK_INT >= 15;
        }

        public static boolean hasJellyBean() {
            return Build.VERSION.SDK_INT >= 16;
        }

        public static boolean hasJellyBeanMR1() {
            return Build.VERSION.SDK_INT >= 17;
        }

        public static boolean hasJellyBeanMR2() {
            return Build.VERSION.SDK_INT >= 18;
        }

        public static boolean hasKitKat() {
            return Build.VERSION.SDK_INT >= 19;
        }

        public static boolean isKitKat() {
            return Build.VERSION.SDK_INT == 19;
        }

        public static boolean hasLollipop() {
            return Build.VERSION.SDK_INT >= 21;
        }

        public static boolean hasLollipopMR1() {
            return Build.VERSION.SDK_INT >= 22;
        }

        public static final boolean isLollipop() {
            return Build.VERSION.SDK_INT == 21;
        }

        public static boolean hasMarshMallow() {
            return Build.VERSION.SDK_INT >= 23;
        }

        public static boolean hasNougat() {
            return Build.VERSION.SDK_INT >= 24;
        }

        public static boolean hasNougatMR1() {
            return Build.VERSION.SDK_INT >= 25;
        }

        public static boolean hasOreo() {
            return Build.VERSION.SDK_INT >= 26;
        }

        public static String getOsVersion() {
            String str = Build.VERSION.RELEASE;
            if (TextUtils.isEmpty(str)) {
                return "0.0";
            }
            return str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }

        public static int getSDKLevel() {
            return Build.VERSION.SDK_INT;
        }
    }

    /* loaded from: classes12.dex */
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
            WindowManager windowManager;
            int i = PreferenceUtils.getInt("KEY_REAL_SCREENSIZE_HEIGHT", -1);
            if (i >= 0 || (windowManager = (WindowManager) AppRuntime.getAppContext().getSystemService("window")) == null) {
                return i;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            int i2 = displayMetrics.heightPixels;
            PreferenceUtils.setInt("KEY_REAL_SCREENSIZE_HEIGHT", i2);
            return i2;
        }

        public static int getScreenOriginDensityDip() {
            if (originDensityDip > 0) {
                return originDensityDip;
            }
            try {
                originDensityDip = ((Integer) Class.forName("android.view.IWindowManager").getMethod("getInitialDisplayDensity", Integer.TYPE).invoke(Class.forName("android.view.WindowManagerGlobal").getMethod("getWindowManagerService", new Class[0]).invoke(new Object(), new Object[0]), 0)).intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return originDensityDip;
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
            int i = 0;
            int identifier = AppRuntime.getAppContext().getResources().getIdentifier("status_bar_height", "dimen", PraiseDataPassUtil.KEY_FROM_OS);
            if (identifier > 0) {
                try {
                    i = AppRuntime.getAppContext().getResources().getDimensionPixelSize(identifier);
                } catch (Exception e) {
                }
            }
            if (i == 0) {
                return (int) (25.0f * getDensity(null));
            }
            return i;
        }

        public static int getNavigationBarHeight() {
            boolean hasPermanentMenuKey = ViewConfiguration.get(AppRuntime.getAppContext()).hasPermanentMenuKey();
            boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
            if (hasPermanentMenuKey || deviceHasKey) {
                return 0;
            }
            Resources resources = AppRuntime.getAppContext().getResources();
            return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", PraiseDataPassUtil.KEY_FROM_OS));
        }

        public static boolean isScreenPortrait() {
            return AppRuntime.getAppContext().getResources().getConfiguration().orientation == 1;
        }

        public static boolean isScreenLand() {
            return AppRuntime.getAppContext().getResources().getConfiguration().orientation == 2;
        }

        public static boolean isDensityTooLarge(Activity activity) {
            int i;
            if (Build.VERSION.SDK_INT < 24 || activity == null) {
                return false;
            }
            try {
                i = ((Integer) Class.forName("android.view.IWindowManager").getMethod("getInitialDisplayDensity", Integer.TYPE).invoke(Class.forName("android.view.WindowManagerGlobal").getMethod("getWindowManagerService", new Class[0]).invoke(new Object(), new Object[0]), 0)).intValue();
            } catch (Exception e) {
                e.printStackTrace();
                i = 0;
            }
            if (i <= 0 || activity.isInMultiWindowMode()) {
                return false;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.density > ((float) i) / 160.0f;
        }

        public static String getRealScreenSize(@Nullable Context context) {
            String string = PreferenceUtils.getString("KEY_REAL_SCREENSIZE", "");
            if (TextUtils.isEmpty(string)) {
                int displayWidth = getDisplayWidth(context);
                int realScreenHeight = getRealScreenHeight(context);
                if (displayWidth > 0 && realScreenHeight > 0) {
                    String str = displayWidth + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + realScreenHeight;
                    PreferenceUtils.setString("KEY_REAL_SCREENSIZE", str);
                    return str;
                }
                return string;
            }
            return string;
        }
    }

    /* loaded from: classes12.dex */
    public static class BrandInfo {
        public static String getDeviceBrand() {
            return Build.BRAND;
        }

        public static String getManufacturer() {
            return Build.MANUFACTURER;
        }

        public static String getDeviceModel() {
            return Build.MODEL;
        }

        public static String getDeviceName() {
            return Build.PRODUCT;
        }

        public static boolean isMiBox2Device() {
            return Build.MANUFACTURER.equalsIgnoreCase("Xiaomi") && Build.PRODUCT.equalsIgnoreCase("dredd");
        }

        public static boolean isMagicBoxDevice() {
            return Build.MANUFACTURER.equalsIgnoreCase("MagicBox") && Build.PRODUCT.equalsIgnoreCase("MagicBox");
        }

        public static boolean isProblemBoxDevice() {
            return isMiBox2Device() || isMagicBoxDevice();
        }
    }

    public static boolean isSupportFoldable() {
        return Build.MODEL.equals("SM-F9000") || Build.MODEL.equals("RLI-AN00");
    }

    /* loaded from: classes12.dex */
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
            String lowerCase = System.getProperty("os.arch").toLowerCase();
            if (lowerCase == null || lowerCase.length() == 0) {
                return null;
            }
            return lowerCase;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [879=5, 881=4, 882=4, 883=4] */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x006c */
        /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: java.io.RandomAccessFile */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:64:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r1v1, types: [boolean] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static synchronized IDevices.ARCH getMyCpuArch() {
            RandomAccessFile randomAccessFile;
            synchronized (CPUInfo.class) {
                byte[] bArr = new byte[20];
                File file = new File(Environment.getRootDirectory(), "lib/libc.so");
                RandomAccessFile canRead = file.canRead();
                if (canRead != 0) {
                    try {
                        try {
                            randomAccessFile = new RandomAccessFile(file, "r");
                            try {
                                randomAccessFile.readFully(bArr);
                                switch (bArr[18] | (bArr[19] << 8)) {
                                    case 3:
                                        sArch = IDevices.ARCH.X86;
                                        break;
                                    case 8:
                                        sArch = IDevices.ARCH.MIPS;
                                        break;
                                    case 40:
                                        sArch = IDevices.ARCH.ARM;
                                        break;
                                    case 183:
                                        sArch = IDevices.ARCH.ARM64;
                                        break;
                                }
                                if (randomAccessFile != null) {
                                    try {
                                        randomAccessFile.close();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            } catch (FileNotFoundException e2) {
                                e = e2;
                                e.printStackTrace();
                                if (randomAccessFile != null) {
                                    try {
                                        randomAccessFile.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                return sArch;
                            } catch (IOException e4) {
                                e = e4;
                                e.printStackTrace();
                                if (randomAccessFile != null) {
                                    try {
                                        randomAccessFile.close();
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                    }
                                }
                                return sArch;
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (canRead != 0) {
                                try {
                                    canRead.close();
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException e7) {
                        e = e7;
                        randomAccessFile = null;
                    } catch (IOException e8) {
                        e = e8;
                        randomAccessFile = null;
                    } catch (Throwable th2) {
                        th = th2;
                        canRead = 0;
                        if (canRead != 0) {
                        }
                        throw th;
                    }
                }
            }
            return sArch;
        }

        public static String get_CPU_ABI() {
            return Build.CPU_ABI;
        }

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
    }
}
