package cn.jiguang.d.h;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
final class v extends ThreadPoolExecutor {
    private final int a;

    private v(int i, int i2, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, int i3) {
        super(i, i2, 10L, TimeUnit.SECONDS, blockingQueue, threadFactory);
        this.a = i3;
    }

    public static v a(String str, int i, int i2, int i3) {
        return new v(15, 15, new PriorityBlockingQueue(), new u(str, 0), 0);
    }

    public static v e(String str, int i) {
        return new v(0, 30, new SynchronousQueue(), new u(str, 0), 0);
    }

    public static v i(String str, int i, int i2) {
        return new v(1, 1, i2 < 0 ? new LinkedBlockingDeque() : new LinkedBlockingDeque(i2), new u(str, i), i);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected final void beforeExecute(Thread thread, Runnable runnable) {
        int i;
        super.beforeExecute(thread, runnable);
        try {
            if (this.a > 0) {
                thread.setPriority(this.a);
            } else if (runnable instanceof w) {
                i = ((w) runnable).a;
                thread.setPriority(i);
            }
        } catch (Throwable th) {
        }
    }
}
