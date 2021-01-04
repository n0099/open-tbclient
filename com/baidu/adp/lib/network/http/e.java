package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f Mu = new f();
    protected g Mv = new g();
    private LinkedList<d> Mw = new LinkedList<>();
    private d Mx = null;

    public f lV() {
        return this.Mu;
    }

    public g lW() {
        return this.Mv;
    }

    public List<d> lX() {
        return Collections.unmodifiableList(this.Mw);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.Mw.add(dVar);
        }
    }

    public d lY() {
        return this.Mx;
    }

    public void b(d dVar) {
        this.Mx = dVar;
    }
}
