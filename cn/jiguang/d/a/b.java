package cn.jiguang.d.a;
/* loaded from: classes3.dex */
public final class b {
    private static volatile Long a;
    private static volatile Long kD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void a(long j, long j2) {
        synchronized (b.class) {
            a = Long.valueOf(j);
            kD = Long.valueOf(j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        return (a == null || kD == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long b() {
        return a.longValue() - kD.longValue();
    }
}
