package com.baidu.live.alablmsdk.d;
/* loaded from: classes4.dex */
public class b {
    private c azx;

    public b(c cVar) {
        this.azx = cVar;
    }

    public void ba(boolean z) {
        if (this.azx != null) {
            com.baidu.live.alablmsdk.a.b.ag("BLMRtcRoom muteMicrophone " + z, "");
            this.azx.ba(z);
        }
    }
}
