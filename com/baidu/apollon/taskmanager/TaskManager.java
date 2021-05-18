package com.baidu.apollon.taskmanager;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.apollon.ApollonConstants;
import com.baidu.apollon.utils.ChannelUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public final class TaskManager {

    /* renamed from: b  reason: collision with root package name */
    public static final long f3985b = 1000;

    /* renamed from: e  reason: collision with root package name */
    public static final long f3988e = Long.MAX_VALUE;
    public static final int k = 5;
    public static final int l = 128;
    public static final int m = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f3986c = ApollonConstants.DEBUG;

    /* renamed from: d  reason: collision with root package name */
    public static final String f3987d = TaskManager.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, TaskManager> f3984a = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    public static TaskManager f3989h = null;

    /* renamed from: f  reason: collision with root package name */
    public long f3990f = Long.MAX_VALUE;

    /* renamed from: g  reason: collision with root package name */
    public Timer f3991g = new Timer();
    public final HashMap<Future<?>, Runnable> j = new HashMap<>();
    public BlockingQueue<Runnable> n = new LinkedBlockingQueue(10);
    public final ThreadFactory o = new ThreadFactory() { // from class: com.baidu.apollon.taskmanager.TaskManager.1

        /* renamed from: b  reason: collision with root package name */
        public final AtomicInteger f3994b = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "WalletTask #" + this.f3994b.getAndIncrement());
        }
    };
    public a p = new a(5, 128, 1, TimeUnit.SECONDS, this.n, this.o);
    public b q = new b();

    /* renamed from: i  reason: collision with root package name */
    public final HashMap<String, ArrayList<c>> f3992i = new HashMap<>();

    /* loaded from: classes.dex */
    public class a extends ThreadPoolExecutor {
        public a(int i2, int i3, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
            super(i2, i3, j, timeUnit, blockingQueue, threadFactory);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        public void afterExecute(Runnable runnable, Throwable th) {
            TaskManager.this.j.remove((Future) runnable);
            super.afterExecute(runnable, th);
        }
    }

    /* loaded from: classes.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public String f4005a;

        /* renamed from: b  reason: collision with root package name */
        public Runnable f4006b;

        /* renamed from: c  reason: collision with root package name */
        public long f4007c;

        /* renamed from: d  reason: collision with root package name */
        public long f4008d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f4009e;

        /* renamed from: f  reason: collision with root package name */
        public long f4010f;

        public c(long j, long j2, boolean z, String str, Runnable runnable) {
            this.f4008d = j;
            this.f4010f = System.currentTimeMillis() + j;
            this.f4007c = j2;
            this.f4009e = z;
            this.f4006b = runnable;
            this.f4005a = str;
        }
    }

    public TaskManager() {
        a aVar;
        if (!ChannelUtils.isSpecailPackage() || (aVar = this.p) == null) {
            return;
        }
        aVar.allowCoreThreadTimeOut(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(c cVar) {
        if (cVar.f4007c > 0) {
            cVar.f4008d = 0L;
        }
        if (cVar.f4009e) {
            this.q.execute(cVar.f4006b);
            return;
        }
        this.j.put(this.p.submit(cVar.f4006b), cVar.f4006b);
        if (f3986c) {
            String str = f3987d;
            Log.d(str, "execute task, " + cVar.f4005a + " execute time is " + System.currentTimeMillis());
        }
    }

    public static synchronized TaskManager getInstance(String str) {
        TaskManager taskManager;
        synchronized (TaskManager.class) {
            if (f3984a.get(str) == null) {
                TaskManager taskManager2 = new TaskManager();
                f3989h = taskManager2;
                f3984a.put(str, taskManager2);
            }
            taskManager = f3989h;
        }
        return taskManager;
    }

    public void cancelTask(String str, String str2) {
        synchronized (this.f3992i) {
            ArrayList<c> b2 = b(str);
            Iterator<c> it = b2.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.f4005a.equals(str2)) {
                    b(next);
                    b2.remove(next.f4005a);
                }
            }
        }
    }

    private ArrayList<c> b(String str) {
        ArrayList<c> arrayList = this.f3992i.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        this.f3992i.put(str, arrayList);
        return arrayList;
    }

    private void c(c cVar) {
        if (cVar.f4008d > 0) {
            a(cVar, cVar.f4010f - System.currentTimeMillis());
        } else {
            d(cVar);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Executor {

        /* renamed from: a  reason: collision with root package name */
        public final LinkedList<Runnable> f4000a;

        /* renamed from: b  reason: collision with root package name */
        public Runnable f4001b;

        public b() {
            this.f4000a = new LinkedList<>();
        }

        public synchronized void a() {
            Runnable poll = this.f4000a.poll();
            this.f4001b = poll;
            if (poll != null) {
                TaskManager.this.p.execute(this.f4001b);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(final Runnable runnable) {
            this.f4000a.offer(new Runnable() { // from class: com.baidu.apollon.taskmanager.TaskManager.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        b.this.a();
                    }
                }
            });
            if (this.f4001b == null) {
                a();
            }
        }

        public synchronized void a(Runnable runnable) {
            this.f4000a.remove(runnable);
        }
    }

    public boolean a(c cVar, String str) {
        if (cVar == null || cVar.f4006b == null) {
            return false;
        }
        synchronized (this.f3992i) {
            ArrayList<c> b2 = b(str);
            if (!a(cVar, b2)) {
                if (cVar.f4010f <= System.currentTimeMillis()) {
                    c(cVar);
                } else if (cVar.f4008d > 0) {
                    c(cVar);
                }
                if (cVar.f4007c > 0) {
                    cVar.f4010f = System.currentTimeMillis() + cVar.f4008d + cVar.f4007c;
                    b2.add(cVar);
                    a(cVar);
                }
            } else {
                b(cVar, str);
            }
        }
        return true;
    }

    private boolean b(c cVar, String str) {
        if (cVar == null || cVar.f4006b == null) {
            return false;
        }
        synchronized (this.f3992i) {
            ArrayList<c> b2 = b(str);
            c a2 = a(cVar.f4005a, b2);
            if (a2 != null) {
                b(a2);
                b2.remove(a2);
                a(cVar, str);
                return true;
            }
            return false;
        }
    }

    private void b(c cVar) {
        if (cVar.f4009e) {
            this.q.a(cVar.f4006b);
            return;
        }
        for (Future<?> future : this.j.keySet()) {
            if (this.j.get(future) == cVar.f4006b && future != null && (!future.isCancelled() || !future.isDone())) {
                future.cancel(true);
            }
        }
    }

    public void a(String str) {
        synchronized (this.f3992i) {
            ArrayList<c> b2 = b(str);
            Iterator<c> it = b2.iterator();
            while (it.hasNext()) {
                b(it.next());
            }
            b2.clear();
            this.f3992i.remove(str);
        }
    }

    private c a(String str, ArrayList<c> arrayList) {
        Iterator<c> it = arrayList.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (TextUtils.equals(str, next.f4005a)) {
                return next;
            }
        }
        return null;
    }

    private void a(c cVar) {
        long j = cVar.f4010f;
        if (j < this.f3990f) {
            a(Math.max(j - System.currentTimeMillis(), 1000L));
        }
    }

    private void a(long j) {
        if (f3986c) {
            String str = f3987d;
            Log.d(str, "intervalMillis: " + j);
        }
        Timer timer = this.f3991g;
        if (timer != null) {
            timer.cancel();
            this.f3991g = null;
        }
        this.f3991g = new Timer();
        this.f3991g.schedule(new TimerTask() { // from class: com.baidu.apollon.taskmanager.TaskManager.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                TaskManager.this.a();
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (f3986c) {
            Log.d(f3987d, "scheduleForPeriodTasks run");
        }
        synchronized (this.f3992i) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f3990f = Long.MAX_VALUE;
            for (String str : this.f3992i.keySet()) {
                ArrayList arrayList = new ArrayList();
                Iterator<c> it = b(str).iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.f4010f - currentTimeMillis < 1000) {
                        if (f3986c) {
                            String str2 = f3987d;
                            Log.d(str2, "task.mNextRunTime - current = " + (next.f4010f - currentTimeMillis));
                        }
                        c(next);
                        if (next.f4007c > 0) {
                            next.f4010f = next.f4007c + currentTimeMillis;
                            arrayList.add(next);
                        }
                    }
                    if (next.f4010f < this.f3990f) {
                        this.f3990f = next.f4010f;
                    }
                }
                if (this.f3990f < Long.MAX_VALUE) {
                    a(this.f3990f - currentTimeMillis);
                }
            }
        }
    }

    private boolean a(c cVar, ArrayList<c> arrayList) {
        Iterator<c> it = arrayList.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().f4005a, cVar.f4005a)) {
                return true;
            }
        }
        return false;
    }

    private void a(final c cVar, final long j) {
        this.p.execute(new Runnable() { // from class: com.baidu.apollon.taskmanager.TaskManager.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Thread.sleep(j);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                TaskManager.this.d(cVar);
            }
        });
    }
}
