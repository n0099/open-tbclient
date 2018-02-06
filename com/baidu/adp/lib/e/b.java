package com.baidu.adp.lib.e;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int ajO;
    private int ajP;
    private LinkedList<T> ajQ;
    private c<T> ajR;

    public b(c<T> cVar, int i, int i2) {
        this.ajO = 10;
        this.ajP = 0;
        this.ajQ = null;
        this.ajR = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.ajR = cVar;
        this.ajO = i;
        this.ajP = i2;
        this.ajQ = new LinkedList<>();
        de(this.ajP);
    }

    private void dd(int i) {
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    this.ajR.as(this.ajQ.poll());
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
                    t = this.ajR.at(this.ajR.nl());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.ajQ.offer(t);
                }
            }
        }
    }

    public void df(int i) {
        synchronized (this) {
            int i2 = i < this.ajP ? this.ajP : i;
            if (i2 <= 0) {
                i2 = 1;
            }
            this.ajO = i2;
            dd(this.ajQ.size() - this.ajO);
        }
    }

    public void dg(int i) {
        synchronized (this) {
            if (i > this.ajO) {
                i = this.ajO;
            }
            this.ajP = i;
            de(this.ajP - this.ajQ.size());
        }
    }

    public T nk() {
        T t = null;
        synchronized (this) {
            try {
                if (this.ajQ.size() > 0) {
                    t = this.ajR.at(this.ajQ.poll());
                } else {
                    t = this.ajR.at(this.ajR.nl());
                }
                de(this.ajP - this.ajQ.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void ar(T t) {
        T t2;
        synchronized (this) {
            if (this.ajQ.size() < this.ajO) {
                try {
                    t2 = this.ajR.au(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.ajQ.offer(t2);
                }
            } else {
                this.ajR.as(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.ajQ.clear();
        }
    }
}
