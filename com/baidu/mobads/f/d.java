package com.baidu.mobads.f;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes5.dex */
public class d extends AbstractExecutorService {
    private static final com.baidu.mobads.f.b n = new a();
    private static final RuntimePermission o = new RuntimePermission("modifyThread");

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f3326a;

    /* renamed from: b  reason: collision with root package name */
    private final BlockingQueue<Runnable> f3327b;
    private final ReentrantLock c;
    private final HashSet<b> d;
    private final Condition e;
    private int f;
    private long g;
    private volatile ThreadFactory h;
    private volatile com.baidu.mobads.f.b i;
    private volatile long j;
    private volatile boolean k;
    private volatile int l;
    private volatile int m;

    private static int a(int i) {
        return (-536870912) & i;
    }

    private static int b(int i) {
        return 536870911 & i;
    }

    private static int a(int i, int i2) {
        return i | i2;
    }

    private static boolean b(int i, int i2) {
        return i < i2;
    }

    private static boolean c(int i, int i2) {
        return i >= i2;
    }

    private static boolean c(int i) {
        return i < 0;
    }

    private boolean d(int i) {
        return this.f3326a.compareAndSet(i, i + 1);
    }

    private boolean e(int i) {
        return this.f3326a.compareAndSet(i, i - 1);
    }

    private void f() {
        do {
        } while (!e(this.f3326a.get()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class b extends AbstractQueuedSynchronizer implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final Thread f3328a;

        /* renamed from: b  reason: collision with root package name */
        Runnable f3329b;
        volatile long c;

        b(Runnable runnable) {
            setState(-1);
            this.f3329b = runnable;
            this.f3328a = d.this.c().newThread(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.a(this);
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        protected boolean isHeldExclusively() {
            return getState() != 0;
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        protected boolean tryAcquire(int i) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        protected boolean tryRelease(int i) {
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        public void a() {
            acquire(1);
        }

        public boolean b() {
            return tryAcquire(1);
        }

        public void c() {
            release(1);
        }

        public boolean d() {
            return isHeldExclusively();
        }

        void e() {
            Thread thread;
            if (getState() >= 0 && (thread = this.f3328a) != null && !thread.isInterrupted()) {
                try {
                    thread.interrupt();
                } catch (SecurityException e) {
                }
            }
        }
    }

    private void f(int i) {
        int i2;
        do {
            i2 = this.f3326a.get();
            if (c(i2, i)) {
                return;
            }
        } while (!this.f3326a.compareAndSet(i2, a(i, b(i2))));
    }

    final void a() {
        while (true) {
            int i = this.f3326a.get();
            if (!c(i) && !c(i, 1073741824)) {
                if (a(i) != 0 || this.f3327b.isEmpty()) {
                    if (b(i) != 0) {
                        a(true);
                        return;
                    }
                    ReentrantLock reentrantLock = this.c;
                    reentrantLock.lock();
                    try {
                        if (this.f3326a.compareAndSet(i, a(1073741824, 0))) {
                            e();
                            this.f3326a.set(a(1610612736, 0));
                            this.e.signalAll();
                            return;
                        }
                    } finally {
                        reentrantLock.unlock();
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private void g() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(o);
            ReentrantLock reentrantLock = this.c;
            reentrantLock.lock();
            try {
                Iterator<b> it = this.d.iterator();
                while (it.hasNext()) {
                    securityManager.checkAccess(it.next().f3328a);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    private void h() {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            Iterator<b> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().e();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    private void a(boolean z) {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            Iterator<b> it = this.d.iterator();
            while (it.hasNext()) {
                b next = it.next();
                Thread thread = next.f3328a;
                if (!thread.isInterrupted() && next.b()) {
                    try {
                        thread.interrupt();
                        continue;
                    } catch (SecurityException e) {
                        continue;
                    } finally {
                    }
                }
                if (z) {
                    break;
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    private void i() {
        a(false);
    }

    final void a(Runnable runnable) {
        this.i.a(runnable, this);
    }

    void b() {
    }

    private List<Runnable> j() {
        Runnable[] runnableArr;
        BlockingQueue<Runnable> blockingQueue = this.f3327b;
        ArrayList arrayList = new ArrayList();
        blockingQueue.drainTo(arrayList);
        if (!blockingQueue.isEmpty()) {
            for (Runnable runnable : (Runnable[]) blockingQueue.toArray(new Runnable[0])) {
                if (blockingQueue.remove(runnable)) {
                    arrayList.add(runnable);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:?, code lost:
        return false;
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(Runnable runnable, boolean z) {
        b bVar;
        boolean z2;
        boolean z3;
        loop0: while (true) {
            int i = this.f3326a.get();
            int a2 = a(i);
            if (a2 < 0 || (a2 == 0 && runnable == null && !this.f3327b.isEmpty())) {
                do {
                    int b2 = b(i);
                    if (b2 >= 536870911) {
                        break loop0;
                    }
                    if (b2 >= (z ? this.l : this.m)) {
                        break loop0;
                    } else if (!d(i)) {
                        i = this.f3326a.get();
                    } else {
                        try {
                            b bVar2 = new b(runnable);
                            try {
                                Thread thread = bVar2.f3328a;
                                if (thread != null) {
                                    ReentrantLock reentrantLock = this.c;
                                    reentrantLock.lock();
                                    int a3 = a(this.f3326a.get());
                                    if (a3 >= 0 && (a3 != 0 || runnable != null)) {
                                        z3 = false;
                                    } else if (thread.isAlive()) {
                                        throw new IllegalThreadStateException();
                                    } else {
                                        this.d.add(bVar2);
                                        int size = this.d.size();
                                        if (size > this.f) {
                                            this.f = size;
                                        }
                                        z3 = true;
                                    }
                                    reentrantLock.unlock();
                                    if (z3) {
                                        thread.start();
                                        z2 = true;
                                        if (z2) {
                                            b(bVar2);
                                            return z2;
                                        }
                                        return z2;
                                    }
                                }
                                z2 = false;
                                if (z2) {
                                }
                            } catch (Throwable th) {
                                th = th;
                                bVar = bVar2;
                                b(bVar);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bVar = null;
                        }
                    }
                } while (a(i) == a2);
            }
        }
        return false;
    }

    private void b(b bVar) {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        if (bVar != null) {
            try {
                this.d.remove(bVar);
            } finally {
                reentrantLock.unlock();
            }
        }
        f();
        a();
    }

    private void a(b bVar, boolean z) {
        if (z) {
            f();
        }
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            this.g += bVar.c;
            this.d.remove(bVar);
            reentrantLock.unlock();
            a();
            int i = this.f3326a.get();
            if (b(i, 536870912)) {
                if (!z) {
                    int i2 = this.k ? 0 : this.l;
                    if (i2 == 0 && !this.f3327b.isEmpty()) {
                        i2 = 1;
                    }
                    if (b(i) >= i2) {
                        return;
                    }
                }
                a((Runnable) null, false);
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x004c, code lost:
        r0 = r8.f3327b.poll(r8.j, java.util.concurrent.TimeUnit.NANOSECONDS);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0066, code lost:
        r0 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Runnable k() {
        boolean z = false;
        while (true) {
            int i = this.f3326a.get();
            int a2 = a(i);
            if (a2 < 0 || (a2 < 536870912 && !this.f3327b.isEmpty())) {
                int b2 = b(i);
                boolean z2 = this.k || b2 > this.l;
                if ((b2 > this.m || (z2 && z)) && (b2 > 1 || this.f3327b.isEmpty())) {
                    if (e(i)) {
                        return null;
                    }
                } else {
                    Runnable take = this.f3327b.take();
                    if (take != null) {
                        return take;
                    }
                    z = true;
                }
            }
        }
        f();
        return null;
    }

    final void a(b bVar) {
        Thread currentThread = Thread.currentThread();
        Runnable runnable = bVar.f3329b;
        bVar.f3329b = null;
        bVar.c();
        while (true) {
            if (runnable == null) {
                try {
                    runnable = k();
                    if (runnable == null) {
                        a(bVar, false);
                        return;
                    }
                } catch (Throwable th) {
                    a(bVar, true);
                    throw th;
                }
            }
            Runnable runnable2 = runnable;
            bVar.a();
            if ((c(this.f3326a.get(), 536870912) || (Thread.interrupted() && c(this.f3326a.get(), 536870912))) && !currentThread.isInterrupted()) {
                currentThread.interrupt();
            }
            a(currentThread, runnable2);
            try {
                runnable2.run();
                a(runnable2, (Throwable) null);
                bVar.c++;
                bVar.c();
                runnable = null;
            } catch (Error e) {
                throw e;
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Throwable th2) {
                throw new Error(th2);
            }
        }
    }

    public d(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        this(i, i2, j, timeUnit, blockingQueue, threadFactory, n);
    }

    public d(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, com.baidu.mobads.f.b bVar) {
        this.f3326a = new AtomicInteger(a(-536870912, 0));
        this.c = new ReentrantLock();
        this.d = new HashSet<>();
        this.e = this.c.newCondition();
        if (i < 0 || i2 <= 0 || i2 < i || j < 0) {
            throw new IllegalArgumentException();
        }
        if (blockingQueue == null || threadFactory == null || bVar == null) {
            throw new NullPointerException();
        }
        this.l = i;
        this.m = i2;
        this.f3327b = blockingQueue;
        this.j = timeUnit.toNanos(j);
        this.h = threadFactory;
        this.i = bVar;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException();
        }
        int b2 = b(this.f3326a.get());
        if (b2 - d() > 0) {
            b(runnable);
        } else if (b2 < this.m) {
            if (!a(runnable, false)) {
                b(runnable);
            }
        } else {
            b(runnable);
        }
    }

    private void b(Runnable runnable) {
        int i = this.f3326a.get();
        if (!c(i)) {
            a(runnable);
        } else if (this.f3327b.offer(runnable)) {
            if (b(i) == 0) {
                a((Runnable) null, false);
            }
        } else if (!a(runnable, false)) {
            a(runnable);
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            g();
            f(0);
            i();
            b();
            reentrantLock.unlock();
            a();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            g();
            f(536870912);
            h();
            List<Runnable> j = j();
            reentrantLock.unlock();
            a();
            return j;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return !c(this.f3326a.get());
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return c(this.f3326a.get(), 1610612736);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        while (!c(this.f3326a.get(), 1610612736)) {
            try {
                if (nanos > 0) {
                    nanos = this.e.awaitNanos(nanos);
                } else {
                    return false;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
        return true;
    }

    public ThreadFactory c() {
        return this.h;
    }

    public void a(com.baidu.mobads.f.b bVar) {
        if (bVar == null) {
            throw new NullPointerException();
        }
        this.i = bVar;
    }

    public int d() {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        int i = 0;
        try {
            Iterator<b> it = this.d.iterator();
            while (it.hasNext()) {
                i = it.next().d() ? i + 1 : i;
            }
            return i;
        } finally {
            reentrantLock.unlock();
        }
    }

    public String toString() {
        String str;
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            long j = this.g;
            int size = this.d.size();
            Iterator<b> it = this.d.iterator();
            int i = 0;
            while (it.hasNext()) {
                b next = it.next();
                j += next.c;
                i = next.d() ? i + 1 : i;
            }
            reentrantLock.unlock();
            int i2 = this.f3326a.get();
            if (b(i2, 0)) {
                str = "Running";
            } else {
                str = c(i2, 1610612736) ? "Terminated" : "Shutting down";
            }
            return super.toString() + "[" + str + ", pool size = " + size + ", active threads = " + i + ", queued tasks = " + this.f3327b.size() + ", completed tasks = " + j + "]";
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    protected void a(Thread thread, Runnable runnable) {
    }

    protected void a(Runnable runnable, Throwable th) {
    }

    protected void e() {
    }

    /* loaded from: classes5.dex */
    public static class a implements com.baidu.mobads.f.b {
        @Override // com.baidu.mobads.f.b
        public void a(Runnable runnable, d dVar) {
            throw new RejectedExecutionException("Task " + runnable.toString() + " rejected from " + dVar.toString());
        }
    }
}
