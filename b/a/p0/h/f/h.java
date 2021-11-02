package b.a.p0.h.f;

import android.content.Context;
import android.view.View;
import b.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStatistic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class h extends b.a.p0.a.h0.e.d {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean E;
    public transient /* synthetic */ FieldHolder $fh;
    public View D;

    /* loaded from: classes4.dex */
    public class a extends b.a.p0.a.h0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // b.a.p0.a.h0.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.a(str);
                boolean unused = h.E;
                i.a();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-865305493, "Lb/a/p0/h/f/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-865305493, "Lb/a/p0/h/f/h;");
                return;
            }
        }
        E = k.f6397a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context context) {
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
    }

    @Override // b.a.p0.a.h0.e.d, b.a.p0.a.p.e.a
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            i.h(false);
            this.D = null;
            super.E();
        }
    }

    @Override // b.a.p0.a.h0.e.d, b.a.p0.a.p.e.a
    public void G(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            this.D = view;
        }
    }

    @Override // b.a.p0.a.h0.e.d, b.a.p0.a.p.e.a
    public void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (s().getVisibility() == (z ? 0 : 8)) {
                return;
            }
            if (E) {
                String str = "setConsoleVisible:" + z;
            }
            if (z) {
                b.a.p0.a.g1.f.T().l("console", c.i(true));
            }
            if (this.D != null) {
                this.D.setVisibility(z ? 4 : 0);
            }
            super.P(z);
        }
    }

    @Override // b.a.p0.a.h0.e.d, com.baidu.swan.apps.core.SwanAppWebViewManager, b.a.p0.a.p.e.d
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "console" : (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.e.d, b.a.p0.a.p.e.a
    public void e0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            i.g(str, str2);
        }
    }

    @Override // b.a.p0.a.h0.e.d
    public void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            s().setVisibility(8);
            s().setBackgroundColor(0);
            i.c();
            g1();
            String i2 = d.m().i();
            if (E) {
                String str = HttpRetryStatistic.RETRY_URL + i2;
            }
            loadUrl(i2);
        }
    }

    public final void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c(new a(this));
        }
    }
}
