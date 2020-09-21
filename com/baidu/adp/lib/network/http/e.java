package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f LI = new f();
    protected g LJ = new g();
    private LinkedList<d> LK = new LinkedList<>();
    private d LM = null;

    public f mw() {
        return this.LI;
    }

    public g mx() {
        return this.LJ;
    }

    public List<d> my() {
        return Collections.unmodifiableList(this.LK);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.LK.add(dVar);
        }
    }

    public d mz() {
        return this.LM;
    }

    public void b(d dVar) {
        this.LM = dVar;
    }
}
