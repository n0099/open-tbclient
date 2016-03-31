package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    protected g vC = new g();
    protected h vD = new h();
    private LinkedList<e> vE = new LinkedList<>();
    private e vF = null;

    public g hg() {
        return this.vC;
    }

    public h hh() {
        return this.vD;
    }

    public List<e> hi() {
        return Collections.unmodifiableList(this.vE);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.vE.add(eVar);
        }
    }

    public e hj() {
        return this.vF;
    }

    public void b(e eVar) {
        this.vF = eVar;
    }
}
