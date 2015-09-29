package com.baidu.adp.lib.e;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int vo;
    private int vp;
    private LinkedList<T> vq;
    private c<T> vr;

    public b(c<T> cVar, int i, int i2) {
        this.vo = 10;
        this.vp = 0;
        this.vq = null;
        this.vr = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.vr = cVar;
        this.vo = i;
        this.vp = i2;
        this.vq = new LinkedList<>();
        V(this.vp);
    }

    private void V(int i) {
        T t;
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    t = this.vr.m(this.vr.gZ());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.vq.offer(t);
                }
            }
        }
    }

    public T gY() {
        T t = null;
        synchronized (this) {
            try {
                if (this.vq.size() > 0) {
                    t = this.vr.m(this.vq.poll());
                } else {
                    t = this.vr.m(this.vr.gZ());
                }
                V(this.vp - this.vq.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void k(T t) {
        T t2;
        synchronized (this) {
            if (this.vq.size() < this.vo) {
                try {
                    t2 = this.vr.n(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.vq.offer(t2);
                }
            } else {
                this.vr.l(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.vq.clear();
        }
    }
}
