package b.a.p0.h.j.n;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class i implements b.a.p0.h.j.p.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f10673a;

    public i(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10673a = fVar;
    }

    private void setResult(b.a.p0.h.j.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, aVar) == null) {
            this.f10673a.f9436d.clear();
            if (aVar != null) {
                this.f10673a.f9436d.putString("functionType", aVar.a());
                this.f10673a.f9436d.putString("resultData", aVar.b());
                this.f10673a.f9436d.putInt("resultStatus", aVar.c());
            }
            this.f10673a.c();
        }
    }

    @Override // b.a.p0.h.j.p.a
    public void a(b.a.p0.h.j.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            setResult(aVar);
        }
    }
}
