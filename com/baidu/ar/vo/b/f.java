package com.baidu.ar.vo.b;
/* loaded from: classes3.dex */
public class f extends com.baidu.ar.c.b {
    private g xi;

    public f(long j) {
        this.xi = null;
        setTimestamp(j);
    }

    public f(g gVar) {
        this.xi = gVar;
        if (gVar != null) {
            setTimestamp(gVar.getTimestamp());
        }
    }

    public g fE() {
        return this.xi;
    }
}
