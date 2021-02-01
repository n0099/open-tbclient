package com.baidu.poly.a.c;

import com.baidu.poly.util.c;
import com.baidu.poly.util.g;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: com.baidu.poly.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static class RunnableC0298a implements Runnable {
        final /* synthetic */ com.baidu.poly.b.a cnk;

        /* renamed from: com.baidu.poly.a.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        class C0299a extends com.baidu.poly.b.a {
            final /* synthetic */ JSONArray cni;

            C0299a(JSONArray jSONArray) {
                this.cni = jSONArray;
            }

            @Override // com.baidu.poly.b.a
            public void onResult(int i, String str) {
                com.baidu.poly.b.a aVar = RunnableC0298a.this.cnk;
                if (aVar != null) {
                    aVar.onResult(i, str);
                }
                if (i == 1) {
                    a.b(this.cni);
                }
            }
        }

        RunnableC0298a(com.baidu.poly.b.a aVar) {
            this.cnk = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONArray adm = a.adm();
            if (adm == null) {
                return;
            }
            com.baidu.poly.a.b.a.a(adm, new C0299a(adm));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized JSONArray adm() {
        JSONArray jSONArray;
        JSONArray jSONArray2 = null;
        synchronized (a.class) {
            File file = new File(g.adH().getFilesDir(), "poly_cashier_commission_record_cache.json");
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
                    c.a(jSONArray.toString(), new File(g.adH().getFilesDir(), "poly_cashier_commission_record_cache.json"));
                }
            }
        }
    }

    public static void b(com.baidu.poly.b.a aVar) {
        com.baidu.poly.c.a.execute(new RunnableC0298a(aVar));
    }

    public static void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("operateTime", String.valueOf(System.currentTimeMillis() / 1000));
            } catch (JSONException e) {
            }
            JSONArray adm = adm();
            if (adm == null) {
                adm = new JSONArray();
            }
            adm.put(jSONObject);
            if (adm.length() > 100) {
                adm.remove(0);
            }
            b(adm);
        }
    }
}
