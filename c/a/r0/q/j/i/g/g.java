package c.a.r0.q.j.i.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class g implements Runnable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final c.a.r0.q.p.a f11671h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f11672e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicBoolean f11673f;

    /* renamed from: g  reason: collision with root package name */
    public a f11674g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-189319824, "Lc/a/r0/q/j/i/g/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-189319824, "Lc/a/r0/q/j/i/g/g;");
                return;
            }
        }
        f11671h = c.a.r0.q.p.a.e();
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
        this.f11673f = atomicBoolean;
        this.f11672e = bVar;
        this.f11674g = aVar;
    }

    public final <T> void a(f<T> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            this.f11672e.a(fVar);
            try {
                try {
                    fVar.run();
                } catch (Exception e2) {
                    f11671h.g("PMSTaskExecutor", "#runTask 包下载任务出错", e2);
                }
            } finally {
                this.f11672e.b(fVar);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            while (!this.f11673f.get()) {
                Runnable a = this.f11674g.a(true);
                if (!(a instanceof f)) {
                    return;
                }
                try {
                    a((f) a);
                } catch (Throwable th) {
                    f11671h.g("PMSTaskExecutor", "#run 包下载任务出错", th);
                }
            }
        }
    }
}
