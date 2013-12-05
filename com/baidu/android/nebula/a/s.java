package com.baidu.android.nebula.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class s {
    private ArrayList b;

    /* renamed from: a  reason: collision with root package name */
    private boolean f660a = false;
    private t d = new t(this);
    private final ConcurrentHashMap c = new ConcurrentHashMap();

    private void d() {
        Collection values = this.c.values();
        if (values == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(values);
        Collections.sort(arrayList, this.d);
        this.b = arrayList;
        this.f660a = true;
    }

    public a a(int i) {
        if (!this.f660a) {
            d();
        }
        return (a) this.b.get(i);
    }

    public a a(String str) {
        return (a) this.c.get(str);
    }

    public s a(int i, int i2) {
        s sVar = new s();
        d();
        if (i < 0 || i2 < 0 || i > i2 || i > this.b.size() || i2 > this.b.size()) {
            return sVar;
        }
        while (i < i2) {
            a aVar = (a) this.b.get(i);
            sVar.a(aVar.b(), aVar);
            b(aVar.b());
            i++;
        }
        return sVar;
    }

    public void a() {
        if (this.c == null) {
            if (this.b != null) {
                this.b.clear();
                return;
            }
            return;
        }
        this.c.clear();
        if (this.b != null) {
            this.b.clear();
        }
    }

    public void a(a aVar) {
        this.c.put(aVar.b(), aVar);
        this.f660a = false;
    }

    public void a(String str, a aVar) {
        this.f660a = false;
        this.c.put(str, aVar);
    }

    public a b(String str) {
        this.f660a = false;
        return (a) this.c.remove(str);
    }

    public ArrayList b() {
        if (!this.f660a) {
            d();
        }
        return this.b;
    }

    public int c() {
        if (this.c == null) {
            return 0;
        }
        return this.c.size();
    }
}
