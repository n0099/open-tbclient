package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    protected g om = new g();
    protected h oo = new h();
    private LinkedList<e> oq = new LinkedList<>();
    private e or = null;

    public g en() {
        return this.om;
    }

    public h eo() {
        return this.oo;
    }

    public List<e> ep() {
        return Collections.unmodifiableList(this.oq);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.oq.add(eVar);
        }
    }

    public e eq() {
        return this.or;
    }

    public void b(e eVar) {
        this.or = eVar;
    }
}
