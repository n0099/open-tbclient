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
    private volatile int sR = 0;
    private volatile int sS = 0;
    private volatile int sT = 0;
    private volatile int sU = 0;
    private final SparseIntArray sV = new SparseIntArray();
    private final LinkedList<AbstractRunnableC0004a> sW = new LinkedList<>();
    private final LinkedList<AbstractRunnableC0004a> sX = new LinkedList<>();
    private final LinkedList<AbstractRunnableC0004a> sY = new LinkedList<>();
    private HandlerThread sZ;
    private static a sQ = null;
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

    a() {
        this.sZ = null;
        this.mHandler = null;
        this.sZ = new HandlerThread("BdAsyncTaskExecutor");
        this.sZ.start();
        this.mHandler = new Handler(this.sZ.getLooper()) { // from class: com.baidu.adp.lib.asyncTask.a.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 1) {
                    if (message.obj != null && (message.obj instanceof AbstractRunnableC0004a)) {
                        a.this.b((AbstractRunnableC0004a) message.obj);
                    }
                } else if (message.what == 2 && message.obj != null && (message.obj instanceof AbstractRunnableC0004a)) {
                    a.this.e((AbstractRunnableC0004a) message.obj);
                    if (BdBaseApplication.getInst().isDebugMode()) {
                    }
                }
            }
        };
    }

    public String toString() {
        return "mWaitingTasks = " + this.sW.size() + " mRunningTasks = " + this.sX.size() + " mTimeOutTasks = " + this.sY.size();
    }

    public String ej() {
        return this.sW.size() + "/" + this.sX.size() + "/" + this.sY.size();
    }

    public static a ek() {
        if (sQ == null) {
            synchronized (a.class) {
                if (sQ == null) {
                    sQ = new a();
                }
            }
        }
        return sQ;
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        if (runnable instanceof b) {
            AbstractRunnableC0004a abstractRunnableC0004a = new AbstractRunnableC0004a((b) runnable) { // from class: com.baidu.adp.lib.asyncTask.a.3
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
                        el();
                    } finally {
                        if (!isSelfExecute()) {
                            a.this.mHandler.sendMessageDelayed(a.this.mHandler.obtainMessage(2, this), 1L);
                        }
                    }
                }
            };
            if (abstractRunnableC0004a.isSelfExecute()) {
                new Thread(abstractRunnableC0004a).start();
            } else {
                a(abstractRunnableC0004a);
                e(null);
                if (BdBaseApplication.getInst().isDebugMode()) {
                }
            }
        }
    }

    private synchronized void a(AbstractRunnableC0004a abstractRunnableC0004a) {
        if (abstractRunnableC0004a != null) {
            int size = this.sW.size();
            int i = 0;
            while (i < size && this.sW.get(i).getPriority() >= abstractRunnableC0004a.getPriority()) {
                i++;
            }
            this.sW.add(i, abstractRunnableC0004a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(AbstractRunnableC0004a abstractRunnableC0004a) {
        AbstractRunnableC0004a poll;
        c(abstractRunnableC0004a);
        if (!abstractRunnableC0004a.isCancelled()) {
            abstractRunnableC0004a.setTimeout(true);
            this.sY.add(abstractRunnableC0004a);
            if (this.sY.size() > 242 && (poll = this.sY.poll()) != null) {
                poll.ei();
            }
        } else {
            BdLog.e("task TimeOut but it's cancelled()");
        }
        e(null);
    }

    private synchronized void c(AbstractRunnableC0004a abstractRunnableC0004a) {
        if (abstractRunnableC0004a != null) {
            if (abstractRunnableC0004a.en()) {
                this.sY.remove(abstractRunnableC0004a);
            } else {
                this.sX.remove(abstractRunnableC0004a);
                this.mHandler.removeMessages(1, abstractRunnableC0004a);
                switch (abstractRunnableC0004a.getPriority()) {
                    case 1:
                        this.sU--;
                        break;
                    case 2:
                        this.sT--;
                        break;
                    case 3:
                        this.sS--;
                        break;
                    case 4:
                        this.sR--;
                        break;
                }
                int eo = abstractRunnableC0004a.eo();
                if (eo != 0) {
                    int i = this.sV.get(eo) - 1;
                    if (i <= 0) {
                        this.sV.delete(eo);
                    } else {
                        this.sV.put(eo, i);
                    }
                    if (i < 0) {
                        BdLog.e("removeTask error < 0");
                    }
                }
            }
        }
    }

    private synchronized void d(AbstractRunnableC0004a abstractRunnableC0004a) {
        if (abstractRunnableC0004a != null) {
            this.sX.add(abstractRunnableC0004a);
            this.sW.remove(abstractRunnableC0004a);
            THREAD_POOL_EXECUTOR.execute(abstractRunnableC0004a);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, abstractRunnableC0004a), 180000L);
            switch (abstractRunnableC0004a.getPriority()) {
                case 1:
                    this.sU++;
                    break;
                case 2:
                    this.sT++;
                    break;
                case 3:
                    this.sS++;
                    break;
                case 4:
                    this.sR++;
                    if (this.sR >= 7) {
                        BdLog.e("SuperHight Task too much num = " + this.sR);
                        break;
                    }
                    break;
            }
            int eo = abstractRunnableC0004a.eo();
            if (eo != 0) {
                this.sV.put(eo, this.sV.get(eo, 0) + 1);
            }
        }
    }

    private boolean a(int i, AbstractRunnableC0004a abstractRunnableC0004a) {
        if (abstractRunnableC0004a == null) {
            return false;
        }
        BdAsyncTaskParallel.BdAsyncTaskParallelType ep = abstractRunnableC0004a.ep();
        return ep == BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL ? i < 1 : ep == BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL ? i < 2 : ep == BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL ? i < 3 : ep == BdAsyncTaskParallel.BdAsyncTaskParallelType.FOUR_PARALLEL ? i < 4 : ep != BdAsyncTaskParallel.BdAsyncTaskParallelType.CUSTOM_PARALLEL || i < abstractRunnableC0004a.eq();
    }

    protected synchronized void e(AbstractRunnableC0004a abstractRunnableC0004a) {
        c(abstractRunnableC0004a);
        int i = 0;
        while (true) {
            if (i < this.sW.size()) {
                AbstractRunnableC0004a abstractRunnableC0004a2 = this.sW.get(i);
                if (abstractRunnableC0004a2 != null) {
                    int eo = abstractRunnableC0004a2.eo();
                    switch (abstractRunnableC0004a2.getPriority()) {
                        case 1:
                            if (this.sS + this.sT + this.sU >= 5) {
                                break;
                            }
                            break;
                        case 2:
                            if (this.sS + this.sT + this.sU >= 6) {
                                break;
                            }
                            break;
                        case 3:
                            if (this.sS + this.sT + this.sU >= 7) {
                                break;
                            }
                            break;
                        case 4:
                            if (eo == 0) {
                                d(abstractRunnableC0004a2);
                                break;
                            }
                            break;
                    }
                    if (a(this.sV.get(eo), abstractRunnableC0004a2)) {
                        d(abstractRunnableC0004a2);
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
        a(this.sX, false, bdUniqueId, str);
        a(this.sY, false, bdUniqueId, str);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        removeAllWaitingTask(bdUniqueId, null);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        a(this.sW, true, bdUniqueId, str);
    }

    private synchronized void a(LinkedList<AbstractRunnableC0004a> linkedList, boolean z, BdUniqueId bdUniqueId, String str) {
        if (bdUniqueId != null) {
            int id = bdUniqueId.getId();
            Iterator<AbstractRunnableC0004a> it = linkedList.iterator();
            while (it.hasNext()) {
                AbstractRunnableC0004a next = it.next();
                int tag = next.getTag();
                String key = next.getKey();
                if ((str != null && tag == id && str.equals(key)) || (str == null && id != 0 && tag == id)) {
                    if (z) {
                        it.remove();
                    }
                    next.ei();
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
        Iterator<AbstractRunnableC0004a> it = this.sW.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AbstractRunnableC0004a next = it.next();
            if (next != null && next.em() == bdAsyncTask) {
                break;
            }
        }
    }

    public int getTaskNum(String str, BdUniqueId bdUniqueId) {
        return a(this.sW, str, bdUniqueId) + a(this.sX, str, bdUniqueId) + a(this.sY, str, bdUniqueId);
    }

    private synchronized int a(LinkedList<AbstractRunnableC0004a> linkedList, String str, BdUniqueId bdUniqueId) {
        int i = 0;
        synchronized (this) {
            if (linkedList != null && bdUniqueId != null) {
                int id = bdUniqueId.getId();
                Iterator<AbstractRunnableC0004a> it = linkedList.iterator();
                while (it.hasNext()) {
                    AbstractRunnableC0004a next = it.next();
                    int tag = next.getTag();
                    i = (!((str != null && tag == id && str.equals(next.getKey())) || (str == null && id != 0 && tag == id)) || next.em() == null || next.em().isCancelled()) ? i : i + 1;
                }
            }
        }
        return i;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchTask(String str) {
        BdAsyncTask<?, ?, ?> a;
        a = a(this.sW, str);
        if (a == null) {
            a = a(this.sX, str);
        }
        if (a == null) {
            a = a(this.sY, str);
        }
        return a;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return searchAllTask(bdUniqueId, null);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.sW, bdUniqueId, str);
        if (a != null) {
            linkedList.addAll(a);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.sX, bdUniqueId, str);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a3 = a(this.sY, bdUniqueId, str);
        if (a3 != null) {
            linkedList.addAll(a3);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return a(this.sW, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.sW, bdUniqueId, (String) null);
        if (a != null) {
            linkedList.addAll(a);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return a(this.sX, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
        r0 = r0.em();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized BdAsyncTask<?, ?, ?> a(LinkedList<AbstractRunnableC0004a> linkedList, String str) {
        BdAsyncTask<?, ?, ?> bdAsyncTask;
        if (linkedList != null && str != null) {
            Iterator<AbstractRunnableC0004a> it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bdAsyncTask = null;
                    break;
                }
                AbstractRunnableC0004a next = it.next();
                String key = next.getKey();
                if (key != null && key.equals(str) && !next.em().isCancelled()) {
                    break;
                }
            }
        } else {
            bdAsyncTask = null;
        }
        return bdAsyncTask;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> a(LinkedList<AbstractRunnableC0004a> linkedList, BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList2;
        if (linkedList == null || bdUniqueId == null) {
            linkedList2 = null;
        } else {
            int id = bdUniqueId.getId();
            LinkedList<BdAsyncTask<?, ?, ?>> linkedList3 = new LinkedList<>();
            Iterator<AbstractRunnableC0004a> it = linkedList.iterator();
            while (it.hasNext()) {
                AbstractRunnableC0004a next = it.next();
                int tag = next.getTag();
                String key = next.getKey();
                if ((str != null && tag == id && str.equals(key)) || (str == null && id != 0 && tag == id)) {
                    if (next.em() != null && !next.em().isCancelled()) {
                        linkedList3.add(next.em());
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
    public static abstract class AbstractRunnableC0004a implements Runnable {
        private b<?> tc;

        public AbstractRunnableC0004a(b<?> bVar) {
            this.tc = null;
            if (bVar == null || bVar.em() == null) {
                throw new InvalidParameterException("parameter is null");
            }
            this.tc = bVar;
        }

        public void el() {
            try {
                this.tc.run();
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }

        public void ei() {
            this.tc.ei();
        }

        public boolean isCancelled() {
            return this.tc.isCancelled();
        }

        public BdAsyncTask<?, ?, ?> em() {
            return this.tc.em();
        }

        public int getPriority() {
            return this.tc.em().getPriority();
        }

        public void setTimeout(boolean z) {
            this.tc.em().setTimeout(z);
        }

        public boolean en() {
            return this.tc.em().isTimeout();
        }

        public int getTag() {
            return this.tc.em().getTag();
        }

        public int eo() {
            if (this.tc.em().getParallel() != null) {
                return this.tc.em().getParallel().getTag();
            }
            return 0;
        }

        public String getKey() {
            return this.tc.em().getKey();
        }

        public BdAsyncTaskParallel.BdAsyncTaskParallelType ep() {
            return this.tc.em().getParallel() != null ? this.tc.em().getParallel().es() : BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
        }

        public int eq() {
            if (this.tc.em().getParallel() != null) {
                return this.tc.em().getParallel().er();
            }
            return 1;
        }

        public boolean isSelfExecute() {
            return this.tc.em().isSelfExecute();
        }
    }
}
