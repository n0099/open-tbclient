package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.mapapi.map.o.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* loaded from: classes2.dex */
public class o<T extends a> {

    /* renamed from: a  reason: collision with root package name */
    public final h f7191a;

    /* renamed from: b  reason: collision with root package name */
    public final int f7192b;

    /* renamed from: c  reason: collision with root package name */
    public List<T> f7193c;

    /* renamed from: d  reason: collision with root package name */
    public List<o<T>> f7194d;

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
        this.f7194d = null;
        this.f7191a = hVar;
        this.f7192b = i2;
    }

    private void a() {
        ArrayList arrayList = new ArrayList(4);
        this.f7194d = arrayList;
        h hVar = this.f7191a;
        arrayList.add(new o(hVar.f7178a, hVar.f7182e, hVar.f7179b, hVar.f7183f, this.f7192b + 1));
        List<o<T>> list = this.f7194d;
        h hVar2 = this.f7191a;
        list.add(new o<>(hVar2.f7182e, hVar2.f7180c, hVar2.f7179b, hVar2.f7183f, this.f7192b + 1));
        List<o<T>> list2 = this.f7194d;
        h hVar3 = this.f7191a;
        list2.add(new o<>(hVar3.f7178a, hVar3.f7182e, hVar3.f7183f, hVar3.f7181d, this.f7192b + 1));
        List<o<T>> list3 = this.f7194d;
        h hVar4 = this.f7191a;
        list3.add(new o<>(hVar4.f7182e, hVar4.f7180c, hVar4.f7183f, hVar4.f7181d, this.f7192b + 1));
        List<T> list4 = this.f7193c;
        this.f7193c = null;
        for (T t : list4) {
            a(t.a().x, t.a().y, t);
        }
    }

    private void a(double d2, double d3, T t) {
        List<o<T>> list = this.f7194d;
        if (list != null) {
            h hVar = this.f7191a;
            int i2 = (d3 > hVar.f7183f ? 1 : (d3 == hVar.f7183f ? 0 : -1));
            int i3 = (d2 > hVar.f7182e ? 1 : (d2 == hVar.f7182e ? 0 : -1));
            list.get(i2 < 0 ? i3 < 0 ? 0 : 1 : i3 < 0 ? 2 : 3).a(d2, d3, t);
            return;
        }
        if (this.f7193c == null) {
            this.f7193c = new ArrayList();
        }
        this.f7193c.add(t);
        if (this.f7193c.size() <= 40 || this.f7192b >= 40) {
            return;
        }
        a();
    }

    private void a(h hVar, Collection<T> collection) {
        if (this.f7191a.a(hVar)) {
            List<o<T>> list = this.f7194d;
            if (list != null) {
                for (o<T> oVar : list) {
                    oVar.a(hVar, collection);
                }
            } else if (this.f7193c != null) {
                if (hVar.b(this.f7191a)) {
                    collection.addAll(this.f7193c);
                    return;
                }
                for (T t : this.f7193c) {
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
        if (this.f7191a.a(a2.x, a2.y)) {
            a(a2.x, a2.y, t);
        }
    }
}
