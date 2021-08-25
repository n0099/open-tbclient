package c.a.o0.a.n0.j.g;

import androidx.annotation.NonNull;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public class c extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull c.a.o0.a.n0.j.f.a aVar) {
        super(aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.o0.a.n0.j.f.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.o0.a.n0.j.g.a
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d();
            c.a.o0.t.d.L(c.a.o0.a.k2.b.w());
            c.a.o0.a.t1.e.a.a();
            c.a.o0.t.d.K(c.a.o0.a.h0.o.h.d.a.a().b());
            c.a.o0.t.d.L(c.a.o0.a.b2.a.c.e());
            Map<String, PMSAppInfo> t = c.a.o0.n.g.a.h().t();
            c.a.o0.a.n0.d d2 = c.a.o0.a.n0.f.c().d();
            ArrayList arrayList = new ArrayList(t.keySet());
            c.a.o0.a.n0.l.c l = c.a.o0.a.n0.l.c.l();
            l.i(15);
            d2.g(arrayList, true, false, l.k());
        }
    }
}
