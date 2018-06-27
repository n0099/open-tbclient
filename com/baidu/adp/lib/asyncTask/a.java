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
    private volatile int xh = 0;
    private volatile int xi = 0;
    private volatile int xj = 0;
    private volatile int xk = 0;
    private final SparseIntArray xl = new SparseIntArray();
    private final LinkedList<AbstractRunnableC0013a> xm = new LinkedList<>();
    private final LinkedList<AbstractRunnableC0013a> xn = new LinkedList<>();
    private final LinkedList<AbstractRunnableC0013a> xo = new LinkedList<>();
    private static a xg = null;
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
        return "mWaitingTasks = " + this.xm.size() + " mRunningTasks = " + this.xn.size() + " mTimeOutTasks = " + this.xo.size();
    }

    public String gI() {
        return this.xm.size() + "/" + this.xn.size() + "/" + this.xo.size();
    }

    public static a gJ() {
        if (xg == null) {
            synchronized (a.class) {
                if (xg == null) {
                    xg = new a();
                }
            }
        }
        return xg;
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
                        gK();
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
            int size = this.xm.size();
            int i = 0;
            while (i < size && this.xm.get(i).getPriority() >= abstractRunnableC0013a.getPriority()) {
                i++;
            }
            this.xm.add(i, abstractRunnableC0013a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(AbstractRunnableC0013a abstractRunnableC0013a) {
        AbstractRunnableC0013a poll;
        c(abstractRunnableC0013a);
        if (!abstractRunnableC0013a.isCancelled()) {
            abstractRunnableC0013a.setTimeout(true);
            this.xo.add(abstractRunnableC0013a);
            if (this.xo.size() > 242 && (poll = this.xo.poll()) != null) {
                poll.gH();
            }
        } else {
            BdLog.e("task TimeOut but it's cancelled()");
        }
        e(null);
    }

    private synchronized void c(AbstractRunnableC0013a abstractRunnableC0013a) {
        if (abstractRunnableC0013a != null) {
            if (abstractRunnableC0013a.gM()) {
                this.xo.remove(abstractRunnableC0013a);
            } else {
                this.xn.remove(abstractRunnableC0013a);
                this.mHandler.removeMessages(1, abstractRunnableC0013a);
                switch (abstractRunnableC0013a.getPriority()) {
                    case 1:
                        this.xk--;
                        break;
                    case 2:
                        this.xj--;
                        break;
                    case 3:
                        this.xi--;
                        break;
                    case 4:
                        this.xh--;
                        break;
                }
                int gN = abstractRunnableC0013a.gN();
                if (gN != 0) {
                    int i = this.xl.get(gN) - 1;
                    if (i <= 0) {
                        this.xl.delete(gN);
                    } else {
                        this.xl.put(gN, i);
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
            this.xn.add(abstractRunnableC0013a);
            this.xm.remove(abstractRunnableC0013a);
            THREAD_POOL_EXECUTOR.execute(abstractRunnableC0013a);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, abstractRunnableC0013a), 180000L);
            switch (abstractRunnableC0013a.getPriority()) {
                case 1:
                    this.xk++;
                    break;
                case 2:
                    this.xj++;
                    break;
                case 3:
                    this.xi++;
                    break;
                case 4:
                    this.xh++;
                    if (this.xh >= 7) {
                        BdLog.e("SuperHight Task too much num = " + this.xh);
                        break;
                    }
                    break;
            }
            int gN = abstractRunnableC0013a.gN();
            if (gN != 0) {
                this.xl.put(gN, this.xl.get(gN, 0) + 1);
            }
        }
    }

    private boolean a(int i, AbstractRunnableC0013a abstractRunnableC0013a) {
        if (abstractRunnableC0013a == null) {
            return false;
        }
        BdAsyncTaskParallel.BdAsyncTaskParallelType gO = abstractRunnableC0013a.gO();
        return gO == BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL ? i < 1 : gO == BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL ? i < 2 : gO == BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL ? i < 3 : gO == BdAsyncTaskParallel.BdAsyncTaskParallelType.FOUR_PARALLEL ? i < 4 : gO != BdAsyncTaskParallel.BdAsyncTaskParallelType.CUSTOM_PARALLEL || i < abstractRunnableC0013a.gP();
    }

    protected synchronized void e(AbstractRunnableC0013a abstractRunnableC0013a) {
        c(abstractRunnableC0013a);
        int i = 0;
        while (true) {
            if (i < this.xm.size()) {
                AbstractRunnableC0013a abstractRunnableC0013a2 = this.xm.get(i);
                if (abstractRunnableC0013a2 != null) {
                    int gN = abstractRunnableC0013a2.gN();
                    switch (abstractRunnableC0013a2.getPriority()) {
                        case 1:
                            if (this.xi + this.xj + this.xk >= 5) {
                                break;
                            }
                            break;
                        case 2:
                            if (this.xi + this.xj + this.xk >= 6) {
                                break;
                            }
                            break;
                        case 3:
                            if (this.xi + this.xj + this.xk >= 7) {
                                break;
                            }
                            break;
                        case 4:
                            if (gN == 0) {
                                d(abstractRunnableC0013a2);
                                break;
                            }
                            break;
                    }
                    if (a(this.xl.get(gN), abstractRunnableC0013a2)) {
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
        a(this.xn, false, bdUniqueId, str);
        a(this.xo, false, bdUniqueId, str);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        removeAllWaitingTask(bdUniqueId, null);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        a(this.xm, true, bdUniqueId, str);
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
                    next.gH();
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
        Iterator<AbstractRunnableC0013a> it = this.xm.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AbstractRunnableC0013a next = it.next();
            if (next != null && next.gL() == bdAsyncTask) {
                break;
            }
        }
    }

    public int getTaskNum(String str, BdUniqueId bdUniqueId) {
        return a(this.xm, str, bdUniqueId) + a(this.xn, str, bdUniqueId) + a(this.xo, str, bdUniqueId);
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
                    i = (!((str != null && tag == id && str.equals(next.getKey())) || (str == null && id != 0 && tag == id)) || next.gL() == null || next.gL().isCancelled()) ? i : i + 1;
                }
            }
        }
        return i;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchTask(String str) {
        BdAsyncTask<?, ?, ?> a;
        a = a(this.xm, str);
        if (a == null) {
            a = a(this.xn, str);
        }
        if (a == null) {
            a = a(this.xo, str);
        }
        return a;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return searchAllTask(bdUniqueId, null);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.xm, bdUniqueId, str);
        if (a != null) {
            linkedList.addAll(a);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.xn, bdUniqueId, str);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a3 = a(this.xo, bdUniqueId, str);
        if (a3 != null) {
            linkedList.addAll(a3);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return a(this.xm, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.xm, bdUniqueId, (String) null);
        if (a != null) {
            linkedList.addAll(a);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return a(this.xn, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
        r0 = r0.gL();
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
                if (key != null && key.equals(str) && !next.gL().isCancelled()) {
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
                    if (next.gL() != null && !next.gL().isCancelled()) {
                        linkedList3.add(next.gL());
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
        private b<?> xq;

        public AbstractRunnableC0013a(b<?> bVar) {
            this.xq = null;
            if (bVar == null || bVar.gL() == null) {
                throw new InvalidParameterException("parameter is null");
            }
            this.xq = bVar;
        }

        public void gK() {
            try {
                this.xq.run();
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }

        public void gH() {
            this.xq.gH();
        }

        public boolean isCancelled() {
            return this.xq.isCancelled();
        }

        public BdAsyncTask<?, ?, ?> gL() {
            return this.xq.gL();
        }

        public int getPriority() {
            return this.xq.gL().getPriority();
        }

        public void setTimeout(boolean z) {
            this.xq.gL().setTimeout(z);
        }

        public boolean gM() {
            return this.xq.gL().isTimeout();
        }

        public int getTag() {
            return this.xq.gL().getTag();
        }

        public int gN() {
            if (this.xq.gL().getParallel() != null) {
                return this.xq.gL().getParallel().getTag();
            }
            return 0;
        }

        public String getKey() {
            return this.xq.gL().getKey();
        }

        public BdAsyncTaskParallel.BdAsyncTaskParallelType gO() {
            return this.xq.gL().getParallel() != null ? this.xq.gL().getParallel().gR() : BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
        }

        public int gP() {
            if (this.xq.gL().getParallel() != null) {
                return this.xq.gL().getParallel().gQ();
            }
            return 1;
        }

        public boolean isSelfExecute() {
            return this.xq.gL().isSelfExecute();
        }
    }
}
