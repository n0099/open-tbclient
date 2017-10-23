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
    private volatile int sk = 0;
    private volatile int sl = 0;
    private volatile int sm = 0;
    private volatile int so = 0;
    private final SparseIntArray sq = new SparseIntArray();
    private final LinkedList<AbstractRunnableC0003a> sr = new LinkedList<>();
    private final LinkedList<AbstractRunnableC0003a> ss = new LinkedList<>();
    private final LinkedList<AbstractRunnableC0003a> su = new LinkedList<>();
    private HandlerThread sv;
    private static a sj = null;
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
        this.sv = null;
        this.mHandler = null;
        this.sv = new HandlerThread("BdAsyncTaskExecutor");
        this.sv.start();
        this.mHandler = new Handler(this.sv.getLooper()) { // from class: com.baidu.adp.lib.asyncTask.a.2
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
        return "mWaitingTasks = " + this.sr.size() + " mRunningTasks = " + this.ss.size() + " mTimeOutTasks = " + this.su.size();
    }

    public String ei() {
        return this.sr.size() + "/" + this.ss.size() + "/" + this.su.size();
    }

    public static a ej() {
        if (sj == null) {
            synchronized (a.class) {
                if (sj == null) {
                    sj = new a();
                }
            }
        }
        return sj;
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
                        ek();
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
            int size = this.sr.size();
            int i = 0;
            while (i < size && this.sr.get(i).getPriority() >= abstractRunnableC0003a.getPriority()) {
                i++;
            }
            this.sr.add(i, abstractRunnableC0003a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(AbstractRunnableC0003a abstractRunnableC0003a) {
        AbstractRunnableC0003a poll;
        c(abstractRunnableC0003a);
        if (!abstractRunnableC0003a.isCancelled()) {
            abstractRunnableC0003a.setTimeout(true);
            this.su.add(abstractRunnableC0003a);
            if (this.su.size() > 242 && (poll = this.su.poll()) != null) {
                poll.eh();
            }
        } else {
            BdLog.e("task TimeOut but it's cancelled()");
        }
        e(null);
    }

    private synchronized void c(AbstractRunnableC0003a abstractRunnableC0003a) {
        if (abstractRunnableC0003a != null) {
            if (abstractRunnableC0003a.em()) {
                this.su.remove(abstractRunnableC0003a);
            } else {
                this.ss.remove(abstractRunnableC0003a);
                this.mHandler.removeMessages(1, abstractRunnableC0003a);
                switch (abstractRunnableC0003a.getPriority()) {
                    case 1:
                        this.so--;
                        break;
                    case 2:
                        this.sm--;
                        break;
                    case 3:
                        this.sl--;
                        break;
                    case 4:
                        this.sk--;
                        break;
                }
                int en = abstractRunnableC0003a.en();
                if (en != 0) {
                    int i = this.sq.get(en) - 1;
                    if (i <= 0) {
                        this.sq.delete(en);
                    } else {
                        this.sq.put(en, i);
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
            this.ss.add(abstractRunnableC0003a);
            this.sr.remove(abstractRunnableC0003a);
            THREAD_POOL_EXECUTOR.execute(abstractRunnableC0003a);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, abstractRunnableC0003a), 180000L);
            switch (abstractRunnableC0003a.getPriority()) {
                case 1:
                    this.so++;
                    break;
                case 2:
                    this.sm++;
                    break;
                case 3:
                    this.sl++;
                    break;
                case 4:
                    this.sk++;
                    if (this.sk >= 7) {
                        BdLog.e("SuperHight Task too much num = " + this.sk);
                        break;
                    }
                    break;
            }
            int en = abstractRunnableC0003a.en();
            if (en != 0) {
                this.sq.put(en, this.sq.get(en, 0) + 1);
            }
        }
    }

    private boolean a(int i, AbstractRunnableC0003a abstractRunnableC0003a) {
        if (abstractRunnableC0003a == null) {
            return false;
        }
        BdAsyncTaskParallel.BdAsyncTaskParallelType eo = abstractRunnableC0003a.eo();
        return eo == BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL ? i < 1 : eo == BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL ? i < 2 : eo == BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL ? i < 3 : eo == BdAsyncTaskParallel.BdAsyncTaskParallelType.FOUR_PARALLEL ? i < 4 : eo != BdAsyncTaskParallel.BdAsyncTaskParallelType.CUSTOM_PARALLEL || i < abstractRunnableC0003a.ep();
    }

    protected synchronized void e(AbstractRunnableC0003a abstractRunnableC0003a) {
        c(abstractRunnableC0003a);
        int i = 0;
        while (true) {
            if (i < this.sr.size()) {
                AbstractRunnableC0003a abstractRunnableC0003a2 = this.sr.get(i);
                if (abstractRunnableC0003a2 != null) {
                    int en = abstractRunnableC0003a2.en();
                    switch (abstractRunnableC0003a2.getPriority()) {
                        case 1:
                            if (this.sl + this.sm + this.so >= 5) {
                                break;
                            }
                            break;
                        case 2:
                            if (this.sl + this.sm + this.so >= 6) {
                                break;
                            }
                            break;
                        case 3:
                            if (this.sl + this.sm + this.so >= 7) {
                                break;
                            }
                            break;
                        case 4:
                            if (en == 0) {
                                d(abstractRunnableC0003a2);
                                break;
                            }
                            break;
                    }
                    if (a(this.sq.get(en), abstractRunnableC0003a2)) {
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
        a(this.ss, false, bdUniqueId, str);
        a(this.su, false, bdUniqueId, str);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        removeAllWaitingTask(bdUniqueId, null);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        a(this.sr, true, bdUniqueId, str);
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
                    next.eh();
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
        Iterator<AbstractRunnableC0003a> it = this.sr.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AbstractRunnableC0003a next = it.next();
            if (next != null && next.el() == bdAsyncTask) {
                break;
            }
        }
    }

    public int getTaskNum(String str, BdUniqueId bdUniqueId) {
        return a(this.sr, str, bdUniqueId) + a(this.ss, str, bdUniqueId) + a(this.su, str, bdUniqueId);
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
                    i = (!((str != null && tag == id && str.equals(next.getKey())) || (str == null && id != 0 && tag == id)) || next.el() == null || next.el().isCancelled()) ? i : i + 1;
                }
            }
        }
        return i;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchTask(String str) {
        BdAsyncTask<?, ?, ?> a;
        a = a(this.sr, str);
        if (a == null) {
            a = a(this.ss, str);
        }
        if (a == null) {
            a = a(this.su, str);
        }
        return a;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return searchAllTask(bdUniqueId, null);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.sr, bdUniqueId, str);
        if (a != null) {
            linkedList.addAll(a);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.ss, bdUniqueId, str);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a3 = a(this.su, bdUniqueId, str);
        if (a3 != null) {
            linkedList.addAll(a3);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return a(this.sr, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.sr, bdUniqueId, (String) null);
        if (a != null) {
            linkedList.addAll(a);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return a(this.ss, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
        r0 = r0.el();
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
                if (key != null && key.equals(str) && !next.el().isCancelled()) {
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
                    if (next.el() != null && !next.el().isCancelled()) {
                        linkedList3.add(next.el());
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
        private b<?> sx;

        public AbstractRunnableC0003a(b<?> bVar) {
            this.sx = null;
            if (bVar == null || bVar.el() == null) {
                throw new InvalidParameterException("parameter is null");
            }
            this.sx = bVar;
        }

        public void ek() {
            try {
                this.sx.run();
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }

        public void eh() {
            this.sx.eh();
        }

        public boolean isCancelled() {
            return this.sx.isCancelled();
        }

        public BdAsyncTask<?, ?, ?> el() {
            return this.sx.el();
        }

        public int getPriority() {
            return this.sx.el().getPriority();
        }

        public void setTimeout(boolean z) {
            this.sx.el().setTimeout(z);
        }

        public boolean em() {
            return this.sx.el().isTimeout();
        }

        public int getTag() {
            return this.sx.el().getTag();
        }

        public int en() {
            if (this.sx.el().getParallel() != null) {
                return this.sx.el().getParallel().getTag();
            }
            return 0;
        }

        public String getKey() {
            return this.sx.el().getKey();
        }

        public BdAsyncTaskParallel.BdAsyncTaskParallelType eo() {
            return this.sx.el().getParallel() != null ? this.sx.el().getParallel().er() : BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
        }

        public int ep() {
            if (this.sx.el().getParallel() != null) {
                return this.sx.el().getParallel().eq();
            }
            return 1;
        }

        public boolean isSelfExecute() {
            return this.sx.el().isSelfExecute();
        }
    }
}
