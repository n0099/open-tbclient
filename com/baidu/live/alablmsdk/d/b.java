package com.baidu.live.alablmsdk.d;
/* loaded from: classes4.dex */
public class b {
    private c aCb;

    public b(c cVar) {
        this.aCb = cVar;
    }

    public void bg(boolean z) {
        if (this.aCb != null) {
            com.baidu.live.alablmsdk.a.b.a.ak("BLMRtcRoom muteMicrophone " + z, "");
            this.aCb.bg(z);
        }
    }
}
