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
    private Handler i = new h(this, Looper.getMainLooper());
    private static final boolean b = com.baidu.adp.a.b.a().b();
    private static f c = null;
    private static final ThreadFactory d = new g();
    private static final BlockingQueue<Runnable> e = new SynchronousQueue();

    /* renamed from: a  reason: collision with root package name */
    public static final Executor f362a = new ThreadPoolExecutor(5, 256, 30, TimeUnit.SECONDS, e, d, new ThreadPoolExecutor.DiscardPolicy());

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
            if (iVar.h()) {
                new Thread(iVar).start();
            } else {
                int size = this.f.size();
                int i = 0;
                while (i < size && this.f.get(i).d() >= iVar.d()) {
                    i++;
                }
                this.f.add(i, iVar);
                a((j) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(j jVar) {
        j poll;
        this.g.remove(jVar);
        this.h.add(jVar);
        if (this.h.size() > 246 && (poll = this.h.poll()) != null) {
            poll.b();
        }
        a((j) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void a(j jVar) {
        if (jVar != null) {
            this.g.remove(jVar);
            this.h.remove(jVar);
            this.i.removeMessages(1, jVar);
        }
        int size = this.g.size();
        if (size >= 5) {
            if (b) {
                com.baidu.adp.lib.f.d.c(a().toString());
            }
        } else {
            j peek = this.f.peek();
            if (peek == null) {
                if (b) {
                    com.baidu.adp.lib.f.d.c(a().toString());
                }
            } else if (size >= 4 && peek.d() == 1) {
                if (b) {
                    com.baidu.adp.lib.f.d.c(a().toString());
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
                        f362a.execute(jVar2);
                        this.i.sendMessageDelayed(this.i.obtainMessage(1, jVar2), 120000L);
                        break;
                    }
                }
                if (b) {
                    com.baidu.adp.lib.f.d.c(a().toString());
                }
            }
        }
    }

    public synchronized void a(String str) {
        b(str);
        a(this.g, false, str);
        a(this.h, false, str);
        if (b) {
            com.baidu.adp.lib.f.d.c(a().toString());
        }
    }

    public synchronized void b(String str) {
        a(this.f, true, str);
        if (b) {
            com.baidu.adp.lib.f.d.c(a().toString());
        }
    }

    private void a(LinkedList<j> linkedList, boolean z, String str) {
        Iterator<j> it = linkedList.iterator();
        while (it.hasNext()) {
            j next = it.next();
            String e2 = next.e();
            if (e2 != null && e2.equals(str)) {
                if (z) {
                    it.remove();
                }
                next.b();
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
            if (next != null && next.c() == bdAsyncTask) {
                it.remove();
                break;
            }
        }
        if (b) {
            com.baidu.adp.lib.f.d.c(a().toString());
        }
    }

    public synchronized BdAsyncTask<?, ?, ?> c(String str) {
        BdAsyncTask<?, ?, ?> a2;
        a2 = a(this.f, str);
        if (a2 == null) {
            a2 = a(this.g, str);
        }
        return a2;
    }

    public BdAsyncTask<?, ?, ?> a(LinkedList<j> linkedList, String str) {
        if (linkedList == null) {
            return null;
        }
        Iterator<j> it = linkedList.iterator();
        while (it.hasNext()) {
            j next = it.next();
            String f = next.f();
            if (f != null && f.equals(str)) {
                return next.c();
            }
        }
        return null;
    }
}
