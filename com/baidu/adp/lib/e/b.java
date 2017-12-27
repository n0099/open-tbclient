package com.baidu.adp.lib.e;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int ajM;
    private int ajN;
    private LinkedList<T> ajO;
    private c<T> ajP;

    public b(c<T> cVar, int i, int i2) {
        this.ajM = 10;
        this.ajN = 0;
        this.ajO = null;
        this.ajP = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.ajP = cVar;
        this.ajM = i;
        this.ajN = i2;
        this.ajO = new LinkedList<>();
        de(this.ajN);
    }

    private void dd(int i) {
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    this.ajP.as(this.ajO.poll());
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
                    t = this.ajP.at(this.ajP.nk());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.ajO.offer(t);
                }
            }
        }
    }

    public void df(int i) {
        synchronized (this) {
            int i2 = i < this.ajN ? this.ajN : i;
            if (i2 <= 0) {
                i2 = 1;
            }
            this.ajM = i2;
            dd(this.ajO.size() - this.ajM);
        }
    }

    public void dg(int i) {
        synchronized (this) {
            if (i > this.ajM) {
                i = this.ajM;
            }
            this.ajN = i;
            de(this.ajN - this.ajO.size());
        }
    }

    public T nj() {
        T t = null;
        synchronized (this) {
            try {
                if (this.ajO.size() > 0) {
                    t = this.ajP.at(this.ajO.poll());
                } else {
                    t = this.ajP.at(this.ajP.nk());
                }
                de(this.ajN - this.ajO.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void ar(T t) {
        T t2;
        synchronized (this) {
            if (this.ajO.size() < this.ajM) {
                try {
                    t2 = this.ajP.au(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.ajO.offer(t2);
                }
            } else {
                this.ajP.as(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.ajO.clear();
        }
    }
}
