package cn.jiguang.d.h;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
final class u implements ThreadFactory {
    private final AtomicInteger a = new AtomicInteger(1);
    private final String b;
    private final int c;

    public u(String str, int i) {
        this.b = str;
        this.c = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        int i;
        Thread thread = new Thread(runnable, this.c == 0 ? this.b + "_" + this.a.getAndIncrement() : this.b);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (this.c != 0) {
            if (this.c != thread.getPriority()) {
                thread.setPriority(this.c);
            }
        } else if (runnable instanceof w) {
            i = ((w) runnable).a;
            thread.setPriority(i);
        }
        return thread;
    }
}
