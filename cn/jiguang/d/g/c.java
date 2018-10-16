package cn.jiguang.d.g;
/* loaded from: classes3.dex */
public final class c {
    private static final Object c = new Object();
    private static c mr;
    private a mt;

    private c() {
    }

    public static c cg() {
        if (mr == null) {
            synchronized (c) {
                if (mr == null) {
                    mr = new c();
                }
            }
        }
        return mr;
    }

    public final a ch() {
        if (this.mt == null) {
            this.mt = new b();
        }
        return this.mt;
    }
}
