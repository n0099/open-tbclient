package com.baidu.ar.arplay.core.engine;
/* loaded from: classes3.dex */
public class ARPHandle {
    private long eG;

    public long getHandle() {
        return this.eG;
    }

    native void nativeRleaseHandle(long j);

    public void release() {
        if (this.eG > 0) {
            com.baidu.ar.arplay.c.b.c("ARPHandle", "release copy handle : " + this.eG);
            nativeRleaseHandle(this.eG);
            this.eG = -1L;
        }
    }
}
