package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f aju = new f();
    protected g ajv = new g();
    private LinkedList<d> ajw = new LinkedList<>();
    private d ajx = null;

    public f nb() {
        return this.aju;
    }

    public g nc() {
        return this.ajv;
    }

    public List<d> nd() {
        return Collections.unmodifiableList(this.ajw);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.ajw.add(dVar);
        }
    }

    public d ne() {
        return this.ajx;
    }

    public void b(d dVar) {
        this.ajx = dVar;
    }
}
