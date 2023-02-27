package com.baidu.ar.bus;
/* loaded from: classes.dex */
public final class d {
    public c kG;
    public c kH;

    public synchronized void c(c cVar) {
        try {
            if (cVar == null) {
                throw new NullPointerException("null cannot be enqueued");
            }
            if (this.kH != null) {
                this.kH.kF = cVar;
                this.kH = cVar;
            } else if (this.kG != null) {
                throw new IllegalStateException("Head present, but no tail");
            } else {
                this.kH = cVar;
                this.kG = cVar;
            }
            notifyAll();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized c cH() {
        c cVar;
        cVar = this.kG;
        if (this.kG != null) {
            c cVar2 = this.kG.kF;
            this.kG = cVar2;
            if (cVar2 == null) {
                this.kH = null;
            }
        }
        return cVar;
    }
}
