package com.baidu.live.alablmsdk.d;
/* loaded from: classes4.dex */
public class b {
    private c aAO;

    public b(c cVar) {
        this.aAO = cVar;
    }

    public void aY(boolean z) {
        if (this.aAO != null) {
            com.baidu.live.alablmsdk.a.c.d("BLMRtcRoom muteMicrophone" + z);
            com.baidu.live.alablmsdk.a.c.fJ("BLMRtcRoom muteMicrophone" + z);
            this.aAO.aY(z);
        }
    }
}
