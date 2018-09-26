package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f Ch = new f();
    protected g Ci = new g();
    private LinkedList<d> Cj = new LinkedList<>();
    private d Ck = null;

    public f jc() {
        return this.Ch;
    }

    public g jd() {
        return this.Ci;
    }

    public List<d> je() {
        return Collections.unmodifiableList(this.Cj);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.Cj.add(dVar);
        }
    }

    public d jf() {
        return this.Ck;
    }

    public void b(d dVar) {
        this.Ck = dVar;
    }
}
