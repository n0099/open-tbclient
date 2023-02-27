package com.baidu.ar.face.detector;

import android.util.Log;
/* loaded from: classes.dex */
public class d extends com.baidu.ar.c.a {
    public static final String TAG = d.class.getSimpleName();
    public String oj = "face_animate";
    public a oo;

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
        a aVar = this.oo;
        cVar.oh = aVar.oh;
        cVar.a(aVar.oc);
        a aVar2 = this.oo;
        cVar.timestamp = aVar2.timestamp;
        cVar.oi = aVar2.oi;
        cVar.oe = aVar2.oe;
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
