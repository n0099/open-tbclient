package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f a = new f();
    protected g b = new g();
    private LinkedList<d> c = new LinkedList<>();

    public f a() {
        return this.a;
    }

    public g b() {
        return this.b;
    }

    public List<d> c() {
        return Collections.unmodifiableList(this.c);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.c.add(dVar);
        }
    }
}
