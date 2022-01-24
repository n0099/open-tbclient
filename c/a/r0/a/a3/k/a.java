package c.a.r0.a.a3.k;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.f;
import c.a.r0.a.k;
import c.a.r0.a.p.e.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.view.SwanAppNARootViewScrollView;
import com.baidu.swan.apps.view.narootview.SwanAppInlineFullScreenContainer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a<T extends c.a.r0.a.p.e.c> implements c.a.r0.a.h0.j.c, c.a.r0.a.a3.g.a, PullToRefreshBaseWebView.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f5405g;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f5406b;

    /* renamed from: c  reason: collision with root package name */
    public T f5407c;

    /* renamed from: d  reason: collision with root package name */
    public PullToRefreshBaseWebView f5408d;

    /* renamed from: e  reason: collision with root package name */
    public Context f5409e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.a.p.e.b f5410f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-486517758, "Lc/a/r0/a/a3/k/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-486517758, "Lc/a/r0/a/a3/k/a;");
                return;
            }
        }
        f5405g = k.a;
    }

    public a(Context context, @NonNull c.a.r0.a.p.e.b<T> bVar, @NonNull FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bVar, frameLayout};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f5409e = context;
        this.a = frameLayout;
        this.f5410f = bVar;
        e(bVar);
    }

    @Override // c.a.r0.a.a3.g.a
    public boolean a(View view, c.a.r0.a.m1.e.a.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, aVar)) == null) {
            if (view == null || this.f5406b == null || aVar == null) {
                return false;
            }
            if (f5405g) {
                String str = "updateView pos: " + aVar;
            }
            if (d(view, this.f5406b)) {
                Object tag = view.getTag(f.aiapps_na_root_view_tag);
                if (tag instanceof b) {
                    b bVar = (b) tag;
                    c.a(bVar, aVar);
                    view.setTag(f.aiapps_na_root_view_tag, bVar);
                }
                this.f5406b.updateViewLayout(view, c.b(this.f5407c, aVar));
            } else if (!g(view)) {
                return false;
            } else {
                Object tag2 = view.getTag(f.aiapps_na_root_view_tag);
                if (tag2 instanceof b) {
                    b bVar2 = (b) tag2;
                    c.a(bVar2, aVar);
                    view.setTag(f.aiapps_na_root_view_tag, bVar2);
                }
                ((ViewGroup) view.getParent()).updateViewLayout(view, c.b(this.f5407c, aVar));
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.swan.apps.core.container.PullToRefreshBaseWebView.a
    public void b(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4, i5) == null) {
            this.f5406b.scrollTo(i2, i3);
        }
    }

    @Override // c.a.r0.a.a3.g.a
    public boolean c(View view, c.a.r0.a.m1.e.a.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, aVar)) == null) {
            if (this.f5409e != null && aVar != null) {
                b bVar = new b();
                c.a(bVar, aVar);
                view.setTag(f.aiapps_na_root_view_tag, bVar);
                if (this.f5406b.indexOfChild(view) >= 0) {
                    c.a.r0.a.c0.g.a.a("NAParentViewManager", "repeat insert view!");
                    this.f5406b.removeView(view);
                }
                this.f5406b.addView(view, c.b(this.f5407c, aVar));
                return true;
            }
            boolean z = f5405g;
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean d(View view, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view, viewGroup)) == null) ? view != null && viewGroup != null && view.getParent() == viewGroup && viewGroup.indexOfChild(view) >= 0 : invokeLL.booleanValue;
    }

    public final boolean e(c.a.r0.a.p.e.b<T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
            boolean z = f5405g;
            bVar.u(this);
            T t = bVar.t();
            this.f5407c = t;
            if (t == null) {
                return false;
            }
            SwanAppNARootViewScrollView swanAppNARootViewScrollView = new SwanAppNARootViewScrollView(this.f5409e);
            this.a.addView(swanAppNARootViewScrollView, new FrameLayout.LayoutParams(-1, -1));
            this.f5406b = new FrameLayout(this.f5409e);
            swanAppNARootViewScrollView.addView(this.f5406b, new FrameLayout.LayoutParams(-1, -1));
            swanAppNARootViewScrollView.setFillViewport(true);
            PullToRefreshBaseWebView j0 = bVar.j0();
            this.f5408d = j0;
            if (j0 != null) {
                j0.setOnPullToRefreshScrollChangeListener(this);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f5410f.W(this);
        }
    }

    public final boolean g(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view)) == null) {
            if (view == null) {
                return false;
            }
            return view.getParent() instanceof SwanAppInlineFullScreenContainer;
        }
        return invokeL.booleanValue;
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f5406b.setVisibility(i2);
        }
    }

    @Override // c.a.r0.a.h0.j.c
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4, i5) == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f5406b.getLayoutParams();
            marginLayoutParams.leftMargin = -i2;
            marginLayoutParams.topMargin = -i3;
            this.f5406b.setLayoutParams(marginLayoutParams);
            for (int i6 = 0; i6 < this.f5406b.getChildCount(); i6++) {
                View childAt = this.f5406b.getChildAt(i6);
                if (childAt != null) {
                    Object tag = childAt.getTag(f.aiapps_na_root_view_tag);
                    b bVar = tag instanceof b ? (b) tag : null;
                    if (bVar != null && bVar.d()) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                        marginLayoutParams2.leftMargin = bVar.b() + i2;
                        marginLayoutParams2.topMargin = bVar.c() + i3;
                        childAt.setLayoutParams(marginLayoutParams2);
                    }
                }
            }
        }
    }

    @Override // c.a.r0.a.a3.g.a
    public boolean removeView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, view)) == null) {
            if (d(view, this.f5406b)) {
                try {
                    this.f5406b.removeView(view);
                } catch (Exception e2) {
                    if (f5405g) {
                        e2.printStackTrace();
                    }
                }
                return true;
            } else if (g(view)) {
                try {
                    ((ViewGroup) view.getParent()).removeView(view);
                } catch (Exception e3) {
                    if (f5405g) {
                        e3.printStackTrace();
                    }
                }
                return true;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
