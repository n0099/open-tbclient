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
    private volatile int Ag = 0;
    private volatile int Ah = 0;
    private volatile int Ai = 0;
    private volatile int Aj = 0;
    private final SparseIntArray Ak = new SparseIntArray();
    private final LinkedList<AbstractRunnableC0014a> Al = new LinkedList<>();
    private final LinkedList<AbstractRunnableC0014a> Am = new LinkedList<>();
    private final LinkedList<AbstractRunnableC0014a> An = new LinkedList<>();
    private Handler mHandler;
    private HandlerThread sHandlerThread;
    private static a Af = null;
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
        return "mWaitingTasks = " + this.Al.size() + " mRunningTasks = " + this.Am.size() + " mTimeOutTasks = " + this.An.size();
    }

    public String ia() {
        return this.Al.size() + "/" + this.Am.size() + "/" + this.An.size();
    }

    public static a ib() {
        if (Af == null) {
            synchronized (a.class) {
                if (Af == null) {
                    Af = new a();
                }
            }
        }
        return Af;
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
                        ic();
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
            int size = this.Al.size();
            int i = 0;
            while (i < size && this.Al.get(i).getPriority() >= abstractRunnableC0014a.getPriority()) {
                i++;
            }
            this.Al.add(i, abstractRunnableC0014a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(AbstractRunnableC0014a abstractRunnableC0014a) {
        AbstractRunnableC0014a poll;
        c(abstractRunnableC0014a);
        if (!abstractRunnableC0014a.isCancelled()) {
            abstractRunnableC0014a.setTimeout(true);
            this.An.add(abstractRunnableC0014a);
            if (this.An.size() > 242 && (poll = this.An.poll()) != null) {
                poll.hZ();
            }
        } else {
            BdLog.e("task TimeOut but it's cancelled()");
        }
        e(null);
    }

    private synchronized void c(AbstractRunnableC0014a abstractRunnableC0014a) {
        if (abstractRunnableC0014a != null) {
            if (abstractRunnableC0014a.m9if()) {
                this.An.remove(abstractRunnableC0014a);
            } else {
                this.Am.remove(abstractRunnableC0014a);
                this.mHandler.removeMessages(1, abstractRunnableC0014a);
                switch (abstractRunnableC0014a.getPriority()) {
                    case 1:
                        this.Aj--;
                        break;
                    case 2:
                        this.Ai--;
                        break;
                    case 3:
                        this.Ah--;
                        break;
                    case 4:
                        this.Ag--;
                        break;
                }
                int ig = abstractRunnableC0014a.ig();
                if (ig != 0) {
                    int i = this.Ak.get(ig) - 1;
                    if (i <= 0) {
                        this.Ak.delete(ig);
                    } else {
                        this.Ak.put(ig, i);
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
            this.Am.add(abstractRunnableC0014a);
            this.Al.remove(abstractRunnableC0014a);
            THREAD_POOL_EXECUTOR.execute(abstractRunnableC0014a);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, abstractRunnableC0014a), 180000L);
            switch (abstractRunnableC0014a.getPriority()) {
                case 1:
                    this.Aj++;
                    break;
                case 2:
                    this.Ai++;
                    break;
                case 3:
                    this.Ah++;
                    break;
                case 4:
                    this.Ag++;
                    if (this.Ag >= 7) {
                        BdLog.e("SuperHight Task too much num = " + this.Ag);
                        break;
                    }
                    break;
            }
            int ig = abstractRunnableC0014a.ig();
            if (ig != 0) {
                this.Ak.put(ig, this.Ak.get(ig, 0) + 1);
            }
        }
    }

    private boolean a(int i, AbstractRunnableC0014a abstractRunnableC0014a) {
        if (abstractRunnableC0014a == null) {
            return false;
        }
        BdAsyncTaskParallel.BdAsyncTaskParallelType ih = abstractRunnableC0014a.ih();
        return ih == BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL ? i < 1 : ih == BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL ? i < 2 : ih == BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL ? i < 3 : ih == BdAsyncTaskParallel.BdAsyncTaskParallelType.FOUR_PARALLEL ? i < 4 : ih != BdAsyncTaskParallel.BdAsyncTaskParallelType.CUSTOM_PARALLEL || i < abstractRunnableC0014a.ii();
    }

    protected synchronized void e(AbstractRunnableC0014a abstractRunnableC0014a) {
        c(abstractRunnableC0014a);
        int i = 0;
        while (true) {
            if (i < this.Al.size()) {
                AbstractRunnableC0014a abstractRunnableC0014a2 = this.Al.get(i);
                if (abstractRunnableC0014a2 != null) {
                    int ig = abstractRunnableC0014a2.ig();
                    switch (abstractRunnableC0014a2.getPriority()) {
                        case 1:
                            if (this.Ah + this.Ai + this.Aj >= 5) {
                                break;
                            }
                            break;
                        case 2:
                            if (this.Ah + this.Ai + this.Aj >= 6) {
                                break;
                            }
                            break;
                        case 3:
                            if (this.Ah + this.Ai + this.Aj >= 7) {
                                break;
                            }
                            break;
                        case 4:
                            if (ig == 0) {
                                d(abstractRunnableC0014a2);
                                break;
                            }
                            break;
                    }
                    if (a(this.Ak.get(ig), abstractRunnableC0014a2)) {
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
        a(this.Am, false, bdUniqueId, str);
        a(this.An, false, bdUniqueId, str);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        removeAllWaitingTask(bdUniqueId, null);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        a(this.Al, true, bdUniqueId, str);
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
                    next.hZ();
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
        Iterator<AbstractRunnableC0014a> it = this.Al.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AbstractRunnableC0014a next = it.next();
            if (next != null && next.ie() == bdAsyncTask) {
                break;
            }
        }
    }

    public int getTaskNum(String str, BdUniqueId bdUniqueId) {
        return a(this.Al, str, bdUniqueId) + a(this.Am, str, bdUniqueId) + a(this.An, str, bdUniqueId);
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
                    i = (!((str != null && tag == id && str.equals(next.getKey())) || (str == null && id != 0 && tag == id)) || next.ie() == null || next.ie().isCancelled()) ? i : i + 1;
                }
            }
        }
        return i;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchTask(String str) {
        BdAsyncTask<?, ?, ?> a;
        a = a(this.Al, str);
        if (a == null) {
            a = a(this.Am, str);
        }
        if (a == null) {
            a = a(this.An, str);
        }
        return a;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return searchAllTask(bdUniqueId, null);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.Al, bdUniqueId, str);
        if (a != null) {
            linkedList.addAll(a);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.Am, bdUniqueId, str);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a3 = a(this.An, bdUniqueId, str);
        if (a3 != null) {
            linkedList.addAll(a3);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return a(this.Al, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.Al, bdUniqueId, (String) null);
        if (a != null) {
            linkedList.addAll(a);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return a(this.Am, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
        r0 = r0.ie();
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
                if (key != null && key.equals(str) && !next.ie().isCancelled()) {
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
                    if (next.ie() != null && !next.ie().isCancelled()) {
                        linkedList3.add(next.ie());
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
        private b<?> Ap;

        public AbstractRunnableC0014a(b<?> bVar) {
            this.Ap = null;
            if (bVar == null || bVar.ie() == null) {
                throw new InvalidParameterException("parameter is null");
            }
            this.Ap = bVar;
        }

        public void ic() {
            try {
                this.Ap.run();
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }

        public void hZ() {
            this.Ap.hZ();
        }

        public boolean isCancelled() {
            return this.Ap.isCancelled();
        }

        public BdAsyncTask<?, ?, ?> ie() {
            return this.Ap.ie();
        }

        public int getPriority() {
            return this.Ap.ie().getPriority();
        }

        public void setTimeout(boolean z) {
            this.Ap.ie().setTimeout(z);
        }

        /* renamed from: if  reason: not valid java name */
        public boolean m9if() {
            return this.Ap.ie().isTimeout();
        }

        public int getTag() {
            return this.Ap.ie().getTag();
        }

        public int ig() {
            if (this.Ap.ie().getParallel() != null) {
                return this.Ap.ie().getParallel().getTag();
            }
            return 0;
        }

        public String getKey() {
            return this.Ap.ie().getKey();
        }

        public BdAsyncTaskParallel.BdAsyncTaskParallelType ih() {
            return this.Ap.ie().getParallel() != null ? this.Ap.ie().getParallel().ik() : BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
        }

        public int ii() {
            if (this.Ap.ie().getParallel() != null) {
                return this.Ap.ie().getParallel().ij();
            }
            return 1;
        }

        public boolean isSelfExecute() {
            return this.Ap.ie().isSelfExecute();
        }
    }
}
