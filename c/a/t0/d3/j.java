package c.a.t0.d3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes7.dex */
public class j implements c.a.t0.h2.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f17507b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, c.a.t0.h2.e> f17508c;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final c.a.t0.h2.g a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1535910042, "Lc/a/t0/d3/j$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1535910042, "Lc/a/t0/d3/j$b;");
                    return;
                }
            }
            a = new j(null);
        }
    }

    public /* synthetic */ j(a aVar) {
        this();
    }

    public static c.a.t0.h2.g m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (c.a.t0.h2.g) invokeV.objValue;
    }

    @Override // c.a.t0.h2.g
    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
            n().c(this.a, i2, str);
        }
    }

    @Override // c.a.t0.h2.g
    public void b(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            n().f(this.a, i2, str);
        }
    }

    @Override // c.a.t0.h2.g
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            n().k(this.a);
            q(this.a);
        }
    }

    @Override // c.a.t0.h2.g
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f17507b = this.a;
        }
    }

    @Override // c.a.t0.h2.g
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || StringUtils.isNull(this.f17507b)) {
            return;
        }
        if (!o(this.f17507b) && !p(this.f17507b)) {
            c.a.t0.h2.d.b(this.f17507b);
            this.f17508c.remove(this.a);
        } else {
            q(this.f17507b);
        }
        g();
        n().h(this.f17507b, str);
        this.f17507b = null;
    }

    @Override // c.a.t0.h2.g
    public void f(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, str) == null) {
            n().b(this.a, i2, i3, str);
        }
    }

    @Override // c.a.t0.h2.g
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a = UUID.randomUUID().toString();
        }
    }

    @Override // c.a.t0.h2.g
    public void h(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, str) == null) {
            n().g(this.a, i2, str);
        }
    }

    @Override // c.a.t0.h2.g
    public void i(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, str) == null) {
            n().l(this.a, i2, str);
        }
    }

    @Override // c.a.t0.h2.g
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            n().j(this.a);
        }
    }

    @Override // c.a.t0.h2.g
    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            n().i(this.a, str);
            if (!o(this.a) && !p(this.a)) {
                c.a.t0.h2.d.b(this.a);
                this.f17508c.remove(this.a);
            } else {
                q(this.a);
            }
            this.a = null;
        }
    }

    public final c.a.t0.h2.e l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            i iVar = new i(this.a);
            this.f17508c.put(this.a, iVar);
            return iVar;
        }
        return (c.a.t0.h2.e) invokeV.objValue;
    }

    public final c.a.t0.h2.e n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            c.a.t0.h2.e eVar = this.f17508c.get(this.a);
            return eVar == null ? l() : eVar;
        }
        return (c.a.t0.h2.e) invokeV.objValue;
    }

    public boolean o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) ? n().d(str) : invokeL.booleanValue;
    }

    public boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) ? n().e(str) : invokeL.booleanValue;
    }

    public void q(String str) {
        c.a.t0.h2.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || (eVar = this.f17508c.get(str)) == null) {
            return;
        }
        eVar.a(str);
        this.f17508c.remove(str);
    }

    public j() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17508c = new HashMap<>();
    }
}
