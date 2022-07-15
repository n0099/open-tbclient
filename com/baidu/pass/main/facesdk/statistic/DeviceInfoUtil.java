package com.baidu.pass.main.facesdk.statistic;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.C0294;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
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
                    String name = file.getName();
                    if (name.startsWith("cpu")) {
                        for (int i = 3; i < name.length(); i++) {
                            if (name.charAt(i) < '0' || name.charAt(i) > '9') {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            } catch (IOException e) {
                e.printStackTrace();
                str = null;
            }
            if (str != null) {
                return Integer.valueOf(str.contains("aarch64") ? 64 : 32);
            }
            return 0;
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
        IOException e;
        FileNotFoundException e2;
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
                } catch (IOException e3) {
                    e3.printStackTrace();
                    return 0;
                }
            } catch (FileNotFoundException e4) {
                bufferedReader = null;
                e2 = e4;
                r1 = 0;
            } catch (IOException e5) {
                bufferedReader = null;
                e = e5;
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
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
                try {
                    bufferedReader.close();
                    return parseInt;
                } catch (IOException e7) {
                    e7.printStackTrace();
                    return parseInt;
                }
            } catch (FileNotFoundException e8) {
                e2 = e8;
                e2.printStackTrace();
                if (r1 != 0) {
                    try {
                        r1.close();
                    } catch (IOException e9) {
                        e9.printStackTrace();
                    }
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return 0;
            } catch (IOException e10) {
                e = e10;
                e.printStackTrace();
                if (r1 != 0) {
                    try {
                        r1.close();
                    } catch (IOException e11) {
                        e11.printStackTrace();
                    }
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return 0;
            }
        } catch (FileNotFoundException e12) {
            bufferedReader = null;
            e2 = e12;
        } catch (IOException e13) {
            bufferedReader = null;
            e = e13;
        } catch (Throwable th3) {
            r2 = 0;
            th = th3;
            if (r1 != 0) {
                try {
                    r1.close();
                } catch (IOException e14) {
                    e14.printStackTrace();
                }
            }
            if (r2 != 0) {
                try {
                    r2.close();
                } catch (IOException e15) {
                    e15.printStackTrace();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? Build.BRAND : (String) invokeV.objValue;
    }

    public static String getDeviceDevice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? Build.DEVICE : (String) invokeV.objValue;
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
                String[] split = new BufferedReader(new FileReader(C0294.f19)).readLine().split(":\\s+", 2);
                for (int i = 0; i < split.length; i++) {
                }
                return split[1];
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e2) {
                e2.printStackTrace();
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

    public static String getFieldFromCpuinfo(String str) {
        InterceptResult invokeL;
        Matcher matcher;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(C0294.f19));
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

    public static String getStorageInfo(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65552, null, context, i)) == null) {
            String storagePath = getStoragePath(context, i);
            if (!isSDCardMount() || storagePath == null || storagePath.toString().equals("")) {
                return "无外置SD卡";
            }
            StatFs statFs = new StatFs(new File(storagePath).getPath());
            long blockCountLong = statFs.getBlockCountLong();
            long blockSizeLong = statFs.getBlockSizeLong();
            long j = blockCountLong * blockSizeLong;
            long availableBlocksLong = statFs.getAvailableBlocksLong() * blockSizeLong;
            return "可用/总共：" + Long.toString(availableBlocksLong) + "/" + Long.toString(j);
        }
        return (String) invokeLI.objValue;
    }

    public static String getStoragePath(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLI = interceptable.invokeLI(65553, null, context, i)) != null) {
            return (String) invokeLI.objValue;
        }
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        try {
            String[] strArr = (String[]) storageManager.getClass().getMethod("getVolumePaths", new Class[0]).invoke(storageManager, new Object[0]);
            if (i != 0) {
                if (i == 1 && strArr.length > 1) {
                    return strArr[i];
                }
                return null;
            }
            return strArr[i];
        } catch (Exception e) {
            e.printStackTrace();
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
