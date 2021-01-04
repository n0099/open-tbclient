package com.baidu.ar.face.detector;

import android.os.SystemClock;
import com.baidu.ar.face.algo.FaceJniClient;
import com.baidu.ar.statistic.StatisticApi;
/* loaded from: classes6.dex */
class c extends a {
    private static final String TAG = c.class.getSimpleName();
    private long om;
    private int on;

    @Override // com.baidu.ar.face.detector.a
    void dF() {
        com.baidu.ar.b.a.as().a(14, true);
        this.ob = FaceJniClient.animateFace(this.om, this.ob, this.mf);
        if (this.ob.getFaceFrame().getTriggersList() != null) {
            com.baidu.ar.h.b.k(TAG, "detect_frame animate task executing triggers size:" + this.ob.getFaceFrame().getTriggersList().size());
        }
        com.baidu.ar.b.a.as().a(14, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.ar.face.detector.a
    public void dG() {
        super.dG();
        if (this.ob != null && this.ob.getFaceFrame() != null) {
            if (this.ob.getFaceFrame().getProcessResult() != 200) {
                this.on = 0;
            }
            if (this.ob.getFaceFrame().getFaceBoxes() != null) {
                this.on = this.ob.getFaceFrame().getFaceBoxes().size();
                if (this.on > 4) {
                    this.on = 4;
                }
            }
        }
        StatisticApi.getPerformanceApi().recordAlgoTimeCost("face", "animate", SystemClock.elapsedRealtime() - this.of, 1);
        if (this.od != null) {
            this.od.d(this.og);
        }
        this.oc.eg();
    }

    @Override // com.baidu.ar.face.detector.a
    public void dJ() {
        super.dJ();
        this.om = this.oc.eb();
    }

    public int dL() {
        return this.on;
    }
}
