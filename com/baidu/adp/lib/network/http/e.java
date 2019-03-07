package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f CU = new f();
    protected g CV = new g();
    private LinkedList<d> CW = new LinkedList<>();
    private d CX = null;

    public f jr() {
        return this.CU;
    }

    public g js() {
        return this.CV;
    }

    public List<d> jt() {
        return Collections.unmodifiableList(this.CW);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.CW.add(dVar);
        }
    }

    public d ju() {
        return this.CX;
    }

    public void b(d dVar) {
        this.CX = dVar;
    }
}
