package com.baidu.ar.face.detector;
/* loaded from: classes11.dex */
public class b extends com.baidu.ar.c.a {
    private static final String TAG = d.class.getSimpleName();
    private String nT = "additional_thread";
    private c nU;
    private m nV;

    public b(c cVar) {
        this.nU = cVar;
        setPriority(10);
    }

    public b(m mVar) {
        this.nV = mVar;
        setPriority(10);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.ar.c.a
    /* renamed from: dL */
    public m ax() {
        return this.nV != null ? this.nV : com.baidu.ar.face.c.a(this.nU.nL, this.nU.nQ, this.nU.lQ, this.nU.nR, this.nU.nO, this.nU.timestamp, this.nU.nS);
    }

    @Override // com.baidu.ar.c.a
    public String getTag() {
        return this.nT;
    }
}
