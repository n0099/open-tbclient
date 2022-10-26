package com.baidu.searchbox.aperf.param.util;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes2.dex */
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-353160652, "Lcom/baidu/searchbox/aperf/param/util/CpuInfoUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-353160652, "Lcom/baidu/searchbox/aperf/param/util/CpuInfoUtils;");
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static float getAveCpuFrequency() {
        InterceptResult invokeV;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            int numCores = getNumCores();
            int i = 0;
            if (numCores > 0) {
                int i2 = 0;
                f = 0.0f;
                while (i < numCores) {
                    float singleCpuFrequency = getSingleCpuFrequency(getCpuInfoFilePath(i));
                    if (singleCpuFrequency > 0.0f) {
                        f += singleCpuFrequency;
                        i2++;
                    }
                    i++;
                }
                i = i2;
            } else {
                f = 0.0f;
            }
            if (i > 0 && f > 0.0f) {
                return f / i;
            }
            return -1.0f;
        }
        return invokeV.floatValue;
    }

    public static float getMaxCpuFrequency() {
        InterceptResult invokeV;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            int numCores = getNumCores();
            if (numCores > 0) {
                f = 0.0f;
                for (int i = 0; i < numCores; i++) {
                    float singleCpuFrequency = getSingleCpuFrequency(getCpuInfoFilePath(i));
                    if (singleCpuFrequency > 0.0f && singleCpuFrequency > f) {
                        f = singleCpuFrequency;
                    }
                }
            } else {
                f = 0.0f;
            }
            if (f <= 0.0f) {
                return -1.0f;
            }
            return f;
        }
        return invokeV.floatValue;
    }

    public static int getNumCores() {
        InterceptResult invokeV;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            FileFilter fileFilter = new FileFilter() { // from class: com.baidu.searchbox.aperf.param.util.CpuInfoUtils.1
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
                        }
                    }
                }

                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file)) == null) {
                        return Pattern.matches("cpu[0-9]", file.getName());
                    }
                    return invokeL.booleanValue;
                }
            };
            if (sCoreNum <= 0) {
                try {
                    File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(fileFilter);
                    if (listFiles == null) {
                        length = -1;
                    } else {
                        length = listFiles.length;
                    }
                    sCoreNum = length;
                } catch (Exception e) {
                    if (DEBUG) {
                        Log.e(TAG, "getNumCores exception occurred, e= ", e);
                    }
                    sCoreNum = -1;
                }
            }
            return sCoreNum;
        }
        return invokeV.intValue;
    }

    public static String getCpuInfoFilePath(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            return "/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_max_freq";
        }
        return (String) invokeI.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static float getSingleCpuFrequency(String str) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Throwable th;
        BufferedReader bufferedReader;
        Exception e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            try {
                fileInputStream = new FileInputStream(new File(str));
            } catch (Exception e2) {
                fileInputStream = null;
                e = e2;
                bufferedReader = null;
            } catch (Throwable th2) {
                fileInputStream = null;
                th = th2;
                bufferedReader = null;
            }
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                try {
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
                    } catch (Exception e3) {
                        e = e3;
                        if (DEBUG) {
                            Log.e(TAG, "getCpuFrequency Exception occurred, e=", e);
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused4) {
                            }
                        }
                        return -1.0f;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused5) {
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused6) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                bufferedReader = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                if (fileInputStream != null) {
                }
                if (bufferedReader != null) {
                }
                throw th;
            }
        } else {
            return invokeL.floatValue;
        }
    }
}
