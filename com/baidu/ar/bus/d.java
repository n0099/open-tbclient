package com.baidu.ar.bus;
/* loaded from: classes3.dex */
final class d {
    private c kG;
    private c kH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void c(c cVar) {
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
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized c cH() {
        c cVar;
        cVar = this.kG;
        if (this.kG != null) {
            this.kG = this.kG.kF;
            if (this.kG == null) {
                this.kH = null;
            }
        }
        return cVar;
    }
}
