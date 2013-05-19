package com.baidu.adp.lib.a;

import android.os.Handler;
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
    private final LinkedList e = new LinkedList();
    private final LinkedList f = new LinkedList();
    private final LinkedList g = new LinkedList();
    private Handler h = new j(this);
    private static h b = null;
    private static final ThreadFactory c = new i();
    private static final BlockingQueue d = new SynchronousQueue();
    public static final Executor a = new ThreadPoolExecutor(5, 256, 30, TimeUnit.SECONDS, d, c, new ThreadPoolExecutor.DiscardPolicy());

    private h() {
    }

    public String toString() {
        return "mTasks = " + this.e.size() + " mActives = " + this.f.size() + " mTimeOutActives = " + this.g.size();
    }

    public static h a() {
        if (b == null) {
            b = new h();
        }
        return b;
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        if (runnable instanceof n) {
            k kVar = new k(this, (n) runnable);
            if (kVar.h()) {
                new Thread(kVar).start();
            } else {
                int size = this.e.size();
                int i = 0;
                while (i < size && ((l) this.e.get(i)).d() >= kVar.d()) {
                    i++;
                }
                this.e.add(i, kVar);
                a((l) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(l lVar) {
        l lVar2;
        this.f.remove(lVar);
        this.g.add(lVar);
        if (this.g.size() > 246 && (lVar2 = (l) this.g.poll()) != null) {
            lVar2.b();
        }
        a((l) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0051, code lost:
        r4.f.add(r0);
        r4.e.remove(r0);
        com.baidu.adp.lib.a.h.a.execute(r0);
        r4.h.sendMessageDelayed(r4.h.obtainMessage(1, r0), 120000);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(l lVar) {
        l lVar2;
        if (lVar != null) {
            this.f.remove(lVar);
            this.g.remove(lVar);
            this.h.removeMessages(1, lVar);
        }
        int size = this.f.size();
        if (size < 5 && (lVar2 = (l) this.e.peek()) != null && (size < 4 || lVar2.d() != 1)) {
            m mVar = new m(this, this.f);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.e.size()) {
                    break;
                }
                l lVar3 = (l) this.e.get(i2);
                if (mVar.a(lVar3)) {
                    break;
                }
                i = i2 + 1;
            }
        }
    }

    public synchronized void a(String str) {
        b(str);
        a(this.f, false, str);
        a(this.g, false, str);
    }

    public synchronized void b(String str) {
        a(this.e, true, str);
    }

    private void a(LinkedList linkedList, boolean z, String str) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            l lVar = (l) it.next();
            String e = lVar.e();
            if (e != null && e.equals(str)) {
                if (z) {
                    it.remove();
                }
                lVar.b();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        r1.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(a aVar) {
        Iterator it = this.e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            l lVar = (l) it.next();
            if (lVar != null && lVar.c() == aVar) {
                break;
            }
        }
    }

    public synchronized a c(String str) {
        a a2;
        a2 = a(this.e, str);
        if (a2 == null) {
            a2 = a(this.f, str);
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
