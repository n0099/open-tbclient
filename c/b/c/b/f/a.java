package c.b.c.b.f;

import android.os.SystemClock;
import c.b.c.b.i;
import c.b.c.b.k;
import c.b.c.b.l;
import c.b.c.b.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.Thread;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
/* loaded from: classes4.dex */
public class a implements Thread.UncaughtExceptionHandler {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static a f31312i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f31313e;

    /* renamed from: f  reason: collision with root package name */
    public HashSet<Thread.UncaughtExceptionHandler> f31314f;

    /* renamed from: g  reason: collision with root package name */
    public b f31315g;

    /* renamed from: h  reason: collision with root package name */
    public long f31316h;

    /* renamed from: c.b.c.b.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1444a extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f31317e;

        public C1444a(a aVar) {
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
            this.f31317e = aVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            super.run();
            try {
                while (true) {
                    SystemClock.sleep(Math.abs(new Random().nextLong()) % 5000);
                    this.f31317e.g();
                }
            } catch (Throwable unused) {
            }
        }
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
        this.f31314f = new HashSet<>();
        this.f31316h = -1L;
        g();
        e();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f31312i == null) {
                f31312i = new a();
            }
            return f31312i;
        }
        return (a) invokeV.objValue;
    }

    public void c(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f31315g = bVar;
        }
    }

    public final boolean d(Thread thread, Throwable th) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, thread, th)) == null) {
            k g2 = m.c().g();
            if (g2 != null) {
                try {
                    return g2.a(th, thread);
                } catch (Throwable unused) {
                    return true;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                new C1444a(this).start();
            } catch (Throwable unused) {
            }
        }
    }

    public final void f(Thread thread, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, thread, th) == null) {
            List<i> e2 = m.c().e();
            com.bytedance.tea.crash.c cVar = com.bytedance.tea.crash.c.f68528b;
            for (i iVar : e2) {
                try {
                    iVar.a(cVar, l.n.a(th), thread);
                } catch (Throwable th2) {
                    l.k.c(th2);
                }
            }
        }
    }

    public final void g() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()) == this) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
        if (this.f31313e == null) {
            this.f31313e = defaultUncaughtExceptionHandler;
        } else {
            this.f31314f.add(defaultUncaughtExceptionHandler);
        }
    }

    public final void h(Thread thread, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, thread, th) == null) {
            try {
                Iterator<Thread.UncaughtExceptionHandler> it = this.f31314f.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().uncaughtException(thread, th);
                    } catch (Throwable unused) {
                    }
                }
                this.f31313e.uncaughtException(thread, th);
            } catch (Throwable unused2) {
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        boolean d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, thread, th) == null) || SystemClock.uptimeMillis() - this.f31316h < 20000) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.f31316h = SystemClock.uptimeMillis();
            d2 = d(thread, th);
        } finally {
            try {
            } finally {
            }
        }
        if (d2) {
            com.bytedance.tea.crash.c cVar = com.bytedance.tea.crash.c.f68528b;
            f(thread, th);
            if (d2 && this.f31315g != null && this.f31315g.a(th)) {
                this.f31315g.a(currentTimeMillis, thread, th);
                String str = "end dispose " + th;
            }
        }
    }
}
