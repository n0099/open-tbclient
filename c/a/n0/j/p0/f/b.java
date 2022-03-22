package c.a.n0.j.p0.f;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import c.a.n0.a.f.b.a.n;
import c.a.n0.a.p2.n0;
import c.a.n0.a.w0.f;
import c.a.n0.j.n0.g;
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
    public static final int f8879g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile b f8880h;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f8881b;

    /* renamed from: c  reason: collision with root package name */
    public int f8882c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8883d;

    /* renamed from: e  reason: collision with root package name */
    public int f8884e;

    /* renamed from: f  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f8885f;

    /* loaded from: classes2.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.j.p0.f.a f8886b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f8887c;

        public a(b bVar, View view, c.a.n0.j.p0.f.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, view, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8887c = bVar;
            this.a = view;
            this.f8886b = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                View view = this.a;
                if (view == null) {
                    return;
                }
                view.getWindowVisibleDisplayFrame(rect);
                int i = rect.bottom - rect.top;
                int n = n0.n(AppRuntime.getAppContext());
                int t = n0.t();
                if (!this.f8887c.f8883d) {
                    this.f8887c.f8883d = true;
                    this.f8887c.f8882c = (n - i) - t;
                    if (this.f8887c.f8882c < 0) {
                        this.f8887c.f8882c = 0;
                    }
                }
                if (i > 0) {
                    if (i >= this.f8887c.f8884e || this.a.getHeight() - i <= 200) {
                        if (i <= this.f8887c.f8884e || this.a.getHeight() - i >= 200) {
                            return;
                        }
                        this.f8887c.f8884e = i;
                        this.f8887c.s(this.f8886b);
                        return;
                    }
                    this.f8887c.f8884e = i;
                    this.f8887c.f8881b = i - b.f8879g;
                    b bVar = this.f8887c;
                    bVar.a = ((n - i) - t) - bVar.f8882c;
                    if (this.f8887c.a > 0) {
                        b bVar2 = this.f8887c;
                        if (bVar2.t(this.f8886b, bVar2.a, this.f8887c.f8881b)) {
                            return;
                        }
                        this.f8887c.s(this.f8886b);
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(251547333, "Lc/a/n0/j/p0/f/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(251547333, "Lc/a/n0/j/p0/f/b;");
                return;
            }
        }
        f8879g = g.a(42.0f);
        f8880h = null;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f8885f = null;
    }

    public static b p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (f8880h == null) {
                synchronized (b.class) {
                    if (f8880h == null) {
                        f8880h = new b();
                    }
                }
            }
            return f8880h;
        }
        return (b) invokeV.objValue;
    }

    public final void m(View view, c.a.n0.j.p0.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, view, aVar) == null) || view == null || aVar == null) {
            return;
        }
        this.f8884e = view.getHeight();
        this.f8885f = new a(this, view, aVar);
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.f8885f);
    }

    public boolean n(c.a.n0.j.p0.f.a aVar) {
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

    public final c.a.n0.a.c1.e.a.a o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.n0.a.c1.e.a.a aVar = new c.a.n0.a.c1.e.a.a();
            aVar.k(true);
            aVar.n(-1);
            aVar.j(-2);
            return aVar;
        }
        return (c.a.n0.a.c1.e.a.a) invokeV.objValue;
    }

    public final c.a.n0.a.c1.e.a.a q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            c.a.n0.a.c1.e.a.a aVar = new c.a.n0.a.c1.e.a.a();
            aVar.k(true);
            aVar.m(i);
            aVar.n(-1);
            aVar.j(-2);
            return aVar;
        }
        return (c.a.n0.a.c1.e.a.a) invokeI.objValue;
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

    public boolean s(c.a.n0.j.p0.f.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            n X = f.U().X();
            if (X == null) {
                return false;
            }
            FrameLayout rootView = X.getRootView();
            if (rootView != null && this.f8885f != null) {
                rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this.f8885f);
            }
            aVar.h();
            this.f8885f = null;
            this.a = -1;
            this.f8881b = -1;
            this.f8882c = -1;
            this.f8883d = false;
            this.f8884e = -1;
            return X.removeView(aVar.f());
        }
        return invokeL.booleanValue;
    }

    public final boolean t(c.a.n0.j.p0.f.a aVar, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, aVar, i, i2)) == null) {
            n X = f.U().X();
            boolean z = X != null && X.a(aVar.f(), q(i2));
            if (z) {
                aVar.k(i);
            }
            return z;
        }
        return invokeLII.booleanValue;
    }
}
