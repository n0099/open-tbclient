package com.baidu.poly.a.c;

import com.baidu.poly.util.c;
import com.baidu.poly.util.g;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: com.baidu.poly.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static class RunnableC0294a implements Runnable {
        final /* synthetic */ com.baidu.poly.b.a ciV;

        /* renamed from: com.baidu.poly.a.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class C0295a extends com.baidu.poly.b.a {
            final /* synthetic */ JSONArray ciT;

            C0295a(JSONArray jSONArray) {
                this.ciT = jSONArray;
            }

            @Override // com.baidu.poly.b.a
            public void onResult(int i, String str) {
                com.baidu.poly.b.a aVar = RunnableC0294a.this.ciV;
                if (aVar != null) {
                    aVar.onResult(i, str);
                }
                if (i == 1) {
                    a.b(this.ciT);
                }
            }
        }

        RunnableC0294a(com.baidu.poly.b.a aVar) {
            this.ciV = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONArray aby = a.aby();
            if (aby == null) {
                return;
            }
            com.baidu.poly.a.b.a.a(aby, new C0295a(aby));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized JSONArray aby() {
        JSONArray jSONArray;
        JSONArray jSONArray2 = null;
        synchronized (a.class) {
            File file = new File(g.abT().getFilesDir(), "poly_cashier_commission_record_cache.json");
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
                    c.a(jSONArray.toString(), new File(g.abT().getFilesDir(), "poly_cashier_commission_record_cache.json"));
                }
            }
        }
    }

    public static void b(com.baidu.poly.b.a aVar) {
        com.baidu.poly.c.a.execute(new RunnableC0294a(aVar));
    }

    public static void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("operateTime", String.valueOf(System.currentTimeMillis() / 1000));
            } catch (JSONException e) {
            }
            JSONArray aby = aby();
            if (aby == null) {
                aby = new JSONArray();
            }
            aby.put(jSONObject);
            if (aby.length() > 100) {
                aby.remove(0);
            }
            b(aby);
        }
    }
}
