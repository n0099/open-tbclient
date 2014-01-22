package com.baidu.adp.lib.asyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class k implements Runnable {
    private m<?> a;

    public k(m<?> mVar) {
        this.a = null;
        if (mVar == null) {
            throw new NullPointerException();
        }
        this.a = mVar;
    }

    public void a() {
        if (this.a != null) {
            try {
                this.a.run();
            } catch (OutOfMemoryError e) {
                com.baidu.adp.a.b.a().c();
                System.gc();
            }
        }
    }

    public void b() {
        if (this.a != null) {
            this.a.a();
        }
    }

    public BdAsyncTask<?, ?, ?> c() {
        if (this.a != null) {
            return this.a.b();
        }
        return null;
    }

    public int d() {
        try {
            return this.a.b().getPriority();
        } catch (Exception e) {
            return 1;
        }
    }

    public int e() {
        try {
            return this.a.b().getTag();
        } catch (Exception e) {
            return 0;
        }
    }

    public int f() {
        try {
            return this.a.b().getParallelTag();
        } catch (Exception e) {
            return 0;
        }
    }

    public String g() {
        try {
            return this.a.b().getKey();
        } catch (Exception e) {
            return null;
        }
    }

    public BdAsyncTaskParallelType h() {
        try {
            return this.a.b().getType();
        } catch (Exception e) {
            return BdAsyncTaskParallelType.MAX_PARALLEL;
        }
    }

    public boolean i() {
        try {
            return this.a.b().isSelfExecute();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean j() {
        try {
            return this.a.b().isImmediatelyExecut();
        } catch (Exception e) {
            return false;
        }
    }
}
