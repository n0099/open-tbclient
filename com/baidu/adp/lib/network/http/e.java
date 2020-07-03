package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f KT = new f();
    protected g KU = new g();
    private LinkedList<d> KV = new LinkedList<>();
    private d KW = null;

    public f kT() {
        return this.KT;
    }

    public g kU() {
        return this.KU;
    }

    public List<d> kV() {
        return Collections.unmodifiableList(this.KV);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.KV.add(dVar);
        }
    }

    public d kW() {
        return this.KW;
    }

    public void b(d dVar) {
        this.KW = dVar;
    }
}
