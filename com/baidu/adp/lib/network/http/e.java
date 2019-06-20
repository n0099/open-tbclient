package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f AB = new f();
    protected g AC = new g();
    private LinkedList<d> AD = new LinkedList<>();
    private d AE = null;

    public f ik() {
        return this.AB;
    }

    public g il() {
        return this.AC;
    }

    public List<d> im() {
        return Collections.unmodifiableList(this.AD);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.AD.add(dVar);
        }
    }

    public d in() {
        return this.AE;
    }

    public void b(d dVar) {
        this.AE = dVar;
    }
}
