package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f Kh = new f();
    protected g Ki = new g();
    private LinkedList<d> Kj = new LinkedList<>();
    private d Kk = null;

    public f kB() {
        return this.Kh;
    }

    public g kC() {
        return this.Ki;
    }

    public List<d> kD() {
        return Collections.unmodifiableList(this.Kj);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.Kj.add(dVar);
        }
    }

    public d kE() {
        return this.Kk;
    }

    public void b(d dVar) {
        this.Kk = dVar;
    }
}
