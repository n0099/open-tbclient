package cn.jiguang.d.g;
/* loaded from: classes3.dex */
public final class c {
    private static final Object c = new Object();
    private static c lM;
    private a lN;

    private c() {
    }

    public static c bP() {
        if (lM == null) {
            synchronized (c) {
                if (lM == null) {
                    lM = new c();
                }
            }
        }
        return lM;
    }

    public final a bQ() {
        if (this.lN == null) {
            this.lN = new b();
        }
        return this.lN;
    }
}
