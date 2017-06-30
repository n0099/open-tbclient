package com.baidu.adp.lib.e;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int wc;
    private int wd;
    private LinkedList<T> we;
    private c<T> wf;

    public b(c<T> cVar, int i, int i2) {
        this.wc = 10;
        this.wd = 0;
        this.we = null;
        this.wf = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.wf = cVar;
        this.wc = i;
        this.wd = i2;
        this.we = new LinkedList<>();
        ak(this.wd);
    }

    private void ak(int i) {
        T t;
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    t = this.wf.p(this.wf.fK());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.we.offer(t);
                }
            }
        }
    }

    public T fJ() {
        T t = null;
        synchronized (this) {
            try {
                if (this.we.size() > 0) {
                    t = this.wf.p(this.we.poll());
                } else {
                    t = this.wf.p(this.wf.fK());
                }
                ak(this.wd - this.we.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void n(T t) {
        T t2;
        synchronized (this) {
            if (this.we.size() < this.wc) {
                try {
                    t2 = this.wf.q(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.we.offer(t2);
                }
            } else {
                this.wf.o(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.we.clear();
        }
    }
}
