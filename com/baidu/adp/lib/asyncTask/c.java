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
    private HandlerThread sF;
    private static c sw = null;
    private static final ThreadFactory sThreadFactory = new d();
    private static final BlockingQueue<Runnable> sPoolWorkQueue = new SynchronousQueue();
    public static final Executor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(7, 256, 30, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory, new ThreadPoolExecutor.DiscardPolicy());
    private volatile int sx = 0;
    private volatile int sy = 0;
    private volatile int sz = 0;
    private volatile int sA = 0;
    private final SparseIntArray sB = new SparseIntArray();
    private final LinkedList<a> sC = new LinkedList<>();
    private final LinkedList<a> sD = new LinkedList<>();
    private final LinkedList<a> sE = new LinkedList<>();

    c() {
        this.sF = null;
        this.mHandler = null;
        this.sF = new HandlerThread("BdAsyncTaskExecutor");
        this.sF.start();
        this.mHandler = new e(this, this.sF.getLooper());
    }

    public String toString() {
        return "mWaitingTasks = " + this.sC.size() + " mRunningTasks = " + this.sD.size() + " mTimeOutTasks = " + this.sE.size();
    }

    public String fN() {
        return String.valueOf(this.sC.size()) + "/" + this.sD.size() + "/" + this.sE.size();
    }

    public static c fO() {
        if (sw == null) {
            synchronized (c.class) {
                if (sw == null) {
                    sw = new c();
                }
            }
        }
        return sw;
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
            int size = this.sC.size();
            int i = 0;
            while (i < size && this.sC.get(i).getPriority() >= aVar.getPriority()) {
                i++;
            }
            this.sC.add(i, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(a aVar) {
        a poll;
        c(aVar);
        if (!aVar.isCancelled()) {
            aVar.setTimeout(true);
            this.sE.add(aVar);
            if (this.sE.size() > 242 && (poll = this.sE.poll()) != null) {
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
                this.sE.remove(aVar);
            } else {
                this.sD.remove(aVar);
                this.mHandler.removeMessages(1, aVar);
                switch (aVar.getPriority()) {
                    case 1:
                        this.sA--;
                        break;
                    case 2:
                        this.sz--;
                        break;
                    case 3:
                        this.sy--;
                        break;
                    case 4:
                        this.sx--;
                        break;
                }
                int fS = aVar.fS();
                if (fS != 0) {
                    int i = this.sB.get(fS) - 1;
                    if (i <= 0) {
                        this.sB.delete(fS);
                    } else {
                        this.sB.put(fS, i);
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
            this.sD.add(aVar);
            this.sC.remove(aVar);
            THREAD_POOL_EXECUTOR.execute(aVar);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, aVar), 180000L);
            switch (aVar.getPriority()) {
                case 1:
                    this.sA++;
                    break;
                case 2:
                    this.sz++;
                    break;
                case 3:
                    this.sy++;
                    break;
                case 4:
                    this.sx++;
                    if (this.sx >= 7) {
                        BdLog.e("SuperHight Task too much num = " + this.sx);
                        break;
                    }
                    break;
            }
            int fS = aVar.fS();
            if (fS != 0) {
                this.sB.put(fS, this.sB.get(fS, 0) + 1);
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
            if (i2 < this.sC.size()) {
                a aVar2 = this.sC.get(i2);
                int fS = aVar2.fS();
                switch (aVar2.getPriority()) {
                    case 1:
                        if (this.sy + this.sz + this.sA >= 5) {
                            break;
                        }
                        break;
                    case 2:
                        if (this.sy + this.sz + this.sA >= 6) {
                            break;
                        }
                        break;
                    case 3:
                        if (this.sy + this.sz + this.sA >= 7) {
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
                if (!a(this.sB.get(fS), aVar2)) {
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
        a(this.sD, false, bdUniqueId, str);
        a(this.sE, false, bdUniqueId, str);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        removeAllWaitingTask(bdUniqueId, null);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        a(this.sC, true, bdUniqueId, str);
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
        Iterator<a> it = this.sC.iterator();
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
        return a(this.sC, str, bdUniqueId) + a(this.sD, str, bdUniqueId) + a(this.sE, str, bdUniqueId);
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
        a2 = a(this.sC, str);
        if (a2 == null) {
            a2 = a(this.sD, str);
        }
        if (a2 == null) {
            a2 = a(this.sE, str);
        }
        return a2;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return searchAllTask(bdUniqueId, null);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.sC, bdUniqueId, str);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a3 = a(this.sD, bdUniqueId, str);
        if (a3 != null) {
            linkedList.addAll(a3);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a4 = a(this.sE, bdUniqueId, str);
        if (a4 != null) {
            linkedList.addAll(a4);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return a(this.sC, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.sC, bdUniqueId, (String) null);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return a(this.sD, str);
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
        private g<?> sH;

        public a(g<?> gVar) {
            this.sH = null;
            if (gVar == null || gVar.fQ() == null) {
                throw new InvalidParameterException("parameter is null");
            }
            this.sH = gVar;
        }

        public void fP() {
            try {
                this.sH.run();
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }

        public void fM() {
            this.sH.fM();
        }

        public boolean isCancelled() {
            return this.sH.isCancelled();
        }

        public BdAsyncTask<?, ?, ?> fQ() {
            return this.sH.fQ();
        }

        public int getPriority() {
            return this.sH.fQ().getPriority();
        }

        public void setTimeout(boolean z) {
            this.sH.fQ().setTimeout(z);
        }

        public boolean fR() {
            return this.sH.fQ().isTimeout();
        }

        public int getTag() {
            return this.sH.fQ().getTag();
        }

        public int fS() {
            if (this.sH.fQ().getParallel() != null) {
                return this.sH.fQ().getParallel().getTag();
            }
            return 0;
        }

        public String getKey() {
            return this.sH.fQ().getKey();
        }

        public BdAsyncTaskParallel.BdAsyncTaskParallelType fT() {
            return this.sH.fQ().getParallel() != null ? this.sH.fQ().getParallel().fW() : BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
        }

        public int fU() {
            if (this.sH.fQ().getParallel() != null) {
                return this.sH.fQ().getParallel().fV();
            }
            return 1;
        }

        public boolean isSelfExecute() {
            return this.sH.fQ().isSelfExecute();
        }
    }
}
