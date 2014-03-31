package com.baidu.adp.framework.d;

import android.util.SparseArray;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.b.f;
import com.baidu.adp.framework.message.d;
import com.baidu.adp.framework.message.f;
import com.baidu.adp.framework.task.b;
import com.baidu.adp.lib.util.i;
import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<M extends com.baidu.adp.framework.message.d, T extends com.baidu.adp.framework.task.b, R extends f, N extends com.baidu.adp.framework.message.f<?>> implements com.baidu.adp.framework.a<M, T> {
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

    public final void a(T t) {
        if (t != null) {
            this.c.put(t.i(), t);
        }
    }

    public final void b(int i) {
        this.c.remove(i);
    }

    public final T c(int i) {
        return this.c.get(i);
    }

    private void a() {
        if (this.g) {
            throw new IllegalStateException("MessageListener locked");
        }
    }

    public final void a(int i, com.baidu.adp.framework.c.c<N> cVar) {
        a();
        i.b();
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

    public final void a(com.baidu.adp.framework.c.c cVar) {
        a();
        i.b();
        if (cVar != null) {
            int b = cVar.b();
            if (b == 0) {
                int size = this.e.size();
                for (int i = 0; i < size; i++) {
                    this.e.valueAt(i).remove(cVar);
                }
                return;
            }
            LinkedList<com.baidu.adp.framework.c.c<N>> linkedList = this.e.get(b);
            if (linkedList != null) {
                linkedList.remove(cVar);
            }
        }
    }

    public final void d(int i) {
        a();
        i.b();
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

    public final boolean c(M m, T t) {
        i.b();
        if (m == null) {
            return false;
        }
        int e = m.e();
        T c = c(e);
        if (c != null) {
            M b = b((c<M, T, R, N>) m, (M) c);
            if (this.b != null) {
                if (c.j() == null) {
                    c.b(this.b.j());
                }
                if (c.k() == 0) {
                    c.a(this.b.i());
                }
            }
            if (b != null) {
                a((c<M, T, R, N>) b, (M) c);
                return true;
            }
            com.baidu.adp.lib.util.f.e("message is trapped:" + e);
            return false;
        }
        com.baidu.adp.lib.util.f.b("task not register:" + e);
        return false;
    }

    public final void a(N n) {
        i.b();
        if (n != null) {
            int g = n.g();
            if (this.d.indexOfKey(g) >= 0) {
                this.d.put(g, n);
            }
            LinkedList<com.baidu.adp.framework.c.c<N>> linkedList = this.e.get(g);
            if (linkedList != null) {
                this.f = false;
                this.g = true;
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
                    com.baidu.adp.lib.util.f.b(String.valueOf(e2.getMessage()) + n.getClass().getName());
                } finally {
                    this.g = false;
                }
            }
        }
    }
}
