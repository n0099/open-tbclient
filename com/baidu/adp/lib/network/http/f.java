package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    protected g ov = new g();
    protected h ow = new h();
    private LinkedList<e> ox = new LinkedList<>();
    private e oy = null;

    public g ep() {
        return this.ov;
    }

    public h eq() {
        return this.ow;
    }

    public List<e> er() {
        return Collections.unmodifiableList(this.ox);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.ox.add(eVar);
        }
    }

    public e es() {
        return this.oy;
    }

    public void b(e eVar) {
        this.oy = eVar;
    }
}
