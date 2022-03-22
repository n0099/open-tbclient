package com.baidu.searchbox.aideviceperformance.utils;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.SevenZipUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class HardwareInfoUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CPU_INFO_DIR = "/sys/devices/system/cpu/";
    public static final boolean DEBUG;
    public static final int INVALID_VALUE = -1;
    public static final String MEM_INFO_FILE = "/proc/meminfo";
    public static final String TAG = "HardwareInfoUtil";
    public static int sCoreNum;
    public static float sTotalMemory;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(96250037, "Lcom/baidu/searchbox/aideviceperformance/utils/HardwareInfoUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(96250037, "Lcom/baidu/searchbox/aideviceperformance/utils/HardwareInfoUtils;");
                return;
            }
        }
        DEBUG = Config.isDebug();
        sCoreNum = -1;
        sTotalMemory = -1.0f;
    }

    public HardwareInfoUtils() {
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

    public static float[] getAllCpuFrequency() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            float[] fArr = new float[getNumCores()];
            for (int i = 0; i < getNumCores(); i++) {
                fArr[i] = getSingleCpuFrequency(getCpuInfoFilePath(i));
            }
            return fArr;
        }
        return (float[]) invokeV.objValue;
    }

    public static String getAllCpuFrequencyString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < getNumCores(); i++) {
                float singleCpuFrequency = getSingleCpuFrequency(getCpuInfoFilePath(i));
                sb.append(SevenZipUtils.FILE_SEP + singleCpuFrequency);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static float getAveCpuFrequency() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            int i = 0;
            float f2 = 0.0f;
            for (int i2 = 0; i2 < getNumCores(); i2++) {
                float singleCpuFrequency = getSingleCpuFrequency(getCpuInfoFilePath(i2));
                if (singleCpuFrequency > 0.0f) {
                    f2 += singleCpuFrequency;
                    i++;
                }
            }
            if (i > 0) {
                return f2 / i;
            }
            return -1.0f;
        }
        return invokeV.floatValue;
    }

    public static String getCpuInfoFilePath(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) {
            return "/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_max_freq";
        }
        return (String) invokeI.objValue;
    }

    public static int getNumCores() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            FileFilter fileFilter = new FileFilter() { // from class: com.baidu.searchbox.aideviceperformance.utils.HardwareInfoUtils.1
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
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file)) == null) ? Pattern.matches("cpu[0-9]", file.getName()) : invokeL.booleanValue;
                }
            };
            if (sCoreNum <= 0) {
                try {
                    File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(fileFilter);
                    sCoreNum = listFiles == null ? -1 : listFiles.length;
                } catch (Exception e2) {
                    if (DEBUG) {
                        Log.e(TAG, "getNumCores exception occurred, e= ", e2);
                    }
                    sCoreNum = -1;
                }
            }
            return sCoreNum;
        }
        return invokeV.intValue;
    }

    public static int getScreenDensity(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) ? context.getResources().getDisplayMetrics().densityDpi : invokeL.intValue;
    }

    public static String getScreenInfo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            float f2 = displayMetrics.density;
            int i = displayMetrics.densityDpi;
            int i2 = displayMetrics.widthPixels;
            int i3 = displayMetrics.heightPixels;
            return "densityDPI=" + i + "; screenWidth=" + i2 + "; screenHeight=" + i3;
        }
        return (String) invokeL.objValue;
    }

    public static long getScreenResolution(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return displayMetrics.widthPixels * displayMetrics.heightPixels;
        }
        return invokeL.longValue;
    }

    public static float getScreenXdpi(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) ? context.getResources().getDisplayMetrics().xdpi : invokeL.floatValue;
    }

    public static float getScreenYdpi(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) ? context.getResources().getDisplayMetrics().ydpi : invokeL.floatValue;
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
        Exception e2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65548, null, str)) != null) {
            return invokeL.floatValue;
        }
        try {
            fileInputStream = new FileInputStream(new File(str));
        } catch (Exception e3) {
            fileInputStream = null;
            e2 = e3;
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
                } catch (Exception e4) {
                    e2 = e4;
                    if (DEBUG) {
                        Log.e(TAG, "getCpuFrequency Exception occurred, e=", e2);
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
        } catch (Exception e5) {
            e2 = e5;
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
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x0047 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:41:0x0076 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: java.io.FileReader */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: java.io.FileReader */
    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: java.io.FileReader */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.FileReader, java.io.Reader] */
    public static float getTotalMemory() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2;
        Exception e2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65549, null)) != null) {
            return invokeV.floatValue;
        }
        float f2 = sTotalMemory;
        FileReader fileReader = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        if (fileReader >= 0) {
            return f2;
        }
        try {
            try {
                fileReader = new FileReader(MEM_INFO_FILE);
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                bufferedReader2 = new BufferedReader(fileReader, 8192);
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        String[] split = readLine.split("\\s+");
                        if (split.length >= 2) {
                            long parseLong = Long.parseLong(split[1]);
                            if (parseLong > 0) {
                                sTotalMemory = (((float) parseLong) / 1024.0f) / 1024.0f;
                            }
                        }
                    }
                    float f3 = sTotalMemory;
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused) {
                    }
                    try {
                        fileReader.close();
                    } catch (IOException unused2) {
                    }
                    return f3;
                } catch (Exception e3) {
                    e2 = e3;
                    if (DEBUG) {
                        Log.e(TAG, "getTotalMemory Exception occured,e=", e2);
                    }
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException unused3) {
                        }
                    }
                    if (fileReader != 0) {
                        try {
                            fileReader.close();
                        } catch (IOException unused4) {
                        }
                    }
                    return -1.0f;
                }
            } catch (Exception e4) {
                bufferedReader2 = null;
                e2 = e4;
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused5) {
                    }
                }
                if (fileReader != 0) {
                    try {
                        fileReader.close();
                    } catch (IOException unused6) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            bufferedReader2 = null;
            e2 = e5;
            fileReader = 0;
        } catch (Throwable th4) {
            bufferedReader = null;
            th = th4;
            fileReader = 0;
        }
    }

    public static float getTotalSDCardSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (Environment.getExternalStorageState().equals("mounted")) {
                try {
                    StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                    return ((((float) (statFs.getBlockCountLong() * statFs.getBlockSizeLong())) / 1024.0f) / 1024.0f) / 1024.0f;
                } catch (Error | Exception unused) {
                }
            }
            return -1.0f;
        }
        return invokeV.floatValue;
    }
}
