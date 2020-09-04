package com.baidu.poly;

import android.content.Context;
import android.os.Bundle;
import com.baidu.poly.util.d;
import com.baidu.poly.util.g;
import com.baidu.poly.widget.PolyActivity;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    private long bEE;

    /* renamed from: com.baidu.poly.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0259a {
        private Context context;
        private int bEF = 1;
        private boolean debug = false;

        public a TS() {
            return new a(this);
        }

        public C0259a aM(Context context) {
            this.context = context;
            return this;
        }

        public C0259a dh(boolean z) {
            this.debug = z;
            return this;
        }

        public C0259a fN(int i) {
            this.bEF = i;
            return this;
        }
    }

    /* loaded from: classes6.dex */
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
            if (currentTimeMillis - this.bEE < 1000) {
                d.info("cashier pay time interval less than 1s");
                return;
            }
            this.bEE = currentTimeMillis;
            d.info("cashier pay");
            com.baidu.poly.a.h.a.a(Long.valueOf(currentTimeMillis));
            com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b("0"));
            PolyActivity.a(context, cVar, bVar, bundle);
            return;
        }
        throw new IllegalArgumentException("channelPay can not be null");
    }

    private a(C0259a c0259a) {
        this.bEE = 0L;
        if (c0259a != null) {
            if (c0259a.context != null) {
                com.baidu.poly.a.b.a.b(c0259a.bEF);
                com.baidu.poly.a.d.b.a(com.baidu.poly.a.d.a.aN(c0259a.context.getApplicationContext()));
                g.b(c0259a.context.getApplicationContext());
                d.bGM = c0259a.debug;
                return;
            }
            throw new IllegalArgumentException("context can not be null");
        }
        throw new IllegalArgumentException("builder can not be null");
    }
}
