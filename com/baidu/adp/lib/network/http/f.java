package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    protected g vH = new g();
    protected h vI = new h();
    private LinkedList<e> vJ = new LinkedList<>();
    private e vK = null;

    public g fB() {
        return this.vH;
    }

    public h fC() {
        return this.vI;
    }

    public List<e> fD() {
        return Collections.unmodifiableList(this.vJ);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.vJ.add(eVar);
        }
    }

    public e fE() {
        return this.vK;
    }

    public void b(e eVar) {
        this.vK = eVar;
    }
}
