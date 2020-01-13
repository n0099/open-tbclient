package com.baidu.poly;

import android.content.Context;
import android.os.Bundle;
import com.baidu.poly.util.f;
import com.baidu.poly.widget.PolyActivity;
/* loaded from: classes10.dex */
public class a {
    private com.baidu.poly.c.a.c aLu;
    private long aLv;

    /* renamed from: com.baidu.poly.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0144a {
        private com.baidu.poly.c.a.c aLu;
        private Context context;
        private int aLw = 1;
        private boolean debug = false;

        public a Ca() {
            return new a(this);
        }

        public C0144a a(com.baidu.poly.c.a.c cVar) {
            this.aLu = cVar;
            return this;
        }

        public C0144a aR(Context context) {
            this.context = context;
            return this;
        }

        public C0144a bF(boolean z) {
            this.debug = z;
            return this;
        }

        public C0144a dc(int i) {
            this.aLw = i;
            return this;
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class b {
        public abstract void onResult(int i, String str);
    }

    public void a(Context context, Bundle bundle, b bVar) {
        if (context == null) {
            throw new IllegalArgumentException("context can not be null");
        }
        if (bundle != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.aLv < 1000) {
                com.baidu.poly.util.c.info("cashier pay time interval less than 1s");
                return;
            }
            this.aLv = currentTimeMillis;
            com.baidu.poly.util.c.info("cashier pay");
            PolyActivity.a(context, this.aLu, bVar, bundle);
            return;
        }
        throw new IllegalArgumentException("arguments can not be null");
    }

    private a(C0144a c0144a) {
        this.aLv = 0L;
        if (c0144a != null && c0144a.aLu != null) {
            if (c0144a.context != null) {
                this.aLu = c0144a.aLu;
                com.baidu.poly.a.b.a.init(c0144a.aLw);
                com.baidu.poly.a.c.b.a(com.baidu.poly.a.c.a.aS(c0144a.context.getApplicationContext()));
                f.b(c0144a.context.getApplicationContext());
                com.baidu.poly.util.c.aNC = c0144a.debug;
                return;
            }
            throw new IllegalArgumentException("context can not be null");
        }
        throw new IllegalArgumentException("channelPay can not be null");
    }
}
