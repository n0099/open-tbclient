package c.a.j.l.a.d;

import android.app.Activity;
import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CharSequence a;

    /* renamed from: b  reason: collision with root package name */
    public int f3790b;

    /* renamed from: c  reason: collision with root package name */
    public CharSequence f3791c;

    /* renamed from: d  reason: collision with root package name */
    public int f3792d;

    /* renamed from: e  reason: collision with root package name */
    public int f3793e;

    /* renamed from: f  reason: collision with root package name */
    public a f3794f;

    /* renamed from: g  reason: collision with root package name */
    public String f3795g;

    /* renamed from: h  reason: collision with root package name */
    public String f3796h;

    /* renamed from: i  reason: collision with root package name */
    public String f3797i;

    /* renamed from: j  reason: collision with root package name */
    public String f3798j;
    public String k;
    public String l;
    public c.a.j.h.c.d.c m;

    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    public b() {
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
        this.f3793e = 2;
        this.f3790b = 14;
        this.f3792d = 14;
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            d.e();
            f.f();
        }
    }

    public static int m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? c.a.j.h.d.d.a() : invokeL.intValue;
    }

    public b a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this : (b) invokeI.objValue;
    }

    public b b(c.a.j.h.c.d.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
            this.m = cVar;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b c(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
            this.f3794f = aVar;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b d(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, charSequence)) == null) {
            this.a = charSequence;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.f3795g = str;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public void g(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, context) == null) && l()) {
            f();
            d.g(context, this.a, this.f3793e, this.f3795g, this.l, this.f3796h, this.m);
        }
    }

    public b h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (i2 >= 1 && i2 <= 10) {
                this.f3793e = i2;
            } else {
                this.f3793e = 2;
            }
            return this;
        }
        return (b) invokeI.objValue;
    }

    public b i(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, charSequence)) == null) {
            this.f3791c = charSequence;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            this.f3796h = str;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public void k(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, context) == null) && l() && context != null) {
            f();
            if (context instanceof Activity) {
                f.g((Activity) context, this.a, this.f3790b, this.f3791c, this.f3792d, this.f3793e, this.f3795g, this.l, this.f3796h, this.f3797i, this.f3798j, this.k, this.f3794f, this.m);
            } else {
                d.f(context, this.a, this.f3790b, this.l, this.f3791c, this.f3792d, this.f3793e, this.f3795g, this.f3796h, this.f3797i, this.f3798j, this.k, this.f3794f, this.m);
            }
        }
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.a != null : invokeV.booleanValue;
    }

    public b n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            this.f3797i = str;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            this.f3798j = str;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            this.k = str;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            this.l = str;
            return this;
        }
        return (b) invokeL.objValue;
    }
}
