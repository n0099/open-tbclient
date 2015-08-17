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
    private HandlerThread sH;
    private static c sy = null;
    private static final ThreadFactory sThreadFactory = new d();
    private static final BlockingQueue<Runnable> sPoolWorkQueue = new SynchronousQueue();
    public static final Executor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(7, 256, 30, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory, new ThreadPoolExecutor.DiscardPolicy());
    private volatile int sz = 0;
    private volatile int sA = 0;
    private volatile int sB = 0;
    private volatile int sC = 0;
    private final SparseIntArray sD = new SparseIntArray();
    private final LinkedList<a> sE = new LinkedList<>();
    private final LinkedList<a> sF = new LinkedList<>();
    private final LinkedList<a> sG = new LinkedList<>();

    c() {
        this.sH = null;
        this.mHandler = null;
        this.sH = new HandlerThread("BdAsyncTaskExecutor");
        this.sH.start();
        this.mHandler = new e(this, this.sH.getLooper());
    }

    public String toString() {
        return "mWaitingTasks = " + this.sE.size() + " mRunningTasks = " + this.sF.size() + " mTimeOutTasks = " + this.sG.size();
    }

    public String fQ() {
        return String.valueOf(this.sE.size()) + "/" + this.sF.size() + "/" + this.sG.size();
    }

    public static c fR() {
        if (sy == null) {
            synchronized (c.class) {
                if (sy == null) {
                    sy = new c();
                }
            }
        }
        return sy;
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
            int size = this.sE.size();
            int i = 0;
            while (i < size && this.sE.get(i).getPriority() >= aVar.getPriority()) {
                i++;
            }
            this.sE.add(i, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(a aVar) {
        a poll;
        c(aVar);
        if (!aVar.isCancelled()) {
            aVar.setTimeout(true);
            this.sG.add(aVar);
            if (this.sG.size() > 242 && (poll = this.sG.poll()) != null) {
                poll.fP();
            }
        } else {
            BdLog.e("task TimeOut but it's cancelled()");
        }
        e(null);
    }

    private synchronized void c(a aVar) {
        if (aVar != null) {
            if (aVar.fU()) {
                this.sG.remove(aVar);
            } else {
                this.sF.remove(aVar);
                this.mHandler.removeMessages(1, aVar);
                switch (aVar.getPriority()) {
                    case 1:
                        this.sC--;
                        break;
                    case 2:
                        this.sB--;
                        break;
                    case 3:
                        this.sA--;
                        break;
                    case 4:
                        this.sz--;
                        break;
                }
                int fV = aVar.fV();
                if (fV != 0) {
                    int i = this.sD.get(fV) - 1;
                    if (i <= 0) {
                        this.sD.delete(fV);
                    } else {
                        this.sD.put(fV, i);
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
            this.sF.add(aVar);
            this.sE.remove(aVar);
            THREAD_POOL_EXECUTOR.execute(aVar);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, aVar), 180000L);
            switch (aVar.getPriority()) {
                case 1:
                    this.sC++;
                    break;
                case 2:
                    this.sB++;
                    break;
                case 3:
                    this.sA++;
                    break;
                case 4:
                    this.sz++;
                    if (this.sz >= 7) {
                        BdLog.e("SuperHight Task too much num = " + this.sz);
                        break;
                    }
                    break;
            }
            int fV = aVar.fV();
            if (fV != 0) {
                this.sD.put(fV, this.sD.get(fV, 0) + 1);
            }
        }
    }

    private boolean a(int i, a aVar) {
        if (aVar == null) {
            return false;
        }
        BdAsyncTaskParallel.BdAsyncTaskParallelType fW = aVar.fW();
        return fW == BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL ? i < 1 : fW == BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL ? i < 2 : fW == BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL ? i < 3 : fW == BdAsyncTaskParallel.BdAsyncTaskParallelType.FOUR_PARALLEL ? i < 4 : fW != BdAsyncTaskParallel.BdAsyncTaskParallelType.CUSTOM_PARALLEL || i < aVar.fX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void e(a aVar) {
        c(aVar);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.sE.size()) {
                a aVar2 = this.sE.get(i2);
                int fV = aVar2.fV();
                switch (aVar2.getPriority()) {
                    case 1:
                        if (this.sA + this.sB + this.sC >= 5) {
                            break;
                        }
                        break;
                    case 2:
                        if (this.sA + this.sB + this.sC >= 6) {
                            break;
                        }
                        break;
                    case 3:
                        if (this.sA + this.sB + this.sC >= 7) {
                            break;
                        }
                        break;
                    case 4:
                        if (fV == 0) {
                            d(aVar2);
                            break;
                        }
                        break;
                }
                if (!a(this.sD.get(fV), aVar2)) {
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
        a(this.sF, false, bdUniqueId, str);
        a(this.sG, false, bdUniqueId, str);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        removeAllWaitingTask(bdUniqueId, null);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        a(this.sE, true, bdUniqueId, str);
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
                    next.fP();
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
        Iterator<a> it = this.sE.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a next = it.next();
            if (next != null && next.fT() == bdAsyncTask) {
                break;
            }
        }
    }

    public int getTaskNum(String str, BdUniqueId bdUniqueId) {
        return a(this.sE, str, bdUniqueId) + a(this.sF, str, bdUniqueId) + a(this.sG, str, bdUniqueId);
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
                        if (next.fT() != null && !next.fT().isCancelled()) {
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
        a2 = a(this.sE, str);
        if (a2 == null) {
            a2 = a(this.sF, str);
        }
        if (a2 == null) {
            a2 = a(this.sG, str);
        }
        return a2;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return searchAllTask(bdUniqueId, null);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.sE, bdUniqueId, str);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a3 = a(this.sF, bdUniqueId, str);
        if (a3 != null) {
            linkedList.addAll(a3);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a4 = a(this.sG, bdUniqueId, str);
        if (a4 != null) {
            linkedList.addAll(a4);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return a(this.sE, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.sE, bdUniqueId, (String) null);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return a(this.sF, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
        r0 = r0.fT();
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
                if (key != null && key.equals(str) && !next.fT().isCancelled()) {
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
                    if (next.fT() != null && !next.fT().isCancelled()) {
                        linkedList3.add(next.fT());
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
        private g<?> sJ;

        public a(g<?> gVar) {
            this.sJ = null;
            if (gVar == null || gVar.fT() == null) {
                throw new InvalidParameterException("parameter is null");
            }
            this.sJ = gVar;
        }

        public void fS() {
            try {
                this.sJ.run();
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }

        public void fP() {
            this.sJ.fP();
        }

        public boolean isCancelled() {
            return this.sJ.isCancelled();
        }

        public BdAsyncTask<?, ?, ?> fT() {
            return this.sJ.fT();
        }

        public int getPriority() {
            return this.sJ.fT().getPriority();
        }

        public void setTimeout(boolean z) {
            this.sJ.fT().setTimeout(z);
        }

        public boolean fU() {
            return this.sJ.fT().isTimeout();
        }

        public int getTag() {
            return this.sJ.fT().getTag();
        }

        public int fV() {
            if (this.sJ.fT().getParallel() != null) {
                return this.sJ.fT().getParallel().getTag();
            }
            return 0;
        }

        public String getKey() {
            return this.sJ.fT().getKey();
        }

        public BdAsyncTaskParallel.BdAsyncTaskParallelType fW() {
            return this.sJ.fT().getParallel() != null ? this.sJ.fT().getParallel().fZ() : BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
        }

        public int fX() {
            if (this.sJ.fT().getParallel() != null) {
                return this.sJ.fT().getParallel().fY();
            }
            return 1;
        }

        public boolean isSelfExecute() {
            return this.sJ.fT().isSelfExecute();
        }
    }
}
