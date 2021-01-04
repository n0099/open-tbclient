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
/* loaded from: classes3.dex */
public class d {
    public static String coE;
    public static String coF;
    public static String coG;
    public static String coH;
    private static List<com.baidu.poly.a.h.b> coI;
    private static Object coJ = new Object();
    public static String pd;

    /* loaded from: classes3.dex */
    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.doFlush();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class b extends com.baidu.poly.a.a.a {
        final /* synthetic */ com.baidu.poly.a.a.c cnu;
        final /* synthetic */ com.baidu.poly.a.a.b cnv;

        b(com.baidu.poly.a.a.c cVar, com.baidu.poly.a.a.b bVar) {
            this.cnu = cVar;
            this.cnv = bVar;
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Object obj) {
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            d.b(this.cnu.getMap(), this.cnv.getMap());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class c extends com.baidu.poly.a.a.a {
        final /* synthetic */ JSONArray coC;
        final /* synthetic */ JSONObject coD;

        c(JSONArray jSONArray, JSONObject jSONObject) {
            this.coC = jSONArray;
            this.coD = jSONObject;
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Object obj) {
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            this.coC.put(this.coD);
        }
    }

    public static void H() {
        coE = null;
        coF = null;
        pd = null;
        coG = null;
        coH = null;
    }

    private static void afC() {
        JSONArray afq = afq();
        if (afq != null && afq.length() != 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < afq.length(); i++) {
                    JSONObject jSONObject = afq.getJSONObject(i);
                    com.baidu.poly.a.a.c cVar = new com.baidu.poly.a.a.c();
                    cVar.b(e.av(jSONObject.optJSONObject(WebSocketRequest.PARAM_KEY_HEADER)));
                    com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
                    bVar.b(e.av(jSONObject.optJSONObject("body")));
                    new com.baidu.poly.a.h.c().a(cVar, bVar, new c(jSONArray, jSONObject));
                }
                p(jSONArray);
            } catch (Exception e) {
            }
        }
    }

    private static com.baidu.poly.a.a.c afD() {
        com.baidu.poly.a.a.c cVar = new com.baidu.poly.a.a.c();
        if (!TextUtils.isEmpty(coE)) {
            cVar.g(SM.COOKIE, "BDUSS=" + coE);
        }
        return cVar;
    }

    private static com.baidu.poly.a.a.b afE() {
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        bVar.g("dm", "cashier");
        bVar.g("os", HttpConstants.OS_TYPE_VALUE);
        bVar.g("v", "2.7.5");
        if (!TextUtils.isEmpty(coH)) {
            bVar.g("n", coH);
        }
        if (!TextUtils.isEmpty(coF)) {
            bVar.g("d", coF);
        }
        if (!TextUtils.isEmpty(pd)) {
            bVar.g("dt", pd);
        }
        if (!TextUtils.isEmpty(coG)) {
            bVar.g("dp", coG);
        }
        return bVar;
    }

    private static JSONArray afq() {
        JSONArray jSONArray;
        File file = new File(g.afL().getFilesDir(), "poly_cashier_statistics.json");
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
        List<com.baidu.poly.a.h.b> list = coI;
        if (list != null) {
            list.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void doFlush() {
        synchronized (d.class) {
            List<com.baidu.poly.a.h.b> list = coI;
            if (list != null && !list.isEmpty()) {
                com.baidu.poly.a.a.b afE = afE();
                synchronized (coJ) {
                    JSONArray jSONArray = new JSONArray();
                    for (com.baidu.poly.a.h.b bVar : coI) {
                        JSONObject afB = bVar.afB();
                        if (afB != null) {
                            jSONArray.put(afB);
                        }
                    }
                    afE.g("data", jSONArray.toString());
                    afE.g("s", HttpSigner.a(afE, "key", com.baidu.poly.a.b.a.q()));
                    clear();
                }
                com.baidu.poly.a.a.c afD = afD();
                if (f.J()) {
                    afC();
                    new com.baidu.poly.a.h.c().a(afD, afE, new b(afD, afE));
                } else {
                    b(afD.getMap(), afE.getMap());
                }
            }
        }
    }

    public static void flush() {
        com.baidu.poly.c.a.execute(new a());
    }

    private static void p(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            com.baidu.poly.util.c.a(jSONArray.toString(), new File(g.afL().getFilesDir(), "poly_cashier_statistics.json"));
        }
    }

    public static void a(com.baidu.poly.a.h.b bVar) {
        if (coI == null) {
            coI = new ArrayList();
        }
        if (bVar != null) {
            synchronized (coJ) {
                coI.add(bVar);
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
            bVar.jX(str);
            a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Map map, Map map2) {
        try {
            JSONArray afq = afq();
            if (afq != null) {
                if (afq.length() >= 20) {
                    afq.remove(0);
                }
            } else {
                afq = new JSONArray();
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject n = e.n(map);
            JSONObject n2 = e.n(map2);
            jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, n);
            jSONObject.put("body", n2);
            afq.put(jSONObject);
            p(afq);
        } catch (Exception e) {
        }
    }
}
