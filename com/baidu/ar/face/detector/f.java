package com.baidu.ar.face.detector;

import android.os.SystemClock;
import com.baidu.ar.face.algo.FaceJniClient;
import com.baidu.ar.statistic.StatisticApi;
import java.nio.ByteBuffer;
/* loaded from: classes14.dex */
class f extends a {
    private static final String TAG = f.class.getSimpleName();
    protected long oc;

    public f(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.ar.face.detector.a
    public void dF() {
        super.dF();
    }

    @Override // com.baidu.ar.face.detector.a
    void dG() {
        com.baidu.ar.b.a.ar().a(12, true);
        this.nL = FaceJniClient.detectFace(this.oc, this.nL, this.lQ);
        com.baidu.ar.g.b.l(TAG, "detect_frame detect task executing faceboxes：" + this.nL.getFaceFrame().getFaceBoxes());
        com.baidu.ar.b.a.ar().a(12, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.ar.face.detector.a
    public void dH() {
        super.dH();
        int i = 0;
        if (this.nL != null && this.nL.getFaceFrame() != null && this.nL.getFaceFrame().getFaceBoxes() != null) {
            i = this.nL.getFaceFrame().getFaceBoxes().size();
        }
        StatisticApi.getPerformanceApi().recordAlgoTimeCost("face", "detect", SystemClock.elapsedRealtime() - this.nP, i);
        if (this.nN != null) {
            this.nN.a(this.nQ);
        }
    }

    @Override // com.baidu.ar.face.detector.a
    public void dK() {
        super.dK();
        this.oc = this.nM.ea();
    }

    public void r(long j) {
        this.nR = j;
    }

    public void setFrontCamera(boolean z) {
        this.nS = z;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }
}
