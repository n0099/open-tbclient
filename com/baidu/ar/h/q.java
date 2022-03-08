package com.baidu.ar.h;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.statistic.DeviceInfoUtil;
import com.baidu.searchbox.aideviceperformance.utils.HardwareInfoUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.z;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class q {
    public static /* synthetic */ Interceptable $ic = null;
    public static String name = "";
    public static String value = "";
    public static String yh = "";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a implements FileFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) ? Pattern.matches("cpu[0-9]", file.getName()) : invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1921143105, "Lcom/baidu/ar/h/q;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1921143105, "Lcom/baidu/ar/h/q;");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long B(Context context) {
        InterceptResult invokeL;
        InputStreamReader inputStreamReader;
        Throwable th;
        BufferedReader bufferedReader;
        Exception e2;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                inputStreamReader = new InputStreamReader(new FileInputStream(HardwareInfoUtils.MEM_INFO_FILE), Charset.forName("utf-8"));
            } catch (Exception e3) {
                inputStreamReader = null;
                e2 = e3;
                bufferedReader = null;
            } catch (Throwable th2) {
                inputStreamReader = null;
                th = th2;
                bufferedReader = null;
            }
            try {
                bufferedReader = new BufferedReader(inputStreamReader, 8192);
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        String[] split = readLine.split("\\s+");
                        for (String str : split) {
                            String str2 = readLine + StringUtil.ARRAY_ELEMENT_SEPARATOR + str + "\t";
                        }
                        j2 = Integer.parseInt(split[1]);
                        try {
                            bufferedReader.close();
                        } catch (IOException e4) {
                            e4.printStackTrace(System.out);
                        }
                        try {
                            inputStreamReader.close();
                        } catch (IOException e5) {
                            e5.printStackTrace(System.out);
                        }
                    } catch (Exception e6) {
                        e2 = e6;
                        e2.printStackTrace(System.out);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e7) {
                                e7.printStackTrace(System.out);
                            }
                        }
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (IOException e8) {
                                e8.printStackTrace(System.out);
                            }
                        }
                        j2 = 0;
                        return j2 / 1024;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e9) {
                            e9.printStackTrace(System.out);
                        }
                    }
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e10) {
                            e10.printStackTrace(System.out);
                        }
                    }
                    throw th;
                }
            } catch (Exception e11) {
                e2 = e11;
                bufferedReader = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                if (bufferedReader != null) {
                }
                if (inputStreamReader != null) {
                }
                throw th;
            }
            return j2 / 1024;
        }
        return invokeL.longValue;
    }

    public static long C(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            return memoryInfo.availMem / 1048576;
        }
        return invokeL.longValue;
    }

    public static boolean D(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(4) != null : invokeL.booleanValue;
    }

    public static boolean E(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? "RLIAN00".equalsIgnoreCase(Build.MODEL) || "RLIN29".equalsIgnoreCase(Build.MODEL) || "TAH-AN00".equalsIgnoreCase(Build.MODEL) || "TAHN29".equalsIgnoreCase(Build.MODEL) || "TAH-AN00m".equalsIgnoreCase(Build.MODEL) || "RLI-N29".equalsIgnoreCase(Build.MODEL) || "TAH-N29".equalsIgnoreCase(Build.MODEL) || "RHA-AN00m".equalsIgnoreCase(Build.MODEL) : invokeL.booleanValue;
    }

    public static long[] gC() {
        InterceptResult invokeV;
        StatFs statFs;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            long blockSize = new StatFs(Environment.getDataDirectory().getPath()).getBlockSize();
            return new long[]{(statFs.getBlockCount() * blockSize) / 1048576, (blockSize * statFs.getAvailableBlocks()) / 1048576};
        }
        return (long[]) invokeV.objValue;
    }

    public static long gD() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            try {
                if ("mounted".equals(Environment.getExternalStorageState())) {
                    StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                    return (statFs.getBlockSize() * statFs.getBlockCount()) / 1048576;
                }
                return 0L;
            } catch (Throwable th) {
                th.printStackTrace(System.out);
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    public static long gE() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                try {
                    StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                    return (statFs.getBlockSize() * statFs.getAvailableBlocks()) / 1048576;
                } catch (Exception e2) {
                    e2.printStackTrace(System.out);
                }
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public static String gF() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Throwable th;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65544, null)) != null) {
            return (String) invokeV.objValue;
        }
        try {
            try {
                inputStreamReader = new InputStreamReader(new FileInputStream("/proc/cpuinfo"), Charset.forName("utf-8"));
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
            inputStreamReader = null;
            bufferedReader2 = null;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            inputStreamReader = null;
        }
        try {
            bufferedReader2 = new BufferedReader(inputStreamReader);
            try {
                String[] split = bufferedReader2.readLine().split(":\\s+", 2);
                for (int i2 = 0; i2 < split.length; i2++) {
                }
                String str = split[1];
                try {
                    bufferedReader2.close();
                } catch (IOException e3) {
                    e3.printStackTrace(System.out);
                }
                try {
                    inputStreamReader.close();
                } catch (IOException e4) {
                    e4.printStackTrace(System.out);
                }
                return str;
            } catch (Exception e5) {
                e = e5;
                e.printStackTrace(System.out);
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e6) {
                        e6.printStackTrace(System.out);
                    }
                }
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (IOException e7) {
                        e7.printStackTrace(System.out);
                    }
                }
                return null;
            }
        } catch (Exception e8) {
            e = e8;
            bufferedReader2 = null;
        } catch (Throwable th4) {
            bufferedReader = null;
            th = th4;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e9) {
                    e9.printStackTrace(System.out);
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e10) {
                    e10.printStackTrace(System.out);
                }
            }
            throw th;
        }
    }

    public static int gG() {
        File[] listFiles;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            try {
                String str = "CPU Count: " + listFiles.length;
                return new File("/sys/devices/system/cpu/").listFiles(new a()).length;
            } catch (Exception e2) {
                e2.printStackTrace(System.out);
                return 1;
            }
        }
        return invokeV.intValue;
    }

    public static String gH() {
        String str;
        byte[] bArr;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            try {
                InputStream inputStream = new ProcessBuilder("/system/bin/cat", z.f53881c).start().getInputStream();
                String str2 = "";
                while (inputStream.read(new byte[24]) != -1) {
                    str2 = str2 + new String(bArr, "utf-8");
                }
                inputStream.close();
                str = String.valueOf(Integer.parseInt(str2.trim()) / 1000);
            } catch (Exception unused) {
                str = "N/A";
            }
            return str.trim();
        }
        return (String) invokeV.objValue;
    }

    public static boolean gI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? Build.VERSION.SDK_INT >= 26 : invokeV.booleanValue;
    }

    public static String gJ() {
        String str;
        byte[] bArr;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            try {
                InputStream inputStream = new ProcessBuilder("/system/bin/cat", z.f53880b).start().getInputStream();
                String str2 = "";
                while (inputStream.read(new byte[24]) != -1) {
                    str2 = str2 + new String(bArr, "utf-8");
                }
                inputStream.close();
                str = String.valueOf(Integer.parseInt(str2.trim()) / 1000);
            } catch (Exception e2) {
                e2.printStackTrace(System.out);
                str = "N/A";
            }
            return String.valueOf(str);
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x0049 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x004b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:64:0x006f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r1v17, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.io.Reader, java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r3v15, types: [java.io.PrintStream] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.io.PrintStream] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0043 -> B:64:0x006f). Please submit an issue!!! */
    public static String gK() {
        Interceptable interceptable;
        InterceptResult invokeV;
        ?? r2;
        ?? r3;
        Exception e2;
        Interceptable interceptable2;
        Interceptable interceptable3 = $ic;
        if (interceptable3 == null || (invokeV = (interceptable = interceptable3).invokeV(65549, null)) == null) {
            String str = "N/A";
            ?? r1 = 0;
            r1 = 0;
            try {
                try {
                    try {
                        r2 = new InputStreamReader(new FileInputStream(DeviceInfoUtil.CurPath), Charset.forName("utf-8"));
                    } catch (Throwable th) {
                        th = th;
                        r1 = interceptable;
                    }
                } catch (Exception e3) {
                    r3 = 0;
                    e2 = e3;
                    r2 = 0;
                } catch (Throwable th2) {
                    th = th2;
                    r2 = 0;
                }
                try {
                    r3 = new BufferedReader(r2);
                    try {
                        str = String.valueOf(Integer.parseInt(r3.readLine().trim().trim()) / 1000);
                        try {
                            r3.close();
                            interceptable2 = r3;
                        } catch (IOException e4) {
                            ?? r32 = System.out;
                            e4.printStackTrace(r32);
                            interceptable2 = r32;
                        }
                        r2.close();
                        r2 = r2;
                        interceptable = interceptable2;
                    } catch (Exception e5) {
                        e2 = e5;
                        e2.printStackTrace(System.out);
                        interceptable = r3;
                        if (r3 != 0) {
                            try {
                                r3.close();
                                interceptable = r3;
                            } catch (IOException e6) {
                                ?? r33 = System.out;
                                e6.printStackTrace(r33);
                                interceptable = r33;
                            }
                        }
                        if (r2 != 0) {
                            r2.close();
                            r2 = r2;
                            interceptable = interceptable;
                        }
                        return str;
                    }
                } catch (Exception e7) {
                    r3 = 0;
                    e2 = e7;
                } catch (Throwable th3) {
                    th = th3;
                    if (r1 != 0) {
                        try {
                            r1.close();
                        } catch (IOException e8) {
                            e8.printStackTrace(System.out);
                        }
                    }
                    if (r2 != 0) {
                        try {
                            r2.close();
                        } catch (IOException e9) {
                            e9.printStackTrace(System.out);
                        }
                    }
                    throw th;
                }
            } catch (IOException e10) {
                PrintStream printStream = System.out;
                e10.printStackTrace(printStream);
                r2 = printStream;
                interceptable = interceptable;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static boolean gL() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? "Nexus 6P".equals(Build.MODEL) || "AOSP on angler".equals(Build.MODEL) : invokeV.booleanValue;
    }

    public static boolean gM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? "Nexus 5X".equals(Build.MODEL) : invokeV.booleanValue;
    }
}
