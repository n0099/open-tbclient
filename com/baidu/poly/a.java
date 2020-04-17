package com.baidu.poly;

import android.content.Context;
import android.os.Bundle;
import com.baidu.poly.util.f;
import com.baidu.poly.widget.PolyActivity;
/* loaded from: classes11.dex */
public class a {
    private com.baidu.poly.c.a.c bml;
    private long bmm;

    /* renamed from: com.baidu.poly.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0177a {
        private com.baidu.poly.c.a.c bml;
        private Context context;
        private int bmn = 1;
        private boolean debug = false;

        public a KQ() {
            return new a(this);
        }

        public C0177a a(com.baidu.poly.c.a.c cVar) {
            this.bml = cVar;
            return this;
        }

        public C0177a aH(Context context) {
            this.context = context;
            return this;
        }

        public C0177a cF(boolean z) {
            this.debug = z;
            return this;
        }

        public C0177a dy(int i) {
            this.bmn = i;
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
            if (currentTimeMillis - this.bmm < 1000) {
                com.baidu.poly.util.c.info("cashier pay time interval less than 1s");
                return;
            }
            this.bmm = currentTimeMillis;
            com.baidu.poly.util.c.info("cashier pay");
            PolyActivity.a(context, this.bml, bVar, bundle);
            return;
        }
        throw new IllegalArgumentException("arguments can not be null");
    }

    private a(C0177a c0177a) {
        this.bmm = 0L;
        if (c0177a != null && c0177a.bml != null) {
            if (c0177a.context != null) {
                this.bml = c0177a.bml;
                com.baidu.poly.a.b.a.dz(c0177a.bmn);
                com.baidu.poly.a.c.b.a(com.baidu.poly.a.c.a.aI(c0177a.context.getApplicationContext()));
                f.b(c0177a.context.getApplicationContext());
                com.baidu.poly.util.c.bos = c0177a.debug;
                return;
            }
            throw new IllegalArgumentException("context can not be null");
        }
        throw new IllegalArgumentException("channelPay can not be null");
    }
}
