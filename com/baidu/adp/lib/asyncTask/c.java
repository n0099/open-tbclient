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
    private volatile int lB = 0;
    private volatile int lC = 0;
    private volatile int lD = 0;
    private volatile int lE = 0;
    private final SparseIntArray lF = new SparseIntArray();
    private final LinkedList<a> lG = new LinkedList<>();
    private final LinkedList<a> lH = new LinkedList<>();
    private final LinkedList<a> lI = new LinkedList<>();
    private HandlerThread lJ;
    private Handler mHandler;
    private static c lA = null;
    private static final ThreadFactory sThreadFactory = new d();
    private static final BlockingQueue<Runnable> sPoolWorkQueue = new SynchronousQueue();
    public static final Executor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(7, 256, 30, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory, new ThreadPoolExecutor.DiscardPolicy());

    c() {
        this.lJ = null;
        this.mHandler = null;
        this.lJ = new HandlerThread("BdAsyncTaskExecutor");
        this.lJ.start();
        this.mHandler = new e(this, this.lJ.getLooper());
    }

    public String toString() {
        return "mWaitingTasks = " + this.lG.size() + " mRunningTasks = " + this.lH.size() + " mTimeOutTasks = " + this.lI.size();
    }

    public String df() {
        return String.valueOf(this.lG.size()) + "/" + this.lH.size() + "/" + this.lI.size();
    }

    public static c dg() {
        if (lA == null) {
            synchronized (c.class) {
                if (lA == null) {
                    lA = new c();
                }
            }
        }
        return lA;
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
            int size = this.lG.size();
            int i = 0;
            while (i < size && this.lG.get(i).getPriority() >= aVar.getPriority()) {
                i++;
            }
            this.lG.add(i, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(a aVar) {
        a poll;
        c(aVar);
        if (!aVar.isCancelled()) {
            aVar.setTimeout(true);
            this.lI.add(aVar);
            if (this.lI.size() > 242 && (poll = this.lI.poll()) != null) {
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
                this.lI.remove(aVar);
            } else {
                this.lH.remove(aVar);
                this.mHandler.removeMessages(1, aVar);
                switch (aVar.getPriority()) {
                    case 1:
                        this.lE--;
                        break;
                    case 2:
                        this.lD--;
                        break;
                    case 3:
                        this.lC--;
                        break;
                    case 4:
                        this.lB--;
                        break;
                }
                int dk = aVar.dk();
                if (dk != 0) {
                    int i = this.lF.get(dk) - 1;
                    if (i <= 0) {
                        this.lF.delete(dk);
                    } else {
                        this.lF.put(dk, i);
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
            this.lH.add(aVar);
            this.lG.remove(aVar);
            THREAD_POOL_EXECUTOR.execute(aVar);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, aVar), 180000L);
            switch (aVar.getPriority()) {
                case 1:
                    this.lE++;
                    break;
                case 2:
                    this.lD++;
                    break;
                case 3:
                    this.lC++;
                    break;
                case 4:
                    this.lB++;
                    if (this.lB >= 7) {
                        BdLog.e("SuperHight Task too much num = " + this.lB);
                        break;
                    }
                    break;
            }
            int dk = aVar.dk();
            if (dk != 0) {
                this.lF.put(dk, this.lF.get(dk, 0) + 1);
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
            if (i < this.lG.size()) {
                a aVar2 = this.lG.get(i);
                if (aVar2 != null) {
                    int dk = aVar2.dk();
                    switch (aVar2.getPriority()) {
                        case 1:
                            if (this.lC + this.lD + this.lE >= 5) {
                                break;
                            }
                            break;
                        case 2:
                            if (this.lC + this.lD + this.lE >= 6) {
                                break;
                            }
                            break;
                        case 3:
                            if (this.lC + this.lD + this.lE >= 7) {
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
                    if (a(this.lF.get(dk), aVar2)) {
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
        a(this.lH, false, bdUniqueId, str);
        a(this.lI, false, bdUniqueId, str);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        removeAllWaitingTask(bdUniqueId, null);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        a(this.lG, true, bdUniqueId, str);
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
        Iterator<a> it = this.lG.iterator();
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
        return a(this.lG, str, bdUniqueId) + a(this.lH, str, bdUniqueId) + a(this.lI, str, bdUniqueId);
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
        a2 = a(this.lG, str);
        if (a2 == null) {
            a2 = a(this.lH, str);
        }
        if (a2 == null) {
            a2 = a(this.lI, str);
        }
        return a2;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return searchAllTask(bdUniqueId, null);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.lG, bdUniqueId, str);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a3 = a(this.lH, bdUniqueId, str);
        if (a3 != null) {
            linkedList.addAll(a3);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a4 = a(this.lI, bdUniqueId, str);
        if (a4 != null) {
            linkedList.addAll(a4);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return a(this.lG, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.lG, bdUniqueId, (String) null);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return a(this.lH, str);
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
        private g<?> lL;

        public a(g<?> gVar) {
            this.lL = null;
            if (gVar == null || gVar.di() == null) {
                throw new InvalidParameterException("parameter is null");
            }
            this.lL = gVar;
        }

        public void dh() {
            try {
                this.lL.run();
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }

        public void de() {
            this.lL.de();
        }

        public boolean isCancelled() {
            return this.lL.isCancelled();
        }

        public BdAsyncTask<?, ?, ?> di() {
            return this.lL.di();
        }

        public int getPriority() {
            return this.lL.di().getPriority();
        }

        public void setTimeout(boolean z) {
            this.lL.di().setTimeout(z);
        }

        public boolean dj() {
            return this.lL.di().isTimeout();
        }

        public int getTag() {
            return this.lL.di().getTag();
        }

        public int dk() {
            if (this.lL.di().getParallel() != null) {
                return this.lL.di().getParallel().getTag();
            }
            return 0;
        }

        public String getKey() {
            return this.lL.di().getKey();
        }

        public BdAsyncTaskParallel.BdAsyncTaskParallelType dl() {
            return this.lL.di().getParallel() != null ? this.lL.di().getParallel().m4do() : BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
        }

        public int dm() {
            if (this.lL.di().getParallel() != null) {
                return this.lL.di().getParallel().dn();
            }
            return 1;
        }

        public boolean isSelfExecute() {
            return this.lL.di().isSelfExecute();
        }
    }
}
