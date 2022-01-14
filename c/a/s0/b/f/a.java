package c.a.s0.b.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void d(List<c.a.d.n.e.n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, list) == null) || list == null) {
            return;
        }
        HashMap hashMap = new HashMap(c.a.s0.b.d.b());
        for (c.a.d.n.e.n nVar : list) {
            if (nVar instanceof c.a.s0.s.q.a) {
                c.a.s0.s.q.a aVar = (c.a.s0.s.q.a) nVar;
                for (Map.Entry entry : hashMap.entrySet()) {
                    aVar.setABTest((BdUniqueId) entry.getKey(), (c.a.s0.b.e) entry.getValue());
                }
            }
        }
    }

    public static void e(n... nVarArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, nVarArr) == null) || nVarArr == null) {
            return;
        }
        HashMap hashMap = new HashMap(c.a.s0.b.d.b());
        for (n nVar : nVarArr) {
            if (nVar != null) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    nVar.setABTest((BdUniqueId) entry.getKey(), (c.a.s0.b.e) entry.getValue());
                }
            }
        }
    }

    public abstract ArrayList<String> a();

    public abstract c.a.s0.b.e b();

    public abstract BdUniqueId c();

    public abstract void f(c.a.s0.b.e eVar);
}
