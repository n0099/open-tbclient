package com.baidu.android.util.devices;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyCharacterMap;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.baidu.android.util.devices.IDevices;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
/* loaded from: classes.dex */
public class DeviceUtils implements IDevices {

    /* loaded from: classes.dex */
    public static final class CPUInfo {
        public static final String FEATURE_COMMON = "common";
        public static final String FEATURE_NEON = "neon";
        public static final String FEATURE_VFP = "vfp";
        public static final String PREFIX_FEATURES = "features";
        public static final String PREFIX_PROCESSOR = "processor";
        public static final String PROCESSOR_ARMV5 = "armv5";
        public static final String PROCESSOR_ARMV6 = "armv6";
        public static final String PROCESSOR_ARMV7 = "armv7";
        public static final String PROCESSOR_X86 = "x86";
        public static IDevices.ARCH sArch = IDevices.ARCH.Unknown;
        public static CPUInfo systemCPUInfo;
        public String processor = "";
        public String features = "";

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x0064 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:41:0x0070 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:63:0x0019 */
        /* JADX DEBUG: Multi-variable search result rejected for r3v7, resolved type: java.io.RandomAccessFile */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v11 */
        /* JADX WARN: Type inference failed for: r3v12 */
        /* JADX WARN: Type inference failed for: r3v13 */
        /* JADX WARN: Type inference failed for: r3v14 */
        /* JADX WARN: Type inference failed for: r3v15 */
        public static synchronized IDevices.ARCH getCpuArch() {
            RandomAccessFile randomAccessFile;
            synchronized (CPUInfo.class) {
                byte[] bArr = new byte[20];
                File file = new File(Environment.getRootDirectory(), "lib/libc.so");
                if (file.canRead()) {
                    RandomAccessFile randomAccessFile2 = null;
                    try {
                        try {
                            randomAccessFile = new RandomAccessFile(file, r.f7672a);
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (FileNotFoundException e2) {
                        e = e2;
                    } catch (IOException e3) {
                        e = e3;
                    }
                    try {
                        randomAccessFile.readFully(bArr);
                        randomAccessFile2 = 8;
                        int i2 = bArr[18] | (bArr[19] << 8);
                        if (i2 == 3) {
                            sArch = IDevices.ARCH.X86;
                        } else if (i2 == 8) {
                            sArch = IDevices.ARCH.MIPS;
                        } else if (i2 == 40) {
                            sArch = IDevices.ARCH.ARM;
                        } else if (i2 == 183) {
                            sArch = IDevices.ARCH.ARM64;
                        }
                        try {
                            randomAccessFile.close();
                        } catch (IOException e4) {
                            e = e4;
                            e.printStackTrace();
                            return sArch;
                        }
                    } catch (FileNotFoundException e5) {
                        e = e5;
                        randomAccessFile2 = randomAccessFile;
                        e.printStackTrace();
                        randomAccessFile2 = randomAccessFile2;
                        if (randomAccessFile2 != null) {
                            try {
                                randomAccessFile2.close();
                                randomAccessFile2 = randomAccessFile2;
                            } catch (IOException e6) {
                                e = e6;
                                e.printStackTrace();
                                return sArch;
                            }
                        }
                        return sArch;
                    } catch (IOException e7) {
                        e = e7;
                        randomAccessFile2 = randomAccessFile;
                        e.printStackTrace();
                        randomAccessFile2 = randomAccessFile2;
                        if (randomAccessFile2 != null) {
                            try {
                                randomAccessFile2.close();
                                randomAccessFile2 = randomAccessFile2;
                            } catch (IOException e8) {
                                e = e8;
                                e.printStackTrace();
                                return sArch;
                            }
                        }
                        return sArch;
                    } catch (Throwable th2) {
                        th = th2;
                        randomAccessFile2 = randomAccessFile;
                        if (randomAccessFile2 != null) {
                            try {
                                randomAccessFile2.close();
                            } catch (IOException e9) {
                                e9.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            }
            return sArch;
        }

        public static String getCpuArchInfo() {
            String lowerCase = System.getProperty("os.arch").toLowerCase(Locale.getDefault());
            if (lowerCase == null || lowerCase.length() == 0) {
                return null;
            }
            return lowerCase;
        }

        public static String getPreferredABI() {
            if (OSInfo.hasLollipop()) {
                String[] strArr = Build.SUPPORTED_64_BIT_ABIS;
                if (strArr != null && strArr.length > 0) {
                    return strArr[0];
                }
                String[] strArr2 = Build.SUPPORTED_32_BIT_ABIS;
                if (strArr2 != null && strArr2.length > 0) {
                    return strArr2[0];
                }
            }
            return Build.CPU_ABI;
        }

        public static String[] getSupportedABIs() {
            if (Build.VERSION.SDK_INT >= 21) {
                return Build.SUPPORTED_ABIS;
            }
            ArrayList arrayList = new ArrayList(Arrays.asList(Build.CPU_ABI, Build.CPU_ABI2));
            arrayList.removeAll(Arrays.asList(null, ""));
            return (String[]) arrayList.toArray(new String[0]);
        }

        public static CPUInfo getSystemCPUInfo() {
            CPUInfo cPUInfo = systemCPUInfo;
            if (cPUInfo != null) {
                return cPUInfo;
            }
            CPUInfo cPUInfo2 = new CPUInfo();
            try {
                FileReader fileReader = new FileReader("/proc/cpuinfo");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                    String lowerCase = readLine.trim().toLowerCase(Locale.getDefault());
                    if (lowerCase.startsWith("processor") && lowerCase.indexOf(":", 9) != -1) {
                        if (cPUInfo2.processor.length() > 0) {
                            cPUInfo2.processor += "__";
                        }
                        cPUInfo2.processor += lowerCase.split(":")[1].trim();
                    } else if (lowerCase.startsWith("features") && lowerCase.indexOf(":", 8) != -1) {
                        if (cPUInfo2.features.length() > 0) {
                            cPUInfo2.features += "__";
                        }
                        cPUInfo2.features += lowerCase.split(":")[1].trim();
                    }
                }
                bufferedReader.close();
                fileReader.close();
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            if (Build.CPU_ABI.equalsIgnoreCase("x86")) {
                cPUInfo2.processor = "x86";
            }
            systemCPUInfo = cPUInfo2;
            return cPUInfo2;
        }

        public static boolean isARMSimulatedByX86() {
            return !supportX86() && IDevices.ARCH.X86.equals(getCpuArch());
        }

        public static boolean isRealARMArch() {
            return (supportABI("armeabi-v7a") || supportABI("armeabi")) && IDevices.ARCH.ARM.equals(getCpuArch());
        }

        public static boolean isRealX86Arch() {
            return supportABI("x86") || IDevices.ARCH.X86.equals(getCpuArch());
        }

        public static boolean supportABI(String str) {
            for (String str2 : getSupportedABIs()) {
                if (str2.equalsIgnoreCase(str)) {
                    return true;
                }
            }
            return false;
        }

        public static boolean supportMips() {
            return supportABI(IDevices.ABI_MIPS);
        }

        public static boolean supportX86() {
            return supportABI("x86");
        }
    }

    /* loaded from: classes.dex */
    public static class OSInfo {
        public static String getOS() {
            return "Android";
        }

        public static String getOsVersion() {
            String str = Build.VERSION.RELEASE;
            return TextUtils.isEmpty(str) ? XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT : str.replace("_", "-");
        }

        public static int getSDKLevel() {
            return Build.VERSION.SDK_INT;
        }

        @SuppressLint({"ObsoleteSdkInt"})
        public static boolean hasFroyo() {
            return Build.VERSION.SDK_INT >= 8;
        }

        @SuppressLint({"ObsoleteSdkInt"})
        public static boolean hasGingerbread() {
            return Build.VERSION.SDK_INT >= 9;
        }

        @SuppressLint({"ObsoleteSdkInt"})
        public static boolean hasHoneycomb() {
            return Build.VERSION.SDK_INT >= 11;
        }

        @SuppressLint({"ObsoleteSdkInt"})
        public static boolean hasHoneycombMR1() {
            return Build.VERSION.SDK_INT >= 12;
        }

        @SuppressLint({"ObsoleteSdkInt"})
        public static boolean hasICS() {
            return Build.VERSION.SDK_INT >= 14;
        }

        @SuppressLint({"ObsoleteSdkInt"})
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

        public static boolean hasLollipop() {
            return Build.VERSION.SDK_INT >= 21;
        }

        public static boolean hasLollipopMR1() {
            return Build.VERSION.SDK_INT >= 22;
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

        public static boolean hasOreoMR1() {
            return Build.VERSION.SDK_INT >= 27;
        }

        public static boolean hasPie() {
            return Build.VERSION.SDK_INT >= 28;
        }

        public static boolean hasQ() {
            return Build.VERSION.SDK_INT >= 29;
        }

        @SuppressLint({"ObsoleteSdkInt"})
        public static boolean isGingerbread() {
            return Build.VERSION.SDK_INT == 9;
        }

        @SuppressLint({"ObsoleteSdkInt"})
        public static boolean isGingerbreadmr1() {
            return Build.VERSION.SDK_INT == 10;
        }

        public static boolean isKitKat() {
            return Build.VERSION.SDK_INT == 19;
        }

        public static final boolean isLollipop() {
            return Build.VERSION.SDK_INT == 21;
        }
    }

    /* loaded from: classes.dex */
    public static class ScreenInfo {
        public static final int STANDARD_STATUSBAR_HEIGHT = 50;
        public static int originDensityDip;
        public static DisplayMetrics sDisplayMetrics;

        public static int dp2px(@Nullable Context context, float f2) {
            if (context == null) {
                return 0;
            }
            return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
        }

        public static float dp2pxf(@Nullable Context context, float f2) {
            return f2 * getDensity(context);
        }

        public static float getDensity(@Nullable Context context) {
            initDisplayMetrics(context);
            DisplayMetrics displayMetrics = sDisplayMetrics;
            if (displayMetrics != null) {
                return displayMetrics.density;
            }
            return 0.0f;
        }

        public static int getDensityDpi(@Nullable Context context) {
            initDisplayMetrics(context);
            DisplayMetrics displayMetrics = sDisplayMetrics;
            if (displayMetrics != null) {
                return displayMetrics.densityDpi;
            }
            return 0;
        }

        public static int getDisplayHeight(@Nullable Context context) {
            DisplayMetrics displayMetrics = getDisplayMetrics(context);
            if (displayMetrics != null) {
                return displayMetrics.heightPixels;
            }
            return 0;
        }

        public static DisplayMetrics getDisplayMetrics(Context context) {
            if (context == null) {
                return null;
            }
            return context.getResources().getDisplayMetrics();
        }

        public static int getDisplayWidth(@Nullable Context context) {
            DisplayMetrics displayMetrics = getDisplayMetrics(context);
            if (displayMetrics != null) {
                return displayMetrics.widthPixels;
            }
            return 0;
        }

        public static int getNavigationBarHeight() {
            boolean hasPermanentMenuKey = ViewConfiguration.get(AppRuntime.getAppContext()).hasPermanentMenuKey();
            boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
            if (hasPermanentMenuKey || deviceHasKey) {
                return 0;
            }
            Resources resources = AppRuntime.getAppContext().getResources();
            return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
        }

        public static int getRealScreenHeight(@Nullable Context context) {
            if (context == null) {
                return 0;
            }
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                if (OSInfo.hasJellyBeanMR1()) {
                    windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
                    return displayMetrics.heightPixels;
                }
                return getDisplayHeight(context);
            }
            return -1;
        }

        public static int[] getRealScreenSize(@Nullable Context context) {
            int[] iArr = new int[2];
            int displayWidth = getDisplayWidth(context);
            int realScreenHeight = getRealScreenHeight(context);
            if (displayWidth > 0 && realScreenHeight > 0) {
                iArr[0] = displayWidth;
                iArr[1] = realScreenHeight;
            }
            return iArr;
        }

        @SuppressLint({"PrivateApi"})
        public static int getScreenOriginDensityDip() {
            int i2 = originDensityDip;
            if (i2 > 0) {
                return i2;
            }
            try {
                originDensityDip = ((Integer) Class.forName("android.view.IWindowManager").getMethod("getInitialDisplayDensity", Integer.TYPE).invoke(Class.forName("android.view.WindowManagerGlobal").getMethod("getWindowManagerService", new Class[0]).invoke(new Object(), new Object[0]), 0)).intValue();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return originDensityDip;
        }

        public static int getStatusBarHeight() {
            int identifier = AppRuntime.getAppContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
            int i2 = 0;
            if (identifier > 0) {
                try {
                    i2 = AppRuntime.getAppContext().getResources().getDimensionPixelSize(identifier);
                } catch (Exception unused) {
                }
            }
            return i2 == 0 ? (int) (getDensity(null) * 25.0f) : i2;
        }

        public static void initDisplayMetrics(Context context) {
            if (sDisplayMetrics != null || context == null) {
                return;
            }
            sDisplayMetrics = context.getResources().getDisplayMetrics();
        }

        public static boolean isDensityTooLarge(Activity activity) {
            int screenOriginDensityDip;
            if (Build.VERSION.SDK_INT < 24 || activity == null || (screenOriginDensityDip = getScreenOriginDensityDip()) <= 0 || activity.isInMultiWindowMode()) {
                return false;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.density > ((float) screenOriginDensityDip) / 160.0f;
        }

        public static boolean isScreenLand() {
            return AppRuntime.getAppContext().getResources().getConfiguration().orientation == 2;
        }

        public static boolean isScreenPortrait() {
            return AppRuntime.getAppContext().getResources().getConfiguration().orientation == 1;
        }

        public static int px2dp(@Nullable Context context, float f2) {
            if (context == null) {
                return 0;
            }
            return (int) ((f2 / context.getResources().getDisplayMetrics().density) + 0.5f);
        }

        public static float px2dpFloat(@Nullable Context context, float f2) {
            return f2 / getDensity(context);
        }
    }
}
