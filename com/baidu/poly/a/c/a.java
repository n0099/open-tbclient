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
    static class RunnableC0242a implements Runnable {
        final /* synthetic */ com.baidu.poly.b.a bzp;

        /* renamed from: com.baidu.poly.a.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        class C0243a extends com.baidu.poly.b.a {
            final /* synthetic */ JSONArray bzn;

            C0243a(JSONArray jSONArray) {
                this.bzn = jSONArray;
            }

            @Override // com.baidu.poly.b.a
            public void onResult(int i, String str) {
                com.baidu.poly.b.a aVar = RunnableC0242a.this.bzp;
                if (aVar != null) {
                    aVar.onResult(i, str);
                }
                if (i == 1) {
                    a.b(this.bzn);
                }
            }
        }

        RunnableC0242a(com.baidu.poly.b.a aVar) {
            this.bzp = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONArray Od = a.Od();
            if (Od == null) {
                return;
            }
            com.baidu.poly.a.b.a.a(Od, new C0243a(Od));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized JSONArray Od() {
        JSONArray jSONArray;
        JSONArray jSONArray2 = null;
        synchronized (a.class) {
            File file = new File(g.OA().getFilesDir(), "poly_cashier_commission_record_cache.json");
            if (file.exists()) {
                try {
                    jSONArray = new JSONArray(c.m(file));
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
                    c.a(jSONArray.toString(), new File(g.OA().getFilesDir(), "poly_cashier_commission_record_cache.json"));
                }
            }
        }
    }

    public static void b(com.baidu.poly.b.a aVar) {
        com.baidu.poly.c.a.execute(new RunnableC0242a(aVar));
    }

    public static void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("operateTime", String.valueOf(System.currentTimeMillis() / 1000));
            } catch (JSONException e) {
            }
            JSONArray Od = Od();
            if (Od == null) {
                Od = new JSONArray();
            }
            Od.put(jSONObject);
            if (Od.length() > 100) {
                Od.remove(0);
            }
            b(Od);
        }
    }
}
