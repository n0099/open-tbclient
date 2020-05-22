package com.baidu.poly.a.g;

import android.text.TextUtils;
import com.baidu.poly.util.e;
import com.baidu.poly.util.f;
import com.baidu.poly.util.g;
import com.baidu.searchbox.suspensionball.SuspensionBallUbc;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.http.cookie.SM;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    public static String bve;
    public static String bvf;
    public static String bvg;
    public static String bvh;
    public static String bvi;
    private static List<com.baidu.poly.a.g.b> bvj;
    private static Object bvk = new Object();

    /* loaded from: classes11.dex */
    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.doFlush();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class b extends com.baidu.poly.a.a.a {
        final /* synthetic */ com.baidu.poly.a.a.c btV;
        final /* synthetic */ com.baidu.poly.a.a.b btW;

        b(com.baidu.poly.a.a.c cVar, com.baidu.poly.a.a.b bVar) {
            this.btV = cVar;
            this.btW = bVar;
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Object obj) {
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            d.b(this.btV.getMap(), this.btW.getMap());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class c extends com.baidu.poly.a.a.a {
        final /* synthetic */ JSONArray bvc;
        final /* synthetic */ JSONObject bvd;

        c(JSONArray jSONArray, JSONObject jSONObject) {
            this.bvc = jSONArray;
            this.bvd = jSONObject;
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Object obj) {
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            this.bvc.put(this.bvd);
        }
    }

    private static void MY() {
        JSONArray Nb = Nb();
        if (Nb != null && Nb.length() != 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < Nb.length(); i++) {
                    JSONObject jSONObject = Nb.getJSONObject(i);
                    com.baidu.poly.a.a.c cVar = new com.baidu.poly.a.a.c();
                    cVar.b(e.T(jSONObject.optJSONObject(WebSocketRequest.PARAM_KEY_HEADER)));
                    com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
                    bVar.b(e.T(jSONObject.optJSONObject("body")));
                    new com.baidu.poly.a.g.c().a(cVar, bVar, new c(jSONArray, jSONObject));
                }
                a(jSONArray);
            } catch (Exception e) {
            }
        }
    }

    private static com.baidu.poly.a.a.c MZ() {
        com.baidu.poly.a.a.c cVar = new com.baidu.poly.a.a.c();
        if (!TextUtils.isEmpty(bve)) {
            cVar.g(SM.COOKIE, "BDUSS=" + bve);
        }
        return cVar;
    }

    private static com.baidu.poly.a.a.b Na() {
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        bVar.g("dm", "cashier");
        bVar.g("os", "android");
        bVar.g("v", "2.6.3");
        bVar.g("id", UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        if (!TextUtils.isEmpty(bvi)) {
            bVar.g("n", bvi);
        }
        if (!TextUtils.isEmpty(bvf)) {
            bVar.g("d", bvf);
        }
        if (!TextUtils.isEmpty(bvg)) {
            bVar.g(SuspensionBallUbc.VALUE_DT, bvg);
        }
        if (!TextUtils.isEmpty(bvh)) {
            bVar.g("dp", bvh);
        }
        return bVar;
    }

    private static JSONArray Nb() {
        JSONArray jSONArray;
        File file = new File(g.Nj().getFilesDir(), "poly_cashier_statistics.json");
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

    private static void clear() {
        List<com.baidu.poly.a.g.b> list = bvj;
        if (list != null) {
            list.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void doFlush() {
        synchronized (d.class) {
            List<com.baidu.poly.a.g.b> list = bvj;
            if (list != null && !list.isEmpty()) {
                com.baidu.poly.a.a.b Na = Na();
                synchronized (bvk) {
                    JSONArray jSONArray = new JSONArray();
                    for (com.baidu.poly.a.g.b bVar : bvj) {
                        JSONObject MX = bVar.MX();
                        if (MX != null) {
                            jSONArray.put(MX);
                        }
                    }
                    Na.g("data", jSONArray.toString());
                    clear();
                }
                com.baidu.poly.a.a.c MZ = MZ();
                if (f.A()) {
                    MY();
                    new com.baidu.poly.a.g.c().a(MZ, Na, new b(MZ, Na));
                } else {
                    b(MZ.getMap(), Na.getMap());
                }
            }
        }
    }

    public static void flush() {
        com.baidu.poly.b.a.execute(new a());
    }

    public static void y() {
        bve = null;
        bvf = null;
        bvg = null;
        bvh = null;
        bvi = null;
    }

    public static void a(com.baidu.poly.a.g.b bVar) {
        if (bvj == null) {
            bvj = new ArrayList();
        }
        if (bVar != null) {
            synchronized (bvk) {
                bvj.add(bVar);
            }
        }
    }

    public static void b(int i, String str) {
        com.baidu.poly.a.g.b bVar = null;
        if (i == 0) {
            bVar = new com.baidu.poly.a.g.b("2");
        } else if (i == 2) {
            bVar = new com.baidu.poly.a.g.b("4");
        } else if (i == 3) {
            bVar = new com.baidu.poly.a.g.b("3");
        }
        if (bVar != null) {
            bVar.gx(str);
            a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Map map, Map map2) {
        try {
            JSONArray Nb = Nb();
            if (Nb != null) {
                if (Nb.length() >= 20) {
                    Nb.remove(0);
                }
            } else {
                Nb = new JSONArray();
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject k = e.k(map);
            JSONObject k2 = e.k(map2);
            jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, k);
            jSONObject.put("body", k2);
            Nb.put(jSONObject);
            a(Nb);
        } catch (Exception e) {
        }
    }

    private static void a(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            com.baidu.poly.util.c.a(jSONArray.toString(), new File(g.Nj().getFilesDir(), "poly_cashier_statistics.json"));
        }
    }
}
