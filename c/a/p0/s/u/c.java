package c.a.p0.s.u;

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
    public View f14534a;

    /* renamed from: b  reason: collision with root package name */
    public Drawable f14535b;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f14536e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f14537f;

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
            this.f14537f = cVar;
            this.f14536e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c cVar = this.f14537f;
                cVar.f14535b = c.a.p0.s.u.a.C(cVar.f14535b, this.f14536e, this.f14537f.f14534a.getMeasuredHeight());
                this.f14537f.f14534a.setBackgroundDrawable(this.f14537f.f14535b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f14538e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f14539f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f14540g;

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
            this.f14540g = cVar;
            this.f14538e = i2;
            this.f14539f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c cVar = this.f14540g;
                cVar.f14535b = c.a.p0.s.u.a.D(cVar.f14535b, this.f14538e, this.f14539f, this.f14540g.f14534a.getMeasuredHeight());
                this.f14540g.f14534a.setBackgroundDrawable(this.f14540g.f14535b);
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
        this.f14534a = view;
        this.f14535b = c.a.p0.s.u.a.d(view);
    }

    public static c d(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, view)) == null) ? new c(view) : (c) invokeL.objValue;
    }

    public c e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (this.f14534a == null) {
                return this;
            }
            this.f14535b = c.a.p0.s.u.a.b(this.f14535b, i2);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public void f(int i2) {
        Drawable i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f14534a == null || (i3 = c.a.p0.s.u.a.i(this.f14535b, i2)) == null) {
            return;
        }
        this.f14535b = i3;
        this.f14534a.setBackgroundDrawable(i3);
    }

    public void g(int i2) {
        Drawable w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f14534a == null || (w = c.a.p0.s.u.a.w(this.f14535b, i2)) == null) {
            return;
        }
        this.f14535b = w;
        this.f14534a.setBackgroundDrawable(w);
    }

    public void h(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (view = this.f14534a) == null) {
            return;
        }
        view.post(new a(this, i2));
    }

    public void i(int i2, int i3) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) || (view = this.f14534a) == null) {
            return;
        }
        view.post(new b(this, i2, i3));
    }

    public c j(int i2) {
        InterceptResult invokeI;
        Drawable e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (this.f14534a == null || (e2 = c.a.p0.s.u.a.e(this.f14535b, i2)) == null) {
                return this;
            }
            this.f14535b = e2;
            this.f14534a.setBackgroundDrawable(e2);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c k(int i2) {
        InterceptResult invokeI;
        Drawable f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (this.f14534a == null || (f2 = c.a.p0.s.u.a.f(this.f14535b, i2)) == null) {
                return this;
            }
            this.f14535b = f2;
            this.f14534a.setBackgroundDrawable(f2);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            if (this.f14534a == null) {
                return this;
            }
            this.f14535b = c.a.p0.s.u.a.g(this.f14535b, i2);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            if (this.f14534a == null) {
                return this;
            }
            this.f14535b = c.a.p0.s.u.a.l(this.f14535b, i2);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            if (this.f14534a == null) {
                return this;
            }
            this.f14535b = c.a.p0.s.u.a.k(this.f14535b, i2);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public void o(int[] iArr) {
        Drawable p;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, iArr) == null) || this.f14534a == null || (p = c.a.p0.s.u.a.p(this.f14535b, Direction.BOTTOM, iArr)) == null) {
            return;
        }
        this.f14535b = p;
        this.f14534a.setBackgroundDrawable(p);
    }

    public c p(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            View view = this.f14534a;
            if (view == null) {
                return this;
            }
            view.setLayerType(i2, null);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            View view = this.f14534a;
            if (view instanceof TextView) {
                ((TextView) view).setLinkTextColor(c.a.p0.s.u.a.h(i2));
                return this;
            }
            return this;
        }
        return (c) invokeI.objValue;
    }

    public void r(int i2) {
        Drawable t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || this.f14534a == null || (t = c.a.p0.s.u.a.t(this.f14535b, c.a.p0.s.u.a.F(i2))) == null) {
            return;
        }
        this.f14535b = t;
        this.f14534a.setBackgroundDrawable(t);
    }

    public c s(int i2) {
        InterceptResult invokeI;
        Drawable v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            if (this.f14534a == null || (v = c.a.p0.s.u.a.v(this.f14535b, i2)) == null) {
                return this;
            }
            this.f14535b = v;
            this.f14534a.setBackgroundDrawable(v);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c t(int i2) {
        InterceptResult invokeI;
        Drawable A;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            View view = this.f14534a;
            if (view == null || (A = c.a.p0.s.u.a.A(view, this.f14535b, c.a.p0.s.u.a.F(i2))) == null) {
                return this;
            }
            this.f14535b = A;
            this.f14534a.setBackgroundDrawable(A);
            p(1);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c u(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            View view = this.f14534a;
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(c.a.p0.s.u.a.h(i2));
                return this;
            }
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c v(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
            View view = this.f14534a;
            if (view instanceof EMTextView) {
                ((EMTextView) view).setLineSpacing(c.a.p0.s.u.a.m(i2), ((EMTextView) this.f14534a).getLineSpacingMultiplier());
                return this;
            }
            throw new ClassCastException("When setting line spacing, use EMTextView to ensure UI effect.");
        }
        return (c) invokeI.objValue;
    }

    public c w(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            View view = this.f14534a;
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(c.a.p0.s.u.a.G(i2));
                return this;
            }
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c x(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            if (this.f14534a instanceof TextView) {
                float[] B = c.a.p0.s.u.a.B(i2);
                ((TextView) this.f14534a).setShadowLayer(B[1], B[2], B[3], (int) B[0]);
                return this;
            }
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c y(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
            View view = this.f14534a;
            if (view instanceof TextView) {
                ((TextView) view).setTextSize(0, c.a.p0.s.u.a.m(i2));
                return this;
            }
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c z(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) {
            View view = this.f14534a;
            if (view instanceof TextView) {
                ((TextView) view).setTypeface(c.a.p0.s.u.a.H(c.a.p0.s.u.a.E(i2)));
                return this;
            }
            return this;
        }
        return (c) invokeI.objValue;
    }
}
