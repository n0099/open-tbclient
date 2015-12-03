package com.baidu.adp.lib.asyncTask;

import android.os.Handler;
import android.os.HandlerThread;
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
/* loaded from: classes.dex */
public class c implements Executor {
    private Handler mHandler;
    private HandlerThread sG;
    private static c sx = null;
    private static final ThreadFactory sThreadFactory = new d();
    private static final BlockingQueue<Runnable> sPoolWorkQueue = new SynchronousQueue();
    public static final Executor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(7, 256, 30, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory, new ThreadPoolExecutor.DiscardPolicy());
    private volatile int sy = 0;
    private volatile int sz = 0;
    private volatile int sA = 0;
    private volatile int sB = 0;
    private final SparseIntArray sC = new SparseIntArray();
    private final LinkedList<a> sD = new LinkedList<>();
    private final LinkedList<a> sE = new LinkedList<>();
    private final LinkedList<a> sF = new LinkedList<>();

    c() {
        this.sG = null;
        this.mHandler = null;
        this.sG = new HandlerThread("BdAsyncTaskExecutor");
        this.sG.start();
        this.mHandler = new e(this, this.sG.getLooper());
    }

    public String toString() {
        return "mWaitingTasks = " + this.sD.size() + " mRunningTasks = " + this.sE.size() + " mTimeOutTasks = " + this.sF.size();
    }

    public String fN() {
        return String.valueOf(this.sD.size()) + "/" + this.sE.size() + "/" + this.sF.size();
    }

    public static c fO() {
        if (sx == null) {
            synchronized (c.class) {
                if (sx == null) {
                    sx = new c();
                }
            }
        }
        return sx;
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        if (runnable instanceof g) {
            f fVar = new f(this, (g) runnable);
            if (fVar.isSelfExecute()) {
                new Thread(fVar).start();
            } else {
                a(fVar);
                e(null);
                BdBaseApplication.getInst().isDebugMode();
            }
        }
    }

    private synchronized void a(a aVar) {
        if (aVar != null) {
            int size = this.sD.size();
            int i = 0;
            while (i < size && this.sD.get(i).getPriority() >= aVar.getPriority()) {
                i++;
            }
            this.sD.add(i, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(a aVar) {
        a poll;
        c(aVar);
        if (!aVar.isCancelled()) {
            aVar.setTimeout(true);
            this.sF.add(aVar);
            if (this.sF.size() > 242 && (poll = this.sF.poll()) != null) {
                poll.fM();
            }
        } else {
            BdLog.e("task TimeOut but it's cancelled()");
        }
        e(null);
    }

    private synchronized void c(a aVar) {
        if (aVar != null) {
            if (aVar.fR()) {
                this.sF.remove(aVar);
            } else {
                this.sE.remove(aVar);
                this.mHandler.removeMessages(1, aVar);
                switch (aVar.getPriority()) {
                    case 1:
                        this.sB--;
                        break;
                    case 2:
                        this.sA--;
                        break;
                    case 3:
                        this.sz--;
                        break;
                    case 4:
                        this.sy--;
                        break;
                }
                int fS = aVar.fS();
                if (fS != 0) {
                    int i = this.sC.get(fS) - 1;
                    if (i <= 0) {
                        this.sC.delete(fS);
                    } else {
                        this.sC.put(fS, i);
                    }
                    if (i < 0) {
                        BdLog.e("removeTask error < 0");
                    }
                }
            }
        }
    }

    private synchronized void d(a aVar) {
        if (aVar != null) {
            this.sE.add(aVar);
            this.sD.remove(aVar);
            THREAD_POOL_EXECUTOR.execute(aVar);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, aVar), 180000L);
            switch (aVar.getPriority()) {
                case 1:
                    this.sB++;
                    break;
                case 2:
                    this.sA++;
                    break;
                case 3:
                    this.sz++;
                    break;
                case 4:
                    this.sy++;
                    if (this.sy >= 7) {
                        BdLog.e("SuperHight Task too much num = " + this.sy);
                        break;
                    }
                    break;
            }
            int fS = aVar.fS();
            if (fS != 0) {
                this.sC.put(fS, this.sC.get(fS, 0) + 1);
            }
        }
    }

    private boolean a(int i, a aVar) {
        if (aVar == null) {
            return false;
        }
        BdAsyncTaskParallel.BdAsyncTaskParallelType fT = aVar.fT();
        return fT == BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL ? i < 1 : fT == BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL ? i < 2 : fT == BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL ? i < 3 : fT == BdAsyncTaskParallel.BdAsyncTaskParallelType.FOUR_PARALLEL ? i < 4 : fT != BdAsyncTaskParallel.BdAsyncTaskParallelType.CUSTOM_PARALLEL || i < aVar.fU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void e(a aVar) {
        c(aVar);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.sD.size()) {
                a aVar2 = this.sD.get(i2);
                int fS = aVar2.fS();
                switch (aVar2.getPriority()) {
                    case 1:
                        if (this.sz + this.sA + this.sB >= 5) {
                            break;
                        }
                        break;
                    case 2:
                        if (this.sz + this.sA + this.sB >= 6) {
                            break;
                        }
                        break;
                    case 3:
                        if (this.sz + this.sA + this.sB >= 7) {
                            break;
                        }
                        break;
                    case 4:
                        if (fS == 0) {
                            d(aVar2);
                            break;
                        }
                        break;
                }
                if (!a(this.sC.get(fS), aVar2)) {
                    i = i2 + 1;
                } else {
                    d(aVar2);
                }
            }
        }
    }

    public synchronized void removeAllTask(BdUniqueId bdUniqueId) {
        removeAllTask(bdUniqueId, null);
    }

    public synchronized void removeAllTask(BdUniqueId bdUniqueId, String str) {
        removeAllWaitingTask(bdUniqueId, str);
        a(this.sE, false, bdUniqueId, str);
        a(this.sF, false, bdUniqueId, str);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        removeAllWaitingTask(bdUniqueId, null);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        a(this.sD, true, bdUniqueId, str);
    }

    private synchronized void a(LinkedList<a> linkedList, boolean z, BdUniqueId bdUniqueId, String str) {
        if (bdUniqueId != null) {
            int id = bdUniqueId.getId();
            Iterator<a> it = linkedList.iterator();
            while (it.hasNext()) {
                a next = it.next();
                int tag = next.getTag();
                String key = next.getKey();
                if ((str != null && tag == id && str.equals(key)) || (str == null && id != 0 && tag == id)) {
                    if (z) {
                        it.remove();
                    }
                    next.fM();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        r1.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(BdAsyncTask<?, ?, ?> bdAsyncTask) {
        Iterator<a> it = this.sD.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a next = it.next();
            if (next != null && next.fQ() == bdAsyncTask) {
                break;
            }
        }
    }

    public int getTaskNum(String str, BdUniqueId bdUniqueId) {
        return a(this.sD, str, bdUniqueId) + a(this.sE, str, bdUniqueId) + a(this.sF, str, bdUniqueId);
    }

    private synchronized int a(LinkedList<a> linkedList, String str, BdUniqueId bdUniqueId) {
        int i = 0;
        synchronized (this) {
            if (linkedList != null && bdUniqueId != null) {
                int id = bdUniqueId.getId();
                Iterator<a> it = linkedList.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    a next = it.next();
                    int tag = next.getTag();
                    String key = next.getKey();
                    if ((str != null && tag == id && str.equals(key)) || (str == null && id != 0 && tag == id)) {
                        if (next.fQ() != null && !next.fQ().isCancelled()) {
                            i2++;
                        }
                    }
                }
                i = i2;
            }
        }
        return i;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchTask(String str) {
        BdAsyncTask<?, ?, ?> a2;
        a2 = a(this.sD, str);
        if (a2 == null) {
            a2 = a(this.sE, str);
        }
        if (a2 == null) {
            a2 = a(this.sF, str);
        }
        return a2;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return searchAllTask(bdUniqueId, null);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.sD, bdUniqueId, str);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a3 = a(this.sE, bdUniqueId, str);
        if (a3 != null) {
            linkedList.addAll(a3);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a4 = a(this.sF, bdUniqueId, str);
        if (a4 != null) {
            linkedList.addAll(a4);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return a(this.sD, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.sD, bdUniqueId, (String) null);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return a(this.sE, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
        r0 = r0.fQ();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized BdAsyncTask<?, ?, ?> a(LinkedList<a> linkedList, String str) {
        BdAsyncTask<?, ?, ?> bdAsyncTask;
        if (linkedList != null && str != null) {
            Iterator<a> it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bdAsyncTask = null;
                    break;
                }
                a next = it.next();
                String key = next.getKey();
                if (key != null && key.equals(str) && !next.fQ().isCancelled()) {
                    break;
                }
            }
        } else {
            bdAsyncTask = null;
        }
        return bdAsyncTask;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> a(LinkedList<a> linkedList, BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList2;
        if (linkedList == null || bdUniqueId == null) {
            linkedList2 = null;
        } else {
            int id = bdUniqueId.getId();
            LinkedList<BdAsyncTask<?, ?, ?>> linkedList3 = new LinkedList<>();
            Iterator<a> it = linkedList.iterator();
            while (it.hasNext()) {
                a next = it.next();
                int tag = next.getTag();
                String key = next.getKey();
                if ((str != null && tag == id && str.equals(key)) || (str == null && id != 0 && tag == id)) {
                    if (next.fQ() != null && !next.fQ().isCancelled()) {
                        linkedList3.add(next.fQ());
                    }
                }
            }
            linkedList2 = linkedList3;
        }
        return linkedList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class a implements Runnable {
        private g<?> sI;

        public a(g<?> gVar) {
            this.sI = null;
            if (gVar == null || gVar.fQ() == null) {
                throw new InvalidParameterException("parameter is null");
            }
            this.sI = gVar;
        }

        public void fP() {
            try {
                this.sI.run();
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }

        public void fM() {
            this.sI.fM();
        }

        public boolean isCancelled() {
            return this.sI.isCancelled();
        }

        public BdAsyncTask<?, ?, ?> fQ() {
            return this.sI.fQ();
        }

        public int getPriority() {
            return this.sI.fQ().getPriority();
        }

        public void setTimeout(boolean z) {
            this.sI.fQ().setTimeout(z);
        }

        public boolean fR() {
            return this.sI.fQ().isTimeout();
        }

        public int getTag() {
            return this.sI.fQ().getTag();
        }

        public int fS() {
            if (this.sI.fQ().getParallel() != null) {
                return this.sI.fQ().getParallel().getTag();
            }
            return 0;
        }

        public String getKey() {
            return this.sI.fQ().getKey();
        }

        public BdAsyncTaskParallel.BdAsyncTaskParallelType fT() {
            return this.sI.fQ().getParallel() != null ? this.sI.fQ().getParallel().fW() : BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
        }

        public int fU() {
            if (this.sI.fQ().getParallel() != null) {
                return this.sI.fQ().getParallel().fV();
            }
            return 1;
        }

        public boolean isSelfExecute() {
            return this.sI.fQ().isSelfExecute();
        }
    }
}
