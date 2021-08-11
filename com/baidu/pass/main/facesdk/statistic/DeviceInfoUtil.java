package com.baidu.pass.main.facesdk.statistic;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class DeviceInfoUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final FileFilter CPU_FILTER;
    public static final String CurPath = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1900589538, "Lcom/baidu/pass/main/facesdk/statistic/DeviceInfoUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1900589538, "Lcom/baidu/pass/main/facesdk/statistic/DeviceInfoUtil;");
                return;
            }
        }
        CPU_FILTER = new FileFilter() { // from class: com.baidu.pass.main.facesdk.statistic.DeviceInfoUtil.1
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
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file)) == null) {
                    String name = file.getName();
                    if (name.startsWith("cpu")) {
                        for (int i2 = 3; i2 < name.length(); i2++) {
                            if (name.charAt(i2) < '0' || name.charAt(i2) > '9') {
                                return false;
                            }
                        }
                        return true;
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }
        };
    }

    public DeviceInfoUtil() {
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

    public static Integer getCPUBit() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                str = getFieldFromCpuinfo("Processor");
            } catch (IOException e2) {
                e2.printStackTrace();
                str = null;
            }
            if (str == null) {
                return 0;
            }
            if (str.contains("aarch64")) {
                return 64;
            }
            return 32;
        }
        return (Integer) invokeV.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x0030 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x0032 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:54:0x007c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.baidu.titan.sdk.runtime.Interceptable] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.io.FileReader] */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.io.FileReader] */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.io.FileReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.FileReader] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public static int getDeviceBasicFrequency() {
        ?? r1;
        ?? r2;
        BufferedReader bufferedReader;
        IOException e2;
        FileNotFoundException e3;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            r1 = interceptable;
            r2 = 65539;
            InterceptResult invokeV = r1.invokeV(65539, null);
            if (invokeV != null) {
                return invokeV.intValue;
            }
        }
        try {
            try {
                try {
                    r1 = new FileReader(CurPath);
                } catch (IOException e4) {
                    e4.printStackTrace();
                    return 0;
                }
            } catch (FileNotFoundException e5) {
                bufferedReader = null;
                e3 = e5;
                r1 = 0;
            } catch (IOException e6) {
                bufferedReader = null;
                e2 = e6;
                r1 = 0;
            } catch (Throwable th) {
                r2 = 0;
                th = th;
                r1 = 0;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            bufferedReader = new BufferedReader(r1);
            try {
                int parseInt = Integer.parseInt(bufferedReader.readLine().trim());
                try {
                    r1.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
                try {
                    bufferedReader.close();
                    return parseInt;
                } catch (IOException e8) {
                    e8.printStackTrace();
                    return parseInt;
                }
            } catch (FileNotFoundException e9) {
                e3 = e9;
                e3.printStackTrace();
                if (r1 != 0) {
                    try {
                        r1.close();
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return 0;
            } catch (IOException e11) {
                e2 = e11;
                e2.printStackTrace();
                if (r1 != 0) {
                    try {
                        r1.close();
                    } catch (IOException e12) {
                        e12.printStackTrace();
                    }
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return 0;
            }
        } catch (FileNotFoundException e13) {
            bufferedReader = null;
            e3 = e13;
        } catch (IOException e14) {
            bufferedReader = null;
            e2 = e14;
        } catch (Throwable th3) {
            r2 = 0;
            th = th3;
            if (r1 != 0) {
                try {
                    r1.close();
                } catch (IOException e15) {
                    e15.printStackTrace();
                }
            }
            if (r2 != 0) {
                try {
                    r2.close();
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static String getDeviceBoard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? Build.BOARD : (String) invokeV.objValue;
    }

    public static String getDeviceBrand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? Build.BRAND : (String) invokeV.objValue;
    }

    public static String getDeviceDevice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? Build.DEVICE : (String) invokeV.objValue;
    }

    public static String getDeviceManufacturer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? Build.MANUFACTURER : (String) invokeV.objValue;
    }

    public static String getDeviceModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? Build.MODEL : (String) invokeV.objValue;
    }

    public static String getDeviceProcessor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            try {
                return new BufferedReader(new FileReader("/proc/cpuinfo")).readLine().split(":\\s+", 2)[1];
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                return null;
            } catch (IOException e3) {
                e3.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String getDeviceProduct() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? Build.PRODUCT : (String) invokeV.objValue;
    }

    public static int getDeviceSDK() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? Build.VERSION.SDK_INT : invokeV.intValue;
    }

    public static String getDeviceSerial() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? Build.SERIAL : (String) invokeV.objValue;
    }

    public static String getFieldFromCpuinfo(String str) throws IOException {
        InterceptResult invokeL;
        Matcher matcher;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"));
            Pattern compile = Pattern.compile(str + "\\s*:\\s*(.*)");
            do {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        bufferedReader.close();
                        return null;
                    }
                    matcher = compile.matcher(readLine);
                } finally {
                    bufferedReader.close();
                }
            } while (!matcher.matches());
            return matcher.group(1);
        }
        return (String) invokeL.objValue;
    }

    public static int getNumberOfCPUCores() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (Build.VERSION.SDK_INT <= 10) {
                return 1;
            }
            try {
                return new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER).length;
            } catch (NullPointerException | SecurityException unused) {
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public static long getRamInfo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem;
        }
        return invokeL.longValue;
    }

    public static String getStorageInfo(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65552, null, context, i2)) == null) {
            String storagePath = getStoragePath(context, i2);
            if (!isSDCardMount() || storagePath == null || storagePath.toString().equals("")) {
                return "无外置SD卡";
            }
            StatFs statFs = new StatFs(new File(storagePath).getPath());
            long blockCountLong = statFs.getBlockCountLong();
            long blockSizeLong = statFs.getBlockSizeLong();
            long j2 = blockCountLong * blockSizeLong;
            long availableBlocksLong = statFs.getAvailableBlocksLong() * blockSizeLong;
            return "可用/总共：" + Long.toString(availableBlocksLong) + "/" + Long.toString(j2);
        }
        return (String) invokeLI.objValue;
    }

    public static String getStoragePath(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLI = interceptable.invokeLI(65553, null, context, i2)) != null) {
            return (String) invokeLI.objValue;
        }
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        try {
            String[] strArr = (String[]) storageManager.getClass().getMethod("getVolumePaths", new Class[0]).invoke(storageManager, new Object[0]);
            if (i2 != 0) {
                if (i2 == 1 && strArr.length > 1) {
                    return strArr[i2];
                }
                return null;
            }
            return strArr[i2];
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    public static String getSystemVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? Build.VERSION.RELEASE : (String) invokeV.objValue;
    }

    public static boolean isSDCardMount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? Environment.getExternalStorageState().equals("mounted") : invokeV.booleanValue;
    }
}
