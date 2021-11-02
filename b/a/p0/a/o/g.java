package b.a.p0.a.o;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import b.a.p0.a.h;
import b.a.p0.a.h0.g.g;
import b.a.p0.a.v2.n0;
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
public class g implements b.a.p0.f.i.l.f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final ViewGroup.LayoutParams f7072c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.p0.a.h0.g.f f7073a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f7074b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1065441462, "Lb/a/p0/a/o/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1065441462, "Lb/a/p0/a/o/g;");
                return;
            }
        }
        f7072c = new FrameLayout.LayoutParams(-1, -1);
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

    @Override // b.a.p0.f.i.l.f
    public void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
            b.a.p0.a.h0.g.g U = b.a.p0.a.g1.f.T().U();
            Context appContext = AppRuntime.getAppContext();
            if (U == null) {
                if (appContext != null) {
                    b.a.p0.a.z1.b.f.e.f(appContext, h.aiapps_open_fragment_failed_toast).F();
                    return;
                }
                return;
            }
            b.a.p0.a.l1.b e2 = b.a.p0.a.l1.b.e(str, str);
            e2.i(jSONObject.toString());
            g.b i2 = U.i("adLanding");
            i2.n(b.a.p0.a.h0.g.g.f5280g, b.a.p0.a.h0.g.g.f5282i);
            i2.k("adLanding", e2).b();
        }
    }

    @Override // b.a.p0.f.i.l.f
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.f.i.l.f
    public boolean c(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.p0.f.i.l.f
    public boolean d(View view, b.a.p0.f.i.i.a aVar) {
        InterceptResult invokeLL;
        b.a.p0.a.h0.g.g U;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view, aVar)) == null) {
            b.a.p0.a.g1.f T = b.a.p0.a.g1.f.T();
            SwanAppActivity activity = T.getActivity();
            if (activity == null || activity.isFinishing() || (U = T.U()) == null) {
                return false;
            }
            b.a.p0.a.h0.g.f o = U.o();
            this.f7073a = o;
            if (o.n3()) {
                int u = n0.u();
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                        View childAt = viewGroup.getChildAt(i2);
                        if (childAt.getTop() < u) {
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) childAt.getLayoutParams();
                            layoutParams.topMargin = childAt.getTop() + u;
                            childAt.setLayoutParams(layoutParams);
                        }
                    }
                }
            }
            SwanAppInlineFullScreenContainer swanAppInlineFullScreenContainer = new SwanAppInlineFullScreenContainer(activity);
            this.f7074b = swanAppInlineFullScreenContainer;
            swanAppInlineFullScreenContainer.addView(view, f7072c);
            b.a.p0.a.z1.b.c.a floatLayer = o.getFloatLayer();
            if (floatLayer == null) {
                return false;
            }
            floatLayer.i(true);
            n0.b(activity);
            floatLayer.j(this.f7074b);
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // b.a.p0.f.i.l.f
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // b.a.p0.f.i.l.f
    public boolean f(View view, b.a.p0.f.i.i.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view, aVar)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // b.a.p0.f.i.l.f
    public boolean removeView(View view) {
        InterceptResult invokeL;
        b.a.p0.a.z1.b.c.a floatLayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view)) == null) {
            this.f7074b.removeAllViews();
            b.a.p0.a.h0.g.f fVar = this.f7073a;
            if (fVar == null || (floatLayer = fVar.getFloatLayer()) == null) {
                return false;
            }
            floatLayer.i(false);
            floatLayer.f();
            return true;
        }
        return invokeL.booleanValue;
    }
}
