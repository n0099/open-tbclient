package c.a.r0.s2;

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
/* loaded from: classes3.dex */
public class j implements c.a.r0.z1.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f24798a;

    /* renamed from: b  reason: collision with root package name */
    public String f24799b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, c.a.r0.z1.e> f24800c;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final c.a.r0.z1.g f24801a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-743858856, "Lc/a/r0/s2/j$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-743858856, "Lc/a/r0/s2/j$b;");
                    return;
                }
            }
            f24801a = new j(null);
        }
    }

    public /* synthetic */ j(a aVar) {
        this();
    }

    public static c.a.r0.z1.g m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.f24801a : (c.a.r0.z1.g) invokeV.objValue;
    }

    @Override // c.a.r0.z1.g
    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
            n().c(this.f24798a, i2, str);
        }
    }

    @Override // c.a.r0.z1.g
    public void b(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            n().f(this.f24798a, i2, str);
        }
    }

    @Override // c.a.r0.z1.g
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            n().k(this.f24798a);
            q(this.f24798a);
        }
    }

    @Override // c.a.r0.z1.g
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f24799b = this.f24798a;
        }
    }

    @Override // c.a.r0.z1.g
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || StringUtils.isNull(this.f24799b)) {
            return;
        }
        if (!o(this.f24799b) && !p(this.f24799b)) {
            c.a.r0.z1.d.b(this.f24799b);
            this.f24800c.remove(this.f24798a);
        } else {
            q(this.f24799b);
        }
        g();
        n().h(this.f24799b, str);
        this.f24799b = null;
    }

    @Override // c.a.r0.z1.g
    public void f(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, str) == null) {
            n().b(this.f24798a, i2, i3, str);
        }
    }

    @Override // c.a.r0.z1.g
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f24798a = UUID.randomUUID().toString();
        }
    }

    @Override // c.a.r0.z1.g
    public void h(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, str) == null) {
            n().g(this.f24798a, i2, str);
        }
    }

    @Override // c.a.r0.z1.g
    public void i(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, str) == null) {
            n().l(this.f24798a, i2, str);
        }
    }

    @Override // c.a.r0.z1.g
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            n().j(this.f24798a);
        }
    }

    @Override // c.a.r0.z1.g
    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            n().i(this.f24798a, str);
            if (!o(this.f24798a) && !p(this.f24798a)) {
                c.a.r0.z1.d.b(this.f24798a);
                this.f24800c.remove(this.f24798a);
            } else {
                q(this.f24798a);
            }
            this.f24798a = null;
        }
    }

    public final c.a.r0.z1.e l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            i iVar = new i(this.f24798a);
            this.f24800c.put(this.f24798a, iVar);
            return iVar;
        }
        return (c.a.r0.z1.e) invokeV.objValue;
    }

    public final c.a.r0.z1.e n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            c.a.r0.z1.e eVar = this.f24800c.get(this.f24798a);
            return eVar == null ? l() : eVar;
        }
        return (c.a.r0.z1.e) invokeV.objValue;
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
        c.a.r0.z1.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || (eVar = this.f24800c.get(str)) == null) {
            return;
        }
        eVar.a(str);
        this.f24800c.remove(str);
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
        this.f24800c = new HashMap<>();
    }
}
