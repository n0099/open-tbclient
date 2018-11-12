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
    private volatile int Ah = 0;
    private volatile int Ai = 0;
    private volatile int Aj = 0;
    private volatile int Ak = 0;
    private final SparseIntArray Al = new SparseIntArray();
    private final LinkedList<AbstractRunnableC0016a> Am = new LinkedList<>();
    private final LinkedList<AbstractRunnableC0016a> An = new LinkedList<>();
    private final LinkedList<AbstractRunnableC0016a> Ao = new LinkedList<>();
    private Handler mHandler;
    private HandlerThread sHandlerThread;
    private static a Ag = null;
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
        return "mWaitingTasks = " + this.Am.size() + " mRunningTasks = " + this.An.size() + " mTimeOutTasks = " + this.Ao.size();
    }

    public String ib() {
        return this.Am.size() + "/" + this.An.size() + "/" + this.Ao.size();
    }

    public static a ic() {
        if (Ag == null) {
            synchronized (a.class) {
                if (Ag == null) {
                    Ag = new a();
                }
            }
        }
        return Ag;
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
                        id();
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
            int size = this.Am.size();
            int i = 0;
            while (i < size && this.Am.get(i).getPriority() >= abstractRunnableC0016a.getPriority()) {
                i++;
            }
            this.Am.add(i, abstractRunnableC0016a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(AbstractRunnableC0016a abstractRunnableC0016a) {
        AbstractRunnableC0016a poll;
        c(abstractRunnableC0016a);
        if (!abstractRunnableC0016a.isCancelled()) {
            abstractRunnableC0016a.setTimeout(true);
            this.Ao.add(abstractRunnableC0016a);
            if (this.Ao.size() > 242 && (poll = this.Ao.poll()) != null) {
                poll.ia();
            }
        } else {
            BdLog.e("task TimeOut but it's cancelled()");
        }
        e(null);
    }

    private synchronized void c(AbstractRunnableC0016a abstractRunnableC0016a) {
        if (abstractRunnableC0016a != null) {
            if (abstractRunnableC0016a.m9if()) {
                this.Ao.remove(abstractRunnableC0016a);
            } else {
                this.An.remove(abstractRunnableC0016a);
                this.mHandler.removeMessages(1, abstractRunnableC0016a);
                switch (abstractRunnableC0016a.getPriority()) {
                    case 1:
                        this.Ak--;
                        break;
                    case 2:
                        this.Aj--;
                        break;
                    case 3:
                        this.Ai--;
                        break;
                    case 4:
                        this.Ah--;
                        break;
                }
                int ig = abstractRunnableC0016a.ig();
                if (ig != 0) {
                    int i = this.Al.get(ig) - 1;
                    if (i <= 0) {
                        this.Al.delete(ig);
                    } else {
                        this.Al.put(ig, i);
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
            this.An.add(abstractRunnableC0016a);
            this.Am.remove(abstractRunnableC0016a);
            THREAD_POOL_EXECUTOR.execute(abstractRunnableC0016a);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, abstractRunnableC0016a), 180000L);
            switch (abstractRunnableC0016a.getPriority()) {
                case 1:
                    this.Ak++;
                    break;
                case 2:
                    this.Aj++;
                    break;
                case 3:
                    this.Ai++;
                    break;
                case 4:
                    this.Ah++;
                    if (this.Ah >= 7) {
                        BdLog.e("SuperHight Task too much num = " + this.Ah);
                        break;
                    }
                    break;
            }
            int ig = abstractRunnableC0016a.ig();
            if (ig != 0) {
                this.Al.put(ig, this.Al.get(ig, 0) + 1);
            }
        }
    }

    private boolean a(int i, AbstractRunnableC0016a abstractRunnableC0016a) {
        if (abstractRunnableC0016a == null) {
            return false;
        }
        BdAsyncTaskParallel.BdAsyncTaskParallelType ih = abstractRunnableC0016a.ih();
        return ih == BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL ? i < 1 : ih == BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL ? i < 2 : ih == BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL ? i < 3 : ih == BdAsyncTaskParallel.BdAsyncTaskParallelType.FOUR_PARALLEL ? i < 4 : ih != BdAsyncTaskParallel.BdAsyncTaskParallelType.CUSTOM_PARALLEL || i < abstractRunnableC0016a.ii();
    }

    protected synchronized void e(AbstractRunnableC0016a abstractRunnableC0016a) {
        c(abstractRunnableC0016a);
        int i = 0;
        while (true) {
            if (i < this.Am.size()) {
                AbstractRunnableC0016a abstractRunnableC0016a2 = this.Am.get(i);
                if (abstractRunnableC0016a2 != null) {
                    int ig = abstractRunnableC0016a2.ig();
                    switch (abstractRunnableC0016a2.getPriority()) {
                        case 1:
                            if (this.Ai + this.Aj + this.Ak >= 5) {
                                break;
                            }
                            break;
                        case 2:
                            if (this.Ai + this.Aj + this.Ak >= 6) {
                                break;
                            }
                            break;
                        case 3:
                            if (this.Ai + this.Aj + this.Ak >= 7) {
                                break;
                            }
                            break;
                        case 4:
                            if (ig == 0) {
                                d(abstractRunnableC0016a2);
                                break;
                            }
                            break;
                    }
                    if (a(this.Al.get(ig), abstractRunnableC0016a2)) {
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
        a(this.An, false, bdUniqueId, str);
        a(this.Ao, false, bdUniqueId, str);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        removeAllWaitingTask(bdUniqueId, null);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        a(this.Am, true, bdUniqueId, str);
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
                    next.ia();
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
        Iterator<AbstractRunnableC0016a> it = this.Am.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AbstractRunnableC0016a next = it.next();
            if (next != null && next.ie() == bdAsyncTask) {
                break;
            }
        }
    }

    public int getTaskNum(String str, BdUniqueId bdUniqueId) {
        return a(this.Am, str, bdUniqueId) + a(this.An, str, bdUniqueId) + a(this.Ao, str, bdUniqueId);
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
                    i = (!((str != null && tag == id && str.equals(next.getKey())) || (str == null && id != 0 && tag == id)) || next.ie() == null || next.ie().isCancelled()) ? i : i + 1;
                }
            }
        }
        return i;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchTask(String str) {
        BdAsyncTask<?, ?, ?> a;
        a = a(this.Am, str);
        if (a == null) {
            a = a(this.An, str);
        }
        if (a == null) {
            a = a(this.Ao, str);
        }
        return a;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return searchAllTask(bdUniqueId, null);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.Am, bdUniqueId, str);
        if (a != null) {
            linkedList.addAll(a);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.An, bdUniqueId, str);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a3 = a(this.Ao, bdUniqueId, str);
        if (a3 != null) {
            linkedList.addAll(a3);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return a(this.Am, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.Am, bdUniqueId, (String) null);
        if (a != null) {
            linkedList.addAll(a);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return a(this.An, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
        r0 = r0.ie();
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
                if (key != null && key.equals(str) && !next.ie().isCancelled()) {
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
    public static abstract class AbstractRunnableC0016a implements Runnable {
        private b<?> Aq;

        public AbstractRunnableC0016a(b<?> bVar) {
            this.Aq = null;
            if (bVar == null || bVar.ie() == null) {
                throw new InvalidParameterException("parameter is null");
            }
            this.Aq = bVar;
        }

        public void id() {
            try {
                this.Aq.run();
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }

        public void ia() {
            this.Aq.ia();
        }

        public boolean isCancelled() {
            return this.Aq.isCancelled();
        }

        public BdAsyncTask<?, ?, ?> ie() {
            return this.Aq.ie();
        }

        public int getPriority() {
            return this.Aq.ie().getPriority();
        }

        public void setTimeout(boolean z) {
            this.Aq.ie().setTimeout(z);
        }

        /* renamed from: if  reason: not valid java name */
        public boolean m9if() {
            return this.Aq.ie().isTimeout();
        }

        public int getTag() {
            return this.Aq.ie().getTag();
        }

        public int ig() {
            if (this.Aq.ie().getParallel() != null) {
                return this.Aq.ie().getParallel().getTag();
            }
            return 0;
        }

        public String getKey() {
            return this.Aq.ie().getKey();
        }

        public BdAsyncTaskParallel.BdAsyncTaskParallelType ih() {
            return this.Aq.ie().getParallel() != null ? this.Aq.ie().getParallel().ik() : BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
        }

        public int ii() {
            if (this.Aq.ie().getParallel() != null) {
                return this.Aq.ie().getParallel().ij();
            }
            return 1;
        }

        public boolean isSelfExecute() {
            return this.Aq.ie().isSelfExecute();
        }
    }
}
