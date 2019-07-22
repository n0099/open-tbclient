package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f AH = new f();
    protected g AI = new g();
    private LinkedList<d> AJ = new LinkedList<>();
    private d AK = null;

    public f iu() {
        return this.AH;
    }

    public g iv() {
        return this.AI;
    }

    public List<d> iw() {
        return Collections.unmodifiableList(this.AJ);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.AJ.add(dVar);
        }
    }

    public d ix() {
        return this.AK;
    }

    public void b(d dVar) {
        this.AK = dVar;
    }
}
