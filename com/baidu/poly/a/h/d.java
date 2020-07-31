package com.baidu.poly.a.h;

import android.text.TextUtils;
import com.baidu.poly.util.HttpSigner;
import com.baidu.poly.util.e;
import com.baidu.poly.util.f;
import com.baidu.poly.util.g;
import com.baidu.searchbox.suspensionball.SuspensionBallUbc;
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
    public static String bAj;
    public static String bAk;
    public static String bAl;
    public static String bAm;
    public static String bAn;
    private static List<com.baidu.poly.a.h.b> bAo;
    private static Object bAp = new Object();

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
        final /* synthetic */ com.baidu.poly.a.a.c bza;
        final /* synthetic */ com.baidu.poly.a.a.b bzb;

        b(com.baidu.poly.a.a.c cVar, com.baidu.poly.a.a.b bVar) {
            this.bza = cVar;
            this.bzb = bVar;
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Object obj) {
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            d.b(this.bza.getMap(), this.bzb.getMap());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class c extends com.baidu.poly.a.a.a {
        final /* synthetic */ JSONArray bAh;
        final /* synthetic */ JSONObject bAi;

        c(JSONArray jSONArray, JSONObject jSONObject) {
            this.bAh = jSONArray;
            this.bAi = jSONObject;
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Object obj) {
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            this.bAh.put(this.bAi);
        }
    }

    public static void G() {
        bAj = null;
        bAk = null;
        bAl = null;
        bAm = null;
        bAn = null;
    }

    private static JSONArray Od() {
        JSONArray jSONArray;
        File file = new File(g.OA().getFilesDir(), "poly_cashier_statistics.json");
        if (file.exists()) {
            try {
                jSONArray = new JSONArray(com.baidu.poly.util.c.m(file));
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

    private static void Op() {
        JSONArray Od = Od();
        if (Od != null && Od.length() != 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < Od.length(); i++) {
                    JSONObject jSONObject = Od.getJSONObject(i);
                    com.baidu.poly.a.a.c cVar = new com.baidu.poly.a.a.c();
                    cVar.b(e.aa(jSONObject.optJSONObject(WebSocketRequest.PARAM_KEY_HEADER)));
                    com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
                    bVar.b(e.aa(jSONObject.optJSONObject("body")));
                    new com.baidu.poly.a.h.c().a(cVar, bVar, new c(jSONArray, jSONObject));
                }
                o(jSONArray);
            } catch (Exception e) {
            }
        }
    }

    private static com.baidu.poly.a.a.c Oq() {
        com.baidu.poly.a.a.c cVar = new com.baidu.poly.a.a.c();
        if (!TextUtils.isEmpty(bAj)) {
            cVar.g(SM.COOKIE, "BDUSS=" + bAj);
        }
        return cVar;
    }

    private static com.baidu.poly.a.a.b Or() {
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        bVar.g("dm", "cashier");
        bVar.g("os", "android");
        bVar.g("v", "2.7.2");
        if (!TextUtils.isEmpty(bAn)) {
            bVar.g("n", bAn);
        }
        if (!TextUtils.isEmpty(bAk)) {
            bVar.g("d", bAk);
        }
        if (!TextUtils.isEmpty(bAl)) {
            bVar.g(SuspensionBallUbc.VALUE_DT, bAl);
        }
        if (!TextUtils.isEmpty(bAm)) {
            bVar.g("dp", bAm);
        }
        return bVar;
    }

    private static void clear() {
        List<com.baidu.poly.a.h.b> list = bAo;
        if (list != null) {
            list.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void doFlush() {
        synchronized (d.class) {
            List<com.baidu.poly.a.h.b> list = bAo;
            if (list != null && !list.isEmpty()) {
                com.baidu.poly.a.a.b Or = Or();
                synchronized (bAp) {
                    JSONArray jSONArray = new JSONArray();
                    for (com.baidu.poly.a.h.b bVar : bAo) {
                        JSONObject Oo = bVar.Oo();
                        if (Oo != null) {
                            jSONArray.put(Oo);
                        }
                    }
                    Or.g("data", jSONArray.toString());
                    Or.g("s", HttpSigner.a(Or, "key", com.baidu.poly.a.b.a.p()));
                    clear();
                }
                com.baidu.poly.a.a.c Oq = Oq();
                if (f.Oz()) {
                    Op();
                    new com.baidu.poly.a.h.c().a(Oq, Or, new b(Oq, Or));
                } else {
                    b(Oq.getMap(), Or.getMap());
                }
            }
        }
    }

    public static void flush() {
        com.baidu.poly.c.a.execute(new a());
    }

    private static void o(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            com.baidu.poly.util.c.a(jSONArray.toString(), new File(g.OA().getFilesDir(), "poly_cashier_statistics.json"));
        }
    }

    public static void a(com.baidu.poly.a.h.b bVar) {
        if (bAo == null) {
            bAo = new ArrayList();
        }
        if (bVar != null) {
            synchronized (bAp) {
                bAo.add(bVar);
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
            bVar.gE(str);
            a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Map map, Map map2) {
        try {
            JSONArray Od = Od();
            if (Od != null) {
                if (Od.length() >= 20) {
                    Od.remove(0);
                }
            } else {
                Od = new JSONArray();
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject k = e.k(map);
            JSONObject k2 = e.k(map2);
            jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, k);
            jSONObject.put("body", k2);
            Od.put(jSONObject);
            o(Od);
        } catch (Exception e) {
        }
    }
}
