package c.a.o0.h.y.d;

import c.a.o0.a.k;
import c.a.o0.a.n1.e;
import c.a.o0.a.n1.h;
import c.a.o0.a.n1.o.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;
/* loaded from: classes3.dex */
public class d implements Interceptor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a.b f11583a;

    /* renamed from: b  reason: collision with root package name */
    public final e f11584b;

    /* loaded from: classes3.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f11585a;

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
            this.f11585a = dVar;
        }

        @Override // c.a.o0.a.n1.e
        public void a(long j2, long j3, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)}) == null) {
                if (this.f11585a.f11583a == null) {
                    boolean z2 = k.f7049a;
                } else if (j3 == -1 && j2 != 0) {
                    this.f11585a.f11583a.b(0, j2, j3);
                } else if (j3 > 52428800) {
                    this.f11585a.f11583a.a(j3);
                    this.f11585a.f11583a = null;
                } else if (j3 <= 0 || j2 > j3 || j2 == 0) {
                    this.f11585a.f11583a.c(j2, j3);
                    this.f11585a.f11583a = null;
                } else {
                    int floor = (int) Math.floor((100 * j2) / j3);
                    if (floor <= 100) {
                        this.f11585a.f11583a.b(floor, j2, j3);
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
        this.f11584b = new a(this);
    }

    public void c(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f11583a = bVar;
        }
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chain)) == null) {
            Response proceed = chain.proceed(chain.request());
            return proceed.newBuilder().body(new h(proceed.body(), this.f11584b)).build();
        }
        return (Response) invokeL.objValue;
    }
}
