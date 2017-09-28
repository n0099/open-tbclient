package com.baidu.adp.lib.e;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int vA;
    private int vB;
    private LinkedList<T> vC;
    private c<T> vD;

    public b(c<T> cVar, int i, int i2) {
        this.vA = 10;
        this.vB = 0;
        this.vC = null;
        this.vD = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.vD = cVar;
        this.vA = i;
        this.vB = i2;
        this.vC = new LinkedList<>();
        al(this.vB);
    }

    private void ak(int i) {
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    this.vD.n(this.vC.poll());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    private void al(int i) {
        T t;
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    t = this.vD.o(this.vD.fI());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.vC.offer(t);
                }
            }
        }
    }

    public void am(int i) {
        synchronized (this) {
            int i2 = i < this.vB ? this.vB : i;
            if (i2 <= 0) {
                i2 = 1;
            }
            this.vA = i2;
            ak(this.vC.size() - this.vA);
        }
    }

    public void an(int i) {
        synchronized (this) {
            if (i > this.vA) {
                i = this.vA;
            }
            this.vB = i;
            al(this.vB - this.vC.size());
        }
    }

    public T fH() {
        T t = null;
        synchronized (this) {
            try {
                if (this.vC.size() > 0) {
                    t = this.vD.o(this.vC.poll());
                } else {
                    t = this.vD.o(this.vD.fI());
                }
                al(this.vB - this.vC.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void m(T t) {
        T t2;
        synchronized (this) {
            if (this.vC.size() < this.vA) {
                try {
                    t2 = this.vD.p(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.vC.offer(t2);
                }
            } else {
                this.vD.n(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.vC.clear();
        }
    }
}
