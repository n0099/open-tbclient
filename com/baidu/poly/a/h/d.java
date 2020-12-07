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
/* loaded from: classes19.dex */
public class d {
    public static String chB;
    public static String chC;
    public static String chD;
    public static String chE;
    private static List<com.baidu.poly.a.h.b> chF;
    private static Object chG = new Object();
    public static String pd;

    /* loaded from: classes19.dex */
    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.doFlush();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public static class b extends com.baidu.poly.a.a.a {
        final /* synthetic */ com.baidu.poly.a.a.c cgr;
        final /* synthetic */ com.baidu.poly.a.a.b cgs;

        b(com.baidu.poly.a.a.c cVar, com.baidu.poly.a.a.b bVar) {
            this.cgr = cVar;
            this.cgs = bVar;
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Object obj) {
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            d.b(this.cgr.getMap(), this.cgs.getMap());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public static class c extends com.baidu.poly.a.a.a {
        final /* synthetic */ JSONObject chA;
        final /* synthetic */ JSONArray chz;

        c(JSONArray jSONArray, JSONObject jSONObject) {
            this.chz = jSONArray;
            this.chA = jSONObject;
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Object obj) {
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            this.chz.put(this.chA);
        }
    }

    public static void H() {
        chB = null;
        chC = null;
        pd = null;
        chD = null;
        chE = null;
    }

    private static void adH() {
        JSONArray adu = adu();
        if (adu != null && adu.length() != 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < adu.length(); i++) {
                    JSONObject jSONObject = adu.getJSONObject(i);
                    com.baidu.poly.a.a.c cVar = new com.baidu.poly.a.a.c();
                    cVar.b(e.an(jSONObject.optJSONObject(WebSocketRequest.PARAM_KEY_HEADER)));
                    com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
                    bVar.b(e.an(jSONObject.optJSONObject("body")));
                    new com.baidu.poly.a.h.c().a(cVar, bVar, new c(jSONArray, jSONObject));
                }
                p(jSONArray);
            } catch (Exception e) {
            }
        }
    }

    private static com.baidu.poly.a.a.c adI() {
        com.baidu.poly.a.a.c cVar = new com.baidu.poly.a.a.c();
        if (!TextUtils.isEmpty(chB)) {
            cVar.g(SM.COOKIE, "BDUSS=" + chB);
        }
        return cVar;
    }

    private static com.baidu.poly.a.a.b adJ() {
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        bVar.g("dm", "cashier");
        bVar.g("os", "android");
        bVar.g("v", "2.7.5");
        if (!TextUtils.isEmpty(chE)) {
            bVar.g("n", chE);
        }
        if (!TextUtils.isEmpty(chC)) {
            bVar.g("d", chC);
        }
        if (!TextUtils.isEmpty(pd)) {
            bVar.g("dt", pd);
        }
        if (!TextUtils.isEmpty(chD)) {
            bVar.g("dp", chD);
        }
        return bVar;
    }

    private static JSONArray adu() {
        JSONArray jSONArray;
        File file = new File(g.adQ().getFilesDir(), "poly_cashier_statistics.json");
        if (file.exists()) {
            try {
                jSONArray = new JSONArray(com.baidu.poly.util.c.p(file));
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

    private static void clear() {
        List<com.baidu.poly.a.h.b> list = chF;
        if (list != null) {
            list.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void doFlush() {
        synchronized (d.class) {
            List<com.baidu.poly.a.h.b> list = chF;
            if (list != null && !list.isEmpty()) {
                com.baidu.poly.a.a.b adJ = adJ();
                synchronized (chG) {
                    JSONArray jSONArray = new JSONArray();
                    for (com.baidu.poly.a.h.b bVar : chF) {
                        JSONObject adG = bVar.adG();
                        if (adG != null) {
                            jSONArray.put(adG);
                        }
                    }
                    adJ.g("data", jSONArray.toString());
                    adJ.g("s", HttpSigner.a(adJ, "key", com.baidu.poly.a.b.a.q()));
                    clear();
                }
                com.baidu.poly.a.a.c adI = adI();
                if (f.J()) {
                    adH();
                    new com.baidu.poly.a.h.c().a(adI, adJ, new b(adI, adJ));
                } else {
                    b(adI.getMap(), adJ.getMap());
                }
            }
        }
    }

    public static void flush() {
        com.baidu.poly.c.a.execute(new a());
    }

    private static void p(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            com.baidu.poly.util.c.a(jSONArray.toString(), new File(g.adQ().getFilesDir(), "poly_cashier_statistics.json"));
        }
    }

    public static void a(com.baidu.poly.a.h.b bVar) {
        if (chF == null) {
            chF = new ArrayList();
        }
        if (bVar != null) {
            synchronized (chG) {
                chF.add(bVar);
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
            bVar.kb(str);
            a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Map map, Map map2) {
        try {
            JSONArray adu = adu();
            if (adu != null) {
                if (adu.length() >= 20) {
                    adu.remove(0);
                }
            } else {
                adu = new JSONArray();
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject m = e.m(map);
            JSONObject m2 = e.m(map2);
            jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, m);
            jSONObject.put("body", m2);
            adu.put(jSONObject);
            p(adu);
        } catch (Exception e) {
        }
    }
}
