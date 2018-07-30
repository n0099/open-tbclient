package com.baidu.adp.lib.e;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int Aj;
    private int Ak;
    private LinkedList<T> Al;
    private c<T> Am;

    public b(c<T> cVar, int i, int i2) {
        this.Aj = 10;
        this.Ak = 0;
        this.Al = null;
        this.Am = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.Am = cVar;
        this.Aj = i;
        this.Ak = i2;
        this.Al = new LinkedList<>();
        ag(this.Ak);
    }

    private void af(int i) {
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    this.Am.q(this.Al.poll());
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
                    t = this.Am.r(this.Am.ig());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.Al.offer(t);
                }
            }
        }
    }

    public void ah(int i) {
        synchronized (this) {
            int i2 = i < this.Ak ? this.Ak : i;
            if (i2 <= 0) {
                i2 = 1;
            }
            this.Aj = i2;
            af(this.Al.size() - this.Aj);
        }
    }

    public void ai(int i) {
        synchronized (this) {
            if (i > this.Aj) {
                i = this.Aj;
            }
            this.Ak = i;
            ag(this.Ak - this.Al.size());
        }
    }

    /* renamed from: if  reason: not valid java name */
    public T m9if() {
        T t = null;
        synchronized (this) {
            try {
                if (this.Al.size() > 0) {
                    t = this.Am.r(this.Al.poll());
                } else {
                    t = this.Am.r(this.Am.ig());
                }
                ag(this.Ak - this.Al.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void p(T t) {
        T t2;
        synchronized (this) {
            if (this.Al.size() < this.Aj) {
                try {
                    t2 = this.Am.s(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.Al.offer(t2);
                }
            } else {
                this.Am.q(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.Al.clear();
        }
    }
}
