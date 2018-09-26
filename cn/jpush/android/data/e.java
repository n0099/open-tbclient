package cn.jpush.android.data;
/* loaded from: classes3.dex */
public final class e {
    private long a;
    private int b;
    private int c;
    private int d;
    private String e;
    private long f;
    private long g;

    public e() {
        this.a = 0L;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = "";
        this.f = 0L;
        this.g = 0L;
        this.a = 0L;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = "";
        this.f = 0L;
        this.g = 0L;
    }

    public final long a() {
        return this.a;
    }

    public final void a(int i) {
        this.b = i;
    }

    public final void a(long j) {
        this.a = j;
    }

    public final void a(String str) {
        this.e = str;
    }

    public final int b() {
        return this.b;
    }

    public final void b(int i) {
        this.c = i;
    }

    public final void b(long j) {
        this.g = j;
    }

    public final int c() {
        return this.c;
    }

    public final void c(int i) {
        this.d = i;
    }

    public final void c(long j) {
        this.f = j;
    }

    public final String d() {
        return this.e;
    }

    public final long e() {
        return this.g;
    }

    public final long f() {
        return this.f;
    }

    public final String toString() {
        return "LocalNotificationDBData [ln_id=" + this.a + ", ln_count=" + this.b + ", ln_remove=" + this.c + ", ln_type=" + this.d + ", ln_extra=" + this.e + ", ln_trigger_time=" + this.f + ", ln_add_time=" + this.g + "]";
    }
}
