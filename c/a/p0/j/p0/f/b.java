package c.a.p0.j.p0.f;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import c.a.p0.a.f.b.a.n;
import c.a.p0.a.p2.n0;
import c.a.p0.a.w0.f;
import c.a.p0.j.n0.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final int f10641g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile b f10642h;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f10643b;

    /* renamed from: c  reason: collision with root package name */
    public int f10644c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f10645d;

    /* renamed from: e  reason: collision with root package name */
    public int f10646e;

    /* renamed from: f  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f10647f;

    /* loaded from: classes2.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f10648e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.j.p0.f.a f10649f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f10650g;

        public a(b bVar, View view, c.a.p0.j.p0.f.a aVar) {
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
            this.f10650g = bVar;
            this.f10648e = view;
            this.f10649f = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                View view = this.f10648e;
                if (view == null) {
                    return;
                }
                view.getWindowVisibleDisplayFrame(rect);
                int i2 = rect.bottom - rect.top;
                int n = n0.n(AppRuntime.getAppContext());
                int t = n0.t();
                if (!this.f10650g.f10645d) {
                    this.f10650g.f10645d = true;
                    this.f10650g.f10644c = (n - i2) - t;
                    if (this.f10650g.f10644c < 0) {
                        this.f10650g.f10644c = 0;
                    }
                }
                if (i2 > 0) {
                    if (i2 >= this.f10650g.f10646e || this.f10648e.getHeight() - i2 <= 200) {
                        if (i2 <= this.f10650g.f10646e || this.f10648e.getHeight() - i2 >= 200) {
                            return;
                        }
                        this.f10650g.f10646e = i2;
                        this.f10650g.s(this.f10649f);
                        return;
                    }
                    this.f10650g.f10646e = i2;
                    this.f10650g.f10643b = i2 - b.f10641g;
                    b bVar = this.f10650g;
                    bVar.a = ((n - i2) - t) - bVar.f10644c;
                    if (this.f10650g.a > 0) {
                        b bVar2 = this.f10650g;
                        if (bVar2.t(this.f10649f, bVar2.a, this.f10650g.f10643b)) {
                            return;
                        }
                        this.f10650g.s(this.f10649f);
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(509712771, "Lc/a/p0/j/p0/f/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(509712771, "Lc/a/p0/j/p0/f/b;");
                return;
            }
        }
        f10641g = g.a(42.0f);
        f10642h = null;
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
        this.f10647f = null;
    }

    public static b p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (f10642h == null) {
                synchronized (b.class) {
                    if (f10642h == null) {
                        f10642h = new b();
                    }
                }
            }
            return f10642h;
        }
        return (b) invokeV.objValue;
    }

    public final void m(View view, c.a.p0.j.p0.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, view, aVar) == null) || view == null || aVar == null) {
            return;
        }
        this.f10646e = view.getHeight();
        this.f10647f = new a(this, view, aVar);
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.f10647f);
    }

    public boolean n(c.a.p0.j.p0.f.a aVar) {
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

    public final c.a.p0.a.c1.e.a.a o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.p0.a.c1.e.a.a aVar = new c.a.p0.a.c1.e.a.a();
            aVar.l(true);
            aVar.o(-1);
            aVar.k(-2);
            return aVar;
        }
        return (c.a.p0.a.c1.e.a.a) invokeV.objValue;
    }

    public final c.a.p0.a.c1.e.a.a q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            c.a.p0.a.c1.e.a.a aVar = new c.a.p0.a.c1.e.a.a();
            aVar.l(true);
            aVar.n(i2);
            aVar.o(-1);
            aVar.k(-2);
            return aVar;
        }
        return (c.a.p0.a.c1.e.a.a) invokeI.objValue;
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

    public boolean s(c.a.p0.j.p0.f.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            n X = f.U().X();
            if (X == null) {
                return false;
            }
            FrameLayout rootView = X.getRootView();
            if (rootView != null && this.f10647f != null) {
                rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this.f10647f);
            }
            aVar.h();
            this.f10647f = null;
            this.a = -1;
            this.f10643b = -1;
            this.f10644c = -1;
            this.f10645d = false;
            this.f10646e = -1;
            return X.removeView(aVar.f());
        }
        return invokeL.booleanValue;
    }

    public final boolean t(c.a.p0.j.p0.f.a aVar, int i2, int i3) {
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
