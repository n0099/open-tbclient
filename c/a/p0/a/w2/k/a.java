package c.a.p0.a.w2.k;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.f;
import c.a.p0.a.k;
import c.a.p0.a.p.e.c;
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
public class a<T extends c.a.p0.a.p.e.c> implements c.a.p0.a.h0.j.c, c.a.p0.a.w2.g.a, PullToRefreshBaseWebView.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f9670g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrameLayout f9671a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f9672b;

    /* renamed from: c  reason: collision with root package name */
    public T f9673c;

    /* renamed from: d  reason: collision with root package name */
    public PullToRefreshBaseWebView f9674d;

    /* renamed from: e  reason: collision with root package name */
    public Context f9675e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.a.p.e.b f9676f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1571899451, "Lc/a/p0/a/w2/k/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1571899451, "Lc/a/p0/a/w2/k/a;");
                return;
            }
        }
        f9670g = k.f7077a;
    }

    public a(Context context, @NonNull c.a.p0.a.p.e.b<T> bVar, @NonNull FrameLayout frameLayout) {
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
        this.f9675e = context;
        this.f9671a = frameLayout;
        this.f9676f = bVar;
        e(bVar);
    }

    @Override // c.a.p0.a.w2.g.a
    public boolean a(View view, c.a.p0.a.l1.e.a.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, aVar)) == null) {
            if (view == null || this.f9672b == null || aVar == null) {
                return false;
            }
            if (f9670g) {
                String str = "updateView pos: " + aVar;
            }
            if (d(view, this.f9672b)) {
                Object tag = view.getTag(f.aiapps_na_root_view_tag);
                if (tag instanceof b) {
                    b bVar = (b) tag;
                    c.a(bVar, aVar);
                    view.setTag(f.aiapps_na_root_view_tag, bVar);
                }
                this.f9672b.updateViewLayout(view, c.b(this.f9673c, aVar));
            } else if (!g(view)) {
                return false;
            } else {
                Object tag2 = view.getTag(f.aiapps_na_root_view_tag);
                if (tag2 instanceof b) {
                    b bVar2 = (b) tag2;
                    c.a(bVar2, aVar);
                    view.setTag(f.aiapps_na_root_view_tag, bVar2);
                }
                ((ViewGroup) view.getParent()).updateViewLayout(view, c.b(this.f9673c, aVar));
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.swan.apps.core.container.PullToRefreshBaseWebView.a
    public void b(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4, i5) == null) {
            this.f9672b.scrollTo(i2, i3);
        }
    }

    @Override // c.a.p0.a.w2.g.a
    public boolean c(View view, c.a.p0.a.l1.e.a.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, aVar)) == null) {
            if (this.f9675e != null && aVar != null) {
                b bVar = new b();
                c.a(bVar, aVar);
                view.setTag(f.aiapps_na_root_view_tag, bVar);
                if (this.f9672b.indexOfChild(view) >= 0) {
                    c.a.p0.a.c0.g.a.a("NAParentViewManager", "repeat insert view!");
                    this.f9672b.removeView(view);
                }
                this.f9672b.addView(view, c.b(this.f9673c, aVar));
                return true;
            }
            boolean z = f9670g;
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean d(View view, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view, viewGroup)) == null) ? view != null && viewGroup != null && view.getParent() == viewGroup && viewGroup.indexOfChild(view) >= 0 : invokeLL.booleanValue;
    }

    public final boolean e(c.a.p0.a.p.e.b<T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
            boolean z = f9670g;
            bVar.u(this);
            T t = bVar.t();
            this.f9673c = t;
            if (t == null) {
                return false;
            }
            SwanAppNARootViewScrollView swanAppNARootViewScrollView = new SwanAppNARootViewScrollView(this.f9675e);
            this.f9671a.addView(swanAppNARootViewScrollView, new FrameLayout.LayoutParams(-1, -1));
            this.f9672b = new FrameLayout(this.f9675e);
            swanAppNARootViewScrollView.addView(this.f9672b, new FrameLayout.LayoutParams(-1, -1));
            swanAppNARootViewScrollView.setFillViewport(true);
            PullToRefreshBaseWebView g0 = bVar.g0();
            this.f9674d = g0;
            if (g0 != null) {
                g0.setOnPullToRefreshScrollChangeListener(this);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f9676f.U(this);
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
            this.f9672b.setVisibility(i2);
        }
    }

    @Override // c.a.p0.a.h0.j.c
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4, i5) == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f9672b.getLayoutParams();
            marginLayoutParams.leftMargin = -i2;
            marginLayoutParams.topMargin = -i3;
            this.f9672b.setLayoutParams(marginLayoutParams);
            for (int i6 = 0; i6 < this.f9672b.getChildCount(); i6++) {
                View childAt = this.f9672b.getChildAt(i6);
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

    @Override // c.a.p0.a.w2.g.a
    public boolean removeView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, view)) == null) {
            if (d(view, this.f9672b)) {
                try {
                    this.f9672b.removeView(view);
                } catch (Exception e2) {
                    if (f9670g) {
                        e2.printStackTrace();
                    }
                }
                return true;
            } else if (g(view)) {
                try {
                    ((ViewGroup) view.getParent()).removeView(view);
                } catch (Exception e3) {
                    if (f9670g) {
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
