package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    protected g vD = new g();
    protected h vE = new h();
    private LinkedList<e> vF = new LinkedList<>();
    private e vG = null;

    public g fA() {
        return this.vD;
    }

    public h fB() {
        return this.vE;
    }

    public List<e> fC() {
        return Collections.unmodifiableList(this.vF);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.vF.add(eVar);
        }
    }

    public e fD() {
        return this.vG;
    }

    public void b(e eVar) {
        this.vG = eVar;
    }
}
