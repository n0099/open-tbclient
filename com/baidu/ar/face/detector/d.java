package com.baidu.ar.face.detector;

import android.util.Log;
/* loaded from: classes14.dex */
public class d extends com.baidu.ar.c.a {
    private static final String TAG = d.class.getSimpleName();
    private String nT = "face_animate";
    a nY;

    public d(n nVar) {
        this.nY = nVar;
        setPriority(10);
    }

    public void X(String str) {
        this.nT = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.ar.c.a
    /* renamed from: dN */
    public c ax() {
        Log.d(TAG, "detect_frame animate task before execute");
        c cVar = new c();
        cVar.a(this.nY.nL);
        cVar.i(this.nY.lQ);
        cVar.nR = this.nY.nR;
        cVar.a(this.nY.nM);
        cVar.timestamp = this.nY.timestamp;
        cVar.nS = this.nY.nS;
        cVar.nO = this.nY.nO;
        cVar.nT = this.nT;
        cVar.dK();
        cVar.dI();
        Log.d(TAG, "detect_frame animate task after execute");
        cVar.nM.dY().C(cVar.dM());
        if (cVar.nL != null) {
            return cVar;
        }
        return null;
    }

    @Override // com.baidu.ar.c.a
    public String getTag() {
        return this.nT;
    }
}
