package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f Mb = new f();
    protected g Mc = new g();
    private LinkedList<d> Md = new LinkedList<>();
    private d Me = null;

    public f mx() {
        return this.Mb;
    }

    public g my() {
        return this.Mc;
    }

    public List<d> mz() {
        return Collections.unmodifiableList(this.Md);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.Md.add(dVar);
        }
    }

    public d mA() {
        return this.Me;
    }

    public void b(d dVar) {
        this.Me = dVar;
    }
}
