package c.a.d0.v.c0;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<c.a.d0.v.k0.c> a;

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
                return;
            }
        }
        this.a = new ArrayList<>();
    }

    public void b(@NonNull c.a.d0.v.k0.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || this.a.contains(cVar)) {
            return;
        }
        c.a.d0.x.a.b(this.a, cVar);
    }

    public void c(@NonNull p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pVar) == null) {
            int size = this.a.size();
            for (int i2 = 0; i2 < size; i2++) {
                c.a.d0.v.k0.c cVar = (c.a.d0.v.k0.c) c.a.d0.x.a.d(this.a, i2);
                if (cVar != null) {
                    if (i2 == 0) {
                        cVar.d(pVar);
                    } else {
                        cVar.d(p.a(pVar));
                    }
                }
            }
        }
    }

    public void d(@NonNull c.a.d0.v.k0.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            c.a.d0.x.a.j(this.a, cVar);
        }
    }
}
