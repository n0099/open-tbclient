package com.baidu.swan.games.utils.so;
/* loaded from: classes10.dex */
public class f {
    private final boolean eam;
    private final boolean ean;
    private final boolean eao;

    private f(boolean z, boolean z2) {
        this.eam = true;
        this.ean = z;
        this.eao = z2;
    }

    private f(boolean z) {
        this.eam = false;
        this.ean = true;
        this.eao = z;
    }

    public boolean isSuccess() {
        return this.eam ? this.ean && this.eao : this.eao;
    }

    public boolean aXY() {
        return (this.eam && this.ean) ? false : true;
    }

    public static f aXZ() {
        return new f(true, true);
    }

    public static f u(boolean z, boolean z2) {
        return new f(z, z2);
    }

    public static f hE(boolean z) {
        return new f(z);
    }
}
