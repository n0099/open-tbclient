package c.h.b.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Locale;
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public static final Object a;

    /* renamed from: b  reason: collision with root package name */
    public static final SimpleDateFormat f28581b;

    /* renamed from: c  reason: collision with root package name */
    public static final SimpleDateFormat f28582c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                File[] f2 = c.f();
                if (f2 == null || f2.length <= 0) {
                    return;
                }
                synchronized (f.a) {
                    for (File file : f2) {
                        if (currentTimeMillis - file.lastModified() > 172800000) {
                            file.delete();
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2023317391, "Lc/h/b/a/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2023317391, "Lc/h/b/a/f;");
                return;
            }
        }
        a = new Object();
        f28581b = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss.SSS", Locale.US);
        f28582c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            e.b().post(new a());
        }
    }

    public static String c(String str) {
        InterceptResult invokeL;
        String d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            synchronized (a) {
                d2 = d("looper", str);
            }
            return d2;
        }
        return (String) invokeL.objValue;
    }

    public static String d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            String str3 = "";
            BufferedWriter bufferedWriter = null;
            try {
                File c2 = c.c();
                long currentTimeMillis = System.currentTimeMillis();
                str3 = c2.getAbsolutePath() + "/" + str + "-" + f28581b.format(Long.valueOf(currentTimeMillis)) + ".log";
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str3, true), "UTF-8"));
                try {
                    bufferedWriter2.write("\r\n");
                    bufferedWriter2.write("**********************");
                    bufferedWriter2.write("\r\n");
                    bufferedWriter2.write(f28582c.format(Long.valueOf(currentTimeMillis)) + "(write log time)");
                    bufferedWriter2.write("\r\n");
                    bufferedWriter2.write("\r\n");
                    bufferedWriter2.write(str2);
                    bufferedWriter2.write("\r\n");
                    bufferedWriter2.flush();
                    bufferedWriter2.close();
                } catch (Throwable unused) {
                    bufferedWriter = bufferedWriter2;
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (Exception unused2) {
                        }
                    }
                    return str3;
                }
            } catch (Throwable unused3) {
            }
            return str3;
        }
        return (String) invokeLL.objValue;
    }
}
