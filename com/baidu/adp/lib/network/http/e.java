package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f Lw = new f();
    protected g Lx = new g();
    private LinkedList<d> Ly = new LinkedList<>();
    private d Lz = null;

    public f ms() {
        return this.Lw;
    }

    public g mt() {
        return this.Lx;
    }

    public List<d> mu() {
        return Collections.unmodifiableList(this.Ly);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.Ly.add(dVar);
        }
    }

    public d mv() {
        return this.Lz;
    }

    public void b(d dVar) {
        this.Lz = dVar;
    }
}
