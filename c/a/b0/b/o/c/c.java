package c.a.b0.b.o.c;

import android.app.Application;
import androidx.annotation.NonNull;
import c.a.b0.d0.k;
import c.a.b0.i.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Service
/* loaded from: classes.dex */
public final class c implements c.a.b0.l.a {
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

    @Override // c.a.b0.l.a
    public void a(@NonNull Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, application) == null) {
            a.a().b(b.c());
            application.registerActivityLifecycleCallbacks(a.a());
            b.c().g(new c.a.b0.b.o.a());
            b.c().f(new c.a.b0.b.o.b());
            c.a.b0.n.a.b(b.c());
        }
    }

    @Override // c.a.b0.l.a
    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && k.b()) {
            h.b().request().a(false);
            c.a.b0.m.a.a().request();
        }
    }
}
