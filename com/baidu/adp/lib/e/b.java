package com.baidu.adp.lib.e;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int Ds;
    private int Dt;
    private LinkedList<T> Du;
    private c<T> Dv;

    public b(c<T> cVar, int i, int i2) {
        this.Ds = 10;
        this.Dt = 0;
        this.Du = null;
        this.Dv = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.Dv = cVar;
        this.Ds = i;
        this.Dt = i2;
        this.Du = new LinkedList<>();
        aF(this.Dt);
    }

    private void aE(int i) {
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    this.Dv.u(this.Du.poll());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    private void aF(int i) {
        T t;
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    t = this.Dv.v(this.Dv.jz());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.Du.offer(t);
                }
            }
        }
    }

    public void aG(int i) {
        synchronized (this) {
            int i2 = i < this.Dt ? this.Dt : i;
            if (i2 <= 0) {
                i2 = 1;
            }
            this.Ds = i2;
            aE(this.Du.size() - this.Ds);
        }
    }

    public void aH(int i) {
        synchronized (this) {
            if (i > this.Ds) {
                i = this.Ds;
            }
            this.Dt = i;
            aF(this.Dt - this.Du.size());
        }
    }

    public T jy() {
        T t = null;
        synchronized (this) {
            try {
                if (this.Du.size() > 0) {
                    t = this.Dv.v(this.Du.poll());
                } else {
                    t = this.Dv.v(this.Dv.jz());
                }
                aF(this.Dt - this.Du.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void t(T t) {
        T t2;
        synchronized (this) {
            if (this.Du.size() < this.Ds) {
                try {
                    t2 = this.Dv.w(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.Du.offer(t2);
                }
            } else {
                this.Dv.u(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.Du.clear();
        }
    }
}
