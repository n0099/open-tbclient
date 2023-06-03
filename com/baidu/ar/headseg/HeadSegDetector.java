package com.baidu.ar.headseg;

import android.os.Bundle;
import android.os.SystemClock;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelType;
import com.baidu.ar.b.b.b;
import com.baidu.ar.bus.CallBack;
import com.baidu.ar.c.c;
import com.baidu.ar.d.e;
import com.baidu.ar.d.l;
import com.baidu.ar.databasic.AlgoHandleAdapter;
import com.baidu.ar.mdl.ARMdlInterfaceJNI;
import com.baidu.ar.statistic.StatisticApi;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
/* loaded from: classes.dex */
public class HeadSegDetector extends com.baidu.ar.b.a.a {
    public static final String TAG = "HeadSegDetector";
    public int qB = 256;
    public int qC = Cea708Decoder.COMMAND_SPA;
    public int oU = 8;
    public float qD = 0.5f;

    public HeadSegDetector() {
        c.cd().a(this);
        PixelReadParams pixelReadParams = new PixelReadParams(PixelType.NV21);
        this.nk = pixelReadParams;
        pixelReadParams.setOutputWidth(this.qB);
        this.nk.setOutputHeight(this.qC);
    }

    @Override // com.baidu.ar.b.a.a
    public b a(Bundle bundle) {
        return new b(this.oU) { // from class: com.baidu.ar.headseg.HeadSegDetector.1
            @Override // com.baidu.ar.b.b.b
            public int a(com.baidu.ar.mdl.a aVar) {
                String str = aVar.tw[0];
                return aVar.f1036tv ? ARMdlInterfaceJNI.initHeadSegFromAsset(str) : ARMdlInterfaceJNI.initHeadSeg(str);
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                return "headseg";
            }
        };
    }

    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    public void ao() {
        e eVar = this.mv;
        if (eVar != null) {
            eVar.a(new l(getName(), true, 22));
        }
    }

    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    public void aq() {
        e eVar = this.mv;
        if (eVar != null) {
            eVar.b(new l(getName(), true, 22));
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
    public int au() {
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
            /* JADX WARN: Removed duplicated region for block: B:21:0x00a9  */
            @Override // com.baidu.ar.b.b.c
            /* renamed from: h */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public a e(FramePixels framePixels2) {
                long j;
                long j2;
                long j3;
                a aVar = new a();
                aVar.setTimestamp(framePixels2.getTimestamp());
                aVar.W(HeadSegDetector.this.getName());
                long elapsedRealtime = SystemClock.elapsedRealtime();
                try {
                    j2 = HeadSegDetector.this.cb.createHandle();
                    try {
                        HeadSegDetector.this.cb.setUsingHandle(j2);
                        j3 = j2;
                    } catch (Exception unused) {
                    }
                    try {
                        HeadSegDetector.this.cb.setHandleInput(j2, 22, framePixels2.getTimestamp(), 0, framePixels2.getWidth(), framePixels2.getHeight(), framePixels2.isFrontCamera(), framePixels2.isFrontCamera() ? 4 : 7, true, framePixels2.getPixelsAddress());
                        HeadSegDetector.this.cb.setHandleMaskThreshold(j3, HeadSegDetector.this.qD);
                        ARMdlInterfaceJNI.predictHeadSeg(j3, true);
                        StatisticApi.getPerformanceApi().recordAlgoTimeCost("head_seg", "predict", SystemClock.elapsedRealtime() - elapsedRealtime, 0);
                    } catch (Exception unused2) {
                        j2 = j3;
                        j = 0;
                        if (j2 > j) {
                            AlgoHandleAdapter.destroyHandle(j2);
                        }
                        j3 = j;
                        aVar.n(j3);
                        return aVar;
                    }
                    try {
                        HeadSegDetector.this.cb.setUsingHandle(0L);
                    } catch (Exception unused3) {
                        j2 = j3;
                        j = 0;
                        if (j2 > j) {
                        }
                        j3 = j;
                        aVar.n(j3);
                        return aVar;
                    }
                } catch (Exception unused4) {
                    j = 0;
                    j2 = 0;
                }
                aVar.n(j3);
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
        e eVar = this.mv;
        if (eVar != null) {
            eVar.a(aVar);
        }
    }
}
