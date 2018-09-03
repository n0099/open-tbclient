package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f zM = new f();
    protected g zN = new g();
    private LinkedList<d> zO = new LinkedList<>();
    private d zP = null;

    public f hW() {
        return this.zM;
    }

    public g hX() {
        return this.zN;
    }

    public List<d> hY() {
        return Collections.unmodifiableList(this.zO);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.zO.add(dVar);
        }
    }

    public d hZ() {
        return this.zP;
    }

    public void b(d dVar) {
        this.zP = dVar;
    }
}
