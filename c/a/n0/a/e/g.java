package c.a.n0.a.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import c.a.n0.a.p2.n0;
import c.a.n0.a.x.g.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.view.narootview.SwanAppInlineFullScreenContainer;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g implements c.a.n0.h.a.e.g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final ViewGroup.LayoutParams f4209c;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.n0.a.x.g.f a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f4210b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2039200749, "Lc/a/n0/a/e/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2039200749, "Lc/a/n0/a/e/g;");
                return;
            }
        }
        f4209c = new FrameLayout.LayoutParams(-1, -1);
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // c.a.n0.h.a.e.g
    public void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
            c.a.n0.a.x.g.g V = c.a.n0.a.w0.f.U().V();
            Context appContext = AppRuntime.getAppContext();
            if (V == null) {
                if (appContext != null) {
                    c.a.n0.a.s1.b.f.e.f(appContext, R.string.obfuscated_res_0x7f0f019b).G();
                    return;
                }
                return;
            }
            c.a.n0.a.c1.b d2 = c.a.n0.a.c1.b.d(str, str);
            d2.h(jSONObject.toString());
            g.b i = V.i("adLanding");
            i.n(c.a.n0.a.x.g.g.f7048g, c.a.n0.a.x.g.g.i);
            i.k("adLanding", d2).b();
        }
    }

    @Override // c.a.n0.h.a.e.g
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.h.a.e.g
    public boolean c(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.n0.h.a.e.g
    public boolean d(View view, c.a.n0.h.a.a.a aVar) {
        InterceptResult invokeLL;
        c.a.n0.a.x.g.g V;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view, aVar)) == null) {
            c.a.n0.a.w0.f U = c.a.n0.a.w0.f.U();
            SwanAppActivity activity = U.getActivity();
            if (activity == null || activity.isFinishing() || (V = U.V()) == null) {
                return false;
            }
            c.a.n0.a.x.g.f o = V.o();
            this.a = o;
            if (o.E3()) {
                int t = n0.t();
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int i = 0; i < viewGroup.getChildCount(); i++) {
                        View childAt = viewGroup.getChildAt(i);
                        if (childAt.getTop() < t) {
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) childAt.getLayoutParams();
                            layoutParams.topMargin = childAt.getTop() + t;
                            childAt.setLayoutParams(layoutParams);
                        }
                    }
                }
            }
            SwanAppInlineFullScreenContainer swanAppInlineFullScreenContainer = new SwanAppInlineFullScreenContainer(activity);
            this.f4210b = swanAppInlineFullScreenContainer;
            swanAppInlineFullScreenContainer.addView(view, f4209c);
            c.a.n0.a.s1.b.c.a floatLayer = o.getFloatLayer();
            if (floatLayer == null) {
                return false;
            }
            floatLayer.m(true);
            n0.b(activity);
            floatLayer.n(this.f4210b);
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.n0.h.a.e.g
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // c.a.n0.h.a.e.g
    public boolean f(View view, c.a.n0.h.a.a.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view, aVar)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.n0.h.a.e.g
    public boolean removeView(View view) {
        InterceptResult invokeL;
        c.a.n0.a.s1.b.c.a floatLayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view)) == null) {
            this.f4210b.removeAllViews();
            c.a.n0.a.x.g.f fVar = this.a;
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
