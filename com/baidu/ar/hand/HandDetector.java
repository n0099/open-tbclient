package com.baidu.ar.hand;

import android.os.Bundle;
import android.os.SystemClock;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.ar.arplay.core.engine.pixel.FramePixels;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.engine.pixel.PixelType;
import com.baidu.ar.b.b.b;
import com.baidu.ar.bus.CallBack;
import com.baidu.ar.c.c;
import com.baidu.ar.d.l;
import com.baidu.ar.mdl.ARMdlInterfaceJNI;
import com.baidu.ar.statistic.StatisticApi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public class HandDetector extends com.baidu.ar.b.a.a {
    private static final String TAG = HandDetector.class.getSimpleName();
    private int oE = 7;

    public HandDetector() {
        c.ce().a(this);
        this.mU = new PixelReadParams(PixelType.NV21);
        this.mU.setOutputWidth(640);
        this.mU.setOutputHeight(EncoderTextureDrawer.X264_WIDTH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(int i, boolean z) {
        switch (i) {
            case -90:
                return 0;
            case 90:
                return 2;
            case 180:
                return !z ? 3 : 1;
            default:
                return z ? 3 : 1;
        }
    }

    @Override // com.baidu.ar.b.a.a
    public b a(Bundle bundle) {
        return new b(this.oE) { // from class: com.baidu.ar.hand.HandDetector.1
            @Override // com.baidu.ar.b.b.b
            public int a(com.baidu.ar.mdl.a aVar) {
                return aVar.sI ? ARMdlInterfaceJNI.initHandSkeletonFromAsset(aVar.sJ[0], aVar.sJ[1]) : ARMdlInterfaceJNI.initHandSkeleton(aVar.sJ[0], aVar.sJ[1]);
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                return "hand";
            }
        };
    }

    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    protected void am() {
        if (this.mg != null) {
            this.mg.a(new l(getName(), true, 19));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    public void ao() {
        if (this.mg != null) {
            this.mg.b(new l(getName(), true, 19));
        }
        c.ce().b(this);
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.a as() {
        return new com.baidu.ar.b.b.a(this.oE) { // from class: com.baidu.ar.hand.HandDetector.2
            @Override // com.baidu.ar.b.b.a
            public int aw() {
                return ARMdlInterfaceJNI.releaseHandSkeleton();
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                return "hand";
            }
        };
    }

    @Override // com.baidu.ar.b.a.a
    protected int at() {
        return this.oE;
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.c e(final FramePixels framePixels) {
        return new com.baidu.ar.b.b.c(this.oE, framePixels) { // from class: com.baidu.ar.hand.HandDetector.3
            @Override // com.baidu.ar.c.a
            public String getTag() {
                return "hand";
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.ar.b.b.c
            /* renamed from: h */
            public a f(FramePixels framePixels2) {
                long timestamp = framePixels2.getTimestamp();
                int d = HandDetector.this.d(framePixels2.getOrientation().getDegree(), framePixels2.isFrontCamera());
                long elapsedRealtime = SystemClock.elapsedRealtime();
                try {
                    long createHandle = HandDetector.this.bY.createHandle();
                    HandDetector.this.bY.setHandleInput(createHandle, 19, framePixels2.getTimestamp(), 0, framePixels2.getWidth(), framePixels2.getHeight(), framePixels2.isFrontCamera(), framePixels2.getSegOrientation().getValue(), false, framePixels2.getPixelsAddress());
                    ARMdlInterfaceJNI.predictHandSkeletonByHandle(createHandle, d);
                    StatisticApi.getPerformanceApi().recordAlgoTimeCost("finger_gesture", "predict", SystemClock.elapsedRealtime() - elapsedRealtime, 0);
                    return new a(HandDetector.this.getName(), createHandle, timestamp);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
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
