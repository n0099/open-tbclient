package com.baidu.ar.hand;

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
import com.baidu.ar.mdl.ARMdlInterfaceJNI;
import com.baidu.ar.statistic.StatisticApi;
/* loaded from: classes.dex */
public class HandDetector extends com.baidu.ar.b.a.a {
    public static final String TAG = "HandDetector";
    public int oU = 7;

    public HandDetector() {
        c.cd().a(this);
        PixelReadParams pixelReadParams = new PixelReadParams(PixelType.NV21);
        this.nk = pixelReadParams;
        pixelReadParams.setOutputWidth(640);
        this.nk.setOutputHeight(360);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(int i, boolean z) {
        if (i != -90) {
            if (i != 90) {
                if (i != 180) {
                    if (z) {
                        return 3;
                    }
                } else if (!z) {
                    return 3;
                }
                return 1;
            }
            return 2;
        }
        return 0;
    }

    @Override // com.baidu.ar.b.a.a
    public b a(Bundle bundle) {
        return new b(this.oU) { // from class: com.baidu.ar.hand.HandDetector.1
            @Override // com.baidu.ar.b.b.b
            public int a(com.baidu.ar.mdl.a aVar) {
                boolean z = aVar.f1031tv;
                String[] strArr = aVar.tw;
                return z ? ARMdlInterfaceJNI.initHandSkeletonFromAsset(strArr[0], strArr[1]) : ARMdlInterfaceJNI.initHandSkeleton(strArr[0], strArr[1]);
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                return "hand";
            }
        };
    }

    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    public void ao() {
        e eVar = this.mv;
        if (eVar != null) {
            eVar.a(new l(getName(), true, 19));
        }
    }

    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    public void aq() {
        e eVar = this.mv;
        if (eVar != null) {
            eVar.b(new l(getName(), true, 19));
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
    public int au() {
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
        e eVar = this.mv;
        if (eVar != null) {
            eVar.a(aVar);
        }
    }
}
