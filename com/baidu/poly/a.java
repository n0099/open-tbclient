package com.baidu.poly;

import android.content.Context;
import android.os.Bundle;
import com.baidu.poly.util.d;
import com.baidu.poly.util.g;
import com.baidu.poly.widget.PolyActivity;
/* loaded from: classes11.dex */
public class a {
    private com.baidu.poly.c.a.c byH;
    private long byI;

    /* renamed from: com.baidu.poly.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0238a {
        private com.baidu.poly.c.a.c byH;
        private Context context;
        private int byJ = 1;
        private boolean debug = false;

        public a NS() {
            return new a(this);
        }

        public C0238a a(com.baidu.poly.c.a.c cVar) {
            this.byH = cVar;
            return this;
        }

        public C0238a aG(Context context) {
            this.context = context;
            return this;
        }

        public C0238a cW(boolean z) {
            this.debug = z;
            return this;
        }

        public C0238a dR(int i) {
            this.byJ = i;
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
            if (currentTimeMillis - this.byI < 1000) {
                d.info("cashier pay time interval less than 1s");
                return;
            }
            this.byI = currentTimeMillis;
            d.info("cashier pay");
            com.baidu.poly.a.g.a.a(Long.valueOf(currentTimeMillis));
            PolyActivity.a(context, this.byH, bVar, bundle);
            return;
        }
        throw new IllegalArgumentException("arguments can not be null");
    }

    private a(C0238a c0238a) {
        this.byI = 0L;
        if (c0238a != null && c0238a.byH != null) {
            if (c0238a.context != null) {
                this.byH = c0238a.byH;
                com.baidu.poly.a.b.a.dS(c0238a.byJ);
                com.baidu.poly.a.c.b.a(com.baidu.poly.a.c.a.aH(c0238a.context.getApplicationContext()));
                g.b(c0238a.context.getApplicationContext());
                d.bAO = c0238a.debug;
                return;
            }
            throw new IllegalArgumentException("context can not be null");
        }
        throw new IllegalArgumentException("channelPay can not be null");
    }
}
