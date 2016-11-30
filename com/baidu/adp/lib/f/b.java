package com.baidu.adp.lib.f;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int oR;
    private int oS;
    private LinkedList<T> oT;
    private c<T> oU;

    public b(c<T> cVar, int i, int i2) {
        this.oR = 10;
        this.oS = 0;
        this.oT = null;
        this.oU = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.oU = cVar;
        this.oR = i;
        this.oS = i2;
        this.oT = new LinkedList<>();
        ak(this.oS);
    }

    private void ak(int i) {
        T t;
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    t = this.oU.p(this.oU.ez());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.oT.offer(t);
                }
            }
        }
    }

    public T ey() {
        T t = null;
        synchronized (this) {
            try {
                if (this.oT.size() > 0) {
                    t = this.oU.p(this.oT.poll());
                } else {
                    t = this.oU.p(this.oU.ez());
                }
                ak(this.oS - this.oT.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void n(T t) {
        T t2;
        synchronized (this) {
            if (this.oT.size() < this.oR) {
                try {
                    t2 = this.oU.q(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.oT.offer(t2);
                }
            } else {
                this.oU.o(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.oT.clear();
        }
    }
}
