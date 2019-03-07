package cn.jiguang.a.c;
/* loaded from: classes3.dex */
public final class b {
    private static b la;

    private b() {
    }

    public static b bt() {
        if (la == null) {
            la = new b();
        }
        return la;
    }
}
