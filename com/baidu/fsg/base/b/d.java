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
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final long f37359a = 1000;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f37360b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f37361c;

    /* renamed from: d  reason: collision with root package name */
    public static final long f37362d = Long.MAX_VALUE;

    /* renamed from: e  reason: collision with root package name */
    public static final int f37363e = 5;

    /* renamed from: f  reason: collision with root package name */
    public static final int f37364f = 128;

    /* renamed from: g  reason: collision with root package name */
    public static final int f37365g = 1;

    /* renamed from: h  reason: collision with root package name */
    public static HashMap<String, d> f37366h;

    /* renamed from: i  reason: collision with root package name */
    public static d f37367i;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, ArrayList<c>> j;
    public final HashMap<Future<?>, Runnable> k;
    public final ThreadFactory l;
    public long m;
    public Timer n;
    public BlockingQueue<Runnable> o;
    public a p;
    public b q;

    /* loaded from: classes7.dex */
    public class a extends ThreadPoolExecutor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f37368a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, int i2, int i3, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
            super(i2, i3, j, timeUnit, blockingQueue, threadFactory);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), timeUnit, blockingQueue, threadFactory};
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
            this.f37368a = dVar;
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        public void afterExecute(Runnable runnable, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, runnable, th) == null) {
                this.f37368a.k.remove((Future) runnable);
                super.afterExecute(runnable, th);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Executor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final LinkedList<Runnable> f37369a;

        /* renamed from: b  reason: collision with root package name */
        public Runnable f37370b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f37371c;

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
            this.f37371c = dVar;
            this.f37369a = new LinkedList<>();
        }

        public /* synthetic */ b(d dVar, com.baidu.fsg.base.b.a aVar) {
            this(dVar);
        }

        public synchronized void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    Runnable poll = this.f37369a.poll();
                    this.f37370b = poll;
                    if (poll != null) {
                        this.f37371c.p.execute(this.f37370b);
                    }
                }
            }
        }

        public synchronized void a(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) {
                synchronized (this) {
                    this.f37369a.remove(runnable);
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) {
                synchronized (this) {
                    this.f37369a.offer(new e(this, runnable));
                    if (this.f37370b == null) {
                        a();
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f37372a;

        /* renamed from: b  reason: collision with root package name */
        public Runnable f37373b;

        /* renamed from: c  reason: collision with root package name */
        public long f37374c;

        /* renamed from: d  reason: collision with root package name */
        public long f37375d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f37376e;

        /* renamed from: f  reason: collision with root package name */
        public long f37377f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f37378g;

        public c(d dVar, long j, long j2, boolean z, String str, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z), str, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37378g = dVar;
            this.f37375d = j;
            this.f37377f = System.currentTimeMillis() + j;
            this.f37374c = j2;
            this.f37376e = z;
            this.f37373b = runnable;
            this.f37372a = str;
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
        f37360b = ApollonConstants.DEBUG;
        f37361c = d.class.getSimpleName();
        f37366h = new HashMap<>();
        f37367i = null;
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
        this.k = new HashMap<>();
        this.l = new com.baidu.fsg.base.b.a(this);
        this.m = Long.MAX_VALUE;
        this.n = new Timer();
        this.o = new LinkedBlockingQueue(10);
        this.p = new a(this, 5, 128, 1L, TimeUnit.SECONDS, this.o, this.l);
        this.q = new b(this, null);
        this.j = new HashMap<>();
    }

    private c a(String str, ArrayList<c> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, arrayList)) == null) {
            Iterator<c> it = arrayList.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (TextUtils.equals(str, next.f37372a)) {
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
            boolean z = f37360b;
            synchronized (this.j) {
                long currentTimeMillis = System.currentTimeMillis();
                this.m = Long.MAX_VALUE;
                for (String str : this.j.keySet()) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<c> it = c(str).iterator();
                    while (it.hasNext()) {
                        c next = it.next();
                        if (next.f37377f - currentTimeMillis < 1000) {
                            if (f37360b) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("task.mNextRunTime - current = ");
                                sb.append(next.f37377f - currentTimeMillis);
                                sb.toString();
                            }
                            c(next);
                            if (next.f37374c > 0) {
                                next.f37377f = next.f37374c + currentTimeMillis;
                                arrayList.add(next);
                            }
                        }
                        if (next.f37377f < this.m) {
                            this.m = next.f37377f;
                        }
                    }
                    if (this.m < Long.MAX_VALUE) {
                        a(this.m - currentTimeMillis);
                    }
                }
            }
        }
    }

    private void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, this, j) == null) {
            if (f37360b) {
                String str = "intervalMillis: " + j;
            }
            Timer timer = this.n;
            if (timer != null) {
                timer.cancel();
                this.n = null;
            }
            this.n = new Timer();
            this.n.schedule(new com.baidu.fsg.base.b.b(this), j);
        }
    }

    private void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, cVar) == null) {
            if (cVar.f37376e) {
                this.q.a(cVar.f37373b);
                return;
            }
            for (Future<?> future : this.k.keySet()) {
                if (this.k.get(future) == cVar.f37373b && future != null && (!future.isCancelled() || !future.isDone())) {
                    future.cancel(true);
                }
            }
        }
    }

    private void a(c cVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(AdIconUtil.BAIDU_LOGO_ID, this, cVar, j) == null) {
            this.p.execute(new com.baidu.fsg.base.b.c(this, j, cVar));
        }
    }

    private boolean a(c cVar, ArrayList<c> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, cVar, arrayList)) == null) {
            Iterator<c> it = arrayList.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().f37372a, cVar.f37372a)) {
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
                if (f37366h.get(str) == null) {
                    d dVar2 = new d();
                    f37367i = dVar2;
                    f37366h.put(str, dVar2);
                }
                dVar = f37367i;
            }
            return dVar;
        }
        return (d) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, cVar) == null) {
            if (cVar.f37374c > 0) {
                cVar.f37375d = 0L;
            }
            if (cVar.f37376e) {
                this.q.execute(cVar.f37373b);
                return;
            }
            this.k.put(this.p.submit(cVar.f37373b), cVar.f37373b);
            if (f37360b) {
                String str = "execute task, " + cVar.f37372a + " execute time is " + System.currentTimeMillis();
            }
        }
    }

    private boolean b(c cVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, this, cVar, str)) == null) {
            if (cVar == null || cVar.f37373b == null) {
                return false;
            }
            synchronized (this.j) {
                ArrayList<c> c2 = c(str);
                c a2 = a(cVar.f37372a, c2);
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
            ArrayList<c> arrayList = this.j.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            this.j.put(str, arrayList);
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    private void c(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, cVar) == null) {
            if (cVar.f37375d > 0) {
                a(cVar, cVar.f37377f - System.currentTimeMillis());
            } else {
                b(cVar);
            }
        }
    }

    private void d(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, cVar) == null) {
            long j = cVar.f37377f;
            if (j < this.m) {
                a(Math.max(j - System.currentTimeMillis(), 1000L));
            }
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            synchronized (this.j) {
                ArrayList<c> c2 = c(str);
                Iterator<c> it = c2.iterator();
                while (it.hasNext()) {
                    a(it.next());
                }
                c2.clear();
                this.j.remove(str);
            }
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            synchronized (this.j) {
                ArrayList<c> c2 = c(str);
                Iterator<c> it = c2.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.f37372a.equals(str2)) {
                        a(next);
                        c2.remove(next.f37372a);
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0029, code lost:
        if (r9.f37375d > 0) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(c cVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cVar, str)) == null) {
            if (cVar == null || cVar.f37373b == null) {
                return false;
            }
            synchronized (this.j) {
                ArrayList<c> c2 = c(str);
                if (a(cVar, c2)) {
                    b(cVar, str);
                } else {
                    if (cVar.f37377f > System.currentTimeMillis()) {
                    }
                    c(cVar);
                    if (cVar.f37374c > 0) {
                        cVar.f37377f = System.currentTimeMillis() + cVar.f37375d + cVar.f37374c;
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
