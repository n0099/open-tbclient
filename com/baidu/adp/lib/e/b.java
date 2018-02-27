package com.baidu.adp.lib.e;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int ajI;
    private int ajJ;
    private LinkedList<T> ajK;
    private c<T> ajL;

    public b(c<T> cVar, int i, int i2) {
        this.ajI = 10;
        this.ajJ = 0;
        this.ajK = null;
        this.ajL = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.ajL = cVar;
        this.ajI = i;
        this.ajJ = i2;
        this.ajK = new LinkedList<>();
        de(this.ajJ);
    }

    private void dd(int i) {
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    this.ajL.as(this.ajK.poll());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    private void de(int i) {
        T t;
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    t = this.ajL.at(this.ajL.nl());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.ajK.offer(t);
                }
            }
        }
    }

    public void df(int i) {
        synchronized (this) {
            int i2 = i < this.ajJ ? this.ajJ : i;
            if (i2 <= 0) {
                i2 = 1;
            }
            this.ajI = i2;
            dd(this.ajK.size() - this.ajI);
        }
    }

    public void dg(int i) {
        synchronized (this) {
            if (i > this.ajI) {
                i = this.ajI;
            }
            this.ajJ = i;
            de(this.ajJ - this.ajK.size());
        }
    }

    public T nk() {
        T t = null;
        synchronized (this) {
            try {
                if (this.ajK.size() > 0) {
                    t = this.ajL.at(this.ajK.poll());
                } else {
                    t = this.ajL.at(this.ajL.nl());
                }
                de(this.ajJ - this.ajK.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void ar(T t) {
        T t2;
        synchronized (this) {
            if (this.ajK.size() < this.ajI) {
                try {
                    t2 = this.ajL.au(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.ajK.offer(t2);
                }
            } else {
                this.ajL.as(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.ajK.clear();
        }
    }
}
