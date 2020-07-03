package com.baidu.ar.objdetect;

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
    private int cS = 6;

    public a() {
        this.mm = new PixelReadParams(PixelType.BGR);
        this.mm.setOutputWidth(640);
        this.mm.setOutputHeight(360);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(int i, boolean z) {
        switch (i) {
            case -90:
                return z ? 2 : 0;
            case 90:
                return !z ? 2 : 0;
            case 180:
                return z ? 1 : 3;
            default:
                return z ? 3 : 1;
        }
    }

    @Override // com.baidu.ar.b.a.b
    public com.baidu.ar.b.b.b a(final ByteBuffer byteBuffer, final int i, final int i2, final long j, final boolean z, final int i3, int i4) {
        com.baidu.ar.b.a.aq().c(this.cS);
        return new com.baidu.ar.b.b.b(this.cS) { // from class: com.baidu.ar.objdetect.a.3
            @Override // com.baidu.ar.b.b.b
            public HashMap aA() {
                int c = a.this.c(i3, z);
                HashMap hashMap = new HashMap();
                hashMap.put("timestamp", Long.valueOf(j));
                float[] fArr = new float[36];
                long elapsedRealtime = SystemClock.elapsedRealtime();
                ARMdlInterfaceJNI.predictObjDetect(byteBuffer, i, i2, c, z, fArr);
                StatisticApi.getPerformanceApi().recordAlgoTimeCost("obj_detect", "predict", SystemClock.elapsedRealtime() - elapsedRealtime, 0);
                hashMap.put("objDatas", fArr);
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
        return this.cS;
    }

    @Override // com.baidu.ar.b.a.b
    public com.baidu.ar.b.b.a av() {
        return new com.baidu.ar.b.b.a(this.cS) { // from class: com.baidu.ar.objdetect.a.2
            @Override // com.baidu.ar.b.b.a
            public boolean az() {
                ARMdlInterfaceJNI.releaseObjDetect();
                return true;
            }
        };
    }

    @Override // com.baidu.ar.b.a.b
    public c b(Bundle bundle) {
        return new c(this.cS) { // from class: com.baidu.ar.objdetect.a.1
            @Override // com.baidu.ar.b.b.c
            public int a(com.baidu.ar.mdl.a aVar) {
                String[] strArr = aVar.se;
                if (strArr == null || strArr.length == 0) {
                    return -1;
                }
                return aVar.sd ? ARMdlInterfaceJNI.initObjDetectFromAsset(strArr[0], strArr[1]) : ARMdlInterfaceJNI.initObjDetect(strArr[0], strArr[1]);
            }
        };
    }

    @Override // com.baidu.ar.b.a.a
    public void e(HashMap hashMap) {
        long longValue = ((Long) hashMap.get("timestamp")).longValue();
        b bVar = new b(getName(), (float[]) hashMap.get("objDatas"), longValue);
        if (this.ly != null) {
            this.ly.a(bVar);
        }
    }

    @Override // com.baidu.ar.c.k
    public String getName() {
        return TAG;
    }
}
