package com.baidu.adp.lib.e;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int wv;
    private int ww;
    private LinkedList<T> wx;
    private c<T> wy;

    public b(c<T> cVar, int i, int i2) {
        this.wv = 10;
        this.ww = 0;
        this.wx = null;
        this.wy = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.wy = cVar;
        this.wv = i;
        this.ww = i2;
        this.wx = new LinkedList<>();
        al(this.ww);
    }

    private void al(int i) {
        T t;
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    t = this.wy.p(this.wy.fF());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.wx.offer(t);
                }
            }
        }
    }

    public T fE() {
        T t = null;
        synchronized (this) {
            try {
                if (this.wx.size() > 0) {
                    t = this.wy.p(this.wx.poll());
                } else {
                    t = this.wy.p(this.wy.fF());
                }
                al(this.ww - this.wx.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void n(T t) {
        T t2;
        synchronized (this) {
            if (this.wx.size() < this.wv) {
                try {
                    t2 = this.wy.q(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.wx.offer(t2);
                }
            } else {
                this.wy.o(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.wx.clear();
        }
    }
}
