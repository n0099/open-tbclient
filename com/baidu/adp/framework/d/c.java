package com.baidu.adp.framework.d;

import android.util.SparseArray;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.b.a;
import com.baidu.adp.framework.message.e;
import com.baidu.adp.framework.message.f;
import com.baidu.adp.framework.task.b;
import com.baidu.adp.lib.util.BdUtilHelper;
import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<M extends e, T extends com.baidu.adp.framework.task.b, R extends com.baidu.adp.framework.b.a, N extends f<?>> implements com.baidu.adp.framework.a<M, T> {
    protected com.baidu.adp.framework.c a;
    private final SparseArray<T> c = new SparseArray<>();
    private final SparseArray<N> d = new SparseArray<>();
    private final SparseArray<LinkedList<com.baidu.adp.framework.c.c<N>>> e = new SparseArray<>();
    protected com.baidu.adp.framework.e.d b = null;
    private boolean f = false;
    private boolean g = false;

    public abstract M b(M m, T t);

    public c(com.baidu.adp.framework.c cVar) {
        this.a = null;
        this.a = cVar;
    }

    public void a(T t) {
        if (t != null) {
            this.c.put(t.i(), t);
        }
    }

    public T b(int i) {
        return this.c.get(i);
    }

    private void a() {
        if (d()) {
            throw new IllegalStateException("MessageListener locked");
        }
    }

    public void a(int i, com.baidu.adp.framework.c.c<N> cVar) {
        a();
        BdUtilHelper.b();
        if (cVar != null) {
            if ((i == 0 && cVar.b() == 0) || (i != 0 && cVar.b() != 0)) {
                throw new InvalidParameterException("registerListener cmd error");
            }
            if (i == 0) {
                i = cVar.b();
            }
            LinkedList<com.baidu.adp.framework.c.c<N>> linkedList = this.e.get(i);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.e.put(i, linkedList);
            }
            FrameHelper.a(linkedList, cVar);
            N n = this.d.get(i);
            if (n != null) {
                cVar.a((com.baidu.adp.framework.c.c<N>) n);
            }
        }
    }

    public void c(int i) {
        a();
        BdUtilHelper.b();
        if (i != 0) {
            int size = this.e.size();
            for (int i2 = 0; i2 < size; i2++) {
                Iterator<com.baidu.adp.framework.c.c<N>> it = this.e.valueAt(i2).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.framework.c.c<N> next = it.next();
                    if (next != null && next.c() == i) {
                        it.remove();
                    }
                }
            }
        }
    }

    public boolean c(M m, T t) {
        BdUtilHelper.b();
        if (m == null) {
            return false;
        }
        int d = m.d();
        if (t == null) {
            t = b(d);
        }
        if (t != null) {
            M b = b(m, t);
            if (this.b != null) {
                if (t.j() == null) {
                    t.b(this.b.h());
                }
                if (t.k() == 0) {
                    t.a(this.b.g());
                }
            }
            a((c<M, T, R, N>) b, (M) t);
            return true;
        }
        com.baidu.adp.lib.util.f.b("task not register");
        return false;
    }

    public void a(N n) {
        BdUtilHelper.b();
        if (n != null) {
            int b = n.b();
            if (this.d.indexOfKey(b) >= 0) {
                this.d.put(b, n);
            }
            LinkedList<com.baidu.adp.framework.c.c<N>> linkedList = this.e.get(b);
            this.f = false;
            b();
            try {
                Iterator<com.baidu.adp.framework.c.c<N>> it = linkedList.iterator();
                while (it.hasNext() && !this.f) {
                    com.baidu.adp.framework.c.c<N> next = it.next();
                    if (next != null) {
                        try {
                            next.a((com.baidu.adp.framework.c.c<N>) n);
                        } catch (Exception e) {
                            com.baidu.adp.lib.util.f.b(e.getMessage());
                        }
                    }
                }
            } catch (Exception e2) {
                com.baidu.adp.lib.util.f.b(e2.getMessage());
            } finally {
                c();
            }
        }
    }

    private void b() {
        this.g = true;
    }

    private void c() {
        this.g = false;
    }

    private boolean d() {
        return this.g;
    }
}
