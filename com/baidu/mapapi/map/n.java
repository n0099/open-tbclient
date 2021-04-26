package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.mapapi.map.n.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* loaded from: classes2.dex */
public class n<T extends a> {

    /* renamed from: a  reason: collision with root package name */
    public final g f7372a;

    /* renamed from: b  reason: collision with root package name */
    public final int f7373b;

    /* renamed from: c  reason: collision with root package name */
    public List<T> f7374c;

    /* renamed from: d  reason: collision with root package name */
    public List<n<T>> f7375d;

    /* loaded from: classes2.dex */
    public static abstract class a {
        public abstract Point a();
    }

    public n(double d2, double d3, double d4, double d5, int i2) {
        this(new g(d2, d3, d4, d5), i2);
    }

    public n(g gVar) {
        this(gVar, 0);
    }

    public n(g gVar, int i2) {
        this.f7375d = null;
        this.f7372a = gVar;
        this.f7373b = i2;
    }

    private void a() {
        ArrayList arrayList = new ArrayList(4);
        this.f7375d = arrayList;
        g gVar = this.f7372a;
        arrayList.add(new n(gVar.f7359a, gVar.f7363e, gVar.f7360b, gVar.f7364f, this.f7373b + 1));
        List<n<T>> list = this.f7375d;
        g gVar2 = this.f7372a;
        list.add(new n<>(gVar2.f7363e, gVar2.f7361c, gVar2.f7360b, gVar2.f7364f, this.f7373b + 1));
        List<n<T>> list2 = this.f7375d;
        g gVar3 = this.f7372a;
        list2.add(new n<>(gVar3.f7359a, gVar3.f7363e, gVar3.f7364f, gVar3.f7362d, this.f7373b + 1));
        List<n<T>> list3 = this.f7375d;
        g gVar4 = this.f7372a;
        list3.add(new n<>(gVar4.f7363e, gVar4.f7361c, gVar4.f7364f, gVar4.f7362d, this.f7373b + 1));
        List<T> list4 = this.f7374c;
        this.f7374c = null;
        for (T t : list4) {
            a(t.a().x, t.a().y, t);
        }
    }

    private void a(double d2, double d3, T t) {
        List<n<T>> list = this.f7375d;
        if (list != null) {
            g gVar = this.f7372a;
            int i2 = (d3 > gVar.f7364f ? 1 : (d3 == gVar.f7364f ? 0 : -1));
            int i3 = (d2 > gVar.f7363e ? 1 : (d2 == gVar.f7363e ? 0 : -1));
            list.get(i2 < 0 ? i3 < 0 ? 0 : 1 : i3 < 0 ? 2 : 3).a(d2, d3, t);
            return;
        }
        if (this.f7374c == null) {
            this.f7374c = new ArrayList();
        }
        this.f7374c.add(t);
        if (this.f7374c.size() <= 40 || this.f7373b >= 40) {
            return;
        }
        a();
    }

    private void a(g gVar, Collection<T> collection) {
        if (this.f7372a.a(gVar)) {
            List<n<T>> list = this.f7375d;
            if (list != null) {
                for (n<T> nVar : list) {
                    nVar.a(gVar, collection);
                }
            } else if (this.f7374c != null) {
                if (gVar.b(this.f7372a)) {
                    collection.addAll(this.f7374c);
                    return;
                }
                for (T t : this.f7374c) {
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
        if (this.f7372a.a(a2.x, a2.y)) {
            a(a2.x, a2.y, t);
        }
    }
}
