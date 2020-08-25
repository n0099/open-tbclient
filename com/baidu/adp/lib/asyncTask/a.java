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
    private static a Ka = null;
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
    private final LinkedList<AbstractRunnableC0017a> mWaitingTasks = new LinkedList<>();
    private final LinkedList<AbstractRunnableC0017a> mRunningTasks = new LinkedList<>();
    private final LinkedList<AbstractRunnableC0017a> mTimeOutTasks = new LinkedList<>();

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
                    if (message.obj != null && (message.obj instanceof AbstractRunnableC0017a)) {
                        a.this.b((AbstractRunnableC0017a) message.obj);
                    }
                } else if (message.what == 2 && message.obj != null && (message.obj instanceof AbstractRunnableC0017a)) {
                    a.this.e((AbstractRunnableC0017a) message.obj);
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

    public static a lM() {
        if (Ka == null) {
            synchronized (a.class) {
                if (Ka == null) {
                    Ka = new a();
                }
            }
        }
        return Ka;
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        if (runnable instanceof b) {
            AbstractRunnableC0017a abstractRunnableC0017a = new AbstractRunnableC0017a((b) runnable) { // from class: com.baidu.adp.lib.asyncTask.a.3
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
            if (abstractRunnableC0017a.isSelfExecute()) {
                new Thread(abstractRunnableC0017a).start();
            } else {
                a(abstractRunnableC0017a);
                e(null);
                if (BdBaseApplication.getInst().isDebugMode()) {
                }
            }
        }
    }

    private synchronized void a(AbstractRunnableC0017a abstractRunnableC0017a) {
        if (abstractRunnableC0017a != null) {
            int size = this.mWaitingTasks.size();
            int i = 0;
            while (i < size && this.mWaitingTasks.get(i).getPriority() >= abstractRunnableC0017a.getPriority()) {
                i++;
            }
            this.mWaitingTasks.add(i, abstractRunnableC0017a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(AbstractRunnableC0017a abstractRunnableC0017a) {
        AbstractRunnableC0017a poll;
        c(abstractRunnableC0017a);
        if (!abstractRunnableC0017a.isCancelled()) {
            abstractRunnableC0017a.setTimeout(true);
            this.mTimeOutTasks.add(abstractRunnableC0017a);
            if (this.mTimeOutTasks.size() > 242 && (poll = this.mTimeOutTasks.poll()) != null) {
                poll.cancelTask();
            }
        } else {
            BdLog.e("task TimeOut but it's cancelled()");
        }
        e(null);
    }

    private synchronized void c(AbstractRunnableC0017a abstractRunnableC0017a) {
        if (abstractRunnableC0017a != null) {
            if (abstractRunnableC0017a.IsTimeout()) {
                this.mTimeOutTasks.remove(abstractRunnableC0017a);
            } else {
                this.mRunningTasks.remove(abstractRunnableC0017a);
                this.mHandler.removeMessages(1, abstractRunnableC0017a);
                switch (abstractRunnableC0017a.getPriority()) {
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
                int parallelTag = abstractRunnableC0017a.getParallelTag();
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

    private synchronized void d(AbstractRunnableC0017a abstractRunnableC0017a) {
        if (abstractRunnableC0017a != null) {
            this.mRunningTasks.add(abstractRunnableC0017a);
            this.mWaitingTasks.remove(abstractRunnableC0017a);
            THREAD_POOL_EXECUTOR.execute(abstractRunnableC0017a);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, abstractRunnableC0017a), 180000L);
            switch (abstractRunnableC0017a.getPriority()) {
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
            int parallelTag = abstractRunnableC0017a.getParallelTag();
            if (parallelTag != 0) {
                this.mParallelMap.put(parallelTag, this.mParallelMap.get(parallelTag, 0) + 1);
            }
        }
    }

    private boolean a(int i, AbstractRunnableC0017a abstractRunnableC0017a) {
        if (abstractRunnableC0017a == null) {
            return false;
        }
        BdAsyncTaskParallel.BdAsyncTaskParallelType lO = abstractRunnableC0017a.lO();
        return lO == BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL ? i < 1 : lO == BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL ? i < 2 : lO == BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL ? i < 3 : lO == BdAsyncTaskParallel.BdAsyncTaskParallelType.FOUR_PARALLEL ? i < 4 : lO != BdAsyncTaskParallel.BdAsyncTaskParallelType.CUSTOM_PARALLEL || i < abstractRunnableC0017a.getExcuteNum();
    }

    protected synchronized void e(AbstractRunnableC0017a abstractRunnableC0017a) {
        c(abstractRunnableC0017a);
        int i = 0;
        while (true) {
            if (i < this.mWaitingTasks.size()) {
                AbstractRunnableC0017a abstractRunnableC0017a2 = this.mWaitingTasks.get(i);
                if (abstractRunnableC0017a2 != null) {
                    int parallelTag = abstractRunnableC0017a2.getParallelTag();
                    switch (abstractRunnableC0017a2.getPriority()) {
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
                                d(abstractRunnableC0017a2);
                                break;
                            }
                            break;
                    }
                    if (a(this.mParallelMap.get(parallelTag), abstractRunnableC0017a2)) {
                        d(abstractRunnableC0017a2);
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

    private synchronized void a(LinkedList<AbstractRunnableC0017a> linkedList, boolean z, BdUniqueId bdUniqueId, String str) {
        if (bdUniqueId != null) {
            int id = bdUniqueId.getId();
            Iterator<AbstractRunnableC0017a> it = linkedList.iterator();
            while (it.hasNext()) {
                AbstractRunnableC0017a next = it.next();
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
        Iterator<AbstractRunnableC0017a> it = this.mWaitingTasks.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AbstractRunnableC0017a next = it.next();
            if (next != null && next.lN() == bdAsyncTask) {
                break;
            }
        }
    }

    public int getTaskNum(String str, BdUniqueId bdUniqueId) {
        return a(this.mWaitingTasks, str, bdUniqueId) + a(this.mRunningTasks, str, bdUniqueId) + a(this.mTimeOutTasks, str, bdUniqueId);
    }

    private synchronized int a(LinkedList<AbstractRunnableC0017a> linkedList, String str, BdUniqueId bdUniqueId) {
        int i = 0;
        synchronized (this) {
            if (linkedList != null && bdUniqueId != null) {
                int id = bdUniqueId.getId();
                Iterator<AbstractRunnableC0017a> it = linkedList.iterator();
                while (it.hasNext()) {
                    AbstractRunnableC0017a next = it.next();
                    int tag = next.getTag();
                    i = (!((str != null && tag == id && str.equals(next.getKey())) || (str == null && id != 0 && tag == id)) || next.lN() == null || next.lN().isCancelled()) ? i : i + 1;
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
        r0 = r0.lN();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized BdAsyncTask<?, ?, ?> a(LinkedList<AbstractRunnableC0017a> linkedList, String str) {
        BdAsyncTask<?, ?, ?> bdAsyncTask;
        if (linkedList != null && str != null) {
            Iterator<AbstractRunnableC0017a> it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bdAsyncTask = null;
                    break;
                }
                AbstractRunnableC0017a next = it.next();
                String key = next.getKey();
                if (key != null && key.equals(str) && !next.lN().isCancelled()) {
                    break;
                }
            }
        } else {
            bdAsyncTask = null;
        }
        return bdAsyncTask;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> a(LinkedList<AbstractRunnableC0017a> linkedList, BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList2;
        if (linkedList == null || bdUniqueId == null) {
            linkedList2 = null;
        } else {
            int id = bdUniqueId.getId();
            LinkedList<BdAsyncTask<?, ?, ?>> linkedList3 = new LinkedList<>();
            Iterator<AbstractRunnableC0017a> it = linkedList.iterator();
            while (it.hasNext()) {
                AbstractRunnableC0017a next = it.next();
                int tag = next.getTag();
                String key = next.getKey();
                if ((str != null && tag == id && str.equals(key)) || (str == null && id != 0 && tag == id)) {
                    if (next.lN() != null && !next.lN().isCancelled()) {
                        linkedList3.add(next.lN());
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
    public static abstract class AbstractRunnableC0017a implements Runnable {
        private b<?> Kc;

        public AbstractRunnableC0017a(b<?> bVar) {
            this.Kc = null;
            if (bVar == null || bVar.lN() == null) {
                throw new InvalidParameterException("parameter is null");
            }
            this.Kc = bVar;
        }

        public void runTask() {
            try {
                this.Kc.run();
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }

        public void cancelTask() {
            this.Kc.cancelTask();
        }

        public boolean isCancelled() {
            return this.Kc.isCancelled();
        }

        public BdAsyncTask<?, ?, ?> lN() {
            return this.Kc.lN();
        }

        public int getPriority() {
            return this.Kc.lN().getPriority();
        }

        public void setTimeout(boolean z) {
            this.Kc.lN().setTimeout(z);
        }

        public boolean IsTimeout() {
            return this.Kc.lN().isTimeout();
        }

        public int getTag() {
            return this.Kc.lN().getTag();
        }

        public int getParallelTag() {
            if (this.Kc.lN().getParallel() != null) {
                return this.Kc.lN().getParallel().getTag();
            }
            return 0;
        }

        public String getKey() {
            return this.Kc.lN().getKey();
        }

        public BdAsyncTaskParallel.BdAsyncTaskParallelType lO() {
            return this.Kc.lN().getParallel() != null ? this.Kc.lN().getParallel().lP() : BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
        }

        public int getExcuteNum() {
            if (this.Kc.lN().getParallel() != null) {
                return this.Kc.lN().getParallel().getExecuteNum();
            }
            return 1;
        }

        public boolean isSelfExecute() {
            return this.Kc.lN().isSelfExecute();
        }
    }
}
