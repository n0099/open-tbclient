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
    public static String ccK;
    public static String ccL;
    public static String ccM;
    public static String ccN;
    private static List<com.baidu.poly.a.h.b> ccO;
    private static Object ccP = new Object();
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
        final /* synthetic */ com.baidu.poly.a.a.c cbC;
        final /* synthetic */ com.baidu.poly.a.a.b cbD;

        b(com.baidu.poly.a.a.c cVar, com.baidu.poly.a.a.b bVar) {
            this.cbC = cVar;
            this.cbD = bVar;
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Object obj) {
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            d.b(this.cbC.getMap(), this.cbD.getMap());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class c extends com.baidu.poly.a.a.a {
        final /* synthetic */ JSONArray ccI;
        final /* synthetic */ JSONObject ccJ;

        c(JSONArray jSONArray, JSONObject jSONObject) {
            this.ccI = jSONArray;
            this.ccJ = jSONObject;
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Object obj) {
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            this.ccI.put(this.ccJ);
        }
    }

    public static void H() {
        nd = null;
        ccK = null;
        ccL = null;
        ccM = null;
        ccN = null;
    }

    private static JSONArray aaV() {
        JSONArray jSONArray;
        File file = new File(g.abr().getFilesDir(), "poly_cashier_statistics.json");
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

    private static void abi() {
        JSONArray aaV = aaV();
        if (aaV != null && aaV.length() != 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < aaV.length(); i++) {
                    JSONObject jSONObject = aaV.getJSONObject(i);
                    com.baidu.poly.a.a.c cVar = new com.baidu.poly.a.a.c();
                    cVar.b(e.ar(jSONObject.optJSONObject(WebSocketRequest.PARAM_KEY_HEADER)));
                    com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
                    bVar.b(e.ar(jSONObject.optJSONObject("body")));
                    new com.baidu.poly.a.h.c().a(cVar, bVar, new c(jSONArray, jSONObject));
                }
                o(jSONArray);
            } catch (Exception e) {
            }
        }
    }

    private static com.baidu.poly.a.a.c abj() {
        com.baidu.poly.a.a.c cVar = new com.baidu.poly.a.a.c();
        if (!TextUtils.isEmpty(nd)) {
            cVar.g(SM.COOKIE, "BDUSS=" + nd);
        }
        return cVar;
    }

    private static com.baidu.poly.a.a.b abk() {
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        bVar.g("dm", "cashier");
        bVar.g("os", "android");
        bVar.g("v", "2.7.5");
        if (!TextUtils.isEmpty(ccN)) {
            bVar.g("n", ccN);
        }
        if (!TextUtils.isEmpty(ccK)) {
            bVar.g("d", ccK);
        }
        if (!TextUtils.isEmpty(ccL)) {
            bVar.g("dt", ccL);
        }
        if (!TextUtils.isEmpty(ccM)) {
            bVar.g("dp", ccM);
        }
        return bVar;
    }

    private static void clear() {
        List<com.baidu.poly.a.h.b> list = ccO;
        if (list != null) {
            list.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void doFlush() {
        synchronized (d.class) {
            List<com.baidu.poly.a.h.b> list = ccO;
            if (list != null && !list.isEmpty()) {
                com.baidu.poly.a.a.b abk = abk();
                synchronized (ccP) {
                    JSONArray jSONArray = new JSONArray();
                    for (com.baidu.poly.a.h.b bVar : ccO) {
                        JSONObject abh = bVar.abh();
                        if (abh != null) {
                            jSONArray.put(abh);
                        }
                    }
                    abk.g("data", jSONArray.toString());
                    abk.g("s", HttpSigner.a(abk, "key", com.baidu.poly.a.b.a.q()));
                    clear();
                }
                com.baidu.poly.a.a.c abj = abj();
                if (f.J()) {
                    abi();
                    new com.baidu.poly.a.h.c().a(abj, abk, new b(abj, abk));
                } else {
                    b(abj.getMap(), abk.getMap());
                }
            }
        }
    }

    public static void flush() {
        com.baidu.poly.c.a.execute(new a());
    }

    private static void o(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            com.baidu.poly.util.c.a(jSONArray.toString(), new File(g.abr().getFilesDir(), "poly_cashier_statistics.json"));
        }
    }

    public static void a(com.baidu.poly.a.h.b bVar) {
        if (ccO == null) {
            ccO = new ArrayList();
        }
        if (bVar != null) {
            synchronized (ccP) {
                ccO.add(bVar);
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
            bVar.jA(str);
            a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Map map, Map map2) {
        try {
            JSONArray aaV = aaV();
            if (aaV != null) {
                if (aaV.length() >= 20) {
                    aaV.remove(0);
                }
            } else {
                aaV = new JSONArray();
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject m = e.m(map);
            JSONObject m2 = e.m(map2);
            jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, m);
            jSONObject.put("body", m2);
            aaV.put(jSONObject);
            o(aaV);
        } catch (Exception e) {
        }
    }
}
