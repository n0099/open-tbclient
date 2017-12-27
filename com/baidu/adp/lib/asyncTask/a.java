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
    private volatile int agF = 0;
    private volatile int agG = 0;
    private volatile int agH = 0;
    private volatile int agI = 0;
    private final SparseIntArray agJ = new SparseIntArray();
    private final LinkedList<AbstractRunnableC0016a> agK = new LinkedList<>();
    private final LinkedList<AbstractRunnableC0016a> agL = new LinkedList<>();
    private final LinkedList<AbstractRunnableC0016a> agM = new LinkedList<>();
    private HandlerThread agN;
    private Handler mHandler;
    private static a agE = null;
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
        this.agN = null;
        this.mHandler = null;
        this.agN = new HandlerThread("BdAsyncTaskExecutor");
        this.agN.start();
        this.mHandler = new Handler(this.agN.getLooper()) { // from class: com.baidu.adp.lib.asyncTask.a.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 1) {
                    if (message.obj != null && (message.obj instanceof AbstractRunnableC0016a)) {
                        a.this.b((AbstractRunnableC0016a) message.obj);
                    }
                } else if (message.what == 2 && message.obj != null && (message.obj instanceof AbstractRunnableC0016a)) {
                    a.this.e((AbstractRunnableC0016a) message.obj);
                    if (BdBaseApplication.getInst().isDebugMode()) {
                    }
                }
            }
        };
    }

    public String toString() {
        return "mWaitingTasks = " + this.agK.size() + " mRunningTasks = " + this.agL.size() + " mTimeOutTasks = " + this.agM.size();
    }

    public String lM() {
        return this.agK.size() + "/" + this.agL.size() + "/" + this.agM.size();
    }

    public static a lN() {
        if (agE == null) {
            synchronized (a.class) {
                if (agE == null) {
                    agE = new a();
                }
            }
        }
        return agE;
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        if (runnable instanceof b) {
            AbstractRunnableC0016a abstractRunnableC0016a = new AbstractRunnableC0016a((b) runnable) { // from class: com.baidu.adp.lib.asyncTask.a.3
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
                        lO();
                    } finally {
                        if (!isSelfExecute()) {
                            a.this.mHandler.sendMessageDelayed(a.this.mHandler.obtainMessage(2, this), 1L);
                        }
                    }
                }
            };
            if (abstractRunnableC0016a.isSelfExecute()) {
                new Thread(abstractRunnableC0016a).start();
            } else {
                a(abstractRunnableC0016a);
                e(null);
                if (BdBaseApplication.getInst().isDebugMode()) {
                }
            }
        }
    }

    private synchronized void a(AbstractRunnableC0016a abstractRunnableC0016a) {
        if (abstractRunnableC0016a != null) {
            int size = this.agK.size();
            int i = 0;
            while (i < size && this.agK.get(i).getPriority() >= abstractRunnableC0016a.getPriority()) {
                i++;
            }
            this.agK.add(i, abstractRunnableC0016a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(AbstractRunnableC0016a abstractRunnableC0016a) {
        AbstractRunnableC0016a poll;
        c(abstractRunnableC0016a);
        if (!abstractRunnableC0016a.isCancelled()) {
            abstractRunnableC0016a.setTimeout(true);
            this.agM.add(abstractRunnableC0016a);
            if (this.agM.size() > 242 && (poll = this.agM.poll()) != null) {
                poll.lL();
            }
        } else {
            BdLog.e("task TimeOut but it's cancelled()");
        }
        e(null);
    }

    private synchronized void c(AbstractRunnableC0016a abstractRunnableC0016a) {
        if (abstractRunnableC0016a != null) {
            if (abstractRunnableC0016a.lQ()) {
                this.agM.remove(abstractRunnableC0016a);
            } else {
                this.agL.remove(abstractRunnableC0016a);
                this.mHandler.removeMessages(1, abstractRunnableC0016a);
                switch (abstractRunnableC0016a.getPriority()) {
                    case 1:
                        this.agI--;
                        break;
                    case 2:
                        this.agH--;
                        break;
                    case 3:
                        this.agG--;
                        break;
                    case 4:
                        this.agF--;
                        break;
                }
                int lR = abstractRunnableC0016a.lR();
                if (lR != 0) {
                    int i = this.agJ.get(lR) - 1;
                    if (i <= 0) {
                        this.agJ.delete(lR);
                    } else {
                        this.agJ.put(lR, i);
                    }
                    if (i < 0) {
                        BdLog.e("removeTask error < 0");
                    }
                }
            }
        }
    }

    private synchronized void d(AbstractRunnableC0016a abstractRunnableC0016a) {
        if (abstractRunnableC0016a != null) {
            this.agL.add(abstractRunnableC0016a);
            this.agK.remove(abstractRunnableC0016a);
            THREAD_POOL_EXECUTOR.execute(abstractRunnableC0016a);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, abstractRunnableC0016a), 180000L);
            switch (abstractRunnableC0016a.getPriority()) {
                case 1:
                    this.agI++;
                    break;
                case 2:
                    this.agH++;
                    break;
                case 3:
                    this.agG++;
                    break;
                case 4:
                    this.agF++;
                    if (this.agF >= 7) {
                        BdLog.e("SuperHight Task too much num = " + this.agF);
                        break;
                    }
                    break;
            }
            int lR = abstractRunnableC0016a.lR();
            if (lR != 0) {
                this.agJ.put(lR, this.agJ.get(lR, 0) + 1);
            }
        }
    }

    private boolean a(int i, AbstractRunnableC0016a abstractRunnableC0016a) {
        if (abstractRunnableC0016a == null) {
            return false;
        }
        BdAsyncTaskParallel.BdAsyncTaskParallelType lS = abstractRunnableC0016a.lS();
        return lS == BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL ? i < 1 : lS == BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL ? i < 2 : lS == BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL ? i < 3 : lS == BdAsyncTaskParallel.BdAsyncTaskParallelType.FOUR_PARALLEL ? i < 4 : lS != BdAsyncTaskParallel.BdAsyncTaskParallelType.CUSTOM_PARALLEL || i < abstractRunnableC0016a.lT();
    }

    protected synchronized void e(AbstractRunnableC0016a abstractRunnableC0016a) {
        c(abstractRunnableC0016a);
        int i = 0;
        while (true) {
            if (i < this.agK.size()) {
                AbstractRunnableC0016a abstractRunnableC0016a2 = this.agK.get(i);
                if (abstractRunnableC0016a2 != null) {
                    int lR = abstractRunnableC0016a2.lR();
                    switch (abstractRunnableC0016a2.getPriority()) {
                        case 1:
                            if (this.agG + this.agH + this.agI >= 5) {
                                break;
                            }
                            break;
                        case 2:
                            if (this.agG + this.agH + this.agI >= 6) {
                                break;
                            }
                            break;
                        case 3:
                            if (this.agG + this.agH + this.agI >= 7) {
                                break;
                            }
                            break;
                        case 4:
                            if (lR == 0) {
                                d(abstractRunnableC0016a2);
                                break;
                            }
                            break;
                    }
                    if (a(this.agJ.get(lR), abstractRunnableC0016a2)) {
                        d(abstractRunnableC0016a2);
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
        a(this.agL, false, bdUniqueId, str);
        a(this.agM, false, bdUniqueId, str);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        removeAllWaitingTask(bdUniqueId, null);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        a(this.agK, true, bdUniqueId, str);
    }

    private synchronized void a(LinkedList<AbstractRunnableC0016a> linkedList, boolean z, BdUniqueId bdUniqueId, String str) {
        if (bdUniqueId != null) {
            int id = bdUniqueId.getId();
            Iterator<AbstractRunnableC0016a> it = linkedList.iterator();
            while (it.hasNext()) {
                AbstractRunnableC0016a next = it.next();
                int tag = next.getTag();
                String key = next.getKey();
                if ((str != null && tag == id && str.equals(key)) || (str == null && id != 0 && tag == id)) {
                    if (z) {
                        it.remove();
                    }
                    next.lL();
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
        Iterator<AbstractRunnableC0016a> it = this.agK.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AbstractRunnableC0016a next = it.next();
            if (next != null && next.lP() == bdAsyncTask) {
                break;
            }
        }
    }

    public int getTaskNum(String str, BdUniqueId bdUniqueId) {
        return a(this.agK, str, bdUniqueId) + a(this.agL, str, bdUniqueId) + a(this.agM, str, bdUniqueId);
    }

    private synchronized int a(LinkedList<AbstractRunnableC0016a> linkedList, String str, BdUniqueId bdUniqueId) {
        int i = 0;
        synchronized (this) {
            if (linkedList != null && bdUniqueId != null) {
                int id = bdUniqueId.getId();
                Iterator<AbstractRunnableC0016a> it = linkedList.iterator();
                while (it.hasNext()) {
                    AbstractRunnableC0016a next = it.next();
                    int tag = next.getTag();
                    i = (!((str != null && tag == id && str.equals(next.getKey())) || (str == null && id != 0 && tag == id)) || next.lP() == null || next.lP().isCancelled()) ? i : i + 1;
                }
            }
        }
        return i;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchTask(String str) {
        BdAsyncTask<?, ?, ?> a;
        a = a(this.agK, str);
        if (a == null) {
            a = a(this.agL, str);
        }
        if (a == null) {
            a = a(this.agM, str);
        }
        return a;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return searchAllTask(bdUniqueId, null);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.agK, bdUniqueId, str);
        if (a != null) {
            linkedList.addAll(a);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.agL, bdUniqueId, str);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a3 = a(this.agM, bdUniqueId, str);
        if (a3 != null) {
            linkedList.addAll(a3);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return a(this.agK, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.agK, bdUniqueId, (String) null);
        if (a != null) {
            linkedList.addAll(a);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return a(this.agL, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
        r0 = r0.lP();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized BdAsyncTask<?, ?, ?> a(LinkedList<AbstractRunnableC0016a> linkedList, String str) {
        BdAsyncTask<?, ?, ?> bdAsyncTask;
        if (linkedList != null && str != null) {
            Iterator<AbstractRunnableC0016a> it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bdAsyncTask = null;
                    break;
                }
                AbstractRunnableC0016a next = it.next();
                String key = next.getKey();
                if (key != null && key.equals(str) && !next.lP().isCancelled()) {
                    break;
                }
            }
        } else {
            bdAsyncTask = null;
        }
        return bdAsyncTask;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> a(LinkedList<AbstractRunnableC0016a> linkedList, BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList2;
        if (linkedList == null || bdUniqueId == null) {
            linkedList2 = null;
        } else {
            int id = bdUniqueId.getId();
            LinkedList<BdAsyncTask<?, ?, ?>> linkedList3 = new LinkedList<>();
            Iterator<AbstractRunnableC0016a> it = linkedList.iterator();
            while (it.hasNext()) {
                AbstractRunnableC0016a next = it.next();
                int tag = next.getTag();
                String key = next.getKey();
                if ((str != null && tag == id && str.equals(key)) || (str == null && id != 0 && tag == id)) {
                    if (next.lP() != null && !next.lP().isCancelled()) {
                        linkedList3.add(next.lP());
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
    public static abstract class AbstractRunnableC0016a implements Runnable {
        private b<?> agP;

        public AbstractRunnableC0016a(b<?> bVar) {
            this.agP = null;
            if (bVar == null || bVar.lP() == null) {
                throw new InvalidParameterException("parameter is null");
            }
            this.agP = bVar;
        }

        public void lO() {
            try {
                this.agP.run();
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }

        public void lL() {
            this.agP.lL();
        }

        public boolean isCancelled() {
            return this.agP.isCancelled();
        }

        public BdAsyncTask<?, ?, ?> lP() {
            return this.agP.lP();
        }

        public int getPriority() {
            return this.agP.lP().getPriority();
        }

        public void setTimeout(boolean z) {
            this.agP.lP().setTimeout(z);
        }

        public boolean lQ() {
            return this.agP.lP().isTimeout();
        }

        public int getTag() {
            return this.agP.lP().getTag();
        }

        public int lR() {
            if (this.agP.lP().getParallel() != null) {
                return this.agP.lP().getParallel().getTag();
            }
            return 0;
        }

        public String getKey() {
            return this.agP.lP().getKey();
        }

        public BdAsyncTaskParallel.BdAsyncTaskParallelType lS() {
            return this.agP.lP().getParallel() != null ? this.agP.lP().getParallel().lV() : BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
        }

        public int lT() {
            if (this.agP.lP().getParallel() != null) {
                return this.agP.lP().getParallel().lU();
            }
            return 1;
        }

        public boolean isSelfExecute() {
            return this.agP.lP().isSelfExecute();
        }
    }
}
