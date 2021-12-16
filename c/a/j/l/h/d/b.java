package c.a.j.l.h.d;

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
    public int f3647b;

    /* renamed from: c  reason: collision with root package name */
    public CharSequence f3648c;

    /* renamed from: d  reason: collision with root package name */
    public int f3649d;

    /* renamed from: e  reason: collision with root package name */
    public int f3650e;

    /* renamed from: f  reason: collision with root package name */
    public a f3651f;

    /* renamed from: g  reason: collision with root package name */
    public String f3652g;

    /* renamed from: h  reason: collision with root package name */
    public String f3653h;

    /* renamed from: i  reason: collision with root package name */
    public String f3654i;

    /* renamed from: j  reason: collision with root package name */
    public String f3655j;

    /* renamed from: k  reason: collision with root package name */
    public String f3656k;
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
        this.f3650e = 2;
        this.f3647b = 14;
        this.f3649d = 14;
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
            this.f3651f = aVar;
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
            this.f3652g = str;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public void g(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, context) == null) && l()) {
            f();
            d.g(context, this.a, this.f3650e, this.f3652g, this.l, this.f3653h, this.m);
        }
    }

    public b h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (i2 >= 1 && i2 <= 10) {
                this.f3650e = i2;
            } else {
                this.f3650e = 2;
            }
            return this;
        }
        return (b) invokeI.objValue;
    }

    public b i(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, charSequence)) == null) {
            this.f3648c = charSequence;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            this.f3653h = str;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public void k(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, context) == null) && l() && context != null) {
            f();
            if (context instanceof Activity) {
                f.g((Activity) context, this.a, this.f3647b, this.f3648c, this.f3649d, this.f3650e, this.f3652g, this.l, this.f3653h, this.f3654i, this.f3655j, this.f3656k, this.f3651f, this.m);
            } else {
                d.f(context, this.a, this.f3647b, this.l, this.f3648c, this.f3649d, this.f3650e, this.f3652g, this.f3653h, this.f3654i, this.f3655j, this.f3656k, this.f3651f, this.m);
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
            this.f3654i = str;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            this.f3655j = str;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            this.f3656k = str;
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
