package com.baidu.ar.face.detector;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.ar.face.algo.FaceJniClient;
import com.baidu.ar.statistic.StatisticApi;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
class n extends a {
    private static final String TAG = n.class.getSimpleName();
    private long pK;
    private long time;

    public n(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    @Override // com.baidu.ar.face.detector.a
    void dF() {
        com.baidu.ar.b.a.as().a(13, true);
        this.time = System.currentTimeMillis();
        this.ob = FaceJniClient.trackFace(this.pK, this.ob, this.mf);
        com.baidu.ar.h.b.k(TAG, "track-time= " + (System.currentTimeMillis() - this.time));
        com.baidu.ar.h.b.c(TAG, "detect_frame track task executing");
        Log.d("vvv", "face track: " + this.mf + "   ,  " + this.pK);
        com.baidu.ar.b.a.as().a(13, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.ar.face.detector.a
    public void dG() {
        super.dG();
        int i = 0;
        if (this.ob != null && this.ob.getFaceFrame() != null && this.ob.getFaceFrame().getFaceBoxes() != null) {
            i = this.ob.getFaceFrame().getFaceBoxes().size();
        }
        StatisticApi.getPerformanceApi().recordAlgoTimeCost("face", ARPScriptEnvironment.KEY_DATA_PIP_TRACK, SystemClock.elapsedRealtime() - this.of, i);
        if (this.od != null) {
            this.od.c(this.og);
        }
    }

    @Override // com.baidu.ar.face.detector.a
    public void dJ() {
        super.dJ();
        this.pK = this.oc.ea();
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
