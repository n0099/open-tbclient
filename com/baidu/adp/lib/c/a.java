package com.baidu.adp.lib.c;

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

    public a(int i) {
        this.c = i;
    }

    public final Object a(Object obj) {
        Object obj2 = null;
        if (obj != null) {
            synchronized (this) {
                Object obj3 = this.a.get(obj);
                if (obj3 != null) {
                    this.f++;
                    obj2 = obj3;
                } else {
                    this.g++;
                }
            }
        }
        return obj2;
    }

    public final Object a(Object obj, Object obj2) {
        Object put;
        if (obj == null || obj2 == null) {
            return null;
        }
        synchronized (this) {
            this.d++;
            this.b += c(obj, obj2);
            put = this.a.put(obj, obj2);
            if (put != null) {
                this.b -= c(obj, put);
            }
        }
        if (put != null) {
            a(false, obj, put, obj2);
        }
        a(this.c);
        return put;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0031, code lost:
        throw new java.lang.IllegalStateException(java.lang.String.valueOf(getClass().getName()) + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i) {
        Object key;
        Object value;
        while (true) {
            synchronized (this) {
                if (this.b < 0 || (this.a.isEmpty() && this.b != 0)) {
                    break;
                } else if (this.b <= i || this.a.isEmpty()) {
                    break;
                } else {
                    Map.Entry entry = (Map.Entry) this.a.entrySet().iterator().next();
                    key = entry.getKey();
                    value = entry.getValue();
                    this.a.remove(key);
                    this.b -= c(key, value);
                    this.e++;
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
                this.b -= c(obj, remove);
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
        a(-1);
    }

    public final void b() {
        a();
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
    }

    public final void b(int i) {
        synchronized (this) {
            this.c = i;
            a(i);
        }
    }
}
