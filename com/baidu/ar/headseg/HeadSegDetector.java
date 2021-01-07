package com.baidu.ar.headseg;

import android.os.Bundle;
import android.os.SystemClock;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelType;
import com.baidu.ar.b.b.b;
import com.baidu.ar.bus.CallBack;
import com.baidu.ar.c.c;
import com.baidu.ar.d.l;
import com.baidu.ar.databasic.AlgoHandleAdapter;
import com.baidu.ar.mdl.ARMdlInterfaceJNI;
import com.baidu.ar.statistic.StatisticApi;
/* loaded from: classes6.dex */
public class HeadSegDetector extends com.baidu.ar.b.a.a {
    private static final String TAG = HeadSegDetector.class.getSimpleName();
    private int qB = 256;
    private int qC = 144;
    private int oU = 8;
    private float qD = 0.5f;

    public HeadSegDetector() {
        c.cd().a(this);
        this.nk = new PixelReadParams(PixelType.NV21);
        this.nk.setOutputWidth(this.qB);
        this.nk.setOutputHeight(this.qC);
    }

    @Override // com.baidu.ar.b.a.a
    public b a(Bundle bundle) {
        return new b(this.oU) { // from class: com.baidu.ar.headseg.HeadSegDetector.1
            @Override // com.baidu.ar.b.b.b
            public int a(com.baidu.ar.mdl.a aVar) {
                String str = aVar.tw[0];
                return aVar.f1487tv ? ARMdlInterfaceJNI.initHeadSegFromAsset(str) : ARMdlInterfaceJNI.initHeadSeg(str);
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                return "headseg";
            }
        };
    }

    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    protected void ao() {
        if (this.mv != null) {
            this.mv.a(new l(getName(), true, 22));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    public void aq() {
        if (this.mv != null) {
            this.mv.b(new l(getName(), true, 22));
        }
        c.cd().b(this);
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.a at() {
        return new com.baidu.ar.b.b.a(this.oU) { // from class: com.baidu.ar.headseg.HeadSegDetector.2
            @Override // com.baidu.ar.b.b.a
            public int ax() {
                return ARMdlInterfaceJNI.releaseHeadSeg();
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                return "headseg";
            }
        };
    }

    @Override // com.baidu.ar.b.a.a
    protected int au() {
        return this.oU;
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.c d(FramePixels framePixels) {
        return new com.baidu.ar.b.b.c(this.oU, framePixels) { // from class: com.baidu.ar.headseg.HeadSegDetector.3
            @Override // com.baidu.ar.c.a
            public String getTag() {
                return "headseg";
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.ar.b.b.c
            /* renamed from: h */
            public a e(FramePixels framePixels2) {
                a aVar = new a();
                aVar.setTimestamp(framePixels2.getTimestamp());
                aVar.W(HeadSegDetector.this.getName());
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j = 0;
                try {
                    j = HeadSegDetector.this.cb.createHandle();
                    HeadSegDetector.this.cb.setUsingHandle(j);
                    HeadSegDetector.this.cb.setHandleInput(j, 22, framePixels2.getTimestamp(), 0, framePixels2.getWidth(), framePixels2.getHeight(), framePixels2.isFrontCamera(), framePixels2.isFrontCamera() ? 4 : 7, true, framePixels2.getPixelsAddress());
                    HeadSegDetector.this.cb.setHandleMaskThreshold(j, HeadSegDetector.this.qD);
                    ARMdlInterfaceJNI.predictHeadSeg(j, true);
                    StatisticApi.getPerformanceApi().recordAlgoTimeCost("head_seg", "predict", SystemClock.elapsedRealtime() - elapsedRealtime, 0);
                    HeadSegDetector.this.cb.setUsingHandle(0L);
                } catch (Exception e) {
                    if (j > 0) {
                        AlgoHandleAdapter.destroyHandle(j);
                    }
                    j = 0;
                }
                aVar.n(j);
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
        if (this.mv != null) {
            this.mv.a(aVar);
        }
    }
}
