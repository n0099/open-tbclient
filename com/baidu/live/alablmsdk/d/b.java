package com.baidu.live.alablmsdk.d;

import com.baidu.live.alablmsdk.module.rtc.d;
/* loaded from: classes10.dex */
public class b {
    private c azs;

    public b(c cVar) {
        this.azs = cVar;
    }

    public void aY(boolean z) {
        if (this.azs != null) {
            com.baidu.live.alablmsdk.a.b.a.ag("in-media-device muteMicrophone " + z, "");
            this.azs.aY(z);
        }
    }

    public void aZ(boolean z) {
        if (this.azs != null) {
            com.baidu.live.alablmsdk.a.b.a.ag("in-media-device muteSpeaker " + z, "");
            this.azs.aZ(z);
        }
    }

    public d yn() {
        if (this.azs != null) {
            return this.azs.yn();
        }
        return null;
    }
}
