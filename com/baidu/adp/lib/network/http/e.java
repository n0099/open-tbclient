package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f vb = new f();
    protected g vc = new g();
    private LinkedList<d> vd = new LinkedList<>();

    public f gY() {
        return this.vb;
    }

    public g gZ() {
        return this.vc;
    }

    public List<d> ha() {
        return Collections.unmodifiableList(this.vd);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.vd.add(dVar);
        }
    }
}
