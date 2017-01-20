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
    private HandlerThread lD;
    private Handler mHandler;
    private static c ls = null;
    private static final ThreadFactory sThreadFactory = new d();
    private static final BlockingQueue<Runnable> sPoolWorkQueue = new SynchronousQueue();
    public static final Executor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(7, 256, 30, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory, new ThreadPoolExecutor.DiscardPolicy());
    private volatile int lt = 0;
    private volatile int lu = 0;
    private volatile int lw = 0;
    private volatile int lx = 0;
    private final SparseIntArray ly = new SparseIntArray();
    private final LinkedList<a> lA = new LinkedList<>();
    private final LinkedList<a> lB = new LinkedList<>();
    private final LinkedList<a> lC = new LinkedList<>();

    c() {
        this.lD = null;
        this.mHandler = null;
        this.lD = new HandlerThread("BdAsyncTaskExecutor");
        this.lD.start();
        this.mHandler = new e(this, this.lD.getLooper());
    }

    public String toString() {
        return "mWaitingTasks = " + this.lA.size() + " mRunningTasks = " + this.lB.size() + " mTimeOutTasks = " + this.lC.size();
    }

    public String dd() {
        return String.valueOf(this.lA.size()) + "/" + this.lB.size() + "/" + this.lC.size();
    }

    public static c de() {
        if (ls == null) {
            synchronized (c.class) {
                if (ls == null) {
                    ls = new c();
                }
            }
        }
        return ls;
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
            int size = this.lA.size();
            int i = 0;
            while (i < size && this.lA.get(i).getPriority() >= aVar.getPriority()) {
                i++;
            }
            this.lA.add(i, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(a aVar) {
        a poll;
        c(aVar);
        if (!aVar.isCancelled()) {
            aVar.setTimeout(true);
            this.lC.add(aVar);
            if (this.lC.size() > 242 && (poll = this.lC.poll()) != null) {
                poll.dc();
            }
        } else {
            BdLog.e("task TimeOut but it's cancelled()");
        }
        e(null);
    }

    private synchronized void c(a aVar) {
        if (aVar != null) {
            if (aVar.dh()) {
                this.lC.remove(aVar);
            } else {
                this.lB.remove(aVar);
                this.mHandler.removeMessages(1, aVar);
                switch (aVar.getPriority()) {
                    case 1:
                        this.lx--;
                        break;
                    case 2:
                        this.lw--;
                        break;
                    case 3:
                        this.lu--;
                        break;
                    case 4:
                        this.lt--;
                        break;
                }
                int di = aVar.di();
                if (di != 0) {
                    int i = this.ly.get(di) - 1;
                    if (i <= 0) {
                        this.ly.delete(di);
                    } else {
                        this.ly.put(di, i);
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
            this.lB.add(aVar);
            this.lA.remove(aVar);
            THREAD_POOL_EXECUTOR.execute(aVar);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, aVar), 180000L);
            switch (aVar.getPriority()) {
                case 1:
                    this.lx++;
                    break;
                case 2:
                    this.lw++;
                    break;
                case 3:
                    this.lu++;
                    break;
                case 4:
                    this.lt++;
                    if (this.lt >= 7) {
                        BdLog.e("SuperHight Task too much num = " + this.lt);
                        break;
                    }
                    break;
            }
            int di = aVar.di();
            if (di != 0) {
                this.ly.put(di, this.ly.get(di, 0) + 1);
            }
        }
    }

    private boolean a(int i, a aVar) {
        if (aVar == null) {
            return false;
        }
        BdAsyncTaskParallel.BdAsyncTaskParallelType dj = aVar.dj();
        return dj == BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL ? i < 1 : dj == BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL ? i < 2 : dj == BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL ? i < 3 : dj == BdAsyncTaskParallel.BdAsyncTaskParallelType.FOUR_PARALLEL ? i < 4 : dj != BdAsyncTaskParallel.BdAsyncTaskParallelType.CUSTOM_PARALLEL || i < aVar.dk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void e(a aVar) {
        c(aVar);
        int i = 0;
        while (true) {
            if (i < this.lA.size()) {
                a aVar2 = this.lA.get(i);
                if (aVar2 != null) {
                    int di = aVar2.di();
                    switch (aVar2.getPriority()) {
                        case 1:
                            if (this.lu + this.lw + this.lx >= 5) {
                                break;
                            }
                            break;
                        case 2:
                            if (this.lu + this.lw + this.lx >= 6) {
                                break;
                            }
                            break;
                        case 3:
                            if (this.lu + this.lw + this.lx >= 7) {
                                break;
                            }
                            break;
                        case 4:
                            if (di == 0) {
                                d(aVar2);
                                break;
                            }
                            break;
                    }
                    if (a(this.ly.get(di), aVar2)) {
                        d(aVar2);
                    }
                }
                i++;
            }
        }
    }

    public synchronized void removeAllTask(BdUniqueId bdUniqueId) {
        removeAllTask(bdUniqueId, null);
    }

    public synchronized void removeAllTask(BdUniqueId bdUniqueId, String str) {
        removeAllWaitingTask(bdUniqueId, str);
        a(this.lB, false, bdUniqueId, str);
        a(this.lC, false, bdUniqueId, str);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        removeAllWaitingTask(bdUniqueId, null);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        a(this.lA, true, bdUniqueId, str);
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
                    next.dc();
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
        Iterator<a> it = this.lA.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a next = it.next();
            if (next != null && next.dg() == bdAsyncTask) {
                break;
            }
        }
    }

    public int getTaskNum(String str, BdUniqueId bdUniqueId) {
        return a(this.lA, str, bdUniqueId) + a(this.lB, str, bdUniqueId) + a(this.lC, str, bdUniqueId);
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
                        if (next.dg() != null && !next.dg().isCancelled()) {
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
        a2 = a(this.lA, str);
        if (a2 == null) {
            a2 = a(this.lB, str);
        }
        if (a2 == null) {
            a2 = a(this.lC, str);
        }
        return a2;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return searchAllTask(bdUniqueId, null);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.lA, bdUniqueId, str);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a3 = a(this.lB, bdUniqueId, str);
        if (a3 != null) {
            linkedList.addAll(a3);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a4 = a(this.lC, bdUniqueId, str);
        if (a4 != null) {
            linkedList.addAll(a4);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return a(this.lA, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.lA, bdUniqueId, (String) null);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return a(this.lB, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
        r0 = r0.dg();
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
                if (key != null && key.equals(str) && !next.dg().isCancelled()) {
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
                    if (next.dg() != null && !next.dg().isCancelled()) {
                        linkedList3.add(next.dg());
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
        private g<?> lF;

        public a(g<?> gVar) {
            this.lF = null;
            if (gVar == null || gVar.dg() == null) {
                throw new InvalidParameterException("parameter is null");
            }
            this.lF = gVar;
        }

        public void df() {
            try {
                this.lF.run();
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }

        public void dc() {
            this.lF.dc();
        }

        public boolean isCancelled() {
            return this.lF.isCancelled();
        }

        public BdAsyncTask<?, ?, ?> dg() {
            return this.lF.dg();
        }

        public int getPriority() {
            return this.lF.dg().getPriority();
        }

        public void setTimeout(boolean z) {
            this.lF.dg().setTimeout(z);
        }

        public boolean dh() {
            return this.lF.dg().isTimeout();
        }

        public int getTag() {
            return this.lF.dg().getTag();
        }

        public int di() {
            if (this.lF.dg().getParallel() != null) {
                return this.lF.dg().getParallel().getTag();
            }
            return 0;
        }

        public String getKey() {
            return this.lF.dg().getKey();
        }

        public BdAsyncTaskParallel.BdAsyncTaskParallelType dj() {
            return this.lF.dg().getParallel() != null ? this.lF.dg().getParallel().dm() : BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
        }

        public int dk() {
            if (this.lF.dg().getParallel() != null) {
                return this.lF.dg().getParallel().dl();
            }
            return 1;
        }

        public boolean isSelfExecute() {
            return this.lF.dg().isSelfExecute();
        }
    }
}
