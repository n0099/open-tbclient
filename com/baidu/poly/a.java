package com.baidu.poly;

import android.content.Context;
import android.os.Bundle;
import com.baidu.poly.util.f;
import com.baidu.poly.widget.PolyActivity;
/* loaded from: classes9.dex */
public class a {
    private com.baidu.poly.c.a.c aKC;
    private long aKD;

    /* renamed from: com.baidu.poly.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0142a {
        private com.baidu.poly.c.a.c aKC;
        private Context context;
        private int aKE = 1;
        private boolean debug = false;

        public a BE() {
            return new a(this);
        }

        public C0142a a(com.baidu.poly.c.a.c cVar) {
            this.aKC = cVar;
            return this;
        }

        public C0142a aR(Context context) {
            this.context = context;
            return this;
        }

        public C0142a bA(boolean z) {
            this.debug = z;
            return this;
        }

        public C0142a db(int i) {
            this.aKE = i;
            return this;
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class b {
        public abstract void onResult(int i, String str);
    }

    public void a(Context context, Bundle bundle, b bVar) {
        if (context == null) {
            throw new IllegalArgumentException("context can not be null");
        }
        if (bundle != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.aKD < 1000) {
                com.baidu.poly.util.c.info("cashier pay time interval less than 1s");
                return;
            }
            this.aKD = currentTimeMillis;
            com.baidu.poly.util.c.info("cashier pay");
            PolyActivity.a(context, this.aKC, bVar, bundle);
            return;
        }
        throw new IllegalArgumentException("arguments can not be null");
    }

    private a(C0142a c0142a) {
        this.aKD = 0L;
        if (c0142a != null && c0142a.aKC != null) {
            if (c0142a.context != null) {
                this.aKC = c0142a.aKC;
                com.baidu.poly.a.b.a.init(c0142a.aKE);
                com.baidu.poly.a.c.b.a(com.baidu.poly.a.c.a.aS(c0142a.context.getApplicationContext()));
                f.b(c0142a.context.getApplicationContext());
                com.baidu.poly.util.c.aMK = c0142a.debug;
                return;
            }
            throw new IllegalArgumentException("context can not be null");
        }
        throw new IllegalArgumentException("channelPay can not be null");
    }
}
