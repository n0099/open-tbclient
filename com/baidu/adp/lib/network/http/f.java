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

    public g fA() {
        return this.vH;
    }

    public h fB() {
        return this.vI;
    }

    public List<e> fC() {
        return Collections.unmodifiableList(this.vJ);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.vJ.add(eVar);
        }
    }

    public e fD() {
        return this.vK;
    }

    public void b(e eVar) {
        this.vK = eVar;
    }
}
