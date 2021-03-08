package com.baidu.ar.vo.b;
/* loaded from: classes3.dex */
public class f extends com.baidu.ar.d.b {
    private g yW;

    public f(long j) {
        this.yW = null;
        setTimestamp(j);
    }

    public f(g gVar) {
        this.yW = gVar;
        if (gVar != null) {
            setTimestamp(gVar.getTimestamp());
        }
    }

    public g hj() {
        return this.yW;
    }
}
