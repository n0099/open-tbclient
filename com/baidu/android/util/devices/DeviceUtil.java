package com.baidu.android.util.devices;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.android.util.devices.IDevices;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.g;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Locale;
@Deprecated
/* loaded from: classes3.dex */
public class DeviceUtil implements IDevices {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class BrandInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public BrandInfo() {
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

        public static String getDeviceBrand() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? RomUtils.getDeviceBrand() : (String) invokeV.objValue;
        }

        public static String getDeviceModel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? RomUtils.getDeviceModel() : (String) invokeV.objValue;
        }

        public static String getDeviceName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? RomUtils.getDeviceName() : (String) invokeV.objValue;
        }

        public static String getManufacturer() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? RomUtils.getManufacturer() : (String) invokeV.objValue;
        }

        public static boolean isMagicBoxDevice() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? RomUtils.isMagicBoxDevice() : invokeV.booleanValue;
        }

        public static boolean isMiBox2Device() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? RomUtils.isMiBox2Device() : invokeV.booleanValue;
        }

        @Deprecated
        public static boolean isProblemBoxDevice() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? isMiBox2Device() || isMagicBoxDevice() : invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class CPUInfo {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String FEATURE_COMMON = "common";
        public static final String FEATURE_NEON = "neon";
        public static final String FEATURE_VFP = "vfp";
        public static final String PREFIX_FEATURES = "features";
        public static final String PREFIX_PROCESSOR = "processor";
        public static final String PROCESSOR_ARMV5 = "armv5";
        public static final String PROCESSOR_ARMV6 = "armv6";
        public static final String PROCESSOR_ARMV7 = "armv7";
        public static final String PROCESSOR_X86 = "x86";
        public static IDevices.ARCH sArch;
        public static CPUInfo systemCPUInfo;
        public transient /* synthetic */ FieldHolder $fh;
        public String features;
        public String processor;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(791729184, "Lcom/baidu/android/util/devices/DeviceUtil$CPUInfo;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(791729184, "Lcom/baidu/android/util/devices/DeviceUtil$CPUInfo;");
                    return;
                }
            }
            sArch = IDevices.ARCH.Unknown;
        }

        public CPUInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.processor = "";
            this.features = "";
        }

        public static String getCpuArchInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? DeviceUtils.CPUInfo.getCpuArchInfo() : (String) invokeV.objValue;
        }

        public static synchronized IDevices.ARCH getMyCpuArch() {
            InterceptResult invokeV;
            IDevices.ARCH cpuArch;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                synchronized (CPUInfo.class) {
                    cpuArch = DeviceUtils.CPUInfo.getCpuArch();
                }
                return cpuArch;
            }
            return (IDevices.ARCH) invokeV.objValue;
        }

        public static String getPreferredABI() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? DeviceUtils.CPUInfo.getPreferredABI() : (String) invokeV.objValue;
        }

        public static CPUInfo getSystemCPUInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
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
            return (CPUInfo) invokeV.objValue;
        }

        @Deprecated
        public static String get_CPU_ABI() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? Build.CPU_ABI : (String) invokeV.objValue;
        }

        @Deprecated
        public static String get_CPU_ABI2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
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
                } catch (Exception unused) {
                    return null;
                }
            }
            return (String) invokeV.objValue;
        }

        public static boolean isARMSimulatedByX86() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
                return !supportX86() && IDevices.ARCH.X86.equals(getMyCpuArch());
            }
            return invokeV.booleanValue;
        }

        public static boolean isRealARMArch() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
                return (supportABI("armeabi-v7a") || supportABI("armeabi")) && IDevices.ARCH.ARM.equals(getMyCpuArch());
            }
            return invokeV.booleanValue;
        }

        public static boolean isRealX86Arch() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
                return supportABI("x86") || IDevices.ARCH.X86.equals(getMyCpuArch());
            }
            return invokeV.booleanValue;
        }

        public static boolean supportABI(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
                String _cpu_abi = get_CPU_ABI();
                if (TextUtils.isEmpty(_cpu_abi) || !_cpu_abi.equalsIgnoreCase(str)) {
                    return !TextUtils.isEmpty(get_CPU_ABI2()) && _cpu_abi.equalsIgnoreCase(str);
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public static boolean supportMips() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? supportABI(IDevices.ABI_MIPS) : invokeV.booleanValue;
        }

        public static boolean supportX86() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? supportABI("x86") : invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class OSInfo {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int KITKAT = 19;
        public static final int LOLLIPOP = 21;
        public static final int LOLLIPOP_MR1 = 22;
        public static final int MARSHMALLOW = 23;
        public static final int Nougat = 24;
        public static final int NougatPlus = 25;
        public transient /* synthetic */ FieldHolder $fh;

        public OSInfo() {
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

        public static String getOS() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? "Android" : (String) invokeV.objValue;
        }

        public static String getOsVersion() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? DeviceUtils.OSInfo.getOsVersion() : (String) invokeV.objValue;
        }

        public static int getSDKLevel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? DeviceUtils.OSInfo.getSDKLevel() : invokeV.intValue;
        }

        public static boolean hasFroyo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? DeviceUtils.OSInfo.hasFroyo() : invokeV.booleanValue;
        }

        public static boolean hasGingerbread() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? DeviceUtils.OSInfo.hasGingerbread() : invokeV.booleanValue;
        }

        public static boolean hasHoneycomb() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? DeviceUtils.OSInfo.hasHoneycomb() : invokeV.booleanValue;
        }

        public static boolean hasHoneycombMR1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? DeviceUtils.OSInfo.hasHoneycombMR1() : invokeV.booleanValue;
        }

        public static boolean hasICS() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? DeviceUtils.OSInfo.hasICS() : invokeV.booleanValue;
        }

        public static boolean hasICSMR1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? DeviceUtils.OSInfo.hasICSMR1() : invokeV.booleanValue;
        }

        public static boolean hasJellyBean() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? DeviceUtils.OSInfo.hasJellyBean() : invokeV.booleanValue;
        }

        public static boolean hasJellyBeanMR1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? DeviceUtils.OSInfo.hasJellyBeanMR1() : invokeV.booleanValue;
        }

        public static boolean hasJellyBeanMR2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? DeviceUtils.OSInfo.hasJellyBeanMR2() : invokeV.booleanValue;
        }

        public static boolean hasKitKat() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? DeviceUtils.OSInfo.hasKitKat() : invokeV.booleanValue;
        }

        public static boolean hasLollipop() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? DeviceUtils.OSInfo.hasLollipop() : invokeV.booleanValue;
        }

        public static boolean hasLollipopMR1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? DeviceUtils.OSInfo.hasLollipopMR1() : invokeV.booleanValue;
        }

        public static boolean hasMarshMallow() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? DeviceUtils.OSInfo.hasMarshMallow() : invokeV.booleanValue;
        }

        public static boolean hasNougat() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? DeviceUtils.OSInfo.hasNougat() : invokeV.booleanValue;
        }

        public static boolean hasNougatMR1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? DeviceUtils.OSInfo.hasNougatMR1() : invokeV.booleanValue;
        }

        public static boolean hasOreo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? DeviceUtils.OSInfo.hasOreo() : invokeV.booleanValue;
        }

        public static boolean isGingerbread() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? DeviceUtils.OSInfo.isGingerbread() : invokeV.booleanValue;
        }

        public static boolean isGingerbreadmr1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? DeviceUtils.OSInfo.isGingerbreadmr1() : invokeV.booleanValue;
        }

        public static boolean isKitKat() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) ? DeviceUtils.OSInfo.isKitKat() : invokeV.booleanValue;
        }

        public static final boolean isLollipop() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) ? DeviceUtils.OSInfo.isLollipop() : invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class ScreenInfo {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int STANDARD_STATUSBAR_HEIGHT = 50;
        public static int originDensityDip;
        public static DisplayMetrics sDisplayMetrics;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1793929926, "Lcom/baidu/android/util/devices/DeviceUtil$ScreenInfo;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1793929926, "Lcom/baidu/android/util/devices/DeviceUtil$ScreenInfo;");
            }
        }

        public ScreenInfo() {
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

        public static int dp2px(@Nullable Context context, float f2) {
            InterceptResult invokeLF;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLF = interceptable.invokeLF(65538, null, context, f2)) == null) ? (int) ((f2 * AppRuntime.getAppContext().getResources().getDisplayMetrics().density) + 0.5f) : invokeLF.intValue;
        }

        public static float dp2pxf(@Nullable Context context, float f2) {
            InterceptResult invokeLF;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLF = interceptable.invokeLF(65539, null, context, f2)) == null) ? f2 * getDensity(AppRuntime.getAppContext()) : invokeLF.floatValue;
        }

        public static float getDensity(@Nullable Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
                initDisplayMetrics(AppRuntime.getAppContext());
                DisplayMetrics displayMetrics = sDisplayMetrics;
                if (displayMetrics != null) {
                    return displayMetrics.density;
                }
                return 0.0f;
            }
            return invokeL.floatValue;
        }

        public static int getDensityDpi(@Nullable Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
                initDisplayMetrics(AppRuntime.getAppContext());
                DisplayMetrics displayMetrics = sDisplayMetrics;
                if (displayMetrics != null) {
                    return displayMetrics.densityDpi;
                }
                return 0;
            }
            return invokeL.intValue;
        }

        public static int getDisplayHeight(@Nullable Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
                DisplayMetrics displayMetrics = getDisplayMetrics(AppRuntime.getAppContext());
                if (displayMetrics != null) {
                    return displayMetrics.heightPixels;
                }
                return 0;
            }
            return invokeL.intValue;
        }

        public static DisplayMetrics getDisplayMetrics(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
                Context appContext = AppRuntime.getAppContext();
                if (appContext == null) {
                    return null;
                }
                return appContext.getResources().getDisplayMetrics();
            }
            return (DisplayMetrics) invokeL.objValue;
        }

        public static int getDisplayWidth(@Nullable Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
                DisplayMetrics displayMetrics = getDisplayMetrics(AppRuntime.getAppContext());
                if (displayMetrics != null) {
                    return displayMetrics.widthPixels;
                }
                return 0;
            }
            return invokeL.intValue;
        }

        public static int getNavigationBarHeight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? DeviceUtils.ScreenInfo.getNavigationBarHeight() : invokeV.intValue;
        }

        public static int getRealScreenHeight(@Nullable Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
                WindowManager windowManager = (WindowManager) AppRuntime.getAppContext().getSystemService("window");
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
            return invokeL.intValue;
        }

        @Deprecated
        public static String getRealScreenSize(@Nullable Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
                int displayWidth = getDisplayWidth(context);
                int realScreenHeight = getRealScreenHeight(context);
                if (displayWidth <= 0 || realScreenHeight <= 0) {
                    return "";
                }
                return displayWidth + "_" + realScreenHeight;
            }
            return (String) invokeL.objValue;
        }

        public static int getScreenOriginDensityDip() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? DeviceUtils.ScreenInfo.getScreenOriginDensityDip() : invokeV.intValue;
        }

        public static int getStatusBarHeight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? DeviceUtils.ScreenInfo.getStatusBarHeight() : invokeV.intValue;
        }

        public static void initDisplayMetrics(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65550, null, context) == null) {
                Context appContext = AppRuntime.getAppContext();
                if (sDisplayMetrics == null) {
                    if (appContext != null) {
                        context = appContext;
                    }
                    if (context == null) {
                        return;
                    }
                    sDisplayMetrics = context.getResources().getDisplayMetrics();
                }
            }
        }

        public static boolean isDensityTooLarge(Activity activity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, activity)) == null) ? DeviceUtils.ScreenInfo.isDensityTooLarge(activity) : invokeL.booleanValue;
        }

        public static boolean isScreenLand() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? DeviceUtils.ScreenInfo.isScreenLand() : invokeV.booleanValue;
        }

        public static boolean isScreenPortrait() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? DeviceUtils.ScreenInfo.isScreenPortrait() : invokeV.booleanValue;
        }

        public static int px2dp(@Nullable Context context, float f2) {
            InterceptResult invokeLF;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLF = interceptable.invokeLF(65554, null, context, f2)) == null) ? (int) ((f2 / AppRuntime.getAppContext().getResources().getDisplayMetrics().density) + 0.5f) : invokeLF.intValue;
        }

        @Deprecated
        public static float px2dpFloat(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeF = interceptable.invokeF(65555, null, f2)) == null) ? f2 / getDensity(AppRuntime.getAppContext()) : invokeF.floatValue;
        }
    }

    public DeviceUtil() {
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

    public static boolean isHonorFoldableDevice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if ("HONOR".equalsIgnoreCase(Build.MANUFACTURER) && AppRuntime.getAppContext().getPackageManager().hasSystemFeature("com.hihonor.hardware.sensor.posture")) {
                return true;
            }
            return isHonorSpecifiedDevice();
        }
        return invokeV.booleanValue;
    }

    public static boolean isHonorSpecifiedDevice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? "HONOR".equalsIgnoreCase(Build.MANUFACTURER) && "HNMGI".equalsIgnoreCase(Build.DEVICE) && ("DIA-AN00".equalsIgnoreCase(Build.MODEL) || "MGI-AN00".equalsIgnoreCase(Build.MODEL)) : invokeV.booleanValue;
    }

    public static boolean isHwFoldableDevice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? "HUAWEI".equalsIgnoreCase(Build.MANUFACTURER) && AppRuntime.getAppContext().getPackageManager().hasSystemFeature("com.huawei.hardware.sensor.posture") : invokeV.booleanValue;
    }

    public static boolean isInMagicWindow(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (context == null) {
                return false;
            }
            String configuration = context.getResources().getConfiguration().toString();
            if (TextUtils.isEmpty(configuration)) {
                return false;
            }
            return configuration.contains("hw-magic-windows");
        }
        return invokeL.booleanValue;
    }

    public static boolean isMateX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            String[] strArr = {"RLI-AN00", "RLI-N29", "TAH-AN00", "TAH-N29", "TAH-AN00m", "RHA-AN00m", "TET-AN00"};
            if ("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) {
                for (int i2 = 0; i2 < 7; i2++) {
                    if (strArr[i2].equalsIgnoreCase(Build.MODEL)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isOppoFoldableDevice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return AppRuntime.getAppContext().getPackageManager().hasSystemFeature("oplus.feature.largescreen") || AppRuntime.getAppContext().getPackageManager().hasSystemFeature("oplus.feature.largescreen.land");
        }
        return invokeV.booleanValue;
    }

    public static boolean isSamSungFolded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (TextUtils.isEmpty(Build.MODEL)) {
                return false;
            }
            String[] strArr = {"SM-F9000", "SM-F9160"};
            if (g.f53624j.equalsIgnoreCase(Build.MANUFACTURER)) {
                for (int i2 = 0; i2 < 2; i2++) {
                    if (strArr[i2].equalsIgnoreCase(Build.MODEL)) {
                        return true;
                    }
                }
                if (Build.MODEL.startsWith("SM-F") || Build.MODEL.startsWith("SM-W")) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isSupportFoldable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? isMateX() || isHwFoldableDevice() || isSamSungFolded() || isHonorFoldableDevice() || isOppoFoldableDevice() || isVIVOFoldableDevice() : invokeV.booleanValue;
    }

    public static boolean isVIVOFoldableDevice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if ("VIVO".equalsIgnoreCase(RomUtils.getManufacturer())) {
                try {
                    return TextUtils.equals("foldable", (String) Class.forName("android.util.FtDeviceInfo").getMethod("getDeviceType", new Class[0]).invoke(null, new Object[0]));
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
