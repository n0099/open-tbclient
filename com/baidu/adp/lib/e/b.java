package com.baidu.adp.lib.e;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int Bg;
    private int Bh;
    private LinkedList<T> Bi;
    private c<T> Bj;

    public b(c<T> cVar, int i, int i2) {
        this.Bg = 10;
        this.Bh = 0;
        this.Bi = null;
        this.Bj = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.Bj = cVar;
        this.Bg = i;
        this.Bh = i2;
        this.Bi = new LinkedList<>();
        ag(this.Bh);
    }

    private void af(int i) {
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    this.Bj.destroyObject(this.Bi.poll());
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
                    t = this.Bj.activateObject(this.Bj.makeObject());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.Bi.offer(t);
                }
            }
        }
    }

    public void ah(int i) {
        synchronized (this) {
            int i2 = i < this.Bh ? this.Bh : i;
            if (i2 <= 0) {
                i2 = 1;
            }
            this.Bg = i2;
            af(this.Bi.size() - this.Bg);
        }
    }

    public void ai(int i) {
        synchronized (this) {
            if (i > this.Bg) {
                i = this.Bg;
            }
            this.Bh = i;
            ag(this.Bh - this.Bi.size());
        }
    }

    public T iD() {
        T t = null;
        synchronized (this) {
            try {
                if (this.Bi.size() > 0) {
                    t = this.Bj.activateObject(this.Bi.poll());
                } else {
                    t = this.Bj.activateObject(this.Bj.makeObject());
                }
                ag(this.Bh - this.Bi.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void t(T t) {
        T t2;
        synchronized (this) {
            if (this.Bi.size() < this.Bg) {
                try {
                    t2 = this.Bj.passivateObject(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.Bi.offer(t2);
                }
            } else {
                this.Bj.destroyObject(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.Bi.clear();
        }
    }
}
