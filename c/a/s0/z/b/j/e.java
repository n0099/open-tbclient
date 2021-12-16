package c.a.s0.z.b.j;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.q0.b.p.a.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.swan.apps.api.SwanApi$$ModulesProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
@Singleton
@Service
/* loaded from: classes9.dex */
public class e implements c.a.q0.g.i.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
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

    @Override // c.a.q0.g.i.d
    public void a(c.a.q0.a.f2.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null) {
            return;
        }
        eVar.b(new g(eVar));
        eVar.b(new c.a.s0.z.b.i.a(eVar));
        eVar.b(new c.a.q0.b.p.a.c(eVar));
        eVar.b(new c.a.q0.b.p.a.e(eVar));
        eVar.b(new c.a.q0.b.p.a.g(eVar));
        eVar.b(new c.a.q0.a.f2.f.g0.a(eVar));
        eVar.b(new c.a.q0.a.f2.f.g0.b(eVar));
        eVar.b(new c.a.q0.a.h2.b.f(eVar));
        eVar.b(new h(eVar));
        eVar.b(new c.a.q0.a.q.a(eVar));
        eVar.b(new d(eVar));
    }

    @Override // c.a.q0.g.i.d
    @Nullable
    public Map<String, Object> b(@NonNull c.a.q0.a.u.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) ? SwanApi$$ModulesProvider.getV8ApiModules(bVar) : (Map) invokeL.objValue;
    }

    @Override // c.a.q0.g.i.d
    @Nullable
    public Map<String, Object> c(@NonNull c.a.q0.a.u.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) ? SwanApi$$ModulesProvider.getWebviewApiModules(bVar) : (Map) invokeL.objValue;
    }
}
