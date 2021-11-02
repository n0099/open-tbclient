package b.a.f0.d.a;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f2879a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f2880b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f2881c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f2882d;

    /* renamed from: e  reason: collision with root package name */
    public static final ThreadFactory f2883e;

    /* renamed from: f  reason: collision with root package name */
    public static final BlockingQueue<Runnable> f2884f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.f0.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class ThreadFactoryC0068a implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ThreadFactoryC0068a() {
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

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) ? new Thread(runnable) : (Thread) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Runnable f2885a;

        /* renamed from: b  reason: collision with root package name */
        public String f2886b;

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

        public /* synthetic */ b(ThreadFactoryC0068a threadFactoryC0068a) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static class c extends AsyncTask<b, Object, Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Object doInBackground(b... bVarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVarArr)) == null) {
                Process.setThreadPriority(10);
                try {
                    if (bVarArr[0] == null || bVarArr[0].f2885a == null) {
                        return null;
                    }
                    String str = !TextUtils.isEmpty(bVarArr[0].f2886b) ? bVarArr[0].f2886b : "noname";
                    Thread.currentThread().setName(str);
                    if (a.f2879a) {
                        String str2 = "start to run task " + str;
                    }
                    bVarArr[0].f2885a.run();
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return invokeL.objValue;
        }

        public /* synthetic */ c(ThreadFactoryC0068a threadFactoryC0068a) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-85295823, "Lb/a/f0/d/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-85295823, "Lb/a/f0/d/a/a;");
                return;
            }
        }
        f2879a = b.a.f0.a.a.a.f2779a;
        new Handler(Looper.getMainLooper());
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f2880b = availableProcessors;
        f2881c = Math.max(2, Math.min(availableProcessors - 1, 4));
        f2882d = Math.max(2, f2880b - 1);
        f2883e = new ThreadFactoryC0068a();
        f2884f = new LinkedBlockingQueue();
        if (f2879a) {
            String str = "core pool size: " + f2881c + " max size: " + f2882d;
        }
        int i2 = f2882d;
        new ThreadPoolExecutor(i2, i2, 30L, TimeUnit.SECONDS, f2884f, f2883e).allowCoreThreadTimeOut(true);
    }

    public static void b(Runnable runnable, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, runnable, str) == null) {
            b bVar = new b(null);
            bVar.f2885a = runnable;
            bVar.f2886b = str;
            new c(null).execute(bVar);
        }
    }
}
