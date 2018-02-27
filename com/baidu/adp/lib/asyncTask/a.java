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
    private volatile int agA = 0;
    private volatile int agB = 0;
    private volatile int agC = 0;
    private volatile int agD = 0;
    private final SparseIntArray agE = new SparseIntArray();
    private final LinkedList<AbstractRunnableC0016a> agF = new LinkedList<>();
    private final LinkedList<AbstractRunnableC0016a> agG = new LinkedList<>();
    private final LinkedList<AbstractRunnableC0016a> agH = new LinkedList<>();
    private HandlerThread agI;
    private Handler mHandler;
    private static a agz = null;
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
        this.agI = null;
        this.mHandler = null;
        this.agI = new HandlerThread("BdAsyncTaskExecutor");
        this.agI.start();
        this.mHandler = new Handler(this.agI.getLooper()) { // from class: com.baidu.adp.lib.asyncTask.a.2
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
        return "mWaitingTasks = " + this.agF.size() + " mRunningTasks = " + this.agG.size() + " mTimeOutTasks = " + this.agH.size();
    }

    public String lN() {
        return this.agF.size() + "/" + this.agG.size() + "/" + this.agH.size();
    }

    public static a lO() {
        if (agz == null) {
            synchronized (a.class) {
                if (agz == null) {
                    agz = new a();
                }
            }
        }
        return agz;
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
                        lP();
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
            int size = this.agF.size();
            int i = 0;
            while (i < size && this.agF.get(i).getPriority() >= abstractRunnableC0016a.getPriority()) {
                i++;
            }
            this.agF.add(i, abstractRunnableC0016a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(AbstractRunnableC0016a abstractRunnableC0016a) {
        AbstractRunnableC0016a poll;
        c(abstractRunnableC0016a);
        if (!abstractRunnableC0016a.isCancelled()) {
            abstractRunnableC0016a.setTimeout(true);
            this.agH.add(abstractRunnableC0016a);
            if (this.agH.size() > 242 && (poll = this.agH.poll()) != null) {
                poll.lM();
            }
        } else {
            BdLog.e("task TimeOut but it's cancelled()");
        }
        e(null);
    }

    private synchronized void c(AbstractRunnableC0016a abstractRunnableC0016a) {
        if (abstractRunnableC0016a != null) {
            if (abstractRunnableC0016a.lR()) {
                this.agH.remove(abstractRunnableC0016a);
            } else {
                this.agG.remove(abstractRunnableC0016a);
                this.mHandler.removeMessages(1, abstractRunnableC0016a);
                switch (abstractRunnableC0016a.getPriority()) {
                    case 1:
                        this.agD--;
                        break;
                    case 2:
                        this.agC--;
                        break;
                    case 3:
                        this.agB--;
                        break;
                    case 4:
                        this.agA--;
                        break;
                }
                int lS = abstractRunnableC0016a.lS();
                if (lS != 0) {
                    int i = this.agE.get(lS) - 1;
                    if (i <= 0) {
                        this.agE.delete(lS);
                    } else {
                        this.agE.put(lS, i);
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
            this.agG.add(abstractRunnableC0016a);
            this.agF.remove(abstractRunnableC0016a);
            THREAD_POOL_EXECUTOR.execute(abstractRunnableC0016a);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, abstractRunnableC0016a), 180000L);
            switch (abstractRunnableC0016a.getPriority()) {
                case 1:
                    this.agD++;
                    break;
                case 2:
                    this.agC++;
                    break;
                case 3:
                    this.agB++;
                    break;
                case 4:
                    this.agA++;
                    if (this.agA >= 7) {
                        BdLog.e("SuperHight Task too much num = " + this.agA);
                        break;
                    }
                    break;
            }
            int lS = abstractRunnableC0016a.lS();
            if (lS != 0) {
                this.agE.put(lS, this.agE.get(lS, 0) + 1);
            }
        }
    }

    private boolean a(int i, AbstractRunnableC0016a abstractRunnableC0016a) {
        if (abstractRunnableC0016a == null) {
            return false;
        }
        BdAsyncTaskParallel.BdAsyncTaskParallelType lT = abstractRunnableC0016a.lT();
        return lT == BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL ? i < 1 : lT == BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL ? i < 2 : lT == BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL ? i < 3 : lT == BdAsyncTaskParallel.BdAsyncTaskParallelType.FOUR_PARALLEL ? i < 4 : lT != BdAsyncTaskParallel.BdAsyncTaskParallelType.CUSTOM_PARALLEL || i < abstractRunnableC0016a.lU();
    }

    protected synchronized void e(AbstractRunnableC0016a abstractRunnableC0016a) {
        c(abstractRunnableC0016a);
        int i = 0;
        while (true) {
            if (i < this.agF.size()) {
                AbstractRunnableC0016a abstractRunnableC0016a2 = this.agF.get(i);
                if (abstractRunnableC0016a2 != null) {
                    int lS = abstractRunnableC0016a2.lS();
                    switch (abstractRunnableC0016a2.getPriority()) {
                        case 1:
                            if (this.agB + this.agC + this.agD >= 5) {
                                break;
                            }
                            break;
                        case 2:
                            if (this.agB + this.agC + this.agD >= 6) {
                                break;
                            }
                            break;
                        case 3:
                            if (this.agB + this.agC + this.agD >= 7) {
                                break;
                            }
                            break;
                        case 4:
                            if (lS == 0) {
                                d(abstractRunnableC0016a2);
                                break;
                            }
                            break;
                    }
                    if (a(this.agE.get(lS), abstractRunnableC0016a2)) {
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
        a(this.agG, false, bdUniqueId, str);
        a(this.agH, false, bdUniqueId, str);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        removeAllWaitingTask(bdUniqueId, null);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        a(this.agF, true, bdUniqueId, str);
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
                    next.lM();
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
        Iterator<AbstractRunnableC0016a> it = this.agF.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AbstractRunnableC0016a next = it.next();
            if (next != null && next.lQ() == bdAsyncTask) {
                break;
            }
        }
    }

    public int getTaskNum(String str, BdUniqueId bdUniqueId) {
        return a(this.agF, str, bdUniqueId) + a(this.agG, str, bdUniqueId) + a(this.agH, str, bdUniqueId);
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
                    i = (!((str != null && tag == id && str.equals(next.getKey())) || (str == null && id != 0 && tag == id)) || next.lQ() == null || next.lQ().isCancelled()) ? i : i + 1;
                }
            }
        }
        return i;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchTask(String str) {
        BdAsyncTask<?, ?, ?> a;
        a = a(this.agF, str);
        if (a == null) {
            a = a(this.agG, str);
        }
        if (a == null) {
            a = a(this.agH, str);
        }
        return a;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return searchAllTask(bdUniqueId, null);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.agF, bdUniqueId, str);
        if (a != null) {
            linkedList.addAll(a);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.agG, bdUniqueId, str);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a3 = a(this.agH, bdUniqueId, str);
        if (a3 != null) {
            linkedList.addAll(a3);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return a(this.agF, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.agF, bdUniqueId, (String) null);
        if (a != null) {
            linkedList.addAll(a);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return a(this.agG, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
        r0 = r0.lQ();
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
                if (key != null && key.equals(str) && !next.lQ().isCancelled()) {
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
                    if (next.lQ() != null && !next.lQ().isCancelled()) {
                        linkedList3.add(next.lQ());
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
        private b<?> agK;

        public AbstractRunnableC0016a(b<?> bVar) {
            this.agK = null;
            if (bVar == null || bVar.lQ() == null) {
                throw new InvalidParameterException("parameter is null");
            }
            this.agK = bVar;
        }

        public void lP() {
            try {
                this.agK.run();
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }

        public void lM() {
            this.agK.lM();
        }

        public boolean isCancelled() {
            return this.agK.isCancelled();
        }

        public BdAsyncTask<?, ?, ?> lQ() {
            return this.agK.lQ();
        }

        public int getPriority() {
            return this.agK.lQ().getPriority();
        }

        public void setTimeout(boolean z) {
            this.agK.lQ().setTimeout(z);
        }

        public boolean lR() {
            return this.agK.lQ().isTimeout();
        }

        public int getTag() {
            return this.agK.lQ().getTag();
        }

        public int lS() {
            if (this.agK.lQ().getParallel() != null) {
                return this.agK.lQ().getParallel().getTag();
            }
            return 0;
        }

        public String getKey() {
            return this.agK.lQ().getKey();
        }

        public BdAsyncTaskParallel.BdAsyncTaskParallelType lT() {
            return this.agK.lQ().getParallel() != null ? this.agK.lQ().getParallel().lW() : BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
        }

        public int lU() {
            if (this.agK.lQ().getParallel() != null) {
                return this.agK.lQ().getParallel().lV();
            }
            return 1;
        }

        public boolean isSelfExecute() {
            return this.agK.lQ().isSelfExecute();
        }
    }
}
