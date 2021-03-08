package com.baidu.poly.a.c;

import com.baidu.poly.util.c;
import com.baidu.poly.util.g;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class a {

    /* renamed from: com.baidu.poly.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    static class RunnableC0304a implements Runnable {
        final /* synthetic */ com.baidu.poly.b.a coM;

        /* renamed from: com.baidu.poly.a.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes14.dex */
        class C0305a extends com.baidu.poly.b.a {
            final /* synthetic */ JSONArray coK;

            C0305a(JSONArray jSONArray) {
                this.coK = jSONArray;
            }

            @Override // com.baidu.poly.b.a
            public void onResult(int i, String str) {
                com.baidu.poly.b.a aVar = RunnableC0304a.this.coM;
                if (aVar != null) {
                    aVar.onResult(i, str);
                }
                if (i == 1) {
                    a.b(this.coK);
                }
            }
        }

        RunnableC0304a(com.baidu.poly.b.a aVar) {
            this.coM = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONArray adp = a.adp();
            if (adp == null) {
                return;
            }
            com.baidu.poly.a.b.a.a(adp, new C0305a(adp));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized JSONArray adp() {
        JSONArray jSONArray;
        JSONArray jSONArray2 = null;
        synchronized (a.class) {
            File file = new File(g.adK().getFilesDir(), "poly_cashier_commission_record_cache.json");
            if (file.exists()) {
                try {
                    jSONArray = new JSONArray(c.b(file));
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
                    c.a(jSONArray.toString(), new File(g.adK().getFilesDir(), "poly_cashier_commission_record_cache.json"));
                }
            }
        }
    }

    public static void b(com.baidu.poly.b.a aVar) {
        com.baidu.poly.c.a.execute(new RunnableC0304a(aVar));
    }

    public static void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("operateTime", String.valueOf(System.currentTimeMillis() / 1000));
            } catch (JSONException e) {
            }
            JSONArray adp = adp();
            if (adp == null) {
                adp = new JSONArray();
            }
            adp.put(jSONObject);
            if (adp.length() > 100) {
                adp.remove(0);
            }
            b(adp);
        }
    }
}
