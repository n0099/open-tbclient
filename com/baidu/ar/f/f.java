package com.baidu.ar.f;
/* loaded from: classes3.dex */
public class f<T> {
    private volatile T wK;
    private volatile int wL = 0;
    private String wM;

    public f(String str) {
        this.wM = str;
    }

    public T fm() {
        if (this.wK != null) {
            return this.wK;
        }
        if (isAvailable()) {
            synchronized (this) {
                if (this.wK == null) {
                    this.wK = (T) l.aO(this.wM);
                }
            }
        }
        return this.wK;
    }

    public T fn() {
        return this.wK;
    }

    public boolean isAvailable() {
        boolean z = false;
        if (this.wL == 1) {
            return true;
        }
        if (this.wL != -1) {
            try {
                Class.forName(this.wM);
                z = true;
            } catch (ClassNotFoundException e) {
            }
            synchronized (this) {
                this.wL = z ? 1 : -1;
            }
            return z;
        }
        return false;
    }

    public void release() {
        if (this.wK != null) {
            this.wK = null;
        }
    }
}
