package com.baidu.ar.hand;

import android.os.Bundle;
import android.os.SystemClock;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.engine.pixel.PixelType;
import com.baidu.ar.b.b.c;
import com.baidu.ar.c.l;
import com.baidu.ar.mdl.ARMdlInterfaceJNI;
import com.baidu.ar.statistic.StatisticApi;
import java.nio.ByteBuffer;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class a extends com.baidu.ar.b.a.b {
    private static final String TAG = a.class.getSimpleName();
    private int cS = 7;

    public a() {
        this.mm = new PixelReadParams(PixelType.NV21);
        this.mm.setOutputWidth(640);
        this.mm.setOutputHeight(360);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(int i, boolean z) {
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
        com.baidu.ar.b.a.aq().c(this.cS);
        return new com.baidu.ar.b.b.b(this.cS) { // from class: com.baidu.ar.hand.a.3
            @Override // com.baidu.ar.b.b.b
            public HashMap aA() {
                int c = a.this.c(i3, z);
                HashMap hashMap = new HashMap();
                hashMap.put("timestamp", Long.valueOf(j));
                long elapsedRealtime = SystemClock.elapsedRealtime();
                try {
                    long createHandle = a.this.ch.createHandle();
                    a.this.ch.setHandleInput(createHandle, 19, j, 0, i, i2, z, i4, false, byteBuffer);
                    ARMdlInterfaceJNI.predictHandSkeletonByHandle(createHandle, c);
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

    @Override // com.baidu.ar.b.a.b, com.baidu.ar.c.j
    protected void al() {
        if (this.ly != null) {
            this.ly.a(new l(getName(), true, 19));
        }
    }

    @Override // com.baidu.ar.b.a.b, com.baidu.ar.c.j
    protected void an() {
        if (this.ly != null) {
            this.ly.b(new l(getName(), true, 19));
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
        return new com.baidu.ar.b.b.a(this.cS) { // from class: com.baidu.ar.hand.a.2
            @Override // com.baidu.ar.b.b.a
            public boolean az() {
                ARMdlInterfaceJNI.releaseHandSkeleton();
                return true;
            }
        };
    }

    @Override // com.baidu.ar.b.a.b
    public c b(Bundle bundle) {
        return new c(this.cS) { // from class: com.baidu.ar.hand.a.1
            @Override // com.baidu.ar.b.b.c
            public int a(com.baidu.ar.mdl.a aVar) {
                return aVar.sd ? ARMdlInterfaceJNI.initHandSkeletonFromAsset(aVar.se[0], aVar.se[1]) : ARMdlInterfaceJNI.initHandSkeleton(aVar.se[0], aVar.se[1]);
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
