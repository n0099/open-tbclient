package c.b.c.b.h;

import android.os.Build;
import android.system.Os;
import android.system.OsConstants;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class j {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static long f31604a = -1;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static long f31605a = -1;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-140306567, "Lc/b/c/b/h/j$a;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-140306567, "Lc/b/c/b/h/j$a;");
            }
        }

        public static long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (j.f31604a == -1) {
                    long unused = j.f31604a = 1000 / d();
                }
                return j.f31604a;
            }
            return invokeV.longValue;
        }

        public static long b(long j2) {
            InterceptResult invokeJ;
            long c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j2)) == null) {
                long j3 = f31605a;
                if (j3 > 0) {
                    return j3;
                }
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 21) {
                    c2 = Os.sysconf(OsConstants._SC_CLK_TCK);
                } else {
                    c2 = i2 >= 14 ? c("_SC_CLK_TCK", j2) : j2;
                }
                if (c2 > 0) {
                    j2 = c2;
                }
                f31605a = j2;
                return j2;
            }
            return invokeJ.longValue;
        }

        public static long c(String str, long j2) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65539, null, str, j2)) == null) {
                try {
                    int i2 = Class.forName("libcore.io.OsConstants").getField(str).getInt(null);
                    Class<?> cls = Class.forName("libcore.io.Libcore");
                    return ((Long) Class.forName("libcore.io.Os").getMethod("sysconf", Integer.TYPE).invoke(cls.getField("os").get(null), Integer.valueOf(i2))).longValue();
                } catch (Throwable th) {
                    th.printStackTrace();
                    return j2;
                }
            }
            return invokeLJ.longValue;
        }

        public static long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? b(100L) : invokeV.longValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1738399574, "Lc/b/c/b/h/j;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1738399574, "Lc/b/c/b/h/j;");
        }
    }
}
