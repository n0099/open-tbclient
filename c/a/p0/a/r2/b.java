package c.a.p0.a.r2;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.p2.o0;
import c.a.p0.a.x.g.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static volatile b f7252i;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.a.k2.a a;

    /* renamed from: b  reason: collision with root package name */
    public String f7253b;

    /* renamed from: c  reason: collision with root package name */
    public String f7254c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.a.c1.b f7255d;

    /* renamed from: e  reason: collision with root package name */
    public d f7256e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7257f;

    /* renamed from: g  reason: collision with root package name */
    public String f7258g;

    /* renamed from: h  reason: collision with root package name */
    public String f7259h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(828301809, "Lc/a/p0/a/r2/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(828301809, "Lc/a/p0/a/r2/b;");
                return;
            }
        }
        boolean z = c.a.p0.a.a.a;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f7257f = true;
        this.f7258g = "-1";
    }

    public static b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f7252i == null) {
                synchronized (b.class) {
                    if (f7252i == null) {
                        f7252i = new b();
                    }
                }
            }
            return f7252i;
        }
        return (b) invokeV.objValue;
    }

    public c.a.p0.a.c1.b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f7255d : (c.a.p0.a.c1.b) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f7254c : (String) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f7257f : invokeV.booleanValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f7259h : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f7258g : (String) invokeV.objValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.p0.a.k2.a aVar = this.a;
            if (aVar != null) {
                return aVar.h();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c.a.p0.a.u.d.i("SwanWebModeController", "getWebViewId: " + this.f7253b);
            return this.f7253b;
        }
        return (String) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a = null;
            this.f7253b = "";
            this.f7254c = "";
            this.f7255d = null;
            this.f7257f = true;
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f7254c = str;
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f7257f = z;
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f7259h = str;
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f7258g = str;
        }
    }

    public void n(c.a.p0.a.k2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            this.a = aVar;
        }
    }

    public void o(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) {
            this.f7256e = dVar;
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            c.a.p0.a.u.d.i("SwanWebModeController", "setWebViewId: " + str);
            this.f7253b = str;
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            c.a.p0.a.u.d.i("SwanWebModeController", "updateCurPageParam: pageUrl " + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            c.a.p0.a.c1.b bVar = this.f7255d;
            if (bVar == null) {
                this.f7255d = c.a.p0.a.c1.b.e(str, str);
                return;
            }
            bVar.f4642e = o0.f(str);
            this.f7255d.f4643f = o0.o(str);
        }
    }
}
