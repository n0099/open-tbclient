package com.baidu.poly;

import android.content.Context;
import android.os.Bundle;
import com.baidu.poly.util.d;
import com.baidu.poly.util.g;
import com.baidu.poly.widget.PolyActivity;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class a {
    private long cor;

    /* renamed from: com.baidu.poly.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static class C0300a {
        private Context context;
        private int cos = 1;
        private boolean debug = false;

        public a adl() {
            return new a(this);
        }

        public C0300a bK(Context context) {
            this.context = context;
            return this;
        }

        public C0300a em(boolean z) {
            this.debug = z;
            return this;
        }

        public C0300a fE(int i) {
            this.cos = i;
            return this;
        }
    }

    /* loaded from: classes14.dex */
    public static abstract class b {
        public abstract void onResult(int i, String str);
    }

    public void a(int i, JSONObject jSONObject, com.baidu.poly.b.a aVar) {
        if (i == 1) {
            com.baidu.poly.a.b.a.b(jSONObject, aVar);
        } else if (i == 2) {
            com.baidu.poly.a.c.a.b(aVar);
        } else if (aVar != null) {
            aVar.onResult(1, "unknown command");
        }
    }

    public void a(Context context, Bundle bundle, com.baidu.poly.d.a.c cVar, b bVar) {
        if (context == null) {
            throw new IllegalArgumentException("context can not be null");
        }
        if (bundle == null) {
            throw new IllegalArgumentException("arguments can not be null");
        }
        if (cVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.cor < 1000) {
                d.info("cashier pay time interval less than 1s");
                return;
            }
            this.cor = currentTimeMillis;
            d.info("cashier pay");
            com.baidu.poly.a.h.a.a(Long.valueOf(currentTimeMillis));
            com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b("0"));
            PolyActivity.a(context, cVar, bVar, bundle);
            return;
        }
        throw new IllegalArgumentException("channelPay can not be null");
    }

    private a(C0300a c0300a) {
        this.cor = 0L;
        if (c0300a != null) {
            if (c0300a.context != null) {
                com.baidu.poly.a.b.a.b(c0300a.cos);
                com.baidu.poly.a.d.b.a(com.baidu.poly.a.d.a.bL(c0300a.context.getApplicationContext()));
                g.b(c0300a.context.getApplicationContext());
                d.cqC = c0300a.debug;
                return;
            }
            throw new IllegalArgumentException("context can not be null");
        }
        throw new IllegalArgumentException("builder can not be null");
    }
}
