package com.baidu.ar.face.detector;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.ar.face.algo.FaceJniClient;
import com.baidu.ar.statistic.StatisticApi;
import java.nio.ByteBuffer;
/* loaded from: classes14.dex */
class n extends a {
    private static final String TAG = n.class.getSimpleName();
    private long pu;

    public n(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    @Override // com.baidu.ar.face.detector.a
    void dG() {
        com.baidu.ar.b.a.ar().a(13, true);
        this.nL = FaceJniClient.trackFace(this.pu, this.nL, this.lQ);
        com.baidu.ar.g.b.c(TAG, "detect_frame track task executing");
        Log.e("vvv", "face track: " + this.lQ + "   ,  " + this.pu);
        com.baidu.ar.b.a.ar().a(13, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.ar.face.detector.a
    public void dH() {
        super.dH();
        int i = 0;
        if (this.nL != null && this.nL.getFaceFrame() != null && this.nL.getFaceFrame().getFaceBoxes() != null) {
            i = this.nL.getFaceFrame().getFaceBoxes().size();
        }
        StatisticApi.getPerformanceApi().recordAlgoTimeCost("face", ARPScriptEnvironment.KEY_DATA_PIP_TRACK, SystemClock.elapsedRealtime() - this.nP, i);
        if (this.nN != null) {
            this.nN.c(this.nQ);
        }
    }

    @Override // com.baidu.ar.face.detector.a
    public void dK() {
        super.dK();
        this.pu = this.nM.eb();
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
