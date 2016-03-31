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
    private volatile int sS = 0;
    private volatile int sT = 0;
    private volatile int sU = 0;
    private volatile int sV = 0;
    private final SparseIntArray sW = new SparseIntArray();
    private final LinkedList<a> sX = new LinkedList<>();
    private final LinkedList<a> sY = new LinkedList<>();
    private final LinkedList<a> sZ = new LinkedList<>();
    private HandlerThread tb;
    private static c sR = null;
    private static final ThreadFactory sThreadFactory = new d();
    private static final BlockingQueue<Runnable> sPoolWorkQueue = new SynchronousQueue();
    public static final Executor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(7, 256, 30, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory, new ThreadPoolExecutor.DiscardPolicy());

    c() {
        this.tb = null;
        this.mHandler = null;
        this.tb = new HandlerThread("BdAsyncTaskExecutor");
        this.tb.start();
        this.mHandler = new e(this, this.tb.getLooper());
    }

    public String toString() {
        return "mWaitingTasks = " + this.sX.size() + " mRunningTasks = " + this.sY.size() + " mTimeOutTasks = " + this.sZ.size();
    }

    public String fV() {
        return String.valueOf(this.sX.size()) + "/" + this.sY.size() + "/" + this.sZ.size();
    }

    public static c fW() {
        if (sR == null) {
            synchronized (c.class) {
                if (sR == null) {
                    sR = new c();
                }
            }
        }
        return sR;
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
            int size = this.sX.size();
            int i = 0;
            while (i < size && this.sX.get(i).getPriority() >= aVar.getPriority()) {
                i++;
            }
            this.sX.add(i, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(a aVar) {
        a poll;
        c(aVar);
        if (!aVar.isCancelled()) {
            aVar.setTimeout(true);
            this.sZ.add(aVar);
            if (this.sZ.size() > 242 && (poll = this.sZ.poll()) != null) {
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
                this.sZ.remove(aVar);
            } else {
                this.sY.remove(aVar);
                this.mHandler.removeMessages(1, aVar);
                switch (aVar.getPriority()) {
                    case 1:
                        this.sV--;
                        break;
                    case 2:
                        this.sU--;
                        break;
                    case 3:
                        this.sT--;
                        break;
                    case 4:
                        this.sS--;
                        break;
                }
                int ga = aVar.ga();
                if (ga != 0) {
                    int i = this.sW.get(ga) - 1;
                    if (i <= 0) {
                        this.sW.delete(ga);
                    } else {
                        this.sW.put(ga, i);
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
            this.sY.add(aVar);
            this.sX.remove(aVar);
            THREAD_POOL_EXECUTOR.execute(aVar);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, aVar), 180000L);
            switch (aVar.getPriority()) {
                case 1:
                    this.sV++;
                    break;
                case 2:
                    this.sU++;
                    break;
                case 3:
                    this.sT++;
                    break;
                case 4:
                    this.sS++;
                    if (this.sS >= 7) {
                        BdLog.e("SuperHight Task too much num = " + this.sS);
                        break;
                    }
                    break;
            }
            int ga = aVar.ga();
            if (ga != 0) {
                this.sW.put(ga, this.sW.get(ga, 0) + 1);
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
            if (i2 < this.sX.size()) {
                a aVar2 = this.sX.get(i2);
                int ga = aVar2.ga();
                switch (aVar2.getPriority()) {
                    case 1:
                        if (this.sT + this.sU + this.sV >= 5) {
                            break;
                        }
                        break;
                    case 2:
                        if (this.sT + this.sU + this.sV >= 6) {
                            break;
                        }
                        break;
                    case 3:
                        if (this.sT + this.sU + this.sV >= 7) {
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
                if (!a(this.sW.get(ga), aVar2)) {
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
        a(this.sY, false, bdUniqueId, str);
        a(this.sZ, false, bdUniqueId, str);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        removeAllWaitingTask(bdUniqueId, null);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        a(this.sX, true, bdUniqueId, str);
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
        Iterator<a> it = this.sX.iterator();
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
        return a(this.sX, str, bdUniqueId) + a(this.sY, str, bdUniqueId) + a(this.sZ, str, bdUniqueId);
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
        a2 = a(this.sX, str);
        if (a2 == null) {
            a2 = a(this.sY, str);
        }
        if (a2 == null) {
            a2 = a(this.sZ, str);
        }
        return a2;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return searchAllTask(bdUniqueId, null);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.sX, bdUniqueId, str);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a3 = a(this.sY, bdUniqueId, str);
        if (a3 != null) {
            linkedList.addAll(a3);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a4 = a(this.sZ, bdUniqueId, str);
        if (a4 != null) {
            linkedList.addAll(a4);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return a(this.sX, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.sX, bdUniqueId, (String) null);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return a(this.sY, str);
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
        private g<?> td;

        public a(g<?> gVar) {
            this.td = null;
            if (gVar == null || gVar.fY() == null) {
                throw new InvalidParameterException("parameter is null");
            }
            this.td = gVar;
        }

        public void fX() {
            try {
                this.td.run();
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }

        public void fU() {
            this.td.fU();
        }

        public boolean isCancelled() {
            return this.td.isCancelled();
        }

        public BdAsyncTask<?, ?, ?> fY() {
            return this.td.fY();
        }

        public int getPriority() {
            return this.td.fY().getPriority();
        }

        public void setTimeout(boolean z) {
            this.td.fY().setTimeout(z);
        }

        public boolean fZ() {
            return this.td.fY().isTimeout();
        }

        public int getTag() {
            return this.td.fY().getTag();
        }

        public int ga() {
            if (this.td.fY().getParallel() != null) {
                return this.td.fY().getParallel().getTag();
            }
            return 0;
        }

        public String getKey() {
            return this.td.fY().getKey();
        }

        public BdAsyncTaskParallel.BdAsyncTaskParallelType gb() {
            return this.td.fY().getParallel() != null ? this.td.fY().getParallel().gf() : BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
        }

        public int gd() {
            if (this.td.fY().getParallel() != null) {
                return this.td.fY().getParallel().ge();
            }
            return 1;
        }

        public boolean isSelfExecute() {
            return this.td.fY().isSelfExecute();
        }
    }
}
