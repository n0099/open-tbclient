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
    private volatile int gT = 0;
    private volatile int gU = 0;
    private volatile int gV = 0;
    private volatile int gW = 0;
    private final SparseIntArray gX = new SparseIntArray();
    private final LinkedList<j> gY = new LinkedList<>();
    private final LinkedList<j> gZ = new LinkedList<>();
    private final LinkedList<j> ha = new LinkedList<>();
    private HandlerThread hb;
    private Handler mHandler;
    private static f gS = null;
    private static final ThreadFactory sThreadFactory = new g();
    private static final BlockingQueue<Runnable> sPoolWorkQueue = new SynchronousQueue();
    public static final Executor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(7, 256, 30, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory, new ThreadPoolExecutor.DiscardPolicy());

    f() {
        this.hb = null;
        this.mHandler = null;
        this.hb = new HandlerThread("BdAsyncTaskExecutor");
        this.hb.start();
        this.mHandler = new h(this, this.hb.getLooper());
    }

    public String toString() {
        return "mWaitingTasks = " + this.gY.size() + " mRunningTasks = " + this.gZ.size() + " mTimeOutTasks = " + this.ha.size();
    }

    public String cu() {
        return String.valueOf(this.gY.size()) + "/" + this.gZ.size() + "/" + this.ha.size();
    }

    public static void cv() {
        gS = null;
    }

    public static f cw() {
        if (gS == null) {
            synchronized (f.class) {
                if (gS == null) {
                    gS = new f();
                }
            }
        }
        return gS;
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
            int size = this.gY.size();
            int i = 0;
            while (i < size && this.gY.get(i).getPriority() >= jVar.getPriority()) {
                i++;
            }
            this.gY.add(i, jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(j jVar) {
        j poll;
        c(jVar);
        if (!jVar.isCancelled()) {
            jVar.setTimeout(true);
            this.ha.add(jVar);
            if (this.ha.size() > 242 && (poll = this.ha.poll()) != null) {
                poll.ct();
            }
        } else {
            BdLog.e("task TimeOut but it's cancelled()");
        }
        e(null);
    }

    private synchronized void c(j jVar) {
        if (jVar != null) {
            if (jVar.cz()) {
                this.ha.remove(jVar);
            } else {
                this.gZ.remove(jVar);
                this.mHandler.removeMessages(1, jVar);
                switch (jVar.getPriority()) {
                    case 1:
                        this.gW--;
                        break;
                    case 2:
                        this.gV--;
                        break;
                    case 3:
                        this.gU--;
                        break;
                    case 4:
                        this.gT--;
                        break;
                }
                int cA = jVar.cA();
                if (cA != 0) {
                    int i = this.gX.get(cA) - 1;
                    if (i <= 0) {
                        this.gX.delete(cA);
                    } else {
                        this.gX.put(cA, i);
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
            this.gZ.add(jVar);
            this.gY.remove(jVar);
            THREAD_POOL_EXECUTOR.execute(jVar);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, jVar), 180000L);
            switch (jVar.getPriority()) {
                case 1:
                    this.gW++;
                    break;
                case 2:
                    this.gV++;
                    break;
                case 3:
                    this.gU++;
                    break;
                case 4:
                    this.gT++;
                    if (this.gT >= 7) {
                        BdLog.e("SuperHight Task too much num = " + this.gT);
                        break;
                    }
                    break;
            }
            int cA = jVar.cA();
            if (cA != 0) {
                this.gX.put(cA, this.gX.get(cA, 0) + 1);
            }
        }
    }

    private boolean a(int i, j jVar) {
        if (jVar == null) {
            return false;
        }
        BdAsyncTaskParallel.BdAsyncTaskParallelType cB = jVar.cB();
        return cB == BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL ? i < 1 : cB == BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL ? i < 2 : cB == BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL ? i < 3 : cB == BdAsyncTaskParallel.BdAsyncTaskParallelType.FOUR_PARALLEL ? i < 4 : cB != BdAsyncTaskParallel.BdAsyncTaskParallelType.CUSTOM_PARALLEL || i < jVar.cC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void e(j jVar) {
        c(jVar);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gY.size()) {
                j jVar2 = this.gY.get(i2);
                int cA = jVar2.cA();
                switch (jVar2.getPriority()) {
                    case 1:
                        if (this.gU + this.gV + this.gW >= 5) {
                            break;
                        }
                        break;
                    case 2:
                        if (this.gU + this.gV + this.gW >= 6) {
                            break;
                        }
                        break;
                    case 3:
                        if (this.gU + this.gV + this.gW >= 7) {
                            break;
                        }
                        break;
                    case 4:
                        if (cA == 0) {
                            d(jVar2);
                            break;
                        }
                        break;
                }
                if (!a(this.gX.get(cA), jVar2)) {
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
        a(this.gZ, false, bdUniqueId, str);
        a(this.ha, false, bdUniqueId, str);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        removeAllWaitingTask(bdUniqueId, null);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        a(this.gY, true, bdUniqueId, str);
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
                    next.ct();
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
        Iterator<j> it = this.gY.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            j next = it.next();
            if (next != null && next.cy() == bdAsyncTask) {
                break;
            }
        }
    }

    public int getTaskNum(String str, BdUniqueId bdUniqueId) {
        return a(this.gY, str, bdUniqueId) + a(this.gZ, str, bdUniqueId) + a(this.ha, str, bdUniqueId);
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
                        if (next.cy() != null && !next.cy().isCancelled()) {
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
        a = a(this.gY, str);
        if (a == null) {
            a = a(this.gZ, str);
        }
        if (a == null) {
            a = a(this.ha, str);
        }
        return a;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return searchAllTask(bdUniqueId, null);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.gY, bdUniqueId, str);
        if (a != null) {
            linkedList.addAll(a);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.gZ, bdUniqueId, str);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a3 = a(this.ha, bdUniqueId, str);
        if (a3 != null) {
            linkedList.addAll(a3);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return a(this.gY, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.gY, bdUniqueId, (String) null);
        if (a != null) {
            linkedList.addAll(a);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return a(this.gZ, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
        r0 = r0.cy();
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
                if (key != null && key.equals(str) && !next.cy().isCancelled()) {
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
                    if (next.cy() != null && !next.cy().isCancelled()) {
                        linkedList3.add(next.cy());
                    }
                }
            }
            linkedList2 = linkedList3;
        }
        return linkedList2;
    }
}
