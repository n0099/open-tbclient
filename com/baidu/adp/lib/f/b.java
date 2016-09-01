package com.baidu.adp.lib.f;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int oQ;
    private int oR;
    private LinkedList<T> oS;
    private c<T> oT;

    public b(c<T> cVar, int i, int i2) {
        this.oQ = 10;
        this.oR = 0;
        this.oS = null;
        this.oT = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.oT = cVar;
        this.oQ = i;
        this.oR = i2;
        this.oS = new LinkedList<>();
        ak(this.oR);
    }

    private void ak(int i) {
        T t;
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    t = this.oT.p(this.oT.ez());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.oS.offer(t);
                }
            }
        }
    }

    public T ey() {
        T t = null;
        synchronized (this) {
            try {
                if (this.oS.size() > 0) {
                    t = this.oT.p(this.oS.poll());
                } else {
                    t = this.oT.p(this.oT.ez());
                }
                ak(this.oR - this.oS.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void n(T t) {
        T t2;
        synchronized (this) {
            if (this.oS.size() < this.oQ) {
                try {
                    t2 = this.oT.q(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.oS.offer(t2);
                }
            } else {
                this.oT.o(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.oS.clear();
        }
    }
}
