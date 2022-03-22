package c.a.n0.q.j.h;

import androidx.annotation.Nullable;
import c.a.n0.q.e.i;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends c.a.n0.q.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.n0.q.j.a, c.a.n0.q.j.d
    public void b(JSONObject jSONObject, i iVar, @Nullable i iVar2, @Nullable i iVar3) {
        a d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, jSONObject, iVar, iVar2, iVar3) == null) || jSONObject == null || (d2 = b.c().d(jSONObject)) == null) {
            return;
        }
        c.a.n0.q.c.b().D(d2);
    }
}
