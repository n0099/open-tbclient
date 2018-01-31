package com.baidu.adp.lib.e;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int ajP;
    private int ajQ;
    private LinkedList<T> ajR;
    private c<T> ajS;

    public b(c<T> cVar, int i, int i2) {
        this.ajP = 10;
        this.ajQ = 0;
        this.ajR = null;
        this.ajS = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.ajS = cVar;
        this.ajP = i;
        this.ajQ = i2;
        this.ajR = new LinkedList<>();
        de(this.ajQ);
    }

    private void dd(int i) {
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    this.ajS.as(this.ajR.poll());
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
                    t = this.ajS.at(this.ajS.nl());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.ajR.offer(t);
                }
            }
        }
    }

    public void df(int i) {
        synchronized (this) {
            int i2 = i < this.ajQ ? this.ajQ : i;
            if (i2 <= 0) {
                i2 = 1;
            }
            this.ajP = i2;
            dd(this.ajR.size() - this.ajP);
        }
    }

    public void dg(int i) {
        synchronized (this) {
            if (i > this.ajP) {
                i = this.ajP;
            }
            this.ajQ = i;
            de(this.ajQ - this.ajR.size());
        }
    }

    public T nk() {
        T t = null;
        synchronized (this) {
            try {
                if (this.ajR.size() > 0) {
                    t = this.ajS.at(this.ajR.poll());
                } else {
                    t = this.ajS.at(this.ajS.nl());
                }
                de(this.ajQ - this.ajR.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void ar(T t) {
        T t2;
        synchronized (this) {
            if (this.ajR.size() < this.ajP) {
                try {
                    t2 = this.ajS.au(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.ajR.offer(t2);
                }
            } else {
                this.ajS.as(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.ajR.clear();
        }
    }
}
