package com.baidu.adp.lib.d;

import android.util.Log;
import com.baidu.adp.lib.h.d;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashMap<K, V> f441a = new LinkedHashMap<>(0, 0.75f, true);
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

    public final V a(K k) {
        V v = null;
        if (k != null) {
            synchronized (this) {
                V v2 = this.f441a.get(k);
                if (v2 != null) {
                    this.g++;
                    v = v2;
                } else {
                    this.h++;
                }
            }
        }
        return v;
    }

    public final V a(K k, V v) {
        V v2 = null;
        if (k != null && v != null) {
            if (b(k, v) > this.b) {
                if (d.a()) {
                    Log.w("adp", "image too big:" + v + ", size:" + b(k, v), new Exception());
                }
                a(false, k, v, null);
            } else {
                synchronized (this) {
                    this.e++;
                    this.c += c(k, v);
                    v2 = this.f441a.put(k, v);
                    if (v2 != null) {
                        this.c -= c(k, v2);
                    }
                }
                if (v2 != null) {
                    a(false, k, v2, v);
                }
                b(this.d);
            }
        }
        return v2;
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
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(int i) {
        K key;
        V value;
        while (true) {
            synchronized (this) {
                if (this.c < 0 || (this.f441a.isEmpty() && this.c != 0)) {
                    break;
                } else if (this.c <= i || this.f441a.isEmpty()) {
                    break;
                } else {
                    Map.Entry<K, V> next = this.f441a.entrySet().iterator().next();
                    key = next.getKey();
                    value = next.getValue();
                    this.f441a.remove(key);
                    this.c -= c(key, value);
                    this.f++;
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
            remove = this.f441a.remove(k);
            if (remove != null) {
                this.c -= c(k, remove);
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
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
    }

    public final synchronized int c() {
        return this.c;
    }

    public final synchronized int d() {
        return this.d;
    }

    public final void c(int i) {
        synchronized (this) {
            this.d = i;
            this.b = this.d / 5;
            b(i);
        }
    }
}
