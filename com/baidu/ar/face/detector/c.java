package com.baidu.ar.face.detector;

import android.os.SystemClock;
import com.baidu.ar.face.algo.FaceJniClient;
import com.baidu.ar.statistic.StatisticApi;
/* loaded from: classes11.dex */
class c extends a {
    private static final String TAG = c.class.getSimpleName();
    private long nW;
    private int nX;

    @Override // com.baidu.ar.face.detector.a
    void dG() {
        com.baidu.ar.b.a.ar().a(14, true);
        this.nL = FaceJniClient.animateFace(this.nW, this.nL, this.lQ);
        if (this.nL.getFaceFrame().getTriggersList() != null) {
            com.baidu.ar.g.b.k(TAG, "detect_frame animate task executing triggers size:" + this.nL.getFaceFrame().getTriggersList().size());
        }
        com.baidu.ar.b.a.ar().a(14, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.ar.face.detector.a
    public void dH() {
        super.dH();
        if (this.nL != null && this.nL.getFaceFrame() != null) {
            if (this.nL.getFaceFrame().getProcessResult() != 200) {
                this.nX = 0;
            }
            if (this.nL.getFaceFrame().getFaceBoxes() != null) {
                this.nX = this.nL.getFaceFrame().getFaceBoxes().size();
                if (this.nX > 4) {
                    this.nX = 4;
                }
            }
        }
        StatisticApi.getPerformanceApi().recordAlgoTimeCost("face", "animate", SystemClock.elapsedRealtime() - this.nP, 1);
        if (this.nN != null) {
            this.nN.d(this.nQ);
        }
        this.nM.eh();
    }

    @Override // com.baidu.ar.face.detector.a
    public void dK() {
        super.dK();
        this.nW = this.nM.ec();
    }

    public int dM() {
        return this.nX;
    }
}
