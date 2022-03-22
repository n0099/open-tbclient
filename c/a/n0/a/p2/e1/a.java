package c.a.n0.a.p2.e1;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.v0.e.f.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public transient /* synthetic */ FieldHolder $fh;
    public final Set<c.a.n0.a.p2.g1.c<Pipe.SourceChannel>> a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f5812b;

    /* renamed from: c  reason: collision with root package name */
    public int f5813c;

    /* renamed from: d  reason: collision with root package name */
    public long f5814d;

    /* renamed from: e  reason: collision with root package name */
    public TimeUnit f5815e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.n0.a.p2.g1.c<String> f5816f;

    /* renamed from: g  reason: collision with root package name */
    public final c.a f5817g;

    /* renamed from: h  reason: collision with root package name */
    public float f5818h;

    /* renamed from: c.a.n0.a.p2.e1.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0417a implements c.a.n0.a.p2.g1.c<c.a.n0.a.p2.g1.c<Pipe.SourceChannel>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f5819b;

        public C0417a(a aVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5819b = aVar;
            this.a = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.n0.a.p2.g1.c<Pipe.SourceChannel> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                try {
                    this.a.add(new e(this.f5819b, cVar));
                } catch (IOException e2) {
                    if (a.i) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.n0.a.p2.g1.c<e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CountDownLatch a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ExecutorService f5820b;

        public b(a aVar, CountDownLatch countDownLatch, ExecutorService executorService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, countDownLatch, executorService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = countDownLatch;
            this.f5820b = executorService;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
                eVar.f(this.a);
                this.f5820b.submit(eVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.n0.a.p2.g1.c<e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ByteBuffer a;

        public c(a aVar, ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, byteBuffer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = byteBuffer;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
                try {
                    if (eVar.f5823d.isOpen() && eVar.f5822c.isOpen()) {
                        this.a.rewind();
                        eVar.f5823d.write(this.a);
                    }
                } catch (IOException e2) {
                    if (a.i) {
                        a.m("connect e:" + e2 + " line: " + eVar);
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.n0.a.p2.g1.c<e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
                Pipe.SinkChannel sinkChannel = eVar.f5823d;
                a.f(sinkChannel, eVar.toString() + " by[PumpingFinish]");
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final c.a.n0.a.p2.g1.c<Pipe.SourceChannel> a;

        /* renamed from: b  reason: collision with root package name */
        public final Pipe f5821b;

        /* renamed from: c  reason: collision with root package name */
        public final Pipe.SourceChannel f5822c;

        /* renamed from: d  reason: collision with root package name */
        public final Pipe.SinkChannel f5823d;

        /* renamed from: e  reason: collision with root package name */
        public CountDownLatch f5824e;

        /* renamed from: f  reason: collision with root package name */
        public String f5825f;

        public e(a aVar, c.a.n0.a.p2.g1.c<Pipe.SourceChannel> cVar) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
            Pipe open = Pipe.open();
            this.f5821b = open;
            this.f5823d = open.sink();
            this.f5822c = this.f5821b.source();
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Pipe.SinkChannel sinkChannel = this.f5823d;
                a.f(sinkChannel, "sink for " + toString());
                Pipe.SourceChannel sourceChannel = this.f5822c;
                a.f(sourceChannel, "source for " + toString());
            }
        }

        public final void e() {
            CountDownLatch countDownLatch;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (countDownLatch = this.f5824e) == null) {
                return;
            }
            countDownLatch.countDown();
        }

        public final void f(CountDownLatch countDownLatch) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, countDownLatch) == null) {
                this.f5824e = countDownLatch;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f5825f = Thread.currentThread().toString();
                if (a.i) {
                    a.m(" >> run on " + toString());
                }
                try {
                    try {
                        this.a.onCallback(this.f5822c);
                    } catch (Exception e2) {
                        if (a.i) {
                            e2.printStackTrace();
                            a.m("catch Exception on " + toString() + " :\n  " + e2.toString());
                        }
                    }
                    if (a.i) {
                        a.m("countdown by end -> " + toString());
                    }
                    e();
                } finally {
                    d();
                }
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return "PipeLine: " + this.f5825f + " consumer=" + this.a.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1544217371, "Lc/a/n0/a/p2/e1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1544217371, "Lc/a/n0/a/p2/e1/a;");
                return;
            }
        }
        i = c.a.n0.a.a.a;
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
        this.a = new HashSet();
        this.f5813c = 8192;
        this.f5814d = -1L;
        this.f5815e = TimeUnit.NANOSECONDS;
        this.f5817g = new c.a();
        this.f5818h = 0.0f;
    }

    public static void f(Channel channel, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, null, channel, str) == null) && channel != null && channel.isOpen()) {
            c.a.n0.w.d.d(channel);
        }
    }

    public static void m(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, str) == null) && i) {
            Log.i("PipeHub", str);
        }
    }

    @NonNull
    public a d(@NonNull c.a.n0.a.p2.g1.c<Pipe.SourceChannel>... cVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVarArr)) == null) {
            this.a.addAll(Arrays.asList(cVarArr));
            return this;
        }
        return (a) invokeL.objValue;
    }

    public final void e(String str) {
        c.a.n0.a.p2.g1.c<String> cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (cVar = this.f5816f) == null) {
            return;
        }
        cVar.onCallback(str);
    }

    public a g(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle)) == null) {
            this.f5817g.update(bundle);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public synchronized void h(ReadableByteChannel readableByteChannel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, readableByteChannel) == null) {
            synchronized (this) {
                e("start");
                long currentTimeMillis = System.currentTimeMillis();
                List<e> i2 = i();
                CountDownLatch countDownLatch = new CountDownLatch(i2.size());
                ExecutorService l = l(i2, countDownLatch);
                n(readableByteChannel, i2);
                e("pump_finish");
                if (i) {
                    m("pumping: cost=" + (System.currentTimeMillis() - currentTimeMillis));
                }
                try {
                    if (i) {
                        m("main await for timeout: " + this.f5815e.toMillis(this.f5814d));
                    }
                    boolean z = false;
                    if (this.f5814d < 0) {
                        countDownLatch.await();
                    } else {
                        z = !countDownLatch.await(this.f5814d, this.f5815e);
                    }
                    if (i) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("main await finish by ");
                        sb.append(z ? "time's up" : "count down");
                        m(sb.toString());
                    }
                    if (i) {
                        m("all done: " + (System.currentTimeMillis() - currentTimeMillis));
                    }
                } catch (InterruptedException e2) {
                    if (i) {
                        m("main await finish by InterruptedException " + e2);
                        e2.printStackTrace();
                    }
                    if (i) {
                        m("all done: " + (System.currentTimeMillis() - currentTimeMillis));
                    }
                }
                r(l);
                e("finish");
            }
        }
    }

    public final List<e> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ArrayList arrayList = new ArrayList();
            c.a.n0.a.p2.g1.b.c(new C0417a(this, arrayList), this.a);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public float j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f5818h : invokeV.floatValue;
    }

    public final float k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            float h2 = this.f5817g.h("progress_granularity", 0.01f);
            if (h2 < 0.0f) {
                h2 = 0.0f;
            }
            if (h2 > 1.0f) {
                return 1.0f;
            }
            return h2;
        }
        return invokeV.floatValue;
    }

    @NonNull
    public final ExecutorService l(@NonNull List<e> list, @NonNull CountDownLatch countDownLatch) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, list, countDownLatch)) == null) {
            ExecutorService executorService = this.f5812b;
            if (executorService == null || executorService.isShutdown() || this.f5812b.isTerminated()) {
                this.f5812b = null;
            }
            ExecutorService executorService2 = this.f5812b;
            if (executorService2 == null) {
                executorService2 = Executors.newCachedThreadPool();
            }
            c.a.n0.a.p2.g1.b.c(new b(this, countDownLatch, executorService2), list);
            return executorService2;
        }
        return (ExecutorService) invokeLL.objValue;
    }

    public final void n(@NonNull ReadableByteChannel readableByteChannel, @NonNull List<e> list) {
        d dVar;
        long j;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, readableByteChannel, list) == null) {
            ReadableByteChannel readableByteChannel2 = readableByteChannel;
            List<e> list2 = list;
            float f2 = 0.0f;
            s(0.0f);
            float k = k();
            long k2 = this.f5817g.k("length");
            ByteBuffer allocate = ByteBuffer.allocate(this.f5813c);
            long j2 = 0;
            int i3 = 0;
            while (true) {
                try {
                    try {
                        long read = readableByteChannel2.read(allocate);
                        if (read == -1) {
                            break;
                        }
                        j2 += read;
                        try {
                            allocate.flip();
                            c.a.n0.a.p2.g1.b.c(new c(this, allocate), list2);
                            int i4 = i3 + 1;
                            if (k2 > 0) {
                                float f3 = ((float) j2) / ((float) k2);
                                if (f3 < f2) {
                                    f3 = 0.0f;
                                }
                                if (f3 > 1.0f) {
                                    f3 = 1.0f;
                                }
                                float f4 = f3 - this.f5818h;
                                int round = Math.round(100.0f * f3);
                                i2 = i4;
                                StringBuilder sb = new StringBuilder();
                                int i5 = 0;
                                while (i5 < 100) {
                                    sb.append(i5 > round ? "=" : "#");
                                    i5++;
                                }
                                if (i) {
                                    j = k2;
                                    m(String.format("pumping: %4s [%s] read/at:[%7d/%-7d]", NumberFormat.getPercentInstance().format(f3), sb, Long.valueOf(read), Long.valueOf(j2)));
                                } else {
                                    j = k2;
                                }
                                if (f4 > k) {
                                    if (i) {
                                        NumberFormat percentInstance = NumberFormat.getPercentInstance();
                                        m("pumping: updateProgress granularity:" + percentInstance.format(k) + " step:" + percentInstance.format(f4));
                                    }
                                    s(f3);
                                }
                            } else {
                                j = k2;
                                i2 = i4;
                            }
                            allocate.clear();
                            readableByteChannel2 = readableByteChannel;
                            list2 = list;
                            i3 = i2;
                            k2 = j;
                            f2 = 0.0f;
                        } catch (IOException e2) {
                            e = e2;
                            readableByteChannel2 = readableByteChannel;
                            list2 = list;
                            if (i) {
                                e.printStackTrace();
                            }
                            f(readableByteChannel2, "connected source");
                            dVar = new d(this);
                            c.a.n0.a.p2.g1.b.c(dVar, list2);
                            s(1.0f);
                        } catch (Throwable th) {
                            th = th;
                            readableByteChannel2 = readableByteChannel;
                            list2 = list;
                            f(readableByteChannel2, "connected source");
                            c.a.n0.a.p2.g1.b.c(new d(this), list2);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (IOException e3) {
                    e = e3;
                }
            }
            long j3 = k2;
            if (i) {
                m("pumping done: writeCount=" + i3 + " length: " + j3);
            }
            f(readableByteChannel, "connected source");
            dVar = new d(this);
            list2 = list;
            c.a.n0.a.p2.g1.b.c(dVar, list2);
            s(1.0f);
        }
    }

    @NonNull
    public a o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            if (i2 < 1) {
                i2 = 8192;
            }
            this.f5813c = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a p(c.a.n0.a.p2.g1.c<String> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, cVar)) == null) {
            this.f5816f = cVar;
            return this;
        }
        return (a) invokeL.objValue;
    }

    @NonNull
    public a q(long j, @NonNull TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048587, this, j, timeUnit)) == null) {
            if (j < 0) {
                j = -1;
            }
            this.f5814d = j;
            this.f5815e = timeUnit;
            return this;
        }
        return (a) invokeJL.objValue;
    }

    public final void r(@NonNull ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, executorService) == null) {
            if (executorService != this.f5812b && !executorService.isShutdown()) {
                executorService.shutdown();
            }
            this.f5812b = null;
        }
    }

    public final void s(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048589, this, f2) == null) {
            if (i) {
                m("updateProgress: progress=" + f2);
            }
            this.f5818h = f2;
            e("on_progress");
        }
    }
}
