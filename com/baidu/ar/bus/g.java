package com.baidu.ar.bus;
/* loaded from: classes14.dex */
final class g {
    final Object kG;
    final e kH;
    volatile boolean kI = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Object obj, e eVar) {
        this.kG = obj;
        this.kH = eVar;
    }

    public boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.kG == gVar.kG && this.kH.equals(gVar.kH);
        }
        return false;
    }

    public int hashCode() {
        return this.kG.hashCode() + this.kH.kw.hashCode();
    }
}
