package com.baidu.live.alablmsdk.d;
/* loaded from: classes4.dex */
public class b {
    private c aBi;

    public b(c cVar) {
        this.aBi = cVar;
    }

    public void aY(boolean z) {
        if (this.aBi != null) {
            com.baidu.live.alablmsdk.a.b.ah("BLMRtcRoom muteMicrophone " + z, "");
            this.aBi.aY(z);
        }
    }
}
