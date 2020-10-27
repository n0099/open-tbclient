package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f Mc = new f();
    protected g Md = new g();
    private LinkedList<d> Me = new LinkedList<>();
    private d Mf = null;

    public f mx() {
        return this.Mc;
    }

    public g my() {
        return this.Md;
    }

    public List<d> mz() {
        return Collections.unmodifiableList(this.Me);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.Me.add(dVar);
        }
    }

    public d mA() {
        return this.Mf;
    }

    public void b(d dVar) {
        this.Mf = dVar;
    }
}
