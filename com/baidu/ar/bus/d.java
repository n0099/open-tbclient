package com.baidu.ar.bus;
/* loaded from: classes10.dex */
final class d {
    private c kr;
    private c ks;

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void c(c cVar) {
        if (cVar == null) {
            throw new NullPointerException("null cannot be enqueued");
        }
        if (this.ks != null) {
            this.ks.kq = cVar;
            this.ks = cVar;
        } else if (this.kr != null) {
            throw new IllegalStateException("Head present, but no tail");
        } else {
            this.ks = cVar;
            this.kr = cVar;
        }
        notifyAll();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized c cI() {
        c cVar;
        cVar = this.kr;
        if (this.kr != null) {
            this.kr = this.kr.kq;
            if (this.kr == null) {
                this.ks = null;
            }
        }
        return cVar;
    }
}
