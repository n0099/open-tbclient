package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f vI = new f();
    protected g vJ = new g();
    private LinkedList<d> vK = new LinkedList<>();
    private d vL = null;

    public f fy() {
        return this.vI;
    }

    public g fz() {
        return this.vJ;
    }

    public List<d> fA() {
        return Collections.unmodifiableList(this.vK);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.vK.add(dVar);
        }
    }

    public d fB() {
        return this.vL;
    }

    public void b(d dVar) {
        this.vL = dVar;
    }
}
