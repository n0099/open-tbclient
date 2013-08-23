package com.baidu.adp.lib.asyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private l f362a;

    public j(l lVar) {
        this.f362a = null;
        if (lVar == null) {
            throw new NullPointerException();
        }
        this.f362a = lVar;
    }

    public void a() {
        if (this.f362a != null) {
            try {
                this.f362a.run();
            } catch (OutOfMemoryError e) {
                com.baidu.adp.a.b.a().c();
                System.gc();
            }
        }
    }

    public void b() {
        if (this.f362a != null) {
            this.f362a.a();
        }
    }

    public BdAsyncTask c() {
        if (this.f362a != null) {
            return this.f362a.b();
        }
        return null;
    }

    public int d() {
        try {
            return this.f362a.b().getPriority();
        } catch (Exception e) {
            return 1;
        }
    }

    public String e() {
        try {
            return this.f362a.b().getTag();
        } catch (Exception e) {
            return null;
        }
    }

    public String f() {
        try {
            return this.f362a.b().getKey();
        } catch (Exception e) {
            return null;
        }
    }

    public BdAsyncTaskType g() {
        try {
            return this.f362a.b().getType();
        } catch (Exception e) {
            return BdAsyncTaskType.MAX_PARALLEL;
        }
    }

    public boolean h() {
        try {
            return this.f362a.b().isSelfExecute();
        } catch (Exception e) {
            return false;
        }
    }
}
