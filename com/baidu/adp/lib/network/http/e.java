package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f CV = new f();
    protected g CW = new g();
    private LinkedList<d> CX = new LinkedList<>();
    private d CY = null;

    public f jp() {
        return this.CV;
    }

    public g jq() {
        return this.CW;
    }

    public List<d> jr() {
        return Collections.unmodifiableList(this.CX);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.CX.add(dVar);
        }
    }

    public d js() {
        return this.CY;
    }

    public void b(d dVar) {
        this.CY = dVar;
    }
}
