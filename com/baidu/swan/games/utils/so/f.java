package com.baidu.swan.games.utils.so;
/* loaded from: classes9.dex */
public class f {
    private final boolean eoF;
    private final boolean eoG;
    private final boolean eoH;

    private f(boolean z, boolean z2) {
        this.eoF = true;
        this.eoG = z;
        this.eoH = z2;
    }

    private f(boolean z) {
        this.eoF = false;
        this.eoG = true;
        this.eoH = z;
    }

    public boolean isSuccess() {
        return this.eoF ? this.eoG && this.eoH : this.eoH;
    }

    public boolean bcQ() {
        return (this.eoF && this.eoG) ? false : true;
    }

    public static f bcR() {
        return new f(true, true);
    }

    public static f u(boolean z, boolean z2) {
        return new f(z, z2);
    }

    public static f io(boolean z) {
        return new f(z);
    }
}
