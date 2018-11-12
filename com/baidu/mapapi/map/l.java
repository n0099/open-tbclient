package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.mapapi.map.l.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* loaded from: classes4.dex */
class l<T extends a> {
    private final f a;
    private final int b;
    private List<T> c;
    private List<l<T>> d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static abstract class a {
        abstract Point a();
    }

    private l(double d, double d2, double d3, double d4, int i) {
        this(new f(d, d2, d3, d4), i);
    }

    public l(f fVar) {
        this(fVar, 0);
    }

    private l(f fVar, int i) {
        this.d = null;
        this.a = fVar;
        this.b = i;
    }

    private void a() {
        this.d = new ArrayList(4);
        this.d.add(new l<>(this.a.a, this.a.e, this.a.b, this.a.f, this.b + 1));
        this.d.add(new l<>(this.a.e, this.a.c, this.a.b, this.a.f, this.b + 1));
        this.d.add(new l<>(this.a.a, this.a.e, this.a.f, this.a.d, this.b + 1));
        this.d.add(new l<>(this.a.e, this.a.c, this.a.f, this.a.d, this.b + 1));
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

    private void a(f fVar, Collection<T> collection) {
        if (this.a.a(fVar)) {
            if (this.d != null) {
                for (l<T> lVar : this.d) {
                    lVar.a(fVar, collection);
                }
            } else if (this.c != null) {
                if (fVar.b(this.a)) {
                    collection.addAll(this.c);
                    return;
                }
                for (T t : this.c) {
                    if (fVar.a(t.a())) {
                        collection.add(t);
                    }
                }
            }
        }
    }

    public Collection<T> a(f fVar) {
        ArrayList arrayList = new ArrayList();
        a(fVar, arrayList);
        return arrayList;
    }

    public void a(T t) {
        Point a2 = t.a();
        if (this.a.a(a2.x, a2.y)) {
            a(a2.x, a2.y, t);
        }
    }
}
