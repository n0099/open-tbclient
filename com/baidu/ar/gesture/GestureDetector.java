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
import com.baidu.ar.d.e;
import com.baidu.ar.mdl.ARMdlInterfaceJNI;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.searchbox.appframework.AppFrameworkConstants;
/* loaded from: classes.dex */
public class GestureDetector extends com.baidu.ar.b.a.a {
    public static final String TAG = "GestureDetector";
    public int oU = 1;

    public GestureDetector() {
        c.cd().a(this);
        PixelReadParams pixelReadParams = new PixelReadParams(PixelType.BGR);
        this.nk = pixelReadParams;
        pixelReadParams.setOutputWidth(320);
        this.nk.setOutputHeight(180);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0013 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0010 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int c(int i, boolean z) {
        if (i == -90) {
            return 0;
        }
        if (i != 0) {
            if (i != 90) {
                return (i == 180 ? !z : z) ? -90 : 90;
            }
            return 180;
        } else if (z) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(Bundle bundle) {
        if (bundle == null) {
            return 1;
        }
        String string = bundle.getString(HttpConstants.FUNCTION_TYPE, AppFrameworkConstants.VALUE_GESTURE_BACK);
        if (AppFrameworkConstants.VALUE_GESTURE_BACK.equals(string)) {
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
                return aVar.f1031tv ? ARMdlInterfaceJNI.initGestureFromAsset(strArr[0], strArr[1], strArr[2], GestureDetector.this.c(bundle), i, f, f2, f3, 1) : ARMdlInterfaceJNI.initGesture(strArr[0], strArr[1], strArr[2], GestureDetector.this.c(bundle), i, f, f2, f3, 1);
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                return GestureDetector.TAG;
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
        return new com.baidu.ar.b.b.a(this.oU) { // from class: com.baidu.ar.gesture.GestureDetector.2
            @Override // com.baidu.ar.b.b.a
            public int ax() {
                return ARMdlInterfaceJNI.releaseGesture();
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                return GestureDetector.TAG;
            }
        };
    }

    @Override // com.baidu.ar.b.a.a
    public int au() {
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
                return GestureDetector.TAG;
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
