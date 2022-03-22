package c.a.l;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.l.w0.a;
import c.a.o0.r.r.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.ThreadCardView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class a<T extends c.a.o0.r.r.a> implements q, p<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public l0 a;

    /* renamed from: b  reason: collision with root package name */
    public Context f3392b;

    /* renamed from: c  reason: collision with root package name */
    public Boolean f3393c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.h0.b0<T> f3394d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC0194a f3395e;

    /* renamed from: c.a.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0194a {
        void a(c.a.o0.r.r.a aVar);
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3393c = Boolean.FALSE;
        this.f3392b = context;
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
        }
    }

    public c.a.p0.h0.b0<T> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f3394d : (c.a.p0.h0.b0) invokeV.objValue;
    }

    public final ThreadCardView e(View view, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, view, i)) == null) {
            if (view == null || view.getParent() == null || i == 0) {
                return null;
            }
            if (view.getParent() instanceof ThreadCardView) {
                return (ThreadCardView) view.getParent();
            }
            return e((View) view.getParent(), i - 1);
        }
        return (ThreadCardView) invokeLI.objValue;
    }

    public Boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f3393c : (Boolean) invokeV.objValue;
    }

    public abstract View g();

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public void i(int i, a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, bVar) == null) {
            this.a.m(i, bVar);
        }
    }

    public void j(l0 l0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, l0Var) == null) {
            this.a = l0Var;
        }
    }

    public void k(View view, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048585, this, view, i) == null) && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin != i) {
                marginLayoutParams.topMargin = i;
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void l(c.a.p0.h0.b0<T> b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, b0Var) == null) {
            this.f3394d = b0Var;
        }
    }

    public void m(View view, int i) {
        ThreadCardView e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048587, this, view, i) == null) || (e2 = e(view, i)) == null) {
            return;
        }
        c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(e2);
        d2.n(R.string.J_X06);
        d2.f(R.color.CAM_X0205);
    }

    public void n(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bool) == null) {
            this.f3393c = bool;
        }
    }
}
