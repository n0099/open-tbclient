package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f tN = new f();
    protected g tO = new g();
    private LinkedList<d> tP = new LinkedList<>();
    private d tQ = null;

    public f fe() {
        return this.tN;
    }

    public g ff() {
        return this.tO;
    }

    public List<d> fg() {
        return Collections.unmodifiableList(this.tP);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.tP.add(dVar);
        }
    }

    public d fh() {
        return this.tQ;
    }

    public void b(d dVar) {
        this.tQ = dVar;
    }
}
