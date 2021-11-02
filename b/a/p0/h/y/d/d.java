package b.a.p0.h.y.d;

import b.a.p0.a.k;
import b.a.p0.a.n1.e;
import b.a.p0.a.n1.h;
import b.a.p0.a.n1.o.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;
/* loaded from: classes4.dex */
public class d implements Interceptor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a.b f10809a;

    /* renamed from: b  reason: collision with root package name */
    public final e f10810b;

    /* loaded from: classes4.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f10811a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10811a = dVar;
        }

        @Override // b.a.p0.a.n1.e
        public void a(long j, long j2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
                if (this.f10811a.f10809a == null) {
                    boolean z2 = k.f6397a;
                } else if (j2 == -1 && j != 0) {
                    this.f10811a.f10809a.b(0, j, j2);
                } else if (j2 > 52428800) {
                    this.f10811a.f10809a.a(j2);
                    this.f10811a.f10809a = null;
                } else if (j2 <= 0 || j > j2 || j == 0) {
                    this.f10811a.f10809a.c(j, j2);
                    this.f10811a.f10809a = null;
                } else {
                    int floor = (int) Math.floor((100 * j) / j2);
                    if (floor <= 100) {
                        this.f10811a.f10809a.b(floor, j, j2);
                    }
                }
            }
        }
    }

    public d() {
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
        this.f10810b = new a(this);
    }

    public void c(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f10809a = bVar;
        }
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chain)) == null) {
            Response proceed = chain.proceed(chain.request());
            return proceed.newBuilder().body(new h(proceed.body(), this.f10810b)).build();
        }
        return (Response) invokeL.objValue;
    }
}
