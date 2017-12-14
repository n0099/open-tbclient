package com.baidu.adp.lib.e;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private LinkedList<T> vA;
    private c<T> vB;
    private int vy;
    private int vz;

    public b(c<T> cVar, int i, int i2) {
        this.vy = 10;
        this.vz = 0;
        this.vA = null;
        this.vB = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.vB = cVar;
        this.vy = i;
        this.vz = i2;
        this.vA = new LinkedList<>();
        ak(this.vz);
    }

    private void aj(int i) {
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    this.vB.n(this.vA.poll());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    private void ak(int i) {
        T t;
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    t = this.vB.o(this.vB.fI());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.vA.offer(t);
                }
            }
        }
    }

    public void al(int i) {
        synchronized (this) {
            int i2 = i < this.vz ? this.vz : i;
            if (i2 <= 0) {
                i2 = 1;
            }
            this.vy = i2;
            aj(this.vA.size() - this.vy);
        }
    }

    public void am(int i) {
        synchronized (this) {
            if (i > this.vy) {
                i = this.vy;
            }
            this.vz = i;
            ak(this.vz - this.vA.size());
        }
    }

    public T fH() {
        T t = null;
        synchronized (this) {
            try {
                if (this.vA.size() > 0) {
                    t = this.vB.o(this.vA.poll());
                } else {
                    t = this.vB.o(this.vB.fI());
                }
                ak(this.vz - this.vA.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void m(T t) {
        T t2;
        synchronized (this) {
            if (this.vA.size() < this.vy) {
                try {
                    t2 = this.vB.p(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.vA.offer(t2);
                }
            } else {
                this.vB.n(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.vA.clear();
        }
    }
}
