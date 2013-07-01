package com.baidu.adp.lib.a;

import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private int f120a;
    private int b;
    private LinkedList c;
    private c d;

    public b(c cVar, int i, int i2) {
        this.f120a = 10;
        this.b = 0;
        this.c = null;
        this.d = null;
        if (cVar == null || i <= 0 || i2 > i) {
            throw new InvalidParameterException("invalid params");
        }
        this.d = cVar;
        this.f120a = i;
        this.b = i2;
        this.c = new LinkedList();
        a(this.b);
    }

    private void a(int i) {
        Object obj;
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    obj = this.d.b(this.d.a());
                } catch (Exception e) {
                    com.baidu.adp.lib.c.b.a(e.getMessage());
                    obj = null;
                }
                if (obj != null) {
                    this.c.offer(obj);
                }
            }
        }
    }

    public Object a() {
        Object obj = null;
        synchronized (this) {
            try {
                if (this.c.size() > 0) {
                    obj = this.d.b(this.c.poll());
                } else {
                    obj = this.d.b(this.d.a());
                }
                a(this.b - this.c.size());
            } catch (Exception e) {
                com.baidu.adp.lib.c.b.a(e.getMessage());
            }
        }
        return obj;
    }

    public void a(Object obj) {
        Object obj2;
        synchronized (this) {
            if (this.c.size() < this.f120a) {
                try {
                    obj2 = this.d.c(obj);
                } catch (Exception e) {
                    com.baidu.adp.lib.c.b.a(e.getMessage());
                    obj2 = null;
                }
                if (obj2 != null) {
                    this.c.offer(obj2);
                }
            } else {
                this.d.a(obj);
            }
        }
    }

    public void b() {
        synchronized (this) {
            this.c.clear();
        }
    }
}
