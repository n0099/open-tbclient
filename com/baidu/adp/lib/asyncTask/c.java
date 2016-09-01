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
    private volatile int lA = 0;
    private volatile int lB = 0;
    private volatile int lC = 0;
    private volatile int lD = 0;
    private final SparseIntArray lE = new SparseIntArray();
    private final LinkedList<a> lF = new LinkedList<>();
    private final LinkedList<a> lG = new LinkedList<>();
    private final LinkedList<a> lH = new LinkedList<>();
    private HandlerThread lI;
    private Handler mHandler;
    private static c ly = null;
    private static final ThreadFactory sThreadFactory = new d();
    private static final BlockingQueue<Runnable> sPoolWorkQueue = new SynchronousQueue();
    public static final Executor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(7, 256, 30, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory, new ThreadPoolExecutor.DiscardPolicy());

    c() {
        this.lI = null;
        this.mHandler = null;
        this.lI = new HandlerThread("BdAsyncTaskExecutor");
        this.lI.start();
        this.mHandler = new e(this, this.lI.getLooper());
    }

    public String toString() {
        return "mWaitingTasks = " + this.lF.size() + " mRunningTasks = " + this.lG.size() + " mTimeOutTasks = " + this.lH.size();
    }

    public String df() {
        return String.valueOf(this.lF.size()) + "/" + this.lG.size() + "/" + this.lH.size();
    }

    public static c dg() {
        if (ly == null) {
            synchronized (c.class) {
                if (ly == null) {
                    ly = new c();
                }
            }
        }
        return ly;
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
            int size = this.lF.size();
            int i = 0;
            while (i < size && this.lF.get(i).getPriority() >= aVar.getPriority()) {
                i++;
            }
            this.lF.add(i, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(a aVar) {
        a poll;
        c(aVar);
        if (!aVar.isCancelled()) {
            aVar.setTimeout(true);
            this.lH.add(aVar);
            if (this.lH.size() > 242 && (poll = this.lH.poll()) != null) {
                poll.de();
            }
        } else {
            BdLog.e("task TimeOut but it's cancelled()");
        }
        e(null);
    }

    private synchronized void c(a aVar) {
        if (aVar != null) {
            if (aVar.dj()) {
                this.lH.remove(aVar);
            } else {
                this.lG.remove(aVar);
                this.mHandler.removeMessages(1, aVar);
                switch (aVar.getPriority()) {
                    case 1:
                        this.lD--;
                        break;
                    case 2:
                        this.lC--;
                        break;
                    case 3:
                        this.lB--;
                        break;
                    case 4:
                        this.lA--;
                        break;
                }
                int dk = aVar.dk();
                if (dk != 0) {
                    int i = this.lE.get(dk) - 1;
                    if (i <= 0) {
                        this.lE.delete(dk);
                    } else {
                        this.lE.put(dk, i);
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
            this.lG.add(aVar);
            this.lF.remove(aVar);
            THREAD_POOL_EXECUTOR.execute(aVar);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, aVar), 180000L);
            switch (aVar.getPriority()) {
                case 1:
                    this.lD++;
                    break;
                case 2:
                    this.lC++;
                    break;
                case 3:
                    this.lB++;
                    break;
                case 4:
                    this.lA++;
                    if (this.lA >= 7) {
                        BdLog.e("SuperHight Task too much num = " + this.lA);
                        break;
                    }
                    break;
            }
            int dk = aVar.dk();
            if (dk != 0) {
                this.lE.put(dk, this.lE.get(dk, 0) + 1);
            }
        }
    }

    private boolean a(int i, a aVar) {
        if (aVar == null) {
            return false;
        }
        BdAsyncTaskParallel.BdAsyncTaskParallelType dl = aVar.dl();
        return dl == BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL ? i < 1 : dl == BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL ? i < 2 : dl == BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL ? i < 3 : dl == BdAsyncTaskParallel.BdAsyncTaskParallelType.FOUR_PARALLEL ? i < 4 : dl != BdAsyncTaskParallel.BdAsyncTaskParallelType.CUSTOM_PARALLEL || i < aVar.dm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void e(a aVar) {
        c(aVar);
        int i = 0;
        while (true) {
            if (i < this.lF.size()) {
                a aVar2 = this.lF.get(i);
                if (aVar2 != null) {
                    int dk = aVar2.dk();
                    switch (aVar2.getPriority()) {
                        case 1:
                            if (this.lB + this.lC + this.lD >= 5) {
                                break;
                            }
                            break;
                        case 2:
                            if (this.lB + this.lC + this.lD >= 6) {
                                break;
                            }
                            break;
                        case 3:
                            if (this.lB + this.lC + this.lD >= 7) {
                                break;
                            }
                            break;
                        case 4:
                            if (dk == 0) {
                                d(aVar2);
                                break;
                            }
                            break;
                    }
                    if (a(this.lE.get(dk), aVar2)) {
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
        a(this.lG, false, bdUniqueId, str);
        a(this.lH, false, bdUniqueId, str);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        removeAllWaitingTask(bdUniqueId, null);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        a(this.lF, true, bdUniqueId, str);
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
                    next.de();
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
        Iterator<a> it = this.lF.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a next = it.next();
            if (next != null && next.di() == bdAsyncTask) {
                break;
            }
        }
    }

    public int getTaskNum(String str, BdUniqueId bdUniqueId) {
        return a(this.lF, str, bdUniqueId) + a(this.lG, str, bdUniqueId) + a(this.lH, str, bdUniqueId);
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
                        if (next.di() != null && !next.di().isCancelled()) {
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
        a2 = a(this.lF, str);
        if (a2 == null) {
            a2 = a(this.lG, str);
        }
        if (a2 == null) {
            a2 = a(this.lH, str);
        }
        return a2;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return searchAllTask(bdUniqueId, null);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.lF, bdUniqueId, str);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a3 = a(this.lG, bdUniqueId, str);
        if (a3 != null) {
            linkedList.addAll(a3);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a4 = a(this.lH, bdUniqueId, str);
        if (a4 != null) {
            linkedList.addAll(a4);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return a(this.lF, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.lF, bdUniqueId, (String) null);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return a(this.lG, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
        r0 = r0.di();
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
                if (key != null && key.equals(str) && !next.di().isCancelled()) {
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
                    if (next.di() != null && !next.di().isCancelled()) {
                        linkedList3.add(next.di());
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
        private g<?> lK;

        public a(g<?> gVar) {
            this.lK = null;
            if (gVar == null || gVar.di() == null) {
                throw new InvalidParameterException("parameter is null");
            }
            this.lK = gVar;
        }

        public void dh() {
            try {
                this.lK.run();
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }

        public void de() {
            this.lK.de();
        }

        public boolean isCancelled() {
            return this.lK.isCancelled();
        }

        public BdAsyncTask<?, ?, ?> di() {
            return this.lK.di();
        }

        public int getPriority() {
            return this.lK.di().getPriority();
        }

        public void setTimeout(boolean z) {
            this.lK.di().setTimeout(z);
        }

        public boolean dj() {
            return this.lK.di().isTimeout();
        }

        public int getTag() {
            return this.lK.di().getTag();
        }

        public int dk() {
            if (this.lK.di().getParallel() != null) {
                return this.lK.di().getParallel().getTag();
            }
            return 0;
        }

        public String getKey() {
            return this.lK.di().getKey();
        }

        public BdAsyncTaskParallel.BdAsyncTaskParallelType dl() {
            return this.lK.di().getParallel() != null ? this.lK.di().getParallel().m4do() : BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
        }

        public int dm() {
            if (this.lK.di().getParallel() != null) {
                return this.lK.di().getParallel().dn();
            }
            return 1;
        }

        public boolean isSelfExecute() {
            return this.lK.di().isSelfExecute();
        }
    }
}
