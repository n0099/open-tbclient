package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f kB = new f();
    protected g kC = new g();
    private LinkedList<d> kD = new LinkedList<>();

    public f dN() {
        return this.kB;
    }

    public g dO() {
        return this.kC;
    }

    public List<d> dP() {
        return Collections.unmodifiableList(this.kD);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.kD.add(dVar);
        }
    }
}
