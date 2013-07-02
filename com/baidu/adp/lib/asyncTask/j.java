package com.baidu.adp.lib.asyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class j implements Runnable {
    private l a;

    public j(l lVar) {
        this.a = null;
        if (lVar == null) {
            throw new NullPointerException();
        }
        this.a = lVar;
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

    public BdAsyncTask c() {
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

    public String e() {
        try {
            return this.a.b().getTag();
        } catch (Exception e) {
            return null;
        }
    }

    public String f() {
        try {
            return this.a.b().getKey();
        } catch (Exception e) {
            return null;
        }
    }

    public BdAsyncTaskType g() {
        try {
            return this.a.b().getType();
        } catch (Exception e) {
            return BdAsyncTaskType.MAX_PARALLEL;
        }
    }

    public boolean h() {
        try {
            return this.a.b().isSelfExecute();
        } catch (Exception e) {
            return false;
        }
    }
}
