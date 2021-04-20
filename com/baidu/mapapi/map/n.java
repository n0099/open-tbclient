package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.mapapi.map.n.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* loaded from: classes2.dex */
public class n<T extends a> {

    /* renamed from: a  reason: collision with root package name */
    public final g f7117a;

    /* renamed from: b  reason: collision with root package name */
    public final int f7118b;

    /* renamed from: c  reason: collision with root package name */
    public List<T> f7119c;

    /* renamed from: d  reason: collision with root package name */
    public List<n<T>> f7120d;

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
        this.f7120d = null;
        this.f7117a = gVar;
        this.f7118b = i;
    }

    private void a() {
        ArrayList arrayList = new ArrayList(4);
        this.f7120d = arrayList;
        g gVar = this.f7117a;
        arrayList.add(new n(gVar.f7104a, gVar.f7108e, gVar.f7105b, gVar.f7109f, this.f7118b + 1));
        List<n<T>> list = this.f7120d;
        g gVar2 = this.f7117a;
        list.add(new n<>(gVar2.f7108e, gVar2.f7106c, gVar2.f7105b, gVar2.f7109f, this.f7118b + 1));
        List<n<T>> list2 = this.f7120d;
        g gVar3 = this.f7117a;
        list2.add(new n<>(gVar3.f7104a, gVar3.f7108e, gVar3.f7109f, gVar3.f7107d, this.f7118b + 1));
        List<n<T>> list3 = this.f7120d;
        g gVar4 = this.f7117a;
        list3.add(new n<>(gVar4.f7108e, gVar4.f7106c, gVar4.f7109f, gVar4.f7107d, this.f7118b + 1));
        List<T> list4 = this.f7119c;
        this.f7119c = null;
        for (T t : list4) {
            a(t.a().x, t.a().y, t);
        }
    }

    private void a(double d2, double d3, T t) {
        List<n<T>> list = this.f7120d;
        if (list != null) {
            g gVar = this.f7117a;
            int i = (d3 > gVar.f7109f ? 1 : (d3 == gVar.f7109f ? 0 : -1));
            int i2 = (d2 > gVar.f7108e ? 1 : (d2 == gVar.f7108e ? 0 : -1));
            list.get(i < 0 ? i2 < 0 ? 0 : 1 : i2 < 0 ? 2 : 3).a(d2, d3, t);
            return;
        }
        if (this.f7119c == null) {
            this.f7119c = new ArrayList();
        }
        this.f7119c.add(t);
        if (this.f7119c.size() <= 40 || this.f7118b >= 40) {
            return;
        }
        a();
    }

    private void a(g gVar, Collection<T> collection) {
        if (this.f7117a.a(gVar)) {
            List<n<T>> list = this.f7120d;
            if (list != null) {
                for (n<T> nVar : list) {
                    nVar.a(gVar, collection);
                }
            } else if (this.f7119c != null) {
                if (gVar.b(this.f7117a)) {
                    collection.addAll(this.f7119c);
                    return;
                }
                for (T t : this.f7119c) {
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
        if (this.f7117a.a(a2.x, a2.y)) {
            a(a2.x, a2.y, t);
        }
    }
}
