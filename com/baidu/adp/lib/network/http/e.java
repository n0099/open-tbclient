package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f vf = new f();
    protected g vg = new g();
    private LinkedList<d> vh = new LinkedList<>();
    private d vi = null;

    public f fy() {
        return this.vf;
    }

    public g fz() {
        return this.vg;
    }

    public List<d> fA() {
        return Collections.unmodifiableList(this.vh);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.vh.add(dVar);
        }
    }

    public d fB() {
        return this.vi;
    }

    public void b(d dVar) {
        this.vi = dVar;
    }
}
