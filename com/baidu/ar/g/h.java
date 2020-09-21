package com.baidu.ar.g;
/* loaded from: classes10.dex */
public class h<T> {
    private volatile T xj;
    private volatile int xk = 0;
    private String xl;

    public h(String str) {
        this.xl = str;
    }

    public T gA() {
        if (this.xj != null) {
            return this.xj;
        }
        if (isAvailable()) {
            synchronized (this) {
                if (this.xj == null) {
                    this.xj = (T) n.aS(this.xl);
                }
            }
        }
        return this.xj;
    }

    public T gB() {
        return this.xj;
    }

    public boolean isAvailable() {
        boolean z = false;
        if (this.xk == 1) {
            return true;
        }
        if (this.xk != -1) {
            try {
                Class.forName(this.xl);
                z = true;
            } catch (ClassNotFoundException e) {
            }
            synchronized (this) {
                this.xk = z ? 1 : -1;
            }
            return z;
        }
        return false;
    }

    public void release() {
        if (this.xj != null) {
            this.xj = null;
        }
    }
}
