package c.a.o0.a.h0.e;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.e0.e;
import c.a.o0.a.k;
import c.a.o0.a.p.b.a.f;
import c.a.o0.a.v2.x;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class d extends SwanAppWebViewManager implements c.a.o0.a.p.e.a<NgWebView> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean C;
    public transient /* synthetic */ FieldHolder $fh;
    public Context A;
    public boolean B;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(957726450, "Lc/a/o0/a/h0/e/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(957726450, "Lc/a/o0/a/h0/e/d;");
                return;
            }
        }
        C = k.f7049a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.B = false;
        this.A = context;
        f1();
    }

    @Override // c.a.o0.a.p.e.a
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.o0.a.e0.d.k(false);
            ViewParent parent = t().getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(t());
            }
            destroy();
        }
    }

    @Override // c.a.o0.a.p.e.a
    public void G(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) == null) || viewGroup == null) {
            return;
        }
        k(viewGroup, t());
    }

    @Override // c.a.o0.a.p.e.a
    public void H(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // c.a.o0.a.p.e.a
    public void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            t().setVisibility(z ? 0 : 8);
        }
    }

    public final void T() {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (context = this.A) != null && (context instanceof Activity)) {
            x.a(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
        }
    }

    @Override // c.a.o0.a.p.e.a
    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Q(t().getVisibility() != 0);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, c.a.o0.a.p.e.d
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "console" : (String) invokeV.objValue;
    }

    public final void d1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (C) {
                String str = "call downloadConsoleCore: " + z;
            }
            if (!this.B || z) {
                c.a.o0.n.i.m.d dVar = new c.a.o0.n.i.m.d("sconsole-core", e.c(), e.b(), 2);
                f h2 = c.a.o0.a.c1.b.h();
                c.a.o0.n.b.e(dVar, h2 != null ? h2.d() : null);
                this.B = true;
            }
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, c.a.o0.a.p.e.d
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            T();
            super.destroy();
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, c.a.o0.a.p.e.d
    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.e0();
        }
    }

    public final boolean e1(ViewGroup viewGroup, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, viewGroup, view)) == null) {
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (viewGroup.getChildAt(i2) == view) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.o0.a.p.e.a
    public void f0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) {
            JSONArray jSONArray = new JSONArray();
            if (!TextUtils.isEmpty(str2)) {
                jSONArray.put(str2);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("logType", str);
            hashMap.put("logs", jSONArray.toString());
            c.a.o0.a.g1.f.V().m("console", new c.a.o0.a.o0.d.b("searchboxSConsole", hashMap));
        }
    }

    public void f1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            t().setVisibility(8);
            t().setBackgroundColor(0);
            File file = new File(e.a(), "index.html");
            if (file.exists() && file.isFile()) {
                loadUrl(Uri.fromFile(file).toString());
                d1(false);
                return;
            }
            loadUrl("file:///android_asset/aiapps/sConsole.html");
            e.d();
            d1(true);
        }
    }

    public final void k(ViewGroup viewGroup, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, viewGroup, view) == null) || viewGroup == null || view == null || e1(viewGroup, view)) {
            return;
        }
        viewGroup.addView(view, new FrameLayout.LayoutParams(-1, -1));
    }
}
