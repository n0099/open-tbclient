package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f pi = new f();
    protected g pj = new g();
    private LinkedList<d> pl = new LinkedList<>();
    private d po = null;

    public f fJ() {
        return this.pi;
    }

    public g fK() {
        return this.pj;
    }

    public List<d> fL() {
        return Collections.unmodifiableList(this.pl);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.pl.add(dVar);
        }
    }

    public d fM() {
        return this.po;
    }

    public void b(d dVar) {
        this.po = dVar;
    }
}
