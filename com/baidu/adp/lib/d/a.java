package com.baidu.adp.lib.d;

import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a<K, V> {
    private final LinkedHashMap<K, V> a = new LinkedHashMap<>(0, 0.75f, true);
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;

    public a(int i) {
        this.c = i;
    }

    public final V a(K k) {
        V v = null;
        if (k != null) {
            synchronized (this) {
                V v2 = this.a.get(k);
                if (v2 != null) {
                    this.f++;
                    v = v2;
                } else {
                    this.g++;
                }
            }
        }
        return v;
    }

    public final V a(K k, V v) {
        V put;
        if (k == null || v == null) {
            return null;
        }
        synchronized (this) {
            this.d++;
            this.b += c(k, v);
            put = this.a.put(k, v);
            if (put != null) {
                this.b -= c(k, put);
            }
        }
        if (put != null) {
            a(false, k, put, v);
        }
        b(this.c);
        return put;
    }

    public synchronized boolean a(int i) {
        int i2 = this.b - i;
        if (i2 > this.c * 0.6d) {
            b(i2);
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0031, code lost:
        throw new java.lang.IllegalStateException(java.lang.String.valueOf(getClass().getName()) + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(int i) {
        K key;
        V value;
        while (true) {
            synchronized (this) {
                if (this.b < 0 || (this.a.isEmpty() && this.b != 0)) {
                    break;
                } else if (this.b <= i || this.a.isEmpty()) {
                    break;
                } else {
                    Map.Entry<K, V> next = this.a.entrySet().iterator().next();
                    key = next.getKey();
                    value = next.getValue();
                    this.a.remove(key);
                    this.b -= c(key, value);
                    this.e++;
                }
            }
            a(true, key, value, null);
        }
    }

    public final V b(K k) {
        V remove;
        if (k == null) {
            return null;
        }
        synchronized (this) {
            remove = this.a.remove(k);
            if (remove != null) {
                this.b -= c(k, remove);
            }
        }
        if (remove != null) {
            a(false, k, remove, null);
        }
        return remove;
    }

    protected void a(boolean z, K k, V v, V v2) {
    }

    private int c(K k, V v) {
        int b = b(k, v);
        if (b < 0) {
            throw new IllegalStateException("Negative size: " + k + "=" + v);
        }
        return b;
    }

    protected int b(K k, V v) {
        return 1;
    }

    public final void a() {
        b(-1);
    }

    public final void b() {
        a();
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
    }

    public final synchronized int c() {
        return this.b;
    }

    public final synchronized int d() {
        return this.c;
    }

    public final void c(int i) {
        synchronized (this) {
            this.c = i;
            b(i);
        }
    }
}
