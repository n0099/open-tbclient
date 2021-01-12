package com.baidu.live.adp.lib.asynctask;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.util.SparseIntArray;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.lib.asynctask.BdAsyncTaskParallel;
import com.baidu.live.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public class BdAsyncTaskExecutor implements Executor {
    private static final int CORE_POOL_SIZE = 7;
    private static final int KEEP_ALIVE = 30;
    private static final int MAXIMUM_POOL_SIZE = 256;
    private static final int TASK_MAX_TIME = 180000;
    private static final int TASK_MAX_TIME_ID = 1;
    private static final int TASK_RUN_NEXT_ID = 2;
    private Handler mHandler;
    private HandlerThread sHandlerThread;
    private static volatile BdAsyncTaskExecutor sInstance = null;
    private static final ThreadFactory sThreadFactory = new ThreadFactory() { // from class: com.baidu.live.adp.lib.asynctask.BdAsyncTaskExecutor.1
        private final AtomicInteger mCount = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            String str = "BdAsyncTask #" + String.valueOf(this.mCount.getAndIncrement());
            BdLog.i(str);
            return new Thread(runnable, str);
        }
    };
    private static final BlockingQueue<Runnable> sPoolWorkQueue = new SynchronousQueue();
    public static final Executor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(7, 256, 30, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory, new ThreadPoolExecutor.DiscardPolicy());
    private volatile int mRunningSuperHightTaskNum = 0;
    private volatile int mRunningHightTaskNum = 0;
    private volatile int mRunningMiddleTaskNum = 0;
    private volatile int mRunningLowTaskNum = 0;
    private final SparseIntArray mParallelMap = new SparseIntArray();
    private final LinkedList<BdAsyncTaskRunnable> mWaitingTasks = new LinkedList<>();
    private final LinkedList<BdAsyncTaskRunnable> mRunningTasks = new LinkedList<>();
    private final LinkedList<BdAsyncTaskRunnable> mTimeOutTasks = new LinkedList<>();

    BdAsyncTaskExecutor() {
        this.sHandlerThread = null;
        this.mHandler = null;
        this.sHandlerThread = new HandlerThread("BdAsyncTaskExecutor");
        this.sHandlerThread.start();
        this.mHandler = new Handler(this.sHandlerThread.getLooper()) { // from class: com.baidu.live.adp.lib.asynctask.BdAsyncTaskExecutor.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 1) {
                    if (message.obj != null && (message.obj instanceof BdAsyncTaskRunnable)) {
                        BdAsyncTaskExecutor.this.taskTimeOut((BdAsyncTaskRunnable) message.obj);
                    }
                } else if (message.what == 2 && message.obj != null && (message.obj instanceof BdAsyncTaskRunnable)) {
                    BdAsyncTaskExecutor.this.scheduleNext((BdAsyncTaskRunnable) message.obj);
                }
            }
        };
    }

    public String toString() {
        return "mWaitingTasks = " + this.mWaitingTasks.size() + " mRunningTasks = " + this.mRunningTasks.size() + " mTimeOutTasks = " + this.mTimeOutTasks.size();
    }

    public String toLogString() {
        return this.mWaitingTasks.size() + "/" + this.mRunningTasks.size() + "/" + this.mTimeOutTasks.size();
    }

    public static void clearInstance() {
        sInstance = null;
    }

    public static BdAsyncTaskExecutor getInstance() {
        if (sInstance == null) {
            synchronized (BdAsyncTaskExecutor.class) {
                if (sInstance == null) {
                    sInstance = new BdAsyncTaskExecutor();
                }
            }
        }
        return sInstance;
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        if (runnable instanceof BdAsyncTaskFuture) {
            BdAsyncTaskRunnable bdAsyncTaskRunnable = new BdAsyncTaskRunnable((BdAsyncTaskFuture) runnable) { // from class: com.baidu.live.adp.lib.asynctask.BdAsyncTaskExecutor.3
                /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [163=4] */
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                            if (getPriority() == 4) {
                                Process.setThreadPriority(-2);
                            } else if (getPriority() == 3) {
                                Process.setThreadPriority(-1);
                            } else if (getPriority() == 2) {
                                Process.setThreadPriority(0);
                            } else {
                                Process.setThreadPriority(10);
                            }
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        }
                        runTask();
                    } finally {
                        if (!isSelfExecute()) {
                            BdAsyncTaskExecutor.this.mHandler.sendMessageDelayed(BdAsyncTaskExecutor.this.mHandler.obtainMessage(2, this), 1L);
                        }
                    }
                }
            };
            if (bdAsyncTaskRunnable.isSelfExecute()) {
                new Thread(bdAsyncTaskRunnable).start();
            } else {
                insertTask(bdAsyncTaskRunnable);
                scheduleNext(null);
            }
        }
    }

    private synchronized void insertTask(BdAsyncTaskRunnable bdAsyncTaskRunnable) {
        if (bdAsyncTaskRunnable != null) {
            int size = this.mWaitingTasks.size();
            int i = 0;
            while (i < size && this.mWaitingTasks.get(i).getPriority() >= bdAsyncTaskRunnable.getPriority()) {
                i++;
            }
            this.mWaitingTasks.add(i, bdAsyncTaskRunnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void taskTimeOut(BdAsyncTaskRunnable bdAsyncTaskRunnable) {
        BdAsyncTaskRunnable poll;
        removeRunningTask(bdAsyncTaskRunnable);
        if (!bdAsyncTaskRunnable.isCancelled()) {
            bdAsyncTaskRunnable.setTimeout(true);
            this.mTimeOutTasks.add(bdAsyncTaskRunnable);
            if (this.mTimeOutTasks.size() > 242 && (poll = this.mTimeOutTasks.poll()) != null) {
                poll.cancelTask();
            }
        } else {
            BdLog.e("task TimeOut but it's cancelled()");
        }
        scheduleNext(null);
    }

    private synchronized void removeRunningTask(BdAsyncTaskRunnable bdAsyncTaskRunnable) {
        if (bdAsyncTaskRunnable != null) {
            if (bdAsyncTaskRunnable.IsTimeout()) {
                this.mTimeOutTasks.remove(bdAsyncTaskRunnable);
            } else {
                this.mRunningTasks.remove(bdAsyncTaskRunnable);
                this.mHandler.removeMessages(1, bdAsyncTaskRunnable);
                switch (bdAsyncTaskRunnable.getPriority()) {
                    case 1:
                        this.mRunningLowTaskNum--;
                        break;
                    case 2:
                        this.mRunningMiddleTaskNum--;
                        break;
                    case 3:
                        this.mRunningHightTaskNum--;
                        break;
                    case 4:
                        this.mRunningSuperHightTaskNum--;
                        break;
                }
                int parallelTag = bdAsyncTaskRunnable.getParallelTag();
                if (parallelTag != 0) {
                    int i = this.mParallelMap.get(parallelTag) - 1;
                    if (i <= 0) {
                        this.mParallelMap.delete(parallelTag);
                    } else {
                        this.mParallelMap.put(parallelTag, i);
                    }
                    if (i < 0) {
                        BdLog.e("removeTask error < 0");
                    }
                }
            }
        }
    }

    private synchronized void executeTask(BdAsyncTaskRunnable bdAsyncTaskRunnable) {
        if (bdAsyncTaskRunnable != null) {
            this.mRunningTasks.add(bdAsyncTaskRunnable);
            this.mWaitingTasks.remove(bdAsyncTaskRunnable);
            THREAD_POOL_EXECUTOR.execute(bdAsyncTaskRunnable);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, bdAsyncTaskRunnable), 180000L);
            switch (bdAsyncTaskRunnable.getPriority()) {
                case 1:
                    this.mRunningLowTaskNum++;
                    break;
                case 2:
                    this.mRunningMiddleTaskNum++;
                    break;
                case 3:
                    this.mRunningHightTaskNum++;
                    break;
                case 4:
                    this.mRunningSuperHightTaskNum++;
                    if (this.mRunningSuperHightTaskNum >= 7) {
                        BdLog.e("SuperHight Task too much num = " + this.mRunningSuperHightTaskNum);
                        break;
                    }
                    break;
            }
            int parallelTag = bdAsyncTaskRunnable.getParallelTag();
            if (parallelTag != 0) {
                this.mParallelMap.put(parallelTag, this.mParallelMap.get(parallelTag, 0) + 1);
            }
        }
    }

    private boolean canParallelExecute(int i, BdAsyncTaskRunnable bdAsyncTaskRunnable) {
        if (bdAsyncTaskRunnable == null) {
            return false;
        }
        BdAsyncTaskParallel.BdAsyncTaskParallelType parallelType = bdAsyncTaskRunnable.getParallelType();
        return parallelType == BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL ? i < 1 : parallelType == BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL ? i < 2 : parallelType == BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL ? i < 3 : parallelType == BdAsyncTaskParallel.BdAsyncTaskParallelType.FOUR_PARALLEL ? i < 4 : parallelType != BdAsyncTaskParallel.BdAsyncTaskParallelType.CUSTOM_PARALLEL || i < bdAsyncTaskRunnable.getExcuteNum();
    }

    protected synchronized void scheduleNext(BdAsyncTaskRunnable bdAsyncTaskRunnable) {
        removeRunningTask(bdAsyncTaskRunnable);
        int i = 0;
        while (true) {
            if (i < this.mWaitingTasks.size()) {
                BdAsyncTaskRunnable bdAsyncTaskRunnable2 = this.mWaitingTasks.get(i);
                if (bdAsyncTaskRunnable2 != null) {
                    int parallelTag = bdAsyncTaskRunnable2.getParallelTag();
                    switch (bdAsyncTaskRunnable2.getPriority()) {
                        case 1:
                            if (this.mRunningHightTaskNum + this.mRunningMiddleTaskNum + this.mRunningLowTaskNum >= 5) {
                                break;
                            }
                            break;
                        case 2:
                            if (this.mRunningHightTaskNum + this.mRunningMiddleTaskNum + this.mRunningLowTaskNum >= 6) {
                                break;
                            }
                            break;
                        case 3:
                            if (this.mRunningHightTaskNum + this.mRunningMiddleTaskNum + this.mRunningLowTaskNum >= 7) {
                                break;
                            }
                            break;
                        case 4:
                            if (parallelTag == 0) {
                                executeTask(bdAsyncTaskRunnable2);
                                break;
                            }
                            break;
                    }
                    if (canParallelExecute(this.mParallelMap.get(parallelTag), bdAsyncTaskRunnable2)) {
                        executeTask(bdAsyncTaskRunnable2);
                    }
                }
                i++;
            }
        }
    }

    public synchronized void removeAllTask(BdUniqueId bdUniqueId) {
        removeAllTask(bdUniqueId, null);
    }

    public synchronized void removeAllTask(BdUniqueId bdUniqueId, String str) {
        removeAllWaitingTask(bdUniqueId, str);
        removeTask(this.mRunningTasks, false, bdUniqueId, str);
        removeTask(this.mTimeOutTasks, false, bdUniqueId, str);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        removeAllWaitingTask(bdUniqueId, null);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        removeTask(this.mWaitingTasks, true, bdUniqueId, str);
    }

    private synchronized void removeTask(LinkedList<BdAsyncTaskRunnable> linkedList, boolean z, BdUniqueId bdUniqueId, String str) {
        if (bdUniqueId != null) {
            int id = bdUniqueId.getId();
            Iterator<BdAsyncTaskRunnable> it = linkedList.iterator();
            while (it.hasNext()) {
                BdAsyncTaskRunnable next = it.next();
                int tag = next.getTag();
                String key = next.getKey();
                if ((str != null && tag == id && str.equals(key)) || (str == null && id != 0 && tag == id)) {
                    if (z) {
                        it.remove();
                    }
                    next.cancelTask();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
        r1.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void removeWaitingTask(BdAsyncTask<?, ?, ?> bdAsyncTask) {
        Iterator<BdAsyncTaskRunnable> it = this.mWaitingTasks.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            BdAsyncTaskRunnable next = it.next();
            if (next != null && next.getTask() == bdAsyncTask) {
                break;
            }
        }
    }

    public int getTaskNum(BdUniqueId bdUniqueId) {
        return getTaskNum(null, bdUniqueId);
    }

    public int getTaskNum(String str, BdUniqueId bdUniqueId) {
        return getQueueTaskNum(this.mWaitingTasks, str, bdUniqueId) + getQueueTaskNum(this.mRunningTasks, str, bdUniqueId) + getQueueTaskNum(this.mTimeOutTasks, str, bdUniqueId);
    }

    private synchronized int getQueueTaskNum(LinkedList<BdAsyncTaskRunnable> linkedList, String str, BdUniqueId bdUniqueId) {
        int i = 0;
        synchronized (this) {
            if (linkedList != null && bdUniqueId != null) {
                int id = bdUniqueId.getId();
                Iterator<BdAsyncTaskRunnable> it = linkedList.iterator();
                while (it.hasNext()) {
                    BdAsyncTaskRunnable next = it.next();
                    int tag = next.getTag();
                    i = (!((str != null && tag == id && str.equals(next.getKey())) || (str == null && id != 0 && tag == id)) || next.getTask() == null || next.getTask().isCancelled()) ? i : i + 1;
                }
            }
        }
        return i;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchTask(String str) {
        BdAsyncTask<?, ?, ?> searchTask;
        searchTask = searchTask(this.mWaitingTasks, str);
        if (searchTask == null) {
            searchTask = searchTask(this.mRunningTasks, str);
        }
        if (searchTask == null) {
            searchTask = searchTask(this.mTimeOutTasks, str);
        }
        return searchTask;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return searchAllTask(bdUniqueId, null);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = searchAllTask(this.mWaitingTasks, bdUniqueId, str);
        if (searchAllTask != null) {
            linkedList.addAll(searchAllTask);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask2 = searchAllTask(this.mRunningTasks, bdUniqueId, str);
        if (searchAllTask2 != null) {
            linkedList.addAll(searchAllTask2);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask3 = searchAllTask(this.mTimeOutTasks, bdUniqueId, str);
        if (searchAllTask3 != null) {
            linkedList.addAll(searchAllTask3);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return searchTask(this.mWaitingTasks, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = searchAllTask(this.mWaitingTasks, bdUniqueId, null);
        if (searchAllTask != null) {
            linkedList.addAll(searchAllTask);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return searchTask(this.mRunningTasks, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
        r0 = r0.getTask();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized BdAsyncTask<?, ?, ?> searchTask(LinkedList<BdAsyncTaskRunnable> linkedList, String str) {
        BdAsyncTask<?, ?, ?> bdAsyncTask;
        if (linkedList != null && str != null) {
            Iterator<BdAsyncTaskRunnable> it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bdAsyncTask = null;
                    break;
                }
                BdAsyncTaskRunnable next = it.next();
                String key = next.getKey();
                if (key != null && key.equals(str) && !next.getTask().isCancelled()) {
                    break;
                }
            }
        } else {
            bdAsyncTask = null;
        }
        return bdAsyncTask;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(LinkedList<BdAsyncTaskRunnable> linkedList, BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList2;
        if (linkedList == null || bdUniqueId == null) {
            linkedList2 = null;
        } else {
            int id = bdUniqueId.getId();
            LinkedList<BdAsyncTask<?, ?, ?>> linkedList3 = new LinkedList<>();
            Iterator<BdAsyncTaskRunnable> it = linkedList.iterator();
            while (it.hasNext()) {
                BdAsyncTaskRunnable next = it.next();
                int tag = next.getTag();
                String key = next.getKey();
                if ((str != null && tag == id && str.equals(key)) || (str == null && id != 0 && tag == id)) {
                    if (next.getTask() != null && !next.getTask().isCancelled()) {
                        linkedList3.add(next.getTask());
                    }
                }
            }
            linkedList2 = linkedList3;
        }
        return linkedList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static abstract class BdAsyncTaskRunnable implements Runnable {
        private BdAsyncTaskFuture<?> mBdAsyncTaskFuture;

        public BdAsyncTaskRunnable(BdAsyncTaskFuture<?> bdAsyncTaskFuture) {
            this.mBdAsyncTaskFuture = null;
            if (bdAsyncTaskFuture == null || bdAsyncTaskFuture.getTask() == null) {
                throw new InvalidParameterException("parameter is null");
            }
            this.mBdAsyncTaskFuture = bdAsyncTaskFuture;
        }

        public void runTask() {
            try {
                this.mBdAsyncTaskFuture.run();
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }

        public void cancelTask() {
            this.mBdAsyncTaskFuture.cancelTask();
        }

        public boolean isCancelled() {
            return this.mBdAsyncTaskFuture.isCancelled();
        }

        public BdAsyncTask<?, ?, ?> getTask() {
            return this.mBdAsyncTaskFuture.getTask();
        }

        public int getPriority() {
            return this.mBdAsyncTaskFuture.getTask().getPriority();
        }

        public void setTimeout(boolean z) {
            this.mBdAsyncTaskFuture.getTask().setTimeout(z);
        }

        public boolean IsTimeout() {
            return this.mBdAsyncTaskFuture.getTask().isTimeout();
        }

        public int getTag() {
            return this.mBdAsyncTaskFuture.getTask().getTag();
        }

        public int getParallelTag() {
            if (this.mBdAsyncTaskFuture.getTask().getParallel() != null) {
                return this.mBdAsyncTaskFuture.getTask().getParallel().getTag();
            }
            return 0;
        }

        public String getKey() {
            return this.mBdAsyncTaskFuture.getTask().getKey();
        }

        public BdAsyncTaskParallel.BdAsyncTaskParallelType getParallelType() {
            return this.mBdAsyncTaskFuture.getTask().getParallel() != null ? this.mBdAsyncTaskFuture.getTask().getParallel().getType() : BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
        }

        public int getExcuteNum() {
            if (this.mBdAsyncTaskFuture.getTask().getParallel() != null) {
                return this.mBdAsyncTaskFuture.getTask().getParallel().getExecuteNum();
            }
            return 1;
        }

        public boolean isSelfExecute() {
            return this.mBdAsyncTaskFuture.getTask().isSelfExecute();
        }
    }
}
