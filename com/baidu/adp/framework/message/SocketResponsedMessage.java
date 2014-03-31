package com.baidu.adp.framework.message;
/* loaded from: classes.dex */
public abstract class SocketResponsedMessage extends f<byte[]> {
    private int a;
    private int b;
    private long c;

    public final int a() {
        return this.a;
    }

    public final void b(int i) {
        this.a = i;
    }

    public final int b() {
        return this.b;
    }

    public final void c(int i) {
        this.b = i;
    }

    public final long c() {
        return this.c;
    }

    public final void a(long j) {
        this.c = j;
    }

    public SocketResponsedMessage(int i) {
        super(i);
        this.a = 0;
        this.b = 0;
        this.c = 0L;
    }
}
