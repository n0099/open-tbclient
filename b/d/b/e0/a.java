package b.d.b.e0;

import b.d.b.b0;
import b.d.b.d0;
import b.d.b.j;
import b.d.b.k;
import b.d.b.r;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.Socket;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
/* loaded from: classes6.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static a f30186a;
    public transient /* synthetic */ FieldHolder $fh;

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
            }
        }
    }

    public abstract void a(r.a aVar, String str);

    public abstract void b(r.a aVar, String str, String str2);

    public abstract void c(k kVar, SSLSocket sSLSocket, boolean z);

    public abstract int d(b0.a aVar);

    public abstract boolean e(j jVar, b.d.b.e0.h.c cVar);

    public abstract Socket f(j jVar, b.d.b.a aVar, b.d.b.e0.h.f fVar);

    public abstract boolean g(b.d.b.a aVar, b.d.b.a aVar2);

    public abstract b.d.b.e0.h.c h(j jVar, b.d.b.a aVar, b.d.b.e0.h.f fVar, d0 d0Var);

    public abstract boolean i(IllegalArgumentException illegalArgumentException);

    public abstract void j(j jVar, b.d.b.e0.h.c cVar);

    public abstract b.d.b.e0.h.d k(j jVar);

    @Nullable
    public abstract IOException l(b.d.b.e eVar, @Nullable IOException iOException);
}
