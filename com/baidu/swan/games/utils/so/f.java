package com.baidu.swan.games.utils.so;
/* loaded from: classes8.dex */
public class f {
    private final boolean dxV;
    private final boolean dxW;
    private final boolean dxX;

    private f(boolean z, boolean z2) {
        this.dxV = true;
        this.dxW = z;
        this.dxX = z2;
    }

    private f(boolean z) {
        this.dxV = false;
        this.dxW = true;
        this.dxX = z;
    }

    public boolean isSuccess() {
        return this.dxV ? this.dxW && this.dxX : this.dxX;
    }

    public boolean aQj() {
        return (this.dxV && this.dxW) ? false : true;
    }

    public static f aQk() {
        return new f(true, true);
    }

    public static f u(boolean z, boolean z2) {
        return new f(z, z2);
    }

    public static f gO(boolean z) {
        return new f(z);
    }
}
