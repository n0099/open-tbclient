package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f NQ = new f();
    protected g NR = new g();
    private LinkedList<d> NT = new LinkedList<>();
    private d NU = null;

    public f lU() {
        return this.NQ;
    }

    public g lV() {
        return this.NR;
    }

    public List<d> lW() {
        return Collections.unmodifiableList(this.NT);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.NT.add(dVar);
        }
    }

    public d lX() {
        return this.NU;
    }

    public void b(d dVar) {
        this.NU = dVar;
    }
}
