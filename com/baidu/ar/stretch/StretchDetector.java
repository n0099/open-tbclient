package com.baidu.ar.stretch;

import android.os.Bundle;
import android.os.SystemClock;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelType;
import com.baidu.ar.b.b.b;
import com.baidu.ar.bus.CallBack;
import com.baidu.ar.c.c;
import com.baidu.ar.d.e;
import com.baidu.ar.mdl.ARMdlInterfaceJNI;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
/* loaded from: classes3.dex */
public class StretchDetector extends com.baidu.ar.b.a.a {
    public static final String TAG = "StretchDetector";
    public int oU = -1;

    public StretchDetector() {
        c.cd().a(this);
        PixelReadParams pixelReadParams = new PixelReadParams(PixelType.BGR);
        this.nk = pixelReadParams;
        pixelReadParams.setOutputWidth(640);
        this.nk.setOutputHeight(360);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0018, code lost:
        if (r7 != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x001e, code lost:
        if (r7 != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0021, code lost:
        r1 = 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int i(int i, boolean z) {
        int i2 = 0;
        if (i != -90) {
            if (i != 0) {
                if (i != 90) {
                    if (i != 180 || z) {
                        return 1;
                    }
                }
            } else if (!z) {
                return 1;
            }
            return 3;
        }
        return i2;
    }

    @Override // com.baidu.ar.b.a.a
    public b a(Bundle bundle) {
        return new b(this.oU) { // from class: com.baidu.ar.stretch.StretchDetector.1
            @Override // com.baidu.ar.b.b.b
            public int a(com.baidu.ar.mdl.a aVar) {
                String[] strArr = aVar.tw;
                if (strArr == null || strArr.length == 0) {
                    return -1;
                }
                return aVar.f1035tv ? ARMdlInterfaceJNI.initBodyKeyPointFromAssetDir(strArr[0]) : ARMdlInterfaceJNI.initBodyKeyPoint(strArr[0]);
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                return CriusAttrConstants.STRETCH;
            }
        };
    }

    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    public void aq() {
        super.aq();
        c.cd().b(this);
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.a at() {
        return new com.baidu.ar.b.b.a(this.oU) { // from class: com.baidu.ar.stretch.StretchDetector.2
            @Override // com.baidu.ar.b.b.a
            public int ax() {
                return ARMdlInterfaceJNI.releaseBodyKeyPoint();
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                return CriusAttrConstants.STRETCH;
            }
        };
    }

    @Override // com.baidu.ar.b.a.a
    public int au() {
        return -1;
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.c d(FramePixels framePixels) {
        return new com.baidu.ar.b.b.c(this.oU, framePixels) { // from class: com.baidu.ar.stretch.StretchDetector.3
            @Override // com.baidu.ar.c.a
            public String getTag() {
                return CriusAttrConstants.STRETCH;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.ar.b.b.c
            /* renamed from: l */
            public a e(FramePixels framePixels2) {
                int i = StretchDetector.this.i(framePixels2.getOrientation().getDegree(), framePixels2.isFrontCamera());
                a aVar = new a();
                aVar.setTimestamp(framePixels2.getTimestamp());
                aVar.W(StretchDetector.this.getName());
                float[] fArr = new float[54];
                long elapsedRealtime = SystemClock.elapsedRealtime();
                ARMdlInterfaceJNI.predictBodyKeyPoint(framePixels2.getPixelsAddress(), framePixels2.getWidth(), framePixels2.getHeight(), i, fArr);
                StatisticApi.getPerformanceApi().recordAlgoTimeCost("body_beauty", "predict", SystemClock.elapsedRealtime() - elapsedRealtime, 0);
                aVar.o(fArr);
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
