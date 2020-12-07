package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f MX = new f();
    protected g MY = new g();
    private LinkedList<d> MZ = new LinkedList<>();
    private d Na = null;

    public f mx() {
        return this.MX;
    }

    public g my() {
        return this.MY;
    }

    public List<d> mz() {
        return Collections.unmodifiableList(this.MZ);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.MZ.add(dVar);
        }
    }

    public d mA() {
        return this.Na;
    }

    public void b(d dVar) {
        this.Na = dVar;
    }
}
