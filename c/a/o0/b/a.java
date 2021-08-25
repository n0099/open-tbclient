package c.a.o0.b;

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
public class a implements c.a.o0.e.i.c {
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

    @Override // c.a.o0.e.i.d
    @Nullable
    public Map<String, Object> a(@NonNull c.a.o0.a.u.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) ? SwanApi$$ModulesProvider.getV8ApiModules(bVar) : (Map) invokeL.objValue;
    }

    @Override // c.a.o0.e.i.d
    public void b(c.a.o0.a.c2.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            eVar.b(new c.a.o0.b.p.a.c(eVar));
            eVar.b(new c.a.o0.b.p.a.g(eVar));
            eVar.b(new c.a.o0.b.p.i.a.c(eVar));
            eVar.b(new c.a.o0.b.p.i.a.b(eVar));
            eVar.b(new c.a.o0.b.p.c.b(eVar));
            eVar.b(new c.a.o0.a.q.a(eVar));
            eVar.b(new c.a.o0.b.p.f.c(eVar));
            eVar.b(new c.a.o0.b.p.a.h(eVar));
            eVar.b(new c.a.o0.b.p.a.e(eVar));
            eVar.b(new c.a.o0.b.p.e.a(eVar));
            eVar.b(new c.a.o0.b.p.f.a(eVar));
            eVar.b(new c.a.o0.b.p.b.a(eVar));
            eVar.b(new c.a.o0.b.p.a.d(eVar));
            eVar.b(new c.a.o0.b.p.a.b(eVar));
            eVar.b(new c.a.o0.b.p.a.a(eVar));
            eVar.b(new c.a.o0.b.p.a.f(eVar));
        }
    }

    @Override // c.a.o0.e.i.d
    @Nullable
    public Map<String, Object> c(@NonNull c.a.o0.a.u.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) ? SwanApi$$ModulesProvider.getWebviewApiModules(bVar) : (Map) invokeL.objValue;
    }
}
