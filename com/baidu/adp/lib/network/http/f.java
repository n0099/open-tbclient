package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    protected g ow = new g();
    protected h ox = new h();
    private LinkedList<e> oy = new LinkedList<>();
    private e oz = null;

    public g ep() {
        return this.ow;
    }

    public h eq() {
        return this.ox;
    }

    public List<e> er() {
        return Collections.unmodifiableList(this.oy);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.oy.add(eVar);
        }
    }

    public e es() {
        return this.oz;
    }

    public void b(e eVar) {
        this.oz = eVar;
    }
}
