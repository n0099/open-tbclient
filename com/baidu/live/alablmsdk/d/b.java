package com.baidu.live.alablmsdk.d;
/* loaded from: classes10.dex */
public class b {
    private c axF;

    public b(c cVar) {
        this.axF = cVar;
    }

    public void aZ(boolean z) {
        if (this.axF != null) {
            com.baidu.live.alablmsdk.a.b.a.ai("BLMRtcRoom muteMicrophone " + z, "");
            this.axF.aZ(z);
        }
    }
}
