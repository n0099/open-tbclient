package cn.jiguang.d.g;
/* loaded from: classes3.dex */
public final class c {
    private static final Object c = new Object();
    private static c mw;
    private a mx;

    private c() {
    }

    public static c cf() {
        if (mw == null) {
            synchronized (c) {
                if (mw == null) {
                    mw = new c();
                }
            }
        }
        return mw;
    }

    public final a cg() {
        if (this.mx == null) {
            this.mx = new b();
        }
        return this.mx;
    }
}
