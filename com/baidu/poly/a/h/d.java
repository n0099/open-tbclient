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
/* loaded from: classes4.dex */
public class d {
    public static String cof;
    public static String cog;
    public static String coh;
    public static String coi;
    private static List<com.baidu.poly.a.h.b> coj;
    private static Object cok = new Object();
    public static String pd;

    /* loaded from: classes4.dex */
    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.doFlush();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class b extends com.baidu.poly.a.a.a {
        final /* synthetic */ com.baidu.poly.a.a.c cmV;
        final /* synthetic */ com.baidu.poly.a.a.b cmW;

        b(com.baidu.poly.a.a.c cVar, com.baidu.poly.a.a.b bVar) {
            this.cmV = cVar;
            this.cmW = bVar;
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Object obj) {
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            d.b(this.cmV.getMap(), this.cmW.getMap());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class c extends com.baidu.poly.a.a.a {
        final /* synthetic */ JSONArray cod;
        final /* synthetic */ JSONObject coe;

        c(JSONArray jSONArray, JSONObject jSONObject) {
            this.cod = jSONArray;
            this.coe = jSONObject;
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Object obj) {
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            this.cod.put(this.coe);
        }
    }

    public static void H() {
        cof = null;
        cog = null;
        pd = null;
        coh = null;
        coi = null;
    }

    private static com.baidu.poly.a.a.b adA() {
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        bVar.g("dm", "cashier");
        bVar.g("os", HttpConstants.OS_TYPE_VALUE);
        bVar.g("v", "2.7.5");
        if (!TextUtils.isEmpty(coi)) {
            bVar.g("n", coi);
        }
        if (!TextUtils.isEmpty(cog)) {
            bVar.g("d", cog);
        }
        if (!TextUtils.isEmpty(pd)) {
            bVar.g("dt", pd);
        }
        if (!TextUtils.isEmpty(coh)) {
            bVar.g("dp", coh);
        }
        return bVar;
    }

    private static JSONArray adm() {
        JSONArray jSONArray;
        File file = new File(g.adH().getFilesDir(), "poly_cashier_statistics.json");
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

    private static void ady() {
        JSONArray adm = adm();
        if (adm != null && adm.length() != 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < adm.length(); i++) {
                    JSONObject jSONObject = adm.getJSONObject(i);
                    com.baidu.poly.a.a.c cVar = new com.baidu.poly.a.a.c();
                    cVar.b(e.ax(jSONObject.optJSONObject(WebSocketRequest.PARAM_KEY_HEADER)));
                    com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
                    bVar.b(e.ax(jSONObject.optJSONObject("body")));
                    new com.baidu.poly.a.h.c().a(cVar, bVar, new c(jSONArray, jSONObject));
                }
                p(jSONArray);
            } catch (Exception e) {
            }
        }
    }

    private static com.baidu.poly.a.a.c adz() {
        com.baidu.poly.a.a.c cVar = new com.baidu.poly.a.a.c();
        if (!TextUtils.isEmpty(cof)) {
            cVar.g(SM.COOKIE, "BDUSS=" + cof);
        }
        return cVar;
    }

    private static void clear() {
        List<com.baidu.poly.a.h.b> list = coj;
        if (list != null) {
            list.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void doFlush() {
        synchronized (d.class) {
            List<com.baidu.poly.a.h.b> list = coj;
            if (list != null && !list.isEmpty()) {
                com.baidu.poly.a.a.b adA = adA();
                synchronized (cok) {
                    JSONArray jSONArray = new JSONArray();
                    for (com.baidu.poly.a.h.b bVar : coj) {
                        JSONObject adx = bVar.adx();
                        if (adx != null) {
                            jSONArray.put(adx);
                        }
                    }
                    adA.g("data", jSONArray.toString());
                    adA.g("s", HttpSigner.a(adA, "key", com.baidu.poly.a.b.a.q()));
                    clear();
                }
                com.baidu.poly.a.a.c adz = adz();
                if (f.J()) {
                    ady();
                    new com.baidu.poly.a.h.c().a(adz, adA, new b(adz, adA));
                } else {
                    b(adz.getMap(), adA.getMap());
                }
            }
        }
    }

    public static void flush() {
        com.baidu.poly.c.a.execute(new a());
    }

    private static void p(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            com.baidu.poly.util.c.a(jSONArray.toString(), new File(g.adH().getFilesDir(), "poly_cashier_statistics.json"));
        }
    }

    public static void a(com.baidu.poly.a.h.b bVar) {
        if (coj == null) {
            coj = new ArrayList();
        }
        if (bVar != null) {
            synchronized (cok) {
                coj.add(bVar);
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
            bVar.jr(str);
            a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Map map, Map map2) {
        try {
            JSONArray adm = adm();
            if (adm != null) {
                if (adm.length() >= 20) {
                    adm.remove(0);
                }
            } else {
                adm = new JSONArray();
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject n = e.n(map);
            JSONObject n2 = e.n(map2);
            jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, n);
            jSONObject.put("body", n2);
            adm.put(jSONObject);
            p(adm);
        } catch (Exception e) {
        }
    }
}
