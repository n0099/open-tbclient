package com.baidu.adp.lib.f;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int vX;
    private int vY;
    private LinkedList<T> vZ;
    private c<T> wa;

    public b(c<T> cVar, int i, int i2) {
        this.vX = 10;
        this.vY = 0;
        this.vZ = null;
        this.wa = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.wa = cVar;
        this.vX = i;
        this.vY = i2;
        this.vZ = new LinkedList<>();
        ag(this.vY);
    }

    private void ag(int i) {
        T t;
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    t = this.wa.m(this.wa.hq());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.vZ.offer(t);
                }
            }
        }
    }

    public T hp() {
        T t = null;
        synchronized (this) {
            try {
                if (this.vZ.size() > 0) {
                    t = this.wa.m(this.vZ.poll());
                } else {
                    t = this.wa.m(this.wa.hq());
                }
                ag(this.vY - this.vZ.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void k(T t) {
        T t2;
        synchronized (this) {
            if (this.vZ.size() < this.vX) {
                try {
                    t2 = this.wa.n(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.vZ.offer(t2);
                }
            } else {
                this.wa.l(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.vZ.clear();
        }
    }
}
