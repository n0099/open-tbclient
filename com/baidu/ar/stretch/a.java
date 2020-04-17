package com.baidu.ar.stretch;

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
    private int cF = -1;

    public a() {
        this.lP = new PixelReadParams(PixelType.BGR);
        this.lP.setOutputWidth(640);
        this.lP.setOutputHeight(360);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g(int i, boolean z) {
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

    @Override // com.baidu.ar.b.a.b
    public com.baidu.ar.b.b.b a(final ByteBuffer byteBuffer, final int i, final int i2, final long j, final boolean z, final int i3, int i4) {
        com.baidu.ar.b.a.ac().b(this.cF);
        return new com.baidu.ar.b.b.b(this.cF) { // from class: com.baidu.ar.stretch.a.3
            @Override // com.baidu.ar.b.b.b
            public HashMap am() {
                int g = a.this.g(i3, z);
                HashMap hashMap = new HashMap();
                hashMap.put("timestamp", Long.valueOf(j));
                float[] fArr = new float[54];
                long elapsedRealtime = SystemClock.elapsedRealtime();
                ARMdlInterfaceJNI.predictBodyKeyPoint(byteBuffer, i, i2, g, fArr);
                StatisticApi.getPerformanceApi().recordAlgoTimeCost("body_beauty", "predict", SystemClock.elapsedRealtime() - elapsedRealtime, 0);
                hashMap.put("bodyKeyPoints", fArr);
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
        return -1;
    }

    @Override // com.baidu.ar.b.a.b
    public com.baidu.ar.b.b.a ah() {
        return new com.baidu.ar.b.b.a(this.cF) { // from class: com.baidu.ar.stretch.a.2
            @Override // com.baidu.ar.b.b.a
            public boolean al() {
                ARMdlInterfaceJNI.releaseBodyKeyPoint();
                return true;
            }
        };
    }

    @Override // com.baidu.ar.b.a.b
    public c b(Bundle bundle) {
        return new c(this.cF) { // from class: com.baidu.ar.stretch.a.1
            @Override // com.baidu.ar.b.b.c
            public int a(com.baidu.ar.mdl.a aVar) {
                String[] strArr = aVar.rF;
                if (strArr == null || strArr.length == 0) {
                    return -1;
                }
                return aVar.rE ? ARMdlInterfaceJNI.initBodyKeyPointFromAssetDir(strArr[0]) : ARMdlInterfaceJNI.initBodyKeyPoint(strArr[0]);
            }
        };
    }

    @Override // com.baidu.ar.b.a.a
    public void e(HashMap hashMap) {
        long longValue = ((Long) hashMap.get("timestamp")).longValue();
        b bVar = new b(getName(), (float[]) hashMap.get("bodyKeyPoints"), longValue);
        if (this.lb != null) {
            this.lb.a(bVar);
        }
    }

    @Override // com.baidu.ar.c.k
    public String getName() {
        return TAG;
    }
}
