package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f ve = new f();
    protected g vf = new g();
    private LinkedList<d> vg = new LinkedList<>();
    private d vh = null;

    public f fy() {
        return this.ve;
    }

    public g fz() {
        return this.vf;
    }

    public List<d> fA() {
        return Collections.unmodifiableList(this.vg);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.vg.add(dVar);
        }
    }

    public d fB() {
        return this.vh;
    }

    public void b(d dVar) {
        this.vh = dVar;
    }
}
