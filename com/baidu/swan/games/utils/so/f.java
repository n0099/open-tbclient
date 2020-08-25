package com.baidu.swan.games.utils.so;
/* loaded from: classes8.dex */
public class f {
    private final boolean dxR;
    private final boolean dxS;
    private final boolean dxT;

    private f(boolean z, boolean z2) {
        this.dxR = true;
        this.dxS = z;
        this.dxT = z2;
    }

    private f(boolean z) {
        this.dxR = false;
        this.dxS = true;
        this.dxT = z;
    }

    public boolean isSuccess() {
        return this.dxR ? this.dxS && this.dxT : this.dxT;
    }

    public boolean aQj() {
        return (this.dxR && this.dxS) ? false : true;
    }

    public static f aQk() {
        return new f(true, true);
    }

    public static f u(boolean z, boolean z2) {
        return new f(z, z2);
    }

    public static f gN(boolean z) {
        return new f(z);
    }
}
