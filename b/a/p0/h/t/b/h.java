package b.a.p0.h.t.b;

import b.a.p0.a.c2.f.a0;
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
/* loaded from: classes4.dex */
public class h implements b.a.p0.a.p.b.a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public h() {
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

    @Override // b.a.p0.a.p.b.a.b
    public List<a0> a(b.a.p0.a.c2.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new b.a.p0.h.m.b.c(eVar));
            arrayList.add(new b.a.p0.h.m.b.d(eVar));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // b.a.p0.a.p.b.a.b
    public List<a0> b(b.a.p0.a.c2.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar)) == null) ? Arrays.asList(new b.a.p0.h.p.a.a(eVar), new b.a.p0.h.f.e(eVar), new b.a.p0.h.h.a(eVar), new b.a.p0.h.m.b.a(eVar)) : (List) invokeL.objValue;
    }

    @Override // b.a.p0.a.p.b.a.b
    public List<a0> c(b.a.p0.a.c2.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new b.a.p0.h.e0.a.a.c(eVar));
            arrayList.add(new b.a.p0.h.e0.a.a.b(eVar));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
