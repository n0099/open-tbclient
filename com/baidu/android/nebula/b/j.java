package com.baidu.android.nebula.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class j {
    private ArrayList b;
    private boolean a = false;
    private l d = new l(this);
    private final ConcurrentHashMap c = new ConcurrentHashMap();

    private void d() {
        Collection values = this.c.values();
        if (values == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(values);
        Collections.sort(arrayList, this.d);
        this.b = arrayList;
        this.a = true;
    }

    public j a(int i, int i2) {
        j jVar = new j();
        d();
        if (i < 0 || i2 < 0 || i > i2 || i > this.b.size() || i2 > this.b.size()) {
            return jVar;
        }
        while (i < i2) {
            u uVar = (u) this.b.get(i);
            jVar.a(uVar.b(), uVar);
            b(uVar.b());
            i++;
        }
        return jVar;
    }

    public u a(int i) {
        if (!this.a) {
            d();
        }
        return (u) this.b.get(i);
    }

    public u a(String str) {
        return (u) this.c.get(str);
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

    public void a(u uVar) {
        this.c.put(uVar.b(), uVar);
        this.a = false;
    }

    public void a(String str, u uVar) {
        this.a = false;
        this.c.put(str, uVar);
    }

    public u b(String str) {
        this.a = false;
        return (u) this.c.remove(str);
    }

    public ArrayList b() {
        if (!this.a) {
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
