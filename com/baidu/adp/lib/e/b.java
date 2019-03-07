package com.baidu.adp.lib.e;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int Dr;
    private int Ds;
    private LinkedList<T> Dt;
    private c<T> Du;

    public b(c<T> cVar, int i, int i2) {
        this.Dr = 10;
        this.Ds = 0;
        this.Dt = null;
        this.Du = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.Du = cVar;
        this.Dr = i;
        this.Ds = i2;
        this.Dt = new LinkedList<>();
        ao(this.Ds);
    }

    private void an(int i) {
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    this.Du.destroyObject(this.Dt.poll());
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
                    t = this.Du.activateObject(this.Du.makeObject());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.Dt.offer(t);
                }
            }
        }
    }

    public void ap(int i) {
        synchronized (this) {
            int i2 = i < this.Ds ? this.Ds : i;
            if (i2 <= 0) {
                i2 = 1;
            }
            this.Dr = i2;
            an(this.Dt.size() - this.Dr);
        }
    }

    public void aq(int i) {
        synchronized (this) {
            if (i > this.Dr) {
                i = this.Dr;
            }
            this.Ds = i;
            ao(this.Ds - this.Dt.size());
        }
    }

    public T jA() {
        T t = null;
        synchronized (this) {
            try {
                if (this.Dt.size() > 0) {
                    t = this.Du.activateObject(this.Dt.poll());
                } else {
                    t = this.Du.activateObject(this.Du.makeObject());
                }
                ao(this.Ds - this.Dt.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void t(T t) {
        T t2;
        synchronized (this) {
            if (this.Dt.size() < this.Dr) {
                try {
                    t2 = this.Du.passivateObject(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.Dt.offer(t2);
                }
            } else {
                this.Du.destroyObject(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.Dt.clear();
        }
    }
}
