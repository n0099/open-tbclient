package c.a.s0.g.i;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
@Singleton
@Service
/* loaded from: classes6.dex */
public class e implements c.a.s0.a.c1.d.c {
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

    @Override // c.a.s0.a.c1.d.c
    public void a(c.a.s0.a.f2.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            a.b().a(eVar);
            a.a().a(eVar);
        }
    }

    @Override // c.a.s0.a.c1.d.c
    public Map<String, Object> b(@NonNull c.a.s0.a.u.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) {
            Map<String, Object> b2 = a.b().b(bVar);
            Map<String, Object> b3 = a.a().b(bVar);
            HashMap hashMap = new HashMap();
            if (b2 != null) {
                hashMap.putAll(b2);
            }
            if (b3 != null) {
                hashMap.putAll(b3);
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    @Override // c.a.s0.a.c1.d.c
    public Map<String, Object> c(@NonNull c.a.s0.a.u.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
            Map<String, Object> c2 = a.b().c(bVar);
            Map<String, Object> c3 = a.a().c(bVar);
            HashMap hashMap = new HashMap();
            if (c2 != null) {
                hashMap.putAll(c2);
            }
            if (c3 != null) {
                hashMap.putAll(c3);
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    @Override // c.a.s0.a.c1.d.c
    public Map<Class, Object> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (Map) invokeV.objValue;
    }
}
