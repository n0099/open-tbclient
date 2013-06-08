package com.baidu.adp.lib.a;

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
public class h implements Executor {
    private final LinkedList f = new LinkedList();
    private final LinkedList g = new LinkedList();
    private final LinkedList h = new LinkedList();
    private Handler i = new j(this, Looper.getMainLooper());
    private static final boolean b = com.baidu.adp.a.b.a().b();
    private static h c = null;
    private static final ThreadFactory d = new i();
    private static final BlockingQueue e = new SynchronousQueue();
    public static final Executor a = new ThreadPoolExecutor(5, 256, 30, TimeUnit.SECONDS, e, d, new ThreadPoolExecutor.DiscardPolicy());

    private h() {
    }

    public String toString() {
        return "mTasks = " + this.f.size() + " mActives = " + this.g.size() + " mTimeOutActives = " + this.h.size();
    }

    public static h a() {
        if (c == null) {
            c = new h();
        }
        return c;
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        if (runnable instanceof n) {
            k kVar = new k(this, (n) runnable);
            if (kVar.h()) {
                new Thread(kVar).start();
            } else {
                int size = this.f.size();
                int i = 0;
                while (i < size && ((l) this.f.get(i)).d() >= kVar.d()) {
                    i++;
                }
                this.f.add(i, kVar);
                a((l) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(l lVar) {
        l lVar2;
        this.g.remove(lVar);
        this.h.add(lVar);
        if (this.h.size() > 246 && (lVar2 = (l) this.h.poll()) != null) {
            lVar2.b();
        }
        a((l) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void a(l lVar) {
        if (lVar != null) {
            this.g.remove(lVar);
            this.h.remove(lVar);
            this.i.removeMessages(1, lVar);
        }
        int size = this.g.size();
        if (size >= 5) {
            if (b) {
                com.baidu.adp.lib.e.b.c(a().toString());
            }
        } else {
            l lVar2 = (l) this.f.peek();
            if (lVar2 == null) {
                if (b) {
                    com.baidu.adp.lib.e.b.c(a().toString());
                }
            } else if (size >= 4 && lVar2.d() == 1) {
                if (b) {
                    com.baidu.adp.lib.e.b.c(a().toString());
                }
            } else {
                m mVar = new m(this, this.g);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.f.size()) {
                        break;
                    }
                    l lVar3 = (l) this.f.get(i2);
                    if (!mVar.a(lVar3)) {
                        i = i2 + 1;
                    } else {
                        this.g.add(lVar3);
                        this.f.remove(lVar3);
                        a.execute(lVar3);
                        this.i.sendMessageDelayed(this.i.obtainMessage(1, lVar3), 120000L);
                        break;
                    }
                }
                if (b) {
                    com.baidu.adp.lib.e.b.c(a().toString());
                }
            }
        }
    }

    public synchronized void a(String str) {
        b(str);
        a(this.g, false, str);
        a(this.h, false, str);
        if (b) {
            com.baidu.adp.lib.e.b.c(a().toString());
        }
    }

    public synchronized void b(String str) {
        a(this.f, true, str);
        if (b) {
            com.baidu.adp.lib.e.b.c(a().toString());
        }
    }

    private void a(LinkedList linkedList, boolean z, String str) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            l lVar = (l) it.next();
            String e2 = lVar.e();
            if (e2 != null && e2.equals(str)) {
                if (z) {
                    it.remove();
                }
                lVar.b();
            }
        }
    }

    public synchronized void a(a aVar) {
        Iterator it = this.f.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            l lVar = (l) it.next();
            if (lVar != null && lVar.c() == aVar) {
                it.remove();
                break;
            }
        }
        if (b) {
            com.baidu.adp.lib.e.b.c(a().toString());
        }
    }

    public synchronized a c(String str) {
        a a2;
        a2 = a(this.f, str);
        if (a2 == null) {
            a2 = a(this.g, str);
        }
        return a2;
    }

    public a a(LinkedList linkedList, String str) {
        if (linkedList == null) {
            return null;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            l lVar = (l) it.next();
            String f = lVar.f();
            if (f != null && f.equals(str)) {
                return lVar.c();
            }
        }
        return null;
    }
}
