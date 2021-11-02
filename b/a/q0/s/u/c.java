package b.a.q0.s.u;

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
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f13622a;

    /* renamed from: b  reason: collision with root package name */
    public Drawable f13623b;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f13624e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f13625f;

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
            this.f13625f = cVar;
            this.f13624e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c cVar = this.f13625f;
                cVar.f13623b = b.a.q0.s.u.a.C(cVar.f13623b, this.f13624e, this.f13625f.f13622a.getMeasuredHeight());
                this.f13625f.f13622a.setBackgroundDrawable(this.f13625f.f13623b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f13626e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f13627f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f13628g;

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
            this.f13628g = cVar;
            this.f13626e = i2;
            this.f13627f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c cVar = this.f13628g;
                cVar.f13623b = b.a.q0.s.u.a.D(cVar.f13623b, this.f13626e, this.f13627f, this.f13628g.f13622a.getMeasuredHeight());
                this.f13628g.f13622a.setBackgroundDrawable(this.f13628g.f13623b);
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
        this.f13622a = view;
        this.f13623b = b.a.q0.s.u.a.d(view);
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
            View view = this.f13622a;
            if (view instanceof TextView) {
                ((TextView) view).setTypeface(b.a.q0.s.u.a.H(b.a.q0.s.u.a.E(i2)));
                return this;
            }
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (this.f13622a == null) {
                return this;
            }
            this.f13623b = b.a.q0.s.u.a.b(this.f13623b, i2);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public void f(int i2) {
        Drawable i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f13622a == null || (i3 = b.a.q0.s.u.a.i(this.f13623b, i2)) == null) {
            return;
        }
        this.f13623b = i3;
        this.f13622a.setBackgroundDrawable(i3);
    }

    public void g(int i2) {
        Drawable w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.f13622a == null || (w = b.a.q0.s.u.a.w(this.f13623b, i2)) == null) {
            return;
        }
        this.f13623b = w;
        this.f13622a.setBackgroundDrawable(w);
    }

    public void h(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || (view = this.f13622a) == null) {
            return;
        }
        view.post(new a(this, i2));
    }

    public void i(int i2, int i3) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) || (view = this.f13622a) == null) {
            return;
        }
        view.post(new b(this, i2, i3));
    }

    public c j(int i2) {
        InterceptResult invokeI;
        Drawable e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (this.f13622a == null || (e2 = b.a.q0.s.u.a.e(this.f13623b, i2)) == null) {
                return this;
            }
            this.f13623b = e2;
            this.f13622a.setBackgroundDrawable(e2);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c k(int i2) {
        InterceptResult invokeI;
        Drawable f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            if (this.f13622a == null || (f2 = b.a.q0.s.u.a.f(this.f13623b, i2)) == null) {
                return this;
            }
            this.f13623b = f2;
            this.f13622a.setBackgroundDrawable(f2);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            if (this.f13622a == null) {
                return this;
            }
            this.f13623b = b.a.q0.s.u.a.g(this.f13623b, i2);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            if (this.f13622a == null) {
                return this;
            }
            this.f13623b = b.a.q0.s.u.a.l(this.f13623b, i2);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            if (this.f13622a == null) {
                return this;
            }
            this.f13623b = b.a.q0.s.u.a.k(this.f13623b, i2);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public void o(int[] iArr) {
        Drawable p;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, iArr) == null) || this.f13622a == null || (p = b.a.q0.s.u.a.p(this.f13623b, Direction.BOTTOM, iArr)) == null) {
            return;
        }
        this.f13623b = p;
        this.f13622a.setBackgroundDrawable(p);
    }

    public void p(int[] iArr, Direction direction) {
        Drawable p;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, iArr, direction) == null) || this.f13622a == null || (p = b.a.q0.s.u.a.p(this.f13623b, direction, iArr)) == null) {
            return;
        }
        this.f13623b = p;
        this.f13622a.setBackgroundDrawable(p);
    }

    public c q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            View view = this.f13622a;
            if (view == null) {
                return this;
            }
            view.setLayerType(i2, null);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c r(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            View view = this.f13622a;
            if (view instanceof TextView) {
                ((TextView) view).setLinkTextColor(b.a.q0.s.u.a.h(i2));
                return this;
            }
            return this;
        }
        return (c) invokeI.objValue;
    }

    public void s(int i2) {
        Drawable t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || this.f13622a == null || (t = b.a.q0.s.u.a.t(this.f13623b, b.a.q0.s.u.a.F(i2))) == null) {
            return;
        }
        this.f13623b = t;
        this.f13622a.setBackgroundDrawable(t);
    }

    public c t(int i2) {
        InterceptResult invokeI;
        Drawable v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            if (this.f13622a == null || (v = b.a.q0.s.u.a.v(this.f13623b, i2)) == null) {
                return this;
            }
            this.f13623b = v;
            this.f13622a.setBackgroundDrawable(v);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c u(int i2) {
        InterceptResult invokeI;
        Drawable A;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
            View view = this.f13622a;
            if (view == null || (A = b.a.q0.s.u.a.A(view, this.f13623b, b.a.q0.s.u.a.F(i2))) == null) {
                return this;
            }
            this.f13623b = A;
            this.f13622a.setBackgroundDrawable(A);
            q(1);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c v(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            View view = this.f13622a;
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(b.a.q0.s.u.a.h(i2));
                return this;
            }
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c w(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            View view = this.f13622a;
            if (view instanceof EMTextView) {
                ((EMTextView) view).setLineSpacing(b.a.q0.s.u.a.m(i2), ((EMTextView) this.f13622a).getLineSpacingMultiplier());
                return this;
            }
            throw new ClassCastException("When setting line spacing, use EMTextView to ensure UI effect.");
        }
        return (c) invokeI.objValue;
    }

    public c x(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
            View view = this.f13622a;
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(b.a.q0.s.u.a.G(i2));
                return this;
            }
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c y(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) {
            if (this.f13622a instanceof TextView) {
                float[] B = b.a.q0.s.u.a.B(i2);
                ((TextView) this.f13622a).setShadowLayer(B[1], B[2], B[3], (int) B[0]);
                return this;
            }
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c z(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
            View view = this.f13622a;
            if (view instanceof TextView) {
                ((TextView) view).setTextSize(0, b.a.q0.s.u.a.m(i2));
                return this;
            }
            return this;
        }
        return (c) invokeI.objValue;
    }
}
