package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f ajr = new f();
    protected g ajs = new g();
    private LinkedList<d> ajt = new LinkedList<>();
    private d aju = null;

    public f na() {
        return this.ajr;
    }

    public g nb() {
        return this.ajs;
    }

    public List<d> nc() {
        return Collections.unmodifiableList(this.ajt);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.ajt.add(dVar);
        }
    }

    public d nd() {
        return this.aju;
    }

    public void b(d dVar) {
        this.aju = dVar;
    }
}
