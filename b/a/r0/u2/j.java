package b.a.r0.u2;

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
/* loaded from: classes5.dex */
public class j implements b.a.r0.a2.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f25548a;

    /* renamed from: b  reason: collision with root package name */
    public String f25549b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, b.a.r0.a2.e> f25550c;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b.a.r0.a2.g f25551a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1536707131, "Lb/a/r0/u2/j$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1536707131, "Lb/a/r0/u2/j$b;");
                    return;
                }
            }
            f25551a = new j(null);
        }
    }

    public /* synthetic */ j(a aVar) {
        this();
    }

    public static b.a.r0.a2.g m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.f25551a : (b.a.r0.a2.g) invokeV.objValue;
    }

    @Override // b.a.r0.a2.g
    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
            n().c(this.f25548a, i2, str);
        }
    }

    @Override // b.a.r0.a2.g
    public void b(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            n().f(this.f25548a, i2, str);
        }
    }

    @Override // b.a.r0.a2.g
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            n().k(this.f25548a);
            q(this.f25548a);
        }
    }

    @Override // b.a.r0.a2.g
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f25549b = this.f25548a;
        }
    }

    @Override // b.a.r0.a2.g
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || StringUtils.isNull(this.f25549b)) {
            return;
        }
        if (!o(this.f25549b) && !p(this.f25549b)) {
            b.a.r0.a2.d.b(this.f25549b);
            this.f25550c.remove(this.f25548a);
        } else {
            q(this.f25549b);
        }
        g();
        n().h(this.f25549b, str);
        this.f25549b = null;
    }

    @Override // b.a.r0.a2.g
    public void f(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, str) == null) {
            n().b(this.f25548a, i2, i3, str);
        }
    }

    @Override // b.a.r0.a2.g
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f25548a = UUID.randomUUID().toString();
        }
    }

    @Override // b.a.r0.a2.g
    public void h(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, str) == null) {
            n().g(this.f25548a, i2, str);
        }
    }

    @Override // b.a.r0.a2.g
    public void i(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, str) == null) {
            n().l(this.f25548a, i2, str);
        }
    }

    @Override // b.a.r0.a2.g
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            n().j(this.f25548a);
        }
    }

    @Override // b.a.r0.a2.g
    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            n().i(this.f25548a, str);
            if (!o(this.f25548a) && !p(this.f25548a)) {
                b.a.r0.a2.d.b(this.f25548a);
                this.f25550c.remove(this.f25548a);
            } else {
                q(this.f25548a);
            }
            this.f25548a = null;
        }
    }

    public final b.a.r0.a2.e l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            i iVar = new i(this.f25548a);
            this.f25550c.put(this.f25548a, iVar);
            return iVar;
        }
        return (b.a.r0.a2.e) invokeV.objValue;
    }

    public final b.a.r0.a2.e n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            b.a.r0.a2.e eVar = this.f25550c.get(this.f25548a);
            return eVar == null ? l() : eVar;
        }
        return (b.a.r0.a2.e) invokeV.objValue;
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
        b.a.r0.a2.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || (eVar = this.f25550c.get(str)) == null) {
            return;
        }
        eVar.a(str);
        this.f25550c.remove(str);
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
        this.f25550c = new HashMap<>();
    }
}
