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
    public static final long f5317a = 1000;

    /* renamed from: e  reason: collision with root package name */
    public static final long f5321e = Long.MAX_VALUE;

    /* renamed from: f  reason: collision with root package name */
    public static final int f5322f = 5;

    /* renamed from: g  reason: collision with root package name */
    public static final int f5323g = 128;

    /* renamed from: h  reason: collision with root package name */
    public static final int f5324h = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f5319c = ApollonConstants.DEBUG;

    /* renamed from: d  reason: collision with root package name */
    public static final String f5320d = a.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, a> f5318b = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    public static a f5325i = null;
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
        public C0078a(int i2, int i3, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
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
        public String f5330a;

        /* renamed from: b  reason: collision with root package name */
        public Runnable f5331b;

        /* renamed from: c  reason: collision with root package name */
        public long f5332c;

        /* renamed from: d  reason: collision with root package name */
        public long f5333d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f5334e;

        /* renamed from: f  reason: collision with root package name */
        public long f5335f;

        public c(long j, long j2, boolean z, String str, Runnable runnable) {
            this.f5333d = j;
            this.f5335f = System.currentTimeMillis() + j;
            this.f5332c = j2;
            this.f5334e = z;
            this.f5331b = runnable;
            this.f5330a = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(c cVar) {
        if (cVar.f5332c > 0) {
            cVar.f5333d = 0L;
        }
        if (cVar.f5334e) {
            this.q.execute(cVar.f5331b);
            return;
        }
        this.k.put(this.p.submit(cVar.f5331b), cVar.f5331b);
        if (f5319c) {
            String str = f5320d;
            Log.d(str, "execute task, " + cVar.f5330a + " execute time is " + System.currentTimeMillis());
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Executor {

        /* renamed from: a  reason: collision with root package name */
        public final LinkedList<Runnable> f5327a;

        /* renamed from: b  reason: collision with root package name */
        public Runnable f5328b;

        public b() {
            this.f5327a = new LinkedList<>();
        }

        public synchronized void a() {
            Runnable poll = this.f5327a.poll();
            this.f5328b = poll;
            if (poll != null) {
                a.this.p.execute(this.f5328b);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(Runnable runnable) {
            this.f5327a.offer(new e(this, runnable));
            if (this.f5328b == null) {
                a();
            }
        }

        public /* synthetic */ b(a aVar, com.baidu.fsg.base.b.b bVar) {
            this();
        }

        public synchronized void a(Runnable runnable) {
            this.f5327a.remove(runnable);
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
            if (f5318b.get(str) == null) {
                a aVar2 = new a();
                f5325i = aVar2;
                f5318b.put(str, aVar2);
            }
            aVar = f5325i;
        }
        return aVar;
    }

    private void c(c cVar) {
        if (cVar.f5333d > 0) {
            a(cVar, cVar.f5335f - System.currentTimeMillis());
        } else {
            d(cVar);
        }
    }

    public boolean a(c cVar, String str) {
        if (cVar == null || cVar.f5331b == null) {
            return false;
        }
        synchronized (this.j) {
            ArrayList<c> c2 = c(str);
            if (!a(cVar, c2)) {
                if (cVar.f5335f <= System.currentTimeMillis()) {
                    c(cVar);
                } else if (cVar.f5333d > 0) {
                    c(cVar);
                }
                if (cVar.f5332c > 0) {
                    cVar.f5335f = System.currentTimeMillis() + cVar.f5333d + cVar.f5332c;
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
        if (cVar == null || cVar.f5331b == null) {
            return false;
        }
        synchronized (this.j) {
            ArrayList<c> c2 = c(str);
            c a2 = a(cVar.f5330a, c2);
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
        if (cVar.f5334e) {
            this.q.a(cVar.f5331b);
            return;
        }
        for (Future<?> future : this.k.keySet()) {
            if (this.k.get(future) == cVar.f5331b && future != null && (!future.isCancelled() || !future.isDone())) {
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
                if (next.f5330a.equals(str2)) {
                    b(next);
                    c2.remove(next.f5330a);
                }
            }
        }
    }

    private c a(String str, ArrayList<c> arrayList) {
        Iterator<c> it = arrayList.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (TextUtils.equals(str, next.f5330a)) {
                return next;
            }
        }
        return null;
    }

    private void a(c cVar) {
        long j = cVar.f5335f;
        if (j < this.m) {
            a(Math.max(j - System.currentTimeMillis(), 1000L));
        }
    }

    private void a(long j) {
        if (f5319c) {
            String str = f5320d;
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
        if (f5319c) {
            Log.d(f5320d, "scheduleForPeriodTasks run");
        }
        synchronized (this.j) {
            long currentTimeMillis = System.currentTimeMillis();
            this.m = Long.MAX_VALUE;
            for (String str : this.j.keySet()) {
                ArrayList arrayList = new ArrayList();
                Iterator<c> it = c(str).iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.f5335f - currentTimeMillis < 1000) {
                        if (f5319c) {
                            String str2 = f5320d;
                            Log.d(str2, "task.mNextRunTime - current = " + (next.f5335f - currentTimeMillis));
                        }
                        c(next);
                        if (next.f5332c > 0) {
                            next.f5335f = next.f5332c + currentTimeMillis;
                            arrayList.add(next);
                        }
                    }
                    if (next.f5335f < this.m) {
                        this.m = next.f5335f;
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
            if (TextUtils.equals(it.next().f5330a, cVar.f5330a)) {
                return true;
            }
        }
        return false;
    }

    private void a(c cVar, long j) {
        this.p.execute(new d(this, j, cVar));
    }
}
