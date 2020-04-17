package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f Ke = new f();
    protected g Kf = new g();
    private LinkedList<d> Kg = new LinkedList<>();
    private d Kh = null;

    public f kB() {
        return this.Ke;
    }

    public g kC() {
        return this.Kf;
    }

    public List<d> kD() {
        return Collections.unmodifiableList(this.Kg);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.Kg.add(dVar);
        }
    }

    public d kE() {
        return this.Kh;
    }

    public void b(d dVar) {
        this.Kh = dVar;
    }
}
