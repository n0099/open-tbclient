package c.a.q0.j.p0.f;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import c.a.q0.a.g1.f;
import c.a.q0.a.p.b.a.n;
import c.a.q0.a.z2.n0;
import c.a.q0.j.n0.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final int f10695g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile b f10696h;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f10697b;

    /* renamed from: c  reason: collision with root package name */
    public int f10698c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f10699d;

    /* renamed from: e  reason: collision with root package name */
    public int f10700e;

    /* renamed from: f  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f10701f;

    /* loaded from: classes6.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f10702e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.j.p0.f.a f10703f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f10704g;

        public a(b bVar, View view, c.a.q0.j.p0.f.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, view, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10704g = bVar;
            this.f10702e = view;
            this.f10703f = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                View view = this.f10702e;
                if (view == null) {
                    return;
                }
                view.getWindowVisibleDisplayFrame(rect);
                int i2 = rect.bottom - rect.top;
                int n = n0.n(AppRuntime.getAppContext());
                int t = n0.t();
                if (!this.f10704g.f10699d) {
                    this.f10704g.f10699d = true;
                    this.f10704g.f10698c = (n - i2) - t;
                    if (this.f10704g.f10698c < 0) {
                        this.f10704g.f10698c = 0;
                    }
                }
                if (i2 > 0) {
                    if (i2 >= this.f10704g.f10700e || this.f10702e.getHeight() - i2 <= 200) {
                        if (i2 <= this.f10704g.f10700e || this.f10702e.getHeight() - i2 >= 200) {
                            return;
                        }
                        this.f10704g.f10700e = i2;
                        this.f10704g.s(this.f10703f);
                        return;
                    }
                    this.f10704g.f10700e = i2;
                    this.f10704g.f10697b = i2 - b.f10695g;
                    b bVar = this.f10704g;
                    bVar.a = ((n - i2) - t) - bVar.f10698c;
                    if (this.f10704g.a > 0) {
                        b bVar2 = this.f10704g;
                        if (bVar2.t(this.f10703f, bVar2.a, this.f10704g.f10697b)) {
                            return;
                        }
                        this.f10704g.s(this.f10703f);
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(638795490, "Lc/a/q0/j/p0/f/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(638795490, "Lc/a/q0/j/p0/f/b;");
                return;
            }
        }
        f10695g = g.a(42.0f);
        f10696h = null;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f10701f = null;
    }

    public static b p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (f10696h == null) {
                synchronized (b.class) {
                    if (f10696h == null) {
                        f10696h = new b();
                    }
                }
            }
            return f10696h;
        }
        return (b) invokeV.objValue;
    }

    public final void m(View view, c.a.q0.j.p0.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, view, aVar) == null) || view == null || aVar == null) {
            return;
        }
        this.f10700e = view.getHeight();
        this.f10701f = new a(this, view, aVar);
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.f10701f);
    }

    public boolean n(c.a.q0.j.p0.f.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            n X = f.U().X();
            boolean z = (X == null || r(aVar.f()) || !X.c(aVar.f(), o())) ? false : true;
            if (z) {
                if (!aVar.l() || X == null) {
                    return false;
                }
                m(X.getRootView(), aVar);
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final c.a.q0.a.m1.e.a.a o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.q0.a.m1.e.a.a aVar = new c.a.q0.a.m1.e.a.a();
            aVar.l(true);
            aVar.o(-1);
            aVar.k(-2);
            return aVar;
        }
        return (c.a.q0.a.m1.e.a.a) invokeV.objValue;
    }

    public final c.a.q0.a.m1.e.a.a q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            c.a.q0.a.m1.e.a.a aVar = new c.a.q0.a.m1.e.a.a();
            aVar.l(true);
            aVar.n(i2);
            aVar.o(-1);
            aVar.k(-2);
            return aVar;
        }
        return (c.a.q0.a.m1.e.a.a) invokeI.objValue;
    }

    public final boolean r(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) {
            n X = f.U().X();
            return X != null && X.d(view);
        }
        return invokeL.booleanValue;
    }

    public boolean s(c.a.q0.j.p0.f.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            n X = f.U().X();
            if (X == null) {
                return false;
            }
            FrameLayout rootView = X.getRootView();
            if (rootView != null && this.f10701f != null) {
                rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this.f10701f);
            }
            aVar.h();
            this.f10701f = null;
            this.a = -1;
            this.f10697b = -1;
            this.f10698c = -1;
            this.f10699d = false;
            this.f10700e = -1;
            return X.removeView(aVar.f());
        }
        return invokeL.booleanValue;
    }

    public final boolean t(c.a.q0.j.p0.f.a aVar, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, aVar, i2, i3)) == null) {
            n X = f.U().X();
            boolean z = X != null && X.a(aVar.f(), q(i3));
            if (z) {
                aVar.k(i2);
            }
            return z;
        }
        return invokeLII.booleanValue;
    }
}
