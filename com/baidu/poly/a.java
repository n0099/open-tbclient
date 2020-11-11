package com.baidu.poly;

import android.content.Context;
import android.os.Bundle;
import com.baidu.poly.util.d;
import com.baidu.poly.util.g;
import com.baidu.poly.widget.PolyActivity;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    private long cbv;

    /* renamed from: com.baidu.poly.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0298a {
        private Context context;
        private int cbw = 1;
        private boolean debug = false;

        public C0298a aP(Context context) {
            this.context = context;
            return this;
        }

        public a aaR() {
            return new a(this);
        }

        public C0298a dH(boolean z) {
            this.debug = z;
            return this;
        }

        public C0298a gL(int i) {
            this.cbw = i;
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
            if (currentTimeMillis - this.cbv < 1000) {
                d.info("cashier pay time interval less than 1s");
                return;
            }
            this.cbv = currentTimeMillis;
            d.info("cashier pay");
            com.baidu.poly.a.h.a.a(Long.valueOf(currentTimeMillis));
            com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b("0"));
            PolyActivity.a(context, cVar, bVar, bundle);
            return;
        }
        throw new IllegalArgumentException("channelPay can not be null");
    }

    private a(C0298a c0298a) {
        this.cbv = 0L;
        if (c0298a != null) {
            if (c0298a.context != null) {
                com.baidu.poly.a.b.a.b(c0298a.cbw);
                com.baidu.poly.a.d.b.a(com.baidu.poly.a.d.a.aQ(c0298a.context.getApplicationContext()));
                g.b(c0298a.context.getApplicationContext());
                d.cdF = c0298a.debug;
                return;
            }
            throw new IllegalArgumentException("context can not be null");
        }
        throw new IllegalArgumentException("builder can not be null");
    }
}
