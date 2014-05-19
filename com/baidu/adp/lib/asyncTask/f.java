package com.baidu.adp.lib.asyncTask;

import android.os.Handler;
import android.util.SparseIntArray;
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
    private volatile int e = 0;
    private volatile int f = 0;
    private volatile int g = 0;
    private volatile int h = 0;
    private final SparseIntArray i = new SparseIntArray();
    private final LinkedList<j> j = new LinkedList<>();
    private final LinkedList<j> k = new LinkedList<>();
    private final LinkedList<j> l = new LinkedList<>();
    private final Handler m = new h(this);
    private static f b = null;
    private static final ThreadFactory c = new g();
    private static final BlockingQueue<Runnable> d = new SynchronousQueue();
    public static final Executor a = new ThreadPoolExecutor(5, 256, 30, TimeUnit.SECONDS, d, c, new ThreadPoolExecutor.DiscardPolicy());

    private f() {
        com.baidu.adp.lib.util.h.b();
    }

    public String toString() {
        return "mWaitingTasks = " + this.j.size() + " mRunningTasks = " + this.k.size() + " mTimeOutTasks = " + this.l.size();
    }

    public static f a() {
        if (b == null) {
            synchronized (f.class) {
                if (b == null) {
                    b = new f();
                }
            }
        }
        return b;
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        com.baidu.adp.lib.util.h.b();
        if (runnable instanceof k) {
            i iVar = new i(this, (k) runnable);
            if (iVar.k()) {
                new Thread(iVar).start();
            } else {
                b(iVar);
                a((j) null);
                if (com.baidu.adp.base.a.getInst().isDebugMode()) {
                    BdLog.d(toString());
                }
            }
        }
    }

    private synchronized void b(j jVar) {
        if (jVar != null) {
            int size = this.j.size();
            int i = 0;
            while (i < size && this.j.get(i).e() >= jVar.e()) {
                i++;
            }
            this.j.add(i, jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c(j jVar) {
        j poll;
        d(jVar);
        if (!jVar.c()) {
            jVar.a(true);
            this.l.add(jVar);
            if (this.l.size() > 246 && (poll = this.l.poll()) != null) {
                poll.b();
            }
        } else {
            BdLog.e("task TimeOut but it's cancelled()");
        }
        a((j) null);
    }

    private synchronized void d(j jVar) {
        if (jVar != null) {
            if (jVar.f()) {
                this.l.remove(jVar);
            } else {
                this.k.remove(jVar);
                this.m.removeMessages(1, jVar);
                switch (jVar.e()) {
                    case 1:
                        this.h--;
                        break;
                    case 2:
                        this.g--;
                        break;
                    case 3:
                        this.f--;
                        break;
                    case 4:
                        this.e--;
                        break;
                }
                int h = jVar.h();
                if (h != 0) {
                    int i = this.i.get(h) - 1;
                    if (i <= 0) {
                        this.i.delete(h);
                    } else {
                        this.i.put(h, i);
                    }
                    if (i < 0) {
                        BdLog.e("removeTask error < 0");
                    }
                }
            }
        }
    }

    private synchronized void e(j jVar) {
        if (jVar != null) {
            this.k.add(jVar);
            this.j.remove(jVar);
            a.execute(jVar);
            this.m.sendMessageDelayed(this.m.obtainMessage(1, jVar), 180000L);
            switch (jVar.e()) {
                case 1:
                    this.h++;
                    break;
                case 2:
                    this.g++;
                    break;
                case 3:
                    this.f++;
                    break;
                case 4:
                    this.e++;
                    if (this.e >= 5) {
                        BdLog.e("SuperHight Task too much num = " + this.e);
                        break;
                    }
                    break;
            }
            int h = jVar.h();
            if (h != 0) {
                this.i.put(h, this.i.get(h, 0) + 1);
            }
        }
    }

    private boolean a(int i, BdAsyncTaskParallel.BdAsyncTaskParallelType bdAsyncTaskParallelType) {
        if (bdAsyncTaskParallelType == BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL) {
            if (i < 1) {
                return true;
            }
        } else if (bdAsyncTaskParallelType == BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL) {
            if (i < 2) {
                return true;
            }
        } else if (bdAsyncTaskParallelType == BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL) {
            if (i < 3) {
                return true;
            }
        } else if (bdAsyncTaskParallelType != BdAsyncTaskParallel.BdAsyncTaskParallelType.FOUR_PARALLEL || i < 4) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void a(j jVar) {
        d(jVar);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.j.size()) {
                j jVar2 = this.j.get(i2);
                int h = jVar2.h();
                switch (jVar2.e()) {
                    case 1:
                        if (this.f + this.g + this.h >= 3) {
                            break;
                        }
                        break;
                    case 2:
                        if (this.f + this.g + this.h >= 4) {
                            break;
                        }
                        break;
                    case 3:
                        if (this.f + this.g + this.h >= 5) {
                            break;
                        }
                        break;
                    case 4:
                        if (h == 0) {
                            e(jVar2);
                            break;
                        }
                        break;
                }
                if (!a(this.i.get(h), jVar2.j())) {
                    i = i2 + 1;
                } else {
                    e(jVar2);
                }
            }
        }
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> a(int i) {
        return a(i, (String) null);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> a(int i, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        linkedList.addAll(b(i, str));
        linkedList.addAll(a(this.k, false, i, str));
        linkedList.addAll(a(this.l, false, i, str));
        BdLog.d(a().toString());
        return linkedList;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> b(int i) {
        LinkedList<BdAsyncTask<?, ?, ?>> a2;
        a2 = a(this.j, true, i, null);
        BdLog.d(a().toString());
        return a2;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> b(int i, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> a2;
        a2 = a(this.j, true, i, str);
        BdLog.d(a().toString());
        return a2;
    }

    private synchronized LinkedList<BdAsyncTask<?, ?, ?>> a(LinkedList<j> linkedList, boolean z, int i, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList2;
        com.baidu.adp.lib.util.h.b();
        linkedList2 = new LinkedList<>();
        Iterator<j> it = linkedList.iterator();
        while (it.hasNext()) {
            j next = it.next();
            int g = next.g();
            String i2 = next.i();
            if (g == i && (str == null || str.equals(i2))) {
                if (z) {
                    it.remove();
                }
                next.b();
                linkedList2.add(next.d());
            }
        }
        return linkedList2;
    }

    public synchronized int c(int i) {
        return a(this.j, i) + a(this.k, i) + a(this.l, i);
    }

    public synchronized int a(LinkedList<j> linkedList, int i) {
        int i2 = 0;
        synchronized (this) {
            if (linkedList != null) {
                Iterator<j> it = linkedList.iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    j next = it.next();
                    if (next.g() == i && next.d() != null && !next.d().isCancelled()) {
                        i3++;
                    }
                }
                i2 = i3;
            }
        }
        return i2;
    }

    public synchronized void a(BdAsyncTask<?, ?, ?> bdAsyncTask) {
        com.baidu.adp.lib.util.h.b();
        Iterator<j> it = this.j.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            j next = it.next();
            if (next != null && next.d() == bdAsyncTask) {
                it.remove();
                break;
            }
        }
        BdLog.d(a().toString());
    }

    public synchronized BdAsyncTask<?, ?, ?> a(String str) {
        BdAsyncTask<?, ?, ?> a2;
        a2 = a(this.j, str);
        if (a2 == null) {
            a2 = a(this.k, str);
        }
        if (a2 == null) {
            a2 = a(this.l, str);
        }
        if (a2 != null) {
            if (a2.isCancelled()) {
                a2 = null;
            }
        }
        return a2;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> c(int i, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        linkedList.addAll(a(this.j, i, str));
        linkedList.addAll(a(this.k, i, str));
        linkedList.addAll(a(this.l, i, str));
        return linkedList;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> d(int i) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        linkedList.addAll(b(this.j, i));
        linkedList.addAll(b(this.k, i));
        linkedList.addAll(b(this.l, i));
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> b(String str) {
        return a(this.j, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> e(int i) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        linkedList.addAll(b(this.j, i));
        linkedList.addAll(b(this.l, i));
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> c(String str) {
        return a(this.k, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
        r0 = r0.d();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized BdAsyncTask<?, ?, ?> a(LinkedList<j> linkedList, String str) {
        BdAsyncTask<?, ?, ?> bdAsyncTask;
        if (linkedList != null) {
            Iterator<j> it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bdAsyncTask = null;
                    break;
                }
                j next = it.next();
                String i = next.i();
                if (i != null && i.equals(str) && !next.d().isCancelled()) {
                    break;
                }
            }
        } else {
            bdAsyncTask = null;
        }
        return bdAsyncTask;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> b(LinkedList<j> linkedList, int i) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList2;
        if (linkedList == null) {
            linkedList2 = null;
        } else {
            LinkedList<BdAsyncTask<?, ?, ?>> linkedList3 = new LinkedList<>();
            Iterator<j> it = linkedList.iterator();
            while (it.hasNext()) {
                j next = it.next();
                if (next.g() == i && next.d() != null && !next.d().isCancelled()) {
                    linkedList3.add(next.d());
                }
            }
            linkedList2 = linkedList3;
        }
        return linkedList2;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> a(LinkedList<j> linkedList, int i, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList2;
        if (linkedList == null) {
            linkedList2 = null;
        } else {
            LinkedList<BdAsyncTask<?, ?, ?>> linkedList3 = new LinkedList<>();
            Iterator<j> it = linkedList.iterator();
            while (it.hasNext()) {
                j next = it.next();
                String i2 = next.i();
                if (i2 != null && i2.equals(str) && next.g() == i && next.d() != null && !next.d().isCancelled()) {
                    linkedList3.add(next.d());
                }
            }
            linkedList2 = linkedList3;
        }
        return linkedList2;
    }
}
