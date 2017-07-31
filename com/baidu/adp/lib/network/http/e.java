package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f xk = new f();
    protected g xl = new g();
    private LinkedList<d> xm = new LinkedList<>();
    private d xn = null;

    public f fJ() {
        return this.xk;
    }

    public g fK() {
        return this.xl;
    }

    public List<d> fL() {
        return Collections.unmodifiableList(this.xm);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.xm.add(dVar);
        }
    }

    public d fM() {
        return this.xn;
    }

    public void b(d dVar) {
        this.xn = dVar;
    }
}
