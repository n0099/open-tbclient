package c.a.p0.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.p0.a.v1.e;
import c.a.p0.b.g.a.d;
import c.a.p0.b.g.a.f;
import c.a.p0.b.g.a.g;
import c.a.p0.b.g.a.h;
import c.a.p0.g.d.c;
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
public class a implements c {
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

    @Override // c.a.p0.g.d.d
    public void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            eVar.b(new c.a.p0.b.g.a.c(eVar));
            eVar.b(new g(eVar));
            eVar.b(new c.a.p0.b.g.f.a.c(eVar));
            eVar.b(new c.a.p0.b.g.f.a.b(eVar));
            eVar.b(new c.a.p0.b.g.c.c(eVar));
            eVar.b(new h(eVar));
            eVar.b(new c.a.p0.b.g.a.e(eVar));
            eVar.b(new c.a.p0.b.g.c.a(eVar));
            eVar.b(new d(eVar));
            eVar.b(new c.a.p0.b.g.a.b(eVar));
            eVar.b(new c.a.p0.b.g.a.a(eVar));
            eVar.b(new f(eVar));
            eVar.b(new c.a.p0.b.g.g.a(eVar));
        }
    }

    @Override // c.a.p0.g.d.d
    @Nullable
    public Map<String, Object> b(@NonNull c.a.p0.a.k.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) ? SwanApi$$ModulesProvider.getV8ApiModules(bVar) : (Map) invokeL.objValue;
    }

    @Override // c.a.p0.g.d.d
    @Nullable
    public Map<String, Object> c(@NonNull c.a.p0.a.k.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) ? SwanApi$$ModulesProvider.getWebviewApiModules(bVar) : (Map) invokeL.objValue;
    }
}
