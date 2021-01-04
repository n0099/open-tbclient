package com.baidu.ar.bus;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class g {
    final Object kV;
    final e kW;
    volatile boolean kX = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Object obj, e eVar) {
        this.kV = obj;
        this.kW = eVar;
    }

    public boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.kV == gVar.kV && this.kW.equals(gVar.kW);
        }
        return false;
    }

    public int hashCode() {
        return this.kV.hashCode() + this.kW.kL.hashCode();
    }
}
