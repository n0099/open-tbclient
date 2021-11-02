package b.a.t0;

import android.content.Context;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import b.a.t0.i0;
import b.a.t0.x;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class y {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final z f28905a;

    public y(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28905a = z.N(context);
    }

    public void A(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.f28905a.W(list);
        }
    }

    public void B(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pVar) == null) {
            this.f28905a.X(pVar);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f28905a.Y();
        }
    }

    public boolean D(List<j> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) ? this.f28905a.Z(list) : invokeL.booleanValue;
    }

    public void E(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, str, i2, str2) == null) {
            this.f28905a.a0(str, i2, str2);
        }
    }

    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f28905a.b0(str);
        }
    }

    public void G(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            this.f28905a.c0(str, str2);
        }
    }

    public void a(l0 l0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, l0Var) == null) {
            this.f28905a.a(l0Var);
        }
    }

    public void b(l0 l0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, l0Var) == null) {
            this.f28905a.b(l0Var);
        }
    }

    public void c(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, str, z) == null) {
            this.f28905a.h(str, z);
        }
    }

    public void d(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, str, i2) == null) {
            this.f28905a.k(str, i2);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f28905a.m();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f28905a.n();
        }
    }

    public boolean g(l0 l0Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, l0Var, str)) == null) ? this.f28905a.o(l0Var, str) : invokeLL.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f28905a.s() : invokeV.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f28905a.t();
        }
    }

    public boolean j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) ? this.f28905a.u(str) : invokeL.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f28905a.v();
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.f28905a.w(str);
        }
    }

    public void m(String str, int i2, long j, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{str, Integer.valueOf(i2), Long.valueOf(j), jSONArray}) == null) {
            this.f28905a.y(str, i2, j, jSONArray);
        }
    }

    public int n(l0 l0Var, l0 l0Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, l0Var, l0Var2)) == null) ? this.f28905a.B(l0Var, l0Var2) : invokeLL.intValue;
    }

    public HashMap<String, String> o(ArrayList<String> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, arrayList)) == null) ? this.f28905a.E(arrayList) : (HashMap) invokeL.objValue;
    }

    public j p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) ? this.f28905a.F(str) : (j) invokeL.objValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f28905a.G() : invokeV.intValue;
    }

    public int r(ArrayList<String> arrayList, boolean z, l0 l0Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{arrayList, Boolean.valueOf(z), l0Var})) == null) {
            l0Var.M(10485760);
            return this.f28905a.H(arrayList, z, l0Var);
        }
        return invokeCommon.intValue;
    }

    public i0.d s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f28905a.O() : (i0.d) invokeV.objValue;
    }

    public int t(ArrayList<String> arrayList, boolean z, l0 l0Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048602, this, new Object[]{arrayList, Boolean.valueOf(z), l0Var})) == null) ? this.f28905a.H(arrayList, z, l0Var) : invokeCommon.intValue;
    }

    public int u(l0 l0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, l0Var)) == null) ? this.f28905a.P(l0Var) : invokeL.intValue;
    }

    public Map<String, x.a> v(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i2)) == null) ? this.f28905a.Q(i2) : (Map) invokeI.objValue;
    }

    public o w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) ? this.f28905a.R(str) : (o) invokeL.objValue;
    }

    public void x(SparseArray<ArrayList> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, sparseArray) == null) {
            this.f28905a.S(sparseArray);
        }
    }

    public void y(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, fVar) == null) {
            this.f28905a.T(fVar);
        }
    }

    public void z(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, nVar) == null) {
            this.f28905a.V(nVar);
        }
    }
}
