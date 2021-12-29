package c.a.r0.j.u.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class h implements c.a.r0.j.u.c.i {
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

    @Override // c.a.r0.j.u.c.i
    public void a(c.a.r0.j.f0.b.c cVar, c.a.r0.j.f0.b.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, cVar, bVar) == null) || bVar == null) {
            return;
        }
        bVar.a(cVar, "Method 'shareVideo' is not implemented.");
    }

    @Override // c.a.r0.j.u.c.i
    public void b(c.a.r0.j.e0.h.d dVar, c.a.r0.j.e0.h.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, cVar) == null) || cVar == null) {
            return;
        }
        cVar.a(dVar, "Method 'clipVideo' is not implemented.");
    }
}
