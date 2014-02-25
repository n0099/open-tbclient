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
public class f implements Executor {
    private final LinkedList<j> f = new LinkedList<>();
    private final LinkedList<j> g = new LinkedList<>();
    private final LinkedList<j> h = new LinkedList<>();
    private final Handler i = new h(this, Looper.getMainLooper());
    private static final boolean b = com.baidu.adp.a.b.a().d();
    private static f c = null;
    private static final ThreadFactory d = new g();
    private static final BlockingQueue<Runnable> e = new SynchronousQueue();
    public static final Executor a = new ThreadPoolExecutor(5, 256, 30, TimeUnit.SECONDS, e, d, new ThreadPoolExecutor.DiscardPolicy());

    private f() {
    }

    public String toString() {
        return "mTasks = " + this.f.size() + " mActives = " + this.g.size() + " mTimeOutActives = " + this.h.size();
    }

    public static f a() {
        if (c == null) {
            c = new f();
        }
        return c;
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        if (runnable instanceof l) {
            i iVar = new i(this, (l) runnable);
            if (iVar.k()) {
                new Thread(iVar).start();
            } else if (iVar.l()) {
                a(iVar);
            } else {
                c(iVar);
                b((j) null);
            }
        }
    }

    private synchronized void c(j jVar) {
        int size = this.f.size();
        int i = 0;
        while (i < size && this.f.get(i).e() >= jVar.e()) {
            i++;
        }
        this.f.add(i, jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d(j jVar) {
        j poll;
        this.g.remove(jVar);
        jVar.a(true);
        if (jVar.f()) {
            jVar.c();
        } else {
            this.h.add(jVar);
            if (this.h.size() > 246 && (poll = this.h.poll()) != null) {
                poll.c();
            }
        }
        b((j) null);
    }

    protected synchronized void a(j jVar) {
        if (new k(this, this.g).a(jVar)) {
            this.g.add(jVar);
            a.execute(jVar);
            this.i.sendMessageDelayed(this.i.obtainMessage(1, jVar), jVar.a() / 2);
        } else {
            c(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void b(j jVar) {
        if (jVar != null) {
            this.g.remove(jVar);
            this.h.remove(jVar);
            this.i.removeMessages(1, jVar);
        }
        int size = this.g.size();
        if (size >= 5) {
            if (b) {
                com.baidu.adp.lib.util.f.e(a().toString());
            }
        } else {
            j peek = this.f.peek();
            if (peek == null) {
                if (b) {
                    com.baidu.adp.lib.util.f.e(a().toString());
                }
            } else if (size >= 4 && peek.e() == 1) {
                if (b) {
                    com.baidu.adp.lib.util.f.e(a().toString());
                }
            } else {
                k kVar = new k(this, this.g);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.f.size()) {
                        break;
                    }
                    j jVar2 = this.f.get(i2);
                    if (!kVar.a(jVar2)) {
                        i = i2 + 1;
                    } else {
                        this.g.add(jVar2);
                        this.f.remove(jVar2);
                        a.execute(jVar2);
                        this.i.sendMessageDelayed(this.i.obtainMessage(1, jVar2), jVar2.a());
                        break;
                    }
                }
                if (b) {
                    com.baidu.adp.lib.util.f.e(a().toString());
                }
            }
        }
    }

    public synchronized void a(int i) {
        b(i);
        a(this.g, false, i);
        a(this.h, false, i);
        if (b) {
            com.baidu.adp.lib.util.f.e(a().toString());
        }
    }

    public synchronized void a(int i, String str) {
        b(i, str);
        a(this.g, false, i, str);
        a(this.h, false, i, str);
        if (b) {
            com.baidu.adp.lib.util.f.e(a().toString());
        }
    }

    public synchronized void b(int i) {
        a(this.f, true, i);
        if (b) {
            com.baidu.adp.lib.util.f.e(a().toString());
        }
    }

    public synchronized void b(int i, String str) {
        a(this.f, true, i, str);
        if (b) {
            com.baidu.adp.lib.util.f.e(a().toString());
        }
    }

    private void a(LinkedList<j> linkedList, boolean z, int i) {
        a(linkedList, z, i, null);
    }

    private void a(LinkedList<j> linkedList, boolean z, int i, String str) {
        Iterator<j> it = linkedList.iterator();
        while (it.hasNext()) {
            j next = it.next();
            int g = next.g();
            String i2 = next.i();
            if (g == i && (str == null || str.equals(i2))) {
                if (z) {
                    it.remove();
                }
                next.c();
            }
        }
    }

    public synchronized void a(BdAsyncTask<?, ?, ?> bdAsyncTask) {
        Iterator<j> it = this.f.iterator();
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
        if (b) {
            com.baidu.adp.lib.util.f.e(a().toString());
        }
    }

    public synchronized BdAsyncTask<?, ?, ?> a(String str) {
        BdAsyncTask<?, ?, ?> a2;
        a2 = a(this.f, str);
        if (a2 == null) {
            a2 = a(this.g, str);
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

    public BdAsyncTask<?, ?, ?> a(LinkedList<j> linkedList, String str) {
        if (linkedList == null) {
            return null;
        }
        Iterator<j> it = linkedList.iterator();
        while (it.hasNext()) {
            j next = it.next();
            String i = next.i();
            if (i != null && i.equals(str) && !next.d().isCancelled()) {
                return next.d();
            }
        }
        return null;
    }

    public LinkedList<BdAsyncTask<?, ?, ?>> a(LinkedList<j> linkedList, int i) {
        if (linkedList == null) {
            return null;
        }
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList2 = new LinkedList<>();
        Iterator<j> it = linkedList.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (next.g() == i && next.d() != null && !next.d().isCancelled()) {
                linkedList2.add(next.d());
            }
        }
        return linkedList2;
    }

    public LinkedList<BdAsyncTask<?, ?, ?>> a(LinkedList<j> linkedList, int i, String str) {
        if (linkedList == null) {
            return null;
        }
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList2 = new LinkedList<>();
        Iterator<j> it = linkedList.iterator();
        while (it.hasNext()) {
            j next = it.next();
            String i2 = next.i();
            if (i2 != null && i2.equals(str) && next.g() == i && next.d() != null && !next.d().isCancelled()) {
                linkedList2.add(next.d());
            }
        }
        return linkedList2;
    }
}
