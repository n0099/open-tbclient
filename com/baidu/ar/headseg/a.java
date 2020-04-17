package com.baidu.ar.headseg;

import android.os.Bundle;
import android.os.SystemClock;
import com.baidu.ar.arplay.core.engine.pixel.PixelType;
import com.baidu.ar.b.b.c;
import com.baidu.ar.databasic.AlgoHandleAdapter;
import com.baidu.ar.mdl.ARMdlInterfaceJNI;
import com.baidu.ar.statistic.StatisticApi;
import java.nio.ByteBuffer;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a extends com.baidu.ar.b.a.b {
    private static final String TAG = a.class.getSimpleName();
    private int pg = 256;
    private int ph = 144;
    private int cF = 8;
    private float pi = 0.5f;

    public a() {
        this.lP.setPixelType(PixelType.NV21);
        this.lP.setOutputWidth(this.pg);
        this.lP.setOutputHeight(this.ph);
    }

    @Override // com.baidu.ar.b.a.b
    public com.baidu.ar.b.b.b a(final ByteBuffer byteBuffer, final int i, final int i2, final long j, final boolean z, int i3, int i4) {
        return new com.baidu.ar.b.b.b(this.cF) { // from class: com.baidu.ar.headseg.a.3
            @Override // com.baidu.ar.b.b.b
            public HashMap am() {
                HashMap hashMap = new HashMap();
                hashMap.put("timestamp", Long.valueOf(j));
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j2 = 0;
                try {
                    j2 = a.this.bU.createHandle();
                    a.this.bU.setUsingHandle(j2);
                    a.this.bU.setHandleInput(j2, 22, j, 0, i, i2, z, z ? 4 : 7, true, byteBuffer);
                    a.this.bU.setHandleMaskThreshold(j2, a.this.pi);
                    ARMdlInterfaceJNI.predictHeadSeg(j2, true);
                    StatisticApi.getPerformanceApi().recordAlgoTimeCost("head_seg", "predict", SystemClock.elapsedRealtime() - elapsedRealtime, 0);
                    a.this.bU.setUsingHandle(0L);
                    hashMap.put("handle", Long.valueOf(j2));
                } catch (Exception e) {
                    if (j2 > 0) {
                        AlgoHandleAdapter.destroyHandle(j2);
                    }
                    hashMap.put("handle", 0L);
                }
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
        return this.cF;
    }

    @Override // com.baidu.ar.b.a.b
    public com.baidu.ar.b.b.a ah() {
        return new com.baidu.ar.b.b.a(this.cF) { // from class: com.baidu.ar.headseg.a.2
            @Override // com.baidu.ar.b.b.a
            public boolean al() {
                ARMdlInterfaceJNI.releaseHeadSeg();
                return true;
            }
        };
    }

    @Override // com.baidu.ar.b.a.b
    public c b(Bundle bundle) {
        return new c(this.cF) { // from class: com.baidu.ar.headseg.a.1
            @Override // com.baidu.ar.b.b.c
            public int a(com.baidu.ar.mdl.a aVar) {
                String str = aVar.rF[0];
                return aVar.rE ? ARMdlInterfaceJNI.initHeadSegFromAsset(str) : ARMdlInterfaceJNI.initHeadSeg(str);
            }
        };
    }

    @Override // com.baidu.ar.b.a.a
    public void e(HashMap hashMap) {
        b bVar = new b(getName(), hashMap.get("handle") != null ? ((Long) hashMap.get("handle")).longValue() : 0L, ((Long) hashMap.get("timestamp")).longValue());
        if (this.lb != null) {
            this.lb.a(bVar);
        }
    }

    @Override // com.baidu.ar.c.k
    public String getName() {
        return TAG;
    }
}
