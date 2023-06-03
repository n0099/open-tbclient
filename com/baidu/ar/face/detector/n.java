package com.baidu.ar.face.detector;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.ar.face.algo.FaceAlgoData;
import com.baidu.ar.face.algo.FaceJniClient;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.searchbox.ugc.transcoder.interfaces.UgcTranscoderConstant;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class n extends a {
    public static final String TAG = "n";
    public long pK;
    public long time;

    public n(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    @Override // com.baidu.ar.face.detector.a
    public void dF() {
        com.baidu.ar.b.a.as().a(13, true);
        this.time = System.currentTimeMillis();
        this.ob = FaceJniClient.trackFace(this.pK, this.ob, this.mf);
        String str = TAG;
        com.baidu.ar.h.b.k(str, "track-time= " + (System.currentTimeMillis() - this.time));
        com.baidu.ar.h.b.c(TAG, "detect_frame track task executing");
        Log.d("vvv", "face track: " + this.mf + "   ,  " + this.pK);
        com.baidu.ar.b.a.as().a(13, false);
    }

    @Override // com.baidu.ar.face.detector.a
    public void dG() {
        super.dG();
        FaceAlgoData faceAlgoData = this.ob;
        StatisticApi.getPerformanceApi().recordAlgoTimeCost(UgcTranscoderConstant.URL_GET_FACE, ARPScriptEnvironment.KEY_DATA_PIP_TRACK, SystemClock.elapsedRealtime() - this.of, (faceAlgoData == null || faceAlgoData.getFaceFrame() == null || this.ob.getFaceFrame().getFaceBoxes() == null) ? 0 : this.ob.getFaceFrame().getFaceBoxes().size());
        k kVar = this.od;
        if (kVar != null) {
            kVar.c(this.og);
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
