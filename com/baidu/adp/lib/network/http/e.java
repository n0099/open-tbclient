package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f zS = new f();
    protected g zT = new g();
    private LinkedList<d> zU = new LinkedList<>();
    private d zV = null;

    public f hV() {
        return this.zS;
    }

    public g hW() {
        return this.zT;
    }

    public List<d> hX() {
        return Collections.unmodifiableList(this.zU);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.zU.add(dVar);
        }
    }

    public d hY() {
        return this.zV;
    }

    public void b(d dVar) {
        this.zV = dVar;
    }
}
