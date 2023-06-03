package com.baidu.ar.face.detector;

import android.os.SystemClock;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.face.algo.FAUImage;
import com.baidu.ar.face.algo.FaceAlgoConfig;
import com.baidu.ar.face.algo.FaceAlgoData;
import com.baidu.ar.face.algo.FaceFrame;
import com.baidu.ar.face.algo.FaceJniClient;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.searchbox.ugc.transcoder.interfaces.UgcTranscoderConstant;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class e extends a {
    public static final String TAG = "e";
    public FaceAlgoConfig op;
    public FAUImage oq;
    public AlgoHandleController or;

    public e(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public void a(int i, int i2, boolean z, int i3, boolean z2, long j) {
        AlgoHandleController algoHandleController;
        dJ();
        this.or = this.oc.dY();
        if (this.oc.ee() && (algoHandleController = this.or) != null) {
            this.oh = algoHandleController.createHandle();
            this.oc.dY().setHandleInput(this.oh, 10, j, 2, i, i2, z, i3, z2, this.oe);
        }
        this.oq = new FAUImage(this.oe, i, i2, 2);
    }

    @Override // com.baidu.ar.face.detector.a
    public void dF() {
        com.baidu.ar.h.b.l(TAG, "detect_frame track task executing before createFrame");
        this.mf = FaceJniClient.createFrame(this.oq);
        FaceAlgoData faceAlgoData = new FaceAlgoData();
        this.ob = faceAlgoData;
        faceAlgoData.setAlgoConfig(this.op);
        this.ob.setFaceFrame(new FaceFrame());
        AlgoHandleController algoHandleController = this.or;
        if (algoHandleController != null) {
            long j = this.oh;
            if (j > 0) {
                algoHandleController.setHandleFaceHandle(j, this.mf);
            }
        }
    }

    @Override // com.baidu.ar.face.detector.a
    public void dG() {
        super.dG();
        StatisticApi.getPerformanceApi().recordAlgoTimeCost(UgcTranscoderConstant.URL_GET_FACE, "create", SystemClock.elapsedRealtime() - this.of, 1);
        k kVar = this.od;
        if (kVar != null) {
            kVar.b(this.og);
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
