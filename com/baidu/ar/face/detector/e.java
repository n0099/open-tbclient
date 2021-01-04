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
/* loaded from: classes6.dex */
class e extends a {
    private static final String TAG = e.class.getSimpleName();
    private FaceAlgoConfig op;
    private FAUImage oq;
    private AlgoHandleController or;

    public e(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public void a(int i, int i2, boolean z, int i3, boolean z2, long j) {
        dJ();
        this.or = this.oc.dY();
        if (this.oc.ee() && this.or != null) {
            this.oh = this.or.createHandle();
            this.oc.dY().setHandleInput(this.oh, 10, j, 2, i, i2, z, i3, z2, this.oe);
        }
        this.oq = new FAUImage(this.oe, i, i2, 2);
    }

    @Override // com.baidu.ar.face.detector.a
    void dF() {
        com.baidu.ar.h.b.l(TAG, "detect_frame track task executing before createFrame");
        this.mf = FaceJniClient.createFrame(this.oq);
        this.ob = new FaceAlgoData();
        this.ob.setAlgoConfig(this.op);
        this.ob.setFaceFrame(new FaceFrame());
        if (this.or == null || this.oh <= 0) {
            return;
        }
        this.or.setHandleFaceHandle(this.oh, this.mf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.ar.face.detector.a
    public void dG() {
        super.dG();
        StatisticApi.getPerformanceApi().recordAlgoTimeCost("face", "create", SystemClock.elapsedRealtime() - this.of, 1);
        if (this.od != null) {
            this.od.b(this.og);
        }
    }

    @Override // com.baidu.ar.face.detector.a
    public void dJ() {
        super.dJ();
        this.op = this.oc.ec().cloneInstance();
    }

    public long dN() {
        return this.oh;
    }
}
