package com.baidu.ar.pose;

import android.os.Bundle;
import android.os.SystemClock;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.engine.pixel.PixelType;
import com.baidu.ar.b.b.c;
import com.baidu.ar.mdl.ARMdlInterfaceJNI;
import com.baidu.ar.statistic.StatisticApi;
import java.nio.ByteBuffer;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a extends com.baidu.ar.b.a.b {
    private static final String TAG = a.class.getSimpleName();
    static int[] rX = {2, 3, 4, 8, 9, 10, 14, 16};
    static int[] rY = {5, 6, 7, 11, 12, 13, 15, 17};
    private int cF = 0;

    public a() {
        this.lP = new PixelReadParams(PixelType.BGR);
        this.lP.setOutputWidth(320);
        this.lP.setOutputHeight(180);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i, boolean z) {
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
    public static void m(float[] fArr) {
        for (int i = 0; i < 8; i++) {
            float f = fArr[rX[i] * 3];
            float f2 = fArr[(rX[i] * 3) + 1];
            float f3 = fArr[(rX[i] * 3) + 2];
            fArr[rX[i] * 3] = fArr[rY[i] * 3];
            fArr[(rX[i] * 3) + 1] = fArr[(rY[i] * 3) + 1];
            fArr[(rX[i] * 3) + 2] = fArr[(rY[i] * 3) + 2];
            fArr[rY[i] * 3] = f;
            fArr[(rY[i] * 3) + 1] = f2;
            fArr[(rY[i] * 3) + 2] = f3;
        }
    }

    @Override // com.baidu.ar.b.a.b
    public com.baidu.ar.b.b.b a(final ByteBuffer byteBuffer, final int i, final int i2, final long j, final boolean z, final int i3, int i4) {
        com.baidu.ar.b.a.ac().b(this.cF);
        return new com.baidu.ar.b.b.b(this.cF) { // from class: com.baidu.ar.pose.a.3
            @Override // com.baidu.ar.b.b.b
            public HashMap am() {
                int a = a.this.a(i3, z);
                HashMap hashMap = new HashMap();
                hashMap.put("timestamp", Long.valueOf(j));
                float[] fArr = new float[54];
                long elapsedRealtime = SystemClock.elapsedRealtime();
                ARMdlInterfaceJNI.predictPose(byteBuffer, i, i2, a, z, fArr);
                StatisticApi.getPerformanceApi().recordAlgoTimeCost("body_pose", "predict", SystemClock.elapsedRealtime() - elapsedRealtime, 0);
                if (z) {
                    a.m(fArr);
                    for (int i5 = 0; i5 < 18; i5++) {
                        fArr[(i5 * 3) + 1] = 1.0f - fArr[(i5 * 3) + 1];
                    }
                }
                hashMap.put("bodyPoints", fArr);
                return hashMap;
            }
        };
    }

    @Override // com.baidu.ar.b.a.a
    public void ad() {
    }

    @Override // com.baidu.ar.b.a.a
    public void ae() {
    }

    @Override // com.baidu.ar.b.a.b
    protected int af() {
        return 0;
    }

    @Override // com.baidu.ar.b.a.b
    public com.baidu.ar.b.b.a ah() {
        return new com.baidu.ar.b.b.a(this.cF) { // from class: com.baidu.ar.pose.a.2
            @Override // com.baidu.ar.b.b.a
            public boolean al() {
                ARMdlInterfaceJNI.releasePose();
                return true;
            }
        };
    }

    @Override // com.baidu.ar.b.a.b
    public c b(final Bundle bundle) {
        return new c(this.cF) { // from class: com.baidu.ar.pose.a.1
            @Override // com.baidu.ar.b.b.c
            public int a(com.baidu.ar.mdl.a aVar) {
                String[] strArr = aVar.rF;
                if (strArr == null || strArr.length == 0) {
                    return -1;
                }
                float f = bundle.getFloat(PoseAR.MDL_MAGIC_FILTER_CUTOFFSLOPE, 1.0f);
                float[] floatArray = bundle.getFloatArray(PoseAR.MDL_MAGIC_FILTER_MIN_CUTOFFFREQ);
                return aVar.rE ? ARMdlInterfaceJNI.initPoseFromAsset(strArr[0], strArr[1], strArr[2], 1, f, floatArray, floatArray) : ARMdlInterfaceJNI.initPose(strArr[0], strArr[1], strArr[2], 1, f, floatArray, floatArray);
            }
        };
    }

    @Override // com.baidu.ar.b.a.a
    public void e(HashMap hashMap) {
        long longValue = ((Long) hashMap.get("timestamp")).longValue();
        b bVar = new b(getName(), (float[]) hashMap.get("bodyPoints"), longValue);
        if (this.lb != null) {
            this.lb.a(bVar);
        }
    }

    @Override // com.baidu.ar.c.k
    public String getName() {
        return TAG;
    }
}
