package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f vb = new f();
    protected g vc = new g();
    private LinkedList<d> vd = new LinkedList<>();
    private d ve = null;

    public f gS() {
        return this.vb;
    }

    public g gT() {
        return this.vc;
    }

    public List<d> gU() {
        return Collections.unmodifiableList(this.vd);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.vd.add(dVar);
        }
    }

    public d gV() {
        return this.ve;
    }

    public void b(d dVar) {
        this.ve = dVar;
    }
}
