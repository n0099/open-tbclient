package com.baidu.adp.lib.f;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int vu;
    private int vv;
    private LinkedList<T> vw;
    private c<T> vx;

    public b(c<T> cVar, int i, int i2) {
        this.vu = 10;
        this.vv = 0;
        this.vw = null;
        this.vx = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.vx = cVar;
        this.vu = i;
        this.vv = i2;
        this.vw = new LinkedList<>();
        W(this.vv);
    }

    private void W(int i) {
        T t;
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    t = this.vx.m(this.vx.hc());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.vw.offer(t);
                }
            }
        }
    }

    public T hb() {
        T t = null;
        synchronized (this) {
            try {
                if (this.vw.size() > 0) {
                    t = this.vx.m(this.vw.poll());
                } else {
                    t = this.vx.m(this.vx.hc());
                }
                W(this.vv - this.vw.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void k(T t) {
        T t2;
        synchronized (this) {
            if (this.vw.size() < this.vu) {
                try {
                    t2 = this.vx.n(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.vw.offer(t2);
                }
            } else {
                this.vx.l(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.vw.clear();
        }
    }
}
