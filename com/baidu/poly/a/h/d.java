package com.baidu.poly.a.h;

import android.text.TextUtils;
import com.baidu.poly.util.HttpSigner;
import com.baidu.poly.util.e;
import com.baidu.poly.util.f;
import com.baidu.poly.util.g;
import com.baidu.searchbox.websocket.WebSocketRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.cookie.SM;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {
    public static String caY;
    public static String caZ;
    public static String cba;
    public static String cbb;
    private static List<com.baidu.poly.a.h.b> cbc;
    private static Object cbd = new Object();
    public static String nd;

    /* loaded from: classes6.dex */
    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.doFlush();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class b extends com.baidu.poly.a.a.a {
        final /* synthetic */ com.baidu.poly.a.a.c bZR;
        final /* synthetic */ com.baidu.poly.a.a.b bZS;

        b(com.baidu.poly.a.a.c cVar, com.baidu.poly.a.a.b bVar) {
            this.bZR = cVar;
            this.bZS = bVar;
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Object obj) {
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            d.b(this.bZR.getMap(), this.bZS.getMap());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class c extends com.baidu.poly.a.a.a {
        final /* synthetic */ JSONArray caW;
        final /* synthetic */ JSONObject caX;

        c(JSONArray jSONArray, JSONObject jSONObject) {
            this.caW = jSONArray;
            this.caX = jSONObject;
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Object obj) {
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            this.caW.put(this.caX);
        }
    }

    public static void H() {
        nd = null;
        caY = null;
        caZ = null;
        cba = null;
        cbb = null;
    }

    private static com.baidu.poly.a.a.c aaA() {
        com.baidu.poly.a.a.c cVar = new com.baidu.poly.a.a.c();
        if (!TextUtils.isEmpty(nd)) {
            cVar.g(SM.COOKIE, "BDUSS=" + nd);
        }
        return cVar;
    }

    private static com.baidu.poly.a.a.b aaB() {
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        bVar.g("dm", "cashier");
        bVar.g("os", "android");
        bVar.g("v", "2.7.5");
        if (!TextUtils.isEmpty(cbb)) {
            bVar.g("n", cbb);
        }
        if (!TextUtils.isEmpty(caY)) {
            bVar.g("d", caY);
        }
        if (!TextUtils.isEmpty(caZ)) {
            bVar.g("dt", caZ);
        }
        if (!TextUtils.isEmpty(cba)) {
            bVar.g("dp", cba);
        }
        return bVar;
    }

    private static JSONArray aam() {
        JSONArray jSONArray;
        File file = new File(g.aaI().getFilesDir(), "poly_cashier_statistics.json");
        if (file.exists()) {
            try {
                jSONArray = new JSONArray(com.baidu.poly.util.c.r(file));
                try {
                    file.delete();
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                jSONArray = null;
            }
            return jSONArray;
        }
        return null;
    }

    private static void aaz() {
        JSONArray aam = aam();
        if (aam != null && aam.length() != 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < aam.length(); i++) {
                    JSONObject jSONObject = aam.getJSONObject(i);
                    com.baidu.poly.a.a.c cVar = new com.baidu.poly.a.a.c();
                    cVar.b(e.al(jSONObject.optJSONObject(WebSocketRequest.PARAM_KEY_HEADER)));
                    com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
                    bVar.b(e.al(jSONObject.optJSONObject("body")));
                    new com.baidu.poly.a.h.c().a(cVar, bVar, new c(jSONArray, jSONObject));
                }
                o(jSONArray);
            } catch (Exception e) {
            }
        }
    }

    private static void clear() {
        List<com.baidu.poly.a.h.b> list = cbc;
        if (list != null) {
            list.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void doFlush() {
        synchronized (d.class) {
            List<com.baidu.poly.a.h.b> list = cbc;
            if (list != null && !list.isEmpty()) {
                com.baidu.poly.a.a.b aaB = aaB();
                synchronized (cbd) {
                    JSONArray jSONArray = new JSONArray();
                    for (com.baidu.poly.a.h.b bVar : cbc) {
                        JSONObject aay = bVar.aay();
                        if (aay != null) {
                            jSONArray.put(aay);
                        }
                    }
                    aaB.g("data", jSONArray.toString());
                    aaB.g("s", HttpSigner.a(aaB, "key", com.baidu.poly.a.b.a.q()));
                    clear();
                }
                com.baidu.poly.a.a.c aaA = aaA();
                if (f.J()) {
                    aaz();
                    new com.baidu.poly.a.h.c().a(aaA, aaB, new b(aaA, aaB));
                } else {
                    b(aaA.getMap(), aaB.getMap());
                }
            }
        }
    }

    public static void flush() {
        com.baidu.poly.c.a.execute(new a());
    }

    private static void o(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            com.baidu.poly.util.c.a(jSONArray.toString(), new File(g.aaI().getFilesDir(), "poly_cashier_statistics.json"));
        }
    }

    public static void a(com.baidu.poly.a.h.b bVar) {
        if (cbc == null) {
            cbc = new ArrayList();
        }
        if (bVar != null) {
            synchronized (cbd) {
                cbc.add(bVar);
            }
        }
    }

    public static void b(int i, String str) {
        com.baidu.poly.a.h.b bVar = null;
        if (i == 0) {
            bVar = new com.baidu.poly.a.h.b("2");
        } else if (i == 2) {
            bVar = new com.baidu.poly.a.h.b("4");
        } else if (i == 3) {
            bVar = new com.baidu.poly.a.h.b("3");
        }
        if (bVar != null) {
            bVar.ju(str);
            a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Map map, Map map2) {
        try {
            JSONArray aam = aam();
            if (aam != null) {
                if (aam.length() >= 20) {
                    aam.remove(0);
                }
            } else {
                aam = new JSONArray();
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject m = e.m(map);
            JSONObject m2 = e.m(map2);
            jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, m);
            jSONObject.put("body", m2);
            aam.put(jSONObject);
            o(aam);
        } catch (Exception e) {
        }
    }
}
