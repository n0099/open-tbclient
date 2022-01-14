package c.a.r0.a.z2.e1;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.f1.e.f.c;
import c.a.r0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.face.platform.common.ConstantHelper;
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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f9960i;
    public transient /* synthetic */ FieldHolder $fh;
    public final Set<c.a.r0.a.z2.g1.c<Pipe.SourceChannel>> a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f9961b;

    /* renamed from: c  reason: collision with root package name */
    public int f9962c;

    /* renamed from: d  reason: collision with root package name */
    public long f9963d;

    /* renamed from: e  reason: collision with root package name */
    public TimeUnit f9964e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.a.z2.g1.c<String> f9965f;

    /* renamed from: g  reason: collision with root package name */
    public final c.a f9966g;

    /* renamed from: h  reason: collision with root package name */
    public float f9967h;

    /* renamed from: c.a.r0.a.z2.e1.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0652a implements c.a.r0.a.z2.g1.c<c.a.r0.a.z2.g1.c<Pipe.SourceChannel>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f9968e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f9969f;

        public C0652a(a aVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9969f = aVar;
            this.f9968e = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.r0.a.z2.g1.c<Pipe.SourceChannel> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                try {
                    this.f9968e.add(new e(this.f9969f, cVar));
                } catch (IOException e2) {
                    if (a.f9960i) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements c.a.r0.a.z2.g1.c<e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f9970e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ExecutorService f9971f;

        public b(a aVar, CountDownLatch countDownLatch, ExecutorService executorService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, countDownLatch, executorService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9970e = countDownLatch;
            this.f9971f = executorService;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
                eVar.f(this.f9970e);
                this.f9971f.submit(eVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements c.a.r0.a.z2.g1.c<e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ByteBuffer f9972e;

        public c(a aVar, ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, byteBuffer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9972e = byteBuffer;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
                try {
                    if (eVar.f9976h.isOpen() && eVar.f9975g.isOpen()) {
                        this.f9972e.rewind();
                        eVar.f9976h.write(this.f9972e);
                    }
                } catch (IOException e2) {
                    if (a.f9960i) {
                        a.m("connect e:" + e2 + " line: " + eVar);
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements c.a.r0.a.z2.g1.c<e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(a aVar) {
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
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
                Pipe.SinkChannel sinkChannel = eVar.f9976h;
                a.f(sinkChannel, eVar.toString() + " by[PumpingFinish]");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final c.a.r0.a.z2.g1.c<Pipe.SourceChannel> f9973e;

        /* renamed from: f  reason: collision with root package name */
        public final Pipe f9974f;

        /* renamed from: g  reason: collision with root package name */
        public final Pipe.SourceChannel f9975g;

        /* renamed from: h  reason: collision with root package name */
        public final Pipe.SinkChannel f9976h;

        /* renamed from: i  reason: collision with root package name */
        public CountDownLatch f9977i;

        /* renamed from: j  reason: collision with root package name */
        public String f9978j;

        public e(a aVar, c.a.r0.a.z2.g1.c<Pipe.SourceChannel> cVar) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9973e = cVar;
            Pipe open = Pipe.open();
            this.f9974f = open;
            this.f9976h = open.sink();
            this.f9975g = this.f9974f.source();
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Pipe.SinkChannel sinkChannel = this.f9976h;
                a.f(sinkChannel, "sink for " + toString());
                Pipe.SourceChannel sourceChannel = this.f9975g;
                a.f(sourceChannel, "source for " + toString());
            }
        }

        public final void e() {
            CountDownLatch countDownLatch;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (countDownLatch = this.f9977i) == null) {
                return;
            }
            countDownLatch.countDown();
        }

        public final void f(CountDownLatch countDownLatch) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, countDownLatch) == null) {
                this.f9977i = countDownLatch;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f9978j = Thread.currentThread().toString();
                if (a.f9960i) {
                    a.m(" >> run on " + toString());
                }
                try {
                    try {
                        this.f9973e.onCallback(this.f9975g);
                    } catch (Exception e2) {
                        if (a.f9960i) {
                            e2.printStackTrace();
                            a.m("catch Exception on " + toString() + " :\n  " + e2.toString());
                        }
                    }
                    if (a.f9960i) {
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
                return "PipeLine: " + this.f9978j + " consumer=" + this.f9973e.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1825372063, "Lc/a/r0/a/z2/e1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1825372063, "Lc/a/r0/a/z2/e1/a;");
                return;
            }
        }
        f9960i = k.a;
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
        this.f9962c = 8192;
        this.f9963d = -1L;
        this.f9964e = TimeUnit.NANOSECONDS;
        this.f9966g = new c.a();
        this.f9967h = 0.0f;
    }

    public static void f(Channel channel, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, null, channel, str) == null) && channel != null && channel.isOpen()) {
            c.a.r0.w.d.d(channel);
        }
    }

    public static void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, str) == null) {
            boolean z = f9960i;
        }
    }

    @NonNull
    public a d(@NonNull c.a.r0.a.z2.g1.c<Pipe.SourceChannel>... cVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVarArr)) == null) {
            this.a.addAll(Arrays.asList(cVarArr));
            return this;
        }
        return (a) invokeL.objValue;
    }

    public final void e(String str) {
        c.a.r0.a.z2.g1.c<String> cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (cVar = this.f9965f) == null) {
            return;
        }
        cVar.onCallback(str);
    }

    public a g(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle)) == null) {
            this.f9966g.update(bundle);
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
                if (f9960i) {
                    m("pumping: cost=" + (System.currentTimeMillis() - currentTimeMillis));
                }
                try {
                    if (f9960i) {
                        m("main await for timeout: " + this.f9964e.toMillis(this.f9963d));
                    }
                    boolean z = false;
                    if (this.f9963d < 0) {
                        countDownLatch.await();
                    } else {
                        z = !countDownLatch.await(this.f9963d, this.f9964e);
                    }
                    if (f9960i) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("main await finish by ");
                        sb.append(z ? "time's up" : "count down");
                        m(sb.toString());
                    }
                    if (f9960i) {
                        m("all done: " + (System.currentTimeMillis() - currentTimeMillis));
                    }
                } catch (InterruptedException e2) {
                    if (f9960i) {
                        m("main await finish by InterruptedException " + e2);
                        e2.printStackTrace();
                    }
                    if (f9960i) {
                        m("all done: " + (System.currentTimeMillis() - currentTimeMillis));
                    }
                }
                r(l);
                e(ConstantHelper.LOG_FINISH);
            }
        }
    }

    public final List<e> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ArrayList arrayList = new ArrayList();
            c.a.r0.a.z2.g1.b.c(new C0652a(this, arrayList), this.a);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public float j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f9967h : invokeV.floatValue;
    }

    public final float k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            float h2 = this.f9966g.h("progress_granularity", 0.01f);
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
            ExecutorService executorService = this.f9961b;
            if (executorService == null || executorService.isShutdown() || this.f9961b.isTerminated()) {
                this.f9961b = null;
            }
            ExecutorService executorService2 = this.f9961b;
            if (executorService2 == null) {
                executorService2 = Executors.newCachedThreadPool();
            }
            c.a.r0.a.z2.g1.b.c(new b(this, countDownLatch, executorService2), list);
            return executorService2;
        }
        return (ExecutorService) invokeLL.objValue;
    }

    public final void n(@NonNull ReadableByteChannel readableByteChannel, @NonNull List<e> list) {
        d dVar;
        long j2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, readableByteChannel, list) == null) {
            ReadableByteChannel readableByteChannel2 = readableByteChannel;
            List<e> list2 = list;
            float f2 = 0.0f;
            s(0.0f);
            float k = k();
            long k2 = this.f9966g.k("length");
            ByteBuffer allocate = ByteBuffer.allocate(this.f9962c);
            long j3 = 0;
            int i3 = 0;
            while (true) {
                try {
                    try {
                        long read = readableByteChannel2.read(allocate);
                        if (read == -1) {
                            break;
                        }
                        j3 += read;
                        try {
                            allocate.flip();
                            c.a.r0.a.z2.g1.b.c(new c(this, allocate), list2);
                            int i4 = i3 + 1;
                            if (k2 > 0) {
                                float f3 = ((float) j3) / ((float) k2);
                                if (f3 < f2) {
                                    f3 = 0.0f;
                                }
                                if (f3 > 1.0f) {
                                    f3 = 1.0f;
                                }
                                float f4 = f3 - this.f9967h;
                                int round = Math.round(100.0f * f3);
                                i2 = i4;
                                StringBuilder sb = new StringBuilder();
                                int i5 = 0;
                                while (i5 < 100) {
                                    sb.append(i5 > round ? "=" : "#");
                                    i5++;
                                }
                                if (f9960i) {
                                    j2 = k2;
                                    m(String.format("pumping: %4s [%s] read/at:[%7d/%-7d]", NumberFormat.getPercentInstance().format(f3), sb, Long.valueOf(read), Long.valueOf(j3)));
                                } else {
                                    j2 = k2;
                                }
                                if (f4 > k) {
                                    if (f9960i) {
                                        NumberFormat percentInstance = NumberFormat.getPercentInstance();
                                        m("pumping: updateProgress granularity:" + percentInstance.format(k) + " step:" + percentInstance.format(f4));
                                    }
                                    s(f3);
                                }
                            } else {
                                j2 = k2;
                                i2 = i4;
                            }
                            allocate.clear();
                            readableByteChannel2 = readableByteChannel;
                            list2 = list;
                            i3 = i2;
                            k2 = j2;
                            f2 = 0.0f;
                        } catch (IOException e2) {
                            e = e2;
                            readableByteChannel2 = readableByteChannel;
                            list2 = list;
                            if (f9960i) {
                                e.printStackTrace();
                            }
                            f(readableByteChannel2, "connected source");
                            dVar = new d(this);
                            c.a.r0.a.z2.g1.b.c(dVar, list2);
                            s(1.0f);
                        } catch (Throwable th) {
                            th = th;
                            readableByteChannel2 = readableByteChannel;
                            list2 = list;
                            f(readableByteChannel2, "connected source");
                            c.a.r0.a.z2.g1.b.c(new d(this), list2);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (IOException e3) {
                    e = e3;
                }
            }
            long j4 = k2;
            if (f9960i) {
                m("pumping done: writeCount=" + i3 + " length: " + j4);
            }
            f(readableByteChannel, "connected source");
            dVar = new d(this);
            list2 = list;
            c.a.r0.a.z2.g1.b.c(dVar, list2);
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
            this.f9962c = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a p(c.a.r0.a.z2.g1.c<String> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, cVar)) == null) {
            this.f9965f = cVar;
            return this;
        }
        return (a) invokeL.objValue;
    }

    @NonNull
    public a q(long j2, @NonNull TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048587, this, j2, timeUnit)) == null) {
            if (j2 < 0) {
                j2 = -1;
            }
            this.f9963d = j2;
            this.f9964e = timeUnit;
            return this;
        }
        return (a) invokeJL.objValue;
    }

    public final void r(@NonNull ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, executorService) == null) {
            if (executorService != this.f9961b && !executorService.isShutdown()) {
                executorService.shutdown();
            }
            this.f9961b = null;
        }
    }

    public final void s(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048589, this, f2) == null) {
            if (f9960i) {
                m("updateProgress: progress=" + f2);
            }
            this.f9967h = f2;
            e("on_progress");
        }
    }
}
