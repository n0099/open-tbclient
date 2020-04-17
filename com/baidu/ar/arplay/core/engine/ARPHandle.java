package com.baidu.ar.arplay.core.engine;
/* loaded from: classes3.dex */
public class ARPHandle {
    private long eu;

    public ARPHandle(long j) {
        this.eu = -1L;
        this.eu = nativeDeepCopyHandle(j);
        com.baidu.ar.arplay.c.b.c("ARPHandle", "new copy handle : " + this.eu);
    }

    public long getHandle() {
        return this.eu;
    }

    native long nativeDeepCopyHandle(long j);

    native void nativeRleaseHandle(long j);

    public void release() {
        if (this.eu > 0) {
            com.baidu.ar.arplay.c.b.c("ARPHandle", "release copy handle : " + this.eu);
            nativeRleaseHandle(this.eu);
            this.eu = -1L;
        }
    }
}
