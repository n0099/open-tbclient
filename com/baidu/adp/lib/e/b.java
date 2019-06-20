package com.baidu.adp.lib.e;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int Ba;
    private int Bb;
    private LinkedList<T> Bc;
    private c<T> Bd;

    public b(c<T> cVar, int i, int i2) {
        this.Ba = 10;
        this.Bb = 0;
        this.Bc = null;
        this.Bd = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.Bd = cVar;
        this.Ba = i;
        this.Bb = i2;
        this.Bc = new LinkedList<>();
        ag(this.Bb);
    }

    private void af(int i) {
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    this.Bd.destroyObject(this.Bc.poll());
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
                    t = this.Bd.activateObject(this.Bd.makeObject());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.Bc.offer(t);
                }
            }
        }
    }

    public void ah(int i) {
        synchronized (this) {
            int i2 = i < this.Bb ? this.Bb : i;
            if (i2 <= 0) {
                i2 = 1;
            }
            this.Ba = i2;
            af(this.Bc.size() - this.Ba);
        }
    }

    public void ai(int i) {
        synchronized (this) {
            if (i > this.Ba) {
                i = this.Ba;
            }
            this.Bb = i;
            ag(this.Bb - this.Bc.size());
        }
    }

    public T iu() {
        T t = null;
        synchronized (this) {
            try {
                if (this.Bc.size() > 0) {
                    t = this.Bd.activateObject(this.Bc.poll());
                } else {
                    t = this.Bd.activateObject(this.Bd.makeObject());
                }
                ag(this.Bb - this.Bc.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void t(T t) {
        T t2;
        synchronized (this) {
            if (this.Bc.size() < this.Ba) {
                try {
                    t2 = this.Bd.passivateObject(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.Bc.offer(t2);
                }
            } else {
                this.Bd.destroyObject(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.Bc.clear();
        }
    }
}
