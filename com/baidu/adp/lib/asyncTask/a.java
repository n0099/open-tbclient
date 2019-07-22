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
    private volatile int xV = 0;
    private volatile int xW = 0;
    private volatile int xX = 0;
    private volatile int xY = 0;
    private final SparseIntArray xZ = new SparseIntArray();
    private final LinkedList<AbstractRunnableC0014a> ya = new LinkedList<>();
    private final LinkedList<AbstractRunnableC0014a> yb = new LinkedList<>();
    private final LinkedList<AbstractRunnableC0014a> yc = new LinkedList<>();
    private static a xU = null;
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
                    if (message.obj != null && (message.obj instanceof AbstractRunnableC0014a)) {
                        a.this.b((AbstractRunnableC0014a) message.obj);
                    }
                } else if (message.what == 2 && message.obj != null && (message.obj instanceof AbstractRunnableC0014a)) {
                    a.this.e((AbstractRunnableC0014a) message.obj);
                    if (BdBaseApplication.getInst().isDebugMode()) {
                    }
                }
            }
        };
    }

    public String toString() {
        return "mWaitingTasks = " + this.ya.size() + " mRunningTasks = " + this.yb.size() + " mTimeOutTasks = " + this.yc.size();
    }

    public String hd() {
        return this.ya.size() + "/" + this.yb.size() + "/" + this.yc.size();
    }

    public static a he() {
        if (xU == null) {
            synchronized (a.class) {
                if (xU == null) {
                    xU = new a();
                }
            }
        }
        return xU;
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        if (runnable instanceof b) {
            AbstractRunnableC0014a abstractRunnableC0014a = new AbstractRunnableC0014a((b) runnable) { // from class: com.baidu.adp.lib.asyncTask.a.3
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
                        hf();
                    } finally {
                        if (!isSelfExecute()) {
                            a.this.mHandler.sendMessageDelayed(a.this.mHandler.obtainMessage(2, this), 1L);
                        }
                    }
                }
            };
            if (abstractRunnableC0014a.isSelfExecute()) {
                new Thread(abstractRunnableC0014a).start();
            } else {
                a(abstractRunnableC0014a);
                e(null);
                if (BdBaseApplication.getInst().isDebugMode()) {
                }
            }
        }
    }

    private synchronized void a(AbstractRunnableC0014a abstractRunnableC0014a) {
        if (abstractRunnableC0014a != null) {
            int size = this.ya.size();
            int i = 0;
            while (i < size && this.ya.get(i).getPriority() >= abstractRunnableC0014a.getPriority()) {
                i++;
            }
            this.ya.add(i, abstractRunnableC0014a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(AbstractRunnableC0014a abstractRunnableC0014a) {
        AbstractRunnableC0014a poll;
        c(abstractRunnableC0014a);
        if (!abstractRunnableC0014a.isCancelled()) {
            abstractRunnableC0014a.setTimeout(true);
            this.yc.add(abstractRunnableC0014a);
            if (this.yc.size() > 242 && (poll = this.yc.poll()) != null) {
                poll.hc();
            }
        } else {
            BdLog.e("task TimeOut but it's cancelled()");
        }
        e(null);
    }

    private synchronized void c(AbstractRunnableC0014a abstractRunnableC0014a) {
        if (abstractRunnableC0014a != null) {
            if (abstractRunnableC0014a.hh()) {
                this.yc.remove(abstractRunnableC0014a);
            } else {
                this.yb.remove(abstractRunnableC0014a);
                this.mHandler.removeMessages(1, abstractRunnableC0014a);
                switch (abstractRunnableC0014a.getPriority()) {
                    case 1:
                        this.xY--;
                        break;
                    case 2:
                        this.xX--;
                        break;
                    case 3:
                        this.xW--;
                        break;
                    case 4:
                        this.xV--;
                        break;
                }
                int hi = abstractRunnableC0014a.hi();
                if (hi != 0) {
                    int i = this.xZ.get(hi) - 1;
                    if (i <= 0) {
                        this.xZ.delete(hi);
                    } else {
                        this.xZ.put(hi, i);
                    }
                    if (i < 0) {
                        BdLog.e("removeTask error < 0");
                    }
                }
            }
        }
    }

    private synchronized void d(AbstractRunnableC0014a abstractRunnableC0014a) {
        if (abstractRunnableC0014a != null) {
            this.yb.add(abstractRunnableC0014a);
            this.ya.remove(abstractRunnableC0014a);
            THREAD_POOL_EXECUTOR.execute(abstractRunnableC0014a);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, abstractRunnableC0014a), 180000L);
            switch (abstractRunnableC0014a.getPriority()) {
                case 1:
                    this.xY++;
                    break;
                case 2:
                    this.xX++;
                    break;
                case 3:
                    this.xW++;
                    break;
                case 4:
                    this.xV++;
                    if (this.xV >= 7) {
                        BdLog.e("SuperHight Task too much num = " + this.xV);
                        break;
                    }
                    break;
            }
            int hi = abstractRunnableC0014a.hi();
            if (hi != 0) {
                this.xZ.put(hi, this.xZ.get(hi, 0) + 1);
            }
        }
    }

    private boolean a(int i, AbstractRunnableC0014a abstractRunnableC0014a) {
        if (abstractRunnableC0014a == null) {
            return false;
        }
        BdAsyncTaskParallel.BdAsyncTaskParallelType hj = abstractRunnableC0014a.hj();
        return hj == BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL ? i < 1 : hj == BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL ? i < 2 : hj == BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL ? i < 3 : hj == BdAsyncTaskParallel.BdAsyncTaskParallelType.FOUR_PARALLEL ? i < 4 : hj != BdAsyncTaskParallel.BdAsyncTaskParallelType.CUSTOM_PARALLEL || i < abstractRunnableC0014a.hk();
    }

    protected synchronized void e(AbstractRunnableC0014a abstractRunnableC0014a) {
        c(abstractRunnableC0014a);
        int i = 0;
        while (true) {
            if (i < this.ya.size()) {
                AbstractRunnableC0014a abstractRunnableC0014a2 = this.ya.get(i);
                if (abstractRunnableC0014a2 != null) {
                    int hi = abstractRunnableC0014a2.hi();
                    switch (abstractRunnableC0014a2.getPriority()) {
                        case 1:
                            if (this.xW + this.xX + this.xY >= 5) {
                                break;
                            }
                            break;
                        case 2:
                            if (this.xW + this.xX + this.xY >= 6) {
                                break;
                            }
                            break;
                        case 3:
                            if (this.xW + this.xX + this.xY >= 7) {
                                break;
                            }
                            break;
                        case 4:
                            if (hi == 0) {
                                d(abstractRunnableC0014a2);
                                break;
                            }
                            break;
                    }
                    if (a(this.xZ.get(hi), abstractRunnableC0014a2)) {
                        d(abstractRunnableC0014a2);
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
        a(this.yb, false, bdUniqueId, str);
        a(this.yc, false, bdUniqueId, str);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        removeAllWaitingTask(bdUniqueId, null);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        a(this.ya, true, bdUniqueId, str);
    }

    private synchronized void a(LinkedList<AbstractRunnableC0014a> linkedList, boolean z, BdUniqueId bdUniqueId, String str) {
        if (bdUniqueId != null) {
            int id = bdUniqueId.getId();
            Iterator<AbstractRunnableC0014a> it = linkedList.iterator();
            while (it.hasNext()) {
                AbstractRunnableC0014a next = it.next();
                int tag = next.getTag();
                String key = next.getKey();
                if ((str != null && tag == id && str.equals(key)) || (str == null && id != 0 && tag == id)) {
                    if (z) {
                        it.remove();
                    }
                    next.hc();
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
        Iterator<AbstractRunnableC0014a> it = this.ya.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AbstractRunnableC0014a next = it.next();
            if (next != null && next.hg() == bdAsyncTask) {
                break;
            }
        }
    }

    public int getTaskNum(String str, BdUniqueId bdUniqueId) {
        return a(this.ya, str, bdUniqueId) + a(this.yb, str, bdUniqueId) + a(this.yc, str, bdUniqueId);
    }

    private synchronized int a(LinkedList<AbstractRunnableC0014a> linkedList, String str, BdUniqueId bdUniqueId) {
        int i = 0;
        synchronized (this) {
            if (linkedList != null && bdUniqueId != null) {
                int id = bdUniqueId.getId();
                Iterator<AbstractRunnableC0014a> it = linkedList.iterator();
                while (it.hasNext()) {
                    AbstractRunnableC0014a next = it.next();
                    int tag = next.getTag();
                    i = (!((str != null && tag == id && str.equals(next.getKey())) || (str == null && id != 0 && tag == id)) || next.hg() == null || next.hg().isCancelled()) ? i : i + 1;
                }
            }
        }
        return i;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchTask(String str) {
        BdAsyncTask<?, ?, ?> a;
        a = a(this.ya, str);
        if (a == null) {
            a = a(this.yb, str);
        }
        if (a == null) {
            a = a(this.yc, str);
        }
        return a;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return searchAllTask(bdUniqueId, null);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.ya, bdUniqueId, str);
        if (a != null) {
            linkedList.addAll(a);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.yb, bdUniqueId, str);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a3 = a(this.yc, bdUniqueId, str);
        if (a3 != null) {
            linkedList.addAll(a3);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return a(this.ya, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.ya, bdUniqueId, (String) null);
        if (a != null) {
            linkedList.addAll(a);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return a(this.yb, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
        r0 = r0.hg();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized BdAsyncTask<?, ?, ?> a(LinkedList<AbstractRunnableC0014a> linkedList, String str) {
        BdAsyncTask<?, ?, ?> bdAsyncTask;
        if (linkedList != null && str != null) {
            Iterator<AbstractRunnableC0014a> it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bdAsyncTask = null;
                    break;
                }
                AbstractRunnableC0014a next = it.next();
                String key = next.getKey();
                if (key != null && key.equals(str) && !next.hg().isCancelled()) {
                    break;
                }
            }
        } else {
            bdAsyncTask = null;
        }
        return bdAsyncTask;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> a(LinkedList<AbstractRunnableC0014a> linkedList, BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList2;
        if (linkedList == null || bdUniqueId == null) {
            linkedList2 = null;
        } else {
            int id = bdUniqueId.getId();
            LinkedList<BdAsyncTask<?, ?, ?>> linkedList3 = new LinkedList<>();
            Iterator<AbstractRunnableC0014a> it = linkedList.iterator();
            while (it.hasNext()) {
                AbstractRunnableC0014a next = it.next();
                int tag = next.getTag();
                String key = next.getKey();
                if ((str != null && tag == id && str.equals(key)) || (str == null && id != 0 && tag == id)) {
                    if (next.hg() != null && !next.hg().isCancelled()) {
                        linkedList3.add(next.hg());
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
    public static abstract class AbstractRunnableC0014a implements Runnable {
        private b<?> ye;

        public AbstractRunnableC0014a(b<?> bVar) {
            this.ye = null;
            if (bVar == null || bVar.hg() == null) {
                throw new InvalidParameterException("parameter is null");
            }
            this.ye = bVar;
        }

        public void hf() {
            try {
                this.ye.run();
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }

        public void hc() {
            this.ye.hc();
        }

        public boolean isCancelled() {
            return this.ye.isCancelled();
        }

        public BdAsyncTask<?, ?, ?> hg() {
            return this.ye.hg();
        }

        public int getPriority() {
            return this.ye.hg().getPriority();
        }

        public void setTimeout(boolean z) {
            this.ye.hg().setTimeout(z);
        }

        public boolean hh() {
            return this.ye.hg().isTimeout();
        }

        public int getTag() {
            return this.ye.hg().getTag();
        }

        public int hi() {
            if (this.ye.hg().getParallel() != null) {
                return this.ye.hg().getParallel().getTag();
            }
            return 0;
        }

        public String getKey() {
            return this.ye.hg().getKey();
        }

        public BdAsyncTaskParallel.BdAsyncTaskParallelType hj() {
            return this.ye.hg().getParallel() != null ? this.ye.hg().getParallel().hm() : BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
        }

        public int hk() {
            if (this.ye.hg().getParallel() != null) {
                return this.ye.hg().getParallel().hl();
            }
            return 1;
        }

        public boolean isSelfExecute() {
            return this.ye.hg().isSelfExecute();
        }
    }
}
