package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f rd = new f();
    protected g re = new g();
    private LinkedList<d> rf = new LinkedList<>();
    private d rg = null;

    public f fX() {
        return this.rd;
    }

    public g fY() {
        return this.re;
    }

    public List<d> fZ() {
        return Collections.unmodifiableList(this.rf);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.rf.add(dVar);
        }
    }

    public d ga() {
        return this.rg;
    }

    public void b(d dVar) {
        this.rg = dVar;
    }
}
