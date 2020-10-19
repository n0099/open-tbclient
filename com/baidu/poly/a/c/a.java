package com.baidu.poly.a.c;

import com.baidu.poly.util.c;
import com.baidu.poly.util.g;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: com.baidu.poly.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static class RunnableC0276a implements Runnable {
        final /* synthetic */ com.baidu.poly.b.a bNJ;

        /* renamed from: com.baidu.poly.a.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        class C0277a extends com.baidu.poly.b.a {
            final /* synthetic */ JSONArray bNH;

            C0277a(JSONArray jSONArray) {
                this.bNH = jSONArray;
            }

            @Override // com.baidu.poly.b.a
            public void onResult(int i, String str) {
                com.baidu.poly.b.a aVar = RunnableC0276a.this.bNJ;
                if (aVar != null) {
                    aVar.onResult(i, str);
                }
                if (i == 1) {
                    a.b(this.bNH);
                }
            }
        }

        RunnableC0276a(com.baidu.poly.b.a aVar) {
            this.bNJ = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONArray WC = a.WC();
            if (WC == null) {
                return;
            }
            com.baidu.poly.a.b.a.a(WC, new C0277a(WC));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized JSONArray WC() {
        JSONArray jSONArray;
        JSONArray jSONArray2 = null;
        synchronized (a.class) {
            File file = new File(g.WY().getFilesDir(), "poly_cashier_commission_record_cache.json");
            if (file.exists()) {
                try {
                    jSONArray = new JSONArray(c.r(file));
                    try {
                        file.delete();
                    } catch (JSONException e) {
                    }
                } catch (JSONException e2) {
                    jSONArray = null;
                }
                jSONArray2 = jSONArray;
            }
        }
        return jSONArray2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void b(JSONArray jSONArray) {
        synchronized (a.class) {
            if (jSONArray != null) {
                if (jSONArray.length() != 0) {
                    c.a(jSONArray.toString(), new File(g.WY().getFilesDir(), "poly_cashier_commission_record_cache.json"));
                }
            }
        }
    }

    public static void b(com.baidu.poly.b.a aVar) {
        com.baidu.poly.c.a.execute(new RunnableC0276a(aVar));
    }

    public static void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("operateTime", String.valueOf(System.currentTimeMillis() / 1000));
            } catch (JSONException e) {
            }
            JSONArray WC = WC();
            if (WC == null) {
                WC = new JSONArray();
            }
            WC.put(jSONObject);
            if (WC.length() > 100) {
                WC.remove(0);
            }
            b(WC);
        }
    }
}
