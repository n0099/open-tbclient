package com.baidu.swan.games.utils.so;
/* loaded from: classes25.dex */
public class f {
    private final boolean efD;
    private final boolean efE;
    private final boolean efF;

    private f(boolean z, boolean z2) {
        this.efD = true;
        this.efE = z;
        this.efF = z2;
    }

    private f(boolean z) {
        this.efD = false;
        this.efE = true;
        this.efF = z;
    }

    public boolean isSuccess() {
        return this.efD ? this.efE && this.efF : this.efF;
    }

    public boolean bav() {
        return (this.efD && this.efE) ? false : true;
    }

    public static f baw() {
        return new f(true, true);
    }

    public static f u(boolean z, boolean z2) {
        return new f(z, z2);
    }

    public static f hW(boolean z) {
        return new f(z);
    }
}
