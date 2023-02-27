package com.baidu.ar.h;
/* loaded from: classes.dex */
public class h<T> {
    public volatile T xY;
    public volatile int xZ = 0;
    public String ya;

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
        if (this.xZ == 1) {
            return true;
        }
        boolean z = false;
        if (this.xZ == -1) {
            return false;
        }
        try {
            Class.forName(this.ya);
            z = true;
        } catch (ClassNotFoundException unused) {
        }
        synchronized (this) {
            this.xZ = z ? 1 : -1;
        }
        return z;
    }

    public void release() {
        if (this.xY != null) {
            this.xY = null;
        }
    }
}
