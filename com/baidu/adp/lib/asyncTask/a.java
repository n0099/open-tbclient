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
    private volatile int xc = 0;
    private volatile int xd = 0;
    private volatile int xe = 0;
    private volatile int xf = 0;
    private final SparseIntArray xg = new SparseIntArray();
    private final LinkedList<AbstractRunnableC0013a> xh = new LinkedList<>();
    private final LinkedList<AbstractRunnableC0013a> xi = new LinkedList<>();
    private final LinkedList<AbstractRunnableC0013a> xj = new LinkedList<>();
    private static a xb = null;
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
        this.sHandlerThread = null;
        this.mHandler = null;
        this.sHandlerThread = new HandlerThread("BdAsyncTaskExecutor");
        this.sHandlerThread.start();
        this.mHandler = new Handler(this.sHandlerThread.getLooper()) { // from class: com.baidu.adp.lib.asyncTask.a.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 1) {
                    if (message.obj != null && (message.obj instanceof AbstractRunnableC0013a)) {
                        a.this.b((AbstractRunnableC0013a) message.obj);
                    }
                } else if (message.what == 2 && message.obj != null && (message.obj instanceof AbstractRunnableC0013a)) {
                    a.this.e((AbstractRunnableC0013a) message.obj);
                    if (BdBaseApplication.getInst().isDebugMode()) {
                    }
                }
            }
        };
    }

    public String toString() {
        return "mWaitingTasks = " + this.xh.size() + " mRunningTasks = " + this.xi.size() + " mTimeOutTasks = " + this.xj.size();
    }

    public String gH() {
        return this.xh.size() + "/" + this.xi.size() + "/" + this.xj.size();
    }

    public static a gI() {
        if (xb == null) {
            synchronized (a.class) {
                if (xb == null) {
                    xb = new a();
                }
            }
        }
        return xb;
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        if (runnable instanceof b) {
            AbstractRunnableC0013a abstractRunnableC0013a = new AbstractRunnableC0013a((b) runnable) { // from class: com.baidu.adp.lib.asyncTask.a.3
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
                        gJ();
                    } finally {
                        if (!isSelfExecute()) {
                            a.this.mHandler.sendMessageDelayed(a.this.mHandler.obtainMessage(2, this), 1L);
                        }
                    }
                }
            };
            if (abstractRunnableC0013a.isSelfExecute()) {
                new Thread(abstractRunnableC0013a).start();
            } else {
                a(abstractRunnableC0013a);
                e(null);
                if (BdBaseApplication.getInst().isDebugMode()) {
                }
            }
        }
    }

    private synchronized void a(AbstractRunnableC0013a abstractRunnableC0013a) {
        if (abstractRunnableC0013a != null) {
            int size = this.xh.size();
            int i = 0;
            while (i < size && this.xh.get(i).getPriority() >= abstractRunnableC0013a.getPriority()) {
                i++;
            }
            this.xh.add(i, abstractRunnableC0013a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(AbstractRunnableC0013a abstractRunnableC0013a) {
        AbstractRunnableC0013a poll;
        c(abstractRunnableC0013a);
        if (!abstractRunnableC0013a.isCancelled()) {
            abstractRunnableC0013a.setTimeout(true);
            this.xj.add(abstractRunnableC0013a);
            if (this.xj.size() > 242 && (poll = this.xj.poll()) != null) {
                poll.gG();
            }
        } else {
            BdLog.e("task TimeOut but it's cancelled()");
        }
        e(null);
    }

    private synchronized void c(AbstractRunnableC0013a abstractRunnableC0013a) {
        if (abstractRunnableC0013a != null) {
            if (abstractRunnableC0013a.gL()) {
                this.xj.remove(abstractRunnableC0013a);
            } else {
                this.xi.remove(abstractRunnableC0013a);
                this.mHandler.removeMessages(1, abstractRunnableC0013a);
                switch (abstractRunnableC0013a.getPriority()) {
                    case 1:
                        this.xf--;
                        break;
                    case 2:
                        this.xe--;
                        break;
                    case 3:
                        this.xd--;
                        break;
                    case 4:
                        this.xc--;
                        break;
                }
                int gM = abstractRunnableC0013a.gM();
                if (gM != 0) {
                    int i = this.xg.get(gM) - 1;
                    if (i <= 0) {
                        this.xg.delete(gM);
                    } else {
                        this.xg.put(gM, i);
                    }
                    if (i < 0) {
                        BdLog.e("removeTask error < 0");
                    }
                }
            }
        }
    }

    private synchronized void d(AbstractRunnableC0013a abstractRunnableC0013a) {
        if (abstractRunnableC0013a != null) {
            this.xi.add(abstractRunnableC0013a);
            this.xh.remove(abstractRunnableC0013a);
            THREAD_POOL_EXECUTOR.execute(abstractRunnableC0013a);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, abstractRunnableC0013a), 180000L);
            switch (abstractRunnableC0013a.getPriority()) {
                case 1:
                    this.xf++;
                    break;
                case 2:
                    this.xe++;
                    break;
                case 3:
                    this.xd++;
                    break;
                case 4:
                    this.xc++;
                    if (this.xc >= 7) {
                        BdLog.e("SuperHight Task too much num = " + this.xc);
                        break;
                    }
                    break;
            }
            int gM = abstractRunnableC0013a.gM();
            if (gM != 0) {
                this.xg.put(gM, this.xg.get(gM, 0) + 1);
            }
        }
    }

    private boolean a(int i, AbstractRunnableC0013a abstractRunnableC0013a) {
        if (abstractRunnableC0013a == null) {
            return false;
        }
        BdAsyncTaskParallel.BdAsyncTaskParallelType gN = abstractRunnableC0013a.gN();
        return gN == BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL ? i < 1 : gN == BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL ? i < 2 : gN == BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL ? i < 3 : gN == BdAsyncTaskParallel.BdAsyncTaskParallelType.FOUR_PARALLEL ? i < 4 : gN != BdAsyncTaskParallel.BdAsyncTaskParallelType.CUSTOM_PARALLEL || i < abstractRunnableC0013a.gO();
    }

    protected synchronized void e(AbstractRunnableC0013a abstractRunnableC0013a) {
        c(abstractRunnableC0013a);
        int i = 0;
        while (true) {
            if (i < this.xh.size()) {
                AbstractRunnableC0013a abstractRunnableC0013a2 = this.xh.get(i);
                if (abstractRunnableC0013a2 != null) {
                    int gM = abstractRunnableC0013a2.gM();
                    switch (abstractRunnableC0013a2.getPriority()) {
                        case 1:
                            if (this.xd + this.xe + this.xf >= 5) {
                                break;
                            }
                            break;
                        case 2:
                            if (this.xd + this.xe + this.xf >= 6) {
                                break;
                            }
                            break;
                        case 3:
                            if (this.xd + this.xe + this.xf >= 7) {
                                break;
                            }
                            break;
                        case 4:
                            if (gM == 0) {
                                d(abstractRunnableC0013a2);
                                break;
                            }
                            break;
                    }
                    if (a(this.xg.get(gM), abstractRunnableC0013a2)) {
                        d(abstractRunnableC0013a2);
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
        a(this.xi, false, bdUniqueId, str);
        a(this.xj, false, bdUniqueId, str);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        removeAllWaitingTask(bdUniqueId, null);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        a(this.xh, true, bdUniqueId, str);
    }

    private synchronized void a(LinkedList<AbstractRunnableC0013a> linkedList, boolean z, BdUniqueId bdUniqueId, String str) {
        if (bdUniqueId != null) {
            int id = bdUniqueId.getId();
            Iterator<AbstractRunnableC0013a> it = linkedList.iterator();
            while (it.hasNext()) {
                AbstractRunnableC0013a next = it.next();
                int tag = next.getTag();
                String key = next.getKey();
                if ((str != null && tag == id && str.equals(key)) || (str == null && id != 0 && tag == id)) {
                    if (z) {
                        it.remove();
                    }
                    next.gG();
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
        Iterator<AbstractRunnableC0013a> it = this.xh.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AbstractRunnableC0013a next = it.next();
            if (next != null && next.gK() == bdAsyncTask) {
                break;
            }
        }
    }

    public int getTaskNum(String str, BdUniqueId bdUniqueId) {
        return a(this.xh, str, bdUniqueId) + a(this.xi, str, bdUniqueId) + a(this.xj, str, bdUniqueId);
    }

    private synchronized int a(LinkedList<AbstractRunnableC0013a> linkedList, String str, BdUniqueId bdUniqueId) {
        int i = 0;
        synchronized (this) {
            if (linkedList != null && bdUniqueId != null) {
                int id = bdUniqueId.getId();
                Iterator<AbstractRunnableC0013a> it = linkedList.iterator();
                while (it.hasNext()) {
                    AbstractRunnableC0013a next = it.next();
                    int tag = next.getTag();
                    i = (!((str != null && tag == id && str.equals(next.getKey())) || (str == null && id != 0 && tag == id)) || next.gK() == null || next.gK().isCancelled()) ? i : i + 1;
                }
            }
        }
        return i;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchTask(String str) {
        BdAsyncTask<?, ?, ?> a;
        a = a(this.xh, str);
        if (a == null) {
            a = a(this.xi, str);
        }
        if (a == null) {
            a = a(this.xj, str);
        }
        return a;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return searchAllTask(bdUniqueId, null);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.xh, bdUniqueId, str);
        if (a != null) {
            linkedList.addAll(a);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.xi, bdUniqueId, str);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a3 = a(this.xj, bdUniqueId, str);
        if (a3 != null) {
            linkedList.addAll(a3);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return a(this.xh, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.xh, bdUniqueId, (String) null);
        if (a != null) {
            linkedList.addAll(a);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return a(this.xi, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
        r0 = r0.gK();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized BdAsyncTask<?, ?, ?> a(LinkedList<AbstractRunnableC0013a> linkedList, String str) {
        BdAsyncTask<?, ?, ?> bdAsyncTask;
        if (linkedList != null && str != null) {
            Iterator<AbstractRunnableC0013a> it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bdAsyncTask = null;
                    break;
                }
                AbstractRunnableC0013a next = it.next();
                String key = next.getKey();
                if (key != null && key.equals(str) && !next.gK().isCancelled()) {
                    break;
                }
            }
        } else {
            bdAsyncTask = null;
        }
        return bdAsyncTask;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> a(LinkedList<AbstractRunnableC0013a> linkedList, BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList2;
        if (linkedList == null || bdUniqueId == null) {
            linkedList2 = null;
        } else {
            int id = bdUniqueId.getId();
            LinkedList<BdAsyncTask<?, ?, ?>> linkedList3 = new LinkedList<>();
            Iterator<AbstractRunnableC0013a> it = linkedList.iterator();
            while (it.hasNext()) {
                AbstractRunnableC0013a next = it.next();
                int tag = next.getTag();
                String key = next.getKey();
                if ((str != null && tag == id && str.equals(key)) || (str == null && id != 0 && tag == id)) {
                    if (next.gK() != null && !next.gK().isCancelled()) {
                        linkedList3.add(next.gK());
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
    public static abstract class AbstractRunnableC0013a implements Runnable {
        private b<?> xl;

        public AbstractRunnableC0013a(b<?> bVar) {
            this.xl = null;
            if (bVar == null || bVar.gK() == null) {
                throw new InvalidParameterException("parameter is null");
            }
            this.xl = bVar;
        }

        public void gJ() {
            try {
                this.xl.run();
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }

        public void gG() {
            this.xl.gG();
        }

        public boolean isCancelled() {
            return this.xl.isCancelled();
        }

        public BdAsyncTask<?, ?, ?> gK() {
            return this.xl.gK();
        }

        public int getPriority() {
            return this.xl.gK().getPriority();
        }

        public void setTimeout(boolean z) {
            this.xl.gK().setTimeout(z);
        }

        public boolean gL() {
            return this.xl.gK().isTimeout();
        }

        public int getTag() {
            return this.xl.gK().getTag();
        }

        public int gM() {
            if (this.xl.gK().getParallel() != null) {
                return this.xl.gK().getParallel().getTag();
            }
            return 0;
        }

        public String getKey() {
            return this.xl.gK().getKey();
        }

        public BdAsyncTaskParallel.BdAsyncTaskParallelType gN() {
            return this.xl.gK().getParallel() != null ? this.xl.gK().getParallel().gQ() : BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
        }

        public int gO() {
            if (this.xl.gK().getParallel() != null) {
                return this.xl.gK().getParallel().gP();
            }
            return 1;
        }

        public boolean isSelfExecute() {
            return this.xl.gK().isSelfExecute();
        }
    }
}
