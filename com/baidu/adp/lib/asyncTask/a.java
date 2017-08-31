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
    private volatile int sj = 0;
    private volatile int sk = 0;
    private volatile int sl = 0;
    private volatile int sm = 0;
    private final SparseIntArray so = new SparseIntArray();
    private final LinkedList<AbstractRunnableC0003a> sq = new LinkedList<>();
    private final LinkedList<AbstractRunnableC0003a> sr = new LinkedList<>();
    private final LinkedList<AbstractRunnableC0003a> ss = new LinkedList<>();
    private HandlerThread su;
    private static a si = null;
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
        this.su = null;
        this.mHandler = null;
        this.su = new HandlerThread("BdAsyncTaskExecutor");
        this.su.start();
        this.mHandler = new Handler(this.su.getLooper()) { // from class: com.baidu.adp.lib.asyncTask.a.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 1) {
                    if (message.obj != null && (message.obj instanceof AbstractRunnableC0003a)) {
                        a.this.b((AbstractRunnableC0003a) message.obj);
                    }
                } else if (message.what == 2 && message.obj != null && (message.obj instanceof AbstractRunnableC0003a)) {
                    a.this.e((AbstractRunnableC0003a) message.obj);
                    if (BdBaseApplication.getInst().isDebugMode()) {
                    }
                }
            }
        };
    }

    public String toString() {
        return "mWaitingTasks = " + this.sq.size() + " mRunningTasks = " + this.sr.size() + " mTimeOutTasks = " + this.ss.size();
    }

    public String ej() {
        return this.sq.size() + "/" + this.sr.size() + "/" + this.ss.size();
    }

    public static a ek() {
        if (si == null) {
            synchronized (a.class) {
                if (si == null) {
                    si = new a();
                }
            }
        }
        return si;
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        if (runnable instanceof b) {
            AbstractRunnableC0003a abstractRunnableC0003a = new AbstractRunnableC0003a((b) runnable) { // from class: com.baidu.adp.lib.asyncTask.a.3
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
                        el();
                    } finally {
                        if (!isSelfExecute()) {
                            a.this.mHandler.sendMessageDelayed(a.this.mHandler.obtainMessage(2, this), 1L);
                        }
                    }
                }
            };
            if (abstractRunnableC0003a.isSelfExecute()) {
                new Thread(abstractRunnableC0003a).start();
            } else {
                a(abstractRunnableC0003a);
                e(null);
                if (BdBaseApplication.getInst().isDebugMode()) {
                }
            }
        }
    }

    private synchronized void a(AbstractRunnableC0003a abstractRunnableC0003a) {
        if (abstractRunnableC0003a != null) {
            int size = this.sq.size();
            int i = 0;
            while (i < size && this.sq.get(i).getPriority() >= abstractRunnableC0003a.getPriority()) {
                i++;
            }
            this.sq.add(i, abstractRunnableC0003a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(AbstractRunnableC0003a abstractRunnableC0003a) {
        AbstractRunnableC0003a poll;
        c(abstractRunnableC0003a);
        if (!abstractRunnableC0003a.isCancelled()) {
            abstractRunnableC0003a.setTimeout(true);
            this.ss.add(abstractRunnableC0003a);
            if (this.ss.size() > 242 && (poll = this.ss.poll()) != null) {
                poll.ei();
            }
        } else {
            BdLog.e("task TimeOut but it's cancelled()");
        }
        e(null);
    }

    private synchronized void c(AbstractRunnableC0003a abstractRunnableC0003a) {
        if (abstractRunnableC0003a != null) {
            if (abstractRunnableC0003a.en()) {
                this.ss.remove(abstractRunnableC0003a);
            } else {
                this.sr.remove(abstractRunnableC0003a);
                this.mHandler.removeMessages(1, abstractRunnableC0003a);
                switch (abstractRunnableC0003a.getPriority()) {
                    case 1:
                        this.sm--;
                        break;
                    case 2:
                        this.sl--;
                        break;
                    case 3:
                        this.sk--;
                        break;
                    case 4:
                        this.sj--;
                        break;
                }
                int eo = abstractRunnableC0003a.eo();
                if (eo != 0) {
                    int i = this.so.get(eo) - 1;
                    if (i <= 0) {
                        this.so.delete(eo);
                    } else {
                        this.so.put(eo, i);
                    }
                    if (i < 0) {
                        BdLog.e("removeTask error < 0");
                    }
                }
            }
        }
    }

    private synchronized void d(AbstractRunnableC0003a abstractRunnableC0003a) {
        if (abstractRunnableC0003a != null) {
            this.sr.add(abstractRunnableC0003a);
            this.sq.remove(abstractRunnableC0003a);
            THREAD_POOL_EXECUTOR.execute(abstractRunnableC0003a);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, abstractRunnableC0003a), 180000L);
            switch (abstractRunnableC0003a.getPriority()) {
                case 1:
                    this.sm++;
                    break;
                case 2:
                    this.sl++;
                    break;
                case 3:
                    this.sk++;
                    break;
                case 4:
                    this.sj++;
                    if (this.sj >= 7) {
                        BdLog.e("SuperHight Task too much num = " + this.sj);
                        break;
                    }
                    break;
            }
            int eo = abstractRunnableC0003a.eo();
            if (eo != 0) {
                this.so.put(eo, this.so.get(eo, 0) + 1);
            }
        }
    }

    private boolean a(int i, AbstractRunnableC0003a abstractRunnableC0003a) {
        if (abstractRunnableC0003a == null) {
            return false;
        }
        BdAsyncTaskParallel.BdAsyncTaskParallelType ep = abstractRunnableC0003a.ep();
        return ep == BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL ? i < 1 : ep == BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL ? i < 2 : ep == BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL ? i < 3 : ep == BdAsyncTaskParallel.BdAsyncTaskParallelType.FOUR_PARALLEL ? i < 4 : ep != BdAsyncTaskParallel.BdAsyncTaskParallelType.CUSTOM_PARALLEL || i < abstractRunnableC0003a.eq();
    }

    protected synchronized void e(AbstractRunnableC0003a abstractRunnableC0003a) {
        c(abstractRunnableC0003a);
        int i = 0;
        while (true) {
            if (i < this.sq.size()) {
                AbstractRunnableC0003a abstractRunnableC0003a2 = this.sq.get(i);
                if (abstractRunnableC0003a2 != null) {
                    int eo = abstractRunnableC0003a2.eo();
                    switch (abstractRunnableC0003a2.getPriority()) {
                        case 1:
                            if (this.sk + this.sl + this.sm >= 5) {
                                break;
                            }
                            break;
                        case 2:
                            if (this.sk + this.sl + this.sm >= 6) {
                                break;
                            }
                            break;
                        case 3:
                            if (this.sk + this.sl + this.sm >= 7) {
                                break;
                            }
                            break;
                        case 4:
                            if (eo == 0) {
                                d(abstractRunnableC0003a2);
                                break;
                            }
                            break;
                    }
                    if (a(this.so.get(eo), abstractRunnableC0003a2)) {
                        d(abstractRunnableC0003a2);
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
        a(this.sr, false, bdUniqueId, str);
        a(this.ss, false, bdUniqueId, str);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        removeAllWaitingTask(bdUniqueId, null);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        a(this.sq, true, bdUniqueId, str);
    }

    private synchronized void a(LinkedList<AbstractRunnableC0003a> linkedList, boolean z, BdUniqueId bdUniqueId, String str) {
        if (bdUniqueId != null) {
            int id = bdUniqueId.getId();
            Iterator<AbstractRunnableC0003a> it = linkedList.iterator();
            while (it.hasNext()) {
                AbstractRunnableC0003a next = it.next();
                int tag = next.getTag();
                String key = next.getKey();
                if ((str != null && tag == id && str.equals(key)) || (str == null && id != 0 && tag == id)) {
                    if (z) {
                        it.remove();
                    }
                    next.ei();
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
        Iterator<AbstractRunnableC0003a> it = this.sq.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AbstractRunnableC0003a next = it.next();
            if (next != null && next.em() == bdAsyncTask) {
                break;
            }
        }
    }

    public int getTaskNum(String str, BdUniqueId bdUniqueId) {
        return a(this.sq, str, bdUniqueId) + a(this.sr, str, bdUniqueId) + a(this.ss, str, bdUniqueId);
    }

    private synchronized int a(LinkedList<AbstractRunnableC0003a> linkedList, String str, BdUniqueId bdUniqueId) {
        int i = 0;
        synchronized (this) {
            if (linkedList != null && bdUniqueId != null) {
                int id = bdUniqueId.getId();
                Iterator<AbstractRunnableC0003a> it = linkedList.iterator();
                while (it.hasNext()) {
                    AbstractRunnableC0003a next = it.next();
                    int tag = next.getTag();
                    i = (!((str != null && tag == id && str.equals(next.getKey())) || (str == null && id != 0 && tag == id)) || next.em() == null || next.em().isCancelled()) ? i : i + 1;
                }
            }
        }
        return i;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchTask(String str) {
        BdAsyncTask<?, ?, ?> a;
        a = a(this.sq, str);
        if (a == null) {
            a = a(this.sr, str);
        }
        if (a == null) {
            a = a(this.ss, str);
        }
        return a;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return searchAllTask(bdUniqueId, null);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.sq, bdUniqueId, str);
        if (a != null) {
            linkedList.addAll(a);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.sr, bdUniqueId, str);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a3 = a(this.ss, bdUniqueId, str);
        if (a3 != null) {
            linkedList.addAll(a3);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return a(this.sq, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.sq, bdUniqueId, (String) null);
        if (a != null) {
            linkedList.addAll(a);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return a(this.sr, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
        r0 = r0.em();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized BdAsyncTask<?, ?, ?> a(LinkedList<AbstractRunnableC0003a> linkedList, String str) {
        BdAsyncTask<?, ?, ?> bdAsyncTask;
        if (linkedList != null && str != null) {
            Iterator<AbstractRunnableC0003a> it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bdAsyncTask = null;
                    break;
                }
                AbstractRunnableC0003a next = it.next();
                String key = next.getKey();
                if (key != null && key.equals(str) && !next.em().isCancelled()) {
                    break;
                }
            }
        } else {
            bdAsyncTask = null;
        }
        return bdAsyncTask;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> a(LinkedList<AbstractRunnableC0003a> linkedList, BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList2;
        if (linkedList == null || bdUniqueId == null) {
            linkedList2 = null;
        } else {
            int id = bdUniqueId.getId();
            LinkedList<BdAsyncTask<?, ?, ?>> linkedList3 = new LinkedList<>();
            Iterator<AbstractRunnableC0003a> it = linkedList.iterator();
            while (it.hasNext()) {
                AbstractRunnableC0003a next = it.next();
                int tag = next.getTag();
                String key = next.getKey();
                if ((str != null && tag == id && str.equals(key)) || (str == null && id != 0 && tag == id)) {
                    if (next.em() != null && !next.em().isCancelled()) {
                        linkedList3.add(next.em());
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
    public static abstract class AbstractRunnableC0003a implements Runnable {
        private b<?> sw;

        public AbstractRunnableC0003a(b<?> bVar) {
            this.sw = null;
            if (bVar == null || bVar.em() == null) {
                throw new InvalidParameterException("parameter is null");
            }
            this.sw = bVar;
        }

        public void el() {
            try {
                this.sw.run();
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }

        public void ei() {
            this.sw.ei();
        }

        public boolean isCancelled() {
            return this.sw.isCancelled();
        }

        public BdAsyncTask<?, ?, ?> em() {
            return this.sw.em();
        }

        public int getPriority() {
            return this.sw.em().getPriority();
        }

        public void setTimeout(boolean z) {
            this.sw.em().setTimeout(z);
        }

        public boolean en() {
            return this.sw.em().isTimeout();
        }

        public int getTag() {
            return this.sw.em().getTag();
        }

        public int eo() {
            if (this.sw.em().getParallel() != null) {
                return this.sw.em().getParallel().getTag();
            }
            return 0;
        }

        public String getKey() {
            return this.sw.em().getKey();
        }

        public BdAsyncTaskParallel.BdAsyncTaskParallelType ep() {
            return this.sw.em().getParallel() != null ? this.sw.em().getParallel().es() : BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
        }

        public int eq() {
            if (this.sw.em().getParallel() != null) {
                return this.sw.em().getParallel().er();
            }
            return 1;
        }

        public boolean isSelfExecute() {
            return this.sw.em().isSelfExecute();
        }
    }
}
