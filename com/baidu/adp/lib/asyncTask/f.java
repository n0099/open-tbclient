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
    private final LinkedList f = new LinkedList();
    private final LinkedList g = new LinkedList();
    private final LinkedList h = new LinkedList();
    private Handler i = new h(this, Looper.getMainLooper());
    private static final boolean b = com.baidu.adp.a.b.a().b();
    private static f c = null;
    private static final ThreadFactory d = new g();
    private static final BlockingQueue e = new SynchronousQueue();

    /* renamed from: a  reason: collision with root package name */
    public static final Executor f358a = new ThreadPoolExecutor(5, 256, 30, TimeUnit.SECONDS, e, d, new ThreadPoolExecutor.DiscardPolicy());

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
                while (i < size && ((j) this.f.get(i)).d() >= iVar.d()) {
                    i++;
                }
                this.f.add(i, iVar);
                a((j) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(j jVar) {
        j jVar2;
        this.g.remove(jVar);
        this.h.add(jVar);
        if (this.h.size() > 246 && (jVar2 = (j) this.h.poll()) != null) {
            jVar2.b();
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
                com.baidu.adp.lib.e.d.c(a().toString());
            }
        } else {
            j jVar2 = (j) this.f.peek();
            if (jVar2 == null) {
                if (b) {
                    com.baidu.adp.lib.e.d.c(a().toString());
                }
            } else if (size >= 4 && jVar2.d() == 1) {
                if (b) {
                    com.baidu.adp.lib.e.d.c(a().toString());
                }
            } else {
                k kVar = new k(this, this.g);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.f.size()) {
                        break;
                    }
                    j jVar3 = (j) this.f.get(i2);
                    if (!kVar.a(jVar3)) {
                        i = i2 + 1;
                    } else {
                        this.g.add(jVar3);
                        this.f.remove(jVar3);
                        f358a.execute(jVar3);
                        this.i.sendMessageDelayed(this.i.obtainMessage(1, jVar3), 120000L);
                        break;
                    }
                }
                if (b) {
                    com.baidu.adp.lib.e.d.c(a().toString());
                }
            }
        }
    }

    public synchronized void a(String str) {
        b(str);
        a(this.g, false, str);
        a(this.h, false, str);
        if (b) {
            com.baidu.adp.lib.e.d.c(a().toString());
        }
    }

    public synchronized void b(String str) {
        a(this.f, true, str);
        if (b) {
            com.baidu.adp.lib.e.d.c(a().toString());
        }
    }

    private void a(LinkedList linkedList, boolean z, String str) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            j jVar = (j) it.next();
            String e2 = jVar.e();
            if (e2 != null && e2.equals(str)) {
                if (z) {
                    it.remove();
                }
                jVar.b();
            }
        }
    }

    public synchronized void a(BdAsyncTask bdAsyncTask) {
        Iterator it = this.f.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            j jVar = (j) it.next();
            if (jVar != null && jVar.c() == bdAsyncTask) {
                it.remove();
                break;
            }
        }
        if (b) {
            com.baidu.adp.lib.e.d.c(a().toString());
        }
    }

    public synchronized BdAsyncTask c(String str) {
        BdAsyncTask a2;
        a2 = a(this.f, str);
        if (a2 == null) {
            a2 = a(this.g, str);
        }
        return a2;
    }

    public BdAsyncTask a(LinkedList linkedList, String str) {
        if (linkedList == null) {
            return null;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            j jVar = (j) it.next();
            String f = jVar.f();
            if (f != null && f.equals(str)) {
                return jVar.c();
            }
        }
        return null;
    }
}
