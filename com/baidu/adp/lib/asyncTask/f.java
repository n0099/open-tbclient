package com.baidu.adp.lib.asyncTask;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class f implements Executor {
    private volatile int eS = 0;
    private volatile int eT = 0;
    private volatile int eU = 0;
    private volatile int eV = 0;
    private final SparseIntArray eW = new SparseIntArray();
    private final LinkedList<j> eX = new LinkedList<>();
    private final LinkedList<j> eY = new LinkedList<>();
    private final LinkedList<j> eZ = new LinkedList<>();
    private HandlerThread fa;
    private Handler mHandler;
    private static f eR = null;
    private static final ThreadFactory sThreadFactory = new g();
    private static final BlockingQueue<Runnable> sPoolWorkQueue = new SynchronousQueue();
    public static final Executor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(7, 256, 30, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory, new ThreadPoolExecutor.DiscardPolicy());

    f() {
        this.fa = null;
        this.mHandler = null;
        this.fa = new HandlerThread("BdAsyncTaskExecutor");
        this.fa.start();
        this.mHandler = new h(this, this.fa.getLooper());
    }

    public String toString() {
        return "mWaitingTasks = " + this.eX.size() + " mRunningTasks = " + this.eY.size() + " mTimeOutTasks = " + this.eZ.size();
    }

    public String bU() {
        return String.valueOf(this.eX.size()) + "/" + this.eY.size() + "/" + this.eZ.size();
    }

    public static f bV() {
        if (eR == null) {
            synchronized (f.class) {
                if (eR == null) {
                    eR = new f();
                }
            }
        }
        return eR;
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        if (runnable instanceof k) {
            i iVar = new i(this, (k) runnable);
            if (iVar.isSelfExecute()) {
                new Thread(iVar).start();
            } else {
                a(iVar);
                e(null);
                BdBaseApplication.getInst().isDebugMode();
            }
        }
    }

    private synchronized void a(j jVar) {
        if (jVar != null) {
            int size = this.eX.size();
            int i = 0;
            while (i < size && this.eX.get(i).getPriority() >= jVar.getPriority()) {
                i++;
            }
            this.eX.add(i, jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(j jVar) {
        j poll;
        c(jVar);
        if (!jVar.isCancelled()) {
            jVar.setTimeout(true);
            this.eZ.add(jVar);
            if (this.eZ.size() > 242 && (poll = this.eZ.poll()) != null) {
                poll.bT();
            }
        } else {
            BdLog.e("task TimeOut but it's cancelled()");
        }
        e(null);
    }

    private synchronized void c(j jVar) {
        if (jVar != null) {
            if (jVar.bY()) {
                this.eZ.remove(jVar);
            } else {
                this.eY.remove(jVar);
                this.mHandler.removeMessages(1, jVar);
                switch (jVar.getPriority()) {
                    case 1:
                        this.eV--;
                        break;
                    case 2:
                        this.eU--;
                        break;
                    case 3:
                        this.eT--;
                        break;
                    case 4:
                        this.eS--;
                        break;
                }
                int bZ = jVar.bZ();
                if (bZ != 0) {
                    int i = this.eW.get(bZ) - 1;
                    if (i <= 0) {
                        this.eW.delete(bZ);
                    } else {
                        this.eW.put(bZ, i);
                    }
                    if (i < 0) {
                        BdLog.e("removeTask error < 0");
                    }
                }
            }
        }
    }

    private synchronized void d(j jVar) {
        if (jVar != null) {
            this.eY.add(jVar);
            this.eX.remove(jVar);
            THREAD_POOL_EXECUTOR.execute(jVar);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, jVar), 180000L);
            switch (jVar.getPriority()) {
                case 1:
                    this.eV++;
                    break;
                case 2:
                    this.eU++;
                    break;
                case 3:
                    this.eT++;
                    break;
                case 4:
                    this.eS++;
                    if (this.eS >= 7) {
                        BdLog.e("SuperHight Task too much num = " + this.eS);
                        break;
                    }
                    break;
            }
            int bZ = jVar.bZ();
            if (bZ != 0) {
                this.eW.put(bZ, this.eW.get(bZ, 0) + 1);
            }
        }
    }

    private boolean a(int i, j jVar) {
        if (jVar == null) {
            return false;
        }
        BdAsyncTaskParallel.BdAsyncTaskParallelType ca = jVar.ca();
        return ca == BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL ? i < 1 : ca == BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL ? i < 2 : ca == BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL ? i < 3 : ca == BdAsyncTaskParallel.BdAsyncTaskParallelType.FOUR_PARALLEL ? i < 4 : ca != BdAsyncTaskParallel.BdAsyncTaskParallelType.CUSTOM_PARALLEL || i < jVar.cb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void e(j jVar) {
        c(jVar);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.eX.size()) {
                j jVar2 = this.eX.get(i2);
                int bZ = jVar2.bZ();
                switch (jVar2.getPriority()) {
                    case 1:
                        if (this.eT + this.eU + this.eV >= 5) {
                            break;
                        }
                        break;
                    case 2:
                        if (this.eT + this.eU + this.eV >= 6) {
                            break;
                        }
                        break;
                    case 3:
                        if (this.eT + this.eU + this.eV >= 7) {
                            break;
                        }
                        break;
                    case 4:
                        if (bZ == 0) {
                            d(jVar2);
                            break;
                        }
                        break;
                }
                if (!a(this.eW.get(bZ), jVar2)) {
                    i = i2 + 1;
                } else {
                    d(jVar2);
                }
            }
        }
    }

    public synchronized void removeAllTask(BdUniqueId bdUniqueId) {
        removeAllTask(bdUniqueId, null);
    }

    public synchronized void removeAllTask(BdUniqueId bdUniqueId, String str) {
        removeAllWaitingTask(bdUniqueId, str);
        a(this.eY, false, bdUniqueId, str);
        a(this.eZ, false, bdUniqueId, str);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        removeAllWaitingTask(bdUniqueId, null);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        a(this.eX, true, bdUniqueId, str);
    }

    private synchronized void a(LinkedList<j> linkedList, boolean z, BdUniqueId bdUniqueId, String str) {
        if (bdUniqueId != null) {
            int id = bdUniqueId.getId();
            Iterator<j> it = linkedList.iterator();
            while (it.hasNext()) {
                j next = it.next();
                int tag = next.getTag();
                String key = next.getKey();
                if ((str != null && tag == id && str.equals(key)) || (str == null && id != 0 && tag == id)) {
                    if (z) {
                        it.remove();
                    }
                    next.bT();
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
        Iterator<j> it = this.eX.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            j next = it.next();
            if (next != null && next.bX() == bdAsyncTask) {
                break;
            }
        }
    }

    public int getTaskNum(String str, BdUniqueId bdUniqueId) {
        return a(this.eX, str, bdUniqueId) + a(this.eY, str, bdUniqueId) + a(this.eZ, str, bdUniqueId);
    }

    private synchronized int a(LinkedList<j> linkedList, String str, BdUniqueId bdUniqueId) {
        int i = 0;
        synchronized (this) {
            if (linkedList != null && bdUniqueId != null) {
                int id = bdUniqueId.getId();
                Iterator<j> it = linkedList.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    j next = it.next();
                    int tag = next.getTag();
                    String key = next.getKey();
                    if ((str != null && tag == id && str.equals(key)) || (str == null && id != 0 && tag == id)) {
                        if (next.bX() != null && !next.bX().isCancelled()) {
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
        BdAsyncTask<?, ?, ?> a;
        a = a(this.eX, str);
        if (a == null) {
            a = a(this.eY, str);
        }
        if (a == null) {
            a = a(this.eZ, str);
        }
        return a;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return searchAllTask(bdUniqueId, null);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.eX, bdUniqueId, str);
        if (a != null) {
            linkedList.addAll(a);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.eY, bdUniqueId, str);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a3 = a(this.eZ, bdUniqueId, str);
        if (a3 != null) {
            linkedList.addAll(a3);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return a(this.eX, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.eX, bdUniqueId, (String) null);
        if (a != null) {
            linkedList.addAll(a);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return a(this.eY, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
        r0 = r0.bX();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized BdAsyncTask<?, ?, ?> a(LinkedList<j> linkedList, String str) {
        BdAsyncTask<?, ?, ?> bdAsyncTask;
        if (linkedList != null && str != null) {
            Iterator<j> it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bdAsyncTask = null;
                    break;
                }
                j next = it.next();
                String key = next.getKey();
                if (key != null && key.equals(str) && !next.bX().isCancelled()) {
                    break;
                }
            }
        } else {
            bdAsyncTask = null;
        }
        return bdAsyncTask;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> a(LinkedList<j> linkedList, BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList2;
        if (linkedList == null || bdUniqueId == null) {
            linkedList2 = null;
        } else {
            int id = bdUniqueId.getId();
            LinkedList<BdAsyncTask<?, ?, ?>> linkedList3 = new LinkedList<>();
            Iterator<j> it = linkedList.iterator();
            while (it.hasNext()) {
                j next = it.next();
                int tag = next.getTag();
                String key = next.getKey();
                if ((str != null && tag == id && str.equals(key)) || (str == null && id != 0 && tag == id)) {
                    if (next.bX() != null && !next.bX().isCancelled()) {
                        linkedList3.add(next.bX());
                    }
                }
            }
            linkedList2 = linkedList3;
        }
        return linkedList2;
    }
}
