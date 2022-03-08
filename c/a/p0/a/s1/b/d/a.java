package c.a.p0.a.s1.b.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.p2.n0;
import c.a.p0.a.p2.q0;
import c.a.p0.a.s1.b.c.a;
import c.a.p0.a.x.g.d;
import com.baidu.swan.apps.res.ui.BdShimmerView;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final WeakHashMap<ViewGroup, c.a.p0.a.s1.b.d.b> f7402b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.a.s1.b.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0460a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.s1.b.c.a f7403e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f7404f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f7405g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f7406h;

        public RunnableC0460a(c.a.p0.a.s1.b.c.a aVar, Context context, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7403e = aVar;
            this.f7404f = context;
            this.f7405g = str;
            this.f7406h = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            LoadingView loadingView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                View d2 = this.f7403e.d();
                if (d2 instanceof LoadingView) {
                    loadingView = (LoadingView) d2;
                } else {
                    loadingView = new LoadingView(this.f7404f);
                    FrameLayout frameLayout = new FrameLayout(this.f7404f);
                    frameLayout.setPadding(0, 0, 0, n0.g(160.0f));
                    frameLayout.addView(loadingView);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 17;
                    this.f7403e.o(frameLayout, layoutParams);
                }
                if (!TextUtils.isEmpty(this.f7405g)) {
                    loadingView.setMsg(this.f7405g);
                }
                this.f7403e.k(this.f7406h);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f7407e;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7407e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.p0.a.s1.b.c.a floatLayer;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (floatLayer = ((a.InterfaceC0459a) this.f7407e).getFloatLayer()) != null && (floatLayer.d() instanceof FrameLayout) && (((FrameLayout) floatLayer.d()).getChildAt(0) instanceof LoadingView)) {
                floatLayer.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-298657012, "Lc/a/p0/a/s1/b/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-298657012, "Lc/a/p0/a/s1/b/d/a;");
                return;
            }
        }
        a = c.a.p0.a.a.a & true;
        f7402b = new WeakHashMap<>();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            for (ViewGroup viewGroup : f7402b.keySet()) {
                c.a.p0.a.s1.b.d.b bVar = f7402b.get(viewGroup);
                if (bVar != null && bVar.getLoadingView() != null) {
                    viewGroup.removeView(bVar.getLoadingView());
                }
            }
            f7402b.clear();
        }
    }

    public static boolean b(ViewGroup viewGroup) {
        InterceptResult invokeL;
        c.a.p0.a.s1.b.d.b bVar;
        View loadingView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, viewGroup)) == null) {
            if (viewGroup == null) {
                return false;
            }
            c.a.p0.a.s1.b.d.b bVar2 = f7402b.get(viewGroup);
            if (bVar2 != null && bVar2.getLoadingView() != null) {
                bVar2.getLoadingView().setVisibility(8);
                return true;
            }
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                if ((viewGroup.getChildAt(i2) instanceof c.a.p0.a.s1.b.d.b) && (loadingView = (bVar = (c.a.p0.a.s1.b.d.b) viewGroup.getChildAt(i2)).getLoadingView()) != null) {
                    loadingView.setVisibility(8);
                    f7402b.put(viewGroup, bVar);
                    if (a) {
                        String str = "The count of cached loading views is : " + f7402b.size();
                        String str2 = "The content of cached views is : " + f7402b.toString();
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void c(@NonNull d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, dVar) == null) && (dVar instanceof a.InterfaceC0459a)) {
            q0.e0(new b(dVar));
        }
    }

    public static boolean d(ViewGroup viewGroup) {
        InterceptResult invokeL;
        c.a.p0.a.s1.b.d.b bVar;
        View loadingView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, viewGroup)) == null) {
            if (viewGroup == null) {
                return false;
            }
            c.a.p0.a.s1.b.d.b bVar2 = f7402b.get(viewGroup);
            if (bVar2 != null) {
                View loadingView2 = bVar2.getLoadingView();
                if (loadingView2 != null) {
                    if (loadingView2 instanceof BdShimmerView) {
                        ((BdShimmerView) loadingView2).stopShimmerAnimation();
                    }
                    loadingView2.setVisibility(8);
                    viewGroup.removeView(loadingView2);
                    f7402b.remove(viewGroup);
                    if (a) {
                        String str = "The count of cached loading views is : " + f7402b.size();
                        String str2 = "The content of cached views is : " + f7402b.toString();
                    }
                }
                return true;
            }
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                if ((viewGroup.getChildAt(i2) instanceof c.a.p0.a.s1.b.d.b) && (loadingView = (bVar = (c.a.p0.a.s1.b.d.b) viewGroup.getChildAt(i2)).getLoadingView()) != null) {
                    loadingView.setVisibility(8);
                    viewGroup.removeView((View) bVar);
                    f7402b.remove(viewGroup);
                    if (a) {
                        String str3 = "The count of cached loading views is : " + f7402b.size();
                        String str4 = "The content of cached views is : " + f7402b.toString();
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean e(ViewGroup viewGroup) {
        InterceptResult invokeL;
        c.a.p0.a.s1.b.d.b bVar;
        View loadingView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, viewGroup)) == null) {
            if (viewGroup == null) {
                return false;
            }
            c.a.p0.a.s1.b.d.b bVar2 = f7402b.get(viewGroup);
            if (bVar2 != null && bVar2.getLoadingView() != null) {
                bVar2.getLoadingView().setVisibility(0);
                return true;
            }
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                if ((viewGroup.getChildAt(i2) instanceof c.a.p0.a.s1.b.d.b) && (loadingView = (bVar = (c.a.p0.a.s1.b.d.b) viewGroup.getChildAt(i2)).getLoadingView()) != null) {
                    loadingView.setVisibility(0);
                    f7402b.put(viewGroup, bVar);
                    if (a) {
                        String str = "The count of cached loading views is : " + f7402b.size();
                        String str2 = "The content of cached views is : " + f7402b.toString();
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void f(@NonNull c.a.p0.a.s1.b.c.a aVar, @NonNull Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{aVar, context, str, Boolean.valueOf(z)}) == null) {
            q0.e0(new RunnableC0460a(aVar, context, str, z));
        }
    }

    public static boolean g(Context context, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, viewGroup)) == null) ? h(context, viewGroup, "") : invokeLL.booleanValue;
    }

    public static boolean h(Context context, ViewGroup viewGroup, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, context, viewGroup, str)) == null) {
            if (context != null && viewGroup != null) {
                if (e(viewGroup)) {
                    return true;
                }
                LoadingView loadingView = new LoadingView(context);
                LoadingView loadingView2 = loadingView.getLoadingView();
                if (loadingView2 == null) {
                    return false;
                }
                if (!TextUtils.isEmpty(str)) {
                    loadingView2.setMsg(str);
                }
                ViewGroup viewGroup2 = (ViewGroup) loadingView2.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(loadingView2);
                }
                if (viewGroup instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    viewGroup.addView(loadingView2, layoutParams);
                } else if (viewGroup instanceof LinearLayout) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 17;
                    viewGroup.addView(loadingView2, layoutParams2);
                } else if (viewGroup instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams3.gravity = 17;
                    viewGroup.addView(loadingView2, layoutParams3);
                }
                f7402b.put(viewGroup, loadingView);
                loadingView2.setVisibility(0);
                if (a) {
                    String str2 = "The count of cached loading views is : " + f7402b.size();
                    String str3 = "The content of cached views is : " + f7402b.toString();
                }
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
