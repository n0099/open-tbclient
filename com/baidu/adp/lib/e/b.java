package com.baidu.adp.lib.e;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int vt;
    private int vu;
    private LinkedList<T> vv;
    private c<T> vw;

    public b(c<T> cVar, int i, int i2) {
        this.vt = 10;
        this.vu = 0;
        this.vv = null;
        this.vw = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.vw = cVar;
        this.vt = i;
        this.vu = i2;
        this.vv = new LinkedList<>();
        U(this.vu);
    }

    private void U(int i) {
        T t;
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    t = this.vw.l(this.vw.hk());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.vv.offer(t);
                }
            }
        }
    }

    public T hj() {
        T t = null;
        synchronized (this) {
            try {
                if (this.vv.size() > 0) {
                    t = this.vw.l(this.vv.poll());
                } else {
                    t = this.vw.l(this.vw.hk());
                }
                U(this.vu - this.vv.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void j(T t) {
        T t2;
        synchronized (this) {
            if (this.vv.size() < this.vt) {
                try {
                    t2 = this.vw.m(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.vv.offer(t2);
                }
            } else {
                this.vw.k(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.vv.clear();
        }
    }
}
