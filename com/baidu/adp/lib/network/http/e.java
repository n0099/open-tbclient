package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f AC = new f();
    protected g AD = new g();
    private LinkedList<d> AE = new LinkedList<>();
    private d AF = null;

    public f ik() {
        return this.AC;
    }

    public g il() {
        return this.AD;
    }

    public List<d> im() {
        return Collections.unmodifiableList(this.AE);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.AE.add(dVar);
        }
    }

    public d in() {
        return this.AF;
    }

    public void b(d dVar) {
        this.AF = dVar;
    }
}
