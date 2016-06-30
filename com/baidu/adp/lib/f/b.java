package com.baidu.adp.lib.f;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int lQ;
    private int lR;
    private LinkedList<T> lS;
    private c<T> lT;

    public b(c<T> cVar, int i, int i2) {
        this.lQ = 10;
        this.lR = 0;
        this.lS = null;
        this.lT = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.lT = cVar;
        this.lQ = i;
        this.lR = i2;
        this.lS = new LinkedList<>();
        U(this.lR);
    }

    private void U(int i) {
        T t;
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    t = this.lT.m(this.lT.dF());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.lS.offer(t);
                }
            }
        }
    }

    public T dE() {
        T t = null;
        synchronized (this) {
            try {
                if (this.lS.size() > 0) {
                    t = this.lT.m(this.lS.poll());
                } else {
                    t = this.lT.m(this.lT.dF());
                }
                U(this.lR - this.lS.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void k(T t) {
        T t2;
        synchronized (this) {
            if (this.lS.size() < this.lQ) {
                try {
                    t2 = this.lT.n(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.lS.offer(t2);
                }
            } else {
                this.lT.l(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.lS.clear();
        }
    }
}
