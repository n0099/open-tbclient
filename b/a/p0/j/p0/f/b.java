package b.a.p0.j.p0.f;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import b.a.p0.a.g1.f;
import b.a.p0.a.p.b.a.n;
import b.a.p0.a.z2.n0;
import b.a.p0.j.n0.g;
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
    public static final int f11364g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile b f11365h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f11366a;

    /* renamed from: b  reason: collision with root package name */
    public int f11367b;

    /* renamed from: c  reason: collision with root package name */
    public int f11368c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f11369d;

    /* renamed from: e  reason: collision with root package name */
    public int f11370e;

    /* renamed from: f  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f11371f;

    /* loaded from: classes4.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f11372e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.j.p0.f.a f11373f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f11374g;

        public a(b bVar, View view, b.a.p0.j.p0.f.a aVar) {
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
            this.f11374g = bVar;
            this.f11372e = view;
            this.f11373f = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                View view = this.f11372e;
                if (view == null) {
                    return;
                }
                view.getWindowVisibleDisplayFrame(rect);
                int i2 = rect.bottom - rect.top;
                int n = n0.n(AppRuntime.getAppContext());
                int t = n0.t();
                if (!this.f11374g.f11369d) {
                    this.f11374g.f11369d = true;
                    this.f11374g.f11368c = (n - i2) - t;
                    if (this.f11374g.f11368c < 0) {
                        this.f11374g.f11368c = 0;
                    }
                }
                if (i2 > 0) {
                    if (i2 >= this.f11374g.f11370e || this.f11372e.getHeight() - i2 <= 200) {
                        if (i2 <= this.f11374g.f11370e || this.f11372e.getHeight() - i2 >= 200) {
                            return;
                        }
                        this.f11374g.f11370e = i2;
                        this.f11374g.s(this.f11373f);
                        return;
                    }
                    this.f11374g.f11370e = i2;
                    this.f11374g.f11367b = i2 - b.f11364g;
                    b bVar = this.f11374g;
                    bVar.f11366a = ((n - i2) - t) - bVar.f11368c;
                    if (this.f11374g.f11366a > 0) {
                        b bVar2 = this.f11374g;
                        if (bVar2.t(this.f11373f, bVar2.f11366a, this.f11374g.f11367b)) {
                            return;
                        }
                        this.f11374g.s(this.f11373f);
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1020246948, "Lb/a/p0/j/p0/f/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1020246948, "Lb/a/p0/j/p0/f/b;");
                return;
            }
        }
        f11364g = g.a(42.0f);
        f11365h = null;
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
        this.f11371f = null;
    }

    public static b p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (f11365h == null) {
                synchronized (b.class) {
                    if (f11365h == null) {
                        f11365h = new b();
                    }
                }
            }
            return f11365h;
        }
        return (b) invokeV.objValue;
    }

    public final void m(View view, b.a.p0.j.p0.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, view, aVar) == null) || view == null || aVar == null) {
            return;
        }
        this.f11370e = view.getHeight();
        this.f11371f = new a(this, view, aVar);
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.f11371f);
    }

    public boolean n(b.a.p0.j.p0.f.a aVar) {
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

    public final b.a.p0.a.m1.e.a.a o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b.a.p0.a.m1.e.a.a aVar = new b.a.p0.a.m1.e.a.a();
            aVar.l(true);
            aVar.o(-1);
            aVar.k(-2);
            return aVar;
        }
        return (b.a.p0.a.m1.e.a.a) invokeV.objValue;
    }

    public final b.a.p0.a.m1.e.a.a q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            b.a.p0.a.m1.e.a.a aVar = new b.a.p0.a.m1.e.a.a();
            aVar.l(true);
            aVar.n(i2);
            aVar.o(-1);
            aVar.k(-2);
            return aVar;
        }
        return (b.a.p0.a.m1.e.a.a) invokeI.objValue;
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

    public boolean s(b.a.p0.j.p0.f.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            n X = f.U().X();
            if (X == null) {
                return false;
            }
            FrameLayout rootView = X.getRootView();
            if (rootView != null && this.f11371f != null) {
                rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this.f11371f);
            }
            aVar.h();
            this.f11371f = null;
            this.f11366a = -1;
            this.f11367b = -1;
            this.f11368c = -1;
            this.f11369d = false;
            this.f11370e = -1;
            return X.removeView(aVar.f());
        }
        return invokeL.booleanValue;
    }

    public final boolean t(b.a.p0.j.p0.f.a aVar, int i2, int i3) {
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
