package com.baidu.ar.stretch;

import android.os.Bundle;
import android.os.SystemClock;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.ar.arplay.core.engine.pixel.FramePixels;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.engine.pixel.PixelType;
import com.baidu.ar.b.b.b;
import com.baidu.ar.bus.CallBack;
import com.baidu.ar.c.c;
import com.baidu.ar.mdl.ARMdlInterfaceJNI;
import com.baidu.ar.statistic.StatisticApi;
/* loaded from: classes12.dex */
public class StretchDetector extends com.baidu.ar.b.a.a {
    private static final String TAG = StretchDetector.class.getSimpleName();
    private int oE = -1;

    public StretchDetector() {
        c.ce().a(this);
        this.mU = new PixelReadParams(PixelType.BGR);
        this.mU.setOutputWidth(640);
        this.mU.setOutputHeight(EncoderTextureDrawer.X264_WIDTH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int i(int i, boolean z) {
        switch (i) {
            case -90:
                return z ? 0 : 2;
            case 0:
                return !z ? 1 : 3;
            case 90:
                return z ? 2 : 0;
            case 180:
                return z ? 1 : 3;
            default:
                return 1;
        }
    }

    @Override // com.baidu.ar.b.a.a
    public b a(Bundle bundle) {
        return new b(this.oE) { // from class: com.baidu.ar.stretch.StretchDetector.1
            @Override // com.baidu.ar.b.b.b
            public int a(com.baidu.ar.mdl.a aVar) {
                String[] strArr = aVar.sJ;
                if (strArr == null || strArr.length == 0) {
                    return -1;
                }
                return aVar.sI ? ARMdlInterfaceJNI.initBodyKeyPointFromAssetDir(strArr[0]) : ARMdlInterfaceJNI.initBodyKeyPoint(strArr[0]);
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                return "stretch";
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    public void ao() {
        super.ao();
        c.ce().b(this);
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.a as() {
        return new com.baidu.ar.b.b.a(this.oE) { // from class: com.baidu.ar.stretch.StretchDetector.2
            @Override // com.baidu.ar.b.b.a
            public int aw() {
                return ARMdlInterfaceJNI.releaseBodyKeyPoint();
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                return "stretch";
            }
        };
    }

    @Override // com.baidu.ar.b.a.a
    protected int at() {
        return -1;
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.c e(FramePixels framePixels) {
        return new com.baidu.ar.b.b.c(this.oE, framePixels) { // from class: com.baidu.ar.stretch.StretchDetector.3
            @Override // com.baidu.ar.c.a
            public String getTag() {
                return "stretch";
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.ar.b.b.c
            /* renamed from: m */
            public a f(FramePixels framePixels2) {
                int i = StretchDetector.this.i(framePixels2.getOrientation().getDegree(), framePixels2.isFrontCamera());
                a aVar = new a();
                aVar.setTimestamp(framePixels2.getTimestamp());
                aVar.T(StretchDetector.this.getName());
                float[] fArr = new float[54];
                long elapsedRealtime = SystemClock.elapsedRealtime();
                ARMdlInterfaceJNI.predictBodyKeyPoint(framePixels2.getPixelsAddress(), framePixels2.getWidth(), framePixels2.getHeight(), i, fArr);
                StatisticApi.getPerformanceApi().recordAlgoTimeCost("body_beauty", "predict", SystemClock.elapsedRealtime() - elapsedRealtime, 0);
                aVar.p(fArr);
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
