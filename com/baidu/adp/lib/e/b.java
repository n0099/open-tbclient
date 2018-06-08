package com.baidu.adp.lib.e;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int Ao;
    private int Ap;
    private LinkedList<T> Aq;
    private c<T> Ar;

    public b(c<T> cVar, int i, int i2) {
        this.Ao = 10;
        this.Ap = 0;
        this.Aq = null;
        this.Ar = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.Ar = cVar;
        this.Ao = i;
        this.Ap = i2;
        this.Aq = new LinkedList<>();
        af(this.Ap);
    }

    private void ae(int i) {
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    this.Ar.q(this.Aq.poll());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    private void af(int i) {
        T t;
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    t = this.Ar.r(this.Ar.mo9if());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.Aq.offer(t);
                }
            }
        }
    }

    public void ag(int i) {
        synchronized (this) {
            int i2 = i < this.Ap ? this.Ap : i;
            if (i2 <= 0) {
                i2 = 1;
            }
            this.Ao = i2;
            ae(this.Aq.size() - this.Ao);
        }
    }

    public void ah(int i) {
        synchronized (this) {
            if (i > this.Ao) {
                i = this.Ao;
            }
            this.Ap = i;
            af(this.Ap - this.Aq.size());
        }
    }

    public T ie() {
        T t = null;
        synchronized (this) {
            try {
                if (this.Aq.size() > 0) {
                    t = this.Ar.r(this.Aq.poll());
                } else {
                    t = this.Ar.r(this.Ar.mo9if());
                }
                af(this.Ap - this.Aq.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void p(T t) {
        T t2;
        synchronized (this) {
            if (this.Aq.size() < this.Ao) {
                try {
                    t2 = this.Ar.s(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.Aq.offer(t2);
                }
            } else {
                this.Ar.q(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.Aq.clear();
        }
    }
}
