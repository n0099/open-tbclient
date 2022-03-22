package c.a.n0.j.u.b;

import c.a.n0.a.v1.f.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Singleton
@Service
/* loaded from: classes2.dex */
public class j implements c.a.n0.a.f.b.a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public j() {
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

    @Override // c.a.n0.a.f.b.a.b
    public List<z> a(c.a.n0.a.v1.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new c.a.n0.j.m.b.c(eVar));
            arrayList.add(new c.a.n0.j.m.b.d(eVar));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // c.a.n0.a.f.b.a.b
    public List<z> b(c.a.n0.a.v1.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar)) == null) ? Arrays.asList(new c.a.n0.j.p.a.a(eVar), new c.a.n0.j.f.e(eVar), new c.a.n0.j.h.a(eVar), new c.a.n0.j.m.b.a(eVar)) : (List) invokeL.objValue;
    }

    @Override // c.a.n0.a.f.b.a.b
    public List<z> c(c.a.n0.a.v1.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new c.a.n0.j.f0.a.a.c(eVar));
            arrayList.add(new c.a.n0.j.f0.a.a.b(eVar));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
