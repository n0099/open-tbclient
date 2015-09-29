package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f uV = new f();
    protected g uW = new g();
    private LinkedList<d> uX = new LinkedList<>();
    private d uY = null;

    public f gP() {
        return this.uV;
    }

    public g gQ() {
        return this.uW;
    }

    public List<d> gR() {
        return Collections.unmodifiableList(this.uX);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.uX.add(dVar);
        }
    }

    public d gS() {
        return this.uY;
    }

    public void b(d dVar) {
        this.uY = dVar;
    }
}
