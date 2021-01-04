package com.baidu.ar.face.detector;

import android.os.SystemClock;
import com.baidu.ar.face.algo.FaceJniClient;
import com.baidu.ar.statistic.StatisticApi;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
class f extends a {
    private static final String TAG = f.class.getSimpleName();
    protected long os;
    private long time;

    public f(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.ar.face.detector.a
    public void dE() {
        super.dE();
    }

    @Override // com.baidu.ar.face.detector.a
    void dF() {
        com.baidu.ar.b.a.as().a(12, true);
        this.time = System.currentTimeMillis();
        this.ob = FaceJniClient.detectFace(this.os, this.ob, this.mf);
        com.baidu.ar.h.b.k(TAG, "detect-time= " + (System.currentTimeMillis() - this.time));
        com.baidu.ar.h.b.l(TAG, "detect_frame detect task executing faceboxes：" + this.ob.getFaceFrame().getFaceBoxes());
        com.baidu.ar.b.a.as().a(12, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.ar.face.detector.a
    public void dG() {
        super.dG();
        int i = 0;
        if (this.ob != null && this.ob.getFaceFrame() != null && this.ob.getFaceFrame().getFaceBoxes() != null) {
            i = this.ob.getFaceFrame().getFaceBoxes().size();
        }
        StatisticApi.getPerformanceApi().recordAlgoTimeCost("face", "detect", SystemClock.elapsedRealtime() - this.of, i);
        if (this.od != null) {
            this.od.a(this.og);
        }
    }

    @Override // com.baidu.ar.face.detector.a
    public void dJ() {
        super.dJ();
        this.os = this.oc.dZ();
    }

    public void p(long j) {
        this.oh = j;
    }

    public void setFrontCamera(boolean z) {
        this.oi = z;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }
}
