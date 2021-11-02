package b.a.p0.a.n1.o;

import b.a.p0.a.k;
import b.a.p0.a.n1.e;
import b.a.p0.a.n1.h;
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
    public b f6927a;

    /* renamed from: b  reason: collision with root package name */
    public final e f6928b;

    /* renamed from: b.a.p0.a.n1.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0311a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f6929a;

        public C0311a(a aVar) {
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
            this.f6929a = aVar;
        }

        @Override // b.a.p0.a.n1.e
        public void a(long j, long j2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
                if (this.f6929a.f6927a == null) {
                    if (k.f6397a) {
                        throw new RuntimeException("DownloadProgressInterceptor.mIProgressCallback == null");
                    }
                } else if (j2 == -1 && j != 0) {
                    this.f6929a.f6927a.b(0, j, j2);
                } else if (j2 > 52428800) {
                    this.f6929a.f6927a.a(j2);
                } else if (j2 <= 0 || j > j2 || j == 0) {
                    this.f6929a.f6927a.c(j, j2);
                } else {
                    int floor = (int) Math.floor((100 * j) / j2);
                    if (floor <= 100) {
                        this.f6929a.f6927a.b(floor, j, j2);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(long j);

        void b(int i2, long j, long j2);

        void c(long j, long j2);
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
        this.f6928b = new C0311a(this);
    }

    public void b(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f6927a = bVar;
        }
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chain)) == null) {
            Response proceed = chain.proceed(chain.request());
            return proceed.newBuilder().body(new h(proceed.body(), this.f6928b)).build();
        }
        return (Response) invokeL.objValue;
    }
}
