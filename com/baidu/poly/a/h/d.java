package com.baidu.poly.a.h;

import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
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
/* loaded from: classes14.dex */
public class d {
    public static String cpI;
    public static String cpJ;
    public static String cpK;
    public static String cpL;
    private static List<com.baidu.poly.a.h.b> cpM;
    private static Object cpN = new Object();
    public static String pd;

    /* loaded from: classes14.dex */
    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.doFlush();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static class b extends com.baidu.poly.a.a.a {
        final /* synthetic */ com.baidu.poly.a.a.c cox;
        final /* synthetic */ com.baidu.poly.a.a.b coy;

        b(com.baidu.poly.a.a.c cVar, com.baidu.poly.a.a.b bVar) {
            this.cox = cVar;
            this.coy = bVar;
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Object obj) {
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            d.b(this.cox.getMap(), this.coy.getMap());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static class c extends com.baidu.poly.a.a.a {
        final /* synthetic */ JSONArray cpG;
        final /* synthetic */ JSONObject cpH;

        c(JSONArray jSONArray, JSONObject jSONObject) {
            this.cpG = jSONArray;
            this.cpH = jSONObject;
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Object obj) {
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            this.cpG.put(this.cpH);
        }
    }

    public static void H() {
        cpI = null;
        cpJ = null;
        pd = null;
        cpK = null;
        cpL = null;
    }

    private static void adB() {
        JSONArray adp = adp();
        if (adp != null && adp.length() != 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < adp.length(); i++) {
                    JSONObject jSONObject = adp.getJSONObject(i);
                    com.baidu.poly.a.a.c cVar = new com.baidu.poly.a.a.c();
                    cVar.b(e.az(jSONObject.optJSONObject(WebSocketRequest.PARAM_KEY_HEADER)));
                    com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
                    bVar.b(e.az(jSONObject.optJSONObject("body")));
                    new com.baidu.poly.a.h.c().a(cVar, bVar, new c(jSONArray, jSONObject));
                }
                p(jSONArray);
            } catch (Exception e) {
            }
        }
    }

    private static com.baidu.poly.a.a.c adC() {
        com.baidu.poly.a.a.c cVar = new com.baidu.poly.a.a.c();
        if (!TextUtils.isEmpty(cpI)) {
            cVar.g(SM.COOKIE, "BDUSS=" + cpI);
        }
        return cVar;
    }

    private static com.baidu.poly.a.a.b adD() {
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        bVar.g("dm", "cashier");
        bVar.g("os", HttpConstants.OS_TYPE_VALUE);
        bVar.g("v", "2.7.5");
        if (!TextUtils.isEmpty(cpL)) {
            bVar.g("n", cpL);
        }
        if (!TextUtils.isEmpty(cpJ)) {
            bVar.g("d", cpJ);
        }
        if (!TextUtils.isEmpty(pd)) {
            bVar.g("dt", pd);
        }
        if (!TextUtils.isEmpty(cpK)) {
            bVar.g("dp", cpK);
        }
        return bVar;
    }

    private static JSONArray adp() {
        JSONArray jSONArray;
        File file = new File(g.adK().getFilesDir(), "poly_cashier_statistics.json");
        if (file.exists()) {
            try {
                jSONArray = new JSONArray(com.baidu.poly.util.c.b(file));
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
        List<com.baidu.poly.a.h.b> list = cpM;
        if (list != null) {
            list.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void doFlush() {
        synchronized (d.class) {
            List<com.baidu.poly.a.h.b> list = cpM;
            if (list != null && !list.isEmpty()) {
                com.baidu.poly.a.a.b adD = adD();
                synchronized (cpN) {
                    JSONArray jSONArray = new JSONArray();
                    for (com.baidu.poly.a.h.b bVar : cpM) {
                        JSONObject adA = bVar.adA();
                        if (adA != null) {
                            jSONArray.put(adA);
                        }
                    }
                    adD.g("data", jSONArray.toString());
                    adD.g("s", HttpSigner.a(adD, "key", com.baidu.poly.a.b.a.q()));
                    clear();
                }
                com.baidu.poly.a.a.c adC = adC();
                if (f.J()) {
                    adB();
                    new com.baidu.poly.a.h.c().a(adC, adD, new b(adC, adD));
                } else {
                    b(adC.getMap(), adD.getMap());
                }
            }
        }
    }

    public static void flush() {
        com.baidu.poly.c.a.execute(new a());
    }

    private static void p(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            com.baidu.poly.util.c.a(jSONArray.toString(), new File(g.adK().getFilesDir(), "poly_cashier_statistics.json"));
        }
    }

    public static void a(com.baidu.poly.a.h.b bVar) {
        if (cpM == null) {
            cpM = new ArrayList();
        }
        if (bVar != null) {
            synchronized (cpN) {
                cpM.add(bVar);
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
            bVar.jx(str);
            a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Map map, Map map2) {
        try {
            JSONArray adp = adp();
            if (adp != null) {
                if (adp.length() >= 20) {
                    adp.remove(0);
                }
            } else {
                adp = new JSONArray();
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject n = e.n(map);
            JSONObject n2 = e.n(map2);
            jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, n);
            jSONObject.put("body", n2);
            adp.put(jSONObject);
            p(adp);
        } catch (Exception e) {
        }
    }
}
