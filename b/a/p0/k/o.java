package b.a.p0.k;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f11015a;

    /* renamed from: b  reason: collision with root package name */
    public int f11016b;

    /* renamed from: c  reason: collision with root package name */
    public int f11017c;

    /* renamed from: d  reason: collision with root package name */
    public String f11018d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f11019e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11020f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11021g;

    /* renamed from: h  reason: collision with root package name */
    public int f11022h;

    /* renamed from: i  reason: collision with root package name */
    public int f11023i;
    public long j;
    public e k;
    public b.a.p0.k.r.b l;

    public o(int i2, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11016b = -1;
        this.f11017c = -1;
        this.f11020f = true;
        this.f11021g = true;
        this.f11022h = 0;
        this.f11023i = 0;
        this.j = 0L;
        this.f11015a = i2;
        this.f11016b = i3;
        this.f11017c = i4;
        this.f11021g = z;
    }

    public static o k(o oVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, oVar)) == null) {
            if (oVar == null) {
                return null;
            }
            return new o(oVar.f11015a, oVar.f11016b, oVar.f11017c, oVar.f11021g);
        }
        return (o) invokeL.objValue;
    }

    public static o l(o oVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, oVar, z)) == null) {
            if (oVar == null) {
                return null;
            }
            return new o(oVar.f11015a, oVar.f11016b, oVar.f11017c, z);
        }
        return (o) invokeLZ.objValue;
    }

    public Drawable a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            Drawable drawable = this.f11019e;
            if (drawable != null) {
                return drawable;
            }
            if (this.f11017c <= 0) {
                return null;
            }
            return context.getResources().getDrawable(this.f11017c);
        }
        return (Drawable) invokeL.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f11022h : invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f11015a : invokeV.intValue;
    }

    public b.a.p0.k.r.b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.l : (b.a.p0.k.r.b) invokeV.objValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.j : invokeV.longValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f11023i : invokeV.intValue;
    }

    public e g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.k : (e) invokeV.objValue;
    }

    public String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            String str = this.f11018d;
            if (str != null) {
                return str;
            }
            if (this.f11016b <= 0) {
                return null;
            }
            return context.getResources().getString(this.f11016b);
        }
        return (String) invokeL.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f11021g : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f11020f : invokeV.booleanValue;
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f11017c = i2;
        }
    }

    public void n(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            this.j = j;
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f11023i = i2;
        }
    }

    public void p(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, eVar) == null) {
            this.k = eVar;
        }
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f11016b = i2;
        }
    }
}
