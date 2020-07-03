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
    private static List<com.baidu.poly.a.g.b> bAa;
    private static Object bAb = new Object();
    public static String bzV;
    public static String bzW;
    public static String bzX;
    public static String bzY;
    public static String bzZ;

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
        final /* synthetic */ com.baidu.poly.a.a.c byO;
        final /* synthetic */ com.baidu.poly.a.a.b byP;

        b(com.baidu.poly.a.a.c cVar, com.baidu.poly.a.a.b bVar) {
            this.byO = cVar;
            this.byP = bVar;
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Object obj) {
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            d.b(this.byO.getMap(), this.byP.getMap());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class c extends com.baidu.poly.a.a.a {
        final /* synthetic */ JSONArray bzT;
        final /* synthetic */ JSONObject bzU;

        c(JSONArray jSONArray, JSONObject jSONObject) {
            this.bzT = jSONArray;
            this.bzU = jSONObject;
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Object obj) {
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            this.bzT.put(this.bzU);
        }
    }

    private static void Oh() {
        JSONArray Ok = Ok();
        if (Ok != null && Ok.length() != 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < Ok.length(); i++) {
                    JSONObject jSONObject = Ok.getJSONObject(i);
                    com.baidu.poly.a.a.c cVar = new com.baidu.poly.a.a.c();
                    cVar.b(e.aa(jSONObject.optJSONObject(WebSocketRequest.PARAM_KEY_HEADER)));
                    com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
                    bVar.b(e.aa(jSONObject.optJSONObject("body")));
                    new com.baidu.poly.a.g.c().a(cVar, bVar, new c(jSONArray, jSONObject));
                }
                a(jSONArray);
            } catch (Exception e) {
            }
        }
    }

    private static com.baidu.poly.a.a.c Oi() {
        com.baidu.poly.a.a.c cVar = new com.baidu.poly.a.a.c();
        if (!TextUtils.isEmpty(bzV)) {
            cVar.g(SM.COOKIE, "BDUSS=" + bzV);
        }
        return cVar;
    }

    private static com.baidu.poly.a.a.b Oj() {
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        bVar.g("dm", "cashier");
        bVar.g("os", "android");
        bVar.g("v", "2.6.3");
        bVar.g("id", UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        if (!TextUtils.isEmpty(bzZ)) {
            bVar.g("n", bzZ);
        }
        if (!TextUtils.isEmpty(bzW)) {
            bVar.g("d", bzW);
        }
        if (!TextUtils.isEmpty(bzX)) {
            bVar.g(SuspensionBallUbc.VALUE_DT, bzX);
        }
        if (!TextUtils.isEmpty(bzY)) {
            bVar.g("dp", bzY);
        }
        return bVar;
    }

    private static JSONArray Ok() {
        JSONArray jSONArray;
        File file = new File(g.Os().getFilesDir(), "poly_cashier_statistics.json");
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
        List<com.baidu.poly.a.g.b> list = bAa;
        if (list != null) {
            list.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void doFlush() {
        synchronized (d.class) {
            List<com.baidu.poly.a.g.b> list = bAa;
            if (list != null && !list.isEmpty()) {
                com.baidu.poly.a.a.b Oj = Oj();
                synchronized (bAb) {
                    JSONArray jSONArray = new JSONArray();
                    for (com.baidu.poly.a.g.b bVar : bAa) {
                        JSONObject Og = bVar.Og();
                        if (Og != null) {
                            jSONArray.put(Og);
                        }
                    }
                    Oj.g("data", jSONArray.toString());
                    clear();
                }
                com.baidu.poly.a.a.c Oi = Oi();
                if (f.A()) {
                    Oh();
                    new com.baidu.poly.a.g.c().a(Oi, Oj, new b(Oi, Oj));
                } else {
                    b(Oi.getMap(), Oj.getMap());
                }
            }
        }
    }

    public static void flush() {
        com.baidu.poly.b.a.execute(new a());
    }

    public static void y() {
        bzV = null;
        bzW = null;
        bzX = null;
        bzY = null;
        bzZ = null;
    }

    public static void a(com.baidu.poly.a.g.b bVar) {
        if (bAa == null) {
            bAa = new ArrayList();
        }
        if (bVar != null) {
            synchronized (bAb) {
                bAa.add(bVar);
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
            bVar.gF(str);
            a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Map map, Map map2) {
        try {
            JSONArray Ok = Ok();
            if (Ok != null) {
                if (Ok.length() >= 20) {
                    Ok.remove(0);
                }
            } else {
                Ok = new JSONArray();
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject k = e.k(map);
            JSONObject k2 = e.k(map2);
            jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, k);
            jSONObject.put("body", k2);
            Ok.put(jSONObject);
            a(Ok);
        } catch (Exception e) {
        }
    }

    private static void a(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            com.baidu.poly.util.c.a(jSONArray.toString(), new File(g.Os().getFilesDir(), "poly_cashier_statistics.json"));
        }
    }
}
