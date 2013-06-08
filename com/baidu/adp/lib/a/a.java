package com.baidu.adp.lib.a;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class a {
    private static final h a = h.a();
    private static f b = new f(null);
    private static /* synthetic */ int[] l;
    private volatile e e = e.PENDING;
    private int f = 1;
    private String g = null;
    private String h = null;
    private o i = o.MAX_PARALLEL;
    private boolean j = false;
    private final AtomicBoolean k = new AtomicBoolean();
    private final g c = new b(this);
    private final n d = new c(this, this.c, this);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object a(Object... objArr);

    static /* synthetic */ int[] d() {
        int[] iArr = l;
        if (iArr == null) {
            iArr = new int[e.valuesCustom().length];
            try {
                iArr[e.FINISHED.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[e.PENDING.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[e.RUNNING.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            l = iArr;
        }
        return iArr;
    }

    public static void updateInternalHandler() {
        b = new f(null);
    }

    public static void removeAllTask(String str) {
        a.a(str);
    }

    public static void removeAllQueueTask(String str) {
        a.b(str);
    }

    public static a searchTask(String str) {
        return a.c(str);
    }

    public int setPriority(int i) {
        if (this.e != e.PENDING) {
            throw new IllegalStateException("the task is already running");
        }
        int i2 = this.f;
        this.f = i;
        return i2;
    }

    public int getPriority() {
        return this.f;
    }

    public String getTag() {
        return this.g;
    }

    public String setTag(String str) {
        if (this.e != e.PENDING) {
            throw new IllegalStateException("the task is already running");
        }
        String str2 = this.g;
        this.g = str;
        return str2;
    }

    public String getKey() {
        return this.h;
    }

    public String setKey(String str) {
        if (this.e != e.PENDING) {
            throw new IllegalStateException("the task is already running");
        }
        String str2 = this.h;
        this.h = str;
        return str2;
    }

    public o getType() {
        return this.i;
    }

    public void setType(o oVar) {
        if (this.e != e.PENDING) {
            throw new IllegalStateException("the task is already running");
        }
        this.i = oVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object c(Object obj) {
        synchronized (this) {
            if (this.k.get()) {
                return null;
            }
            this.k.set(true);
            b.obtainMessage(1, new d(this, obj)).sendToTarget();
            return obj;
        }
    }

    public final e getStatus() {
        return this.e;
    }

    public void cancel() {
        cancel(true);
    }

    protected void a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Object... objArr) {
    }

    protected void b(Object obj) {
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
    }

    public final boolean isCancelled() {
        return this.d.isCancelled();
    }

    public final boolean cancel(boolean z) {
        if (!this.j) {
            a.a(this);
        }
        boolean cancel = this.d.cancel(z);
        a();
        return cancel;
    }

    public final Object get() {
        return this.d.get();
    }

    public final Object get(long j, TimeUnit timeUnit) {
        return this.d.get(j, timeUnit);
    }

    public final a execute(Object... objArr) {
        return executeOnExecutor(a, objArr);
    }

    public final a executeOnExecutor(Executor executor, Object... objArr) {
        if (this.e != e.PENDING) {
            switch (d()[this.e.ordinal()]) {
                case 2:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case 3:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.e = e.RUNNING;
        b();
        this.c.b = objArr;
        executor.execute(this.d);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(Object... objArr) {
        if (!isCancelled()) {
            b.obtainMessage(2, new d(this, objArr)).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Object obj) {
        if (isCancelled()) {
            b(obj);
        } else {
            a(obj);
        }
        this.e = e.FINISHED;
    }

    public boolean isSelfExecute() {
        return this.j;
    }

    public void setSelfExecute(boolean z) {
        if (this.e != e.PENDING) {
            throw new IllegalStateException("the task is already running");
        }
        this.j = z;
    }
}
