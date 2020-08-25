package com.baidu.ar.vo.b;
/* loaded from: classes11.dex */
public class f extends com.baidu.ar.d.b {
    private g yh;

    public f(long j) {
        this.yh = null;
        setTimestamp(j);
    }

    public f(g gVar) {
        this.yh = gVar;
        if (gVar != null) {
            setTimestamp(gVar.getTimestamp());
        }
    }

    public g hj() {
        return this.yh;
    }
}
