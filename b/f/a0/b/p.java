package b.f.a0.b;

import b.f.a0.b.o;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.nativ.NativeUnifiedADData;
/* loaded from: classes6.dex */
public class p implements o.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.fun.module.gdt.x f31798a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NativeUnifiedADData f31799b;

    public p(o oVar, com.fun.module.gdt.x xVar, NativeUnifiedADData nativeUnifiedADData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {oVar, xVar, nativeUnifiedADData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31798a = xVar;
        this.f31799b = nativeUnifiedADData;
    }

    @Override // b.f.a0.b.o.e
    public void onADStatusChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f31798a.b(this.f31799b);
        }
    }
}
