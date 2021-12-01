package c.a.p0.a.h0.n.a;

import android.text.TextUtils;
import c.a.p0.a.a1.d;
import c.a.p0.a.d2.d;
import c.a.p0.a.g1.f;
import c.a.p0.a.k;
import c.a.p0.a.z2.o0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1004123001, "Lc/a/p0/a/h0/n/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1004123001, "Lc/a/p0/a/h0/n/a/a;");
                return;
            }
        }
        boolean z = k.a;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? b(d.J().r().V().e0()) : invokeV.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                str = f.U().f();
            }
            String f2 = o0.f(str);
            boolean z = f.U().d(f2, f.U().r(), d.e.i(c.a.p0.a.d2.d.J().getAppId(), c.a.p0.a.d2.d.J().r().V().v1()).getPath() + File.separator).o;
            c.a.p0.a.e0.d.i("PreCreateVideoHelper", "hasVideoInPage path : " + f2 + " has video :" + z);
            return z;
        }
        return invokeL.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            c.a.p0.a.c1.a.g0().getSwitch("swan_app_precreate_video_switch_v2", false);
            return false;
        }
        return invokeV.booleanValue;
    }
}
