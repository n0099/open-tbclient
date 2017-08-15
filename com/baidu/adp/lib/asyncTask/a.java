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
    private volatile int uA = 0;
    private volatile int uB = 0;
    private volatile int uC = 0;
    private volatile int uD = 0;
    private final SparseIntArray uE = new SparseIntArray();
    private final LinkedList<AbstractRunnableC0003a> uF = new LinkedList<>();
    private final LinkedList<AbstractRunnableC0003a> uG = new LinkedList<>();
    private final LinkedList<AbstractRunnableC0003a> uH = new LinkedList<>();
    private HandlerThread uI;
    private static a uz = null;
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
        this.uI = null;
        this.mHandler = null;
        this.uI = new HandlerThread("BdAsyncTaskExecutor");
        this.uI.start();
        this.mHandler = new Handler(this.uI.getLooper()) { // from class: com.baidu.adp.lib.asyncTask.a.2
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
        return "mWaitingTasks = " + this.uF.size() + " mRunningTasks = " + this.uG.size() + " mTimeOutTasks = " + this.uH.size();
    }

    public String eu() {
        return this.uF.size() + "/" + this.uG.size() + "/" + this.uH.size();
    }

    public static a ev() {
        if (uz == null) {
            synchronized (a.class) {
                if (uz == null) {
                    uz = new a();
                }
            }
        }
        return uz;
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
                        ew();
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
            int size = this.uF.size();
            int i = 0;
            while (i < size && this.uF.get(i).getPriority() >= abstractRunnableC0003a.getPriority()) {
                i++;
            }
            this.uF.add(i, abstractRunnableC0003a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(AbstractRunnableC0003a abstractRunnableC0003a) {
        AbstractRunnableC0003a poll;
        c(abstractRunnableC0003a);
        if (!abstractRunnableC0003a.isCancelled()) {
            abstractRunnableC0003a.setTimeout(true);
            this.uH.add(abstractRunnableC0003a);
            if (this.uH.size() > 242 && (poll = this.uH.poll()) != null) {
                poll.et();
            }
        } else {
            BdLog.e("task TimeOut but it's cancelled()");
        }
        e(null);
    }

    private synchronized void c(AbstractRunnableC0003a abstractRunnableC0003a) {
        if (abstractRunnableC0003a != null) {
            if (abstractRunnableC0003a.ey()) {
                this.uH.remove(abstractRunnableC0003a);
            } else {
                this.uG.remove(abstractRunnableC0003a);
                this.mHandler.removeMessages(1, abstractRunnableC0003a);
                switch (abstractRunnableC0003a.getPriority()) {
                    case 1:
                        this.uD--;
                        break;
                    case 2:
                        this.uC--;
                        break;
                    case 3:
                        this.uB--;
                        break;
                    case 4:
                        this.uA--;
                        break;
                }
                int ez = abstractRunnableC0003a.ez();
                if (ez != 0) {
                    int i = this.uE.get(ez) - 1;
                    if (i <= 0) {
                        this.uE.delete(ez);
                    } else {
                        this.uE.put(ez, i);
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
            this.uG.add(abstractRunnableC0003a);
            this.uF.remove(abstractRunnableC0003a);
            THREAD_POOL_EXECUTOR.execute(abstractRunnableC0003a);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, abstractRunnableC0003a), 180000L);
            switch (abstractRunnableC0003a.getPriority()) {
                case 1:
                    this.uD++;
                    break;
                case 2:
                    this.uC++;
                    break;
                case 3:
                    this.uB++;
                    break;
                case 4:
                    this.uA++;
                    if (this.uA >= 7) {
                        BdLog.e("SuperHight Task too much num = " + this.uA);
                        break;
                    }
                    break;
            }
            int ez = abstractRunnableC0003a.ez();
            if (ez != 0) {
                this.uE.put(ez, this.uE.get(ez, 0) + 1);
            }
        }
    }

    private boolean a(int i, AbstractRunnableC0003a abstractRunnableC0003a) {
        if (abstractRunnableC0003a == null) {
            return false;
        }
        BdAsyncTaskParallel.BdAsyncTaskParallelType eA = abstractRunnableC0003a.eA();
        return eA == BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL ? i < 1 : eA == BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL ? i < 2 : eA == BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL ? i < 3 : eA == BdAsyncTaskParallel.BdAsyncTaskParallelType.FOUR_PARALLEL ? i < 4 : eA != BdAsyncTaskParallel.BdAsyncTaskParallelType.CUSTOM_PARALLEL || i < abstractRunnableC0003a.eB();
    }

    protected synchronized void e(AbstractRunnableC0003a abstractRunnableC0003a) {
        c(abstractRunnableC0003a);
        int i = 0;
        while (true) {
            if (i < this.uF.size()) {
                AbstractRunnableC0003a abstractRunnableC0003a2 = this.uF.get(i);
                if (abstractRunnableC0003a2 != null) {
                    int ez = abstractRunnableC0003a2.ez();
                    switch (abstractRunnableC0003a2.getPriority()) {
                        case 1:
                            if (this.uB + this.uC + this.uD >= 5) {
                                break;
                            }
                            break;
                        case 2:
                            if (this.uB + this.uC + this.uD >= 6) {
                                break;
                            }
                            break;
                        case 3:
                            if (this.uB + this.uC + this.uD >= 7) {
                                break;
                            }
                            break;
                        case 4:
                            if (ez == 0) {
                                d(abstractRunnableC0003a2);
                                break;
                            }
                            break;
                    }
                    if (a(this.uE.get(ez), abstractRunnableC0003a2)) {
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
        a(this.uG, false, bdUniqueId, str);
        a(this.uH, false, bdUniqueId, str);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        removeAllWaitingTask(bdUniqueId, null);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        a(this.uF, true, bdUniqueId, str);
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
        Iterator<AbstractRunnableC0003a> it = this.uF.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AbstractRunnableC0003a next = it.next();
            if (next != null && next.ex() == bdAsyncTask) {
                break;
            }
        }
    }

    public int getTaskNum(String str, BdUniqueId bdUniqueId) {
        return a(this.uF, str, bdUniqueId) + a(this.uG, str, bdUniqueId) + a(this.uH, str, bdUniqueId);
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
                    i = (!((str != null && tag == id && str.equals(next.getKey())) || (str == null && id != 0 && tag == id)) || next.ex() == null || next.ex().isCancelled()) ? i : i + 1;
                }
            }
        }
        return i;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchTask(String str) {
        BdAsyncTask<?, ?, ?> a;
        a = a(this.uF, str);
        if (a == null) {
            a = a(this.uG, str);
        }
        if (a == null) {
            a = a(this.uH, str);
        }
        return a;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return searchAllTask(bdUniqueId, null);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.uF, bdUniqueId, str);
        if (a != null) {
            linkedList.addAll(a);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.uG, bdUniqueId, str);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a3 = a(this.uH, bdUniqueId, str);
        if (a3 != null) {
            linkedList.addAll(a3);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return a(this.uF, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.uF, bdUniqueId, (String) null);
        if (a != null) {
            linkedList.addAll(a);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return a(this.uG, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
        r0 = r0.ex();
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
                if (key != null && key.equals(str) && !next.ex().isCancelled()) {
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
    public static abstract class AbstractRunnableC0003a implements Runnable {
        private b<?> uK;

        public AbstractRunnableC0003a(b<?> bVar) {
            this.uK = null;
            if (bVar == null || bVar.ex() == null) {
                throw new InvalidParameterException("parameter is null");
            }
            this.uK = bVar;
        }

        public void ew() {
            try {
                this.uK.run();
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }

        public void et() {
            this.uK.et();
        }

        public boolean isCancelled() {
            return this.uK.isCancelled();
        }

        public BdAsyncTask<?, ?, ?> ex() {
            return this.uK.ex();
        }

        public int getPriority() {
            return this.uK.ex().getPriority();
        }

        public void setTimeout(boolean z) {
            this.uK.ex().setTimeout(z);
        }

        public boolean ey() {
            return this.uK.ex().isTimeout();
        }

        public int getTag() {
            return this.uK.ex().getTag();
        }

        public int ez() {
            if (this.uK.ex().getParallel() != null) {
                return this.uK.ex().getParallel().getTag();
            }
            return 0;
        }

        public String getKey() {
            return this.uK.ex().getKey();
        }

        public BdAsyncTaskParallel.BdAsyncTaskParallelType eA() {
            return this.uK.ex().getParallel() != null ? this.uK.ex().getParallel().eD() : BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
        }

        public int eB() {
            if (this.uK.ex().getParallel() != null) {
                return this.uK.ex().getParallel().eC();
            }
            return 1;
        }

        public boolean isSelfExecute() {
            return this.uK.ex().isSelfExecute();
        }
    }
}
