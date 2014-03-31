package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public final class e {
    protected f a = new f();
    protected g b = new g();
    private LinkedList<d> c = new LinkedList<>();

    public final f a() {
        return this.a;
    }

    public final g b() {
        return this.b;
    }

    public final List<d> c() {
        return Collections.unmodifiableList(this.c);
    }

    public final void a(d dVar) {
        if (dVar != null) {
            this.c.add(dVar);
        }
    }
}
