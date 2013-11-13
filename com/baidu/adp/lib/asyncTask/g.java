package com.baidu.adp.lib.asyncTask;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.Util;
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

    /* renamed from: a  reason: collision with root package name */
    public static final Executor f413a = new ThreadPoolExecutor(5, 256, 30, TimeUnit.SECONDS, e, d, new ThreadPoolExecutor.DiscardPolicy());

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
            if (jVar.h()) {
                new Thread(jVar).start();
            } else if (jVar.i()) {
                a(jVar);
            } else {
                int size = this.f.size();
                int i = 0;
                while (i < size && this.f.get(i).d() >= jVar.d()) {
                    i++;
                }
                this.f.add(i, jVar);
                b((k) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c(k kVar) {
        k poll;
        this.g.remove(kVar);
        this.h.add(kVar);
        if (this.h.size() > 246 && (poll = this.h.poll()) != null) {
            poll.b();
        }
        b((k) null);
    }

    protected synchronized void a(k kVar) {
        this.g.add(kVar);
        f413a.execute(kVar);
        this.i.sendMessageDelayed(this.i.obtainMessage(1, kVar), Util.MILLSECONDS_OF_MINUTE);
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
                com.baidu.adp.lib.h.d.d(a().toString());
            }
        } else {
            k peek = this.f.peek();
            if (peek == null) {
                if (b) {
                    com.baidu.adp.lib.h.d.d(a().toString());
                }
            } else if (size >= 4 && peek.d() == 1) {
                if (b) {
                    com.baidu.adp.lib.h.d.d(a().toString());
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
                        f413a.execute(kVar2);
                        this.i.sendMessageDelayed(this.i.obtainMessage(1, kVar2), 120000L);
                        break;
                    }
                }
                if (b) {
                    com.baidu.adp.lib.h.d.d(a().toString());
                }
            }
        }
    }

    public synchronized void a(String str) {
        b(str);
        a(this.g, false, str);
        a(this.h, false, str);
        if (b) {
            com.baidu.adp.lib.h.d.d(a().toString());
        }
    }

    public synchronized void b(String str) {
        a(this.f, true, str);
        if (b) {
            com.baidu.adp.lib.h.d.d(a().toString());
        }
    }

    private void a(LinkedList<k> linkedList, boolean z, String str) {
        Iterator<k> it = linkedList.iterator();
        while (it.hasNext()) {
            k next = it.next();
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
            com.baidu.adp.lib.h.d.d(a().toString());
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

    public synchronized BdAsyncTask<?, ?, ?> d(String str) {
        return a(this.f, str);
    }

    public synchronized BdAsyncTask<?, ?, ?> e(String str) {
        return a(this.g, str);
    }

    public BdAsyncTask<?, ?, ?> a(LinkedList<k> linkedList, String str) {
        if (linkedList == null) {
            return null;
        }
        Iterator<k> it = linkedList.iterator();
        while (it.hasNext()) {
            k next = it.next();
            String f = next.f();
            if (f != null && f.equals(str)) {
                return next.c();
            }
        }
        return null;
    }
}
