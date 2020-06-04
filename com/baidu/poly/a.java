package com.baidu.poly;

import android.content.Context;
import android.os.Bundle;
import com.baidu.poly.util.d;
import com.baidu.poly.util.g;
import com.baidu.poly.widget.PolyActivity;
/* loaded from: classes11.dex */
public class a {
    private com.baidu.poly.c.a.c btN;
    private long btO;

    /* renamed from: com.baidu.poly.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0232a {
        private com.baidu.poly.c.a.c btN;
        private Context context;
        private int btP = 1;
        private boolean debug = false;

        public a MJ() {
            return new a(this);
        }

        public C0232a a(com.baidu.poly.c.a.c cVar) {
            this.btN = cVar;
            return this;
        }

        public C0232a aF(Context context) {
            this.context = context;
            return this;
        }

        public C0232a cR(boolean z) {
            this.debug = z;
            return this;
        }

        public C0232a dG(int i) {
            this.btP = i;
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
            if (currentTimeMillis - this.btO < 1000) {
                d.info("cashier pay time interval less than 1s");
                return;
            }
            this.btO = currentTimeMillis;
            d.info("cashier pay");
            com.baidu.poly.a.g.a.a(Long.valueOf(currentTimeMillis));
            PolyActivity.a(context, this.btN, bVar, bundle);
            return;
        }
        throw new IllegalArgumentException("arguments can not be null");
    }

    private a(C0232a c0232a) {
        this.btO = 0L;
        if (c0232a != null && c0232a.btN != null) {
            if (c0232a.context != null) {
                this.btN = c0232a.btN;
                com.baidu.poly.a.b.a.dH(c0232a.btP);
                com.baidu.poly.a.c.b.a(com.baidu.poly.a.c.a.aG(c0232a.context.getApplicationContext()));
                g.b(c0232a.context.getApplicationContext());
                d.bvX = c0232a.debug;
                return;
            }
            throw new IllegalArgumentException("context can not be null");
        }
        throw new IllegalArgumentException("channelPay can not be null");
    }
}
