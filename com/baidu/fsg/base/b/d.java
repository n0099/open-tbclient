package com.baidu.fsg.base.b;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.ApollonConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Timer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long a = 1000;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f34646b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f34647c;

    /* renamed from: d  reason: collision with root package name */
    public static final long f34648d = Long.MAX_VALUE;

    /* renamed from: e  reason: collision with root package name */
    public static final int f34649e = 5;

    /* renamed from: f  reason: collision with root package name */
    public static final int f34650f = 128;

    /* renamed from: g  reason: collision with root package name */
    public static final int f34651g = 1;

    /* renamed from: h  reason: collision with root package name */
    public static HashMap<String, d> f34652h;

    /* renamed from: i  reason: collision with root package name */
    public static d f34653i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: j  reason: collision with root package name */
    public final HashMap<String, ArrayList<c>> f34654j;

    /* renamed from: k  reason: collision with root package name */
    public final HashMap<Future<?>, Runnable> f34655k;
    public final ThreadFactory l;
    public long m;
    public Timer n;
    public BlockingQueue<Runnable> o;
    public a p;
    public b q;

    /* loaded from: classes10.dex */
    public class a extends ThreadPoolExecutor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, int i2, int i3, long j2, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
            super(i2, i3, j2, timeUnit, blockingQueue, threadFactory);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), timeUnit, blockingQueue, threadFactory};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Long) objArr2[2]).longValue(), (TimeUnit) objArr2[3], (BlockingQueue) objArr2[4], (ThreadFactory) objArr2[5]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        public void afterExecute(Runnable runnable, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, runnable, th) == null) {
                this.a.f34655k.remove((Future) runnable);
                super.afterExecute(runnable, th);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements Executor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final LinkedList<Runnable> a;

        /* renamed from: b  reason: collision with root package name */
        public Runnable f34656b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f34657c;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34657c = dVar;
            this.a = new LinkedList<>();
        }

        public /* synthetic */ b(d dVar, com.baidu.fsg.base.b.a aVar) {
            this(dVar);
        }

        public synchronized void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    Runnable poll = this.a.poll();
                    this.f34656b = poll;
                    if (poll != null) {
                        this.f34657c.p.execute(this.f34656b);
                    }
                }
            }
        }

        public synchronized void a(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) {
                synchronized (this) {
                    this.a.remove(runnable);
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) {
                synchronized (this) {
                    this.a.offer(new e(this, runnable));
                    if (this.f34656b == null) {
                        a();
                    }
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public Runnable f34658b;

        /* renamed from: c  reason: collision with root package name */
        public long f34659c;

        /* renamed from: d  reason: collision with root package name */
        public long f34660d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f34661e;

        /* renamed from: f  reason: collision with root package name */
        public long f34662f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f34663g;

        public c(d dVar, long j2, long j3, boolean z, String str, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z), str, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34663g = dVar;
            this.f34660d = j2;
            this.f34662f = System.currentTimeMillis() + j2;
            this.f34659c = j3;
            this.f34661e = z;
            this.f34658b = runnable;
            this.a = str;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2066588351, "Lcom/baidu/fsg/base/b/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2066588351, "Lcom/baidu/fsg/base/b/d;");
                return;
            }
        }
        f34646b = ApollonConstants.DEBUG;
        f34647c = d.class.getSimpleName();
        f34652h = new HashMap<>();
        f34653i = null;
    }

    public d() {
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
        this.f34655k = new HashMap<>();
        this.l = new com.baidu.fsg.base.b.a(this);
        this.m = Long.MAX_VALUE;
        this.n = new Timer();
        this.o = new LinkedBlockingQueue(10);
        this.p = new a(this, 5, 128, 1L, TimeUnit.SECONDS, this.o, this.l);
        this.q = new b(this, null);
        this.f34654j = new HashMap<>();
    }

    private c a(String str, ArrayList<c> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, arrayList)) == null) {
            Iterator<c> it = arrayList.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (TextUtils.equals(str, next.a)) {
                    return next;
                }
            }
            return null;
        }
        return (c) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            boolean z = f34646b;
            synchronized (this.f34654j) {
                long currentTimeMillis = System.currentTimeMillis();
                this.m = Long.MAX_VALUE;
                for (String str : this.f34654j.keySet()) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<c> it = c(str).iterator();
                    while (it.hasNext()) {
                        c next = it.next();
                        if (next.f34662f - currentTimeMillis < 1000) {
                            if (f34646b) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("task.mNextRunTime - current = ");
                                sb.append(next.f34662f - currentTimeMillis);
                                sb.toString();
                            }
                            c(next);
                            if (next.f34659c > 0) {
                                next.f34662f = next.f34659c + currentTimeMillis;
                                arrayList.add(next);
                            }
                        }
                        if (next.f34662f < this.m) {
                            this.m = next.f34662f;
                        }
                    }
                    if (this.m < Long.MAX_VALUE) {
                        a(this.m - currentTimeMillis);
                    }
                }
            }
        }
    }

    private void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, this, j2) == null) {
            if (f34646b) {
                String str = "intervalMillis: " + j2;
            }
            Timer timer = this.n;
            if (timer != null) {
                timer.cancel();
                this.n = null;
            }
            this.n = new Timer();
            this.n.schedule(new com.baidu.fsg.base.b.b(this), j2);
        }
    }

    private void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, cVar) == null) {
            if (cVar.f34661e) {
                this.q.a(cVar.f34658b);
                return;
            }
            for (Future<?> future : this.f34655k.keySet()) {
                if (this.f34655k.get(future) == cVar.f34658b && future != null && (!future.isCancelled() || !future.isDone())) {
                    future.cancel(true);
                }
            }
        }
    }

    private void a(c cVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65542, this, cVar, j2) == null) {
            this.p.execute(new com.baidu.fsg.base.b.c(this, j2, cVar));
        }
    }

    private boolean a(c cVar, ArrayList<c> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, cVar, arrayList)) == null) {
            Iterator<c> it = arrayList.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().a, cVar.a)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static synchronized d b(String str) {
        InterceptResult invokeL;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            synchronized (d.class) {
                if (f34652h.get(str) == null) {
                    d dVar2 = new d();
                    f34653i = dVar2;
                    f34652h.put(str, dVar2);
                }
                dVar = f34653i;
            }
            return dVar;
        }
        return (d) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, cVar) == null) {
            if (cVar.f34659c > 0) {
                cVar.f34660d = 0L;
            }
            if (cVar.f34661e) {
                this.q.execute(cVar.f34658b);
                return;
            }
            this.f34655k.put(this.p.submit(cVar.f34658b), cVar.f34658b);
            if (f34646b) {
                String str = "execute task, " + cVar.a + " execute time is " + System.currentTimeMillis();
            }
        }
    }

    private boolean b(c cVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, this, cVar, str)) == null) {
            if (cVar == null || cVar.f34658b == null) {
                return false;
            }
            synchronized (this.f34654j) {
                ArrayList<c> c2 = c(str);
                c a2 = a(cVar.a, c2);
                if (a2 != null) {
                    a(a2);
                    c2.remove(a2);
                    a(cVar, str);
                    return true;
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    private ArrayList<c> c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, str)) == null) {
            ArrayList<c> arrayList = this.f34654j.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            this.f34654j.put(str, arrayList);
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    private void c(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, cVar) == null) {
            if (cVar.f34660d > 0) {
                a(cVar, cVar.f34662f - System.currentTimeMillis());
            } else {
                b(cVar);
            }
        }
    }

    private void d(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, cVar) == null) {
            long j2 = cVar.f34662f;
            if (j2 < this.m) {
                a(Math.max(j2 - System.currentTimeMillis(), 1000L));
            }
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            synchronized (this.f34654j) {
                ArrayList<c> c2 = c(str);
                Iterator<c> it = c2.iterator();
                while (it.hasNext()) {
                    a(it.next());
                }
                c2.clear();
                this.f34654j.remove(str);
            }
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            synchronized (this.f34654j) {
                ArrayList<c> c2 = c(str);
                Iterator<c> it = c2.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.a.equals(str2)) {
                        a(next);
                        c2.remove(next.a);
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0029, code lost:
        if (r9.f34660d > 0) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(c cVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cVar, str)) == null) {
            if (cVar == null || cVar.f34658b == null) {
                return false;
            }
            synchronized (this.f34654j) {
                ArrayList<c> c2 = c(str);
                if (a(cVar, c2)) {
                    b(cVar, str);
                } else {
                    if (cVar.f34662f > System.currentTimeMillis()) {
                    }
                    c(cVar);
                    if (cVar.f34659c > 0) {
                        cVar.f34662f = System.currentTimeMillis() + cVar.f34660d + cVar.f34659c;
                        c2.add(cVar);
                        d(cVar);
                    }
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
