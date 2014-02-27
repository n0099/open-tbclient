package com.baidu.adp.lib.asyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class j implements Runnable {
    private l<?> a;

    public final int a() {
        try {
            return this.a.b().getTaskMaxTime();
        } catch (Exception e) {
            return 120000;
        }
    }

    public j(l<?> lVar) {
        this.a = null;
        if (lVar == null) {
            throw new NullPointerException();
        }
        this.a = lVar;
    }

    public final void b() {
        if (this.a != null) {
            try {
                this.a.run();
            } catch (OutOfMemoryError e) {
                com.baidu.adp.a.b.a().e();
                System.gc();
            }
        }
    }

    public final void c() {
        if (this.a != null) {
            this.a.a();
        }
    }

    public final BdAsyncTask<?, ?, ?> d() {
        if (this.a != null) {
            return this.a.b();
        }
        return null;
    }

    public final int e() {
        try {
            return this.a.b().getPriority();
        } catch (Exception e) {
            return 1;
        }
    }

    public final boolean f() {
        try {
            return this.a.b().getNeedImmediatelyCancel();
        } catch (Exception e) {
            return false;
        }
    }

    public final void a(boolean z) {
        try {
            this.a.b().setIsTimeout(true);
        } catch (Exception e) {
        }
    }

    public final int g() {
        try {
            return this.a.b().getTag();
        } catch (Exception e) {
            return 0;
        }
    }

    public final int h() {
        try {
            return this.a.b().getParallelTag();
        } catch (Exception e) {
            return 0;
        }
    }

    public final String i() {
        try {
            return this.a.b().getKey();
        } catch (Exception e) {
            return null;
        }
    }

    public final BdAsyncTaskParallelType j() {
        try {
            return this.a.b().getType();
        } catch (Exception e) {
            return BdAsyncTaskParallelType.MAX_PARALLEL;
        }
    }

    public final boolean k() {
        try {
            return this.a.b().isSelfExecute();
        } catch (Exception e) {
            return false;
        }
    }

    public final boolean l() {
        try {
            return this.a.b().isImmediatelyExecut();
        } catch (Exception e) {
            return false;
        }
    }
}
