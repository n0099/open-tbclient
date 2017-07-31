package com.baidu.adp.lib.e;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int xF;
    private int xG;
    private LinkedList<T> xH;
    private c<T> xI;

    public b(c<T> cVar, int i, int i2) {
        this.xF = 10;
        this.xG = 0;
        this.xH = null;
        this.xI = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.xI = cVar;
        this.xF = i;
        this.xG = i2;
        this.xH = new LinkedList<>();
        an(this.xG);
    }

    private void an(int i) {
        T t;
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    t = this.xI.p(this.xI.fT());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.xH.offer(t);
                }
            }
        }
    }

    public T fS() {
        T t = null;
        synchronized (this) {
            try {
                if (this.xH.size() > 0) {
                    t = this.xI.p(this.xH.poll());
                } else {
                    t = this.xI.p(this.xI.fT());
                }
                an(this.xG - this.xH.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void n(T t) {
        T t2;
        synchronized (this) {
            if (this.xH.size() < this.xF) {
                try {
                    t2 = this.xI.q(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.xH.offer(t2);
                }
            } else {
                this.xI.o(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.xH.clear();
        }
    }
}
