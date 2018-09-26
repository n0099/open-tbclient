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
    private static a zt = null;
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
    private volatile int zu = 0;
    private volatile int zv = 0;
    private volatile int zw = 0;
    private volatile int zx = 0;
    private final SparseIntArray zy = new SparseIntArray();
    private final LinkedList<AbstractRunnableC0013a> zz = new LinkedList<>();
    private final LinkedList<AbstractRunnableC0013a> zA = new LinkedList<>();
    private final LinkedList<AbstractRunnableC0013a> zB = new LinkedList<>();

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
        return "mWaitingTasks = " + this.zz.size() + " mRunningTasks = " + this.zA.size() + " mTimeOutTasks = " + this.zB.size();
    }

    public String hN() {
        return this.zz.size() + "/" + this.zA.size() + "/" + this.zB.size();
    }

    public static a hO() {
        if (zt == null) {
            synchronized (a.class) {
                if (zt == null) {
                    zt = new a();
                }
            }
        }
        return zt;
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
                        hP();
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
            int size = this.zz.size();
            int i = 0;
            while (i < size && this.zz.get(i).getPriority() >= abstractRunnableC0013a.getPriority()) {
                i++;
            }
            this.zz.add(i, abstractRunnableC0013a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(AbstractRunnableC0013a abstractRunnableC0013a) {
        AbstractRunnableC0013a poll;
        c(abstractRunnableC0013a);
        if (!abstractRunnableC0013a.isCancelled()) {
            abstractRunnableC0013a.setTimeout(true);
            this.zB.add(abstractRunnableC0013a);
            if (this.zB.size() > 242 && (poll = this.zB.poll()) != null) {
                poll.hM();
            }
        } else {
            BdLog.e("task TimeOut but it's cancelled()");
        }
        e(null);
    }

    private synchronized void c(AbstractRunnableC0013a abstractRunnableC0013a) {
        if (abstractRunnableC0013a != null) {
            if (abstractRunnableC0013a.hR()) {
                this.zB.remove(abstractRunnableC0013a);
            } else {
                this.zA.remove(abstractRunnableC0013a);
                this.mHandler.removeMessages(1, abstractRunnableC0013a);
                switch (abstractRunnableC0013a.getPriority()) {
                    case 1:
                        this.zx--;
                        break;
                    case 2:
                        this.zw--;
                        break;
                    case 3:
                        this.zv--;
                        break;
                    case 4:
                        this.zu--;
                        break;
                }
                int hS = abstractRunnableC0013a.hS();
                if (hS != 0) {
                    int i = this.zy.get(hS) - 1;
                    if (i <= 0) {
                        this.zy.delete(hS);
                    } else {
                        this.zy.put(hS, i);
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
            this.zA.add(abstractRunnableC0013a);
            this.zz.remove(abstractRunnableC0013a);
            THREAD_POOL_EXECUTOR.execute(abstractRunnableC0013a);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, abstractRunnableC0013a), 180000L);
            switch (abstractRunnableC0013a.getPriority()) {
                case 1:
                    this.zx++;
                    break;
                case 2:
                    this.zw++;
                    break;
                case 3:
                    this.zv++;
                    break;
                case 4:
                    this.zu++;
                    if (this.zu >= 7) {
                        BdLog.e("SuperHight Task too much num = " + this.zu);
                        break;
                    }
                    break;
            }
            int hS = abstractRunnableC0013a.hS();
            if (hS != 0) {
                this.zy.put(hS, this.zy.get(hS, 0) + 1);
            }
        }
    }

    private boolean a(int i, AbstractRunnableC0013a abstractRunnableC0013a) {
        if (abstractRunnableC0013a == null) {
            return false;
        }
        BdAsyncTaskParallel.BdAsyncTaskParallelType hT = abstractRunnableC0013a.hT();
        return hT == BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL ? i < 1 : hT == BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL ? i < 2 : hT == BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL ? i < 3 : hT == BdAsyncTaskParallel.BdAsyncTaskParallelType.FOUR_PARALLEL ? i < 4 : hT != BdAsyncTaskParallel.BdAsyncTaskParallelType.CUSTOM_PARALLEL || i < abstractRunnableC0013a.hU();
    }

    protected synchronized void e(AbstractRunnableC0013a abstractRunnableC0013a) {
        c(abstractRunnableC0013a);
        int i = 0;
        while (true) {
            if (i < this.zz.size()) {
                AbstractRunnableC0013a abstractRunnableC0013a2 = this.zz.get(i);
                if (abstractRunnableC0013a2 != null) {
                    int hS = abstractRunnableC0013a2.hS();
                    switch (abstractRunnableC0013a2.getPriority()) {
                        case 1:
                            if (this.zv + this.zw + this.zx >= 5) {
                                break;
                            }
                            break;
                        case 2:
                            if (this.zv + this.zw + this.zx >= 6) {
                                break;
                            }
                            break;
                        case 3:
                            if (this.zv + this.zw + this.zx >= 7) {
                                break;
                            }
                            break;
                        case 4:
                            if (hS == 0) {
                                d(abstractRunnableC0013a2);
                                break;
                            }
                            break;
                    }
                    if (a(this.zy.get(hS), abstractRunnableC0013a2)) {
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
        a(this.zA, false, bdUniqueId, str);
        a(this.zB, false, bdUniqueId, str);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        removeAllWaitingTask(bdUniqueId, null);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        a(this.zz, true, bdUniqueId, str);
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
                    next.hM();
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
        Iterator<AbstractRunnableC0013a> it = this.zz.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AbstractRunnableC0013a next = it.next();
            if (next != null && next.hQ() == bdAsyncTask) {
                break;
            }
        }
    }

    public int getTaskNum(String str, BdUniqueId bdUniqueId) {
        return a(this.zz, str, bdUniqueId) + a(this.zA, str, bdUniqueId) + a(this.zB, str, bdUniqueId);
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
                    i = (!((str != null && tag == id && str.equals(next.getKey())) || (str == null && id != 0 && tag == id)) || next.hQ() == null || next.hQ().isCancelled()) ? i : i + 1;
                }
            }
        }
        return i;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchTask(String str) {
        BdAsyncTask<?, ?, ?> a;
        a = a(this.zz, str);
        if (a == null) {
            a = a(this.zA, str);
        }
        if (a == null) {
            a = a(this.zB, str);
        }
        return a;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return searchAllTask(bdUniqueId, null);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.zz, bdUniqueId, str);
        if (a != null) {
            linkedList.addAll(a);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.zA, bdUniqueId, str);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a3 = a(this.zB, bdUniqueId, str);
        if (a3 != null) {
            linkedList.addAll(a3);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return a(this.zz, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.zz, bdUniqueId, (String) null);
        if (a != null) {
            linkedList.addAll(a);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return a(this.zA, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
        r0 = r0.hQ();
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
                if (key != null && key.equals(str) && !next.hQ().isCancelled()) {
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
                    if (next.hQ() != null && !next.hQ().isCancelled()) {
                        linkedList3.add(next.hQ());
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
        private b<?> zD;

        public AbstractRunnableC0013a(b<?> bVar) {
            this.zD = null;
            if (bVar == null || bVar.hQ() == null) {
                throw new InvalidParameterException("parameter is null");
            }
            this.zD = bVar;
        }

        public void hP() {
            try {
                this.zD.run();
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }

        public void hM() {
            this.zD.hM();
        }

        public boolean isCancelled() {
            return this.zD.isCancelled();
        }

        public BdAsyncTask<?, ?, ?> hQ() {
            return this.zD.hQ();
        }

        public int getPriority() {
            return this.zD.hQ().getPriority();
        }

        public void setTimeout(boolean z) {
            this.zD.hQ().setTimeout(z);
        }

        public boolean hR() {
            return this.zD.hQ().isTimeout();
        }

        public int getTag() {
            return this.zD.hQ().getTag();
        }

        public int hS() {
            if (this.zD.hQ().getParallel() != null) {
                return this.zD.hQ().getParallel().getTag();
            }
            return 0;
        }

        public String getKey() {
            return this.zD.hQ().getKey();
        }

        public BdAsyncTaskParallel.BdAsyncTaskParallelType hT() {
            return this.zD.hQ().getParallel() != null ? this.zD.hQ().getParallel().hW() : BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
        }

        public int hU() {
            if (this.zD.hQ().getParallel() != null) {
                return this.zD.hQ().getParallel().hV();
            }
            return 1;
        }

        public boolean isSelfExecute() {
            return this.zD.hQ().isSelfExecute();
        }
    }
}
