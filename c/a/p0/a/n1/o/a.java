package c.a.p0.a.n1.o;

import c.a.p0.a.k;
import c.a.p0.a.n1.e;
import c.a.p0.a.n1.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;
/* loaded from: classes.dex */
public class a implements Interceptor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f7618a;

    /* renamed from: b  reason: collision with root package name */
    public final e f7619b;

    /* renamed from: c.a.p0.a.n1.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0316a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f7620a;

        public C0316a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7620a = aVar;
        }

        @Override // c.a.p0.a.n1.e
        public void a(long j2, long j3, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)}) == null) {
                if (this.f7620a.f7618a == null) {
                    if (k.f7077a) {
                        throw new RuntimeException("DownloadProgressInterceptor.mIProgressCallback == null");
                    }
                } else if (j3 == -1 && j2 != 0) {
                    this.f7620a.f7618a.b(0, j2, j3);
                } else if (j3 > 52428800) {
                    this.f7620a.f7618a.a(j3);
                } else if (j3 <= 0 || j2 > j3 || j2 == 0) {
                    this.f7620a.f7618a.c(j2, j3);
                } else {
                    int floor = (int) Math.floor((100 * j2) / j3);
                    if (floor <= 100) {
                        this.f7620a.f7618a.b(floor, j2, j3);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(long j2);

        void b(int i2, long j2, long j3);

        void c(long j2, long j3);
    }

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
        this.f7619b = new C0316a(this);
    }

    public void b(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f7618a = bVar;
        }
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chain)) == null) {
            Response proceed = chain.proceed(chain.request());
            return proceed.newBuilder().body(new h(proceed.body(), this.f7619b)).build();
        }
        return (Response) invokeL.objValue;
    }
}
