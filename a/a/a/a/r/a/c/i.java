package a.a.a.a.r.a.c;

import a.a.a.a.r.a.c.g;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.nativ.NativeUnifiedADData;
/* loaded from: classes.dex */
public class i implements g.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a.a.a.a.r.b.b.b f1195a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NativeUnifiedADData f1196b;

    public i(g gVar, a.a.a.a.r.b.b.b bVar, NativeUnifiedADData nativeUnifiedADData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar, bVar, nativeUnifiedADData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1195a = bVar;
        this.f1196b = nativeUnifiedADData;
    }

    @Override // a.a.a.a.r.a.c.g.d
    public void onADStatusChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f1195a.a(this.f1196b);
        }
    }
}
