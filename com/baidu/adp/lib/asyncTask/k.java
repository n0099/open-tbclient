package com.baidu.adp.lib.asyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private m<?> f417a;

    public k(m<?> mVar) {
        this.f417a = null;
        if (mVar == null) {
            throw new NullPointerException();
        }
        this.f417a = mVar;
    }

    public void a() {
        if (this.f417a != null) {
            try {
                this.f417a.run();
            } catch (OutOfMemoryError e) {
                com.baidu.adp.a.b.a().c();
                System.gc();
            }
        }
    }

    public void b() {
        if (this.f417a != null) {
            this.f417a.a();
        }
    }

    public BdAsyncTask<?, ?, ?> c() {
        if (this.f417a != null) {
            return this.f417a.b();
        }
        return null;
    }

    public int d() {
        try {
            return this.f417a.b().getPriority();
        } catch (Exception e) {
            return 1;
        }
    }

    public String e() {
        try {
            return this.f417a.b().getTag();
        } catch (Exception e) {
            return null;
        }
    }

    public String f() {
        try {
            return this.f417a.b().getKey();
        } catch (Exception e) {
            return null;
        }
    }

    public BdAsyncTaskType g() {
        try {
            return this.f417a.b().getType();
        } catch (Exception e) {
            return BdAsyncTaskType.MAX_PARALLEL;
        }
    }

    public boolean h() {
        try {
            return this.f417a.b().isSelfExecute();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean i() {
        try {
            return this.f417a.b().isImmediatelyExecut();
        } catch (Exception e) {
            return false;
        }
    }
}
