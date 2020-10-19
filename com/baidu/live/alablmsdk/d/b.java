package com.baidu.live.alablmsdk.d;
/* loaded from: classes4.dex */
public class b {
    private c aAJ;

    public b(c cVar) {
        this.aAJ = cVar;
    }

    public void aY(boolean z) {
        if (this.aAJ != null) {
            com.baidu.live.alablmsdk.a.c.d("BLMRtcRoom muteMicrophone" + z);
            com.baidu.live.alablmsdk.a.c.fJ("BLMRtcRoom muteMicrophone" + z);
            this.aAJ.aY(z);
        }
    }
}
