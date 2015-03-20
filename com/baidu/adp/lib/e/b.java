package com.baidu.adp.lib.e;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int wp;
    private int wq;
    private LinkedList<T> wr;
    private c<T> ws;

    public b(c<T> cVar, int i, int i2) {
        this.wp = 10;
        this.wq = 0;
        this.wr = null;
        this.ws = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.ws = cVar;
        this.wp = i;
        this.wq = i2;
        this.wr = new LinkedList<>();
        W(this.wq);
    }

    private void W(int i) {
        T t;
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    t = this.ws.l(this.ws.hA());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.wr.offer(t);
                }
            }
        }
    }

    public T hz() {
        T t = null;
        synchronized (this) {
            try {
                if (this.wr.size() > 0) {
                    t = this.ws.l(this.wr.poll());
                } else {
                    t = this.ws.l(this.ws.hA());
                }
                W(this.wq - this.wr.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void j(T t) {
        T t2;
        synchronized (this) {
            if (this.wr.size() < this.wp) {
                try {
                    t2 = this.ws.m(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.wr.offer(t2);
                }
            } else {
                this.ws.k(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.wr.clear();
        }
    }
}
