package com.baidu.adp.lib.asyncTask;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.util.SparseIntArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
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
/* loaded from: classes.dex */
public class a implements Executor {
    private Handler mHandler;
    private HandlerThread sHandlerThread;
    private static a pI = null;
    private static final ThreadFactory sThreadFactory = new ThreadFactory() { // from class: com.baidu.adp.lib.asyncTask.a.1
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
    private final LinkedList<AbstractRunnableC0015a> mWaitingTasks = new LinkedList<>();
    private final LinkedList<AbstractRunnableC0015a> mRunningTasks = new LinkedList<>();
    private final LinkedList<AbstractRunnableC0015a> mTimeOutTasks = new LinkedList<>();

    a() {
        this.sHandlerThread = null;
        this.mHandler = null;
        this.sHandlerThread = new HandlerThread("BdAsyncTaskExecutor");
        this.sHandlerThread.start();
        this.mHandler = new Handler(this.sHandlerThread.getLooper()) { // from class: com.baidu.adp.lib.asyncTask.a.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 1) {
                    if (message.obj != null && (message.obj instanceof AbstractRunnableC0015a)) {
                        a.this.b((AbstractRunnableC0015a) message.obj);
                    }
                } else if (message.what == 2 && message.obj != null && (message.obj instanceof AbstractRunnableC0015a)) {
                    a.this.e((AbstractRunnableC0015a) message.obj);
                    if (BdBaseApplication.getInst().isDebugMode()) {
                    }
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

    public static a fq() {
        if (pI == null) {
            synchronized (a.class) {
                if (pI == null) {
                    pI = new a();
                }
            }
        }
        return pI;
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        if (runnable instanceof b) {
            AbstractRunnableC0015a abstractRunnableC0015a = new AbstractRunnableC0015a((b) runnable) { // from class: com.baidu.adp.lib.asyncTask.a.3
                /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [166=4] */
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
                            a.this.mHandler.sendMessageDelayed(a.this.mHandler.obtainMessage(2, this), 1L);
                        }
                    }
                }
            };
            if (abstractRunnableC0015a.isSelfExecute()) {
                new Thread(abstractRunnableC0015a).start();
            } else {
                a(abstractRunnableC0015a);
                e(null);
                if (BdBaseApplication.getInst().isDebugMode()) {
                }
            }
        }
    }

    private synchronized void a(AbstractRunnableC0015a abstractRunnableC0015a) {
        if (abstractRunnableC0015a != null) {
            int size = this.mWaitingTasks.size();
            int i = 0;
            while (i < size && this.mWaitingTasks.get(i).getPriority() >= abstractRunnableC0015a.getPriority()) {
                i++;
            }
            this.mWaitingTasks.add(i, abstractRunnableC0015a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(AbstractRunnableC0015a abstractRunnableC0015a) {
        AbstractRunnableC0015a poll;
        c(abstractRunnableC0015a);
        if (!abstractRunnableC0015a.isCancelled()) {
            abstractRunnableC0015a.setTimeout(true);
            this.mTimeOutTasks.add(abstractRunnableC0015a);
            if (this.mTimeOutTasks.size() > 242 && (poll = this.mTimeOutTasks.poll()) != null) {
                poll.cancelTask();
            }
        } else {
            BdLog.e("task TimeOut but it's cancelled()");
        }
        e(null);
    }

    private synchronized void c(AbstractRunnableC0015a abstractRunnableC0015a) {
        if (abstractRunnableC0015a != null) {
            if (abstractRunnableC0015a.IsTimeout()) {
                this.mTimeOutTasks.remove(abstractRunnableC0015a);
            } else {
                this.mRunningTasks.remove(abstractRunnableC0015a);
                this.mHandler.removeMessages(1, abstractRunnableC0015a);
                switch (abstractRunnableC0015a.getPriority()) {
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
                int parallelTag = abstractRunnableC0015a.getParallelTag();
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

    private synchronized void d(AbstractRunnableC0015a abstractRunnableC0015a) {
        if (abstractRunnableC0015a != null) {
            this.mRunningTasks.add(abstractRunnableC0015a);
            this.mWaitingTasks.remove(abstractRunnableC0015a);
            THREAD_POOL_EXECUTOR.execute(abstractRunnableC0015a);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, abstractRunnableC0015a), 180000L);
            switch (abstractRunnableC0015a.getPriority()) {
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
            int parallelTag = abstractRunnableC0015a.getParallelTag();
            if (parallelTag != 0) {
                this.mParallelMap.put(parallelTag, this.mParallelMap.get(parallelTag, 0) + 1);
            }
        }
    }

    private boolean a(int i, AbstractRunnableC0015a abstractRunnableC0015a) {
        if (abstractRunnableC0015a == null) {
            return false;
        }
        BdAsyncTaskParallel.BdAsyncTaskParallelType ft = abstractRunnableC0015a.ft();
        return ft == BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL ? i < 1 : ft == BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL ? i < 2 : ft == BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL ? i < 3 : ft == BdAsyncTaskParallel.BdAsyncTaskParallelType.FOUR_PARALLEL ? i < 4 : ft != BdAsyncTaskParallel.BdAsyncTaskParallelType.CUSTOM_PARALLEL || i < abstractRunnableC0015a.getExcuteNum();
    }

    protected synchronized void e(AbstractRunnableC0015a abstractRunnableC0015a) {
        c(abstractRunnableC0015a);
        int i = 0;
        while (true) {
            if (i < this.mWaitingTasks.size()) {
                AbstractRunnableC0015a abstractRunnableC0015a2 = this.mWaitingTasks.get(i);
                if (abstractRunnableC0015a2 != null) {
                    int parallelTag = abstractRunnableC0015a2.getParallelTag();
                    switch (abstractRunnableC0015a2.getPriority()) {
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
                                d(abstractRunnableC0015a2);
                                break;
                            }
                            break;
                    }
                    if (a(this.mParallelMap.get(parallelTag), abstractRunnableC0015a2)) {
                        d(abstractRunnableC0015a2);
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
        a(this.mRunningTasks, false, bdUniqueId, str);
        a(this.mTimeOutTasks, false, bdUniqueId, str);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        removeAllWaitingTask(bdUniqueId, null);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        a(this.mWaitingTasks, true, bdUniqueId, str);
    }

    private synchronized void a(LinkedList<AbstractRunnableC0015a> linkedList, boolean z, BdUniqueId bdUniqueId, String str) {
        if (bdUniqueId != null) {
            int id = bdUniqueId.getId();
            Iterator<AbstractRunnableC0015a> it = linkedList.iterator();
            while (it.hasNext()) {
                AbstractRunnableC0015a next = it.next();
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
    public synchronized void a(BdAsyncTask<?, ?, ?> bdAsyncTask) {
        Iterator<AbstractRunnableC0015a> it = this.mWaitingTasks.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AbstractRunnableC0015a next = it.next();
            if (next != null && next.fs() == bdAsyncTask) {
                break;
            }
        }
    }

    public int getTaskNum(String str, BdUniqueId bdUniqueId) {
        return a(this.mWaitingTasks, str, bdUniqueId) + a(this.mRunningTasks, str, bdUniqueId) + a(this.mTimeOutTasks, str, bdUniqueId);
    }

    private synchronized int a(LinkedList<AbstractRunnableC0015a> linkedList, String str, BdUniqueId bdUniqueId) {
        int i = 0;
        synchronized (this) {
            if (linkedList != null && bdUniqueId != null) {
                int id = bdUniqueId.getId();
                Iterator<AbstractRunnableC0015a> it = linkedList.iterator();
                while (it.hasNext()) {
                    AbstractRunnableC0015a next = it.next();
                    int tag = next.getTag();
                    i = (!((str != null && tag == id && str.equals(next.getKey())) || (str == null && id != 0 && tag == id)) || next.fs() == null || next.fs().isCancelled()) ? i : i + 1;
                }
            }
        }
        return i;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchTask(String str) {
        BdAsyncTask<?, ?, ?> a;
        a = a(this.mWaitingTasks, str);
        if (a == null) {
            a = a(this.mRunningTasks, str);
        }
        if (a == null) {
            a = a(this.mTimeOutTasks, str);
        }
        return a;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return searchAllTask(bdUniqueId, null);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.mWaitingTasks, bdUniqueId, str);
        if (a != null) {
            linkedList.addAll(a);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.mRunningTasks, bdUniqueId, str);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a3 = a(this.mTimeOutTasks, bdUniqueId, str);
        if (a3 != null) {
            linkedList.addAll(a3);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return a(this.mWaitingTasks, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.mWaitingTasks, bdUniqueId, (String) null);
        if (a != null) {
            linkedList.addAll(a);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return a(this.mRunningTasks, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
        r0 = r0.fs();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized BdAsyncTask<?, ?, ?> a(LinkedList<AbstractRunnableC0015a> linkedList, String str) {
        BdAsyncTask<?, ?, ?> bdAsyncTask;
        if (linkedList != null && str != null) {
            Iterator<AbstractRunnableC0015a> it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bdAsyncTask = null;
                    break;
                }
                AbstractRunnableC0015a next = it.next();
                String key = next.getKey();
                if (key != null && key.equals(str) && !next.fs().isCancelled()) {
                    break;
                }
            }
        } else {
            bdAsyncTask = null;
        }
        return bdAsyncTask;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> a(LinkedList<AbstractRunnableC0015a> linkedList, BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList2;
        if (linkedList == null || bdUniqueId == null) {
            linkedList2 = null;
        } else {
            int id = bdUniqueId.getId();
            LinkedList<BdAsyncTask<?, ?, ?>> linkedList3 = new LinkedList<>();
            Iterator<AbstractRunnableC0015a> it = linkedList.iterator();
            while (it.hasNext()) {
                AbstractRunnableC0015a next = it.next();
                int tag = next.getTag();
                String key = next.getKey();
                if ((str != null && tag == id && str.equals(key)) || (str == null && id != 0 && tag == id)) {
                    if (next.fs() != null && !next.fs().isCancelled()) {
                        linkedList3.add(next.fs());
                    }
                }
            }
            linkedList2 = linkedList3;
        }
        return linkedList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.adp.lib.asyncTask.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractRunnableC0015a implements Runnable {
        private b<?> pK;

        public AbstractRunnableC0015a(b<?> bVar) {
            this.pK = null;
            if (bVar == null || bVar.fs() == null) {
                throw new InvalidParameterException("parameter is null");
            }
            this.pK = bVar;
        }

        public void runTask() {
            try {
                this.pK.run();
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }

        public void cancelTask() {
            this.pK.cancelTask();
        }

        public boolean isCancelled() {
            return this.pK.isCancelled();
        }

        public BdAsyncTask<?, ?, ?> fs() {
            return this.pK.fs();
        }

        public int getPriority() {
            return this.pK.fs().getPriority();
        }

        public void setTimeout(boolean z) {
            this.pK.fs().setTimeout(z);
        }

        public boolean IsTimeout() {
            return this.pK.fs().isTimeout();
        }

        public int getTag() {
            return this.pK.fs().getTag();
        }

        public int getParallelTag() {
            if (this.pK.fs().getParallel() != null) {
                return this.pK.fs().getParallel().getTag();
            }
            return 0;
        }

        public String getKey() {
            return this.pK.fs().getKey();
        }

        public BdAsyncTaskParallel.BdAsyncTaskParallelType ft() {
            return this.pK.fs().getParallel() != null ? this.pK.fs().getParallel().fu() : BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
        }

        public int getExcuteNum() {
            if (this.pK.fs().getParallel() != null) {
                return this.pK.fs().getParallel().getExecuteNum();
            }
            return 1;
        }

        public boolean isSelfExecute() {
            return this.pK.fs().isSelfExecute();
        }
    }
}
