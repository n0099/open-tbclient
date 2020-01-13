package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f rb = new f();
    protected g rd = new g();
    private LinkedList<d> re = new LinkedList<>();
    private d rf = null;

    public f fX() {
        return this.rb;
    }

    public g fY() {
        return this.rd;
    }

    public List<d> fZ() {
        return Collections.unmodifiableList(this.re);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.re.add(dVar);
        }
    }

    public d ga() {
        return this.rf;
    }

    public void b(d dVar) {
        this.rf = dVar;
    }
}
