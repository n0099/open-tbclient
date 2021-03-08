package com.baidu.ar.face.detector;

import android.util.Log;
/* loaded from: classes3.dex */
public class d extends com.baidu.ar.c.a {
    private static final String TAG = d.class.getSimpleName();
    private String oj = "face_animate";
    a oo;

    public d(n nVar) {
        this.oo = nVar;
        setPriority(10);
    }

    public void aa(String str) {
        this.oj = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.ar.c.a
    /* renamed from: dM */
    public c ay() {
        Log.d(TAG, "detect_frame animate task before execute");
        c cVar = new c();
        cVar.a(this.oo.ob);
        cVar.g(this.oo.mf);
        cVar.oh = this.oo.oh;
        cVar.a(this.oo.oc);
        cVar.timestamp = this.oo.timestamp;
        cVar.oi = this.oo.oi;
        cVar.oe = this.oo.oe;
        cVar.oj = this.oj;
        cVar.dJ();
        cVar.dH();
        Log.d(TAG, "detect_frame animate task after execute");
        cVar.oc.dX().E(cVar.dL());
        if (cVar.ob != null) {
            return cVar;
        }
        return null;
    }

    @Override // com.baidu.ar.c.a
    public String getTag() {
        return this.oj;
    }
}
