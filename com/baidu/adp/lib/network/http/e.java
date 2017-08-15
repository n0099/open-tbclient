package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f xm = new f();
    protected g xn = new g();
    private LinkedList<d> xo = new LinkedList<>();
    private d xp = null;

    public f fJ() {
        return this.xm;
    }

    public g fK() {
        return this.xn;
    }

    public List<d> fL() {
        return Collections.unmodifiableList(this.xo);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.xo.add(dVar);
        }
    }

    public d fM() {
        return this.xp;
    }

    public void b(d dVar) {
        this.xp = dVar;
    }
}
