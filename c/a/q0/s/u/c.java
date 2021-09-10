package c.a.q0.s.u;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.Direction;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f14499a;

    /* renamed from: b  reason: collision with root package name */
    public Drawable f14500b;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f14501e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f14502f;

        public a(c cVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14502f = cVar;
            this.f14501e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c cVar = this.f14502f;
                cVar.f14500b = c.a.q0.s.u.a.E(cVar.f14500b, this.f14501e, this.f14502f.f14499a.getMeasuredHeight());
                this.f14502f.f14499a.setBackgroundDrawable(this.f14502f.f14500b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f14503e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f14504f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f14505g;

        public b(c cVar, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14505g = cVar;
            this.f14503e = i2;
            this.f14504f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c cVar = this.f14505g;
                cVar.f14500b = c.a.q0.s.u.a.F(cVar.f14500b, this.f14503e, this.f14504f, this.f14505g.f14499a.getMeasuredHeight());
                this.f14505g.f14499a.setBackgroundDrawable(this.f14505g.f14500b);
            }
        }
    }

    public c(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14499a = view;
        this.f14500b = c.a.q0.s.u.a.d(view);
    }

    public static c d(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, view)) == null) ? new c(view) : (c) invokeL.objValue;
    }

    public c A(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            View view = this.f14499a;
            if (view instanceof TextView) {
                ((TextView) view).setTextSize(0, c.a.q0.s.u.a.o(i2));
                return this;
            }
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c B(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            View view = this.f14499a;
            if (view instanceof TextView) {
                ((TextView) view).setTypeface(c.a.q0.s.u.a.J(c.a.q0.s.u.a.G(i2)));
                return this;
            }
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (this.f14499a == null) {
                return this;
            }
            this.f14500b = c.a.q0.s.u.a.b(this.f14500b, i2);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public void f(int i2) {
        Drawable j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.f14499a == null || (j2 = c.a.q0.s.u.a.j(this.f14500b, i2)) == null) {
            return;
        }
        this.f14500b = j2;
        this.f14499a.setBackgroundDrawable(j2);
    }

    public void g(String str) {
        Drawable k;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || this.f14499a == null || (k = c.a.q0.s.u.a.k(this.f14500b, str)) == null) {
            return;
        }
        this.f14500b = k;
        this.f14499a.setBackgroundDrawable(k);
    }

    public void h(int i2) {
        Drawable y;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || this.f14499a == null || (y = c.a.q0.s.u.a.y(this.f14500b, i2)) == null) {
            return;
        }
        this.f14500b = y;
        this.f14499a.setBackgroundDrawable(y);
    }

    public void i(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (view = this.f14499a) == null) {
            return;
        }
        view.post(new a(this, i2));
    }

    public void j(int i2, int i3) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) || (view = this.f14499a) == null) {
            return;
        }
        view.post(new b(this, i2, i3));
    }

    public c k(int i2) {
        InterceptResult invokeI;
        Drawable e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            if (this.f14499a == null || (e2 = c.a.q0.s.u.a.e(this.f14500b, i2)) == null) {
                return this;
            }
            this.f14500b = e2;
            this.f14499a.setBackgroundDrawable(e2);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c l(int i2) {
        InterceptResult invokeI;
        Drawable f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            if (this.f14499a == null || (f2 = c.a.q0.s.u.a.f(this.f14500b, i2)) == null) {
                return this;
            }
            this.f14500b = f2;
            this.f14499a.setBackgroundDrawable(f2);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            if (this.f14499a == null) {
                return this;
            }
            this.f14500b = c.a.q0.s.u.a.g(this.f14500b, i2);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            if (this.f14499a == null) {
                return this;
            }
            this.f14500b = c.a.q0.s.u.a.n(this.f14500b, i2);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            if (this.f14499a == null) {
                return this;
            }
            this.f14500b = c.a.q0.s.u.a.m(this.f14500b, i2);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public void p(int[] iArr) {
        Drawable r;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, iArr) == null) || this.f14499a == null || (r = c.a.q0.s.u.a.r(this.f14500b, Direction.BOTTOM, iArr)) == null) {
            return;
        }
        this.f14500b = r;
        this.f14499a.setBackgroundDrawable(r);
    }

    public void q(int[] iArr, Direction direction) {
        Drawable r;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, iArr, direction) == null) || this.f14499a == null || (r = c.a.q0.s.u.a.r(this.f14500b, direction, iArr)) == null) {
            return;
        }
        this.f14500b = r;
        this.f14499a.setBackgroundDrawable(r);
    }

    public c r(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            View view = this.f14499a;
            if (view == null) {
                return this;
            }
            view.setLayerType(i2, null);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c s(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            View view = this.f14499a;
            if (view instanceof TextView) {
                ((TextView) view).setLinkTextColor(c.a.q0.s.u.a.h(i2));
                return this;
            }
            return this;
        }
        return (c) invokeI.objValue;
    }

    public void t(int i2) {
        Drawable v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || this.f14499a == null || (v = c.a.q0.s.u.a.v(this.f14500b, c.a.q0.s.u.a.H(i2))) == null) {
            return;
        }
        this.f14500b = v;
        this.f14499a.setBackgroundDrawable(v);
    }

    public c u(int i2) {
        InterceptResult invokeI;
        Drawable x;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            if (this.f14499a == null || (x = c.a.q0.s.u.a.x(this.f14500b, i2)) == null) {
                return this;
            }
            this.f14500b = x;
            this.f14499a.setBackgroundDrawable(x);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c v(int i2) {
        InterceptResult invokeI;
        Drawable C;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            View view = this.f14499a;
            if (view == null || (C = c.a.q0.s.u.a.C(view, this.f14500b, c.a.q0.s.u.a.H(i2))) == null) {
                return this;
            }
            this.f14500b = C;
            this.f14499a.setBackgroundDrawable(C);
            r(1);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c w(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
            View view = this.f14499a;
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(c.a.q0.s.u.a.h(i2));
                return this;
            }
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c x(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) {
            View view = this.f14499a;
            if (view instanceof EMTextView) {
                ((EMTextView) view).setLineSpacing(c.a.q0.s.u.a.o(i2), ((EMTextView) this.f14499a).getLineSpacingMultiplier());
                return this;
            }
            throw new ClassCastException("When setting line spacing, use EMTextView to ensure UI effect.");
        }
        return (c) invokeI.objValue;
    }

    public c y(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
            View view = this.f14499a;
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(c.a.q0.s.u.a.I(i2));
                return this;
            }
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c z(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) {
            if (this.f14499a instanceof TextView) {
                float[] D = c.a.q0.s.u.a.D(i2);
                ((TextView) this.f14499a).setShadowLayer(D[1], D[2], D[3], (int) D[0]);
                return this;
            }
            return this;
        }
        return (c) invokeI.objValue;
    }
}
