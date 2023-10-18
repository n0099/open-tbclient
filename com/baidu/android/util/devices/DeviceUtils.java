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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.IDevices;
import com.baidu.mobads.sdk.internal.cj;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import com.kuaishou.weapon.p0.k1;
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
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean isSupportPreviewWhenClipCopy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes.dex */
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-389021377, "Lcom/baidu/android/util/devices/DeviceUtils$CPUInfo;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-389021377, "Lcom/baidu/android/util/devices/DeviceUtils$CPUInfo;");
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                String lowerCase = System.getProperty("os.arch").toLowerCase(Locale.getDefault());
                if (lowerCase != null && lowerCase.length() != 0) {
                    return lowerCase;
                }
                return null;
            }
            return (String) invokeV.objValue;
        }

        public static boolean isARMSimulatedByX86() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
                IDevices.ARCH cpuArch = getCpuArch();
                if (!supportX86() && IDevices.ARCH.X86.equals(cpuArch)) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public static boolean isRealX86Arch() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
                IDevices.ARCH cpuArch = getCpuArch();
                if (!supportABI("x86") && !IDevices.ARCH.X86.equals(cpuArch)) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public static boolean supportMips() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
                return supportABI(IDevices.ABI_MIPS);
            }
            return invokeV.booleanValue;
        }

        public static boolean supportX86() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
                return supportABI("x86");
            }
            return invokeV.booleanValue;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x0068 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:43:0x0074 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:71:0x001d */
        /* JADX DEBUG: Multi-variable search result rejected for r3v8, resolved type: java.io.RandomAccessFile */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v12 */
        /* JADX WARN: Type inference failed for: r3v13 */
        /* JADX WARN: Type inference failed for: r3v14 */
        /* JADX WARN: Type inference failed for: r3v15 */
        /* JADX WARN: Type inference failed for: r3v16 */
        public static synchronized IDevices.ARCH getCpuArch() {
            InterceptResult invokeV;
            RandomAccessFile randomAccessFile;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                synchronized (CPUInfo.class) {
                    byte[] bArr = new byte[20];
                    File file = new File(Environment.getRootDirectory(), "lib/libc.so");
                    if (file.canRead()) {
                        RandomAccessFile randomAccessFile2 = null;
                        try {
                            try {
                                randomAccessFile = new RandomAccessFile(file, "r");
                            } catch (Throwable th) {
                                th = th;
                            }
                        } catch (FileNotFoundException e) {
                            e = e;
                        } catch (IOException e2) {
                            e = e2;
                        }
                        try {
                            randomAccessFile.readFully(bArr);
                            randomAccessFile2 = 8;
                            int i = bArr[18] | (bArr[19] << 8);
                            if (i != 3) {
                                if (i != 8) {
                                    if (i != 40) {
                                        if (i == 183) {
                                            sArch = IDevices.ARCH.ARM64;
                                        }
                                    } else {
                                        sArch = IDevices.ARCH.ARM;
                                    }
                                } else {
                                    sArch = IDevices.ARCH.MIPS;
                                }
                            } else {
                                sArch = IDevices.ARCH.X86;
                            }
                            try {
                                randomAccessFile.close();
                            } catch (IOException e3) {
                                e = e3;
                                e.printStackTrace();
                                return sArch;
                            }
                        } catch (FileNotFoundException e4) {
                            e = e4;
                            randomAccessFile2 = randomAccessFile;
                            e.printStackTrace();
                            randomAccessFile2 = randomAccessFile2;
                            if (randomAccessFile2 != null) {
                                try {
                                    randomAccessFile2.close();
                                    randomAccessFile2 = randomAccessFile2;
                                } catch (IOException e5) {
                                    e = e5;
                                    e.printStackTrace();
                                    return sArch;
                                }
                            }
                            return sArch;
                        } catch (IOException e6) {
                            e = e6;
                            randomAccessFile2 = randomAccessFile;
                            e.printStackTrace();
                            randomAccessFile2 = randomAccessFile2;
                            if (randomAccessFile2 != null) {
                                try {
                                    randomAccessFile2.close();
                                    randomAccessFile2 = randomAccessFile2;
                                } catch (IOException e7) {
                                    e = e7;
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
                                } catch (IOException e8) {
                                    e8.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                }
                return sArch;
            }
            return (IDevices.ARCH) invokeV.objValue;
        }

        public static String getPreferredABI() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
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
            return (String) invokeV.objValue;
        }

        public static boolean isRealARMArch() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
                IDevices.ARCH cpuArch = getCpuArch();
                if ((supportABI(PassBiometricUtil.CPU_TYPE_ARMEABI_V7A) || supportABI("armeabi")) && IDevices.ARCH.ARM.equals(cpuArch)) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public static String[] getSupportedABIs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    return Build.SUPPORTED_ABIS;
                }
                ArrayList arrayList = new ArrayList(Arrays.asList(Build.CPU_ABI, Build.CPU_ABI2));
                arrayList.removeAll(Arrays.asList(null, ""));
                return (String[]) arrayList.toArray(new String[0]);
            }
            return (String[]) invokeV.objValue;
        }

        public static CPUInfo getSystemCPUInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
                CPUInfo cPUInfo = systemCPUInfo;
                if (cPUInfo != null) {
                    return cPUInfo;
                }
                CPUInfo cPUInfo2 = new CPUInfo();
                try {
                    FileReader fileReader = new FileReader(k1.a);
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
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                if (Build.CPU_ABI.equalsIgnoreCase("x86")) {
                    cPUInfo2.processor = "x86";
                }
                systemCPUInfo = cPUInfo2;
                return cPUInfo2;
            }
            return (CPUInfo) invokeV.objValue;
        }

        public static boolean supportABI(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
                for (String str2 : getSupportedABIs()) {
                    if (str2.equalsIgnoreCase(str)) {
                        return true;
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static class OSInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String getOS() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? "Android" : (String) invokeV.objValue;
        }

        public OSInfo() {
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

        public static String getOsVersion() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                String str = Build.VERSION.RELEASE;
                if (TextUtils.isEmpty(str)) {
                    return cj.d;
                }
                return str.replace("_", "-");
            }
            return (String) invokeV.objValue;
        }

        public static int getSDKLevel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return Build.VERSION.SDK_INT;
            }
            return invokeV.intValue;
        }

        @SuppressLint({"ObsoleteSdkInt"})
        public static boolean hasFroyo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                if (Build.VERSION.SDK_INT >= 8) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @SuppressLint({"ObsoleteSdkInt"})
        public static boolean hasGingerbread() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
                if (Build.VERSION.SDK_INT >= 9) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @SuppressLint({"ObsoleteSdkInt"})
        public static boolean hasHoneycomb() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
                if (Build.VERSION.SDK_INT >= 11) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @SuppressLint({"ObsoleteSdkInt"})
        public static boolean hasHoneycombMR1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
                if (Build.VERSION.SDK_INT >= 12) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @SuppressLint({"ObsoleteSdkInt"})
        public static boolean hasICS() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
                if (Build.VERSION.SDK_INT >= 14) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @SuppressLint({"ObsoleteSdkInt"})
        public static boolean hasICSMR1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
                if (Build.VERSION.SDK_INT >= 15) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public static boolean hasJellyBean() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
                if (Build.VERSION.SDK_INT >= 16) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public static boolean hasJellyBeanMR1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
                if (Build.VERSION.SDK_INT >= 17) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public static boolean hasJellyBeanMR2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
                if (Build.VERSION.SDK_INT >= 18) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public static boolean hasKitKat() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public static boolean hasLollipop() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public static boolean hasLollipopMR1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
                if (Build.VERSION.SDK_INT >= 22) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public static boolean hasMarshMallow() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
                if (Build.VERSION.SDK_INT >= 23) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public static boolean hasNougat() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public static boolean hasNougatMR1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
                if (Build.VERSION.SDK_INT >= 25) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public static boolean hasOreo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
                if (Build.VERSION.SDK_INT >= 26) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public static boolean hasOreoMR1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
                if (Build.VERSION.SDK_INT >= 27) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public static boolean hasPie() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public static boolean hasQ() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
                if (Build.VERSION.SDK_INT >= 29) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public static boolean hasTiramisu() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
                if (Build.VERSION.SDK_INT >= 33) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @SuppressLint({"ObsoleteSdkInt"})
        public static boolean isGingerbread() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
                if (Build.VERSION.SDK_INT == 9) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @SuppressLint({"ObsoleteSdkInt"})
        public static boolean isGingerbreadmr1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
                if (Build.VERSION.SDK_INT == 10) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public static boolean isKitKat() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
                if (Build.VERSION.SDK_INT == 19) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public static final boolean isLollipop() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
                if (Build.VERSION.SDK_INT == 21) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static class ScreenInfo {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int STANDARD_STATUSBAR_HEIGHT = 50;
        public static int originDensityDip;
        public static DisplayMetrics sDisplayMetrics;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1836121415, "Lcom/baidu/android/util/devices/DeviceUtils$ScreenInfo;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1836121415, "Lcom/baidu/android/util/devices/DeviceUtils$ScreenInfo;");
            }
        }

        public ScreenInfo() {
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

        public static boolean isScreenLand() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
                if (AppRuntime.getAppContext().getResources().getConfiguration().orientation == 2) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public static boolean isScreenPortrait() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
                if (AppRuntime.getAppContext().getResources().getConfiguration().orientation == 1) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public static int dp2px(@Nullable Context context, float f) {
            InterceptResult invokeLF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLF = interceptable.invokeLF(65538, null, context, f)) == null) {
                if (context == null) {
                    return 0;
                }
                return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
            }
            return invokeLF.intValue;
        }

        public static float dp2pxf(@Nullable Context context, float f) {
            InterceptResult invokeLF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLF = interceptable.invokeLF(65539, null, context, f)) == null) {
                return f * getDensity(context);
            }
            return invokeLF.floatValue;
        }

        public static int px2dp(@Nullable Context context, float f) {
            InterceptResult invokeLF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLF = interceptable.invokeLF(65554, null, context, f)) == null) {
                if (context == null) {
                    return 0;
                }
                return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
            }
            return invokeLF.intValue;
        }

        public static float px2dpFloat(@Nullable Context context, float f) {
            InterceptResult invokeLF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLF = interceptable.invokeLF(65555, null, context, f)) == null) {
                return f / getDensity(context);
            }
            return invokeLF.floatValue;
        }

        public static float getDensity(@Nullable Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
                initDisplayMetrics(context);
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
                initDisplayMetrics(context);
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
                DisplayMetrics displayMetrics = getDisplayMetrics(context);
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
                if (context == null) {
                    return null;
                }
                return context.getResources().getDisplayMetrics();
            }
            return (DisplayMetrics) invokeL.objValue;
        }

        public static int getDisplayWidth(@Nullable Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
                DisplayMetrics displayMetrics = getDisplayMetrics(context);
                if (displayMetrics != null) {
                    return displayMetrics.widthPixels;
                }
                return 0;
            }
            return invokeL.intValue;
        }

        public static int[] getRealScreenSize(@Nullable Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
                int[] iArr = new int[2];
                int displayWidth = getDisplayWidth(context);
                int realScreenHeight = getRealScreenHeight(context);
                if (displayWidth > 0 && realScreenHeight > 0) {
                    iArr[0] = displayWidth;
                    iArr[1] = realScreenHeight;
                }
                return iArr;
            }
            return (int[]) invokeL.objValue;
        }

        public static void initDisplayMetrics(Context context) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(65550, null, context) != null) || sDisplayMetrics != null || context == null) {
                return;
            }
            sDisplayMetrics = context.getResources().getDisplayMetrics();
        }

        public static int getNavigationBarHeight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
                boolean hasPermanentMenuKey = ViewConfiguration.get(AppRuntime.getAppContext()).hasPermanentMenuKey();
                boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
                if (!hasPermanentMenuKey && !deviceHasKey) {
                    Resources resources = AppRuntime.getAppContext().getResources();
                    return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", EMABTest.TYPE_DIMEN, "android"));
                }
                return 0;
            }
            return invokeV.intValue;
        }

        public static int getStatusBarHeight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
                int identifier = AppRuntime.getAppContext().getResources().getIdentifier("status_bar_height", EMABTest.TYPE_DIMEN, "android");
                int i = 0;
                if (identifier > 0) {
                    try {
                        i = AppRuntime.getAppContext().getResources().getDimensionPixelSize(identifier);
                    } catch (Exception unused) {
                    }
                }
                if (i == 0) {
                    return (int) (getDensity(null) * 25.0f);
                }
                return i;
            }
            return invokeV.intValue;
        }

        public static int getRealScreenHeight(@Nullable Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
                if (context == null) {
                    return 0;
                }
                WindowManager windowManager = (WindowManager) context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
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
            return invokeL.intValue;
        }

        public static boolean isDensityTooLarge(Activity activity) {
            InterceptResult invokeL;
            int screenOriginDensityDip;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, activity)) == null) {
                if (Build.VERSION.SDK_INT < 24 || activity == null || (screenOriginDensityDip = getScreenOriginDensityDip()) <= 0 || activity.isInMultiWindowMode()) {
                    return false;
                }
                DisplayMetrics displayMetrics = new DisplayMetrics();
                activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                if (displayMetrics.density <= screenOriginDensityDip / 160.0f) {
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @SuppressLint({"PrivateApi"})
        public static int getScreenOriginDensityDip() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
                int i = originDensityDip;
                if (i > 0) {
                    return i;
                }
                try {
                    originDensityDip = ((Integer) Class.forName("android.view.IWindowManager").getMethod("getInitialDisplayDensity", Integer.TYPE).invoke(Class.forName("android.view.WindowManagerGlobal").getMethod("getWindowManagerService", new Class[0]).invoke(new Object(), new Object[0]), 0)).intValue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return originDensityDip;
            }
            return invokeV.intValue;
        }
    }

    public DeviceUtils() {
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

    @SuppressLint({"PrivateApi"})
    public static String getHarmonyVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
                return (String) cls.getDeclaredMethod(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, String.class).invoke(cls, "hw_sc.build.os.version");
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static boolean isHarmonyOS(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                int identifier = Resources.getSystem().getIdentifier("config_os_brand", EMABTest.TYPE_STRING, "android");
                if (identifier != 0) {
                    return context.getString(identifier).equals("harmony");
                }
            } catch (Exception unused) {
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
