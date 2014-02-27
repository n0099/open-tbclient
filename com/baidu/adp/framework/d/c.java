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

    public final void a(T t) {
        if (t != null) {
            this.c.put(t.i(), t);
        }
    }

    public final T b(int i) {
        return this.c.get(i);
    }

    private void a() {
        if (this.g) {
            throw new IllegalStateException("MessageListener locked");
        }
    }

    public final void a(int i, com.baidu.adp.framework.c.c<N> cVar) {
        a();
        BdUtilHelper.b();
        if (cVar != null) {
            if (cVar.b() == 0) {
                throw new InvalidParameterException("registerListener cmd error");
            }
            int b = cVar.b();
            LinkedList<com.baidu.adp.framework.c.c<N>> linkedList = this.e.get(b);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.e.put(b, linkedList);
            }
            FrameHelper.a(linkedList, cVar);
            this.d.get(b);
        }
    }

    public final void c(int i) {
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

    public final boolean c(M m, T t) {
        BdUtilHelper.b();
        if (m == null) {
            return false;
        }
        T b = b(m.d());
        if (b != null) {
            M b2 = b(m, b);
            if (this.b != null) {
                if (b.j() == null) {
                    b.b(this.b.h());
                }
                if (b.k() == 0) {
                    b.a(this.b.g());
                }
            }
            a((c<M, T, R, N>) b2, (M) b);
            return true;
        }
        com.baidu.adp.lib.util.e.b("task not register");
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002f A[Catch: Exception -> 0x003f, all -> 0x004a, Merged into TryCatch #1 {all -> 0x004a, Exception -> 0x003f, blocks: (B:9:0x0025, B:10:0x0029, B:12:0x002f, B:15:0x0036, B:19:0x0040), top: B:24:0x0025 }, TRY_LEAVE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(N n) {
        BdUtilHelper.b();
        if (n != null) {
            int b = n.b();
            if (this.d.indexOfKey(b) >= 0) {
                this.d.put(b, n);
            }
            LinkedList<com.baidu.adp.framework.c.c<N>> linkedList = this.e.get(b);
            this.f = false;
            this.g = true;
            try {
                Iterator<com.baidu.adp.framework.c.c<N>> it = linkedList.iterator();
                while (it.hasNext() && !this.f) {
                    if (it.next() == null) {
                    }
                    while (it.hasNext()) {
                        if (it.next() == null) {
                        }
                        while (it.hasNext()) {
                        }
                    }
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b(e.getMessage());
            } finally {
                this.g = false;
            }
        }
    }
}
