package com.baidu.sofire.b;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class u {
    private static u b;
    private HashMap<String, a> a = new HashMap<>(10);

    /* loaded from: classes.dex */
    class a {
        final long a;
        int b;

        public a(int i, long j) {
            this.a = j;
            this.b = i;
        }
    }

    private u() {
    }

    public static synchronized u a() {
        u uVar;
        synchronized (u.class) {
            if (b == null) {
                b = new u();
            }
            uVar = b;
        }
        return uVar;
    }

    public final synchronized void a(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            new StringBuilder(" put key ").append(str).append(" status ").append(i);
            this.a.put(str, new a(i, System.currentTimeMillis() + 600000));
        }
    }

    public final synchronized int a(String str) {
        int i;
        a aVar = this.a.get(str);
        if (aVar == null) {
            i = -1;
        } else {
            if (aVar.a < System.currentTimeMillis()) {
                this.a.remove(str);
                i = -2;
            } else {
                int i2 = aVar.b;
                if (i2 == 1) {
                    i = 0;
                } else {
                    i = i2 == 0 ? -3 : -1;
                }
            }
        }
        return i;
    }
}
