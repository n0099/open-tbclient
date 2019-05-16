package com.baidu.adp.lib.e;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int Bb;
    private int Bc;
    private LinkedList<T> Bd;
    private c<T> Be;

    public b(c<T> cVar, int i, int i2) {
        this.Bb = 10;
        this.Bc = 0;
        this.Bd = null;
        this.Be = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.Be = cVar;
        this.Bb = i;
        this.Bc = i2;
        this.Bd = new LinkedList<>();
        ag(this.Bc);
    }

    private void af(int i) {
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    this.Be.destroyObject(this.Bd.poll());
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
                    t = this.Be.activateObject(this.Be.makeObject());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.Bd.offer(t);
                }
            }
        }
    }

    public void ah(int i) {
        synchronized (this) {
            int i2 = i < this.Bc ? this.Bc : i;
            if (i2 <= 0) {
                i2 = 1;
            }
            this.Bb = i2;
            af(this.Bd.size() - this.Bb);
        }
    }

    public void ai(int i) {
        synchronized (this) {
            if (i > this.Bb) {
                i = this.Bb;
            }
            this.Bc = i;
            ag(this.Bc - this.Bd.size());
        }
    }

    public T iu() {
        T t = null;
        synchronized (this) {
            try {
                if (this.Bd.size() > 0) {
                    t = this.Be.activateObject(this.Bd.poll());
                } else {
                    t = this.Be.activateObject(this.Be.makeObject());
                }
                ag(this.Bc - this.Bd.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void t(T t) {
        T t2;
        synchronized (this) {
            if (this.Bd.size() < this.Bb) {
                try {
                    t2 = this.Be.passivateObject(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.Bd.offer(t2);
                }
            } else {
                this.Be.destroyObject(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this.Bd.clear();
        }
    }
}
