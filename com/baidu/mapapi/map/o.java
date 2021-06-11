package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.mapapi.map.o.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* loaded from: classes2.dex */
public class o<T extends a> {

    /* renamed from: a  reason: collision with root package name */
    public final h f7134a;

    /* renamed from: b  reason: collision with root package name */
    public final int f7135b;

    /* renamed from: c  reason: collision with root package name */
    public List<T> f7136c;

    /* renamed from: d  reason: collision with root package name */
    public List<o<T>> f7137d;

    /* loaded from: classes2.dex */
    public static abstract class a {
        public abstract Point a();
    }

    public o(double d2, double d3, double d4, double d5, int i2) {
        this(new h(d2, d3, d4, d5), i2);
    }

    public o(h hVar) {
        this(hVar, 0);
    }

    public o(h hVar, int i2) {
        this.f7137d = null;
        this.f7134a = hVar;
        this.f7135b = i2;
    }

    private void a() {
        ArrayList arrayList = new ArrayList(4);
        this.f7137d = arrayList;
        h hVar = this.f7134a;
        arrayList.add(new o(hVar.f7121a, hVar.f7125e, hVar.f7122b, hVar.f7126f, this.f7135b + 1));
        List<o<T>> list = this.f7137d;
        h hVar2 = this.f7134a;
        list.add(new o<>(hVar2.f7125e, hVar2.f7123c, hVar2.f7122b, hVar2.f7126f, this.f7135b + 1));
        List<o<T>> list2 = this.f7137d;
        h hVar3 = this.f7134a;
        list2.add(new o<>(hVar3.f7121a, hVar3.f7125e, hVar3.f7126f, hVar3.f7124d, this.f7135b + 1));
        List<o<T>> list3 = this.f7137d;
        h hVar4 = this.f7134a;
        list3.add(new o<>(hVar4.f7125e, hVar4.f7123c, hVar4.f7126f, hVar4.f7124d, this.f7135b + 1));
        List<T> list4 = this.f7136c;
        this.f7136c = null;
        for (T t : list4) {
            a(t.a().x, t.a().y, t);
        }
    }

    private void a(double d2, double d3, T t) {
        List<o<T>> list = this.f7137d;
        if (list != null) {
            h hVar = this.f7134a;
            int i2 = (d3 > hVar.f7126f ? 1 : (d3 == hVar.f7126f ? 0 : -1));
            int i3 = (d2 > hVar.f7125e ? 1 : (d2 == hVar.f7125e ? 0 : -1));
            list.get(i2 < 0 ? i3 < 0 ? 0 : 1 : i3 < 0 ? 2 : 3).a(d2, d3, t);
            return;
        }
        if (this.f7136c == null) {
            this.f7136c = new ArrayList();
        }
        this.f7136c.add(t);
        if (this.f7136c.size() <= 40 || this.f7135b >= 40) {
            return;
        }
        a();
    }

    private void a(h hVar, Collection<T> collection) {
        if (this.f7134a.a(hVar)) {
            List<o<T>> list = this.f7137d;
            if (list != null) {
                for (o<T> oVar : list) {
                    oVar.a(hVar, collection);
                }
            } else if (this.f7136c != null) {
                if (hVar.b(this.f7134a)) {
                    collection.addAll(this.f7136c);
                    return;
                }
                for (T t : this.f7136c) {
                    if (hVar.a(t.a())) {
                        collection.add(t);
                    }
                }
            }
        }
    }

    public Collection<T> a(h hVar) {
        ArrayList arrayList = new ArrayList();
        a(hVar, arrayList);
        return arrayList;
    }

    public void a(T t) {
        Point a2 = t.a();
        if (this.f7134a.a(a2.x, a2.y)) {
            a(a2.x, a2.y, t);
        }
    }
}
