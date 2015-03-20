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
    private volatile int sr = 0;
    private volatile int ss = 0;
    private volatile int st = 0;
    private volatile int su = 0;
    private final SparseIntArray sv = new SparseIntArray();
    private final LinkedList<j> sw = new LinkedList<>();
    private final LinkedList<j> sx = new LinkedList<>();
    private final LinkedList<j> sy = new LinkedList<>();
    private HandlerThread sz;
    private static f sq = null;
    private static final ThreadFactory sThreadFactory = new g();
    private static final BlockingQueue<Runnable> sPoolWorkQueue = new SynchronousQueue();
    public static final Executor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(7, 256, 30, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory, new ThreadPoolExecutor.DiscardPolicy());

    f() {
        this.sz = null;
        this.mHandler = null;
        this.sz = new HandlerThread("BdAsyncTaskExecutor");
        this.sz.start();
        this.mHandler = new h(this, this.sz.getLooper());
    }

    public String toString() {
        return "mWaitingTasks = " + this.sw.size() + " mRunningTasks = " + this.sx.size() + " mTimeOutTasks = " + this.sy.size();
    }

    public String fQ() {
        return String.valueOf(this.sw.size()) + "/" + this.sx.size() + "/" + this.sy.size();
    }

    public static void fR() {
        sq = null;
    }

    public static f fS() {
        if (sq == null) {
            synchronized (f.class) {
                if (sq == null) {
                    sq = new f();
                }
            }
        }
        return sq;
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
            int size = this.sw.size();
            int i = 0;
            while (i < size && this.sw.get(i).getPriority() >= jVar.getPriority()) {
                i++;
            }
            this.sw.add(i, jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(j jVar) {
        j poll;
        c(jVar);
        if (!jVar.isCancelled()) {
            jVar.setTimeout(true);
            this.sy.add(jVar);
            if (this.sy.size() > 242 && (poll = this.sy.poll()) != null) {
                poll.fP();
            }
        } else {
            BdLog.e("task TimeOut but it's cancelled()");
        }
        e(null);
    }

    private synchronized void c(j jVar) {
        if (jVar != null) {
            if (jVar.fV()) {
                this.sy.remove(jVar);
            } else {
                this.sx.remove(jVar);
                this.mHandler.removeMessages(1, jVar);
                switch (jVar.getPriority()) {
                    case 1:
                        this.su--;
                        break;
                    case 2:
                        this.st--;
                        break;
                    case 3:
                        this.ss--;
                        break;
                    case 4:
                        this.sr--;
                        break;
                }
                int fW = jVar.fW();
                if (fW != 0) {
                    int i = this.sv.get(fW) - 1;
                    if (i <= 0) {
                        this.sv.delete(fW);
                    } else {
                        this.sv.put(fW, i);
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
            this.sx.add(jVar);
            this.sw.remove(jVar);
            THREAD_POOL_EXECUTOR.execute(jVar);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, jVar), 180000L);
            switch (jVar.getPriority()) {
                case 1:
                    this.su++;
                    break;
                case 2:
                    this.st++;
                    break;
                case 3:
                    this.ss++;
                    break;
                case 4:
                    this.sr++;
                    if (this.sr >= 7) {
                        BdLog.e("SuperHight Task too much num = " + this.sr);
                        break;
                    }
                    break;
            }
            int fW = jVar.fW();
            if (fW != 0) {
                this.sv.put(fW, this.sv.get(fW, 0) + 1);
            }
        }
    }

    private boolean a(int i, j jVar) {
        if (jVar == null) {
            return false;
        }
        BdAsyncTaskParallel.BdAsyncTaskParallelType fX = jVar.fX();
        return fX == BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL ? i < 1 : fX == BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL ? i < 2 : fX == BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL ? i < 3 : fX == BdAsyncTaskParallel.BdAsyncTaskParallelType.FOUR_PARALLEL ? i < 4 : fX != BdAsyncTaskParallel.BdAsyncTaskParallelType.CUSTOM_PARALLEL || i < jVar.fY();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void e(j jVar) {
        c(jVar);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.sw.size()) {
                j jVar2 = this.sw.get(i2);
                int fW = jVar2.fW();
                switch (jVar2.getPriority()) {
                    case 1:
                        if (this.ss + this.st + this.su >= 5) {
                            break;
                        }
                        break;
                    case 2:
                        if (this.ss + this.st + this.su >= 6) {
                            break;
                        }
                        break;
                    case 3:
                        if (this.ss + this.st + this.su >= 7) {
                            break;
                        }
                        break;
                    case 4:
                        if (fW == 0) {
                            d(jVar2);
                            break;
                        }
                        break;
                }
                if (!a(this.sv.get(fW), jVar2)) {
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
        a(this.sx, false, bdUniqueId, str);
        a(this.sy, false, bdUniqueId, str);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        removeAllWaitingTask(bdUniqueId, null);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        a(this.sw, true, bdUniqueId, str);
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
        Iterator<j> it = this.sw.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            j next = it.next();
            if (next != null && next.fU() == bdAsyncTask) {
                break;
            }
        }
    }

    public int getTaskNum(String str, BdUniqueId bdUniqueId) {
        return a(this.sw, str, bdUniqueId) + a(this.sx, str, bdUniqueId) + a(this.sy, str, bdUniqueId);
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
                        if (next.fU() != null && !next.fU().isCancelled()) {
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
        a = a(this.sw, str);
        if (a == null) {
            a = a(this.sx, str);
        }
        if (a == null) {
            a = a(this.sy, str);
        }
        return a;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return searchAllTask(bdUniqueId, null);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.sw, bdUniqueId, str);
        if (a != null) {
            linkedList.addAll(a);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.sx, bdUniqueId, str);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a3 = a(this.sy, bdUniqueId, str);
        if (a3 != null) {
            linkedList.addAll(a3);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return a(this.sw, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a = a(this.sw, bdUniqueId, (String) null);
        if (a != null) {
            linkedList.addAll(a);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return a(this.sx, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
        r0 = r0.fU();
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
                if (key != null && key.equals(str) && !next.fU().isCancelled()) {
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
                    if (next.fU() != null && !next.fU().isCancelled()) {
                        linkedList3.add(next.fU());
                    }
                }
            }
            linkedList2 = linkedList3;
        }
        return linkedList2;
    }
}
