package com.baidu.adp.lib.e;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int wd;
    private int we;
    private LinkedList<T> wf;
    private c<T> wg;

    public b(c<T> cVar, int i, int i2) {
        this.wd = 10;
        this.we = 0;
        this.wf = null;
        this.wg = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.wg = cVar;
        this.wd = i;
        this.we = i2;
        this.wf = new LinkedList<>();
        aj(this.we);
    }

    private void aj(int i) {
        T t;
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    t = this.wg.p(this.wg.fL());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.wf.offer(t);
                }
            }
        }
    }

    public T fK() {
        T t = null;
        synchronized (this) {
            try {
                if (this.wf.size() > 0) {
                    t = this.wg.p(this.wf.poll());
                } else {
                    t = this.wg.p(this.wg.fL());
                }
                aj(this.we - this.wf.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void n(T t) {
        T t2;
        synchronized (this) {
            if (this.wf.size() < this.wd) {
                try {
                    t2 = this.wg.q(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.wf.offer(t2);
                }
            } else {
                this.wg.o(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.wf.clear();
        }
    }
}
