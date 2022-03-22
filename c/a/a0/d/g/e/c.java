package c.a.a0.d.g.e;

import android.app.Application;
import androidx.annotation.NonNull;
import c.a.a0.h0.l;
import c.a.a0.l.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Service
/* loaded from: classes.dex */
public final class c implements c.a.a0.o.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.a0.o.a
    public void a(@NonNull Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, application) == null) {
            a.a().b(b.e());
            application.registerActivityLifecycleCallbacks(a.a());
            b.e().b(new c.a.a0.d.g.a());
            b.e().h(new c.a.a0.d.g.b());
            c.a.a0.q.a.c(b.e());
        }
    }

    @Override // c.a.a0.o.a
    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && l.b()) {
            h.b().request().a(false);
            c.a.a0.p.a.a().request();
        }
    }
}
