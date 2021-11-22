package b.a.p0.a.h0.l;

import android.content.Context;
import b.a.p0.a.h0.u.g;
import b.a.p0.a.k;
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
/* loaded from: classes.dex */
public class c extends SwanAppWebViewManager implements Object<NgWebView>, a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean B;
    public transient /* synthetic */ FieldHolder $fh;
    public final String A;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597551852, "Lb/a/p0/a/h0/l/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597551852, "Lb/a/p0/a/h0/l/c;");
                return;
            }
        }
        B = k.f6863a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
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
        this.A = b.a.p0.a.h0.l.g.e.b();
    }

    @Override // b.a.p0.a.h0.l.a
    public void E(b.a.p0.a.h0.u.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
            return;
        }
        if (B) {
            String str = "pathList item: " + aVar.f6136b;
        }
        this.f44367f.getSettings().setCodeCacheSetting(b.a.p0.a.h0.d.b.a("appjs", aVar.f6136b));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, b.a.p0.a.p.e.d
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.A : (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.l.a
    public b.a.p0.a.h0.f.a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? t() : (b.a.p0.a.h0.f.a) invokeV.objValue;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, b.a.p0.a.p.e.d, b.a.p0.a.h0.l.a
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            super.loadUrl(str);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, b.a.p0.a.p.e.d
    public void onJSLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            g.U().w0(true);
        }
    }

    @Override // b.a.p0.a.h0.l.a
    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
        }
    }
}
