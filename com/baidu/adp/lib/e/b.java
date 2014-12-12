package com.baidu.adp.lib.e;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int kY;
    private int kZ;
    private LinkedList<T> la;
    private c<T> lb;

    public b(c<T> cVar, int i, int i2) {
        this.kY = 10;
        this.kZ = 0;
        this.la = null;
        this.lb = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.lb = cVar;
        this.kY = i;
        this.kZ = i2;
        this.la = new LinkedList<>();
        Q(this.kZ);
    }

    private void Q(int i) {
        T t;
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    t = this.lb.l(this.lb.ed());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.la.offer(t);
                }
            }
        }
    }

    public T ec() {
        T t = null;
        synchronized (this) {
            try {
                if (this.la.size() > 0) {
                    t = this.lb.l(this.la.poll());
                } else {
                    t = this.lb.l(this.lb.ed());
                }
                Q(this.kZ - this.la.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void j(T t) {
        T t2;
        synchronized (this) {
            if (this.la.size() < this.kY) {
                try {
                    t2 = this.lb.m(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.la.offer(t2);
                }
            } else {
                this.lb.k(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.la.clear();
        }
    }
}
