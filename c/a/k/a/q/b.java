package c.a.k.a.q;

import android.os.Environment;
import android.os.StatFs;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1330834705, "Lc/a/k/a/q/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1330834705, "Lc/a/k/a/q/b;");
        }
    }

    public static float a() {
        InterceptResult invokeV;
        long j2;
        StatFs statFs;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            long j3 = 0;
            try {
                statFs = new StatFs(Environment.getDataDirectory().getPath());
                j2 = statFs.getBlockSize();
            } catch (Exception e2) {
                e = e2;
                j2 = 0;
            }
            try {
                j3 = statFs.getAvailableBlocks();
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                return ((float) (j3 * j2)) / 1024.0f;
            }
            return ((float) (j3 * j2)) / 1024.0f;
        }
        return invokeV.floatValue;
    }
}
