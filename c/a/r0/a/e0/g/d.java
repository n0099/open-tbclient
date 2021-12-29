package c.a.r0.a.e0.g;

import android.os.Build;
import android.os.Process;
import c.a.r0.a.k;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1317476854, "Lc/a/r0/a/e0/g/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1317476854, "Lc/a/r0/a/e0/g/d;");
                return;
            }
        }
        a = k.a;
    }

    public static synchronized String a() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (d.class) {
                boolean z = a;
                BufferedReader bufferedReader2 = null;
                try {
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"sh", "-c", "top -n 1 | grep " + Process.myPid()}).getInputStream()));
                    } catch (IOException unused) {
                    }
                } catch (Throwable th2) {
                    bufferedReader = bufferedReader2;
                    th = th2;
                }
                try {
                    String c2 = c(bufferedReader);
                    if (a) {
                        String str = "stop cpu monitor thread , cpu rate is : " + c2;
                    }
                    c.a.r0.w.d.d(bufferedReader);
                    return c2;
                } catch (IOException unused2) {
                    bufferedReader2 = bufferedReader;
                    boolean z2 = a;
                    c.a.r0.w.d.d(bufferedReader2);
                    return "";
                } catch (Throwable th3) {
                    th = th3;
                    c.a.r0.w.d.d(bufferedReader);
                    throw th;
                }
            }
        }
        return (String) invokeV.objValue;
    }

    public static float b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String a2 = a();
            try {
                if (a2.contains("%")) {
                    return Float.parseFloat(a2.replace("%", "").trim());
                }
                return Float.parseFloat(a2);
            } catch (Exception unused) {
                boolean z = a;
                return 0.0f;
            }
        }
        return invokeV.floatValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:6|(1:9)|10|(6:12|(1:15)|16|17|18|19)|(1:27)(1:32)|(1:31)|16|17|18|19) */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0056, code lost:
        if (c.a.r0.a.e0.g.d.a != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0058, code lost:
        r0 = "get CPU Fail : " + r11.getMessage();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(BufferedReader bufferedReader) throws IOException {
        InterceptResult invokeL;
        char read;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bufferedReader)) == null) {
            char[] cArr = new char[4];
            int i2 = 0;
            if (Build.VERSION.SDK_INT < 26) {
                int i3 = 0;
                do {
                    read = (char) bufferedReader.read();
                    if (read == ' ' || i3 == 4) {
                        i3 = 0;
                    } else {
                        cArr[i3] = read;
                        i3++;
                    }
                    if (read == '%') {
                        break;
                    }
                } while (read != 65535);
                return String.valueOf(cArr, 0, i3);
            }
            int i4 = 0;
            int i5 = 0;
            while (true) {
                char read2 = (char) bufferedReader.read();
                if (z && read2 != ' ') {
                    i4++;
                }
                if (i4 == 9) {
                    if (read2 != '.' && read2 != ' ') {
                        cArr[i5] = read2;
                        i5++;
                    }
                    i2 = Integer.parseInt(String.valueOf(cArr, 0, i5)) / Runtime.getRuntime().availableProcessors();
                    return i2 + "%";
                }
                z = (i4 <= 9 && read2 != 65535 && i5 < 4) ? read2 == ' ' : true;
                i2 = Integer.parseInt(String.valueOf(cArr, 0, i5)) / Runtime.getRuntime().availableProcessors();
                return i2 + "%";
            }
        }
        return (String) invokeL.objValue;
    }
}
