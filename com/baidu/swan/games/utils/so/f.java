package com.baidu.swan.games.utils.so;
/* loaded from: classes9.dex */
public class f {
    private final boolean elX;
    private final boolean elY;
    private final boolean elZ;

    private f(boolean z, boolean z2) {
        this.elX = true;
        this.elY = z;
        this.elZ = z2;
    }

    private f(boolean z) {
        this.elX = false;
        this.elY = true;
        this.elZ = z;
    }

    public boolean isSuccess() {
        return this.elX ? this.elY && this.elZ : this.elZ;
    }

    public boolean aZi() {
        return (this.elX && this.elY) ? false : true;
    }

    public static f aZj() {
        return new f(true, true);
    }

    public static f v(boolean z, boolean z2) {
        return new f(z, z2);
    }

    public static f im(boolean z) {
        return new f(z);
    }
}
