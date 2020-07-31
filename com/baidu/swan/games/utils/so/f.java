package com.baidu.swan.games.utils.so;
/* loaded from: classes7.dex */
public class f {
    private final boolean dnN;
    private final boolean dnO;
    private final boolean dnP;

    private f(boolean z, boolean z2) {
        this.dnN = true;
        this.dnO = z;
        this.dnP = z2;
    }

    private f(boolean z) {
        this.dnN = false;
        this.dnO = true;
        this.dnP = z;
    }

    public boolean isSuccess() {
        return this.dnN ? this.dnO && this.dnP : this.dnP;
    }

    public boolean aHr() {
        return (this.dnN && this.dnO) ? false : true;
    }

    public static f aHs() {
        return new f(true, true);
    }

    public static f r(boolean z, boolean z2) {
        return new f(z, z2);
    }

    public static f gr(boolean z) {
        return new f(z);
    }
}
