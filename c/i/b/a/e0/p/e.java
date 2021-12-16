package c.i.b.a.e0.p;

import android.text.Layout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f30384b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f30385c;

    /* renamed from: d  reason: collision with root package name */
    public int f30386d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30387e;

    /* renamed from: f  reason: collision with root package name */
    public int f30388f;

    /* renamed from: g  reason: collision with root package name */
    public int f30389g;

    /* renamed from: h  reason: collision with root package name */
    public int f30390h;

    /* renamed from: i  reason: collision with root package name */
    public int f30391i;

    /* renamed from: j  reason: collision with root package name */
    public int f30392j;

    /* renamed from: k  reason: collision with root package name */
    public float f30393k;
    public String l;
    public e m;
    public Layout.Alignment n;

    public e() {
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
        this.f30388f = -1;
        this.f30389g = -1;
        this.f30390h = -1;
        this.f30391i = -1;
        this.f30392j = -1;
    }

    public e a(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) {
            l(eVar, true);
            return this;
        }
        return (e) invokeL.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f30387e) {
                return this.f30386d;
            }
            throw new IllegalStateException("Background color has not been defined.");
        }
        return invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f30385c) {
                return this.f30384b;
            }
            throw new IllegalStateException("Font color has not been defined.");
        }
        return invokeV.intValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public float e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f30393k : invokeV.floatValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f30392j : invokeV.intValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f30390h == -1 && this.f30391i == -1) {
                return -1;
            }
            return (this.f30390h == 1 ? 1 : 0) | (this.f30391i == 1 ? 2 : 0);
        }
        return invokeV.intValue;
    }

    public Layout.Alignment i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.n : (Layout.Alignment) invokeV.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f30387e : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f30385c : invokeV.booleanValue;
    }

    public final e l(e eVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048587, this, eVar, z)) == null) {
            if (eVar != null) {
                if (!this.f30385c && eVar.f30385c) {
                    q(eVar.f30384b);
                }
                if (this.f30390h == -1) {
                    this.f30390h = eVar.f30390h;
                }
                if (this.f30391i == -1) {
                    this.f30391i = eVar.f30391i;
                }
                if (this.a == null) {
                    this.a = eVar.a;
                }
                if (this.f30388f == -1) {
                    this.f30388f = eVar.f30388f;
                }
                if (this.f30389g == -1) {
                    this.f30389g = eVar.f30389g;
                }
                if (this.n == null) {
                    this.n = eVar.n;
                }
                if (this.f30392j == -1) {
                    this.f30392j = eVar.f30392j;
                    this.f30393k = eVar.f30393k;
                }
                if (z && !this.f30387e && eVar.f30387e) {
                    o(eVar.f30386d);
                }
            }
            return this;
        }
        return (e) invokeLZ.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f30388f == 1 : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f30389g == 1 : invokeV.booleanValue;
    }

    public e o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            this.f30386d = i2;
            this.f30387e = true;
            return this;
        }
        return (e) invokeI.objValue;
    }

    public e p(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
            c.i.b.a.i0.a.f(this.m == null);
            this.f30390h = z ? 1 : 0;
            return this;
        }
        return (e) invokeZ.objValue;
    }

    public e q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            c.i.b.a.i0.a.f(this.m == null);
            this.f30384b = i2;
            this.f30385c = true;
            return this;
        }
        return (e) invokeI.objValue;
    }

    public e r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            c.i.b.a.i0.a.f(this.m == null);
            this.a = str;
            return this;
        }
        return (e) invokeL.objValue;
    }

    public e s(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048594, this, f2)) == null) {
            this.f30393k = f2;
            return this;
        }
        return (e) invokeF.objValue;
    }

    public e t(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            this.f30392j = i2;
            return this;
        }
        return (e) invokeI.objValue;
    }

    public e u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            this.l = str;
            return this;
        }
        return (e) invokeL.objValue;
    }

    public e v(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048597, this, z)) == null) {
            c.i.b.a.i0.a.f(this.m == null);
            this.f30391i = z ? 1 : 0;
            return this;
        }
        return (e) invokeZ.objValue;
    }

    public e w(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048598, this, z)) == null) {
            c.i.b.a.i0.a.f(this.m == null);
            this.f30388f = z ? 1 : 0;
            return this;
        }
        return (e) invokeZ.objValue;
    }

    public e x(Layout.Alignment alignment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, alignment)) == null) {
            this.n = alignment;
            return this;
        }
        return (e) invokeL.objValue;
    }

    public e y(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048600, this, z)) == null) {
            c.i.b.a.i0.a.f(this.m == null);
            this.f30389g = z ? 1 : 0;
            return this;
        }
        return (e) invokeZ.objValue;
    }
}
