package com.baidu.ar.hand;

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
class a extends com.baidu.ar.b.a.b {
    private static final String TAG = a.class.getSimpleName();
    private int cF = 7;

    public a() {
        this.lP = new PixelReadParams(PixelType.NV21);
        this.lP.setOutputWidth(640);
        this.lP.setOutputHeight(360);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(int i, boolean z) {
        switch (i) {
            case -90:
                return 0;
            case 90:
                return 2;
            case 180:
                return !z ? 3 : 1;
            default:
                return z ? 3 : 1;
        }
    }

    @Override // com.baidu.ar.b.a.b
    public com.baidu.ar.b.b.b a(final ByteBuffer byteBuffer, final int i, final int i2, final long j, final boolean z, final int i3, final int i4) {
        com.baidu.ar.b.a.ac().b(this.cF);
        return new com.baidu.ar.b.b.b(this.cF) { // from class: com.baidu.ar.hand.a.3
            @Override // com.baidu.ar.b.b.b
            public HashMap am() {
                int b = a.this.b(i3, z);
                HashMap hashMap = new HashMap();
                hashMap.put("timestamp", Long.valueOf(j));
                long elapsedRealtime = SystemClock.elapsedRealtime();
                try {
                    long createHandle = a.this.bU.createHandle();
                    a.this.bU.setHandleInput(createHandle, 19, j, 0, i, i2, z, i4, false, byteBuffer);
                    ARMdlInterfaceJNI.predictHandSkeletonByHandle(createHandle, b);
                    StatisticApi.getPerformanceApi().recordAlgoTimeCost("finger_gesture", "predict", SystemClock.elapsedRealtime() - elapsedRealtime, 0);
                    hashMap.put("handle", Long.valueOf(createHandle));
                    return hashMap;
                } catch (Exception e) {
                    e.printStackTrace();
                    return hashMap;
                }
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
        return new com.baidu.ar.b.b.a(this.cF) { // from class: com.baidu.ar.hand.a.2
            @Override // com.baidu.ar.b.b.a
            public boolean al() {
                ARMdlInterfaceJNI.releaseHandSkeleton();
                return true;
            }
        };
    }

    @Override // com.baidu.ar.b.a.b
    public c b(Bundle bundle) {
        return new c(this.cF) { // from class: com.baidu.ar.hand.a.1
            @Override // com.baidu.ar.b.b.c
            public int a(com.baidu.ar.mdl.a aVar) {
                return aVar.rE ? ARMdlInterfaceJNI.initHandSkeletonFromAsset(aVar.rF[0], aVar.rF[1]) : ARMdlInterfaceJNI.initHandSkeleton(aVar.rF[0], aVar.rF[1]);
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
