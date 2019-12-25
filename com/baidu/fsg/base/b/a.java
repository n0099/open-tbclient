package com.baidu.fsg.base.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.fsg.base.ApollonConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Timer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public final class a {
    public static final long a = 1000;
    private static final long e = Long.MAX_VALUE;
    private static final int f = 5;
    private static final int g = 128;
    private static final int h = 1;
    private static final boolean c = ApollonConstants.DEBUG;
    private static final String d = a.class.getSimpleName();
    public static HashMap<String, a> b = new HashMap<>();
    private static a i = null;
    private final HashMap<Future<?>, Runnable> k = new HashMap<>();
    private final ThreadFactory l = new com.baidu.fsg.base.b.b(this);
    private long m = Long.MAX_VALUE;
    private Timer n = new Timer();
    private BlockingQueue<Runnable> o = new LinkedBlockingQueue(10);
    private C0061a p = new C0061a(5, 128, 1, TimeUnit.SECONDS, this.o, this.l);
    private b q = new b(this, null);
    private final HashMap<String, ArrayList<c>> j = new HashMap<>();

    private a() {
    }

    public static synchronized a a(String str) {
        a aVar;
        synchronized (a.class) {
            if (b.get(str) == null) {
                i = new a();
                b.put(str, i);
            }
            aVar = i;
        }
        return aVar;
    }

    public boolean a(c cVar, String str) {
        if (cVar == null || cVar.b == null) {
            return false;
        }
        synchronized (this.j) {
            ArrayList<c> c2 = c(str);
            if (!a(cVar, c2)) {
                if (cVar.f <= System.currentTimeMillis()) {
                    c(cVar);
                } else if (cVar.d > 0) {
                    c(cVar);
                }
                if (cVar.c > 0) {
                    cVar.f = System.currentTimeMillis() + cVar.d + cVar.c;
                    c2.add(cVar);
                    a(cVar);
                }
            } else {
                b(cVar, str);
            }
        }
        return true;
    }

    public void b(String str) {
        synchronized (this.j) {
            ArrayList<c> c2 = c(str);
            Iterator<c> it = c2.iterator();
            while (it.hasNext()) {
                b(it.next());
            }
            c2.clear();
            this.j.remove(str);
        }
    }

    public void a(String str, String str2) {
        synchronized (this.j) {
            ArrayList<c> c2 = c(str);
            Iterator<c> it = c2.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.a.equals(str2)) {
                    b(next);
                    c2.remove(next.a);
                }
            }
        }
    }

    private c a(String str, ArrayList<c> arrayList) {
        Iterator<c> it = arrayList.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (TextUtils.equals(str, next.a)) {
                return next;
            }
        }
        return null;
    }

    private ArrayList<c> c(String str) {
        ArrayList<c> arrayList = this.j.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        this.j.put(str, arrayList);
        return arrayList;
    }

    private boolean b(c cVar, String str) {
        boolean z = false;
        if (cVar != null && cVar.b != null) {
            synchronized (this.j) {
                ArrayList<c> c2 = c(str);
                c a2 = a(cVar.a, c2);
                if (a2 != null) {
                    b(a2);
                    c2.remove(a2);
                    a(cVar, str);
                    z = true;
                }
            }
        }
        return z;
    }

    private void a(c cVar) {
        if (cVar.f < this.m) {
            a(Math.max(cVar.f - System.currentTimeMillis(), 1000L));
        }
    }

    private void a(long j) {
        if (c) {
            Log.d(d, "intervalMillis: " + j);
        }
        if (this.n != null) {
            this.n.cancel();
            this.n = null;
        }
        this.n = new Timer();
        this.n.schedule(new com.baidu.fsg.base.b.c(this), j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (c) {
            Log.d(d, "scheduleForPeriodTasks run");
        }
        synchronized (this.j) {
            long currentTimeMillis = System.currentTimeMillis();
            this.m = Long.MAX_VALUE;
            for (String str : this.j.keySet()) {
                ArrayList arrayList = new ArrayList();
                Iterator<c> it = c(str).iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.f - currentTimeMillis < 1000) {
                        if (c) {
                            Log.d(d, "task.mNextRunTime - current = " + (next.f - currentTimeMillis));
                        }
                        c(next);
                        if (next.c > 0) {
                            next.f = next.c + currentTimeMillis;
                            arrayList.add(next);
                        }
                    }
                    if (next.f < this.m) {
                        this.m = next.f;
                    }
                }
                if (this.m < Long.MAX_VALUE) {
                    a(this.m - currentTimeMillis);
                }
            }
        }
    }

    private boolean a(c cVar, ArrayList<c> arrayList) {
        Iterator<c> it = arrayList.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().a, cVar.a)) {
                return true;
            }
        }
        return false;
    }

    private void b(c cVar) {
        if (cVar.e) {
            this.q.a(cVar.b);
            return;
        }
        for (Future<?> future : this.k.keySet()) {
            if (this.k.get(future) == cVar.b && future != null && (!future.isCancelled() || !future.isDone())) {
                future.cancel(true);
            }
        }
    }

    private void c(c cVar) {
        if (cVar.d > 0) {
            a(cVar, cVar.f - System.currentTimeMillis());
        } else {
            d(cVar);
        }
    }

    private void a(c cVar, long j) {
        this.p.execute(new d(this, j, cVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(c cVar) {
        if (cVar.c > 0) {
            cVar.d = 0L;
        }
        if (cVar.e) {
            this.q.execute(cVar.b);
            return;
        }
        this.k.put(this.p.submit(cVar.b), cVar.b);
        if (c) {
            Log.d(d, "execute task, " + cVar.a + " execute time is " + System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.fsg.base.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0061a extends ThreadPoolExecutor {
        public C0061a(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
            super(i, i2, j, timeUnit, blockingQueue, threadFactory);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        protected void afterExecute(Runnable runnable, Throwable th) {
            a.this.k.remove((Future) runnable);
            super.afterExecute(runnable, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements Executor {
        final LinkedList<Runnable> a;
        Runnable b;

        private b() {
            this.a = new LinkedList<>();
        }

        /* synthetic */ b(a aVar, com.baidu.fsg.base.b.b bVar) {
            this();
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(Runnable runnable) {
            this.a.offer(new e(this, runnable));
            if (this.b == null) {
                a();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public synchronized void a() {
            Runnable poll = this.a.poll();
            this.b = poll;
            if (poll != null) {
                a.this.p.execute(this.b);
            }
        }

        public synchronized void a(Runnable runnable) {
            this.a.remove(runnable);
        }
    }

    /* loaded from: classes3.dex */
    public class c {
        public String a;
        public Runnable b;
        public long c;
        public long d;
        public boolean e;
        long f;

        public c(long j, long j2, boolean z, String str, Runnable runnable) {
            this.d = j;
            this.f = System.currentTimeMillis() + j;
            this.c = j2;
            this.e = z;
            this.b = runnable;
            this.a = str;
        }
    }
}
