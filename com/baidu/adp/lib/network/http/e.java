package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f kv = new f();
    protected g kx = new g();
    private LinkedList<d> ky = new LinkedList<>();

    public f dQ() {
        return this.kv;
    }

    public g dR() {
        return this.kx;
    }

    public List<d> dS() {
        return Collections.unmodifiableList(this.ky);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.ky.add(dVar);
        }
    }
}
