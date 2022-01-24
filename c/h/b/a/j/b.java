package c.h.b.a.j;

import android.app.ActivityManager;
import com.baidu.searchbox.aideviceperformance.utils.HardwareInfoUtils;
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
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static int a;

    /* renamed from: b  reason: collision with root package name */
    public static long f28564b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1212061608, "Lc/h/b/a/j/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1212061608, "Lc/h/b/a/j/b;");
        }
    }

    public static long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) c.h.b.a.c.getContext().provideContext().getSystemService("activity")).getMemoryInfo(memoryInfo);
            return memoryInfo.availMem / 1024;
        }
        return invokeV.longValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == 0) {
                try {
                    a = new File("/sys/devices/system/cpu/").listFiles(new a()).length;
                } catch (Exception unused) {
                    a = 1;
                }
            }
            return a;
        }
        return invokeV.intValue;
    }

    public static long c() {
        InterceptResult invokeV;
        FileReader fileReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f28564b == 0) {
                FileReader fileReader2 = null;
                try {
                    try {
                        fileReader = new FileReader(HardwareInfoUtils.MEM_INFO_FILE);
                    } catch (IOException unused) {
                    }
                } catch (IOException unused2) {
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    BufferedReader bufferedReader = new BufferedReader(fileReader, 8192);
                    String readLine = bufferedReader.readLine();
                    r1 = readLine != null ? Integer.valueOf(readLine.split("\\s+")[1]).intValue() : -1L;
                    bufferedReader.close();
                    fileReader.close();
                } catch (IOException unused3) {
                    fileReader2 = fileReader;
                    if (fileReader2 != null) {
                        fileReader2.close();
                    }
                    f28564b = r1;
                    return f28564b;
                } catch (Throwable th2) {
                    th = th2;
                    fileReader2 = fileReader;
                    if (fileReader2 != null) {
                        try {
                            fileReader2.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
                f28564b = r1;
            }
            return f28564b;
        }
        return invokeV.longValue;
    }
}
