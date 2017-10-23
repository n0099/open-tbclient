package com.baidu.adp.lib.e;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int vB;
    private int vC;
    private LinkedList<T> vD;
    private c<T> vE;

    public b(c<T> cVar, int i, int i2) {
        this.vB = 10;
        this.vC = 0;
        this.vD = null;
        this.vE = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.vE = cVar;
        this.vB = i;
        this.vC = i2;
        this.vD = new LinkedList<>();
        al(this.vC);
    }

    private void ak(int i) {
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    this.vE.n(this.vD.poll());
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
                    t = this.vE.o(this.vE.fI());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.vD.offer(t);
                }
            }
        }
    }

    public void am(int i) {
        synchronized (this) {
            int i2 = i < this.vC ? this.vC : i;
            if (i2 <= 0) {
                i2 = 1;
            }
            this.vB = i2;
            ak(this.vD.size() - this.vB);
        }
    }

    public void an(int i) {
        synchronized (this) {
            if (i > this.vB) {
                i = this.vB;
            }
            this.vC = i;
            al(this.vC - this.vD.size());
        }
    }

    public T fH() {
        T t = null;
        synchronized (this) {
            try {
                if (this.vD.size() > 0) {
                    t = this.vE.o(this.vD.poll());
                } else {
                    t = this.vE.o(this.vE.fI());
                }
                al(this.vC - this.vD.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void m(T t) {
        T t2;
        synchronized (this) {
            if (this.vD.size() < this.vB) {
                try {
                    t2 = this.vE.p(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.vD.offer(t2);
                }
            } else {
                this.vE.n(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.vD.clear();
        }
    }
}
