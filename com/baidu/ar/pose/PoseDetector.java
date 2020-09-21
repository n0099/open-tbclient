package com.baidu.ar.pose;

import android.os.Bundle;
import android.os.SystemClock;
import com.baidu.ar.arplay.core.engine.pixel.FramePixels;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.engine.pixel.PixelType;
import com.baidu.ar.b.b.b;
import com.baidu.ar.bus.CallBack;
import com.baidu.ar.c.c;
import com.baidu.ar.mdl.ARMdlInterfaceJNI;
import com.baidu.ar.statistic.StatisticApi;
/* loaded from: classes10.dex */
public class PoseDetector extends com.baidu.ar.b.a.a {
    private static final String TAG = PoseDetector.class.getSimpleName();
    static int[] tc = {2, 3, 4, 8, 9, 10, 14, 16};
    static int[] td = {5, 6, 7, 11, 12, 13, 15, 17};
    private int oE = 0;
    private boolean tb = true;

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
    public static void n(float[] fArr) {
        for (int i = 0; i < 8; i++) {
            float f = fArr[tc[i] * 3];
            float f2 = fArr[(tc[i] * 3) + 1];
            float f3 = fArr[(tc[i] * 3) + 2];
            fArr[tc[i] * 3] = fArr[td[i] * 3];
            fArr[(tc[i] * 3) + 1] = fArr[(td[i] * 3) + 1];
            fArr[(tc[i] * 3) + 2] = fArr[(td[i] * 3) + 2];
            fArr[td[i] * 3] = f;
            fArr[(td[i] * 3) + 1] = f2;
            fArr[(td[i] * 3) + 2] = f3;
        }
    }

    public void K(boolean z) {
        this.tb = z;
    }

    @Override // com.baidu.ar.b.a.a
    public b a(final Bundle bundle) {
        return new b(this.oE) { // from class: com.baidu.ar.pose.PoseDetector.1
            @Override // com.baidu.ar.b.b.b
            public int a(com.baidu.ar.mdl.a aVar) {
                String[] strArr = aVar.sJ;
                if (strArr == null || strArr.length == 0) {
                    return -1;
                }
                float f = bundle.getFloat(PoseAR.MDL_MAGIC_FILTER_CUTOFFSLOPE, 1.0f);
                float[] floatArray = bundle.getFloatArray(PoseAR.MDL_MAGIC_FILTER_MIN_CUTOFFFREQ);
                return aVar.sI ? ARMdlInterfaceJNI.initPoseFromAsset(strArr[0], strArr[1], strArr[2], 1, f, floatArray, floatArray) : ARMdlInterfaceJNI.initPose(strArr[0], strArr[1], strArr[2], 1, f, floatArray, floatArray);
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                return "pose";
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
        return new com.baidu.ar.b.b.a(this.oE) { // from class: com.baidu.ar.pose.PoseDetector.2
            @Override // com.baidu.ar.b.b.a
            public int aw() {
                return ARMdlInterfaceJNI.releasePose();
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                return "pose";
            }
        };
    }

    @Override // com.baidu.ar.b.a.a
    protected int at() {
        return 0;
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.c e(FramePixels framePixels) {
        return new com.baidu.ar.b.b.c(this.oE, framePixels) { // from class: com.baidu.ar.pose.PoseDetector.3
            @Override // com.baidu.ar.c.a
            public String getTag() {
                return "pose";
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.ar.b.b.c
            /* renamed from: k */
            public a f(FramePixels framePixels2) {
                int c = framePixels2.isCameraFrame() ? PoseDetector.this.c(framePixels2.getOrientation().getDegree(), framePixels2.isFrontCamera()) : 180;
                long timestamp = framePixels2.getTimestamp();
                float[] fArr = new float[54];
                long elapsedRealtime = SystemClock.elapsedRealtime();
                ARMdlInterfaceJNI.predictPose(framePixels2.getPixelsAddress(), framePixels2.getWidth(), framePixels2.getHeight(), c, framePixels2.isFrontCamera(), fArr);
                StatisticApi.getPerformanceApi().recordAlgoTimeCost("body_pose", "predict", SystemClock.elapsedRealtime() - elapsedRealtime, 0);
                if (framePixels2.isFrontCamera()) {
                    PoseDetector.n(fArr);
                    for (int i = 0; i < 18; i++) {
                        fArr[(i * 3) + 1] = 1.0f - fArr[(i * 3) + 1];
                    }
                }
                return new a(PoseDetector.this.getName(), fArr, timestamp);
            }
        };
    }

    @Override // com.baidu.ar.d.k
    public String getName() {
        return TAG;
    }

    public void i(int i, int i2) {
        c.ce().a(this);
        this.mU = new PixelReadParams(PixelType.BGR);
        this.mU.setOutputWidth(i);
        this.mU.setOutputHeight(i2);
    }

    @CallBack
    public void onMdlResult(a aVar) {
        if (this.mg != null) {
            this.mg.a(aVar);
        }
    }
}
