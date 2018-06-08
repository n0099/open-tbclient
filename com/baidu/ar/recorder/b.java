package com.baidu.ar.recorder;
/* loaded from: classes3.dex */
class b {
    private long b;
    private int a = 100;
    private long c = 0;
    private boolean d = false;

    public b(long j) {
        this.b = 0L;
        this.b = j;
    }

    public void a(long j) {
        this.c = j;
        this.d = true;
    }

    public boolean a() {
        return this.d;
    }

    public int b(long j) {
        if (this.b == 0 || this.c == 0) {
            return 0;
        }
        return (int) (((j - this.c) * this.a) / this.b);
    }
}
