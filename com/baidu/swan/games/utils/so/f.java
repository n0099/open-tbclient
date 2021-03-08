package com.baidu.swan.games.utils.so;
/* loaded from: classes8.dex */
public class f {
    private final boolean enA;
    private final boolean enB;
    private final boolean enC;

    private f(boolean z, boolean z2) {
        this.enA = true;
        this.enB = z;
        this.enC = z2;
    }

    private f(boolean z) {
        this.enA = false;
        this.enB = true;
        this.enC = z;
    }

    public boolean isSuccess() {
        return this.enA ? this.enB && this.enC : this.enC;
    }

    public boolean aZl() {
        return (this.enA && this.enB) ? false : true;
    }

    public static f aZm() {
        return new f(true, true);
    }

    public static f v(boolean z, boolean z2) {
        return new f(z, z2);
    }

    public static f im(boolean z) {
        return new f(z);
    }
}
