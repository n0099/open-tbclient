package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f ajn = new f();
    protected g ajo = new g();
    private LinkedList<d> ajp = new LinkedList<>();
    private d ajq = null;

    public f nb() {
        return this.ajn;
    }

    public g nc() {
        return this.ajo;
    }

    public List<d> nd() {
        return Collections.unmodifiableList(this.ajp);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.ajp.add(dVar);
        }
    }

    public d ne() {
        return this.ajq;
    }

    public void b(d dVar) {
        this.ajq = dVar;
    }
}
