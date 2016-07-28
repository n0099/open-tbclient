package com.baidu.adp.lib.f;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int mu;
    private int mw;
    private LinkedList<T> mx;
    private c<T> my;

    public b(c<T> cVar, int i, int i2) {
        this.mu = 10;
        this.mw = 0;
        this.mx = null;
        this.my = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.my = cVar;
        this.mu = i;
        this.mw = i2;
        this.mx = new LinkedList<>();
        X(this.mw);
    }

    private void X(int i) {
        T t;
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    t = this.my.p(this.my.dE());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.mx.offer(t);
                }
            }
        }
    }

    public T dD() {
        T t = null;
        synchronized (this) {
            try {
                if (this.mx.size() > 0) {
                    t = this.my.p(this.mx.poll());
                } else {
                    t = this.my.p(this.my.dE());
                }
                X(this.mw - this.mx.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void n(T t) {
        T t2;
        synchronized (this) {
            if (this.mx.size() < this.mu) {
                try {
                    t2 = this.my.q(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.mx.offer(t2);
                }
            } else {
                this.my.o(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.mx.clear();
        }
    }
}
