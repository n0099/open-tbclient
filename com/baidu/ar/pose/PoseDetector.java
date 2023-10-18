package com.baidu.ar.pose;

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
/* loaded from: classes.dex */
public class PoseDetector extends com.baidu.ar.b.a.a {
    public static final String TAG = "PoseDetector";
    public static int[] tP = {2, 3, 4, 8, 9, 10, 14, 16};
    public static int[] tQ = {5, 6, 7, 11, 12, 13, 15, 17};
    public int oU = 0;
    public boolean tO = true;

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

    public static void m(float[] fArr) {
        for (int i = 0; i < 8; i++) {
            int[] iArr = tP;
            float f = fArr[iArr[i] * 3];
            float f2 = fArr[(iArr[i] * 3) + 1];
            float f3 = fArr[(iArr[i] * 3) + 2];
            int[] iArr2 = tQ;
            fArr[iArr[i] * 3] = fArr[iArr2[i] * 3];
            fArr[(iArr[i] * 3) + 1] = fArr[(iArr2[i] * 3) + 1];
            fArr[(iArr[i] * 3) + 2] = fArr[(iArr2[i] * 3) + 2];
            fArr[iArr2[i] * 3] = f;
            fArr[(iArr2[i] * 3) + 1] = f2;
            fArr[(iArr2[i] * 3) + 2] = f3;
        }
    }

    public void I(boolean z) {
        this.tO = z;
    }

    @Override // com.baidu.ar.b.a.a
    public b a(final Bundle bundle) {
        return new b(this.oU) { // from class: com.baidu.ar.pose.PoseDetector.1
            @Override // com.baidu.ar.b.b.b
            public int a(com.baidu.ar.mdl.a aVar) {
                String[] strArr = aVar.tw;
                if (strArr == null || strArr.length == 0) {
                    return -1;
                }
                float f = bundle.getFloat(PoseAR.MDL_MAGIC_FILTER_CUTOFFSLOPE, 1.0f);
                float[] floatArray = bundle.getFloatArray(PoseAR.MDL_MAGIC_FILTER_MIN_CUTOFFFREQ);
                return aVar.f1035tv ? ARMdlInterfaceJNI.initPoseFromAsset(strArr[0], strArr[1], strArr[2], 1, f, floatArray, floatArray) : ARMdlInterfaceJNI.initPose(strArr[0], strArr[1], strArr[2], 1, f, floatArray, floatArray);
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                return "pose";
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
        return new com.baidu.ar.b.b.a(this.oU) { // from class: com.baidu.ar.pose.PoseDetector.2
            @Override // com.baidu.ar.b.b.a
            public int ax() {
                return ARMdlInterfaceJNI.releasePose();
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                return "pose";
            }
        };
    }

    @Override // com.baidu.ar.b.a.a
    public int au() {
        return 0;
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.c d(FramePixels framePixels) {
        return new com.baidu.ar.b.b.c(this.oU, framePixels) { // from class: com.baidu.ar.pose.PoseDetector.3
            @Override // com.baidu.ar.c.a
            public String getTag() {
                return "pose";
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.ar.b.b.c
            /* renamed from: j */
            public a e(FramePixels framePixels2) {
                int c = framePixels2.isCameraFrame() ? PoseDetector.this.c(framePixels2.getOrientation().getDegree(), framePixels2.isFrontCamera()) : 180;
                long timestamp = framePixels2.getTimestamp();
                float[] fArr = new float[54];
                long elapsedRealtime = SystemClock.elapsedRealtime();
                ARMdlInterfaceJNI.predictPose(framePixels2.getPixelsAddress(), framePixels2.getWidth(), framePixels2.getHeight(), c, framePixels2.isFrontCamera(), fArr);
                StatisticApi.getPerformanceApi().recordAlgoTimeCost("body_pose", "predict", SystemClock.elapsedRealtime() - elapsedRealtime, 0);
                if (framePixels2.isFrontCamera()) {
                    PoseDetector.m(fArr);
                    for (int i = 0; i < 18; i++) {
                        int i2 = (i * 3) + 1;
                        fArr[i2] = 1.0f - fArr[i2];
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
        c.cd().a(this);
        PixelReadParams pixelReadParams = new PixelReadParams(PixelType.BGR);
        this.nk = pixelReadParams;
        pixelReadParams.setOutputWidth(i);
        this.nk.setOutputHeight(i2);
    }

    @CallBack
    public void onMdlResult(a aVar) {
        e eVar = this.mv;
        if (eVar != null) {
            eVar.a(aVar);
        }
    }
}
