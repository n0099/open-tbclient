package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    protected g vI = new g();
    protected h vJ = new h();
    private LinkedList<e> vK = new LinkedList<>();
    private e vL = null;

    public g fB() {
        return this.vI;
    }

    public h fC() {
        return this.vJ;
    }

    public List<e> fD() {
        return Collections.unmodifiableList(this.vK);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.vK.add(eVar);
        }
    }

    public e fE() {
        return this.vL;
    }

    public void b(e eVar) {
        this.vL = eVar;
    }
}
