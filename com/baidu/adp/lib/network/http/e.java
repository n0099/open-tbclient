package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f zQ = new f();
    protected g zR = new g();
    private LinkedList<d> zS = new LinkedList<>();
    private d zT = null;

    public f hV() {
        return this.zQ;
    }

    public g hW() {
        return this.zR;
    }

    public List<d> hX() {
        return Collections.unmodifiableList(this.zS);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.zS.add(dVar);
        }
    }

    public d hY() {
        return this.zT;
    }

    public void b(d dVar) {
        this.zT = dVar;
    }
}
