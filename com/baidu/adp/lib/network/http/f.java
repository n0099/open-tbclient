package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    protected g lY = new g();
    protected h lZ = new h();
    private LinkedList<e> ma = new LinkedList<>();
    private e mb = null;

    public g du() {
        return this.lY;
    }

    public h dv() {
        return this.lZ;
    }

    public List<e> dw() {
        return Collections.unmodifiableList(this.ma);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.ma.add(eVar);
        }
    }

    public e dx() {
        return this.mb;
    }

    public void b(e eVar) {
        this.mb = eVar;
    }
}
