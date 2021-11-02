package com.baidu.down.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public final class DeviceInfoUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String SF_FILENAME = "device_info_shared_f";
    public static final String SF_KEY_CPU_CORES = "cpu_cores";
    public static final String SF_KEY_CPU_FREQ = "cpu_freq";
    public static final String TAG = "DeviceInfoUtils";
    public transient /* synthetic */ FieldHolder $fh;

    public DeviceInfoUtils() {
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

    public static int getCpuCores() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                return new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.baidu.down.utils.DeviceInfoUtils.1CpuFilter
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    @Override // java.io.FileFilter
                    public boolean accept(File file) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file)) == null) ? Pattern.matches("cpu[0-9]", file.getName()) : invokeL.booleanValue;
                    }
                }).length;
            } catch (Exception unused) {
                return 1;
            }
        }
        return invokeV.intValue;
    }

    public static int getCpuCoresWithCache(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(SF_FILENAME, 0);
            int i2 = sharedPreferences.getInt(SF_KEY_CPU_CORES, 0);
            if (i2 == 0) {
                int cpuCores = getCpuCores();
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putInt(SF_KEY_CPU_CORES, cpuCores);
                edit.commit();
                return cpuCores;
            }
            return i2;
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0040, code lost:
        if (r0 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0047, code lost:
        if (r0 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004a, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long getCpuFreq() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65539, null)) != null) {
            return invokeV.longValue;
        }
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq").start().getInputStream()));
            try {
                long parseLong = Long.parseLong(bufferedReader.readLine());
                try {
                    bufferedReader.close();
                    return parseLong;
                } catch (IOException unused) {
                    return parseLong;
                }
            } catch (IOException unused2) {
                bufferedReader2 = bufferedReader;
            } catch (NumberFormatException unused3) {
                bufferedReader2 = bufferedReader;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (IOException unused5) {
        } catch (NumberFormatException unused6) {
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    public static long getCpuFreqWithCache(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(SF_FILENAME, 0);
            long j = sharedPreferences.getLong(SF_KEY_CPU_FREQ, -1L);
            if (j == -1) {
                long cpuFreq = getCpuFreq();
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putLong(SF_KEY_CPU_FREQ, cpuFreq);
                edit.commit();
                return cpuFreq;
            }
            return j;
        }
        return invokeL.longValue;
    }

    public static String getCut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            String str = Build.MODEL;
            String str2 = Build.VERSION.RELEASE;
            int i2 = Build.VERSION.SDK_INT;
            String str3 = Build.MANUFACTURER;
            return str.replace("_", "-") + "_" + str2.replace("_", "-") + "_" + i2 + "_" + str3.replace("_", "-");
        }
        return (String) invokeV.objValue;
    }
}
