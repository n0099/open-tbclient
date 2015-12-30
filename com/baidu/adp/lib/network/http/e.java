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

    public f gS() {
        return this.vd;
    }

    public g gT() {
        return this.ve;
    }

    public List<d> gU() {
        return Collections.unmodifiableList(this.vf);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.vf.add(dVar);
        }
    }

    public d gV() {
        return this.vg;
    }

    public void b(d dVar) {
        this.vg = dVar;
    }
}
