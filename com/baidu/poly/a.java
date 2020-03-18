package com.baidu.poly;

import android.content.Context;
import android.os.Bundle;
import com.baidu.poly.util.f;
import com.baidu.poly.widget.PolyActivity;
/* loaded from: classes11.dex */
public class a {
    private com.baidu.poly.c.a.c aQj;
    private long aQk;

    /* renamed from: com.baidu.poly.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0153a {
        private com.baidu.poly.c.a.c aQj;
        private Context context;
        private int aQl = 1;
        private boolean debug = false;

        public a EF() {
            return new a(this);
        }

        public C0153a a(com.baidu.poly.c.a.c cVar) {
            this.aQj = cVar;
            return this;
        }

        public C0153a aU(Context context) {
            this.context = context;
            return this;
        }

        public C0153a bO(boolean z) {
            this.debug = z;
            return this;
        }

        public C0153a dt(int i) {
            this.aQl = i;
            return this;
        }
    }

    /* loaded from: classes11.dex */
    public static abstract class b {
        public abstract void onResult(int i, String str);
    }

    public void a(Context context, Bundle bundle, b bVar) {
        if (context == null) {
            throw new IllegalArgumentException("context can not be null");
        }
        if (bundle != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.aQk < 1000) {
                com.baidu.poly.util.c.info("cashier pay time interval less than 1s");
                return;
            }
            this.aQk = currentTimeMillis;
            com.baidu.poly.util.c.info("cashier pay");
            PolyActivity.a(context, this.aQj, bVar, bundle);
            return;
        }
        throw new IllegalArgumentException("arguments can not be null");
    }

    private a(C0153a c0153a) {
        this.aQk = 0L;
        if (c0153a != null && c0153a.aQj != null) {
            if (c0153a.context != null) {
                this.aQj = c0153a.aQj;
                com.baidu.poly.a.b.a.init(c0153a.aQl);
                com.baidu.poly.a.c.b.a(com.baidu.poly.a.c.a.aV(c0153a.context.getApplicationContext()));
                f.b(c0153a.context.getApplicationContext());
                com.baidu.poly.util.c.aSq = c0153a.debug;
                return;
            }
            throw new IllegalArgumentException("context can not be null");
        }
        throw new IllegalArgumentException("channelPay can not be null");
    }
}
