package c.a.p0.a.p1.o;

import android.annotation.SuppressLint;
import c.a.p0.a.k;
import c.a.p0.a.p1.e;
import c.a.p0.a.p1.h;
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
    public b a;
    @SuppressLint({"BDThrowableCheck"})

    /* renamed from: b  reason: collision with root package name */
    public final e f7438b;

    /* renamed from: c.a.p0.a.p1.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0415a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0415a(a aVar) {
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
            this.a = aVar;
        }

        @Override // c.a.p0.a.p1.e
        public void a(long j2, long j3, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)}) == null) {
                if (this.a.a == null) {
                    if (k.a) {
                        throw new RuntimeException("DownloadProgressInterceptor.mIProgressCallback == null");
                    }
                } else if (j3 == -1 && j2 != 0) {
                    this.a.a.b(0, j2, j3);
                } else if (j3 > 52428800) {
                    this.a.a.a(j3);
                } else if (j3 <= 0 || j2 > j3 || j2 == 0) {
                    this.a.a.c(j2, j3);
                } else {
                    int floor = (int) Math.floor((100 * j2) / j3);
                    if (floor <= 100) {
                        this.a.a.b(floor, j2, j3);
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
        this.f7438b = new C0415a(this);
    }

    public void b(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.a = bVar;
        }
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chain)) == null) {
            Response proceed = chain.proceed(chain.request());
            return proceed.newBuilder().body(new h(proceed.body(), this.f7438b)).build();
        }
        return (Response) invokeL.objValue;
    }
}
