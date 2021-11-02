package com.baidu.searchbox.logsystem.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public class CpuInfoUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CPU_INFO_DIR = "/sys/devices/system/cpu/";
    public static final boolean DEBUG;
    public static final int INVALID_VALUE = -1;
    public static final String TAG = "CpuInfoUtils";
    public static int sCoreNum;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1761793687, "Lcom/baidu/searchbox/logsystem/util/CpuInfoUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1761793687, "Lcom/baidu/searchbox/logsystem/util/CpuInfoUtils;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
        sCoreNum = -1;
    }

    public CpuInfoUtils() {
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

    public static float getAveCpuFrequency() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            int i2 = 0;
            float f2 = 0.0f;
            for (int i3 = 0; i3 < getNumCores(); i3++) {
                float singleCpuFrequency = getSingleCpuFrequency(getCpuInfoFilePath(i3));
                if (singleCpuFrequency > 0.0f) {
                    f2 += singleCpuFrequency;
                    i2++;
                }
            }
            if (i2 > 0) {
                return f2 / i2;
            }
            return -1.0f;
        }
        return invokeV.floatValue;
    }

    public static String getCpuInfoFilePath(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            return "/sys/devices/system/cpu/cpu" + i2 + "/cpufreq/cpuinfo_max_freq";
        }
        return (String) invokeI.objValue;
    }

    public static int getNumCores() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            FileFilter fileFilter = new FileFilter() { // from class: com.baidu.searchbox.logsystem.util.CpuInfoUtils.1
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
            };
            if (sCoreNum <= 0) {
                try {
                    File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(fileFilter);
                    sCoreNum = listFiles == null ? -1 : listFiles.length;
                } catch (Exception unused) {
                    boolean z = DEBUG;
                    sCoreNum = -1;
                }
            }
            return sCoreNum;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static float getSingleCpuFrequency(String str) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Throwable th;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) != null) {
            return invokeL.floatValue;
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                try {
                    float parseLong = (((float) Long.parseLong(bufferedReader.readLine())) / 1000.0f) / 1000.0f;
                    try {
                        fileInputStream.close();
                    } catch (IOException unused) {
                    }
                    try {
                        bufferedReader.close();
                    } catch (IOException unused2) {
                    }
                    return parseLong;
                } catch (Exception unused3) {
                    fileInputStream2 = fileInputStream;
                    try {
                        boolean z = DEBUG;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException unused4) {
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused5) {
                            }
                        }
                        return -1.0f;
                    } catch (Throwable th2) {
                        fileInputStream = fileInputStream2;
                        th = th2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused6) {
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused7) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (fileInputStream != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    throw th;
                }
            } catch (Exception unused8) {
                bufferedReader = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
            }
        } catch (Exception unused9) {
            bufferedReader = null;
        } catch (Throwable th5) {
            fileInputStream = null;
            th = th5;
            bufferedReader = null;
        }
    }
}
