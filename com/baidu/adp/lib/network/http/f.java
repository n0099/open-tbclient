package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    protected g lt = new g();
    protected h lu = new h();
    private LinkedList<e> lw = new LinkedList<>();
    private e lx = null;

    public g du() {
        return this.lt;
    }

    public h dv() {
        return this.lu;
    }

    public List<e> dw() {
        return Collections.unmodifiableList(this.lw);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.lw.add(eVar);
        }
    }

    public e dx() {
        return this.lx;
    }

    public void b(e eVar) {
        this.lx = eVar;
    }
}
