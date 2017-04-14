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
    private Handler mHandler;
    private volatile int sL = 0;
    private volatile int sM = 0;
    private volatile int sN = 0;
    private volatile int sO = 0;
    private final SparseIntArray sP = new SparseIntArray();
    private final LinkedList<a> sQ = new LinkedList<>();
    private final LinkedList<a> sR = new LinkedList<>();
    private final LinkedList<a> sS = new LinkedList<>();
    private HandlerThread sT;
    private static c sK = null;
    private static final ThreadFactory sThreadFactory = new d();
    private static final BlockingQueue<Runnable> sPoolWorkQueue = new SynchronousQueue();
    public static final Executor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(7, 256, 30, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory, new ThreadPoolExecutor.DiscardPolicy());

    c() {
        this.sT = null;
        this.mHandler = null;
        this.sT = new HandlerThread("BdAsyncTaskExecutor");
        this.sT.start();
        this.mHandler = new e(this, this.sT.getLooper());
    }

    public String toString() {
        return "mWaitingTasks = " + this.sQ.size() + " mRunningTasks = " + this.sR.size() + " mTimeOutTasks = " + this.sS.size();
    }

    public String el() {
        return String.valueOf(this.sQ.size()) + "/" + this.sR.size() + "/" + this.sS.size();
    }

    public static c em() {
        if (sK == null) {
            synchronized (c.class) {
                if (sK == null) {
                    sK = new c();
                }
            }
        }
        return sK;
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
            int size = this.sQ.size();
            int i = 0;
            while (i < size && this.sQ.get(i).getPriority() >= aVar.getPriority()) {
                i++;
            }
            this.sQ.add(i, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(a aVar) {
        a poll;
        c(aVar);
        if (!aVar.isCancelled()) {
            aVar.setTimeout(true);
            this.sS.add(aVar);
            if (this.sS.size() > 242 && (poll = this.sS.poll()) != null) {
                poll.ek();
            }
        } else {
            BdLog.e("task TimeOut but it's cancelled()");
        }
        e(null);
    }

    private synchronized void c(a aVar) {
        if (aVar != null) {
            if (aVar.ep()) {
                this.sS.remove(aVar);
            } else {
                this.sR.remove(aVar);
                this.mHandler.removeMessages(1, aVar);
                switch (aVar.getPriority()) {
                    case 1:
                        this.sO--;
                        break;
                    case 2:
                        this.sN--;
                        break;
                    case 3:
                        this.sM--;
                        break;
                    case 4:
                        this.sL--;
                        break;
                }
                int eq = aVar.eq();
                if (eq != 0) {
                    int i = this.sP.get(eq) - 1;
                    if (i <= 0) {
                        this.sP.delete(eq);
                    } else {
                        this.sP.put(eq, i);
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
            this.sR.add(aVar);
            this.sQ.remove(aVar);
            THREAD_POOL_EXECUTOR.execute(aVar);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, aVar), 180000L);
            switch (aVar.getPriority()) {
                case 1:
                    this.sO++;
                    break;
                case 2:
                    this.sN++;
                    break;
                case 3:
                    this.sM++;
                    break;
                case 4:
                    this.sL++;
                    if (this.sL >= 7) {
                        BdLog.e("SuperHight Task too much num = " + this.sL);
                        break;
                    }
                    break;
            }
            int eq = aVar.eq();
            if (eq != 0) {
                this.sP.put(eq, this.sP.get(eq, 0) + 1);
            }
        }
    }

    private boolean a(int i, a aVar) {
        if (aVar == null) {
            return false;
        }
        BdAsyncTaskParallel.BdAsyncTaskParallelType er = aVar.er();
        return er == BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL ? i < 1 : er == BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL ? i < 2 : er == BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL ? i < 3 : er == BdAsyncTaskParallel.BdAsyncTaskParallelType.FOUR_PARALLEL ? i < 4 : er != BdAsyncTaskParallel.BdAsyncTaskParallelType.CUSTOM_PARALLEL || i < aVar.es();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void e(a aVar) {
        c(aVar);
        int i = 0;
        while (true) {
            if (i < this.sQ.size()) {
                a aVar2 = this.sQ.get(i);
                if (aVar2 != null) {
                    int eq = aVar2.eq();
                    switch (aVar2.getPriority()) {
                        case 1:
                            if (this.sM + this.sN + this.sO >= 5) {
                                break;
                            }
                            break;
                        case 2:
                            if (this.sM + this.sN + this.sO >= 6) {
                                break;
                            }
                            break;
                        case 3:
                            if (this.sM + this.sN + this.sO >= 7) {
                                break;
                            }
                            break;
                        case 4:
                            if (eq == 0) {
                                d(aVar2);
                                break;
                            }
                            break;
                    }
                    if (a(this.sP.get(eq), aVar2)) {
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
        a(this.sR, false, bdUniqueId, str);
        a(this.sS, false, bdUniqueId, str);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        removeAllWaitingTask(bdUniqueId, null);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        a(this.sQ, true, bdUniqueId, str);
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
                    next.ek();
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
        Iterator<a> it = this.sQ.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a next = it.next();
            if (next != null && next.eo() == bdAsyncTask) {
                break;
            }
        }
    }

    public int getTaskNum(String str, BdUniqueId bdUniqueId) {
        return a(this.sQ, str, bdUniqueId) + a(this.sR, str, bdUniqueId) + a(this.sS, str, bdUniqueId);
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
                        if (next.eo() != null && !next.eo().isCancelled()) {
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
        a2 = a(this.sQ, str);
        if (a2 == null) {
            a2 = a(this.sR, str);
        }
        if (a2 == null) {
            a2 = a(this.sS, str);
        }
        return a2;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return searchAllTask(bdUniqueId, null);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.sQ, bdUniqueId, str);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a3 = a(this.sR, bdUniqueId, str);
        if (a3 != null) {
            linkedList.addAll(a3);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a4 = a(this.sS, bdUniqueId, str);
        if (a4 != null) {
            linkedList.addAll(a4);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return a(this.sQ, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.sQ, bdUniqueId, (String) null);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return a(this.sR, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
        r0 = r0.eo();
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
                if (key != null && key.equals(str) && !next.eo().isCancelled()) {
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
                    if (next.eo() != null && !next.eo().isCancelled()) {
                        linkedList3.add(next.eo());
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
        private g<?> sV;

        public a(g<?> gVar) {
            this.sV = null;
            if (gVar == null || gVar.eo() == null) {
                throw new InvalidParameterException("parameter is null");
            }
            this.sV = gVar;
        }

        public void en() {
            try {
                this.sV.run();
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }

        public void ek() {
            this.sV.ek();
        }

        public boolean isCancelled() {
            return this.sV.isCancelled();
        }

        public BdAsyncTask<?, ?, ?> eo() {
            return this.sV.eo();
        }

        public int getPriority() {
            return this.sV.eo().getPriority();
        }

        public void setTimeout(boolean z) {
            this.sV.eo().setTimeout(z);
        }

        public boolean ep() {
            return this.sV.eo().isTimeout();
        }

        public int getTag() {
            return this.sV.eo().getTag();
        }

        public int eq() {
            if (this.sV.eo().getParallel() != null) {
                return this.sV.eo().getParallel().getTag();
            }
            return 0;
        }

        public String getKey() {
            return this.sV.eo().getKey();
        }

        public BdAsyncTaskParallel.BdAsyncTaskParallelType er() {
            return this.sV.eo().getParallel() != null ? this.sV.eo().getParallel().eu() : BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
        }

        public int es() {
            if (this.sV.eo().getParallel() != null) {
                return this.sV.eo().getParallel().et();
            }
            return 1;
        }

        public boolean isSelfExecute() {
            return this.sV.eo().isSelfExecute();
        }
    }
}
