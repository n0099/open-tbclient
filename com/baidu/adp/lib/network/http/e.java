package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f vP = new f();
    protected g vQ = new g();
    private LinkedList<d> vR = new LinkedList<>();

    public f hm() {
        return this.vP;
    }

    public g hn() {
        return this.vQ;
    }

    public List<d> ho() {
        return Collections.unmodifiableList(this.vR);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.vR.add(dVar);
        }
    }
}
