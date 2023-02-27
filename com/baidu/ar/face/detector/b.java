package com.baidu.ar.face.detector;
/* loaded from: classes.dex */
public class b extends com.baidu.ar.c.a {
    public static final String TAG = d.class.getSimpleName();
    public String oj = "additional_thread";
    public c ok;
    public m ol;

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
        m mVar = this.ol;
        if (mVar != null) {
            return mVar;
        }
        c cVar = this.ok;
        return com.baidu.ar.face.c.a(cVar.ob, cVar.og, cVar.mf, cVar.oh, cVar.oe, cVar.timestamp, cVar.oi);
    }

    @Override // com.baidu.ar.c.a
    public String getTag() {
        return this.oj;
    }
}
