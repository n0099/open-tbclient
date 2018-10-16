package com.baidu.adp.lib.e;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int Do;
    private int Dp;
    private LinkedList<T> Dq;
    private c<T> Dr;

    public b(c<T> cVar, int i, int i2) {
        this.Do = 10;
        this.Dp = 0;
        this.Dq = null;
        this.Dr = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.Dr = cVar;
        this.Do = i;
        this.Dp = i2;
        this.Dq = new LinkedList<>();
        ao(this.Dp);
    }

    private void an(int i) {
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    this.Dr.u(this.Dq.poll());
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
                    t = this.Dr.v(this.Dr.jB());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.Dq.offer(t);
                }
            }
        }
    }

    public void ap(int i) {
        synchronized (this) {
            int i2 = i < this.Dp ? this.Dp : i;
            if (i2 <= 0) {
                i2 = 1;
            }
            this.Do = i2;
            an(this.Dq.size() - this.Do);
        }
    }

    public void aq(int i) {
        synchronized (this) {
            if (i > this.Do) {
                i = this.Do;
            }
            this.Dp = i;
            ao(this.Dp - this.Dq.size());
        }
    }

    public T jA() {
        T t = null;
        synchronized (this) {
            try {
                if (this.Dq.size() > 0) {
                    t = this.Dr.v(this.Dq.poll());
                } else {
                    t = this.Dr.v(this.Dr.jB());
                }
                ao(this.Dp - this.Dq.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void t(T t) {
        T t2;
        synchronized (this) {
            if (this.Dq.size() < this.Do) {
                try {
                    t2 = this.Dr.w(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.Dq.offer(t2);
                }
            } else {
                this.Dr.u(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.Dq.clear();
        }
    }
}
