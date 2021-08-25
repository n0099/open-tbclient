package c.a.o0.h.o0.f;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import c.a.o0.a.g1.f;
import c.a.o0.a.p.b.a.n;
import c.a.o0.a.v2.n0;
import c.a.o0.h.m0.g;
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
    public static final int f11419g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile b f11420h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f11421a;

    /* renamed from: b  reason: collision with root package name */
    public int f11422b;

    /* renamed from: c  reason: collision with root package name */
    public int f11423c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f11424d;

    /* renamed from: e  reason: collision with root package name */
    public int f11425e;

    /* renamed from: f  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f11426f;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f11427e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.h.o0.f.a f11428f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f11429g;

        public a(b bVar, View view, c.a.o0.h.o0.f.a aVar) {
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
            this.f11429g = bVar;
            this.f11427e = view;
            this.f11428f = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                View view = this.f11427e;
                if (view == null) {
                    return;
                }
                view.getWindowVisibleDisplayFrame(rect);
                int i2 = rect.bottom - rect.top;
                int n = n0.n(AppRuntime.getAppContext());
                int u = n0.u();
                if (!this.f11429g.f11424d) {
                    this.f11429g.f11424d = true;
                    this.f11429g.f11423c = (n - i2) - u;
                    if (this.f11429g.f11423c < 0) {
                        this.f11429g.f11423c = 0;
                    }
                }
                if (i2 > 0) {
                    if (i2 >= this.f11429g.f11425e || this.f11427e.getHeight() - i2 <= 200) {
                        if (i2 <= this.f11429g.f11425e || this.f11427e.getHeight() - i2 >= 200) {
                            return;
                        }
                        this.f11429g.f11425e = i2;
                        this.f11429g.s(this.f11428f);
                        return;
                    }
                    this.f11429g.f11425e = i2;
                    this.f11429g.f11422b = i2 - b.f11419g;
                    b bVar = this.f11429g;
                    bVar.f11421a = ((n - i2) - u) - bVar.f11423c;
                    if (this.f11429g.f11421a > 0) {
                        b bVar2 = this.f11429g;
                        if (bVar2.t(this.f11428f, bVar2.f11421a, this.f11429g.f11422b)) {
                            return;
                        }
                        this.f11429g.s(this.f11428f);
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1186931999, "Lc/a/o0/h/o0/f/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1186931999, "Lc/a/o0/h/o0/f/b;");
                return;
            }
        }
        f11419g = g.a(42.0f);
        f11420h = null;
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
        this.f11426f = null;
    }

    public static b p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (f11420h == null) {
                synchronized (b.class) {
                    if (f11420h == null) {
                        f11420h = new b();
                    }
                }
            }
            return f11420h;
        }
        return (b) invokeV.objValue;
    }

    public final void m(View view, c.a.o0.h.o0.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, view, aVar) == null) || view == null || aVar == null) {
            return;
        }
        this.f11425e = view.getHeight();
        this.f11426f = new a(this, view, aVar);
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.f11426f);
    }

    public boolean n(c.a.o0.h.o0.f.a aVar) {
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

    public final c.a.o0.a.l1.e.a.a o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.o0.a.l1.e.a.a aVar = new c.a.o0.a.l1.e.a.a();
            aVar.n(true);
            aVar.q(-1);
            aVar.m(-2);
            return aVar;
        }
        return (c.a.o0.a.l1.e.a.a) invokeV.objValue;
    }

    public final c.a.o0.a.l1.e.a.a q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            c.a.o0.a.l1.e.a.a aVar = new c.a.o0.a.l1.e.a.a();
            aVar.n(true);
            aVar.p(i2);
            aVar.q(-1);
            aVar.m(-2);
            return aVar;
        }
        return (c.a.o0.a.l1.e.a.a) invokeI.objValue;
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

    public boolean s(c.a.o0.h.o0.f.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            n Y = f.V().Y();
            if (Y == null) {
                return false;
            }
            FrameLayout rootView = Y.getRootView();
            if (rootView != null && this.f11426f != null) {
                rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this.f11426f);
            }
            aVar.h();
            this.f11426f = null;
            this.f11421a = -1;
            this.f11422b = -1;
            this.f11423c = -1;
            this.f11424d = false;
            this.f11425e = -1;
            return Y.removeView(aVar.f());
        }
        return invokeL.booleanValue;
    }

    public final boolean t(c.a.o0.h.o0.f.a aVar, int i2, int i3) {
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
