package com.baidu.apollon.taskmanager;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.ApollonConstants;
import com.baidu.apollon.utils.ChannelUtils;
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
/* loaded from: classes.dex */
public final class TaskManager {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, TaskManager> f4004a = null;

    /* renamed from: b  reason: collision with root package name */
    public static final long f4005b = 1000;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f4006c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f4007d;

    /* renamed from: e  reason: collision with root package name */
    public static final long f4008e = Long.MAX_VALUE;

    /* renamed from: h  reason: collision with root package name */
    public static TaskManager f4009h = null;
    public static final int k = 5;
    public static final int l = 128;
    public static final int m = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public long f4010f;

    /* renamed from: g  reason: collision with root package name */
    public Timer f4011g;

    /* renamed from: i  reason: collision with root package name */
    public final HashMap<String, ArrayList<c>> f4012i;
    public final HashMap<Future<?>, Runnable> j;
    public BlockingQueue<Runnable> n;
    public final ThreadFactory o;
    public a p;
    public b q;

    /* loaded from: classes.dex */
    public class a extends ThreadPoolExecutor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TaskManager f4019a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TaskManager taskManager, int i2, int i3, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
            super(i2, i3, j, timeUnit, blockingQueue, threadFactory);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {taskManager, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), timeUnit, blockingQueue, threadFactory};
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
            this.f4019a = taskManager;
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        public void afterExecute(Runnable runnable, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, runnable, th) == null) {
                this.f4019a.j.remove((Future) runnable);
                super.afterExecute(runnable, th);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f4025a;

        /* renamed from: b  reason: collision with root package name */
        public Runnable f4026b;

        /* renamed from: c  reason: collision with root package name */
        public long f4027c;

        /* renamed from: d  reason: collision with root package name */
        public long f4028d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f4029e;

        /* renamed from: f  reason: collision with root package name */
        public long f4030f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ TaskManager f4031g;

        public c(TaskManager taskManager, long j, long j2, boolean z, String str, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {taskManager, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z), str, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4031g = taskManager;
            this.f4028d = j;
            this.f4030f = System.currentTimeMillis() + j;
            this.f4027c = j2;
            this.f4029e = z;
            this.f4026b = runnable;
            this.f4025a = str;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1375578296, "Lcom/baidu/apollon/taskmanager/TaskManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1375578296, "Lcom/baidu/apollon/taskmanager/TaskManager;");
                return;
            }
        }
        f4006c = ApollonConstants.DEBUG;
        f4007d = TaskManager.class.getSimpleName();
        f4004a = new HashMap<>();
        f4009h = null;
    }

    public TaskManager() {
        a aVar;
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
        this.f4010f = Long.MAX_VALUE;
        this.f4011g = new Timer();
        this.j = new HashMap<>();
        this.n = new LinkedBlockingQueue(10);
        this.o = new ThreadFactory(this) { // from class: com.baidu.apollon.taskmanager.TaskManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TaskManager f4013a;

            /* renamed from: b  reason: collision with root package name */
            public final AtomicInteger f4014b;

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
                this.f4013a = this;
                this.f4014b = new AtomicInteger(1);
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, runnable)) == null) {
                    return new Thread(runnable, "WalletTask #" + this.f4014b.getAndIncrement());
                }
                return (Thread) invokeL.objValue;
            }
        };
        this.p = new a(this, 5, 128, 1L, TimeUnit.SECONDS, this.n, this.o);
        this.q = new b();
        this.f4012i = new HashMap<>();
        if (!ChannelUtils.isSpecailPackage() || (aVar = this.p) == null) {
            return;
        }
        aVar.allowCoreThreadTimeOut(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, cVar) == null) {
            if (cVar.f4027c > 0) {
                cVar.f4028d = 0L;
            }
            if (cVar.f4029e) {
                this.q.execute(cVar.f4026b);
                return;
            }
            this.j.put(this.p.submit(cVar.f4026b), cVar.f4026b);
            if (f4006c) {
                String str = f4007d;
                Log.d(str, "execute task, " + cVar.f4025a + " execute time is " + System.currentTimeMillis());
            }
        }
    }

    public static synchronized TaskManager getInstance(String str) {
        InterceptResult invokeL;
        TaskManager taskManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            synchronized (TaskManager.class) {
                if (f4004a.get(str) == null) {
                    TaskManager taskManager2 = new TaskManager();
                    f4009h = taskManager2;
                    f4004a.put(str, taskManager2);
                }
                taskManager = f4009h;
            }
            return taskManager;
        }
        return (TaskManager) invokeL.objValue;
    }

    public void cancelTask(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            synchronized (this.f4012i) {
                ArrayList<c> b2 = b(str);
                Iterator<c> it = b2.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.f4025a.equals(str2)) {
                        b(next);
                        b2.remove(next.f4025a);
                    }
                }
            }
        }
    }

    private ArrayList<c> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, str)) == null) {
            ArrayList<c> arrayList = this.f4012i.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            this.f4012i.put(str, arrayList);
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    private void c(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, cVar) == null) {
            if (cVar.f4028d > 0) {
                a(cVar, cVar.f4030f - System.currentTimeMillis());
            } else {
                d(cVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Executor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final LinkedList<Runnable> f4020a;

        /* renamed from: b  reason: collision with root package name */
        public Runnable f4021b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TaskManager f4022c;

        public b(TaskManager taskManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {taskManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4022c = taskManager;
            this.f4020a = new LinkedList<>();
        }

        public synchronized void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    Runnable poll = this.f4020a.poll();
                    this.f4021b = poll;
                    if (poll != null) {
                        this.f4022c.p.execute(this.f4021b);
                    }
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) {
                synchronized (this) {
                    this.f4020a.offer(new Runnable(this, runnable) { // from class: com.baidu.apollon.taskmanager.TaskManager.b.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ Runnable f4023a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ b f4024b;

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
                            this.f4024b = this;
                            this.f4023a = runnable;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                try {
                                    this.f4023a.run();
                                } finally {
                                    this.f4024b.a();
                                }
                            }
                        }
                    });
                    if (this.f4021b == null) {
                        a();
                    }
                }
            }
        }

        public synchronized void a(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) {
                synchronized (this) {
                    this.f4020a.remove(runnable);
                }
            }
        }
    }

    public boolean a(c cVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, str)) == null) {
            if (cVar == null || cVar.f4026b == null) {
                return false;
            }
            synchronized (this.f4012i) {
                ArrayList<c> b2 = b(str);
                if (!a(cVar, b2)) {
                    if (cVar.f4030f <= System.currentTimeMillis()) {
                        c(cVar);
                    } else if (cVar.f4028d > 0) {
                        c(cVar);
                    }
                    if (cVar.f4027c > 0) {
                        cVar.f4030f = System.currentTimeMillis() + cVar.f4028d + cVar.f4027c;
                        b2.add(cVar);
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
            if (cVar == null || cVar.f4026b == null) {
                return false;
            }
            synchronized (this.f4012i) {
                ArrayList<c> b2 = b(str);
                c a2 = a(cVar.f4025a, b2);
                if (a2 != null) {
                    b(a2);
                    b2.remove(a2);
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
            if (cVar.f4029e) {
                this.q.a(cVar.f4026b);
                return;
            }
            for (Future<?> future : this.j.keySet()) {
                if (this.j.get(future) == cVar.f4026b && future != null && (!future.isCancelled() || !future.isDone())) {
                    future.cancel(true);
                }
            }
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            synchronized (this.f4012i) {
                ArrayList<c> b2 = b(str);
                Iterator<c> it = b2.iterator();
                while (it.hasNext()) {
                    b(it.next());
                }
                b2.clear();
                this.f4012i.remove(str);
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
                if (TextUtils.equals(str, next.f4025a)) {
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
            long j = cVar.f4030f;
            if (j < this.f4010f) {
                a(Math.max(j - System.currentTimeMillis(), 1000L));
            }
        }
    }

    private void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(AdIconUtil.AD_TEXT_ID, this, j) == null) {
            if (f4006c) {
                String str = f4007d;
                Log.d(str, "intervalMillis: " + j);
            }
            Timer timer = this.f4011g;
            if (timer != null) {
                timer.cancel();
                this.f4011g = null;
            }
            this.f4011g = new Timer();
            this.f4011g.schedule(new TimerTask(this) { // from class: com.baidu.apollon.taskmanager.TaskManager.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TaskManager f4015a;

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
                    this.f4015a = this;
                }

                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f4015a.a();
                    }
                }
            }, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            if (f4006c) {
                Log.d(f4007d, "scheduleForPeriodTasks run");
            }
            synchronized (this.f4012i) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f4010f = Long.MAX_VALUE;
                for (String str : this.f4012i.keySet()) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<c> it = b(str).iterator();
                    while (it.hasNext()) {
                        c next = it.next();
                        if (next.f4030f - currentTimeMillis < 1000) {
                            if (f4006c) {
                                String str2 = f4007d;
                                Log.d(str2, "task.mNextRunTime - current = " + (next.f4030f - currentTimeMillis));
                            }
                            c(next);
                            if (next.f4027c > 0) {
                                next.f4030f = next.f4027c + currentTimeMillis;
                                arrayList.add(next);
                            }
                        }
                        if (next.f4030f < this.f4010f) {
                            this.f4010f = next.f4030f;
                        }
                    }
                    if (this.f4010f < Long.MAX_VALUE) {
                        a(this.f4010f - currentTimeMillis);
                    }
                }
            }
        }
    }

    private boolean a(c cVar, ArrayList<c> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, cVar, arrayList)) == null) {
            Iterator<c> it = arrayList.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().f4025a, cVar.f4025a)) {
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
            this.p.execute(new Runnable(this, j, cVar) { // from class: com.baidu.apollon.taskmanager.TaskManager.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ long f4016a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ c f4017b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ TaskManager f4018c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j), cVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f4018c = this;
                    this.f4016a = j;
                    this.f4017b = cVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            Thread.sleep(this.f4016a);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                        this.f4018c.d(this.f4017b);
                    }
                }
            });
        }
    }
}
