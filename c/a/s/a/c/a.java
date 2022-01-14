package c.a.s.a.c;

import c.a.s.a.e.c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f12039b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f12040c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f12041d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f12042e;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadPoolExecutor a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-273671018, "Lc/a/s/a/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-273671018, "Lc/a/s/a/c/a;");
                return;
            }
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f12040c = availableProcessors;
        f12041d = Math.max(4, Math.min(availableProcessors - 1, 4));
        f12042e = (f12040c * 3) + 1;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        ThreadPoolExecutor.DiscardOldestPolicy discardOldestPolicy = new ThreadPoolExecutor.DiscardOldestPolicy();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f12041d, f12042e, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Executors.defaultThreadFactory(), discardOldestPolicy);
        this.a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(false);
        Executors.newSingleThreadExecutor();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f12039b == null) {
                synchronized (a.class) {
                    if (f12039b == null) {
                        f12039b = new a();
                    }
                }
            }
            return f12039b;
        }
        return (a) invokeV.objValue;
    }

    public final boolean b(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
            try {
                this.a.submit(runnable);
                return true;
            } catch (Throwable th) {
                c.b("UBCTaskManager", "Exception ", th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
