package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f Ks = new f();
    protected g Kt = new g();
    private LinkedList<d> Ku = new LinkedList<>();
    private d Kv = null;

    public f kD() {
        return this.Ks;
    }

    public g kE() {
        return this.Kt;
    }

    public List<d> kF() {
        return Collections.unmodifiableList(this.Ku);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.Ku.add(dVar);
        }
    }

    public d kG() {
        return this.Kv;
    }

    public void b(d dVar) {
        this.Kv = dVar;
    }
}
