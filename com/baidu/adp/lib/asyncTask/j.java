package com.baidu.adp.lib.asyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class j implements Runnable {
    private l<?> a;

    public int a() {
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

    public void b() {
        if (this.a != null) {
            try {
                this.a.run();
            } catch (OutOfMemoryError e) {
                com.baidu.adp.a.b.a().e();
                System.gc();
            }
        }
    }

    public void c() {
        if (this.a != null) {
            this.a.a();
        }
    }

    public BdAsyncTask<?, ?, ?> d() {
        if (this.a != null) {
            return this.a.b();
        }
        return null;
    }

    public int e() {
        try {
            return this.a.b().getPriority();
        } catch (Exception e) {
            return 1;
        }
    }

    public boolean f() {
        try {
            return this.a.b().getNeedImmediatelyCancel();
        } catch (Exception e) {
            return false;
        }
    }

    public void a(boolean z) {
        try {
            this.a.b().setIsTimeout(z);
        } catch (Exception e) {
        }
    }

    public int g() {
        try {
            return this.a.b().getTag();
        } catch (Exception e) {
            return 0;
        }
    }

    public int h() {
        try {
            return this.a.b().getParallelTag();
        } catch (Exception e) {
            return 0;
        }
    }

    public String i() {
        try {
            return this.a.b().getKey();
        } catch (Exception e) {
            return null;
        }
    }

    public BdAsyncTaskParallelType j() {
        try {
            return this.a.b().getType();
        } catch (Exception e) {
            return BdAsyncTaskParallelType.MAX_PARALLEL;
        }
    }

    public boolean k() {
        try {
            return this.a.b().isSelfExecute();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean l() {
        try {
            return this.a.b().isImmediatelyExecut();
        } catch (Exception e) {
            return false;
        }
    }
}
