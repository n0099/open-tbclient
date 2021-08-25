package c.a.o0.h.t.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class g implements c.a.o0.h.t.c.h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public g() {
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

    @Override // c.a.o0.h.t.c.h
    public void a(c.a.o0.h.e0.b.c cVar, c.a.o0.h.e0.b.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, cVar, bVar) == null) || bVar == null) {
            return;
        }
        bVar.a(cVar, "Method 'shareVideo' is not implemented.");
    }

    @Override // c.a.o0.h.t.c.h
    public void b(c.a.o0.h.d0.h.d dVar, c.a.o0.h.d0.h.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, cVar) == null) || cVar == null) {
            return;
        }
        cVar.a(dVar, "Method 'clipVideo' is not implemented.");
    }
}
