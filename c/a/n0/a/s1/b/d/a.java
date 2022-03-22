package c.a.n0.a.s1.b.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.n0;
import c.a.n0.a.p2.q0;
import c.a.n0.a.s1.b.c.a;
import c.a.n0.a.x.g.d;
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
    public static final WeakHashMap<ViewGroup, c.a.n0.a.s1.b.d.b> f6268b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.a.s1.b.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0452a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.s1.b.c.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f6269b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f6270c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f6271d;

        public RunnableC0452a(c.a.n0.a.s1.b.c.a aVar, Context context, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.f6269b = context;
            this.f6270c = str;
            this.f6271d = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            LoadingView loadingView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                View d2 = this.a.d();
                if (d2 instanceof LoadingView) {
                    loadingView = (LoadingView) d2;
                } else {
                    loadingView = new LoadingView(this.f6269b);
                    FrameLayout frameLayout = new FrameLayout(this.f6269b);
                    frameLayout.setPadding(0, 0, 0, n0.g(160.0f));
                    frameLayout.addView(loadingView);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 17;
                    this.a.o(frameLayout, layoutParams);
                }
                if (!TextUtils.isEmpty(this.f6270c)) {
                    loadingView.setMsg(this.f6270c);
                }
                this.a.k(this.f6271d);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.n0.a.s1.b.c.a floatLayer;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (floatLayer = ((a.InterfaceC0451a) this.a).getFloatLayer()) != null && (floatLayer.d() instanceof FrameLayout) && (((FrameLayout) floatLayer.d()).getChildAt(0) instanceof LoadingView)) {
                floatLayer.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(712460238, "Lc/a/n0/a/s1/b/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(712460238, "Lc/a/n0/a/s1/b/d/a;");
                return;
            }
        }
        a = c.a.n0.a.a.a & true;
        f6268b = new WeakHashMap<>();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            for (ViewGroup viewGroup : f6268b.keySet()) {
                c.a.n0.a.s1.b.d.b bVar = f6268b.get(viewGroup);
                if (bVar != null && bVar.getLoadingView() != null) {
                    viewGroup.removeView(bVar.getLoadingView());
                }
            }
            f6268b.clear();
        }
    }

    public static boolean b(ViewGroup viewGroup) {
        InterceptResult invokeL;
        c.a.n0.a.s1.b.d.b bVar;
        View loadingView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, viewGroup)) == null) {
            if (viewGroup == null) {
                return false;
            }
            c.a.n0.a.s1.b.d.b bVar2 = f6268b.get(viewGroup);
            if (bVar2 != null && bVar2.getLoadingView() != null) {
                bVar2.getLoadingView().setVisibility(8);
                return true;
            }
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if ((viewGroup.getChildAt(i) instanceof c.a.n0.a.s1.b.d.b) && (loadingView = (bVar = (c.a.n0.a.s1.b.d.b) viewGroup.getChildAt(i)).getLoadingView()) != null) {
                    loadingView.setVisibility(8);
                    f6268b.put(viewGroup, bVar);
                    if (a) {
                        Log.d("LoadingViewHelper", "The count of cached loading views is : " + f6268b.size());
                        Log.d("LoadingViewHelper", "The content of cached views is : " + f6268b.toString());
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
        if ((interceptable == null || interceptable.invokeL(65539, null, dVar) == null) && (dVar instanceof a.InterfaceC0451a)) {
            q0.e0(new b(dVar));
        }
    }

    public static boolean d(ViewGroup viewGroup) {
        InterceptResult invokeL;
        c.a.n0.a.s1.b.d.b bVar;
        View loadingView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, viewGroup)) == null) {
            if (viewGroup == null) {
                return false;
            }
            c.a.n0.a.s1.b.d.b bVar2 = f6268b.get(viewGroup);
            if (bVar2 != null) {
                View loadingView2 = bVar2.getLoadingView();
                if (loadingView2 != null) {
                    if (loadingView2 instanceof BdShimmerView) {
                        ((BdShimmerView) loadingView2).p();
                    }
                    loadingView2.setVisibility(8);
                    viewGroup.removeView(loadingView2);
                    f6268b.remove(viewGroup);
                    if (a) {
                        Log.d("LoadingViewHelper", "The count of cached loading views is : " + f6268b.size());
                        Log.d("LoadingViewHelper", "The content of cached views is : " + f6268b.toString());
                    }
                }
                return true;
            }
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if ((viewGroup.getChildAt(i) instanceof c.a.n0.a.s1.b.d.b) && (loadingView = (bVar = (c.a.n0.a.s1.b.d.b) viewGroup.getChildAt(i)).getLoadingView()) != null) {
                    loadingView.setVisibility(8);
                    viewGroup.removeView((View) bVar);
                    f6268b.remove(viewGroup);
                    if (a) {
                        Log.d("LoadingViewHelper", "The count of cached loading views is : " + f6268b.size());
                        Log.d("LoadingViewHelper", "The content of cached views is : " + f6268b.toString());
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
        c.a.n0.a.s1.b.d.b bVar;
        View loadingView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, viewGroup)) == null) {
            if (viewGroup == null) {
                return false;
            }
            c.a.n0.a.s1.b.d.b bVar2 = f6268b.get(viewGroup);
            if (bVar2 != null && bVar2.getLoadingView() != null) {
                bVar2.getLoadingView().setVisibility(0);
                return true;
            }
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if ((viewGroup.getChildAt(i) instanceof c.a.n0.a.s1.b.d.b) && (loadingView = (bVar = (c.a.n0.a.s1.b.d.b) viewGroup.getChildAt(i)).getLoadingView()) != null) {
                    loadingView.setVisibility(0);
                    f6268b.put(viewGroup, bVar);
                    if (a) {
                        Log.d("LoadingViewHelper", "The count of cached loading views is : " + f6268b.size());
                        Log.d("LoadingViewHelper", "The content of cached views is : " + f6268b.toString());
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void f(@NonNull c.a.n0.a.s1.b.c.a aVar, @NonNull Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{aVar, context, str, Boolean.valueOf(z)}) == null) {
            q0.e0(new RunnableC0452a(aVar, context, str, z));
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
                f6268b.put(viewGroup, loadingView);
                loadingView2.setVisibility(0);
                if (a) {
                    Log.d("LoadingViewHelper", "The count of cached loading views is : " + f6268b.size());
                    Log.d("LoadingViewHelper", "The content of cached views is : " + f6268b.toString());
                }
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
