package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f vd = new f();
    protected g ve = new g();
    private LinkedList<d> vf = new LinkedList<>();
    private d vg = null;

    public f fy() {
        return this.vd;
    }

    public g fz() {
        return this.ve;
    }

    public List<d> fA() {
        return Collections.unmodifiableList(this.vf);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.vf.add(dVar);
        }
    }

    public d fB() {
        return this.vg;
    }

    public void b(d dVar) {
        this.vg = dVar;
    }
}
