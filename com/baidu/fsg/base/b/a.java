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
    public static final long f5171a = 1000;

    /* renamed from: e  reason: collision with root package name */
    public static final long f5175e = Long.MAX_VALUE;

    /* renamed from: f  reason: collision with root package name */
    public static final int f5176f = 5;

    /* renamed from: g  reason: collision with root package name */
    public static final int f5177g = 128;

    /* renamed from: h  reason: collision with root package name */
    public static final int f5178h = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f5173c = ApollonConstants.DEBUG;

    /* renamed from: d  reason: collision with root package name */
    public static final String f5174d = a.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, a> f5172b = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    public static a f5179i = null;
    public final HashMap<Future<?>, Runnable> k = new HashMap<>();
    public final ThreadFactory l = new com.baidu.fsg.base.b.b(this);
    public long m = Long.MAX_VALUE;
    public Timer n = new Timer();
    public BlockingQueue<Runnable> o = new LinkedBlockingQueue(10);
    public C0077a p = new C0077a(5, 128, 1, TimeUnit.SECONDS, this.o, this.l);
    public b q = new b(this, null);
    public final HashMap<String, ArrayList<c>> j = new HashMap<>();

    /* renamed from: com.baidu.fsg.base.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0077a extends ThreadPoolExecutor {
        public C0077a(int i2, int i3, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
            super(i2, i3, j, timeUnit, blockingQueue, threadFactory);
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
        public String f5184a;

        /* renamed from: b  reason: collision with root package name */
        public Runnable f5185b;

        /* renamed from: c  reason: collision with root package name */
        public long f5186c;

        /* renamed from: d  reason: collision with root package name */
        public long f5187d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f5188e;

        /* renamed from: f  reason: collision with root package name */
        public long f5189f;

        public c(long j, long j2, boolean z, String str, Runnable runnable) {
            this.f5187d = j;
            this.f5189f = System.currentTimeMillis() + j;
            this.f5186c = j2;
            this.f5188e = z;
            this.f5185b = runnable;
            this.f5184a = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(c cVar) {
        if (cVar.f5186c > 0) {
            cVar.f5187d = 0L;
        }
        if (cVar.f5188e) {
            this.q.execute(cVar.f5185b);
            return;
        }
        this.k.put(this.p.submit(cVar.f5185b), cVar.f5185b);
        if (f5173c) {
            String str = f5174d;
            Log.d(str, "execute task, " + cVar.f5184a + " execute time is " + System.currentTimeMillis());
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Executor {

        /* renamed from: a  reason: collision with root package name */
        public final LinkedList<Runnable> f5181a;

        /* renamed from: b  reason: collision with root package name */
        public Runnable f5182b;

        public b() {
            this.f5181a = new LinkedList<>();
        }

        public synchronized void a() {
            Runnable poll = this.f5181a.poll();
            this.f5182b = poll;
            if (poll != null) {
                a.this.p.execute(this.f5182b);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(Runnable runnable) {
            this.f5181a.offer(new e(this, runnable));
            if (this.f5182b == null) {
                a();
            }
        }

        public /* synthetic */ b(a aVar, com.baidu.fsg.base.b.b bVar) {
            this();
        }

        public synchronized void a(Runnable runnable) {
            this.f5181a.remove(runnable);
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
            if (f5172b.get(str) == null) {
                a aVar2 = new a();
                f5179i = aVar2;
                f5172b.put(str, aVar2);
            }
            aVar = f5179i;
        }
        return aVar;
    }

    private void c(c cVar) {
        if (cVar.f5187d > 0) {
            a(cVar, cVar.f5189f - System.currentTimeMillis());
        } else {
            d(cVar);
        }
    }

    public boolean a(c cVar, String str) {
        if (cVar == null || cVar.f5185b == null) {
            return false;
        }
        synchronized (this.j) {
            ArrayList<c> c2 = c(str);
            if (!a(cVar, c2)) {
                if (cVar.f5189f <= System.currentTimeMillis()) {
                    c(cVar);
                } else if (cVar.f5187d > 0) {
                    c(cVar);
                }
                if (cVar.f5186c > 0) {
                    cVar.f5189f = System.currentTimeMillis() + cVar.f5187d + cVar.f5186c;
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
        if (cVar == null || cVar.f5185b == null) {
            return false;
        }
        synchronized (this.j) {
            ArrayList<c> c2 = c(str);
            c a2 = a(cVar.f5184a, c2);
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
        if (cVar.f5188e) {
            this.q.a(cVar.f5185b);
            return;
        }
        for (Future<?> future : this.k.keySet()) {
            if (this.k.get(future) == cVar.f5185b && future != null && (!future.isCancelled() || !future.isDone())) {
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
                if (next.f5184a.equals(str2)) {
                    b(next);
                    c2.remove(next.f5184a);
                }
            }
        }
    }

    private c a(String str, ArrayList<c> arrayList) {
        Iterator<c> it = arrayList.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (TextUtils.equals(str, next.f5184a)) {
                return next;
            }
        }
        return null;
    }

    private void a(c cVar) {
        long j = cVar.f5189f;
        if (j < this.m) {
            a(Math.max(j - System.currentTimeMillis(), 1000L));
        }
    }

    private void a(long j) {
        if (f5173c) {
            String str = f5174d;
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
        if (f5173c) {
            Log.d(f5174d, "scheduleForPeriodTasks run");
        }
        synchronized (this.j) {
            long currentTimeMillis = System.currentTimeMillis();
            this.m = Long.MAX_VALUE;
            for (String str : this.j.keySet()) {
                ArrayList arrayList = new ArrayList();
                Iterator<c> it = c(str).iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.f5189f - currentTimeMillis < 1000) {
                        if (f5173c) {
                            String str2 = f5174d;
                            Log.d(str2, "task.mNextRunTime - current = " + (next.f5189f - currentTimeMillis));
                        }
                        c(next);
                        if (next.f5186c > 0) {
                            next.f5189f = next.f5186c + currentTimeMillis;
                            arrayList.add(next);
                        }
                    }
                    if (next.f5189f < this.m) {
                        this.m = next.f5189f;
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
            if (TextUtils.equals(it.next().f5184a, cVar.f5184a)) {
                return true;
            }
        }
        return false;
    }

    private void a(c cVar, long j) {
        this.p.execute(new d(this, j, cVar));
    }
}
