package b.a.p0.a.y0.k.f.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a extends f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final b.a.p0.a.y0.k.f.a f9083a;

    public a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f9083a = new b.a.p0.a.y0.k.f.a();
    }

    @Override // b.a.p0.a.y0.k.f.c.f, b.a.p0.a.y0.k.f.c.e
    public void b(boolean z, HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048576, this, z, hybridUbcFlow) == null) {
            if (this.f9083a.f()) {
                this.f9083a.k();
                b.a.p0.a.y0.k.f.b.f();
                return;
            }
            this.f9083a.g("fmpArrived", z ? "1" : "0");
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f9083a.c();
            if (this.f9083a.e("fmpArrived")) {
                this.f9083a.k();
                b.a.p0.a.y0.k.f.b.f();
            }
        }
    }
}
