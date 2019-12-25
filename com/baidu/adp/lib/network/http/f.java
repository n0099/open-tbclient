package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    protected g re = new g();
    protected h rf = new h();
    private LinkedList<d> rg = new LinkedList<>();
    private d rh = null;

    public g fY() {
        return this.re;
    }

    public h fZ() {
        return this.rf;
    }

    public List<d> ga() {
        return Collections.unmodifiableList(this.rg);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.rg.add(dVar);
        }
    }

    public d gb() {
        return this.rh;
    }

    public void b(d dVar) {
        this.rh = dVar;
    }
}
