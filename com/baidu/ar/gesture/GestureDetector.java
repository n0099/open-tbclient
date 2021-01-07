package com.baidu.ar.gesture;

import android.os.Bundle;
import android.os.SystemClock;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelType;
import com.baidu.ar.b.b.b;
import com.baidu.ar.bus.CallBack;
import com.baidu.ar.c.c;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.mdl.ARMdlInterfaceJNI;
import com.baidu.ar.statistic.StatisticApi;
/* loaded from: classes6.dex */
public class GestureDetector extends com.baidu.ar.b.a.a {
    private static final String TAG = GestureDetector.class.getSimpleName();
    private int oU = 1;

    public GestureDetector() {
        c.cd().a(this);
        this.nk = new PixelReadParams(PixelType.BGR);
        this.nk.setOutputWidth(320);
        this.nk.setOutputHeight(180);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(int i, boolean z) {
        switch (i) {
            case -90:
                return 0;
            case 0:
                return !z ? 90 : -90;
            case 90:
                return 180;
            case 180:
                return z ? 90 : -90;
            default:
                return z ? -90 : 90;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(Bundle bundle) {
        if (bundle == null) {
            return 1;
        }
        String string = bundle.getString(HttpConstants.FUNCTION_TYPE, "gesture");
        if ("gesture".equals(string)) {
            return 1;
        }
        return "fingertip".equals(string) ? 2 : 0;
    }

    @Override // com.baidu.ar.b.a.a
    public b a(final Bundle bundle) {
        return new b(this.oU) { // from class: com.baidu.ar.gesture.GestureDetector.1
            @Override // com.baidu.ar.b.b.b
            public int a(com.baidu.ar.mdl.a aVar) {
                String[] strArr = aVar.tw;
                if (strArr == null || strArr.length == 0) {
                    return -1;
                }
                int i = bundle.getInt("force_ft_pose_flag", 0);
                float f = bundle.getFloat("det_thresh", 0.25f);
                float f2 = bundle.getFloat("first_cls_thresh", 0.75f);
                float f3 = bundle.getFloat("second_cls_thresh", 0.5f);
                return aVar.f1487tv ? ARMdlInterfaceJNI.initGestureFromAsset(strArr[0], strArr[1], strArr[2], GestureDetector.this.c(bundle), i, f, f2, f3, 1) : ARMdlInterfaceJNI.initGesture(strArr[0], strArr[1], strArr[2], GestureDetector.this.c(bundle), i, f, f2, f3, 1);
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                return "GestureDetector";
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    public void aq() {
        super.aq();
        c.cd().b(this);
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.a at() {
        return new com.baidu.ar.b.b.a(this.oU) { // from class: com.baidu.ar.gesture.GestureDetector.2
            @Override // com.baidu.ar.b.b.a
            public int ax() {
                return ARMdlInterfaceJNI.releaseGesture();
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                return "GestureDetector";
            }
        };
    }

    @Override // com.baidu.ar.b.a.a
    protected int au() {
        return this.oU;
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.c d(FramePixels framePixels) {
        return new com.baidu.ar.b.b.c<a>(this.oU, framePixels) { // from class: com.baidu.ar.gesture.GestureDetector.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.ar.b.b.c
            /* renamed from: f */
            public a e(FramePixels framePixels2) {
                int c = GestureDetector.this.c(framePixels2.getOrientation().getDegree(), framePixels2.isFrontCamera());
                long timestamp = framePixels2.getTimestamp();
                float[] fArr = new float[13];
                long elapsedRealtime = SystemClock.elapsedRealtime();
                ARMdlInterfaceJNI.predictGesture(framePixels2.getPixelsAddress(), framePixels2.getWidth(), framePixels2.getHeight(), c, framePixels2.isFrontCamera(), fArr);
                StatisticApi.getPerformanceApi().recordAlgoTimeCost("finger_gesture", "predict", SystemClock.elapsedRealtime() - elapsedRealtime, 0);
                return new a(GestureDetector.this.getName(), fArr, timestamp);
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                return "GestureDetector";
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
