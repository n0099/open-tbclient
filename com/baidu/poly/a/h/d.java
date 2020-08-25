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
/* loaded from: classes6.dex */
public class d {
    public static String bFO;
    public static String bFP;
    public static String bFQ;
    public static String bFR;
    private static List<com.baidu.poly.a.h.b> bFS;
    private static Object bFT = new Object();
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
        final /* synthetic */ com.baidu.poly.a.a.c bEH;
        final /* synthetic */ com.baidu.poly.a.a.b bEI;

        b(com.baidu.poly.a.a.c cVar, com.baidu.poly.a.a.b bVar) {
            this.bEH = cVar;
            this.bEI = bVar;
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Object obj) {
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            d.b(this.bEH.getMap(), this.bEI.getMap());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class c extends com.baidu.poly.a.a.a {
        final /* synthetic */ JSONArray bFM;
        final /* synthetic */ JSONObject bFN;

        c(JSONArray jSONArray, JSONObject jSONObject) {
            this.bFM = jSONArray;
            this.bFN = jSONObject;
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Object obj) {
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            this.bFM.put(this.bFN);
        }
    }

    public static void H() {
        nd = null;
        bFO = null;
        bFP = null;
        bFQ = null;
        bFR = null;
    }

    private static JSONArray TW() {
        JSONArray jSONArray;
        File file = new File(g.Us().getFilesDir(), "poly_cashier_statistics.json");
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

    private static void Uj() {
        JSONArray TW = TW();
        if (TW != null && TW.length() != 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < TW.length(); i++) {
                    JSONObject jSONObject = TW.getJSONObject(i);
                    com.baidu.poly.a.a.c cVar = new com.baidu.poly.a.a.c();
                    cVar.b(e.ac(jSONObject.optJSONObject(WebSocketRequest.PARAM_KEY_HEADER)));
                    com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
                    bVar.b(e.ac(jSONObject.optJSONObject("body")));
                    new com.baidu.poly.a.h.c().a(cVar, bVar, new c(jSONArray, jSONObject));
                }
                o(jSONArray);
            } catch (Exception e) {
            }
        }
    }

    private static com.baidu.poly.a.a.c Uk() {
        com.baidu.poly.a.a.c cVar = new com.baidu.poly.a.a.c();
        if (!TextUtils.isEmpty(nd)) {
            cVar.g(SM.COOKIE, "BDUSS=" + nd);
        }
        return cVar;
    }

    private static com.baidu.poly.a.a.b Ul() {
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        bVar.g("dm", "cashier");
        bVar.g("os", "android");
        bVar.g("v", "2.7.5");
        if (!TextUtils.isEmpty(bFR)) {
            bVar.g("n", bFR);
        }
        if (!TextUtils.isEmpty(bFO)) {
            bVar.g("d", bFO);
        }
        if (!TextUtils.isEmpty(bFP)) {
            bVar.g(SuspensionBallUbc.VALUE_DT, bFP);
        }
        if (!TextUtils.isEmpty(bFQ)) {
            bVar.g("dp", bFQ);
        }
        return bVar;
    }

    private static void clear() {
        List<com.baidu.poly.a.h.b> list = bFS;
        if (list != null) {
            list.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void doFlush() {
        synchronized (d.class) {
            List<com.baidu.poly.a.h.b> list = bFS;
            if (list != null && !list.isEmpty()) {
                com.baidu.poly.a.a.b Ul = Ul();
                synchronized (bFT) {
                    JSONArray jSONArray = new JSONArray();
                    for (com.baidu.poly.a.h.b bVar : bFS) {
                        JSONObject Ui = bVar.Ui();
                        if (Ui != null) {
                            jSONArray.put(Ui);
                        }
                    }
                    Ul.g("data", jSONArray.toString());
                    Ul.g("s", HttpSigner.a(Ul, "key", com.baidu.poly.a.b.a.q()));
                    clear();
                }
                com.baidu.poly.a.a.c Uk = Uk();
                if (f.J()) {
                    Uj();
                    new com.baidu.poly.a.h.c().a(Uk, Ul, new b(Uk, Ul));
                } else {
                    b(Uk.getMap(), Ul.getMap());
                }
            }
        }
    }

    public static void flush() {
        com.baidu.poly.c.a.execute(new a());
    }

    private static void o(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            com.baidu.poly.util.c.a(jSONArray.toString(), new File(g.Us().getFilesDir(), "poly_cashier_statistics.json"));
        }
    }

    public static void a(com.baidu.poly.a.h.b bVar) {
        if (bFS == null) {
            bFS = new ArrayList();
        }
        if (bVar != null) {
            synchronized (bFT) {
                bFS.add(bVar);
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
            bVar.hY(str);
            a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Map map, Map map2) {
        try {
            JSONArray TW = TW();
            if (TW != null) {
                if (TW.length() >= 20) {
                    TW.remove(0);
                }
            } else {
                TW = new JSONArray();
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject k = e.k(map);
            JSONObject k2 = e.k(map2);
            jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, k);
            jSONObject.put("body", k2);
            TW.put(jSONObject);
            o(TW);
        } catch (Exception e) {
        }
    }
}
