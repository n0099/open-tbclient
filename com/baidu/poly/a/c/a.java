package com.baidu.poly.a.c;

import com.baidu.poly.util.c;
import com.baidu.poly.util.g;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {

    /* renamed from: com.baidu.poly.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    static class RunnableC0261a implements Runnable {
        final /* synthetic */ com.baidu.poly.b.a bHa;

        /* renamed from: com.baidu.poly.a.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        class C0262a extends com.baidu.poly.b.a {
            final /* synthetic */ JSONArray bGY;

            C0262a(JSONArray jSONArray) {
                this.bGY = jSONArray;
            }

            @Override // com.baidu.poly.b.a
            public void onResult(int i, String str) {
                com.baidu.poly.b.a aVar = RunnableC0261a.this.bHa;
                if (aVar != null) {
                    aVar.onResult(i, str);
                }
                if (i == 1) {
                    a.b(this.bGY);
                }
            }
        }

        RunnableC0261a(com.baidu.poly.b.a aVar) {
            this.bHa = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONArray UF = a.UF();
            if (UF == null) {
                return;
            }
            com.baidu.poly.a.b.a.a(UF, new C0262a(UF));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized JSONArray UF() {
        JSONArray jSONArray;
        JSONArray jSONArray2 = null;
        synchronized (a.class) {
            File file = new File(g.Vb().getFilesDir(), "poly_cashier_commission_record_cache.json");
            if (file.exists()) {
                try {
                    jSONArray = new JSONArray(c.n(file));
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
                    c.a(jSONArray.toString(), new File(g.Vb().getFilesDir(), "poly_cashier_commission_record_cache.json"));
                }
            }
        }
    }

    public static void b(com.baidu.poly.b.a aVar) {
        com.baidu.poly.c.a.execute(new RunnableC0261a(aVar));
    }

    public static void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("operateTime", String.valueOf(System.currentTimeMillis() / 1000));
            } catch (JSONException e) {
            }
            JSONArray UF = UF();
            if (UF == null) {
                UF = new JSONArray();
            }
            UF.put(jSONObject);
            if (UF.length() > 100) {
                UF.remove(0);
            }
            b(UF);
        }
    }
}
