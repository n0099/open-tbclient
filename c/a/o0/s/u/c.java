package c.a.o0.s.u;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
    public View f14227a;

    /* renamed from: b  reason: collision with root package name */
    public Drawable f14228b;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f14229e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f14230f;

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
            this.f14230f = cVar;
            this.f14229e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c cVar = this.f14230f;
                cVar.f14228b = c.a.o0.s.u.a.B(cVar.f14228b, this.f14229e, this.f14230f.f14227a.getMeasuredHeight());
                this.f14230f.f14227a.setBackgroundDrawable(this.f14230f.f14228b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f14231e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f14232f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f14233g;

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
            this.f14233g = cVar;
            this.f14231e = i2;
            this.f14232f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c cVar = this.f14233g;
                cVar.f14228b = c.a.o0.s.u.a.C(cVar.f14228b, this.f14231e, this.f14232f, this.f14233g.f14227a.getMeasuredHeight());
                this.f14233g.f14227a.setBackgroundDrawable(this.f14233g.f14228b);
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
        this.f14227a = view;
        this.f14228b = c.a.o0.s.u.a.d(view);
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
            if (this.f14227a == null) {
                return this;
            }
            this.f14228b = c.a.o0.s.u.a.b(this.f14228b, i2);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public void f(int i2) {
        Drawable i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f14227a == null || (i3 = c.a.o0.s.u.a.i(this.f14228b, i2)) == null) {
            return;
        }
        this.f14228b = i3;
        this.f14227a.setBackgroundDrawable(i3);
    }

    public void g(int i2) {
        Drawable v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f14227a == null || (v = c.a.o0.s.u.a.v(this.f14228b, i2)) == null) {
            return;
        }
        this.f14228b = v;
        this.f14227a.setBackgroundDrawable(v);
    }

    public void h(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (view = this.f14227a) == null) {
            return;
        }
        view.post(new a(this, i2));
    }

    public void i(int i2, int i3) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) || (view = this.f14227a) == null) {
            return;
        }
        view.post(new b(this, i2, i3));
    }

    public c j(int i2) {
        InterceptResult invokeI;
        Drawable e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (this.f14227a == null || (e2 = c.a.o0.s.u.a.e(this.f14228b, i2)) == null) {
                return this;
            }
            this.f14228b = e2;
            this.f14227a.setBackgroundDrawable(e2);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c k(int i2) {
        InterceptResult invokeI;
        Drawable f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (this.f14227a == null || (f2 = c.a.o0.s.u.a.f(this.f14228b, i2)) == null) {
                return this;
            }
            this.f14228b = f2;
            this.f14227a.setBackgroundDrawable(f2);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            if (this.f14227a == null) {
                return this;
            }
            this.f14228b = c.a.o0.s.u.a.g(this.f14228b, i2);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            if (this.f14227a == null) {
                return this;
            }
            this.f14228b = c.a.o0.s.u.a.l(this.f14228b, i2);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            if (this.f14227a == null) {
                return this;
            }
            this.f14228b = c.a.o0.s.u.a.k(this.f14228b, i2);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public void o(int[] iArr) {
        Drawable p;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, iArr) == null) || this.f14227a == null || (p = c.a.o0.s.u.a.p(this.f14228b, iArr)) == null) {
            return;
        }
        this.f14228b = p;
        this.f14227a.setBackgroundDrawable(p);
    }

    public c p(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            View view = this.f14227a;
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
            View view = this.f14227a;
            if (view instanceof TextView) {
                ((TextView) view).setLinkTextColor(c.a.o0.s.u.a.h(i2));
                return this;
            }
            return this;
        }
        return (c) invokeI.objValue;
    }

    public void r(int i2) {
        Drawable t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || this.f14227a == null || (t = c.a.o0.s.u.a.t(this.f14228b, c.a.o0.s.u.a.E(i2))) == null) {
            return;
        }
        this.f14228b = t;
        this.f14227a.setBackgroundDrawable(t);
    }

    public c s(int i2) {
        InterceptResult invokeI;
        Drawable z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            View view = this.f14227a;
            if (view == null || (z = c.a.o0.s.u.a.z(view, this.f14228b, c.a.o0.s.u.a.E(i2))) == null) {
                return this;
            }
            this.f14228b = z;
            this.f14227a.setBackgroundDrawable(z);
            p(1);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c t(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            View view = this.f14227a;
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(c.a.o0.s.u.a.h(i2));
                return this;
            }
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c u(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            View view = this.f14227a;
            if (view instanceof EMTextView) {
                ((EMTextView) view).setLineSpacing(c.a.o0.s.u.a.m(i2), ((EMTextView) this.f14227a).getLineSpacingMultiplier());
                return this;
            }
            throw new ClassCastException("When setting line spacing, use EMTextView to ensure UI effect.");
        }
        return (c) invokeI.objValue;
    }

    public c v(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
            View view = this.f14227a;
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(c.a.o0.s.u.a.F(i2));
                return this;
            }
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c w(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            if (this.f14227a instanceof TextView) {
                float[] A = c.a.o0.s.u.a.A(i2);
                ((TextView) this.f14227a).setShadowLayer(A[1], A[2], A[3], (int) A[0]);
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
            View view = this.f14227a;
            if (view instanceof TextView) {
                ((TextView) view).setTextSize(0, c.a.o0.s.u.a.m(i2));
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
            View view = this.f14227a;
            if (view instanceof TextView) {
                ((TextView) view).setTypeface(c.a.o0.s.u.a.G(c.a.o0.s.u.a.D(i2)));
                return this;
            }
            return this;
        }
        return (c) invokeI.objValue;
    }
}
