package com.baidu.fsg.base.b;

import android.text.TextUtils;
import android.util.Log;
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
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final long f5144a = 1000;

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, a> f5145b = null;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f5146c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f5147d;

    /* renamed from: e  reason: collision with root package name */
    public static final long f5148e = Long.MAX_VALUE;

    /* renamed from: f  reason: collision with root package name */
    public static final int f5149f = 5;

    /* renamed from: g  reason: collision with root package name */
    public static final int f5150g = 128;

    /* renamed from: h  reason: collision with root package name */
    public static final int f5151h = 1;

    /* renamed from: i  reason: collision with root package name */
    public static a f5152i;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, ArrayList<c>> j;
    public final HashMap<Future<?>, Runnable> k;
    public final ThreadFactory l;
    public long m;
    public Timer n;
    public BlockingQueue<Runnable> o;
    public C0097a p;
    public b q;

    /* renamed from: com.baidu.fsg.base.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0097a extends ThreadPoolExecutor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f5153a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0097a(a aVar, int i2, int i3, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
            super(i2, i3, j, timeUnit, blockingQueue, threadFactory);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), timeUnit, blockingQueue, threadFactory};
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
            this.f5153a = aVar;
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        public void afterExecute(Runnable runnable, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, runnable, th) == null) {
                this.f5153a.k.remove((Future) runnable);
                super.afterExecute(runnable, th);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f5157a;

        /* renamed from: b  reason: collision with root package name */
        public Runnable f5158b;

        /* renamed from: c  reason: collision with root package name */
        public long f5159c;

        /* renamed from: d  reason: collision with root package name */
        public long f5160d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f5161e;

        /* renamed from: f  reason: collision with root package name */
        public long f5162f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f5163g;

        public c(a aVar, long j, long j2, boolean z, String str, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z), str, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5163g = aVar;
            this.f5160d = j;
            this.f5162f = System.currentTimeMillis() + j;
            this.f5159c = j2;
            this.f5161e = z;
            this.f5158b = runnable;
            this.f5157a = str;
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
        f5146c = ApollonConstants.DEBUG;
        f5147d = a.class.getSimpleName();
        f5145b = new HashMap<>();
        f5152i = null;
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
        this.l = new com.baidu.fsg.base.b.b(this);
        this.m = Long.MAX_VALUE;
        this.n = new Timer();
        this.o = new LinkedBlockingQueue(10);
        this.p = new C0097a(this, 5, 128, 1L, TimeUnit.SECONDS, this.o, this.l);
        this.q = new b(this, null);
        this.j = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, cVar) == null) {
            if (cVar.f5159c > 0) {
                cVar.f5160d = 0L;
            }
            if (cVar.f5161e) {
                this.q.execute(cVar.f5158b);
                return;
            }
            this.k.put(this.p.submit(cVar.f5158b), cVar.f5158b);
            if (f5146c) {
                String str = f5147d;
                Log.d(str, "execute task, " + cVar.f5157a + " execute time is " + System.currentTimeMillis());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Executor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final LinkedList<Runnable> f5154a;

        /* renamed from: b  reason: collision with root package name */
        public Runnable f5155b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f5156c;

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
            this.f5156c = aVar;
            this.f5154a = new LinkedList<>();
        }

        public synchronized void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    Runnable poll = this.f5154a.poll();
                    this.f5155b = poll;
                    if (poll != null) {
                        this.f5156c.p.execute(this.f5155b);
                    }
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) {
                synchronized (this) {
                    this.f5154a.offer(new e(this, runnable));
                    if (this.f5155b == null) {
                        a();
                    }
                }
            }
        }

        public /* synthetic */ b(a aVar, com.baidu.fsg.base.b.b bVar) {
            this(aVar);
        }

        public synchronized void a(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) {
                synchronized (this) {
                    this.f5154a.remove(runnable);
                }
            }
        }
    }

    private ArrayList<c> c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, str)) == null) {
            ArrayList<c> arrayList = this.j.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            this.j.put(str, arrayList);
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            synchronized (this.j) {
                ArrayList<c> c2 = c(str);
                Iterator<c> it = c2.iterator();
                while (it.hasNext()) {
                    b(it.next());
                }
                c2.clear();
                this.j.remove(str);
            }
        }
    }

    public static synchronized a a(String str) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            synchronized (a.class) {
                if (f5145b.get(str) == null) {
                    a aVar2 = new a();
                    f5152i = aVar2;
                    f5145b.put(str, aVar2);
                }
                aVar = f5152i;
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    private void c(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, cVar) == null) {
            if (cVar.f5160d > 0) {
                a(cVar, cVar.f5162f - System.currentTimeMillis());
            } else {
                d(cVar);
            }
        }
    }

    public boolean a(c cVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, str)) == null) {
            if (cVar == null || cVar.f5158b == null) {
                return false;
            }
            synchronized (this.j) {
                ArrayList<c> c2 = c(str);
                if (!a(cVar, c2)) {
                    if (cVar.f5162f <= System.currentTimeMillis()) {
                        c(cVar);
                    } else if (cVar.f5160d > 0) {
                        c(cVar);
                    }
                    if (cVar.f5159c > 0) {
                        cVar.f5162f = System.currentTimeMillis() + cVar.f5160d + cVar.f5159c;
                        c2.add(cVar);
                        a(cVar);
                    }
                } else {
                    b(cVar, str);
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    private boolean b(c cVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, this, cVar, str)) == null) {
            if (cVar == null || cVar.f5158b == null) {
                return false;
            }
            synchronized (this.j) {
                ArrayList<c> c2 = c(str);
                c a2 = a(cVar.f5157a, c2);
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

    private void b(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, cVar) == null) {
            if (cVar.f5161e) {
                this.q.a(cVar.f5158b);
                return;
            }
            for (Future<?> future : this.k.keySet()) {
                if (this.k.get(future) == cVar.f5158b && future != null && (!future.isCancelled() || !future.isDone())) {
                    future.cancel(true);
                }
            }
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            synchronized (this.j) {
                ArrayList<c> c2 = c(str);
                Iterator<c> it = c2.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.f5157a.equals(str2)) {
                        b(next);
                        c2.remove(next.f5157a);
                    }
                }
            }
        }
    }

    private c a(String str, ArrayList<c> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, arrayList)) == null) {
            Iterator<c> it = arrayList.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (TextUtils.equals(str, next.f5157a)) {
                    return next;
                }
            }
            return null;
        }
        return (c) invokeLL.objValue;
    }

    private void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, cVar) == null) {
            long j = cVar.f5162f;
            if (j < this.m) {
                a(Math.max(j - System.currentTimeMillis(), 1000L));
            }
        }
    }

    private void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(AdIconUtil.AD_TEXT_ID, this, j) == null) {
            if (f5146c) {
                String str = f5147d;
                Log.d(str, "intervalMillis: " + j);
            }
            Timer timer = this.n;
            if (timer != null) {
                timer.cancel();
                this.n = null;
            }
            this.n = new Timer();
            this.n.schedule(new com.baidu.fsg.base.b.c(this), j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            if (f5146c) {
                Log.d(f5147d, "scheduleForPeriodTasks run");
            }
            synchronized (this.j) {
                long currentTimeMillis = System.currentTimeMillis();
                this.m = Long.MAX_VALUE;
                for (String str : this.j.keySet()) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<c> it = c(str).iterator();
                    while (it.hasNext()) {
                        c next = it.next();
                        if (next.f5162f - currentTimeMillis < 1000) {
                            if (f5146c) {
                                String str2 = f5147d;
                                Log.d(str2, "task.mNextRunTime - current = " + (next.f5162f - currentTimeMillis));
                            }
                            c(next);
                            if (next.f5159c > 0) {
                                next.f5162f = next.f5159c + currentTimeMillis;
                                arrayList.add(next);
                            }
                        }
                        if (next.f5162f < this.m) {
                            this.m = next.f5162f;
                        }
                    }
                    if (this.m < Long.MAX_VALUE) {
                        a(this.m - currentTimeMillis);
                    }
                }
            }
        }
    }

    private boolean a(c cVar, ArrayList<c> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, this, cVar, arrayList)) == null) {
            Iterator<c> it = arrayList.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().f5157a, cVar.f5157a)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private void a(c cVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65543, this, cVar, j) == null) {
            this.p.execute(new d(this, j, cVar));
        }
    }
}
