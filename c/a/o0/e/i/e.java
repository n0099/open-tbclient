package c.a.o0.e.i;

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
/* loaded from: classes.dex */
public class e implements c.a.o0.a.c1.d.c {
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

    @Override // c.a.o0.a.c1.d.c
    public Map<String, Object> a(@NonNull c.a.o0.a.u.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
            Map<String, Object> a2 = a.b().a(bVar);
            Map<String, Object> a3 = a.a().a(bVar);
            HashMap hashMap = new HashMap();
            if (a2 != null) {
                hashMap.putAll(a2);
            }
            if (a3 != null) {
                hashMap.putAll(a3);
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    @Override // c.a.o0.a.c1.d.c
    public void b(c.a.o0.a.c2.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            a.b().b(eVar);
            a.a().b(eVar);
        }
    }

    @Override // c.a.o0.a.c1.d.c
    public Map<String, Object> c(@NonNull c.a.o0.a.u.c.b bVar) {
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

    @Override // c.a.o0.a.c1.d.c
    public Map<Class, Object> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (Map) invokeV.objValue;
    }
}
