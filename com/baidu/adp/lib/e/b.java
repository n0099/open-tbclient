package com.baidu.adp.lib.e;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int oK;
    private int oL;
    private LinkedList<T> oM;
    private c<T> oN;

    public b(c<T> cVar, int i, int i2) {
        this.oK = 10;
        this.oL = 0;
        this.oM = null;
        this.oN = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.oN = cVar;
        this.oK = i;
        this.oL = i2;
        this.oM = new LinkedList<>();
        al(this.oL);
    }

    private void al(int i) {
        T t;
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    t = this.oN.p(this.oN.ex());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.oM.offer(t);
                }
            }
        }
    }

    public T ew() {
        T t = null;
        synchronized (this) {
            try {
                if (this.oM.size() > 0) {
                    t = this.oN.p(this.oM.poll());
                } else {
                    t = this.oN.p(this.oN.ex());
                }
                al(this.oL - this.oM.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void n(T t) {
        T t2;
        synchronized (this) {
            if (this.oM.size() < this.oK) {
                try {
                    t2 = this.oN.q(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.oM.offer(t2);
                }
            } else {
                this.oN.o(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.oM.clear();
        }
    }
}
