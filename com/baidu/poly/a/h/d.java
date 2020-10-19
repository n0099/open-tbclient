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
    public static String bOC;
    public static String bOD;
    public static String bOE;
    public static String bOF;
    private static List<com.baidu.poly.a.h.b> bOG;
    private static Object bOH = new Object();
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
        final /* synthetic */ com.baidu.poly.a.a.c bNv;
        final /* synthetic */ com.baidu.poly.a.a.b bNw;

        b(com.baidu.poly.a.a.c cVar, com.baidu.poly.a.a.b bVar) {
            this.bNv = cVar;
            this.bNw = bVar;
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Object obj) {
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            d.b(this.bNv.getMap(), this.bNw.getMap());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class c extends com.baidu.poly.a.a.a {
        final /* synthetic */ JSONArray bOA;
        final /* synthetic */ JSONObject bOB;

        c(JSONArray jSONArray, JSONObject jSONObject) {
            this.bOA = jSONArray;
            this.bOB = jSONObject;
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Object obj) {
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            this.bOA.put(this.bOB);
        }
    }

    public static void H() {
        nd = null;
        bOC = null;
        bOD = null;
        bOE = null;
        bOF = null;
    }

    private static JSONArray WC() {
        JSONArray jSONArray;
        File file = new File(g.WY().getFilesDir(), "poly_cashier_statistics.json");
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

    private static void WP() {
        JSONArray WC = WC();
        if (WC != null && WC.length() != 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < WC.length(); i++) {
                    JSONObject jSONObject = WC.getJSONObject(i);
                    com.baidu.poly.a.a.c cVar = new com.baidu.poly.a.a.c();
                    cVar.b(e.ai(jSONObject.optJSONObject(WebSocketRequest.PARAM_KEY_HEADER)));
                    com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
                    bVar.b(e.ai(jSONObject.optJSONObject("body")));
                    new com.baidu.poly.a.h.c().a(cVar, bVar, new c(jSONArray, jSONObject));
                }
                o(jSONArray);
            } catch (Exception e) {
            }
        }
    }

    private static com.baidu.poly.a.a.c WQ() {
        com.baidu.poly.a.a.c cVar = new com.baidu.poly.a.a.c();
        if (!TextUtils.isEmpty(nd)) {
            cVar.g(SM.COOKIE, "BDUSS=" + nd);
        }
        return cVar;
    }

    private static com.baidu.poly.a.a.b WR() {
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        bVar.g("dm", "cashier");
        bVar.g("os", "android");
        bVar.g("v", "2.7.5");
        if (!TextUtils.isEmpty(bOF)) {
            bVar.g("n", bOF);
        }
        if (!TextUtils.isEmpty(bOC)) {
            bVar.g("d", bOC);
        }
        if (!TextUtils.isEmpty(bOD)) {
            bVar.g("dt", bOD);
        }
        if (!TextUtils.isEmpty(bOE)) {
            bVar.g("dp", bOE);
        }
        return bVar;
    }

    private static void clear() {
        List<com.baidu.poly.a.h.b> list = bOG;
        if (list != null) {
            list.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void doFlush() {
        synchronized (d.class) {
            List<com.baidu.poly.a.h.b> list = bOG;
            if (list != null && !list.isEmpty()) {
                com.baidu.poly.a.a.b WR = WR();
                synchronized (bOH) {
                    JSONArray jSONArray = new JSONArray();
                    for (com.baidu.poly.a.h.b bVar : bOG) {
                        JSONObject WO = bVar.WO();
                        if (WO != null) {
                            jSONArray.put(WO);
                        }
                    }
                    WR.g("data", jSONArray.toString());
                    WR.g("s", HttpSigner.a(WR, "key", com.baidu.poly.a.b.a.q()));
                    clear();
                }
                com.baidu.poly.a.a.c WQ = WQ();
                if (f.J()) {
                    WP();
                    new com.baidu.poly.a.h.c().a(WQ, WR, new b(WQ, WR));
                } else {
                    b(WQ.getMap(), WR.getMap());
                }
            }
        }
    }

    public static void flush() {
        com.baidu.poly.c.a.execute(new a());
    }

    private static void o(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            com.baidu.poly.util.c.a(jSONArray.toString(), new File(g.WY().getFilesDir(), "poly_cashier_statistics.json"));
        }
    }

    public static void a(com.baidu.poly.a.h.b bVar) {
        if (bOG == null) {
            bOG = new ArrayList();
        }
        if (bVar != null) {
            synchronized (bOH) {
                bOG.add(bVar);
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
            bVar.iU(str);
            a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Map map, Map map2) {
        try {
            JSONArray WC = WC();
            if (WC != null) {
                if (WC.length() >= 20) {
                    WC.remove(0);
                }
            } else {
                WC = new JSONArray();
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject m = e.m(map);
            JSONObject m2 = e.m(map2);
            jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, m);
            jSONObject.put("body", m2);
            WC.put(jSONObject);
            o(WC);
        } catch (Exception e) {
        }
    }
}
