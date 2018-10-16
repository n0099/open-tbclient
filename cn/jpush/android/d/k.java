package cn.jpush.android.d;
/* loaded from: classes3.dex */
public final class k {
    private String a;
    private String b;
    private boolean c = false;
    private long d;

    public k(String str, String str2) {
        if (cn.jiguang.api.e.bv()) {
            this.a = str;
            this.b = str2;
            this.d = System.currentTimeMillis();
        }
    }

    public final void a() {
        if (!cn.jiguang.api.e.bv() || this.c) {
            return;
        }
        this.d = System.currentTimeMillis();
    }
}
