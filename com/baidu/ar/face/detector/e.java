package com.baidu.ar.face.detector;

import android.os.SystemClock;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.face.algo.FAUImage;
import com.baidu.ar.face.algo.FaceAlgoConfig;
import com.baidu.ar.face.algo.FaceAlgoData;
import com.baidu.ar.face.algo.FaceFrame;
import com.baidu.ar.face.algo.FaceJniClient;
import com.baidu.ar.statistic.StatisticApi;
import java.nio.ByteBuffer;
/* loaded from: classes11.dex */
class e extends a {
    private static final String TAG = e.class.getSimpleName();
    private FaceAlgoConfig nZ;
    private FAUImage oa;
    private AlgoHandleController ob;

    public e(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public void a(int i, int i2, boolean z, int i3, boolean z2, long j) {
        dK();
        this.ob = this.nM.dZ();
        if (this.nM.ef() && this.ob != null) {
            this.nR = this.ob.createHandle();
            this.nM.dZ().setHandleInput(this.nR, 10, j, 2, i, i2, z, i3, z2, this.nO);
        }
        this.oa = new FAUImage(this.nO, i, i2, 2);
    }

    @Override // com.baidu.ar.face.detector.a
    void dG() {
        com.baidu.ar.g.b.l(TAG, "detect_frame track task executing before createFrame");
        this.lQ = FaceJniClient.createFrame(this.oa);
        this.nL = new FaceAlgoData();
        this.nL.setAlgoConfig(this.nZ);
        this.nL.setFaceFrame(new FaceFrame());
        if (this.ob == null || this.nR <= 0) {
            return;
        }
        this.ob.setHandleFaceHandle(this.nR, this.lQ);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.ar.face.detector.a
    public void dH() {
        super.dH();
        StatisticApi.getPerformanceApi().recordAlgoTimeCost("face", "create", SystemClock.elapsedRealtime() - this.nP, 1);
        if (this.nN != null) {
            this.nN.b(this.nQ);
        }
    }

    @Override // com.baidu.ar.face.detector.a
    public void dK() {
        super.dK();
        this.nZ = this.nM.ed().cloneInstance();
    }

    public long dO() {
        return this.nR;
    }
}
