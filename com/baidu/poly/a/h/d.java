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
/* loaded from: classes9.dex */
public class d {
    public static String bHT;
    public static String bHU;
    public static String bHV;
    public static String bHW;
    private static List<com.baidu.poly.a.h.b> bHX;
    private static Object bHY = new Object();
    public static String nd;

    /* loaded from: classes9.dex */
    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.doFlush();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class b extends com.baidu.poly.a.a.a {
        final /* synthetic */ com.baidu.poly.a.a.c bGM;
        final /* synthetic */ com.baidu.poly.a.a.b bGN;

        b(com.baidu.poly.a.a.c cVar, com.baidu.poly.a.a.b bVar) {
            this.bGM = cVar;
            this.bGN = bVar;
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Object obj) {
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            d.b(this.bGM.getMap(), this.bGN.getMap());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class c extends com.baidu.poly.a.a.a {
        final /* synthetic */ JSONArray bHR;
        final /* synthetic */ JSONObject bHS;

        c(JSONArray jSONArray, JSONObject jSONObject) {
            this.bHR = jSONArray;
            this.bHS = jSONObject;
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Object obj) {
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            this.bHR.put(this.bHS);
        }
    }

    public static void H() {
        nd = null;
        bHT = null;
        bHU = null;
        bHV = null;
        bHW = null;
    }

    private static JSONArray UF() {
        JSONArray jSONArray;
        File file = new File(g.Vb().getFilesDir(), "poly_cashier_statistics.json");
        if (file.exists()) {
            try {
                jSONArray = new JSONArray(com.baidu.poly.util.c.n(file));
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

    private static void US() {
        JSONArray UF = UF();
        if (UF != null && UF.length() != 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < UF.length(); i++) {
                    JSONObject jSONObject = UF.getJSONObject(i);
                    com.baidu.poly.a.a.c cVar = new com.baidu.poly.a.a.c();
                    cVar.b(e.af(jSONObject.optJSONObject(WebSocketRequest.PARAM_KEY_HEADER)));
                    com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
                    bVar.b(e.af(jSONObject.optJSONObject("body")));
                    new com.baidu.poly.a.h.c().a(cVar, bVar, new c(jSONArray, jSONObject));
                }
                o(jSONArray);
            } catch (Exception e) {
            }
        }
    }

    private static com.baidu.poly.a.a.c UT() {
        com.baidu.poly.a.a.c cVar = new com.baidu.poly.a.a.c();
        if (!TextUtils.isEmpty(nd)) {
            cVar.g(SM.COOKIE, "BDUSS=" + nd);
        }
        return cVar;
    }

    private static com.baidu.poly.a.a.b UU() {
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        bVar.g("dm", "cashier");
        bVar.g("os", "android");
        bVar.g("v", "2.7.5");
        if (!TextUtils.isEmpty(bHW)) {
            bVar.g("n", bHW);
        }
        if (!TextUtils.isEmpty(bHT)) {
            bVar.g("d", bHT);
        }
        if (!TextUtils.isEmpty(bHU)) {
            bVar.g("dt", bHU);
        }
        if (!TextUtils.isEmpty(bHV)) {
            bVar.g("dp", bHV);
        }
        return bVar;
    }

    private static void clear() {
        List<com.baidu.poly.a.h.b> list = bHX;
        if (list != null) {
            list.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void doFlush() {
        synchronized (d.class) {
            List<com.baidu.poly.a.h.b> list = bHX;
            if (list != null && !list.isEmpty()) {
                com.baidu.poly.a.a.b UU = UU();
                synchronized (bHY) {
                    JSONArray jSONArray = new JSONArray();
                    for (com.baidu.poly.a.h.b bVar : bHX) {
                        JSONObject UR = bVar.UR();
                        if (UR != null) {
                            jSONArray.put(UR);
                        }
                    }
                    UU.g("data", jSONArray.toString());
                    UU.g("s", HttpSigner.a(UU, "key", com.baidu.poly.a.b.a.q()));
                    clear();
                }
                com.baidu.poly.a.a.c UT = UT();
                if (f.J()) {
                    US();
                    new com.baidu.poly.a.h.c().a(UT, UU, new b(UT, UU));
                } else {
                    b(UT.getMap(), UU.getMap());
                }
            }
        }
    }

    public static void flush() {
        com.baidu.poly.c.a.execute(new a());
    }

    private static void o(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            com.baidu.poly.util.c.a(jSONArray.toString(), new File(g.Vb().getFilesDir(), "poly_cashier_statistics.json"));
        }
    }

    public static void a(com.baidu.poly.a.h.b bVar) {
        if (bHX == null) {
            bHX = new ArrayList();
        }
        if (bVar != null) {
            synchronized (bHY) {
                bHX.add(bVar);
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
            bVar.is(str);
            a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Map map, Map map2) {
        try {
            JSONArray UF = UF();
            if (UF != null) {
                if (UF.length() >= 20) {
                    UF.remove(0);
                }
            } else {
                UF = new JSONArray();
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject k = e.k(map);
            JSONObject k2 = e.k(map2);
            jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, k);
            jSONObject.put("body", k2);
            UF.put(jSONObject);
            o(UF);
        } catch (Exception e) {
        }
    }
}
