package c.a.s0.q.k.h;

import androidx.annotation.Nullable;
import c.a.s0.q.f.i;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d extends c.a.s0.q.k.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
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

    @Override // c.a.s0.q.k.a, c.a.s0.q.k.d
    public void b(JSONObject jSONObject, i iVar, @Nullable i iVar2, @Nullable i iVar3) {
        a d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, jSONObject, iVar, iVar2, iVar3) == null) || jSONObject == null || (d2 = b.c().d(jSONObject)) == null) {
            return;
        }
        c.a.s0.q.c.b().D(d2);
    }
}
