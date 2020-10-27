package com.baidu.swan.games.utils.so;
/* loaded from: classes10.dex */
public class f {
    private final boolean dUu;
    private final boolean dUv;
    private final boolean dUw;

    private f(boolean z, boolean z2) {
        this.dUu = true;
        this.dUv = z;
        this.dUw = z2;
    }

    private f(boolean z) {
        this.dUu = false;
        this.dUv = true;
        this.dUw = z;
    }

    public boolean isSuccess() {
        return this.dUu ? this.dUv && this.dUw : this.dUw;
    }

    public boolean aVy() {
        return (this.dUu && this.dUv) ? false : true;
    }

    public static f aVz() {
        return new f(true, true);
    }

    public static f u(boolean z, boolean z2) {
        return new f(z, z2);
    }

    public static f hv(boolean z) {
        return new f(z);
    }
}
