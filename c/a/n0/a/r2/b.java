package c.a.n0.a.r2;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.o0;
import c.a.n0.a.x.g.d;
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
    public static volatile b i;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.n0.a.k2.a a;

    /* renamed from: b  reason: collision with root package name */
    public String f6071b;

    /* renamed from: c  reason: collision with root package name */
    public String f6072c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.n0.a.c1.b f6073d;

    /* renamed from: e  reason: collision with root package name */
    public d f6074e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6075f;

    /* renamed from: g  reason: collision with root package name */
    public String f6076g;

    /* renamed from: h  reason: collision with root package name */
    public String f6077h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1221328819, "Lc/a/n0/a/r2/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1221328819, "Lc/a/n0/a/r2/b;");
                return;
            }
        }
        boolean z = c.a.n0.a.a.a;
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
        this.f6075f = true;
        this.f6076g = "-1";
    }

    public static b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (i == null) {
                synchronized (b.class) {
                    if (i == null) {
                        i = new b();
                    }
                }
            }
            return i;
        }
        return (b) invokeV.objValue;
    }

    public c.a.n0.a.c1.b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f6073d : (c.a.n0.a.c1.b) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f6072c : (String) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f6075f : invokeV.booleanValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f6077h : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f6076g : (String) invokeV.objValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.n0.a.k2.a aVar = this.a;
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
            c.a.n0.a.u.d.i("SwanWebModeController", "getWebViewId: " + this.f6071b);
            return this.f6071b;
        }
        return (String) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a = null;
            this.f6071b = "";
            this.f6072c = "";
            this.f6073d = null;
            this.f6075f = true;
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f6072c = str;
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f6075f = z;
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f6077h = str;
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f6076g = str;
        }
    }

    public void n(c.a.n0.a.k2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            this.a = aVar;
        }
    }

    public void o(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) {
            this.f6074e = dVar;
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            c.a.n0.a.u.d.i("SwanWebModeController", "setWebViewId: " + str);
            this.f6071b = str;
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            c.a.n0.a.u.d.i("SwanWebModeController", "updateCurPageParam: pageUrl " + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            c.a.n0.a.c1.b bVar = this.f6073d;
            if (bVar == null) {
                this.f6073d = c.a.n0.a.c1.b.d(str, str);
                return;
            }
            bVar.a = o0.f(str);
            this.f6073d.f3947b = o0.o(str);
        }
    }
}
