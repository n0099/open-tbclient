package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f Ms = new f();
    protected g Mt = new g();
    private LinkedList<d> Mu = new LinkedList<>();
    private d Mv = null;

    public f lV() {
        return this.Ms;
    }

    public g lW() {
        return this.Mt;
    }

    public List<d> lX() {
        return Collections.unmodifiableList(this.Mu);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.Mu.add(dVar);
        }
    }

    public d lY() {
        return this.Mv;
    }

    public void b(d dVar) {
        this.Mv = dVar;
    }
}
