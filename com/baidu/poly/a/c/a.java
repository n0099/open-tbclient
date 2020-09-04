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
    static class RunnableC0263a implements Runnable {
        final /* synthetic */ com.baidu.poly.b.a bEZ;

        /* renamed from: com.baidu.poly.a.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        class C0264a extends com.baidu.poly.b.a {
            final /* synthetic */ JSONArray bEX;

            C0264a(JSONArray jSONArray) {
                this.bEX = jSONArray;
            }

            @Override // com.baidu.poly.b.a
            public void onResult(int i, String str) {
                com.baidu.poly.b.a aVar = RunnableC0263a.this.bEZ;
                if (aVar != null) {
                    aVar.onResult(i, str);
                }
                if (i == 1) {
                    a.b(this.bEX);
                }
            }
        }

        RunnableC0263a(com.baidu.poly.b.a aVar) {
            this.bEZ = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONArray TW = a.TW();
            if (TW == null) {
                return;
            }
            com.baidu.poly.a.b.a.a(TW, new C0264a(TW));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized JSONArray TW() {
        JSONArray jSONArray;
        JSONArray jSONArray2 = null;
        synchronized (a.class) {
            File file = new File(g.Us().getFilesDir(), "poly_cashier_commission_record_cache.json");
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
                    c.a(jSONArray.toString(), new File(g.Us().getFilesDir(), "poly_cashier_commission_record_cache.json"));
                }
            }
        }
    }

    public static void b(com.baidu.poly.b.a aVar) {
        com.baidu.poly.c.a.execute(new RunnableC0263a(aVar));
    }

    public static void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("operateTime", String.valueOf(System.currentTimeMillis() / 1000));
            } catch (JSONException e) {
            }
            JSONArray TW = TW();
            if (TW == null) {
                TW = new JSONArray();
            }
            TW.put(jSONObject);
            if (TW.length() > 100) {
                TW.remove(0);
            }
            b(TW);
        }
    }
}
