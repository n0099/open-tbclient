package com.baidu.adp.lib.network.http;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    protected f vm = new f();
    protected g vn = new g();
    private LinkedList<d> vo = new LinkedList<>();
    private d vp = null;

    public f ha() {
        return this.vm;
    }

    public g hb() {
        return this.vn;
    }

    public List<d> hc() {
        return Collections.unmodifiableList(this.vo);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.vo.add(dVar);
        }
    }

    public d hd() {
        return this.vp;
    }

    public void b(d dVar) {
        this.vp = dVar;
    }
}
