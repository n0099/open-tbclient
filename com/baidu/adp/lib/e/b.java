package com.baidu.adp.lib.e;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int uj;
    private int uk;
    private LinkedList<T> ul;
    private c<T> um;

    public b(c<T> cVar, int i, int i2) {
        this.uj = 10;
        this.uk = 0;
        this.ul = null;
        this.um = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.um = cVar;
        this.uj = i;
        this.uk = i2;
        this.ul = new LinkedList<>();
        ae(this.uk);
    }

    private void ad(int i) {
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    this.um.n(this.ul.poll());
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
                    t = this.um.o(this.um.fo());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.ul.offer(t);
                }
            }
        }
    }

    public void af(int i) {
        synchronized (this) {
            int i2 = i < this.uk ? this.uk : i;
            if (i2 <= 0) {
                i2 = 1;
            }
            this.uj = i2;
            ad(this.ul.size() - this.uj);
        }
    }

    public void ag(int i) {
        synchronized (this) {
            if (i > this.uj) {
                i = this.uj;
            }
            this.uk = i;
            ae(this.uk - this.ul.size());
        }
    }

    public T fn() {
        T t = null;
        synchronized (this) {
            try {
                if (this.ul.size() > 0) {
                    t = this.um.o(this.ul.poll());
                } else {
                    t = this.um.o(this.um.fo());
                }
                ae(this.uk - this.ul.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void m(T t) {
        T t2;
        synchronized (this) {
            if (this.ul.size() < this.uj) {
                try {
                    t2 = this.um.p(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.ul.offer(t2);
                }
            } else {
                this.um.n(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.ul.clear();
        }
    }
}
