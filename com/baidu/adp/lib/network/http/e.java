package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f tO = new f();
    protected g tP = new g();
    private LinkedList<d> tQ = new LinkedList<>();
    private d tR = null;

    public f fe() {
        return this.tO;
    }

    public g ff() {
        return this.tP;
    }

    public List<d> fg() {
        return Collections.unmodifiableList(this.tQ);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.tQ.add(dVar);
        }
    }

    public d fh() {
        return this.tR;
    }

    public void b(d dVar) {
        this.tR = dVar;
    }
}
