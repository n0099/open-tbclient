package com.baidu.live.alablmsdk.d;
/* loaded from: classes11.dex */
public class b {
    private c aCs;

    public b(c cVar) {
        this.aCs = cVar;
    }

    public void bd(boolean z) {
        if (this.aCs != null) {
            com.baidu.live.alablmsdk.a.b.a.aj("BLMRtcRoom muteMicrophone " + z, "");
            this.aCs.bd(z);
        }
    }
}
