package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f Mq = new f();
    protected g Mr = new g();
    private LinkedList<d> Ms = new LinkedList<>();
    private d Mt = null;

    public f lU() {
        return this.Mq;
    }

    public g lV() {
        return this.Mr;
    }

    public List<d> lW() {
        return Collections.unmodifiableList(this.Ms);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.Ms.add(dVar);
        }
    }

    public d lX() {
        return this.Mt;
    }

    public void b(d dVar) {
        this.Mt = dVar;
    }
}
