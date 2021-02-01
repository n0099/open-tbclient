package com.baidu.live.alablmsdk.d;

import com.baidu.live.alablmsdk.module.rtc.d;
/* loaded from: classes11.dex */
public class b {
    private c axS;

    public b(c cVar) {
        this.axS = cVar;
    }

    public void aY(boolean z) {
        if (this.axS != null) {
            com.baidu.live.alablmsdk.a.b.a.ag("in-media-device muteMicrophone " + z, "");
            this.axS.aY(z);
        }
    }

    public void aZ(boolean z) {
        if (this.axS != null) {
            com.baidu.live.alablmsdk.a.b.a.ag("in-media-device muteSpeaker " + z, "");
            this.axS.aZ(z);
        }
    }

    public d yk() {
        if (this.axS != null) {
            return this.axS.yk();
        }
        return null;
    }
}
