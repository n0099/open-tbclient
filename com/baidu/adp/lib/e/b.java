package com.baidu.adp.lib.e;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int uk;
    private int ul;
    private LinkedList<T> um;
    private c<T> uo;

    public b(c<T> cVar, int i, int i2) {
        this.uk = 10;
        this.ul = 0;
        this.um = null;
        this.uo = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.uo = cVar;
        this.uk = i;
        this.ul = i2;
        this.um = new LinkedList<>();
        ae(this.ul);
    }

    private void ad(int i) {
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    this.uo.n(this.um.poll());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    private void ae(int i) {
        T t;
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    t = this.uo.o(this.uo.fo());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.um.offer(t);
                }
            }
        }
    }

    public void af(int i) {
        synchronized (this) {
            int i2 = i < this.ul ? this.ul : i;
            if (i2 <= 0) {
                i2 = 1;
            }
            this.uk = i2;
            ad(this.um.size() - this.uk);
        }
    }

    public void ag(int i) {
        synchronized (this) {
            if (i > this.uk) {
                i = this.uk;
            }
            this.ul = i;
            ae(this.ul - this.um.size());
        }
    }

    public T fn() {
        T t = null;
        synchronized (this) {
            try {
                if (this.um.size() > 0) {
                    t = this.uo.o(this.um.poll());
                } else {
                    t = this.uo.o(this.uo.fo());
                }
                ae(this.ul - this.um.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void m(T t) {
        T t2;
        synchronized (this) {
            if (this.um.size() < this.uk) {
                try {
                    t2 = this.uo.p(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.um.offer(t2);
                }
            } else {
                this.uo.n(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.um.clear();
        }
    }
}
