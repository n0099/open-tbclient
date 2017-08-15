package com.baidu.adp.lib.e;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int xH;
    private int xI;
    private LinkedList<T> xJ;
    private c<T> xK;

    public b(c<T> cVar, int i, int i2) {
        this.xH = 10;
        this.xI = 0;
        this.xJ = null;
        this.xK = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.xK = cVar;
        this.xH = i;
        this.xI = i2;
        this.xJ = new LinkedList<>();
        an(this.xI);
    }

    private void an(int i) {
        T t;
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    t = this.xK.p(this.xK.fT());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.xJ.offer(t);
                }
            }
        }
    }

    public T fS() {
        T t = null;
        synchronized (this) {
            try {
                if (this.xJ.size() > 0) {
                    t = this.xK.p(this.xJ.poll());
                } else {
                    t = this.xK.p(this.xK.fT());
                }
                an(this.xI - this.xJ.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void n(T t) {
        T t2;
        synchronized (this) {
            if (this.xJ.size() < this.xH) {
                try {
                    t2 = this.xK.q(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.xJ.offer(t2);
                }
            } else {
                this.xK.o(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.xJ.clear();
        }
    }
}
