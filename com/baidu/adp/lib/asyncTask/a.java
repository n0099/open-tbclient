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
    private volatile int Ae = 0;
    private volatile int Af = 0;
    private volatile int Ag = 0;
    private volatile int Ah = 0;
    private final SparseIntArray Ai = new SparseIntArray();
    private final LinkedList<AbstractRunnableC0016a> Aj = new LinkedList<>();
    private final LinkedList<AbstractRunnableC0016a> Ak = new LinkedList<>();
    private final LinkedList<AbstractRunnableC0016a> Al = new LinkedList<>();
    private Handler mHandler;
    private HandlerThread sHandlerThread;
    private static a Ac = null;
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
        return "mWaitingTasks = " + this.Aj.size() + " mRunningTasks = " + this.Ak.size() + " mTimeOutTasks = " + this.Al.size();
    }

    public String ic() {
        return this.Aj.size() + "/" + this.Ak.size() + "/" + this.Al.size();
    }

    public static a id() {
        if (Ac == null) {
            synchronized (a.class) {
                if (Ac == null) {
                    Ac = new a();
                }
            }
        }
        return Ac;
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
                        ie();
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
            int size = this.Aj.size();
            int i = 0;
            while (i < size && this.Aj.get(i).getPriority() >= abstractRunnableC0016a.getPriority()) {
                i++;
            }
            this.Aj.add(i, abstractRunnableC0016a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(AbstractRunnableC0016a abstractRunnableC0016a) {
        AbstractRunnableC0016a poll;
        c(abstractRunnableC0016a);
        if (!abstractRunnableC0016a.isCancelled()) {
            abstractRunnableC0016a.setTimeout(true);
            this.Al.add(abstractRunnableC0016a);
            if (this.Al.size() > 242 && (poll = this.Al.poll()) != null) {
                poll.ib();
            }
        } else {
            BdLog.e("task TimeOut but it's cancelled()");
        }
        e(null);
    }

    private synchronized void c(AbstractRunnableC0016a abstractRunnableC0016a) {
        if (abstractRunnableC0016a != null) {
            if (abstractRunnableC0016a.ig()) {
                this.Al.remove(abstractRunnableC0016a);
            } else {
                this.Ak.remove(abstractRunnableC0016a);
                this.mHandler.removeMessages(1, abstractRunnableC0016a);
                switch (abstractRunnableC0016a.getPriority()) {
                    case 1:
                        this.Ah--;
                        break;
                    case 2:
                        this.Ag--;
                        break;
                    case 3:
                        this.Af--;
                        break;
                    case 4:
                        this.Ae--;
                        break;
                }
                int ih = abstractRunnableC0016a.ih();
                if (ih != 0) {
                    int i = this.Ai.get(ih) - 1;
                    if (i <= 0) {
                        this.Ai.delete(ih);
                    } else {
                        this.Ai.put(ih, i);
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
            this.Ak.add(abstractRunnableC0016a);
            this.Aj.remove(abstractRunnableC0016a);
            THREAD_POOL_EXECUTOR.execute(abstractRunnableC0016a);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, abstractRunnableC0016a), 180000L);
            switch (abstractRunnableC0016a.getPriority()) {
                case 1:
                    this.Ah++;
                    break;
                case 2:
                    this.Ag++;
                    break;
                case 3:
                    this.Af++;
                    break;
                case 4:
                    this.Ae++;
                    if (this.Ae >= 7) {
                        BdLog.e("SuperHight Task too much num = " + this.Ae);
                        break;
                    }
                    break;
            }
            int ih = abstractRunnableC0016a.ih();
            if (ih != 0) {
                this.Ai.put(ih, this.Ai.get(ih, 0) + 1);
            }
        }
    }

    private boolean a(int i, AbstractRunnableC0016a abstractRunnableC0016a) {
        if (abstractRunnableC0016a == null) {
            return false;
        }
        BdAsyncTaskParallel.BdAsyncTaskParallelType ii = abstractRunnableC0016a.ii();
        return ii == BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL ? i < 1 : ii == BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL ? i < 2 : ii == BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL ? i < 3 : ii == BdAsyncTaskParallel.BdAsyncTaskParallelType.FOUR_PARALLEL ? i < 4 : ii != BdAsyncTaskParallel.BdAsyncTaskParallelType.CUSTOM_PARALLEL || i < abstractRunnableC0016a.ij();
    }

    protected synchronized void e(AbstractRunnableC0016a abstractRunnableC0016a) {
        c(abstractRunnableC0016a);
        int i = 0;
        while (true) {
            if (i < this.Aj.size()) {
                AbstractRunnableC0016a abstractRunnableC0016a2 = this.Aj.get(i);
                if (abstractRunnableC0016a2 != null) {
                    int ih = abstractRunnableC0016a2.ih();
                    switch (abstractRunnableC0016a2.getPriority()) {
                        case 1:
                            if (this.Af + this.Ag + this.Ah >= 5) {
                                break;
                            }
                            break;
                        case 2:
                            if (this.Af + this.Ag + this.Ah >= 6) {
                                break;
                            }
                            break;
                        case 3:
                            if (this.Af + this.Ag + this.Ah >= 7) {
                                break;
                            }
                            break;
                        case 4:
                            if (ih == 0) {
                                d(abstractRunnableC0016a2);
                                break;
                            }
                            break;
                    }
                    if (a(this.Ai.get(ih), abstractRunnableC0016a2)) {
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
        a(this.Ak, false, bdUniqueId, str);
        a(this.Al, false, bdUniqueId, str);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        removeAllWaitingTask(bdUniqueId, null);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        a(this.Aj, true, bdUniqueId, str);
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
                    next.ib();
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
        Iterator<AbstractRunnableC0016a> it = this.Aj.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AbstractRunnableC0016a next = it.next();
            if (next != null && next.m9if() == bdAsyncTask) {
                break;
            }
        }
    }

    public int getTaskNum(String str, BdUniqueId bdUniqueId) {
        return a(this.Aj, str, bdUniqueId) + a(this.Ak, str, bdUniqueId) + a(this.Al, str, bdUniqueId);
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
                    i = (!((str != null && tag == id && str.equals(next.getKey())) || (str == null && id != 0 && tag == id)) || next.m9if() == null || next.m9if().isCancelled()) ? i : i + 1;
                }
            }
        }
        return i;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchTask(String str) {
        BdAsyncTask<?, ?, ?> a;
        a = a(this.Aj, str);
        if (a == null) {
            a = a(this.Ak, str);
        }
        if (a == null) {
            a = a(this.Al, str);
        }
        return a;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return searchAllTask(bdUniqueId, null);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.Aj, bdUniqueId, str);
        if (a != null) {
            linkedList.addAll(a);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.Ak, bdUniqueId, str);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a3 = a(this.Al, bdUniqueId, str);
        if (a3 != null) {
            linkedList.addAll(a3);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return a(this.Aj, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.Aj, bdUniqueId, (String) null);
        if (a != null) {
            linkedList.addAll(a);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return a(this.Ak, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
        r0 = r0.m9if();
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
                if (key != null && key.equals(str) && !next.m9if().isCancelled()) {
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
                    if (next.m9if() != null && !next.m9if().isCancelled()) {
                        linkedList3.add(next.m9if());
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
        private b<?> An;

        public AbstractRunnableC0016a(b<?> bVar) {
            this.An = null;
            if (bVar == null || bVar.m10if() == null) {
                throw new InvalidParameterException("parameter is null");
            }
            this.An = bVar;
        }

        public void ie() {
            try {
                this.An.run();
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }

        public void ib() {
            this.An.ib();
        }

        public boolean isCancelled() {
            return this.An.isCancelled();
        }

        /* renamed from: if  reason: not valid java name */
        public BdAsyncTask<?, ?, ?> m9if() {
            return this.An.m10if();
        }

        public int getPriority() {
            return this.An.m10if().getPriority();
        }

        public void setTimeout(boolean z) {
            this.An.m10if().setTimeout(z);
        }

        public boolean ig() {
            return this.An.m10if().isTimeout();
        }

        public int getTag() {
            return this.An.m10if().getTag();
        }

        public int ih() {
            if (this.An.m10if().getParallel() != null) {
                return this.An.m10if().getParallel().getTag();
            }
            return 0;
        }

        public String getKey() {
            return this.An.m10if().getKey();
        }

        public BdAsyncTaskParallel.BdAsyncTaskParallelType ii() {
            return this.An.m10if().getParallel() != null ? this.An.m10if().getParallel().il() : BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
        }

        public int ij() {
            if (this.An.m10if().getParallel() != null) {
                return this.An.m10if().getParallel().ik();
            }
            return 1;
        }

        public boolean isSelfExecute() {
            return this.An.m10if().isSelfExecute();
        }
    }
}
