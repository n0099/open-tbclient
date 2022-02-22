package c.a.s0.a.p.c;

import android.content.Context;
import c.a.s0.a.p.d.n1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class o0 implements n1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public o0() {
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

    @Override // c.a.s0.a.p.d.n1
    public void a(Context context, c.a.s0.a.z2.g1.c<Boolean> cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, cVar) == null) || cVar == null) {
            return;
        }
        cVar.onCallback(null);
    }

    @Override // c.a.s0.a.p.d.n1
    public void b(boolean z, c.a.s0.a.z2.g1.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, cVar) == null) || cVar == null) {
            return;
        }
        cVar.onCallback(null);
    }

    @Override // c.a.s0.a.p.d.n1
    public void c(Context context, c.a.s0.a.z2.g1.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, cVar) == null) || cVar == null) {
            return;
        }
        cVar.onCallback(null);
    }

    @Override // c.a.s0.a.p.d.n1
    public void d(c.a.s0.a.z2.g1.c<Integer> cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) || cVar == null) {
            return;
        }
        cVar.onCallback(null);
    }
}
