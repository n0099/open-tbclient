package com.baidu.adp.lib.e;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int lb;
    private int lc;
    private LinkedList<T> ld;
    private c<T> le;

    public b(c<T> cVar, int i, int i2) {
        this.lb = 10;
        this.lc = 0;
        this.ld = null;
        this.le = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.le = cVar;
        this.lb = i;
        this.lc = i2;
        this.ld = new LinkedList<>();
        V(this.lc);
    }

    private void V(int i) {
        T t;
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    t = this.le.l(this.le.eb());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.ld.offer(t);
                }
            }
        }
    }

    public T ea() {
        T t = null;
        synchronized (this) {
            try {
                if (this.ld.size() > 0) {
                    t = this.le.l(this.ld.poll());
                } else {
                    t = this.le.l(this.le.eb());
                }
                V(this.lc - this.ld.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void j(T t) {
        T t2;
        synchronized (this) {
            if (this.ld.size() < this.lb) {
                try {
                    t2 = this.le.m(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.ld.offer(t2);
                }
            } else {
                this.le.k(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.ld.clear();
        }
    }
}
