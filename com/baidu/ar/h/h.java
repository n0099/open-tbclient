package com.baidu.ar.h;
/* loaded from: classes10.dex */
public class h<T> {
    private volatile T xY;
    private volatile int xZ = 0;
    private String ya;

    public h(String str) {
        this.ya = str;
    }

    public T gA() {
        if (this.xY != null) {
            return this.xY;
        }
        if (isAvailable()) {
            synchronized (this) {
                if (this.xY == null) {
                    this.xY = (T) n.aV(this.ya);
                }
            }
        }
        return this.xY;
    }

    public T gB() {
        return this.xY;
    }

    public boolean isAvailable() {
        boolean z = false;
        if (this.xZ == 1) {
            return true;
        }
        if (this.xZ != -1) {
            try {
                Class.forName(this.ya);
                z = true;
            } catch (ClassNotFoundException e) {
            }
            synchronized (this) {
                this.xZ = z ? 1 : -1;
            }
            return z;
        }
        return false;
    }

    public void release() {
        if (this.xY != null) {
            this.xY = null;
        }
    }
}
