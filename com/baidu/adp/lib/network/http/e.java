package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f ajt = new f();
    protected g aju = new g();
    private LinkedList<d> ajv = new LinkedList<>();
    private d ajw = null;

    public f nb() {
        return this.ajt;
    }

    public g nc() {
        return this.aju;
    }

    public List<d> nd() {
        return Collections.unmodifiableList(this.ajv);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.ajv.add(dVar);
        }
    }

    public d ne() {
        return this.ajw;
    }

    public void b(d dVar) {
        this.ajw = dVar;
    }
}
