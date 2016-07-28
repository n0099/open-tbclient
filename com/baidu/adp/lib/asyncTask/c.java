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
    private volatile int jj = 0;
    private volatile int jk = 0;
    private volatile int jl = 0;
    private volatile int jm = 0;
    private final SparseIntArray jn = new SparseIntArray();
    private final LinkedList<a> jo = new LinkedList<>();
    private final LinkedList<a> jp = new LinkedList<>();
    private final LinkedList<a> jq = new LinkedList<>();
    private HandlerThread jr;
    private Handler mHandler;
    private static c ji = null;
    private static final ThreadFactory sThreadFactory = new d();
    private static final BlockingQueue<Runnable> sPoolWorkQueue = new SynchronousQueue();
    public static final Executor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(7, 256, 30, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory, new ThreadPoolExecutor.DiscardPolicy());

    c() {
        this.jr = null;
        this.mHandler = null;
        this.jr = new HandlerThread("BdAsyncTaskExecutor");
        this.jr.start();
        this.mHandler = new e(this, this.jr.getLooper());
    }

    public String toString() {
        return "mWaitingTasks = " + this.jo.size() + " mRunningTasks = " + this.jp.size() + " mTimeOutTasks = " + this.jq.size();
    }

    public String ck() {
        return String.valueOf(this.jo.size()) + "/" + this.jp.size() + "/" + this.jq.size();
    }

    public static c cl() {
        if (ji == null) {
            synchronized (c.class) {
                if (ji == null) {
                    ji = new c();
                }
            }
        }
        return ji;
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
            int size = this.jo.size();
            int i = 0;
            while (i < size && this.jo.get(i).getPriority() >= aVar.getPriority()) {
                i++;
            }
            this.jo.add(i, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(a aVar) {
        a poll;
        c(aVar);
        if (!aVar.isCancelled()) {
            aVar.setTimeout(true);
            this.jq.add(aVar);
            if (this.jq.size() > 242 && (poll = this.jq.poll()) != null) {
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
                this.jq.remove(aVar);
            } else {
                this.jp.remove(aVar);
                this.mHandler.removeMessages(1, aVar);
                switch (aVar.getPriority()) {
                    case 1:
                        this.jm--;
                        break;
                    case 2:
                        this.jl--;
                        break;
                    case 3:
                        this.jk--;
                        break;
                    case 4:
                        this.jj--;
                        break;
                }
                int cp = aVar.cp();
                if (cp != 0) {
                    int i = this.jn.get(cp) - 1;
                    if (i <= 0) {
                        this.jn.delete(cp);
                    } else {
                        this.jn.put(cp, i);
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
            this.jp.add(aVar);
            this.jo.remove(aVar);
            THREAD_POOL_EXECUTOR.execute(aVar);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, aVar), 180000L);
            switch (aVar.getPriority()) {
                case 1:
                    this.jm++;
                    break;
                case 2:
                    this.jl++;
                    break;
                case 3:
                    this.jk++;
                    break;
                case 4:
                    this.jj++;
                    if (this.jj >= 7) {
                        BdLog.e("SuperHight Task too much num = " + this.jj);
                        break;
                    }
                    break;
            }
            int cp = aVar.cp();
            if (cp != 0) {
                this.jn.put(cp, this.jn.get(cp, 0) + 1);
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
            if (i2 < this.jo.size()) {
                a aVar2 = this.jo.get(i2);
                int cp = aVar2.cp();
                switch (aVar2.getPriority()) {
                    case 1:
                        if (this.jk + this.jl + this.jm >= 5) {
                            break;
                        }
                        break;
                    case 2:
                        if (this.jk + this.jl + this.jm >= 6) {
                            break;
                        }
                        break;
                    case 3:
                        if (this.jk + this.jl + this.jm >= 7) {
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
                if (!a(this.jn.get(cp), aVar2)) {
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
        a(this.jp, false, bdUniqueId, str);
        a(this.jq, false, bdUniqueId, str);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        removeAllWaitingTask(bdUniqueId, null);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        a(this.jo, true, bdUniqueId, str);
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
        Iterator<a> it = this.jo.iterator();
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
        return a(this.jo, str, bdUniqueId) + a(this.jp, str, bdUniqueId) + a(this.jq, str, bdUniqueId);
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
        a2 = a(this.jo, str);
        if (a2 == null) {
            a2 = a(this.jp, str);
        }
        if (a2 == null) {
            a2 = a(this.jq, str);
        }
        return a2;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return searchAllTask(bdUniqueId, null);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.jo, bdUniqueId, str);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a3 = a(this.jp, bdUniqueId, str);
        if (a3 != null) {
            linkedList.addAll(a3);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a4 = a(this.jq, bdUniqueId, str);
        if (a4 != null) {
            linkedList.addAll(a4);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return a(this.jo, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.jo, bdUniqueId, (String) null);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return a(this.jp, str);
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
        private g<?> jt;

        public a(g<?> gVar) {
            this.jt = null;
            if (gVar == null || gVar.cn() == null) {
                throw new InvalidParameterException("parameter is null");
            }
            this.jt = gVar;
        }

        public void cm() {
            try {
                this.jt.run();
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }

        public void cj() {
            this.jt.cj();
        }

        public boolean isCancelled() {
            return this.jt.isCancelled();
        }

        public BdAsyncTask<?, ?, ?> cn() {
            return this.jt.cn();
        }

        public int getPriority() {
            return this.jt.cn().getPriority();
        }

        public void setTimeout(boolean z) {
            this.jt.cn().setTimeout(z);
        }

        public boolean co() {
            return this.jt.cn().isTimeout();
        }

        public int getTag() {
            return this.jt.cn().getTag();
        }

        public int cp() {
            if (this.jt.cn().getParallel() != null) {
                return this.jt.cn().getParallel().getTag();
            }
            return 0;
        }

        public String getKey() {
            return this.jt.cn().getKey();
        }

        public BdAsyncTaskParallel.BdAsyncTaskParallelType cq() {
            return this.jt.cn().getParallel() != null ? this.jt.cn().getParallel().ct() : BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
        }

        public int cr() {
            if (this.jt.cn().getParallel() != null) {
                return this.jt.cn().getParallel().cs();
            }
            return 1;
        }

        public boolean isSelfExecute() {
            return this.jt.cn().isSelfExecute();
        }
    }
}
