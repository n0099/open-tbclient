package c.a.o0.r.v;

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
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public Drawable f11107b;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f11108b;

        public a(c cVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11108b = cVar;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c cVar = this.f11108b;
                cVar.f11107b = c.a.o0.r.v.a.C(cVar.f11107b, this.a, this.f11108b.a.getMeasuredHeight());
                this.f11108b.a.setBackgroundDrawable(this.f11108b.f11107b);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f11109b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f11110c;

        public b(c cVar, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11110c = cVar;
            this.a = i;
            this.f11109b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c cVar = this.f11110c;
                cVar.f11107b = c.a.o0.r.v.a.D(cVar.f11107b, this.a, this.f11109b, this.f11110c.a.getMeasuredHeight());
                this.f11110c.a.setBackgroundDrawable(this.f11110c.f11107b);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = view;
        this.f11107b = c.a.o0.r.v.a.d(view);
    }

    public static c d(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, view)) == null) ? new c(view) : (c) invokeL.objValue;
    }

    public c A(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            View view = this.a;
            if (view instanceof TextView) {
                ((TextView) view).setTypeface(c.a.o0.r.v.a.H(c.a.o0.r.v.a.E(i)));
                return this;
            }
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (this.a == null) {
                return this;
            }
            this.f11107b = c.a.o0.r.v.a.b(this.f11107b, i);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public void f(int i) {
        Drawable i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || this.a == null || (i2 = c.a.o0.r.v.a.i(this.f11107b, i)) == null) {
            return;
        }
        this.f11107b = i2;
        this.a.setBackgroundDrawable(i2);
    }

    public void g(int i) {
        Drawable w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || this.a == null || (w = c.a.o0.r.v.a.w(this.f11107b, i)) == null) {
            return;
        }
        this.f11107b = w;
        this.a.setBackgroundDrawable(w);
    }

    public void h(int i) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || (view = this.a) == null) {
            return;
        }
        view.post(new a(this, i));
    }

    public void i(int i, int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) || (view = this.a) == null) {
            return;
        }
        view.post(new b(this, i, i2));
    }

    public c j(int i) {
        InterceptResult invokeI;
        Drawable e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (this.a == null || (e2 = c.a.o0.r.v.a.e(this.f11107b, i)) == null) {
                return this;
            }
            this.f11107b = e2;
            this.a.setBackgroundDrawable(e2);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c k(int i) {
        InterceptResult invokeI;
        Drawable f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            if (this.a == null || (f2 = c.a.o0.r.v.a.f(this.f11107b, i)) == null) {
                return this;
            }
            this.f11107b = f2;
            this.a.setBackgroundDrawable(f2);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            if (this.a == null) {
                return this;
            }
            this.f11107b = c.a.o0.r.v.a.g(this.f11107b, i);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            if (this.a == null) {
                return this;
            }
            this.f11107b = c.a.o0.r.v.a.l(this.f11107b, i);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            if (this.a == null) {
                return this;
            }
            this.f11107b = c.a.o0.r.v.a.k(this.f11107b, i);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public void o(int[] iArr) {
        Drawable p;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, iArr) == null) || this.a == null || (p = c.a.o0.r.v.a.p(this.f11107b, Direction.BOTTOM, iArr)) == null) {
            return;
        }
        this.f11107b = p;
        this.a.setBackgroundDrawable(p);
    }

    public void p(int[] iArr, Direction direction) {
        Drawable p;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, iArr, direction) == null) || this.a == null || (p = c.a.o0.r.v.a.p(this.f11107b, direction, iArr)) == null) {
            return;
        }
        this.f11107b = p;
        this.a.setBackgroundDrawable(p);
    }

    public c q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            View view = this.a;
            if (view == null) {
                return this;
            }
            view.setLayerType(i, null);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c r(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            View view = this.a;
            if (view instanceof TextView) {
                ((TextView) view).setLinkTextColor(c.a.o0.r.v.a.h(i));
                return this;
            }
            return this;
        }
        return (c) invokeI.objValue;
    }

    public void s(int i) {
        Drawable t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i) == null) || this.a == null || (t = c.a.o0.r.v.a.t(this.f11107b, c.a.o0.r.v.a.F(i))) == null) {
            return;
        }
        this.f11107b = t;
        this.a.setBackgroundDrawable(t);
    }

    public c t(int i) {
        InterceptResult invokeI;
        Drawable v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            if (this.a == null || (v = c.a.o0.r.v.a.v(this.f11107b, i)) == null) {
                return this;
            }
            this.f11107b = v;
            this.a.setBackgroundDrawable(v);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c u(int i) {
        InterceptResult invokeI;
        Drawable A;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            View view = this.a;
            if (view == null || (A = c.a.o0.r.v.a.A(view, this.f11107b, c.a.o0.r.v.a.F(i))) == null) {
                return this;
            }
            this.f11107b = A;
            this.a.setBackgroundDrawable(A);
            q(1);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c v(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            View view = this.a;
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(c.a.o0.r.v.a.h(i));
                return this;
            }
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c w(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            View view = this.a;
            if (view instanceof EMTextView) {
                ((EMTextView) view).setLineSpacing(c.a.o0.r.v.a.m(i), ((EMTextView) this.a).getLineSpacingMultiplier());
                return this;
            }
            throw new ClassCastException("When setting line spacing, use EMTextView to ensure UI effect.");
        }
        return (c) invokeI.objValue;
    }

    public c x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i)) == null) {
            View view = this.a;
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(c.a.o0.r.v.a.G(i));
                return this;
            }
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c y(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
            if (this.a instanceof TextView) {
                float[] B = c.a.o0.r.v.a.B(i);
                ((TextView) this.a).setShadowLayer(B[1], B[2], B[3], (int) B[0]);
                return this;
            }
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
            View view = this.a;
            if (view instanceof TextView) {
                ((TextView) view).setTextSize(0, c.a.o0.r.v.a.m(i));
                return this;
            }
            return this;
        }
        return (c) invokeI.objValue;
    }
}
