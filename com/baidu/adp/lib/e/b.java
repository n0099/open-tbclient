package com.baidu.adp.lib.e;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int vn;
    private int vo;
    private LinkedList<T> vp;
    private c<T> vq;

    public b(c<T> cVar, int i, int i2) {
        this.vn = 10;
        this.vo = 0;
        this.vp = null;
        this.vq = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.vq = cVar;
        this.vn = i;
        this.vo = i2;
        this.vp = new LinkedList<>();
        V(this.vo);
    }

    private void V(int i) {
        T t;
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    t = this.vq.m(this.vq.gY());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.vp.offer(t);
                }
            }
        }
    }

    public T gX() {
        T t = null;
        synchronized (this) {
            try {
                if (this.vp.size() > 0) {
                    t = this.vq.m(this.vp.poll());
                } else {
                    t = this.vq.m(this.vq.gY());
                }
                V(this.vo - this.vp.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void k(T t) {
        T t2;
        synchronized (this) {
            if (this.vp.size() < this.vn) {
                try {
                    t2 = this.vq.n(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.vp.offer(t2);
                }
            } else {
                this.vq.l(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.vp.clear();
        }
    }
}
