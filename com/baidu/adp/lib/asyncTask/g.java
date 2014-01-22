package com.baidu.adp.lib.asyncTask;

import android.os.Handler;
import android.os.Looper;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class g implements Executor {
    private final LinkedList<k> f = new LinkedList<>();
    private final LinkedList<k> g = new LinkedList<>();
    private final LinkedList<k> h = new LinkedList<>();
    private Handler i = new i(this, Looper.getMainLooper());
    private static final boolean b = com.baidu.adp.a.b.a().b();
    private static g c = null;
    private static final ThreadFactory d = new h();
    private static final BlockingQueue<Runnable> e = new SynchronousQueue();
    public static final Executor a = new ThreadPoolExecutor(5, 256, 30, TimeUnit.SECONDS, e, d, new ThreadPoolExecutor.DiscardPolicy());

    private g() {
    }

    public String toString() {
        return "mTasks = " + this.f.size() + " mActives = " + this.g.size() + " mTimeOutActives = " + this.h.size();
    }

    public static g a() {
        if (c == null) {
            c = new g();
        }
        return c;
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        if (runnable instanceof m) {
            j jVar = new j(this, (m) runnable);
            if (jVar.i()) {
                new Thread(jVar).start();
            } else if (jVar.j()) {
                a(jVar);
            } else {
                c(jVar);
                b((k) null);
            }
        }
    }

    private synchronized void c(k kVar) {
        int size = this.f.size();
        int i = 0;
        while (i < size && this.f.get(i).d() >= kVar.d()) {
            i++;
        }
        this.f.add(i, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d(k kVar) {
        k poll;
        this.g.remove(kVar);
        this.h.add(kVar);
        if (this.h.size() > 246 && (poll = this.h.poll()) != null) {
            poll.b();
        }
        b((k) null);
    }

    protected synchronized void a(k kVar) {
        if (new l(this, this.g).a(kVar)) {
            this.g.add(kVar);
            a.execute(kVar);
            this.i.sendMessageDelayed(this.i.obtainMessage(1, kVar), 60000L);
        } else {
            c(kVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void b(k kVar) {
        if (kVar != null) {
            this.g.remove(kVar);
            this.h.remove(kVar);
            this.i.removeMessages(1, kVar);
        }
        int size = this.g.size();
        if (size >= 5) {
            if (b) {
                com.baidu.adp.lib.g.e.d(a().toString());
            }
        } else {
            k peek = this.f.peek();
            if (peek == null) {
                if (b) {
                    com.baidu.adp.lib.g.e.d(a().toString());
                }
            } else if (size >= 4 && peek.d() == 1) {
                if (b) {
                    com.baidu.adp.lib.g.e.d(a().toString());
                }
            } else {
                l lVar = new l(this, this.g);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.f.size()) {
                        break;
                    }
                    k kVar2 = this.f.get(i2);
                    if (!lVar.a(kVar2)) {
                        i = i2 + 1;
                    } else {
                        this.g.add(kVar2);
                        this.f.remove(kVar2);
                        a.execute(kVar2);
                        this.i.sendMessageDelayed(this.i.obtainMessage(1, kVar2), 120000L);
                        break;
                    }
                }
                if (b) {
                    com.baidu.adp.lib.g.e.d(a().toString());
                }
            }
        }
    }

    public synchronized void a(int i) {
        b(i);
        a(this.g, false, i);
        a(this.h, false, i);
        if (b) {
            com.baidu.adp.lib.g.e.d(a().toString());
        }
    }

    public synchronized void a(int i, String str) {
        b(i, str);
        a(this.g, false, i, str);
        a(this.h, false, i, str);
        if (b) {
            com.baidu.adp.lib.g.e.d(a().toString());
        }
    }

    public synchronized void b(int i) {
        a(this.f, true, i);
        if (b) {
            com.baidu.adp.lib.g.e.d(a().toString());
        }
    }

    public synchronized void b(int i, String str) {
        a(this.f, true, i, str);
        if (b) {
            com.baidu.adp.lib.g.e.d(a().toString());
        }
    }

    private void a(LinkedList<k> linkedList, boolean z, int i) {
        a(linkedList, z, i, null);
    }

    private void a(LinkedList<k> linkedList, boolean z, int i, String str) {
        Iterator<k> it = linkedList.iterator();
        while (it.hasNext()) {
            k next = it.next();
            int e2 = next.e();
            String g = next.g();
            if (e2 == i && (str == null || str.equals(g))) {
                if (z) {
                    it.remove();
                }
                next.b();
            }
        }
    }

    public synchronized void a(BdAsyncTask<?, ?, ?> bdAsyncTask) {
        Iterator<k> it = this.f.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            k next = it.next();
            if (next != null && next.c() == bdAsyncTask) {
                it.remove();
                break;
            }
        }
        if (b) {
            com.baidu.adp.lib.g.e.d(a().toString());
        }
    }

    public synchronized BdAsyncTask<?, ?, ?> a(String str) {
        BdAsyncTask<?, ?, ?> a2;
        a2 = a(this.f, str);
        if (a2 == null) {
            a2 = a(this.g, str);
        }
        return a2;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> c(int i, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        linkedList.addAll(a(this.f, i, str));
        linkedList.addAll(a(this.g, i, str));
        linkedList.addAll(a(this.h, i, str));
        return linkedList;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> c(int i) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        linkedList.addAll(a(this.f, i));
        linkedList.addAll(a(this.g, i));
        linkedList.addAll(a(this.h, i));
        return linkedList;
    }

    public synchronized BdAsyncTask<?, ?, ?> b(String str) {
        return a(this.f, str);
    }

    public synchronized BdAsyncTask<?, ?, ?> c(String str) {
        return a(this.g, str);
    }

    public BdAsyncTask<?, ?, ?> a(LinkedList<k> linkedList, String str) {
        if (linkedList == null) {
            return null;
        }
        Iterator<k> it = linkedList.iterator();
        while (it.hasNext()) {
            k next = it.next();
            String g = next.g();
            if (g != null && g.equals(str)) {
                return next.c();
            }
        }
        return null;
    }

    public LinkedList<BdAsyncTask<?, ?, ?>> a(LinkedList<k> linkedList, int i) {
        if (linkedList == null) {
            return null;
        }
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList2 = new LinkedList<>();
        Iterator<k> it = linkedList.iterator();
        while (it.hasNext()) {
            k next = it.next();
            if (next.e() == i && next.c() != null) {
                linkedList2.add(next.c());
            }
        }
        return linkedList2;
    }

    public LinkedList<BdAsyncTask<?, ?, ?>> a(LinkedList<k> linkedList, int i, String str) {
        if (linkedList == null) {
            return null;
        }
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList2 = new LinkedList<>();
        Iterator<k> it = linkedList.iterator();
        while (it.hasNext()) {
            k next = it.next();
            String g = next.g();
            if (g != null && g.equals(str) && next.e() == i && next.c() != null) {
                linkedList2.add(next.c());
            }
        }
        return linkedList2;
    }
}
