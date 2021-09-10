package c.a.p0.a.p.c;

import android.content.Context;
import c.a.p0.a.p.d.h1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class k0 implements h1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public k0() {
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

    @Override // c.a.p0.a.p.d.h1
    public void a(Context context, c.a.p0.a.v2.e1.b<Boolean> bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, bVar) == null) || bVar == null) {
            return;
        }
        bVar.onCallback(null);
    }

    @Override // c.a.p0.a.p.d.h1
    public void b(boolean z, c.a.p0.a.v2.e1.b<String> bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, bVar) == null) || bVar == null) {
            return;
        }
        bVar.onCallback(null);
    }

    @Override // c.a.p0.a.p.d.h1
    public void c(Context context, c.a.p0.a.v2.e1.b<String> bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, bVar) == null) || bVar == null) {
            return;
        }
        bVar.onCallback(null);
    }

    @Override // c.a.p0.a.p.d.h1
    public void d(c.a.p0.a.v2.e1.b<Integer> bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) || bVar == null) {
            return;
        }
        bVar.onCallback(null);
    }
}
