package com.baidu.platform.comapi.map.b.b;

import android.util.Pair;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.b.a;
import com.baidu.platform.comapi.map.b.a.b;
import com.baidu.platform.comapi.map.b.f;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class b implements b.a {
    private MapController c;
    private a e;
    private LinkedList<a.C0240a> a = new LinkedList<>();
    private f b = new f();
    private boolean d = false;
    private int f = this.b.b / 3;

    public b(MapController mapController) {
        this.c = mapController;
    }

    private boolean a() {
        int a;
        int a2;
        boolean z = true;
        this.d = true;
        Iterator<a.C0240a> it = this.a.iterator();
        while (it.hasNext()) {
            Double valueOf = Double.valueOf(a.d.a(com.baidu.platform.comapi.map.b.a.a.c(), it.next().c()));
            if (Math.abs(valueOf.doubleValue()) > 45.0d && Math.abs(valueOf.doubleValue()) < 135.0d) {
                return false;
            }
        }
        Pair<a.d, a.d> c = this.b.c();
        a.d dVar = (a.d) c.first;
        a.d dVar2 = (a.d) c.second;
        boolean z2 = Math.abs(dVar.b) > ((double) this.f) && Math.abs(dVar2.b) > ((double) this.f);
        a.C0240a first = this.a.getFirst();
        a.C0240a last = this.a.getLast();
        a.C0240a c0240a = new a.C0240a(last.a, first.a);
        a.C0240a c0240a2 = new a.C0240a(last.b, first.b);
        if (dVar.b <= 0.0d || dVar2.b <= 0.0d) {
            a = (int) a.d.a(c0240a.c(), com.baidu.platform.comapi.map.b.a.b.c());
            a2 = (int) a.d.a(c0240a2.c(), com.baidu.platform.comapi.map.b.a.b.c());
        } else {
            a = (int) a.d.a(c0240a.c(), com.baidu.platform.comapi.map.b.a.c.c());
            a2 = (int) a.d.a(c0240a2.c(), com.baidu.platform.comapi.map.b.a.c.c());
        }
        boolean z3 = Math.abs(a) < 40 && Math.abs(a2) < 40;
        if (!z2 || !z3) {
            z = false;
        }
        return z;
    }

    private void d(com.baidu.platform.comapi.map.b.a.b bVar) {
        if (this.a.size() < 5) {
            this.a.addLast(bVar.c);
            this.b.a(bVar.d);
        } else if (!this.d && this.a.size() == 5 && a()) {
            e(bVar);
        }
    }

    private void e(com.baidu.platform.comapi.map.b.a.b bVar) {
        if (this.c.isOverlookGestureEnable()) {
            this.e.a(bVar, null);
            this.e = new c(this.c);
            this.e.a(bVar);
        }
    }

    @Override // com.baidu.platform.comapi.map.b.a.b.a
    public boolean a(com.baidu.platform.comapi.map.b.a.b bVar) {
        this.a.clear();
        this.b.a();
        this.e = new d(this.c);
        this.d = false;
        return true;
    }

    @Override // com.baidu.platform.comapi.map.b.a.b.a
    public boolean b(com.baidu.platform.comapi.map.b.a.b bVar) {
        d(bVar);
        if (this.a.size() == 1) {
            this.e.a(bVar);
        }
        this.e.b(bVar);
        return true;
    }

    @Override // com.baidu.platform.comapi.map.b.a.b.a
    public boolean c(com.baidu.platform.comapi.map.b.a.b bVar) {
        Pair<a.d, a.d> c = this.b.c();
        this.b.b();
        this.e.a(bVar, c);
        return true;
    }
}
