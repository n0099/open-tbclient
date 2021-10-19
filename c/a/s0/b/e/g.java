package c.a.s0.b.e;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class g implements Executor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final BlockingQueue<Runnable> f29963e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f29964f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f29965g;

    /* renamed from: h  reason: collision with root package name */
    public long f29966h;

    /* renamed from: i  reason: collision with root package name */
    public final String f29967i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1837057975, "Lc/a/s0/b/e/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1837057975, "Lc/a/s0/b/e/g;");
            }
        }
    }

    public g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f29964f = false;
        this.f29965g = false;
        this.f29966h = -1L;
        this.f29967i = str;
        this.f29963e = new LinkedBlockingQueue();
    }

    public void a() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b(0);
        }
    }

    public void b(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            long nanoTime = System.nanoTime();
            long convert = TimeUnit.NANOSECONDS.convert(i2, TimeUnit.MILLISECONDS);
            if (!this.f29965g) {
                if (!this.f29964f) {
                    this.f29964f = true;
                    while (this.f29964f) {
                        if (i2 == 0) {
                            try {
                                c(false, 0L).run();
                            } catch (InterruptedIOException | RuntimeException e2) {
                                this.f29964f = false;
                                this.f29965g = true;
                                throw e2;
                            }
                        } else {
                            c(true, (convert - System.nanoTime()) + nanoTime).run();
                        }
                    }
                    return;
                }
                throw new IllegalStateException("Cannot run loop when it is already running.");
            }
            throw new IllegalStateException("Cannot run loop as an exception has occurred previously.");
        }
    }

    public final Runnable c(boolean z, long j2) throws InterruptedIOException {
        Runnable poll;
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j2)})) == null) {
            try {
                if (!z) {
                    poll = this.f29963e.take();
                } else {
                    poll = this.f29963e.poll(j2, TimeUnit.NANOSECONDS);
                }
                if (poll != null) {
                    return poll;
                }
                c.a.s0.a.a.c("cr_CronetHttpURLConn", "****** Messageloop timeout exception, url is: %s", this.f29967i);
                throw new SocketTimeoutException();
            } catch (InterruptedException e2) {
                InterruptedIOException interruptedIOException = new InterruptedIOException();
                interruptedIOException.initCause(e2);
                throw interruptedIOException;
            }
        }
        return (Runnable) invokeCommon.objValue;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) throws RejectedExecutionException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, runnable) == null) {
            if (runnable != null) {
                try {
                    this.f29963e.put(runnable);
                    return;
                } catch (InterruptedException e2) {
                    throw new RejectedExecutionException(e2);
                }
            }
            throw new IllegalArgumentException();
        }
    }

    public void quit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f29964f = false;
        }
    }
}
