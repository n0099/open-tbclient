package com.baidu.ar.f;
/* loaded from: classes3.dex */
public class f<T> {
    private volatile T wk;
    private volatile int wl = 0;
    private String wm;

    public f(String str) {
        this.wm = str;
    }

    public T eW() {
        if (this.wk != null) {
            return this.wk;
        }
        if (isAvailable()) {
            synchronized (this) {
                if (this.wk == null) {
                    this.wk = (T) l.aN(this.wm);
                }
            }
        }
        return this.wk;
    }

    public T eX() {
        return this.wk;
    }

    public boolean isAvailable() {
        boolean z = false;
        if (this.wl == 1) {
            return true;
        }
        if (this.wl != -1) {
            try {
                Class.forName(this.wm);
                z = true;
            } catch (ClassNotFoundException e) {
            }
            synchronized (this) {
                this.wl = z ? 1 : -1;
            }
            return z;
        }
        return false;
    }

    public void release() {
        if (this.wk != null) {
            this.wk = null;
        }
    }
}
