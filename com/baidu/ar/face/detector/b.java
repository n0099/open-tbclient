package com.baidu.ar.face.detector;
/* loaded from: classes3.dex */
public class b extends com.baidu.ar.c.a {
    private static final String TAG = d.class.getSimpleName();
    private String oj = "additional_thread";
    private c ok;
    private m ol;

    public b(c cVar) {
        this.ok = cVar;
        setPriority(10);
    }

    public b(m mVar) {
        this.ol = mVar;
        setPriority(10);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.ar.c.a
    /* renamed from: dK */
    public m ay() {
        return this.ol != null ? this.ol : com.baidu.ar.face.c.a(this.ok.ob, this.ok.og, this.ok.mf, this.ok.oh, this.ok.oe, this.ok.timestamp, this.ok.oi);
    }

    @Override // com.baidu.ar.c.a
    public String getTag() {
        return this.oj;
    }
}
