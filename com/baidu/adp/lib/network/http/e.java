package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f oH = new f();
    protected g oI = new g();
    private LinkedList<d> oJ = new LinkedList<>();
    private d oK = null;

    public f fJ() {
        return this.oH;
    }

    public g fK() {
        return this.oI;
    }

    public List<d> fL() {
        return Collections.unmodifiableList(this.oJ);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.oJ.add(dVar);
        }
    }

    public d fM() {
        return this.oK;
    }

    public void b(d dVar) {
        this.oK = dVar;
    }
}
