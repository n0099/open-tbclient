package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f zL = new f();
    protected g zM = new g();
    private LinkedList<d> zN = new LinkedList<>();
    private d zO = null;

    public f hW() {
        return this.zL;
    }

    public g hX() {
        return this.zM;
    }

    public List<d> hY() {
        return Collections.unmodifiableList(this.zN);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.zN.add(dVar);
        }
    }

    public d hZ() {
        return this.zO;
    }

    public void b(d dVar) {
        this.zO = dVar;
    }
}
