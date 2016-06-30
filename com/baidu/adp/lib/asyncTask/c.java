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
    private volatile int iH = 0;
    private volatile int iI = 0;
    private volatile int iJ = 0;
    private volatile int iK = 0;
    private final SparseIntArray iL = new SparseIntArray();
    private final LinkedList<a> iM = new LinkedList<>();
    private final LinkedList<a> iN = new LinkedList<>();
    private final LinkedList<a> iO = new LinkedList<>();
    private HandlerThread iP;
    private Handler mHandler;
    private static c iG = null;
    private static final ThreadFactory sThreadFactory = new d();
    private static final BlockingQueue<Runnable> sPoolWorkQueue = new SynchronousQueue();
    public static final Executor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(7, 256, 30, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory, new ThreadPoolExecutor.DiscardPolicy());

    c() {
        this.iP = null;
        this.mHandler = null;
        this.iP = new HandlerThread("BdAsyncTaskExecutor");
        this.iP.start();
        this.mHandler = new e(this, this.iP.getLooper());
    }

    public String toString() {
        return "mWaitingTasks = " + this.iM.size() + " mRunningTasks = " + this.iN.size() + " mTimeOutTasks = " + this.iO.size();
    }

    public String cl() {
        return String.valueOf(this.iM.size()) + "/" + this.iN.size() + "/" + this.iO.size();
    }

    public static c cm() {
        if (iG == null) {
            synchronized (c.class) {
                if (iG == null) {
                    iG = new c();
                }
            }
        }
        return iG;
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
            int size = this.iM.size();
            int i = 0;
            while (i < size && this.iM.get(i).getPriority() >= aVar.getPriority()) {
                i++;
            }
            this.iM.add(i, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(a aVar) {
        a poll;
        c(aVar);
        if (!aVar.isCancelled()) {
            aVar.setTimeout(true);
            this.iO.add(aVar);
            if (this.iO.size() > 242 && (poll = this.iO.poll()) != null) {
                poll.ck();
            }
        } else {
            BdLog.e("task TimeOut but it's cancelled()");
        }
        e(null);
    }

    private synchronized void c(a aVar) {
        if (aVar != null) {
            if (aVar.cp()) {
                this.iO.remove(aVar);
            } else {
                this.iN.remove(aVar);
                this.mHandler.removeMessages(1, aVar);
                switch (aVar.getPriority()) {
                    case 1:
                        this.iK--;
                        break;
                    case 2:
                        this.iJ--;
                        break;
                    case 3:
                        this.iI--;
                        break;
                    case 4:
                        this.iH--;
                        break;
                }
                int cq = aVar.cq();
                if (cq != 0) {
                    int i = this.iL.get(cq) - 1;
                    if (i <= 0) {
                        this.iL.delete(cq);
                    } else {
                        this.iL.put(cq, i);
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
            this.iN.add(aVar);
            this.iM.remove(aVar);
            THREAD_POOL_EXECUTOR.execute(aVar);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, aVar), 180000L);
            switch (aVar.getPriority()) {
                case 1:
                    this.iK++;
                    break;
                case 2:
                    this.iJ++;
                    break;
                case 3:
                    this.iI++;
                    break;
                case 4:
                    this.iH++;
                    if (this.iH >= 7) {
                        BdLog.e("SuperHight Task too much num = " + this.iH);
                        break;
                    }
                    break;
            }
            int cq = aVar.cq();
            if (cq != 0) {
                this.iL.put(cq, this.iL.get(cq, 0) + 1);
            }
        }
    }

    private boolean a(int i, a aVar) {
        if (aVar == null) {
            return false;
        }
        BdAsyncTaskParallel.BdAsyncTaskParallelType cr = aVar.cr();
        return cr == BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL ? i < 1 : cr == BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL ? i < 2 : cr == BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL ? i < 3 : cr == BdAsyncTaskParallel.BdAsyncTaskParallelType.FOUR_PARALLEL ? i < 4 : cr != BdAsyncTaskParallel.BdAsyncTaskParallelType.CUSTOM_PARALLEL || i < aVar.cs();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void e(a aVar) {
        c(aVar);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.iM.size()) {
                a aVar2 = this.iM.get(i2);
                int cq = aVar2.cq();
                switch (aVar2.getPriority()) {
                    case 1:
                        if (this.iI + this.iJ + this.iK >= 5) {
                            break;
                        }
                        break;
                    case 2:
                        if (this.iI + this.iJ + this.iK >= 6) {
                            break;
                        }
                        break;
                    case 3:
                        if (this.iI + this.iJ + this.iK >= 7) {
                            break;
                        }
                        break;
                    case 4:
                        if (cq == 0) {
                            d(aVar2);
                            break;
                        }
                        break;
                }
                if (!a(this.iL.get(cq), aVar2)) {
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
        a(this.iN, false, bdUniqueId, str);
        a(this.iO, false, bdUniqueId, str);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        removeAllWaitingTask(bdUniqueId, null);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        a(this.iM, true, bdUniqueId, str);
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
                    next.ck();
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
        Iterator<a> it = this.iM.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a next = it.next();
            if (next != null && next.co() == bdAsyncTask) {
                break;
            }
        }
    }

    public int getTaskNum(String str, BdUniqueId bdUniqueId) {
        return a(this.iM, str, bdUniqueId) + a(this.iN, str, bdUniqueId) + a(this.iO, str, bdUniqueId);
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
                        if (next.co() != null && !next.co().isCancelled()) {
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
        a2 = a(this.iM, str);
        if (a2 == null) {
            a2 = a(this.iN, str);
        }
        if (a2 == null) {
            a2 = a(this.iO, str);
        }
        return a2;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return searchAllTask(bdUniqueId, null);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.iM, bdUniqueId, str);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a3 = a(this.iN, bdUniqueId, str);
        if (a3 != null) {
            linkedList.addAll(a3);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a4 = a(this.iO, bdUniqueId, str);
        if (a4 != null) {
            linkedList.addAll(a4);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return a(this.iM, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.iM, bdUniqueId, (String) null);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return a(this.iN, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
        r0 = r0.co();
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
                if (key != null && key.equals(str) && !next.co().isCancelled()) {
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
                    if (next.co() != null && !next.co().isCancelled()) {
                        linkedList3.add(next.co());
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
        private g<?> iR;

        public a(g<?> gVar) {
            this.iR = null;
            if (gVar == null || gVar.co() == null) {
                throw new InvalidParameterException("parameter is null");
            }
            this.iR = gVar;
        }

        public void cn() {
            try {
                this.iR.run();
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }

        public void ck() {
            this.iR.ck();
        }

        public boolean isCancelled() {
            return this.iR.isCancelled();
        }

        public BdAsyncTask<?, ?, ?> co() {
            return this.iR.co();
        }

        public int getPriority() {
            return this.iR.co().getPriority();
        }

        public void setTimeout(boolean z) {
            this.iR.co().setTimeout(z);
        }

        public boolean cp() {
            return this.iR.co().isTimeout();
        }

        public int getTag() {
            return this.iR.co().getTag();
        }

        public int cq() {
            if (this.iR.co().getParallel() != null) {
                return this.iR.co().getParallel().getTag();
            }
            return 0;
        }

        public String getKey() {
            return this.iR.co().getKey();
        }

        public BdAsyncTaskParallel.BdAsyncTaskParallelType cr() {
            return this.iR.co().getParallel() != null ? this.iR.co().getParallel().cu() : BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
        }

        public int cs() {
            if (this.iR.co().getParallel() != null) {
                return this.iR.co().getParallel().ct();
            }
            return 1;
        }

        public boolean isSelfExecute() {
            return this.iR.co().isSelfExecute();
        }
    }
}
