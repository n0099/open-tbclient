package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.mapapi.map.n.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* loaded from: classes6.dex */
class n<T extends a> {
    private final g a;
    private final int b;
    private List<T> c;
    private List<n<T>> d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static abstract class a {
        abstract Point a();
    }

    private n(double d, double d2, double d3, double d4, int i) {
        this(new g(d, d2, d3, d4), i);
    }

    public n(g gVar) {
        this(gVar, 0);
    }

    private n(g gVar, int i) {
        this.d = null;
        this.a = gVar;
        this.b = i;
    }

    private void a() {
        this.d = new ArrayList(4);
        this.d.add(new n<>(this.a.a, this.a.e, this.a.b, this.a.f, this.b + 1));
        this.d.add(new n<>(this.a.e, this.a.c, this.a.b, this.a.f, this.b + 1));
        this.d.add(new n<>(this.a.a, this.a.e, this.a.f, this.a.d, this.b + 1));
        this.d.add(new n<>(this.a.e, this.a.c, this.a.f, this.a.d, this.b + 1));
        List<T> list = this.c;
        this.c = null;
        for (T t : list) {
            a(t.a().x, t.a().y, t);
        }
    }

    private void a(double d, double d2, T t) {
        if (this.d == null) {
            if (this.c == null) {
                this.c = new ArrayList();
            }
            this.c.add(t);
            if (this.c.size() <= 40 || this.b >= 40) {
                return;
            }
            a();
        } else if (d2 < this.a.f) {
            if (d < this.a.e) {
                this.d.get(0).a(d, d2, t);
            } else {
                this.d.get(1).a(d, d2, t);
            }
        } else if (d < this.a.e) {
            this.d.get(2).a(d, d2, t);
        } else {
            this.d.get(3).a(d, d2, t);
        }
    }

    private void a(g gVar, Collection<T> collection) {
        if (this.a.a(gVar)) {
            if (this.d != null) {
                for (n<T> nVar : this.d) {
                    nVar.a(gVar, collection);
                }
            } else if (this.c != null) {
                if (gVar.b(this.a)) {
                    collection.addAll(this.c);
                    return;
                }
                for (T t : this.c) {
                    if (gVar.a(t.a())) {
                        collection.add(t);
                    }
                }
            }
        }
    }

    public Collection<T> a(g gVar) {
        ArrayList arrayList = new ArrayList();
        a(gVar, arrayList);
        return arrayList;
    }

    public void a(T t) {
        Point a2 = t.a();
        if (this.a.a(a2.x, a2.y)) {
            a(a2.x, a2.y, t);
        }
    }
}
