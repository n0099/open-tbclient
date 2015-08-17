package com.baidu.adp.lib.e;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int vp;
    private int vq;
    private LinkedList<T> vr;
    private c<T> vs;

    public b(c<T> cVar, int i, int i2) {
        this.vp = 10;
        this.vq = 0;
        this.vr = null;
        this.vs = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.vs = cVar;
        this.vp = i;
        this.vq = i2;
        this.vr = new LinkedList<>();
        V(this.vq);
    }

    private void V(int i) {
        T t;
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    t = this.vs.m(this.vs.hb());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.vr.offer(t);
                }
            }
        }
    }

    public T ha() {
        T t = null;
        synchronized (this) {
            try {
                if (this.vr.size() > 0) {
                    t = this.vs.m(this.vr.poll());
                } else {
                    t = this.vs.m(this.vs.hb());
                }
                V(this.vq - this.vr.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void k(T t) {
        T t2;
        synchronized (this) {
            if (this.vr.size() < this.vp) {
                try {
                    t2 = this.vs.n(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.vr.offer(t2);
                }
            } else {
                this.vs.l(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.vr.clear();
        }
    }
}
