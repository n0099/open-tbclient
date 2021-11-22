package b.a.p0.q.j.i.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class g implements Runnable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final b.a.p0.q.p.a f11819h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f11820e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicBoolean f11821f;

    /* renamed from: g  reason: collision with root package name */
    public a f11822g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-955823507, "Lb/a/p0/q/j/i/g/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-955823507, "Lb/a/p0/q/j/i/g/g;");
                return;
            }
        }
        f11819h = b.a.p0.q.p.a.e();
    }

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {atomicBoolean, bVar, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f11821f = atomicBoolean;
        this.f11820e = bVar;
        this.f11822g = aVar;
    }

    public final <T> void a(f<T> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            this.f11820e.a(fVar);
            try {
                try {
                    fVar.run();
                } catch (Exception e2) {
                    f11819h.g("PMSTaskExecutor", "#runTask 包下载任务出错", e2);
                }
            } finally {
                this.f11820e.b(fVar);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            while (!this.f11821f.get()) {
                Runnable a2 = this.f11822g.a(true);
                if (!(a2 instanceof f)) {
                    return;
                }
                try {
                    a((f) a2);
                } catch (Throwable th) {
                    f11819h.g("PMSTaskExecutor", "#run 包下载任务出错", th);
                }
            }
        }
    }
}
