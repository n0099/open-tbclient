package com.baidu.ar.face.detector;

import android.os.SystemClock;
import com.baidu.ar.face.algo.FaceAlgoData;
import com.baidu.ar.face.algo.FaceJniClient;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.pass.face.platform.ConstPath;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class f extends a {
    public static final String TAG = "f";
    public long os;
    public long time;

    public f(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    @Override // com.baidu.ar.face.detector.a
    public void dE() {
        super.dE();
    }

    @Override // com.baidu.ar.face.detector.a
    public void dF() {
        com.baidu.ar.b.a.as().a(12, true);
        this.time = System.currentTimeMillis();
        this.ob = FaceJniClient.detectFace(this.os, this.ob, this.mf);
        String str = TAG;
        com.baidu.ar.h.b.k(str, "detect-time= " + (System.currentTimeMillis() - this.time));
        String str2 = TAG;
        com.baidu.ar.h.b.l(str2, "detect_frame detect task executing faceboxes：" + this.ob.getFaceFrame().getFaceBoxes());
        com.baidu.ar.b.a.as().a(12, false);
    }

    @Override // com.baidu.ar.face.detector.a
    public void dG() {
        super.dG();
        FaceAlgoData faceAlgoData = this.ob;
        StatisticApi.getPerformanceApi().recordAlgoTimeCost("face", ConstPath.KEY_DETECT, SystemClock.elapsedRealtime() - this.of, (faceAlgoData == null || faceAlgoData.getFaceFrame() == null || this.ob.getFaceFrame().getFaceBoxes() == null) ? 0 : this.ob.getFaceFrame().getFaceBoxes().size());
        k kVar = this.od;
        if (kVar != null) {
            kVar.a(this.og);
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
