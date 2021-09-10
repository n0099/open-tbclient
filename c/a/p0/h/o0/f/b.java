package c.a.p0.h.o0.f;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import c.a.p0.a.g1.f;
import c.a.p0.a.p.b.a.n;
import c.a.p0.a.v2.n0;
import c.a.p0.h.m0.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final int f11447g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile b f11448h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f11449a;

    /* renamed from: b  reason: collision with root package name */
    public int f11450b;

    /* renamed from: c  reason: collision with root package name */
    public int f11451c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f11452d;

    /* renamed from: e  reason: collision with root package name */
    public int f11453e;

    /* renamed from: f  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f11454f;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f11455e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.h.o0.f.a f11456f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f11457g;

        public a(b bVar, View view, c.a.p0.h.o0.f.a aVar) {
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
            this.f11457g = bVar;
            this.f11455e = view;
            this.f11456f = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                View view = this.f11455e;
                if (view == null) {
                    return;
                }
                view.getWindowVisibleDisplayFrame(rect);
                int i2 = rect.bottom - rect.top;
                int n = n0.n(AppRuntime.getAppContext());
                int u = n0.u();
                if (!this.f11457g.f11452d) {
                    this.f11457g.f11452d = true;
                    this.f11457g.f11451c = (n - i2) - u;
                    if (this.f11457g.f11451c < 0) {
                        this.f11457g.f11451c = 0;
                    }
                }
                if (i2 > 0) {
                    if (i2 >= this.f11457g.f11453e || this.f11455e.getHeight() - i2 <= 200) {
                        if (i2 <= this.f11457g.f11453e || this.f11455e.getHeight() - i2 >= 200) {
                            return;
                        }
                        this.f11457g.f11453e = i2;
                        this.f11457g.s(this.f11456f);
                        return;
                    }
                    this.f11457g.f11453e = i2;
                    this.f11457g.f11450b = i2 - b.f11447g;
                    b bVar = this.f11457g;
                    bVar.f11449a = ((n - i2) - u) - bVar.f11451c;
                    if (this.f11457g.f11449a > 0) {
                        b bVar2 = this.f11457g;
                        if (bVar2.t(this.f11456f, bVar2.f11449a, this.f11457g.f11450b)) {
                            return;
                        }
                        this.f11457g.s(this.f11456f);
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1057849280, "Lc/a/p0/h/o0/f/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1057849280, "Lc/a/p0/h/o0/f/b;");
                return;
            }
        }
        f11447g = g.a(42.0f);
        f11448h = null;
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
        this.f11454f = null;
    }

    public static b p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (f11448h == null) {
                synchronized (b.class) {
                    if (f11448h == null) {
                        f11448h = new b();
                    }
                }
            }
            return f11448h;
        }
        return (b) invokeV.objValue;
    }

    public final void m(View view, c.a.p0.h.o0.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, view, aVar) == null) || view == null || aVar == null) {
            return;
        }
        this.f11453e = view.getHeight();
        this.f11454f = new a(this, view, aVar);
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.f11454f);
    }

    public boolean n(c.a.p0.h.o0.f.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            n Y = f.V().Y();
            boolean z = (Y == null || r(aVar.f()) || !Y.c(aVar.f(), o())) ? false : true;
            if (z) {
                if (!aVar.l() || Y == null) {
                    return false;
                }
                m(Y.getRootView(), aVar);
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final c.a.p0.a.l1.e.a.a o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.p0.a.l1.e.a.a aVar = new c.a.p0.a.l1.e.a.a();
            aVar.n(true);
            aVar.q(-1);
            aVar.m(-2);
            return aVar;
        }
        return (c.a.p0.a.l1.e.a.a) invokeV.objValue;
    }

    public final c.a.p0.a.l1.e.a.a q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            c.a.p0.a.l1.e.a.a aVar = new c.a.p0.a.l1.e.a.a();
            aVar.n(true);
            aVar.p(i2);
            aVar.q(-1);
            aVar.m(-2);
            return aVar;
        }
        return (c.a.p0.a.l1.e.a.a) invokeI.objValue;
    }

    public final boolean r(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) {
            n Y = f.V().Y();
            return Y != null && Y.d(view);
        }
        return invokeL.booleanValue;
    }

    public boolean s(c.a.p0.h.o0.f.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            n Y = f.V().Y();
            if (Y == null) {
                return false;
            }
            FrameLayout rootView = Y.getRootView();
            if (rootView != null && this.f11454f != null) {
                rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this.f11454f);
            }
            aVar.h();
            this.f11454f = null;
            this.f11449a = -1;
            this.f11450b = -1;
            this.f11451c = -1;
            this.f11452d = false;
            this.f11453e = -1;
            return Y.removeView(aVar.f());
        }
        return invokeL.booleanValue;
    }

    public final boolean t(c.a.p0.h.o0.f.a aVar, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, aVar, i2, i3)) == null) {
            n Y = f.V().Y();
            boolean z = Y != null && Y.a(aVar.f(), q(i3));
            if (z) {
                aVar.k(i2);
            }
            return z;
        }
        return invokeLII.booleanValue;
    }
}
