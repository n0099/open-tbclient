package b.a.u.a.g;

import android.content.Context;
import b.a.u.a.h.e;
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

    /* renamed from: c  reason: collision with root package name */
    public static a f29045c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f29046d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f29047e;

    /* renamed from: f  reason: collision with root package name */
    public static final int f29048f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f29049a;

    /* renamed from: b  reason: collision with root package name */
    public Context f29050b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1211981199, "Lb/a/u/a/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1211981199, "Lb/a/u/a/g/a;");
                return;
            }
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f29046d = availableProcessors;
        f29047e = Math.max(2, Math.min(availableProcessors - 1, 4));
        f29048f = (f29046d * 2) + 1;
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f29049a = null;
        this.f29050b = context;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f29047e, f29048f, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f29049a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        Executors.newSingleThreadExecutor();
    }

    public static a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (f29045c == null) {
                synchronized (a.class) {
                    if (f29045c == null) {
                        f29045c = new a(context);
                    }
                }
            }
            return f29045c;
        }
        return (a) invokeL.objValue;
    }

    public void b(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
            try {
                this.f29049a.submit(runnable);
            } catch (Throwable th) {
                e.c("TaskManager", "Exception ", th);
            }
        }
    }
}
