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
/* loaded from: classes11.dex */
public class a extends com.baidu.ar.b.a.b {
    private static final String TAG = a.class.getSimpleName();
    static int[] sx = {2, 3, 4, 8, 9, 10, 14, 16};
    static int[] sy = {5, 6, 7, 11, 12, 13, 15, 17};
    private int cS = 0;
    private boolean sw = true;

    /* JADX INFO: Access modifiers changed from: private */
    public int b(int i, boolean z) {
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
            float f = fArr[sx[i] * 3];
            float f2 = fArr[(sx[i] * 3) + 1];
            float f3 = fArr[(sx[i] * 3) + 2];
            fArr[sx[i] * 3] = fArr[sy[i] * 3];
            fArr[(sx[i] * 3) + 1] = fArr[(sy[i] * 3) + 1];
            fArr[(sx[i] * 3) + 2] = fArr[(sy[i] * 3) + 2];
            fArr[sy[i] * 3] = f;
            fArr[(sy[i] * 3) + 1] = f2;
            fArr[(sy[i] * 3) + 2] = f3;
        }
    }

    public void J(boolean z) {
        this.sw = z;
    }

    @Override // com.baidu.ar.b.a.b
    public com.baidu.ar.b.b.b a(final ByteBuffer byteBuffer, final int i, final int i2, final long j, final boolean z, final int i3, int i4) {
        com.baidu.ar.b.a.aq().c(this.cS);
        return new com.baidu.ar.b.b.b(this.cS) { // from class: com.baidu.ar.pose.a.3
            @Override // com.baidu.ar.b.b.b
            public HashMap aA() {
                int b = a.this.sw ? a.this.b(i3, z) : 180;
                HashMap hashMap = new HashMap();
                hashMap.put("timestamp", Long.valueOf(j));
                float[] fArr = new float[54];
                long elapsedRealtime = SystemClock.elapsedRealtime();
                ARMdlInterfaceJNI.predictPose(byteBuffer, i, i2, b, z, fArr);
                StatisticApi.getPerformanceApi().recordAlgoTimeCost("body_pose", "predict", SystemClock.elapsedRealtime() - elapsedRealtime, 0);
                if (z) {
                    a.n(fArr);
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
    public void ar() {
    }

    @Override // com.baidu.ar.b.a.a
    public void as() {
    }

    @Override // com.baidu.ar.b.a.b
    protected int at() {
        return 0;
    }

    @Override // com.baidu.ar.b.a.b
    public com.baidu.ar.b.b.a av() {
        return new com.baidu.ar.b.b.a(this.cS) { // from class: com.baidu.ar.pose.a.2
            @Override // com.baidu.ar.b.b.a
            public boolean az() {
                ARMdlInterfaceJNI.releasePose();
                return true;
            }
        };
    }

    @Override // com.baidu.ar.b.a.b
    public c b(final Bundle bundle) {
        return new c(this.cS) { // from class: com.baidu.ar.pose.a.1
            @Override // com.baidu.ar.b.b.c
            public int a(com.baidu.ar.mdl.a aVar) {
                String[] strArr = aVar.se;
                if (strArr == null || strArr.length == 0) {
                    return -1;
                }
                float f = bundle.getFloat(PoseAR.MDL_MAGIC_FILTER_CUTOFFSLOPE, 1.0f);
                float[] floatArray = bundle.getFloatArray(PoseAR.MDL_MAGIC_FILTER_MIN_CUTOFFFREQ);
                return aVar.sd ? ARMdlInterfaceJNI.initPoseFromAsset(strArr[0], strArr[1], strArr[2], 1, f, floatArray, floatArray) : ARMdlInterfaceJNI.initPose(strArr[0], strArr[1], strArr[2], 1, f, floatArray, floatArray);
            }
        };
    }

    @Override // com.baidu.ar.b.a.a
    public void e(HashMap hashMap) {
        long longValue = ((Long) hashMap.get("timestamp")).longValue();
        b bVar = new b(getName(), (float[]) hashMap.get("bodyPoints"), longValue);
        if (this.ly != null) {
            this.ly.a(bVar);
        }
    }

    public void g(int i, int i2) {
        this.mm = new PixelReadParams(PixelType.BGR);
        this.mm.setOutputWidth(i);
        this.mm.setOutputHeight(i2);
    }

    @Override // com.baidu.ar.c.k
    public String getName() {
        return TAG;
    }
}
