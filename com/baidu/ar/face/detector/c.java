package com.baidu.ar.face.detector;

import android.os.SystemClock;
import com.baidu.ar.face.algo.FaceAlgoData;
import com.baidu.ar.face.algo.FaceJniClient;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.searchbox.ugc.transcoder.interfaces.UgcTranscoderConstant;
/* loaded from: classes.dex */
public class c extends a {
    public static final String TAG = "c";
    public long om;
    public int on;

    @Override // com.baidu.ar.face.detector.a
    public void dF() {
        com.baidu.ar.b.a.as().a(14, true);
        FaceAlgoData animateFace = FaceJniClient.animateFace(this.om, this.ob, this.mf);
        this.ob = animateFace;
        if (animateFace.getFaceFrame().getTriggersList() != null) {
            String str = TAG;
            com.baidu.ar.h.b.k(str, "detect_frame animate task executing triggers size:" + this.ob.getFaceFrame().getTriggersList().size());
        }
        com.baidu.ar.b.a.as().a(14, false);
    }

    @Override // com.baidu.ar.face.detector.a
    public void dG() {
        super.dG();
        FaceAlgoData faceAlgoData = this.ob;
        if (faceAlgoData != null && faceAlgoData.getFaceFrame() != null) {
            if (this.ob.getFaceFrame().getProcessResult() != 200) {
                this.on = 0;
            }
            if (this.ob.getFaceFrame().getFaceBoxes() != null) {
                int size = this.ob.getFaceFrame().getFaceBoxes().size();
                this.on = size;
                if (size > 4) {
                    this.on = 4;
                }
            }
        }
        StatisticApi.getPerformanceApi().recordAlgoTimeCost(UgcTranscoderConstant.URL_GET_FACE, "animate", SystemClock.elapsedRealtime() - this.of, 1);
        k kVar = this.od;
        if (kVar != null) {
            kVar.d(this.og);
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
