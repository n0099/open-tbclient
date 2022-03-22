package c.a.n0.q.i.i.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class g implements Runnable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final c.a.n0.q.o.a f9174d;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicBoolean f9175b;

    /* renamed from: c  reason: collision with root package name */
    public a f9176c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-758518131, "Lc/a/n0/q/i/i/g/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-758518131, "Lc/a/n0/q/i/i/g/g;");
                return;
            }
        }
        f9174d = c.a.n0.q.o.a.e();
    }

    public g(AtomicBoolean atomicBoolean, b bVar, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {atomicBoolean, bVar, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f9175b = atomicBoolean;
        this.a = bVar;
        this.f9176c = aVar;
    }

    public final <T> void a(f<T> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            this.a.a(fVar);
            try {
                try {
                    fVar.run();
                } catch (Exception e2) {
                    f9174d.g("PMSTaskExecutor", "#runTask 包下载任务出错", e2);
                }
            } finally {
                this.a.b(fVar);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            while (!this.f9175b.get()) {
                Runnable a = this.f9176c.a(true);
                if (!(a instanceof f)) {
                    return;
                }
                try {
                    a((f) a);
                } catch (Throwable th) {
                    f9174d.g("PMSTaskExecutor", "#run 包下载任务出错", th);
                }
            }
        }
    }
}
