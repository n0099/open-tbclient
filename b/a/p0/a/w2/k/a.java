package b.a.p0.a.w2.k;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.f;
import b.a.p0.a.k;
import b.a.p0.a.p.e.c;
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
public class a<T extends b.a.p0.a.p.e.c> implements b.a.p0.a.h0.j.c, b.a.p0.a.w2.g.a, PullToRefreshBaseWebView.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f8915g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrameLayout f8916a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f8917b;

    /* renamed from: c  reason: collision with root package name */
    public T f8918c;

    /* renamed from: d  reason: collision with root package name */
    public PullToRefreshBaseWebView f8919d;

    /* renamed from: e  reason: collision with root package name */
    public Context f8920e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.p0.a.p.e.b f8921f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2082433628, "Lb/a/p0/a/w2/k/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2082433628, "Lb/a/p0/a/w2/k/a;");
                return;
            }
        }
        f8915g = k.f6397a;
    }

    public a(Context context, @NonNull b.a.p0.a.p.e.b<T> bVar, @NonNull FrameLayout frameLayout) {
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
        this.f8920e = context;
        this.f8916a = frameLayout;
        this.f8921f = bVar;
        e(bVar);
    }

    @Override // b.a.p0.a.w2.g.a
    public boolean a(View view, b.a.p0.a.l1.e.a.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, aVar)) == null) {
            if (view == null || this.f8917b == null || aVar == null) {
                return false;
            }
            if (f8915g) {
                String str = "updateView pos: " + aVar;
            }
            if (d(view, this.f8917b)) {
                Object tag = view.getTag(f.aiapps_na_root_view_tag);
                if (tag instanceof b) {
                    b bVar = (b) tag;
                    c.a(bVar, aVar);
                    view.setTag(f.aiapps_na_root_view_tag, bVar);
                }
                this.f8917b.updateViewLayout(view, c.b(this.f8918c, aVar));
            } else if (!g(view)) {
                return false;
            } else {
                Object tag2 = view.getTag(f.aiapps_na_root_view_tag);
                if (tag2 instanceof b) {
                    b bVar2 = (b) tag2;
                    c.a(bVar2, aVar);
                    view.setTag(f.aiapps_na_root_view_tag, bVar2);
                }
                ((ViewGroup) view.getParent()).updateViewLayout(view, c.b(this.f8918c, aVar));
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.swan.apps.core.container.PullToRefreshBaseWebView.a
    public void b(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4, i5) == null) {
            this.f8917b.scrollTo(i2, i3);
        }
    }

    @Override // b.a.p0.a.w2.g.a
    public boolean c(View view, b.a.p0.a.l1.e.a.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, aVar)) == null) {
            if (this.f8920e != null && aVar != null) {
                b bVar = new b();
                c.a(bVar, aVar);
                view.setTag(f.aiapps_na_root_view_tag, bVar);
                if (this.f8917b.indexOfChild(view) >= 0) {
                    b.a.p0.a.c0.g.a.a("NAParentViewManager", "repeat insert view!");
                    this.f8917b.removeView(view);
                }
                this.f8917b.addView(view, c.b(this.f8918c, aVar));
                return true;
            }
            boolean z = f8915g;
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean d(View view, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view, viewGroup)) == null) ? view != null && viewGroup != null && view.getParent() == viewGroup && viewGroup.indexOfChild(view) >= 0 : invokeLL.booleanValue;
    }

    public final boolean e(b.a.p0.a.p.e.b<T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
            boolean z = f8915g;
            bVar.t(this);
            T s = bVar.s();
            this.f8918c = s;
            if (s == null) {
                return false;
            }
            SwanAppNARootViewScrollView swanAppNARootViewScrollView = new SwanAppNARootViewScrollView(this.f8920e);
            this.f8916a.addView(swanAppNARootViewScrollView, new FrameLayout.LayoutParams(-1, -1));
            this.f8917b = new FrameLayout(this.f8920e);
            swanAppNARootViewScrollView.addView(this.f8917b, new FrameLayout.LayoutParams(-1, -1));
            swanAppNARootViewScrollView.setFillViewport(true);
            PullToRefreshBaseWebView f0 = bVar.f0();
            this.f8919d = f0;
            if (f0 != null) {
                f0.setOnPullToRefreshScrollChangeListener(this);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f8921f.T(this);
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
            this.f8917b.setVisibility(i2);
        }
    }

    @Override // b.a.p0.a.h0.j.c
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4, i5) == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f8917b.getLayoutParams();
            marginLayoutParams.leftMargin = -i2;
            marginLayoutParams.topMargin = -i3;
            this.f8917b.setLayoutParams(marginLayoutParams);
            for (int i6 = 0; i6 < this.f8917b.getChildCount(); i6++) {
                View childAt = this.f8917b.getChildAt(i6);
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

    @Override // b.a.p0.a.w2.g.a
    public boolean removeView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, view)) == null) {
            if (d(view, this.f8917b)) {
                try {
                    this.f8917b.removeView(view);
                } catch (Exception e2) {
                    if (f8915g) {
                        e2.printStackTrace();
                    }
                }
                return true;
            } else if (g(view)) {
                try {
                    ((ViewGroup) view.getParent()).removeView(view);
                } catch (Exception e3) {
                    if (f8915g) {
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
