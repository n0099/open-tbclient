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
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final long f5187a = 1000;

    /* renamed from: e  reason: collision with root package name */
    public static final long f5191e = Long.MAX_VALUE;

    /* renamed from: f  reason: collision with root package name */
    public static final int f5192f = 5;

    /* renamed from: g  reason: collision with root package name */
    public static final int f5193g = 128;

    /* renamed from: h  reason: collision with root package name */
    public static final int f5194h = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f5189c = ApollonConstants.DEBUG;

    /* renamed from: d  reason: collision with root package name */
    public static final String f5190d = a.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, a> f5188b = new HashMap<>();
    public static a i = null;
    public final HashMap<Future<?>, Runnable> k = new HashMap<>();
    public final ThreadFactory l = new com.baidu.fsg.base.b.b(this);
    public long m = Long.MAX_VALUE;
    public Timer n = new Timer();
    public BlockingQueue<Runnable> o = new LinkedBlockingQueue(10);
    public C0078a p = new C0078a(5, 128, 1, TimeUnit.SECONDS, this.o, this.l);
    public b q = new b(this, null);
    public final HashMap<String, ArrayList<c>> j = new HashMap<>();

    /* renamed from: com.baidu.fsg.base.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0078a extends ThreadPoolExecutor {
        public C0078a(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
            super(i, i2, j, timeUnit, blockingQueue, threadFactory);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        public void afterExecute(Runnable runnable, Throwable th) {
            a.this.k.remove((Future) runnable);
            super.afterExecute(runnable, th);
        }
    }

    /* loaded from: classes2.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public String f5199a;

        /* renamed from: b  reason: collision with root package name */
        public Runnable f5200b;

        /* renamed from: c  reason: collision with root package name */
        public long f5201c;

        /* renamed from: d  reason: collision with root package name */
        public long f5202d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f5203e;

        /* renamed from: f  reason: collision with root package name */
        public long f5204f;

        public c(long j, long j2, boolean z, String str, Runnable runnable) {
            this.f5202d = j;
            this.f5204f = System.currentTimeMillis() + j;
            this.f5201c = j2;
            this.f5203e = z;
            this.f5200b = runnable;
            this.f5199a = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(c cVar) {
        if (cVar.f5201c > 0) {
            cVar.f5202d = 0L;
        }
        if (cVar.f5203e) {
            this.q.execute(cVar.f5200b);
            return;
        }
        this.k.put(this.p.submit(cVar.f5200b), cVar.f5200b);
        if (f5189c) {
            String str = f5190d;
            Log.d(str, "execute task, " + cVar.f5199a + " execute time is " + System.currentTimeMillis());
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Executor {

        /* renamed from: a  reason: collision with root package name */
        public final LinkedList<Runnable> f5196a;

        /* renamed from: b  reason: collision with root package name */
        public Runnable f5197b;

        public b() {
            this.f5196a = new LinkedList<>();
        }

        public synchronized void a() {
            Runnable poll = this.f5196a.poll();
            this.f5197b = poll;
            if (poll != null) {
                a.this.p.execute(this.f5197b);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(Runnable runnable) {
            this.f5196a.offer(new e(this, runnable));
            if (this.f5197b == null) {
                a();
            }
        }

        public /* synthetic */ b(a aVar, com.baidu.fsg.base.b.b bVar) {
            this();
        }

        public synchronized void a(Runnable runnable) {
            this.f5196a.remove(runnable);
        }
    }

    private ArrayList<c> c(String str) {
        ArrayList<c> arrayList = this.j.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        this.j.put(str, arrayList);
        return arrayList;
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

    public static synchronized a a(String str) {
        a aVar;
        synchronized (a.class) {
            if (f5188b.get(str) == null) {
                a aVar2 = new a();
                i = aVar2;
                f5188b.put(str, aVar2);
            }
            aVar = i;
        }
        return aVar;
    }

    private void c(c cVar) {
        if (cVar.f5202d > 0) {
            a(cVar, cVar.f5204f - System.currentTimeMillis());
        } else {
            d(cVar);
        }
    }

    public boolean a(c cVar, String str) {
        if (cVar == null || cVar.f5200b == null) {
            return false;
        }
        synchronized (this.j) {
            ArrayList<c> c2 = c(str);
            if (!a(cVar, c2)) {
                if (cVar.f5204f <= System.currentTimeMillis()) {
                    c(cVar);
                } else if (cVar.f5202d > 0) {
                    c(cVar);
                }
                if (cVar.f5201c > 0) {
                    cVar.f5204f = System.currentTimeMillis() + cVar.f5202d + cVar.f5201c;
                    c2.add(cVar);
                    a(cVar);
                }
            } else {
                b(cVar, str);
            }
        }
        return true;
    }

    private boolean b(c cVar, String str) {
        if (cVar == null || cVar.f5200b == null) {
            return false;
        }
        synchronized (this.j) {
            ArrayList<c> c2 = c(str);
            c a2 = a(cVar.f5199a, c2);
            if (a2 != null) {
                b(a2);
                c2.remove(a2);
                a(cVar, str);
                return true;
            }
            return false;
        }
    }

    private void b(c cVar) {
        if (cVar.f5203e) {
            this.q.a(cVar.f5200b);
            return;
        }
        for (Future<?> future : this.k.keySet()) {
            if (this.k.get(future) == cVar.f5200b && future != null && (!future.isCancelled() || !future.isDone())) {
                future.cancel(true);
            }
        }
    }

    public void a(String str, String str2) {
        synchronized (this.j) {
            ArrayList<c> c2 = c(str);
            Iterator<c> it = c2.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.f5199a.equals(str2)) {
                    b(next);
                    c2.remove(next.f5199a);
                }
            }
        }
    }

    private c a(String str, ArrayList<c> arrayList) {
        Iterator<c> it = arrayList.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (TextUtils.equals(str, next.f5199a)) {
                return next;
            }
        }
        return null;
    }

    private void a(c cVar) {
        long j = cVar.f5204f;
        if (j < this.m) {
            a(Math.max(j - System.currentTimeMillis(), 1000L));
        }
    }

    private void a(long j) {
        if (f5189c) {
            String str = f5190d;
            Log.d(str, "intervalMillis: " + j);
        }
        Timer timer = this.n;
        if (timer != null) {
            timer.cancel();
            this.n = null;
        }
        this.n = new Timer();
        this.n.schedule(new com.baidu.fsg.base.b.c(this), j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (f5189c) {
            Log.d(f5190d, "scheduleForPeriodTasks run");
        }
        synchronized (this.j) {
            long currentTimeMillis = System.currentTimeMillis();
            this.m = Long.MAX_VALUE;
            for (String str : this.j.keySet()) {
                ArrayList arrayList = new ArrayList();
                Iterator<c> it = c(str).iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.f5204f - currentTimeMillis < 1000) {
                        if (f5189c) {
                            String str2 = f5190d;
                            Log.d(str2, "task.mNextRunTime - current = " + (next.f5204f - currentTimeMillis));
                        }
                        c(next);
                        if (next.f5201c > 0) {
                            next.f5204f = next.f5201c + currentTimeMillis;
                            arrayList.add(next);
                        }
                    }
                    if (next.f5204f < this.m) {
                        this.m = next.f5204f;
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
            if (TextUtils.equals(it.next().f5199a, cVar.f5199a)) {
                return true;
            }
        }
        return false;
    }

    private void a(c cVar, long j) {
        this.p.execute(new d(this, j, cVar));
    }
}
