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
    private HandlerThread uG;
    private static a ux = null;
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
    private volatile int uy = 0;
    private volatile int uz = 0;
    private volatile int uA = 0;
    private volatile int uB = 0;
    private final SparseIntArray uC = new SparseIntArray();
    private final LinkedList<AbstractRunnableC0004a> uD = new LinkedList<>();
    private final LinkedList<AbstractRunnableC0004a> uE = new LinkedList<>();
    private final LinkedList<AbstractRunnableC0004a> uF = new LinkedList<>();

    a() {
        this.uG = null;
        this.mHandler = null;
        this.uG = new HandlerThread("BdAsyncTaskExecutor");
        this.uG.start();
        this.mHandler = new Handler(this.uG.getLooper()) { // from class: com.baidu.adp.lib.asyncTask.a.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 1) {
                    if (message.obj != null && (message.obj instanceof AbstractRunnableC0004a)) {
                        a.this.b((AbstractRunnableC0004a) message.obj);
                    }
                } else if (message.what == 2 && message.obj != null && (message.obj instanceof AbstractRunnableC0004a)) {
                    a.this.e((AbstractRunnableC0004a) message.obj);
                    if (BdBaseApplication.getInst().isDebugMode()) {
                    }
                }
            }
        };
    }

    public String toString() {
        return "mWaitingTasks = " + this.uD.size() + " mRunningTasks = " + this.uE.size() + " mTimeOutTasks = " + this.uF.size();
    }

    public String eu() {
        return this.uD.size() + "/" + this.uE.size() + "/" + this.uF.size();
    }

    public static a ev() {
        if (ux == null) {
            synchronized (a.class) {
                if (ux == null) {
                    ux = new a();
                }
            }
        }
        return ux;
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        if (runnable instanceof b) {
            AbstractRunnableC0004a abstractRunnableC0004a = new AbstractRunnableC0004a((b) runnable) { // from class: com.baidu.adp.lib.asyncTask.a.3
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
                        ew();
                    } finally {
                        if (!isSelfExecute()) {
                            a.this.mHandler.sendMessageDelayed(a.this.mHandler.obtainMessage(2, this), 1L);
                        }
                    }
                }
            };
            if (abstractRunnableC0004a.isSelfExecute()) {
                new Thread(abstractRunnableC0004a).start();
            } else {
                a(abstractRunnableC0004a);
                e(null);
                if (BdBaseApplication.getInst().isDebugMode()) {
                }
            }
        }
    }

    private synchronized void a(AbstractRunnableC0004a abstractRunnableC0004a) {
        if (abstractRunnableC0004a != null) {
            int size = this.uD.size();
            int i = 0;
            while (i < size && this.uD.get(i).getPriority() >= abstractRunnableC0004a.getPriority()) {
                i++;
            }
            this.uD.add(i, abstractRunnableC0004a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(AbstractRunnableC0004a abstractRunnableC0004a) {
        AbstractRunnableC0004a poll;
        c(abstractRunnableC0004a);
        if (!abstractRunnableC0004a.isCancelled()) {
            abstractRunnableC0004a.setTimeout(true);
            this.uF.add(abstractRunnableC0004a);
            if (this.uF.size() > 242 && (poll = this.uF.poll()) != null) {
                poll.et();
            }
        } else {
            BdLog.e("task TimeOut but it's cancelled()");
        }
        e(null);
    }

    private synchronized void c(AbstractRunnableC0004a abstractRunnableC0004a) {
        if (abstractRunnableC0004a != null) {
            if (abstractRunnableC0004a.ey()) {
                this.uF.remove(abstractRunnableC0004a);
            } else {
                this.uE.remove(abstractRunnableC0004a);
                this.mHandler.removeMessages(1, abstractRunnableC0004a);
                switch (abstractRunnableC0004a.getPriority()) {
                    case 1:
                        this.uB--;
                        break;
                    case 2:
                        this.uA--;
                        break;
                    case 3:
                        this.uz--;
                        break;
                    case 4:
                        this.uy--;
                        break;
                }
                int ez = abstractRunnableC0004a.ez();
                if (ez != 0) {
                    int i = this.uC.get(ez) - 1;
                    if (i <= 0) {
                        this.uC.delete(ez);
                    } else {
                        this.uC.put(ez, i);
                    }
                    if (i < 0) {
                        BdLog.e("removeTask error < 0");
                    }
                }
            }
        }
    }

    private synchronized void d(AbstractRunnableC0004a abstractRunnableC0004a) {
        if (abstractRunnableC0004a != null) {
            this.uE.add(abstractRunnableC0004a);
            this.uD.remove(abstractRunnableC0004a);
            THREAD_POOL_EXECUTOR.execute(abstractRunnableC0004a);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, abstractRunnableC0004a), 180000L);
            switch (abstractRunnableC0004a.getPriority()) {
                case 1:
                    this.uB++;
                    break;
                case 2:
                    this.uA++;
                    break;
                case 3:
                    this.uz++;
                    break;
                case 4:
                    this.uy++;
                    if (this.uy >= 7) {
                        BdLog.e("SuperHight Task too much num = " + this.uy);
                        break;
                    }
                    break;
            }
            int ez = abstractRunnableC0004a.ez();
            if (ez != 0) {
                this.uC.put(ez, this.uC.get(ez, 0) + 1);
            }
        }
    }

    private boolean a(int i, AbstractRunnableC0004a abstractRunnableC0004a) {
        if (abstractRunnableC0004a == null) {
            return false;
        }
        BdAsyncTaskParallel.BdAsyncTaskParallelType eA = abstractRunnableC0004a.eA();
        return eA == BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL ? i < 1 : eA == BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL ? i < 2 : eA == BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL ? i < 3 : eA == BdAsyncTaskParallel.BdAsyncTaskParallelType.FOUR_PARALLEL ? i < 4 : eA != BdAsyncTaskParallel.BdAsyncTaskParallelType.CUSTOM_PARALLEL || i < abstractRunnableC0004a.eB();
    }

    protected synchronized void e(AbstractRunnableC0004a abstractRunnableC0004a) {
        c(abstractRunnableC0004a);
        int i = 0;
        while (true) {
            if (i < this.uD.size()) {
                AbstractRunnableC0004a abstractRunnableC0004a2 = this.uD.get(i);
                if (abstractRunnableC0004a2 != null) {
                    int ez = abstractRunnableC0004a2.ez();
                    switch (abstractRunnableC0004a2.getPriority()) {
                        case 1:
                            if (this.uz + this.uA + this.uB >= 5) {
                                break;
                            }
                            break;
                        case 2:
                            if (this.uz + this.uA + this.uB >= 6) {
                                break;
                            }
                            break;
                        case 3:
                            if (this.uz + this.uA + this.uB >= 7) {
                                break;
                            }
                            break;
                        case 4:
                            if (ez == 0) {
                                d(abstractRunnableC0004a2);
                                break;
                            }
                            break;
                    }
                    if (a(this.uC.get(ez), abstractRunnableC0004a2)) {
                        d(abstractRunnableC0004a2);
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
        a(this.uE, false, bdUniqueId, str);
        a(this.uF, false, bdUniqueId, str);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        removeAllWaitingTask(bdUniqueId, null);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        a(this.uD, true, bdUniqueId, str);
    }

    private synchronized void a(LinkedList<AbstractRunnableC0004a> linkedList, boolean z, BdUniqueId bdUniqueId, String str) {
        if (bdUniqueId != null) {
            int id = bdUniqueId.getId();
            Iterator<AbstractRunnableC0004a> it = linkedList.iterator();
            while (it.hasNext()) {
                AbstractRunnableC0004a next = it.next();
                int tag = next.getTag();
                String key = next.getKey();
                if ((str != null && tag == id && str.equals(key)) || (str == null && id != 0 && tag == id)) {
                    if (z) {
                        it.remove();
                    }
                    next.et();
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
        Iterator<AbstractRunnableC0004a> it = this.uD.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AbstractRunnableC0004a next = it.next();
            if (next != null && next.ex() == bdAsyncTask) {
                break;
            }
        }
    }

    public int getTaskNum(String str, BdUniqueId bdUniqueId) {
        return a(this.uD, str, bdUniqueId) + a(this.uE, str, bdUniqueId) + a(this.uF, str, bdUniqueId);
    }

    private synchronized int a(LinkedList<AbstractRunnableC0004a> linkedList, String str, BdUniqueId bdUniqueId) {
        int i = 0;
        synchronized (this) {
            if (linkedList != null && bdUniqueId != null) {
                int id = bdUniqueId.getId();
                Iterator<AbstractRunnableC0004a> it = linkedList.iterator();
                while (it.hasNext()) {
                    AbstractRunnableC0004a next = it.next();
                    int tag = next.getTag();
                    i = (!((str != null && tag == id && str.equals(next.getKey())) || (str == null && id != 0 && tag == id)) || next.ex() == null || next.ex().isCancelled()) ? i : i + 1;
                }
            }
        }
        return i;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchTask(String str) {
        BdAsyncTask<?, ?, ?> a;
        a = a(this.uD, str);
        if (a == null) {
            a = a(this.uE, str);
        }
        if (a == null) {
            a = a(this.uF, str);
        }
        return a;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return searchAllTask(bdUniqueId, null);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.uD, bdUniqueId, str);
        if (a != null) {
            linkedList.addAll(a);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.uE, bdUniqueId, str);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a3 = a(this.uF, bdUniqueId, str);
        if (a3 != null) {
            linkedList.addAll(a3);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return a(this.uD, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.uD, bdUniqueId, (String) null);
        if (a != null) {
            linkedList.addAll(a);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return a(this.uE, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
        r0 = r0.ex();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized BdAsyncTask<?, ?, ?> a(LinkedList<AbstractRunnableC0004a> linkedList, String str) {
        BdAsyncTask<?, ?, ?> bdAsyncTask;
        if (linkedList != null && str != null) {
            Iterator<AbstractRunnableC0004a> it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bdAsyncTask = null;
                    break;
                }
                AbstractRunnableC0004a next = it.next();
                String key = next.getKey();
                if (key != null && key.equals(str) && !next.ex().isCancelled()) {
                    break;
                }
            }
        } else {
            bdAsyncTask = null;
        }
        return bdAsyncTask;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> a(LinkedList<AbstractRunnableC0004a> linkedList, BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList2;
        if (linkedList == null || bdUniqueId == null) {
            linkedList2 = null;
        } else {
            int id = bdUniqueId.getId();
            LinkedList<BdAsyncTask<?, ?, ?>> linkedList3 = new LinkedList<>();
            Iterator<AbstractRunnableC0004a> it = linkedList.iterator();
            while (it.hasNext()) {
                AbstractRunnableC0004a next = it.next();
                int tag = next.getTag();
                String key = next.getKey();
                if ((str != null && tag == id && str.equals(key)) || (str == null && id != 0 && tag == id)) {
                    if (next.ex() != null && !next.ex().isCancelled()) {
                        linkedList3.add(next.ex());
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
    public static abstract class AbstractRunnableC0004a implements Runnable {
        private b<?> uI;

        public AbstractRunnableC0004a(b<?> bVar) {
            this.uI = null;
            if (bVar == null || bVar.ex() == null) {
                throw new InvalidParameterException("parameter is null");
            }
            this.uI = bVar;
        }

        public void ew() {
            try {
                this.uI.run();
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }

        public void et() {
            this.uI.et();
        }

        public boolean isCancelled() {
            return this.uI.isCancelled();
        }

        public BdAsyncTask<?, ?, ?> ex() {
            return this.uI.ex();
        }

        public int getPriority() {
            return this.uI.ex().getPriority();
        }

        public void setTimeout(boolean z) {
            this.uI.ex().setTimeout(z);
        }

        public boolean ey() {
            return this.uI.ex().isTimeout();
        }

        public int getTag() {
            return this.uI.ex().getTag();
        }

        public int ez() {
            if (this.uI.ex().getParallel() != null) {
                return this.uI.ex().getParallel().getTag();
            }
            return 0;
        }

        public String getKey() {
            return this.uI.ex().getKey();
        }

        public BdAsyncTaskParallel.BdAsyncTaskParallelType eA() {
            return this.uI.ex().getParallel() != null ? this.uI.ex().getParallel().eD() : BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
        }

        public int eB() {
            if (this.uI.ex().getParallel() != null) {
                return this.uI.ex().getParallel().eC();
            }
            return 1;
        }

        public boolean isSelfExecute() {
            return this.uI.ex().isSelfExecute();
        }
    }
}
