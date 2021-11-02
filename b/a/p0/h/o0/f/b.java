package b.a.p0.h.o0.f;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import b.a.p0.a.g1.f;
import b.a.p0.a.p.b.a.n;
import b.a.p0.a.v2.n0;
import b.a.p0.h.m0.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final int f10647g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile b f10648h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f10649a;

    /* renamed from: b  reason: collision with root package name */
    public int f10650b;

    /* renamed from: c  reason: collision with root package name */
    public int f10651c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f10652d;

    /* renamed from: e  reason: collision with root package name */
    public int f10653e;

    /* renamed from: f  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f10654f;

    /* loaded from: classes4.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f10655e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.h.o0.f.a f10656f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f10657g;

        public a(b bVar, View view, b.a.p0.h.o0.f.a aVar) {
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
            this.f10657g = bVar;
            this.f10655e = view;
            this.f10656f = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                View view = this.f10655e;
                if (view == null) {
                    return;
                }
                view.getWindowVisibleDisplayFrame(rect);
                int i2 = rect.bottom - rect.top;
                int n = n0.n(AppRuntime.getAppContext());
                int u = n0.u();
                if (!this.f10657g.f10652d) {
                    this.f10657g.f10652d = true;
                    this.f10657g.f10651c = (n - i2) - u;
                    if (this.f10657g.f10651c < 0) {
                        this.f10657g.f10651c = 0;
                    }
                }
                if (i2 > 0) {
                    if (i2 >= this.f10657g.f10653e || this.f10655e.getHeight() - i2 <= 200) {
                        if (i2 <= this.f10657g.f10653e || this.f10655e.getHeight() - i2 >= 200) {
                            return;
                        }
                        this.f10657g.f10653e = i2;
                        this.f10657g.s(this.f10656f);
                        return;
                    }
                    this.f10657g.f10653e = i2;
                    this.f10657g.f10650b = i2 - b.f10647g;
                    b bVar = this.f10657g;
                    bVar.f10649a = ((n - i2) - u) - bVar.f10651c;
                    if (this.f10657g.f10649a > 0) {
                        b bVar2 = this.f10657g;
                        if (bVar2.t(this.f10656f, bVar2.f10649a, this.f10657g.f10650b)) {
                            return;
                        }
                        this.f10657g.s(this.f10656f);
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-547315103, "Lb/a/p0/h/o0/f/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-547315103, "Lb/a/p0/h/o0/f/b;");
                return;
            }
        }
        f10647g = g.a(42.0f);
        f10648h = null;
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
        this.f10654f = null;
    }

    public static b p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (f10648h == null) {
                synchronized (b.class) {
                    if (f10648h == null) {
                        f10648h = new b();
                    }
                }
            }
            return f10648h;
        }
        return (b) invokeV.objValue;
    }

    public final void m(View view, b.a.p0.h.o0.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, view, aVar) == null) || view == null || aVar == null) {
            return;
        }
        this.f10653e = view.getHeight();
        this.f10654f = new a(this, view, aVar);
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.f10654f);
    }

    public boolean n(b.a.p0.h.o0.f.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            n W = f.T().W();
            boolean z = (W == null || r(aVar.f()) || !W.c(aVar.f(), o())) ? false : true;
            if (z) {
                if (!aVar.l() || W == null) {
                    return false;
                }
                m(W.getRootView(), aVar);
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final b.a.p0.a.l1.e.a.a o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b.a.p0.a.l1.e.a.a aVar = new b.a.p0.a.l1.e.a.a();
            aVar.l(true);
            aVar.o(-1);
            aVar.k(-2);
            return aVar;
        }
        return (b.a.p0.a.l1.e.a.a) invokeV.objValue;
    }

    public final b.a.p0.a.l1.e.a.a q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            b.a.p0.a.l1.e.a.a aVar = new b.a.p0.a.l1.e.a.a();
            aVar.l(true);
            aVar.n(i2);
            aVar.o(-1);
            aVar.k(-2);
            return aVar;
        }
        return (b.a.p0.a.l1.e.a.a) invokeI.objValue;
    }

    public final boolean r(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) {
            n W = f.T().W();
            return W != null && W.d(view);
        }
        return invokeL.booleanValue;
    }

    public boolean s(b.a.p0.h.o0.f.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            n W = f.T().W();
            if (W == null) {
                return false;
            }
            FrameLayout rootView = W.getRootView();
            if (rootView != null && this.f10654f != null) {
                rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this.f10654f);
            }
            aVar.h();
            this.f10654f = null;
            this.f10649a = -1;
            this.f10650b = -1;
            this.f10651c = -1;
            this.f10652d = false;
            this.f10653e = -1;
            return W.removeView(aVar.f());
        }
        return invokeL.booleanValue;
    }

    public final boolean t(b.a.p0.h.o0.f.a aVar, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, aVar, i2, i3)) == null) {
            n W = f.T().W();
            boolean z = W != null && W.a(aVar.f(), q(i3));
            if (z) {
                aVar.k(i2);
            }
            return z;
        }
        return invokeLII.booleanValue;
    }
}
