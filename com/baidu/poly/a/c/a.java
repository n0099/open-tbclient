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
    static class RunnableC0311a implements Runnable {
        final /* synthetic */ com.baidu.poly.b.a cnJ;

        /* renamed from: com.baidu.poly.a.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        class C0312a extends com.baidu.poly.b.a {
            final /* synthetic */ JSONArray cnH;

            C0312a(JSONArray jSONArray) {
                this.cnH = jSONArray;
            }

            @Override // com.baidu.poly.b.a
            public void onResult(int i, String str) {
                com.baidu.poly.b.a aVar = RunnableC0311a.this.cnJ;
                if (aVar != null) {
                    aVar.onResult(i, str);
                }
                if (i == 1) {
                    a.b(this.cnH);
                }
            }
        }

        RunnableC0311a(com.baidu.poly.b.a aVar) {
            this.cnJ = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONArray afr = a.afr();
            if (afr == null) {
                return;
            }
            com.baidu.poly.a.b.a.a(afr, new C0312a(afr));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized JSONArray afr() {
        JSONArray jSONArray;
        JSONArray jSONArray2 = null;
        synchronized (a.class) {
            File file = new File(g.afM().getFilesDir(), "poly_cashier_commission_record_cache.json");
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
                    c.a(jSONArray.toString(), new File(g.afM().getFilesDir(), "poly_cashier_commission_record_cache.json"));
                }
            }
        }
    }

    public static void b(com.baidu.poly.b.a aVar) {
        com.baidu.poly.c.a.execute(new RunnableC0311a(aVar));
    }

    public static void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("operateTime", String.valueOf(System.currentTimeMillis() / 1000));
            } catch (JSONException e) {
            }
            JSONArray afr = afr();
            if (afr == null) {
                afr = new JSONArray();
            }
            afr.put(jSONObject);
            if (afr.length() > 100) {
                afr.remove(0);
            }
            b(afr);
        }
    }
}
