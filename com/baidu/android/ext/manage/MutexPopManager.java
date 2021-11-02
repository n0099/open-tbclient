package com.baidu.android.ext.manage;

import androidx.annotation.NonNull;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
/* loaded from: classes6.dex */
public class MutexPopManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean DEBUG = false;
    public static final String TAG = "MutexPopManager";
    public static boolean isMutexRunning = false;
    public static long sCloseThreadDelay = 500;
    public static long sDefaultInterval = 1000;
    public static MutexPopManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isShowing;
    public BasePopTask mCurrentRunningTask;
    public Executor mExecutor;
    public PriorityBlockingQueue<BasePopTask> mQueue;
    public Runnable mRunnable;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2024340274, "Lcom/baidu/android/ext/manage/MutexPopManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2024340274, "Lcom/baidu/android/ext/manage/MutexPopManager;");
        }
    }

    public MutexPopManager() {
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
        this.isShowing = false;
    }

    public static void doNextTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
            doNextTask(sDefaultInterval);
        }
    }

    public static synchronized MutexPopManager ensureInstance() {
        InterceptResult invokeV;
        MutexPopManager mutexPopManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            synchronized (MutexPopManager.class) {
                if (sInstance == null) {
                    sInstance = new MutexPopManager();
                }
                if (sInstance.mExecutor == null) {
                    sInstance.mExecutor = Executors.newSingleThreadExecutor();
                }
                mutexPopManager = sInstance;
            }
            return mutexPopManager;
        }
        return (MutexPopManager) invokeV.objValue;
    }

    public static synchronized void ensureQueue() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            synchronized (MutexPopManager.class) {
                ensureInstance();
                if (sInstance.mQueue == null) {
                    sInstance.mQueue = new PriorityBlockingQueue<>(4);
                }
            }
        }
    }

    public static synchronized void execPopTask(@NonNull PopItem popItem, int i2, boolean z, boolean z2, boolean z3, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{popItem, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), str, objArr}) == null) {
            synchronized (MutexPopManager.class) {
                execPopTask(new BasePopTask(popItem, i2, z, z2, z3, str, objArr));
            }
        }
    }

    public static BasePopTask generateTaskFromPopItem(@NonNull PopItem popItem, @NonNull String str, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65556, null, popItem, str, objArr)) == null) {
            if (popItem == null) {
                return null;
            }
            return new BasePopTask(popItem, str, objArr);
        }
        return (BasePopTask) invokeLLL.objValue;
    }

    public static String getThreadInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            return stackTrace[stackTrace.length < 5 ? stackTrace.length - 1 : 5].toString();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0022, code lost:
        if (com.baidu.android.ext.manage.MutexPopManager.sInstance.mQueue.isEmpty() == false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean hasTask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            synchronized (MutexPopManager.class) {
                boolean z = false;
                if (sInstance == null) {
                    return false;
                }
                if (sInstance.mCurrentRunningTask == null) {
                    if (sInstance.mQueue != null) {
                    }
                    return z;
                }
                z = true;
                return z;
            }
        }
        return invokeV.booleanValue;
    }

    public static synchronized void nextTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, null) == null) {
            synchronized (MutexPopManager.class) {
                boolean z = DEBUG;
                if (sInstance == null) {
                    boolean z2 = DEBUG;
                    return;
                }
                sInstance.isShowing = false;
                if (sInstance.mCurrentRunningTask != null) {
                    sInstance.mCurrentRunningTask.mutexDismiss();
                }
                if (!isMutexRunning) {
                    boolean z3 = DEBUG;
                    sInstance.mCurrentRunningTask = null;
                    return;
                }
                if (sInstance.mQueue.isEmpty()) {
                    if (DEBUG) {
                        String str = "doNextTask()方法中已经没有更多任务，此线程需要在" + sCloseThreadDelay + "ms后结束自己!";
                    }
                    UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.android.ext.manage.MutexPopManager.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                }
                            }
                        }

                        /* JADX WARN: Removed duplicated region for block: B:23:0x003e A[EXC_TOP_SPLITTER, SYNTHETIC] */
                        @Override // java.lang.Runnable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                                return;
                            }
                            if (MutexPopManager.sInstance.mQueue == null || MutexPopManager.sInstance.mQueue.isEmpty()) {
                                MutexPopManager unused = MutexPopManager.sInstance;
                                if (MutexPopManager.isMutexRunning) {
                                    boolean unused2 = MutexPopManager.DEBUG;
                                    MutexPopManager unused3 = MutexPopManager.sInstance;
                                    boolean unused4 = MutexPopManager.isMutexRunning = false;
                                    synchronized (MutexPopManager.sInstance.mRunnable) {
                                        MutexPopManager.sInstance.mCurrentRunningTask = null;
                                        MutexPopManager.sInstance.mRunnable.notifyAll();
                                    }
                                    return;
                                }
                            }
                            boolean unused5 = MutexPopManager.DEBUG;
                            synchronized (MutexPopManager.sInstance.mRunnable) {
                            }
                        }
                    }, sCloseThreadDelay);
                } else {
                    synchronized (sInstance.mRunnable) {
                        sInstance.mRunnable.notifyAll();
                    }
                }
            }
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (isMutexRunning) {
                boolean z = DEBUG;
                return;
            }
            isMutexRunning = true;
            if (this.mRunnable == null) {
                this.mRunnable = new Runnable(this) { // from class: com.baidu.android.ext.manage.MutexPopManager.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MutexPopManager this$0;

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
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            while (MutexPopManager.isMutexRunning) {
                                while (this.this$0.isShowing) {
                                    try {
                                        synchronized (this) {
                                            wait();
                                        }
                                    } catch (InterruptedException e2) {
                                        if (MutexPopManager.DEBUG) {
                                            e2.printStackTrace();
                                        }
                                    }
                                }
                                if (!MutexPopManager.isMutexRunning) {
                                    break;
                                }
                                try {
                                    boolean unused = MutexPopManager.DEBUG;
                                    this.this$0.mCurrentRunningTask = (BasePopTask) this.this$0.mQueue.take();
                                    boolean unused2 = MutexPopManager.DEBUG;
                                    if (MutexPopManager.DEBUG && this.this$0.mCurrentRunningTask != null) {
                                        String.format("已从队列中取出priority是%d的任务！队列中剩余%d个任务", Integer.valueOf(this.this$0.mCurrentRunningTask.mPriority), Integer.valueOf(this.this$0.mQueue.size()));
                                    }
                                } catch (InterruptedException e3) {
                                    if (MutexPopManager.DEBUG) {
                                        e3.printStackTrace();
                                    }
                                }
                                if (this.this$0.mCurrentRunningTask == null || !this.this$0.mCurrentRunningTask.mutexFinalCheck()) {
                                    if (MutexPopManager.DEBUG) {
                                        Object[] objArr = new Object[1];
                                        objArr[0] = Integer.valueOf(this.this$0.mCurrentRunningTask == null ? -1 : this.this$0.mCurrentRunningTask.mPriority);
                                        String.format("取出的priority是%d的任务！最终检查未通过", objArr);
                                    }
                                    if (this.this$0.mQueue != null && this.this$0.mQueue.isEmpty()) {
                                        MutexPopManager.doNextTask();
                                        synchronized (this) {
                                            try {
                                                wait();
                                            } catch (InterruptedException e4) {
                                                if (MutexPopManager.DEBUG) {
                                                    e4.printStackTrace();
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    UiThreadUtil.runOnUiThread(new Runnable(this) { // from class: com.baidu.android.ext.manage.MutexPopManager.1.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass1 this$1;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr2 = {this};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i2 = newInitContext.flag;
                                                if ((i2 & 1) != 0) {
                                                    int i3 = i2 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$1 = this;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                boolean unused3 = MutexPopManager.DEBUG;
                                                if (this.this$1.this$0.mCurrentRunningTask == null) {
                                                    boolean unused4 = MutexPopManager.DEBUG;
                                                    this.this$1.this$0.isShowing = false;
                                                    return;
                                                }
                                                MutexPopManager mutexPopManager = this.this$1.this$0;
                                                mutexPopManager.isShowing = mutexPopManager.mCurrentRunningTask.mutexShow();
                                            }
                                        }
                                    });
                                    this.this$0.isShowing = true;
                                    if (MutexPopManager.DEBUG) {
                                        String.format("取出的priority是%d的任务！检查通过,开始显示！", Integer.valueOf(this.this$0.mCurrentRunningTask.mPriority));
                                    }
                                }
                            }
                            boolean unused3 = MutexPopManager.DEBUG;
                            MutexPopManager.sInstance.mCurrentRunningTask = null;
                            boolean unused4 = MutexPopManager.isMutexRunning = false;
                        }
                    }
                };
            }
            boolean z2 = DEBUG;
            this.mExecutor.execute(this.mRunnable);
        }
    }

    public static void doNextTask(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65550, null, j) == null) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.android.ext.manage.MutexPopManager.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        boolean unused = MutexPopManager.DEBUG;
                        MutexPopManager.nextTask();
                    }
                }
            }, j);
        }
    }

    public static synchronized boolean execPopTask(@NonNull PopItem popItem, String str, Object... objArr) {
        InterceptResult invokeLLL;
        boolean execPopTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65555, null, popItem, str, objArr)) == null) {
            synchronized (MutexPopManager.class) {
                execPopTask = execPopTask(new BasePopTask(popItem, str, objArr));
            }
            return execPopTask;
        }
        return invokeLLL.booleanValue;
    }

    public static synchronized boolean execPopTask(@NonNull BasePopTask basePopTask) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, basePopTask)) == null) {
            synchronized (MutexPopManager.class) {
                ensureInstance();
                z = false;
                if (sInstance.mCurrentRunningTask != null && (!basePopTask.isEnforce || basePopTask.compareTo(sInstance.mCurrentRunningTask) >= 0)) {
                    if (basePopTask.isEnqueue) {
                        ensureQueue();
                        boolean offer = sInstance.mQueue.offer(basePopTask);
                        if (DEBUG) {
                            String.format("加入priority是%d的任务时，因为已有相应的任务,需要加入队列进行等待\n堆栈信息：\n" + getThreadInfo(), Integer.valueOf(basePopTask.mPriority));
                        }
                        sInstance.start();
                        z = offer;
                    }
                }
                if (sInstance.mCurrentRunningTask != null) {
                    sInstance.mCurrentRunningTask.mutexDismiss();
                    if (sInstance.mCurrentRunningTask.isResumable) {
                        sInstance.mQueue.offer(sInstance.mCurrentRunningTask);
                    }
                    if (DEBUG) {
                        String.format("加入priority是%d的任务时候根据优先级抢占成功，可直接显示\n堆栈信息：\n" + getThreadInfo(), Integer.valueOf(basePopTask.mPriority));
                    }
                } else if (DEBUG) {
                    String.format("加入priority是%d的任务时候没有任何任务，可直接显示\n堆栈信息：\n" + getThreadInfo(), Integer.valueOf(basePopTask.mPriority));
                }
                if (basePopTask.mutexFinalCheck()) {
                    sInstance.mCurrentRunningTask = basePopTask;
                    sInstance.isShowing = true;
                    basePopTask.mutexShow();
                    if (DEBUG) {
                        String.format("第一个加入要显示的任务成功显示,mPriority:%d", Integer.valueOf(basePopTask.mPriority));
                    }
                } else {
                    boolean z2 = DEBUG;
                }
                z = true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}
