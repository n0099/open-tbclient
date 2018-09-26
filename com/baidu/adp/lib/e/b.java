package com.baidu.adp.lib.e;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int CE;
    private int CF;
    private LinkedList<T> CG;
    private c<T> CH;

    public b(c<T> cVar, int i, int i2) {
        this.CE = 10;
        this.CF = 0;
        this.CG = null;
        this.CH = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.CH = cVar;
        this.CE = i;
        this.CF = i2;
        this.CG = new LinkedList<>();
        ao(this.CF);
    }

    private void an(int i) {
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    this.CH.r(this.CG.poll());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    private void ao(int i) {
        T t;
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    t = this.CH.s(this.CH.jm());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.CG.offer(t);
                }
            }
        }
    }

    public void ap(int i) {
        synchronized (this) {
            int i2 = i < this.CF ? this.CF : i;
            if (i2 <= 0) {
                i2 = 1;
            }
            this.CE = i2;
            an(this.CG.size() - this.CE);
        }
    }

    public void aq(int i) {
        synchronized (this) {
            if (i > this.CE) {
                i = this.CE;
            }
            this.CF = i;
            ao(this.CF - this.CG.size());
        }
    }

    public T jl() {
        T t = null;
        synchronized (this) {
            try {
                if (this.CG.size() > 0) {
                    t = this.CH.s(this.CG.poll());
                } else {
                    t = this.CH.s(this.CH.jm());
                }
                ao(this.CF - this.CG.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void q(T t) {
        T t2;
        synchronized (this) {
            if (this.CG.size() < this.CE) {
                try {
                    t2 = this.CH.t(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.CG.offer(t2);
                }
            } else {
                this.CH.r(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.CG.clear();
        }
    }
}
