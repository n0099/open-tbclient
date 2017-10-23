package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f vg = new f();
    protected g vh = new g();
    private LinkedList<d> vi = new LinkedList<>();
    private d vj = null;

    public f fy() {
        return this.vg;
    }

    public g fz() {
        return this.vh;
    }

    public List<d> fA() {
        return Collections.unmodifiableList(this.vi);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.vi.add(dVar);
        }
    }

    public d fB() {
        return this.vj;
    }

    public void b(d dVar) {
        this.vj = dVar;
    }
}
