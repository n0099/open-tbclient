package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.mapapi.map.n.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* loaded from: classes2.dex */
public class n<T extends a> {

    /* renamed from: a  reason: collision with root package name */
    public final g f7082a;

    /* renamed from: b  reason: collision with root package name */
    public final int f7083b;

    /* renamed from: c  reason: collision with root package name */
    public List<T> f7084c;

    /* renamed from: d  reason: collision with root package name */
    public List<n<T>> f7085d;

    /* loaded from: classes2.dex */
    public static abstract class a {
        public abstract Point a();
    }

    public n(double d2, double d3, double d4, double d5, int i) {
        this(new g(d2, d3, d4, d5), i);
    }

    public n(g gVar) {
        this(gVar, 0);
    }

    public n(g gVar, int i) {
        this.f7085d = null;
        this.f7082a = gVar;
        this.f7083b = i;
    }

    private void a() {
        ArrayList arrayList = new ArrayList(4);
        this.f7085d = arrayList;
        g gVar = this.f7082a;
        arrayList.add(new n(gVar.f7069a, gVar.f7073e, gVar.f7070b, gVar.f7074f, this.f7083b + 1));
        List<n<T>> list = this.f7085d;
        g gVar2 = this.f7082a;
        list.add(new n<>(gVar2.f7073e, gVar2.f7071c, gVar2.f7070b, gVar2.f7074f, this.f7083b + 1));
        List<n<T>> list2 = this.f7085d;
        g gVar3 = this.f7082a;
        list2.add(new n<>(gVar3.f7069a, gVar3.f7073e, gVar3.f7074f, gVar3.f7072d, this.f7083b + 1));
        List<n<T>> list3 = this.f7085d;
        g gVar4 = this.f7082a;
        list3.add(new n<>(gVar4.f7073e, gVar4.f7071c, gVar4.f7074f, gVar4.f7072d, this.f7083b + 1));
        List<T> list4 = this.f7084c;
        this.f7084c = null;
        for (T t : list4) {
            a(t.a().x, t.a().y, t);
        }
    }

    private void a(double d2, double d3, T t) {
        List<n<T>> list = this.f7085d;
        if (list != null) {
            g gVar = this.f7082a;
            int i = (d3 > gVar.f7074f ? 1 : (d3 == gVar.f7074f ? 0 : -1));
            int i2 = (d2 > gVar.f7073e ? 1 : (d2 == gVar.f7073e ? 0 : -1));
            list.get(i < 0 ? i2 < 0 ? 0 : 1 : i2 < 0 ? 2 : 3).a(d2, d3, t);
            return;
        }
        if (this.f7084c == null) {
            this.f7084c = new ArrayList();
        }
        this.f7084c.add(t);
        if (this.f7084c.size() <= 40 || this.f7083b >= 40) {
            return;
        }
        a();
    }

    private void a(g gVar, Collection<T> collection) {
        if (this.f7082a.a(gVar)) {
            List<n<T>> list = this.f7085d;
            if (list != null) {
                for (n<T> nVar : list) {
                    nVar.a(gVar, collection);
                }
            } else if (this.f7084c != null) {
                if (gVar.b(this.f7082a)) {
                    collection.addAll(this.f7084c);
                    return;
                }
                for (T t : this.f7084c) {
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
        if (this.f7082a.a(a2.x, a2.y)) {
            a(a2.x, a2.y, t);
        }
    }
}
