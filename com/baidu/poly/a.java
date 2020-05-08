package com.baidu.poly;

import android.content.Context;
import android.os.Bundle;
import com.baidu.poly.util.f;
import com.baidu.poly.widget.PolyActivity;
/* loaded from: classes11.dex */
public class a {
    private com.baidu.poly.c.a.c bmr;
    private long bms;

    /* renamed from: com.baidu.poly.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0199a {
        private com.baidu.poly.c.a.c bmr;
        private Context context;
        private int bmt = 1;
        private boolean debug = false;

        public a KP() {
            return new a(this);
        }

        public C0199a a(com.baidu.poly.c.a.c cVar) {
            this.bmr = cVar;
            return this;
        }

        public C0199a av(Context context) {
            this.context = context;
            return this;
        }

        public C0199a cF(boolean z) {
            this.debug = z;
            return this;
        }

        public C0199a dy(int i) {
            this.bmt = i;
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
            if (currentTimeMillis - this.bms < 1000) {
                com.baidu.poly.util.c.info("cashier pay time interval less than 1s");
                return;
            }
            this.bms = currentTimeMillis;
            com.baidu.poly.util.c.info("cashier pay");
            PolyActivity.a(context, this.bmr, bVar, bundle);
            return;
        }
        throw new IllegalArgumentException("arguments can not be null");
    }

    private a(C0199a c0199a) {
        this.bms = 0L;
        if (c0199a != null && c0199a.bmr != null) {
            if (c0199a.context != null) {
                this.bmr = c0199a.bmr;
                com.baidu.poly.a.b.a.dz(c0199a.bmt);
                com.baidu.poly.a.c.b.a(com.baidu.poly.a.c.a.aw(c0199a.context.getApplicationContext()));
                f.b(c0199a.context.getApplicationContext());
                com.baidu.poly.util.c.box = c0199a.debug;
                return;
            }
            throw new IllegalArgumentException("context can not be null");
        }
        throw new IllegalArgumentException("channelPay can not be null");
    }
}
