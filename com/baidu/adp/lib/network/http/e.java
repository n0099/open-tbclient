package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f kx = new f();
    protected g ky = new g();
    private LinkedList<d> kA = new LinkedList<>();

    public f dP() {
        return this.kx;
    }

    public g dQ() {
        return this.ky;
    }

    public List<d> dR() {
        return Collections.unmodifiableList(this.kA);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.kA.add(dVar);
        }
    }
}
