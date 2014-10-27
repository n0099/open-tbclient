package com.baidu.adp.lib.e;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int kX;
    private int kY;
    private LinkedList<T> kZ;
    private c<T> la;

    public b(c<T> cVar, int i, int i2) {
        this.kX = 10;
        this.kY = 0;
        this.kZ = null;
        this.la = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.la = cVar;
        this.kX = i;
        this.kY = i2;
        this.kZ = new LinkedList<>();
        I(this.kY);
    }

    private void I(int i) {
        T t;
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    t = this.la.j(this.la.ee());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.kZ.offer(t);
                }
            }
        }
    }

    public T ed() {
        T t = null;
        synchronized (this) {
            try {
                if (this.kZ.size() > 0) {
                    t = this.la.j(this.kZ.poll());
                } else {
                    t = this.la.j(this.la.ee());
                }
                I(this.kY - this.kZ.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void h(T t) {
        T t2;
        synchronized (this) {
            if (this.kZ.size() < this.kX) {
                try {
                    t2 = this.la.k(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.kZ.offer(t2);
                }
            } else {
                this.la.i(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.kZ.clear();
        }
    }
}
