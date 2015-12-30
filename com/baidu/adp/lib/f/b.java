package com.baidu.adp.lib.f;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int vw;
    private int vx;
    private LinkedList<T> vy;
    private c<T> vz;

    public b(c<T> cVar, int i, int i2) {
        this.vw = 10;
        this.vx = 0;
        this.vy = null;
        this.vz = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.vz = cVar;
        this.vw = i;
        this.vx = i2;
        this.vy = new LinkedList<>();
        W(this.vx);
    }

    private void W(int i) {
        T t;
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    t = this.vz.m(this.vz.hc());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.vy.offer(t);
                }
            }
        }
    }

    public T hb() {
        T t = null;
        synchronized (this) {
            try {
                if (this.vy.size() > 0) {
                    t = this.vz.m(this.vy.poll());
                } else {
                    t = this.vz.m(this.vz.hc());
                }
                W(this.vx - this.vy.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void k(T t) {
        T t2;
        synchronized (this) {
            if (this.vy.size() < this.vw) {
                try {
                    t2 = this.vz.n(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.vy.offer(t2);
                }
            } else {
                this.vz.l(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.vy.clear();
        }
    }
}
