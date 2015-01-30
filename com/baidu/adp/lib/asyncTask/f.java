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
    private volatile int gV = 0;
    private volatile int gW = 0;
    private volatile int gX = 0;
    private volatile int gY = 0;
    private final SparseIntArray gZ = new SparseIntArray();
    private final LinkedList<j> ha = new LinkedList<>();
    private final LinkedList<j> hb = new LinkedList<>();
    private final LinkedList<j> hc = new LinkedList<>();
    private HandlerThread hd;
    private Handler mHandler;
    private static f gU = null;
    private static final ThreadFactory sThreadFactory = new g();
    private static final BlockingQueue<Runnable> sPoolWorkQueue = new SynchronousQueue();
    public static final Executor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(7, 256, 30, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory, new ThreadPoolExecutor.DiscardPolicy());

    f() {
        this.hd = null;
        this.mHandler = null;
        this.hd = new HandlerThread("BdAsyncTaskExecutor");
        this.hd.start();
        this.mHandler = new h(this, this.hd.getLooper());
    }

    public String toString() {
        return "mWaitingTasks = " + this.ha.size() + " mRunningTasks = " + this.hb.size() + " mTimeOutTasks = " + this.hc.size();
    }

    public String cs() {
        return String.valueOf(this.ha.size()) + "/" + this.hb.size() + "/" + this.hc.size();
    }

    public static void ct() {
        gU = null;
    }

    public static f cu() {
        if (gU == null) {
            synchronized (f.class) {
                if (gU == null) {
                    gU = new f();
                }
            }
        }
        return gU;
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
            int size = this.ha.size();
            int i = 0;
            while (i < size && this.ha.get(i).getPriority() >= jVar.getPriority()) {
                i++;
            }
            this.ha.add(i, jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(j jVar) {
        j poll;
        c(jVar);
        if (!jVar.isCancelled()) {
            jVar.setTimeout(true);
            this.hc.add(jVar);
            if (this.hc.size() > 242 && (poll = this.hc.poll()) != null) {
                poll.cr();
            }
        } else {
            BdLog.e("task TimeOut but it's cancelled()");
        }
        e(null);
    }

    private synchronized void c(j jVar) {
        if (jVar != null) {
            if (jVar.cx()) {
                this.hc.remove(jVar);
            } else {
                this.hb.remove(jVar);
                this.mHandler.removeMessages(1, jVar);
                switch (jVar.getPriority()) {
                    case 1:
                        this.gY--;
                        break;
                    case 2:
                        this.gX--;
                        break;
                    case 3:
                        this.gW--;
                        break;
                    case 4:
                        this.gV--;
                        break;
                }
                int cy = jVar.cy();
                if (cy != 0) {
                    int i = this.gZ.get(cy) - 1;
                    if (i <= 0) {
                        this.gZ.delete(cy);
                    } else {
                        this.gZ.put(cy, i);
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
            this.hb.add(jVar);
            this.ha.remove(jVar);
            THREAD_POOL_EXECUTOR.execute(jVar);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, jVar), 180000L);
            switch (jVar.getPriority()) {
                case 1:
                    this.gY++;
                    break;
                case 2:
                    this.gX++;
                    break;
                case 3:
                    this.gW++;
                    break;
                case 4:
                    this.gV++;
                    if (this.gV >= 7) {
                        BdLog.e("SuperHight Task too much num = " + this.gV);
                        break;
                    }
                    break;
            }
            int cy = jVar.cy();
            if (cy != 0) {
                this.gZ.put(cy, this.gZ.get(cy, 0) + 1);
            }
        }
    }

    private boolean a(int i, j jVar) {
        if (jVar == null) {
            return false;
        }
        BdAsyncTaskParallel.BdAsyncTaskParallelType cz = jVar.cz();
        return cz == BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL ? i < 1 : cz == BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL ? i < 2 : cz == BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL ? i < 3 : cz == BdAsyncTaskParallel.BdAsyncTaskParallelType.FOUR_PARALLEL ? i < 4 : cz != BdAsyncTaskParallel.BdAsyncTaskParallelType.CUSTOM_PARALLEL || i < jVar.cA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void e(j jVar) {
        c(jVar);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ha.size()) {
                j jVar2 = this.ha.get(i2);
                int cy = jVar2.cy();
                switch (jVar2.getPriority()) {
                    case 1:
                        if (this.gW + this.gX + this.gY >= 5) {
                            break;
                        }
                        break;
                    case 2:
                        if (this.gW + this.gX + this.gY >= 6) {
                            break;
                        }
                        break;
                    case 3:
                        if (this.gW + this.gX + this.gY >= 7) {
                            break;
                        }
                        break;
                    case 4:
                        if (cy == 0) {
                            d(jVar2);
                            break;
                        }
                        break;
                }
                if (!a(this.gZ.get(cy), jVar2)) {
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
        a(this.hb, false, bdUniqueId, str);
        a(this.hc, false, bdUniqueId, str);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        removeAllWaitingTask(bdUniqueId, null);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        a(this.ha, true, bdUniqueId, str);
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
                    next.cr();
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
        Iterator<j> it = this.ha.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            j next = it.next();
            if (next != null && next.cw() == bdAsyncTask) {
                break;
            }
        }
    }

    public int getTaskNum(String str, BdUniqueId bdUniqueId) {
        return a(this.ha, str, bdUniqueId) + a(this.hb, str, bdUniqueId) + a(this.hc, str, bdUniqueId);
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
                        if (next.cw() != null && !next.cw().isCancelled()) {
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
        a = a(this.ha, str);
        if (a == null) {
            a = a(this.hb, str);
        }
        if (a == null) {
            a = a(this.hc, str);
        }
        return a;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return searchAllTask(bdUniqueId, null);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.ha, bdUniqueId, str);
        if (a != null) {
            linkedList.addAll(a);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.hb, bdUniqueId, str);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a3 = a(this.hc, bdUniqueId, str);
        if (a3 != null) {
            linkedList.addAll(a3);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return a(this.ha, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.ha, bdUniqueId, (String) null);
        if (a != null) {
            linkedList.addAll(a);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return a(this.hb, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
        r0 = r0.cw();
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
                if (key != null && key.equals(str) && !next.cw().isCancelled()) {
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
                    if (next.cw() != null && !next.cw().isCancelled()) {
                        linkedList3.add(next.cw());
                    }
                }
            }
            linkedList2 = linkedList3;
        }
        return linkedList2;
    }
}
