package com.baidu.adp.lib.f;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int vG;
    private int vH;
    private LinkedList<T> vI;
    private c<T> vJ;

    public b(c<T> cVar, int i, int i2) {
        this.vG = 10;
        this.vH = 0;
        this.vI = null;
        this.vJ = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.vJ = cVar;
        this.vG = i;
        this.vH = i2;
        this.vI = new LinkedList<>();
        ah(this.vH);
    }

    private void ah(int i) {
        T t;
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    t = this.vJ.m(this.vJ.hk());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.vI.offer(t);
                }
            }
        }
    }

    public T hj() {
        T t = null;
        synchronized (this) {
            try {
                if (this.vI.size() > 0) {
                    t = this.vJ.m(this.vI.poll());
                } else {
                    t = this.vJ.m(this.vJ.hk());
                }
                ah(this.vH - this.vI.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void k(T t) {
        T t2;
        synchronized (this) {
            if (this.vI.size() < this.vG) {
                try {
                    t2 = this.vJ.n(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.vI.offer(t2);
                }
            } else {
                this.vJ.l(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.vI.clear();
        }
    }
}
