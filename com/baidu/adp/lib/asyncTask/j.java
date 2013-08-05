package com.baidu.adp.lib.asyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private l f357a;

    public j(l lVar) {
        this.f357a = null;
        if (lVar == null) {
            throw new NullPointerException();
        }
        this.f357a = lVar;
    }

    public void a() {
        if (this.f357a != null) {
            try {
                this.f357a.run();
            } catch (OutOfMemoryError e) {
                com.baidu.adp.a.b.a().c();
                System.gc();
            }
        }
    }

    public void b() {
        if (this.f357a != null) {
            this.f357a.a();
        }
    }

    public BdAsyncTask c() {
        if (this.f357a != null) {
            return this.f357a.b();
        }
        return null;
    }

    public int d() {
        try {
            return this.f357a.b().getPriority();
        } catch (Exception e) {
            return 1;
        }
    }

    public String e() {
        try {
            return this.f357a.b().getTag();
        } catch (Exception e) {
            return null;
        }
    }

    public String f() {
        try {
            return this.f357a.b().getKey();
        } catch (Exception e) {
            return null;
        }
    }

    public BdAsyncTaskType g() {
        try {
            return this.f357a.b().getType();
        } catch (Exception e) {
            return BdAsyncTaskType.MAX_PARALLEL;
        }
    }

    public boolean h() {
        try {
            return this.f357a.b().isSelfExecute();
        } catch (Exception e) {
            return false;
        }
    }
}
