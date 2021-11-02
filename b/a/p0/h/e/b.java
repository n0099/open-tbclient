package b.a.p0.h.e;

import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f10379a;

    /* renamed from: b  reason: collision with root package name */
    public static int f10380b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-865335470, "Lb/a/p0/h/e/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-865335470, "Lb/a/p0/h/e/b;");
                return;
            }
        }
        f10379a = k.f6397a;
        f10380b = -1;
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            a aVar = new a();
            aVar.f10376a = b();
            aVar.f10377b = c();
            aVar.f10378c = d();
            if (f10379a) {
                String str = "getCodeCacheConfig() maxCount: " + aVar.f10376a + " ,sizeLimit: " + aVar.f10377b;
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f10380b < 0) {
                b.a.p0.a.c1.a.Z().getSwitch("minigame_code_cache_max_count", 20);
                f10380b = 20;
            }
            return f10380b;
        }
        return invokeV.intValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return 102400;
        }
        return invokeV.intValue;
    }

    public static long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? b() * 6 * 1048576 : invokeV.longValue;
    }
}
