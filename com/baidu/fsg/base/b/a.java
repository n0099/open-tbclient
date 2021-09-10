package com.baidu.fsg.base.b;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.ApollonConstants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final long f39343a = 1000;

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, a> f39344b = null;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f39345c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f39346d;

    /* renamed from: e  reason: collision with root package name */
    public static final long f39347e = Long.MAX_VALUE;

    /* renamed from: f  reason: collision with root package name */
    public static final int f39348f = 5;

    /* renamed from: g  reason: collision with root package name */
    public static final int f39349g = 128;

    /* renamed from: h  reason: collision with root package name */
    public static final int f39350h = 1;

    /* renamed from: i  reason: collision with root package name */
    public static a f39351i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: j  reason: collision with root package name */
    public final HashMap<String, ArrayList<c>> f39352j;
    public final HashMap<Future<?>, Runnable> k;
    public final ThreadFactory l;
    public long m;
    public Timer n;
    public BlockingQueue<Runnable> o;
    public C1648a p;
    public b q;

    /* renamed from: com.baidu.fsg.base.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1648a extends ThreadPoolExecutor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f39359a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1648a(a aVar, int i2, int i3, long j2, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
            super(i2, i3, j2, timeUnit, blockingQueue, threadFactory);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), timeUnit, blockingQueue, threadFactory};
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
            this.f39359a = aVar;
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        public void afterExecute(Runnable runnable, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, runnable, th) == null) {
                this.f39359a.k.remove((Future) runnable);
                super.afterExecute(runnable, th);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Executor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final LinkedList<Runnable> f39360a;

        /* renamed from: b  reason: collision with root package name */
        public Runnable f39361b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f39362c;

        public b(a aVar) {
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
            this.f39362c = aVar;
            this.f39360a = new LinkedList<>();
        }

        public synchronized void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    Runnable poll = this.f39360a.poll();
                    this.f39361b = poll;
                    if (poll != null) {
                        this.f39362c.p.execute(this.f39361b);
                    }
                }
            }
        }

        public synchronized void a(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) {
                synchronized (this) {
                    this.f39360a.remove(runnable);
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) {
                synchronized (this) {
                    this.f39360a.offer(new Runnable(this, runnable) { // from class: com.baidu.fsg.base.b.a.b.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ Runnable f39363a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ b f39364b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, runnable};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f39364b = this;
                            this.f39363a = runnable;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                try {
                                    this.f39363a.run();
                                } finally {
                                    this.f39364b.a();
                                }
                            }
                        }
                    });
                    if (this.f39361b == null) {
                        a();
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f39365a;

        /* renamed from: b  reason: collision with root package name */
        public Runnable f39366b;

        /* renamed from: c  reason: collision with root package name */
        public long f39367c;

        /* renamed from: d  reason: collision with root package name */
        public long f39368d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f39369e;

        /* renamed from: f  reason: collision with root package name */
        public long f39370f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f39371g;

        public c(a aVar, long j2, long j3, boolean z, String str, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z), str, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39371g = aVar;
            this.f39368d = j2;
            this.f39370f = System.currentTimeMillis() + j2;
            this.f39367c = j3;
            this.f39369e = z;
            this.f39366b = runnable;
            this.f39365a = str;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2066588258, "Lcom/baidu/fsg/base/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2066588258, "Lcom/baidu/fsg/base/b/a;");
                return;
            }
        }
        f39345c = ApollonConstants.DEBUG;
        f39346d = a.class.getSimpleName();
        f39344b = new HashMap<>();
        f39351i = null;
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
        this.k = new HashMap<>();
        this.l = new ThreadFactory(this) { // from class: com.baidu.fsg.base.b.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f39353a;

            /* renamed from: b  reason: collision with root package name */
            public final AtomicInteger f39354b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f39353a = this;
                this.f39354b = new AtomicInteger(1);
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, runnable)) == null) {
                    return new Thread(runnable, "WalletTask #" + this.f39354b.getAndIncrement());
                }
                return (Thread) invokeL.objValue;
            }
        };
        this.m = Long.MAX_VALUE;
        this.n = new Timer();
        this.o = new LinkedBlockingQueue(10);
        this.p = new C1648a(this, 5, 128, 1L, TimeUnit.SECONDS, this.o, this.l);
        this.q = new b();
        this.f39352j = new HashMap<>();
    }

    private c a(String str, ArrayList<c> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, arrayList)) == null) {
            Iterator<c> it = arrayList.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (TextUtils.equals(str, next.f39365a)) {
                    return next;
                }
            }
            return null;
        }
        return (c) invokeLL.objValue;
    }

    public static synchronized a a(String str) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            synchronized (a.class) {
                if (f39344b.get(str) == null) {
                    a aVar2 = new a();
                    f39351i = aVar2;
                    f39344b.put(str, aVar2);
                }
                aVar = f39351i;
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            boolean z = f39345c;
            synchronized (this.f39352j) {
                long currentTimeMillis = System.currentTimeMillis();
                this.m = Long.MAX_VALUE;
                for (String str : this.f39352j.keySet()) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<c> it = c(str).iterator();
                    while (it.hasNext()) {
                        c next = it.next();
                        if (next.f39370f - currentTimeMillis < 1000) {
                            if (f39345c) {
                                String str2 = "task.mNextRunTime - current = " + (next.f39370f - currentTimeMillis);
                            }
                            c(next);
                            if (next.f39367c > 0) {
                                next.f39370f = next.f39367c + currentTimeMillis;
                                arrayList.add(next);
                            }
                        }
                        if (next.f39370f < this.m) {
                            this.m = next.f39370f;
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
        if (interceptable == null || interceptable.invokeJ(AdIconUtil.AD_TEXT_ID, this, j2) == null) {
            if (f39345c) {
                String str = "intervalMillis: " + j2;
            }
            Timer timer = this.n;
            if (timer != null) {
                timer.cancel();
                this.n = null;
            }
            this.n = new Timer();
            this.n.schedule(new TimerTask(this) { // from class: com.baidu.fsg.base.b.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f39355a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39355a = this;
                }

                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f39355a.a();
                    }
                }
            }, j2);
        }
    }

    private void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, cVar) == null) {
            long j2 = cVar.f39370f;
            if (j2 < this.m) {
                a(Math.max(j2 - System.currentTimeMillis(), 1000L));
            }
        }
    }

    private void a(c cVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65543, this, cVar, j2) == null) {
            this.p.execute(new Runnable(this, j2, cVar) { // from class: com.baidu.fsg.base.b.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ long f39356a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ c f39357b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ a f39358c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j2), cVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39358c = this;
                    this.f39356a = j2;
                    this.f39357b = cVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            Thread.sleep(this.f39356a);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                        this.f39358c.d(this.f39357b);
                    }
                }
            });
        }
    }

    private boolean a(c cVar, ArrayList<c> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, this, cVar, arrayList)) == null) {
            Iterator<c> it = arrayList.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().f39365a, cVar.f39365a)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private void b(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, cVar) == null) {
            if (cVar.f39369e) {
                this.q.a(cVar.f39366b);
                return;
            }
            for (Future<?> future : this.k.keySet()) {
                if (this.k.get(future) == cVar.f39366b && future != null && (!future.isCancelled() || !future.isDone())) {
                    future.cancel(true);
                }
            }
        }
    }

    private boolean b(c cVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, this, cVar, str)) == null) {
            if (cVar == null || cVar.f39366b == null) {
                return false;
            }
            synchronized (this.f39352j) {
                ArrayList<c> c2 = c(str);
                c a2 = a(cVar.f39365a, c2);
                if (a2 != null) {
                    b(a2);
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
            ArrayList<c> arrayList = this.f39352j.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            this.f39352j.put(str, arrayList);
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    private void c(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, cVar) == null) {
            if (cVar.f39368d > 0) {
                a(cVar, cVar.f39370f - System.currentTimeMillis());
            } else {
                d(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, cVar) == null) {
            if (cVar.f39367c > 0) {
                cVar.f39368d = 0L;
            }
            if (cVar.f39369e) {
                this.q.execute(cVar.f39366b);
                return;
            }
            this.k.put(this.p.submit(cVar.f39366b), cVar.f39366b);
            if (f39345c) {
                String str = "execute task, " + cVar.f39365a + " execute time is " + System.currentTimeMillis();
            }
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            synchronized (this.f39352j) {
                ArrayList<c> c2 = c(str);
                Iterator<c> it = c2.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.f39365a.equals(str2)) {
                        b(next);
                        c2.remove(next.f39365a);
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0035 A[Catch: all -> 0x004e, TryCatch #0 {, blocks: (B:10:0x000e, B:12:0x0018, B:14:0x0024, B:18:0x002f, B:20:0x0035, B:23:0x004c, B:15:0x0028, B:21:0x0048), top: B:34:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(c cVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, str)) == null) {
            if (cVar == null || cVar.f39366b == null) {
                return false;
            }
            synchronized (this.f39352j) {
                ArrayList<c> c2 = c(str);
                if (a(cVar, c2)) {
                    b(cVar, str);
                } else {
                    if (cVar.f39370f > System.currentTimeMillis()) {
                        if (cVar.f39368d > 0) {
                        }
                        if (cVar.f39367c > 0) {
                            cVar.f39370f = System.currentTimeMillis() + cVar.f39368d + cVar.f39367c;
                            c2.add(cVar);
                            a(cVar);
                        }
                    }
                    c(cVar);
                    if (cVar.f39367c > 0) {
                    }
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            synchronized (this.f39352j) {
                ArrayList<c> c2 = c(str);
                Iterator<c> it = c2.iterator();
                while (it.hasNext()) {
                    b(it.next());
                }
                c2.clear();
                this.f39352j.remove(str);
            }
        }
    }
}
