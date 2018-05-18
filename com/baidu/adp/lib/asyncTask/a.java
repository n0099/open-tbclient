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
    private volatile int qU = 0;
    private volatile int qV = 0;
    private volatile int qW = 0;
    private volatile int qX = 0;
    private final SparseIntArray qY = new SparseIntArray();
    private final LinkedList<AbstractRunnableC0005a> qZ = new LinkedList<>();
    private final LinkedList<AbstractRunnableC0005a> ra = new LinkedList<>();
    private final LinkedList<AbstractRunnableC0005a> rb = new LinkedList<>();
    private HandlerThread rc;
    private static a qT = null;
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
        this.rc = null;
        this.mHandler = null;
        this.rc = new HandlerThread("BdAsyncTaskExecutor");
        this.rc.start();
        this.mHandler = new Handler(this.rc.getLooper()) { // from class: com.baidu.adp.lib.asyncTask.a.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 1) {
                    if (message.obj != null && (message.obj instanceof AbstractRunnableC0005a)) {
                        a.this.b((AbstractRunnableC0005a) message.obj);
                    }
                } else if (message.what == 2 && message.obj != null && (message.obj instanceof AbstractRunnableC0005a)) {
                    a.this.e((AbstractRunnableC0005a) message.obj);
                    if (BdBaseApplication.getInst().isDebugMode()) {
                    }
                }
            }
        };
    }

    public String toString() {
        return "mWaitingTasks = " + this.qZ.size() + " mRunningTasks = " + this.ra.size() + " mTimeOutTasks = " + this.rb.size();
    }

    public String dR() {
        return this.qZ.size() + "/" + this.ra.size() + "/" + this.rb.size();
    }

    public static a dS() {
        if (qT == null) {
            synchronized (a.class) {
                if (qT == null) {
                    qT = new a();
                }
            }
        }
        return qT;
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        if (runnable instanceof b) {
            AbstractRunnableC0005a abstractRunnableC0005a = new AbstractRunnableC0005a((b) runnable) { // from class: com.baidu.adp.lib.asyncTask.a.3
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
                        dT();
                    } finally {
                        if (!isSelfExecute()) {
                            a.this.mHandler.sendMessageDelayed(a.this.mHandler.obtainMessage(2, this), 1L);
                        }
                    }
                }
            };
            if (abstractRunnableC0005a.isSelfExecute()) {
                new Thread(abstractRunnableC0005a).start();
            } else {
                a(abstractRunnableC0005a);
                e(null);
                if (BdBaseApplication.getInst().isDebugMode()) {
                }
            }
        }
    }

    private synchronized void a(AbstractRunnableC0005a abstractRunnableC0005a) {
        if (abstractRunnableC0005a != null) {
            int size = this.qZ.size();
            int i = 0;
            while (i < size && this.qZ.get(i).getPriority() >= abstractRunnableC0005a.getPriority()) {
                i++;
            }
            this.qZ.add(i, abstractRunnableC0005a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(AbstractRunnableC0005a abstractRunnableC0005a) {
        AbstractRunnableC0005a poll;
        c(abstractRunnableC0005a);
        if (!abstractRunnableC0005a.isCancelled()) {
            abstractRunnableC0005a.setTimeout(true);
            this.rb.add(abstractRunnableC0005a);
            if (this.rb.size() > 242 && (poll = this.rb.poll()) != null) {
                poll.dQ();
            }
        } else {
            BdLog.e("task TimeOut but it's cancelled()");
        }
        e(null);
    }

    private synchronized void c(AbstractRunnableC0005a abstractRunnableC0005a) {
        if (abstractRunnableC0005a != null) {
            if (abstractRunnableC0005a.dV()) {
                this.rb.remove(abstractRunnableC0005a);
            } else {
                this.ra.remove(abstractRunnableC0005a);
                this.mHandler.removeMessages(1, abstractRunnableC0005a);
                switch (abstractRunnableC0005a.getPriority()) {
                    case 1:
                        this.qX--;
                        break;
                    case 2:
                        this.qW--;
                        break;
                    case 3:
                        this.qV--;
                        break;
                    case 4:
                        this.qU--;
                        break;
                }
                int dW = abstractRunnableC0005a.dW();
                if (dW != 0) {
                    int i = this.qY.get(dW) - 1;
                    if (i <= 0) {
                        this.qY.delete(dW);
                    } else {
                        this.qY.put(dW, i);
                    }
                    if (i < 0) {
                        BdLog.e("removeTask error < 0");
                    }
                }
            }
        }
    }

    private synchronized void d(AbstractRunnableC0005a abstractRunnableC0005a) {
        if (abstractRunnableC0005a != null) {
            this.ra.add(abstractRunnableC0005a);
            this.qZ.remove(abstractRunnableC0005a);
            THREAD_POOL_EXECUTOR.execute(abstractRunnableC0005a);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, abstractRunnableC0005a), 180000L);
            switch (abstractRunnableC0005a.getPriority()) {
                case 1:
                    this.qX++;
                    break;
                case 2:
                    this.qW++;
                    break;
                case 3:
                    this.qV++;
                    break;
                case 4:
                    this.qU++;
                    if (this.qU >= 7) {
                        BdLog.e("SuperHight Task too much num = " + this.qU);
                        break;
                    }
                    break;
            }
            int dW = abstractRunnableC0005a.dW();
            if (dW != 0) {
                this.qY.put(dW, this.qY.get(dW, 0) + 1);
            }
        }
    }

    private boolean a(int i, AbstractRunnableC0005a abstractRunnableC0005a) {
        if (abstractRunnableC0005a == null) {
            return false;
        }
        BdAsyncTaskParallel.BdAsyncTaskParallelType dX = abstractRunnableC0005a.dX();
        return dX == BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL ? i < 1 : dX == BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL ? i < 2 : dX == BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL ? i < 3 : dX == BdAsyncTaskParallel.BdAsyncTaskParallelType.FOUR_PARALLEL ? i < 4 : dX != BdAsyncTaskParallel.BdAsyncTaskParallelType.CUSTOM_PARALLEL || i < abstractRunnableC0005a.dY();
    }

    protected synchronized void e(AbstractRunnableC0005a abstractRunnableC0005a) {
        c(abstractRunnableC0005a);
        int i = 0;
        while (true) {
            if (i < this.qZ.size()) {
                AbstractRunnableC0005a abstractRunnableC0005a2 = this.qZ.get(i);
                if (abstractRunnableC0005a2 != null) {
                    int dW = abstractRunnableC0005a2.dW();
                    switch (abstractRunnableC0005a2.getPriority()) {
                        case 1:
                            if (this.qV + this.qW + this.qX >= 5) {
                                break;
                            }
                            break;
                        case 2:
                            if (this.qV + this.qW + this.qX >= 6) {
                                break;
                            }
                            break;
                        case 3:
                            if (this.qV + this.qW + this.qX >= 7) {
                                break;
                            }
                            break;
                        case 4:
                            if (dW == 0) {
                                d(abstractRunnableC0005a2);
                                break;
                            }
                            break;
                    }
                    if (a(this.qY.get(dW), abstractRunnableC0005a2)) {
                        d(abstractRunnableC0005a2);
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
        a(this.ra, false, bdUniqueId, str);
        a(this.rb, false, bdUniqueId, str);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        removeAllWaitingTask(bdUniqueId, null);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        a(this.qZ, true, bdUniqueId, str);
    }

    private synchronized void a(LinkedList<AbstractRunnableC0005a> linkedList, boolean z, BdUniqueId bdUniqueId, String str) {
        if (bdUniqueId != null) {
            int id = bdUniqueId.getId();
            Iterator<AbstractRunnableC0005a> it = linkedList.iterator();
            while (it.hasNext()) {
                AbstractRunnableC0005a next = it.next();
                int tag = next.getTag();
                String key = next.getKey();
                if ((str != null && tag == id && str.equals(key)) || (str == null && id != 0 && tag == id)) {
                    if (z) {
                        it.remove();
                    }
                    next.dQ();
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
        Iterator<AbstractRunnableC0005a> it = this.qZ.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AbstractRunnableC0005a next = it.next();
            if (next != null && next.dU() == bdAsyncTask) {
                break;
            }
        }
    }

    public int getTaskNum(String str, BdUniqueId bdUniqueId) {
        return a(this.qZ, str, bdUniqueId) + a(this.ra, str, bdUniqueId) + a(this.rb, str, bdUniqueId);
    }

    private synchronized int a(LinkedList<AbstractRunnableC0005a> linkedList, String str, BdUniqueId bdUniqueId) {
        int i = 0;
        synchronized (this) {
            if (linkedList != null && bdUniqueId != null) {
                int id = bdUniqueId.getId();
                Iterator<AbstractRunnableC0005a> it = linkedList.iterator();
                while (it.hasNext()) {
                    AbstractRunnableC0005a next = it.next();
                    int tag = next.getTag();
                    i = (!((str != null && tag == id && str.equals(next.getKey())) || (str == null && id != 0 && tag == id)) || next.dU() == null || next.dU().isCancelled()) ? i : i + 1;
                }
            }
        }
        return i;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchTask(String str) {
        BdAsyncTask<?, ?, ?> a;
        a = a(this.qZ, str);
        if (a == null) {
            a = a(this.ra, str);
        }
        if (a == null) {
            a = a(this.rb, str);
        }
        return a;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return searchAllTask(bdUniqueId, null);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.qZ, bdUniqueId, str);
        if (a != null) {
            linkedList.addAll(a);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.ra, bdUniqueId, str);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a3 = a(this.rb, bdUniqueId, str);
        if (a3 != null) {
            linkedList.addAll(a3);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return a(this.qZ, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.qZ, bdUniqueId, (String) null);
        if (a != null) {
            linkedList.addAll(a);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return a(this.ra, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
        r0 = r0.dU();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized BdAsyncTask<?, ?, ?> a(LinkedList<AbstractRunnableC0005a> linkedList, String str) {
        BdAsyncTask<?, ?, ?> bdAsyncTask;
        if (linkedList != null && str != null) {
            Iterator<AbstractRunnableC0005a> it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bdAsyncTask = null;
                    break;
                }
                AbstractRunnableC0005a next = it.next();
                String key = next.getKey();
                if (key != null && key.equals(str) && !next.dU().isCancelled()) {
                    break;
                }
            }
        } else {
            bdAsyncTask = null;
        }
        return bdAsyncTask;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> a(LinkedList<AbstractRunnableC0005a> linkedList, BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList2;
        if (linkedList == null || bdUniqueId == null) {
            linkedList2 = null;
        } else {
            int id = bdUniqueId.getId();
            LinkedList<BdAsyncTask<?, ?, ?>> linkedList3 = new LinkedList<>();
            Iterator<AbstractRunnableC0005a> it = linkedList.iterator();
            while (it.hasNext()) {
                AbstractRunnableC0005a next = it.next();
                int tag = next.getTag();
                String key = next.getKey();
                if ((str != null && tag == id && str.equals(key)) || (str == null && id != 0 && tag == id)) {
                    if (next.dU() != null && !next.dU().isCancelled()) {
                        linkedList3.add(next.dU());
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
    public static abstract class AbstractRunnableC0005a implements Runnable {
        private b<?> re;

        public AbstractRunnableC0005a(b<?> bVar) {
            this.re = null;
            if (bVar == null || bVar.dU() == null) {
                throw new InvalidParameterException("parameter is null");
            }
            this.re = bVar;
        }

        public void dT() {
            try {
                this.re.run();
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }

        public void dQ() {
            this.re.dQ();
        }

        public boolean isCancelled() {
            return this.re.isCancelled();
        }

        public BdAsyncTask<?, ?, ?> dU() {
            return this.re.dU();
        }

        public int getPriority() {
            return this.re.dU().getPriority();
        }

        public void setTimeout(boolean z) {
            this.re.dU().setTimeout(z);
        }

        public boolean dV() {
            return this.re.dU().isTimeout();
        }

        public int getTag() {
            return this.re.dU().getTag();
        }

        public int dW() {
            if (this.re.dU().getParallel() != null) {
                return this.re.dU().getParallel().getTag();
            }
            return 0;
        }

        public String getKey() {
            return this.re.dU().getKey();
        }

        public BdAsyncTaskParallel.BdAsyncTaskParallelType dX() {
            return this.re.dU().getParallel() != null ? this.re.dU().getParallel().ea() : BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
        }

        public int dY() {
            if (this.re.dU().getParallel() != null) {
                return this.re.dU().getParallel().dZ();
            }
            return 1;
        }

        public boolean isSelfExecute() {
            return this.re.dU().isSelfExecute();
        }
    }
}
