package com.baidu.swan.games.utils.so;
/* loaded from: classes10.dex */
public class f {
    private final boolean dLX;
    private final boolean dLY;
    private final boolean dLZ;

    private f(boolean z, boolean z2) {
        this.dLX = true;
        this.dLY = z;
        this.dLZ = z2;
    }

    private f(boolean z) {
        this.dLX = false;
        this.dLY = true;
        this.dLZ = z;
    }

    public boolean isSuccess() {
        return this.dLX ? this.dLY && this.dLZ : this.dLZ;
    }

    public boolean aTE() {
        return (this.dLX && this.dLY) ? false : true;
    }

    public static f aTF() {
        return new f(true, true);
    }

    public static f u(boolean z, boolean z2) {
        return new f(z, z2);
    }

    public static f hi(boolean z) {
        return new f(z);
    }
}
