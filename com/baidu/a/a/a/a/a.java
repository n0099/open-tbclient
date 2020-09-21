package com.baidu.a.a.a.a;

import android.content.Context;
import com.baidu.b.c;
import com.baidu.b.f;
import com.baidu.b.g;
import com.baidu.b.h;
import com.baidu.live.adp.lib.cache.BdKVCache;
/* loaded from: classes3.dex */
public final class a {
    public static boolean a = true;
    private static volatile a e;
    private final Context b;
    private h c;
    private g d;
    private c f = new c();
    private h.a g;
    private h.a h;
    private long i;

    private a(Context context) {
        this.b = context.getApplicationContext();
        this.c = new h(this.b, new com.baidu.b.e.a(this.b), this.f);
        this.d = new g(this.b, this.f);
    }

    private h.a a() {
        if (this.h != null) {
            return this.h;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.i) > BdKVCache.MILLS_1Hour) {
            this.h = b();
            this.i = currentTimeMillis;
        }
        if (this.h != null) {
            return this.h;
        }
        if (this.g == null) {
            this.h = c((String) null);
        }
        return this.h;
    }

    private h.a a(String str) {
        h.a a2 = this.c.a();
        return a2 == null ? b(str) : a2;
    }

    public static String a(Context context) {
        String c;
        synchronized (a.class) {
            c = b(context).a().c();
        }
        return c;
    }

    static a b(Context context) {
        a aVar;
        synchronized (f.class) {
            if (e == null) {
                e = new a(context);
            }
            aVar = e;
        }
        return aVar;
    }

    private h.a b() {
        if (0 == 0) {
            return a((String) null);
        }
        return null;
    }

    private h.a b(String str) {
        f da = this.d.da(str);
        if (da != null) {
            return this.c.a(da);
        }
        return null;
    }

    private h.a c(String str) {
        return this.c.b(str);
    }

    public static String c(Context context) {
        return b(context).a().a();
    }
}
