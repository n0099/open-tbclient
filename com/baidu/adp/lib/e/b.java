package com.baidu.adp.lib.e;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int vA;
    private LinkedList<T> vB;
    private c<T> vC;
    private int vz;

    public b(c<T> cVar, int i, int i2) {
        this.vz = 10;
        this.vA = 0;
        this.vB = null;
        this.vC = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.vC = cVar;
        this.vz = i;
        this.vA = i2;
        this.vB = new LinkedList<>();
        ak(this.vA);
    }

    private void aj(int i) {
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    this.vC.n(this.vB.poll());
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
                    t = this.vC.o(this.vC.fI());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.vB.offer(t);
                }
            }
        }
    }

    public void al(int i) {
        synchronized (this) {
            int i2 = i < this.vA ? this.vA : i;
            if (i2 <= 0) {
                i2 = 1;
            }
            this.vz = i2;
            aj(this.vB.size() - this.vz);
        }
    }

    public void am(int i) {
        synchronized (this) {
            if (i > this.vz) {
                i = this.vz;
            }
            this.vA = i;
            ak(this.vA - this.vB.size());
        }
    }

    public T fH() {
        T t = null;
        synchronized (this) {
            try {
                if (this.vB.size() > 0) {
                    t = this.vC.o(this.vB.poll());
                } else {
                    t = this.vC.o(this.vC.fI());
                }
                ak(this.vA - this.vB.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void m(T t) {
        T t2;
        synchronized (this) {
            if (this.vB.size() < this.vz) {
                try {
                    t2 = this.vC.p(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.vB.offer(t2);
                }
            } else {
                this.vC.n(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.vB.clear();
        }
    }
}
