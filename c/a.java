package c;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final a f1475b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f1476c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f1477d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f1478e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Executor f1479a;

    /* renamed from: c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0012a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class b implements Executor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
                new Handler(Looper.getMainLooper()).post(runnable);
            }
        }

        public /* synthetic */ b(C0012a c0012a) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(73185138, "Lc/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(73185138, "Lc/a;");
                return;
            }
        }
        f1475b = new a();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f1476c = availableProcessors;
        f1477d = availableProcessors + 1;
        f1478e = (availableProcessors * 2) + 1;
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
        this.f1479a = new b(null);
    }

    @SuppressLint({"NewApi"})
    public static void a(ThreadPoolExecutor threadPoolExecutor, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65538, null, threadPoolExecutor, z) == null) || Build.VERSION.SDK_INT < 9) {
            return;
        }
        threadPoolExecutor.allowCoreThreadTimeOut(z);
    }

    public static ExecutorService b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f1477d, f1478e, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
            a(threadPoolExecutor, true);
            return threadPoolExecutor;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public static Executor c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? f1475b.f1479a : (Executor) invokeV.objValue;
    }
}
