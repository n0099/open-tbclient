package cn.jiguang.a.c;
/* loaded from: classes3.dex */
public final class b {
    private static b ks;

    private b() {
    }

    public static b bc() {
        if (ks == null) {
            ks = new b();
        }
        return ks;
    }
}
