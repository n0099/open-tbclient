package com.baidu.ar.hand;

import android.os.Bundle;
import android.os.SystemClock;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelType;
import com.baidu.ar.b.b.b;
import com.baidu.ar.bus.CallBack;
import com.baidu.ar.c.c;
import com.baidu.ar.d.l;
import com.baidu.ar.mdl.ARMdlInterfaceJNI;
import com.baidu.ar.statistic.StatisticApi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class HandDetector extends com.baidu.ar.b.a.a {
    private static final String TAG = HandDetector.class.getSimpleName();
    private int oU = 7;

    public HandDetector() {
        c.cd().a(this);
        this.nk = new PixelReadParams(PixelType.NV21);
        this.nk.setOutputWidth(640);
        this.nk.setOutputHeight(EncoderTextureDrawer.X264_WIDTH);
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
        return new b(this.oU) { // from class: com.baidu.ar.hand.HandDetector.1
            @Override // com.baidu.ar.b.b.b
            public int a(com.baidu.ar.mdl.a aVar) {
                return aVar.f1486tv ? ARMdlInterfaceJNI.initHandSkeletonFromAsset(aVar.tw[0], aVar.tw[1]) : ARMdlInterfaceJNI.initHandSkeleton(aVar.tw[0], aVar.tw[1]);
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                return "hand";
            }
        };
    }

    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    protected void ao() {
        if (this.mv != null) {
            this.mv.a(new l(getName(), true, 19));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    public void aq() {
        if (this.mv != null) {
            this.mv.b(new l(getName(), true, 19));
        }
        c.cd().b(this);
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.a at() {
        return new com.baidu.ar.b.b.a(this.oU) { // from class: com.baidu.ar.hand.HandDetector.2
            @Override // com.baidu.ar.b.b.a
            public int ax() {
                return ARMdlInterfaceJNI.releaseHandSkeleton();
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                return "hand";
            }
        };
    }

    @Override // com.baidu.ar.b.a.a
    protected int au() {
        return this.oU;
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.c d(final FramePixels framePixels) {
        return new com.baidu.ar.b.b.c(this.oU, framePixels) { // from class: com.baidu.ar.hand.HandDetector.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.ar.b.b.c
            /* renamed from: g */
            public a e(FramePixels framePixels2) {
                long timestamp = framePixels2.getTimestamp();
                int d = HandDetector.this.d(framePixels2.getOrientation().getDegree(), framePixels2.isFrontCamera());
                long elapsedRealtime = SystemClock.elapsedRealtime();
                try {
                    long createHandle = HandDetector.this.cb.createHandle();
                    HandDetector.this.cb.setHandleInput(createHandle, 19, framePixels2.getTimestamp(), 0, framePixels2.getWidth(), framePixels2.getHeight(), framePixels2.isFrontCamera(), framePixels2.getSegOrientation().getValue(), false, framePixels2.getPixelsAddress());
                    ARMdlInterfaceJNI.predictHandSkeletonByHandle(createHandle, d);
                    StatisticApi.getPerformanceApi().recordAlgoTimeCost("finger_gesture", "predict", SystemClock.elapsedRealtime() - elapsedRealtime, 0);
                    return new a(HandDetector.this.getName(), createHandle, timestamp);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                return "hand";
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
