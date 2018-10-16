package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f CP = new f();
    protected g CQ = new g();
    private LinkedList<d> CT = new LinkedList<>();
    private d CU = null;

    public f jr() {
        return this.CP;
    }

    public g js() {
        return this.CQ;
    }

    public List<d> jt() {
        return Collections.unmodifiableList(this.CT);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.CT.add(dVar);
        }
    }

    public d ju() {
        return this.CU;
    }

    public void b(d dVar) {
        this.CU = dVar;
    }
}
