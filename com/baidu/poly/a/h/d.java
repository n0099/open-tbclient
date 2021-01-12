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
    public static String cjP;
    public static String cjQ;
    public static String cjR;
    public static String cjS;
    private static List<com.baidu.poly.a.h.b> cjT;
    private static Object cjU = new Object();
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
        final /* synthetic */ com.baidu.poly.a.a.c ciG;
        final /* synthetic */ com.baidu.poly.a.a.b ciH;

        b(com.baidu.poly.a.a.c cVar, com.baidu.poly.a.a.b bVar) {
            this.ciG = cVar;
            this.ciH = bVar;
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Object obj) {
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            d.b(this.ciG.getMap(), this.ciH.getMap());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class c extends com.baidu.poly.a.a.a {
        final /* synthetic */ JSONArray cjN;
        final /* synthetic */ JSONObject cjO;

        c(JSONArray jSONArray, JSONObject jSONObject) {
            this.cjN = jSONArray;
            this.cjO = jSONObject;
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Object obj) {
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            this.cjN.put(this.cjO);
        }
    }

    public static void H() {
        cjP = null;
        cjQ = null;
        pd = null;
        cjR = null;
        cjS = null;
    }

    private static void abK() {
        JSONArray aby = aby();
        if (aby != null && aby.length() != 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < aby.length(); i++) {
                    JSONObject jSONObject = aby.getJSONObject(i);
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

    private static com.baidu.poly.a.a.c abL() {
        com.baidu.poly.a.a.c cVar = new com.baidu.poly.a.a.c();
        if (!TextUtils.isEmpty(cjP)) {
            cVar.g(SM.COOKIE, "BDUSS=" + cjP);
        }
        return cVar;
    }

    private static com.baidu.poly.a.a.b abM() {
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        bVar.g("dm", "cashier");
        bVar.g("os", HttpConstants.OS_TYPE_VALUE);
        bVar.g("v", "2.7.5");
        if (!TextUtils.isEmpty(cjS)) {
            bVar.g("n", cjS);
        }
        if (!TextUtils.isEmpty(cjQ)) {
            bVar.g("d", cjQ);
        }
        if (!TextUtils.isEmpty(pd)) {
            bVar.g("dt", pd);
        }
        if (!TextUtils.isEmpty(cjR)) {
            bVar.g("dp", cjR);
        }
        return bVar;
    }

    private static JSONArray aby() {
        JSONArray jSONArray;
        File file = new File(g.abT().getFilesDir(), "poly_cashier_statistics.json");
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
        List<com.baidu.poly.a.h.b> list = cjT;
        if (list != null) {
            list.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void doFlush() {
        synchronized (d.class) {
            List<com.baidu.poly.a.h.b> list = cjT;
            if (list != null && !list.isEmpty()) {
                com.baidu.poly.a.a.b abM = abM();
                synchronized (cjU) {
                    JSONArray jSONArray = new JSONArray();
                    for (com.baidu.poly.a.h.b bVar : cjT) {
                        JSONObject abJ = bVar.abJ();
                        if (abJ != null) {
                            jSONArray.put(abJ);
                        }
                    }
                    abM.g("data", jSONArray.toString());
                    abM.g("s", HttpSigner.a(abM, "key", com.baidu.poly.a.b.a.q()));
                    clear();
                }
                com.baidu.poly.a.a.c abL = abL();
                if (f.J()) {
                    abK();
                    new com.baidu.poly.a.h.c().a(abL, abM, new b(abL, abM));
                } else {
                    b(abL.getMap(), abM.getMap());
                }
            }
        }
    }

    public static void flush() {
        com.baidu.poly.c.a.execute(new a());
    }

    private static void p(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            com.baidu.poly.util.c.a(jSONArray.toString(), new File(g.abT().getFilesDir(), "poly_cashier_statistics.json"));
        }
    }

    public static void a(com.baidu.poly.a.h.b bVar) {
        if (cjT == null) {
            cjT = new ArrayList();
        }
        if (bVar != null) {
            synchronized (cjU) {
                cjT.add(bVar);
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
            bVar.iM(str);
            a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Map map, Map map2) {
        try {
            JSONArray aby = aby();
            if (aby != null) {
                if (aby.length() >= 20) {
                    aby.remove(0);
                }
            } else {
                aby = new JSONArray();
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject n = e.n(map);
            JSONObject n2 = e.n(map2);
            jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, n);
            jSONObject.put("body", n2);
            aby.put(jSONObject);
            p(aby);
        } catch (Exception e) {
        }
    }
}
