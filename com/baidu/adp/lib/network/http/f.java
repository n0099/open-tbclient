package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    protected g wa = new g();
    protected h wb = new h();
    private LinkedList<e> wc = new LinkedList<>();
    private e wd = null;

    public g fv() {
        return this.wa;
    }

    public h fw() {
        return this.wb;
    }

    public List<e> fx() {
        return Collections.unmodifiableList(this.wc);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.wc.add(eVar);
        }
    }

    public e fy() {
        return this.wd;
    }

    public void b(e eVar) {
        this.wd = eVar;
    }
}
