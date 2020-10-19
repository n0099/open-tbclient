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
    private static a Ky = null;
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
    private final LinkedList<AbstractRunnableC0019a> mWaitingTasks = new LinkedList<>();
    private final LinkedList<AbstractRunnableC0019a> mRunningTasks = new LinkedList<>();
    private final LinkedList<AbstractRunnableC0019a> mTimeOutTasks = new LinkedList<>();

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
                    if (message.obj != null && (message.obj instanceof AbstractRunnableC0019a)) {
                        a.this.b((AbstractRunnableC0019a) message.obj);
                    }
                } else if (message.what == 2 && message.obj != null && (message.obj instanceof AbstractRunnableC0019a)) {
                    a.this.e((AbstractRunnableC0019a) message.obj);
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

    public static a lR() {
        if (Ky == null) {
            synchronized (a.class) {
                if (Ky == null) {
                    Ky = new a();
                }
            }
        }
        return Ky;
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        if (runnable instanceof b) {
            AbstractRunnableC0019a abstractRunnableC0019a = new AbstractRunnableC0019a((b) runnable) { // from class: com.baidu.adp.lib.asyncTask.a.3
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
            if (abstractRunnableC0019a.isSelfExecute()) {
                new Thread(abstractRunnableC0019a).start();
            } else {
                a(abstractRunnableC0019a);
                e(null);
                if (BdBaseApplication.getInst().isDebugMode()) {
                }
            }
        }
    }

    private synchronized void a(AbstractRunnableC0019a abstractRunnableC0019a) {
        if (abstractRunnableC0019a != null) {
            int size = this.mWaitingTasks.size();
            int i = 0;
            while (i < size && this.mWaitingTasks.get(i).getPriority() >= abstractRunnableC0019a.getPriority()) {
                i++;
            }
            this.mWaitingTasks.add(i, abstractRunnableC0019a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(AbstractRunnableC0019a abstractRunnableC0019a) {
        AbstractRunnableC0019a poll;
        c(abstractRunnableC0019a);
        if (!abstractRunnableC0019a.isCancelled()) {
            abstractRunnableC0019a.setTimeout(true);
            this.mTimeOutTasks.add(abstractRunnableC0019a);
            if (this.mTimeOutTasks.size() > 242 && (poll = this.mTimeOutTasks.poll()) != null) {
                poll.cancelTask();
            }
        } else {
            BdLog.e("task TimeOut but it's cancelled()");
        }
        e(null);
    }

    private synchronized void c(AbstractRunnableC0019a abstractRunnableC0019a) {
        if (abstractRunnableC0019a != null) {
            if (abstractRunnableC0019a.IsTimeout()) {
                this.mTimeOutTasks.remove(abstractRunnableC0019a);
            } else {
                this.mRunningTasks.remove(abstractRunnableC0019a);
                this.mHandler.removeMessages(1, abstractRunnableC0019a);
                switch (abstractRunnableC0019a.getPriority()) {
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
                int parallelTag = abstractRunnableC0019a.getParallelTag();
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

    private synchronized void d(AbstractRunnableC0019a abstractRunnableC0019a) {
        if (abstractRunnableC0019a != null) {
            this.mRunningTasks.add(abstractRunnableC0019a);
            this.mWaitingTasks.remove(abstractRunnableC0019a);
            THREAD_POOL_EXECUTOR.execute(abstractRunnableC0019a);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, abstractRunnableC0019a), 180000L);
            switch (abstractRunnableC0019a.getPriority()) {
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
            int parallelTag = abstractRunnableC0019a.getParallelTag();
            if (parallelTag != 0) {
                this.mParallelMap.put(parallelTag, this.mParallelMap.get(parallelTag, 0) + 1);
            }
        }
    }

    private boolean a(int i, AbstractRunnableC0019a abstractRunnableC0019a) {
        if (abstractRunnableC0019a == null) {
            return false;
        }
        BdAsyncTaskParallel.BdAsyncTaskParallelType lT = abstractRunnableC0019a.lT();
        return lT == BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL ? i < 1 : lT == BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL ? i < 2 : lT == BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL ? i < 3 : lT == BdAsyncTaskParallel.BdAsyncTaskParallelType.FOUR_PARALLEL ? i < 4 : lT != BdAsyncTaskParallel.BdAsyncTaskParallelType.CUSTOM_PARALLEL || i < abstractRunnableC0019a.getExcuteNum();
    }

    protected synchronized void e(AbstractRunnableC0019a abstractRunnableC0019a) {
        c(abstractRunnableC0019a);
        int i = 0;
        while (true) {
            if (i < this.mWaitingTasks.size()) {
                AbstractRunnableC0019a abstractRunnableC0019a2 = this.mWaitingTasks.get(i);
                if (abstractRunnableC0019a2 != null) {
                    int parallelTag = abstractRunnableC0019a2.getParallelTag();
                    switch (abstractRunnableC0019a2.getPriority()) {
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
                                d(abstractRunnableC0019a2);
                                break;
                            }
                            break;
                    }
                    if (a(this.mParallelMap.get(parallelTag), abstractRunnableC0019a2)) {
                        d(abstractRunnableC0019a2);
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

    private synchronized void a(LinkedList<AbstractRunnableC0019a> linkedList, boolean z, BdUniqueId bdUniqueId, String str) {
        if (bdUniqueId != null) {
            int id = bdUniqueId.getId();
            Iterator<AbstractRunnableC0019a> it = linkedList.iterator();
            while (it.hasNext()) {
                AbstractRunnableC0019a next = it.next();
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
        Iterator<AbstractRunnableC0019a> it = this.mWaitingTasks.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AbstractRunnableC0019a next = it.next();
            if (next != null && next.lS() == bdAsyncTask) {
                break;
            }
        }
    }

    public int getTaskNum(String str, BdUniqueId bdUniqueId) {
        return a(this.mWaitingTasks, str, bdUniqueId) + a(this.mRunningTasks, str, bdUniqueId) + a(this.mTimeOutTasks, str, bdUniqueId);
    }

    private synchronized int a(LinkedList<AbstractRunnableC0019a> linkedList, String str, BdUniqueId bdUniqueId) {
        int i = 0;
        synchronized (this) {
            if (linkedList != null && bdUniqueId != null) {
                int id = bdUniqueId.getId();
                Iterator<AbstractRunnableC0019a> it = linkedList.iterator();
                while (it.hasNext()) {
                    AbstractRunnableC0019a next = it.next();
                    int tag = next.getTag();
                    i = (!((str != null && tag == id && str.equals(next.getKey())) || (str == null && id != 0 && tag == id)) || next.lS() == null || next.lS().isCancelled()) ? i : i + 1;
                }
            }
        }
        return i;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchTask(String str) {
        BdAsyncTask<?, ?, ?> a2;
        a2 = a(this.mWaitingTasks, str);
        if (a2 == null) {
            a2 = a(this.mRunningTasks, str);
        }
        if (a2 == null) {
            a2 = a(this.mTimeOutTasks, str);
        }
        return a2;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return searchAllTask(bdUniqueId, null);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.mWaitingTasks, bdUniqueId, str);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a3 = a(this.mRunningTasks, bdUniqueId, str);
        if (a3 != null) {
            linkedList.addAll(a3);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a4 = a(this.mTimeOutTasks, bdUniqueId, str);
        if (a4 != null) {
            linkedList.addAll(a4);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return a(this.mWaitingTasks, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.mWaitingTasks, bdUniqueId, (String) null);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return a(this.mRunningTasks, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
        r0 = r0.lS();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized BdAsyncTask<?, ?, ?> a(LinkedList<AbstractRunnableC0019a> linkedList, String str) {
        BdAsyncTask<?, ?, ?> bdAsyncTask;
        if (linkedList != null && str != null) {
            Iterator<AbstractRunnableC0019a> it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bdAsyncTask = null;
                    break;
                }
                AbstractRunnableC0019a next = it.next();
                String key = next.getKey();
                if (key != null && key.equals(str) && !next.lS().isCancelled()) {
                    break;
                }
            }
        } else {
            bdAsyncTask = null;
        }
        return bdAsyncTask;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> a(LinkedList<AbstractRunnableC0019a> linkedList, BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList2;
        if (linkedList == null || bdUniqueId == null) {
            linkedList2 = null;
        } else {
            int id = bdUniqueId.getId();
            LinkedList<BdAsyncTask<?, ?, ?>> linkedList3 = new LinkedList<>();
            Iterator<AbstractRunnableC0019a> it = linkedList.iterator();
            while (it.hasNext()) {
                AbstractRunnableC0019a next = it.next();
                int tag = next.getTag();
                String key = next.getKey();
                if ((str != null && tag == id && str.equals(key)) || (str == null && id != 0 && tag == id)) {
                    if (next.lS() != null && !next.lS().isCancelled()) {
                        linkedList3.add(next.lS());
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
    public static abstract class AbstractRunnableC0019a implements Runnable {
        private b<?> KA;

        public AbstractRunnableC0019a(b<?> bVar) {
            this.KA = null;
            if (bVar == null || bVar.lS() == null) {
                throw new InvalidParameterException("parameter is null");
            }
            this.KA = bVar;
        }

        public void runTask() {
            try {
                this.KA.run();
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }

        public void cancelTask() {
            this.KA.cancelTask();
        }

        public boolean isCancelled() {
            return this.KA.isCancelled();
        }

        public BdAsyncTask<?, ?, ?> lS() {
            return this.KA.lS();
        }

        public int getPriority() {
            return this.KA.lS().getPriority();
        }

        public void setTimeout(boolean z) {
            this.KA.lS().setTimeout(z);
        }

        public boolean IsTimeout() {
            return this.KA.lS().isTimeout();
        }

        public int getTag() {
            return this.KA.lS().getTag();
        }

        public int getParallelTag() {
            if (this.KA.lS().getParallel() != null) {
                return this.KA.lS().getParallel().getTag();
            }
            return 0;
        }

        public String getKey() {
            return this.KA.lS().getKey();
        }

        public BdAsyncTaskParallel.BdAsyncTaskParallelType lT() {
            return this.KA.lS().getParallel() != null ? this.KA.lS().getParallel().lU() : BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
        }

        public int getExcuteNum() {
            if (this.KA.lS().getParallel() != null) {
                return this.KA.lS().getParallel().getExecuteNum();
            }
            return 1;
        }

        public boolean isSelfExecute() {
            return this.KA.lS().isSelfExecute();
        }
    }
}
