package com.baidu.apollon.taskmanager;

import android.text.TextUtils;
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
/* loaded from: classes5.dex */
public final class TaskManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long TIMESLICE = 1000;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f38235a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f38236b;

    /* renamed from: c  reason: collision with root package name */
    public static final long f38237c = Long.MAX_VALUE;

    /* renamed from: f  reason: collision with root package name */
    public static TaskManager f38238f = null;

    /* renamed from: i  reason: collision with root package name */
    public static final int f38239i = 5;

    /* renamed from: j  reason: collision with root package name */
    public static final int f38240j = 128;
    public static final int k = 1;
    public static HashMap<String, TaskManager> mTskMgrMap;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public long f38241d;

    /* renamed from: e  reason: collision with root package name */
    public Timer f38242e;

    /* renamed from: g  reason: collision with root package name */
    public final HashMap<String, ArrayList<Task>> f38243g;

    /* renamed from: h  reason: collision with root package name */
    public final HashMap<Future<?>, Runnable> f38244h;
    public BlockingQueue<Runnable> l;
    public final ThreadFactory m;
    public a n;
    public b o;

    /* loaded from: classes5.dex */
    public class Task {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f38251a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TaskManager f38252b;
        public long mDelay;
        public boolean mIsSerial;
        public long mPeriod;
        public Runnable mRunnable;
        public String mTaskKey;

        public Task(TaskManager taskManager, long j2, long j3, boolean z, String str, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {taskManager, Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z), str, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38252b = taskManager;
            this.mDelay = j2;
            this.f38251a = System.currentTimeMillis() + j2;
            this.mPeriod = j3;
            this.mIsSerial = z;
            this.mRunnable = runnable;
            this.mTaskKey = str;
        }
    }

    /* loaded from: classes5.dex */
    public class a extends ThreadPoolExecutor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TaskManager f38253a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TaskManager taskManager, int i2, int i3, long j2, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
            super(i2, i3, j2, timeUnit, blockingQueue, threadFactory);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {taskManager, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), timeUnit, blockingQueue, threadFactory};
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
            this.f38253a = taskManager;
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        public void afterExecute(Runnable runnable, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, runnable, th) == null) {
                this.f38253a.f38244h.remove((Future) runnable);
                super.afterExecute(runnable, th);
            }
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
        f38235a = ApollonConstants.DEBUG;
        f38236b = TaskManager.class.getSimpleName();
        mTskMgrMap = new HashMap<>();
        f38238f = null;
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
        this.f38241d = Long.MAX_VALUE;
        this.f38242e = new Timer();
        this.f38244h = new HashMap<>();
        this.l = new LinkedBlockingQueue(10);
        this.m = new ThreadFactory(this) { // from class: com.baidu.apollon.taskmanager.TaskManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TaskManager f38245a;

            /* renamed from: b  reason: collision with root package name */
            public final AtomicInteger f38246b;

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
                this.f38245a = this;
                this.f38246b = new AtomicInteger(1);
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, runnable)) == null) {
                    return new Thread(runnable, "WalletTask #" + this.f38246b.getAndIncrement());
                }
                return (Thread) invokeL.objValue;
            }
        };
        this.n = new a(this, 5, 128, 1L, TimeUnit.SECONDS, this.l, this.m);
        this.o = new b();
        this.f38243g = new HashMap<>();
        if (!ChannelUtils.isSpecailPackage() || (aVar = this.n) == null) {
            return;
        }
        aVar.allowCoreThreadTimeOut(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Task task) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, task) == null) {
            if (task.mPeriod > 0) {
                task.mDelay = 0L;
            }
            if (task.mIsSerial) {
                this.o.execute(task.mRunnable);
                return;
            }
            this.f38244h.put(this.n.submit(task.mRunnable), task.mRunnable);
            if (f38235a) {
                String str = "execute task, " + task.mTaskKey + " execute time is " + System.currentTimeMillis();
            }
        }
    }

    public static synchronized TaskManager getInstance(String str) {
        InterceptResult invokeL;
        TaskManager taskManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            synchronized (TaskManager.class) {
                if (mTskMgrMap.get(str) == null) {
                    TaskManager taskManager2 = new TaskManager();
                    f38238f = taskManager2;
                    mTskMgrMap.put(str, taskManager2);
                }
                taskManager = f38238f;
            }
            return taskManager;
        }
        return (TaskManager) invokeL.objValue;
    }

    public boolean addTask(Task task, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, task, str)) == null) {
            if (task == null || task.mRunnable == null) {
                return false;
            }
            synchronized (this.f38243g) {
                ArrayList<Task> a2 = a(str);
                if (!a(task, a2)) {
                    if (task.f38251a <= System.currentTimeMillis()) {
                        c(task);
                    } else if (task.mDelay > 0) {
                        c(task);
                    }
                    if (task.mPeriod > 0) {
                        task.f38251a = System.currentTimeMillis() + task.mDelay + task.mPeriod;
                        a2.add(task);
                        a(task);
                    }
                } else {
                    a(task, str);
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void cancelAllTasks(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            synchronized (this.f38243g) {
                ArrayList<Task> a2 = a(str);
                Iterator<Task> it = a2.iterator();
                while (it.hasNext()) {
                    b(it.next());
                }
                a2.clear();
                this.f38243g.remove(str);
            }
        }
    }

    public void cancelTask(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            synchronized (this.f38243g) {
                ArrayList<Task> a2 = a(str);
                Iterator<Task> it = a2.iterator();
                while (it.hasNext()) {
                    Task next = it.next();
                    if (next.mTaskKey.equals(str2)) {
                        b(next);
                        a2.remove(next.mTaskKey);
                    }
                }
            }
        }
    }

    private void b(Task task) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, task) == null) {
            if (task.mIsSerial) {
                this.o.a(task.mRunnable);
                return;
            }
            for (Future<?> future : this.f38244h.keySet()) {
                if (this.f38244h.get(future) == task.mRunnable && future != null && (!future.isCancelled() || !future.isDone())) {
                    future.cancel(true);
                }
            }
        }
    }

    private void c(Task task) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, task) == null) {
            if (task.mDelay > 0) {
                a(task, task.f38251a - System.currentTimeMillis());
            } else {
                d(task);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Executor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final LinkedList<Runnable> f38254a;

        /* renamed from: b  reason: collision with root package name */
        public Runnable f38255b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TaskManager f38256c;

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
            this.f38256c = taskManager;
            this.f38254a = new LinkedList<>();
        }

        public synchronized void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    Runnable poll = this.f38254a.poll();
                    this.f38255b = poll;
                    if (poll != null) {
                        this.f38256c.n.execute(this.f38255b);
                    }
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) {
                synchronized (this) {
                    this.f38254a.offer(new Runnable(this, runnable) { // from class: com.baidu.apollon.taskmanager.TaskManager.b.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ Runnable f38257a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ b f38258b;

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
                            this.f38258b = this;
                            this.f38257a = runnable;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                try {
                                    this.f38257a.run();
                                } finally {
                                    this.f38258b.a();
                                }
                            }
                        }
                    });
                    if (this.f38255b == null) {
                        a();
                    }
                }
            }
        }

        public synchronized void a(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) {
                synchronized (this) {
                    this.f38254a.remove(runnable);
                }
            }
        }
    }

    private Task a(String str, ArrayList<Task> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, arrayList)) == null) {
            Iterator<Task> it = arrayList.iterator();
            while (it.hasNext()) {
                Task next = it.next();
                if (TextUtils.equals(str, next.mTaskKey)) {
                    return next;
                }
            }
            return null;
        }
        return (Task) invokeLL.objValue;
    }

    private ArrayList<Task> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            ArrayList<Task> arrayList = this.f38243g.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            this.f38243g.put(str, arrayList);
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    private boolean a(Task task, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, this, task, str)) == null) {
            if (task == null || task.mRunnable == null) {
                return false;
            }
            synchronized (this.f38243g) {
                ArrayList<Task> a2 = a(str);
                Task a3 = a(task.mTaskKey, a2);
                if (a3 != null) {
                    b(a3);
                    a2.remove(a3);
                    addTask(task, str);
                    return true;
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    private void a(Task task) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, task) == null) {
            long j2 = task.f38251a;
            if (j2 < this.f38241d) {
                a(Math.max(j2 - System.currentTimeMillis(), 1000L));
            }
        }
    }

    private void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(AdIconUtil.BAIDU_LOGO_ID, this, j2) == null) {
            if (f38235a) {
                String str = "intervalMillis: " + j2;
            }
            Timer timer = this.f38242e;
            if (timer != null) {
                timer.cancel();
                this.f38242e = null;
            }
            this.f38242e = new Timer();
            this.f38242e.schedule(new TimerTask(this) { // from class: com.baidu.apollon.taskmanager.TaskManager.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TaskManager f38247a;

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
                    this.f38247a = this;
                }

                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f38247a.a();
                    }
                }
            }, j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            boolean z = f38235a;
            synchronized (this.f38243g) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f38241d = Long.MAX_VALUE;
                for (String str : this.f38243g.keySet()) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<Task> it = a(str).iterator();
                    while (it.hasNext()) {
                        Task next = it.next();
                        if (next.f38251a - currentTimeMillis < 1000) {
                            if (f38235a) {
                                String str2 = "task.mNextRunTime - current = " + (next.f38251a - currentTimeMillis);
                            }
                            c(next);
                            if (next.mPeriod > 0) {
                                next.f38251a = next.mPeriod + currentTimeMillis;
                                arrayList.add(next);
                            }
                        }
                        if (next.f38251a < this.f38241d) {
                            this.f38241d = next.f38251a;
                        }
                    }
                    if (this.f38241d < Long.MAX_VALUE) {
                        a(this.f38241d - currentTimeMillis);
                    }
                }
            }
        }
    }

    private boolean a(Task task, ArrayList<Task> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, this, task, arrayList)) == null) {
            Iterator<Task> it = arrayList.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().mTaskKey, task.mTaskKey)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private void a(Task task, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65544, this, task, j2) == null) {
            this.n.execute(new Runnable(this, j2, task) { // from class: com.baidu.apollon.taskmanager.TaskManager.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ long f38248a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Task f38249b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ TaskManager f38250c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j2), task};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38250c = this;
                    this.f38248a = j2;
                    this.f38249b = task;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            Thread.sleep(this.f38248a);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                        this.f38250c.d(this.f38249b);
                    }
                }
            });
        }
    }
}
