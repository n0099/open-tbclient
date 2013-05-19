package com.baidu.adp.lib.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class l implements Runnable {
    private n a;

    public l(n nVar) {
        this.a = null;
        if (nVar == null) {
            throw new NullPointerException();
        }
        this.a = nVar;
    }

    public void a() {
        if (this.a != null) {
            this.a.run();
        }
    }

    public void b() {
        if (this.a != null) {
            this.a.a();
        }
    }

    public a c() {
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

    public o g() {
        try {
            return this.a.b().getType();
        } catch (Exception e) {
            return o.MAX_PARALLEL;
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
