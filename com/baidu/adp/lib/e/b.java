package com.baidu.adp.lib.e;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int Ak;
    private int Al;
    private LinkedList<T> Am;
    private c<T> An;

    public b(c<T> cVar, int i, int i2) {
        this.Ak = 10;
        this.Al = 0;
        this.Am = null;
        this.An = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.An = cVar;
        this.Ak = i;
        this.Al = i2;
        this.Am = new LinkedList<>();
        ag(this.Al);
    }

    private void af(int i) {
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    this.An.q(this.Am.poll());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    private void ag(int i) {
        T t;
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    t = this.An.r(this.An.ig());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.Am.offer(t);
                }
            }
        }
    }

    public void ah(int i) {
        synchronized (this) {
            int i2 = i < this.Al ? this.Al : i;
            if (i2 <= 0) {
                i2 = 1;
            }
            this.Ak = i2;
            af(this.Am.size() - this.Ak);
        }
    }

    public void ai(int i) {
        synchronized (this) {
            if (i > this.Ak) {
                i = this.Ak;
            }
            this.Al = i;
            ag(this.Al - this.Am.size());
        }
    }

    /* renamed from: if  reason: not valid java name */
    public T m9if() {
        T t = null;
        synchronized (this) {
            try {
                if (this.Am.size() > 0) {
                    t = this.An.r(this.Am.poll());
                } else {
                    t = this.An.r(this.An.ig());
                }
                ag(this.Al - this.Am.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void p(T t) {
        T t2;
        synchronized (this) {
            if (this.Am.size() < this.Ak) {
                try {
                    t2 = this.An.s(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.Am.offer(t2);
                }
            } else {
                this.An.q(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.Am.clear();
        }
    }
}
