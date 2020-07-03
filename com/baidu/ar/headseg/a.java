package com.baidu.ar.headseg;

import android.os.Bundle;
import android.os.SystemClock;
import com.baidu.ar.arplay.core.engine.pixel.PixelType;
import com.baidu.ar.b.b.c;
import com.baidu.ar.c.l;
import com.baidu.ar.databasic.AlgoHandleAdapter;
import com.baidu.ar.mdl.ARMdlInterfaceJNI;
import com.baidu.ar.statistic.StatisticApi;
import java.nio.ByteBuffer;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a extends com.baidu.ar.b.a.b {
    private static final String TAG = a.class.getSimpleName();
    private int pF = 256;
    private int pG = 144;
    private int cS = 8;
    private float pH = 0.5f;

    public a() {
        this.mm.setPixelType(PixelType.NV21);
        this.mm.setOutputWidth(this.pF);
        this.mm.setOutputHeight(this.pG);
    }

    @Override // com.baidu.ar.b.a.b
    public com.baidu.ar.b.b.b a(final ByteBuffer byteBuffer, final int i, final int i2, final long j, final boolean z, int i3, int i4) {
        return new com.baidu.ar.b.b.b(this.cS) { // from class: com.baidu.ar.headseg.a.3
            @Override // com.baidu.ar.b.b.b
            public HashMap aA() {
                HashMap hashMap = new HashMap();
                hashMap.put("timestamp", Long.valueOf(j));
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j2 = 0;
                try {
                    j2 = a.this.ch.createHandle();
                    a.this.ch.setUsingHandle(j2);
                    a.this.ch.setHandleInput(j2, 22, j, 0, i, i2, z, z ? 4 : 7, true, byteBuffer);
                    a.this.ch.setHandleMaskThreshold(j2, a.this.pH);
                    ARMdlInterfaceJNI.predictHeadSeg(j2, true);
                    StatisticApi.getPerformanceApi().recordAlgoTimeCost("head_seg", "predict", SystemClock.elapsedRealtime() - elapsedRealtime, 0);
                    a.this.ch.setUsingHandle(0L);
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

    @Override // com.baidu.ar.b.a.b, com.baidu.ar.c.j
    protected void al() {
        if (this.ly != null) {
            this.ly.a(new l(getName(), true, 22));
        }
    }

    @Override // com.baidu.ar.b.a.b, com.baidu.ar.c.j
    protected void an() {
        if (this.ly != null) {
            this.ly.b(new l(getName(), true, 22));
        }
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
        return new com.baidu.ar.b.b.a(this.cS) { // from class: com.baidu.ar.headseg.a.2
            @Override // com.baidu.ar.b.b.a
            public boolean az() {
                ARMdlInterfaceJNI.releaseHeadSeg();
                return true;
            }
        };
    }

    @Override // com.baidu.ar.b.a.b
    public c b(Bundle bundle) {
        return new c(this.cS) { // from class: com.baidu.ar.headseg.a.1
            @Override // com.baidu.ar.b.b.c
            public int a(com.baidu.ar.mdl.a aVar) {
                String str = aVar.se[0];
                return aVar.sd ? ARMdlInterfaceJNI.initHeadSegFromAsset(str) : ARMdlInterfaceJNI.initHeadSeg(str);
            }
        };
    }

    @Override // com.baidu.ar.b.a.a
    public void e(HashMap hashMap) {
        b bVar = new b(getName(), hashMap.get("handle") != null ? ((Long) hashMap.get("handle")).longValue() : 0L, ((Long) hashMap.get("timestamp")).longValue());
        if (this.ly != null) {
            this.ly.a(bVar);
        }
    }

    @Override // com.baidu.ar.c.k
    public String getName() {
        return TAG;
    }
}
