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
    private volatile int tq = 0;
    private volatile int tr = 0;
    private volatile int ts = 0;
    private volatile int tt = 0;
    private final SparseIntArray tu = new SparseIntArray();

    /* renamed from: tv  reason: collision with root package name */
    private final LinkedList<a> f0tv = new LinkedList<>();
    private final LinkedList<a> tw = new LinkedList<>();
    private final LinkedList<a> tx = new LinkedList<>();
    private HandlerThread ty;
    private static c tp = null;
    private static final ThreadFactory sThreadFactory = new d();
    private static final BlockingQueue<Runnable> sPoolWorkQueue = new SynchronousQueue();
    public static final Executor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(7, 256, 30, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory, new ThreadPoolExecutor.DiscardPolicy());

    c() {
        this.ty = null;
        this.mHandler = null;
        this.ty = new HandlerThread("BdAsyncTaskExecutor");
        this.ty.start();
        this.mHandler = new e(this, this.ty.getLooper());
    }

    public String toString() {
        return "mWaitingTasks = " + this.f0tv.size() + " mRunningTasks = " + this.tw.size() + " mTimeOutTasks = " + this.tx.size();
    }

    public String em() {
        return String.valueOf(this.f0tv.size()) + "/" + this.tw.size() + "/" + this.tx.size();
    }

    public static c en() {
        if (tp == null) {
            synchronized (c.class) {
                if (tp == null) {
                    tp = new c();
                }
            }
        }
        return tp;
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
            int size = this.f0tv.size();
            int i = 0;
            while (i < size && this.f0tv.get(i).getPriority() >= aVar.getPriority()) {
                i++;
            }
            this.f0tv.add(i, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(a aVar) {
        a poll;
        c(aVar);
        if (!aVar.isCancelled()) {
            aVar.setTimeout(true);
            this.tx.add(aVar);
            if (this.tx.size() > 242 && (poll = this.tx.poll()) != null) {
                poll.el();
            }
        } else {
            BdLog.e("task TimeOut but it's cancelled()");
        }
        e(null);
    }

    private synchronized void c(a aVar) {
        if (aVar != null) {
            if (aVar.eq()) {
                this.tx.remove(aVar);
            } else {
                this.tw.remove(aVar);
                this.mHandler.removeMessages(1, aVar);
                switch (aVar.getPriority()) {
                    case 1:
                        this.tt--;
                        break;
                    case 2:
                        this.ts--;
                        break;
                    case 3:
                        this.tr--;
                        break;
                    case 4:
                        this.tq--;
                        break;
                }
                int er = aVar.er();
                if (er != 0) {
                    int i = this.tu.get(er) - 1;
                    if (i <= 0) {
                        this.tu.delete(er);
                    } else {
                        this.tu.put(er, i);
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
            this.tw.add(aVar);
            this.f0tv.remove(aVar);
            THREAD_POOL_EXECUTOR.execute(aVar);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, aVar), 180000L);
            switch (aVar.getPriority()) {
                case 1:
                    this.tt++;
                    break;
                case 2:
                    this.ts++;
                    break;
                case 3:
                    this.tr++;
                    break;
                case 4:
                    this.tq++;
                    if (this.tq >= 7) {
                        BdLog.e("SuperHight Task too much num = " + this.tq);
                        break;
                    }
                    break;
            }
            int er = aVar.er();
            if (er != 0) {
                this.tu.put(er, this.tu.get(er, 0) + 1);
            }
        }
    }

    private boolean a(int i, a aVar) {
        if (aVar == null) {
            return false;
        }
        BdAsyncTaskParallel.BdAsyncTaskParallelType es = aVar.es();
        return es == BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL ? i < 1 : es == BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL ? i < 2 : es == BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL ? i < 3 : es == BdAsyncTaskParallel.BdAsyncTaskParallelType.FOUR_PARALLEL ? i < 4 : es != BdAsyncTaskParallel.BdAsyncTaskParallelType.CUSTOM_PARALLEL || i < aVar.et();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void e(a aVar) {
        c(aVar);
        int i = 0;
        while (true) {
            if (i < this.f0tv.size()) {
                a aVar2 = this.f0tv.get(i);
                if (aVar2 != null) {
                    int er = aVar2.er();
                    switch (aVar2.getPriority()) {
                        case 1:
                            if (this.tr + this.ts + this.tt >= 5) {
                                break;
                            }
                            break;
                        case 2:
                            if (this.tr + this.ts + this.tt >= 6) {
                                break;
                            }
                            break;
                        case 3:
                            if (this.tr + this.ts + this.tt >= 7) {
                                break;
                            }
                            break;
                        case 4:
                            if (er == 0) {
                                d(aVar2);
                                break;
                            }
                            break;
                    }
                    if (a(this.tu.get(er), aVar2)) {
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
        a(this.tw, false, bdUniqueId, str);
        a(this.tx, false, bdUniqueId, str);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        removeAllWaitingTask(bdUniqueId, null);
    }

    public synchronized void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        a(this.f0tv, true, bdUniqueId, str);
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
                    next.el();
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
        Iterator<a> it = this.f0tv.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a next = it.next();
            if (next != null && next.ep() == bdAsyncTask) {
                break;
            }
        }
    }

    public int getTaskNum(String str, BdUniqueId bdUniqueId) {
        return a(this.f0tv, str, bdUniqueId) + a(this.tw, str, bdUniqueId) + a(this.tx, str, bdUniqueId);
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
                        if (next.ep() != null && !next.ep().isCancelled()) {
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
        a2 = a(this.f0tv, str);
        if (a2 == null) {
            a2 = a(this.tw, str);
        }
        if (a2 == null) {
            a2 = a(this.tx, str);
        }
        return a2;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return searchAllTask(bdUniqueId, null);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.f0tv, bdUniqueId, str);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a3 = a(this.tw, bdUniqueId, str);
        if (a3 != null) {
            linkedList.addAll(a3);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> a4 = a(this.tx, bdUniqueId, str);
        if (a4 != null) {
            linkedList.addAll(a4);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return a(this.f0tv, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> a2 = a(this.f0tv, bdUniqueId, (String) null);
        if (a2 != null) {
            linkedList.addAll(a2);
        }
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return a(this.tw, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
        r0 = r0.ep();
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
                if (key != null && key.equals(str) && !next.ep().isCancelled()) {
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
                    if (next.ep() != null && !next.ep().isCancelled()) {
                        linkedList3.add(next.ep());
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
        private g<?> tA;

        public a(g<?> gVar) {
            this.tA = null;
            if (gVar == null || gVar.ep() == null) {
                throw new InvalidParameterException("parameter is null");
            }
            this.tA = gVar;
        }

        public void eo() {
            try {
                this.tA.run();
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }

        public void el() {
            this.tA.el();
        }

        public boolean isCancelled() {
            return this.tA.isCancelled();
        }

        public BdAsyncTask<?, ?, ?> ep() {
            return this.tA.ep();
        }

        public int getPriority() {
            return this.tA.ep().getPriority();
        }

        public void setTimeout(boolean z) {
            this.tA.ep().setTimeout(z);
        }

        public boolean eq() {
            return this.tA.ep().isTimeout();
        }

        public int getTag() {
            return this.tA.ep().getTag();
        }

        public int er() {
            if (this.tA.ep().getParallel() != null) {
                return this.tA.ep().getParallel().getTag();
            }
            return 0;
        }

        public String getKey() {
            return this.tA.ep().getKey();
        }

        public BdAsyncTaskParallel.BdAsyncTaskParallelType es() {
            return this.tA.ep().getParallel() != null ? this.tA.ep().getParallel().ev() : BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
        }

        public int et() {
            if (this.tA.ep().getParallel() != null) {
                return this.tA.ep().getParallel().eu();
            }
            return 1;
        }

        public boolean isSelfExecute() {
            return this.tA.ep().isSelfExecute();
        }
    }
}
