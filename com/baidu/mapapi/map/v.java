package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.mapapi.map.v.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* loaded from: classes3.dex */
public class v<T extends a> {
    public final m a;
    public final int b;
    public List<T> c;
    public List<v<T>> d;

    /* loaded from: classes3.dex */
    public static abstract class a {
        public abstract Point getPoint();
    }

    public v(double d, double d2, double d3, double d4, int i) {
        this(new m(d, d2, d3, d4), i);
    }

    public v(m mVar) {
        this(mVar, 0);
    }

    public Collection<T> a(m mVar) {
        ArrayList arrayList = new ArrayList();
        a(mVar, arrayList);
        return arrayList;
    }

    public v(m mVar, int i) {
        this.d = null;
        this.a = mVar;
        this.b = i;
    }

    private void a() {
        ArrayList arrayList = new ArrayList(4);
        this.d = arrayList;
        m mVar = this.a;
        arrayList.add(new v(mVar.a, mVar.e, mVar.b, mVar.f, this.b + 1));
        List<v<T>> list = this.d;
        m mVar2 = this.a;
        list.add(new v<>(mVar2.e, mVar2.c, mVar2.b, mVar2.f, this.b + 1));
        List<v<T>> list2 = this.d;
        m mVar3 = this.a;
        list2.add(new v<>(mVar3.a, mVar3.e, mVar3.f, mVar3.d, this.b + 1));
        List<v<T>> list3 = this.d;
        m mVar4 = this.a;
        list3.add(new v<>(mVar4.e, mVar4.c, mVar4.f, mVar4.d, this.b + 1));
        List<T> list4 = this.c;
        this.c = null;
        for (T t : list4) {
            a(t.getPoint().x, t.getPoint().y, t);
        }
    }

    private void a(double d, double d2, T t) {
        List<v<T>> list = this.d;
        if (list != null) {
            m mVar = this.a;
            if (d2 < mVar.f) {
                if (d < mVar.e) {
                    list.get(0).a(d, d2, t);
                    return;
                } else {
                    list.get(1).a(d, d2, t);
                    return;
                }
            } else if (d < mVar.e) {
                list.get(2).a(d, d2, t);
                return;
            } else {
                list.get(3).a(d, d2, t);
                return;
            }
        }
        if (this.c == null) {
            this.c = new ArrayList();
        }
        this.c.add(t);
        if (this.c.size() > 40 && this.b < 40) {
            a();
        }
    }

    private void a(m mVar, Collection<T> collection) {
        if (!this.a.a(mVar)) {
            return;
        }
        List<v<T>> list = this.d;
        if (list != null) {
            for (v<T> vVar : list) {
                vVar.a(mVar, collection);
            }
        } else if (this.c != null) {
            if (mVar.b(this.a)) {
                collection.addAll(this.c);
                return;
            }
            for (T t : this.c) {
                if (mVar.a(t.getPoint())) {
                    collection.add(t);
                }
            }
        }
    }

    public void a(T t) {
        Point point = t.getPoint();
        if (this.a.a(point.x, point.y)) {
            a(point.x, point.y, t);
        }
    }
}
