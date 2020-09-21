package com.baidu.swan.games.utils.so;
/* loaded from: classes3.dex */
public class f {
    private final boolean dzW;
    private final boolean dzX;
    private final boolean dzY;

    private f(boolean z, boolean z2) {
        this.dzW = true;
        this.dzX = z;
        this.dzY = z2;
    }

    private f(boolean z) {
        this.dzW = false;
        this.dzX = true;
        this.dzY = z;
    }

    public boolean isSuccess() {
        return this.dzW ? this.dzX && this.dzY : this.dzY;
    }

    public boolean aQV() {
        return (this.dzW && this.dzX) ? false : true;
    }

    public static f aQW() {
        return new f(true, true);
    }

    public static f u(boolean z, boolean z2) {
        return new f(z, z2);
    }

    public static f gM(boolean z) {
        return new f(z);
    }
}
