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
    private volatile int sJ = 0;
    private volatile int sK = 0;
    private volatile int sL = 0;
    private volatile int sM = 0;
    private final SparseIntArray sN = new SparseIntArray();
    private final LinkedList<a> sO = new LinkedList<>();
    private final LinkedList<a> sP = new LinkedList<>();
    private final LinkedList<a> sQ = new LinkedList<>();
    private HandlerThread sR;
    private static c sI = null;
    private static final ThreadFactory sThreadFactory = new d();
    private static final BlockingQueue<Runnable> sPoolWorkQueue = new SynchronousQueue();
    public static final Executor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(7, 256, 30, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory, new ThreadPoolExecutor.DiscardPolicy());

    c() {
        this.sR = null;
        this.mHandler = null;
        this.sR = new HandlerThread("BdAsyncTaskExecutor");
        this.sR.start();
        this.mHandler = new e(this, this.sR.getLooper());
    }

    public String toString() {
        return "mWaitingTasks = " + this.sO.size() + " mRunningTasks = " + this.sP.size() + " mTimeOutTasks = " + this.sQ.size();
    }

    public String fV() {
        return String.valueOf(this.sO.size()) + "/" + this.sP.size() + "/" + this.sQ.size();
    }

    public static c fW() {
        if (sI == null) {
            synchronized (c.class) {
                if (sI == null) {
                    sI = new c();
                }
            }
        }
        return sI;
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
            int size = this.sO.size();
            int i = 0;
            while (i < size && this.sO.get(i).getPriority() >= aVar.getPriority()) {
                i++;
            }
            this.sO.add(i, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(a aVar) {
        a poll;
        c(aVar);
        if (!aVar.isCancelled()) {
            aVar.setTimeout(true);
            this.sQ.add(aVar);
            if (this.sQ.size() > 242 && (poll = this.sQ.poll()) != null) {
                poll.fU();
            }
        } else {
            BdLog.e("task TimeOut but it's cancelled()");
        }
        e(null);
    }

    private synchronized void c(a aVar) {
        if (aVar != null) {
            if (aVar.fZ()) {
                this.sQ.remove(aVar);
            } else {
                this.sP.remove(aVar);
                this.mHandler.removeMessages(1, aVar);
                switch (aVar.getPriority()) {
                    case 1:
                        this.sM--;
                        break;
                    case 2:
                        this.sL--;
                        break;
                    case 3:
                        this.sK--;
                        break;
                    case 4:
                        this.sJ--;
                        break;
                }
                int ga = aVar.ga();
                if (ga != 0) {
                    int i = this.sN.get(ga) - 1;
                    if (i <= 0) {
                        this.sN.delete(ga);
                    } else {
                        this.sN.put(ga, i);
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
            this.sP.add(aVar);
            this.sO.remove(aVar);
            THREAD_POOL_EXECUTOR.execute(aVar);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, aVar), 180000L);
            switch (aVar.getPriority()) {
                case 1:
                    this.sM++;
                    break;
                case 2:
                    this.sL++;
                    break;
                case 3:
                    this.sK++;
                    break;
                case 4:
                    this.sJ++;
                    if (this.sJ >= 7) {
                        BdLog.e("SuperHight Task too much num = " + this.sJ);
                        break;
                    }
                    break;
            }
            int ga = aVar.ga();
            if (ga != 0) {
                this.sN.put(ga, this.sN.get(ga, 0) + 1);
            }
        }
    }

    private boolean a(int i, a aVar) {
        if (aVar == null) {
            return false;
        }
        BdAsyncTaskParallel.BdAsyncTaskParallelType gb = aVar.gb();
        return gb == BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL ? i < 1 : gb == BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL ? i < 2 : gb == BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL ? i < 3 : gb == BdAsyncTaskParallel.BdAsyncTaskParallelType.FOUR_PARALLEL ? i < 4 : gb != BdAsyncTaskParallel.BdAsyncTaskParallelType.CUSTOM_PARALLEL || i < aVar.gd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void e(a aVar) {
        c(aVar);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.sO.size()) {
                a aVar2 = this.sO.get(i2);
                int ga = aVar2.ga();
                switch (aVar2.getPriority()) {
                    case 1:
                        if (this.sK + this.sL + this.sM >= 5) {
                            break;
                        }
                        break;
                    case 2:
                        if (this.sK + this.sL + this.sM >= 6) {
                            break;
                        }
                        break;
                    case 3:
                        if (this.sK + this.sL + this.sM >= 7) {
                            break;
                        }
                        break;
                    case 4:
                        if (ga == 0) {
                            d(aVar2);
                            break;
                        }
                        break;
                }
                if (!a(this.sN.get(ga), aVar2)) {
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
        a(this.sP, false, bdUniqueId, str);
        a(this.sQ, false, bdUniqueId, str);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        removeAllWaitingTask(bdUniqueId, null);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        a(this.sO, true, bdUniqueId, str);
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
                    next.fU();
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
        Iterator<a> it = this.sO.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a next = it.next();
            if (next != null && next.fY() == bdAsyncTask) {
                break;
            }
        }
    }

    public int getTaskNum(String str, BdUniqueId bdUniqueId) {
        return a(this.sO, str, bdUniqueId) + a(this.sP, str, bdUniqueId) + a(this.sQ, str, bdUniqueId);
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
                        if (next.fY() != null && !next.fY().isCancelled()) {
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
        a2 = a(this.sO, str);
        if (a2 == null) {
            a2 = a(this.sP, str);
        }
        if (a2 == null) {
            a2 = a(this.sQ, str);
        }
        return a2;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return searchAllTask(bdUniqueId, null);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.sO, bdUniqueId, str);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a3 = a(this.sP, bdUniqueId, str);
        if (a3 != null) {
            linkedList.addAll(a3);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a4 = a(this.sQ, bdUniqueId, str);
        if (a4 != null) {
            linkedList.addAll(a4);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return a(this.sO, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.sO, bdUniqueId, (String) null);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return a(this.sP, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
        r0 = r0.fY();
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
                if (key != null && key.equals(str) && !next.fY().isCancelled()) {
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
                    if (next.fY() != null && !next.fY().isCancelled()) {
                        linkedList3.add(next.fY());
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
        private g<?> sT;

        public a(g<?> gVar) {
            this.sT = null;
            if (gVar == null || gVar.fY() == null) {
                throw new InvalidParameterException("parameter is null");
            }
            this.sT = gVar;
        }

        public void fX() {
            try {
                this.sT.run();
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }

        public void fU() {
            this.sT.fU();
        }

        public boolean isCancelled() {
            return this.sT.isCancelled();
        }

        public BdAsyncTask<?, ?, ?> fY() {
            return this.sT.fY();
        }

        public int getPriority() {
            return this.sT.fY().getPriority();
        }

        public void setTimeout(boolean z) {
            this.sT.fY().setTimeout(z);
        }

        public boolean fZ() {
            return this.sT.fY().isTimeout();
        }

        public int getTag() {
            return this.sT.fY().getTag();
        }

        public int ga() {
            if (this.sT.fY().getParallel() != null) {
                return this.sT.fY().getParallel().getTag();
            }
            return 0;
        }

        public String getKey() {
            return this.sT.fY().getKey();
        }

        public BdAsyncTaskParallel.BdAsyncTaskParallelType gb() {
            return this.sT.fY().getParallel() != null ? this.sT.fY().getParallel().gf() : BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
        }

        public int gd() {
            if (this.sT.fY().getParallel() != null) {
                return this.sT.fY().getParallel().ge();
            }
            return 1;
        }

        public boolean isSelfExecute() {
            return this.sT.fY().isSelfExecute();
        }
    }
}
