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
    private volatile int iJ = 0;
    private volatile int iK = 0;
    private volatile int iL = 0;
    private volatile int iM = 0;
    private final SparseIntArray iN = new SparseIntArray();
    private final LinkedList<a> iO = new LinkedList<>();
    private final LinkedList<a> iP = new LinkedList<>();
    private final LinkedList<a> iQ = new LinkedList<>();
    private HandlerThread iR;
    private Handler mHandler;
    private static c iI = null;
    private static final ThreadFactory sThreadFactory = new d();
    private static final BlockingQueue<Runnable> sPoolWorkQueue = new SynchronousQueue();
    public static final Executor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(7, 256, 30, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory, new ThreadPoolExecutor.DiscardPolicy());

    c() {
        this.iR = null;
        this.mHandler = null;
        this.iR = new HandlerThread("BdAsyncTaskExecutor");
        this.iR.start();
        this.mHandler = new e(this, this.iR.getLooper());
    }

    public String toString() {
        return "mWaitingTasks = " + this.iO.size() + " mRunningTasks = " + this.iP.size() + " mTimeOutTasks = " + this.iQ.size();
    }

    public String ck() {
        return String.valueOf(this.iO.size()) + "/" + this.iP.size() + "/" + this.iQ.size();
    }

    public static c cl() {
        if (iI == null) {
            synchronized (c.class) {
                if (iI == null) {
                    iI = new c();
                }
            }
        }
        return iI;
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
            int size = this.iO.size();
            int i = 0;
            while (i < size && this.iO.get(i).getPriority() >= aVar.getPriority()) {
                i++;
            }
            this.iO.add(i, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(a aVar) {
        a poll;
        c(aVar);
        if (!aVar.isCancelled()) {
            aVar.setTimeout(true);
            this.iQ.add(aVar);
            if (this.iQ.size() > 242 && (poll = this.iQ.poll()) != null) {
                poll.cj();
            }
        } else {
            BdLog.e("task TimeOut but it's cancelled()");
        }
        e(null);
    }

    private synchronized void c(a aVar) {
        if (aVar != null) {
            if (aVar.co()) {
                this.iQ.remove(aVar);
            } else {
                this.iP.remove(aVar);
                this.mHandler.removeMessages(1, aVar);
                switch (aVar.getPriority()) {
                    case 1:
                        this.iM--;
                        break;
                    case 2:
                        this.iL--;
                        break;
                    case 3:
                        this.iK--;
                        break;
                    case 4:
                        this.iJ--;
                        break;
                }
                int cp = aVar.cp();
                if (cp != 0) {
                    int i = this.iN.get(cp) - 1;
                    if (i <= 0) {
                        this.iN.delete(cp);
                    } else {
                        this.iN.put(cp, i);
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
            this.iP.add(aVar);
            this.iO.remove(aVar);
            THREAD_POOL_EXECUTOR.execute(aVar);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, aVar), 180000L);
            switch (aVar.getPriority()) {
                case 1:
                    this.iM++;
                    break;
                case 2:
                    this.iL++;
                    break;
                case 3:
                    this.iK++;
                    break;
                case 4:
                    this.iJ++;
                    if (this.iJ >= 7) {
                        BdLog.e("SuperHight Task too much num = " + this.iJ);
                        break;
                    }
                    break;
            }
            int cp = aVar.cp();
            if (cp != 0) {
                this.iN.put(cp, this.iN.get(cp, 0) + 1);
            }
        }
    }

    private boolean a(int i, a aVar) {
        if (aVar == null) {
            return false;
        }
        BdAsyncTaskParallel.BdAsyncTaskParallelType cq = aVar.cq();
        return cq == BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL ? i < 1 : cq == BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL ? i < 2 : cq == BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL ? i < 3 : cq == BdAsyncTaskParallel.BdAsyncTaskParallelType.FOUR_PARALLEL ? i < 4 : cq != BdAsyncTaskParallel.BdAsyncTaskParallelType.CUSTOM_PARALLEL || i < aVar.cr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void e(a aVar) {
        c(aVar);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.iO.size()) {
                a aVar2 = this.iO.get(i2);
                int cp = aVar2.cp();
                switch (aVar2.getPriority()) {
                    case 1:
                        if (this.iK + this.iL + this.iM >= 5) {
                            break;
                        }
                        break;
                    case 2:
                        if (this.iK + this.iL + this.iM >= 6) {
                            break;
                        }
                        break;
                    case 3:
                        if (this.iK + this.iL + this.iM >= 7) {
                            break;
                        }
                        break;
                    case 4:
                        if (cp == 0) {
                            d(aVar2);
                            break;
                        }
                        break;
                }
                if (!a(this.iN.get(cp), aVar2)) {
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
        a(this.iP, false, bdUniqueId, str);
        a(this.iQ, false, bdUniqueId, str);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        removeAllWaitingTask(bdUniqueId, null);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        a(this.iO, true, bdUniqueId, str);
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
                    next.cj();
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
        Iterator<a> it = this.iO.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a next = it.next();
            if (next != null && next.cn() == bdAsyncTask) {
                break;
            }
        }
    }

    public int getTaskNum(String str, BdUniqueId bdUniqueId) {
        return a(this.iO, str, bdUniqueId) + a(this.iP, str, bdUniqueId) + a(this.iQ, str, bdUniqueId);
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
                        if (next.cn() != null && !next.cn().isCancelled()) {
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
        a2 = a(this.iO, str);
        if (a2 == null) {
            a2 = a(this.iP, str);
        }
        if (a2 == null) {
            a2 = a(this.iQ, str);
        }
        return a2;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return searchAllTask(bdUniqueId, null);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.iO, bdUniqueId, str);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a3 = a(this.iP, bdUniqueId, str);
        if (a3 != null) {
            linkedList.addAll(a3);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a4 = a(this.iQ, bdUniqueId, str);
        if (a4 != null) {
            linkedList.addAll(a4);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return a(this.iO, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.iO, bdUniqueId, (String) null);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return a(this.iP, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
        r0 = r0.cn();
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
                if (key != null && key.equals(str) && !next.cn().isCancelled()) {
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
                    if (next.cn() != null && !next.cn().isCancelled()) {
                        linkedList3.add(next.cn());
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
        private g<?> iT;

        public a(g<?> gVar) {
            this.iT = null;
            if (gVar == null || gVar.cn() == null) {
                throw new InvalidParameterException("parameter is null");
            }
            this.iT = gVar;
        }

        public void cm() {
            try {
                this.iT.run();
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }

        public void cj() {
            this.iT.cj();
        }

        public boolean isCancelled() {
            return this.iT.isCancelled();
        }

        public BdAsyncTask<?, ?, ?> cn() {
            return this.iT.cn();
        }

        public int getPriority() {
            return this.iT.cn().getPriority();
        }

        public void setTimeout(boolean z) {
            this.iT.cn().setTimeout(z);
        }

        public boolean co() {
            return this.iT.cn().isTimeout();
        }

        public int getTag() {
            return this.iT.cn().getTag();
        }

        public int cp() {
            if (this.iT.cn().getParallel() != null) {
                return this.iT.cn().getParallel().getTag();
            }
            return 0;
        }

        public String getKey() {
            return this.iT.cn().getKey();
        }

        public BdAsyncTaskParallel.BdAsyncTaskParallelType cq() {
            return this.iT.cn().getParallel() != null ? this.iT.cn().getParallel().ct() : BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
        }

        public int cr() {
            if (this.iT.cn().getParallel() != null) {
                return this.iT.cn().getParallel().cs();
            }
            return 1;
        }

        public boolean isSelfExecute() {
            return this.iT.cn().isSelfExecute();
        }
    }
}
