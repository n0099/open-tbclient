package c.a.s0.v;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.s0.j3.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
@Service
/* loaded from: classes8.dex */
public class c extends c.a.c0.d.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
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

    @Override // c.a.c0.d.d.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "commonVideo" : (String) invokeV.objValue;
    }

    @Override // c.a.c0.d.d.a
    public boolean b(@NonNull Context context, @NonNull c.a.c0.d.f.a aVar, @Nullable Map<String, Object> map, @Nullable c.a.c0.d.g.d dVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, aVar, map, dVar)) == null) {
            super.b(context, aVar, map, dVar);
            return z.h(context, aVar.d());
        }
        return invokeLLLL.booleanValue;
    }
}
