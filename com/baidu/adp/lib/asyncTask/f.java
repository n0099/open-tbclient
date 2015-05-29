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
    private Handler mHandler;
    private volatile int sC = 0;
    private volatile int sD = 0;
    private volatile int sE = 0;
    private volatile int sF = 0;
    private final SparseIntArray sG = new SparseIntArray();
    private final LinkedList<j> sH = new LinkedList<>();
    private final LinkedList<j> sI = new LinkedList<>();
    private final LinkedList<j> sJ = new LinkedList<>();
    private HandlerThread sK;
    private static f sB = null;
    private static final ThreadFactory sThreadFactory = new g();
    private static final BlockingQueue<Runnable> sPoolWorkQueue = new SynchronousQueue();
    public static final Executor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(7, 256, 30, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory, new ThreadPoolExecutor.DiscardPolicy());

    f() {
        this.sK = null;
        this.mHandler = null;
        this.sK = new HandlerThread("BdAsyncTaskExecutor");
        this.sK.start();
        this.mHandler = new h(this, this.sK.getLooper());
    }

    public String toString() {
        return "mWaitingTasks = " + this.sH.size() + " mRunningTasks = " + this.sI.size() + " mTimeOutTasks = " + this.sJ.size();
    }

    public String fV() {
        return String.valueOf(this.sH.size()) + "/" + this.sI.size() + "/" + this.sJ.size();
    }

    public static f fW() {
        if (sB == null) {
            synchronized (f.class) {
                if (sB == null) {
                    sB = new f();
                }
            }
        }
        return sB;
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
            int size = this.sH.size();
            int i = 0;
            while (i < size && this.sH.get(i).getPriority() >= jVar.getPriority()) {
                i++;
            }
            this.sH.add(i, jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(j jVar) {
        j poll;
        c(jVar);
        if (!jVar.isCancelled()) {
            jVar.setTimeout(true);
            this.sJ.add(jVar);
            if (this.sJ.size() > 242 && (poll = this.sJ.poll()) != null) {
                poll.fU();
            }
        } else {
            BdLog.e("task TimeOut but it's cancelled()");
        }
        e(null);
    }

    private synchronized void c(j jVar) {
        if (jVar != null) {
            if (jVar.fZ()) {
                this.sJ.remove(jVar);
            } else {
                this.sI.remove(jVar);
                this.mHandler.removeMessages(1, jVar);
                switch (jVar.getPriority()) {
                    case 1:
                        this.sF--;
                        break;
                    case 2:
                        this.sE--;
                        break;
                    case 3:
                        this.sD--;
                        break;
                    case 4:
                        this.sC--;
                        break;
                }
                int ga = jVar.ga();
                if (ga != 0) {
                    int i = this.sG.get(ga) - 1;
                    if (i <= 0) {
                        this.sG.delete(ga);
                    } else {
                        this.sG.put(ga, i);
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
            this.sI.add(jVar);
            this.sH.remove(jVar);
            THREAD_POOL_EXECUTOR.execute(jVar);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, jVar), 180000L);
            switch (jVar.getPriority()) {
                case 1:
                    this.sF++;
                    break;
                case 2:
                    this.sE++;
                    break;
                case 3:
                    this.sD++;
                    break;
                case 4:
                    this.sC++;
                    if (this.sC >= 7) {
                        BdLog.e("SuperHight Task too much num = " + this.sC);
                        break;
                    }
                    break;
            }
            int ga = jVar.ga();
            if (ga != 0) {
                this.sG.put(ga, this.sG.get(ga, 0) + 1);
            }
        }
    }

    private boolean a(int i, j jVar) {
        if (jVar == null) {
            return false;
        }
        BdAsyncTaskParallel.BdAsyncTaskParallelType gb = jVar.gb();
        return gb == BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL ? i < 1 : gb == BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL ? i < 2 : gb == BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL ? i < 3 : gb == BdAsyncTaskParallel.BdAsyncTaskParallelType.FOUR_PARALLEL ? i < 4 : gb != BdAsyncTaskParallel.BdAsyncTaskParallelType.CUSTOM_PARALLEL || i < jVar.gd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void e(j jVar) {
        c(jVar);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.sH.size()) {
                j jVar2 = this.sH.get(i2);
                int ga = jVar2.ga();
                switch (jVar2.getPriority()) {
                    case 1:
                        if (this.sD + this.sE + this.sF >= 5) {
                            break;
                        }
                        break;
                    case 2:
                        if (this.sD + this.sE + this.sF >= 6) {
                            break;
                        }
                        break;
                    case 3:
                        if (this.sD + this.sE + this.sF >= 7) {
                            break;
                        }
                        break;
                    case 4:
                        if (ga == 0) {
                            d(jVar2);
                            break;
                        }
                        break;
                }
                if (!a(this.sG.get(ga), jVar2)) {
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
        a(this.sI, false, bdUniqueId, str);
        a(this.sJ, false, bdUniqueId, str);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        removeAllWaitingTask(bdUniqueId, null);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        a(this.sH, true, bdUniqueId, str);
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
        Iterator<j> it = this.sH.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            j next = it.next();
            if (next != null && next.fY() == bdAsyncTask) {
                break;
            }
        }
    }

    public int getTaskNum(String str, BdUniqueId bdUniqueId) {
        return a(this.sH, str, bdUniqueId) + a(this.sI, str, bdUniqueId) + a(this.sJ, str, bdUniqueId);
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
        BdAsyncTask<?, ?, ?> a;
        a = a(this.sH, str);
        if (a == null) {
            a = a(this.sI, str);
        }
        if (a == null) {
            a = a(this.sJ, str);
        }
        return a;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return searchAllTask(bdUniqueId, null);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.sH, bdUniqueId, str);
        if (a != null) {
            linkedList.addAll(a);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.sI, bdUniqueId, str);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a3 = a(this.sJ, bdUniqueId, str);
        if (a3 != null) {
            linkedList.addAll(a3);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return a(this.sH, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.sH, bdUniqueId, (String) null);
        if (a != null) {
            linkedList.addAll(a);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return a(this.sI, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
        r0 = r0.fY();
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
                if (key != null && key.equals(str) && !next.fY().isCancelled()) {
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
                    if (next.fY() != null && !next.fY().isCancelled()) {
                        linkedList3.add(next.fY());
                    }
                }
            }
            linkedList2 = linkedList3;
        }
        return linkedList2;
    }
}
