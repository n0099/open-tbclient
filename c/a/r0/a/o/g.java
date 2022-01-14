package c.a.r0.a.o;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import c.a.r0.a.h;
import c.a.r0.a.h0.g.g;
import c.a.r0.a.z2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.view.narootview.SwanAppInlineFullScreenContainer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g implements c.a.r0.h.i.m.g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final ViewGroup.LayoutParams f8003c;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.a.h0.g.f a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f8004b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-678786099, "Lc/a/r0/a/o/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-678786099, "Lc/a/r0/a/o/g;");
                return;
            }
        }
        f8003c = new FrameLayout.LayoutParams(-1, -1);
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // c.a.r0.h.i.m.g
    public void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
            c.a.r0.a.h0.g.g V = c.a.r0.a.g1.f.U().V();
            Context appContext = AppRuntime.getAppContext();
            if (V == null) {
                if (appContext != null) {
                    c.a.r0.a.c2.b.f.e.f(appContext, h.aiapps_open_fragment_failed_toast).G();
                    return;
                }
                return;
            }
            c.a.r0.a.m1.b e2 = c.a.r0.a.m1.b.e(str, str);
            e2.i(jSONObject.toString());
            g.b i2 = V.i("adLanding");
            i2.n(c.a.r0.a.h0.g.g.f6399g, c.a.r0.a.h0.g.g.f6401i);
            i2.k("adLanding", e2).b();
        }
    }

    @Override // c.a.r0.h.i.m.g
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.h.i.m.g
    public boolean c(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.r0.h.i.m.g
    public boolean d(View view, c.a.r0.h.i.i.a aVar) {
        InterceptResult invokeLL;
        c.a.r0.a.h0.g.g V;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view, aVar)) == null) {
            c.a.r0.a.g1.f U = c.a.r0.a.g1.f.U();
            SwanAppActivity activity = U.getActivity();
            if (activity == null || activity.isFinishing() || (V = U.V()) == null) {
                return false;
            }
            c.a.r0.a.h0.g.f o = V.o();
            this.a = o;
            if (o.A3()) {
                int t = n0.t();
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                        View childAt = viewGroup.getChildAt(i2);
                        if (childAt.getTop() < t) {
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) childAt.getLayoutParams();
                            layoutParams.topMargin = childAt.getTop() + t;
                            childAt.setLayoutParams(layoutParams);
                        }
                    }
                }
            }
            SwanAppInlineFullScreenContainer swanAppInlineFullScreenContainer = new SwanAppInlineFullScreenContainer(activity);
            this.f8004b = swanAppInlineFullScreenContainer;
            swanAppInlineFullScreenContainer.addView(view, f8003c);
            c.a.r0.a.c2.b.c.a floatLayer = o.getFloatLayer();
            if (floatLayer == null) {
                return false;
            }
            floatLayer.m(true);
            n0.b(activity);
            floatLayer.n(this.f8004b);
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.r0.h.i.m.g
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // c.a.r0.h.i.m.g
    public boolean f(View view, c.a.r0.h.i.i.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view, aVar)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.r0.h.i.m.g
    public boolean removeView(View view) {
        InterceptResult invokeL;
        c.a.r0.a.c2.b.c.a floatLayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view)) == null) {
            this.f8004b.removeAllViews();
            c.a.r0.a.h0.g.f fVar = this.a;
            if (fVar == null || (floatLayer = fVar.getFloatLayer()) == null) {
                return false;
            }
            floatLayer.m(false);
            floatLayer.g();
            return true;
        }
        return invokeL.booleanValue;
    }
}
