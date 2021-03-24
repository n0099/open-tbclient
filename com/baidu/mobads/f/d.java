package com.baidu.mobads.f;

import com.baidubce.auth.NTLMEngineImpl;
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
/* loaded from: classes2.dex */
public class d extends AbstractExecutorService {
    public static final com.baidu.mobads.f.b n = new a();
    public static final RuntimePermission o = new RuntimePermission("modifyThread");

    /* renamed from: a  reason: collision with root package name */
    public final AtomicInteger f8228a;

    /* renamed from: b  reason: collision with root package name */
    public final BlockingQueue<Runnable> f8229b;

    /* renamed from: c  reason: collision with root package name */
    public final ReentrantLock f8230c;

    /* renamed from: d  reason: collision with root package name */
    public final HashSet<b> f8231d;

    /* renamed from: e  reason: collision with root package name */
    public final Condition f8232e;

    /* renamed from: f  reason: collision with root package name */
    public int f8233f;

    /* renamed from: g  reason: collision with root package name */
    public long f8234g;

    /* renamed from: h  reason: collision with root package name */
    public volatile ThreadFactory f8235h;
    public volatile com.baidu.mobads.f.b i;
    public volatile long j;
    public volatile boolean k;
    public volatile int l;
    public volatile int m;

    /* loaded from: classes2.dex */
    public static class a implements com.baidu.mobads.f.b {
        @Override // com.baidu.mobads.f.b
        public void a(Runnable runnable, d dVar) {
            throw new RejectedExecutionException("Task " + runnable.toString() + " rejected from " + dVar.toString());
        }
    }

    /* loaded from: classes2.dex */
    public final class b extends AbstractQueuedSynchronizer implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final Thread f8236a;

        /* renamed from: b  reason: collision with root package name */
        public Runnable f8237b;

        /* renamed from: c  reason: collision with root package name */
        public volatile long f8238c;

        public b(Runnable runnable) {
            setState(-1);
            this.f8237b = runnable;
            this.f8236a = d.this.c().newThread(this);
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

        public void e() {
            Thread thread;
            if (getState() < 0 || (thread = this.f8236a) == null || thread.isInterrupted()) {
                return;
            }
            try {
                thread.interrupt();
            } catch (SecurityException unused) {
            }
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        public boolean isHeldExclusively() {
            return getState() != 0;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.a(this);
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        public boolean tryAcquire(int i) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        public boolean tryRelease(int i) {
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }
    }

    public d(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        this(i, i2, j, timeUnit, blockingQueue, threadFactory, n);
    }

    public static int a(int i) {
        return i & (-536870912);
    }

    public static int a(int i, int i2) {
        return i | i2;
    }

    public static int b(int i) {
        return i & 536870911;
    }

    private void b(b bVar) {
        ReentrantLock reentrantLock = this.f8230c;
        reentrantLock.lock();
        if (bVar != null) {
            try {
                this.f8231d.remove(bVar);
            } finally {
                reentrantLock.unlock();
            }
        }
        f();
        a();
    }

    public static boolean b(int i, int i2) {
        return i < i2;
    }

    public static boolean c(int i) {
        return i < 0;
    }

    public static boolean c(int i, int i2) {
        return i >= i2;
    }

    private boolean d(int i) {
        return this.f8228a.compareAndSet(i, i + 1);
    }

    private boolean e(int i) {
        return this.f8228a.compareAndSet(i, i - 1);
    }

    private void f() {
        do {
        } while (!e(this.f8228a.get()));
    }

    private void g() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(o);
            ReentrantLock reentrantLock = this.f8230c;
            reentrantLock.lock();
            try {
                Iterator<b> it = this.f8231d.iterator();
                while (it.hasNext()) {
                    securityManager.checkAccess(it.next().f8236a);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    private void h() {
        ReentrantLock reentrantLock = this.f8230c;
        reentrantLock.lock();
        try {
            Iterator<b> it = this.f8231d.iterator();
            while (it.hasNext()) {
                it.next().e();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    private void i() {
        a(false);
    }

    private List<Runnable> j() {
        Runnable[] runnableArr;
        BlockingQueue<Runnable> blockingQueue = this.f8229b;
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

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
        f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001e, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0045, code lost:
        r1 = r8.f8229b.poll(r8.j, java.util.concurrent.TimeUnit.NANOSECONDS);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:?, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Runnable k() {
        loop0: while (true) {
            boolean z = false;
            while (true) {
                int i = this.f8228a.get();
                int a2 = a(i);
                if (a2 < 0 || (a2 < 536870912 && !this.f8229b.isEmpty())) {
                    int b2 = b(i);
                    boolean z2 = this.k || b2 > this.l;
                    if ((b2 <= this.m && (!z2 || !z)) || (b2 <= 1 && !this.f8229b.isEmpty())) {
                        Runnable poll = this.f8229b.take();
                        if (poll != null) {
                            return poll;
                        }
                        z = true;
                    } else if (e(i)) {
                        return null;
                    }
                }
            }
        }
    }

    public final void a() {
        while (true) {
            int i = this.f8228a.get();
            if (c(i) || c(i, 1073741824)) {
                return;
            }
            if (a(i) == 0 && !this.f8229b.isEmpty()) {
                return;
            }
            if (b(i) != 0) {
                a(true);
                return;
            }
            ReentrantLock reentrantLock = this.f8230c;
            reentrantLock.lock();
            try {
                if (this.f8228a.compareAndSet(i, a(1073741824, 0))) {
                    e();
                    this.f8228a.set(a(1610612736, 0));
                    this.f8232e.signalAll();
                    return;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public void a(Runnable runnable, Throwable th) {
    }

    public void a(Thread thread, Runnable runnable) {
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        boolean z;
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.f8230c;
        reentrantLock.lock();
        while (true) {
            try {
                if (c(this.f8228a.get(), 1610612736)) {
                    z = true;
                    break;
                } else if (nanos <= 0) {
                    z = false;
                    break;
                } else {
                    nanos = this.f8232e.awaitNanos(nanos);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
        return z;
    }

    public void b() {
    }

    public ThreadFactory c() {
        return this.f8235h;
    }

    public void e() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable != null) {
            int b2 = b(this.f8228a.get());
            if (b2 - d() > 0) {
                b(runnable);
                return;
            } else if (b2 < this.m) {
                if (a(runnable, false)) {
                    return;
                }
                b(runnable);
                return;
            } else {
                b(runnable);
                return;
            }
        }
        throw null;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return !c(this.f8228a.get());
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return c(this.f8228a.get(), 1610612736);
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        ReentrantLock reentrantLock = this.f8230c;
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
        ReentrantLock reentrantLock = this.f8230c;
        reentrantLock.lock();
        try {
            g();
            f(NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH);
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

    public String toString() {
        String str;
        ReentrantLock reentrantLock = this.f8230c;
        reentrantLock.lock();
        try {
            long j = this.f8234g;
            int size = this.f8231d.size();
            Iterator<b> it = this.f8231d.iterator();
            int i = 0;
            while (it.hasNext()) {
                b next = it.next();
                j += next.f8238c;
                if (next.d()) {
                    i++;
                }
            }
            reentrantLock.unlock();
            int i2 = this.f8228a.get();
            if (b(i2, 0)) {
                str = "Running";
            } else {
                str = c(i2, 1610612736) ? "Terminated" : "Shutting down";
            }
            return super.toString() + "[" + str + ", pool size = " + size + ", active threads = " + i + ", queued tasks = " + this.f8229b.size() + ", completed tasks = " + j + "]";
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public d(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, com.baidu.mobads.f.b bVar) {
        this.f8228a = new AtomicInteger(a(-536870912, 0));
        this.f8230c = new ReentrantLock();
        this.f8231d = new HashSet<>();
        this.f8232e = this.f8230c.newCondition();
        if (i < 0 || i2 <= 0 || i2 < i || j < 0) {
            throw new IllegalArgumentException();
        }
        if (blockingQueue != null && threadFactory != null && bVar != null) {
            this.l = i;
            this.m = i2;
            this.f8229b = blockingQueue;
            this.j = timeUnit.toNanos(j);
            this.f8235h = threadFactory;
            this.i = bVar;
            return;
        }
        throw null;
    }

    private void f(int i) {
        int i2;
        do {
            i2 = this.f8228a.get();
            if (c(i2, i)) {
                return;
            }
        } while (!this.f8228a.compareAndSet(i2, a(i, b(i2))));
    }

    public int d() {
        ReentrantLock reentrantLock = this.f8230c;
        reentrantLock.lock();
        int i = 0;
        try {
            Iterator<b> it = this.f8231d.iterator();
            while (it.hasNext()) {
                if (it.next().d()) {
                    i++;
                }
            }
            return i;
        } finally {
            reentrantLock.unlock();
        }
    }

    private void b(Runnable runnable) {
        int i = this.f8228a.get();
        if (!c(i)) {
            a(runnable);
        } else if (this.f8229b.offer(runnable)) {
            if (b(i) == 0) {
                a((Runnable) null, false);
            }
        } else if (a(runnable, false)) {
        } else {
            a(runnable);
        }
    }

    private void a(boolean z) {
        ReentrantLock reentrantLock = this.f8230c;
        reentrantLock.lock();
        try {
            Iterator<b> it = this.f8231d.iterator();
            while (it.hasNext()) {
                b next = it.next();
                Thread thread = next.f8236a;
                if (!thread.isInterrupted() && next.b()) {
                    try {
                        thread.interrupt();
                    } catch (SecurityException unused) {
                    } catch (Throwable th) {
                        next.c();
                        throw th;
                    }
                    next.c();
                    continue;
                }
                if (z) {
                    break;
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void a(Runnable runnable) {
        this.i.a(runnable, this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00a0, code lost:
        return false;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0074 A[Catch: all -> 0x008a, TRY_LEAVE, TryCatch #3 {all -> 0x008a, blocks: (B:20:0x003a, B:22:0x003f, B:35:0x006f, B:37:0x0074, B:23:0x0044, B:29:0x0057, B:31:0x005d, B:33:0x006c, B:39:0x0079, B:40:0x007e), top: B:58:0x003a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(Runnable runnable, boolean z) {
        b bVar;
        boolean z2;
        loop0: while (true) {
            int i = this.f8228a.get();
            int a2 = a(i);
            boolean z3 = false;
            if (a2 < 0 || (a2 == 0 && runnable == null && !this.f8229b.isEmpty())) {
                do {
                    int b2 = b(i);
                    if (b2 >= 536870911) {
                        break loop0;
                    }
                    if (b2 >= (z ? this.l : this.m)) {
                        break loop0;
                    } else if (d(i)) {
                        b bVar2 = null;
                        try {
                            bVar = new b(runnable);
                        } catch (Throwable th) {
                            th = th;
                        }
                        try {
                            Thread thread = bVar.f8236a;
                            if (thread != null) {
                                ReentrantLock reentrantLock = this.f8230c;
                                reentrantLock.lock();
                                int a3 = a(this.f8228a.get());
                                if (a3 >= 0 && (a3 != 0 || runnable != null)) {
                                    z2 = false;
                                    reentrantLock.unlock();
                                    if (z2) {
                                        thread.start();
                                        z3 = true;
                                    }
                                }
                                if (!thread.isAlive()) {
                                    this.f8231d.add(bVar);
                                    int size = this.f8231d.size();
                                    if (size > this.f8233f) {
                                        this.f8233f = size;
                                    }
                                    z2 = true;
                                    reentrantLock.unlock();
                                    if (z2) {
                                    }
                                } else {
                                    throw new IllegalThreadStateException();
                                }
                            }
                            if (!z3) {
                                b(bVar);
                            }
                            return z3;
                        } catch (Throwable th2) {
                            th = th2;
                            bVar2 = bVar;
                            b(bVar2);
                            throw th;
                        }
                    } else {
                        i = this.f8228a.get();
                    }
                } while (a(i) == a2);
            }
        }
        return false;
    }

    private void a(b bVar, boolean z) {
        if (z) {
            f();
        }
        ReentrantLock reentrantLock = this.f8230c;
        reentrantLock.lock();
        try {
            this.f8234g += bVar.f8238c;
            this.f8231d.remove(bVar);
            reentrantLock.unlock();
            a();
            int i = this.f8228a.get();
            if (b(i, NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH)) {
                if (!z) {
                    int i2 = this.k ? 0 : this.l;
                    if (i2 == 0 && !this.f8229b.isEmpty()) {
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

    public final void a(b bVar) {
        Thread currentThread = Thread.currentThread();
        Runnable runnable = bVar.f8237b;
        bVar.f8237b = null;
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
            bVar.a();
            if ((c(this.f8228a.get(), NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH) || (Thread.interrupted() && c(this.f8228a.get(), NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH))) && !currentThread.isInterrupted()) {
                currentThread.interrupt();
            }
            a(currentThread, runnable);
            try {
                try {
                    try {
                        runnable.run();
                        a(runnable, (Throwable) null);
                        bVar.f8238c++;
                        bVar.c();
                        runnable = null;
                    } catch (RuntimeException e2) {
                        throw e2;
                    }
                } catch (Error e3) {
                    throw e3;
                }
            }
        }
    }

    public void a(com.baidu.mobads.f.b bVar) {
        if (bVar != null) {
            this.i = bVar;
            return;
        }
        throw null;
    }
}
