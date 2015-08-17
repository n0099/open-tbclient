package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f uX = new f();
    protected g uY = new g();
    private LinkedList<d> uZ = new LinkedList<>();

    public f gS() {
        return this.uX;
    }

    public g gT() {
        return this.uY;
    }

    public List<d> gU() {
        return Collections.unmodifiableList(this.uZ);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.uZ.add(dVar);
        }
    }
}
