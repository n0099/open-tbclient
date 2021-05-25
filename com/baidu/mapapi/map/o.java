package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.mapapi.map.o.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* loaded from: classes2.dex */
public class o<T extends a> {

    /* renamed from: a  reason: collision with root package name */
    public final h f7091a;

    /* renamed from: b  reason: collision with root package name */
    public final int f7092b;

    /* renamed from: c  reason: collision with root package name */
    public List<T> f7093c;

    /* renamed from: d  reason: collision with root package name */
    public List<o<T>> f7094d;

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
        this.f7094d = null;
        this.f7091a = hVar;
        this.f7092b = i2;
    }

    private void a() {
        ArrayList arrayList = new ArrayList(4);
        this.f7094d = arrayList;
        h hVar = this.f7091a;
        arrayList.add(new o(hVar.f7078a, hVar.f7082e, hVar.f7079b, hVar.f7083f, this.f7092b + 1));
        List<o<T>> list = this.f7094d;
        h hVar2 = this.f7091a;
        list.add(new o<>(hVar2.f7082e, hVar2.f7080c, hVar2.f7079b, hVar2.f7083f, this.f7092b + 1));
        List<o<T>> list2 = this.f7094d;
        h hVar3 = this.f7091a;
        list2.add(new o<>(hVar3.f7078a, hVar3.f7082e, hVar3.f7083f, hVar3.f7081d, this.f7092b + 1));
        List<o<T>> list3 = this.f7094d;
        h hVar4 = this.f7091a;
        list3.add(new o<>(hVar4.f7082e, hVar4.f7080c, hVar4.f7083f, hVar4.f7081d, this.f7092b + 1));
        List<T> list4 = this.f7093c;
        this.f7093c = null;
        for (T t : list4) {
            a(t.a().x, t.a().y, t);
        }
    }

    private void a(double d2, double d3, T t) {
        List<o<T>> list = this.f7094d;
        if (list != null) {
            h hVar = this.f7091a;
            int i2 = (d3 > hVar.f7083f ? 1 : (d3 == hVar.f7083f ? 0 : -1));
            int i3 = (d2 > hVar.f7082e ? 1 : (d2 == hVar.f7082e ? 0 : -1));
            list.get(i2 < 0 ? i3 < 0 ? 0 : 1 : i3 < 0 ? 2 : 3).a(d2, d3, t);
            return;
        }
        if (this.f7093c == null) {
            this.f7093c = new ArrayList();
        }
        this.f7093c.add(t);
        if (this.f7093c.size() <= 40 || this.f7092b >= 40) {
            return;
        }
        a();
    }

    private void a(h hVar, Collection<T> collection) {
        if (this.f7091a.a(hVar)) {
            List<o<T>> list = this.f7094d;
            if (list != null) {
                for (o<T> oVar : list) {
                    oVar.a(hVar, collection);
                }
            } else if (this.f7093c != null) {
                if (hVar.b(this.f7091a)) {
                    collection.addAll(this.f7093c);
                    return;
                }
                for (T t : this.f7093c) {
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
        if (this.f7091a.a(a2.x, a2.y)) {
            a(a2.x, a2.y, t);
        }
    }
}
