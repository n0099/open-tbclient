package com.baidu.swan.games.utils.so;
/* loaded from: classes7.dex */
public class f {
    private final boolean dYE;
    private final boolean dYF;
    private final boolean dYG;

    private f(boolean z, boolean z2) {
        this.dYE = true;
        this.dYF = z;
        this.dYG = z2;
    }

    private f(boolean z) {
        this.dYE = false;
        this.dYF = true;
        this.dYG = z;
    }

    public boolean isSuccess() {
        return this.dYE ? this.dYF && this.dYG : this.dYG;
    }

    public boolean aXq() {
        return (this.dYE && this.dYF) ? false : true;
    }

    public static f aXr() {
        return new f(true, true);
    }

    public static f u(boolean z, boolean z2) {
        return new f(z, z2);
    }

    public static f hH(boolean z) {
        return new f(z);
    }
}
