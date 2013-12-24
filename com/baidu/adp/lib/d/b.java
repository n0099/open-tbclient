package com.baidu.adp.lib.d;

import com.baidu.adp.lib.h.e;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {
    private int a;
    private int b;
    private LinkedList<T> c;
    private c<T> d;

    public b(c<T> cVar, int i, int i2) {
        this.a = 10;
        this.b = 0;
        this.c = null;
        this.d = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.d = cVar;
        this.a = i;
        this.b = i2;
        this.c = new LinkedList<>();
        a(this.b);
    }

    private void a(int i) {
        T t;
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    t = this.d.b(this.d.a());
                } catch (Exception e) {
                    e.a(e.getMessage());
                    t = null;
                }
                if (t != null) {
                    this.c.offer(t);
                }
            }
        }
    }

    public T a() {
        T t = null;
        synchronized (this) {
            try {
                if (this.c.size() > 0) {
                    t = this.d.b(this.c.poll());
                } else {
                    t = this.d.b(this.d.a());
                }
                a(this.b - this.c.size());
            } catch (Exception e) {
                e.a(e.getMessage());
            }
        }
        return t;
    }

    public void a(T t) {
        T t2;
        synchronized (this) {
            if (this.c.size() < this.a) {
                try {
                    t2 = this.d.c(t);
                } catch (Exception e) {
                    e.a(e.getMessage());
                    t2 = null;
                }
                if (t2 != null) {
                    this.c.offer(t2);
                }
            } else {
                this.d.a(t);
            }
        }
    }

    public void b() {
        synchronized (this) {
            this.c.clear();
        }
    }
}
