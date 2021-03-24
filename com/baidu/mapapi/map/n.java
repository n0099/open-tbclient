package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.mapapi.map.n.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* loaded from: classes2.dex */
public class n<T extends a> {

    /* renamed from: a  reason: collision with root package name */
    public final g f7081a;

    /* renamed from: b  reason: collision with root package name */
    public final int f7082b;

    /* renamed from: c  reason: collision with root package name */
    public List<T> f7083c;

    /* renamed from: d  reason: collision with root package name */
    public List<n<T>> f7084d;

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
        this.f7084d = null;
        this.f7081a = gVar;
        this.f7082b = i;
    }

    private void a() {
        ArrayList arrayList = new ArrayList(4);
        this.f7084d = arrayList;
        g gVar = this.f7081a;
        arrayList.add(new n(gVar.f7068a, gVar.f7072e, gVar.f7069b, gVar.f7073f, this.f7082b + 1));
        List<n<T>> list = this.f7084d;
        g gVar2 = this.f7081a;
        list.add(new n<>(gVar2.f7072e, gVar2.f7070c, gVar2.f7069b, gVar2.f7073f, this.f7082b + 1));
        List<n<T>> list2 = this.f7084d;
        g gVar3 = this.f7081a;
        list2.add(new n<>(gVar3.f7068a, gVar3.f7072e, gVar3.f7073f, gVar3.f7071d, this.f7082b + 1));
        List<n<T>> list3 = this.f7084d;
        g gVar4 = this.f7081a;
        list3.add(new n<>(gVar4.f7072e, gVar4.f7070c, gVar4.f7073f, gVar4.f7071d, this.f7082b + 1));
        List<T> list4 = this.f7083c;
        this.f7083c = null;
        for (T t : list4) {
            a(t.a().x, t.a().y, t);
        }
    }

    private void a(double d2, double d3, T t) {
        List<n<T>> list = this.f7084d;
        if (list != null) {
            g gVar = this.f7081a;
            int i = (d3 > gVar.f7073f ? 1 : (d3 == gVar.f7073f ? 0 : -1));
            int i2 = (d2 > gVar.f7072e ? 1 : (d2 == gVar.f7072e ? 0 : -1));
            list.get(i < 0 ? i2 < 0 ? 0 : 1 : i2 < 0 ? 2 : 3).a(d2, d3, t);
            return;
        }
        if (this.f7083c == null) {
            this.f7083c = new ArrayList();
        }
        this.f7083c.add(t);
        if (this.f7083c.size() <= 40 || this.f7082b >= 40) {
            return;
        }
        a();
    }

    private void a(g gVar, Collection<T> collection) {
        if (this.f7081a.a(gVar)) {
            List<n<T>> list = this.f7084d;
            if (list != null) {
                for (n<T> nVar : list) {
                    nVar.a(gVar, collection);
                }
            } else if (this.f7083c != null) {
                if (gVar.b(this.f7081a)) {
                    collection.addAll(this.f7083c);
                    return;
                }
                for (T t : this.f7083c) {
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
        if (this.f7081a.a(a2.x, a2.y)) {
            a(a2.x, a2.y, t);
        }
    }
}
