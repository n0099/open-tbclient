package com.baidu.android.ext.manage;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.android.util.concurrent.UiThreadUtil;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import rx.a.b.a;
import rx.d;
import rx.functions.b;
import rx.schedulers.Schedulers;
/* loaded from: classes13.dex */
public class MutexPopManager {
    public static final String TAG = "MutexPopManager";
    private static MutexPopManager sInstance;
    private boolean isShowing = false;
    private BasePopTask mCurrentRunningTask;
    private Executor mExecutor;
    private PriorityBlockingQueue<BasePopTask> mQueue;
    private Runnable mRunnable;
    private static boolean DEBUG = false;
    private static boolean isMutexRunning = false;
    private static long sDefaultInterval = 1000;
    private static long sCloseThreadDelay = 10000;

    public static synchronized MutexPopManager ensureInstance() {
        MutexPopManager mutexPopManager;
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

    private static synchronized void ensureQueue() {
        synchronized (MutexPopManager.class) {
            ensureInstance();
            if (sInstance.mQueue == null) {
                sInstance.mQueue = new PriorityBlockingQueue<>(4);
            }
        }
    }

    public static BasePopTask generateTaskFromPopItem(@NonNull PopItem popItem, @NonNull String str, Object... objArr) {
        if (popItem == null) {
            return null;
        }
        return new BasePopTask(popItem, str, objArr);
    }

    public static synchronized void execPopTask(@NonNull PopItem popItem, int i, boolean z, boolean z2, boolean z3, String str, Object... objArr) {
        synchronized (MutexPopManager.class) {
            execPopTask(new BasePopTask(popItem, i, z, z2, z3, str, objArr));
        }
    }

    public static synchronized boolean execPopTask(@NonNull PopItem popItem, String str, Object... objArr) {
        boolean execPopTask;
        synchronized (MutexPopManager.class) {
            execPopTask = execPopTask(new BasePopTask(popItem, str, objArr));
        }
        return execPopTask;
    }

    public static synchronized boolean execPopTask(@NonNull BasePopTask basePopTask) {
        boolean z = false;
        synchronized (MutexPopManager.class) {
            ensureInstance();
            if (sInstance.mCurrentRunningTask == null || (basePopTask.isEnforce && basePopTask.compareTo(sInstance.mCurrentRunningTask) < 0)) {
                if (sInstance.mCurrentRunningTask != null) {
                    sInstance.mCurrentRunningTask.mutexDismiss();
                    if (sInstance.mCurrentRunningTask.isResumable) {
                        sInstance.mQueue.offer(sInstance.mCurrentRunningTask);
                    }
                    if (DEBUG) {
                        Log.e(TAG, String.format("加入priority是%d的任务时候根据优先级抢占成功，可直接显示", Integer.valueOf(basePopTask.mPriority)));
                    }
                } else if (DEBUG) {
                    Log.e(TAG, String.format("加入priority是%d的任务时候没有任何任务，可直接显示", Integer.valueOf(basePopTask.mPriority)));
                }
                if (basePopTask.mutexFinalCheck()) {
                    sInstance.mCurrentRunningTask = basePopTask;
                    sInstance.isShowing = true;
                    basePopTask.mutexShow();
                    if (DEBUG) {
                        Log.i(TAG, String.format("第一个加入要显示的任务成功显示,mPriority:%d", Integer.valueOf(basePopTask.mPriority)));
                    }
                } else if (DEBUG) {
                    Log.v(TAG, "任务直接显示时(却发现此弹框最终检测未通过。)");
                }
                z = true;
            } else if (basePopTask.isEnqueue) {
                ensureQueue();
                z = sInstance.mQueue.offer(basePopTask);
                if (DEBUG) {
                    Log.e(TAG, String.format("加入priority是%d的任务时，因为已有相应的任务,需要加入队列进行等待", Integer.valueOf(basePopTask.mPriority)));
                }
                sInstance.start();
            }
        }
        return z;
    }

    public void start() {
        if (isMutexRunning) {
            if (DEBUG) {
                Log.w(TAG, "循环任务线程还在运行中，无需新启动！");
                return;
            }
            return;
        }
        isMutexRunning = true;
        if (this.mRunnable == null) {
            this.mRunnable = new Runnable() { // from class: com.baidu.android.ext.manage.MutexPopManager.1
                @Override // java.lang.Runnable
                public void run() {
                    while (MutexPopManager.isMutexRunning) {
                        while (MutexPopManager.this.isShowing) {
                            try {
                                synchronized (this) {
                                    wait();
                                }
                            } catch (InterruptedException e) {
                                if (MutexPopManager.DEBUG) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        if (!MutexPopManager.isMutexRunning) {
                            break;
                        }
                        try {
                            if (MutexPopManager.DEBUG) {
                                Log.i(MutexPopManager.TAG, "从mQueue中取任务start");
                            }
                            MutexPopManager.this.mCurrentRunningTask = (BasePopTask) MutexPopManager.this.mQueue.take();
                            if (MutexPopManager.DEBUG) {
                                Log.i(MutexPopManager.TAG, "从mQueue中取任务end");
                            }
                            if (MutexPopManager.DEBUG) {
                                Log.i(MutexPopManager.TAG, MutexPopManager.this.mCurrentRunningTask == null ? "进行了一次取队列操作，但是取出结果是空" : String.format("已从队列中取出priority是%d的任务！队列中剩余%d个任务", Integer.valueOf(MutexPopManager.this.mCurrentRunningTask.mPriority), Integer.valueOf(MutexPopManager.this.mQueue.size())));
                            }
                        } catch (InterruptedException e2) {
                            if (MutexPopManager.DEBUG) {
                                e2.printStackTrace();
                            }
                        }
                        if (MutexPopManager.this.mCurrentRunningTask != null && MutexPopManager.this.mCurrentRunningTask.mutexFinalCheck()) {
                            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.android.ext.manage.MutexPopManager.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (MutexPopManager.this.mCurrentRunningTask == null) {
                                        if (MutexPopManager.DEBUG) {
                                            Log.i(MutexPopManager.TAG, "UI线程中mCurrentRunningTask为空，异常情况了！");
                                        }
                                        MutexPopManager.this.isShowing = false;
                                        return;
                                    }
                                    MutexPopManager.this.isShowing = MutexPopManager.this.mCurrentRunningTask.mutexShow();
                                }
                            });
                            MutexPopManager.this.isShowing = true;
                            Log.d(MutexPopManager.TAG, String.format("取出的priority是%d的任务！检查通过,开始显示！", Integer.valueOf(MutexPopManager.this.mCurrentRunningTask.mPriority)));
                        } else {
                            Object[] objArr = new Object[1];
                            objArr[0] = Integer.valueOf(MutexPopManager.this.mCurrentRunningTask == null ? -1 : MutexPopManager.this.mCurrentRunningTask.mPriority);
                            Log.d(MutexPopManager.TAG, String.format("取出的priority是%d的任务！最终检查未通过", objArr));
                            if (MutexPopManager.this.mQueue != null && MutexPopManager.this.mQueue.isEmpty()) {
                                MutexPopManager.doNextTask();
                                synchronized (this) {
                                    try {
                                        wait();
                                    } catch (InterruptedException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                            }
                        }
                    }
                    if (MutexPopManager.DEBUG) {
                        Log.w(MutexPopManager.TAG, "循环任务线程死亡！");
                    }
                    MutexPopManager.sInstance.mCurrentRunningTask = null;
                    boolean unused = MutexPopManager.isMutexRunning = false;
                }
            };
        }
        if (DEBUG) {
            Log.w(TAG, "目前无循环任务线程运行，新建或重新启动！");
        }
        this.mExecutor.execute(this.mRunnable);
    }

    public static void doNextTask() {
        doNextTask(sDefaultInterval);
    }

    public static void doNextTask(long j) {
        d.b(j, TimeUnit.MILLISECONDS).d(Schedulers.io()).c(a.dOd()).c(new b<Long>() { // from class: com.baidu.android.ext.manage.MutexPopManager.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Long l) {
                MutexPopManager.nextTask();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void nextTask() {
        synchronized (MutexPopManager.class) {
            if (DEBUG) {
                Log.i(TAG, "上一个任务结束,开始执行doNextTask()方法");
            }
            if (sInstance == null) {
                if (DEBUG) {
                    Log.i(TAG, "doNextTask()方法中检测到sInstance为null，直接return！");
                }
            } else {
                sInstance.isShowing = false;
                if (sInstance.mCurrentRunningTask != null) {
                    sInstance.mCurrentRunningTask.mutexDismiss();
                }
                if (!isMutexRunning) {
                    if (DEBUG) {
                        Log.i(TAG, "doNextTask()方法中isMutexRunning是false了。表明互斥时，截止目前只有一个互斥弹框，并且现已显示完!并未生成队列");
                    }
                } else if (sInstance.mQueue.isEmpty()) {
                    if (DEBUG) {
                        Log.i(TAG, "doNextTask()方法中已经没有更多任务，此线程需要在10秒后结束自己!");
                    }
                    d.b(sCloseThreadDelay, TimeUnit.MILLISECONDS).d(Schedulers.io()).c(a.dOd()).c(new b<Long>() { // from class: com.baidu.android.ext.manage.MutexPopManager.3
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Removed duplicated region for block: B:23:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                        @Override // rx.functions.b
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public void call(Long l) {
                            if (MutexPopManager.sInstance.mQueue == null || MutexPopManager.sInstance.mQueue.isEmpty()) {
                                MutexPopManager unused = MutexPopManager.sInstance;
                                if (MutexPopManager.isMutexRunning) {
                                    if (MutexPopManager.DEBUG) {
                                        Log.i(MutexPopManager.TAG, "真的要关闭时，发现队列是为空的，所以要关闭线程啦！");
                                    }
                                    MutexPopManager unused2 = MutexPopManager.sInstance;
                                    boolean unused3 = MutexPopManager.isMutexRunning = false;
                                    synchronized (MutexPopManager.sInstance.mRunnable) {
                                        MutexPopManager.sInstance.mCurrentRunningTask = null;
                                        MutexPopManager.sInstance.mRunnable.notify();
                                    }
                                    return;
                                }
                            }
                            if (MutexPopManager.DEBUG) {
                                Log.i(MutexPopManager.TAG, "真的要关闭时的，才发现又加入了任务或线程已经关闭了，因此(不能/不用)关闭线程啦！");
                            }
                            synchronized (MutexPopManager.sInstance.mRunnable) {
                            }
                        }
                    });
                } else {
                    synchronized (sInstance.mRunnable) {
                        sInstance.mRunnable.notify();
                    }
                }
            }
        }
    }
}
