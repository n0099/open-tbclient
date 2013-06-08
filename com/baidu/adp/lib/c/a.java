package com.baidu.adp.lib.c;

import android.util.Log;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    private final LinkedHashMap a = new LinkedHashMap(0, 0.75f, true);
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public a(int i) {
        this.d = i;
        this.b = this.d / 5;
    }

    public final Object a(Object obj) {
        Object obj2 = null;
        if (obj != null) {
            synchronized (this) {
                Object obj3 = this.a.get(obj);
                if (obj3 != null) {
                    this.g++;
                    obj2 = obj3;
                } else {
                    this.h++;
                }
            }
        }
        return obj2;
    }

    public final Object a(Object obj, Object obj2) {
        Object obj3 = null;
        if (obj != null && obj2 != null) {
            if (b(obj, obj2) > this.b) {
                if (com.baidu.adp.lib.e.b.a()) {
                    Log.w("adp", "image too big:" + obj2 + ", size:" + b(obj, obj2), new Exception());
                }
                a(false, obj, obj2, null);
            } else {
                synchronized (this) {
                    this.e++;
                    this.c += c(obj, obj2);
                    obj3 = this.a.put(obj, obj2);
                    if (obj3 != null) {
                        this.c -= c(obj, obj3);
                    }
                }
                if (obj3 != null) {
                    a(false, obj, obj3, obj2);
                }
                b(this.d);
            }
        }
        return obj3;
    }

    public synchronized boolean a(int i) {
        boolean z;
        if (i > this.b) {
            z = false;
        } else {
            int i2 = this.c - i;
            if (i2 > this.d * 0.6d) {
                b(i2);
            }
            z = true;
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0031, code lost:
        throw new java.lang.IllegalStateException(java.lang.String.valueOf(getClass().getName()) + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(int i) {
        Object key;
        Object value;
        while (true) {
            synchronized (this) {
                if (this.c < 0 || (this.a.isEmpty() && this.c != 0)) {
                    break;
                } else if (this.c <= i || this.a.isEmpty()) {
                    break;
                } else {
                    Map.Entry entry = (Map.Entry) this.a.entrySet().iterator().next();
                    key = entry.getKey();
                    value = entry.getValue();
                    this.a.remove(key);
                    this.c -= c(key, value);
                    this.f++;
                }
            }
            a(true, key, value, null);
        }
    }

    public final Object b(Object obj) {
        Object remove;
        if (obj == null) {
            return null;
        }
        synchronized (this) {
            remove = this.a.remove(obj);
            if (remove != null) {
                this.c -= c(obj, remove);
            }
        }
        if (remove != null) {
            a(false, obj, remove, null);
        }
        return remove;
    }

    protected void a(boolean z, Object obj, Object obj2, Object obj3) {
    }

    private int c(Object obj, Object obj2) {
        int b = b(obj, obj2);
        if (b < 0) {
            throw new IllegalStateException("Negative size: " + obj + "=" + obj2);
        }
        return b;
    }

    protected int b(Object obj, Object obj2) {
        return 1;
    }

    public final void a() {
        b(-1);
    }

    public final void b() {
        a();
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
    }

    public final synchronized int c() {
        return this.c;
    }

    public final void c(int i) {
        synchronized (this) {
            this.d = i;
            this.b = this.d / 5;
            b(i);
        }
    }
}
