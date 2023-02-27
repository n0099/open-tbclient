package com.baidu.ar.bus;
/* loaded from: classes.dex */
public final class g {
    public final Object kV;
    public final e kW;
    public volatile boolean kX = true;

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
