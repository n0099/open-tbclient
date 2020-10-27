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
    public static String bWZ;
    public static String bXa;
    public static String bXb;
    public static String bXc;
    private static List<com.baidu.poly.a.h.b> bXd;
    private static Object bXe = new Object();
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
        final /* synthetic */ com.baidu.poly.a.a.c bVS;
        final /* synthetic */ com.baidu.poly.a.a.b bVT;

        b(com.baidu.poly.a.a.c cVar, com.baidu.poly.a.a.b bVar) {
            this.bVS = cVar;
            this.bVT = bVar;
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Object obj) {
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            d.b(this.bVS.getMap(), this.bVT.getMap());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class c extends com.baidu.poly.a.a.a {
        final /* synthetic */ JSONArray bWX;
        final /* synthetic */ JSONObject bWY;

        c(JSONArray jSONArray, JSONObject jSONObject) {
            this.bWX = jSONArray;
            this.bWY = jSONObject;
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Object obj) {
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            this.bWX.put(this.bWY);
        }
    }

    public static void H() {
        nd = null;
        bWZ = null;
        bXa = null;
        bXb = null;
        bXc = null;
    }

    private static void YJ() {
        JSONArray Yw = Yw();
        if (Yw != null && Yw.length() != 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < Yw.length(); i++) {
                    JSONObject jSONObject = Yw.getJSONObject(i);
                    com.baidu.poly.a.a.c cVar = new com.baidu.poly.a.a.c();
                    cVar.b(e.al(jSONObject.optJSONObject(WebSocketRequest.PARAM_KEY_HEADER)));
                    com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
                    bVar.b(e.al(jSONObject.optJSONObject("body")));
                    new com.baidu.poly.a.h.c().a(cVar, bVar, new c(jSONArray, jSONObject));
                }
                o(jSONArray);
            } catch (Exception e) {
            }
        }
    }

    private static com.baidu.poly.a.a.c YK() {
        com.baidu.poly.a.a.c cVar = new com.baidu.poly.a.a.c();
        if (!TextUtils.isEmpty(nd)) {
            cVar.g(SM.COOKIE, "BDUSS=" + nd);
        }
        return cVar;
    }

    private static com.baidu.poly.a.a.b YL() {
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        bVar.g("dm", "cashier");
        bVar.g("os", "android");
        bVar.g("v", "2.7.5");
        if (!TextUtils.isEmpty(bXc)) {
            bVar.g("n", bXc);
        }
        if (!TextUtils.isEmpty(bWZ)) {
            bVar.g("d", bWZ);
        }
        if (!TextUtils.isEmpty(bXa)) {
            bVar.g("dt", bXa);
        }
        if (!TextUtils.isEmpty(bXb)) {
            bVar.g("dp", bXb);
        }
        return bVar;
    }

    private static JSONArray Yw() {
        JSONArray jSONArray;
        File file = new File(g.YS().getFilesDir(), "poly_cashier_statistics.json");
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

    private static void clear() {
        List<com.baidu.poly.a.h.b> list = bXd;
        if (list != null) {
            list.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void doFlush() {
        synchronized (d.class) {
            List<com.baidu.poly.a.h.b> list = bXd;
            if (list != null && !list.isEmpty()) {
                com.baidu.poly.a.a.b YL = YL();
                synchronized (bXe) {
                    JSONArray jSONArray = new JSONArray();
                    for (com.baidu.poly.a.h.b bVar : bXd) {
                        JSONObject YI = bVar.YI();
                        if (YI != null) {
                            jSONArray.put(YI);
                        }
                    }
                    YL.g("data", jSONArray.toString());
                    YL.g("s", HttpSigner.a(YL, "key", com.baidu.poly.a.b.a.q()));
                    clear();
                }
                com.baidu.poly.a.a.c YK = YK();
                if (f.J()) {
                    YJ();
                    new com.baidu.poly.a.h.c().a(YK, YL, new b(YK, YL));
                } else {
                    b(YK.getMap(), YL.getMap());
                }
            }
        }
    }

    public static void flush() {
        com.baidu.poly.c.a.execute(new a());
    }

    private static void o(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            com.baidu.poly.util.c.a(jSONArray.toString(), new File(g.YS().getFilesDir(), "poly_cashier_statistics.json"));
        }
    }

    public static void a(com.baidu.poly.a.h.b bVar) {
        if (bXd == null) {
            bXd = new ArrayList();
        }
        if (bVar != null) {
            synchronized (bXe) {
                bXd.add(bVar);
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
            bVar.jn(str);
            a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Map map, Map map2) {
        try {
            JSONArray Yw = Yw();
            if (Yw != null) {
                if (Yw.length() >= 20) {
                    Yw.remove(0);
                }
            } else {
                Yw = new JSONArray();
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject m = e.m(map);
            JSONObject m2 = e.m(map2);
            jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, m);
            jSONObject.put("body", m2);
            Yw.put(jSONObject);
            o(Yw);
        } catch (Exception e) {
        }
    }
}
