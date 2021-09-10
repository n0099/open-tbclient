package c.a.p0.a.h0.n.a;

import android.text.TextUtils;
import c.a.p0.a.a1.e;
import c.a.p0.a.e0.d;
import c.a.p0.a.g1.f;
import c.a.p0.a.k;
import c.a.p0.a.v2.o0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static int f6276a;
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
        boolean z = k.f7077a;
        f6276a = -1;
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f6276a < 0) {
                c.a.p0.a.c1.a.Z().getSwitch("swan_app_precreate_video_switch", 0);
                f6276a = 0;
            }
            d.g("PreCreateVideoHelper", "getCacheVideoSwitch:" + f6276a);
            return f6276a;
        }
        return invokeV.intValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                str = f.V().f();
            }
            String f2 = o0.f(str);
            boolean z = f.V().d(f2, f.V().s(), e.C0114e.i(c.a.p0.a.a2.d.g().getAppId(), c.a.p0.a.a2.d.g().r().L().u1()).getPath() + File.separator).o;
            d.g("PreCreateVideoHelper", "hasVideoInPage path : " + f2 + " has video :" + z);
            return z;
        }
        return invokeL.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            boolean z = (a() > 0) && b(c.a.p0.a.a2.d.g().r().L().e0());
            d.g("PreCreateVideoHelper", "isEnableVideoCache: hasVideoInCurPage " + z);
            return z;
        }
        return invokeV.booleanValue;
    }
}
