package c.a.n0.a.q2.k;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.f.e.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.view.SwanAppNARootViewScrollView;
import com.baidu.swan.apps.view.narootview.SwanAppInlineFullScreenContainer;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a<T extends c.a.n0.a.f.e.c> implements c.a.n0.a.x.j.c, c.a.n0.a.q2.g.a, PullToRefreshBaseWebView.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f6059g;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f6060b;

    /* renamed from: c  reason: collision with root package name */
    public T f6061c;

    /* renamed from: d  reason: collision with root package name */
    public PullToRefreshBaseWebView f6062d;

    /* renamed from: e  reason: collision with root package name */
    public Context f6063e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.n0.a.f.e.b f6064f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(283679223, "Lc/a/n0/a/q2/k/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(283679223, "Lc/a/n0/a/q2/k/a;");
                return;
            }
        }
        f6059g = c.a.n0.a.a.a;
    }

    public a(Context context, @NonNull c.a.n0.a.f.e.b<T> bVar, @NonNull FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bVar, frameLayout};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f6063e = context;
        this.a = frameLayout;
        this.f6064f = bVar;
        e(bVar);
    }

    @Override // c.a.n0.a.q2.g.a
    public boolean a(View view, c.a.n0.a.c1.e.a.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, aVar)) == null) {
            if (view == null || this.f6060b == null || aVar == null) {
                return false;
            }
            if (f6059g) {
                Log.d("NAParentViewManager", "updateView pos: " + aVar);
            }
            if (d(view, this.f6060b)) {
                Object tag = view.getTag(R.id.obfuscated_res_0x7f0901a0);
                if (tag instanceof b) {
                    b bVar = (b) tag;
                    c.a(bVar, aVar);
                    view.setTag(R.id.obfuscated_res_0x7f0901a0, bVar);
                }
                this.f6060b.updateViewLayout(view, c.b(this.f6061c, aVar));
            } else if (!g(view)) {
                return false;
            } else {
                Object tag2 = view.getTag(R.id.obfuscated_res_0x7f0901a0);
                if (tag2 instanceof b) {
                    b bVar2 = (b) tag2;
                    c.a(bVar2, aVar);
                    view.setTag(R.id.obfuscated_res_0x7f0901a0, bVar2);
                }
                ((ViewGroup) view.getParent()).updateViewLayout(view, c.b(this.f6061c, aVar));
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.swan.apps.core.container.PullToRefreshBaseWebView.a
    public void b(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, i3, i4) == null) {
            this.f6060b.scrollTo(i, i2);
        }
    }

    @Override // c.a.n0.a.q2.g.a
    public boolean c(View view, c.a.n0.a.c1.e.a.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, aVar)) == null) {
            if (this.f6063e != null && aVar != null) {
                b bVar = new b();
                c.a(bVar, aVar);
                view.setTag(R.id.obfuscated_res_0x7f0901a0, bVar);
                if (this.f6060b.indexOfChild(view) >= 0) {
                    c.a.n0.a.s.g.a.a("NAParentViewManager", "repeat insert view!");
                    this.f6060b.removeView(view);
                }
                this.f6060b.addView(view, c.b(this.f6061c, aVar));
                return true;
            } else if (f6059g) {
                Log.d("NAParentViewManager", "insertView failed");
                return false;
            } else {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public final boolean d(View view, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view, viewGroup)) == null) ? view != null && viewGroup != null && view.getParent() == viewGroup && viewGroup.indexOfChild(view) >= 0 : invokeLL.booleanValue;
    }

    public final boolean e(c.a.n0.a.f.e.b<T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
            if (f6059g) {
                Log.d("NAParentViewManager", "createViewAndListener");
            }
            bVar.v(this);
            T u = bVar.u();
            this.f6061c = u;
            if (u == null) {
                return false;
            }
            SwanAppNARootViewScrollView swanAppNARootViewScrollView = new SwanAppNARootViewScrollView(this.f6063e);
            this.a.addView(swanAppNARootViewScrollView, new FrameLayout.LayoutParams(-1, -1));
            this.f6060b = new FrameLayout(this.f6063e);
            swanAppNARootViewScrollView.addView(this.f6060b, new FrameLayout.LayoutParams(-1, -1));
            swanAppNARootViewScrollView.setFillViewport(true);
            PullToRefreshBaseWebView k0 = bVar.k0();
            this.f6062d = k0;
            if (k0 != null) {
                k0.setOnPullToRefreshScrollChangeListener(this);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f6064f.X(this);
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

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.f6060b.setVisibility(i);
        }
    }

    @Override // c.a.n0.a.x.j.c
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3, i4) == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f6060b.getLayoutParams();
            marginLayoutParams.leftMargin = -i;
            marginLayoutParams.topMargin = -i2;
            this.f6060b.setLayoutParams(marginLayoutParams);
            for (int i5 = 0; i5 < this.f6060b.getChildCount(); i5++) {
                View childAt = this.f6060b.getChildAt(i5);
                if (childAt != null) {
                    Object tag = childAt.getTag(R.id.obfuscated_res_0x7f0901a0);
                    b bVar = tag instanceof b ? (b) tag : null;
                    if (bVar != null && bVar.d()) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                        marginLayoutParams2.leftMargin = bVar.b() + i;
                        marginLayoutParams2.topMargin = bVar.c() + i2;
                        childAt.setLayoutParams(marginLayoutParams2);
                    }
                }
            }
        }
    }

    @Override // c.a.n0.a.q2.g.a
    public boolean removeView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, view)) == null) {
            if (d(view, this.f6060b)) {
                try {
                    this.f6060b.removeView(view);
                } catch (Exception e2) {
                    if (f6059g) {
                        e2.printStackTrace();
                    }
                }
                return true;
            } else if (g(view)) {
                try {
                    ((ViewGroup) view.getParent()).removeView(view);
                } catch (Exception e3) {
                    if (f6059g) {
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
