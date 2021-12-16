package c.a.q0.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.swan.bdprivate.api.SwanApi$$ModulesProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
@Service
/* loaded from: classes.dex */
public class a implements c.a.q0.g.i.c {
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

    @Override // c.a.q0.g.i.d
    public void a(c.a.q0.a.f2.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            eVar.b(new c.a.q0.b.p.a.c(eVar));
            eVar.b(new c.a.q0.b.p.a.g(eVar));
            eVar.b(new c.a.q0.b.p.f.a.c(eVar));
            eVar.b(new c.a.q0.b.p.f.a.b(eVar));
            eVar.b(new c.a.q0.b.p.c.c(eVar));
            eVar.b(new c.a.q0.b.p.a.h(eVar));
            eVar.b(new c.a.q0.b.p.a.e(eVar));
            eVar.b(new c.a.q0.b.p.c.a(eVar));
            eVar.b(new c.a.q0.b.p.a.d(eVar));
            eVar.b(new c.a.q0.b.p.a.b(eVar));
            eVar.b(new c.a.q0.b.p.a.a(eVar));
            eVar.b(new c.a.q0.b.p.a.f(eVar));
            eVar.b(new c.a.q0.b.p.g.a(eVar));
        }
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
