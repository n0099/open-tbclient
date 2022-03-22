package c.a.p0.b0.b.k;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.n0.b.g.a.h;
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
/* loaded from: classes2.dex */
public class e implements c.a.n0.g.d.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
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

    @Override // c.a.n0.g.d.d
    public void a(c.a.n0.a.v1.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null) {
            return;
        }
        eVar.b(new g(eVar));
        eVar.b(new c.a.p0.b0.b.j.a(eVar));
        eVar.b(new c.a.n0.b.g.a.c(eVar));
        eVar.b(new c.a.n0.b.g.a.e(eVar));
        eVar.b(new c.a.n0.b.g.a.g(eVar));
        eVar.b(new c.a.n0.a.v1.f.g0.a(eVar));
        eVar.b(new c.a.n0.a.v1.f.g0.b(eVar));
        eVar.b(new c.a.n0.a.x1.b.f(eVar));
        eVar.b(new h(eVar));
        eVar.b(new c.a.n0.a.g.a(eVar));
        eVar.b(new d(eVar));
    }

    @Override // c.a.n0.g.d.d
    @Nullable
    public Map<String, Object> b(@NonNull c.a.n0.a.k.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) ? SwanApi$$ModulesProvider.getV8ApiModules(bVar) : (Map) invokeL.objValue;
    }

    @Override // c.a.n0.g.d.d
    @Nullable
    public Map<String, Object> c(@NonNull c.a.n0.a.k.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) ? SwanApi$$ModulesProvider.getWebviewApiModules(bVar) : (Map) invokeL.objValue;
    }
}
