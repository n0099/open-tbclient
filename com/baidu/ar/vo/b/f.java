package com.baidu.ar.vo.b;
/* loaded from: classes3.dex */
public class f extends com.baidu.ar.c.b {
    private g xI;

    public f(long j) {
        this.xI = null;
        setTimestamp(j);
    }

    public f(g gVar) {
        this.xI = gVar;
        if (gVar != null) {
            setTimestamp(gVar.getTimestamp());
        }
    }

    public g fU() {
        return this.xI;
    }
}
