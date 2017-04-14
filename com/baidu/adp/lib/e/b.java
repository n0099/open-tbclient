package com.baidu.adp.lib.e;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int vY;
    private int vZ;
    private LinkedList<T> wa;
    private c<T> wb;

    public b(c<T> cVar, int i, int i2) {
        this.vY = 10;
        this.vZ = 0;
        this.wa = null;
        this.wb = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.wb = cVar;
        this.vY = i;
        this.vZ = i2;
        this.wa = new LinkedList<>();
        ak(this.vZ);
    }

    private void ak(int i) {
        T t;
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    t = this.wb.p(this.wb.fK());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.wa.offer(t);
                }
            }
        }
    }

    public T fJ() {
        T t = null;
        synchronized (this) {
            try {
                if (this.wa.size() > 0) {
                    t = this.wb.p(this.wa.poll());
                } else {
                    t = this.wb.p(this.wb.fK());
                }
                ak(this.vZ - this.wa.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void n(T t) {
        T t2;
        synchronized (this) {
            if (this.wa.size() < this.vY) {
                try {
                    t2 = this.wb.q(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.wa.offer(t2);
                }
            } else {
                this.wb.o(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.wa.clear();
        }
    }
}
