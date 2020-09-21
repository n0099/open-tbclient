package com.baidu.ar.headseg;

import android.os.Bundle;
import android.os.SystemClock;
import com.baidu.ar.arplay.core.engine.pixel.FramePixels;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.engine.pixel.PixelType;
import com.baidu.ar.b.b.b;
import com.baidu.ar.bus.CallBack;
import com.baidu.ar.c.c;
import com.baidu.ar.d.l;
import com.baidu.ar.databasic.AlgoHandleAdapter;
import com.baidu.ar.mdl.ARMdlInterfaceJNI;
import com.baidu.ar.statistic.StatisticApi;
/* loaded from: classes10.dex */
public class HeadSegDetector extends com.baidu.ar.b.a.a {
    private static final String TAG = HeadSegDetector.class.getSimpleName();
    private int ql = 256;
    private int qm = 144;
    private int oE = 8;
    private float qn = 0.5f;

    public HeadSegDetector() {
        c.ce().a(this);
        this.mU = new PixelReadParams(PixelType.NV21);
        this.mU.setOutputWidth(this.ql);
        this.mU.setOutputHeight(this.qm);
    }

    @Override // com.baidu.ar.b.a.a
    public b a(Bundle bundle) {
        return new b(this.oE) { // from class: com.baidu.ar.headseg.HeadSegDetector.1
            @Override // com.baidu.ar.b.b.b
            public int a(com.baidu.ar.mdl.a aVar) {
                String str = aVar.sJ[0];
                return aVar.sI ? ARMdlInterfaceJNI.initHeadSegFromAsset(str) : ARMdlInterfaceJNI.initHeadSeg(str);
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                return "headseg";
            }
        };
    }

    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    protected void am() {
        if (this.mg != null) {
            this.mg.a(new l(getName(), true, 22));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    public void ao() {
        if (this.mg != null) {
            this.mg.b(new l(getName(), true, 22));
        }
        c.ce().b(this);
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.a as() {
        return new com.baidu.ar.b.b.a(this.oE) { // from class: com.baidu.ar.headseg.HeadSegDetector.2
            @Override // com.baidu.ar.b.b.a
            public int aw() {
                return ARMdlInterfaceJNI.releaseHeadSeg();
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                return "headseg";
            }
        };
    }

    @Override // com.baidu.ar.b.a.a
    protected int at() {
        return this.oE;
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.c e(FramePixels framePixels) {
        return new com.baidu.ar.b.b.c(this.oE, framePixels) { // from class: com.baidu.ar.headseg.HeadSegDetector.3
            @Override // com.baidu.ar.c.a
            public String getTag() {
                return "headseg";
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.ar.b.b.c
            /* renamed from: i */
            public a f(FramePixels framePixels2) {
                a aVar = new a();
                aVar.setTimestamp(framePixels2.getTimestamp());
                aVar.T(HeadSegDetector.this.getName());
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j = 0;
                try {
                    j = HeadSegDetector.this.bY.createHandle();
                    HeadSegDetector.this.bY.setUsingHandle(j);
                    HeadSegDetector.this.bY.setHandleInput(j, 22, framePixels2.getTimestamp(), 0, framePixels2.getWidth(), framePixels2.getHeight(), framePixels2.isFrontCamera(), framePixels2.isFrontCamera() ? 4 : 7, true, framePixels2.getPixelsAddress());
                    HeadSegDetector.this.bY.setHandleMaskThreshold(j, HeadSegDetector.this.qn);
                    ARMdlInterfaceJNI.predictHeadSeg(j, true);
                    StatisticApi.getPerformanceApi().recordAlgoTimeCost("head_seg", "predict", SystemClock.elapsedRealtime() - elapsedRealtime, 0);
                    HeadSegDetector.this.bY.setUsingHandle(0L);
                } catch (Exception e) {
                    if (j > 0) {
                        AlgoHandleAdapter.destroyHandle(j);
                    }
                    j = 0;
                }
                aVar.p(j);
                return aVar;
            }
        };
    }

    @Override // com.baidu.ar.d.k
    public String getName() {
        return TAG;
    }

    @CallBack
    public void onMdlResult(a aVar) {
        if (this.mg != null) {
            this.mg.a(aVar);
        }
    }
}
