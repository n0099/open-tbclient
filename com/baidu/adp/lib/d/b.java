package com.baidu.adp.lib.d;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    protected c<T> KQ;
    private int _maxIdle;
    private int _minIdle;
    protected LinkedList<T> _pool;

    public b(c<T> cVar, int i, int i2) {
        this._maxIdle = 10;
        this._minIdle = 0;
        this._pool = null;
        this.KQ = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.KQ = cVar;
        this._maxIdle = i;
        this._minIdle = i2;
        this._pool = new LinkedList<>();
        addItems(this._minIdle);
    }

    private void deleteItems(int i) {
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    this.KQ.destroyObject(this._pool.poll());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    private void addItems(int i) {
        T t;
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    t = this.KQ.activateObject(this.KQ.makeObject());
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this._pool.offer(t);
                }
            }
        }
    }

    public void setMaxIdle(int i) {
        synchronized (this) {
            int i2 = i < this._minIdle ? this._minIdle : i;
            if (i2 <= 0) {
                i2 = 1;
            }
            this._maxIdle = i2;
            deleteItems(this._pool.size() - this._maxIdle);
        }
    }

    public void setMinIdle(int i) {
        synchronized (this) {
            if (i > this._maxIdle) {
                i = this._maxIdle;
            }
            this._minIdle = i;
            addItems(this._minIdle - this._pool.size());
        }
    }

    public T borrowObject() {
        T t = null;
        synchronized (this) {
            try {
                if (this._pool.size() > 0) {
                    t = this.KQ.activateObject(this._pool.poll());
                } else {
                    t = this.KQ.activateObject(this.KQ.makeObject());
                }
                addItems(this._minIdle - this._pool.size());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return t;
    }

    public void returnObject(T t) {
        T t2;
        synchronized (this) {
            if (this._pool.size() < this._maxIdle) {
                try {
                    t2 = this.KQ.passivateObject(t);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this._pool.offer(t2);
                }
            } else {
                this.KQ.destroyObject(t);
            }
        }
    }

    public void clear() {
        synchronized (this) {
            this._pool.clear();
        }
    }
}
