package com.baidu.swan.games.utils.so;
/* loaded from: classes8.dex */
public class f {
    private final boolean ejQ;
    private final boolean ejR;
    private final boolean ejS;

    private f(boolean z, boolean z2) {
        this.ejQ = true;
        this.ejR = z;
        this.ejS = z2;
    }

    private f(boolean z) {
        this.ejQ = false;
        this.ejR = true;
        this.ejS = z;
    }

    public boolean isSuccess() {
        return this.ejQ ? this.ejR && this.ejS : this.ejS;
    }

    public boolean aYW() {
        return (this.ejQ && this.ejR) ? false : true;
    }

    public static f aYX() {
        return new f(true, true);
    }

    public static f u(boolean z, boolean z2) {
        return new f(z, z2);
    }

    public static f ik(boolean z) {
        return new f(z);
    }
}
